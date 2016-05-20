package f.inheritance.entities;

import f.inheritance.interfaces.Interviewer;
import f.inheritance.interfaces.Trainable;
import f.inheritance.interfacesInheritance.example.BaseIF1;


/**
 * @author mariaane
 *
 */
public class Manager extends MyAbstractClass implements Trainable, Interviewer {
	
	BaseIF1 b;
	private int teamSize =10; //Encapsulation
	void reportProjectStatus() {}
	String name="Manager";
	
	public Manager() {
		//When a class extends another class, if you don't explicit call another local constructor
		//the first call (implicit) will be to the non argument constructor of its superclass.
		
		this("Mary"); //Here, there's no Implicit call for super(); because I explicitly called this
		//If I comment this line when I created an object like new Manager() it will print:
			//SUPER CONSTRUCTOR
			//THIS CONSTRUCTOR
		System.out.println("THIS CONSTRUCTOR");
		//Remeber: if you want to call another constructor this must the the first statement in a constructor - don't consider comments or blank spaces
	}
	
	public Manager(String name) {
			super(name);  //If I comment this line when I created an object like new Manager() it will print:
			//SUPER CONSTRUCTOR - implicit call to super constructor
			//NAME CONSTRUCTOR - here
			//THIS CONSTRUCTOR - the () constructor print
		
		System.out.println("NAME CONSTRUCTOR");
		/* Or I call super or I call this, I can't call both at the same time!
		 *
		 * If present, a call to a another constructor (superclass or the same class) must be the first statement in a class's constructor. 
		 * Otherwise, if there's none explicit call, a call to super(); (the non argument constructor) is inserted automatically by the compiler.
		 * 
		 */
	}
	
	//Only to use in another classes and don't get a lot of prints
	public Manager(int num) {
		super(num);
	}
	
	public void attendTraining(String[] trainingSchedule) {
		System.out.println("Manager - attend training.");
	}

	//Types of return to an overriden method
	//In this case I'm using a more restrictive return type: Manager
	public Manager doSomething() {
		//If in the base class the return type is an Interface, I can pass every class who implements the interface or the interface itself
		//But if the return type is an class that implements an interface I can't pass the interface as return - because it's not covariant
		//Example: doSomething returns Employee in the base class, and Employee implements Base1IF. But I can't return here Base1If, I only can return a Employee or its subclasses
		//If doSomething returns Base1IF in the base class, so I can return the interface Base1IF or any class that implements this interface
		BaseIF1 b = new Manager();  //Compile. I can do this because Manager extends MyAbstractClass and MyAbstractClass extends Employee
									//Manager IS A Employee AND Employee implements BaseIF1
		//A derived class inherit all interfaces implemented by its superclasses
		
		MyAbstractClass c = new Manager(); // I can do this because Manager extends MyAbstractClass
		Interviewer v = new Manager(); 
		
		//RULES TO RETURN:
		//If I use return type as BaseIF1 I can return b or c (both are derived from Employee which implements Base1IF)
		//If I use return type as MyAbstractClass I can return the class itself or its subclasses 
		//If I use return type as Interviewer I can return the interviewer object like v, 
			//I can create an object interviewer using any class which implements this interface
		return new Manager(); //In this case can't return b, c or v, because the return type is explicit Manager
		//If Manager had one or more derived classes so I could return an object from its derived classes
	}
	
	public void test() {
		this.name="MaryDerived";
		System.out.println(this.name);//refers to this name
		System.out.println(name); //refers to this name
		super.test(); //Prints MarySuper because calls the superclass method (in case, this method appears first on Employee class, from bottom to top)
	}
	
	public void conductInterview() {
		this.address="85, Polônia St."; //I can use this to access parent attributes 
		this.name="Mary";
		System.out.println("Manager - conduct interview.");
		System.out.println("Candidates: "+this.name + " "+super.name); // this refers to own object and super to the parent object
		//In this case super will refer to the first name's attribute in the superclass hierarchy from bottom to top
		//But as Manager don't have an address (Employee has). In this case it understands I'm calling one attribute in its superclass hierarchy.
	}
	
	public static void main(String[] args) {
		/* When the superclass and the derived class have attributes with the same name, I can use super and this to differentiate them	 */
		
		Employee m = new Manager();
		/*
		  prints 
		  SUPER CONSTRUCTOR (because Abstract class constructor calls super() implicit)
		  Abstract class constructor - name (because name constructor in this class calls super(name) explicit)
		  NAME CONSTRUCTOR (because the non argument constructor Manager() calls this("Mary") explicit)
		  THIS CONSTRUCTOR (because I create a Manager() using non argument constructor)
		 */
		
		System.out.println();
		m.test(); 
		
		//IMPORTANT: the keywords super and this are implicit object references. Because static methods belong to a class, not to objects of a class, 
			//you can’t use this and super in static methods. WILL NOT COMPILE!
		
		System.out.println();
		Manager man = new Manager();
		man.conductInterview();
	}

	public void startProjectWork() {
		meetingWithCustomer();
		defineProjectSchedule();
		assignRespToTeam();
	}

	private void meetingWithCustomer() {
		System.out.println("meet Customer");
	}

	private void defineProjectSchedule() {
		System.out.println("Project Schedule");
	}

	private void assignRespToTeam() {
		System.out.println("team work starts");
	}

	//Encapsulation
	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
}
