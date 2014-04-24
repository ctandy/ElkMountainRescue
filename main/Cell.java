package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JComponent;

//cell uses abstraction so that the program can be adapted as needed.
//For instance if they don't want to send searchers into dangerous areas 
//a new type of cell could be created for that easily
//For now only NormalCell will be used
@SuppressWarnings("serial")
public abstract class Cell extends JComponent{
	private int row, col;
	private boolean searched;
	private Color color;
	
	public Cell(int r, int c) {
		this.row = r;
		this.col = c;
		this.color = null;
		this.searched = false;
	}
	
	public boolean equals(Cell c){
		if(this.row == c.getRow() && this.col == c.getCol()) {
			this.searched = true;
			this.color = Color.YELLOW;
			return true;
		}
		else 
			return false;
	}
	
	public boolean isSearched() {
		return searched;
	}
	
	public void setSearched(boolean searched) {// for testing purposes
		if (searched) 
			this.color = Color.YELLOW;
		else 
			this.color = null;
		this.searched = searched;
	}
	
	public abstract void draw(Graphics2D g, Integer x, Integer y);
	
	public Color getColor() {
		return color;
	}
	
	public int getRow() {
		return row;
	}
	
	public void setRow(int row) {
		this.row = row;
	}
	
	public int getCol() {
		return col;
	}
	
	public void setCol(int col) {
		this.col = col;
	}
	
	public boolean containsClick(int mouseX, int mouseY) {
		Rectangle rect = new Rectangle(col * Grid.CELL_SIZE, row * Grid.CELL_SIZE, Grid.CELL_SIZE, Grid.CELL_SIZE);
		if (rect.contains(new Point(mouseX, mouseY))) 
			return true;
		return false;
	}
	
}
