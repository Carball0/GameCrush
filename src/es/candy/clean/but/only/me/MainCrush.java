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

public class MainCrush {
	static final Logger logger = LogManager.getLogger(MainCrush.class);
	
	public static void main(String[] args) {
		
		JuegoCrush game = new JuegoCrush();
		
		int dimensions = Integer.parseInt(args[0]);
		int numColors = Integer.parseInt(args[1]);
		
			try {
				game = new JuegoCrush(dimensions, numColors);
			} catch (JuegoCrushException err) {
				System.out.println(err.getMessage());
			}
			
			TextUI ui = new TextUI(game);
			logger.trace("Game starts");
			ui.start();	
	  }
}