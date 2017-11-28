/**
 * 
 */
package com.sg.gsc.interview.tanb.discalc.exceptions;

/**
 * @author tanmoy
 *
 */
public class MisConfigurationException extends AppRuntimeException {
	private static final String ERROR_CODE = "C001";
	
	public MisConfigurationException(String message) {
		super(message);
	}
	
	public MisConfigurationException(Throwable t) {
		super(t);
	}

	public String getErrorCode() {
		return ERROR_CODE;
	}
}
