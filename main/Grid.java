package main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.TimerTask;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Grid extends JPanel implements MouseListener{

	private static ArrayList<Searcher> searchers;
	public final static Integer CELL_SIZE = 16;
	protected static ArrayList<Cell> cells;
	//origin of grid is upper-left
	public static int MAX_ROW = 0; //row is increasing going down 
	public static int MAX_COL = 0; //col is increasing going right
	private int pixelRow = 0; // number of pixels vertically
	private int pixelCol = 0; // number of pixels horizontally
	private Image map;
	private Graphics2D g2d;
	private boolean waitingForPlacement;
	private boolean waitingForRemove;
	private boolean waitingForEdit;
	private boolean waitingForUpdate;
	private Searcher manTarget;
	

	MediaTracker tracker = new MediaTracker(this);


	public Grid() throws BadConfigFormatException{
		this.loadConfigFiles();
		this.initializeCells();
		searchers = new ArrayList<Searcher>();
		waitingForPlacement = false;
		waitingForRemove = false;
		waitingForEdit = false;
		waitingForUpdate = false;
		manTarget = null;
		addMouseListener(this);
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
	}
	
	public int calcIndex(int r, int c) {
		return (r*MAX_COL+c);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		//paints the cells onto the board
		super.paintComponents(g);
		super.paintComponent(g);
		g2d = (Graphics2D) g;
		// paints the image to the background
		g.drawImage(map, 0, 0, this);
		for(int i = 0; i < MAX_ROW; i++)
			for(int j = 0; j < MAX_COL; j++)
				cells.get(calcIndex(i, j)).draw(g2d, j * CELL_SIZE, i * CELL_SIZE);
		// paints search teams
		for(Searcher s : searchers)
			s.draw(g);		
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
	
	//sets all the cells in the search range to searched
	// they will all be yellow when repaint is called
	public void searchedLine(Searcher s, int brow, int bcol, Cell after){ // assume speed = 1 // only called after a move
		ArrayList<Cell> searched = new ArrayList<Cell>();
		int arow = after.getRow();
		int acol = after.getCol();
		
		searched.add(new NormalCell(brow, bcol));// add initial position
		
		double dir = 0.0;
		if (bcol != acol){
			if (brow != arow)
				dir = Math.atan((brow-arow)/(acol-bcol));
			else if(acol > bcol)
				dir = Math.toRadians(0.0);
			else
				dir = Math.toRadians(180.0);
		} else {
			if(arow > brow)
				dir = Math.toRadians(270.0);
			else
				dir = Math.toRadians(90.0);
		}
		
		int dx = (int) Math.round((Math.cos(dir)));
		int dy = (int) Math.round((Math.sin(dir)));
		int dx_90 = (int) Math.round((Math.cos(dir+(Math.PI)/2)));
		int dy_90 = (int) Math.round(Math.sin(dir+(Math.PI)/2));
		int dx_270 = (int) Math.round(Math.cos(dir+(Math.PI)*3/2));
		int dy_270 = (int) Math.round(Math.sin(dir+(Math.PI)*3/2));
		
		double fullHypo = Math.sqrt(Math.pow((brow-arow),2)+Math.pow((acol-bcol),2));
		double dHypo = Math.sqrt(Math.pow(dx,2)+Math.pow(dy,2));
		int steps = (int) Math.round(fullHypo/dHypo);
	
		int crow = brow;
		int ccol = bcol;
		
		for (int i = 0; i < steps; i++){
			crow = crow - dy;
			ccol = ccol + dx;
			searched.add(new NormalCell(crow, ccol));// adds the current cell
			for (int j = 1; j <= s.getRadius(); j++){ //adds the radius cells to searched
				int jrow = crow - j*dy_90;
				int jcol = ccol + j*dx_90;
				searched.add(new NormalCell(jrow, jcol));
				jrow = crow - j*dy_270;
				jcol = ccol + j*dx_270;
				searched.add(new NormalCell(jrow, jcol));
			}
		} 
		
		for (Cell cell : cells){
			for (Cell sCell : searched){
				cell.equals(sCell); // sets cells in searched to searched:true
			}
		}
	}

	public void addSearcher(Searcher s){ //called from the menu bar
		searchers.add(s);
		Rescue.legend.addSearcher(this);
		repaint();
	}
	
	public void addTwoSearchers(Searcher s1, Searcher s2){ //used for testing empty searcher
		searchers.add(s1);
		searchers.add(s2);
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
	
	public boolean isWaitingForPlacement() {
		return waitingForPlacement;
	}

	public void setWaitingForPlacement(boolean waitingForPlacement) {
		this.waitingForPlacement = waitingForPlacement;
	}
	
	public boolean isWaitingForRemove() {
		return waitingForRemove;
	}

	public void setWaitingForRemove(boolean remove) {
		this.waitingForRemove = remove;
	}

	public boolean isWaitingForEdit() {
		return waitingForEdit;
	}

	public void setWaitingForEdit(boolean edit) {
		this.waitingForEdit = edit;
	}
	
	public boolean isWaitingForUpdate() {
		return waitingForUpdate;
	}

	public void setWaitingForUpdate(boolean update) {
		this.waitingForUpdate = update;
	}
	
	public void removeSearcher(Cell c){
		for (Searcher s : searchers){
			if(s.getIndex().equals(c)){
				searchers.remove(s);
				Rescue.legend.updateSearchers(this);
				break; //so it only removes one searcher if two occupy the same cell
			}
		}
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		// sets waitingForPlacement to false if user selects a valid cell to place a searcher in and makes the searcher visible
		if(isWaitingForPlacement()){
			if(cells == null) throw new RuntimeException("No valid cells available.");
			Cell target = null;
			for(Cell c: cells){
				if(c.containsClick(e.getX(), e.getY())){
					target = c;
					break;
				}
			}
			waitingForPlacement = false;
			NewSearcherDialog makeNewSearcher = new NewSearcherDialog(target, this);
			makeNewSearcher.setVisible(true);
		}
		//sets waitingForRemove to false if the user selects a valid target then removes the Searcher at that target
		if(isWaitingForRemove()){
			if(cells == null) throw new RuntimeException("No valid cells available.");
			Cell target = null;
			for(Cell c: cells){
				if(c.containsClick(e.getX(), e.getY())){
					target = c;
					break;
				}
			}
			waitingForRemove = false;
			removeSearcher(target);
		}
		//sets waitingForEdit to false if user selects a valid target and brings up EditSearcherDialog
		if(isWaitingForEdit()){
			if(cells == null) throw new RuntimeException("No valid cells available.");
			Cell target = null;
			for(Cell c: cells){
				if(c.containsClick(e.getX(), e.getY())){
					for (Searcher s : searchers){
						if(s.getIndex().equals(c))
							target = c;
					}
					if(target == null){
						waitingForEdit = false;
						return;
					}
				}
			}
			waitingForEdit = false;
			EditSearcherDialog edit = new EditSearcherDialog(target, this);
			edit.setVisible(true);
		}
		if(isWaitingForUpdate()){
			if(cells == null) throw new RuntimeException("No valid cells available.");
			manTarget = null;
			for(Cell c: cells){
				if(c.containsClick(e.getX(), e.getY())){
					for (Searcher s : searchers){
						if(s.getIndex().equals(c))
							manTarget = s;
					}
					if(manTarget == null){
						waitingForUpdate = false;
						return;
					}
				}
			}
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// sets waitingForUpdate to false updates the searcher location and searched cells(used with manual update)
		if(isWaitingForUpdate()){
			if(cells == null) throw new RuntimeException("No valid cells available.");
			Cell target = null;
			int brow = manTarget.getIndex().getRow();
			int bcol = manTarget.getIndex().getCol();
			for(Cell c: cells){
				if(c.containsClick(e.getX(), e.getY())){
					target = c;
					break;
				}
			}
			
			waitingForUpdate = false;
			searchedLine(manTarget, brow, bcol, target);
			manTarget.setIndex(target);
			repaint();

			if(manTarget.getRadius() != Dog.RADIUS){
				UpdateSearcherDialog update = new UpdateSearcherDialog(manTarget, this);
				update.setVisible(true);
			}
		}
	}
}
