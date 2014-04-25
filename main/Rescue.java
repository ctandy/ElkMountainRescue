package main;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Rescue extends JFrame{
	private Grid grid;
	private Legend legend;

	public Rescue() {
		//loads the grid and legend
		try {
			grid = new Grid();
			legend = new Legend(grid);
			legend.setUp();
		} catch (BadConfigFormatException e) {
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Make Menu
		JMenuBar menuBar = makeMenuBar();
		setJMenuBar(menuBar);
		add(grid, BorderLayout.CENTER);
		add(legend, BorderLayout.SOUTH);
		//sets the size of the JFrame
		setSize(grid.getPixelCol() + 16, grid.getPixelRow() + menuBar.getHeight() + 64);
		setTitle("Elk Mountain Rescue System");
		setVisible(true);
	}
	private JMenuBar makeMenuBar() {
		//makes menu bar and adds items to menu bar
		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenuItem close = new JMenuItem("Exit");
		close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you wish to exit?", "Are you sure?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});
		JMenuItem add = new JMenuItem("Add Search Team");
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				grid.setWaitingForPlacement(true);
				JOptionPane.showMessageDialog(null, "Click a cell to place searcher", 
						"Add new Searcher", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		JMenuItem remove = new JMenuItem("Remove Search Team");
		remove.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				grid.setWaitingForRemove(true);
				JOptionPane.showMessageDialog(null, "Click a cell to remove searcher", 
						"Remove Searcher", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		JMenuItem edit = new JMenuItem("Edit Search Team");
		edit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				grid.setWaitingForEdit(true);
				JOptionPane.showMessageDialog(null, "Click a cell to edit searcher", 
						"Edit Searcher", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		JMenuItem manUpdate = new JMenuItem("Manual Update");
		manUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				grid.setWaitingForUpdate(true);
				JOptionPane.showMessageDialog(null, "Click and drag the searcher to update location",
						"Manual Update", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		JMenuItem time = new JMenuItem("Time Step");
		time.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				for (Searcher s : grid.getSearchers()) {
					grid.move(s);
				}
			}
		});
		menuBar.add(file);
		file.add(add);
		file.add(remove);
		file.add(edit);
		file.add(manUpdate);
		file.add(time);
		file.add(close);
		return menuBar;
	}
	
	public Grid getGrid(){
		return grid;
	}
	
	public static void main(String[] args) {

        Rescue r = new Rescue();
        
       //Determines interval in milliseconds to call GridUpdater
       //Timer timer = new Timer();
       //timer.schedule(new GridUpdater(r), 1000);

		/*final Rescue r = new Rescue();

		Timer timer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				for (Searcher s : r.getGrid().getSearchers()) {
					r.getGrid().move(s);
				}
				r.getGrid().repaint();

			}

		});
		timer.start();
        //Determines interval in milliseconds to call GridUpdater
      // Timer timer = new Timer();
       //timer.schedule(new GridUpdater(r), 20000);
        */

    }
	
}
