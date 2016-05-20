package e.flow.control;


/**
 * @author mariaane
 *
 */

public class TestEnhancedFor {

	public static void main(String[] args) {
		
		//String is IMMUTABLE
		//StringBuilder is MUTABLE
		String [] s = new String[] {"Hi", "Ane", "Hello"};
		StringBuilder sb [] =  new StringBuilder[] {new StringBuilder("Hi"), new StringBuilder("Ane"), new StringBuilder("Hello")};
		int [] myarr = new int[] {0,1,2,3};
		
		//String
		for(String si : s) {
			si = new String("OK"); // This don't change the value of si, because we are talking about a local copy
		}
		
		for(String si : s) {
			System.out.println(si);
		}
		
		System.out.println();
		
		for(String si : s) {
			si ="BLA"; // This don't change the value of si, because we are talking about a local copy
		}
		System.out.println();
		
		for(String si : s) {
			System.out.println(si);
		}
		System.out.println();
		
		
		//StringBuilder
		
		for(StringBuilder sb1 : sb) {
			sb1 = new StringBuilder("Test"); // This don't change the value of si, because we are talking about a local copy
			//Doesn't matter StringBuilder is mutable in this case, because this enhanced for do a local copy
		}
		
		for(StringBuilder sb1 : sb) {
			System.out.println(sb1); 
		}
		System.out.println();
		
		for(StringBuilder sb1 : sb) {
			sb1.append("12"); //This modify the value because the local copy POINTS to the same object memory reference 
			//and I'm changing the object state
		}
		
		for(StringBuilder sb1 : sb) {
			System.out.println(sb1); 
		}
		System.out.println();
		
		
		//int
		for(int i: myarr) {
			i = 10; //This don't change the value of si, because we are talking about a local copy
		}
		
		for(int i: myarr) {
			System.out.println(i);
		}
		
		System.out.println();
	}
}
