package test;

import static org.junit.Assert.*;
import main.Rescue;
import main.Searcher;

import org.junit.Before;
import org.junit.Test;

public class RescueTest {
	
	@Test
	public void testAddSearcher() {
		Searcher s = new Searcher();
		res.addSearcher(s);
		assertTrue(res.getSearchers().size() == 1);
	}

}
