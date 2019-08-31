package com.exercicios_banco_imobiliario.domain;

public class Carta {
	
	private int id;
	private String nome;
	private int preco;
	private int aluguelSemCasa;
	private int aluguelUmaCasa;
	private int aluguelDuasCasas;
	private int aluguelTresCasas;
	private int aluguelQuatroCasas;
	private int aluguelHotel;
	private int hipoteca;
	private int precoDaCasa;
	private int[] indices = null;
	
	//Construtor de Cartas Especiais
	public Carta(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	//Construtor de Títulos de Propriedade
	public Carta(int id, String nome, int preco, int aluguelSemCasa, int aluguelUmaCasa,
			int aluguelDuasCasas, int aluguelTresCasas, int aluguelQuatroCasas, int aluguelHotel, int hipoteca,
			int precoDaCasa) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.aluguelSemCasa = aluguelSemCasa;
		this.aluguelUmaCasa = aluguelUmaCasa;
		this.aluguelDuasCasas = aluguelDuasCasas;
		this.aluguelTresCasas = aluguelTresCasas;
		this.aluguelQuatroCasas = aluguelQuatroCasas;
		this.aluguelHotel = aluguelHotel;
		this.hipoteca = hipoteca;
		this.precoDaCasa = precoDaCasa;
	}

	//Construtor de Companhias
	public Carta(int id, String nome, int preco, int hipoteca) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.hipoteca = hipoteca;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public int getPreco() {
		return preco;
	}

	public int getAluguelSemCasa() {
		return aluguelSemCasa;
	}

	public int getAluguelUmaCasa() {
		return aluguelUmaCasa;
	}

	public int getAluguelDuasCasas() {
		return aluguelDuasCasas;
	}

	public int getAluguelTresCasas() {
		return aluguelTresCasas;
	}

	public int getAluguelQuatroCasas() {
		return aluguelQuatroCasas;
	}

	public int getAluguelHotel() {
		return aluguelHotel;
	}

	public int getHipoteca() {
		return hipoteca;
	}

	public int getPrecoDaCasa() {
		return precoDaCasa;
	}
	
	public int[] getIndices() {
		return indices;
	}
}
