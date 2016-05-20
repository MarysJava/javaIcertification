// All the classes and interfaces defined in the same Java source code file will be defined in the same package - only one package declaration! 
// The only thing that can come first than a package declaration is a comment (of any type) - or blank space like line break

package a.teste.another.pack;

/**
 * @author mariaane
 *
 */

public class GoodCat {
	String name;
}


// This class is not public! Its modifier is "default" one
// This class is declared in the same java file of class Cat, the file's name is Cat and the public class must be named Cat too.
class Cat1 {
	// Even being public it will not be available for the classes outside the Cat1's package, because the class will be inaccessible
	// This is a little test trick, even you have an attribute public you must check the class visibility! If the class is inaccessible, 
	// so the attribute will be inaccessible too.
	public String name; 
	
}
