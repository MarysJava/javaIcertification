package f.inheritance.entities;

import f.inheritance.interfaces.Trainable;

/**
 * @author mariaane
 *
 */
public class IWantToBreakFreeProgrammer extends MyAbstractClass implements Trainable {

	//Constructors
	public IWantToBreakFreeProgrammer() {
	}
	
	public IWantToBreakFreeProgrammer(int num) {
		super(num);
	}
	
	//String name; //I can do this - only this name will be available here
	String[] programmingLanguages;
	String name = "Programmer";
	
	//An object	of a derived class contains an object of its base class.
	//An object of class Employee exists within an object of class Programmer
	
	void writeCode() {}
	
	void accessBaseClassMembers() {
		name = "Programmer";  // Can access the parent members
	}

	//Implementing the Trainable interface method
	//If a class implements an interface it must implement all the interface methods, it's a contract!
	public void attendTraining(String[] trainingSchedule) { //Need to use PUBLIC access modifier here! 
		//A modifier can't be more restrictive that the access modifier in the interface or base class/
		//And all modifiers of an interface are public by default
		System.out.println("Programmer - attend training.");
	}


	public IWantToBreakFreeProgrammer doSomething() {
		return new IWantToBreakFreeProgrammer(); 
		//Covariant return, I can return a Programmer instead a Employee because IWantToBreakFreeProgrammer extends MyAbstractClass
		//and MyAbstractClass extends Employee, so IWantToBreakFreeProgrammer is a kind of Employee
	}
	
	//POLYMORPHIC METHODS ARE ALSO CALLED OVERRIDDEN METHODS
	//To be consider a OVERRIDDEN method, you need to use the same method NAME, same ARGUMENTS list and same RETURN type
	//If you don't do this, Java won't mark a method as an overridden method.
	public String reachOffice(String x) { //THIS IS NOT an overriden method
		//The original method in superclass has return type void and has no arguments
		System.out.println("Here Not overriden");
		super.reachOffice();
		return null;
	}
	
	public void reachOffice() { //THIS IS an overriden method
		//I CAN change the access modifier but NEVER RESTRICT it!
		//I CAN use a covariant return in a overriden method!
		System.out.println("Here overriden");
		super.reachOffice();
	}
	
	//TIP: when I say I CAN do something, not necessarily I'll do it. But I can do if I want.

	public void startProjectWork() {
		defineClasses();
		unitTestCode();
	}
	
	protected void startProjectWork(int x) {
		System.out.println("X "+x);
	}
	
	private void defineClasses() { System.out.println("define classes"); }
	private void unitTestCode() { System.out.println("unit test code"); }
	
	public String getName() {
		return name;
	}
	
	public static void main(String[] args) {
		IWantToBreakFreeProgrammer p = new IWantToBreakFreeProgrammer();
		System.out.println(p.name); //IWantToBreakFreeProgrammer name
		MyAbstractClass mab = new IWantToBreakFreeProgrammer();
		System.out.println(mab.name); //Employees name
		//If MyAbstractClass had a name, so this line above would print the MyAbstractClass name variable
		//Because it doesn't have, so the line prints its superclass name, the Employee's name
		//Remember a class only have access to its own variables and the variables not private in its superclass hierarchy
	}
}
