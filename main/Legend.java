package main;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
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
		setLayout(new FlowLayout());
		//GridBagConstraints c = new GridBagConstraints();
		setBorder(new TitledBorder("Legend"));
		//Graphics g;
	}
	
	public void addSearcher(Grid grid){
		Searcher s = searchers.get(searchers.size()-1);
		JPanel sLegend = new JPanel();
		sLegend.add(new LegendSquare(s));
		sLegend.add(new JLabel(s.getName()));
		add(sLegend);
		this.updateUI();
	}
	
	
	public class LegendSquare extends JPanel{
		Searcher searcher;
		public LegendSquare(Searcher searcher){
			this.searcher = searcher;
		}
		
		public void paintComponent(Graphics g){
			super.paintComponents(g);
			g.setColor(searcher.getColor());
			g.fillRect(0, 0, 10, 10);
		}
	}
	
}
