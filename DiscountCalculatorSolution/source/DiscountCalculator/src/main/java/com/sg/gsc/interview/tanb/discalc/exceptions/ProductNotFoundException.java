/**
 * 
 */
package com.sg.gsc.interview.tanb.discalc.exceptions;

/**
 * @author tanmoy
 *
 */
public class ProductNotFoundException extends AppRuntimeException {
	private static final String ERROR_CODE = "C004";
	
	public ProductNotFoundException(String message) {
		super(message);
	}
	
	public ProductNotFoundException(Throwable t) {
		super(t);
	}

	public String getErrorCode() {
		return ERROR_CODE;
	}
}
