package br.ufrpe.ip2_heranca.employee;

public class Invoice implements Payable {
	
	private final String 	partNumber;
	private final String 	partDescription;
	private int 			quantity;
	private double 			pricePerItem;
	
	//construtor
	public Invoice(String partNumber, String partDescription, 
			int quantity, double pricePerItem) {
		if(quantity < 0)
			throw new IllegalArgumentException("Quantity must be >= 0");
		if(pricePerItem < 0.0)
			throw new IllegalArgumentException("Price per item must be >= 0");
		
		this.quantity = quantity;
		this.partDescription = partDescription;
		this.partNumber = partNumber;
		this.pricePerItem = pricePerItem;
	}
	
	//obtem o numero da peça
	public String getPartNumber() {
		return partNumber;
	}
	
	//obtem a descrição
	public String getPartDescription() {
		return partDescription;
	}
	
	//obtem a quantidade
	public int getQuantity() {
		return quantity;
	}
	
	//obtem preço por item
	public double getPricePerItem() {
		return pricePerItem;
	}
	
	//configurando a quantidade
	public void setQuantity(int quantity) {
		if(quantity < 0)
			throw new IllegalArgumentException("Quantity must be >= 0");
		this.quantity = quantity;
	}
	
	//configurando preço por item
	public void setPricePerItem(double pricePerItem) {
		if(pricePerItem < 0.0)
			throw new IllegalArgumentException("Price per item must be >= 0");
		this.pricePerItem = pricePerItem;
	}
	
	@Override
	public double getPaymentAmount() {
		return getQuantity() * getPricePerItem(); //calcula custo total
	}
	
	@Override
	public String toString() {
		return String.format("%s: %n%s: %s (%s, args) %n%s: $%.2f",
				"invoice", "part number", getPartNumber(), getPartDescription(), "quantity",
				getQuantity(), "price per item", getPricePerItem());
	}
}
