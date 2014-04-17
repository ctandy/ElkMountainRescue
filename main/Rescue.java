package main;

import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Rescue {
	private ArrayList<Searcher> searchers;

	public Rescue(){
		searchers = new ArrayList<Searcher>();
	}
	
	public void addSearcher(Searcher s){ //called from a MouseListener for the 'add' button
		this.getSearchers().add(s);
	}
	
	public void manualUpdate(MouseListener click){} //Part of GUI, done in part 2 

	public ArrayList<Searcher> getSearchers() {
		return searchers;
	}
	
	public static void main(String[] args) {
        
    }
	
}
