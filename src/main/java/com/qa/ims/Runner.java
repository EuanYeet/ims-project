package com.qa.ims;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {

	public static final Logger LOGGER = LogManager.getLogger();

	public static void main(String[] args) {
		try {
		IMS ims = new IMS();
		ims.imsSystem();
		LOGGER.info("SO LONG!");
		} catch(Exception e) {
			LOGGER.info(e);
			throw e;
		} 

	}

}
