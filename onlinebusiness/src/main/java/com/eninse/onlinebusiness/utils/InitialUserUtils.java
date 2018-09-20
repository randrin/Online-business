package com.eninse.onlinebusiness.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InitialUserUtils {

	public static final Logger log = LoggerFactory.getLogger(InitialUserUtils.class);
	
	public static String calculTwoInitialUser(String firtName, String lastName) {
		
		log.info("Init calculTwoInitialUser");
		
		String initialName = "";
		initialName = firtName.substring(0, 1).toUpperCase();
		initialName += lastName.substring(0, 1).toUpperCase();
		
		log.info("Two initial name user: " +initialName);
		return initialName;
	}
}
