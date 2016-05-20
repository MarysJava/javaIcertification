package d.string.stringbuilder.arrays.arraysList;

import java.util.ArrayList;

/**
 * @author mariaane
 *
 */

public class ArrayTests {
	public static void main(String[] args) {
		
		//Declare a String array
		String [] arr = new String[] {new String("Hi"), new String()};
		arr[1] = "Test"; //Set the value to the element in position 1 to Test
		
		//Try to change value of elements using an enhanced for
		for(String s : arr) {
			s = new String("Price"); //Refers to a local copy, don't change the objects (enhanced for)
		}
		
		System.out.println("Printing String array after enhanced for: ");
		printArray(arr);
		
		//Try to change value of elements using a normal for loop
		for(int i=0; i< arr.length; i++) {
			arr[i] = new String("Price"); //Change the objects, not a local copy
		}
		
		System.out.println("Printing String array after normal for: ");
		printArray(arr);
		
		//Declaring an int array
		int arr1[] = new int[] {0,1,2,3};
		arr1[3]=5; //Changes the value of an element in the array
		
		//Try to change the value of the int elements in array using an enhanced for
		for(int s : arr1) {
			s = 1; //This assignment does not reflect on the real array, because s is a copy of the element (enhanced for)
		}
		System.out.println("Printing int array after enhanced for: ");
		printArrayInt(arr1);
		
		for(int i=0; i< arr1.length; i++) {
			arr1[i]=1; //In this case I'm changing the element, is not a local copy
		}
		System.out.println("Printing int array after normal for: ");
		printArrayInt(arr1);
		
		int val=20;
		System.out.println("Val variable is "+val+"\n");
		//Using a method that use normal for to change array values
		changeArrayTest(arr1, val);
		System.out.println("Printing int array after method that use normal for: ");
		printArrayInt(arr1);
		
		System.out.println("changeArrayTest method doesn't change the value of variable val: it remains "+val+"\n"); //Val is a primitive and it's not changed by the method changeArrayTest
		//Passed by copy not reference
		
		//Using a method that use enhanced for to change array values
		changeArrayTestEnhancedFor(arr1);
		System.out.println("Printing int array after method that use enhanced for: ");
		printArrayInt(arr1);
		
		//Declaring an ArrayList
		ArrayList<String> myarraylist = new ArrayList<String>();
		myarraylist.add(0,"Fofy");
		myarraylist.add(1,"Fofy 1");
		myarraylist.add(2,"Fofy 3");
		System.out.println("Position 0 of myarraylist ArrayList: "+myarraylist.get(0));
	}

	static void changeArrayTest(int[] arr1, int val) {
		val=30;
		for(int i=0; i< arr1.length; i++) {
			arr1[i]=22; //Here I'm changing the array elements, it has effect because I'm using a memory reference to change an element
			//and I'm using for, for don't make a local copy like enhanced for
		}
		arr1=null;//This has no effect in the calling method because arr1 is a reference
		// This refers to the same arr1 on the calling method but is not the same object
	}
	
	static void changeArrayTestEnhancedFor(int[] arr1) {
		for(int i : arr1) {
			i=40; 
		}
		arr1=null;//This has no effect in the calling method because arr1 is a reference
		// This refers to the same arr1 on the calling method but is not the same object
	}
	
	private static void printArray(String[] arr) {
		for(int i=0; i< arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println();
	}
	
	private static void printArrayInt(int[] arr1) {
		for(int i=0; i< arr1.length; i++) {
			System.out.println(arr1[i]);
		}
		System.out.println();
	}
}