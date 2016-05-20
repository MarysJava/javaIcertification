/***********************************************************
* I AM A JAVA SOURCE CODE FILE FOR A INTERFACE!!!	 	   *
***********************************************************/
package a.java.basics;

/**
 * @author mariaane
 *
 */

// An interface can define constants and methods.
// An interface is abstract for default, because this it can't never be marked as final
public interface WeirdPersonBehavior {
	
	// The variables of an interface are implicitly public, final, and static.
	int IDADE_MAXIMA=150;

	// FOR DEFAULT ALL ACCESS MODIFIERS FOR INTERFACE METHODS ARE PUBLIC SO USE PUBLIC WORD IS REDUNDANT, BUT IT WORKS
	public void falar();
	void comer(); //also public

}
