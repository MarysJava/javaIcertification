package c.methods.encapsulation;

import a.java.basics.WeirdPerson;

/**
 * @author mariaane
 *
 */
public class LovelyScope {

	/* 
	 Local variables (also known as method-local variables)
	 Method parameters (also known as method arguments)
	 Instance variables (also known as attributes, fields, and non static variables)
	 Class variables (also known as static variables)
	*/

	// SCOPE OF LOCAL VARIABLE - IMPORTANT TO THE TEST
		
	//An INSTANCE variable is declared within a class, outside of all of the methods. It’s accessible to all the nonstatic methods defined in a class.
	//A single copy of a STATIC variable is accessible to all the objects of class, and is accessible even you don't have an object yet, using the class name
	
	//Strings can also be initialized using the '=' operator, the following code is a valid	example of String objects being created
	String x=""; //using default access modifier
	int age;
	
	//I CAN'T have two instance variables with the same name	
	//Class variable and instance variable can’t be defined	using the same name in a class
	//Method parameter and local variable can’t be defined using the same name in a method. Won’t compile.
	
	//After created an object remains accessible until it goes out of scope or its reference variable is explicitly set to null.
	//If you reassign another object to an initialized reference variable the previous object becomes inaccessible (becomes a dog without a leash)
	
	int age2=2, age3=10;
	
	public void testScope() {
		String teste="";
		age=age2; // I can't do this outside a method/constructor;
		{
			double d =0.0; // Every time a variable is inside {} his scope (life span) is only inside this {}
		}
		
		//d=10.0; //OUT OF SCOPE
		x="Oi!"; //x is accessible here because it's an instance variable!
	}
	
	public void setX(String x /* LocalVariable - method parameter/argument */) {
		//String x = ""; // Won’t compile! Because I already have an parameter named x
		this.x =x; // x (instance variable) is accessible here!
		// x=x this assignment has no effect, you must use the keyword 'this' to say you're setting the value of instance variable with the value of local variable: this.x = x.
		int age =10; // I can duplicate the name age, it can be an int, a String or another type, its because the two variables named age are in different scopes
		// and the local scope has precedence about instance scope unless I use the keyword this to refers the instance variable.
	}
	
	public static void main(String[] args) {
		WeirdPerson p = new WeirdPerson();
		p.setAge(10);
		System.out.println(p);// One memory reference
		p = new WeirdPerson(); // or p=null; //The first object will be garbage collected but we never know when or if it will really occurs
		p.setAge(20);
		System.out.println(p); //Another memory reference 
		System.out.println(p.getAge());
		
		{
			//I can't duplicate a local var
			WeirdPerson p2 = new WeirdPerson(); //I can't create p because it already exists in this scope as a local var. 
										//Unless p was a instance var I can't create another var named p.
			p2.setAge(30);
		}
		
		//p2 is not accessible here anymore (outside the brackets), so the object will be garbage collected but we never know when or if it will really occurs

		//Object is garbage collected when it no longer can be accessed (goes out of scope), receive null or be reinitialized.
		
		//IMPORTANT
		//You can never determine when a particular object will be garbage collected. 
		//A user can’t control or determine the execution of a garbage collector. It’s controlled by the JVM.
		//EXAM TRICK: watch for questions with wordings such as "which objects are SURE to be collected during the next GC cycle" (it's impossible to be sure about that)
	}
}
