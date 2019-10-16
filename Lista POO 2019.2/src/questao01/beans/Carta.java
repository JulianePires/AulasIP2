package questao01.beans;

public class Carta {
	
	//ATRIBUTOS
	private Naipes naipe;
	private Valores valor;
	
	//CONSTRUTOR
	public Carta(Naipes naipe, Valores valor) {
		this.naipe = naipe;
		this.valor = valor;
	}

	public Naipes getNaipe() {
		return naipe;
	}

	public Valores getValor() {
		return valor;
	}
	
	//TO STRING
	public String toString () {
		return valor.toString() + " de " + naipe.toString();
	}
	
}
