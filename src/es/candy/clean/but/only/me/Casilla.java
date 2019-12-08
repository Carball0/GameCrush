package es.candy.clean.but.only.me;

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

	public Color[][] compareRightColor(Color[][] tableroInput, int rowInput, int columnInput) {
		int i = 1;
		while (tableroInput[rowInput][columnInput].equals(tableroInput[rowInput][columnInput+1])==true && tableroInput[rowInput][columnInput] != black) {
			if (columnInput<tableroInput.length-1 && rowInput<tableroInput.length-1 && columnInput+i<tableroInput.length-1) {
			tableroInput[rowInput][columnInput] = black;
			tableroInput[rowInput][columnInput + i] = black;
			i++;
			}
		}
	return tableroInput;
	}
	public Color[][] compareLeftColor(Color[][] tableroInput, int rowInput, int columnInput) {
		int i = 1;
		while (tableroInput[rowInput][columnInput].equals(tableroInput[rowInput][columnInput-1])==true) {
			if (columnInput<tableroInput.length-1 && rowInput<tableroInput.length-1 && columnInput+i<tableroInput.length-1) {
				tableroInput[rowInput][columnInput] = black;
				tableroInput[rowInput][columnInput + i] = black;
				i++;
			}
		}
	return tableroInput;
	}	
}
