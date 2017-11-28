/**
 * 
 */
package com.sg.gsc.interview.tanb.discalc.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author tanmoy
 *
 */
public class DoubleUtilTest {
	private static final double DELTA = 0.001;

	/**
	 * Test method for {@link com.sg.gsc.interview.tanb.discalc.util.DoubleUtil#round(double, int)}.
	 */
	@Test
	public void testRound() {
		assertEquals("Double values should match", 34.12, DoubleUtil.round(34.123456, 2), DELTA);
	}
	
	/**
	 * Test method for {@link com.sg.gsc.interview.tanb.discalc.util.DoubleUtil#round(double, int)}.
	 */
	@Test
	public void testRoundUp() {
		assertEquals("Double values should match", 34.13, DoubleUtil.round(34.125456, 2), DELTA);
	}
	
	/**
	 * Test method for {@link com.sg.gsc.interview.tanb.discalc.util.DoubleUtil#round(double, int)}.
	 */
	@Test
	public void testRoundAnother() {
		assertEquals("Double values should match", 34.00, DoubleUtil.round(34.0, 2), DELTA);
	}
	
	/**
	 * Test method for {@link com.sg.gsc.interview.tanb.discalc.util.DoubleUtil#round(double, int)}.
	 */
	@Test
	public void testRoundInteger() {
		assertEquals("Double values should match", 34.00, DoubleUtil.round(34, 2), DELTA);
	}

}
