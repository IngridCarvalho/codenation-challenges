package br.com.codenation;

import br.com.codenation.desafio.annotation.Desafio;
import br.com.codenation.desafio.app.MeuTimeInterface;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;
import br.com.codenation.player.ListPlayers;
import br.com.codenation.player.Player;
import br.com.codenation.team.ListTeams;
import br.com.codenation.team.Team;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

	private ListTeams teams = new ListTeams();
	private ListPlayers players = new ListPlayers();

	@Desafio("incluirTime")
	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		checkId(id, "team");
		teams.addTeam(new Team(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario));
	}

	@Desafio("incluirJogador")
	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		checkId(id, "player");
		checkIdTeam(idTime);
		if(nivelHabilidade < 0 || nivelHabilidade > 100){
			throw new IllegalArgumentException("Nivel de habilidade incorreto, deve estar entre 0 e 100");
		}
		players.addPlayer(new Player(id, idTime, nome, dataNascimento, nivelHabilidade, salario));
	}

	@Desafio("definirCapitao")
	public void definirCapitao(Long idJogador) {
		checkPlayer(idJogador);

		players.setCaptain(idJogador);
	}

	@Desafio("buscarCapitaoDoTime")
	public Long buscarCapitaoDoTime(Long idTime) {
		checkIdTeam(idTime);

		return players.getTeamCaptain(idTime);
	}

	@Desafio("buscarNomeJogador")
	public String buscarNomeJogador(Long idJogador) {
		checkPlayer(idJogador);

		return players.getPlayerName(idJogador);
	}

	@Desafio("buscarNomeTime")
	public String buscarNomeTime(Long idTime) {
		checkIdTeam(idTime);

		return teams.getTeamName(idTime);
	}

	@Desafio("buscarJogadoresDoTime")
	public List<Long> buscarJogadoresDoTime(Long idTime) {
		checkIdTeam(idTime);

		return players.getTeamsPlayers(idTime);
	}

	@Desafio("buscarMelhorJogadorDoTime")
	public Long buscarMelhorJogadorDoTime(Long idTime) {
		checkIdTeam(idTime);

		return players.getIdBestPlayerTeam(idTime);
	}

	@Desafio("buscarJogadorMaisVelho")
	public Long buscarJogadorMaisVelho(Long idTime) {
		checkIdTeam(idTime);

		return players.getOlderPlayerTeam(idTime);
	}

	@Desafio("buscarTimes")
	public List<Long> buscarTimes() {
		return teams.getTeamsId();
	}

	@Desafio("buscarJogadorMaiorSalario")
	public Long buscarJogadorMaiorSalario(Long idTime) {
		checkIdTeam(idTime);

		return players.getPlayerWithHigherSalary(idTime);
	}

	@Desafio("buscarSalarioDoJogador")
	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		checkPlayer(idJogador);

		return players.getSalaryPlayer(idJogador);
	}

	@Desafio("buscarTopJogadores")
	public List<Long> buscarTopJogadores(Integer top) {
		if (players.getPlayers().isEmpty()) return new ArrayList<>();

		if(top <= 0 || players.getPlayers().size() < top) {
			throw new IllegalArgumentException("Quantidade top de jogaadores não pode ser menor ou igual a 0");
		}

		return players.getTopPlayers(top);
	}

	@Desafio("buscarCorCamisaTimeDeFora")
	public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {
		checkIdTeam(timeDaCasa);
		checkIdTeam(timeDeFora);

		return teams.getColorShirt(timeDaCasa, timeDeFora);
	}

	private void checkId(Long id, String option) {
		boolean hasId = false;

		if(option == "team") {
			hasId = teams.getTeams().stream()
									.anyMatch(team -> team.getId().equals(id));
		} else {
			hasId = players.getPlayers().stream()
										.anyMatch(player -> player.getId().equals(id));
		}

		if(hasId) {
			throw new IdentificadorUtilizadoException();
		}
	}

	private void checkIdTeam(Long idTime) {
		if(teams.getTeamById(idTime) == null) {
			throw new TimeNaoEncontradoException();
		}
	}

	private void checkPlayer(Long idJogador) {
		if(players.getPlayerById(idJogador) == null) {
			throw new JogadorNaoEncontradoException();
		}
	}

}
