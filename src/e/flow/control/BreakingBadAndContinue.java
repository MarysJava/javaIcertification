package e.flow.control;

/**
 * @author mariaane
 *
 */
public class BreakingBadAndContinue {
	
	public static void main(String[] args) {
		
	/* BREAK
	 * The break statement is used to exit—or break out of—the for, for-each, do, and do-while loops, as well as switch constructs. 
	 * Alternatively, the continue statement can be used to skip the remaining steps in the current iteration and start with the next 
	 * loop iteration.
	 * The difference between these statements can be best demonstrated with an example. 
	 * You could use the following code to browse and print all of the values of a String array:
	 */

		String[] programmers = { "Paul", "Shreya", "Selvan", "Harry" };
		for (String name : programmers) {
			if (name.equals("Shreya"))
				break; //Exit loop
			System.out.println(name); 
		} // This loop prints only Paul
		
		//When you use the break statement with nested loops, it exits the INNER loop.
		
		/*
		 * CONTINUE
		 * The continue statement is used to skip the remaining steps in the current iteration and start with the next loop iteration.
		 */
		
		System.out.println();
		for (String name : programmers) {
			if (name.equals("Shreya"))
				continue; //As soon as a loop encounters continue, it exits the current iteration of the loop.
			System.out.println(name);
		}
		
		
		//When you use the continue statement with nested loops, it exits the current iteration of the inner loop.
		
		/* In Java, you can add labels to the following types of statements:
			- A code block defined using {}
			- All looping statements (for, enhanced for, while, do-while)
			- Conditional constructs (if and switch statements)
			- Expressions
			- Assignments
			- return statements
			- try blocks
			- throws statements
		 */
		
		outer:
		for (int i = 0; i < programmers.length; i++) {
		}
		
		outer : {
			int[] myArray = {1,2,3};
		}	
		
		
		//You can use a labeled break statement to exit an outer loop.
		System.out.println();
		String[] programmers1 = {"Outer", "Inner"};
		outer:
			for (String outer : programmers1) {
				outer1:
				for (String inner : programmers1) {
					if (inner.equals("Inner"))
						break outer;  //OUTS OF THE outer loop (first one)
					System.out.println(inner + ":");
				}
			}
		
		
		//When this code executes break outer:, control transfers to the line of text that marks the end of this block. 
		//It doesn’t transfer control to the label outer.
		String[] programmers2 = {"Paul", "Shreya", "Selvan", "Harry"};

		System.out.println();
		outer:
		for (String name1 : programmers2) {
			for (String name : programmers2) {
				if (name.equals("Shreya"))
					continue outer; //Skip remaining code for the current iteration of outer loop and starts with its next iteration
				System.out.println(name);
		}
		}
		
		//Break can't be used outside of a loop or switch
	}
}
