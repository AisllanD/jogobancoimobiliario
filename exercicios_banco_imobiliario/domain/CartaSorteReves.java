package com.exercicios_banco_imobiliario.domain;

public class CartaSorteReves extends Carta {

	private int valor;
	private boolean sorte;
	
	public CartaSorteReves(int id, String nome) {
		super(id, nome);
	}
	
	public CartaSorteReves(int id, String nome, int valor, boolean sorte) {
		super(id, nome);
		this.valor = valor;
		this.sorte = sorte;
	}

	public int getValor() {
		return this.valor;
	}
	
	public boolean getSorte() {
		return this.sorte;
	}
	
}
