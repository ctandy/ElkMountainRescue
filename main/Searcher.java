package main;

import java.awt.Graphics;

public class Searcher {
	private String name;
	private double speed;
	private double direction; // in degrees counterclockwise from positive x-axis
	private int row;
	private int col;
	private double radius;
	
	public Searcher(){
		name = new String();
		speed = 0.0;
		direction = 0.0;
		row = 0;
		col = 0;
		radius = 0;
	}
	
	public Searcher(String name, double speed, double direction, int row, int col, double radius){
		this.name = name;
		this.speed = speed;
		this.direction = direction;
		this.row = row;
		this.col = col;
		this.radius = radius;
	}
	
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

	public void setLocation(int row, int col){
		this.row = row;
		this.col = col;
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

	public int getRow(){
		return row;
	}
	
	public int getCol(){
		return col;
	}

	public double getRadius() {
		return radius;
	}
	
}
