package e.flow.control;

/**
 * @author mariaane
 *
 */
public class ShakespeareWhileOrDoWhile {

	public static void main(String[] args) {
		
		//WHILE
		//This loop checks the condition before it executes
		boolean bunsAvailable = true;
		boolean noMoreBuns =false;
		
		while (bunsAvailable) {
		//... prepare burger ...
		if (noMoreBuns)
			bunsAvailable = false;
		noMoreBuns =true;
		}
		System.out.println("OFF");
		
		int num = 9;
		boolean divisibleBy7 = false;
	
		while (!divisibleBy7) { //While !true (false) don't do anything, While !false (true) does.
		System.out.println(num);
		if (num % 7 == 0) divisibleBy7 = true;
			--num;
		}
		
		
		divisibleBy7 = true;
		while (divisibleBy7 == false) { //The code won’t enter the loop because the condition divisibleBy7==false isn’t true.
		System.out.println(num);
		if (num % 7 == 0) divisibleBy7 = true;
		--num;
		}
		
		//DO WHILE
		//This loop checks the condition after it completes the execution of all the statements in its loop body.
		//IMPORTANT: Don’t forget to use a semicolon (;) to end the do-while loop after specifying its condition. 
		//Even some experienced programmers overlook this step!
		
		System.out.println("DO WHILE");
		num=9;
		divisibleBy7 = false;
		do {
			System.out.println(num);
			if (num % 7 == 0) divisibleBy7 = true;
			num--;
		} while (divisibleBy7 == false);
		
		
		System.out.println("DO WHILE - 1");
		num=9;
		divisibleBy7 = true; //Here I'am changing the boolean to true AND the loop condition is while (divisibleBy7 == false);
		do {
			System.out.println(num);
			if (num % 7 == 0) divisibleBy7 = true;
			num--;	
		} while (divisibleBy7 == false);  //DON'T FORGET THIS ;
		System.out.println("END\n");
		// Executes at least once, even if the condition IS NOT evaluated to true because the condition 
		// is evaluated at the end of execution of the loop body.
		
		/* Without the use of curly braces, only the first line of code will be considered a part of the while or do-while loop, 
		 * as specified in the if-else construct.
		 * Similarly, the rules that define an appropriate expression to be passed to while and do-while loops are as 
		 * for the if-else construct. Also, the rules for defining nested while and do-while loops are the same as for an if-else 
		 * construct.
		 */
		
		//Do while with more than one statement and without {} will not compile 
		num = 9;
		do  
			System.out.println(num); //Prints 8 - One statement without {} it's OK
		 while (divisibleBy7 == false); 
		
		while(!divisibleBy7) 
			System.out.println("OK"); //Don't print here
		System.out.println("OK1"); //Always print here - it's outside of the loop
		
		
		num=10;
		do {
		num++;
		} while (++num > 20);
		System.out.println (num); //Prints 12: loop executes once, num++ turns num to 11, ++num turns num to 12
		
		num=10;
		while (num++ > 20) {
			num++;
		}
		System.out.println(num); //Prints 11: the condition is evaluated but loop never execute
		System.out.println();

		
		//IMPORTANT
		//Using literals like true/false
		//while(false) WILL NOT COMPILE
		//while(true) COMPILE BUT IF THERE ARE CODE AFTER THE BLOCK, WILL NOT COMPILE -> unreachable code
		String settings;
		boolean b=false; 
		while (b) {  
			settings = "Adjust settings manually";
		}
		
		//IMPORTANT
		//VAR settings WAS NOT INITIALIZED - the code NEVER ENTER IN THE LOOP above because b = false 
		//If I try to user the variable settings the code NOT COMPILE
		// if (settings==null) { 
		// }
		//System.out.println("Camera:" + settings);
		
		
		
		/* WHEN USE
		 *  
		 * You should try to use a FOR loop when you know the number of iterations — for example, when you’re iterating through a 
		 * collection or an array, or when you’re executing a loop for a fixed number of times, say to “ping” a server five times.
		 * 
		 * You should try to use a DO-WHILE or a WHILE loop when you don’t know the number of iterations beforehand, 
		 * and when the number of iterations depends on a condition being true—for example, when accepting passport renewal 
		 * applications from applicants until there are no more applicants. 
		 * In this case, you’d be unaware of the number of applicants who have submitted their applications on a given day.
		 * 
		 * If it needs to execute at least once, use do-while loop.
		 */
	}
}
