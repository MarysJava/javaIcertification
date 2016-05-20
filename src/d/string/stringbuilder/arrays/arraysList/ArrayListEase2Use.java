package d.string.stringbuilder.arrays.arraysList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import a.java.basics.WeirdPerson;

/**
 * @author mariaane
 *
 */
public class ArrayListEase2Use {
	
	//The ease of use of an ArrayList.
	
	/* ADVANTAGES
	 You can compare an ArrayList with a resizable array. As you know, once it’s created, you can’t increase or decrease the size 
	 of an array. 
	 On the other hand, an ArrayList automatically increases and decreases in size as elements are added to or removed from it. 
	 Also, unlike arrays, you don’t need to specify an initial size to create an ArrayList.

	 It implements the interface List.
	 It allows null values to be added to it.
	 It implements all list operations (add, modify, and delete values).
	 It allows duplicate values to be added to it.
	 It maintains its insertion order.
	 You can use either Iterator or ListIterator (an implementation of the  Iterator interface) to iterate over the items of an ArrayList.
	 It supports generics, making it type safe. (You have to declare the type of the elements that should be added to an ArrayList with its declaration.)
	 */

	ArrayList<String> myArrList = new ArrayList<>(); //Needs to import java.util.ArrayList;
	//This declaration works in Java 7.0 and above: new ArrayList<>(); without <String> on the right side
	
	//It offers you all of the benefits of using an array, with none of the disadvantages. It offers an expandable array that is modifiable.
	//An ArrayList uses an array to store its elements. It provides you with the functionality of a dynamic array.
	
