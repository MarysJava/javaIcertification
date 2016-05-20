package g.exception.handling.rafting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author mariaane
 * 
 */
public class ProudMaryRiverRafting extends RiverRaftingBase implements RollingInTheRiverIF {

	ProudMaryRiverRafting() {
		
	}
	
	ProudMaryRiverRafting(RiverRaftingBase b) {
		
	}
	
	ProudMaryRiverRafting(ProudMaryRiverRafting r) {
		
	}
	
	void crossRapid(int degree) throws FallInRiverException {
		System.out.println("Cross Rapid");
		if (degree > 10)
			throw new FallInRiverException();
	}

	
	//Base method and this overridden method CAN throw how many Errors or RUNTIME exceptions they want freely
	//If the base method throws a CHECKED exception, this overridden method CAN throw the same exception or a subclass of the exception 
	//throwed by superclass OR can throw nothing in his signature, BUT, if it throws must be a compatible one
	
	//I can use protected here because in the base class the access modifier is default
	//But if I implement RollingInTheRiverIF that has the same method, I NEED TO TURN MODIFIER ACCESS TO PUBLIC
	//because I can't have a more restrictive access modifier in a overridden method
	public void rowRaft(String state) {
		System.out.println("Row Raft");
		if (state.equals("nervous"))
			//If the if clause does not has a {} block. This try block works here, because try block is consider one statement (and it's a block)
			try {
				throw new DropOarException(); //I can throw an exception and catch it in sequence this like this
			} catch (DropOarException e) {
				//e.printStackTrace();
			}
	}

	//Main is the last method in the stack trace, so it will not handle the exceptions and shows the stack trace if I
	//don't put a specific try/catch clause in it.
	public static void main(String[] args) throws DropOarException, FallInRiverException {
		ProudMaryRiverRafting riverRafting = new ProudMaryRiverRafting();
		
		//If I try to call methods which throws checked exceptions
		// without a try/catch block, it will not compile, it will shows a UnhandleException
		
		//It will happen unless the method signature indicate it throws the exception for another method  - 
		// like: throws DropOarException, FallInRiverException {
		
		//The main method has no other method to pass the handling of exceptions 
		// so it can do this in its signature: throws DropOarException, FallInRiverException (compiles) but it doesn't have effect
		
		//riverRafting.crossRapid(11);
		//riverRafting.rowRaft("happy");
		
		//Main method can throw exceptions
		
		//A method can throw and handle the same exceptions
		
		try {
			riverRafting.crossRapid(11);
			riverRafting.rowRaft("happy"); //This line will never execute because first line throws an exception
			System.out.println("Enjoy River Rafting");
		} catch (FallInRiverException e1) {
			System.out.println("Get back in the raft");
		} //catch (DropOarException e2) {
			//System.out.println("Do not panic");
		//	} 
		finally {
			System.out.println("Pay for the sport"); //This line will ALWAYS execute
		}
		System.out.println("After the try block");
		
		System.out.println();
		ProudMaryRiverRafting rr = new ProudMaryRiverRafting();
		System.out.println("GetInt: "+rr.getInt());
		System.out.println("GetInt1: "+rr.getInt1());
		System.out.println("SB: "+ rr.getStringBuilder());
		
		
		//Prints:
		//Test
		//Next task...
		//IMPORTANT: Finally and catch positions CAN NOT BE CHANGED - NEVER
		System.out.println();
		FileInputStream fis = null;
		try {
			System.out.println("Test");
			if(fis==null)
			return; //FINALLY WILL EXECUTE EVENT WITH A RETURN CLAUSE HERE.
			fis = new FileInputStream("file.txt");
			System.out.println("File Opened");
			fis.read();
			System.out.println("Read File ");
		} catch (FileNotFoundException fnfe) {
			System.out.println("File not found");
			return;
		} catch (IOException ioe) {
			System.out.println("File Closing Exception");
			return; //FINALLY WILL EXECUTE EVENT WITH A RETURN CLAUSE HERE.
		} finally {
			System.out.println("finally"); 
		}
		System.out.println("Next task..");
		
		
		//Testing try/catch throwing exceptions
		try {
			//throw new FileNotFoundException(); //NOT COMPILE - there's not a catch block and we have an UNHANDLED CHECKED EXCEPTION
			//If I put the correct catch block below, it's ok, code will work
		} finally {
			
		}	
		
		//If I have a try block throwing something, code after the try/catch/finally block
		//becomes unreachable code unless I have a catch for the exception I'm throwing
		//In this case below if I don't put the catch clause, the System.out.println("Test2"); becomes unreachable code
		
		//Finally is always a reachable code, and it will always execute even if I have a return statement
		try {
			throw new NullPointerException();
			//System.out.println("Test"); // Unreachable code
		} catch (NullPointerException e) {
			System.out.println("Test"); //OK!
			//Now it's fine! I have a catch
		} finally {
			
		}
		
		System.out.println("Test2"); //I'm a reachable code
		
		//Testing try/catch throwing exceptions
		try {
			throw new NullPointerException(); //It's OK because NullPointerException is a RuntimeException
		} finally {
					
		}
		
		//The code here becomes unreachable because of the throw new NullPointerException(); above 
		//If I try to put code here it not compile
	}

