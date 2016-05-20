package f.inheritance.interfacesInheritance.example;

/**
 * @author mariaane
 *
 */
public class MySubClass extends MySuperClass implements ChildIF {

	//ChildIF inherit getName from BaseIF1 and BaseIF2, but
	//Here is the method getName, implemented only once
	//The interface purpose is only to guarantee the class will have a method with that name and return type, I can trust in this
	
	//MySubClass also extends MySuperClass that has a String getName() 
	//It doesn't matter if these methods are equal, because the only thing that matter is the
	//MySubClass implements all methods in its IF's 
	//and if IT WANTS, override methods of MySuperClass
	public String getName() {
		System.out.println("Name");
		String name ="Mary";
		return name;
	}
	
	//If MySuperClass defines a getPhone (same method name as defined in BaseIF1) with another return type, 
	// JVM would be confused about the interface method and overriden method. It does not work!
	//Two methods with the same name and different return types (and same arguments), in two different interfaces implemented by the class,
	// or one in the interface implemented by the class and another in the superclass does not work.
	//The question is, how JVM will know who you are calling? 
	//Only if the methods have different names or different arguments you know this 
	public String getPhone() {
		return "MyPhone";
	}
}
