package com.founder.ldym.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 
 * <p>标题：字符串处理工具类</p>
 * <p>描述：</p>
 * <p>Copyright：Copyright(c) 2014 founder</p>
 * <p>日期：2014-1-10</p>
 * @author	gb
 */
public class StringUtil extends org.springframework.util.StringUtils {
	
	/**
	 * 回车换行
	 */
	public static final String enterNewline = String.valueOf((char) 13) + String.valueOf((char) 10);
	
	/**
	 * <p>说明：null 转换为空字符串</p>
	 * <p>时间：2014-1-10 上午11:10:49</p>
	 * @param temp 需要转换的字符串
	 * @return String
	 */
	public static String nullToStr(String temp) {
		if (temp == null)
			temp = "";
		return temp;
	}
	
	/**
	 * <p>说明：判断对象是否为空</p>
	 * <p>时间：2014-1-24 上午11:07:47</p>
	 * @param obj 需要判断的对象
	 * @return boolean
	 */
	public static boolean isEmpty(Object obj) {
		if(obj == null || "".equals(obj)) {
			return true;
		} else {
			return false;
		}
	}
	
	
	/**
	 * <p>说明：返回字符串分割后的字符串数组,不同于 String.split() 方法,可以正确的得到特殊字符的分割结果</p>
	 * <p>时间：2014-1-21 下午2:43:46</p>
	 * @param str 被分割的字符串
	 * @param splitStr 分割符,可以是一个字符串
	 * @return String[]
	 */
	public static String[] split(String str, String splitStr) {
		List<String> coll = new ArrayList<String>();
		if (str != null && !"".equals(str) && splitStr != null
				&& !"".equals(splitStr)) {
			String tempStr = str;
			int at = tempStr.indexOf(splitStr);
			while (at != -1) {
				coll.add(tempStr.substring(0, at));
				tempStr = tempStr.substring(at + splitStr.length());
				at = tempStr.indexOf(splitStr);
			}
			coll.add(tempStr);
		}
		return (String[]) coll.toArray(new String[0]);
	}
	
	/**
	 * <p>说明：去掉字符串的单引号与双引号</p>
	 * <p>时间：2014-1-21 下午2:44:50</p>
	 * @param str
	 * @return
	 */
	public static String clearMark(String str) {
		String returnValue = "";
		if (str != null && !"".equals(str)) {
			returnValue = str.replaceAll("'", "");
			returnValue = returnValue.replaceAll("\"", "");
		}
		return returnValue;
	}
	
	/**
	 * <p>说明：文本字符串转换成HTML格式</p>
	 * <p>时间：2014-1-21 下午2:45:16</p>
	 * @param str 需要转换的字符串 <li>& 转换成 ＆amp; <li>空格 转换成 ＆nbsp; <li>" 转换成 ＆quot;
	 *            <li>< 转换成 ＆lt; <li>>转换成 ＆gt; <li>\n 转换成 ＜br＞
	 * @return String
	 */
	public static String txtToHtml(String str) {
		String returnValue = "";
		if (str != null && !"".equals(str)) {
			returnValue = str.replaceAll("&", "&amp;");
			returnValue = returnValue.replaceAll(" ", "&nbsp;");
			returnValue = returnValue.replaceAll("\"", "&quot;");
			returnValue = returnValue.replaceAll("<", "&lt;");
			returnValue = returnValue.replaceAll(">", "&gt;");
			returnValue = returnValue.replaceAll("\n", "<br>");
		}
		return returnValue;
	}
	
	/**
	 * <p>说明：HTML格式的字符串转换成文本格式</p>
	 * <p>时间：2014-1-21 下午2:45:57</p>
	 * @param str 需要转换的字符串 <li>＆amp; 转换成 & <li>＆nbsp; 转换成 空格 <li>＆quot; 转换成 "
	 *            <li>＆lt; 转换成 < <li>＆gt; 转换成 > <li>＜br＞ 转换成 \n <li>＜br/＞ 转换成 \n
	 * @return String
	 */
	public static String htmlToTxt(String str) {
		String returnValue = "";
		if (str != null && !"".equals(str)) {
			returnValue = returnValue.replaceAll("<br/>", "\n");
			returnValue = returnValue.replaceAll("<br>", "\n");
			returnValue = returnValue.replaceAll("&lt;", "<");
			returnValue = returnValue.replaceAll("&gt;", ">");
			returnValue = returnValue.replaceAll("&nbsp;", " ");
			returnValue = returnValue.replaceAll("&amp;", "&");
			returnValue = returnValue.replaceAll("&quot;", "\"");
		}
		return returnValue;
	}
	
