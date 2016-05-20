package d.string.stringbuilder.arrays.arraysList;

/**
 * @author mariaane
 *
 */
public class ManySidedArrays {

	/*
	 An array is an object that stores a collection of values. The fact that an array itself is an object is often overlooked. 
	 I’ll reiterate: an array is an object itself, which implies that it stores references to the data it stores. 
	 Arrays can store two types of data:
	 A collection of primitive data types
	 A collection of objects
	 
	 Object arrays store references (to objects) and primitive arrays store primitive values.
	  
	 An array type can be any of the following:
 		Primitive data type
 		Interface
 		Abstract class
 		Concrete class
 		
 		The first position of an arrays is always 0
	 */
	
	public static void main(String[] args) {
		
		int intArray[] = new int[] {4, 8, 107}; //Primitives
		String objArray[] = new String[] {"Harry", "Shreya", "Paul", "Selvan"}; //Objects
		
		//Three steps:
		//Declaring the array
		//Allocating the array
		//Initializing the array elements
		
		//DECLARING
		//Declaring the array - the [] can be after OR before the name OR after AND before the name - how many do you want.
		//Because no elements of an array are created when it’s declared, it’s invalid to define the size of an array with its declaration
		int intArray1[];
		String [] strArray;
		int[] multiArray[];
		int [][] multiArray1 [][];
		
		//ALLOCATING
		//Allocating the array
		//As the name suggests, array allocation will allocate memory for the elements of an array. 
		//When you allocate memory for an array, you should specify its dimensions, such as the number of elements the array should store. 
		//Note that the size of an array CAN'T expand or reduce once it is allocated.		
		intArray = new int[2];
		strArray = new String[4];
		multiArray = new int[2][3]; //amount of [] must match the amount of declaration
		
		//ARRAY SIZE MUST BE AN INTEGER!
		
		//Expressions evaluated as integer OK
		strArray = new String[Math.max(2, 3)]; // I can reinitialize strArray like this (Math.max(2, 3) = integer)
				
		//IMPORTANT: for multidimentional arrays it's ok to initialize only first value, the first value is mandatory always!
		// Amount of [] must match the amount of declaration
		multiArray1 = new int[2] [4] [] []; //I can do this, but I CAN'T DO THIS: new int[2] [] [4] [] - can't specify an array dimension after an empty dimension
		
		//Will not compile:
		//intArray = new int[]; //Missing the size
		//intArray[2] = new int; //Missing the allocation bracket
		//intArray = new [3] int; //Allocation bracket must be after the type (int)
		
		/* Once allocated, the array elements store their default values. For arrays that store objects, all the allocated array’s elements 
		 * store NULL. For arrays that store primitive values, the default values depend on the exact data types stored by them.
		 * Ex. default values for char /u0000, for int=0, decimal 0.0 and boolean=false
		 */
		
		//INITIALIZING
		//Initializing the array elements
		for (int i=0; i<intArray.length; i++) {
			System.out.println("Before: "+intArray[i]);
			intArray[i] = i + 5;
			System.out.println("After: "+intArray[i]);
		}
		
		intArray[0] = 10;
		intArray[1] = 1870;
		
		System.out.println(intArray[0]+intArray[1]); //PRINTS 1880
		
		/*
		 * Code to access an array index will throw a runtime exception if you pass it an invalid array index value. 
		 * Code to access an array index will fail to compile if you don’t use a char, byte, short, or int.
		 */

		char c = 1; //If I pass an integer, without '' after I can use it to access the array position like this:
		System.out.println(intArray[c]); //Very weird but c is a char and char is an int. Long does not work here!
		//If I use a char declared as char c = '1' it will compile but remember '1' is not the same as 1, so we will never know what number it will try to access
		//It can cause a runtime exception
		
		//intArray[0].length does not work because it refers to an int value
		//multiArray[i].length works because multiArray[i] is another array, and an array has the length value.
		//Note that all array objects can access the instance variable length, which stores the array size.
		
		//Mutidimensional
		for (int i=0; i<multiArray.length; i++) {
			for (int j=0; j<multiArray[i].length; j++) { 
				multiArray[i][j] = i + j;
			}
		}

		//If I do this multiArray = new int[2][]; the loop will fail with a null pointer exception
		
		//Without a loop
		multiArray[0][0] = 10;
		multiArray[0][1] = 110;
		multiArray[0][2] = 1087;
		multiArray[1][0] = 1210;
		multiArray[1][1] = 12;
		multiArray[1][2] = 10;
		
		//System.out.println(intArray[-10]); //Compile, but... ArrayIndexOutOfBoundException
	
		//You CAN'T remove array positions.
		
		//Combining:
			
		//You can combine all the previously mentioned steps of array declaration, allocation,	and initialization into one step, as follows:
		int intArray2[] = {0, 1};
		String[] strArray2 = {"Summer", "Winter"};
		int multiArray2[][] = { {0, 1}, {3, 4, 5} }; //Combining the declaration and initialization of a multidimensional array -
		
		/* 
		  In this case:
		  Doesn’t use the keyword new to initialize an array
		  Doesn’t specify the size of the array
		  Uses a single pair of braces to define values for a one-dimensional array and
		  multiple pairs of braces to define a multidimensional array */
		
		//OR
		//It's ok, use int and initialize in front of it! But NEVER put the size of the array inside the brackets!
		int intArray3[] = new int[]{0, 1};
		String[] strArray3 = new String[]{"Summer", "Winter"};
		int multiArray3[][] = new int[][]{ {0, 1}, {3, 4, 5}};
		
		//If you try to specify the size in this case... fail to compile!
		//Cannot define dimension expression when an array initializer is provided
		//int intArray4[] = new int[2]{0, 1}; //Fail to compile!
		
		// When you combine an array declaration, allocation, and initialization in a single step, you can’t specify the size of the array. 
		// The size of the array is calculated by the number of values that are assigned to the array.
		
		String  arrayteste [] = new String[2];
		arrayteste[0] = "Teste";
		arrayteste = new String[3]; // It's ok, reassign to an array
		arrayteste[1] = "Teste1";
		arrayteste[2] = "Teste2";
		System.out.println("Teste "+arrayteste[2] +" "+ arrayteste.length); //Lenght is 3!
		
		char[] charzin = "Ane".toCharArray();
		String  arrayteste1 [] = new String[]{"M", "Ane"};
		System.out.println("Teste "+arrayteste1[1]);
		
		int intArray5[];
		intArray5 = new int[]{0, 1}; //Using new is OK!
		
		//But you can’t miss the keyword new and initialize your array as follows:
		int intArray6[];
		//intArray6 = {0, 1}; //Failed to compile: IMPORTANT: Array constants can only be used in initializers. 
		
		/*
		 * If the type of an array is an interface, its elements are either null or objects that implement the relevant interface type.
		 * If the type of an array is an abstract class, its elements are either null or objects of concrete classes that extend the relevant abstract class.
		 * Because all classes extend the class java.lang.Object, elements of an array whose type is java.lang.Object can refer to any object. 
		
		 
		 public members:
			length — The variable length: contains the number of components of the array.
			
			clone() — This method overrides the method clone defined in class Object but doesn’t throw checked exceptions. 
			The return type of this method is the same as the array’s type. 
			For example, for an array of type Type[], this method returns Type[]. 
			
			Inherited methods — Methods inherited from the class Object, except the method clone.
		 */
		
		String [] myArrayString = new String[]{"A", "B"};
		String [] myArrayStringClone = myArrayString.clone();
		System.out.println(myArrayStringClone[1]);
		
		// String x Array lenght:
		//String — Retrieve length using the METHOD length()
		//Array — Determine element count using the VARIABLE length
		
		System.out.println("AAA".length()); //Method on String
		System.out.println(myArrayStringClone.length); //Final variable on an Array
	}	
}
