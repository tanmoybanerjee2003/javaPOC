/**
 * 
 */
package com.sg.gsc.interview.tanb.discalc.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sg.gsc.interview.tanb.discalc.exceptions.ProductNotFoundException;

/**
 * @author tanmoy
 *
 */
public class Customer {
	private List<Product> products;
	
	public Customer() {
		//do nothing
	}
	
	public Customer(List<String> productIdStrs, Map<Integer, Product> productMap) {
		if((productIdStrs != null) && (productIdStrs.size() > 0)) {
			if(products == null) {
				products = new ArrayList<>(productIdStrs.size());
			}
			for(String productIdStr : productIdStrs) {
				Product product = productMap.get(Integer.parseInt(productIdStr));
				if(product == null) {
					throw new ProductNotFoundException("Product having ID " + productIdStr + " is not found."); 
				} else {
					//add to purchase list
					products.add(product);
				}
			}
		}
	}
	
	/**
	 * 
	 * @return total discount received
	 */
	public double getTotalDiscount() {
		double sum  = 0;
		
		if(products != null) {
			for(Product product :  products) {
				sum +=  product.getDiscountAmount();
			}
		}
		
		return sum;
	}
	
	/**
	 * 
	 * @return cost of purchase
	 */
	public double getCostOfPurchase() {
		double sum = 0;
		
		if(products != null) {
			for(Product product :  products) {
				sum +=  product.getDiscountedPrice();
			}
		}
		
		return sum;
	}

	/**
	 * @return the products
	 */
	public List<Product> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
