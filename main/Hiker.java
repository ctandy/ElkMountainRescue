package main;

import java.awt.Graphics;

public class Hiker extends Searcher {
	public static double RADIUS = 3.0;  

	public Hiker(String n, double s, double dir, Cell ind){
		this.setName(n);
		this.setSpeed(s);
		this.setDirection(dir);
		this.setIndex(ind);
		this.setRadius(RADIUS);
	}

	public void draw(Graphics g){

	}
}
