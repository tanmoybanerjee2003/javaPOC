/**
 * 
 */
package com.redmart.interview.tanb.util;

/**
 * 
 * Helps in mapping between cell-reference like 'A1' and spreadsheet row,column like [0][0]
 * 
 * @author tanmoy
 *
 */
public class IndexMapper {
	/**
	 * 
	 * @param cellRef
	 * @return
	 */
	public static int[] convertToIndex(String cellRef) {
		int[] indices = null;
		
		if((cellRef != null) 
				&& (!cellRef.isEmpty()) 
				&& PatternUtil.isCellReference(cellRef)) {
			indices = new int[2];
			char cellRow = cellRef.charAt(0);
			int row;
			int col = Integer.parseInt(cellRef.substring(1));
			
			if(cellRow >= 97) {
				row = cellRow - 97;
			} else {
				row = cellRow - 65;
			}
			
			indices[0] = row;
			indices[1] = col - 1;
		}
		
		return indices;
	}
	
	/**
	 * 
	 * @param row
	 * @param col
	 * @return
	 */
	public static String convertToCellRef(int row, int col) {
		String cellRef = null;
		
		if((row < 0) || (col < 0)) {
			return null;
		}
		
		char rowChar = (char)(65 + row);
		cellRef = rowChar + Integer.toString(col + 1);
		
		return cellRef;
	}

}
