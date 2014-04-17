package main;

import java.awt.Color;

//cell uses abstraction so that the program can be upgraded as needed.
//For instance if they don't want to send searchers into dangerous areas a new type of cell could be created for that easily
public abstract class Cell {
	private int row, col;
	private boolean searched;
	private Color color;
	
	public Cell(int r, int c) {
		this.row = r;
		this.col = c;
	}
	// empty draw to be implemented with GUI
	public abstract void draw();
	public boolean equals(Cell cell){//Test and implement this for part 1
		
		return false;
	}
	public boolean isSearched() {
		return searched;
	}
	public void setSearched(boolean searched) {
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
