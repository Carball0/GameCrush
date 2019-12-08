package es.candy.clean.but.only.me;

public class MainCrush {
	public static void main(String[] args) {
		Tablero tablero = new Tablero();
		JuegoCrush game = new JuegoCrush();
		Casilla box = new Casilla();
		
		System.out.println("Test code: Choose an option:\n1.-Test Functionality\n2.-Execute the program");
		int readOption = Teclado.readInteger();
		 if (readOption==1) {	//Test functionality
			System.out.println("Board Size:");
			int readSize = Teclado.readInteger();
			tablero.setArraySize(readSize);
			game.setSize(readSize);
			
			tablero.printRandomBoard();
			game.colorTest();
		 }
		 if (readOption==2) {	//Execute the program
			System.out.println("Board Size:");
			int readSize = Teclado.readInteger();
			game.setSize(readSize);
			tablero.setArraySize(readSize);
			System.out.println(tablero.getArray().length);
			tablero.setBoardColors(3);
			game.setBoardColors(3);
			tablero.printRandomBoard();
			while (game.isGameFinished()==false) {
				System.out.println("Row:\n");
				int readRow = Teclado.readInteger();
				System.out.println("Column:\n");
				int readColumn = Teclado.readInteger();
				box.compareRightColor(tablero.getArray(), readRow, readColumn);
				box.compareLeftColor(tablero.getArray(), readRow, readColumn);
				//box.compareBottomColor(tablero.getArray(), readRow, readColumn);
				//box.compareTopColor(tablero.getArray(), readRow, readColumn);
				System.out.print("\nRow input:"+readRow+"   Column input:"+readColumn+"\n");	//test - Remove
				System.out.println("ArrayLength:"+tablero.getArrayLength());					//test - Remove
				System.out.println("Selected:" +tablero.getArray()[readRow][readColumn]);		//test - Remove
				//System.out.println("Right +1 :" +tablero.getArray()[readRow+1][readColumn]);	//test - Remove
				//System.out.println("Left -1:" +tablero.getArray()[readRow-1][readColumn]);	//test - Remove
				tablero.printBoardAgain(tablero.getArray());
			}
		 }
		 if (readOption!=1&&readOption!=2) {
			 System.out.println("Invalid option. Closing program");
		 }

	}

}
