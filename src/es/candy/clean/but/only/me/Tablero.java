package es.candy.clean.but.only.me;
/*
 * @author Alejandro Carballo Casas
 */

public class Tablero {
	private int size;
	private Color[][] tablero = new Color[5][5];
	Color black = new Color(0);
	Color red = new Color(1);
	Color green = new Color(2);
	Color yellow = new Color(3);
	Color blue = new Color(4);
	Color purple = new Color(5);
	Color cyan = new Color(6);
	Color white = new Color(7);
	
	public Tablero() {
		this.size = 5;
	}
	public Tablero(int size) {
		this.size = size;
		tablero = new Color[size][size];
			for(int i = 1; i < size; i++) {
				for(int j=1; j < size; j++) {
					tablero[i][j] = red;
					for(int v = 1; v < size; v++) {
						tablero[i][0] = yellow;
						for(int w = 1; w < size; w++) {
							tablero[0][j] = red;
						}
					}
				}
			}
	}
	public void printBoard() {
		
	    for(int i=0; i < size; i++) {
	        System.out.print((" "+"|" + (i+1)));
	    }
	    System.out.println();
	    for(int i=0; i < size; i++) {
	    	System.out.println(" ");
	        System.out.printf("%2d\t", i+1);
	        for(int j=0; j < size; j++) {
	            System.out.print((tablero[i][j] = red)/* + "\t"*/);
	        }
	    }
	}
	public int getSize() {
		return this.size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	//public Tablero newBoard() {
		
	//}
}
