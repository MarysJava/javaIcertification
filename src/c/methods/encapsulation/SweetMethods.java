package c.methods.encapsulation;

/**
 * @author mariaane
 *
 */
public class SweetMethods {

	/* Methods can have:	
    	Return type
		Method parameters
		return statement
		Access modifiers 
		Nonaccess modifiers
	 
	  RETURN TYPE
	  	A method may or may not return a value (RETURN TYPE VOID). 
	  	A method can return a primitive value or an object of any class.
	  	The name of the return type can be any of the eight primitive types defined in Java, the name of any class, or an INTERFACE.
	  	If a method doesn’t return a value, you can’t assign the result of that method to a variable. (If you try this, won't compile)
	  	If a method returns a value, the calling method may or may not bother to store the returned value from a method in a variable. It's OK!
	  	The variable you use to accept the returned value from a method must be compatible with the returned value.
	
	 METHOD PARAMETERS
	 	Method parameters are the variables that appear in the definition of a method and specify the type and number of values that a method can accept.
	 	Method arguments are the actual values that are passed to a method while executing it. (Different from parameters!)
	 	There is no limits of how many parameters you pass to a method, but practically it’s not a good idea to define more than five or six method parameters.
	 
	 	Method can accept varargs as parameter: (int... days) // Can be passed an ARRAY or multiple comma-separated values.
	 	You can define only one variable argument in a parameter list, and it should be the last variable in the parameter list. 
	 	If you don’t comply with these two rules, your code won’t compile.
	 	Each method parameter is preceded by the name of its type. You can’t declare the type once and then list them separated by commas, as you can for variables.
	
	 	You CAN use the return statement in a method even if it doesn’t return a value. Usually this statement is used to define an early exit from a method
	
		The return statement must be the last statement to execute in a method, IF PRESENT.
		The return statement need not be the last statement in a method, but it must be the last statement to execute in a method
		
		For a method that returns a value, the return statement must be followed immediately by a value
		For a method that doesn’t return a value (return type is void), the return statement must not be followed by a return value
		If the compiler determines that a return statement isn’t the last statement to execute in a method, the method will fail to compile
	 */
	
	//public void testVargars(int... days, String... teste) { // Will not compile! More than one vararg.
	
	//public void testVargars(int... days, String teste) { // Will not compile! The vararg must be the last parameter.
	
	// OK
	public void testVargars(String teste, int... days) { //The ... MUST BE after the parameter TYPE, always (not like an array)
		int x=10;
		if(x==10)
		return; //Even return type being void you can do this to exit from the method 
		int a =8; //This code is reachable
		//Here I can have only return in if clause because the method does not require a return, it's only to exit from this method earlier on a specific situation
		//If the return was out of if clause, this code will not compile because the code after it would be an unreachable code
	}
	
	public int testeReturn() {
		int x=10;
		//The return x occurs only if x==10, so I need to put another return in the end of the method or in the another option (else)
		//All ends of the method must be covered
		if(x==10) {
			return x;
		} else {
			return 0;
		}
		//int a =8; //This code will not compile! Unreachable code.
	}
}
