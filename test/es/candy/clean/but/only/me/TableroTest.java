package es.candy.clean.but.only.me;

import static org.junit.Assert.*;

import org.junit.Test;

public class TableroTest {

	@Test
	public void testSetGetArraySize() {
		Tablero tablero = new Tablero();
		tablero.setArraySize(4);
		assertEquals(4, tablero.getArraySize());
	}

	@Test
	public void testSetGetBoardColors() {
		Tablero tablero = new Tablero();
		tablero.setBoardColors(3);
		assertEquals(3, tablero.getBoardColors());
	}

	@Test
	public void testSetArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetArrayLength() {
		fail("Not yet implemented");
	}

	@Test
	public void testPrintRandomBoard() {
		fail("Not yet implemented");
	}

	@Test
	public void testPrintBoardAgain() {
		fail("Not yet implemented");
	}

}
