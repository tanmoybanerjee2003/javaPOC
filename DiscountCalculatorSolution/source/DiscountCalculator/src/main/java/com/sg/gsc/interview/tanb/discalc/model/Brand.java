/**
 * 
 */
package com.sg.gsc.interview.tanb.discalc.model;

import java.util.List;

import com.sg.gsc.interview.tanb.discalc.util.DoubleUtil;
import com.sg.gsc.interview.tanb.discalc.util.StringUtil;

/**
 * @author tanmoy
 *
 */
public class Brand {
	private String name;
	private double discountPercent;
	/**
	 * @param name
	 * @param discountPercent
	 */
	public Brand(String name, double discountPercent) {
		this.name = name;
		this.discountPercent = discountPercent;
	}
	/**
	 * 
	 * @param brandData
	 */
	public Brand(List<String> brandData) {
		if((brandData != null) && (brandData.size() > 0)) {
			String name = brandData.get(0);
			
			if(!StringUtil.isEmpty(name, true)) {
				this.name = name;
				
				//brand discount is optional
				if(brandData.size() >= 2) {
					String discountPercentStr = brandData.get(1);
					if(!StringUtil.isEmpty(discountPercentStr, true)) {
						discountPercent = DoubleUtil.round(Double.parseDouble(discountPercentStr.trim()), 2);
					} else {
						discountPercent = 0;
					}
				} else {
					discountPercent = 0;
				}
			}
		}
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the discountPercent
	 */
	public double getDiscountPercent() {
		return discountPercent;
	}

}
