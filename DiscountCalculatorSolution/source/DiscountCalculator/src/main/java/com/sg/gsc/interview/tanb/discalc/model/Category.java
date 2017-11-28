/**
 * 
 */
package com.sg.gsc.interview.tanb.discalc.model;

import java.util.Map;
import java.util.List;

import com.sg.gsc.interview.tanb.discalc.exceptions.CategoryNotFoundException;
import com.sg.gsc.interview.tanb.discalc.util.DoubleUtil;
import com.sg.gsc.interview.tanb.discalc.util.StringUtil;

/**
 * @author tanmoy
 *
 */
public class Category {
	private String name;
	private double discountPercent;
	private Category parent;
	
	public Category() {
		//do nothing
	}
	
	public Category(List<String> categoryData, Map<String, Category> categoryMap) {
		if((categoryData != null) && (categoryData.size() >= 1)) {
			String name = categoryData.get(0);
			
			if(!StringUtil.isEmpty(name, true)) {
				//name
				this.name = name;
				
				//parent is optional
				if(categoryData.size() >= 2) {
					String parentCategoryName = categoryData.get(1);
					if(!StringUtil.isEmpty(parentCategoryName, true)) {
						parent = categoryMap.get(parentCategoryName.trim());
						if(parent == null) {
							throw new CategoryNotFoundException("Category with name " + parentCategoryName + " is not found.");
						}
					}
				} else {
					parent = null;
				}
				
				//discount percent is optional
				if(categoryData.size() >= 3) {
					String discountPercentStr = categoryData.get(2);
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
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This is the algorithm of deciding on discountPercent
	 * 
	 * @return calculated discount percent
	 */
	public final double getDiscountPercent() {
		double netDiscount = 0.0;
		
		if(parent != null) {
			if(parent.getDiscountPercent() > discountPercent) {
				//apply your parent's discountPercent
				netDiscount = parent.getDiscountPercent();
			} else {
				//take your discountPercent
				netDiscount = discountPercent;
			}
		} else {
			//this cateory has no parent, so no comparison
			netDiscount = discountPercent;
		}
		
		return netDiscount;
	}

	/**
	 * @param discountPercent the discountPercent to set
	 */
	public void setDiscountPercent(double discountPercent) {
		this.discountPercent = discountPercent;
	}

	/**
	 * @return the parent
	 */
	public Category getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(Category parent) {
		this.parent = parent;
	}

}
