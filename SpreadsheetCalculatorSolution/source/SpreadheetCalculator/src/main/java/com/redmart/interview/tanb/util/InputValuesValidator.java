/**
 * 
 */
package com.redmart.interview.tanb.util;

/**
 * @author tanmoy
 *
 */
public class InputValuesValidator implements Validator {

	/* (non-Javadoc)
	 * @see com.redmart.interview.tanb.util.Validator#validate(int, int, java.lang.String[])
	 */
	@Override
	public String validate(int width, int height, String[] values) {
		String result = "";
		
		for(String value : values) {
			boolean isValid = PatternUtil.isNumber(value) 
							|| PatternUtil.isNumericExpression(value)
							|| PatternUtil.isCellReference(value)
							|| PatternUtil.isCellRefExpression(value);
			if(!isValid) {
				result += "\n" + value + " is not valid input.";
			}
		}
		
		return result;
	}

}
