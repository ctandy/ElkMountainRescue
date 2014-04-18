package main;

import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Rescue {
	private ArrayList<Searcher> searchers;
	private Grid grid;

	public Rescue() throws BadConfigFormatException{
		searchers = new ArrayList<Searcher>();
		grid = new Grid();
	}
	
	public void addSearcher(Searcher s){ //called from a MouseListener for the 'add' button
		this.getSearchers().add(s);
	}
	
	public void move(Searcher s){
		Cell cell = s.getIndex();
		int introw = cell.getRow();
		int intcol = cell.getCol();
		int newrow, newcol;
		while(true){
			int dx = (int) (s.getSpeed()*Math.cos(Math.toRadians(s.getDirection())));
			int dy = (int) (s.getSpeed()*Math.sin(Math.toRadians(s.getDirection())));
			newrow = introw-dy;
			newcol = intcol+dx;
			if ((newrow<0 || newrow>Grid.MAX_ROW-1) || (newcol<0 || newcol>Grid.MAX_COL-1)){
				s.setDirection(Math.random()*360);
			}
			else {
				cell.setRow(newrow);
				cell.setCol(newcol);
				s.setIndex(cell);
				break;
			}
		}
	}
	
	public void manualUpdate(MouseListener click){} //Part of GUI, done in part 2 

	public ArrayList<Searcher> getSearchers() {
		return searchers;
	}
	
	public Grid getGrid(){
		return grid;
	}
	
	public static void main(String[] args) {
        
    }
	
}
