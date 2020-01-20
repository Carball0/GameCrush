package es.candy.clean.but.only.me;

import org.apache.logging.log4j.*;

/**
 * Class that creates the game with the parameters 
 * introduced by the user.
 * This class calls Board methods for erasing boxes
 * It also return when the game has finished.
 * 
 * @version 1.0
 * @author Alejandro Carballo Casas
 */

public class GameCrush {
	
	static final Logger logger = LogManager.getLogger(GameCrush.class);

	/**
	 * 
	 * Board of the game that is ran.
	 * 
	 */
	
	private Board board;
								
	/**
	 * 
	 * Creates a game with a board predefined if size is 5 
	 * and boardColor is 3, else it creates a random board. 
	 * 
	 * @param size Dimensions of the board.
	 * @param boardColors Number of colors that the board has. 
	 * @throws CandyCleanException Receives an exception from class Board.
	 */
	
	public GameCrush(int size, int boardColors) throws GameCrushException {
		try {
			this.board = new Board(size, boardColors);
		} catch (GameCrushException msg) {
			System.out.println(msg.getMessage());
		}	
	}
	
	/**
	 * 
	 * Creates a predefined board with 3 colors and 5x5 dimension.
	 * 
	 */
	
	public GameCrush() {
		this.board = new Board();
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
	
	public void shootBox(int row, int column) throws GameCrushException {
		int bounds = this.board.getDimensions() - 1;
		if (row >= 0 && column >= 0) {
			if (row < this.board.getDimensions() && column < this.board.getDimensions()) {
				this.board.shootColor(row, column);
				this.board.stackEmptyBoxesAbove();
			} else {
				logger.error("The user has entered an invalid number = Row:"+row+" and Column:"+column);
				throw new GameCrushException("Invalid number: Enter a valid number between 0 and " + bounds);
			}
		} else {
			logger.error("The user has entered an invalid number = Row:"+row+" and Column:"+column);
			throw new GameCrushException("Invalid number: Enter a valid number between 0 and " + bounds);
		}
	}
	
	/**
	 * 
	 * This method returns if the game is finished or not.
	 * 
	 * @return If the boxes of the board are all black or not. 
	 */
	
	public boolean isGameFinished() {
		return board.isBoardEmpty();
	}
	
	/**
	 * 
	 * This method returns if you lost the game when there are no more 
	 * possible combinations
	 * 
	 * @return Whether you have lost or not
	 */
	
	public boolean isGameLost() {
		return board.shootNotPossible();
	}
	
	/**
	 * 
	 * Converts the game into a String.
	 * 
	 * @return The game as a String.
	 */
	
	public String toString() {
		return this.board.toString();
	}
}