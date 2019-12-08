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
	
	public void compareRightColor(Color[][] tableroInput, int rowInput, int columnInput) {
		int rowaux = rowInput - 1;
		int columnaux = columnInput-1;
		if (columnaux>=0 && rowaux>=0 && columnaux<tableroInput.length && rowaux<tableroInput.length) {
			while (tableroInput[rowaux][columnaux].equals(tableroInput[rowaux+1][columnaux]) && tableroInput[rowaux][columnaux]!=black) {
				tableroInput[rowaux][columnaux]=black;
				tableroInput[rowaux+1][columnaux]=black;
			}
		}
	}
	public void compareLeftColor(Color[][] tableroInput, int rowInput, int columnInput) {
		int rowaux = rowInput - 1;
		int columnaux = columnInput-1;
		if (columnaux>=0 && rowaux>=0 && columnaux<tableroInput.length && rowaux<tableroInput.length) {
			while (tableroInput[rowaux][columnaux].equals(tableroInput[rowaux-1][columnaux]) && tableroInput[rowaux][columnaux]!=black) {
				tableroInput[rowaux][columnaux]=black;
				tableroInput[rowaux-1][columnaux]=black;
			}
		}
	}
	public void compareBottomColor(Color[][] tableroInput, int rowInput, int columnInput) {
		int rowaux = rowInput - 1;
		int columnaux = columnInput-1;
		if (columnaux>=0 && rowaux>=0 && columnaux<tableroInput.length && rowaux<tableroInput.length) {
			while (tableroInput[rowaux][columnaux].equals(tableroInput[rowaux][columnaux+1]) && tableroInput[rowaux][columnaux]!=black) {
				tableroInput[rowaux][columnaux]=black;
				tableroInput[rowaux-1][columnaux]=black;
			}
		}
	}
	public void compareTopColor(Color[][] tableroInput, int rowInput, int columnInput) {
		int rowaux = rowInput - 1;
		int columnaux = columnInput-1;
		if (columnaux>=0 && rowaux>=0 && columnaux<tableroInput.length && rowaux<tableroInput.length) {
			while (tableroInput[rowaux][columnaux].equals(tableroInput[rowaux][columnaux-1]) && tableroInput[rowaux][columnaux]!=black) {
				tableroInput[rowaux][columnaux]=black;
				tableroInput[rowaux-1][columnaux]=black;
			}
		}
	}	
	public void compareColors() {
		
	}
	public boolean removeBox() {
		
		return false;
	}
}
