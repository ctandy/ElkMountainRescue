package main;

//This class is for the searchers that update their position automatically (i.e. helicopters and hikers)
public class AutoSearcher extends Searcher{
	
	double speed;
	double dir;
	
	public AutoSearcher(String name, Cell index, double radius, double s, double dir){
		super(name, index, radius);
		this.speed = s;
		this.dir = dir;
	}

}
