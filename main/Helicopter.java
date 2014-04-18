package main;

import java.awt.Graphics;

public class Helicopter extends Searcher {
	private static double RADIUS = 0.0;  
	
	public Helicopter(){
		super();
	}

	public Helicopter(String n, double s, double dir, int r, int c){
		super(n, s, dir, r, c, RADIUS);
	}

	@Override
	public void draw(Graphics g){

	}
}
