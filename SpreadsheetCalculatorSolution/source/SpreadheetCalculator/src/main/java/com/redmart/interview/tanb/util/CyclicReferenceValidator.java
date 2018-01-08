/**
 * 
 */
package com.redmart.interview.tanb.util;

import com.redmart.interview.tanb.model.Digraph;

/**
 * Uses directed graph to identify a cycle
 * 
 * @author tanmoy
 *
 */
public class CyclicReferenceValidator implements Validator {

	/* (non-Javadoc)
	 * @see com.redmart.interview.tanb.util.Validator#validate(java.lang.String[])
	 */
	@Override
	public String validate(int width, int height, String[] values) {
		String result = "";
		
		//form the dependency graph
		Digraph<String> digraph = new Digraph<>();
		
		for(int i=0; i<values.length; i++) {
			String fromCellRef = IndexMapper.convertToCellRef(i/width, i%width);
			String[] tokens = values[i].split("\\s");
			for(String  token : tokens) {
				if(PatternUtil.isCellReference(token)) {
					digraph.add(fromCellRef, token);
				}
			}
		}
		
		//now, check for cycle
		boolean cyclePresent = digraph.checkForCycle();
		
		if(cyclePresent) {
			result = "Cyclic reference is present.";
		}
		
		return result;
	}

}
