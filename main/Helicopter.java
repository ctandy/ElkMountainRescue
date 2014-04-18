package main;

import java.awt.Graphics;

public class Helicopter extends Searcher {
	private static double RADIUS = 0.0;  
	
	public Helicopter(){
		super();
		this.setRadius(RADIUS);
	}

	public Helicopter(String n, double s, double dir, Cell c){
		super(n, s, dir, c, RADIUS);
	}

	@Override
	public void draw(Graphics g){

	}
}
