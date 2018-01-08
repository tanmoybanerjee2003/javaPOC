/**
 * 
 */
package com.redmart.interview.tanb.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author tanmoy
 *
 */
public class PatternUtilTest {
	/**
	 * Test method for {@link com.redmart.interview.tanb.util.PatternUtil#isCellReference(java.lang.String)}.
	 */
	@Test
	public void testIsCellReference1() {
		String s = "A1";
		boolean isCellRef = PatternUtil.isCellReference(s);
		assertEquals("Should be cell reference.", true, isCellRef);
	}
	
	/**
	 * Test method for {@link com.redmart.interview.tanb.util.PatternUtil#isCellReference(java.lang.String)}.
	 */
	@Test
	public void testIsCellReference2() {
		String s = "B22";
		boolean isCellRef = PatternUtil.isCellReference(s);
		assertEquals("Should be cell reference.", true, isCellRef);
	}
	
	/**
	 * Test method for {@link com.redmart.interview.tanb.util.PatternUtil#isCellReference(java.lang.String)}.
	 */
	@Test
	public void testIsCellReference3() {
		String s = "AB";
		boolean isCellRef = PatternUtil.isCellReference(s);
		assertEquals("Should not be cell reference.", false, isCellRef);
	}
	
	/**
	 * Test method for {@link com.redmart.interview.tanb.util.PatternUtil#isCellReference(java.lang.String)}.
	 */
	@Test
	public void testIsCellReference4() {
		String s = "AB123";
		boolean isCellRef = PatternUtil.isCellReference(s);
		assertEquals("Should not be cell reference.", false, isCellRef);
	}
	
	/**
	 * Test method for {@link com.redmart.interview.tanb.util.PatternUtil#isCellReference(java.lang.String)}.
	 */
	@Test
	public void testIsCellReference5() {
		String s = "A0";//column index starts from 1, not 0
		boolean isCellRef = PatternUtil.isCellReference(s);
		assertEquals("Should not be cell reference.", false, isCellRef);
	}

	/**
	 * Test method for {@link com.redmart.interview.tanb.util.PatternUtil#isNumber(java.lang.String)}.
	 */
	@Test
	public void testIsNumber1() {
		String s = "1";
		boolean isNumber = PatternUtil.isNumber(s);
		assertEquals("Should be number.", true, isNumber);
	}
	
	/**
	 * Test method for {@link com.redmart.interview.tanb.util.PatternUtil#isNumber(java.lang.String)}.
	 */
	@Test
	public void testIsNumber2() {
		String s = "-1";
		boolean isNumber = PatternUtil.isNumber(s);
		assertEquals("Should be number.", true, isNumber);
	}
	
	/**
	 * Test method for {@link com.redmart.interview.tanb.util.PatternUtil#isNumber(java.lang.String)}.
	 */
	@Test
	public void testIsNumber3() {
		String s = "1.";
		boolean isNumber = PatternUtil.isNumber(s);
		assertEquals("Should not be number.", false, isNumber);
	}
	
	/**
	 * Test method for {@link com.redmart.interview.tanb.util.PatternUtil#isNumber(java.lang.String)}.
	 */
	@Test
	public void testIsNumber4() {
		String s = "1.0";
		boolean isNumber = PatternUtil.isNumber(s);
		assertEquals("Should be number.", true, isNumber);
	}
	
	/**
	 * Test method for {@link com.redmart.interview.tanb.util.PatternUtil#isNumber(java.lang.String)}.
	 */
	@Test
	public void testIsNumber5() {
		String s = "4.32";
		boolean isNumber = PatternUtil.isNumber(s);
		assertEquals("Should be number.", true, isNumber);
	}
	
	/**
	 * Test method for {@link com.redmart.interview.tanb.util.PatternUtil#isNumber(java.lang.String)}.
	 */
	@Test
	public void testIsNumber6() {
		String s = "-4.32";
		boolean isNumber = PatternUtil.isNumber(s);
		assertEquals("Should be number.", true, isNumber);
	}
	
	/**
	 * Test method for {@link com.redmart.interview.tanb.util.PatternUtil#isNumber(java.lang.String)}.
	 */
	@Test
	public void testIsNumber7() {
		String s = "4..32";
		boolean isNumber = PatternUtil.isNumber(s);
		assertEquals("Should not be number.", false, isNumber);
	}

	/**
	 * Test method for {@link com.redmart.interview.tanb.util.PatternUtil#isNumericExpression(java.lang.String)}.
	 */
	@Test
	public void testIsNumericExpression1() {
		String s = "4 5 * 5 +";
		boolean isNumericExpression = PatternUtil.isNumericExpression(s);
		assertEquals("Should be numeric expression.", true, isNumericExpression);
	}
	
