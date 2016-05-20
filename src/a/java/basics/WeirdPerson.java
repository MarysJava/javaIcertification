/***********************************************************
* I AM A JAVA SOURCE CODE FILE FOR A CLASS!!!  	 	       *
***********************************************************/

// CLASS STRUCTURE
// PACKAGE STATEMENT - FIRST STATEMENT IN A CLASS - ONLY ONE AND HERE ABOVE ALL
// If you don’t include an explicit package statement in a class or an interface, it’s part of a default package
// Package names should all be in lowercase. Package and subpackage names are separated using a dot (.).
// Package names follow the rules defined for valid identifiers in Java.
package a.java.basics;

//IMPORTS - CLASSES IN OTHER PACKAGES
import static a.teste.another.pack.LoyalDog.*;

import java.util.List;

import a.teste.another.pack.GoodCat;
import a.teste.another.pack.LoyalDog;
import a.teste.another.pack.WeirdPersonSuperClass;

// import java.util.*  import all classes inside Util but not inside the Util subpackages!

// I can import Dog or use in my code the complete reference: a.teste.other.pack.Dog all the time, in this case the import becomes unused

// You can’t use the import statement to access multiple classes or interfaces with the same names from different packages.
//Ex. java.util.Date and java.sql.Date - the code for import both don't compile, so you must chose one to import and refer fully qualified name of the other.

//Default package is automatically imported in the Java classes and interfaces defined within the same directory on your system.
//A class from a default package can’t be used in any named packaged class, regardless of whether they are defined within the same directory or not.

//I can use a IMPORT STATIC like this - so I can use the static var "dogsAge" without prefix it
//import static a.teste.other.pack.Dog.dogsAge; 
//Or I can import all static members/methods from class Dog: import static a.teste.other.pack.Dog.*;

//COMMENTS IF ANY
/**
 * @author mariaane
 *
 */

// CLASS DECLARATION
// Access modifiers (public or 'default') / Nonaccess modifiers (abstract/final)
// Class name + extends + Name of the base class + implements + all implemented interfaces separated by ,
// public final class Runner extends Person implements Athlete {}

// Class body (class fields, methods, constructors), included within a pair of curly braces, {}

// A CLASS CAN'T BE ABSTRACT AND FINAL AT THE SAME TIME
// Modifiers can appears in any order, the valid modifiers to a class are public, default and (final OR abstract)
// private and protected are not valid modifiers for a class

public class WeirdPerson extends WeirdPersonSuperClass{

	//Instance variables or Instance attributes - CAN BE PLACED ANYWHERE INSIDE A CLASS
	//Access modifiers can be applied to classes, interfaces, and their members (instance and class variables and methods). 
	//In you try to use in a local variable or method parameter the code will not compile.
	
	//Modifiers
	//public (least restrictive) / protected / default / private (most restrictive)
		//Visibility:
		//Public: all in the same and separated package, derived and unrelated classes
		//Protected: all in the same package. Only derived classes on separated package
		//Default: all in the same package. Not visible on separated package
		//Private: not accessible outside the class in which they’re defined. NEVER.
	
	private String name;
	private int age;
	private List<WeirdPerson> friends;
	LoyalDog d;
	
	//Cat1 cat1; // It doesn't find class Cat1 because it is in another package with default access modifier
	//If you uncomment here it will not compile.
	
	GoodCat cat; 
	GoodCat cat1 = new GoodCat();
	final static StringBuilder sh = new StringBuilder("Sh");
	
	final int myInt=1; //If I don't initialize myInt here, I need to do this in WeirdPerson constructors. 
	//If one constructor calls another, I can only initialize this final attribute in the first constructor called by JVM
	//otherwise code not compile. It's because a final attribute can be initialized only once in the class.
	static int myInt1;
	
	//NONACCESS MODIFIERS
		//abstract
		//static
		//final
		//synchronized
		//native
		//strictfp
		//transient
		//volatile
	
