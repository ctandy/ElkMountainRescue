package test;

import static org.junit.Assert.*;
import main.BadConfigFormatException;
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
	public void testMove() {
		Searcher s = new Searcher();
		res.addSearcher(s);
		assertTrue(res.getSearchers().size() == 1);
	}

}
