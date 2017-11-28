/**
 * 
 */
package com.sg.gsc.interview.tanb.discalc.exceptions;

/**
 * @author tanmoy
 *
 */
public class BrandSetupException extends AppRuntimeException {
	private static final String ERROR_CODE = "C005";
	
	public BrandSetupException(String message) {
		super(message);
	}
	
	public BrandSetupException(Throwable t) {
		super(t);
	}
	
	/*
	 * 
	 */
	@Override
	public String getErrorCode() {
		return ERROR_CODE;
	}

}
