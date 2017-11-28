/**
 * 
 */
package com.sg.gsc.interview.tanb.discalc.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sg.gsc.interview.tanb.discalc.exceptions.AppRuntimeException;
import com.sg.gsc.interview.tanb.discalc.exceptions.BrandSetupException;
import com.sg.gsc.interview.tanb.discalc.io.FileReader;
import com.sg.gsc.interview.tanb.discalc.io.TextFileReader;
import com.sg.gsc.interview.tanb.discalc.util.AppProperties;

/**
 * @author tanmoy
 *
 */
public class ProductBuilder implements Builder<Map<Integer, Product>> {
	private static final Logger LOGGER = LogManager.getLogger(ProductBuilder.class);
	
	private Map<String, Brand> brands;
	private Map<String, Category> categories;
	
	private String initFileName;
	
	public ProductBuilder() {
		initFileName = AppProperties.get("products.setup.file.path");
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
	/*
	 * (non-Javadoc)
	 * @see com.sg.gsc.interview.tanb.discalc.model.Builder#build()
	 */
	@Override
	public Map<Integer, Product> build() {
		LOGGER.debug("Product setup has started...");
		
		Map<Integer, Product> productMap = null;
		FileReader reader = null;
		
		try {
			reader = new TextFileReader();
			List<List<String>> data = reader.readFile(initFileName);
			if((data != null) && (data.size() > 0)) {
				productMap = new HashMap<>(data.size());
				for(List<String> datum : data) {
					Product product = new Product(datum, categories, brands);
					if(product.getId() > 0) {
						productMap.put(product.getId(), product);
					}
				}
			} else {
				LOGGER.warn("No product data found.");
			}
		} catch(AppRuntimeException are) {
			throw new BrandSetupException(are);
		}
		
		LOGGER.debug("Product setup has finished successfully.");
		
		return productMap;
	}

}
