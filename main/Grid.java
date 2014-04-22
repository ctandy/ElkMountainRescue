package main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Grid extends JPanel{
	private ArrayList<Searcher> searchers;
	public final static Integer CELL_SIZE = 16;
	private ArrayList<Cell> cells;
	//origin of grid is upper-left
	public static int MAX_ROW = 0; //row is increasing going down 
	public static int MAX_COL = 0; //col is increasing going right
	private int pixelRow = 0; // number of pixels vertically
	private int pixelCol = 0; // number of pixels horizontally
	private Image map;
	private Graphics2D g2d;
	MediaTracker tracker = new MediaTracker(this);


	public Grid() throws BadConfigFormatException{
		this.loadConfigFiles();
		this.initializeCells();
		searchers = new ArrayList<Searcher>();
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
		importBackground();
		pixelRow = map.getHeight(this);
		pixelCol = map.getWidth(this);
		this.setMAX_ROW(pixelRow/CELL_SIZE);
		this.setMAX_COL(pixelCol/CELL_SIZE);
		System.out.println(MAX_ROW + "   " + MAX_COL);
	}
	
	public int calcIndex(int r, int c) {
		return (r*MAX_COL+c);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		//paints the cell onto the board
		super.paintComponent(g);
		g2d = (Graphics2D) g;
		g.drawImage(map, 0, 0, this);
		for(int i = 0; i < MAX_ROW; i++)
			for(int j = 0; j < MAX_COL; j++)
				cells.get(calcIndex(i, j)).draw(g2d, j * CELL_SIZE, i * CELL_SIZE);
	}
	
	public void importBackground(){
		URL url = getClass().getResource("/images/searchMap.jpg"); 
		Image original = Toolkit.getDefaultToolkit().getImage(url);
	    tracker.addImage(original, 0);
	    try {
	      tracker.waitForID(0);
	    } catch (InterruptedException e) {  return; }
	    map = original;
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
			if (s.getSpeed() > Math.sqrt(Math.pow(Grid.MAX_COL, 2)+Math.pow(Grid.MAX_ROW, 2))){
				s.setSpeed(s.getSpeed()/2);
			}
			else if ((newrow<0 || newrow>Grid.MAX_ROW-1) || (newcol<0 || newcol>Grid.MAX_COL-1)){
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
	
	public void addSearcher(Searcher s){ //called from a MouseListener for the 'add' button
		this.getSearchers().add(s);
	}
	
	public void setMAX_ROW(int mAX_ROW) {
		MAX_ROW = mAX_ROW;
	}

	public void setMAX_COL(int mAX_COL) {
		MAX_COL = mAX_COL;
	}
	
	public int getPixelRow() {
		return pixelRow;
	}

	public void setPixelRow(int pixelRow) {
		this.pixelRow = pixelRow;
	}

	public int getPixelCol() {
		return pixelCol;
	}

	public void setPixelCol(int pixelCol) {
		this.pixelCol = pixelCol;
	}

	public ArrayList<Searcher> getSearchers() {
		return searchers;
	}
	
	public ArrayList<Cell> getCells() {
		return cells;
	}
}
