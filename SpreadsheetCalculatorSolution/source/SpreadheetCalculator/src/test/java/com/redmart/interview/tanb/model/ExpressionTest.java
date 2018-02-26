/**
 * 
 */
package com.redmart.interview.tanb.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author HP
 *
 */
public class ExpressionTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.redmart.interview.tanb.model.Expression#value()}.
	 */
	@Test
	public void testValue1() {
		Expression expression = new Expression("20.0 3.0 / 2 +");
		String result = String.format("%.5f", expression.value());
		assertEquals("Values should match", "8.66667", result);
	}
	
	/**
	 * Test method for {@link com.redmart.interview.tanb.model.Expression#value()}.
	 */
	@Test
	public void testValue2() {
		Expression expression = new Expression("-4 5 *");
		String result = String.format("%.5f", expression.value());
		assertEquals("Values should match", "-20.00000", result);
	}

}
