package com.exercicios_banco_imobiliario_tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.exercicios_banco_imobiliario.domain.Jogo;
import com.exercicios_banco_imobiliario.enums.Peao;
import com.exercicios_banco_imobiliario.exceptions.NumeroJogadoresExcedenteException;
import com.exercicios_banco_imobiliario.exceptions.NumeroJogadoresInsuficienteException;

class JogoTest {

	Jogo jogo = new Jogo();
	
	@Test
	void testCriaJogo() throws NumeroJogadoresInsuficienteException, NumeroJogadoresExcedenteException {
		assertThrows(NumeroJogadoresInsuficienteException.class, () -> this.jogo.criaJogadores(1));
		this.jogo.criaJogadores(3);
		this.jogo.criaJogadores(4);
		this.jogo.criaJogadores(5);
		this.jogo.criaJogadores(6);
		this.jogo.criaJogadores(7);
		this.jogo.criaJogadores(8);
		assertThrows(NumeroJogadoresExcedenteException.class, () -> this.jogo.criaJogadores(9));
	}

	@Test
	void testEscolhePeao() {
/*		
		assertNotEquals(Peao.AMARELO, this.jogo.escolherPeao("amarelo"));
		assertNotEquals(Peao.BRANCO, this.jogo.escolhePeao(5));
		assertNotEquals(Peao.VERDE, this.jogo.escolhePeao(1));
		assertNotEquals(Peao.VERMELHO, this.jogo.escolhePeao(2));
		assertNotEquals(Peao.AZUL, this.jogo.escolhePeao(4));
		assertNotEquals(Peao.ROSA, this.jogo.escolhePeao(3));
		
		
		assertEquals(Peao.PRETO, this.jogo.escolhePeao(1));
		assertEquals(Peao.BRANCO, this.jogo.escolhePeao(2));
		assertEquals(Peao.VERMELHO, this.jogo.escolhePeao(3));
		assertEquals(Peao.VERDE, this.jogo.escolhePeao(4));
		assertEquals(Peao.AZUL, this.jogo.escolhePeao(5));
		assertEquals(Peao.AMARELO, this.jogo.escolhePeao(6));
		assertEquals(Peao.LARANJA, this.jogo.escolhePeao(7));
		assertEquals(Peao.ROSA, this.jogo.escolhePeao(8));
*/
	}
}
