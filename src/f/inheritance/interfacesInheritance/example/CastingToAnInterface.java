package f.inheritance.interfacesInheritance.example;

import java.util.ArrayList;

import a.java.basics.WeirdPerson;
import f.inheritance.animal.example.Animal;
import f.inheritance.animal.example.AnimalIF;
import f.inheritance.animal.example.GuineaPig;
import f.inheritance.animal.example.GuineaPigIF;
import f.inheritance.entities.HRExecutive;
import f.inheritance.entities.IWantToBreakFreeProgrammer;
import f.inheritance.entities.Manager;
import f.inheritance.interfaces.Interviewer;

/**
 * @author mariaane
 *
 */
public class CastingToAnInterface {

	public static void main(String[] args) {
		
		BaseIF1 b = new Manager(1); 
		
		//HRExecutive hr = new Employee(); //NOT ALLOWED! Will not compile because a derived class may have not access to all superclass attributes and methods
			/* You may see multiple questions in the exam that try to assign an object of a base class 
			 * to a reference variable of a derived class. 
			 * Note that a derived class CAN be referred to using a reference variable of its base class.
			 * The reverse is not allowed and won’t compile. */

		//HRExecutive hr = new Interviewer(); //NOT ALLOWED! Will not compile, you can't instantiate an interface
		
		Interviewer[] interviewers = new Interviewer[2];
		interviewers[0] = new Manager(1);
		interviewers[1] = new HRExecutive(1);
		for (Interviewer interviewer : interviewers) {
			interviewer.conductInterview();
		}
		

		Interviewer interv = null;
		Manager m = new Manager(1);
		interv = (Interviewer) m; // Ok because Manager implements Interviewer
		
		IWantToBreakFreeProgrammer prog = new IWantToBreakFreeProgrammer(1);
		//interv  = (Interviewer) prog; //Throws a ClassCastException (RuntimeException) - TRY TO UNCOMENT THIS LINE AND RUN
		//interv = prog; //Will not compile because Programmer does not implement Interviewer IF
		
		
		ArrayList<Interviewer> test = new ArrayList<Interviewer>();
		test.add(m); // Ok because Manager implements Interviewer
		//test.add(prog); //Will not compile because Programmer does not implement Interviewer IF
		//test.add((Interviewer)prog);  //Throws a ClassCastException (RuntimeException) - Keep line 38 commented, UNCOMENT THIS LINE AND RUN
	
		//IMPORTANT
		//I can cast any object to a interface it doesn't implement - compile OK but will throw a ClassCastException
		//I can try to do this, WeirdPerson don't implement GuineaPigIF neither its superclass but compiler don't check this.
		//The code below will throw a java.lang.ClassCastException
		WeirdPerson p = new WeirdPerson();
		GuineaPigIF gui = (GuineaPigIF) p;
		AnimalIF an = (AnimalIF) p;
		
		//GuineaPig g = (GuineaPig) p;
		//Animal a = (Animal) p; 
		//In case to cast to a class or abstract class, the compiler can check if the class are compatible or not
		//In the case above, the code not compile, because WeirdPerson is not an Animal or a GuineaPig
		//This is valid to CLASSES OR ABSTRACT CLASSES
	
		//In this case, because Animal is superclass of GuineaPig, the compiler allow us to do this.
		//But I CAN'T cast a superclass to a subclass, so the code below will throw a java.lang.ClassCastException
		Animal animal = new Animal(1);
		GuineaPig guigui = (GuineaPig) animal; //GuineaPig is an Animal BUT Animal IS NOT a GuineaPig - ClassCastException
	}
}
