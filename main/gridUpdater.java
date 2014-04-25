package main;

import java.util.TimerTask;

/*
 * a small class that is run in Rescue main. The run function determines what happens every
 * interval as determined by function in main.
 */
public class gridUpdater extends TimerTask {
	private Grid g;
	
	public gridUpdater(Rescue r){
		this.g = r.getGrid();
	}
	
	@Override
	public void run() {
		for (Searcher s : g.getSearchers()) {
			g.move(s);
		}
		g.repaint();
	}

}
