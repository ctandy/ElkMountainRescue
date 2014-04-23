package main;

import java.awt.Graphics;

public class Dog extends Searcher {
	public static double RADIUS = 5.0;  

	public Dog(String n, double s, double dir, Cell ind){
		this.setName(n);
		this.setSpeed(s);
		this.setDirection(dir);
		this.setIndex(ind);
		this.setRadius(RADIUS);
	}

	public void draw(Graphics g){
		g.setColor(null);
		super.draw(g);
	}

}
