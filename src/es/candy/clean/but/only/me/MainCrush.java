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
			tablero.setBoardColors(2);
			game.setBoardColors(2);
			tablero.printRandomBoard();
			while (game.isGameFinished()==false) {
				System.out.println("Row:\n");
				int readRow = Teclado.readInteger();
				System.out.println("Column:\n");
				int readColumn = Teclado.readInteger();
				Color[][] tableroaux1 = box.compareRightColor(tablero.getArray(), readRow, readColumn);
				Color[][] tableroaux2 = box.compareLeftColor(tableroaux1, readRow, readColumn);
				System.out.print("\nRow input:"+readRow+"  Column input:"+readColumn+"\n");		//test - Remove
				System.out.println("ArrayLength:"+tableroaux2.length);					//test - Remove
				System.out.println("Selected:" +tableroaux2[readRow][readColumn]);		//test - Remove
				//System.out.println("Right +1 :" +tablero.getArray()[readRow][readColumn+1]);	//test - Remove
				//System.out.println("Left -1:" +tablero.getArray()[readRow][readColumn-1]);	//test - Remove
				tablero.printBoardAgain(tableroaux2);
			}
		 }
		 if (readOption!=1 && readOption!=2) {
			 System.out.println("Invalid option. Closing program");
		 }

	}

}
