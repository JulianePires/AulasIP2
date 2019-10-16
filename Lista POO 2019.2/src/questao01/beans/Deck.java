package questao01.beans;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
	//ATRIBUTOS
	private ArrayList<Carta> cartas;

	//CONSTRUTOR
	public Deck() {
		this.cartas = new ArrayList<Carta>();
	}

	//GERA BARALHO
	public void criarBaralho() {
		for(Naipes naipe: Naipes.values()) {
			for(Valores valor: Valores.values()) {
				this.cartas.add(new Carta(naipe, valor));
			}
		}
	}

	//EMBARALHA
	public void shuffle() {
		ArrayList<Carta> auxDeck = new ArrayList<Carta>();
		Random random = new Random();
		int indiceCartaRdm = 0;
		int tamanhoOriginal = this.cartas.size();
		for(int i = 0; i < tamanhoOriginal; i++) {
			//Gera indice aleatório
			indiceCartaRdm = random.nextInt((this.cartas.size()-1 - 0) + 1) + 0;
			auxDeck.add(this.cartas.get(indiceCartaRdm));
			this.cartas.remove(indiceCartaRdm);
		}
		this.cartas = auxDeck;
	}


	//METODO TO STRING
	public String toString() {
		String outputCartas = "";
		int i = 0;
		for(Carta cartaX: this.cartas) {
			outputCartas += "\n"+i+" "+cartaX.toString();
			i++;
		}
		return outputCartas;
	}

	//REMOVE UMA CARTA DO DECK
	public void removeCarta(int i){
		this.cartas.remove(i);
	}
	//SELECIONA CARTA DO DECK
	public Carta getCarta(int i){
		return this.cartas.get(i);
	}

	//ADICIONA CARTA AO DECK
	public void addCarta(Carta cartaAdicional){
		this.cartas.add(cartaAdicional);
	}

	//COMPRA UMA CARTA DE CIMA DO BARALHO
	public void comprar(Deck deckOrigem){
		this.cartas.add(deckOrigem.getCarta(0));
		deckOrigem.removeCarta(0);
	}

	public void moverTodasParaDeck(Deck deckDestino){
		int thisTamanhoDeck = this.cartas.size();
		for(int i = 0; i < thisTamanhoDeck; i++){
			deckDestino.addCarta(this.getCarta(i));
		}
		//empty out the deck
		for(int i = 0; i < thisTamanhoDeck; i++){
			this.removeCarta(0);
		}
	}

	public int tamanhoDeck(){
		return this.cartas.size();
	}

	//Calculate the value of deck
	public int valoresCarta(){
		int valorTotal = 0;
		int as = 0;
		//For every card in the deck
		for(Carta aCard : this.cartas){
			//Switch of possible values
			switch(aCard.getValor()){
			case DOIS: valorTotal += 2; break;
			case TRÊS: valorTotal += 3; break;
			case QUATRO: valorTotal += 4; break;
			case CINCO: valorTotal += 5; break;
			case SEIS: valorTotal += 6; break;
			case SETE: valorTotal += 7; break;
			case OITO: valorTotal += 8; break;
			case NOVE: valorTotal += 9; break;
			case DEZ: valorTotal += 10; break;
			case VALETE: valorTotal += 10; break;
			case DAMA: valorTotal += 10; break;
			case REI: valorTotal += 10; break;
			case ÁS: as += 1; break;
			}			
		}

		//Determina o valor total com o ás
		//Valor do ás pode ser 11 or 1 - se 11 ultrapassar 21, forçar 1
		for(int i = 0; i < as; i++){
			//Se já está com mais de 10 pontos, obter um ás no valor de 11 traria um valor de 22, então o ás valerá um
			if (valorTotal > 10){
				valorTotal += 1;
			}
			else{
				valorTotal += 11;
			}
		}
		return valorTotal;
	}

}
