/**
 * 
 */
package com.sg.gsc.interview.tanb.discalc.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author HP
 *
 */
public class CustomerTest {
	private static final double DELTA = 0.001;
	private Customer customer;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		Brand wrangler = new Brand("Wrangler", 10);
		Category mensWear = new Category();
		mensWear.setDiscountPercent(10.0);
		Category trousers = new Category();
		trousers.setDiscountPercent(0);
		trousers.setParent(mensWear);
		Category jeans = new Category();
		jeans.setDiscountPercent(20.0);
		jeans.setParent(trousers);
		Product wranglerJeans = new Product(1, wrangler, jeans, 2200);
		
		List<Product> products = new ArrayList<>(1);
		products.add(wranglerJeans);
		
		customer = new Customer();
		customer.setProducts(products);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		customer = null;
	}

	/**
	 * Test method for {@link com.sg.gsc.interview.tanb.discalc.model.Customer#getTotalDiscount()}.
	 */
	@Test
	public void testGetTotalDiscount() {
		assertEquals(440.0, customer.getTotalDiscount(), DELTA);
	}

	/**
	 * Test method for {@link com.sg.gsc.interview.tanb.discalc.model.Customer#getCostOfPurchase()}.
	 */
	@Test
	public void testGetCostOfPurchase() {
		assertEquals(1760.0, customer.getCostOfPurchase(), DELTA);
	}

}
