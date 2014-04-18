package main;

import java.awt.Graphics;

public class Helicopter extends Searcher {
	private static double RADIUS = 10.0;  

	public Helicopter(String n, double s, double dir, Cell ind){
		this.setName(n);
		this.setSpeed(s);
		this.setDirection(dir);
		this.setIndex(ind);
		this.setRadius(RADIUS);
	}

	public void draw(Graphics g){

	}
}
