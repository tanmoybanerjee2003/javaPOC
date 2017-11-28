/**
 * 
 */
package com.sg.gsc.interview.tanb.discalc.exceptions;

/**
 * @author tanmoy
 *
 */
public class CategorySetupException extends AppRuntimeException {
	private static final String ERROR_CODE = "C006";
	
	public CategorySetupException(String message) {
		super(message);
	}
	
	public CategorySetupException(Throwable t) {
		super(t);
	}

	public String getErrorCode() {
		return ERROR_CODE;
	}
}
