package f.inheritance.interfacesInheritance.example;

/**
 * @author mariaane
 *
 */
public interface ChildIF extends BaseIF1, BaseIF2 {

	String getName();
	//BaseIF1 and BaseIF2 has getName() method and it's not important about how ChildIF inherit because it has no body (behavior) yet
	//IF is only a contract, both methods have the same name and return type, so they are considered the 'same method'
	//and the class which implements both interfaces will need to implement it only once
	
	//If I have two BASE IFs with a method with the same name and different return type it will not compile
	//For example, if I uncomment line //int getPhone(); in the BaseIF2, so this interface will not compile, because
		//I can't inherit two methods with the same name and different return types, they are not the same method anymore
}
