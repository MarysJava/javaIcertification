package g.exception.handling;

/**
 * @author mariaane
 *
 */
public class ExceptionalException {
	
	/* Creating an object of class File can throw the checked exception java.io.FileNotFoundException. 
	 * The methods read, write, and close defined in classes FileInputStream and FileOutputStream can throw the checked 
	 * exception java.io.IOException. Note that FileNotFoundException is a subclass of IOException.
	 */

	public static void main(String args[]) { // line 2
		method1(); // line 3
	} // line 4

	public static void method1() { // line 5
		method2(); // line 6
	} // line 7

	public static void method2() { // line 8
		String[] students = { "Shreya", "Joseph" }; // line 9
		System.out.println(students[5]); // line 10
	}
	
	/* The following is an example of a try-catch block that WILL NOT COMPILE because it tries to catch 
	   a checked exception that’s never thrown by the try block:
		
	   try {
		++a;
	   }
	   catch (java.io.FileNotFoundException e) {
	   }
	 */

	 /* FLOW:
	    1 When the method main starts its execution, its instructions are pushed onto the stack.
		2 The method main calls the method method1, and instructions for method1 are pushed onto the stack.
		3 method1 calls method2; instructions for method2 are pushed onto the stack.
		4 method2 throws an exception: ArrayIndexOutOfBoundsException. Because method2 doesn’t handle this exception itself, 
		it’s passed on to the method that called it — method1.
		5 method1 doesn’t define any exception handler for ArrayIndexOutOfBoundsException, so it hands this exception over to 
		its calling method — main.
		6 There are no exception handlers for ArrayIndexOutOfBoundsException in main. Because there are no further methods that 
		handle ArrayIndexOutOfBoundsException, execution of the class Trace stops.
		
		stack trace works with handled and unhandled exceptions.

		Stack Trace from the point of an exception to the calling method - all methods involved:
		Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Array index out of range: 5
		at g.exception.handling.ExceptionalException.method2(ExceptionalException.java:24)
		at g.exception.handling.ExceptionalException.method1(ExceptionalException.java:20)
		at g.exception.handling.ExceptionalException.main(ExceptionalException.java:17)
	
		All types of exceptions subclass java.lang.Throwable.
	
		When a piece of code hits an obstacle in the form of an exceptional condition, it creates an object of class 
		java.lang.Throwable (at runtime an object of the most appropriate subtype is created), initializes it with the necessary 
		information (such as its type, an optional textual description, and the offending program’s state), and hands it over to 
		the JVM. The JVM blows a siren in the form of this exception and looks for an appropriate code block that can “handle” 
		this exception.
		The JVM keeps an account of all the methods that were called when it hit the offending code, so to find an appropriate 
		exception handler it looks through all of the tracked method calls.

	    Try what?
			First you try to execute your code. If it doesn’t execute as planned, you handle the exceptional conditions using a 
			catch block.
	   
	   Catch what?
			You catch the exceptional event arising from the code enclosed within the try block and handle the event by defining 
			appropriate exception handlers.
	   
	   What does finally do?
			Finally, you execute a set of code, in all conditions, regardless of whether the code in the try block throws 
			any exceptions.
	 */		
		
}
