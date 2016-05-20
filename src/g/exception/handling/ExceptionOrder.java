package g.exception.handling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author mariaane
 * 
 */
public class ExceptionOrder {

	/* Order doesn’t matter for unrelated classes. But it does matter for
	  related classes sharing an IS-A relationship.
	 
	  In the latter case, if you try to catch an exception of the base class
	  before an exception of the derived class, your code will fail to compile.
	
	  The order of placement of exception handlers is important.
	 */
		
	public static void main(String args[]) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("file.txt");
			fis.close();
		} catch (FileNotFoundException ioe) { //Here it's OK because first I catch the derived one and after the generic (base class)
			System.out.println("IOException");
		} 
		catch (IOException ioe) { //I can't catch the same exception twice of course
			System.out.println("IOException");
		}
		//Java doesn’t compile code if it contains unreachable statements.
		//	} catch (FileNotFoundException fnf) { //WILL NOT COMPILE - UNREACHABLE CATCH BLOCK 
												  //because FileNotFoundException is derived class from IOException and it was already catched above 
		//		System.out.println("file not found");
		//	}
		
		
		//The code below will not compile because the code inside try throw checked exceptions.
		//If the method throws this exceptions, so it will compile
		//IMPORTANT: I CAN have a block try{} with only a finally but it's not enough to handle the exceptions thrown by the code
		//	try {
		//		fis = new FileInputStream("file.txt");
		//		fis.close();
		//	} finally {
		//			
		//	}
	}
	
	/*  RULES:
	    - A try block may be followed by multiple catch blocks, and the catch blocks may be followed by a single finally block.
		- A try block may be followed by either a catch or a finally block or both. 
		But a finally block alone wouldn’t suffice if code in the try block throws a checked exception. 
		In this case, you need to catch the checked exception or declare it to be thrown by your method. 
	    - Otherwise your code won’t compile.
	    - The try, catch, and finally blocks can’t exist independently.
        - The finally block can’t appear before a catch block.
		- A finally block always executes, regardless of whether the code throws an exception.
	 */
}
