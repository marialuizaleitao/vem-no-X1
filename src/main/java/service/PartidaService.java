package service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import model.dto.JogadaDTO;
import model.dto.PartidaDTO;
import model.entity.Carta;
import model.entity.CartaNaPartida;
import model.entity.Partida;
import model.entity.enums.Resultado;
import model.repository.CartaPartidaRepository;
import model.repository.CartaRepository;
import model.repository.JogadorRepository;
import model.repository.PartidaRepository;

public class PartidaService {

	private JogadorRepository jogadorRepository = new JogadorRepository();
	private PartidaRepository partidaRepository = new PartidaRepository();
	private CartaRepository cartaRepository = new CartaRepository();
	private CartaPartidaRepository cartaPartidaRepository = new CartaPartidaRepository();

	public PartidaDTO iniciarPartida(int idJogador) {
		PartidaDTO dto = new PartidaDTO();

		// Criar uma partida -> inserir Partida [PartidaRepository]
		Partida novaPartida = new Partida();
		novaPartida.setResultado(Resultado.EM_ANDAMENTO);
		novaPartida.setData(LocalDateTime.now());
		novaPartida.setJogador(jogadorRepository.consultarPorId(idJogador));
		novaPartida = partidaRepository.salvar(novaPartida);

		ArrayList<String> atributos = new ArrayList<String>();
		atributos.add("Força");
		atributos.add("Inteligência");
		atributos.add("Velocidade");

		// Sortear as 6 cartas -> sortearCartas [CartaRepository]
		ArrayList<Carta> seisCartas = cartaRepository.sortearSeisCartas();
		ArrayList<CartaNaPartida> cartasDoJogador = new ArrayList<CartaNaPartida>();

		// Distribuir para jogador e CPU -> inserir CartaPartida
		boolean ehDoJogador = true;
		for (Carta carta : seisCartas) {
			CartaNaPartida cartaDaPartida = new CartaNaPartida();
			cartaDaPartida.setIdPartida(novaPartida.getId());
			cartaDaPartida.setCarta(carta);
			cartaDaPartida.setPertenceAoJogador(ehDoJogador);
			cartaDaPartida = cartaPartidaRepository.salvar(cartaDaPartida);

			if (ehDoJogador) {
				cartasDoJogador.add(cartaDaPartida);
			}

			// ! Usado para intercalar a distribuição de cartas entre jogador e CPU
			ehDoJogador = !ehDoJogador;
		}

		// Montar o PartidaDTO e retornar
		dto.setIdPartida(novaPartida.getId());
		dto.setResultadoUltimaJogada(null);
		dto.setAtributosDisponiveis(atributos);
		dto.setCartasJogador(cartasDoJogador);
		return dto;
	}

	public PartidaDTO jogar(JogadaDTO jogada) {
		PartidaDTO partidaAtualizada = new PartidaDTO();
		Partida partida = partidaRepository.consultarPorId(jogada.getIdPartida());
		CartaNaPartida cartaJogada = cartaPartidaRepository.consultarPorId(jogada.getIdCartaNaPartidaSelecionada());

		if (jogada.getAtributoSelecionado().equals("Força")) {
			int valorForcaCartaJogada = cartaJogada.getCarta().getForca();

			// Recupera as cartas da CPU
			ArrayList<CartaNaPartida> cartasCpu = cartaPartidaRepository
					.consultarPorPartidaETipoJogador(partida.getId(), false);

			// Encontra a carta de maior valor de Força da CPU
			int maiorForcaCpu = Integer.MIN_VALUE;
			for (CartaNaPartida cartaCpu : cartasCpu) {
				int forcaCpu = cartaCpu.getCarta().getForca();
				if (forcaCpu > maiorForcaCpu) {
					maiorForcaCpu = forcaCpu;
				}
			}

			// Verifica quem venceu o round
			if (valorForcaCartaJogada > maiorForcaCpu) {
				partida.setRoundsVencidosJogador(partida.getRoundsVencidosJogador() + 1);
			} else if (valorForcaCartaJogada < maiorForcaCpu) {
				partida.setRoundsVencidosCpu(partida.getRoundsVencidosCpu() + 1);
			} else {
				partida.setRoundsEmpatados(partida.getRoundsEmpatados() + 1);
			}

			// Verifica se a partida terminou
			if (partida.getRoundsVencidosJogador() == 3 || partida.getRoundsVencidosCpu() == 3) {
				// Define o resultado da partida
				if (partida.getRoundsVencidosJogador() > partida.getRoundsVencidosCpu()) {
					partida.setResultado(Resultado.VITORIA_JOGADOR);
				} else if (partida.getRoundsVencidosJogador() < partida.getRoundsVencidosCpu()) {
					partida.setResultado(Resultado.VITORIA_CPU);
				} else {
					partida.setResultado(Resultado.EMPATE);
				}
			}

			// Atualiza a partida no banco de dados
			partidaRepository.alterar(partida);
		}

		// Atualiza o DTO da partida
		partidaAtualizada.setIdPartida(partida.getId());
		partidaAtualizada.setResultadoUltimaJogada(partida.getResultado());
		partidaAtualizada.setAtributosDisponiveis(Arrays.asList("Força", "Inteligência", "Velocidade"));
		partidaAtualizada
				.setCartasJogador(cartaPartidaRepository.consultarPorPartidaETipoJogador(partida.getId(), true));

		return partidaAtualizada;
	}

}