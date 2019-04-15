package com.syc.log4j;

import org.apache.log4j.Logger;

public class Log4jDemo {

	public static void main(String[] args) {
		//获取Logger对象
		Logger logger = Logger.getLogger(Log4jDemo.class);
		//debug----->info----->warn----->error
		logger.debug("debug...");
		logger.info("info...");
		logger.warn("warn...");
		logger.error("error...");
	}
}
