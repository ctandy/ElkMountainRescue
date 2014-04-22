package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Map;

public class NormalCell extends Cell{
	
	public NormalCell(int r, int c) {
		super(r, c);

	}
	
	// empty draw to be implemented with GUI
	@Override
	public void draw(Graphics2D g, Integer x, Integer y) {
		g.setColor(Color.black);
		g.drawRect(x, y, Grid.CELL_SIZE.intValue(), Grid.CELL_SIZE.intValue());
		g.setColor(this.getColor());
		g.fillRect(x + 1, y + 1, Grid.CELL_SIZE.intValue() - 1, Grid.CELL_SIZE.intValue() - 1);
	}
}
