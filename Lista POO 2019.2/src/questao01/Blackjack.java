package questao01;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import questao01.beans.Deck;

public class Blackjack {
	private static ArrayList<Deck> decks = new ArrayList<Deck>(10);
	private static int numDecks;

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);

		/*
		 * Mensagem Inicial
		 */
		System.out.println("+++++++++ Bem-vindo ao Blackjack Rural +++++++++\n\n");
		System.out.println("Quantos decks de baralho você deseja utilizar nessa partida?");
		int numDecks = ler.nextInt();
		while(numDecks < 2 || numDecks > 10) {
			if(numDecks < 2 || numDecks > 10) {
				System.out.println("Número inválido de decks, digite um valor entre 2 e 10!");
				numDecks = ler.nextInt();
			}
		}

		//Inicializando Decks
		for (int i = 0; i < numDecks; i++){
			Deck newDeck = new Deck();
			newDeck.criarBaralho();
			newDeck.shuffle();
			decks.add(newDeck);
		}

		Deck playerDeck = new Deck();
		Deck bancaDeck = new Deck();
		double playerMoney = 100;

		//loop
		while(playerMoney > 0) {
			System.out.println("Você tem $"+ playerMoney +", quanto você deseja apostar?");
			double playerAposta = ler.nextDouble();
			boolean fimRodada = false;
			if(playerAposta > playerMoney) {
				System.out.println("Você não pode apostar mais do que tem!");
				break;
			}

			/*
			 * Início da banca
			 * Jogador recebe duas cartas
			 */
			Random random = new Random();
			int indicePlayingDeck = random.nextInt((decks.size() - 1 - 0)+1)+0;
			Deck playingDeck = decks.get(indicePlayingDeck);
			System.out.println("Distribuindo...");
			
			//Jogador recebe duas cartas
			playerDeck.comprar(playingDeck);
			playerDeck.comprar(playingDeck);

			//Banca recebe duas cartas
			bancaDeck.comprar(playingDeck);
			bancaDeck.comprar(playingDeck);

			//While loop for drawing new cards
			while(true)
			{
				//Display player cards
				System.out.println("Sua mão:" + playerDeck.toString());

				//Display Value
				System.out.println("Valor atual da mão: " + playerDeck.valoresCarta());

				//Display dealer cards
				System.out.println("Mão da banca: " + bancaDeck.getCarta(0).toString() + " e [ocultas]");

				//What do they want to do
				System.out.println("Você deseja: (1)Comprar or (2)Manter");
				int response = ler.nextInt();	
				//They hit
				if(response == 1){
					playerDeck.comprar(playingDeck);
					System.out.println("Você comprou uma:" + playerDeck.getCarta(playerDeck.tamanhoDeck()-1).toString());
					//Bust if they go over 21
					if(playerDeck.valoresCarta() > 21){
						System.out.println("Mantido. Valor atual da mão: " + playerDeck.valoresCarta());
						playerMoney -= playerAposta;
						fimRodada = true;
						break;
					}
				}

				//Stand
				if(response == 2){
					break;
				}

			}

			//Revela as cartas da Banca
			System.out.println("Cartas da Banca:" + bancaDeck.toString());
			//Verifica se a Banca tem mais pontos que o jogador
			if((bancaDeck.valoresCarta() > playerDeck.valoresCarta())&&fimRodada == false){
				System.out.println("A Banca te venceu por:" + bancaDeck.valoresCarta() + " a " + playerDeck.valoresCarta());
				playerMoney -= playerAposta;
				fimRodada = true;
			}
			//Dealer hits at 16 stands at 17
			while((bancaDeck.valoresCarta() < 17) && fimRodada == false){
				bancaDeck.comprar(playingDeck);
				System.out.println("Compras da Banca: " + bancaDeck.getCarta(bancaDeck.tamanhoDeck()-1).toString());
			}
			//Mostra o valor da mão da banca
			System.out.println("Valor da mão da Banca: " + bancaDeck.valoresCarta());
			//Determina se a banca manteve
			if((bancaDeck.valoresCarta()>21)&& fimRodada == false){
				System.out.println("A Banca manteve. Você venceu!");
				playerMoney += playerAposta;
				fimRodada = true;
			}
			//Determina se push
			if((bancaDeck.valoresCarta() == playerDeck.valoresCarta()) && fimRodada == false){
				System.out.println("Push.");
				fimRodada = true;
			}
			//Determina se o jogador ganhou
			if((playerDeck.valoresCarta() > bancaDeck.valoresCarta()) && fimRodada == false){
				System.out.println("Você ganhou a mão.");
				playerMoney += playerAposta;
				fimRodada = true;
			}
			else if(fimRodada == false) //Banca vence
			{
				System.out.println("Banca venceu!");
				playerMoney -= playerAposta;
			}

			//Fim da mão - coloca as cartas de volta no Deck
			playerDeck.moverTodasParaDeck(playingDeck);
			bancaDeck.moverTodasParaDeck(playingDeck);
			System.out.println("Fim da mão.");

		}
		//Game is over
		System.out.println("Game over! Você perdeu todas as fichas. :(");

		//Close Scanner
		ler.close();

	}
}