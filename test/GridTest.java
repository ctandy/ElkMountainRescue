package test;

import static org.junit.Assert.*;
import junit.framework.Assert;
import main.BadConfigFormatException;
import main.Grid;

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
		assertTrue(Grid.MAX_ROW == 32);// 687 pixels / 16
		assertTrue(Grid.MAX_COL == 48);// 889 pixels / 16
	}
	
	@Test
	public void testInitializeCells() {
		assertTrue(testing.getCells().size() == 1536);
	}
	
	@Test
	public void testCalcIndex() {
		int expected = 195;
		int actual = testing.calcIndex(4, 3);
		assertEquals(expected, actual);
		expected = 3;
		actual = testing.calcIndex(0, 3);
		assertEquals(expected, actual);
	}
}
