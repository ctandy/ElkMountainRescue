package main;
//cell uses abstraction so that the program can be upgraded as needed.
//For instance if they don't want to send searchers into dangerous areas a new type of cell could be created for that easily
public class Cell {
	private int row, col;
	
	public Cell(int r, int c) {
		this.row = r;
		this.col = c;
	}
	
	public boolean equals(){//Test and implement this for part 1
		return false;
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
