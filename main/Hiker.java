package main;

import java.awt.Graphics;

public class Hiker extends Searcher {
	private static double RADIUS = 0.0;  
	
	public Hiker(){
		super();
		this.setRadius(RADIUS);
	}

	public Hiker(String n, double s, double dir, int r, int c){
		super(n, s, dir, r, c, RADIUS);
	}

	@Override
	public void draw(Graphics g){

	}
}
