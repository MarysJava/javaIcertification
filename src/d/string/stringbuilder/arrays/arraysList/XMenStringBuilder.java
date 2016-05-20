package d.string.stringbuilder.arrays.arraysList;

import a.java.basics.WeirdPerson;

/**
 * @author mariaane
 *
 */
public class XMenStringBuilder {

	/*
	 The class StringBuilder is defined in the package java.lang and it has a mutable sequence of characters. 
	 You must use class StringBuilder when you’re dealing with larger strings or modifying the contents of a string often. 
	 Doing so will improve the performance of your code. Unlike StringBuilder, the String class has an immutable sequence of characters. 
	 Every time you modify a string that’s represented by the String class, your code actually creates new String objects 
	  	instead of modifying the existing ones.
	 */
	
	//Constructors 
	StringBuilder sb1 = new StringBuilder();  // without parameter - initial capacity of 16 characters.
	StringBuilder sb2 = new StringBuilder(sb1); // string builder
	StringBuilder sb3 = new StringBuilder(50); // initial value of string builder
	StringBuilder sb4 = new StringBuilder("Shreya Gupta"); // string
		
	public static void main(String[] args) {
		StringBuilder sb5 = new StringBuilder(new StringBuffer());
		System.out.println(sb5);
		
		//charAt indexOf and substring - the same methods used with Strings
		//They don't modify StringBuilder object
		System.out.println("\ncharAt");
		System.out.println("\nindexOf");
		System.out.println("\nsubstring");
		StringBuilder sb4 = new StringBuilder("Shreya Gupta"); // string
		System.out.println(sb4.charAt(2));
		System.out.println(sb4.indexOf("A", 3));
		System.out.println(sb4.substring(0,3));
		System.out.println(sb4);
		
		//append - CHANGE the value of object StringBuilder  
		//parameters: (string/char) /  append(string/char array, begin, end of char array)  
		//IMPORTANT: append method only allows you to add the requested data at the END of the StringBuilder object
		System.out.println("\nappend");
		
		StringBuilder sb1 = new StringBuilder();
		System.out.println("Teste: "+sb1.append(true)); //Prints true
		sb1.append(10);
		sb1.append('a');
		sb1.append(20.99);
		sb1.append("Hi");
		sb1.append(new WeirdPerson("Teste")); //I can append anything
		sb1.append(new StringBuffer("Ahahaha"));  // In this case toString of StringBuffer returns my string so it will be appended correctly
		
		//If the toString method has been overridden by the class, then the method append will add the String value returned by it
		
		/* For classes that haven’t overridden the toString method, the
		append method appends the output from the default implementation of
		method toString defined in class Object.
		The default implementation of the method toString in the
		class Object returns the name of the class followed by the @ char and unsigned hexadecimal representation of the hash code of the 
		object (the value returned by the object’s hashcode method). */
		
		System.out.println("\nappend using positions");
		System.out.println(sb1); //Prints true10a20.99Hia.java.basics.Person@d3a2d982
		sb1 = new StringBuilder();
		char[] name = {'J', 'a', 'v', 'a', '7'};
		sb1.append(name, 1, 3); //append for positions 1 to 3, position 3 included - positions are only to a char array (or String)
		System.out.println(sb1);
		sb1.append("TestAppend", 1, 3); //append for positions 1 to 3, position 3 included - positions are only to a char array (or String)
		System.out.println(sb1);
		
		//INSERT 
		//insert (position, string or char) /  insert(position, string or char array, begin, end of char array)
		//insert method enables you to insert the requested data at a particular position
		//You can also insert a complete char array, StringBuffer, or String or its subset, as follows:
		System.out.println("\ninsert");		
		StringBuilder sb2 = new StringBuilder("Bon");
		sb2.insert(2, "rr"); //insert a char or string (''  or  "") in the position 2 (position of the n) and n goes to right
		sb2.insert(3, new WeirdPerson("Thalia")); 
		sb2.insert(2, 'a'); //I can insert '' or ""
		System.out.println(sb2); // Prints Bora.java.basics.Person@b463c18arn
		
		StringBuffer b = new StringBuffer("AAAA"); //can be inserted or appended because it is a char array
		
		sb1 = new StringBuilder("123");
		char[] name1 = {'J', 'a', 'v', 'a'};
		sb1.insert(1, name1, 1, 3); 
		sb1.insert(1, b, 1, 3);  //positions are only to a char array (or String)
		System.out.println(sb1);// Prints 1ava23 because 2 shift to right
		
		
		//DELETE() AND DELETECHARAT()
		System.out.println("\ndelete and deleteCharAt");	
		//The method delete removes the characters in a substring of the specified StringBuilder.
		sb1 = new StringBuilder("0123456");
		sb1.delete(2, 4); // Deletes 2 and 3 (positions 2 and 3 - like substring)
		System.out.println(sb1);
		
		sb1 = new StringBuilder("0123456");
		sb1.deleteCharAt(2); //DELETE CHAR AT POSITION 2
		System.out.println(sb1);
		
		//TIP Combinations of the deleteCharAt and insert methods can be quite confusing.
		sb1 = new StringBuilder("0123456");
		sb1.insert(1, 'a').delete(3, 5);
		System.out.println(sb1); //Prints 0a1456 because first insert a, after remove 2 and 3, because now 2 is in the 3rd position.
		
		sb1 = new StringBuilder("0123456");
		sb1.insert(5, 'a').deleteCharAt(6);
		System.out.println(sb1); //Prints 01234a6: a is inserted in the 5 place and 5 becomes the 6 position that was removed
		
		
		//REVERSE - REVERSE THE CHARACTER SEQUENCE
		System.out.println("\nreverse");	
		StringBuilder reverse = new StringBuilder("Let's play now!");
		reverse.reverse();
		System.out.println(reverse); //These methods change the StringBuilder value because it's mutable. String isn't!
		
		//REPLACE
		System.out.println("\nreplace");	
		sb1 = new StringBuilder("0123456");
		sb1.replace(3, 6, "Content"); //Remove 3 to 6 - 3 included and 6 not included like in substring and add "Content" in this place
		System.out.println(sb1);
		
		//SUBSEQUENCE
		//IMPORTANT: like substring, this method doesn't modify the original StringBuilder
		System.out.println("\nsubsequence");	
		sb1 = new StringBuilder("0123456");
		System.out.println(sb1.subSequence(2, 4)); //Prints 23, like substring 4 is not is not included
		System.out.println(sb1); 
		
		
		//String Builder doesn't have trim method
		
		 /* Listing StringBuilder methods
		 * Doesn't modify the StringBuilder value:
		 * charAt - char at specific position - parameter: int
		 * indexOf - index of an specific string (can't use char here), can have a specific start to begin to look - parameters: (String), (String, int)
		 * substring (the specified position until the end), (initial position, final position - not included) 
		 * subsequence is the same of substring 
		 * 
		 * Modify the StringBuilder value:
		 * append - append in the end of a string - anything can be appended - append(toAppend) or append(charArray, initial position of char array, final position of char array)
		 * insert - insert in a specific position - anything can be inserted - insert(position, toInsert) or insert(position, charArray, initial position of char array, final position of char array)
		 * delete(initial position, final position) 
		 * deleteCharAt(specific position)
		 * reverse - reverse the StringBuilder order 
		 * replace - replace one position initial-end with a value of a String (only a String value)
		 * 
		 * 
		 * TIPS:
		 * STRING IS A CHAR ARRAY
		 * STRING BUFFER IS A CHAR ARRAY
		 * char IS NOT a char array!
		 * char array [] and StringBuffer are not Strings
		 *
		 * JUST TO KNOW:
		 * The methods of the class StringBuffer are synchronized where necessary, whereas the methods of the class StringBuilder aren’t.
		 * When you work with the class StringBuffer, only one thread out of multiple threads can execute your method. This arrangement prevents any inconsistencies in the values
of the instance variables that are modified by these (synchronized) methods. But it introduces additional overhead, so working with synchronized methods and the
StringBuffer class affects the performance of your code.
	 	 * The class StringBuilder offers the same functionality as offered by StringBuffer, minus the additional feature of synchronized methods. Often your code won’t be
accessed by multiple threads, so it won’t need the overhead of thread synchronization.
		 * If you need to access your code from multiple threads, use StringBuffer; otherwise use StringBuilder.
		 * 
		 */
		
		//Certification Test - example
		StringBuilder ejg = new StringBuilder(10 + 2 + "SUN" + 4 + 5);
		System.out.println(ejg); //Sum 10+2 but not 4+5 because before 4+5 has a String. If were (4+5) it would be SUM too
		ejg.append(ejg.delete(3, 6)); //Delete first and append (updated) value to itself 12S5.append(12S5).
		System.out.println(ejg);
	}
}
