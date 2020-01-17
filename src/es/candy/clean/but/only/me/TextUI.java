package es.candy.clean.but.only.me;

import org.apache.logging.log4j.*;

/**
 * Class for the user interface of the game
 * @author Alejandro Carballo Casas
 *
 */

public class TextUI {
	
	static final Logger logger = LogManager.getLogger(Tablero.class);
	
	/**
	 * Is an object of type CandyClean that gets the parameters to start the game.
	 */
	private JuegoCrush game;
	
	/**
	 *  
	 * @param game. This parameter is type CandyClean and start the game with the Main.
	 * 
	 */
	
	public TextUI(JuegoCrush game) {
		this.game = game;
	}
	
	/**
	 * This method starts the game with the parameters that you have chosen.
	 */
	
	public void start() {
		logger.trace("Initial board: \n"+ game.toString());
		while(!this.game.isGameFinished() && !this.game.isGameLost()) {
			System.out.println(this.game.toString());
			System.out.println("Row:");
			int row= Teclado.readInteger();
			System.out.println("Column:");
			int column = Teclado.readInteger();
			logger.trace("User Input: Row:"+ row +" and Column:"+ column);
			try {
                this.game.shootBox(row,column);
            } catch (JuegoCrushException err) {
            	System.out.println(err.getMessage());
            }
		}
		if (this.game.isGameLost()) {
			logger.trace("Game lost (no more possible combinations)");
			System.out.println(this.game.toString());
			System.out.println("You lose!");
		}
		
		if (this.game.isGameFinished()) {
			logger.trace("Game won (all the board is empty)");
			System.out.println(this.game.toString());
			System.out.println("You won!");
		}
	}
}
