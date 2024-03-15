package model.dto;

import java.util.List;

import model.entity.CartaNaPartida;
import model.entity.enums.Resultado;

public class PartidaDTO {

	private int idPartida;
	private List<CartaNaPartida> cartasJogador;
	private List<String> atributosDisponiveis;
	private Resultado resultadoUltimaJogada;

	public PartidaDTO() {

	}

	public PartidaDTO(int idPartida, List<CartaNaPartida> cartaJogador, List<String> atributosDisponiveis,
			Resultado resultadoUltimaJogada) {
		super();
		this.idPartida = idPartida;
		this.cartasJogador = cartaJogador;
		this.atributosDisponiveis = atributosDisponiveis;
		this.resultadoUltimaJogada = resultadoUltimaJogada;
	}

	public int getIdPartida() {
		return idPartida;
	}

	public void setIdPartida(int idPartida) {
		this.idPartida = idPartida;
	}

	public List<CartaNaPartida> getCartasJogador() {
		return cartasJogador;
	}

	public void setCartasJogador(List<CartaNaPartida> cartasJogador) {
		this.cartasJogador = cartasJogador;
	}

	public List<String> getAtributosDisponiveis() {
		return atributosDisponiveis;
	}

	public void setAtributosDisponiveis(List<String> atributosDisponiveis) {
		this.atributosDisponiveis = atributosDisponiveis;
	}

	public Resultado getResultadoUltimaJogada() {
		return resultadoUltimaJogada;
	}

	public void setResultadoUltimaJogada(Resultado resultado) {
		this.resultadoUltimaJogada = resultado;
	}
}
