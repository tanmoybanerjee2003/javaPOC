/**
 * 
 */
package com.sg.gsc.interview.tanb.discalc.model;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author tanmoy
 *
 */
public class CustomerBuilderTest {
	private Builder<Map<String, Brand>> brandBuilder;
	private Builder<Map<String, Category>> categoryBuilder;
	private Builder<Map<Integer, Product>> productBuilder;
	private Builder<List<Customer>> customerBuilder;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		brandBuilder = new BrandBuilder();
		Map<String, Brand> brands = brandBuilder.build();
		categoryBuilder = new CategoryBuilder();
		Map<String, Category> categories = categoryBuilder.build();
		productBuilder = new ProductBuilder();
		((ProductBuilder)productBuilder).setBrands(brands);
		((ProductBuilder)productBuilder).setCategories(categories);
		Map<Integer, Product> products = productBuilder.build();
		customerBuilder = new CustomerBuilder(products);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		customerBuilder = null;
	}

	/**
	 * Test method for {@link com.sg.gsc.interview.tanb.discalc.model.CustomerBuilder#build()}.
	 */
	@Test
	public void testBuild() {
		List<Customer> customers = customerBuilder.build();
		
		assertNotNull(customers);
		
		assertEquals(2, customers.size());
	}

}
