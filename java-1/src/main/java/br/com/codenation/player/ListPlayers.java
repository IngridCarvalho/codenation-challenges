package br.com.codenation.player;

import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class ListPlayers {

    private List<Player> players = new ArrayList<>();

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Player getPlayerById(Long idPlayer) {
        if(idPlayer == null) {
            throw new NullPointerException("O id não pode ser nulo");
        }

        return players.stream()
                        .filter(player -> player.getId().equals(idPlayer))
                        .findAny().orElse(null);
    }


    public void setCaptain(Long idPlayer) {
        Optional<Long> idTime = players.stream()
                .filter(player -> player.getId().equals(idPlayer))
                .map(Player::getIdTeam).findAny();

        players.stream()
                .filter(player -> player.getIdTeam().equals(idTime.get()))
                .forEach(player -> {
                    if(player.isCaptain() && player.getId() != idPlayer) {
                        player.setCaptain(false);
                    } else if(player.getId().equals(idPlayer)) {
                        player.setCaptain(true);
                    }
                });
    }

    public Long getTeamCaptain(Long idTeam) {
        return players.stream()
                    .filter(player -> player.isCaptain() && player.getIdTeam().equals(idTeam))
                    .map(Player::getId)
                    .findAny()
                    .orElseThrow(CapitaoNaoInformadoException::new);
    }

    public String getPlayerName(Long idPlayer) {
        return players.stream()
                    .filter(player -> player.getId().equals(idPlayer))
                    .map(Player::getName)
                    .findAny().get();
    }

    public List getTeamsPlayers(Long idTeam) {
        return players.stream()
                    .filter(player -> player.getIdTeam().equals(idTeam))
                    .map(Player::getId)
                    .sorted()
                    .collect(Collectors.toList());
    }

    public Long getIdBestPlayerTeam(Long idTeam) {
        return players.stream()
                    .filter(player -> player.getIdTeam().equals(idTeam))
                    .max(Comparator.comparingInt(Player::getSkillLevel))
                    .get().getId();
    }

    public Long getOlderPlayerTeam(Long idTeam) {
        Long idPlayer = -1L;
        LocalDate data = LocalDate.MAX;

        for (Player player : players) {
            if(player.getIdTeam().equals(idTeam)) {
                if(player.getBirthDate().equals(data) && idPlayer > player.getId()) {
                    data = player.getBirthDate();
                    idPlayer = player.getId();
                } else if(player.getBirthDate().isBefore(data)) {
                    data = player.getBirthDate();
                    idPlayer = player.getId();
                }
            }
        }

        return idPlayer;
    }

    public Long getPlayerWithHigherSalary(Long idTeam) {
        return players.stream()
                    .filter(player -> player.getIdTeam().equals(idTeam))
                    .sorted(Comparator.comparing(Player::getSalary).reversed()
                            .thenComparing(Player::getId))
                    .findFirst().get().getId();
    }

    public BigDecimal getSalaryPlayer(Long idPlayer) {
        return players.stream()
                    .filter(player -> player.getId().equals(idPlayer))
                    .findAny().get().getSalary();
    }

    public List getTopPlayers(Integer top) {
        List<Player> topPlayers = players;

        Comparator<Player> comparator = Comparator.comparing(Player::getSkillLevel).reversed()
                .thenComparing(Player::getId);

        Collections.sort(topPlayers, comparator);

        return topPlayers.stream()
                        .map(player -> player.getId())
                        .limit(top)
                        .collect(Collectors.toList());
    }
}
