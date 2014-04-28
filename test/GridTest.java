package test;

import static org.junit.Assert.*;
import junit.framework.Assert;
import main.BadConfigFormatException;
import main.Cell;
import main.Grid;
import main.Hiker;
import main.NormalCell;
import main.Searcher;

import org.junit.Before;
import org.junit.Test;

public class GridTest {
	private Grid testing;
	
	@Before
	public void initialize() throws BadConfigFormatException {
		testing = new Grid();
	}
	
	@Test
	public void testConstructor() {
		assertTrue(Grid.MAX_ROW == 32);// 512 pixels / 16
		assertTrue(Grid.MAX_COL == 48);// 768 pixels / 16
		assertTrue(testing.getSearchers() != null);
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
	
	@Test
	public void testAddSearcher() {
		Searcher s = new Searcher();
		testing.addSearcher(s);
		assertTrue(testing.getSearchers().size() == 1);
	}
	
	
	
	
}
