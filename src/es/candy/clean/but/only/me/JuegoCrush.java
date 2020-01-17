package es.candy.clean.but.only.me;

import org.apache.logging.log4j.*;

/**
 * Class that creates the game with the parameters 
 * introduced by the user.
 * This class calls Tablero methods for erasing boxes
 * It also return when the game has finished.
 * 
 * @version 1.0
 * @author Alejandro Carballo Casas
 */

public class JuegoCrush {
	
	static final Logger logger = LogManager.getLogger(JuegoCrush.class);

	/**
	 * 
	 * Board of the game that is ran.
	 * 
	 */
	
	private Tablero tablero;
								
	/**
	 * 
	 * Creates a game with a board predefined if size is 5 
	 * and boardColor is 3, else it creates a random board. 
	 * 
	 * @param size Dimensions of the board.
	 * @param boardColors Number of colors that the board has. 
	 * @throws CandyCleanException Receives an exception from class Tablero.
	 */
	
	public JuegoCrush(int size, int boardColors) throws JuegoCrushException {
		try {
			this.tablero = new Tablero(size, boardColors);
		} catch (JuegoCrushException msg) {
			System.out.println(msg.getMessage());
		}	
	}
	
	/**
	 * 
	 * Creates a predefined board with 3 colors and 5x5 dimension.
	 * 
	 */
	
	public JuegoCrush() {
		this.tablero = new Tablero();
	}
	
	/**
	 * 
	 * This method shoots the box which has been chosen by the user.
	 * As long as you can shoot the box.
	 * 
	 * @param row The row the method will shoot at.
	 * @param column The column the method will shoot at.
	 * @throws CandyCleanException An exception that will be returned if the 
	 * user enters a row or a column which is not valid.
	 */
	
	public void shootBox(int row, int column) throws JuegoCrushException {
		int bounds = this.tablero.getDimensions() - 1;
		if (row >= 0 && column >= 0) {
			if (row < this.tablero.getDimensions() && column < this.tablero.getDimensions()) {
				this.tablero.shootColor(row, column);
				this.tablero.stackEmptyBoxesAbove();
			} else {
				logger.error("The user has entered an invalid number = Row:"+row+" and Column:"+column);
				throw new JuegoCrushException("Invalid number: Enter a valid number between 0 and " + bounds);
			}
		} else {
			logger.error("The user has entered an invalid number = Row:"+row+" and Column:"+column);
			throw new JuegoCrushException("Invalid number: Enter a valid number between 0 and " + bounds);
		}
	}
	
	/**
	 * 
	 * This method returns if the game is finished or not.
	 * 
	 * @return If the boxes of the board are all black or not. 
	 */
	
	public boolean isGameFinished() {
		return tablero.isBoardEmpty();
	}
	
	/**
	 * 
	 * This method returns if you lost the game when there are no more 
	 * possible combinations
	 * 
	 * @return Whether you have lost or not
	 */
	
	public boolean isGameLost() {
		return tablero.shootNotPossible();
	}
	
	/**
	 * 
	 * Converts the game into a String.
	 * 
	 * @return The game as a String.
	 */
	
	public String toString() {
		return this.tablero.toString();
	}
}