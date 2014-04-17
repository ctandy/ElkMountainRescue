package test;

import static org.junit.Assert.*;

import java.awt.Color;

import junit.framework.Assert;
import main.Cell;
import main.NormalCell;

import org.junit.Before;
import org.junit.Test;

public class CellTest {
	private Cell cell;
	@Before
	public void setup() {
		cell = new NormalCell(0, 0);
	}

	@Test
	public void testSearchedColor() {
		cell.setSearched(true);
		Assert.assertEquals(Color.YELLOW, cell.getColor());
		cell.setSearched(false);
		Assert.assertEquals(null, cell.getColor());
	}

}
