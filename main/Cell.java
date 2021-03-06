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
	
	public Cell(int r, int c) {
		this.row = r;
		this.col = c;
		this.searched = false;
	}
	// when comparing 2 cells this will set a cell to searched and update the color of the cell
	public boolean equals(Cell c){
		if(this.row == c.getRow() && this.col == c.getCol()) {
			this.searched = true;
			return true;
		}
		else 
			return false;
	}
	
	public boolean isSearched() {
		return searched;
	}
	
	public void setSearched(boolean searched) {
		this.searched = searched;
	}
	
	public abstract void draw(Graphics2D g, Integer x, Integer y);
	
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
	//checks to see if the cell contains a mouse click (used when placeing or updating searchers
	public boolean containsClick(int mouseX, int mouseY) {
		Rectangle rect = new Rectangle(col * Grid.CELL_SIZE, row * Grid.CELL_SIZE, Grid.CELL_SIZE, Grid.CELL_SIZE);
		if (rect.contains(new Point(mouseX, mouseY))) 
			return true;
		return false;
	}

	@Override
	public String toString() {
		return "Cell [row=" + row + ", col=" + col + ", searched=" + searched + "]";
	}
	
}
