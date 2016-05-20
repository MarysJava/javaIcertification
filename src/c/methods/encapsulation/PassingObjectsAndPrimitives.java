package c.methods.encapsulation;

import a.java.basics.WeirdPerson;

/**
 * @author mariaane
 *
 */
public class PassingObjectsAndPrimitives {

	// The value of a primitive data type is copied and passed on to a method. Hence, the variable whose value was copied doesn’t change.
	
	
	int age;
	/*
	It’s okay to define a method parameter with the same name as an instance variable (or object field).
	Within a method, a method parameter takes precedence over an object field.
	When the method modifyVal refers to the variable age, it refers to the method
	parameter age, not the instance variable age. To access the instance variable
	age within the method modifyVal, the variable name age needs to be prefixed
	with the keyword this (this is a keyword that refers to the object itself).
	 */
	
	void modifyVal(int age) {
		age = age + 1; //age is parameter received, when calls  e.modifyVal(e.age); the e.age remains the same, only local var age changes its value
		System.out.println(age); //Prints 1
		System.out.println(this.age); //Prints 0
	}
	
	/* Passing object references to methods. Two cases:
	  Case 1: When a method reassigns the object reference passed to it to another variable. 
	     In this case, the state of the object, which was passed on to the method, remains intact.
 	  Case 2: When a method modifies the state of the object reference passed to it, in this case the state of object change.
	 */
	
	//Case 1
	public static void swap(WeirdPerson p1, WeirdPerson p2) {
		System.out.println("P1 before "+p1);
		System.out.println("P2 before "+p2);
		
		WeirdPerson temp = p1; 
		p1 = p2; //p1 refers p2
		p2 = temp; //p2 refers p1
		
		p2.setName("Test"); //If I do this, I change object p2 name

		System.out.println("P1 after "+p1);
		System.out.println("P2 after "+p2);
		
		//but if I do
		p2 = new WeirdPerson();
		p2.setName("Test");
		System.out.println("p2 name: "+p2.getName()); //If the called method assigns a new object reference to the method argument 
		// before modifying the value of its fields, these changes aren’t visible in the calling method.
			
		//p1 and p2 are only references to an object in memory
		}
	
	
	//Case 2
	public static void resetValueOfMemberVariable(WeirdPerson p1) {
		// Both the variables person1 (in the calling method) and p1	refer to the same object.
		// So when set name to Robert, both, person1 and p1 refers to the object which attribute name is now Robert
		p1.setName("Robert");
	}
	
	
	public static void main(String args[]) {
		PassingObjectsAndPrimitives e = new PassingObjectsAndPrimitives();
		System.out.println(e.age); // Prints 0
		e.modifyVal(e.age);
		System.out.println(e.age); // Prints 0
		// If in the modifyVal method I do 'this.age=2' so the value of instance attribute age will be changed.
		// But passing age as a method parameter and change this parameter value will never change the value of attribute age 
		
		//Case 1
		WeirdPerson person1 = new WeirdPerson("John");
		WeirdPerson person2 = new WeirdPerson("Paul");
		System.out.println("Person1 "+person1);
		System.out.println("Person2  "+person2);
		System.out.println(person1.getName()+ ":" + person2.getName());
		swap(person1, person2);
		System.out.println("Person1 "+person1);
		System.out.println("Person2  "+person2);
		//PERSON 1 AND 2 REMAINS THE SAME OBJECT REFERENCE!
		System.out.println(person1.getName()	+ ":" + person2.getName());
		
		//Case 2
		WeirdPerson person3 = new WeirdPerson("John");
		System.out.println(person3.getName());
		resetValueOfMemberVariable(person3); // Change the attribute name of the person3 - case 2
		System.out.println(person3.getName());
	}
}
