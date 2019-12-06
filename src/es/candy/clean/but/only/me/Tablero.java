package es.candy.clean.but.only.me;
/*
 * @author Alejandro Carballo Casas
 */

public class Tablero {
	private int size;
	private Color[][] tablero;
	
	public Tablero() {
		this.size = 5;
	}
	public Tablero(int size) {
		this.size = size;
		tablero = new Color[size][size];
		Color rojo = new Color(1);
			for(int i = 1; i < size; i++) {
				for(int j=1; j < size; j++) {
					tablero[i][j] = rojo;
					for(int v = 1; v < size; v++) {
						tablero[i][0] = rojo;
						for(int w = 1; w < size; w++) {
							tablero[0][j] = rojo;
						}
					}
				}
			}
	}
	public void printBoard() {
	    for(int i=0; i < size; i++) {
	        System.out.print( (char)(i + 97) + "\t" ); //97 es el valor de 'a'
	    }
	    System.out.println();
	    for(int i=0; i < size; i++) {
	        System.out.printf("%2d\t", i+1);
	        for(int j=0; j < size; j++) {
	            System.out.print(tablero[i][j] + "\t");
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