	public static void main(String[] args) {
		ArrayList<String> myArrList = new ArrayList<>(); 
		ArrayList<String> myArrListSize= new ArrayList<>(10); //It's OK, you can pass the size of the array if you want
		myArrList.add("Teste");
		myArrList.add("Teste1");
		myArrList.add("Teste2");
		myArrList.add("Teste3");
		//myArrList.add(1);//Fail to compile, because the type of array is String
		myArrList.add(2,"AAA");
		
		/*
		 An ArrayList preserves the order of insertion of its elements. Iterator, ListIterator, and the enhanced for loop will return 
		 the elements in the order in which they were added to the ArrayList. 
		 
		 An iterator (Iterator or ListIterator) let you remove elements while you iterate an ArrayList. 
		 It’s not possible to remove elements from an ArrayList while iterating it using a 'for loop'.
		 */
		
		//Modifying
		System.out.println(myArrList.get(1));
		myArrList.set(1, "One and Half");
		System.out.println(myArrList.get(1));
		
		//You can also modify the existing values of an ArrayList by accessing its individual elements.
		ArrayList<StringBuilder> builder = new ArrayList();
		builder.add(new StringBuilder("AAAAA"));
		builder.add(new StringBuilder("BBBBB"));
		builder.add(new StringBuilder("CCCCC"));
		

		for(StringBuilder s : builder) {
			s.append(builder.size());
			System.out.println(s);
		}
		
		
		//Test Iteration
		System.out.println("ENHANCED FOR");
		for(String s : myArrList) {
			//It’s not possible to remove elements from an ArrayList while iterating it using a enhanced for loop.
			//ConcurrentModificationException
			System.out.println(s);
		}
		
		
		System.out.println("LIST ITERATOR");
		ListIterator<String> iterator = myArrList.listIterator();
		while (iterator.hasNext()) {
			//I can remove an element here
			String s = iterator.next();
			if(s.equals("Teste2")) {
				myArrList.remove(s);
				System.out.println("Removing: "+s);
			}
			System.out.println(s);
		}
		
		
		System.out.println("ITERATOR");
		Iterator<String> iterator1 = myArrList.iterator();
		while (iterator1.hasNext()) {
			//I can remove an element here
			String s = iterator1.next();
//			if(s.equals("Teste2")) {
//				myArrList.remove(s);
//				System.out.println("Removing: "+s);
//			}
			System.out.println(s);
		}
	
		//REMOVE method
		/*
		 remove(int index) — This method removes the element at the specified position in this list.
		 remove(Object o) — This method removes the first occurrence of the specified element from this list, if it’s present (compare using equals).
		*/
		
		ArrayList<StringBuilder> myArrList1 = new ArrayList<>();
		StringBuilder sb1 = new StringBuilder("One");
		StringBuilder sb2 = new StringBuilder("Two");
		StringBuilder sb3 = new StringBuilder("Three");
		StringBuilder sb4 = new StringBuilder("Four");
		myArrList1.add(sb1);
		myArrList1.add(sb2);
		myArrList1.add(sb3);
		myArrList1.add(sb4);
		myArrList1.remove(1); //Remove the seconde element (Two)
		
		for (StringBuilder element : myArrList1)
			System.out.println(element);
		
		myArrList1.remove(sb3); //OK
		myArrList1.remove(new StringBuilder("Four")); //FAIL TO REMOVE
		//IF YOU OVERWRITE EQUALS OF STRINGBUILDER TO COMPARE 'NAME' (NOT OBJECT) IT WILL WORKS
		
		/*
		 Two objects are equal if their object references (the variables that store them) point to the same object.
	  	 You can always override the equals method in your own class to change this default behavior.
		 */
		
		System.out.println();
		for (StringBuilder element : myArrList1)
			System.out.println(element);		
	
		//Testing remove in a class that has equals
		ArrayList<WeirdPerson> people = new ArrayList<>();
		people.add(new WeirdPerson("Mary"));
		people.add(new WeirdPerson("David"));
		people.add(new WeirdPerson("Paul"));
		people.add(new WeirdPerson("Julie"));
		people.add(new WeirdPerson("Rick"));
		
		people.remove(new WeirdPerson("Rick")); // Remember Java is Case Sensitive! If you use rick he will not be removed
		
		for (WeirdPerson p : people)
			System.out.println(p.getName());	//Rick is gone
		
		/*
		 Method addAll(Collection<? extends E> c) appends all of the elements in the specified collection to the end of this list in the order 
		 in which they’re returned by the specified collection’s Iterator. 
		 */
		
		ArrayList<WeirdPerson> people1 = new ArrayList<>();
		people1.add(new WeirdPerson("Ane"));
		people1.add(new WeirdPerson("L"));
		people1.add(new WeirdPerson("C"));
		people1.add(new WeirdPerson("J"));
		WeirdPerson p1=new WeirdPerson("R");
		people1.add(p1);
		people1.add(p1); //An ArrayList CAN accept duplicate object values.
		
		System.out.println();
		people.addAll(people1);
		for (WeirdPerson p : people)
			System.out.println(p.getName());
		
		people.removeAll(people1);
		System.out.println();
		for (WeirdPerson p : people)
			System.out.println(p.getName());
		
		people.addAll(2, people1); // Add starting in the position 2, shift Paul to right
		System.out.println();
		for (WeirdPerson p : people)
			System.out.println(p.getName());
		
		System.out.println("GET: "+people.get(1).getName()); //GET
		
		people.clear(); // Clear all objects in the array
		System.out.println(people);
		System.out.println("CLEAR");
		for (WeirdPerson p : people)
			System.out.println(p.getName());
			
		people.addAll(people1);
		
		/*
		get(int index) — This method returns the element at the specified position in this list.
		 If the requested element isn’t within the range, the get method throws a java.lang.IndexOutOfBoundsException error at runtime.
 		size() — This method returns the number of elements in this list.
 		contains(Object o) — This method returns true if this list contains the specified element. (using equals method!)
		indexOf(Object o) — This method returns the index of the first occurrence of the specified element in this list, 
			or –1 if this list doesn’t contain the element.
 		lastIndexOf(Object o)—This method returns the index of the last occurrence of the specified element in this list, 
 			or –1 if this list doesn’t contain the element.
		 */
		
		ArrayList<WeirdPerson> copy1 = people; // Same reference, to the same objects
		ArrayList<WeirdPerson> copy2 = (	ArrayList<WeirdPerson>) people.clone(); // Create new reference pointing to the SAME ELEMENTS
		
		System.out.println("CLONE");
		System.out.println(people==copy1); //true because is the same reference
		System.out.println(people==copy2); //false, clone don't give the same memory reference
		
		//but
		
		System.out.println(people.get(0) == copy1.get(0)); //True - because it's the same element
		System.out.println(people.get(0) == copy2.get(0)); //True
		
		copy2.get(0).setName("Marie");
		System.out.println(people.get(0).getName()); //Change all names from Marie (copy2, people and copy1 name) - same element
		System.out.println(people.get(0).equals(copy1.get(0))); //True - because it's the same value
		System.out.println(people.get(0).equals(copy2.get(0))); //True
		
		
		//TO ARRAY
		//Method toArray doesn’t return a reference to this array. It creates a new array, copies the elements of the ArrayList
		//to it and then returns it.
		
		Object p [] = people.toArray();
		
		/* If you modify the returned array by, say, swapping the position of its elements or by assigning new objects to its elements, 
		 the elements of ArrayList won't be affected. 
		 But, if you modify the state of (mutable) elements of the returned
		 array, then the modified state of elements will be reflected in the ArrayList.*/
		
		System.out.println("Normal");
		for (WeirdPerson pe : people)
			System.out.println(pe.getName());
		
		//This don't change the order in the original list because it's another array
		Object test = p[0];
		p[0] = p[1];
		p[1] = test;
		
		WeirdPerson pe1 = (WeirdPerson) p[1];
		//This change the name on the original list because it's the same element
		pe1.setName("Astrogildes");
		
		System.out.println("SWAP"); 
		for (Object pe : p) {
			System.out.println(((WeirdPerson)pe).getName());
		}
		
		System.out.println("List");
		for (WeirdPerson pe : people)
			System.out.println(pe.getName());
		
		
		
		System.out.println("\nONE MORE TEST USING SET");
		List<String> st = new ArrayList<String>(10);
		
		for(int i=0; i< 10; i++) {
			st.add(i, new String("Bla"));
		}
		
		st.set(3,"Oi"); //Remember the first element is in the position 0
		
		System.out.println("Position 3: "+st.get(3));
		
		System.out.println("Total size: "+st.size());
		
		//Printing the array
		for(String si : st) {
			System.out.println(si);
		}
		
		
		/* In the exam, watch out for questions about the correct implementation of the equals method to compare two objects 
		   versus questions about the equals methods that simply compile correctly. 
		 
		  If you’d been asked whether equals() in the example code below would compile correctly, the correct answer is yes.
		  
		  IMAGINE THE EQUALS OF THE FIRST OBJECT IS BEING CALLED SO
		  obj1.equals(obj2)
		  if method equals of obj1 returns always true, it will be true
		  but if obj2 is another type of object obj2.equals(obj1) can return false, because it will be another equals method
		  
		  Ex:		 
		 
		  class BankAccount {
			String acctNumber;
			int acctType;
			
			public boolean equals(Object anObject) {
				return true; //This broke the EQUALS CONTRACT
			}
		}

		 	BankAccount acct = new BankAccount();
			String str = "Bank";
			System.out.println(acct.equals(str)); //true
			System.out.println(str.equals(acct)); //false because equals being called on String str will return false
			
			See more explanations in Person.java file (a.java.basics package)
		 */
	}
}
