package main;

import java.awt.Color;
import java.awt.Graphics2D;

public class NormalCell extends Cell{
	
	public NormalCell(int r, int c) {
		super(r, c);
	}
	
	@Override
	public void draw(Graphics2D g, Integer x, Integer y) {
		g.setColor(Color.black);
		g.drawRect(x, y, Grid.CELL_SIZE.intValue(), Grid.CELL_SIZE.intValue());
		if (this.isSearched()) {
			Color yellow = new Color (255,255,0,100);
			g.setColor(yellow);
			g.fillRect(x + 1, y + 1, Grid.CELL_SIZE.intValue() - 1, Grid.CELL_SIZE.intValue() - 1);
		}
	}
}
