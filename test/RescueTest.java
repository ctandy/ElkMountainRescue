package test;

import static org.junit.Assert.*;
import main.Rescue;
import main.Searcher;

import org.junit.Before;
import org.junit.Test;

public class RescueTest {
	Rescue res;
	@Before
	public void setup(){
		res = new Rescue(5, 4);
	}
	@Test
	public void testConstructor() {
		assertTrue(Rescue.MAX_ROW == 5);
		assertTrue(Rescue.MAX_COL == 4);
	}
	
	@Test
	public void testInitializeCells() {
		assertTrue(res.getCells().size() == 20);
	}
	
	@Test
	public void testAddSearcher() {
		Searcher s = new Searcher();
		res.addSearcher(s);
		assertTrue(res.getSearchers().size() == 1);
	}

}
