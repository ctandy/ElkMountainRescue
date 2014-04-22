package main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Rescue extends JFrame{
	private Grid grid;

	public Rescue() {
		try {
			grid = new Grid();
		} catch (BadConfigFormatException e) {
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Make Menu
		JMenuBar menuBar = makeMenuBar();
		setJMenuBar(menuBar);
		add(grid, BorderLayout.CENTER);
		
		setSize(grid.getPixelCol() + 16, grid.getPixelRow() + menuBar.getHeight() + 64);
		setVisible(true);
	}
	private JMenuBar makeMenuBar() {
		//makes menu bar and adds items to menu bar
		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("File");
		//allows player to see detective notes
		JMenuItem close = new JMenuItem("Close");
		close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you wish to exit?", "Are you sure?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});
		menuBar.add(file);
		file.add(close);
		return menuBar;
	}
	
	public void manualUpdate(MouseListener click){} 
	
	public Grid getGrid(){
		return grid;
	}
	
	public static void main(String[] args) {
        Rescue r = new Rescue();
    }
	
}
