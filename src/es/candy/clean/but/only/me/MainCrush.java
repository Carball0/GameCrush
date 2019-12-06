package es.candy.clean.but.only.me;

public class MainCrush {
	public static void main(String[] args) {
		Tablero tablero = new Tablero();
		JuegoCrush game = new JuegoCrush();	
		System.out.println("Board Size:");
		int readSize = Teclado.readInteger();
		game.setSize(readSize);
		tablero.setSize(readSize);
		
		tablero.printRandomBoard();
		game.colorTest();
	}

}
