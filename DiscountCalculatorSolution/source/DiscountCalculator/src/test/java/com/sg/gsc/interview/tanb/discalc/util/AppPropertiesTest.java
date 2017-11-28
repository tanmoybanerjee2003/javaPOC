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
public class AppPropertiesTest {

	/**
	 * Test method for {@link com.sg.gsc.interview.tanb.discalc.util.AppProperties#get(java.lang.String)}.
	 */
	@Test
	public void testGet() {
		String value = AppProperties.get("brands.setup.file.path");
		assertEquals("values should match", "Brands.txt",  value);
	}
	
	/**
	 * Test method for {@link com.sg.gsc.interview.tanb.discalc.util.AppProperties#get(java.lang.String)}.
	 */
	@Test
	public void testInvalidKey() {
		String value = AppProperties.get("someInvalidKey");
		assertNull("value shouldn't be found", value);
	}

}
