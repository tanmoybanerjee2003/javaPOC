/**
 * 
 */
package com.sg.gsc.interview.tanb.discalc.exceptions;

/**
 * @author tanmoy
 *
 */
public class BrandNotFoundException extends AppRuntimeException {
	private static final String ERROR_CODE = "C002";
	
	public BrandNotFoundException(String message) {
		super(message);
	}
	
	public BrandNotFoundException(Throwable t) {
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
