package f.inheritance.polymorphism;

import f.inheritance.entities.Employee;
import f.inheritance.entities.HRExecutive;
import f.inheritance.entities.IWantToBreakFreeProgrammer;
import f.inheritance.entities.Manager;
import f.inheritance.entities.MyAbstractClass;
import f.inheritance.interfaces.Interviewer;

/**
 * @author mariaane
 *
 */
public class TestCasting {

/* Casting is the process of forcefully making a variable behave as a variable of another
type. If a class shares an IS-A or inheritance relationship with another class or interface,
their variables can be cast to each other’s type. */
	
	public static void main(String[] args) {
		Interviewer interviewer1 = new HRExecutive(1);
		
		//Important note
		// To access specialization you need to cast
		//((HRExecutive)interviewer) to get the result of cast
		((HRExecutive)interviewer1).setSpecialization(new String[] {"Staffing"}); //Compile OK
		
		Interviewer[] interviewers = new Interviewer[2];
		interviewers[0] = new Manager(1); //Can cast this only to Manager
		interviewers[1] = new HRExecutive(1); //Can cast this only to HRExecutive
		
		for (Interviewer interviewer : interviewers) {
			if (interviewer instanceof Manager) { //USE INSTANCEOF TO KNOW WHAT IS THE TYPE OF CLASS AND DO THE CORRECT CAST!
				int teamSize = ((Manager) interviewer).getTeamSize(); //CAST arises a need of Cast
				// Only a Manager has teamSize attribute
				if (teamSize > 10) {
					interviewer.conductInterview();
				} else {
					System.out.println("Mgr can't interview with team size less than 10");
				}
			} else if (interviewer instanceof HRExecutive) {
				interviewer.conductInterview();
			}
		}
		
		//I can put a derived class in a superclass
		System.out.println("\nCAST");
		MyAbstractClass ab = new IWantToBreakFreeProgrammer(1);
		IWantToBreakFreeProgrammer p = (IWantToBreakFreeProgrammer) ab; //Ok cast a base class to a Programmer because it's a programmer object
		p.test();
		System.out.println("OK\n");
		
		//COMPILE BUT give a class cast exception at runtime
		//Employee ab1 = (Programmer) new Employee(); //Can't cast a Employee to a Programmer, because Employee is the superclass not the derived class
		//ab1.test();
		
		//Programmer ab2 = (Programmer) new Employee(); //Can't cast a Employee to a Programmer, because Employee is the superclass not the derived class
		//ab2.test();
		
		
		//Prints the same thing because all of the objects below refers to an instanceof Manager
		Employee empl = new Manager(1); //OK
		Manager m = (Manager) empl; //Valid cast because empl IS A MANAGER AND WAS INSTANCIATED AS NEW MANAGER NOT AS NEW EMPLOYEE
		System.out.println();
		empl.test();
		System.out.println();
		m.test();
		
		System.out.println();
		Employee man = (Employee) new Manager(1); //Cast is unecessary in this case (cast to superclass) but works
		man.test();
		
		//EXAM TIP: NEVER TRY TO CAST A SUPERCLASS IN A DERIVED CLASS if the type of the superclass instantiated is not the same as the subclass
		
		/* This keyword:
		 * The this reference always points to an object's own instance.
		 * You can use the keyword this to refer to all methods and variables that are accessible to a class
		 */
	}
}
