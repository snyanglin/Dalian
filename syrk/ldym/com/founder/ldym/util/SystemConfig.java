package com.founder.ldym.util;

import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;


/**
 * <p>标题：系统配置类</p>
 * <p>描述：</p>
 * <p>Copyright：Copyright(c) 2014 founder</p>
 * <p>日期：2014-1-21</p>
 * @author	gb
 */

public class SystemConfig {
	/**
	 * 日志对象
	 */
	private static Logger logger = Logger.getLogger(SystemConfig.class);
	/**
	 * 声明属性配置
	 */
	private static Properties property = new Properties();

	/**
	 * 
	 * <p>说明：取得所有配置项集合</p>
	 * <p>时间：2014-1-21 下午3:50:04</p>
	 * @return 属性配置对象
	 */
	public static Properties getProperty() {
		return property;
	}

	/**
	 * 
	 * <p>说明：系统配置初始化</p>
	 * <p>时间：2014-1-21 下午3:50:11</p>
	 * @param context 配置内容
	 */
	public static void init(ServletContext context) {
		try {
			/**
			 * 加载 systemConfig.properties 配置的系统信息
			 */
			InputStream in = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("systemConfig.properties");
			property.load(in);
			in.close();
			Iterator<Object> iterator = property.keySet().iterator();
			String key, value;
			while (iterator.hasNext()) {
				key = (String) iterator.next();
				value = (String) property.get(key);
				property.put(key, StringUtil.urlDecode(value));
			}

			/**
			 * web根路径的物理路径
			 */
			if (context != null) {
				String temp = context.getRealPath("");
				temp = temp.replace("\\", "/");
				property.put("webRootPath", temp);
			}

			/**
			 * 加载数据库中的用户配置信息
			 */
			// TODO
			logger.info("============The system configuration is loaded successfully!============");
		} catch (Exception ex) {
			logger.error("系统配置初始化出错: " + ex.getMessage(), ex);
		}
	}

	/**
	 * 
	 * <p>说明：增加一个配置信息</p>
	 * <p>时间：2014-1-21 下午3:52:04</p>
	 * @param key 指定key
	 * @param value 指定key对应的value
	 */
	public static synchronized void add(String key, String value) {
		property.put(key, value);
	}

	/**
	 * 
	 * <p>说明：删除一个配置信息</p>
	 * <p>时间：2014-1-21 下午3:52:16</p>
	 * @param key 指定key
	 */
	public static synchronized void remove(String key) {
		property.remove(key);
	}

	/**
	 * <p>说明：显示所有的配置信息</p>
	 * <p>时间：2014-3-10 下午3:32:18</p>
	 */
	public static void configView() {
		Iterator<Object> iterator = property.keySet().iterator();
		String key, value;
		while (iterator.hasNext()) {
			key = (String) iterator.next();
			value = (String) property.get(key);
			//System.out.println(key + " = " + value);
		}
	}

	/**
	 * 
	 * <p>说明：根据 key 取值，返回配置的字符串值</p>
	 * <p>时间：2014-1-21 下午3:52:52</p>
	 * @param key 指定key
	 * @return 配置字符串
	 */
	public static String getString(String key) {
		String returnValue = "";
		if (key != null) {
			String temp = (String) property.get(key);
			if (temp != null && !"".equals(temp)) {
				returnValue = temp;
			}
		}
		return returnValue;
	}

	/**
	 * 
	 * <p>说明： 根据 key 取值，返回配置的整数值</p>
	 * <p>时间：2014-1-21 下午3:53:01</p>
	 * @param key 指定key
	 * @return 配置数值
	 */
	public static long getLong(String key) {
		long returnValue = 0;
		try {
			if (key != null) {
				String temp = (String) property.get(key);
				if (temp != null && !"".equals(temp)) {
					returnValue = Long.parseLong(temp);
				}
			}
		} catch (Exception ex) {
			logger.error("取得系统配置出错: key=" + key + " " + ex.getMessage(), ex);
		}
		return returnValue;
	}

/*	public static void main(String[] args) {
		String a = "C:\\bea92\\user_projects\\domains\\base_domain\\autodeploy";
		//System.out.println(a.replace("\\", "/"));
		init(null);
		configView();
		//System.out.println(getString("versionInfo"));
		// long b = getLong("times");
	}*/
}
