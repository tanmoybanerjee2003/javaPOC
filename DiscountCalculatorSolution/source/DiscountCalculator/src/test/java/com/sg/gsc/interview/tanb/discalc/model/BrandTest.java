/**
 * 
 */
package com.sg.gsc.interview.tanb.discalc.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author tanmoy
 *
 */
public class BrandTest {
	private static final double DELTA = 0.001;
	private Brand wrangler;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		wrangler = new Brand("Wrangler", 10);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		wrangler = null;
	}

	/**
	 * Test method for {@link com.sg.gsc.interview.tanb.discalc.model.Brand#getName()}.
	 */
	@Test
	public void testGetName() {
		assertEquals("Wrangler", wrangler.getName());
	}

	/**
	 * Test method for {@link com.sg.gsc.interview.tanb.discalc.model.Brand#getDiscountPercent()}.
	 */
	@Test
	public void testGetDiscountPercent() {
		assertEquals(10.0, wrangler.getDiscountPercent(), DELTA);
	}

}
