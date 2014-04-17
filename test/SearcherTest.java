package test;

import static org.junit.Assert.*;
import main.Dog;
import main.Helicopter;
import main.Hiker;

import org.junit.BeforeClass;
import org.junit.Test;

public class SearcherTest {
	private Hiker hiker;
	private Dog dog;
	private Helicopter helicopter;
	
	@BeforeClass
	public void setUp(){
		hiker = new Hiker();
		dog = new Dog(null, 0, 0, null);
		helicopter = new Helicopter();
	}

	@Test
	public void searchersHaveName(){
		String hikerName = "Hiker1";
		String dogName = "Dog1";
		String heliName = "Helicopter1";
		
		hiker.setName(hikerName);
		dog.setName(dogName);
		helicopter.setName(heliName);
		
		assertEquals(hikerName, hiker.getName());
		assertEquals(dogName, dog.getName());
		assertEquals(heliName, helicopter.getName());
		
	}

}
