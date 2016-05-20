package e.flow.control;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author mariaane
 *
 */
public class SwitchAndFor {

	private final static int var1=10;
	static final int var3 = 20;
	
	
	public void testVars() {
		final int b; //I can have a final parameter to be use in the switch, but only if it is final
		b=10;
		// b=15; This will not compile, because I can have only one assignment to b.
		
		// If I want to use b in a switch I must declare it as final and assign a value to it in the same line of the declaration 
		// like this: final int b = 10;
		
		// static int x =8; // I can't have a static parameter, only an attribute can be static
		
	}
	
	public static void main(String[] args) {
		
		// Improve the readability of your code by replacing a set of (rather complicated-looking) 
		// related if-else-if-else statements with a switch and multiple case statements.
		
		final int var2=20;
		// IMPORTANT: If the final variable var2 isn’t initialized with its declaration, isn’t considered a compile-time constant, 
		// so it can’t	be used as a case label.
		
		int marks = 80;
		switch (marks) {
		default: System.out.println("default"); // Default can appear in any order
		break;
		case 10: System.out.println(10);
		break;
		case var2: System.out.println(20);
		break;
		case 30: System.out.println(30);
		break;
		}
		
		//ONE CODE BLOCK CAN BE DEFINED FOR MULTIPLE CASES
		String day = "SUN";
		switch (day) {
		case "MON":
		case "TUE":
		case "WED":
		case "THU": System.out.println("Time to work");
		break; //If MON, TUE, WED or THU so print this and break.
		case "FRI": System.out.println("Nearing weekend");
		break;
		case "SAT":
		case "SUN": System.out.println("Weekend!");
		break;
		default: System.out.println("Invalid day?");
		}
		
		//IMPORTANT:
		//What happens if the value of the variable day matches TUE? When the code control
		//enters the label matching TUE in the switch construct, it’ll execute all of the code
		//until it encounters a break statement or it reaches the end of the switch statement.
		
		//The if-else-if-else construct evaluates all of the conditions until
		//it finds a match. A switch construct compares the argument passed to it with its labels.
		
		//A switch statement accepts arguments of type 
		//char, byte, short, int, and String (starting in Java version 7). It also accepts arguments and expressions of types
		//enum, Character, Byte, Integer, and Short,
		
		//You can also pass an expression to the switch statement as long as it returns one of the allowed types
		int score =10, num = 20;
		switch (score+num) {
		// ..code
		} //It's OK
		
		//Watch out for questions in the exam that try to pass a primitive decimal type such as float or double to a switch statement. 
		//Code that tries to do so will not compile:
		double history = 20;
		//switch (history) { //Will not compile
		// ..code
		//}
		
		// The value of a case label must be a compile-time constant value; 
		// that is, the value should be known at the time of code compilation:
		
		int a=10, b=20, c=30;
		switch (a) {
		//case b+c: System.out.println(b+c); break; //Not valid!
		case 10*7: System.out.println(10*7512+10); break; 
		//case 70: System.out.println(10*7512+10); break; //Duplicate cases are not allowed - will not compile
		//You can use variables in an expression if they’re marked final because the value of final variables can’t change once they’re initialized:
		case var1+var2: System.out.println(10*7512+10); break; //Using final vars it's OK		
		}
		
		//If you don’t assign a value to a final variable with its declaration (same line as explained above), it isn’t considered a compile-time constant
		
		//CASE VALUES SHOULD BE ASSIGNABLE TO THE ARGUMENT PASSED TO THE SWITCH STATEMENT
		//I can't assign a String to a byte, for example
		//Null is not valid as a label case
		
		//In the absence of the break statement, control will fall through the REMAINING code and execute the code corresponding 
		//to all the remaining cases that follow that matching case.
		
		score = 10;
		switch (score) {
		case 30: System.out.println("Good score 30 "); // Don't print this 
		case 100:
		case 50 :
		case 10 : System.out.println("Average score"); // Print this
		//Case 10 don't have a break so...
		case 200: System.out.println("Good score"); //Print this too
		default: System.out.println("Invalid day?"); //Print this too
		}
		
		
		//FOR
		
		/* for (initialization; condition; update) {
			statements;
		} */
		
		int tableOf = 25;
		for (int ctr = 1; ctr <= 5; ctr++) {
			System.out.println(tableOf * ctr);
		}
		
		//The update clause is a last statement in the for loop.
		
		/* The initialization section, which executes ONLY ONCE, may define multiple initialization statements.
		 * Similarly, the update clause may define multiple statements. But there can be only one termination condition for a for loop
		 */
	
		//The statentes are separated by ;  and if I want to initialize or update more than one var I need to separate using , the initializations/updates
		int ctr = 12;
		for ( int j=10, k=14, i=1 /*Initializing - multiples*/; j <= k /*Condition - only one*/; ++j, k=k-1, --ctr /*Update - multiples*/)
		{
			System.out.println(j+":"+k+":"+ctr); //First time prints 10, 14, 12
			//Excute first the print and after the update clause
		}
		
		//You can’t declare variables of different types in an initialization block. The following code will fail to compile:
		//for (int j=10, long longVar = 10; j <= l; ++j) { }
		
		//The scope of the variables declared in the initialization block is limited to the for block.
		//An initialization block executes only once.
		
		/* The termination condition is evaluated once for each iteration before executing the
		   statements defined within the body of the loop. The for loop terminates when the termination condition evaluates to false.
		   A for loop can define exactly one termination condition — no more.
		 */
		
		//Valid
		int j = 14;
		int k=16;
		for ( ; j <= k; )
		{
			++j;
			System.out.println(j+":"+k); 
		}
		
		
		/*
		 * You can define multiple statements in the update clause, including calls to other methods. 
		 * The only limit is that these statements will execute in the order in which they appear, 
		 * at the end of all the statements defined in the for block.
		 */
		
		String line = "ab";
		for (int i=0; i < line.length(); ++i, printMethod())
			System.out.println(line.charAt(i));
		
		//for (int i=0;; ++i) { System.out.println("AAA");} //Compile but is a INFINTE LOOP because there's not a condition clause
		
		// Nested loops are often used to initialize or iterate multidimensional arrays. The following
		// code initializes a multidimensional array using nested for loops:
		int multiArr[][];
		multiArr = new int[2][3];
		for (int i=0; i<multiArr.length; i++) {
			for (int g=0; g<multiArr[i].length; g++) {
				multiArr[i][g] = i + g;
				System.out.println("i + g "+i+" "+g+" "+multiArr[i][g] );
			}
		}
		

		ArrayList<String> myList= new ArrayList<String>();
		myList.add("Java");
		myList.add("Loop");
		
		
		//Regular loop iteratin over a collection or array is cumbersome
		for(Iterator<String> i = myList.iterator(); i.hasNext();)
			System.out.println(i.next());
		
		//Enhanced loop is so much better:
		//Enhanced loop = for-each loop
		for (String val : myList)
			System.out.println(val);
		
		//I can do this
		int total = 0;
		int primeNums[] = {2, 3, 7, 11};
		for (int num1 : primeNums) { //I can use enhanced loops with arrays
			num1=2; //This never changes the value of primeNums because it's a primitive, and this is a local copy inside the enhanced for
			total += num1;
		}
		
		for (int num1 : primeNums) {
			System.out.println(num1);
		}
		
		
		/*  What happens when you try to modify the value of the loop variable in an enhanced
			for loop? The result depends on whether you’re iterating through a collection of
			primitive values or objects. 
			
			If you’re iterating through an array of primitive values, manipulation of the loop variable will NEVER change the value of the array 
			being iterated because the primitive values are passed by value to the loop variable in an enhanced for loop.

			When you iterate through a collection of objects, the value of the collection is passed by reference to the loop variable. 
			Therefore, if the value of the loop variable is manipulated by executing methods on it, the modified value will be reflected in the
			collection of objects being iterated.
		 */
		
				StringBuilder myArr[] = {
				new StringBuilder("Java"),
				new StringBuilder("Loop")
				};
		
				for (StringBuilder val : myArr)
				System.out.println(val);
				
				for (StringBuilder val : myArr)
					val.append("Oracle"); //Here I'm calling a method that change the val value
				
				for (StringBuilder val : myArr)
					System.out.println(val);
							
				
				for (StringBuilder val : myArr) {
				val = new StringBuilder("Oracle"); //Here I assign a new value for the val, but val is only a variable local, so it has no effect over array or list objects
				//I am not calling method on val, I'm assign to it a new object, and changing his memory reference
				val.append("Teste"); //Has no effect over array or list objects
				}
				
				for (StringBuilder val : myArr)
				System.out.println (val);
				
				// Watch out for code that uses an enhanced for loop and its loop variable to change the values of elements in the collection 
				// that it iterates. This behavior often serves as food for thought for the exam authors.
				
				String [] s = {"A", "B", "C"};
				
				for(String s1 : s) {
					s1 = s1.replace('A', 'D'); //Doesn't change the String because it's immutable
					
				}
				
				for(String s1 : s) {
					System.out.println(s1);
				}
							
				
				/* ENHANCED FOR LOOP 
				 * 
				 * 	CAN’T BE USED TO INITIALIZE AN ARRAY AND MODIFY ITS ELEMENTS
				 * 	Although you can define a “counter” outside of the enhanced for loop and use it to initialize and modify 
				 * 	the array elements, this approach defeats the purpose of the for-each loop. The existing for loop is easier to 
				 * 	use in this case. 
				 * 	It compiles but is not the correct use.
				 *
				 * 	CAN’T BE USED TO DELETE OR REMOVE THE ELEMENTS OF A COLLECTION
				 * 	Because the for loop hides the iterator used to iterate through the elements of a collection,
				 * 	you can’t use it to remove or delete the existing collection values because you can’t call the remove method.
				 * 	If you assign a null value to the loop variable, it won’t remove the element from a collection:
				 */
				
				ArrayList<StringBuilder> myList1= new ArrayList<>();
				myList1.add(new StringBuilder("One"));
				myList1.add(new StringBuilder("Two"));
				
				for (StringBuilder val : myList1)
				System.out.println (val);
				
				for (StringBuilder val : myList1)
					//myList1.remove(val); //If I have more than 2 elements on the list I will have a concurrent modification exception
					val=null; //Has no effect 
				
				for (StringBuilder val : myList1)
				System.out.println(val);
				
				/*
				 * ENHANCED FOR LOOP CAN’T BE USED TO ITERATE OVER MULTIPLE COLLECTIONS OR ARRAYS IN THE SAME LOOP
				 * Use the for-each loop to iterate arrays and collections. Don’t use it to initialize, modify, or filter them.
				 *
				 * Working with a nested collection is not the same as working with a nested loop. 
				 * A nested loop can also work with unrelated collections.
				 * A nested loop executes all its iterations for each single iteration of its immediate outer loop.
				 *
				 * The enhanced for loop can’t be used to initialize an array and modify its elements.
				 *	- The enhanced for loop can’t be used to delete the elements of a collection.
				 *	- The enhanced for loop can’t be used to iterate over multiple collections or arrays in the same loop.
				 */
				
		num = 120;
		switch (num) {
		default:
			System.out.println("default");
			// case 0: System.out.println("case1"); 
			//TAKE CARE OF THIS, TWO CASES WITH MATH EXPRESSIONS THAT ARE EVALUATED TO THE SAME VALUE: 0 and (10 * 2 - 20)
		case 10 * 2 - 20:
			System.out.println("case2"); // you can’t define duplicate case labels for the switch statement
			break;
		}
					
	}
	
		private static void printMethod() {
			System.out.println("Happy");
		}		
}