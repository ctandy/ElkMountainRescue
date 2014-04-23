package main;

import java.awt.Color;

public class Hiker extends AutoSearcher {
	private static double RADIUS = 3.0;  

	public Hiker(String n, Cell ind, double s, double dir){
		super(n, ind, RADIUS, s, dir);
		
	}
	
	public void makeRandColor(){
		// r and b have 0.5 so that all of the hikers have a stronger green tint
		float r = (float) (rand.nextFloat()*0.25);
		float g = (float) (rand.nextFloat()*.25 + .5);
		float b = (float) (rand.nextFloat()*.25);
		
		if( !usedColors.contains(new Color(r,g,b)))
			setColor(new Color(r,g,b));
		else
			this.makeRandColor();
	}
}