	//ABSTRACT
	//An abstract class can’t be instantiated
	//An abstract class may or may not define an abstract method. And can have non abstract methods.
	//Adding the keyword abstract to the definition of an interface is redundant because all interfaces are abstract.
	//An abstract method doesn’t have a body. Usually, an abstract method is implemented by a derived class.
	//None of the different types of variables (instance, static, local, and method parameters) can be defined as abstract. Won't compile.
	
	//FINAL
	//A class that is marked final cannot be extended by another class
	//An interface cannot be marked as final because it is abstract and it can't be abstract and final. (Won't compile)
	//A final variable can’t be reassigned a value. (If you try it won't compile).
	//A final method defined in a base class can’t be overridden (same signature) by a derived class.
	
	//STATIC
	//Static variables belong to a class (common to all instances of a class). 
	//A static variable can be accessed using the name of the object reference variable or the name of a class.
	//The static and final nonaccess modifiers can be used to define constants (variables whose value can’t change).
	// You can define a constant as a non-static member, it’s common practice to define constants as static members, 
		// to allows the constant values to be used across objects and classes.
	//Static methods aren’t associated with objects and CAN'T use any of the instance variables of a class.
	//You can also use static methods to define utility methods
	//The non-private static variables and methods are inherited by derived classes.
	//You can’t override the static members in a derived class, but you can redefine them.
	//A static method can be accessed using the name of the object reference variables	and the class in a manner similar to static variables.
	//Neither static methods nor static variables can access the non-static variables and methods of a class. 
	// But the reverse is true: non-static variables and methods can access	static variables and methods because 
	// the static members of a class exist even if no instances of the class exist. 
	// static members are forbidden from accessing instance methods and variables, which can exist only if an instance of the class is created.
	//You can’t prefix the definition of a top-level class or an interface with the keyword static, but
		//you can define a class and an interface as a static member of another class.
		//static class Address {} AND static interface MyInterface {} are Ok.
	
	
	static int x = result(); // Ok because it calls a static method;
	static int result() { return 20; } // static method
	int nonStaticResult() { return result(); } // A instance method calls a static method, it's ok.
	//static int x1 = nonStaticResult(); //Will not compile because nonStaticResult isn't a static method
	
	
	//COMMENTS CAN BE ANYWHERE IN THE CLASS
	//THERE ARE THREE TYPES OF COMMENTS
	
	// SINGLE LINE
	
	/*
	 * MULTIPLE LINE
	 * */
	
	/**
	 * JAVADOC
	 * */

	//CONSTRUCTORS
	//A class can define multiple constructors that accept different sets of method parameters.
	//Constructors can have different access modifiers
	//If I create any constructor I lost the default one (like this below) and need to create it explicitly
	public WeirdPerson() {
	}
	
	public WeirdPerson(String name) {
		this.name=name;
	}
	
	protected WeirdPerson (String name, int age) {
		this.name = name;
		this.age = age;
		age = 50; //The person's age, not the dog's age.
		dogsAge=10; //Works, because I used static import and they are public on Dog's class
		bark(); //Works, because I used static import and they are public on Dog's class
		d = new LoyalDog(); // nickname is protected and is not visible for a class who don't extends Dog
		d.age = 10; //The dog's age
		LoyalDog.age=12; // I can access a static var using the object or the class. 
		LoyalDog d1 = new LoyalDog();
		d1.age=8;
		LoyalDog.age=15;
		System.out.println(LoyalDog.age); // Prints 15
		
		//If I use an object to change the value of a static var, and after I use another object to change this value again
		// and after I use these two objects to read the value of this var, the value will be the same: the last one modified by last object
		// it's because static variables are class variables, not object variables. All objects refers to the same static variable of his class.
		
		cat = new GoodCat(); // Yeah - Cat is a public class
		//cat.name; // But unfortunately cat's name has default access modifier so it's not visible for classes there are not in the same package of Cat's class
		ancestry = "Europe"; // Attribute inherited of PersonSuperClassTest because it is protected
		
		sh.append("aaa"); //Call a method using a final var - it's ok!
		System.out.println(sh.toString()); 
		//sh = new StringBuilder(); //Doesn't work, because I cant't reassign a value to a final var
		
		WeirdPerson.staticTest(); // A static method can be accessed using the name of the class
		
	}
	
