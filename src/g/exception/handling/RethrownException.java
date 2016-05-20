package g.exception.handling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author mariaane
 * 
 */
public class RethrownException {

	/* Can I rethrow an exception or the error I catch? You can do whatever you want with an exception. 
	 * Rethrow it, pass it on to a method, assign it to another variable, upload it to a server, send it in an SMS, and so on.*/

	FileInputStream soccer;

	/* When you rethrow a checked exception, it’s treated like a regular thrown checked exception, meaning that all the rules of handling a 
	 * checked exception apply to it. In the code below, if the code neither “caught” the rethrown FileNotFoundException
	 * exception nor declared that the method myMethod would throw it using the throw clause in its signature, the code will fail to compile.
	 * 
	 * Another interesting point to note is that the code doesn’t apply to a RuntimeException. 
	 * You can rethrow a runtime exception, but you’re not required to catch it, nor must you modify your method signature to include the 
	 * throws clause.
	 * The simple reason for this rule is that RuntimeExceptions aren’t checked exceptions, and they (MAY or MAY NOT) be caught or declared 
	 * to be thrown by your code.
	 * 
	 * If a method doesn’t wish to handle the checked exceptions thrown by a method it calls, it can throw these exceptions using the 
	 * throws clause in its own method signature. 
	 * 
	 * Examine the following example, in which the method myMethod doesn’t include an exception handler; instead, it rethrows the IOException 
	 * thrown by a constructor of the class FileInputStream using the throws clause in its method signature
	 */
	
	
	//In this case I surround this with try/catch
	public void myMethod() { 
		try {
			soccer = new FileInputStream("soccer.txt");
		} catch (FileNotFoundException fnfe) {
			System.out.println("FileNotFoundException occurs");
		} 
	}
	
	//In this case I declare that this method thrown the exception 
	public void myMethod1() throws IOException {
		FileInputStream soccer = new FileInputStream("soccer.txt");
		soccer.close();
	}
	
	//In this case I surround this with try/catch BUT in the catch clause I throw the FileNotFoundException
	//so I need to use throws FileNotFoundException in the method signature, because I'm not handling with the exception inside the method
	public void myMethod2() throws FileNotFoundException  { 
		try {
			soccer = new FileInputStream("soccer.txt");
		} catch (FileNotFoundException fnfe) {
			throw fnfe; 
		} 
	}
	
	/* In case of throws FileNotFoundException in the signature
	 * any method that calls myMethod1 or myMethod2 must now either catch and handle the checked exception or declare that it will be 
	 * rethrown in its method signature. 
	 * 
	 * Note that FileNotFoundException is a IOException 
	 * So in case of myMethod2 any method that calls it can catch or throw one or both of these Exceptions 
	 * In case of myMethod1 any method that calls it must catch or thrown IOException */
	
	
	//Here's a test about NESTED exceptions
	static public void testNestedExceptions() {
		FileInputStream players, coach=null;
		try {
			//CREATE AN EMPTY players.txt FILE IN YOUR C: DIRECTORY
			players = new FileInputStream("C:\\players.txt"); //File exists
			System.out.println("File C:\\players.txt found"); //Prints here 
			try {
				players = new FileInputStream("C:\\playe"); //File doesn't exist - wrong name - IOException is being catched by the outer catch
				coach.close(); 
				//In this case coach.close will never execute because line above throws an IOException
				//coach.close() throws a checked exception of type IOException
				//I don't need to catch this in the inner try/catch block because I'm already catching it in the outer try/catch block
			} catch (NullPointerException e) { 
				System.out.println("coach.txt not found"); 
			}
		} catch (IOException io) {
			System.out.println("File C:\\playe not found"); //Prints here 
		} catch (NullPointerException ne) { 
			System.out.println("NullPointerException"); 
			throw ne;
		}
	}
	
	//Here's another test about NESTED exceptions
	static public void testNestedExceptions1() {
		FileInputStream players, coach=null;
		try {
			//CREATE AN EMPTY players.txt FILE IN YOUR C: DIRECTORY
			players = new FileInputStream("C:\\players.txt"); //File exists
			System.out.println("File C:\\players.txt found"); //Prints here 
			try {
				coach.close(); //coach was not initialized, throws NullPointerException
			} catch (IOException e) { //There's no catch for the NullPointerException, so pass to the outer try/catch block
				System.out.println("coach.txt not found");
			}
		} catch (FileNotFoundException fnfe) {
			System.out.println("players.txt not found");
		} catch (NullPointerException ne) { //Hey in the outer block there's a catch for NullPointerException, it can be used!
			System.out.println("testNestedExceptions1 method: NullPointerException"); //Prints NullPointerException
			throw ne; //The code throw exception here and the method who calls this one is the main method
			//If I put a try/catch inside the main method to deal with NullPointerException the stack will not be printed
			//otherwise the stack trace will be printed
		}
	}
	
	public static void main(String[] args) {
		testNestedExceptions();

		//If I put a try/catch inside the main method to deal with NullPointerException the stack will not be printed
		System.out.println();
		try {
		testNestedExceptions1();
		} catch (NullPointerException npe) {
			System.out.println("Main method: NullPointerException");
		}
		
		//Otherwise the stack trace will be printed
		System.out.println();
		testNestedExceptions1();
		
	}
	
}
