/**
 * 
 */
package com.sg.gsc.interview.tanb.discalc.model;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

import com.sg.gsc.interview.tanb.discalc.util.AppProperties;
import com.sg.gsc.interview.tanb.discalc.util.StringUtil;
import com.sg.gsc.interview.tanb.discalc.exceptions.AppRuntimeException;
import com.sg.gsc.interview.tanb.discalc.exceptions.BrandSetupException;
import com.sg.gsc.interview.tanb.discalc.io.FileReader;
import com.sg.gsc.interview.tanb.discalc.io.TextFileReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author tanmoy
 *
 */
public class BrandBuilder implements Builder<Map<String, Brand>> {
	private static final Logger LOGGER = LogManager.getLogger(BrandBuilder.class);
	
	private String initFileName;
	
	public BrandBuilder() {
		initFileName = AppProperties.get("brands.setup.file.path");
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.sg.gsc.interview.tanb.discalc.model.Builder#build()
	 */
	public Map<String, Brand> build() {
		LOGGER.debug("Brand setup has started...");
		
		Map<String, Brand> brandMap = null;
		FileReader reader = null;
		
		try {
			reader = new TextFileReader();
			List<List<String>> data = reader.readFile(initFileName);
			if((data != null) && (data.size() > 0)) {
				brandMap = new HashMap<>(data.size());
				for(List<String> datum : data) {
					Brand brand = new Brand(datum);
					if(!StringUtil.isEmpty(brand.getName(), true)) {
						brandMap.put(brand.getName(), brand);
					}
				}
			} else {
				LOGGER.warn("No brand data found.");
			}
		} catch(AppRuntimeException are) {
			throw new BrandSetupException(are);
		}
		
		LOGGER.debug("Brand setup has finished successfully.");
		return brandMap;
	}
}
