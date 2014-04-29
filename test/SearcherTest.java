package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import main.Dog;
import main.Grid;
import main.Helicopter;
import main.Hiker;
import main.NormalCell;
import main.Searcher;

import org.junit.BeforeClass;
import org.junit.Test;

public class SearcherTest {
	private static ArrayList<Searcher> searchers;
	
	@BeforeClass
	public static void setUp(){
		searchers = new ArrayList<Searcher>();
		searchers.add(new Hiker(null, null, 0, 0));
		searchers.add(new Dog(null, null));
		searchers.add(new Helicopter(null, null, 0, 0));
	}

	@Test
	public void searchersHaveName(){
		ArrayList<String> names = new ArrayList<String>();
		names.add("Hiker1");
		names.add("Dog1");
		names.add("Helicopter1");
		
		for(int i=0; i<searchers.size(); i++){
			searchers.get(i).setName(names.get(i));
		}
		
		for(int i=0; i<searchers.size(); i++){
			assertEquals(names.get(i), searchers.get(i).getName());
		}
		
	}
	
	//test that classes have the correct radii
	//the numbers below are made up, please change them once we decide what the ranges
	//should actually be
	@Test
	public void searchersHaveCorrectRadii(){
		final double HIKER_RADIUS = 3.0;
		final double DOG_RADIUS = 5.0;
		final double HELICOPTER_RADIUS = 10.0;
		
		assertTrue(HIKER_RADIUS == searchers.get(0).getRadius());
		assertTrue(DOG_RADIUS == searchers.get(1).getRadius());
		assertTrue(HELICOPTER_RADIUS == searchers.get(2).getRadius());
		
	}
	
	@Test
	public void searchersHaveCell(){
		int testRow = 0;
		int testColumn = 0;
		
		//test initial conditions allow for searchers to share cell
		for(Searcher s : searchers){
			s.setIndex(new NormalCell(testRow, testColumn));
			assertEquals(testRow, s.getIndex().getRow());
			assertEquals(testColumn, s.getIndex().getCol());
		}
		
		//check that new location can be set by passing in a new cell
		for(Searcher s : searchers){
			s.setIndex(new NormalCell(++testRow, testColumn));
			assertEquals(testRow, s.getIndex().getRow());
			assertEquals(testColumn, s.getIndex().getCol());
		}
	}
	
	@Test
	public void SearchersHaveDifferentColors(){
		assertFalse((searchers.get(0).getColor()).equals(searchers.get(1).getColor()));
	}
	
	@Test
	public void testMove() {
		Searcher s = new Searcher();
		
		//test for redirecting the team when it hits a wall
		s.setDirection(180.0);
		s.setIndex(new NormalCell(0, 0));
		s.setSpeed(3.0);
		s.move();
		assertTrue(s.getIndex().getRow() >= 0);
		assertTrue(s.getIndex().getRow() <= s.getSpeed());
		assertTrue(s.getIndex().getCol() <= s.getSpeed());
		assertTrue(s.getIndex().getCol() >= 0);
		
		//test for a normal move
		s.setDirection(270);
		s.setIndex(new NormalCell(0, 0));
		s.setSpeed(2.0);
		s.move();
		NormalCell testCell = new NormalCell(1, 0);
		assertTrue(s.getIndex().equals(testCell));
		
		//test for excessive speed
		s.setDirection(315);
		s.setIndex(new NormalCell(0, 0));
		s.setSpeed(1000.0); //can input any speed, move will stay in grid
		s.move();
		assertTrue(s.getIndex().getRow() >= 0);
		assertTrue(s.getIndex().getRow() < Grid.MAX_ROW);
		assertTrue(s.getIndex().getCol() < Grid.MAX_COL);
		assertTrue(s.getIndex().getCol() >= 0);
	}
}
