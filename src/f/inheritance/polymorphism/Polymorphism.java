package f.inheritance.polymorphism;

import f.inheritance.entities.IWantToBreakFreeProgrammer;
import f.inheritance.entities.Manager;
import f.inheritance.entities.MyAbstractClass;
import f.inheritance.interfaces.Trainable;

/**
 * @author mariaane
 *
 */
public class Polymorphism {
 
	/* Polymorphism comes into the picture when a class inherits another class and both the
base and the derived classes define methods with the same method signature (the same method name and method parameters - overriden methods)
    */
	
	public static void main(String[] args) {
		//Polimorfism using classes
		MyAbstractClass emp1 = new IWantToBreakFreeProgrammer(1);
		MyAbstractClass emp2 = new Manager(1);
		Manager mm = new Manager(1);
		
		System.out.println();
		emp1.reachOffice();
		System.out.println();
		emp2.reachOffice();
		System.out.println();
		emp1.startProjectWork();
		System.out.println();
		emp2.startProjectWork();
		System.out.println();
		
		System.out.println("Names:");
		System.out.println(emp1.getName()); //When called in emp1, prints superclass value
		System.out.println(mm.getName()); //Here, using specific object prints name in the Manager class		
		System.out.println((((Manager)emp2)).getName()); //Here, after correct cast, prints name in the subclass
		System.out.println(emp1.getName()); //If derived class has an overriden method, always calls the method in derived class

		System.out.println();
		//Polimorfism using interfaces
		Trainable t1 = new Manager(1);
		Trainable t2 = new IWantToBreakFreeProgrammer(1);
		t1.attendTraining(new String [1]); //Calls Manager attendTraining 
		t2.attendTraining(new String [1]); //Calls Programmer attendTraining 
		
		/* Because both these classes also extend the class Employee, you can use a variable of type Employee to store
		  objects of the classes Programmer and Manager. But in this case you won’t be able to call method 
		  attendTraining because it isn’t visible to the class Employee.
		  
		  If you change Employee class to implements Trainable
		  so the subclasses no longer need to implement this interface because their base class, Employee, implements it.
		  
		  The objects are aware of their own type and execute the overridden method defined in their own class, 
		  even if a base class variable is used to refer to them.
		  
		  The way to call super methods (or part of them) is using super in the overriding method
		  Or don't override method.
		  If you don't override a method, the superclass one's will be called. (Reach office case).
		  
		  To implement polymorphism with classes, you can define abstract or non-abstract methods 
		  in the base class and override them in the derived classes.
		 
		  When the same action (method call startProjectWork) is invoked on these reference variables (emp1 and emp2),
		  each method call results in the method defined in the respective classes being executed.

		  
		  OVERRIDEN METHODS RULES:
		   Overridden methods are defined by classes and interfaces that share inheritance relationships.
	       -  The name of the overridden method must be the same in both the base class and the derived class.
           -  The argument list passed to the overridden method must be the same in both the base class and derived class.
           -  The return type of an overriding method in the derived class can be the same, 
              or a subclass of the return type of the overridden method in the base class. 
           - If base class returns an interface, so the derived class can return a subclass of this interface or any class that implements this interface.
           When the overriding method returns a subclass of the return type of the overridden method, it is known as 
              a covariant return type.
          - An overridden method defined in the base class can be an abstract method or a non-abstract method.
          - Access modifiers for an overriding method can be the same or less restrictive than the method being overridden, 
             but they can’t be more restrictive.


			CAN POLYMORPHISM WORK WITH OVERLOADED METHODS?
			
			No, polymorphism works only with overridden methods. Overridden methods have the same number and type of method arguments, 
			whereas overloaded methods define a method argument list with either a different number or type of method parameters.
			
			Overloaded methods only share the same name; the JRE treats them like different methods. 
			In the case of overridden methods, the JRE decides at runtime which method should be called based on the exact 
			type of the object on which it's called.

			IMPORTANT:
			Watch out for overloaded methods that seem to participate in polymorphism: overloaded methods don’t participate in polymorphism.
			Only overridden methods—methods with the same method signatures—participate in polymorphism.
			*/
	}
}
