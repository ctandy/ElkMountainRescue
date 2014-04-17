package main;

import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Rescue {
	private ArrayList<Searcher> searchers = new ArrayList<Searcher>();
	private ArrayList<Cell> cells = new ArrayList<Cell>();
	public static int MAX_ROW = 10; 
	public static int MAX_COL = 10;

	public Rescue(int row, int col){
		this.initializeCells();
		this.setMAX_ROW(row);
		this.setMAX_COL(col);
	}
	
	public void initializeCells(){
		ArrayList<Cell> cell = new ArrayList<Cell>();
		//...for loops
		this.setCells(cell);
	}
	
	public void addSearcher(Searcher s){ //called from a MouseListener for the 'add' button
		this.getSearchers().add(s);
	}
	
	public void importBackground(){} //Part of GUI, done in part 2
	
	public void paint(Graphics g){} //Part of GUI, done in part 2
	
	public void manualUpdate(MouseListener click){} //Part of GUI, done in part 2 

	public void setMAX_ROW(int mAX_ROW) {
		MAX_ROW = mAX_ROW;
	}

	public void setMAX_COL(int mAX_COL) {
		MAX_COL = mAX_COL;
	}

	public ArrayList<Searcher> getSearchers() {
		return searchers;
	}

	public void setSearchers(ArrayList<Searcher> searchers) {
		this.searchers = searchers;
	}
	
	public ArrayList<Cell> getCells() {
		return cells;
	}

	public void setCells(ArrayList<Cell> cells) {
		this.cells = cells;
	}
	
	public static void main(String[] args) {
        
    }
	
}