	int getInt() {
		try {
			String[] test = { "Harry", "Paul" };
			System.out.println(test[5]);
		} catch (Exception e) {
			return 10; // Pass here
		} finally {
			return 20; // Pass here and return 20
		}
	}

	int getInt1() {
		int returnVal = 10;
		try {
			String[] test = { "Harry", "Paul" };
			System.out.println(test[5]);
		} catch (Exception e) {
			return returnVal; // Return 10 because catch block makes a copy of the returnVal value
							  // (to be returned) before it executes so the assignment of another value
							  // in finally block does not work
			//Primitives are passed by value and objects are passed by reference.
		} finally {
			returnVal += 10;
			// Finally can't modify the value copied by catch block
			// If I return returnVal here it will return 20, but if I don't, the
			// returnVal to be returned is one from the catch block
			// So the assignment above has no effect over it
		}
		// TRICK: if the catch block executes, 
		// AND IF IT HAS A RETURN STATEMENT
		// this code below will not execute. 
		// Only finally code will execute.
		return returnVal; // If I return returnVal here it will return 20 in
						  // this case no exception was thrown AND CODE INSIDE CATCH WAS NOT EXECUTED
	}

	StringBuilder getStringBuilder() {
		StringBuilder returnVal = new StringBuilder("10");
		try {
			String[] students = { "Harry", "Paul" };
			System.out.println(students[5]);
		} catch (Exception e) {
			System.out.println("About to return :" + returnVal);
			return returnVal;
		} finally {
			returnVal.append("10");
			System.out.println("Return value is now :" + returnVal);
			//In this case returns 1010 because when the finally block executes, it can access the value of the OBJECT 
			//referred to by the variable returnVal and can modify it.
			//Primitives are passed by value and objects are passed by reference.
		}
		return returnVal; //If an exception is thrown this code does not execute
	}
		
		/* Even though the finally block adds 10 to variable returnVal, this modified value is not returned to the method main. 
		   Control in the catch block copies the value of returnVal to be returned before it executes the finally block, so the returned value
is not modified when finally executes.

		  IMPORTANT: If both catch and finally blocks define return statements, the calling method will receive a value from the FINALLY block.
		  If finally does not have a return, but catch has, and the code entered in the catch block, so the return of catch will be the valid one.
		  If I change the state of the object in a finally block, it will be reflected in the catch block.
		  If I change the value of a primitive it does not has effect in the catch block because it makes a copy of the primitive value.	
		 
	   	  When you execute methods that may throw checked exceptions (exceptions
	      that don’t extend the class RuntimeException), enclose the code within a
	      try block. Catch blocks that follow a try block should handle all the
	      checked exceptions thrown by the code enclosed in the try block
	  
	      For a try block, you can define multiple catch blocks, but only a single finally block. 
	      Multiple catch blocks are used to handle different types of exceptions. 
	      A finally block is used to define cleanup code — code that closes 
	      and releases resources, such as file handlers and database or network connections
	 
	      There are a few scenarios in Java in which a finally block does not execute: 
	      - Application termination: The try or the catch block executes System.exit, which terminates the application
		  - Fatal error - A crash of the JVM or the Operational System
	 */
}
