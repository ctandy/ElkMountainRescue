package main;

import java.awt.Graphics;

public abstract class Searcher {
	private String name;
	private double speed;
	private double direction; // in degrees counterclockwise from positive x-axis
	private int row, col;
	private double radius;
	

	public Searcher(){
		name = new String();
		speed = 0.0;
		direction = 0.0;
		row = 0;
		col = 0;
		radius = 0.0;
	}
	
	public Searcher(String n, double s, double d, double r, int row, int col){
		name = n;
		speed = s;
		direction = d;
		radius = r;
		this.row = row;
		this.col = col;
	}
	
	public abstract void move(Grid g); //Should be implemented in part I following TDD (fail-pass)
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


	/*
	 * should we pass in a pointer to the right index?
	 * if not you'll need to override hashcode and equals
	 * in the cell class
	 */
	public void setIndex(int r, int c) {
		this.row = r;
		this.col = c;
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

	public int getRow() {
		return row;
	}
	
	public int getCol(){
		return col;
	}

	public double getRadius() {
		return radius;
	}
	
	
}
