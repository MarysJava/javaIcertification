package g.exception.handling;

/**
 * @author mariaane
 * 
 */
public class ConvertToNumberTest {

	//Example, capturing and treating exceptions
	public static int convertToNum(String val) {
		int num = 0;
		try {
			num = Integer.parseInt(val, 16);
		} catch (NumberFormatException e) {
			throw new NumberFormatException(val	+ " cannot be converted to hexadecimal number");
		}
		return num;
	}

	public static void main(String args[]) {
		System.out.println(convertToNum("16b")); //16b can be converted to hexadecimal number - OK
		System.out.println(convertToNum("65v")); //65v CAN'T be converted to hexadecimal number - throw NumberFormatException customized on convertToNum method
	}
}
