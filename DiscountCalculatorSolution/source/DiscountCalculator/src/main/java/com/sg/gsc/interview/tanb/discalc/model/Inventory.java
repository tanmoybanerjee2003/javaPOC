/**
 * 
 */
package com.sg.gsc.interview.tanb.discalc.model;

import java.util.Map;

/**
 * @author tanmoy
 *
 */
public class Inventory {
	private Map<Integer, Product> products;
	private Map<String, Brand> brands;
	private Map<String, Category> categories;
	/**
	 * @return the products
	 */
	public Map<Integer, Product> getProducts() {
		return products;
	}
	/**
	 * @param products the products to set
	 */
	public void setProducts(Map<Integer, Product> products) {
		this.products = products;
	}
	/**
	 * @return the brands
	 */
	public Map<String, Brand> getBrands() {
		return brands;
	}
	/**
	 * @param brands the brands to set
	 */
	public void setBrands(Map<String, Brand> brands) {
		this.brands = brands;
	}
	/**
	 * @return the categories
	 */
	public Map<String, Category> getCategories() {
		return categories;
	}
	/**
	 * @param categories the categories to set
	 */
	public void setCategories(Map<String, Category> categories) {
		this.categories = categories;
	}
}
