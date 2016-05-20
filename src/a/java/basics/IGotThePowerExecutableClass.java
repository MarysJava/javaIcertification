package a.java.basics;

/**
 * @author mariaane
 *
 */

//I AM AN EXECUTABLE CLASS BECAUSE I HAVE THE MAIN METHOD
//You cannot ask to JVM start executing a class that has no MAIN method.
//The JVM won’t know how to execute it because no entry point is marked.
public class IGotThePowerExecutableClass {

	// The method must be PUBLIC and STATIC, 
	//NAME must be MAIN and RETURN TYPE = VOID
	// ARGUMENTS =  a String array (String [] x ) or a variable	argument of type String (String... x).
	
	// public static void main(String[] args) OR
	// The [] can appears before or after the name of the argument (String[] args) or (String args [])
	// public static void main(String... args)	
	// The (...) ARE ALWAYS AFTER THE DATA TYPE! Never after the name of var.
	
	// public static void main(String minnieMouse[]) THE VAR NAME CAN BE ANY VALID VAR NAME
	// Modifiers (public and static) can appears in any order
	// static public void main(String... args) is VALID
	
	// When you call main you can pass how many parameters do you want
	// The first parameter is the number 0
	
	// To call passing parameters just do: java ClassName arg0 arg1 arg2 arg3
	
	public static void main(String... args) {
		System.out.println(args[0]);// Named command-line parameters or command-line values
		System.out.println(args[1]);
		
		Integer integ = new Integer(1);
		Integer integ1 = new Integer(2);
		Integer ia=1;
		Integer ib=1;
		System.out.println(integ.equals(integ1));
		System.out.println(ia==ib); //Prints true
	}	
}