	/**
	 * Test method for {@link com.redmart.interview.tanb.util.PatternUtil#isNumericExpression(java.lang.String)}.
	 */
	@Test
	public void testIsNumericExpression2() {
		String s = "20.0 3.0 / 2 +";
		boolean isNumericExpression = PatternUtil.isNumericExpression(s);
		assertEquals("Should be numeric expression.", true, isNumericExpression);
	}
	
	/**
	 * Test method for {@link com.redmart.interview.tanb.util.PatternUtil#isNumericExpression(java.lang.String)}.
	 */
	@Test
	public void testIsNumericExpression3() {
		String s = "-20.0 3.0 / 2 +";
		boolean isNumericExpression = PatternUtil.isNumericExpression(s);
		assertEquals("Should be numeric expression.", true, isNumericExpression);
	}
	
	/**
	 * Test method for {@link com.redmart.interview.tanb.util.PatternUtil#isNumericExpression(java.lang.String)}.
	 */
	@Test
	public void testIsNumericExpression4() {
		String s = "A1 B2 / 2 +";
		boolean isNumericExpression = PatternUtil.isNumericExpression(s);
		assertEquals("Should not be numeric expression.", false, isNumericExpression);
	}
	
	/**
	 * Test method for {@link com.redmart.interview.tanb.util.PatternUtil#isNumericExpression(java.lang.String)}.
	 */
	@Test
	public void testIsNumericExpression5() {
		String s = "39 B1 B2 * /";
		boolean isNumericExpression = PatternUtil.isNumericExpression(s);
		assertEquals("Should not be numeric expression.", false, isNumericExpression);
	}
	
	/**
	 * Test method for {@link com.redmart.interview.tanb.util.PatternUtil#isNumericExpression(java.lang.String)}.
	 */
	@Test
	public void testIsNumericExpression6() {
		String s = "34";
		boolean isNumericExpression = PatternUtil.isNumericExpression(s);
		assertEquals("Should not be numeric expression.", false, isNumericExpression);
	}
	
	/**
	 * Test method for {@link com.redmart.interview.tanb.util.PatternUtil#isNumericExpression(java.lang.String)}.
	 */
	@Test
	public void testIsNumericExpression7() {
		String s = "-3";
		boolean isNumericExpression = PatternUtil.isNumericExpression(s);
		assertEquals("Should not be numeric expression.", false, isNumericExpression);
	}

	/**
	 * Test method for {@link com.redmart.interview.tanb.util.PatternUtil#isBinaryOperator(java.lang.String)}.
	 */
	@Test
	public void testIsPlusBinaryOperator() {
		String s = "+";
		boolean isBinOp = PatternUtil.isBinaryOperator(s);
		assertEquals("Should be binary operator.", true, isBinOp);
	}
	
	/**
	 * Test method for {@link com.redmart.interview.tanb.util.PatternUtil#isBinaryOperator(java.lang.String)}.
	 */
	@Test
	public void testIsMiusBinaryOperator() {
		String s = "-";
		boolean isBinOp = PatternUtil.isBinaryOperator(s);
		assertEquals("Should be binary operator.", true, isBinOp);
	}
	
	/**
	 * Test method for {@link com.redmart.interview.tanb.util.PatternUtil#isBinaryOperator(java.lang.String)}.
	 */
	@Test
	public void testIsStarBinaryOperator() {
		String s = "*";
		boolean isBinOp = PatternUtil.isBinaryOperator(s);
		assertEquals("Should be binary operator.", true, isBinOp);
	}
	
	/**
	 * Test method for {@link com.redmart.interview.tanb.util.PatternUtil#isBinaryOperator(java.lang.String)}.
	 */
	@Test
	public void testIsHashBinaryOperator() {
		String s = "/";
		boolean isBinOp = PatternUtil.isBinaryOperator(s);
		assertEquals("Should be binary operator.", true, isBinOp);
	}
	
	/**
	 * Test method for {@link com.redmart.interview.tanb.util.PatternUtil#isCellRefExpression(java.lang.String)}.
	 */
	@Test
	public void testIsCellRefExpression1() {
		String s = "A1 B2 / 2 +";
		boolean isCellExp = PatternUtil.isCellRefExpression(s);
		assertEquals("Should be cellRef expression.", true, isCellExp);
	}
	
	/**
	 * Test method for {@link com.redmart.interview.tanb.util.PatternUtil#isCellRefExpression(java.lang.String)}.
	 */
	@Test
	public void testIsCellRefExpression2() {
		String s = "I am a good boy";
		boolean isCellExp = PatternUtil.isCellRefExpression(s);
		assertEquals("Should not be cellRef expression.", false, isCellExp);
	}

}
