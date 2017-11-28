/**
 * 
 */
package com.sg.gsc.interview.tanb.discalc.util;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author tanmoy
 *
 */
public class StringUtilTest {

	/**
	 * Test method for {@link com.sg.gsc.interview.tanb.discalc.util.StringUtil#isEmpty(java.lang.String, boolean)}.
	 */
	@Test
	public void testEmptyString() {
		assertEquals("Values should match", true, StringUtil.isEmpty("", false));
	}
	
	/**
	 * Test method for {@link com.sg.gsc.interview.tanb.discalc.util.StringUtil#isEmpty(java.lang.String, boolean)}.
	 */
	@Test
	public void testBlankString1() {
		assertEquals("Values should match", false, StringUtil.isEmpty(" ", false));
	}
	
	/**
	 * Test method for {@link com.sg.gsc.interview.tanb.discalc.util.StringUtil#isEmpty(java.lang.String, boolean)}.
	 */
	@Test
	public void testBlankString2() {
		assertEquals("Values should match", true, StringUtil.isEmpty(" ", true));
	}
	
	/**
	 * Test method for {@link com.sg.gsc.interview.tanb.discalc.util.StringUtil#isEmpty(java.lang.String, boolean)}.
	 */
	@Test
	public void testNullString() {
		assertEquals("Values should match", true, StringUtil.isEmpty(null, true));
	}
	
	/**
	 * Test method for {@link com.sg.gsc.interview.tanb.discalc.util.StringUtil#isEmpty(java.lang.String, boolean)}.
	 */
	@Test
	public void testNormalString() {
		assertEquals("Values should match", false, StringUtil.isEmpty("abcd", true));
	}

}
