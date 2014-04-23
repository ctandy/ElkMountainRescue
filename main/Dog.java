package main;

import java.awt.Color;

public class Dog extends Searcher {
	private static double RADIUS = 5.0;  

	public Dog(String n, Cell ind){
		super(n, ind, RADIUS);

	}
	
	public void makeRandColor(){
		// b and g have 0.5 so that all of the hikers have a stronger red tint
		float r = (float) (rand.nextFloat()*.25 + .5);
		float g = (float) (rand.nextFloat()*.25);
		float b = (float) (rand.nextFloat()*0.25);
		
		if( !usedColors.contains(new Color(r,g,b)))
			setColor(new Color(r,g,b));
		else
			this.makeRandColor();
	}

}
