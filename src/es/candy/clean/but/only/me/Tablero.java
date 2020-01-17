package es.candy.clean.but.only.me;

import org.apache.logging.log4j.*;

/**
*	Class that creates a board and interacts with it.
*	The class modifies the board erasing the boxes of the same color in
*	the same line on the right and the left.
*	When the boxes are erased, they are stacked at the top and when the
*	game is finished, it returns a boolean that states that.
*
*  	@version 1.0
*  	@author Alejandro Carballo Casas
*/

public class Tablero {
	
	static final Logger logger = LogManager.getLogger(Tablero.class);
	
	/**
	 * 
	 * Array that stores the board of the game
	 * 
	 */
	private Casilla[][] tablero;
	
	/**
	 * Boolean that checks if the boxes has been erased
	 */
	private boolean erasedBox;
	
	/**
	 * 
	 * Creates a board with 3 colors and dimension 5x5
	 * 
	 */
	public Tablero() {
		this.tablero = new Casilla[5][5];
		for (int b = 0; b <= 4; b++) {
	       	tablero[0][b] = new Casilla('r');
	       	tablero[2][b] = new Casilla('b');
	       	for (int c = 0; c <= 1; c++) {
	       		tablero[1][c] = new Casilla('b');
	       		tablero[3][c] = new Casilla('g');
	       		tablero[4][c] = new Casilla('b');
	        }
	       	for (int c = 2; c <= 4; c++) {
	       		tablero[1][c] = new Casilla('r');
	       		tablero[3][c] = new Casilla('b');
	       		tablero[4][c] = new Casilla('g');
	       	}
		}
	}
	
	/**
	 * Creates a board with the colors and dimensions entered by the user
	 * @param size Dimensions entered by the user
	 * @param boardColors Colors entered by the user
	 * @throws CandyCleanException Exception thrown when invalid number are entered
	 * 
	 */
	public Tablero(int size, int boardColors) throws JuegoCrushException {
		if (size < 5) {
			logger.error("Contructor Exception: Entered size value lower than 5");
			throw new JuegoCrushException("Invalid value. Value must be higher or equal to 5");
		} else {
			if (size > 30) {
				logger.error("Constructor Exception: Entered size value higher than 30");
				throw new JuegoCrushException("Invalid value. Value must be lower or equal to 30");
			} else {
				if (boardColors < 3 && boardColors > 7) {
					logger.error("Constructor Exception: Entered color value higher than 7 or lower than 2");
					throw new JuegoCrushException("Invalid value. Value must lower than 7 or higher than 2");
				} else {
					this.tablero = new Casilla[size][size];
				    for (int i=0; i < size; i++) {
				        for (int j=0; j < size; j++) {
				        	this.tablero[i][j] = new Casilla(boardColors);
				        }
			        }
			    }
			}
		}
	}

	/**
	 * 
	 * Gets the board dimension
	 * @return board dimension
	 * 
	 */
	public int getDimensions() {
		return this.tablero.length;
	}
	
	/**
	 * Compares colors on the left or the right 
	 * @param rowInput Row entered by the user to shoot at
	 * @param origColumn Column entered by the user to shoot at
	 * @param compareColumn Column that will be compared (entered by shootColorLeft()
	 * and shootColorRight())
	 * @return true if the colors are the same
	 * 
	 */
	public boolean isSameColor(int rowInput, int origColumn, int compareColumn) {
		boolean isSameColor = false;
		if (rowInput >= 0 && origColumn >= 0) {
			if (rowInput < this.tablero.length && origColumn < this.tablero.length) {
				if (compareColumn >= 0 && compareColumn < this.tablero.length) {
					if (!this.tablero[rowInput][origColumn].isEmpty()) {
						if (this.tablero[rowInput][origColumn].equals(this.tablero[rowInput][compareColumn])) {
							isSameColor = true;
						}
					}
				}
			}
		}
		return isSameColor;
	}
	
	/**
	 * If the color at the right is the same as the one in the box the user selected,
	 * it will be removed (the box turns black) 
	 * @param rowInput Row entered by the user to shoot at
	 * @param columnInput Column entered by the user to shoot at
	 * 
	 */
	public void shootRightColor(int rowInput, int columnInput) {
		int column = columnInput;
		columnInput++;
		boolean isSameColor = isSameColor(rowInput, column, columnInput);
		while (columnInput < this.tablero.length && isSameColor) {
			this.tablero[rowInput][columnInput].removeBox();
			columnInput++;
			isSameColor = isSameColor(rowInput, column, columnInput);
			this.erasedBox = true;
        }
	}
	
