package main;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Legend extends JPanel{

	private ArrayList<Searcher> searchers;
	private ArrayList<JPanel> searcherPanels;
	public Legend(Grid grid){
		
		searchers = grid.getSearchers();		
	}
	
	public void setUp(){
		setLayout(new GridLayout(1, searchers.size()));
		for(Searcher s: searchers){
			JPanel sLegend = new JPanel();
			sLegend.add(new LegendSquare(s));
			searcherPanels.add(sLegend);
		}
	}
	
	public class LegendSquare extends JPanel{
		Searcher searcher;
		public LegendSquare(Searcher searcher){
			this.searcher = searcher;
		}
		
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.setColor(searcher.getColor());
			g.fillRect(0, 0, 10, 10);
		}
	}
	
}
