package exercicios_banco_imobiliario.domain;

import exercicios_banco_imobiliario.enums.Peao;

public class Companhia extends Carta implements Negociavel {

	int multiplicador;
	Peao proprietario;

	public Companhia(int id, String nome, int preco, int hipoteca, int multiplicador) {
		super(id, nome, preco, hipoteca);
		this.multiplicador = multiplicador;
	}
	
	public int getMultiplicador() {
		return multiplicador;
	}

	@Override
	public void setProprietario(Peao peao) {
		this.proprietario = peao;		
	}

	@Override
	public Peao getProprietario() {
		return this.proprietario;
	}

	
}
