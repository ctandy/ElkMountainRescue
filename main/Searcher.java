package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.Timer;


public class Searcher extends JComponent{
	private String name;
	private double speed;
	private double direction; // in degrees counterclockwise from positive x-axis
	private Cell index;
	private double radius;
	private Color color;
	public static ArrayList<Color> usedColors = new ArrayList<Color>();
	private Random rand;

	public Searcher(){} //For testing the Grid
	
	public Searcher(String name, Cell index, double radius){
		this.name = name;
		this.index = index;
		this.radius = radius;
		setRand(new Random());
		makeRandColor();
	}
	
	//Ensures that no two searchers have the same colors
	public void makeRandColor(){}
	

	public void draw(Graphics g){
		g.setColor(color);
		g.fillOval(index.getCol()*Grid.CELL_SIZE , 
				index.getRow()*Grid.CELL_SIZE , Grid.CELL_SIZE, Grid.CELL_SIZE);
		g.setColor(Color.BLACK);
		g.drawOval(index.getCol()*Grid.CELL_SIZE, 
				index.getRow()*Grid.CELL_SIZE, Grid.CELL_SIZE, Grid.CELL_SIZE);
		//g.drawString(name, index.getRow()*Grid.CELL_SIZE + Grid.CELL_SIZE/2, index.getCol()*Grid.CELL_SIZE);
	}
	
	public void move(){
		int introw = index.getRow();
		int intcol = index.getCol();
		int newrow, newcol;
		while(true){
			int dx = (int) (Math.round(Math.cos(Math.toRadians(direction))));
			int dy = (int) (Math.round(Math.sin(Math.toRadians(direction))));
			newrow = introw-dy;
			newcol = intcol+dx;
			if ((newrow<0 || newrow>Grid.MAX_ROW-1) || (newcol<0 || newcol>Grid.MAX_COL-1)){
				setDirection(Math.random()*360);
			}
			else {
				index.setRow(newrow);
				index.setCol(newcol);
				setIndex(index);
				break;
			}
		}
	}

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

	public Random getRand() {
		return rand;
	}

	public void setRand(Random rand) {
		this.rand = rand;
	}

}
