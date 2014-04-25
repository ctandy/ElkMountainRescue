package main;

import java.util.TimerTask;


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
