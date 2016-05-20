package b.data.types;

import a.java.basics.WeirdPerson;

/**
 * @author mariaane
 *
 */
public class ObjectReferenceVariables {

	/*
	 * Object reference variables or object references.
	 * Primitive variables store the actual values, whereas reference variables store the ADDRESSES of the objects they refer to
	 */

	WeirdPerson p = null; //Reference p has no object attached
	WeirdPerson p1 = new WeirdPerson(); //Reference p1 has an object attached
	WeirdPerson p2 = p1; // One object (p1) has two references for it
	static int myInt;
	int i = 0;
	
	// Reference is like a leash and object is like a dog.
	// You can have a dog with more than a leash, you can have a leash without  a dog, and you can have a dog without a leash.
	
	//Difference between primitive and reference variables:
	//Primitives 
		//Always keep values
		//Compare using ==
		//8 types
		//Default values (boolean = false, integers = 0, decimal =0.0, character ='\u0000'
		//Non garbage collected
		//Use arithmetic, assignment, logical and relational operators
	
	//References
		//Keep a memory reference
		//Compare using equals method
		//Any class can be referenced
		//Default value = null
		//Garbage collected
		//Can't use java operators
		//Methods change the state of an object or assign a new object, in this latter case the changes are NOT reflected in the calling method
	
	
	private static void test() {
		int i=1;
		myInt=12;
		WeirdPerson pe = new WeirdPerson();
		test1(i, pe);
		System.out.println(i);
		System.out.println(myInt);
		System.out.println(pe.getName());
	}
	
	static private void test1(int i, WeirdPerson p) {
		i=20;
		WeirdPerson pe1 = new WeirdPerson();
		pe1.setName("Mary");
		myInt=14;
		p = pe1; //If I assign a new reference value for a p it does not work for the calling method
		
		//If I use p.setName("Mary") it works on the calling method because I'm changing the state of the object
		
	}
	
	public static void main(String[] args) {
		test();
		
		WeirdPerson p = new WeirdPerson();
		WeirdPerson p1, p2;
		p1=p2=p;
		
		System.out.println(p +" "+p1+" "+p2); // All these references refers to the same object memory
		p2.setAge(29);// Change the object age		
		System.out.println(p.getAge()+" "+p1.getAge()+" "+p2.getAge()); // All refers to the same object memory so the age will be the same for all of them
		
	}
}
