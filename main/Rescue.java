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

@SuppressWarnings("serial")
public class Rescue extends JFrame{
	private Grid grid;
	private boolean waitForUpdate = false;
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
				// Bernardo: here is where you could look for a click and update the index/direction
				// could call to the manualUpdate function below
				// use the moveManual function in Grid
				waitForUpdate = true;
				JOptionPane.showMessageDialog(null, "Click the searcher to update",
						"Manually Update Location", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		menuBar.add(file);
		file.add(add);
		file.add(remove);
		file.add(edit);
		file.add(manUpdate);
		file.add(close);
		return menuBar;
	}
	
	public void manualUpdate(MouseListener click) {

		
		while (waitForUpdate) {
			
		}
	}
	
	public Grid getGrid(){
		return grid;
	}
	
	public static void main(String[] args) {
        Rescue r = new Rescue();
       
        // every time a timer goes off do:
        // for (Searcher s : r.getGrid().getSearchers()){
        //   if (s.getRadius() != Dog.RADIUS) 
        //	   r.getGrid().move(s);
        // }
        // All the menu bar functions can be done on top of this timer
        // r.getGrid().repaint();
    }
	
}
