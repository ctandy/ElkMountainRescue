package test;

import static org.junit.Assert.*;

import java.awt.Color;

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
	public void testEquals() {
		assertTrue(cell.equals(new NormalCell(0, 0)));
		assertFalse(cell.equals(new NormalCell(1, 1)));
	}

}