	/**
	 * <p>说明：当前字符转换行符转换成空格</p>
	 * <p>时间：2014-1-21 下午2:49:14</p>
	 * @param str 需要转换的字符串 (char)13 + (char)10 转换成 空格
	 * @return
	 */
	public static String enterToSpace(String str) {
		String returnValue = "";
		if (str != null && !"".equals(str)) {
			returnValue = str.replaceAll(getEnterNewLine(), " ");
		}
		return returnValue;
	}

	/**
	 * <p>说明：当前字符转换行符转换成空格</p>
	 * <p>时间：2014-1-21 下午2:49:28</p>
	 * @param str 需要转换的字符串 (char)13 + (char)10 转换成 空格
	 * @return
	 */
	public static String enterToEmpty(String str) {
		String returnValue = "";
		if (str != null && !"".equals(str)) {
			returnValue = str.replaceAll(getEnterNewLine(), "");
		}
		return returnValue;
	}

	/**
	 * <p>说明：取得SQL中的条件表达式</p>
	 * <p>时间：2014-1-21 下午2:49:41</p>
	 * @param str 需要转换的字符串 '（单引号） 转换成 ''（两个单引号，SQL中默认两个单引号为一个单引号字符）
	 * @return String
	 */
	public static String getSqlExpression(String str) {
		String returnValue = "";
		if (str != null && !"".equals(str)) {
			returnValue = str.replaceAll("'", "''");
		}
		return returnValue;
	}

	/**
	 * <p>说明：当前字符转换行符转换成回车符</p>
	 * <p>时间：2014-1-21 下午2:50:01</p>
	 * @param str 需要转换的字符串 (char)13 + (char)10 转换成 (char)13 回车符
	 * @return String
	 */
	public static String enterConvert(String str) {
		String returnValue = "";
		String enterNewline = getEnterNewLine();
		if (str != null && !"".equals(str)) {
			returnValue = str.replaceAll(enterNewline, String
					.valueOf((char) 13));
		}
		return returnValue;
	}

	/**
	 * <p>说明：取得当前URL完整地址，包括参数字符串</p>
	 * <p>时间：2014-1-21 下午2:50:18</p>
	 * @param request 当前的 request 对象
	 * @return String
	 */
	public static String getCurURL(HttpServletRequest request) {
		String returnValue = request.getRequestURI();
		String queryString = request.getQueryString();
		if (queryString != null) {
			returnValue = returnValue + "?" + queryString;
		}
		return returnValue;
	}

	/**
	 * <p>
	 * 说明：取得当前URL替换后的完整地址（注意：如替换的参数名不存则增加，参数值为中文直接用URLEncode方法转换，
	 * queryString中如有多个相同的参数则同时替换）
	 * </p>
	 * <p>
	 * 时间：2014-1-21 下午2:50:52
	 * </p>
	 * 
	 * @param request
	 *            当前的 request 对象
	 * @param parameterMap
	 *            替换的参数名与值的Map集合
	 * @return String
	 */
	public static String getCurURLReplaced(HttpServletRequest request,
			Map<String, Object> parameterMap) {
		String requestUri = request.getRequestURI();
		String queryString = request.getQueryString();
		return getCurURLReplaced(requestUri, queryString, parameterMap);
	}

