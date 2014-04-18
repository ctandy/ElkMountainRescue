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
