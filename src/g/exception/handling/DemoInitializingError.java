package g.exception.handling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;


/**
 * @author mariaane
 *
 */

public class DemoInitializingError {

	//Try to uncomment some lines (some of them each time) to understand what's happen
	//For example, uncomment the String test declaration and run, 
	//after modify the getName() to throw new StackOverflowError(); and run again 
	
	
	//After the first test, uncomment the Line2, 
	//comment the line FileReader fr = new FileReader(new File("test.txt")); of the static initialization block
	//and comment the throw exception of getName(), uncomment the line //return "Test";
	//Run again and see what happen
	
	//Uncomment the line FileReader fr = new FileReader(new File("test.txt")); of the static initialization block
	//Run again and see what happen
	
	
	//static String test = getName(); //Line 1
	//static int nameLength = test.length(); // Throws ExceptionInInitializerError  //Line 2
	static String var;
	
	static {
		//int num = Integer.parseInt("sd", 16); //Line 3
		//If I do something that can throw checked exception here, I must use try/catch surrounding the code or code will not compile
		//throw new StackOverflowError(); //Will not compile - You can't never throw a checked exception or an error inside a initialization block (static or not)
		try {
			var = getName();
			//The code below can throw a checked exception and only compiles because it's inside a try/catch
			FileReader fr = new FileReader(new File("test.txt")); 
		} catch (Exception e) {
			throw new NullPointerException();  //Compile but... throws an ExceptionInInitializerError
			//You CAN'T throw a checked exception inside a initialization block (static or not) - NEVER
			//WILL NOT COMPILE
		}
	}
	
	
	public static void main(String[] args) {
		//Throws ExceptionInInitializerError ONLY IF THE INITIALIZATION BLOCK IS STATIC, else throws NumberFormatException 
		//DemoInitializingError d = new DemoInitializingError();
		//DemoInitializingError.test="Hello"; //If the INITIALIZATION BLOCK IS not static, in this case, nothing happens, because the block will not execute
		System.out.println(DemoInitializingError.class); // Throws ExceptionInInitializerError when try to load the class because of lines 1, 2 or 3
	}
	
	static String getName() {
		
		throw new NullPointerException();
		//throw new StackOverflowError(); // I can do this but will be a StackOverflowError not an ExceptionInInitializerError
		
		//return "Test";
		
		/*If I try checked exception here, I must use try/catch or declaring throws into the method signature or code will not compile
		  In this case I'm preventing the exception in line static String test = getName();
		
		  ExceptionInInitializerError can be caused only by a runtime exception
		  
		  If a static initializer block throws an error, it doesn’t recover from it to come back to the code to throw an 
		  ExceptionInInitializerError. 		  
		  This error can’t be thrown if a static initializer block throws an object of a checked exception because the Java
compiler is intelligent enough to determine this condition and doesn’t allow you to throw an unhandled checked exception from a static initialization block.
		 */
	}
	
}
