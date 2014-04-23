package test;

import static org.junit.Assert.*;
import junit.framework.Assert;
import main.BadConfigFormatException;
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
	
	@Test
	public void testMove() {
		Searcher s = new Searcher();
		NormalCell cell = new NormalCell(0, 0);
		
		//test for redirecting the team when it hits a wall
		s.setDirection(180.0);
		s.setIndex(cell);
		s.setSpeed(3.0);
		testing.move(s);
		assertTrue(s.getIndex().getRow() >= 0);
		assertTrue(s.getIndex().getRow() <= s.getSpeed());
		assertTrue(s.getIndex().getCol() <= s.getSpeed());
		assertTrue(s.getIndex().getCol() >= 0);
		
		//test for a normal move
		s.setDirection(270);
		s.setIndex(new NormalCell(0, 0));
		s.setSpeed(2.0);
		testing.move(s);
		NormalCell testCell = new NormalCell(2, 0);
		assertTrue(s.getIndex().equals(testCell));
		
		//test for excessive speed
		s.setDirection(315);
		s.setIndex(new NormalCell(0, 0));
		s.setSpeed(1000.0); //can input any speed, move will stay in grid
		testing.move(s);
		assertTrue(s.getIndex().getRow() >= 0);
		assertTrue(s.getIndex().getRow() < Grid.MAX_ROW);
		assertTrue(s.getIndex().getCol() < Grid.MAX_COL);
		assertTrue(s.getIndex().getCol() >= 0);
	}
	
}
