package com.founder.service.requestservice;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import sun.misc.BASE64Decoder;

import com.dragonsoft.adapter.service.QueryAdapterSend;
import com.dragonsoft.pci.exception.InvokeServiceException;

/**
 * 全国常住人口请求服务查询
 * 
 * @author redstorm
 * @version 2014-7-8
 * 
 */
public class CzrkRequestService {

	static private boolean connectEnable = true;

	static private long disconnectTime = 0;

	public static CzrkResult selectCzrk(String sfzh, boolean takeImage) {
		CzrkResult result = null;
		if (sfzh != null && !"".equals(sfzh)) {
			try {
				String condition = "SFZH='" + sfzh + "'";
				QueryAdapterSend adapter = new QueryAdapterSend();
				String serviceResult = "";
				String serviceName = "";
				if (takeImage) {
					serviceName = "czrkImage";
				} else {
					serviceName = "czrk";
				}
				serviceResult = adapter.sendQuery(serviceName, condition,
						RequesterConfig.getRequestusercardid(), RequesterConfig
								.getRequestusername(), RequesterConfig
								.getRequestuserdept());
				if (serviceResult != null && !"".equals(serviceResult)) {
					CzrkResult[] parseList = parseXML(serviceResult);
					if (parseList != null && parseList.length > 0) {
						result = parseList[0];
					}
				}
				if (result == null) { // 查询不到执行第二次查询
					Thread.sleep(200L);
					serviceResult = adapter.sendQuery(serviceName, condition,
							RequesterConfig.getRequestusercardid(),
							RequesterConfig.getRequestusername(),
							RequesterConfig.getRequestuserdept());
					if (serviceResult != null && !"".equals(serviceResult)) {
						CzrkResult[] parseList = parseXML(serviceResult);
						if (parseList != null && parseList.length > 0) {
							result = parseList[0];
						}
					}
				}
			} catch (InvokeServiceException ex) {
				System.out.println("全国常住人口服务调用错误，错误代码：" + ex.getErrorCode());
				System.out
						.println("Exception : com.founder.service.requestservice.instance.CzrkRequestService/selectCzrk() "
								+ ex.getMessage());
			} catch (Exception ex) {
				System.out.println("全国常住人口服务调用错误！");
				System.out
						.println("Exception : com.founder.service.requestservice.instance.CzrkRequestService/selectCzrk() "
								+ ex.getMessage());
			}
		}
		return result;
	}

	private static CzrkResult[] parseXML(String xmlContent) throws Exception {
		List<CzrkResult> returnValue = new ArrayList<CzrkResult>();
		SAXReader xmlReader = new SAXReader();
		xmlReader.setEncoding("UTF-8");
		StringReader stringReader = new StringReader(xmlContent);
		Document documentObject = (Document) xmlReader.read(stringReader);

		Element root = documentObject.getRootElement();
		Element method = root.element("Method");
		Element items = method.element("Items");
		Element item = items.element("Item");
		Element value = item.element("Value");
		Element row;
		int rowNo = 0;
		boolean validFlag = false;
		List fieldList = new ArrayList();
		for (Iterator i = value.elementIterator("Row"); i.hasNext();) {
			row = (Element) i.next();
			if (rowNo == 0) {
				Iterator j = row.elementIterator("Data");
				String returnCode = ((Element) j.next()).getTextTrim();
				if ("00".equals(returnCode) || "000".equals(returnCode)) {
					validFlag = true;
				} else {
					throw new Exception("请求与服务平台调用错误，错误代码:" + returnCode);
				}
			} else if (rowNo == 1) {
				for (Iterator j = row.elementIterator("Data"); j.hasNext();) {
					String field = ((Element) j.next()).getTextTrim();
					fieldList.add(field.toUpperCase());
				}
			} else {
				int tempI = 0;
				CzrkResult resultObject = new CzrkResult();
				for (Iterator j = row.elementIterator("Data"); j.hasNext();) {
					String itemValueData = ((Element) j.next()).getTextTrim();
					String field = (String) fieldList.get(tempI);
					if ("SFZH".equals(field)) {
						resultObject.setSFZH(itemValueData);
					} else if ("CSRQ".equals(field)) {
						if (itemValueData != null
								&& itemValueData.length() == 8) { // 出生日期格式转换
							itemValueData = itemValueData.substring(0, 4) + "-"
									+ itemValueData.substring(4, 6) + "-"
									+ itemValueData.substring(6);
						}
						resultObject.setCSRQ(itemValueData);
					} else if ("XM".equals(field)) {
						resultObject.setXM(itemValueData);
					} else if ("XB".equals(field)) {
						resultObject.setXB(itemValueData);
					} else if ("CYM".equals(field)) {
						resultObject.setCYM(itemValueData);
					} else if ("MZ".equals(field)) {
						resultObject.setMZ(itemValueData);
					} else if ("ZZSSX".equals(field)) {
						resultObject.setZZSSX(itemValueData);
					} else if ("ZZXZ".equals(field)) {
						resultObject.setZZXZ(itemValueData);
					} else if ("JGSSX".equals(field)) {
						resultObject.setJGSSX(itemValueData);
					} else if ("HYZK".equals(field)) {
						resultObject.setHYZK(itemValueData);
					} else if ("WHCD".equals(field)) {
						resultObject.setWHCD(itemValueData);
					} else if ("ZY".equals(field)) {
						resultObject.setZY(itemValueData);
					} else if ("XP".equals(field)) {
						resultObject.setXP(itemValueData);
					}
					tempI++;
				}
				returnValue.add(resultObject);
			}
			rowNo++;
		}
		return (CzrkResult[]) returnValue.toArray(new CzrkResult[0]);
	}

	public static void main(String[] args) {
		try {
			// Profile profile = new Profile("rbsp_setup.ini");
			// System.out.println(profile.getValue("base", "ip"));

			String sfzh = "";
			sfzh = "513401195808231316";
			sfzh = "510704198805051826"; // girl

			CzrkRequestService service = new CzrkRequestService();
			CzrkResult result = service.selectCzrk(sfzh, true);

			if (result != null) {
				System.out.println("SFZH   = " + result.getSFZH());
				System.out.println("XM     = " + result.getXM());
				System.out.println("CYM    = " + result.getCYM());
				System.out.println("XB     = " + result.getXB());
				System.out.println("CSRQ   = " + result.getCSRQ());
				System.out.println("ZZSSX  = " + result.getZZSSX());
				System.out.println("ZZXZ   = " + result.getZZXZ());
				System.out.println("JGSSX  = " + result.getJGSSX());
				System.out.println("MZ     = " + result.getMZ());
				System.out.println("WHCD   = " + result.getWHCD());
				System.out.println("HYZK   = " + result.getHYZK());
				System.out.println("ZY     = " + result.getZY());
				System.out.println("XP.length = " + result.getXP().length());
				if (!"".equals(result.getXP())) {
					OutputStream out = new FileOutputStream("C:/"
							+ result.getXM() + ".jpg");
					OutputStream outBuffer = new BufferedOutputStream(out);
					outBuffer.write(new BASE64Decoder().decodeBuffer(result
							.getXP()));
					outBuffer.close();
				}
			} else {
				System.out.println("查询无记录！");
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
