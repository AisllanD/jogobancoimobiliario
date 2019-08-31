package com.exercicios_banco_imobiliario.domain;

import com.exercicios_banco_imobiliario.enums.Peao;

public interface Negociavel {

	public int getId();
	public String getNome();
	public int getPreco();
	public int getHipoteca();
	public void setProprietario(Peao peao);
	public Peao getProprietario();
}
