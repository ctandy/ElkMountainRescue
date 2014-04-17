package main;

import java.awt.Graphics;

public class Dog extends Searcher {
	
	private static double RADIUS = 0.0;  
	
	public Dog(){
		super();
	}
	
	public Dog(String n, double s, double d, double r, int row, int col){
		super(n , s, d, r, row, col);
	}
	
	@Override
	public void draw(Graphics g){
		
	}

	@Override
	public void move(Grid g) {
		// TODO Auto-generated method stub
		
	}
}
