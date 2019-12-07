package es.candy.clean.but.only.me;

public class JuegoCrush {
	private int size = 5;
	private int boardColors;
	Color black = new Color(0);
	Color red = new Color(1);
	Color green = new Color(2);
	Color yellow = new Color(3);
	Color blue = new Color(4);
	Color purple = new Color(5);
	Color cyan = new Color(6);
	Color white = new Color(7);
	
	public JuegoCrush() {
	}
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
	
	//return a random numbers for random colors
	public int randomNumber() {
		int random = (int)Math.floor(Math.random()*(boardColors)+1);
		return random;
	}
	
	//method that tests the Color class functionality
	public void colorTest() {
		Color[][] tableroo1 = new Color[1][8];
		tableroo1[0][0] = red;
		tableroo1[0][1] = green;
		tableroo1[0][2] = yellow;
		tableroo1[0][3] = blue;
		tableroo1[0][4] = purple;
		tableroo1[0][5] = cyan;
		tableroo1[0][6] = white;
		tableroo1[0][7] = black;
		System.out.println("\n"+"Input size: "+getSize()+"\nPrinting available colors");
		for (int i=0; i<8; i++) {
			System.out.print(tableroo1[0][i]);
		}
	}
	//method that declares the game finished
	public boolean isGameFinished() {
		return false;
	}
}
