package main;

import java.awt.Graphics;

public class Dog extends Searcher {
	private static double RADIUS = 0.0; 
	
	public Dog(){
		super();
		this.setRadius(RADIUS);
	}

	public Dog(String n, double s, double dir, Cell c){
		super(n, s, dir, c, RADIUS);
	}

	@Override
	public void draw(Graphics g){

	}
}
