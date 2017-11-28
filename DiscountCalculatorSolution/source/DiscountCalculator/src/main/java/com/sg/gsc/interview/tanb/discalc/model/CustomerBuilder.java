/**
 * 
 */
package com.sg.gsc.interview.tanb.discalc.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sg.gsc.interview.tanb.discalc.exceptions.AppRuntimeException;
import com.sg.gsc.interview.tanb.discalc.exceptions.CustomerSetupException;
import com.sg.gsc.interview.tanb.discalc.io.FileReader;
import com.sg.gsc.interview.tanb.discalc.io.TextFileReader;
import com.sg.gsc.interview.tanb.discalc.util.AppProperties;

/**
 * @author HP
 *
 */
public class CustomerBuilder implements Builder<List<Customer>> {
	private static final Logger LOGGER = LogManager.getLogger(CustomerBuilder.class);
	
	private Map<Integer, Product> productMap;
	private String initFileName;
	
	public CustomerBuilder(Map<Integer, Product> productMap) {
		this.productMap = productMap;
		initFileName = AppProperties.get("customers.purchases.input.file.path");
	}

	@Override
	public List<Customer> build() {
		LOGGER.debug("Customer setup has started...");
		
		List<Customer> customers= null;
		FileReader reader = null;
		
		try {
			reader = new TextFileReader();
			List<List<String>> data = reader.readFile(initFileName);
			if((data != null) && (data.size() > 0)) {
				customers = new ArrayList<>(data.size());
				for(List<String> datum : data) {
					Customer customer = new Customer(datum, productMap);
					customers.add(customer);
				}
			} else {
				LOGGER.warn("No customer data found.");
			}
		} catch(AppRuntimeException are) {
			throw new CustomerSetupException(are);
		}
		
		LOGGER.debug("Customer setup has finished successfully.");
		return customers;
	}

}
