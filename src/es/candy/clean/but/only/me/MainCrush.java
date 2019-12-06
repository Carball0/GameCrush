package es.candy.clean.but.only.me;

public class MainCrush {
	public static final String ANSI_RED = "\u001B[31m";
	public static void main(String[] args) {
		Tablero tablero = new Tablero();
		JuegoCrush size = new JuegoCrush();
		Color yellow = new Color(3);
		Color blue = new Color(4);
		
		System.out.println("Board Size:");
		size.setSize(Teclado.readInteger());
		
		Color[][] tableroo = new Color[size.getSize()][size.getSize()];
		tableroo[0][0] = yellow;
		tableroo[0][1] = blue;
		
		System.out.println(tableroo[0][0]+""+""+tableroo[0][1]);
		System.out.println(size.getSize());
		tablero.printBoard();
		
}

}
