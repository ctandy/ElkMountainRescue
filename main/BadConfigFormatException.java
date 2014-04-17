package main;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;

public class BadConfigFormatException extends Exception { //exception? or runtime exception?
	PrintWriter writer;
	public BadConfigFormatException(String s) {
		super(s);
		try {
			writer = new PrintWriter("ConfigErrorLog.txt");
			writer.println(s);
			writer.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
	public BadConfigFormatException() {
		super();
		try {
			writer = new PrintWriter("ConfigErrorLog.txt");
			writer.println("Unidentified BadConfigFormatException thrown.");
			writer.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
}