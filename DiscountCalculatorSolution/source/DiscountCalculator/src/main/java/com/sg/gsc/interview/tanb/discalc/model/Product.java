/**
 * 
 */
package com.sg.gsc.interview.tanb.discalc.model;

import java.util.List;
import java.util.Map;

import com.sg.gsc.interview.tanb.discalc.exceptions.BrandNotFoundException;
import com.sg.gsc.interview.tanb.discalc.exceptions.CategoryNotFoundException;
import com.sg.gsc.interview.tanb.discalc.util.StringUtil;

/**
 * @author tanmoy
 *
 */
public class Product {
	private int id;
	private Brand brand;
	private Category category;
	private double price;
	/**
	 * @param id
	 * @param brand
	 * @param category
	 * @param price
	 */
	public Product(int id, Brand brand, Category category, double price) {
		this.id = id;
		this.brand = brand;
		this.category = category;
		this.price = price;
	}
	/**
	 * 
	 * @param productData
	 * @param categoryMap
	 * @param brandMap
	 */
	public Product(List<String> productData, Map<String, Category> categoryMap, Map<String, Brand> brandMap) {
		if((productData != null) && (productData.size() >= 4)) {
			String idStr = productData.get(0);
			
			if(!StringUtil.isEmpty(idStr, true)) {
				//id
				id = Integer.parseInt(idStr);
				
				//brand
				String brandName = productData.get(1);
				if(!StringUtil.isEmpty(brandName, true)) {
					brand = brandMap.get(brandName.trim());
					if(brand == null) {
						throw new BrandNotFoundException("No brand with name " + brandName + " is found.");
					}
				}
				
				//category
				String categoryName = productData.get(2);
				if(!StringUtil.isEmpty(categoryName, true)) {
					category = categoryMap.get(categoryName.trim());
					if(category == null) {
						throw new CategoryNotFoundException("No category with name " + categoryName + " is found");
					}
				}
				
				//price
				price = Double.parseDouble(productData.get(3));
			}
		}
	}
	
	/**
	 * 
	 * @return discount amount
	 */
	public double getDiscountAmount() {
		double discountAmount = 0;
		double brandDiscount = 0;
		double categoryDiscount = 0;
		
		if(brand != null) {
			brandDiscount = brand.getDiscountPercent();
		}
		
		if(category != null) {
			categoryDiscount = category.getDiscountPercent();
		}
		
		//apply brand or category discount, whichever is higher
		if(brandDiscount > categoryDiscount) {
			discountAmount = (price * brandDiscount) / 100.0;
		} else {
			discountAmount = (price * categoryDiscount) / 100.0;
		}
		
		return discountAmount;
	}
	
	/**
	 * 
	 * @return discounted price
	 */
	public double getDiscountedPrice() {
		double discountAmount = getDiscountAmount();
		
		return (price - discountAmount);
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

}
