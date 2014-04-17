package main;

import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Rescue {
	private ArrayList<Searcher> searchers = new ArrayList<Searcher>();
	private ArrayList<Cell> cells;
	//origin of board is upper-left
	public static int MAX_ROW = 0; //row is increasing going down 
	public static int MAX_COL = 0; //col is increasing going right

	public Rescue(int row, int col){
		this.setMAX_ROW(row);
		this.setMAX_COL(col);
		this.initializeCells();
	}
	
	public void initializeCells(){
		cells = new ArrayList<Cell>();
		for (int i = 0; i < MAX_ROW; i++){
			for (int j = 0; j < MAX_COL; j++){
				cells.add(new Cell(i, j));
			}
		}
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
