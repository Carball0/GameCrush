package es.candy.clean.but.only.me;
import org.apache.logging.log4j.*;

public class Casilla {
	private int column;
	private int row;
	private Tablero tablero = new Tablero();
	Color black = new Color(0);
	Color red = new Color(1);
	Color green = new Color(2);
	Color yellow = new Color(3);
	Color blue = new Color(4);
	Color purple = new Color(5);
	Color cyan = new Color(6);
	Color white = new Color(7);
	
	public Casilla() {
	}
	
	public void setRow(int row) {
		this.row = row;
	}
	public int getRow() {
		return this.row;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	public int getColumn() {
		return this.column;
	}
	public void setArray(Tablero tablero) {
		this.tablero = tablero;
	}
	public int getArray() {
		return this.column;
	}

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
		if (columnInput<tableroInput.length-1 && rowInput<tableroInput.length-1 && tableroInput[rowInput][columnInput-1] != black) {
			if (tableroInput[rowInput][columnInput].equals(tableroInput[rowInput][columnInput-1])==true && columnInput-1>=0) {
				isSameColor = true;
			} else {
				isSameColor = false;
			}
		}
		return isSameColor;
	}
	public Color[][] shootRightColor(Color[][] tableroInput, int rowInput, int columnInput) {
		boolean isSameColor = isSameColorRight(tableroInput, rowInput, columnInput);
		int i = 0;
		while (isSameColor==true && columnInput + i < tableroInput.length-1) {
			tableroInput[rowInput][columnInput] = black;
			tableroInput[rowInput][columnInput + i] = black;
			i++;
			isSameColor = isSameColorRight(tableroInput, rowInput, columnInput + i);
		}
		return tableroInput;
	}
	public Color[][] shootLeftColor(Color[][] tableroInput, int rowInput, int columnInput) {
		boolean isSameColor = isSameColorLeft(tableroInput, rowInput, columnInput);
		int i = 0;
		while (isSameColor==true && columnInput - i >= 0) {
			tableroInput[rowInput][columnInput] = black;
			tableroInput[rowInput][columnInput - i] = black;
			i++;
			isSameColor = isSameColorRight(tableroInput, rowInput, columnInput - i);
		}
		return tableroInput;
	}
}
