package es.candy.clean.but.only.me;
import org.apache.logging.log4j.*;
/*
 * @author Alejandro Carballo Casas
 */

public class Tablero {
	private int size;
	private Color[][] tablero;
	private int boardColors;
	Color black = new Color(0);
	
	//getters and setters
	public void setArraySize(int size) {
		this.size = size;
		tablero = new Color[size][size];
	}
	public int getArraySize() {
		return this.size;
	}
	public void setBoardColors(int boardColors) {
		this.boardColors = boardColors;
	}
	public int getBoardColors() {
		return this.boardColors;
	}
	public Color[][] getArray() {
		return this.tablero;
	}
	
	//Random board generator and printer
	public boolean isSameColorRight(Color[][] tableroInput, int rowInput, int columnInput) {
		boolean isSameColor = false;
		if (columnInput<tableroInput.length-1 && rowInput<tableroInput.length-1 && tableroInput[rowInput][columnInput+1] != black) {
			if (tableroInput[rowInput][columnInput].equals(tableroInput[rowInput][columnInput+1])==true && columnInput+1<=tableroInput.length-1) {
				isSameColor = true;
			} else {
				isSameColor = false;
			}
		}
		return isSameColor;
	}
	public boolean isSameColorLeft(Color[][] tableroInput, int rowInput, int columnInput) {
		boolean isSameColor = false;
		if (columnInput<tableroInput.length-1 && rowInput<tableroInput.length-1 && tableroInput[rowInput][columnInput-1] != black && columnInput-1<0) {
			if (tableroInput[rowInput][columnInput].equals(tableroInput[rowInput][columnInput-1])==true && columnInput-1>=0) {
				isSameColor = true;
			} else {
				isSameColor = false;
			}
		}
		return isSameColor;
	}
	public void printRandomBoard() {
	    for(int i=0; i < size; i++) {
	    	if (i==0) {
	    		System.out.print("    " + (i));
	    	} else {
	        System.out.print(" " + (i));
	    	}
	    }
	    for(int i=0; i < size; i++) {
	    	System.out.println("");
	        System.out.printf("%2d\t", i);
	        for(int j=0; j < size; j++) {
	        	int random = (int)Math.floor(Math.random()*(boardColors)+1);
	        	Color randomColor = new Color(random);
	        	System.out.print(tablero[i][j] = randomColor);
	        }
	    }
	}
	public void printBoardAgain(Color[][] array) {
	    for(int i=0; i < array.length; i++) {
	    	if (i==0) {
	    		System.out.print("    " + (i));
	    	} else {
	        System.out.print((" " + (i)));
	    	}
	    }
	    for(int i=0; i < array.length; i++) {
	    	System.out.println("");
	        System.out.printf("%2d\t", i);
	        for(int j=0; j < array.length; j++) {
	        	System.out.print(array[i][j]);
	        }
	    }
	}
}
