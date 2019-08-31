package com.exercicios_banco_imobiliario.domain;

import java.util.Random;

public class Dado {

	private int faceSuperior;
	
	/**
	 * Método que rola o dado sorteando um número de 1 a 6 e que ao final os soma com a posição antiga do jogador. 
	 * @param faceSuperior
	 * @return retorna a face superior de cada dado, ou seja, o valor utilizado para calcular o avanço do jogador
	 * @author Carlos Eduardo, Alefe e Aisllan
	**/
	public int rolaDado() {
		Random rand = new Random();
		this.faceSuperior = 1 + rand.nextInt(6);
		return this.faceSuperior;
	}
}
