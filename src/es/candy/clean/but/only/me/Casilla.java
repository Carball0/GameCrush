package es.candy.clean.but.only.me;

/**
 * 
 * Class that creates the boxes which will be placed
 * in the board and assigns colors to the different boxes.
 * 
 * @version 1.0
 * @author Alejandro Carballo Casas
 */

public class Casilla {
	
	/**
	 * 
	 * Stores the colors in a variable.
	 * 
	 */
	
	private Color color;

	/**
	 * 
	 * Constructor that creates a box with a random color.
	 * 
	 * @param boardColors Number of colors that the board has.
	 */
	
	public Casilla(int boardColors)  {
		
		int randomNumber = (int) Math.floor(Math.random()*boardColors+1);
		this.color = new Color(randomNumber);
	   }
	
	/**
	 * 
	 * Constructor that creates a box with the given color.
	 * 
	 * @param character Character for choosing the color you want.
	 */
	
	public Casilla (char character) {
		switch (character){
		case 'r': 
			this.color = new Color(1);
			break;
		
		case 'g': 
			this.color = new Color(2);
			break;
		
		case 'b': 
			this.color = new Color(4);
			break;
		}
	}
	
	/**
	 * 
	 * Constructor that creates a black box.
	 * 
	 */
	
	public Casilla()  {
		this.color = new Color(0);
	   }
	
	/**
	 * 
	 * Empties the box turning it to black
	 * 
	 */
	
	public void removeBox() {
		this.color = new Color(0);
	} 
	
	/**
	 * 
	 * Checks whether the box is black or not.
	 * 
	 * @return Wheter the color is black or not.
	 */
	
	public boolean isEmpty() {
		return this.color == new Color(0);
	}
	
	/**
	 * 
	 * Converts the box into a String.
	 * 
	 * @return The box as a String.
	 */
	
	public String toString() {
		return this.color.toString();
	}
	
	/**
	 * 
	 * Gets the color of the box.
	 * 
	 * @return The color of the box.
	 */
	
	public Color getColor() {
		return this.color;
	}
	
	/**
	 * 
	 * Compare if two boxes are equal or not.	
	 * 
	 * @param another Another box.
	 * @return True if the box is equal to another.
	 */
	
	public boolean equals(Casilla another) {
		return this.color.equals(another.getColor());
	}
}