	//Only to test the constructor if needed
	public static void main(String[] args) {
		WeirdPerson p = new WeirdPerson("aa",10);
		p.staticTest(); //A static method can be accessed also using object instance
		//this.name="Mary"; //Can't use this in a static context, it's an instance member (non static). Will not compile!
	
		//Final and static test:
		
		//myInt =30; //Can't reassign a value to a final attribute - not compile
		myInt1=40; //I can reassign a value to a static attribute, but all objects and the class 
				   //of this attribute will now have the same value 40!
		
		final int test; //I can declare a final variable or attribute in one line
		test=10; // and initialize it in another line	
		//test=30; //Can't reassign a value to a final var
		
		String notInitialized; //If I never use this var, even if I have not initialized it, will compile fine
		//if(notInitialized==null) 
		//System.out.println("Hello"); // I have not initialized 'notInitialized' variable so these lines above will not compile
	}
		
	
	//METHODS	
	static void staticTest(){
		System.out.println("Static Test");
	}
	
	public String getName() { //Non static method
		//You can't use an instance var in a static method 
		//BUT you CAN use a static var in a non static method
		sh.append("test");		//Sh is a static var - it's ok!
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<WeirdPerson> getFriends() {
		return friends;
	}

	public void setFriends(List<WeirdPerson> friends) {
		this.friends = friends;
	}
	
	
	/*
	 The method hashCode is not called by the equals method to determine the equality of two objects!
	 
	 The method hashCode is used by the collection classes (such as TreeMap and Hash-
Map) that store key-value pairs, where a key is an object. These collection classes use
the hashCode of a key to search efficiently for the corresponding value. The hashCode
of the key (an object) is used to specify a bucket number, which should store its corresponding
value. The hashCode values of two objects can be the same. When these
collection classes find the right bucket, they call the equals method to select the
correct value object (that shares the same key values). The equals method is called
even if a bucket contains only one object. After all, it might be the same hash but a
different equals, and there is no match to get!

According to the Java documentation, when you override the equals method in
your class, you should also override the hashCode method. If you don’t, objects of
your classes won’t behave as required if they’re used as keys by collection
classes that store key-value pairs. This method is not discussed in detail in this
chapter because it isn’t on the exam. But don’t forget to override it with the
method equals in your real-world projects.
	 */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	
	
	/*
	 * 
	 * Two persons are the same if they have the same name (you can choose what make an object unique)
	
	 * Don’t change the name of the method, its return type, or the type of method parameter when you define (override) this
method in your class to compare two objects.
	boolean / equals / Object
	 	
	Equals always use Object as parameter! If I use a Person object (without override) it will compile but has no effect - when objects call equals will be the Object one
	If you try to use another access modifier the code will not compile, because you CAN'T reduce the visibility of an overridden method
	 */
	
	@Override
	public boolean equals(Object obj) { 
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WeirdPerson other = (WeirdPerson) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	/* EQUALS METHOD CONTRACT
	 * 
	 * It is reflexive: for any non-null reference value x, x.equals(x) should return true.
 	   It is symmetric: for any non-null reference values x and y, x.equals(y) should return true if and only if y.equals(x) returns true.
 	   It is transitive: for any non-null reference values x, y, and z, if x.equals(y) returns true and y.equals(z) returns true, then x.equals(z) should
return true.
		It is consistent: for any non-null reference values x and y, multiple invocations of x.equals(y) consistently return true or consistently return false, provided
no information used in equals() comparisons on the objects is modified.
	For any non-null reference value x, x.equals(null) should return false.

	 * 
	 *  An equals method that returns true for a null object passed to it will violate the contract. 
	 *  Also, if the equals method modifies the value of any of the instance variables of the method parameter passed to it, or of the
object on which it is called, it will violate the equals contract.
	 */
}
