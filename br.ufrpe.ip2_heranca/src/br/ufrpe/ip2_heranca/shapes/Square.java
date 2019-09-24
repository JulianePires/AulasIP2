package br.ufrpe.ip2_heranca.shapes;

public class Square extends Rectangle {
	private double		side;

	public Square() {
		// TODO Auto-generated constructor stub
	}
	
	public Square(double side) {
	}
	
	public Square(double side, String color, boolean filled) {
		this.side = side;
		setColor(color);
		setFilled(filled);
	}

	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}
	
	public void setWidth(double side) {
		super.setWidth(side);
		super.setLength(side);
		this.side = side;
	}
	
	public void setLength(double side) {
		super.setLength(side);
		super.setWidth(side);
		this.side = side;
	}

	@Override
	public String toString() {
		return "Side = " + side +"| "+ super.toString();
	}
	
}
