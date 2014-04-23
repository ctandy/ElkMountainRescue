package main;

import java.awt.Color;

public class Helicopter extends AutoSearcher {
	public static double RADIUS = 10.0;  

	public Helicopter(String n, Cell ind, double s, double dir){
		super(n, ind, RADIUS, s, dir);
	}
	
	public void makeRandColor(){
		// r and g have 0.5 so that all of the hikers have a stronger blue tint
		float r = (float) (rand.nextFloat()*0.25);
		float g = (float) (rand.nextFloat()*0.25);
		float b = (float) (rand.nextFloat()*.25 + .5);
		if( !usedColors.contains(new Color(r,g,b)))
			setColor(new Color(r,g,b));
		else
			this.makeRandColor();
	}
}
