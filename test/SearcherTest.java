package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import main.Dog;
import main.Helicopter;
import main.Hiker;
import main.Searcher;

import org.junit.BeforeClass;
import org.junit.Test;

public class SearcherTest {
	private static ArrayList<Searcher> searchers;
	
	@BeforeClass
	public static void setUp(){
		searchers = new ArrayList<Searcher>();
		searchers.add(new Hiker());
		searchers.add(new Dog());
		searchers.add(new Helicopter());
	}

	@Test
	public void searchersHaveName(){
		ArrayList<String> names = new ArrayList<String>();
		names.add("Hiker1");
		names.add("Dog1");
		names.add("Helicopter1");
		
		System.out.println(searchers.toString());
		
		for(int i=0; i<searchers.size(); i++){
			searchers.get(i).setName(names.get(i));
		}
		
		for(int i=0; i<searchers.size(); i++){
			assertEquals(names.get(i), searchers.get(i).getName());
		}
		
	}
	
	//add a test that checks if the searchers have the correct radii.
	//Initially the test will fail, but then when the static ints in each class are changed,
	//the test should pass

	//searchers can share a cell
	@Test
	public void searchersHaveLocation(){// didn't we decide in class to keep these as rows/cols?
		int testRow = 0;
		int testColumn = 0;
		
		for(Searcher s : searchers){
			s.setLocation(testRow, testColumn);
		}
		
		for(Searcher s : searchers){
			assertEquals(testRow, s.getRow());
			assertEquals(testColumn, s.getCol());
		}
		
		//test changing hiker's position
		searchers.get(0).setLocation(++testRow, testColumn);
		assertEquals(testRow, searchers.get(0).getRow());
		assertEquals(testColumn, searchers.get(0).getCol());
		
		//test changing dog's position
		searchers.get(1).setLocation(testRow, ++testColumn);
		assertEquals(testRow, searchers.get(1).getRow());
		assertEquals(testColumn, searchers.get(1).getCol());
		
		//test changing the helicopter's position
		searchers.get(2).setLocation(++testRow, ++testColumn);
		assertEquals(testRow, searchers.get(2).getRow());
		assertEquals(testColumn, searchers.get(2).getCol());
	}
}
