package com.founder.yjjb.utils;

import java.util.HashMap;
import java.util.Map;

public class PKIUtils {
	public static Map<String, Object> auth(){
		Map<String, Object> item = new HashMap<String, Object>();
		item.put("0","2011111111");
		item.put("1","xxx");
		item.put("2","0000000");
		item.put("3","xxx单位");
		item.put("4",true);
		return item;
	}
}
