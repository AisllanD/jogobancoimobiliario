package exercicios_banco_imobiliario;

import java.util.Scanner;

import exercicios_banco_imobiliario.domain.Carta;
import exercicios_banco_imobiliario.domain.Companhia;
import exercicios_banco_imobiliario.domain.Dado;
import exercicios_banco_imobiliario.domain.Jogador;
import exercicios_banco_imobiliario.domain.Jogo;
import exercicios_banco_imobiliario.domain.PilhaDeCartas;
import exercicios_banco_imobiliario.domain.Tabuleiro;
import exercicios_banco_imobiliario.domain.TituloDePropriedade;
import exercicios_banco_imobiliario.enums.Peao;
import exercicios_banco_imobiliario.exceptions.CorDePeaoRepetidaException;
import exercicios_banco_imobiliario.exceptions.CorInexistenteExpcetion;
import exercicios_banco_imobiliario.exceptions.NumeroJogadoresExcedenteException;
import exercicios_banco_imobiliario.exceptions.NumeroJogadoresInsuficienteException;

public class GameSystem {

	public static void main(String[] args) {

		Jogo jogo = new Jogo();
		PilhaDeCartas pilhaDeCartas = new PilhaDeCartas();
		Tabuleiro tabuleiro = new Tabuleiro();
		TituloDePropriedade titulo = new TituloDePropriedade(0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
		Companhia companhia = new Companhia(0, null, 0, 0, 0);
		Scanner scan = new Scanner(System.in);
		int numeroDeJogadores = -1;
		int contadorDeRodadas = 0;

		// Escolher número de jogadores
		while (numeroDeJogadores < 2 || numeroDeJogadores > 8) {
			try {
				System.out.print("Digite o número de jogadores de 2 a 8: ");
				numeroDeJogadores = Integer.parseInt(scan.nextLine());
				jogo.criaJogadores(numeroDeJogadores);
			} catch (NumberFormatException e) {
				System.err.println(e.getMessage());
			} catch (NumeroJogadoresInsuficienteException | NumeroJogadoresExcedenteException e) {
				System.err.println(e.getMessage());
			}
		}

		for (int i = 0; i < numeroDeJogadores; i++) {
			
			boolean peaoEscolhido = false;
			System.out.println("\nDigite o nome do jogador " + (i + 1) + ":");
			String nome = scan.nextLine();
			
			while (!peaoEscolhido) {
				System.out.println("\nEscolha a cor do peão de acordo com as cores dispoíveis:");
				for (Peao peao : Peao.values()) {
					if (!jogo.getCoresIndisponiveis().contains(peao)) System.out.print("[" + peao + "]");
				}
				System.out.println();
				
				String cor = scan.nextLine();
				Peao peao = Peao.setPeao(cor.toUpperCase());
				
				try {
					jogo.escolherPeao(peao, nome);
					peaoEscolhido = true;
				} catch (CorDePeaoRepetidaException e) {
					System.err.println(e.getMessage());
				} catch (CorInexistenteExpcetion e) {
					System.err.println(e.getMessage());
				}
			}
		}

		jogo.criaCartasDoJogo();
		System.out.println("\n*** O BANCO IMOBILIÁRIO VAI COMEÇAR, APROVEITE! ***\n");

		while (jogo.getNumeroDeJogadores() > 1) {
			contadorDeRodadas++;
			System.out.println("\n===== RODADA " + contadorDeRodadas + " =====\n");

			for (int i = 0; i < jogo.getJogadores().size(); i++) {
				Jogador jogadorDaVez = jogo.getJogadores().get(i);
				if (contadorDeRodadas == 2 && !jogadorDaVez.getOpcoes().contains("status"))
					jogadorDaVez.adicionaOpcoes("status");
				System.out.println("A vez é do jogador " + jogadorDaVez.getNome() + "(" + jogadorDaVez.getPeao() + ")");

				String opcao = "";
				while (true) {
					System.out.println("Comandos disponíveis: " + jogadorDaVez.imprimeOpcoes());
					System.out.println("Digite o comando desejado:");
					jogadorDaVez.imprimeOpcoes();
					opcao = opcao.replaceAll(opcao, scan.nextLine());
					
					if (jogadorDaVez.getOpcoes().contains(opcao.toLowerCase())) break;
					else System.out.println("Opção inválida!");
				}

				switch (opcao.toLowerCase()) {

				case "jogar":

					Dado dado1 = new Dado();
					Dado dado2 = new Dado();
					int d1 = dado1.rolaDado();
					int d2 = dado2.rolaDado();
					int posicaoAposJogada = jogo.anda(jogadorDaVez.getPosicaoAtual(), d1, d2);
					
					jogadorDaVez.setPosicaoAtual(posicaoAposJogada);

					if (jogo.getIndicesEspeciais().contains(posicaoAposJogada)) {
						String nome = jogo.getCartas().get(posicaoAposJogada).getNome();

						System.out.println("O jogador " + jogadorDaVez.getNome() + "(" + jogadorDaVez.getPeao()
								+ ") tirou " + d1 + ", " + d2 + " e o peão avançou para a casa " + posicaoAposJogada
								+ " - " + nome + "\n");

						if (posicaoAposJogada == 30) {
							jogadorDaVez.setPosicaoAtual(10); //Jogador foi enviado para a prisão
							jogadorDaVez.setPreso(true);
							jogadorDaVez.adicionaOpcoes("pagar");
						}
					} else if (jogo.getIndicesSorteReves().contains(posicaoAposJogada)) {
						
					} else {
						
					}
					
					//Titulos De Propriedade
					if(tabuleiro.getCartas().get(posicaoAposJogada).getClass().equals(titulo.getClass())) {
						
						titulo = (TituloDePropriedade)tabuleiro.getCartas().get(jogadorDaVez.getPosicaoAtual());
						System.out.println("O jogador " + jogadorDaVez.getNome() + "(" + jogadorDaVez.getPeao() + ") tirou " + d1 + ", " + d2 +
						" e o peão avançou para a casa " + posicaoAposJogada + " - " + ((TituloDePropriedade)tabuleiro.getCartas().get(posicaoAposJogada)).getNome());
						//Verifica se propriedade tem um prorietario
						if(!jogo.verificaProprietario(jogadorDaVez)) {
							System.out.println("O título da propriedade " + titulo.getNome() + " está disponível por " + titulo.getPreco());
							System.out.println("Você possui " + jogadorDaVez.getDinheiro());
							//Realiza compra de propriedade
							if (jogadorDaVez.getDinheiro() >= titulo.getPreco()) {
								System.out.println("Vocï¿½ deseja comprar " + titulo.getNome() + " (sim/nï¿½o)?");
								String compra = scan.nextLine();
								jogo.negociaTituloDePropriedade(titulo, jogadorDaVez, compra);
								System.out.println("Parabéns! Você comprou a propriedade: " + titulo.getNome()); 
								}else {
									System.out.println("Voçê não possui Dinheiro o suficiente!");
								}
							//Propriedade indisponivel
							} else {
							System.out.println("O título da propriedade " + titulo.getNome() + " não está disponível para compra!");//Alterar posteriormente
						}			 		  
					}
					
					//Companhias
					if(tabuleiro.getCartas().get(posicaoAposJogada).getClass().equals(companhia.getClass())) {
						
						companhia = (Companhia)tabuleiro.getCartas().get(jogadorDaVez.getPosicaoAtual());
						System.out.println("O jogador " + jogadorDaVez.getNome() + "(" + jogadorDaVez.getPeao() + ") tirou " + d1 + ", " + d2 +
						" e o peão avançou para a casa " + posicaoAposJogada + " - " + ((Companhia)tabuleiro.getCartas().get(posicaoAposJogada)).getNome());
						
						if(!jogo.verificaProprietario(jogadorDaVez)) {
							System.out.println("A " + companhia.getNome() + " está disponível por " + companhia.getPreco());
							System.out.println("Você possui " + jogadorDaVez.getDinheiro());
							
							if(jogadorDaVez.getDinheiro() >= titulo.getPreco()) {
								System.out.println("Vocï¿½ deseja comprar " + companhia.getNome() + " (sim/nï¿½o)?");
								String compra = scan.nextLine();
								jogo.negociaCompanhia(companhia, jogadorDaVez, compra);
								System.out.println("Parabéns! Você comprou a companhia: " + companhia.getNome());	
							}else{
								System.out.println("Voçê não possui Dinheiro o suficiente!");
							}
						}else {
							System.out.println("O t�tulo da Commpanhia: " + companhia.getNome() + " n�o est� dispon�vel para compra. Já tem proprietário." );
							System.out.println("Pague o aluguel ao dono da Companhia!");
							System.out.println("Voc� possui " + jogadorDaVez.getDinheiro());
							System.out.println("O alguel da Companhia custa " + companhia.getMultiplicador() * (d1+d2));
							jogo.pagaAluguelDACompanhia(companhia, jogadorDaVez, d1, d2);
							System.out.println("O seu novo saldo é: " + jogadorDaVez.getDinheiro());
						}
					}
					
					
						
					
					/*
					  if (tabuleiro.getCartas().get(posicaoAposJogada).getClass().equals(titulo.
					  getClass())) {
					  
					  titulo = (TituloDePropriedade)tabuleiro.getCartas().get(jogadorDaVez.getPosicaoAtual());
					  
					  System.out.println("O jogador " + jogadorDaVez.getNome() + "(" +
					  jogadorDaVez.getPeao() + ") tirou " + d1 + ", " + d2 +
					  " e o peão avançou para a casa " + posicaoAposJogada + " - " +
					  ((TituloDePropriedade)
					  tabuleiro.getCartas().get(posicaoAposJogada)).getNome());
					  
					  if (!titulosVendidos.contains(jogadorDaVez.getPosicaoAtual())) {
					  System.out.println("O título da propriedade " + titulo.getNome() +
					  " está disponível por " + titulo.getPreco());
					  System.out.println("Você possui " + jogadorDaVez.getDinheiro());
					  negociaTituloDePropriedade(titulo, jogadorDaVez); } else {
					  System.out.println("O título da propriedade " + titulo.getNome() +
					  " não está disponível para compra!");//Alterar posteriormente }
					  
					  } else if
					  (tabuleiro.getCartas().get(posicaoAposJogada).getClass().equals(companhia.
					  getClass())) { System.out.println("O jogador " + jogadorDaVez.getNome() + "("
					  + jogadorDaVez.getPeao() + ") tirou " + d1 + ", " + d2 +
					  " e o peão avançou para a casa " + posicaoAposJogada + " - " + ((Companhia)
					  tabuleiro.getCartas().get(posicaoAposJogada)).getNome());
					  
					  } else if
					  (tabuleiro.getCartas().get(posicaoAposJogada).getClass().equals(sorteReves.
					  getClass())) { System.out.println("O jogador " + jogadorDaVez.getNome() + "("
					 + jogadorDaVez.getPeao() + ") tirou " + d1 + ", " + d2 +
					  " e o peão avançou para a casa " + posicaoAposJogada + " - " +
					  ((CartaSorteReves)
					  tabuleiro.getCartas().get(posicaoAposJogada)).getDescricao());
					 
					  } else if
					  (tabuleiro.getCartas().get(posicaoAposJogada).getClass().equals(cartaEspecial
					  .getClass())) { System.out.println("O jogador " + jogadorDaVez.getNome() +
					 "(" + jogadorDaVez.getPeao() + ") tirou " + d1 + ", " + d2 +
					  " e o peão avançou para a casa " + posicaoAposJogada + " - " +
					  ((CartaEspecial) tabuleiro.getCartas().get(posicaoAposJogada)).getNome()); }
					 */
					break;

				case "sair":

					System.out.println("Você realmente quer sair do jogo (sim/não)?");
					String escolha = scan.nextLine();
					boolean escolhido = false;

					do {

						if (escolha.toLowerCase().equals("sim")) {
							numeroDeJogadores--;
							jogo.getJogadores().remove(i--);
							escolhido = true;

							if (numeroDeJogadores < 2) {
								System.out.println(
										"Número de jogadores insuficiente para continuar o jogo.\nJogo encerrado!");
								System.exit(0);
							}

						} else if (escolha.toLowerCase().equals("não")) {
							System.out.println("Segue o jogo...");
							escolhido = true;
						} else {
							System.out.println("Opção inválida! Escolha sim ou não:");
							escolha = escolha.replaceAll(escolha, scan.nextLine());
						}

					} while (!escolhido);

					break;

				case "status":

					System.out.println(jogadorDaVez.status());
					i--;

					break;

				}// fim do switch
			} // fim do for
		} // fim do while
		scan.close();
	}//fim do main

}// fim da classe GameSystem
