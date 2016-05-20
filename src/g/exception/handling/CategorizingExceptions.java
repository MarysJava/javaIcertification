package g.exception.handling;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author mariaane
 *
 */
public class CategorizingExceptions {
	
	
	/* Exceptions can be divided into three main categories:
	- Checked exceptions
	- Runtime exceptions (unchecked exceptions)
	- Errors
 
  	Hierarchy: Object -> Throwable -> Error/Exception 
  			   Exception -> RuntimeException
  
  	IMPORTANT: subclasses of the class java.lang.Exception are categorized as checked exceptions 
  	if they AREN'T subclasses of the class java.lang.RuntimeException
  
  	
  	CHECKED EXCEPTIONS
  
  	Compiler knows something can be wrong... so you need to take some action to prevent it!
  	A checked exception is an unacceptable condition foreseen by the author of a method but outside the immediate control of the code. 
  	For example, FileNotFoundException is a checked exception. This exception is thrown if the file that the code is trying 
  	to access can’t be found. When it’s thrown, this condition is outside the immediate control of the author of the code but 
  	it was foreseen by the author.  	
    A checked exception is a subclass of class java.lang.Exception, but IT'S NOT a subclass of java.lang.RuntimeException. 
    It’s interesting to note, however, that the class java.lang.RuntimeException itself is a subclass of the class 
    java.lang.Exception. You may have to select which type of reference variable to use to store the object of the thrown 
    checked exception in a handler. To answer such questions correctly, remember that a checked exception is a subclass of 
    the java.lang.Exception class, but not a subclass of java.lang.RuntimeException.
 
   If a method uses another method that may throw a checked exception, one of the two following things should be true:
	- The method should be enclosed within a try-catch block 
	or
	- The method should specify this exception to be thrown in its method signature
	
	
	RUNTIME EXCEPTIONS
	
	What is a runtime exception?
	- A runtime exception is a representation of a programming error. These occur from inappropriate use of another piece of code. 
	For example, NullPointerException is a runtime exception that occurs when a piece of code tries to execute some code on 
	a variable that hasn’t been assigned an object and points to null. Another example is ArrayIndexOutOfBoundsException, 
	which is thrown when a piece of code tries to access an array list element at a nonexistent position.
	- A runtime exception is a subclass of java.lang.RuntimeException.
	- A runtime exception MAY (EXAM TRICK HERE) not be a part of the method signature, even if a method MAY throw it.
	- ClassCastException is a RuntimeException
	
	
	ERRORS
	
	An error is a serious exception thrown by the JVM as a result of an error in the environment state that processes your code. 
	For example, NoClassDefFoundError is an error thrown by the JVM when it's unable to locate the .class file that it's supposed to run. 
	StackOverflowError is another error thrown by the JVM when the size of the memory required by the stack of a Java program is 
	greater than what the JRE has offered for the Java application. This error usually occurs as a result of infinite or highly 
	nested loops.
	-  error is a subclass of class java.lang.Error.
	- An error NEED NOT be a part of a method signature.
	- An error CAN be caught by an exception handler, but it SHOULDN'T be.
    */
	

	//CONSTRUCTORS CAN THROWN ONE OR MORE EXCEPTIONS (more exceptions from the same hierarchy too, but is unnecessary)
	public CategorizingExceptions() throws IOException, FileNotFoundException {
		throw new FileNotFoundException(); //If I declare only IOException on constructor signature, 
			// and throw new FileNotFoundException() it's ok because IOException is FileNotFoundException superclass
	}
	
	public static void main(String args[]) {
		String[] students = {"Shreya", "Joseph"};
		int pos = 10;
		//This throws ArrayIndexOutOfBoundsException - Runtime exception, for this I don't need a try/catch block 
		//neither declare method throwing the exception - the codes compile well without this
		//System.out.println(students[pos]); // Uncomment this line and run to see the exception
		
		//In the same way you can catch a checked exception, you can also catch a RuntimeException. In the previous code, 
		//you can prevent ArrayIndexOutOfBoundsException from being thrown by using appropriate checks:
		if (pos > 0 && pos < students.length)
			System.out.println(students[pos]); //This line will not execute in this case because pos > students.length
		
		
		//ERROR
		try {
			myMethod();
		} catch (StackOverflowError s) {
			 // Error handling code for StackOverFlowError may execute but (as the name suggests) may not execute for VirtualMachineError.
			for (int i=0; i<2; ++i)
				System.out.println(i);
		}
	}
	
	public static void myMethod() {
		System.out.println("myMethod");
		myMethod();
	}
}
