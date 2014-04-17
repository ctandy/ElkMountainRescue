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
		testing.loadConfigFiles();
	}

	@Test
	public void testCalcIndex() {
		int expected = 173;
		int actual = testing.calcIndex(7, 12);
		Assert.assertEquals(expected, actual);
		expected = 3;
		actual = testing.calcIndex(0,3);
		Assert.assertEquals(expected, actual);
	}
}
