//Because comments can be everywhere
package b.data.types;

/**
 * @author mariaane
 *
 */
public class MyBelovedDataTypes {
	
	//PRIMITIVE DATA TYPES
	//Numerics
	//Integer - When you can count a value in whole numbers, the result is an integer. It includes	both negative and positive numbers
	 byte myByte =0; //8 bits –128 to 127, inclusive
	 short myShort =0; //16 bits –32,768 to 32,767, inclusive
	 int myInt =0; //32 bits –2,147,483,648 to 2,147,483,647, inclusive - you don't need to care about this numbers to the test
	 
	 //To declare a long value you must use l or L in the end of the number, if you don't it will use an integer by default even you had declared the var as long
	 long myLong = 0; //64 bits –9,223,372,036,854,775,808 to 9,223,372,036,854,775,807, inclusive
	
	 //Floating Point
	 float myFloat = 0f;
	 double myDouble = 0d;
	 
	 //Character
	 char myChar=' ';
	 
	 //True or False
	 boolean myBoolean = false;

	 
	 //RANGE TEST
	 byte num = 127; //If I try 128 will not compile!
	 short sum = 32767; //If I try 32768 will not compile!
	 int total = 2147483647; //If I try 2147483648 will not compile!
	 long population = 9223372036854775807L; //If I try 9223372036854775808L will not compile!
	 long population1 = 2147483649l; //If I try without l or L it will not works because it will understand it's and integer
	 
	 //CHAR
	 //A char can store a single 16-bit Unicode character;
	 //you can use a value from \u0000 (or 0) to a maximum value of	 \uffff (or 65,535) inclusive. 
	 //char c=''; this is invalid
	 //Internally, Java stores char data as an unsigned integer value (positive integer).
	 
	 //The integer value 122 is equivalent to the letter 'z', but the integer value 122 is not equal to the Unicode value \u0122 that is 'Ģ'. 
	
	 public static void main(String[] args) {
		 char c=' ';
		 char c1='\u0000'; //Unicode character
		 char c2 = '\uffff'; //Unicode character
		 char c3='8'; // char c3="0"; will not compile because it's using double quotes and you must use SINGLE QUOTES to assign value to a char
		 char c4=65535; //If you try 65536 is out of a char range
		 char c5=0;
		 
		 // The former is a number in base 10 (uses digits 0–9) and the latter is a number in base 16 (uses digits 0–9 and letters a–f). 
		 // '\'u is used to mark the value as a Unicode value.
		 char c6=122; // It's Ok, and 122 = z letter
		 char c7='\u0122';  
		 //char c8 = -122; //Negatives are not allowed!
		 //BUT
		 char c8 = (char) -122; // Works BUT creates a strange value
		 //The char data type in Java doesn’t allocate space to store the sign of an integer. If you
		 //try to forcefully assign a negative integer to char, the sign bit is stored as the part of
		 //the integer value, which results in the storage of unexpected values.
		 
		 // This casts are valid. Cast to byte and short are not valid because they are less than char value (too short)
		 int i = (char) c7; //Here it gets the unicode value of c7, in case, 290
		 long l = (char) c1; //If char is empty so value = 0
		 float f = (char) c6;
		 double d = (char) c6;
		 
		 System.out.println("c:"+c);
		 System.out.println("c1:"+c1);
		 System.out.println("c2:"+c2);
		 System.out.println("c3:"+c3);
		 System.out.println("c4:"+c4);
		 System.out.println("c5:"+c5);
		 System.out.println("c6:"+c6);
		 System.out.println("c7:"+c7);
		 System.out.println("c8:"+c8);
		 
		 System.out.println("i: "+i);
		 System.out.println("l: "+l);
		 System.out.println("f: "+f);
		 System.out.println("d: "+d);
	 }
}
