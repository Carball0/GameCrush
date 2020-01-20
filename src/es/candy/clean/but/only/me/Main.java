package es.candy.clean.but.only.me;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * Main class that checks the parameters and start the application
 * 
 * @author Alejandro Carballo Casas
 *
 */

public class Main {
	static final Logger logger = LogManager.getLogger(Main.class);
	
	public static void main(String[] args) {
		GameCrush game = new GameCrush();
		
		int dimensions = Integer.parseInt(args[0]);
		int numColors = Integer.parseInt(args[1]);
		
		try {
			game = new GameCrush(dimensions, numColors);
		} catch (GameCrushException err) {
			System.out.println(err.getMessage());
		}
		
		TextUI ui = new TextUI(game);
		logger.trace("Game starts");
		
		try {
			ui.menu();
		} catch (GameCrushException err) {
			System.out.println(err.getMessage());
		}
	  }
}