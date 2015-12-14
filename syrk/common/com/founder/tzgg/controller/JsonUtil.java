/**
 * @标题: JsonUtil.java 
 * @描述:(描述文件)
 * @作者: Li_Zhenzhong@founder.com
 * @日期: 2012-5-11 下午5:12:19 
 * @版本: V1.0  
 *         修改人       更新时间      更新内容
 * 1
 * 2
 * 3
 * 4
 * 5 
 */


package com.founder.tzgg.controller;

/**
 * @类名: JsonUtil 
 * @描述:(类描述) 
 * @作者: Li_Zhenzhong@founder.com 
 * @日期: 2012-5-11 下午5:12:19 
 * 
 */
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

public class JsonUtil {  
	private static Logger logger = Logger.getLogger(JsonUtil.class);
	/**
	 * @Title: object2json 
	 * @描述:装对象转换为json格式字符串 
	 * @作者: Li_Zhenzhong@founder.com 
	 * @param obj
	 * @return
	 * @返回值类型：String
	 * @throws 
	 * @date：2012-5-11下午5:15:13
	 */
	public static String object2json(Object obj) {  
	             StringBuilder json = new StringBuilder();  
	             if (obj == null) {  
	               json.append("\"\"");  
	             } else if (obj instanceof String || obj instanceof Integer || obj instanceof Float  
	                 || obj instanceof Boolean || obj instanceof Short || obj instanceof Double  
	                 || obj instanceof Long || obj instanceof BigDecimal || obj instanceof BigInteger  
	                 || obj instanceof Byte) {  
	               json.append("\"").append(string2json(obj.toString())).append("\"");  
	             } else if (obj instanceof Object[]) {  
	               json.append(array2json((Object[]) obj));  
	             } else if (obj instanceof List) {  
	               json.append(list2json((List<?>) obj));  
	             } else if (obj instanceof Map) {  
	               json.append(map2json((Map<?, ?>) obj));  
	             } else if (obj instanceof Set) {  
	               json.append(set2json((Set<?>) obj));  
	             } else {  
	               json.append(bean2json(obj));  
	             }  
	             return json.toString();  
	  } 
	/**
	 * @Title: bean2json 
	 * @描述:装bean对象转换为json格式字符串 
	 * @作者: Li_Zhenzhong@founder.com 
	 * @param bean
	 * @return
	 * @返回值类型：String
	 * @throws 
	 * @date：2012-5-11下午5:15:43
	 */
	public static String bean2json(Object bean) {  
	             StringBuilder json = new StringBuilder();  
	             json.append("{");  
	             PropertyDescriptor[] props = null;  
	             try {  
	               props = Introspector.getBeanInfo(bean.getClass(), Object.class).getPropertyDescriptors();  
	             } catch (IntrospectionException e) {}  
	             if (props != null) {  
	               for (int i = 0; i < props.length; i++) {  
	                 try {  
	                   String name = object2json(props[i].getName());  
	                   String value = object2json(props[i].getReadMethod().invoke(bean));  
	                   json.append(name);  
	                   json.append(":");  
	                   json.append(value);  
	                   json.append(",");  
	                 } catch (Exception e) {}  
	               }  
	               json.setCharAt(json.length() - 1, '}');  
	             } else {  
	               json.append("}");  
	             }  
	             return json.toString();  
	  }
	/**
	 * @Title: list2json 
	 * @描述:装数组对象对象转换为json格式字符串  
	 * @作者: Li_Zhenzhong@founder.com 
	 * @param list
	 * @return
	 * @返回值类型：String
	 * @throws 
	 * @date：2012-5-11下午5:16:16
	 */
	public static String list2json(List<?> list) {  
	             StringBuilder json = new StringBuilder();  
	             json.append("[");  
	             if (list != null && list.size() > 0) {  
	               for (Object obj : list) {  
	                 json.append(object2json(obj));  
	                 json.append(",");  
	               }  
	               json.setCharAt(json.length() - 1, ']');  
	             } else {  
	               json.append("]");  
	             }  
	             return json.toString();  
	  }  
	/**
	 * @Title: array2json 
	 * @描述:装对象数组转换为json格式字符串  
	 * @作者: Li_Zhenzhong@founder.com 
	 * @param array
	 * @return
	 * @返回值类型：String
	 * @throws 
	 * @date：2012-5-11下午5:16:44
	 */
	public static String array2json(Object[] array) {  
	             StringBuilder json = new StringBuilder();  
	             json.append("[");  
	             if (array != null && array.length > 0) {  
	               for (Object obj : array) {  
	                 json.append(object2json(obj));  
	                 json.append(",");  
	               }  
	               json.setCharAt(json.length() - 1, ']');  
	             } else {  
	               json.append("]");  
	             }  
	             return json.toString();  
	  }  
	/**
	 * @Title: map2json 
	 * @描述:装Map对象转换为json格式字符串 
	 * @作者: Li_Zhenzhong@founder.com 
	 * @param map
	 * @return
	 * @返回值类型：String
	 * @throws 
	 * @date：2012-5-11下午5:17:03
	 */
	public static String map2json(Map<?, ?> map) {  
	             StringBuilder json = new StringBuilder();  
	             json.append("{");  
	             if (map != null && map.size() > 0) {  
	               for (Object key : map.keySet()) {  
	                 json.append(object2json(key));  
	                 json.append(":");  
	                 json.append(object2json(map.get(key)));  
	                 json.append(",");  
	               }  
	               json.setCharAt(json.length() - 1, '}');  
	             } else {  
	               json.append("}");  
	             }  
	             return json.toString();  
	  }  
	/**
	 * @Title: set2json 
	 * @描述:装set对象转换为json格式字符串  
	 * @作者: Li_Zhenzhong@founder.com 
	 * @param set
	 * @return
	 * @返回值类型：String
	 * @throws 
	 * @date：2012-5-11下午5:17:27
	 */
	public static String set2json(Set<?> set) {  
	             StringBuilder json = new StringBuilder();  
	             json.append("[");  
	             if (set != null && set.size() > 0) {  
	               for (Object obj : set) {  
	                 json.append(object2json(obj));  
	                 json.append(",");  
	               }  
	               json.setCharAt(json.length() - 1, ']');  
	             } else {  
	               json.append("]");  
	             }  
	             return json.toString();  
	  }  
	/**
	 * @Title: string2json 
	 * @描述:装普通字符串转换为json格式字符串 
	 * @作者: Li_Zhenzhong@founder.com 
	 * @param s
	 * @return
	 * @返回值类型：String
	 * @throws 
	 * @date：2012-5-11下午5:17:53
	 */
	public static String string2json(String s) {
	             if (s == null)  
	               return "";  
	             StringBuilder sb = new StringBuilder();  
	             for (int i = 0; i < s.length(); i++) {  
	               char ch = s.charAt(i);  
	               switch (ch) {  
	               case '"':  
	                 sb.append("\\\"");  
	                 break;  
	               case '\\':  
	                 sb.append("\\\\");  
	                 break;  
	               case '\b':  
	                 sb.append("\\b");  
	                 break;  
	               case '\f':  
	                 sb.append("\\f");  
	                 break;  
	               case '\n':  
	                 sb.append("\\n");  
	                 break;  
	               case '\r':  
	                 sb.append("\\r");  
	                 break;  
	               case '\t':  
	                 sb.append("\\t");  
	                 break;  
	               case '/':  
	                 sb.append("\\/");  
	                 break;  
	               default:  
	                 if (ch >= '\u0000' && ch <= '\u001F') {  
	                   String ss = Integer.toHexString(ch);  
	                   sb.append("\\u");  
	                   for (int k = 0; k < 4 - ss.length(); k++) {  
	                     sb.append('0');  
	                   }  
	                   sb.append(ss.toUpperCase());  
	                 } else {  
	                   sb.append(ch);  
	                 }  
	               }  
	             }
	             logger.debug("String格式字符串转换为json格式");
	             return sb.toString();  
	  }  
}  
