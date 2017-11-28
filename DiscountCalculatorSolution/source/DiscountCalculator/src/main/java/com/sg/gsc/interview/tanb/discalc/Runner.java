package com.sg.gsc.interview.tanb.discalc;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sg.gsc.interview.tanb.discalc.exceptions.AppRuntimeException;
import com.sg.gsc.interview.tanb.discalc.model.Builder;
import com.sg.gsc.interview.tanb.discalc.model.Customer;
import com.sg.gsc.interview.tanb.discalc.model.CustomerBuilder;
import com.sg.gsc.interview.tanb.discalc.model.Inventory;
import com.sg.gsc.interview.tanb.discalc.model.InventoryBuilder;

//import com.sg.gsc.interview.tanb

/**
 * This class runs the application
 * 
 * @author tanmoy
 *
 */
public class Runner {
	private static final Logger LOGGER = LogManager.getLogger(Runner.class);
	
	public static void main(String[] args) {
		LOGGER.debug("Discount calculator has started.");
		
		try {
			Builder<Inventory>  inventoryBuilder = new InventoryBuilder();
			Inventory inventory = inventoryBuilder.build();
			
			Builder<List<Customer>> customerBuilder = new CustomerBuilder(inventory.getProducts());
			List<Customer> customers = customerBuilder.build();
			for(Customer customer : customers) {
				LOGGER.info(customer.getCostOfPurchase());
			}
		} catch (AppRuntimeException e) {
			LOGGER.error("Error code: " + e.getErrorCode(), e);
		}
		
		LOGGER.debug("Discount calculator has ended.");
	}
}