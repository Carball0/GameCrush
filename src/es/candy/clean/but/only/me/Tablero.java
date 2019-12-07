package es.candy.clean.but.only.me;
/*
 * @author Alejandro Carballo Casas
 */

public class Tablero {
	private int size = 5;
	private Color[][] tablero = new Color[size][size];
	JuegoCrush game = new JuegoCrush();
	private int boardColors;
	Color black = new Color(0);
	Color red = new Color(1);
	Color green = new Color(2);
	Color yellow = new Color(3);
	Color blue = new Color(4);
	Color purple = new Color(5);
	Color cyan = new Color(6);
	Color white = new Color(7);
	
	public Tablero() {
	}
	//getters and setters
	public void setSize(int size) {
		this.size = size;
	}
	public int getSize() {
		return this.size;
	}
	public void setBoardColors(int boardColors) {
		this.boardColors = boardColors;
	}
	public int getBoardColors() {
		return this.boardColors;
	}
	public void setArray(Color[][] array) {
		this.tablero = array;
	}
	public Color[][] getArray() {
		return this.tablero;
	}
	public int getArrayLength() {
		return tablero.length;
	}
	
	//Random board generator and printer
	public void printRandomBoard() {
		System.out.println(" ");
	    for(int i=0; i < size; i++) {
	        System.out.print((" "+"|" + (i+1)));
	    }
	    System.out.println();
	    for(int i=0; i < size; i++) {
	    	System.out.println("");
	        System.out.printf("%2d\t", i+1);
	        for(int j=0; j < size; j++) {
	        	int random = (int)Math.floor(Math.random()*(boardColors)+1);
	        	Color randomColor = new Color(random);
	        	System.out.print(tablero[i][j] = randomColor);
	        }
	    }
	}
	public void printBoardAgain(Color[][] array) {
		System.out.println(" ");
	    for(int i=0; i < array.length; i++) {
	        System.out.print((" "+"|" + (i+1)));
	    }
	    System.out.println();
	    for(int i=0; i < array.length; i++) {
	    	System.out.println("");
	        System.out.printf("%2d\t", i+1);
	        for(int j=0; j < array.length; j++) {
	        	System.out.print(tablero[i][j]);
	        }
	    }
	}
}
