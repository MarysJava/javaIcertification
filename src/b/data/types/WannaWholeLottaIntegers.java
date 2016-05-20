package b.data.types;

/**
 * @author mariaane
 *
 */
public class WannaWholeLottaIntegers {

	//Integer literal values come in four flavors: binary, decimal, octal, and hexadecimal.
	//Binary number system—A base-2 system, which uses only 2 digits, 0 and 1.
	//Octal number system—A base-8 system, which uses digits 0 through 7 (a total of 8 	digits). 
		//Here the decimal number 8 is represented as octal 10, decimal 9 as 11,and so on.
	//Decimal number system—The base-10 number system that you use every day. 
	//It’s based on 10 digits, from 0 through 9 (a total of 10 digits).
	//Hexadecimal number system—A base-16 system, which uses digits 0 through 9 and the letters A through F 
		//(a total of 16 digits and letters). Here the number 10 is
		//represented as A, 11 as B, 12 as C, 13 as D, 14 as E, and 15 as F.
	
	
	// To transform decimal to another base:
	// Divide the decimal number by its base. Ex. 267 decimal to octal = 267/8 = 33 and the rest is 3
	// Divide the number you obtain by the base again, repeat this process.
	// When you can't divide anymore, use the last number you got itself.
	// Example to convert to octal: 267/8 = 33 remains 3, 33/8 = 4, remains 1, 4/8 = 0, use 4 as the rest. The octal form of 267 is 413 (inverse order)
	// Example to convert to hexadecimal: 267/16 (16 and left 11), 16/16 (1 and left 0), 16/1 = 0 (use 1). The number is 11 0 1. 
		//In the inverse order the number 10B (remember that 11 = B in hexadecimal system)
	// Example to convert to binary: 
		// 267/2 (133 - and left 1), 133/2 (66 - and left 1),  66/2 (33 - and left 0),  33/2 (16 - and left 1),  16/2 (8 - and left 0), 
		// 8/2 (4 - and left 0), 4/2 (2 - and left 0),  2/2 (1 - and left 0),  1/2 (0 - use 1)
		// This is the number in the inverse order: 100001011
	
	//You can assign integer literals in base decimal, binary, octal, and hexadecimal. 
		//For octal literals, use the prefix 0 (zero); 
		//For binary, use the prefix 0B or 0b; 
		//For hexadecimal, use the prefix 0x or 0X.
	
	//Test trick - there's no integer, the name of the primitive data type is int 
	int baseDecimal = 267;
	int octVal = 0413; //0 indicates it's an octal value
	int hexVal = 0X10B; //0x or 0X indicates it's a hexadecimal value
	int binVal = 0b100001011; // Only to Java 7 // 0b indicates it's a binary value
	
	//UNDERSCORES ARE VALID
	long baseDecimal1 = 100_267_760;
	long octVal1 = 04_13;
	long hexVal1 = 0x10_BA_75;
	long binVal1 = 0b1_0000_10_11;
	long val = 100267760;
		
	//You can’t start or end a literal value with an underscore.
	//You can’t place an underscore right after the prefixes 0b, 0B, 0x, and 0X, which are used to define binary and hexadecimal literal values.
	//You can’t place an underscore prior to an L suffix (the L suffix is used to mark a literal value as long).
	//You can’t use an underscore in positions where a string of digits is expected.
	//Exception: you CAN place an underscore right after the prefix 0, which is used to define an octal literal value.

	int i = Integer.parseInt("45_98"); //Compile but fails in runtime, because underscores are not valid in parse methods
	
	public static void main (String args[]) {
		int baseDecimal = 000267;
		int octVal = 041__3;
		int hexVal = 0x10_B; //Underscores must be located within digits EXCEPT in hexadecimal cases, but considering only the letters A-F, not 0x or 0X
		//This is because to hexadecimal the letters A-F represent digits.
		
		int binVal = 0b100001011;
		System.out.println (baseDecimal +" "+ octVal);
		System.out.println (hexVal + binVal);
		
		//I can compare any type of integers and decimals
		long xx =10l;
		float dd= 20f;
		
		dd=9;
		xx=23;
		System.out.println(xx>dd);
	}
	
	int teste = 000010; //I can have how many left 0's I want
	long var1 = 0_100_267_760; // OK - I can declare a long with 0 in the beggining
	
	//long var2 = 0_x_4_13; // underscore after 0 is not allowed, neither after x
	//long var3 = 0b_x10_BA_75; // underscore after 0b is not allowed. The binaries doesn't have x and BA. Only hexadecimal has this values.
	//long var4 = 0b_10000_10_11; // underscore after 0b is not allowed.
	//long var5 = 0xa10_AG_75; //hexadecimal goes only until F. G is an invalid letter
	
	long var6 = 0x1_0000_10; // It's ok
	long var7 = 100__12_12; // It's oK - you can use how many underscores do you want
	
}
