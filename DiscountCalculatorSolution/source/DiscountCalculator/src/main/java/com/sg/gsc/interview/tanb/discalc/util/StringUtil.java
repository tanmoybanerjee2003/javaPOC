/**
 * 
 */
package com.sg.gsc.interview.tanb.discalc.util;

/**
 * Utility class to work on Strings
 * 
 * @author tanmoy
 *
 */
public final class StringUtil {
	/**
	 * To stop explicit initialization
	 */
	private StringUtil() {
		//do nothing
	}
	
	/**
	 * 
	 * @param str
	 * @param ignoreWhiteSpace
	 * @return true if String is blank or null
	 */
	public static boolean isEmpty(String str, boolean ignoreWhiteSpace) {
		if((str != null) && ignoreWhiteSpace) {
			str = str.trim();
		}
		boolean empty = (str == null) || (str.length() == 0);
		
		return empty;
	}
}
