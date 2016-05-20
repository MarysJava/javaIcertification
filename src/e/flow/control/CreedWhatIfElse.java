package e.flow.control;

/**
 * @author mariaane
 *
 */
public class CreedWhatIfElse {

	//TIP: THEN IS NOT A KEYWORD
	int then = 10; // I can declare a variable named then
	int hello = 12;
	
	public static void main(String[] args) {
		int score = 100;
		String result = "";
		String name = "Lion";
		java.io.File file = new java.io.File("F");
		
		if (name.equals("Lion"))
			score = 200;
		
		
		if (name.equals("Lion"))
			score = 200;
		else
			score = 300;
		
		//The last else statement is part of the last if construct, not any of the if constructs before it.
		//The if-else-if-else is an if-else construct in which the else part defines another if construct.
		//Then isn’t a keyword in Java and isn’t used with the if construct.
		if (score == 100)
			result = "A";
		else if (score == 50)
			result = "B";
		else if (score == 10)
			result = "C";
		else
			result = "F";
		
		
		//It works
		boolean testValue = false;
		if (testValue == true)
			System.out.println("value is true");
		
		if((score=score+10) > 110); //DO NOTHING BUT COMPILE AND WORKS
		
		//If I try to miss if and use only else - WON'T COMPILE
//		if (testValue == true)
//		else
//		System.out.println("value is false");
		
		//or do
			
		System.out.println("\nTest else");
		//else 			 //missing IF statement - WON'T COMPILE
			//System.out.println("Test else");
		
		
		// These two statements are the same:
		if(testValue==true);
		if(testValue);
		
		//and these are the same too:
		if(testValue==false);
		if(!testValue);
		
		
		// {}
		if (name.equals("Lion1"))
		score = 450;
		name = "Larry"; //It is not part of IF statement and will execute ever regardless the condition
		//For more than one line inside a if/else statement always use {}
		
		System.out.println("\n"+score + " "+name); //Score is not 450 because name is not equals Lion1, but name = Larry now.
		
		
		/* In the exam, watch out for code like this that uses misleading indentation in if constructs. 
		 * In the absence of a defined code block (marked with a pair of {}), only the statement following the if construct will be 
		 * considered to be part of it.
		 */
		
		//If I try to do this: WON'T COMPILE, because I have a sentence between if and else, so the compiler understand is a else without if.
		// if (name.equals("Lion"))
		//	score = 200;
		//	name = "Larry"; //I don't have a {} here. This line is not part of the if or the else. Compiler thinks the subsequent else doesn't have an if.
		//	else
		//	score = 129;
		
		
		//If I use {} so it's fine.
		// It's OK the if part has brackets {} and the else part has not
		// And if part can not have {} and else part can have {}
		if (name.equals("Lion")) {
			score = 200;
			name = "Larry";
		}
		else
			score = 129;
	
		if (name.equals("Lion")) 
			score = 200;
		else {
			score = 129;
			name = "Larry";
		} // If I don't use {}  the last sentence will be always executed
		
		//Even if name equals Lion, name will be assigned to Larry in this case:		
		if (name.equals("Lion")) 
			score = 200;
		else 
			score = 129;
			name = "Larry"; //This statement is not part of else anymore, because don't have {}
	
			
		//IMPORTANT
		//In case of a for, for example, the System.out is part of for statement, 
		//so it will execute only if name equals Lion even without use {}
		//When I have this kind of statement like for, the next statement is part of condition too, event I don't use {}
			
			name = "Lion";
			if (name.equals("Lion"))
				for (int i = 0; i < 3; ++i)
				System.out.println(i); //Executes only if the if evaluates to true, it's part of for statement
				System.out.println("Test"); //Always execute - out of for, out of if
	
				if (name.equals("Lion"))
					for (int i = 0; i < 3; ++i) {
					System.out.println(i); //Executes only if the if evaluates to true, it's part of for statement
					System.out.println("Test");  //Executes only if the if evaluates to true, it's part of FOR statement
					}
				
				if (name.equals("Lion")) {
					for (int i = 0; i < 3; ++i) 
					System.out.println(i); //Executes only if the if evaluates to true, it's part of for statement
					System.out.println("Test");  //Executes only if the if evaluates to true, it's part of IF statement 
					}	
				
			// If the single statement inside IF has more than one statement like a for line it will execute as a single command
			// Each if or for who wants to execute more than one SEPARATED command needs to use {} or only the first line will be executed
				
			if(name== "Lion") { //Not a good practice but is valid and if the String was instantiated using "" and not new method, so it will works
				System.out.println("True"); //If I use name== new String("Lion") it will not prints true
			}
			
			//if (allow = true) - In this case I'm not using double == BUT a single = so it's an ASSIGNMENT not a comparison
			//There are no syntactical errors, there is a logical error
			
			//TIP: TAKE CARE WITH THE INDENTATION
			score = 110;
			if (score > 200) {
			if (score < 400)
			if (score > 300)
				System.out.println(1);
			else
				System.out.println(2);
			} //Because the use of { the else belongs to the first if
			else 
			System.out.println(3); //Prints 3
			
			if (score > 200) // Print nothing because there's no else for score > 200
				if (score < 400)
				if (score > 300)
					System.out.println(1);
				else
					System.out.println(2);
				//Because I don't use  { the else belongs to the second if
				else 
				System.out.println(3);
			
			//When the if constructs don’t use curly braces, don’t get confused	by the code indentation, which may or may not be correct.
			//Start working from the inside out, with the inner most if-else statement, matching each else with its nearest unmatched if statement.
			
			//Exam Trick
			//	The if condition (that is, a++ > 10) evaluates to false because the postfix increment
			//	operator (a++) increments the value of the variable 'a' immediately after its earlier
			//	value is used.
			System.out.println("\nExam Trick");
			int a = 10;
			if (a++ > 10) { //FIRST EVALUATE a>10 after sum +1 to a
			System.out.println("true");
			}
			{
			System.out.println("false");
			}
			System.out.println("ABC");
			
			// You may think that 10/3 will return a decimal
			// number, which can’t be assigned to the variable num, but this operation discards
			// the decimal part and compares 3 with the variable num.
			int num = 10/3;
			System.out.println(num);
	}	
}