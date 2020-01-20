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

public class Board {
	
	static final Logger logger = LogManager.getLogger(Board.class);
	
	/**
	 * 
	 * Array that stores the board of the game
	 * 
	 */
	private Box[][] board;
	
	/**
	 * Boolean that checks if any right boxes has been erased
	 */
	private boolean erasedBoxRight;
	
	/**
	 * Boolean that checks if any right boxes has been erased
	 */
	private boolean erasedBoxLeft;
	
	/**
	 * 
	 * Creates a board with 3 colors and dimension 5x5
	 * 
	 */
	public Board() {
		this.board = new Box[5][5];
		for (int b = 0; b <= 4; b++) {
	       	board[0][b] = new Box('r');
	       	board[2][b] = new Box('b');
	       	for (int c = 0; c <= 1; c++) {
	       		board[1][c] = new Box('b');
	       		board[3][c] = new Box('g');
	       		board[4][c] = new Box('b');
	        }
	       	for (int c = 2; c <= 4; c++) {
	       		board[1][c] = new Box('r');
	       		board[3][c] = new Box('b');
	       		board[4][c] = new Box('g');
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
	public Board(int size, int boardColors) throws GameCrushException {
		if (size < 5) {
			logger.error("Contructor Exception: Entered size value lower than 5");
			throw new GameCrushException("Invalid value. Value must be higher or equal to 5");
		} else {
			if (size > 30) {
				logger.error("Constructor Exception: Entered size value higher than 30");
				throw new GameCrushException("Invalid value. Value must be lower or equal to 30");
			} else {
				if (boardColors < 3 && boardColors > 7) {
					logger.error("Constructor Exception: Entered color value higher than 7 or lower than 2");
					throw new GameCrushException("Invalid value. Value must lower than 7 or higher than 2");
				} else {
					this.board = new Box[size][size];
				    for (int i=0; i < size; i++) {
				        for (int j=0; j < size; j++) {
				        	this.board[i][j] = new Box(boardColors);
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
		return this.board.length;
	}
	
	/**
	 * Compares colors on the left or the right 
	 * @param rowInput Row entered by the user to shoot at
	 * @param origColumn Column entered by the user to shoot at
	 * @param compareCol Column that will be compared (entered by shootColor()
	 * methods
	 * @return true if the colors are the same
	 * 
	 */
	public boolean isSameColorColumn(int rowInput, int origColumn, int compareCol) {
		boolean isSameColor = false;
		if (rowInput >= 0 && origColumn >= 0) {
			if (rowInput < this.board.length && origColumn < this.board.length) {
				if (compareCol>= 0 && compareCol < this.board.length) {
					if (!this.board[rowInput][origColumn].isEmpty()) {
						if (this.board[rowInput][origColumn].equals(this.board[rowInput][compareCol])) {
							isSameColor = true;
						}
					}
				}
			}
		}
		return isSameColor;
	}
	
	/**
	 * Compares colors on the left or the right 
	 * @param origRow Row entered by the user to shoot at
	 * @param columnInput Column entered by the user to shoot at
	 * @param compareRow Row that will be compared (entered by shootColor()
	 * methods
	 * @return true if the colors are the same
	 * 
	 */
	public boolean isSameColorRow(int origRow, int columnInput, int compareRow) {
		boolean isSameColor = false;
		if (origRow >= 0 && columnInput >= 0) {
			if (origRow < this.board.length && columnInput < this.board.length) {
				if (compareRow >= 0 && compareRow < this.board.length) {
					if (!this.board[origRow][columnInput].isEmpty()) {
						if (this.board[origRow][columnInput].equals(this.board[compareRow][columnInput])) {
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
		boolean isSameColor = isSameColorColumn(rowInput, column, columnInput);
		while (columnInput < this.board.length && isSameColor) {
			this.board[rowInput][columnInput].removeBox();
			columnInput++;
			isSameColor = isSameColorColumn(rowInput, column, columnInput);
			this.erasedBoxRight = true;
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
		boolean isSameColor = isSameColorColumn(rowInput, column, columnInput);
		while (columnInput >= 0 && isSameColor) {
			this.board[rowInput][columnInput].removeBox();
			columnInput--;
			isSameColor = isSameColorColumn(rowInput, column, columnInput);
			this.erasedBoxLeft = true;
        }
	}
	
	/**
	 * 
	 * If the color above is the same as the one in the box the user selected,
	 * it will be removed (the box turns black)
	 * The method will only remove one line of boxes above (it won't continue
	 * if there are more boxes above of the same color)
	 * @param rowInput Row entered by the user to shoot at
	 * @param columnInput Column entered by the user to shoot at
	 * 
	 */
	public void shootAboveColor(int rowInput, int columnInput) {
		int row = rowInput;
		rowInput--;
		boolean isSameColor = isSameColorRow(row, columnInput, rowInput);
		if (rowInput >= 0 && isSameColor) {
			shootRightColor(rowInput, columnInput);
			shootLeftColor(rowInput, columnInput);
			if (this.erasedBoxLeft || this.erasedBoxRight) {
				this.board[rowInput][columnInput].removeBox();
			}
        }
	}
	
	/**
	 * 
	 * If the color below is the same as the one in the box the user selected,
	 * it will be removed (the box turns black)
	 * The method will only remove one line of boxes below (it won't continue
	 * if there are more boxes below of the same color)
	 * @param rowInput Row entered by the user to shoot at
	 * @param columnInput Column entered by the user to shoot at
	 * 
	 */
	public void shootBelowColor(int rowInput, int columnInput) {
		int row = rowInput;
		rowInput++;
		boolean isSameColor = isSameColorRow(row, columnInput, rowInput);
		if (rowInput >= 0 && isSameColor) {
			shootRightColor(rowInput, columnInput);
			shootLeftColor(rowInput, columnInput);
			if (this.erasedBoxLeft || this.erasedBoxRight) {
				this.board[rowInput][columnInput].removeBox();
			}
        }
	}
	
	/**
	 * Resets variables erasedBoxLeft and erasedBoxRight
	 * 
	 */
	private void resetVar() {
		this.erasedBoxLeft = false;
		this.erasedBoxRight = false;
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
		boolean shotLeftRight = false;
		if (erasedBoxLeft || erasedBoxRight) {
			shotLeftRight = true;
		}
		resetVar();									//Reset vars so the following method does not have wrong info from them
		if (shotLeftRight) {
			shootAboveColor(rowInput, columnInput);
		}
		resetVar();									//Reset vars so the following method does not have wrong info from them
		if (shotLeftRight) {
			shootBelowColor(rowInput, columnInput);
		}
		if (shotLeftRight) {
			if (columnInput<this.board.length && rowInput<this.board.length && columnInput>=0) {
				this.board[rowInput][columnInput].removeBox();
				resetVar();							//Reset vars for the next execution
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
		Box empty = new Box();
		boolean isEmpty = true;
	    for (int i = 0; i < this.board.length; i++) {
	    	for (int j = 0; j < this.board.length; j++) {
	    		if (!empty.equals(this.board[i][j])) {
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
		Box empty = new Box();
		boolean isNotPossible = true;
	    for (int i = 0; i < this.board.length; i++) {
	    	for (int j = 0; j < this.board.length; j++) {
	    		if (j+1 < this.board.length && !this.board[i][j].equals(empty)) {
	    			if (this.board[i][j].equals(this.board[i][j+1]) && isNotPossible) {
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
		Box empty = new Box();
		Box[][] boardAux = new Box[this.board.length][this.board.length];
	    for (int i = 0; i < this.board.length; i++) {
	    	for (int j = 0; j < this.board.length; j++) {
	    		boardAux[i][j] = this.board[i][j];
	    	}
	    }
	    for (int i = 0; i < this.board.length; i++) {
	    	for (int j = 0; j < this.board.length; j++) {
	    		if (this.board[i][j].equals(empty)) {
	    			int k = i;
	    			int l = j;
	    			while (k-1>=0 && l>=0) {
	    				boardAux[k][l] = this.board[k][l];
	    				board[k][l] = this.board[k-1][l];
	    				board[k-1][l] = boardAux[k][l];
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
    	while (k < this.board.length) {
    		out.append(k++ +" ");
    	}
    	out.append("\n");
		for (int i=0; i < this.board.length; i++) {
	        for (int j=0; j < this.board.length; j++) {
	        	if (j == 0) {
	        		if (i >= 10) {
	        			out.append(i);
	        		} else {
	        			out.append(i+" ");
	        		}
	        	}
	        	out.append(this.board[i][j]);
	        	if (j==this.board.length-1) {
	        		out.append("\n");
	        	}
	        }
	    }
		return out.toString();
	}
}