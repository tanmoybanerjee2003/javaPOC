/**
 * 
 */
package com.redmart.interview.tanb.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.redmart.interview.tanb.util.IndexMapper;
import com.redmart.interview.tanb.util.PatternUtil;

/**
 * This is the model that represents the spreadsheet.
 * A 2-dimensional array is used for containing the values
 * 
 * @author tanmoy
 */
public class SpreadSheet {
	private static final Logger LOGGER = LogManager.getLogger(SpreadSheet.class);
	
	private double[][] cells;
	private int width;
	private int height;

	public SpreadSheet(int m, int n) {
		if(m < 0) {
			LOGGER.error("Invalid m = " + m + ". Ignoring this value.");
			m = 0;
		}
		if(n < 0) {
			LOGGER.error("Invalid n = " + n + ". Ignoring this value.");
			n = 0;
		}
		width = m;
		height = n;
		cells = new double[height][width];
	}
	
	/**
	 * 
	 * @param values
	 */
	public void populate(String[] values) {
		LOGGER.debug("Started populating the spreadsheet.");
		
		if((values != null) && (values.length > 0)) {
			/*
			 * An array to track population in the spreadsheet.
			 * '0' at an index means corresponding cell in the spreadsheet is not populated.
			 * '1' means corresponding cell is populated.
			 */
			int[] poplnMarkers = new int[values.length];//by default all will be 0
			
			//scan, evaluate and add
			boolean allReplaced = true;//tracks if all cell-references could be replaced or not
			do {
				LOGGER.debug("=======================================================================");
				LOGGER.debug("starting next iteration");
				LOGGER.debug("=======================================================================");
				allReplaced = true;
				for(int i=0; i<values.length; i++) {
					LOGGER.debug("at start, values[" + i + "] = " + values[i]);
					
					if(PatternUtil.isCellReference(values[i])) {
						//cell reference
						LOGGER.debug("cell reference.");
						int[] indices = IndexMapper.convertToIndex(values[i]);
						int linearIndex = indices[0] * width + indices[1];
						
						if(poplnMarkers[linearIndex] == 1) {
							//that means we can have a value
							values[i] = Double.toString(cells[indices[0]][indices[1]]);
							
							//add to spreadsheet
							cells[i/width][i%width] = Double.parseDouble(values[i]);
							poplnMarkers[i] = 1;
							LOGGER.debug("Value added to spreadsheet.");
						} else {
							//wait for next iteration
							allReplaced = false;
						}
					} else if(PatternUtil.isNumber(values[i])) {
						//value
						if(poplnMarkers[i] == 0) {
							cells[i/width][i%width] = Double.parseDouble(values[i]);
							poplnMarkers[i] = 1;
							LOGGER.debug("Value added to spreadsheet.");
						}
					} else if(PatternUtil.isNumericExpression(values[i])) {
						//Expression containing numbers only
						if(poplnMarkers[i] == 0) {
							//evaluate the expression and add to spreadsheet
							cells[i/width][i%width] = (new Expression(values[i])).value();
							poplnMarkers[i] = 1;
							LOGGER.debug("Numeric expression evaluated and added to spreadsheet.");
						}
					} else if(PatternUtil.isCellRefExpression(values[i])) {
						LOGGER.debug("expression with cell reference.");
						//expression containing cell reference
						String[] tokens = values[i].split("\\s");
						for(int j=0; j<tokens.length; j++) {
							if(PatternUtil.isCellReference(tokens[j])) {
								int[] indices = IndexMapper.convertToIndex(tokens[j]);
								int linearIndex = indices[0] * width + indices[1];
								
								if(poplnMarkers[linearIndex] == 1) {
									//that means we can have a value
									values[i] = values[i].replace(tokens[j], Double.toString(cells[indices[0]][indices[1]]));
								} else {
									//wait for next iteration
									allReplaced = false;
								}
							}
						}
						
						if(PatternUtil.isNumericExpression(values[i])) {
							//evaluate the expression and add to spreadsheet
							cells[i/width][i%width] = (new Expression(values[i])).value();
							poplnMarkers[i] = 1;
							LOGGER.debug("expression evaluated and added to spreadsheet.");
						}
					}
					LOGGER.debug("at end, values[" + i + "] = " + values[i]);
				}
			} while(!allReplaced);
		}
		
		LOGGER.debug("Spreadsheet population ended successfully.");
	}
	
	/**
	 * print the spreadsheet
	 */
	public void print() {
		LOGGER.info(width + " " + height);
		if(cells != null) {
			for(int i=0; i<height; i++) {
				for(int j=0; j<width; j++) {
					LOGGER.info(String.format("%.5f",cells[i][j]));
				}
			}
		}
	}
}
