package es.candy.clean.but.only.me;

import java.io.IOException;

import org.apache.logging.log4j.*;

/**
 * Class for the user interface of the game
 * @author Alejandro Carballo Casas
 *
 */

public class TextUI {
	
	static final Logger logger = LogManager.getLogger(Board.class);
	
	/**
	 * Is an object of type CandyClean that gets the parameters to start the game
	 */
	private GameCrush game;
	
	/**
	 *  
	 * @param game. This parameter is type CandyClean and start the game with the Main
	 * 
	 */
	
	public TextUI(GameCrush game) {
		this.game = game;
	}
	
	/**
	 * This method gives the user a menu to interact with
	 * @throws IOException 
	 */
	public void menu() throws GameCrushException {
		System.out.print("Welcome to: \n"
				+ "   ______                     ______                __  \r\n" + 
				"  / ____/___ _____ ___  ___  / ____/______  _______/ /_ \r\n" + 
				" / / __/ __ `/ __ `__ \\/ _ \\/ /   / ___/ / / / ___/ __ \\\r\n" + 
				"/ /_/ / /_/ / / / / / /  __/ /___/ /  / /_/ (__  ) / / /\r\n" + 
				"\\____/\\__,_/_/ /_/ /_/\\___/\\____/_/   \\__,_/____/_/ /_/ \r\n");
		System.out.print("Choose an option: \n"
				+"1.- Read the instructions for the game\n"
				+"2.- Play the game with default parameters (Board dimension: 5x5; 3 colors)\n\n");
		int input = Teclado.readInteger();
		if (input > 2 || input < 1) {
			logger.debug("Player introduced and invalid number: " + input);
			throw new GameCrushException("Invalid input, introduce 1 or 2");
		} else {
			if (input == 1) {
			    System.out.print("Welcome to: \n"
						+ "   ______                     ______                __  \r\n" + 
						"  / ____/___ _____ ___  ___  / ____/______  _______/ /_ \r\n" + 
						" / / __/ __ `/ __ `__ \\/ _ \\/ /   / ___/ / / / ___/ __ \\\r\n" + 
						"/ /_/ / /_/ / / / / / /  __/ /___/ /  / /_/ (__  ) / / /\r\n" + 
						"\\____/\\__,_/_/ /_/ /_/\\___/\\____/_/   \\__,_/____/_/ /_/ \r\n");
			    System.out.print("Intructions for the game: \n"
			    		+ "\nThis is a simple game based on a board that contains colors, and the goal is to clear the board matching boxes of the same color.\n"
			    		+ "The game works like this:\n"
			    		+ "You will be provided with a board filled with boxes of different colors. The game will ask you for a row and a column value, which will be the parameters used to choose or shoot the boxes\n"
			    		+ "When you select a box with those parameters, the game will check if there are matching colors at the left and the right. If they are the same, this boxes will turn to black\n"
			    		+ "Also, when you select a box the game will also check for matching colors at the nearest row. If you have a matching color above or below, that row will be deleted along with the boxes of the same color that you have at the left or right\n"
			    		+ "!!Note that only the nearest row will be erased. If there are more matching colors on other rows below, those won't turn to black!!\n"
			    		+ "When they are selected and deleted, they will go at the top of the board\n\n"
			    		+ "The goal is to have a board entirely made out of black boxes, which will mean that you have won. If there are no more possible combinations and the board is not empty (all black), you wil lost\n\n"
			    		+ "This game have a logger, which means that your activity on the game will be logged to a file so you can rerun the game with the same parameters that the user used in the last execution\n"
			    		+ "Remember that you can only use numbers to shoot boxes and the must be inside of the board. If the program does not receive a integer number or an invalid one, it will return an error\n\n"
			    		+ "This is all you need to know to run the game, good luck! :)\n\n\n"
			    		+ "Press enter to run the game\n");
			    @SuppressWarnings("unused")
				String str = Teclado.readString();
			    start();
			}
			if (input == 2) {
				start();
			}
		}
		
	}
	
	/**
	 * This method starts the game with the parameters given by the user
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
            } catch (GameCrushException err) {
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
