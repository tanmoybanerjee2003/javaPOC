/**
 * 
 */
package com.sg.gsc.interview.tanb.discalc.exceptions;

/**
 * @author tanmoy
 *
 */
public abstract class AppRuntimeException extends RuntimeException {

	public AppRuntimeException(String message) {
		super(message);
	}
	
	public AppRuntimeException(Throwable t) {
		super(t);
	}
	
	public abstract String getErrorCode();

}
