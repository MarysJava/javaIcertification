package c.methods.encapsulation;

/**
 * @author mariaane
 *
 */
public class OverloadedMethods {
	
	/* OVERLOADED METHODS
	 * 
	Overloaded methods are methods with the same name but different method parameter lists.
	Overload is not override! Override is about inheritance and polymorphism!
	 
	RULES - PARAMETERS THAT MATTERS!
		Overloaded methods must have different method parameters from one another.
		Overloaded methods may or may not define a different return type.
 		Overloaded methods may or may not define different access modifiers.
 		Overloaded methods CAN'T be defined by only changing their return type or access modifiers.
	
	ARGUMENTS
	Overloaded methods accept different lists of arguments. The argument lists can differ in terms of any of the following: 
	  Change in the number of parameters that are accepted 
	  Change in the types of parameters that are accepted 
	  Change in the positions of the parameters that are accepted (based on parameter type, not variable names)
	 */
	
 //Change in the positions of the parameters that are accepted (based on parameter type, not variable names)
 public void testeOverload1(String x, int y) {
		  
  }
 //Change in the positions of the parameters that are accepted (based on parameter type, not variable names)
 public void testeOverload1(int x, String y) {
	  
 }
 
 //If the two methods accepts int and double for example, we have a problem I explain below
 
 //Change in the positions of the parameters that are accepted (based on parameter type, not variable names)
 public void testeOverload2(double x, int y) {
		  
  }
 //Change in the positions of the parameters that are accepted (based on parameter type, not variable names)
 public void testeOverload2(double x, float y) {
	  
 }
 
//Change in the parameters that are accepted
public void testeOverload2(double x) {
	  
}
 
	public static void main(String[] args) {
		OverloadedMethods o = new OverloadedMethods();
		o.testeOverload1(1, "A");
		o.testeOverload1("A", 1);
		
		o.testeOverload2(2.0, 3); //Ok because I passed a double as 2.0. 
		o.testeOverload2(2F, 3); //I can pass a 2F to a double too since double is bigger than a float
		//An int literal value can be passed to a variable of type double, so it wont compile because method is ambiguous 
		//o.testeOverload2(2, 3); -- How can the compiler know which method it will use in this case? Who is the int and who is the double? It will not compile.
	
		o.testeOverload2(3); // In this case, I can pass a var of type int to a double, and the compiler knows I have only one method that accept this testeOverload2(double x)
	}
	
	
  // All of these methods are overloaded methods:
	
  public void testeOverload(String x) {
	  
  }
  
  //Change in the number of parameters that are accepted 
  public void testeOverload(String x, String y) {
	  
  }
 
  //Change in the types of parameters that are accepted 
  public void testeOverload(int x) {
	  
  }
  
  //Overloaded methods may or may not define a different return type.
  //Overloaded methods may or may not define different access modifiers. In this case the method define the default access modifier
  boolean testeOverload(boolean x) {
	  return true;
  }
  
  // Overloaded methods CAN'T be defined by only changing their return type or access modifiers.

  // This is not valid because I only change the access modifier and the type of return
  // The code also won’t compile if one of the methods is defined in a SUBCLASS or DERIVED CLASS.
  // private String testeOverload(String x) { 

}