	/**
	 * If the color at the left is the same as the one in the box the user selected,
	 * it will be removed (the box turns black)
	 * @param rowInput Row entered by the user to shoot at
	 * @param columnInput Column entered by the user to shoot at
	 * 
	 */
	public void shootLeftColor(int rowInput, int columnInput) {
		int column = columnInput;
		columnInput--;
		boolean isSameColor = isSameColor(rowInput, column, columnInput);
		while (columnInput >= 0 && isSameColor) {
			this.tablero[rowInput][columnInput].removeBox();
			columnInput--;
			isSameColor = isSameColor(rowInput, column, columnInput);
			this.erasedBox = true;
        }
	}
	
	/**
	 * Shoots the selected box (the box turns black)
	 * @param rowInput Row entered by the user to shoot at
	 * @param columnInput Column entered by the user to shoot at
	 * 
	 */
	public void shootColor(int rowInput, int columnInput) {
		shootRightColor(rowInput, columnInput);
		shootLeftColor(rowInput, columnInput);
		if (this.erasedBox) {
			if (columnInput<this.tablero.length && rowInput<this.tablero.length && columnInput>=0) {
				this.tablero[rowInput][columnInput].removeBox();
				this.erasedBox = false;
			}
			
		}
	}
	
	/**
	 * 
	 * Checks if the board is filled with black boxes
	 * @return whether the board is empty or not
	 * 
	 */
	public boolean isBoardEmpty() {
		Casilla empty = new Casilla();
		boolean isEmpty = true;
	    for (int i = 0; i < this.tablero.length; i++) {
	    	for (int j = 0; j < this.tablero.length; j++) {
	    		if (!empty.equals(this.tablero[i][j])) {
	    			isEmpty = false;
	    		}
	    	}
	    }
	    return isEmpty;
	}
	
	/**
	 * 
	 * Checks if the board has any possible combinations
	 * @return whether the board have more possible combinations or not
	 * 
	 */
	public boolean shootNotPossible() {
		Casilla empty = new Casilla();
		boolean isNotPossible = true;
	    for (int i = 0; i < this.tablero.length; i++) {
	    	for (int j = 0; j < this.tablero.length; j++) {
	    		if (j+1 < this.tablero.length && !this.tablero[i][j].equals(empty)) {
	    			if (this.tablero[i][j].equals(this.tablero[i][j+1]) && isNotPossible) {
	    				isNotPossible = false;
	    			}
	    		}
	    	}
	    }
	    if(isBoardEmpty()) {
	    	isNotPossible = false;
	    }
	    return isNotPossible;
	}
	
	/**
	 * 
	 * Stacks the empty boxes at the top of the board
	 * 
	 */
	public void stackEmptyBoxesAbove() {
		Casilla empty = new Casilla();
		Casilla[][] tableroAux = new Casilla[this.tablero.length][this.tablero.length];
	    for (int i = 0; i < this.tablero.length; i++) {
	    	for (int j = 0; j < this.tablero.length; j++) {
	    		tableroAux[i][j] = this.tablero[i][j];
	    	}
	    }
	    for (int i = 0; i < this.tablero.length; i++) {
	    	for (int j = 0; j < this.tablero.length; j++) {
	    		if (this.tablero[i][j].equals(empty)) {
	    			int k = i;
	    			int l = j;
	    			while (k-1>=0 && l>=0) {
	    				tableroAux[k][l] = this.tablero[k][l];
	    				tablero[k][l] = this.tablero[k-1][l];
	    				tablero[k-1][l] = tableroAux[k][l];
	   					k--;
	   				}
	    		}
	    	}
	    }
	}
	
	/**
	 * 
	 * Converts the board into a String
	 * @return board as a String
	 * 
	 */
	public String toString() {
		StringBuilder out = new StringBuilder();
		int k = 0;
		out.append("  ");
    	while (k < this.tablero.length) {
    		out.append(k++ +" ");
    	}
    	out.append("\n");
		for (int i=0; i < this.tablero.length; i++) {
	        for (int j=0; j < this.tablero.length; j++) {
	        	if (j == 0) {
	        		out.append(i+" ");
	        	}
	        	out.append(this.tablero[i][j]);
	        	if (j==this.tablero.length-1) {
	        		out.append("\n");
	        	}
	        }
	    }
		return out.toString();
	}
}