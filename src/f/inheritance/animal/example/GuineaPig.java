package f.inheritance.animal.example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author mariaane
 *
 */

public class GuineaPig extends Animal {
	
	static final int myInt=20;
	static int myInt1=30;
	
	static double d;
	static float f;
	
	String test;
	
	GuineaPig() {
		this(10);
		System.out.println("GuineaPig");
	}
	
	GuineaPig(int i) {
		super(10);
		System.out.println("Int");
	}
	
	
	//Test covariant returns:
	
	//If base class returns type Animal (class) I can return Animal or any subclass
	
	//I can't throw Exception because the method in the base class don't throw any Cheked Exception
	//But I can throw RuntimeExceptions and Errors
	public Animal doSomething() throws RuntimeException, NullPointerException, StackOverflowError { //
		try {
			System.out.println(test.charAt(0)); //I MAY (trick) or may not use try/catch here, and I may or may not put throws Exception in the method signature
			//In this case my code don't throw a checked exception, so I can't catch a specific checked exception
			//If I try to catch a specific CHECKED exception, code will not compile because compiler knows the code will not throw a checked exception, he checked it by himself! =P
				//(If your code throws a checked exception and you don't catch it your code will not compile too)
			//But I can catch Exception that is a superclass of RuntimeException and Throwable that is the superclass of all
			//I also can catch an error
		} catch (Error e) {
		}
		return null;
	}
	
	
	//If base class returns type AnimalIF interface
	//I can return any of 4 types:
		//Can return AnimalIF because its original return in base class
		//Can return GuineaPigIF because GuineaPigIF extends AnimalIF
		//Can return GuineaPig because GuineaPig extends Animal which implements GuineaPigIF which extends AnimalIF
		//Can return Animal because Animal implements GuineaPigIF which extends AnimalIF
	//Interfaces has a wide range of covariant returns
	
	//Base class throw Exception, I can throws Exception or any of its subclasses even a checked exception , OR NOT THROW ANYTHING
	//Remeber Checked Exception are Exceptions but not child of RuntimeException!
	public AnimalIF doSomething1() throws IOException {
		return null;
	}
	
	
	//If base class returns type GuineaPig class (more restrictive in this case)
	//I can return only GuineaPig
	//CAN'T return Animal because it's a superclass
	//CAN'T return AnimalIF or GuineaPigIF because the return type in superclass is not an interface, it's a class
	
	//Here the superclass throws Throwable - so I can do the same or not and it's subclasses too
	public GuineaPig doSomething2() throws Throwable, Exception, RuntimeException, IOException { 
		return null;
	}
	
	//If base class returns type GuineaPigIF interface
	//I CAN'T return AnimalIF because is a superclass of the interface
	//Can return Animal because Animal implements GuineaPigIF
	//Can return GuineaPigIF because its original return in base class
	//Can return GuineaPig because GuineaPig extends Animal which implements GuineaPigIF
	
	//If Animal does not implements GuineaPigIF, but implements AnimalIF, Animal and GuineaPig implements only superclass of an interface and GuineaPig (subclass of interface) 
	// would not be a valid return, would not compile because the compiler don't know about the subclass of the interface
	//If the base class method throw any checked exception I can throw any checked exception in the subclass method
	//If a base class method doesn't throw any CHECKED EXCEPTION, an overriding	method in the derived class can't throw any checked exception 
	//But can throw Errors and Runtime Exceptions if it wants to
	public GuineaPigIF doSomething3() throws NullPointerException, FileNotFoundException {
		return null;
	}
	
	public static void main(String[] args) {
		GuineaPig g = new GuineaPig(1);
	}
}