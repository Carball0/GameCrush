package es.candy.clean.but.only.me;
/*
 * @author Alejandro Carballo Casas
 */

public class Tablero {
	private int size = 100;
	private Color[][] tablero = new Color[size][size];
	private int boardColors = 3;
	Color black = new Color(0);
	Color red = new Color(1);
	Color green = new Color(2);
	Color yellow = new Color(3);
	Color blue = new Color(4);
	Color purple = new Color(5);
	Color cyan = new Color(6);
	Color white = new Color(7);
	
	public Tablero() {
		//this.size = getSize();
	}
	//Board generator
	public Tablero(int size) {
		this.size = size;
		for(int i = 0; i < size; i++) {
			for(int j = 1; j < size; j++) {
				System.out.println(tablero[i][j]);
			}
		}
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
	        if (size%2==0) {	//if size is par/even, then size/2 and the following code works (does not work for uneven/odd numbers)
	        for(int j=0; j < size/2; j++) {
	        	j = j++;
	        	int random = (int)Math.floor(Math.random()*(boardColors)+1);
	        	Color randomColor = new Color(random);
	        	
	        		System.out.print(tablero[i][j] = randomColor);
	        		System.out.print(tablero[i+1][j+1] = randomColor);
	        	}
	        } else {
	        	System.out.println("There is no method for uneven numbers :(");
	        }
	    }
	}
}
