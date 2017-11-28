/**
 * 
 */
package com.sg.gsc.interview.tanb.discalc.io;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.sg.gsc.interview.tanb.discalc.exceptions.MisConfigurationException;
import com.sg.gsc.interview.tanb.discalc.util.StringUtil;

/**
 * @author tanmoy
 *
 */
public class TextFileReader implements FileReader {
	private static final String RECORD_SEPARATOR = ",";
	
	/* (non-Javadoc)
	 * @see com.sg.gsc.interview.tanb.discalc.io.FileReader#readFile(java.lang.String)
	 */
	public List<List<String>> readFile(String fileName) {
		List<List<String>> data = null;
		Stream<String> lines = null;
		
		if(!StringUtil.isEmpty(fileName, true)) {
			//read from file
			try {
				lines = Files.lines(Paths.get(fileName));
				data = lines.map(line -> Arrays.asList(line.split(RECORD_SEPARATOR))).collect(Collectors.toList());
			} catch (IOException e) {
				throw new MisConfigurationException(e);
			} finally {
				if(lines != null) {
					lines.close();
				}
			}
		} 
		
		return data;
	}

}
