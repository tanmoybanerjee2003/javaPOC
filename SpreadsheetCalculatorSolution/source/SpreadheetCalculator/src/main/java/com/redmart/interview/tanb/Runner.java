/**
 * 
 */
package com.redmart.interview.tanb;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.redmart.interview.tanb.model.SpreadSheet;
import com.redmart.interview.tanb.util.CyclicReferenceValidator;
import com.redmart.interview.tanb.util.InputValuesValidator;
import com.redmart.interview.tanb.util.Validator;

/**
 * This is the main class that needs to be run
 * 
 * @author tanmoy
 *
 */
public class Runner {
	private static final Logger LOGGER = LogManager.getLogger(Runner.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LOGGER.debug("Discount calculator has started.");
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			
			//read dimensions at first
			int m = sc.nextInt();
			int n = sc.nextInt();
			sc.nextLine();//an extra read to consume newline feed
			LOGGER.debug("m = " + m + ", n = " + n);
			int noOfInputs = m * n;
			String[] values = new String[noOfInputs];
			for(int i=0; i < noOfInputs; i++) {
				values[i] = sc.nextLine().trim().toUpperCase();
			}
			
			//validate
			String result = "";
			//check input values
			Validator inputValuesValidator = new InputValuesValidator();
			result += inputValuesValidator.validate(m, n, values);
			//check for  cyclic references
			Validator cyclicRefValidator = new CyclicReferenceValidator();
			result += cyclicRefValidator.validate(m, n, values);
			//exit if error is present
			if((result !=  null) && (result.length() > 0)) {
				LOGGER.error(result);
				System.exit(1);
			}
			
			//populate the spreadsheet
			SpreadSheet spreadSheet = new SpreadSheet(m, n);
			spreadSheet.populate(values);
			
			//print the spreadsheet
			spreadSheet.print();
		} catch(Exception ex) {
			LOGGER.error("Error is running Spreadsheet calculator\n", ex);
		} finally {
			if(sc != null) {
				sc.close();
			}
		}
		
		LOGGER.debug("Discount calculator has ended	.");

	}

}
