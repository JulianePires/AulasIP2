package br.ufrpe.ip2_heranca.shapes;

public class TesteShapes {

	public static void main(String[] args) {
		Shape[] shapes = new Shape[3];
		shapes[0] = new Circle(6.0, "Blue", true);
		shapes[1] = new Rectangle(6.8, 5.2, "Red", false);
		shapes[2] = new Square(7.0, "Yellow", true);
		
		//TESTANDO METODOS CIRCLE
		
		for(Shape sh:shapes) {
			if(sh.getClass() == Circle.class) {
				((Circle) sh).setRadius(5.0);
				System.out.print("Raio do círculo: "+((Circle) sh).getRadius());
				System.out.print("\nÁrea do círculo: "+((Circle) sh).getArea());
				System.out.print("\nPerímetro do círculo: "+((Circle) sh).getPerimeter());
				System.out.print("\nCirculo: "+((Circle) sh).toString());
			}else if(sh.getClass() == Rectangle.class) {
				((Rectangle) sh).setWidth(3.0);
				((Rectangle) sh).setLength(4.0);
				System.out.print("\nComprimento do retângulo: "+((Rectangle) sh).getLength());
				System.out.print("\nAltura do retângulo: "+((Rectangle) sh).getWidth());
				System.out.print("\nÁrea do retângulo: "+((Rectangle) sh).getArea());
				System.out.print("\nPerímetro do retângulo: "+((Rectangle) sh).getPerimeter());
				System.out.print("\nRetângulo: "+((Rectangle) sh).toString());
			}else if(sh.getClass() == Square.class) {
				((Square) sh).setSide(5.0);
				System.out.print("\nLado do quadrado: "+((Square) sh).getSide());
				((Square) sh).setLength(8.0);
				System.out.print("\nLado do quadrado: "+((Square) sh).getSide());
				((Square) sh).setWidth(6.0);
				System.out.print("\nLado do quadrado: "+((Square) sh).getSide());
				System.out.print("\nÁrea do quadrado: "+((Square) sh).getArea());
				System.out.print("\nPerímetro do quadrado: "+((Square) sh).getPerimeter());
				System.out.print("\nQuadrado: "+((Square) sh).toString());
			}			
		}
	}
}
