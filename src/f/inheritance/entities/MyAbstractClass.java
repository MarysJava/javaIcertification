package f.inheritance.entities;


/**
 * @author mariaane
 *
 */
public abstract class MyAbstractClass  extends Employee { //FIRST THE EXTENDS AFTER THE IMPLEMENTS - ALWAYS

	//An abstract class can have private members
	String myAbstractAttribute;
	
	public MyAbstractClass() {
	
	}
	
	public MyAbstractClass(String name) {
		System.out.println("Abstract class constructor - name");
	}
	
	//Only to use in another classes and don't get a lot of prints
	public MyAbstractClass(int num) {
		super(num);
	}
	
	//An abstract class can extends a concrete class and can be extended by a concrete class too	
	//An abstract class is like a concept, a template
	
	//An abstract class can have concrete methods
	public String getName() {
		return "Test";
	}
	
	//An abstract class can have abstract methods
	protected abstract Employee doSomething(); 
	//These abstract methods MUST be implemented by the first concrete class in the hierarchy
	//REMEMBER TO MARK METHODS WITH ABSTRACT KEYWORD. 
	//In interfaces this keyword is implicit. In abstract classes NO.
	//If you don't mark and use a semicolon in the end like this: public void doSoemthing(); it will not compile 
	
	public void reachOffice() {
		System.out.println("Reached Office - IBM Tutóia, Brasil");
	}
	
	//METHODS CAN BE ABSTRACT OR NON ABSTRACT
	public abstract void startProjectWork(); 
	
	private void testAbstMeth() { 		
	}		
}