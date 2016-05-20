package c.methods.encapsulation;

/**
 * @author mariaane
 *
 */
public class HighTechConstructors {

	/* CONSTRUCTORS:
	    Constructors are special methods that create and return an object of the class in which they're defined. 
	    Constructors have the same name as the name of the class in which they’re defined, and they don’t specify a return type—not even void.
	  
	   CONSTRUCTORS CAN:
	    Call the base class’s constructor - this can be an implicit or explicit call.
		Initialize all of the instance variables of a class with their default values.
		A constructor does have an implicit return type, which is the class in which it’s defined.
	
	   ENCAPSULATION OR INFORMATION HIDING:
		By exposing object functionality only through methods, you can prevent your private variables from being assigned 
		any values that don’t fit your requirements.
	 */
	
	private String name;
	private int a;
	private static double b;
	
	//I AM A CONSTRUCTOR!
	public HighTechConstructors() {
		// Another constructor call must be the first statement 
		// You can’t call a constructor from any other method in your class.
		// Conditional execution of constructors isn’t allowed - won’t compile.
		// call this() - will not work because it's a recursive call
		this("Mary"); // It works well! Because I'm calling another constructor (different list of parameters/arguments)
		System.out.println("Constructor");
		this.name="Mary";
		//HighTechConstructor("Mary"); //Won’t compile—you can’t invoke a constructor within a	class by using the class's name.
		
	}

	//I AM A CONSTRUCTOR!
	private HighTechConstructors(String name) { // You can overloading a constructor because it's also a method! 
		//Access modifier does not matter to overload a constructor, only arguments list must be different!
		//this();	//It's not allowed here because the HighTechConstructor() calls in its first line this("Mary"); - so it becomes a recursive/circular call
			// Circular call: HighTechConstructor(String name) calling HighTechConstructor(), and HighTechConstructor() calling HighTechConstructor(String name)
			// Ife we want to call this() here, we must remove the line this("Mary") from the HighTechConstructor()
		System.out.println("Constructor Name");
		this.name="Mary"; // Set the value of name to Mary
	}
	
	//I AM A CONSTRUCTOR! Overloaded contructor.
	public HighTechConstructors(int a) {
		System.out.println("Constructor int");
	}
	
	//I AM A CONSTRUCTOR! Overloaded contructor. 
	public HighTechConstructors(double b) {
		this.b=b; //b is a static var, but I can access normally here
		System.out.println("Constructor double");
	}
	
	// I AM A CONSTRUCTOR! Overloaded contructor. 
	// My list of parameters/arguments is different from another constructors
	public HighTechConstructors(double b, String s) {
		System.out.println("Constructor double and String");
	}
	
	//If you define a return type for a constructor Java will treat it as another  method, not a constructor
	//This is a METHOD not a constructor and will not be called when you create the object
	//It’s perfectly fine to define a method that’s not a constructor in a class with the same name.
	public void HighTechConstructor(double a) {
	}
	
	
	/* INITIALIZER BLOCK:
	 * 
	 * Initializer block is defined within a class, not as a part of a method. It executes for every object that’s created for a class.
	 * The initializer block will execute PRIOR to the constructor (independent of order it appears in the code).
	 * 
	 * Initializer blocks are used to initialize the variables of anonymous classes. An anonymous class is a type of inner class. 
	 * In the absence of a name, anonymous classes can’t define a constructor and rely on an initializer block to initialize their variables 
	 * upon the creation of an object of their class.
	 * 
	 * As a Constructor, initialization block can create local variables. It can access and assign values to instance and static variables. 
	 * It can call methods and define loops, conditional statements, and try-catch-finally blocks. 
	 * Unlike constructors, an initializer block CAN'T accept method parameters.
	 * 
	 */
	
	{
		System.out.println("HighTechConstructor:initializer");
		// I'm an initializer block { }
	}
	
	
	// DEFAULT constructor always make an implicit call:  super(); to the constructor of its superclass
	// Java defines a default constructor if and only if you DON'T define a constructor
	// The default constructor has no arguments.
	// If you modify the class later by adding a constructor to it, the Java compiler will remove the default, no argument constructor
	// If you create a constructor that accepts parameters, you lost the default one, so you can't call the default constructor 
	// to construct an object unless you also create it manually
	
	public static void main(String[] args) {
		HighTechConstructors htc = new HighTechConstructors();
		System.out.println(htc.name); //First print Constructor and after prints Mary
		htc = new HighTechConstructors("Joanna");
		htc = new HighTechConstructors(2); //Calls constructor int, in case of one var it's not ambiguous
		htc = new HighTechConstructors(3.0); //Cals constructor double, in case of one var it's not ambiguous
		//The ambiguous problem only occurs when you have a method with double, int pair and another with a int, double pair and try call method(numInt, numInt)
		// like method(1, 2).
		//If you pass the double in a double format like 2.0, it compiles Ok. Remember double is decimal.

	}
}
