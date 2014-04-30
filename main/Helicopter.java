package main;

import java.awt.Color;

public class Helicopter extends AutoSearcher {
	public static double RADIUS = 3.0;  

	public Helicopter(String n, Cell ind, double s, double dir){
		super(n, ind, RADIUS, s, dir);
	}
	
	public void makeRandColor(){
		// r and g have 0.5 so that all of the helicopters have a stronger blue tint
		float r = (float) (this.getRand().nextFloat()*0.25);
		float g = (float) (this.getRand().nextFloat()*0.25);
		float b = (float) (this.getRand().nextFloat()*.25 + .5);
		if( !usedColors.contains(new Color(r,g,b)))
			setColor(new Color(r,g,b));
		else
			this.makeRandColor();
	}
}
