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
	private ArrayList<Searcher> searchers;
	private Hiker hiker;
	private Dog dog;
	private Helicopter helicopter;
	
	@BeforeClass
	public void setUp(){
		ArrayList<String> names = new ArrayList<String>();
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
	
	//add a test that checks if the searchers have the correct radii.
	//Initially the test will fail, but then when the static ints in each class are changed,
	//the test should pass

	//searchers can share a cell
	@Test
	public void searchersHaveLocation(){// change this test to work with Cell indices
		int testRow = 0;
		int testColumn = 0;
		
		hiker.setIndex(testRow, testColumn);
		dog.setIndex(testRow, testColumn);
		helicopter.setIndex(testRow, testColumn);
		
		assertEquals(testRow, hiker.getRow());
		assertEquals(testColumn, hiker.getCol());
		assertEquals(testRow, dog.getRow());
		assertEquals(testColumn, dog.getCol());
		assertEquals(testRow, helicopter.getRow());
		assertEquals(testColumn, helicopter.getCol());
		
		hiker.setIndex(++testRow, testColumn)
		assertEquals(testRow, hiker.getRow());
		assertEquals(testColumn, hiker.getCol());
		
		dog.setIndex(testRow, ++testColumn);
		assertEquals(testRow, dog.getRow());
		assertEquals(testColumn, dog.getCol());
	}
}
