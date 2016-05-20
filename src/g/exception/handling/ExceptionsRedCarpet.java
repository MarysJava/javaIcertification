package g.exception.handling;

import java.util.ArrayList;

/**
 * @author mariaane
 *
 */
public class ExceptionsRedCarpet {

	/* THE MOST IMPORTANT RUNTIME EXCEPTIONS 
	  
	  - ArrayIndexOutOfBoundsException: tries to access an array out of its bounds (less than 0 or greater than array lenght)
	  - IndexOutOfBoundsException: is thrown when a piece of code tries to access a list, like an ArrayList, using an illegal index.
	  
	  You can avoid these exceptions from being thrown if you check whether the index position you are trying to access is greater than or equal to 0 and less than
the size of your array or ArrayList.
	  
	 - ClassCastException: is thrown when an object fails an IS-A test with the class type to which it’s being cast
	 You can use the instanceof operator to verify whether an object can be cast to another class before casting it.
	 
	 NOTE: If I have an array type superclass, I can add objects with subclasses type. Even two classes extends the same superclass,
	 if I have an array of one subtype I CAN'T ADD an object of another subtype.
	 
	  - IllegalArgumentException: IllegalArgumentException is thrown to specify that a method has passed illegal or inappropriate arguments.
	  - IllegalStateException: “signals that a method has been invoked at an illegal or inappropriate time. In other words, the Java environment or
Java application is not in an appropriate state for the requested operation.
		For example, what happens if an application tries to modify an SMS that is already in transmission?
		if (!inTransit)
			msg = "new modified message";
		else
			throw new IllegalStateException("Msg in transit. Can't modify it");
		
		The method modify in the class SMS throws an IllegalStateException if another piece of code tries to call it after the method send has been executed.
		and inTransit = true.
	 
	  - NullPointerException: This exception is thrown by the JVM if you try to access a method or a variable with a null value.
	  - Accessing members of a reference variable that is explicitly assigned a null value.
	  - Accessing members of an uninitialized instance or static reference variable. These are implicitly assigned a null value.
	  - Using an uninitialized local variable, which may seem to throw a NullPointerException.
		 By default, local variables aren’t assigned a value—not even a null value. 
		 If you attempt to use an uninitialized local variable, your code will fail to compile.
	  - Attempting to access nonexistent array positions.
	  - Using members of an array element that are assigned a null value.
	  - The key is to ensure that the reference variable has been assigned a non-null value.

	  Trying to access a nonexistent position of an array throws ArrayIndexOutOfBoundsException. 
	  Calling a member on a null value stored in an array throws NullPointerException.
	  
	 - NumberFormatException: NumberFormatException is a runtime exception. It’s thrown to indicate that the application has tried to
	convert a string (with an inappropriate format) to one of the numeric types.
	IllegalArgumentException is its superclass.
    */
	
	public void login(String username, String pwd, int maxLoginAttempt) {
		if (username == null || username.length() < 6)
			throw new IllegalArgumentException(
					"Login:username can’t be shorter than 6 chars");
		if (pwd == null || pwd.length() < 8)
			throw new IllegalArgumentException(
					"Login: pwd cannot be shorter than 8 chars");
		if (maxLoginAttempt < 0)
			throw new IllegalArgumentException(
					"Login: Invalid loginattempt val");
		// .. rest of the method code
	}
	
	static ArrayList<String> list; //CLASS MEMBER - in this case an object is by default initialized with null value
	String[] oldLaptops; // Whether is static or not, the value is assigned to null for a object attribute not initialized
	static int[] arrayTest;
	
	public static void main(String[] args) {
		ArrayList<String> myArray; //I MUST initialize local vars, if not, I can't use them (code not compile)
		//System.out.println(myArray); ////WILL NOT COMPILE 
		//if(myArray!=null) //WILL NOT COMPILE 
		//myArray.add("Hello!"); //WILL NOT COMPILE
		//Compiler says that variable may not have been initialized
		
		//list.add("Test"); //Throws NullPointerException 
		//ExceptionsRedCarpet red = new ExceptionsRedCarpet();
		//System.out.println(red.oldLaptops[1]); //Throws NullPointerException because the array is null
		String[] newLaptops = new String[2];
		//System.out.println(newLaptops[1].toString()); 
		//TRICK: Throws NullPointerException because the array is NOT null, BUT the POSITION [1] has null value
		//newLaptops[1] is an object that was not initialized
		
		//System.out.println(arrayTest[1]);//Throws NullPointerException because the array is null
		//If arrayTest was not null it would print 0 (it's an array of int - primitive type).
		
		//IMPORTANT
		int[] arrayTest1 = new int[2];
		System.out.println(arrayTest1[1]); //In this case (primitive) the positions of array are initialized with 0 so it prints 0
	
		Object [] obj = new Object[2];
		System.out.println(obj[1]); //In this case (Object) the positions of array are initialized with null so it prints null
		
		System.out.println(Integer.parseInt("-123"));
		System.out.println(Integer.parseInt("123"));
		System.out.println(Integer.parseInt("+123"));
		//System.out.println(Integer.parseInt("123_45")); //Use of UNDERSCORES in Strings is not valid to convert to Integer values
		//System.out.println(Integer.parseInt("12ABCD")); //A String 12ABCD is not valid to convert to Integer value
		
		/*The letters ABCD are not used in the decimal number system, but they can be used in the hexadecimal number
		  system, so you can convert the hexadecimal literal value "12ABCD" to the decimal number system by specifying the base of the 
		  number system as 16 */
		
		System.out.println(Integer.parseInt("123ABCDF", 16)); //It works because I'm saying to parseInt method I'm using hexadecimal base with allows letters A, B, C, D, E and F
		//System.out.println(Integer.parseInt("123ABCDG", 16)); // In this case I'm trying to use G that is not part of an Hexadecimal base, so it will throw NumberFormatExecption
		
		/* You may throw NumberFormatException from your own method to indicate that there’s an issue with the conversion of a String 
		 * value to a specified numeric format (decimal,octal, hexadecimal, binary), and you can add a customized exception message. 
		 * One of the most common candidates for this exception is methods that are used to convert a command line argument 
		 * (accepted as a String value) to a numeric value. Please note that all command line arguments are accepted in a
		 * String array as String values.
		 * Take a look at class ConvertToNumberTest.
		 */
	}
}