	/**
	 * <p>说明：取得当前URL替换后的完整地址
	 * 			（注意：如替换的参数名不存则增加，
	 * 			参数值为中文直接用URLEncode方法转换，
	 * 			queryString中如有多个相同的参数则同时替换）</p>
	 * <p>时间：2014-1-21 下午2:52:10</p>
	 * @param requestUri 当前的请求地址
	 * @param queryString 当前请求地址中的get参数字符串
	 * @param parameterMap 替换的参数名与值的Map集合
	 * @return 替换后URL地址
	 */
	public static String getCurURLReplaced(String requestUri,
			String queryString, Map<String, Object> parameterMap) {
		String returnValue = "";
		requestUri = nullToStr(requestUri);
		if (parameterMap == null || parameterMap.isEmpty()) { // 参数为空
			if (queryString == null || "".equals(queryString)) {
				returnValue = requestUri;
			} else {
				returnValue = requestUri + "?" + queryString;
			}
		} else {
			String key, value;
			if (queryString == null || "".equals(queryString)) { // 本身没有参数
				StringBuffer sb = new StringBuffer();
				Iterator<String> iterator = parameterMap.keySet().iterator();
				while (iterator.hasNext()) { // 不存在的新增
					key = (String) iterator.next();
					value = (String) parameterMap.get(key);
					if (sb.length() == 0) {
						sb.append("?");
					} else {
						sb.append("&");
					}
					sb.append(key + "=" + urlEncode(value));
				}
				returnValue = requestUri + sb.toString();

			} else { // 本身有参数
				StringBuffer sb = new StringBuffer();
				String[] tempArray = queryString.split("&");
				Map<String, Object> addMap = new HashMap<String, Object>(parameterMap);
				for (int i = 0; i < tempArray.length; i++) {
					String[] keyArray = tempArray[i].split("=");
					key = keyArray[0];
					sb.append("&");
					if (parameterMap.containsKey(key)) {
						value = (String) parameterMap.get(key);
						sb.append(key + "=" + urlEncode(value));
						addMap.remove(key);
					} else {
						sb.append(tempArray[i]);
					}
				}
				Iterator<String> iterator = addMap.keySet().iterator();
				while (iterator.hasNext()) { // 不存在的新增
					key = (String) iterator.next();
					value = (String) addMap.get(key);
					sb.append("&" + key + "=" + urlEncode(value));
				}
				returnValue = requestUri + "?" + sb.toString().substring(1);
			}
		}
		return returnValue;
	}

	/**
	 * <p>说明：中文字符串转换，转成 ISO8859-1 编码格式</p>
	 * <p>时间：2014-1-21 下午2:52:53</p>
	 * @param str 转码前字符串
	 * @return 转码后字符串
	 */
	public static String getCharSetISO8859(String str) {
		try {
			if (str == null)
				return "";
			String tempStr = str;
			byte[] tempArray = tempStr.getBytes("ISO8859-1");
			return new String(tempArray);
		} catch (Exception ex) {
			 ex.printStackTrace();
		}
		return "";
	}

