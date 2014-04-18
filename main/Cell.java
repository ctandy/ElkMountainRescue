package main;

import java.awt.Color;
import java.awt.Graphics;

//cell uses abstraction so that the program can be adapted as needed.
//For instance if they don't want to send searchers into dangerous areas 
//a new type of cell could be created for that easily
//For now only NormalCell will be used
public abstract class Cell {
	private int row, col;
	private boolean searched = false;
	private Color color;
	
	public Cell(int r, int c) {
		this.row = r;
		this.col = c;
	}
	
	// empty draw to be implemented with GUI
	public abstract void draw(Graphics g);
	
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
	
}
