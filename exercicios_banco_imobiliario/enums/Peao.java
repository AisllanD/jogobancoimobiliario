package com.exercicios_banco_imobiliario.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Peao {

	PRETO, BRANCO, VERMELHO, VERDE, AZUL, AMARELO, LARANJA, ROSA;
	protected List<Peao> coresEscolhidas = new ArrayList<>();

	public static Peao setPeao(String cor) {
		switch(cor) {
		case "PRETO":
			return Peao.PRETO;
		case "BRANCO":
			return Peao.BRANCO;
		case "VERMELHO":
			return Peao.VERMELHO;
		case "VERDE":
			return Peao.VERDE;
		case "AZUL":
			return Peao.AZUL;
		case "AMARELO":
			return Peao.AMARELO;
		case "LARANJA":
			return Peao.LARANJA;
		case "ROSA":
			return Peao.ROSA;
		}
		return null;
	}
	
	public List<Peao> obterCoresEscolhidas() {
		return coresEscolhidas;
	}
	
	public void adcionaCoresEscolhidas(Peao peao) {
		coresEscolhidas.add(peao);
	}
	
}
