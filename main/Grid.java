package main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Grid extends JPanel{
	private ArrayList<Cell> cells;
	//origin of grid is upper-left
	public static int MAX_ROW = 0; //row is increasing going down 
	public static int MAX_COL = 0; //col is increasing going right
	private Image map;
	MediaTracker tracker = new MediaTracker(this);


	public Grid() throws BadConfigFormatException{
		this.loadConfigFiles();
		this.initializeCells();
	}
	
	public void initializeCells(){
		cells = new ArrayList<Cell>();
		for (int i = 0; i < MAX_ROW; i++){
			for (int j = 0; j < MAX_COL; j++){
				cells.add(new NormalCell(i, j));
			}
		}
	}
	
	public void loadConfigFiles() throws BadConfigFormatException{
		int mrow = 5; //set mrow and mcol for testing
		int mcol = 4;
		this.setMAX_ROW(mrow);
		this.setMAX_COL(mcol);
	}
	
	public int calcIndex(int r, int c) {
		return (r*MAX_COL+c);
	}
	
	public void paint(Graphics g){} //Part of GUI, done in part 2
	
	public void importBackground(){
		URL url = getClass().getResource("/images/searchMap.jpg"); 
		Image original = Toolkit.getDefaultToolkit().getImage(url);
	    tracker.addImage(original, 0);
	    try {
	      tracker.waitForID(0);
	    } catch (InterruptedException e) {  return; }
	    map = original;
	}
	
	public void setMAX_ROW(int mAX_ROW) {
		MAX_ROW = mAX_ROW;
	}

	public void setMAX_COL(int mAX_COL) {
		MAX_COL = mAX_COL;
	}
	
	public ArrayList<Cell> getCells() {
		return cells;
	}
}
