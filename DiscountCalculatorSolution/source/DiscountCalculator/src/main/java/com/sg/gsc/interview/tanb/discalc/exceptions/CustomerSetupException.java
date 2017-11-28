/**
 * 
 */
package com.sg.gsc.interview.tanb.discalc.exceptions;

/**
 * @author tanmoy
 *
 */
public class CustomerSetupException extends AppRuntimeException {
	private static final String ERROR_CODE = "C008";
	
	public CustomerSetupException(String message) {
		super(message);
	}
	
	public CustomerSetupException(Throwable t) {
		super(t);
	}

	public String getErrorCode() {
		return ERROR_CODE;
	}
}
