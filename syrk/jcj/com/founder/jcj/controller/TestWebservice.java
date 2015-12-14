package com.founder.jcj.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;

public class TestWebservice {
	public static void main(String[] args) throws Exception {

		String url = "http://10.78.17.238:9999/lbs?";
		String urlParameter = "operation=FeedbackPolicePlatform&content=";
		String content = "{\"data\":[{\"IP\":\"10.80.9.82:8787\",\"MSGID\":\"SynInfoDoc\",\"MSGTYPE\":\"CommandDoc\","
				+ "\"MSGSENDER\":\"警综平台\",\"MSGRECEIVER\":\"110系统\",\"MSGDATATIME\":\"2015-02-15 10:18:36\",\"SEX\":\"1\",\"EVENTLEVEL\":\"一般\",\"CALLTIME\":\"2013-11-16 10:18:36\","
				+ "\"INCEPTTYPE\":\"U0046_1\",\"NUMBER2\":\"0\",\"TELNUM\":\"18030778214\",\"NUMBER1\":\"0\",\"ACTIONNUM\":\"2\",\"ARVTIME\":\"2013-11-16 10:18:36\",\"CONTENT\":\"测试数据测试数据\","
				+ "\"DISPOSITIONRESULT\":\"01\",\"ORGSEATNO\":\"8011\",\"NUMBER3\":\"0\",\"ACTIONNAME\":\"张三,李四\",\"ACTIONSAILNUM\":\"0\",\"CASETYPE\":\"U00400102\",\"FEEDBACKORGID\":\"210204460000\",\"EVENTID\":\"20150215210200100847\","
				+ "\"FEEDBACKTIME\":\"2015-02-15 10:18:36\",\"FEEDBACKORGNAME\":\"测试数据\",\"STATIONHOUSECODE\":\"210204460000\",\"FEEDBACKNAME\":\"李玲\",\"BRUISENUM\":\"1\",\"ECONOMYLOSS\":\"0\",\"DIENUM\":\"1\",\"PERSONNUM\":\"1\",\"ACTIONTIME\":\"2013-11-16 10:18:36\",\"CASEADDRESS\":\"测试数据\","
				+ "\"ALARMSOURCE\":\"8\",\"CASEPORT\":\"U00400102_2\",\"STATIONHOUSE\":\"测试数据\",\"CALLS\":\"王五\",\"FEEDBACKID\":\"11\",\"ACTIONCARNUM\":\"11\""
				+ "}]}";
		try {
			content = urlParameter
					+ java.net.URLEncoder.encode(content, "UTF-8");
			PostMethod postMethod = new PostMethod(url);
			byte[] b = content.getBytes("utf-8");

			InputStream is = new ByteArrayInputStream(b, 0, b.length);
			RequestEntity re = new InputStreamRequestEntity(is, b.length,
					"application/soap+xml; charset=utf-8");
			postMethod.setRequestEntity(re);
			// 最后生成一个HttpClient对象，并发出postMethod请求
			HttpClient httpClient = new HttpClient();
			int statusCode = httpClient.executeMethod(postMethod);
			if (statusCode == 200) {
				System.out.println("调用成功！");
				String soapResponseData = postMethod.getResponseBodyAsString();
				System.out.println(soapResponseData);
			} else {
				System.out.println("调用失败！错误码：" + statusCode);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
