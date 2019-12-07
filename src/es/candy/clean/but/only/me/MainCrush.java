package es.candy.clean.but.only.me;

public class MainCrush {
	public static void main(String[] args) {
		Tablero tablero = new Tablero();
		JuegoCrush game = new JuegoCrush();
		Casilla box = new Casilla();
		
		System.out.println("Test code: Choose an option:\n1.-Test Functionality\n2.-Execute the program\n3.-");
		int readOption = Teclado.readInteger();
		 if (readOption==1) {	//Test functionality
			System.out.println("Board Size:");
			int readSize = Teclado.readInteger();
			tablero.setSize(readSize);
			game.setSize(readSize);
			
			tablero.printRandomBoard();
			game.colorTest();
		 }
		 if (readOption==2) {	//Execute the program
			System.out.println("Board Size:");
			int readSize = Teclado.readInteger();
			game.setSize(readSize);
			tablero.setSize(readSize);
			System.out.println(tablero.getArray().length);
			tablero.setBoardColors(5);
			game.setBoardColors(5);
			tablero.printRandomBoard();
			while (game.isGameFinished()==false) {
				System.out.println("Row:\n");
				int readRow = Teclado.readInteger();
				System.out.println("Column:\n");
				int readColumn = Teclado.readInteger();
				box.compareRightColor(tablero.getArray(), readRow, readColumn);
				box.compareLeftColor(tablero.getArray(), readRow, readColumn);
				box.compareBottomColor(tablero.getArray(), readRow, readColumn);
				box.compareTopColor(tablero.getArray(), readRow, readColumn);
				System.out.print("Row input:"+readRow+"   Column input:"+readColumn+"\n");	//test - Remove
				System.out.print("ArrayLength:"+tablero.getArrayLength());					//test - Remove
				tablero.printBoardAgain(tablero.getArray());
			}
		 }
		 if (readOption==3) {
			 
		 }
		 if (readOption!=1&&readOption!=2&&readOption!=3) {
			 System.out.println("Invalid option. Closing program");
		 }
		

	}

}
