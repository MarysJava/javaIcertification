package f.inheritance.animal.example;

import java.io.IOException;

/**
 * @author mariaane
 *
 */
public class Animal implements GuineaPigIF {
	
	public Animal() {
		System.out.println("Super default");
	}
	
	public Animal(int a){
		System.out.println("Super");
	}
	
	public Animal doSomething() {
		return null;
	}
	
	public AnimalIF doSomething1() throws Exception {
		return null;
	}
	
	public GuineaPig doSomething2() throws Throwable {
		return null;
	}
	
	public GuineaPigIF doSomething3() throws IOException {
		return null;
	}
}
