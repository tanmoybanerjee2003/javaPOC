/**
 * 
 */
package com.redmart.interview.tanb.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author tanmoy
 *
 */
public class IndexMapperTest {
	/**
	 * Test method for {@link com.redmart.interview.tanb.util.IndexMapperTest#convertToIndex(java.lang.String)}.
	 */
	@Test
	public void testConvertToIndex() {
		int[] indices = IndexMapper.convertToIndex("A2");
		assertEquals("row should match", 0, indices[0]);
		assertEquals("col should match", 1, indices[1]);
	}

	/**
	 * Test method for {@link com.redmart.interview.tanb.util.IndexMapperTest#convertToCellRef(int, int)}.
	 */
	@Test
	public void testConvertToCellRef() {
		String cellRef = IndexMapper.convertToCellRef(1, 1);
		assertEquals("cellRef should match", "B2", cellRef);
	}

}
