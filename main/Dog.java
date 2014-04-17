package main;

import java.awt.Graphics;

public class Dog extends Searcher {
	private static double RADIUS = 0.0;  
	
	public Dog(String n, double s, double dir, int ind){
		this.setName(n);
		this.setSpeed(s);
		this.setDirection(dir);
		this.setIndex(ind);
		this.setRadius(RADIUS);
	}
	
	@Override
	public void draw(Graphics g){
		
	}
}
