package exercicios_banco_imobiliario.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import exercicios_banco_imobiliario.enums.Peao;
import exercicios_banco_imobiliario.exceptions.CorDePeaoRepetidaException;
import exercicios_banco_imobiliario.exceptions.CorInexistenteExpcetion;
import exercicios_banco_imobiliario.exceptions.NumeroJogadoresExcedenteException;
import exercicios_banco_imobiliario.exceptions.NumeroJogadoresInsuficienteException;

/**
 * Classe para objeto do tipo jogo, onde estão contidos, valores e métodos para
 * o mesmo.
 * 
 * @author Carlos Eduardo, Alefe e Aisllan
 */

public class Jogo {

	private int numeroDeJogadores;
	private Tabuleiro tabuleiro = new Tabuleiro();
	private List<Jogador> jogadores = new ArrayList<Jogador>();
	private List<Carta> cartas = tabuleiro.getCartas();
	private Stack<Carta> cartasSorteReves = tabuleiro.getCartasSorteReves();
	private List<Peao> coresExistentes = Arrays.asList(Peao.values());
	private List<Peao> coresIndisponiveis = new ArrayList<>();
	private List<Integer> indicesEspeciais = Arrays.asList(0, 10, 18, 20, 24, 30);
	private List<Integer> indicesSorteReves = Arrays.asList(2, 12, 16, 22, 27, 37);
	private List<Integer> titulosVendidos = new ArrayList<>();
	
	Scanner scan = new Scanner(System.in);

	/**
	 * Método encarregado de criar um novo jogo, cadastrando de 2 a 8 jogagdores. E
	 * que laçará uma Exception caso o número de jogadores for menor que 2 ou maior
	 * que 8.
	 * 
	 * @param num - Número de jogadores
	 * @throws NumeroJogadoresInsuficienteException Número de jogadores insuficiente
	 * @throws NumeroJogadoresExcedenteException    Número de jogadores excedeu
	 *                                              limite
	 */

	public void criaJogadores(int num) throws NumeroJogadoresInsuficienteException, NumeroJogadoresExcedenteException {

		if (num < 2)
			throw new NumeroJogadoresInsuficienteException(
					"Número de jogadores insuficiente. O jogo deve ter de 2 a 8 jogadores!");
		else if (num > 8)
			throw new NumeroJogadoresExcedenteException(
					"Número de jogadores excedente. O jogo deve ter de 2 a 8 jogadores!");
		else {
			this.numeroDeJogadores = num;
		}
	}

	public void escolherPeao(Peao cor, String nome) throws CorDePeaoRepetidaException, CorInexistenteExpcetion {
				
		if (coresIndisponiveis.contains(cor)) {
			throw new CorDePeaoRepetidaException("Cor já escolhida. Escolha outra cor!");
		} else if (!coresExistentes.contains(cor)) {
			throw new CorInexistenteExpcetion("Cor inexistente. Escolha outra cor dentre as opções!");
		} else {
			coresIndisponiveis.add(cor);
			Jogador jogador = new Jogador(nome, cor);
			this.jogadores.add(jogador);
		}
	}

	public void criaCartasDoJogo() {
		tabuleiro.pilhaDeCartas.criaPilhaDeCartas();
		tabuleiro.pilhaDeCartas.criaPilhaDeCartasSorteReves();
		cartas = tabuleiro.getCartas();
		cartasSorteReves = tabuleiro.getCartasSorteReves();
	}
	
	/**
	 * Método utilizado para calcular o avanço de cada jogador a cada rodada
	 * 
	 * @param posicaoAntiga
	 * @param dado1
	 * @param dado2
	 * @return retorna o posicaoAposJogada de avanço
	 * @author Carlos Eduardo, Alefe e Aisllan
	 **/

	public int anda(int posicaoAntiga, int dado1, int dado2) {
		int posicaoAposJogada = 0;
		posicaoAposJogada = (posicaoAntiga + dado1 + dado2) % 40;
		return posicaoAposJogada;
	}

	/**
	 * Método que realiza a negociação de compra de título de propriedade
	 * 
	 * @param titulo
	 * @param jogadorDaVez
	 * @author Carlos Eduardo, Alefe e Aisllan
	 **/

	public void negociaTituloDePropriedade(Carta titulo, Jogador jogadorDaVez, String compra) {
		
		if (compra.toLowerCase().equals("sim")) {
			jogadorDaVez.adicionaTitulos(titulo);
			this.titulosVendidos.add(jogadorDaVez.getPosicaoAtual());
			jogadorDaVez.setDinheiro(jogadorDaVez.getDinheiro() - titulo.getPreco());
		} else if (compra.toLowerCase().equals("não")) {
			System.out.println("O jogo continua..."); 
			} 
	}
	
	public boolean verificaProprietario(Jogador jogadorDaVez ) {
		return (titulosVendidos.contains(jogadorDaVez.getPosicaoAtual()));
	}
	
	public void negociaCompanhia(Carta companhia, Jogador jogadorDaVez, String compra) {
		if (compra.toLowerCase().equals("sim")) {
			jogadorDaVez.adicionaCompanhia(companhia);
			this.titulosVendidos.add(jogadorDaVez.getPosicaoAtual());
			jogadorDaVez.setDinheiro(jogadorDaVez.getDinheiro() - companhia.getPreco());
		} else if (compra.toLowerCase().equals("não")) {
			System.out.println("O jogo continua..."); 
			} 
	}
	
	public void pagaAluguelDACompanhia(Companhia companhia, Jogador jogadorDaVez, int d1, int d2) {
		
		int aluguel = companhia.getMultiplicador()* (d1+d2);
		jogadorDaVez.setDinheiro(jogadorDaVez.getDinheiro() - aluguel);
		
	}
	
	
	public Carta retiraCartaDaPilha(int posicao) {
		return cartas.get(posicao);
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}
	
	public List<Peao> getCoresIndisponiveis(){
		return coresIndisponiveis;
	}

	public void setNumeroDeJogadores(int numeroDeJogadores) {
		this.numeroDeJogadores = numeroDeJogadores;
	}
	
	public int getNumeroDeJogadores() {
		return numeroDeJogadores;
	}

	public List<Carta> getCartas() {
		return cartas;
	}

	public Stack<Carta> getCartasSorteReves() {
		return cartasSorteReves;
	}

	public List<Integer> getIndicesEspeciais() {
		return indicesEspeciais;
	}

	public List<Integer> getIndicesSorteReves() {
		return indicesSorteReves;
	}

	

	
}
