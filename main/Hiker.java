package main;

import java.awt.Graphics;

public class Hiker extends Searcher {
	private static double RADIUS = 0.0;  
	
	public Hiker(){
		super();
		this.setRadius(RADIUS);
	}

	public Hiker(String n, double s, double dir, Cell c){
		super(n, s, dir, c, RADIUS);
	}

	@Override
	public void draw(Graphics g){

	}
}
