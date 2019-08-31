package com.exercicios_banco_imobiliario.domain;

import java.util.List;
import java.util.Stack;

public class Tabuleiro {

	PilhaDeCartas pilhaDeCartas = new PilhaDeCartas();
	
	private List<Carta> cartas = pilhaDeCartas.getCartas();
	private Stack<Carta> cartasSorteReves = pilhaDeCartas.getCartasSorteReves();
	
	public List<Carta> getCartas() {
		return cartas;
	}

	public Stack<Carta> getCartasSorteReves() {
		return cartasSorteReves;
	}
	
}
