/**
 * 
 */
package com.sg.gsc.interview.tanb.discalc.exceptions;

/**
 * @author tanmoy
 *
 */
public class CategoryNotFoundException extends AppRuntimeException {
	private static final String ERROR_CODE = "C003";
	
	public CategoryNotFoundException(String message) {
		super(message);
	}
	
	public CategoryNotFoundException(Throwable t) {
		super(t);
	}

	public String getErrorCode() {
		return ERROR_CODE;
	}
}
