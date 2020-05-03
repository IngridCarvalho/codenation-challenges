package br.com.codenation.team;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ListTeams {

    private List<Team> teams = new ArrayList<>();

    public List<Team> getTeams() {
        return teams;
    }

    public void addTeam(Team team) {
        teams.add(team);
    }

    public String getTeamName(Long idTeam) {
            return teams.stream()
                        .filter(team -> team.getId().equals(idTeam))
                        .map(Team::getName)
                        .findAny().get();
    }

    public Team getTeamById(Long idTeam) {
        if(idTeam == null) {
            throw new NullPointerException("O id não pode ser nulo");
        }
        return teams.stream()
                    .filter(team -> team.getId().equals(idTeam))
                    .findAny().orElse(null);
    }

    public List getTeamsId() {
        return teams.stream()
                    .map(team -> team.getId())
                    .sorted()
                    .collect(Collectors.toList());
    }

    public String getColorShirt(Long idTeam, Long idOutsideTeam) {
        Optional<Team> houseTeam = teams.stream()
                                        .filter(team -> team.getId().equals(idTeam))
                                        .findAny();

        Optional<Team> outsideTeam = teams.stream()
                                        .filter(team -> team.getId().equals(idOutsideTeam))
                                        .findAny();

        String colorOutsideTeam;

        if (houseTeam.get().getMainUniformColor().equals(outsideTeam.get().getMainUniformColor())) {
            colorOutsideTeam = outsideTeam.get().getSecondaryUniformColor();
        } else {
            colorOutsideTeam = outsideTeam.get().getMainUniformColor();
        }

        return colorOutsideTeam;
    }



}
