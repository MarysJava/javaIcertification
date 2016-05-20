package a.teste.another.pack;

/**
 * @author mariaane
 *
 */
public class LoyalDog {

	//STATIC MEMBERS
	static public int dogsAge;
	static public int age;
	private static Cat1 cat; // visible only to this class (Dog)

	protected String nickname; // visible only to the derived classes

	
	public static void bark() {
		System.out.println("AuAu");
		cat = new Cat1(); // Find Cat1 because it is in the same package
		cat.name = "Mimi"; // Find Cat1.name because it is in the same package and the modifier is public, protected or default
	}
	
}
