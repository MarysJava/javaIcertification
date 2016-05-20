package d.string.stringbuilder.arrays.arraysList;

/**
 * @author mariaane
 *
 */
public class FreudExplainsString {

	
		public static void main(String[] args) {
			String s1 = new String("Mary");
			String s2 = new String("Mary");
			System.out.println(s1==s2); // Compare two string objects created using new
			
			String s3 = "Mary";
			String s4 = "Mary";
			System.out.println(s3==s4); //Compare two Strings created in String pool
			
			System.out.println(s3==s1); //Compare an object with a string created in the poll
			
			// BUT if I do this
			s1="Mary";
			System.out.println(s3==s1); //Compare two strings created in the String pool
			//The object s1 referred to lost its reference, and now s1 points to a String in the String pool
			
			//Or this
			s1=s2; //Now these two memory references are equal
			System.out.println(s1==s2); // Compare two identical memory references, because this, the default equals method returns true.
			//The default equals method compares memory references and is inherited from Object class
			
			String morning1 = "Morning";
			System.out.println("Morning" == morning1);// true, because it's a string literal in the string pool
			
			String morning2 = new String("Morning");
			System.out.println("Morning" == morning2); // false, because compare a literal value with an object reference
			
			//String objects are immutable so the pool can be called string constant pool
			
			String girl = new String("Shreya");
			char[] name = new char[]{'P','a','u','l'};
			String boy = new String(name); // String constructor can accept a char array

			
			//DON'T MIX STRING AND CHAR, you can construct a String by a char array using the String constructor
			//and a String is implemented internally as a char array but, String c = {'A', 'N'} is invalid
			//and char [] = "AnyString" is invalid - fail to compile!

			String s = null; // I can use null because it's an object
			
			//String can accept String Builder and String Buffer
			StringBuilder sd1 = new StringBuilder("String Builder");
			String str5 = new String(sd1);
			StringBuffer sb2 = new StringBuffer("String Buffer");
			String str6 = new String(sb2);
			
			/*
			If a String object is created using the keyword new, it always results
			in the creation of a new String object. A new String object gets created
			using the assignment operator (=) or double quotes only if a matching
			String object with the same value isn’t found in the String constant pool.			
			If the same String already exists a new one IS NOT created on the pool.
			
			Once created, the contents of an object of the class String can never be modified.
			
			The class String stores its values in a private variable of the type char array
(char value[]). Arrays are fixed in size and don’t grow once initialized.
			This value variable is marked as final in the class String. Note that final is a
nonaccess modifier, and a final variable can be initialized only once.
			None of the methods defined in the class String manipulate the individual elements
of the array value.

			IMPORTANT:
			All the methods defined in the class String, such as substring, concat, toLowerCase,
			toUpperCase, trim, and so on, which seem to modify the contents of the String object on
			which they’re called, CREATE AND RETURN A NEW STRING OBJECT, rather than modifying the
			existing value.
			 
			 */
			
			System.out.println("\nSTRING METHODS"); 
			System.out.println(boy); //Prints Paul
			
			//charAt (position) - accepts only integer as parameter
			System.out.println("\ncharAt");
			//System.out.println(boy.charAt(4)); //If there are not position 4 in a String throw a runtime exception
			System.out.println("charAt: "+boy.charAt(2)); //Prints u
			
			
			//indexOf (char) / (char, position) 
			//parameters: (char/string) or (char/string, integer)
			System.out.println("\nindexOf");
			System.out.println(boy.indexOf('B')); //There's no B in Paul, so returns -1
			System.out.println(boy.indexOf('u')); //Returns the index (2)
			System.out.println(boy.indexOf('U')); //Returns -1 (Java is Case Sensitive)
			System.out.println(boy.indexOf('a', 2)); //Returns -1 (because begins to search in the position 2 and a is in the position 1)
			System.out.println("a "+boy.indexOf("a", 1));
			System.out.println("Pa "+boy.indexOf("au")); 
			
			//substring (initialPosition) / substring (initialPosition, finalPosition) 
			//parameters: only integer
			System.out.println("\nsubstring");
			String exam = "Oracle";
			String sub = exam.substring(2); //returns a substring of a String from the position you specify to the end of the String - includes the start position
			System.out.println(sub); // Prints acle
			
			String result = exam.substring(2, 4); //substring method doesn’t include the character at the end position.  2, 4 = positions 2 and 3
			System.out.println(result); // Prints ac
			
			//trim			
			//without trim
			System.out.println("\ntrim");
			String varWithSpaces = " 	AB 	CB 	D				" +
					"     " +
					"     ";
			System.out.print(":");
			System.out.print(varWithSpaces);
			System.out.print(":");
			
			//with trim
			System.out.print(":");
			System.out.print(varWithSpaces.trim()); //this method DOESN'T remove the space WHITIN a String.
			System.out.println(":");
			
			//REPLACE() ('','') or ("","") // don't mix the types  - must be (char/char) or (string/string)
			//This method will return a new String by replacing all the occurrences of a char with
			//another char. Instead of specifying a char to be replaced by another char, you can
			//also specify a sequence of characters—a String to be replaced by another String:
			System.out.println("\nreplace");
			String letters = "ABCAB";
			//System.out.println(letters.replace('B', "b")); //Will not compile, mix char and String
			System.out.println(letters.replace('B', 'b'));
			System.out.println(letters.replace("CA", "12"));// B still uppercase because String is immutable, letters was not modified by the first method, it returned another String
			System.out.println(letters.replace("C", "1")); 
			
			//System.out.println(letters.replace('CA', '12')); 
			// Char doesn't accept more than one letter, except in case of unicode like: '\\u something'
			
			//lenght - no parameters!
			System.out.println("\nlenght");
			//The length of a String is one number greater than the position that stores its last character.
			System.out.println(letters.length()); //Return 5, but the positions are 0 to 4
			
			//startswith (string) / (string, position of start) AND ENDSWITH (string)  
			// parameters: only (string) /  (string/integer) - only used with Strings - double quotes ""
			System.out.println("\nstartsWith");
			System.out.println(letters.startsWith("AB"));
			System.out.println(letters.startsWith("a"));
			System.out.println(letters.startsWith("AB", 3)); //Begins with AB on the 3rd position? true
			System.out.println(letters.startsWith("A", 4));  //Begins with A on the 4rd position? false
			
			//The method endsWith() tests whether a String ends with a particular suffix. 
			//It returns true for a matching value and false otherwise:
			System.out.println("\nendsWith");
			System.out.println(letters.endsWith("CAB"));
			System.out.println(letters.endsWith("B"));
			System.out.println(letters.endsWith("b")); // Case sensitive
		
			//Method Chaining
			System.out.println("\nMethod Chaining");
			//IMPORTANT: THE METHODS ARE EVALUATED FROM LEFT TO RIGHT
			//The first method to execute in this example is replace, not concat.
			String result1 = "Sunday ".replace(' ', 'Z').trim().concat("M n");
			System.out.println(result1);
			
			//There’s a difference between calling a chain of methods on a String object 
			//versus doing the same and then reassigning the return value to the same variable:
			
			String day = "SunDday"; 
			day.replace('D', 'Z').substring(3); // Don't assign value to a day var
			System.out.println(day); //day doesn't change here!
			
			day = day.replace('D', 'Z').substring(3); //Assign value to a day var
			System.out.println(day); //day change here!
			
			
			//Concat Strings	
			System.out.println("\nConcat Strings");
			
			String aString = "OCJA"+"Cert"+"Exam";
			System.out.println(aString); 
			
			int num = 10;
			int val = 12;
			String aStr = "OCJA";
			String anotherStr = num + val + aStr; //Sum the numbers in this case
			System.out.println(anotherStr); //The + operator can be used with the primitive values, and the expression num + val +	aStr is evaluated from left to right.
		
			anotherStr = "" + num + val + aStr; //Don't sum the numbers in this case because of "" in the beginning of the sentence
			System.out.println(anotherStr); 
			
			String test = ""+ 10+20+30+40; //Don't sum the numbers in this case
			System.out.println(test);
			
			test = ""+ (10+20+30+40); //Sum the numbers in this case, because numbers are inside ()
			System.out.println(test);
			
			
			String lang = "Java";
			lang += " is everywhere!";
			System.out.println(lang);
			
			String initializedToNull = null;
			initializedToNull += "Java";
			System.out.println(initializedToNull); //Prints nullJava
			
			
			//Equals - Always use the equals method to compare two Strings for equality
			System.out.println("\nEquals");
			String e1="Mary";
			String e2="Mary";
			String e3 = new String("Mary");
			
			System.out.println(e1.equals(e2));
			System.out.println(e1.equals(e3));

		}
		
		/* Listing most important String methods
		 * charAt - char at specific position - parameter: integer
		 * indexOf - index of an specific char or string, can have a specific start to begin to look - parameters: (char/string) or (char/string, integer)
		 * substring (position from end), (initial position, final position - not included in the substring generated) - parameters: only integers
		 * lenght - string lenght - don't have parameters
		 * startsWith - starts with a specific sequence (only string). Can have a specific start. Parameters: (string) / (string, position of start)
		 * endsWith - ends with a specific string (only string)
		 * trim - no parameter - don't remove spaces between letters only in the beggining or in the end
		 * replace - replace a char for another char OR a string for another string ('','') or ("","")
		 * 		REPLACE DOES NOT ACCEPT char [] because it expects a single char or a String. 
		 */
}
