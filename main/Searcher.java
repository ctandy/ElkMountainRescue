package main;

import java.awt.Graphics;

public abstract class Searcher {
	private String name;
	private double speed;
	private double direction; // in degrees counterclockwise from positive x-axis
	private Cell index;
	private double radius;
	
	public Searcher(){
		name = new String();
		speed = 0.0;
		direction = 0.0;
		index = null;
		radius = 0.0;
	}
	
	public abstract void move(); //Should be implemented in part I following TDD (fail-pass)
	// move calls setRow and setCol after finding those end coordinates
	public void draw(Graphics g){} //Implemented in part II by the child classes
	
	
	public void setName(String name) {
		this.name = name;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public void setDirection(double direction) {
		this.direction = direction;
	}

	public void setIndex(Cell index) {
		this.index = index;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public String getName() {
		return name;
	}

	public double getSpeed() {
		return speed;
	}

	public double getDirection() {
		return direction;
	}

	public Cell getIndex() {
		return index;
	}

	public double getRadius() {
		return radius;
	}
	
	
}
