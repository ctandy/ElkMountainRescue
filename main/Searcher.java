package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JComponent;




@SuppressWarnings("serial")
public class Searcher extends JComponent{
	private String name;
	private double speed;
	private double direction; // in degrees counterclockwise from positive x-axis
	protected Cell index;
	private double radius;
	private Color color;
	public static ArrayList<Color> usedColors = new ArrayList<Color>();
	protected Random rand;

	public Searcher(){} //For testing the Grid
	
	public Searcher(String name, Cell index, double radius){
		this.name = name;
		this.index = index;
		this.radius = radius;
		rand = new Random();
		makeRandColor();
		
	}
	
	//Ensures that no two searchers have the same colors
	public void makeRandColor(){}
	

	public void draw(Graphics g){
		g.setColor(color);
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
	
	public void setColor(Color color){
		this.color = color;
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
	
	public Color getColor(){
		return color;
	}

}
