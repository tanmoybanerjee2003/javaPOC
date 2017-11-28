/**
 * 
 */
package com.sg.gsc.interview.tanb.discalc.model;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author HP
 *
 */
public class InventoryBuilder implements Builder<Inventory> {
	private static final Logger LOGGER = LogManager.getLogger(InventoryBuilder.class);
	
	private Builder<Map<Integer, Product>> productBuilder;
	private Builder<Map<String, Brand>> brandBuilder;
	private Builder<Map<String, Category>> categoryBuilder;
	
	public InventoryBuilder() {
		productBuilder = new ProductBuilder();
		brandBuilder = new BrandBuilder();
		categoryBuilder = new CategoryBuilder();
	}

	/*
	 * (non-Javadoc)
	 * @see com.sg.gsc.interview.tanb.discalc.model.Builder#build()
	 */
	@Override
	public Inventory build() {
		LOGGER.debug("Inventory setup has started...");
		Inventory inventory = new Inventory();
		
		//set up brands
		Map<String, Brand> brands = brandBuilder.build();
		inventory.setBrands(brands);
		
		//set up categories
		Map<String, Category> categories = categoryBuilder.build();
		inventory.setCategories(categories);
		
		//set up products
		((ProductBuilder)productBuilder).setBrands(brands);
		((ProductBuilder)productBuilder).setCategories(categories);
		Map<Integer, Product> products = productBuilder.build();
		inventory.setProducts(products);
		
		LOGGER.debug("Inventory setup has finished successfully.");
		return inventory;
	}

}
