package f.inheritance.entities;

import f.inheritance.interfacesInheritance.example.BaseIF1;

/**
 * @author mariaane
 *
 */
public class Employee implements BaseIF1 {

	//PRIVATE MEMBERS WILL NOT BE INHERITED - NEVER!
	private String dogsName="LittleJohn"; //Encapsulation
	protected String name="John"; //Must be protected to be accessed in another package by the derived classes
	protected String address;
	String phoneNumber;
	float experience;
	
	static int teste;
	final int teste1;
	//I can initialize a final variable after declare it, but I can initialize it only once in the code.
	
	public Employee() {
		System.out.println("SUPER CONSTRUCTOR");
		teste=12;
		teste1=10; //If I try to refer the another constructor calling this(1) the code will not compile because I'll initialize twice a constant
	}
	
	public Employee(int val) {
		teste=14; //for a static variable it's ok change its value. This value will be the same for all objects of this class.
		teste1=val; //If I try to refer this() the code will not compile because I'll initialize twice a constant
	}
	
	public Employee(String name) {
		System.out.println("SUPER NAME CONSTRUCTOR");
		this.name = name;
		teste1=2;  //It will not compile if I don't instantiate final var teste1 that was not instantiated before
		
		/* Using variable name within the scope of the Employee class constructor block will implicitly refer to that method’s parameter, 
		not the instance variable. In order to refer to the instance variable name from within the scope of the Employee class 
		constructor, you are obliged to use a 'this' reference.
		'this' refers to the instance of the class in which it’s used. 
		'this' can be used to access the inherited members of a base class in the derived class.
		*/
	}

	public String getName() {
		return name;
	}
	
	public void test() {
		this.name="MarySuper";
		System.out.println(this.name);
	}

	@Override
	public String getPhone() {
		return "MyPhoneNumber";
	}

	//Encapsulation
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setName(String name) {
		this.name = name;
	}	
}