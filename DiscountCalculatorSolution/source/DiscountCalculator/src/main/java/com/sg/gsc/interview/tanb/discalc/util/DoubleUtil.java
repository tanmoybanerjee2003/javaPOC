/**
 * 
 */
package com.sg.gsc.interview.tanb.discalc.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Utility class to work on amounts
 * 
 * @author tanmoy
 *
 */
public final class DoubleUtil {
	/**
	 * To stop explicit initialization
	 */
	private DoubleUtil() {
		//do nothing
	}
	
	/**
	 * 
	 * @param value
	 * @param precision
	 * @return value rounded up to given precision
	 */
	public static double round(double value, int precision) {
		if(precision < 0) {
			throw new IllegalArgumentException("Precision can't be negative.");
		}
		
		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(precision, RoundingMode.HALF_UP);
		
		return bd.doubleValue();
	}
}
