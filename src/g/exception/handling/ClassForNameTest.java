package g.exception.handling;

/**
 * @author mariaane
 *
 */
public class ClassForNameTest {

	public static void main(String[] args) {
		//ClassNotFoundException is a CHECKED EXCEPTION
		try {
			Class.forName("g.exception.handling.rafting.RiverRafting"); //Need to use QUALIFIED NAME
			System.out.println("ClassForNameTest exists!");
			Class.forName("g.exception.handling.rafting.MyClass"); //MyClass does not exists so this code will throw ClassNotFoundException
		} catch (ClassNotFoundException e) {
			System.out.println("MyClass does not exist");
		}
	}
	
}