	/**
	 * <p>说明：中文字符串转换，转成 UTF8 编码格式</p>
	 * <p>时间：2014-1-21 下午2:53:12</p>
	 * @param str 转码前字符串
	 * @return 转码后字符串
	 */
	public static String getCharSetUTF8(String str) {
		try {
			if (str == null)
				return "";
			String tempStr = str;
			byte[] tempArray = tempStr.getBytes();
			String temp = new String(tempArray, "UTF8");
			return temp;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "";
	}

	/**
	 * <p>说明：URL中的中文字符串转换(没有通过页面提交的，则用java.net.URLDecoder.decode(str, "UTF8")还原)</p>
	 * <p>时间：2014-1-21 下午2:53:28</p>
	 * @param str 转码前字符串
	 * @return String 转码后字符串
	 */
	public static String urlEncode(String str) {
		String returnValue = "";
		try {
			if (str != null) {
				returnValue = java.net.URLEncoder.encode(str, "UTF-8");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return returnValue;
	}

	/**
	 * 
	 * <p>说明：URL中的中文字符串还原(直接用URLEncode()的返回值调用该方法是无效的，
	 * 			必须是在请求页面中调用才能还原，
	 * 			因为页面请求是按 ISO8859-1 格式编码的)</p>
	 * <p>时间：2014-1-21 下午2:54:00</p>
	 * @param str 原字符串
	 * @return String 转码后字符串
	 */
	public static String urlDecode(String str) {
		String returnValue = "";
		try {
			if (str != null) {
				byte[] tempArray = str.getBytes("ISO8859-1");
				returnValue = new String(tempArray, "UTF-8");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return returnValue;
	}

	/**
	 * 
	 * <p>说明：取得字符串长度(一个汉字为两个字符长度)</p>
	 * <p>时间：2014-1-21 下午2:54:35</p>
	 * @param sourceStr 需要处理的字符串
	 * @return 处理后字符串
	 */
	public static long getStringLength(String sourceStr) {
		long returnValue = 0;
		if (sourceStr == null) {
			return (returnValue);
		}
		for (int i = 0; i < sourceStr.length(); i++) {
			char[] tempChar = sourceStr.substring(i, i + 1).toCharArray();
			if ((int) tempChar[0] > 255)
				returnValue += 2;
			else
				returnValue++;
		}
		return returnValue;
	}

	/**
	 * 
	 * <p>说明：取得重复次数的字符串</p>
	 * <p>时间：2014-1-21 下午2:54:48</p>
	 * @param sourceStr 重复源
	 * @param repeatTimes 重复次数
	 * @return String
	 */
	public static String getRepeatString(String sourceStr, long repeatTimes) {
		if (repeatTimes == 0) {
			return "";
		}
		StringBuffer returnStr = new StringBuffer();
		for (int i = 0; i < repeatTimes; i++) {
			returnStr.append(sourceStr);
		}
		return returnStr.toString();
	}

	/**
	 * 
	 * <p>说明：取得指定长度的左字符串,不足长度的以 replaceString 右填充</p>
	 * <p>时间：2014-1-21 下午2:55:06</p>
	 * @param ss 需要处理的字符串
	 * @param sl 指定长度(一个汉字为两个字符长度,如果截断地方为一个汉字,则可能长度小1)
	 * @param rs 不足长度时填充的字符
	 * @return String
	 */
	public static String getLeftSpecifyString(String ss, long sl, String rs) {
		if (ss == null) {
			return (getRepeatString(rs, sl));
		}
		long realLength = getStringLength(ss);
		StringBuffer returnStr = new StringBuffer();
		if (realLength < sl) {
			returnStr.append(ss);
			returnStr.append(getRepeatString(rs, sl
					- realLength));
		} else {
			returnStr.append(getLeftString(ss, sl));
		}
		return returnStr.toString();
	}

	/**
	 * 
	 * <p>说明：取得字符串的左子串,长度由 leftLength 指定</p>
	 * <p>时间：2014-1-21 下午2:55:30</p>
	 * @param sourceStr 需要处理的字符串
	 * @param leftLength 指定长度,从左边取该长度(一个汉字为两个字符长度,如果截断地方为一个汉字,则可能长度小1)
	 * @return String
	 */
	public static String getLeftString(String sourceStr, long leftLength) {
		StringBuffer returnStr = new StringBuffer();
		long tempLength = 0;
		String tempStr = "";
		for (int i = 0; i < sourceStr.length(); i++) {
			tempStr = sourceStr.substring(i, i + 1);
			char[] tempChar = tempStr.toCharArray();
			if ((int) tempChar[0] > 255){
				tempLength += 2;
			} else {
				tempLength++;
			}
			if (tempLength < leftLength) {
				returnStr.append(tempStr);
			} else {
				if (tempLength == leftLength){
					returnStr.append(tempStr);
				}
				break;
			}
		}
		return returnStr.toString();
	}

	/**
	 * <p>说明：取得指定长度的右字符串,不足长度的以 replaceString 左填充</p>
	 * <p>时间：2014-1-21 下午2:55:52</p>
	 * @param sourceStr 需要处理的字符串
	 * @param specityLength 指定长度(一个汉字为两个字符长度,如果截断地方为一个汉字,则可能长度小1)
	 * @param replaceString  不足长度时填充的字符
	 * @return String
	 */
	public static String getRightSpecifyString(String sourceStr,
			long specityLength, String replaceString) {
		if (sourceStr == null) {
			return (getRepeatString(replaceString, specityLength));
		}
		long realLength = getStringLength(sourceStr);
		StringBuffer returnStr = new StringBuffer();
		if (realLength < specityLength) {
			returnStr.append(getRepeatString(replaceString, specityLength
					- realLength));
			returnStr.append(sourceStr);
		} else {
			returnStr.append(getRightString(sourceStr, specityLength));
		}
		return returnStr.toString();
	}

	/**
	 * <p>说明：取得字符串的右子串,长度由 leftLength 指定</p>
	 * <p>时间：2014-1-21 下午2:56:25</p>
	 * @param sourceStr 需要处理的字符串
	 * @param rightLength 指定长度,从右边取该长度(一个汉字为两个字符长度,如果截断地方为一个汉字,则可能长度小1)
	 * @return String
	 */
	public static String getRightString(String sourceStr, long rightLength) {
		StringBuffer returnStr = new StringBuffer();
		long tempLength = 0;
		for (int i = sourceStr.length() - 1; i >= 0; i--) {
			String tempStr = sourceStr.substring(i, i + 1);
			char[] tempChar = tempStr.toCharArray();
			if ((int) tempChar[0] > 255)
				tempLength += 2;
			else
				tempLength++;
			if (tempLength < rightLength) {
				returnStr.insert(0, tempStr);
			} else {
				if (tempLength == rightLength)
					returnStr.insert(0, tempStr);
				break;
			}
		}
		return returnStr.toString();
	}

	/**
	 * <p>说明：取得指定长度的字符串,长度由 targetlength 指定</p>
	 * <p>时间：2014-1-21 下午2:56:50</p>
	 * @param sourceString 需要处理的字符串
	 * @param targetlength 指定长度,从左边取该长度(一个汉字为两个字符长度)
	 * @return String
	 */
	public static String displayTitle(String sourceString, long targetlength) {
		String returnValue = "";
		if (sourceString != null) {
			if (getStringLength(sourceString) <= targetlength * 2)
				returnValue = sourceString;
			else
				returnValue = getLeftString(sourceString,
						(targetlength - 1) * 2)
						+ "…";
		}
		return returnValue;
	}

	/**
	 * <p>说明：把格式化的日期转换为没有分隔符的字数日期</p>
	 * <p>时间：2014-1-21 下午2:57:10</p>
	 * @param s 转换前日期字符串
	 * @return 转换后字符串
	 */
	public static String changeTime(String s) {
		String time = "";
		if (!"".equals(s)) {
			String[] ss = s.split(" ");

			if (ss.length == 2) {
				String[] sss = ss[0].split("-");
				String[] sss2 = ss[1].split(":");
				for (int i = 0; i < sss.length; i++) {
					time = time + sss[i];
				}
				for (int i = 0; i < sss2.length; i++) {
					time = time + sss2[i];
				}
			} else if (ss.length == 1) {
				String[] sss = ss[0].split("-");
				if (sss.length == 1) {
					time = sss[0];
				} else {
					for (int i = 0; i < sss.length; i++) {
						time = time + sss[i];
					}
				}
			}
		}
		return time;
	}

	/**
	 * <p>说明：取得人民币大写金额</p>
	 * <p>时间：2014-1-21 下午2:57:30</p>
	 * @param money 人民币小心
	 * @return 人民币大写字符串
	 */
	public static String getChineseMoney(double money) {
		if (money > 999999999999999.99 || money < 0) { // 不符合的数值
			return "";
		}
		if (money == 0) {
			return "零元整";
		}
		StringBuffer returnValue = new StringBuffer();
		String chinaDigital[] = new String[] { "零", "壹", "贰", "叁", "肆", "伍",
				"陆", "柒", "捌", "玖" };
		String chinaUnit[] = new String[] { "仟", "佰", "拾", "万", "仟", "佰", "拾",
				"亿", "仟", "佰", "拾", "万", "仟", "佰", "拾", "", "元", "角", "分" };
		java.text.DecimalFormat fmt = new java.text.DecimalFormat(".00");
		String moneyStr = fmt.format(money);
		int moneyLength = moneyStr.length();
		String tempChar = "";
		int tempInt = 0;
		int tempAtArray = 0;
		int zeroCount = 0; // 记0个数
		boolean lastZero = false;
		for (int i = 0; i < moneyLength; i++) {
			tempChar = moneyStr.substring(i, i + 1);
			if (".".equals(tempChar)) {
				if (money >= 1) {
					returnValue.append("元");
				}
			} else {
				tempInt = Integer.parseInt(tempChar);
				tempAtArray = 19 - moneyLength + i;
				if (tempInt == 0) { // 为零的处理
					lastZero = true;
					zeroCount++;
					if (tempAtArray == 7
							|| (tempAtArray % 4 == 3 && zeroCount < 4)) { // 亿必需出现
						returnValue.append(chinaUnit[tempAtArray]);
						zeroCount = 0;
					}
				} else {
					zeroCount = 0;
					if (lastZero) {
						if (money >= 1) {
							returnValue.append(chinaDigital[0]);
						}
					}
					returnValue.append(chinaDigital[tempInt]);
					returnValue.append(chinaUnit[tempAtArray]);
					lastZero = false;
				}
			}
		}
		if (moneyStr.endsWith("0")) {
			returnValue.append("整");
		}
		return returnValue.toString();
	}

	/**
	 * 
	 * <p>说明：判断字符串是否为空，空格、回车符、换行符、Tab符默认为空</p>
	 * <p>时间：2014-1-21 下午2:57:46</p>
	 * @param temp 判断的字符串
	 * @return boolean 返回是否为空(为null时返回true)
	 */
	public static boolean isBlank(Object temp) {
		boolean returnValue = true;
		if (temp != null) {
			if (temp instanceof String)
				returnValue = temp.toString().matches("\\s*");
			else
				returnValue = false;
		}
		return returnValue;
	}
	
    /**
     * 
     * <p>说明：取得用人民币大写金额表示的整数,格式如: (贰仟零捌万零伍佰壹拾贰)</p>
     * <p>时间：2014-1-21 下午2:58:13</p>
     * @param money
     * @return
     */
	public static String getChineseNumberAsMoney(long money) {
		if (money > 999999999999999.99 || money < 0) { // 不符合的数值
			return "";
		}
		if (money == 0) {
			return "零";
		}
		StringBuffer returnValue = new StringBuffer();
		String chinaDigital[] = new String[] { "零", "壹", "贰", "叁", "肆", "伍",
				"陆", "柒", "捌", "玖" };
		String chinaUnit[] = new String[] { "仟", "佰", "拾", "万", "仟", "佰", "拾",
				"亿", "仟", "佰", "拾", "万", "仟", "佰", "拾", "", "", "", "" };
		java.text.DecimalFormat fmt = new java.text.DecimalFormat(".00");
		String moneyStr = fmt.format(money);
		int moneyLength = moneyStr.length();
		String tempChar = "";
		int tempInt = 0;
		int tempAtArray = 0;
		int zeroCount = 0; // 记0个数
		boolean lastZero = false;
		for (int i = 0; i < moneyLength; i++) {
			tempChar = moneyStr.substring(i, i + 1);
			if (".".equals(tempChar)) {
				//if (money >= 1) {
					// returnValue.append("元");
				//}
			} else {
				tempInt = Integer.parseInt(tempChar);
				tempAtArray = 19 - moneyLength + i;
				if (tempInt == 0) { // 为零的处理
					lastZero = true;
					zeroCount++;
					if (tempAtArray == 7
							|| (tempAtArray % 4 == 3 && zeroCount < 4)) { // 亿必需出现
						returnValue.append(chinaUnit[tempAtArray]);
						zeroCount = 0;
					}
				} else {
					zeroCount = 0;
					if (lastZero) {
						if (money >= 1) {
							returnValue.append(chinaDigital[0]);
						}
					}
					returnValue.append(chinaDigital[tempInt]);
					returnValue.append(chinaUnit[tempAtArray]);
					lastZero = false;
				}
			}
		}
		return returnValue.toString();
	}

	/**
	 * <p>说明：取得 0 到 999999999 之间的数字中文字符串,格式如: (二千零八万零五百一十二)</p>
	 * <p>时间：2014-1-21 下午2:58:30</p>
	 * @param number
	 * @return
	 */
	public static String getChineseNumber(long number) {
		if (number > 999999999 || number < 0) { // 不符合的数值
			return "";
		}
		if (number == 0) {
			return "零";
		}
		StringBuffer returnValue = new StringBuffer();
		String chinaDigital[] = new String[] { "零", "一", "二", "三", "四", "五",
				"六", "七", "八", "九" };
		String chinaUnit[] = new String[] { "亿", "千", "百", "十", "万", "千", "百",
				"十", "" };
		String tempStr = "" + number;
		int numberLength = tempStr.length();
		String tempChar = "";
		int tempInt = 0;
		int tempAtArray = 0;
		int zeroCount = 0;
		boolean lastZero = false;
		for (int i = 0; i < numberLength; i++) {
			tempChar = tempStr.substring(i, i + 1);
			tempInt = Integer.parseInt(tempChar);
			tempAtArray = 9 - numberLength + i;
			if (tempInt == 0) { // 为零的处理
				lastZero = true;
				zeroCount++;
				if (tempAtArray == 0 || (tempAtArray % 4 == 0 && zeroCount < 4)) { // 亿必需出现
					returnValue.append(chinaUnit[tempAtArray]);
					zeroCount = 0;
				}
			} else {
				zeroCount = 0;
				if (lastZero) {
					if (number >= 1) {
						returnValue.append(chinaDigital[0]);
					}
				}
				returnValue.append(chinaDigital[tempInt]);
				returnValue.append(chinaUnit[tempAtArray]);
				lastZero = false;
			}
		}
		return returnValue.toString();
	}

	/**
	 * 
	 * <p>说明：将 15 位身份证号码转换为 18 位身份证号码</p>
	 * <p>时间：2014-1-21 下午2:58:41</p>
	 * @param sfzh 15位身份证号码
	 * @return 18位身份证号码
	 */
	public static String convertTo18Sfzh(String sfzh) {
		String returnValue = sfzh;
		try {
			if (sfzh.length() == 15) {
				String tempStr1 = sfzh.substring(0, 6);
				String tempStr2 = "19" + sfzh.substring(6);
				String tempStrAll = tempStr1 + tempStr2;
				int lastAt = 0;
				for (int i = 0; i < 17; i++) {
					int bitInt = Integer.parseInt(tempStrAll
							.substring(i, i + 1));
					int bitIntTemp = 1;
					for (int j = 0; j < 17 - i; j++) {
						bitIntTemp = (bitIntTemp * 2) % 11;
					}
					lastAt += bitInt * bitIntTemp;
				}
				lastAt = lastAt % 11;
				returnValue = tempStrAll
						+ "10X98765432".substring(lastAt, lastAt + 1);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return returnValue;
	}

	/**
	 * <p>说明：是否为一个有效的 18 位身份证号码</p>
	 * <p>时间：2014-1-21 下午2:59:04</p>
	 * @param sfzh 身份证号码
	 * @return 验证结果
	 */
	public static boolean isValidSfzh(String sfzh) {
		boolean returnValue = false;
		try {
			if (!isBlank(sfzh)) {
				int length = sfzh.length();
				if (length == 18) {
					boolean bitValid = true;
					for (int i = 0; i < 17; i++) {
						String bitChar = sfzh.substring(i, i + 1);
						if ("1234567890".indexOf(bitChar) == -1) {
							bitValid = false;
							break;
						}
					}
					if (bitValid) {
						int lastAt = 0;
						int bitInt = 0;
						for (int i = 0; i < 17; i++) {
							bitInt = Integer.parseInt(sfzh.substring(i, i + 1));
							int bitIntTemp = 1;
							for (int j = 0; j < 17 - i; j++) {
								bitIntTemp = (bitIntTemp * 2) % 11;
							}
							lastAt += bitInt * bitIntTemp;
						}
						lastAt = lastAt % 11;
						String checkBit = "10X98765432".substring(lastAt,
								lastAt + 1);
						String lastBit = sfzh.substring(17);
						lastBit = lastBit.toUpperCase();
						if (checkBit.equals(lastBit)) {
							returnValue = true;
						}
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return returnValue;
	}

	/**
	 * 
	 * <p>说明：取得BASE64编码后的字符串</p>
	 * <p>时间：2014-1-21 下午2:59:36</p>
	 * @param str
	 * @return
	 */
	public static String getBase64EncodeString(String str) {
		String returnValue = "";
		if (str != null && !"".equals(str)) {
			byte[] byteArray = str.getBytes();
			returnValue = new BASE64Encoder().encodeBuffer(byteArray);
			returnValue = returnValue.replaceAll(getEnterNewLine(), "");
		}
		return returnValue;
	}

	/**
	 * 
	 * <p>说明：取得BASE64编码后的字符串</p>
	 * <p>时间：2014-1-21 下午2:59:52</p>
	 * @param byteArray 编码前字节数组
	 * @return BASE64后的字符串
	 */
	public static String getBase64EncodeByte(byte[] byteArray) {
		String returnValue = "";
		if (byteArray != null && byteArray.length > 0) {
			returnValue = new BASE64Encoder().encodeBuffer(byteArray);
			returnValue = returnValue.replaceAll(getEnterNewLine(), "");
		}
		return returnValue;
	}

	/**
	 * 
	 * <p>说明：取得BASE64解码后的字符串</p>
	 * <p>时间：2014-1-21 下午3:00:00</p>
	 * @param str 解密钱字符串
	 * @return 解密后字符串
	 */
	public static String getBase64DecodeString(String str) {
		String returnValue = "";
		try {
			if (str != null && !"".equals(str)) {
				byte[] byteArray = new BASE64Decoder().decodeBuffer(str);
				returnValue = new String(byteArray);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return returnValue;
	}

	/**
	 * 
	 * <p>说明：取得BASE64解码后的byte数组</p>
	 * <p>时间：2014-1-21 下午3:00:16</p>
	 * @param str 加密后字符串
	 * @return 解密后字符串
	 */
	public static byte[] getBase64DecodeByte(String str) {
		byte[] returnValue = null;
		try {
			if (str != null && !"".equals(str)) {
				returnValue = new BASE64Decoder().decodeBuffer(str);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return returnValue;
	}

	/**
	 * <p>说明：生成32位的UUID</p>
	 * <p>时间：2014-1-21 下午3:01:16</p>
	 * @return UUID
	 */
	public static String get32UUID() {
		UUID uuid = UUID.randomUUID();
		String returnValue = uuid.toString();
		returnValue = returnValue.replace("-", "");
		return returnValue;
	}

	/**
	 * <p>说明：获取字符串</p>
	 * <p>时间：2014-3-10 下午1:40:59</p>
	 * @return 新的字符串
	 */
	private static String getEnterNewLine(){
		return String.valueOf((char) 13) + String.valueOf((char) 10);
	}
	
	/**
	 * 
	 * <p>说明：获取客户端IP</p>
	 * <p>时间：2014-4-1 下午12:41:10</p>
	 * @param request request
	 * @return String IP
	 */
	public static String getClientIp(HttpServletRequest request){
		String ip = request.getHeader("x-forwarded-for");
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
           ip = request.getHeader("Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
           ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
           ip = request.getRemoteAddr();
		}
	    return ip;
	}
	
	/**
	 * 
	 * <p>说明：去掉代码末尾的00（必须为偶数长度）</p>
	 * <p>时间：2014-6-19 下午7:18:24</p>
	 * @param dm
	 * @return
	 */
	public static String getSplitJgdm(String dm) {
		String returnValue = "";
		String temp = "";
		if(StringUtils.isEmpty(dm)){
			returnValue = "";
		}
		int len = dm.length();
		if(len <= 2){
			returnValue = dm;
		}
		int idx = len - 1;
		for(int i = len - 1; i >= 0; i = i - 2) {
			temp = dm.substring(i - 1, i + 1);
			if(!"00".equals(temp)) {
				break;
			}
			idx = i - 2;
		}
		returnValue = dm.substring(0, idx + 1);
		return returnValue;
	}
	
	/**
	 * 
	 * <p>说明：去掉代码末尾的00（必须为偶数长度）</p>
	 * <p>时间：2014-6-19 下午7:24:57</p>
	 * @param dwdmArray 数组
	 * @return splitDmArray 数组
	 */
	public static String[] getSplitDmArray(String[] dwdmArray) {
		String[] splitDmArray = new String[dwdmArray.length];
		int i = 0;
		for(String dm : dwdmArray){
			splitDmArray[i] = StringUtil.getSplitJgdm(dm);
			i++;
		}
		return splitDmArray;
	}
}
