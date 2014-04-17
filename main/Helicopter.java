package main;

public class Helicopter extends Searcher {

	private static Double RADIUS=0.0;
	
	public Helicopter(){
		super();
	}
	
	public Helicopter (String n, double s, double d, double r, int row, int col){
		super(n , s, d, r, row, col);
	}

	@Override
	public void move(Grid g) {
		// TODO Auto-generated method stub
		
	}
}
