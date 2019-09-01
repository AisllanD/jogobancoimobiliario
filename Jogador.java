package exercicios_banco_imobiliario.domain;

import java.util.ArrayList;

import java.util.List;

import exercicios_banco_imobiliario.enums.Peao;

public class Jogador {

	private String nome;
	private int dinheiro;
	private int posicaoAtual;
	private Peao peao;
	private boolean preso = false;
	private List<String> opcoes = new ArrayList<>();
	private List<Carta> titulos = new ArrayList<>();
	
	public Jogador(String nome, Peao peao) {
		this.nome = nome;
		this.dinheiro = 1500;
		this.posicaoAtual = 0;
		this.peao = peao;
		this.opcoes.add("jogar");
		this.opcoes.add("sair");
		
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setDinheiro(int dinheiro) {
		this.dinheiro = dinheiro;
	}
	
	public int getDinheiro() {
		return dinheiro;
	}
	
	public void setPosicaoAtual(int posicao) {
		this.posicaoAtual = posicao;
	}
	
	public int getPosicaoAtual() {
		return posicaoAtual;
	}
	
	public Peao getPeao() {
		return peao;
	}
	
	public boolean isPreso() {
		return preso;
	}

	public void setPreso(boolean preso) {
		this.preso = preso;
	}

	public List<String> getOpcoes() {
		return opcoes;
	}
	
	public String imprimeOpcoes() {
		String s = "";
		for (String op : this.opcoes) {
			s += "[" + op + "]";
		}
		return s;
	}
	
	public String getTitulos() {
		String titulos = "";
		for (Carta titulo : this.titulos) {
		titulos += "[" + titulo.getNome() + "]\n";
		}
		return titulos;
	}
	
	public String status() {
		String s = "";
		s += "========== STATUS ==========\n\n" 
				+ "Jogador: " + this.nome.substring(0, 1).toUpperCase().concat(this.nome.substring(1)) + "(" + this.peao + "):\n"
				+ "Posição atual: " + this.posicaoAtual + "\n"
				+ "Dinheiro: " + this.dinheiro + "\n"
				+ "Títulos de propriedade: " + this.getTitulos() + "\n";
		return s;
	}
	
	public void adicionaOpcoes(String op) {
		this.opcoes.add(op);
	}
	
	public void adicionaTitulos(Carta titulo) {
		this.titulos.add(titulo);
	}
	public void adicionaCompanhia(Carta companhia) {
		this.titulos.add(companhia);

	}
	
}
