package main;

import java.awt.Graphics;

public class Hiker extends Searcher{
	private static Double RADIUS = 0.0;
	
	public Hiker(){
		super();
	}
	
	public Hiker(String n, double s, double d, double r, int row, int col){
		super(n , s, d, r, row, col);
	}

	@Override
	public void move(Grid g) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void draw(Graphics g){
		
	}
}
