/********************************************************* {COPYRIGHT-TOP} ***
* IBM Confidential
* OCO Source Materials
* IBM Social Trending Analytics
*
* (C) Copyright IBM Corp. 2014  All Rights Reserved.
*
* The source code for this program is not published or otherwise  
* divested of its trade secrets, irrespective of what has been 
* deposited with the U.S. Copyright Office.
********************************************************* {COPYRIGHT-END} **/
package b.data.types;

/**
 * @author mariaane
 *
 */
public class OperatorsPrecedence {

	public static void main(String[] args) {
		
		int b1=20;
		int x=3;
		System.out.println((b1<10) && x++>5); //Prints false because b1>10 = evaluate to false
		System.out.println(x); //Previous statement don't evaluate the second clause, prints 3
		System.out.println(!(b1<10) && x++>5); //Prints false because !(b1>10) evaluates to true but x>5 evaluates to false
		
		//The operator ! has precedence of &&
		System.out.println(x); //Previous statement evaluate the second clause, prints 4
		System.out.println(!(b1<10 && x++>5)); //Changing the parenthesis prints  true, because logical returns false because b1<10 = false
		System.out.println(x); //Previous statement don't evaluate the second clause, prints 4
		
		//System.out.println(! b1<10 && x++>5); //Will not compile because try to negate b that is an int. You need to use the parethesis here!
		System.out.println(! (b1<10) && x++>=4); //Now it's OK, I'm negating (b1<10) expression which result is a boolean
		//IMPORTANT: first evaluate x>=4, and after sum +1 to x
		System.out.println(x);
	}
}
