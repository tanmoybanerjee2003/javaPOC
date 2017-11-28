/**
 * 
 */
package com.sg.gsc.interview.tanb.discalc.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author HP
 *
 */
public class CategoryTest {
	private static final double DELTA = 0.001;
	private Category mensWear;
	private Category trousers;
	private Category jeans;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		mensWear = new Category();
		mensWear.setDiscountPercent(10.0);
		trousers = new Category();
		trousers.setDiscountPercent(0);
		trousers.setParent(mensWear);
		jeans = new Category();
		jeans.setDiscountPercent(20.0);
		jeans.setParent(trousers);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		mensWear = null;
		trousers = null;
		jeans = null;
		
	}

	/**
	 * Test method for {@link com.sg.gsc.interview.tanb.discalc.model.Category#getDiscountPercent()}.
	 */
	@Test
	public void testDiscountPercent1() {
		assertEquals("Discount percent should match", 10.0, mensWear.getDiscountPercent(), DELTA);
	}
	
	/**
	 * Test method for {@link com.sg.gsc.interview.tanb.discalc.model.Category#getDiscountPercent()}.
	 */
	@Test
	public void testDiscountPercent2() {
		assertEquals("Discount percent should match", 10.0, trousers.getDiscountPercent(), DELTA);
	}
	
	/**
	 * Test method for {@link com.sg.gsc.interview.tanb.discalc.model.Category#getDiscountPercent()}.
	 */
	@Test
	public void testDiscountPercent3() {
		assertEquals("Discount percent should match", 20.0, jeans.getDiscountPercent(), DELTA);
	}

}
