/**
 * 
 */
package com.sg.gsc.interview.tanb.discalc.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.sg.gsc.interview.tanb.discalc.exceptions.MisConfigurationException;

/**
 * @author tanmoy
 *
 */
public class AppProperties {
	private static Properties _PROPS;
	
	static {
		InputStream input = null;
		
		try {
			input = AppProperties.class.getClassLoader().getResourceAsStream("DiscountCalculator.properties");
			_PROPS = new Properties();
			_PROPS.load(input);
		} catch(FileNotFoundException e) {
			throw new MisConfigurationException(e);
		} catch(IOException e) {
			throw new MisConfigurationException(e);
		} finally {
			if(input != null) {
				try {
					input.close();
				} catch (Exception e) {
					//do nothing
				}
			}
		}
	}
	
	private AppProperties() {
		//do nothing
	}
	
	public static String get(String key) {
		return _PROPS.getProperty(key);
	}
}
