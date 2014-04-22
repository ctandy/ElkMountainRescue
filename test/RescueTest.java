package test;

import static org.junit.Assert.*;
import main.BadConfigFormatException;
import main.Hiker;
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
	}

}
