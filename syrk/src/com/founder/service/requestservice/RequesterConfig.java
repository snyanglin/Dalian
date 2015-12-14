package com.founder.service.requestservice;

public class RequesterConfig {

	/**
	 * 请求方用户公民身份号码
	 */
	private static final String requestUserCardId = "123456789012345678";

	/**
	 * 请求方用户姓名
	 */
	private static final String requestUserName = "测试用户";

	/**
	 * 请求方用户所在单位机构代码
	 */
	private static final String requestUserDept = "010000";

	public static String getRequestusercardid() {
		return requestUserCardId;
	}

	public static String getRequestusername() {
		return requestUserName;
	}

	public static String getRequestuserdept() {
		return requestUserDept;
	}

}
