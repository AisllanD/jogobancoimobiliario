package com.exercicios_banco_imobiliario.domain;

import com.exercicios_banco_imobiliario.enums.Peao;

public class TituloDePropriedade extends Carta implements Negociavel {
	
	private String tipo;
	private Peao proprietario;
	
	public TituloDePropriedade(int id, String nome, int preco, int aluguelSemCasa, int aluguelUmaCasa,
			int aluguelDuasCasas, int aluguelTresCasas, int aluguelQuatroCasas, int aluguelHotel, int hipoteca,
			int precoDaCasa, String tipo) {
		super(id, nome, preco, aluguelSemCasa, aluguelUmaCasa, aluguelDuasCasas, aluguelTresCasas, aluguelQuatroCasas,
				aluguelHotel, hipoteca, precoDaCasa);
		this.tipo = tipo;
		
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public Peao getProprietario() {
		return proprietario;
	}

	@Override
	public void setProprietario(Peao peao) {
		this.proprietario = peao;
	}

	
}
