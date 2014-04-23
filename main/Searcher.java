package main;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Searcher {
	protected String name;
	private double speed;
	private double direction; // in degrees counterclockwise from positive x-axis
	protected Cell index;
	private double radius;

	public Searcher(){}
	
	public void draw(Graphics g){
		g.fillOval(index.getRow()*Grid.CELL_SIZE + Grid.CELL_SIZE/2, 
				index.getCol()*Grid.CELL_SIZE + Grid.CELL_SIZE/2, Grid.CELL_SIZE*3, Grid.CELL_SIZE*3);
		g.setColor(Color.BLACK);
		g.drawOval(index.getRow()*Grid.CELL_SIZE + Grid.CELL_SIZE/2, 
				index.getCol()*Grid.CELL_SIZE + Grid.CELL_SIZE/2, Grid.CELL_SIZE*3, Grid.CELL_SIZE*3);
		g.drawString(name, index.getRow()*Grid.CELL_SIZE + Grid.CELL_SIZE/2, index.getCol()*Grid.CELL_SIZE);
	}; //Implemented in part II by the child classes

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
