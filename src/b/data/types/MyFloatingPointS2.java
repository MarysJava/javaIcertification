package b.data.types;

/**
 * @author mariaane
 *
 */
public class MyFloatingPointS2 {

	
	//To initialize usually do 0f or 0F and 0d or 0D
	float myFloat =3.4028235E+38f; //float 32 bits +/–1.4E–45 to +/–3.4028235E+38, +/–infinity, +/–0, NaN
	//If I try 3.4028235E+39f is out of a float's range.
	//If I try 3.4028235E+38 without f in the end of declaration, it works because it thinks it's a double (double is the default).

	double myDouble = 0.0; //double 64 bits +/–4.9E–324 to +/–1.7976931348623157E+308, +/–infinity, +/–0, NaN
	
	double cientific = 1201762e2; // Use of d or D is redundant because double is the default, but it is valid
	//Underscores must be located within digits
	
	//You can’t place an underscore prior to a D, d, F, or f suffix (these suffixes are used to mark a floating-point literal as double or float).
	//You can’t place an underscore adjacent to a decimal point.	
	
	//long x = 2.0; Integer values can't receive decimal values
	
	public static void main(String[] args) {
		//Float and double can accept integer values
		float a =2; //I'm not using f or F so compiler will understand it's a double
		double b = 3;
		System.out.println(a+" "+b);
		
		long l = 10l;
		double d =10.0;
		float f =9.0f;
		// I can put an non decimal in a decimal but the inverse is not true (not compile)
		f=l;
		d=l;
		
		System.out.println(l<f); //I can compare a decimal with a non decimal
		
		System.out.println(l+" "+d + " "+ f); //Prints 10 10.0 10.0
		
		System.out.println(l+d + f); //Because there's no "" in the expression prints 30.0 (sum values)
		
		System.out.println(l+d +" "+ f); //Prints 20.0 10.0 (sum values until the " ")
		
		
	}
}
