package com.linbao.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringUtil {

	private static final Logger logging = LoggerFactory.getLogger(StringUtil.class);
	
	
	public static boolean isEmpty(String string){
		if(null == string || "".equals(string) || "null".equals(string)){
			logging.info("The string object is null or empty");
			return true;
		}
		logging.info("The string object is not null or not empty");
		return false;
		
	}
}
