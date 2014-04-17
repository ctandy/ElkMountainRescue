package test;

import static org.junit.Assert.*;
import junit.framework.Assert;
import main.BadConfigFormatException;
import main.Grid;
import main.Rescue;

import org.junit.Before;
import org.junit.Test;

public class GridTest {
	private Grid testing;
	
	@Before
	public void initialize() throws BadConfigFormatException {
		testing = new Grid();
		// MAX_ROW set to 5 in loadConfigFiles
		// MAX_COL set to 4 in loadConfigFiles
	}
	
	@Test
	public void testConstructor() {
		assertTrue(Grid.MAX_ROW == 5);
		assertTrue(Grid.MAX_COL == 4);
	}
	
	@Test
	public void testInitializeCells() {
		assertTrue(testing.getCells().size() == 20);
	}
	
	@Test
	public void testCalcIndex() {
		int expected = 19;
		int actual = testing.calcIndex(4, 3);
		assertEquals(expected, actual);
		expected = 3;
		actual = testing.calcIndex(0, 3);
		assertEquals(expected, actual);
	}
}
