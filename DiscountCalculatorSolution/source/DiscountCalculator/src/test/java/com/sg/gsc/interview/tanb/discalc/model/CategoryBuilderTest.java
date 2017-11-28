/**
 * 
 */
package com.sg.gsc.interview.tanb.discalc.model;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author tanmoy
 *
 */
public class CategoryBuilderTest {
	private static final double DELTA = 0.001;
	private Builder<Map<String, Category>> CategoryBuilder;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		CategoryBuilder = new CategoryBuilder();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.sg.gsc.interview.tanb.discalc.model.CategoryBuilder#build()}.
	 */
	@Test
	public void testBuild() {
		Map<String, Category> categoryMap = CategoryBuilder.build();
		
		assertNotNull("Category map shouldn't be null", categoryMap);
		
		assertEquals("Number of categories should match", 8, categoryMap.values().size());
		
		//check one random value
		Category jeans = categoryMap.get("Jeans");
		assertNotNull("jeans category should be there", jeans);
		assertEquals("Discount percent should match", 20.0, jeans.getDiscountPercent(), DELTA);
	}

}
