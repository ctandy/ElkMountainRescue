package main;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class Legend extends JPanel{

	private ArrayList<Searcher> searchers;
	//private ArrayList<JPanel> searcherPanels;
	public Legend(Grid grid){
		searchers = grid.getSearchers();
		setUp(grid);
	}
	
	public void setUp(Grid grid){
		searchers = grid.getSearchers();
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		setBorder(new TitledBorder("Legend"));
		Graphics g;
		for(Searcher s: searchers){
			JPanel sLegend = new JPanel();
			sLegend.add(new LegendSquare(s));
			add(sLegend);
		}
	}
	
	public class LegendSquare extends JPanel{
		Searcher searcher;
		public LegendSquare(Searcher searcher){
			this.searcher = searcher;
		}
		
		public void draw(Graphics g){
			super.paintComponent(g);
			g.setColor(searcher.getColor());
			g.fillRect(0, 0, 10, 10);
		}
	}
	
}
