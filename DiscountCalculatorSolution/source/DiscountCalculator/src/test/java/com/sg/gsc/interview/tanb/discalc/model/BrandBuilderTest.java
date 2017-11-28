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
public class BrandBuilderTest {
	private static final double DELTA = 0.001;
	private Builder<Map<String, Brand>> brandBuilder;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		brandBuilder = new BrandBuilder();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		brandBuilder = null;
	}

	/**
	 * Test method for {@link com.sg.gsc.interview.tanb.discalc.model.BrandBuilder#build()}.
	 */
	@Test
	public void testBuild() {
		Map<String, Brand> brandMap = brandBuilder.build();
		
		assertNotNull("Brand map shouldn't be null", brandMap);
		
		assertEquals("Number of brands should match", 6, brandMap.values().size());
		
		//check one random value
		Brand uCB = brandMap.get("UCB");
		assertNotNull("UCB brand should be there", uCB);
		assertEquals("Discount percent should match", 0, uCB.getDiscountPercent(), DELTA);
	}

}
