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
	private ArrayList<Cell> cells;
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
			if (s.getSpeed() > Math.sqrt(Grid.MAX_COL*Grid.MAX_ROW)){
				s.setSpeed(s.getSpeed()/2);
			}
			else if (s.getSpeed() < 0){
				s.setSpeed(-1*s.getSpeed());
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
		searchedLine(s, introw, intcol, newrow, newcol);
		repaint();
	}
	
	public void moveManual(Searcher s, Cell newIndex){ // This function is used to manually update index
		Cell cell = s.getIndex();
		for (Cell c : cells){
			if(c.equals(cell))
				break;
		}
		s.setIndex(newIndex);
		repaint();
	}
	
	//calculates search range for given searcher when moving from initial position(irow, icol)
	//to new position(nrow, ncol)
	//sets all the cells in the search range to searched
	// they will all be yellow when repaint is called
	public void searchedLine(Searcher s, int irow, int icol, int nrow, int ncol){
		ArrayList<Cell> searched = new ArrayList<Cell>();
		double crow = irow;
		double ccol = icol;
		double dir = 0.0;
		if (ncol-icol != 0){
			if (nrow-irow != 0)
				dir = Math.atan((irow-nrow)/(ncol-icol));
			else if(ncol > icol)
				dir = 0.0;
			else
				dir = 180.0;
		} else if (nrow-irow != 0){
			if(nrow > irow)
				dir = 270.0;
			else
				dir = 90.0;
		} else
			return; //does not set current index as searched
		
		double dx = (double) (Math.cos(dir));
		double dy = (double) (Math.sin(dir));
		double dx_90 = (double) (Math.cos(dir+(Math.PI)/2));
		double dy_90 = (double) (Math.sin(dir+(Math.PI)/2));
		double dx_270 = (double) (Math.cos(dir+(Math.PI)*3/2));
		double dy_270 = (double) (Math.sin(dir+(Math.PI)*3/2));
		
		if(Math.abs(Math.round(dx) - dx) < Math.pow(10, -2))
			dx = Math.round(dx);
		if(Math.abs(Math.round(dy) - dy) < Math.pow(10, -2))
			dy = Math.round(dy);
		if(Math.abs(Math.round(dx_90) - dx_90) < Math.pow(10, -2))
			dx_90 = Math.round(dx_90);
		if(Math.abs(Math.round(dy_90) - dy_90) < Math.pow(10, -2))
			dy_90 = Math.round(dy_90);
		if(Math.abs(Math.round(dx_270) - dx_270) < Math.pow(10, -2))
			dx_270 = Math.round(dx_270);
		if(Math.abs(Math.round(dy_270) - dy_270) < Math.pow(10, -2))
			dy_270 = Math.round(dy_270);
		
		double i = 0.0;
		do {
			crow = irow - i*dy;
			ccol = icol + i*dx;
			searched.add(new NormalCell((int) Math.round(crow), (int) Math.round(ccol)));
			for (double j = 1; j <= s.getRadius(); j++){
				double jrow = crow - j*dy_90;
				double jcol = ccol + j*dx_90;
				searched.add(new NormalCell((int) Math.round(jrow), (int) Math.round(jcol)));
				jrow = crow - j*dy_270;
				jcol = ccol + j*dx_270;
				searched.add(new NormalCell((int) Math.round(jrow), (int) Math.round(jcol)));
			}
			i++;
		} while (Math.round(crow) != Math.round(nrow+dy) && Math.round(ccol) != Math.round(ncol-dx));
		
		for (Cell cell : cells){
			for (Cell sCell : searched){
				cell.equals(sCell);
			}
		}
	}
	
	public void addSearcher(Searcher s){ //called from the menu bar
		searchers.add(s);
		Rescue.legend.addSearcher(this);
		System.out.println(s.getSpeed());
		System.out.println(s.getDirection());

		repaint();
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
				break; //so it all removes one searcher if two occupy the same cell
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
		if(isWaitingForUpdate()){
			if(cells == null) throw new RuntimeException("No valid cells available.");
			Cell target = null;
			for(Cell c: cells){
				if(c.containsClick(e.getX(), e.getY())){
					target = c;
					break;
				}
			}
			waitingForUpdate = false;
			moveManual(manTarget, target);
			if(manTarget.getRadius() != Dog.RADIUS){
				UpdateSearcherDialog update = new UpdateSearcherDialog(manTarget, this);
				update.setVisible(true);
			}
		}
	}
}
