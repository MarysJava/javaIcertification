package g.exception.handling;

/**
 * @author mariaane
 *
 */
public class FamousErrors {

	/* MOST IMPORTANT ERRORS
	  
	 - ExceptionInInitializerError:  The ExceptionInInitializerError error is typically thrown by the JVM when a
	static initializer in your code throws any type of RuntimeException.
		Superclass: LinkageError
		
	A static initializer block is defined using the keyword static, followed by curly braces, in a class. This block is defined within a class,
	but not within a method. It’s usually used to execute code when a class loads for the first time. Runtime exceptions arising from any 
	of the following will throw this error:
		Execution of an anonymous static block
 		Initialization of a static variable
 		Execution of a static method (called from either of the previous two items)
 	  
	  
	 - StackOverflowError: The StackOverflowError error extends VirtualMachineError
	 This error is thrown by the JVM when a Java program calls itself so many times that the memory stack allocated to execute the 
	 Java program “overflows.”


	 - NoClassDefFoundError: What would happen if you failed to set your classpath and, as a result, the JVM was unable to load
	 the class that you wanted to access or execute? Or what happens if you try to run your application before compiling it? 
	 In both these conditions, the JVM would throw NoClassDefFoundError
	 Superclass: LinkageError
		
	 Thrown if the Java Virtual Machine or a ClassLoader instance tries to load in the definition of a class 
	 (as part of a normal method call or as part of creating a new instance using the new expression) and no definition 
	 of the class could be found.

	 Don’t confuse the exception thrown by Class.forName(), used to load the class, and NoClassDefFoundError thrown by the JVM. 
	 Class.forName() throws ClassNotFoundException.


	 - OutOfMemoryError: extends VirtualMachineError
	 What happens if you create and use a lot of objects in your application—for example, if you load a large
	 chunk of persistent data to be processed by your application. In such a case, the JVM may run out of
	 memory on the heap, and the garbage collector may not be able to free more memory for the JVM. In this
	 case, the JVM is unable to create any more objects on the heap. An OutOfMemoryError will be thrown

	 You’ll always work with a finite heap size, no matter what platform you work on, so you can’t create
	 and use an unlimited number of objects in your application. To get around this error, you need to either limit the number of resources 
	 or objects that your application creates or increase the heap size on the platform you’re working with.

	 As a programmer, you shouldn’t throw or catch these errors—leave them for the JVM. 
	 These are the kind of exceptions that are thrown by the JVM, which shouldn’t be thrown by you programmatically.

	 IMPORTANT TIP:
	 The rule that if a base class method doesn’t throw an exception, an overriding method in the derived class 
	 can’t throw a exception applies only to checked exceptions. It doesn’t apply to runtime (unchecked) exceptions or errors. 
	 A base or overridden method is free to throw any Error or runtime exception.
	 */
	
	public void test() throws ExceptionInInitializerError {
		
	}
}
