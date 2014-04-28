package main;

import java.awt.Color;

public class Dog extends Searcher {
	public static double RADIUS = 5.0;  

	public Dog(String n, Cell ind){
		super(n, ind, RADIUS);

	}
	
	public void makeRandColor(){
		// b and g have 0.5 so that all of the dogs have a stronger red tint
		float r = (float) (this.getRand().nextFloat()*.25 + .5);
		float g = (float) (this.getRand().nextFloat()*.25);
		float b = (float) (this.getRand().nextFloat()*0.25);
		
		if( !usedColors.contains(new Color(r,g,b)))
			setColor(new Color(r,g,b));
		else
			this.makeRandColor();
	}

}
