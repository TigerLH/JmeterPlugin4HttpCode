package com.hcb.jmeter;

import java.util.HashMap;
import java.util.Map;

/** 
 * @author  linhong: 
 * @date 2016年5月16日 下午5:30:56 
 * @Description: TODO
 * @version 1.0  
 */
public class HttpCode {
	public static Map<String,String> codeMap = new HashMap<String,String>();
	static{
		codeMap.put("200", "OK");
		codeMap.put("301", "Moved Permanently");
		codeMap.put("302", "Found");
		codeMap.put("304", "Not Modified");
		codeMap.put("400", "Bad Request");
		codeMap.put("403", "Forbidden");
		codeMap.put("404", "Not Found");
		codeMap.put("410", "Gone");
		codeMap.put("500", "internal Server Error");
		codeMap.put("501", "Not Implemented");
	}
}
