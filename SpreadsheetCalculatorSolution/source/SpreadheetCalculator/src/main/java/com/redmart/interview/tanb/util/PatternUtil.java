/**
 * 
 */
package com.redmart.interview.tanb.util;

/**
 * 
 * Helps in identifying different types of inputs
 * 
 * @author tanmoy
 *
 */
public abstract class PatternUtil {
	private static final String CELL_REFERENCE = "[A-Za-z][1-9][\\d]*";
	private static final String INTEGER = "[-]?[1-9][\\d]*";
	private static final String FRACTION = "[-]?[0-9]+[\\.][0-9]+";
	private static final String NUMERIC_EXPRESSION = "[[-]?\\d+\\.?\\d*]+[\\s][[[-]?\\d+\\.?\\d*]\\+\\-\\*/\\s]+";
	private static final String BINARY_OPERATOR = "[\\+\\-\\*/]";
	
	/**
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isCellReference(String s) {
		if((s == null) || (s.length() == 0)) {
			return false;
		} else {
			return s.matches(CELL_REFERENCE);
		}
	}
	
	/**
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isNumber(String s) {
		if((s == null) || (s.length() == 0)) {
			return false;
		} else {
			return (s.matches(INTEGER) || s.matches(FRACTION));
		}
	}
	
	/**
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isNumericExpression(String s) {
		if((s == null) || (s.length() == 0)) {
			return false;
		} else {
			return s.matches(NUMERIC_EXPRESSION);
		}
	}
	
	/**
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isBinaryOperator(String s) {
		if((s == null) || (s.length() == 0)) {
			return false;
		} else {
			return s.matches(BINARY_OPERATOR);
		}
	}
	
	/**
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isCellRefExpression(String s) {
		boolean binaryOpExists = false;
		boolean cellRefExists = false;
		boolean unknownValueExists = false;
		
		if((s == null) || (s.length() == 0)) {
			return false;
		} else {
			String[] tokens = s.split("\\s");
			for(String token : tokens) {
				if(isNumber(token)) {
					//noted but do nothing
				} else if(isCellReference(token)) {
					cellRefExists = true;
				} else if(isBinaryOperator(token)) {
					binaryOpExists = true;
				} else {
					unknownValueExists = true;
				}
			}
		}
		
		return (cellRefExists && binaryOpExists && !unknownValueExists);
	}

}
