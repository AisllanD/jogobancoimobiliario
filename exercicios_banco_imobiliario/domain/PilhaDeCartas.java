package com.exercicios_banco_imobiliario.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PilhaDeCartas {

	private List<Carta> cartas = new ArrayList<>();
	private int[] indexDeCartasSorteReves = {2, 12, 16, 22, 27, 37};
	private Stack<Carta> cartasSorteReves = new Stack<>();
	
	public void criaPilhaDeCartas() {
		
		Carta carta0 = new CartaEspecial(0, "Ponto de Partida");
		cartas.add(carta0);
		Carta carta1 = new TituloDePropriedade(1, "Leblon", 100, 6, 30, 90, 270, 400, 500, 50, 50, "roxo");
		cartas.add(carta1);
		Carta carta2 = new CartaSorteReves(2, "Sorte ou Reves");
		cartas.add(carta2);
		Carta carta3 = new TituloDePropriedade(3, "Av. Presidente Vargas", 60, 2, 10, 30, 90, 160, 250, 30, 50, "roxo");
		cartas.add(carta3);
		Carta carta4 = new TituloDePropriedade(4, "Av. Nossa Senhora de Copacabana", 60, 2, 10, 30, 90, 160, 250, 30, 50, "roxo");
		cartas.add(carta4);
		Carta carta5 = new Companhia(5, "Carta Ferroviária", 200, 100, 50);
		cartas.add(carta5);
		Carta carta6 = new TituloDePropriedade(6, "Av. Brigadeiro Faria Lima", 240, 20, 100, 300, 750, 925, 1100, 120, 150, "azul");
		cartas.add(carta6);
		Carta carta7 = new Companhia(7, "Carta de Viaçăo", 200, 100, 50);
		cartas.add(carta7);
		Carta carta8 = new TituloDePropriedade(8, "Av. Rebouças", 220, 18, 90, 250, 700, 875, 1050, 110, 150, "azul");
		cartas.add(carta8);
		Carta carta9 = new TituloDePropriedade(9, "Av. 9 de Julho", 220, 18, 90, 250, 700, 875, 1050, 110, 150, "azul");
		cartas.add(carta9);
		Carta casa10 = new CartaEspecial(10, "Prisăo (visitante)");
		cartas.add(casa10);
		Carta carta11 = new TituloDePropriedade(11, "Av. Europa", 200, 16, 80, 220, 600, 800, 1000, 100, 100, "roxo");
		cartas.add(carta11);
		Carta casa12 = new CartaSorteReves(12, "Sorte ou Reves");
		cartas.add(casa12);
		Carta carta13 = new TituloDePropriedade(13, "Rua Augusta", 180, 14, 70, 200, 550, 750, 950, 90, 100, "roxo");
		cartas.add(carta13);
		Carta carta14 = new TituloDePropriedade(14, "Av. Pacaembu", 180, 14, 70, 200, 550, 750, 950, 90, 100, "roxo");
		cartas.add(carta14);
		Carta carta15 = new Companhia(15, "Carta de Táxi", 150, 75, 40);
		cartas.add(carta15);
		Carta carta16 = new CartaSorteReves(16, "Sorte ou Reves");
		cartas.add(carta16);
		Carta carta17 = new TituloDePropriedade(17, "Interlagos", 350, 35, 175, 500, 1100, 1300, 1500, 175, 200, "laranja");
		cartas.add(carta17);
		Carta carta18 = new CartaEspecial(18, "Lucros e Dividendos");
		cartas.add(carta18);
		Carta carta19 = new TituloDePropriedade(19, "Morumbi", 400, 50, 200, 600, 1400, 1700, 2000, 200, 200, "laranja");
		cartas.add(carta19);
		Carta carta20 = new CartaEspecial(20, "Parada Livre");
		cartas.add(carta20);
		Carta carta21 = new TituloDePropriedade(21, "Flamengo", 120, 8, 40, 100, 300, 450, 600, 60, 50, "vermelho");
		cartas.add(carta21);
		Carta carta22 = new CartaSorteReves(22, "Sorte ou Reves");
		cartas.add(carta22);
		Carta carta23 = new TituloDePropriedade(23, "Botafogo", 100, 6, 30, 90, 270, 400, 500, 50, 50, "vermelho");
		cartas.add(carta23);
		Carta carta24 = new CartaEspecial(24, "Imposto de Renda");
		cartas.add(carta24);
		Carta carta25 = new CartaEspecial(25, "Carta de Navegaçăo");
		cartas.add(carta25);
		Carta carta26 = new TituloDePropriedade(26, "Av. Brasil", 160, 12, 60, 180, 500, 700, 900, 80, 100, "amarelo");
		cartas.add(carta26);
		Carta carta27 = new CartaSorteReves(27, "Sorte ou Reves");
		cartas.add(carta27);
		Carta carta28 = new TituloDePropriedade(28, "Av. Paulista", 140, 10, 50, 150, 450, 625, 750, 70, 100, "amarelo");
		cartas.add(carta28);
		Carta carta29 = new TituloDePropriedade(29, "Jardim Europa", 140, 12, 60, 180, 500, 700, 900, 80, 100, "amarelo");
		cartas.add(carta29);
		Carta carta30 = new CartaEspecial(30, "Vá para a Prisăo");
		cartas.add(carta30);
		Carta carta31 = new TituloDePropriedade(31, "Copacabana", 260, 22, 110, 330, 800, 975, 1150, 130, 150, "verde");
		cartas.add(carta31);
		Carta carta32 = new Companhia(32, "Carta de Aviaçăo", 200, 100, 50);
		cartas.add(carta32);
		Carta carta33 = new TituloDePropriedade(33, "Av. Vieira Souto", 320, 28, 150, 450, 1000, 1200, 1400, 160, 200, "verde");
		cartas.add(carta33);
		Carta carta34 = new TituloDePropriedade(34, "Av. Atlântica", 300, 26, 130, 390, 900, 1100, 1275, 150, 200, "verde");
		cartas.add(carta34);
		Carta carta35 = new Companhia(35, "Carta de Táxi Aéreo", 200, 100, 50);
		cartas.add(carta35);
		Carta carta36 = new TituloDePropriedade(36, "Ipanema", 300, 26, 130, 390, 900, 1100, 1275, 150, 200, "verde");
		cartas.add(carta36);
		Carta carta37 = new CartaSorteReves(37, "Sorte ou Reves");
		cartas.add(carta37);
		Carta carta38 = new TituloDePropriedade(38, "Jardim Paulista", 280, 24, 120, 360, 850, 1025, 1200, 140, 150, "azul escuro");
		cartas.add(carta38);
		Carta carta39 = new TituloDePropriedade(39, "Brooklin", 260, 22, 110, 330, 800, 975, 1150, 130, 150, "azul escuro");
		cartas.add(carta39);
		//Carta carta40 = new CartaEspecial(40, "Ponto de Partida");
		//cartas.add(carta40);
		
	}
	
	public void criaPilhaDeCartasSorteReves() {
				
		Carta cartaSorteReves1 = new CartaSorteReves(1, "Sua empresa foi multada por poluir demais", 200, false);
		cartasSorteReves.push(cartaSorteReves1);
		Carta cartaSorteReves2 = new CartaSorteReves(2, "O dia do seu casamento chegou, receba os presentes", 50, true);
		cartasSorteReves.push(cartaSorteReves2);
		Carta cartaSorteReves3 = new CartaSorteReves(3, "Reformou sua casa", 50, false);
		cartasSorteReves.push(cartaSorteReves3);
		Carta cartaSorteReves4 = new CartaSorteReves(4, "Seu livro será publicado por uma grande editora", 50, true);
		cartasSorteReves.push(cartaSorteReves4);
		Carta cartaSorteReves5 = new CartaSorteReves(5, "Utilize este cartão para se livrar da prisão", 0, false);
		cartasSorteReves.push(cartaSorteReves5);
		Carta cartaSorteReves6 = new CartaSorteReves(6, "Vá para prisão", 0, false);
		cartasSorteReves.push(cartaSorteReves6);
		Carta cartaSorteReves7 = new CartaSorteReves(7, "Vá até o início", 200, true);
		cartasSorteReves.push(cartaSorteReves7);
		Carta cartaSorteReves8 = new CartaSorteReves(8, "Suas ações na bolsa de valores estão em alta", 100, true);
		cartasSorteReves.push(cartaSorteReves8);
		Carta cartaSorteReves9 = new CartaSorteReves(9, "Você vai começar um curso de MBA e ganhou um bom desconto para pagamento a vista", 20, false);
		cartasSorteReves.push(cartaSorteReves9);
		Carta cartaSorteReves10 = new CartaSorteReves(10, "Férias com a família pague", 20, false);
		cartasSorteReves.push(cartaSorteReves10);
		Carta cartaSorteReves11 = new CartaSorteReves(11, "Recebeu o prêmio de profissional do ano e ganhou um carro", 10, true);
		cartasSorteReves.push(cartaSorteReves11);
		Carta cartaSorteReves12 = new CartaSorteReves(12, "Jogue os dados novamente", 0, false);
		cartasSorteReves.push(cartaSorteReves12);
		Carta cartaSorteReves13 = new CartaSorteReves(13, "Sua empresa irá patrocinar uma expedição a Antártida", 50, false);
		cartasSorteReves.push(cartaSorteReves13);
		Carta cartaSorteReves14 = new CartaSorteReves(14, "Vendeu a parte de sua empresa para um investidor", 75, true);
		cartasSorteReves.push(cartaSorteReves14);
		Carta cartaSorteReves15 = new CartaSorteReves(15, "Apostou no cavalo azarão e ganhou", 100, true);
		cartasSorteReves.push(cartaSorteReves15);
		Carta cartaSorteReves16 = new CartaSorteReves(16, "A falta de chuva prejudicou a colheita", 45, false);
		cartasSorteReves.push(cartaSorteReves16);
		Carta cartaSorteReves17 = new CartaSorteReves(17, "Recebeu uma herança inesperada", 75, true);
		cartasSorteReves.push(cartaSorteReves17);
		Carta cartaSorteReves18 = new CartaSorteReves(18, "Seu filho decidiu fazer intercâmbio", 20, false);
		cartasSorteReves.push(cartaSorteReves18);
		Carta cartaSorteReves19 = new CartaSorteReves(19, "Sua casa será desapropriada para a construção de um metrô e ganhará uma gorda indenização", 60, true);
		cartasSorteReves.push(cartaSorteReves19);
		Carta cartaSorteReves20 = new CartaSorteReves(20, "Venceu licitação para grande obra", 150, true);
		cartasSorteReves.push(cartaSorteReves20);
		Carta cartaSorteReves21 = new CartaSorteReves(21, "Seu iate afundou, mas você tinha seguro", 25, true);
		cartasSorteReves.push(cartaSorteReves21);
		Carta cartaSorteReves22 = new CartaSorteReves(22, "Seus funcionários entraram em greve", 30, false);
		cartasSorteReves.push(cartaSorteReves22);
		Carta cartaSorteReves23 = new CartaSorteReves(23, "Comprou obra de arte falsificada", 22, false);
		cartasSorteReves.push(cartaSorteReves23);
		Carta cartaSorteReves24 = new CartaSorteReves(24, "Sorte se tirou o número par da soma dos dados e revés caso contrário", 100, false);
		cartasSorteReves.push(cartaSorteReves24);
		Carta cartaSorteReves25 = new CartaSorteReves(25, "Seu jatinho precisa de manutenção", 9, false);
		cartasSorteReves.push(cartaSorteReves25);
		Carta cartaSorteReves26 = new CartaSorteReves(26, "Renovou a frota de carros da sua empresa", 100, false);
		cartasSorteReves.push(cartaSorteReves26);
		Carta cartaSorteReves27 = new CartaSorteReves(27, "Ganhou sozinho na loteria", 80, true);
		cartasSorteReves.push(cartaSorteReves27);
		Carta cartaSorteReves28 = new CartaSorteReves(28, "Atualizou os computadores da sua empresa", 30, false);
		cartasSorteReves.push(cartaSorteReves28);
		Carta cartaSorteReves29 = new CartaSorteReves(29, "Um navio afundou com suas mercadorias (não tinha seguro)", 40, false);
		cartasSorteReves.push(cartaSorteReves29);
		Carta cartaSorteReves30 = new CartaSorteReves(30, "Produção de leite de suas fazendas ficou abaixo da expectativa", 60, false);
		cartasSorteReves.push(cartaSorteReves30);
		Carta cartaSorteReves31 = new CartaSorteReves(31, "Tirou primeiro lugar no torneio de golfe receba", 100, true);
		cartasSorteReves.push(cartaSorteReves31);

	}

	public List<Carta> getCartas() {
		criaPilhaDeCartas();
		return cartas;
	}

	public Stack<Carta> getCartasSorteReves() {
		criaPilhaDeCartasSorteReves();
		return cartasSorteReves;
	}

	public int[] getIndexDeCartasSorteReves() {
		return indexDeCartasSorteReves;
	}
		
}
