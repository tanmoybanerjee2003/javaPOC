/**
 * 
 */
package com.sg.gsc.interview.tanb.discalc.exceptions;

/**
 * @author tanmoy
 *
 */
public class ProductSetupException extends AppRuntimeException {
private static final String ERROR_CODE = "C007";
	
	public ProductSetupException(String message) {
		super(message);
	}
	
	public ProductSetupException(Throwable t) {
		super(t);
	}

	public String getErrorCode() {
		return ERROR_CODE;
	}
}
