package questao01;
import java.util.ArrayList;
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
		while(numDecks < 2 || numDecks > 10) {
			System.out.println("Quantos decks de baralho você deseja utilizar nessa partida?");
			int numDecks = ler.nextInt();
			if(numDecks < 2 || numDecks > 10) {
				System.out.println("Número inválido de decks, digite um valor entre 2 e 10!");
			}
		}

		//Inicializando Decks
		for (int i = 0; i < numDecks; i++){
			Deck newDeck = new Deck();
			newDeck.criarBaralho();
			newDeck.shuffle();
			decks.add(newDeck);
		}
		
		
		
	}


}
