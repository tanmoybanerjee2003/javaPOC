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
public class ProductTest {
	private static final double DELTA = 0.001;
	private Brand wrangler;
	private Category mensWear;
	private Category trousers;
	private Category jeans;
	private Product wranglerJeans;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		wrangler = new Brand("Wrangler", 10);
		mensWear = new Category();
		mensWear.setDiscountPercent(10.0);
		trousers = new Category();
		trousers.setDiscountPercent(0);
		trousers.setParent(mensWear);
		jeans = new Category();
		jeans.setDiscountPercent(20.0);
		jeans.setParent(trousers);
		wranglerJeans = new Product(1, wrangler, jeans, 2200);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		wrangler = null;
		mensWear = null;
		trousers = null;
		jeans = null;
	}

	/**
	 * Test method for {@link com.sg.gsc.interview.tanb.discalc.model.Product#getDiscountAmount()}.
	 */
	@Test
	public void testGetDiscountAmount() {
		assertEquals(440.0, wranglerJeans.getDiscountAmount(), DELTA);
	}

	/**
	 * Test method for {@link com.sg.gsc.interview.tanb.discalc.model.Product#getDiscountedPrice()}.
	 */
	@Test
	public void testGetDiscountedPrice() {
		assertEquals(1760.0, wranglerJeans.getDiscountedPrice(), DELTA);
	}

}
