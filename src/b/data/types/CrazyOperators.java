package b.data.types;

/**
 * @author mariaane
 *
 */
public class CrazyOperators {

	//Operators:
	//Assignment =, +=, -=, *=, /= 			Assign value to a variable
	//Arithmetic +, -, *, /, %, ++, -- 		Add, subtract, multiply, divide, and modulus primitives
	//Relational <, <=, >, >=, ==, != 		Compare primitives
	//Logical !, &&, || 					Apply NOT, AND, and OR logic to primitives

	int test1=1, test2=2, test3=3; // I CAN do this to declare and initialize variables
	int test4, test5, test6;
	//test4=test5=test6=5; //I can't do this to declare and initialize variables. Will not compile.
	
	double myD = 10;
	//Initialization block
	{
		test4=test5=test6=5; //I CAN do this here, because inside a block a expression can be evaluated
	}
	
	public CrazyOperators() { //I'm a constructor
		test4=test5=test6=5; //I CAN do this here
	}
	
	public static void main(String[] args) {
		//ARITHMETIC
		double myDouble2 = 10.2;
		int a = 10;
		int b = a;
		float float1 = 10.2F;
		float float2 = float1;
		
		int c, d, e, f = 10; //Declaring many at the same time
		c =d=e=f; //Initializing with f value - CAN'T do this outside a method/constructor/block
		c =d=e=f=30; //Passing value 30 to all - CAN'T do this outside a method/constructor/block
		System.out.println(c+" "+d+" "+e +" "+f);
		
		b += a;
		System.out.println(b); //10+ 10 = 20		
		a = b = 10; //assign 10 to both vars at the same time
		System.out.println(a+" "+b); 
		b -= a; //10 - 10 = 0
		System.out.println(b); //0
		a = b = 10; 
		System.out.println(a+" "+b);
		b *= a; //10 * 10 = 100
		System.out.println(b);
		a = b = 10;
		System.out.println(a+" "+b);
		b /= a; //10 / 10 = 1
		System.out.println(b);
		
		
		long num = 100976543356L;
		//int val = num; //Won't compile!
		int val = (int) num; //It's ok but the value will be strangled		
		System.out.println(val); //-2102671748 ???? What a hell?
		
		int a1 = 7, b1 = 10, c1 = 8; //This format is valid only to declare
		a1 = b1 = c1;
		System.out.println(a1);
		
		System.out.println("% - Resto: "+ 10%6);
		
		//PREFIX AND POSTFIX NOTATION
		//For a prefix unary operator, the value of its operand increments or decrements just before its value is used in an expression. 
		//For a postfix unary operator, the value of its operand increments or decrements	just after its value is used in an expression.
			// ++var or --var (prefix) change de value before use, and var++, var-- (posfix) change value after use
	
		//If a=10, this expression will be:
		//a = a++ + a + a-- - a-- + ++a;
		//a = 10 + 11 + 11 - 10 + 10;
		
		//Because
		//a = a++ [first use a value = 10] + a [after add 1 to a  value, so a = 11] + a-- [use the value of a as 11, after subtract 1] - a-- [use the new value of a = 10 and after subtract 1] + ++a [value of a is now 9, plus 1 to the a value and use it in the sum];
		
		
		// RELATIONAL OPERATORS
		// Comparing greater (>, >=) and lesser values (<, <=)
		// Comparing values for equality (==) and nonequality (!=)
		
		//The operators <, <=, >, and >= work with all types of numbers, both integers (including char) and floating point, that can be added and subtracted.
		//You cannot compare incomparable values. For example, you cannot compare a boolean with an int, a char, or a floating-point number. 
		//If you try to do so, your code will not compile.
		
		a=10;
		b=10;
		c=15;
		
		char dchar = 'a'; 
		int dint = dchar;
		System.out.println(a>b);
		System.out.println(a>=b);
		System.out.println(a<c);
		System.out.println(a<=dchar);
		System.out.println(a==dchar);
		System.out.println(a!=dchar);
		System.out.println(dint);
		
		boolean bboo=false;
		boolean bboo1=true;
		
		//System.out.println(bboo>a); //You can’t apply these operators to incomparable types.
		//System.out.println(bboo>bboo1); //Invalid operator for boolean type
		
		//The result of the relational operation is always a boolean value.
		//You can’t assign the result of a relational operation to a variable of type char, int, byte, short, long, float, or double.
		
		//ONE '=' sign NOT COMPARE BUT ASSIGNS THE VALUE TO A VAR
		// a=1 assigns 1 to the var a
		
		System.out.println(bboo=true); //Prints true, because assign true value for bboo var!
		
		//LOGICAL OPERATORS
		
		System.out.println(a > 20 && b > 10);
		
		//Table of results
		/*
		 * && (AND)
		 *	true && true = true //Only TRUE if ALL statements are true
			true && false = false
			false && true = false
			false && false = false
			true && true && false =	false
		 * 
		 * || (OR)
		 * 
		 * true || true = true
			true || false = true
			false || true = true
			false || false = false
			false || false || true = true //TRUE if at least ONE of the statements are true
		 * 
		 * 
		 * ! (NOT)
		 * Negate the true/false statement
		 * !true = false 
		   !false = true
		 * 
		 * 
		 * && and || are short-circuit operators
		 * If the first operand to && evaluates to false, the result can never be true. 
		 * Therefore, && does not evaluate the second operand. 
		 * Similarly, the || operator does not evaluate the second operator if the first operand evaluates to true.
		 */
		
		int marks = 8;
		int total = 10;
		
		//IMPORTANT TEST TRICK
		System.out.println(total < marks && ++marks > 5); //Never evaluate second condition because the first one is false, so marks remains with value 8
		System.out.println(marks);
		System.out.println(total == 10 || ++marks > 10); //Never evaluate second condition because the first one is true, so marks remains with value 8
		System.out.println(marks);
		
		//Examples
		a = 10;
		b = 20;
		c = 40;
		System.out.println(a++ > 10 || ++b < 30); // false because a=10 yet,  21<30= true, both are evaluated because first is false
		System.out.println(a > 90 && ++b < 30); //false in firts, don't evaluate second one
		System.out.println(!(c>20) && a==10 ); // false in firts, don't evaluate second one
		System.out.println(a >= 99 || a <= 33 && b == 10);//first is false, so need to evaluate second, second is true so need to evaluate last, last is false, because the first is false AND has one false the sentence returns false
		System.out.println(a >= 99 && a <= 33 || b == 10); //false in firts, don't evaluate second one but evaluate third one because of OR, but b==10 is false so returns false
		
		
		/*OPERATORS PRECEDENCE
		Postfix Expression++, expression--
		Unary ++expression, --expression, +expression, -expression, !
		Multiplication * (multiply), / (divide), % (remainder)
		Addition + (add), - (subtract)
		Relational <, >, <=, >=
		Equality ==, !=
		Logical AND &&
		Logical OR ||
		Assignment =, +=, -=, *=, /=, %=
		*/
		
		int int1 = 10, int2 = 20, int3 = 30;
		System.out.println(int1 % int2); //10/20 is 0 and rest is 20
		System.out.println(int1 % int2 * (int3 + int1) / int2);
		System.out.println(int1 % int2 * int3 + int1 / int2); //Now the precedence goes to * and /
		
		long a3 = 0x10C;
		short a4 = 0512;
		double a5 = 10; //IMPORTANT: it compiles but is incorrect because double must be initialized as decimal like this: 10.0
		byte a7 = -0; //-0 is VALID!
		long a8 = 123456789; //You can assign a valid integer inside a long var
		
		int [] aa = new int[3];
		aa[0]=1;
		aa[1]=1;
	
		System.out.println(aa[0]+aa[1]+aa[2]);
		
		int z=10;
		System.out.println(-z);
		System.out.println(z%20);
	}

}
