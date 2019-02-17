/* Exception for null method argument situation
 * laboratory work ¹11 - Java One-dimensional Arrays
 * version: 1.0
 * Full name: Gilevskiy Denis Alexandrovich
 * Brigade name: Compiler Crusaders
 * Group Number: 10701117
 * Development date: 20.12.2018
 */

package by.bntu.fitr.povt.compilercrusaders.javalabs.lab11.maintask.exception;

public class NullArgumentException extends RuntimeException {

	public NullArgumentException() {
		super();
	}

	public NullArgumentException(String arg0) {
		super(arg0);
	}

}
