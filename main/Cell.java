package main;
//cell uses abstraction so that the program can be upgraded as needed.
//For instance if they don't want to send searchers into dangerous areas a new type of cell could be created for that easily
public class Cell {
	private int row, col;
	
	
	public Cell(int r, int c) {
		this.row = r;
		this.col = c;
	}
	

}
