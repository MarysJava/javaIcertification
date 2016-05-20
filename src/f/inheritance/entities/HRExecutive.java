package f.inheritance.entities;

import java.util.ArrayList;
import java.util.List;

import f.inheritance.interfaces.Interviewer;

/**
 * @author mariaane
 *
 */

public class HRExecutive extends Employee implements Interviewer {

	//Constructors
	public HRExecutive() {
		
	}
	
	public HRExecutive(int num) {
		super(num);
	}

	private String[] specialization; //Encapsulation
	//HRExecutive hre = new HRExecutive(); //It compiles but when use polimorfism it can be a problem, runtime problem
	
	public void conductInterview() {
		System.out.println("HRExecutive - conducting interview");
	}
	
	public static void main(String args[]) {
	
		HRExecutive hr = new HRExecutive(); //Same type
		// You can access variables and methods defined in: the class Employee (except the private ones), the class HRExecutive, 
		//	 and the interface Interviewer using the variable hr
		// Using its own type, you can access all the variables and methods that are defined in its base class and interface
		hr.specialization = new String[] {"Staffing"};
		System.out.println(hr.specialization[0]);
		hr.name = "Pavni Gupta";
		System.out.println(hr.name);
		hr.conductInterview();
		
		//Using the Superclass type
		Employee emp = new HRExecutive();
		//Specialization is specific for class HRExecutive (child class) so the lines below WILL NOT COMPILE
		//emp.specialization = new String[] {"Staffing"};
		//System.out.println(emp.specialization[0]); 
		emp.name = "Pavni Gupta";
		System.out.println(emp.name); //Name it's Ok, because Employee has name, in case of use superclass, the variables are always from superclass
		//If I have an attribute name in this class it's ok too. But in this case if I call hr.name is the local name and emp.name is Employee name
		// emp.conductInterview(); //Class Employee does not implements Interviewer and don't have this method - it WILL NOT COMPILE
	
		//Using the Interface type
		//Interface has only access to its methods, it doesn't know the attributes or methods of class or its superclass
		Interviewer interv = new HRExecutive();
		// The lines below will not compile
		// interviewer.specialization = new String[] {"Staffing"};
		// System.out.println(interviewer.specialization[0]);
		// interviewer.name = "Pavni Gupta";
		// System.out.println(interviewer.name); //WILL NOT COMPILE
		interv.conductInterview(); 
		
		/* This arrangement also makes it possible to create an array (or a list) of the objects that refers to different types of objects 
		 * grouped by a common base class or an interface. 
		 * */
		
		List<Interviewer> interviewers = new ArrayList<>();
		interviewers.add(hr); // This list can add all objects which class implements Interviewer interface
		
		List<Employee> employees = new ArrayList<>();
		employees.add(emp);
		employees.add(hr); //This list can add all objects of class Employee or objects from Employee subclasses		
	}

	////Encapsulation
	public String[] getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String[] specialization) {
		this.specialization = specialization;
	}
}