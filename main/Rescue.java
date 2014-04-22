package main;

import java.awt.event.MouseListener;

public class Rescue {
	private Grid grid;

	public Rescue() throws BadConfigFormatException{
		grid = new Grid();
	}
	
	public void manualUpdate(MouseListener click){} 
	
	public Grid getGrid(){
		return grid;
	}
	
	public static void main(String[] args) {
        
    }
	
}
