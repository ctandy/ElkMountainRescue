package test;

import static org.junit.Assert.*;
import main.BadConfigFormatException;
import main.NormalCell;
import main.Rescue;
import main.Searcher;

import org.junit.Before;
import org.junit.Test;

public class RescueTest {
	Rescue res;
	
	@Before
	public void setup() throws BadConfigFormatException{
		res = new Rescue();
	}
	@Test
	public void testConstructor() {
		assertTrue(res.getGrid() != null);
		assertTrue(res.getSearchers() != null);
	}
	
	@Test
	public void testAddSearcher() {
		Searcher s = new Searcher();
		res.addSearcher(s);
		assertTrue(res.getSearchers().size() == 1);
	}
	
	@Test
	public void testMove() {//MAX_Row = 5 and Max_Col = 4 by the Grid class
		Searcher s = new Searcher();
		NormalCell cell = new NormalCell(0, 3);
		s.setDirection(0.0);
		s.setIndex(cell);
		s.setSpeed(3.0);
		res.move(s);
		assertTrue(s.getIndex().getRow() >= 0);
		assertTrue(s.getIndex().getRow() <= s.getSpeed());
		System.out.println(s.getDirection());
		System.out.println(s.getIndex().getCol());
		System.out.println(s.getIndex().getRow());
		assertTrue(s.getIndex().getCol() <= 3);
		assertTrue(s.getIndex().getRow() >= (3-s.getSpeed()));
	}

}
