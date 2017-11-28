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
import com.sg.gsc.interview.tanb.discalc.exceptions.CategorySetupException;
import com.sg.gsc.interview.tanb.discalc.io.FileReader;
import com.sg.gsc.interview.tanb.discalc.io.TextFileReader;
import com.sg.gsc.interview.tanb.discalc.util.AppProperties;
import com.sg.gsc.interview.tanb.discalc.util.StringUtil;

/**
 * @author tanmoy
 *
 */
public class CategoryBuilder implements Builder<Map<String, Category>> {
	private static final Logger LOGGER = LogManager.getLogger(CategoryBuilder.class);
	
	private String initFileName;
	
	public CategoryBuilder() {
		initFileName = AppProperties.get("categories.setup.file.path");
	}

	@Override
	public Map<String, Category> build() {
		LOGGER.debug("Category setup has started...");
		Map<String, Category> categoryMap = null;
		FileReader reader = null;
		
		try {
			reader = new TextFileReader();
			List<List<String>> data = reader.readFile(initFileName);
			if((data != null) && (data.size() > 0)) {
				categoryMap = new HashMap<>(data.size());
				for(List<String> datum : data) {
					Category category = new Category(datum, categoryMap);
					if(!StringUtil.isEmpty(category.getName(), true)) {
						categoryMap.put(category.getName(), category);
					}
				}
			} else {
				LOGGER.warn("No category data found.");
			}
		} catch(AppRuntimeException are) {
			throw new CategorySetupException(are);
		}
		LOGGER.debug("Category setup has finished successfully.");
		return categoryMap;
	}

}
