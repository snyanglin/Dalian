package com.founder.service.requestservice;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.dragonsoft.adapter.service.QueryAdapterSend;
import com.dragonsoft.pci.exception.InvokeServiceException;

public class JdcRequestService {

	static private boolean connectEnable = true;

	static private long disconnectTime = 0;

	/**
	 * 根据“车牌种类”与“号牌号码”查询全国机动车<br>
	 * 
	 * @param hpzl
	 * @param hphm
	 * @return
	 */
	public static JdcResult selectJdc(String hpzl, String hphm) {
		JdcResult result = null;
		if (hpzl != null && !"".equals(hpzl) && hphm != null
				&& !"".equals(hphm)) {
			try {
				String condition = "HPZL='" + hpzl + "' and HPHM='" + hphm
						+ "'";
				QueryAdapterSend adapter = new QueryAdapterSend();
				String serviceResult = "";
				String serviceName = "jdcxx";
				serviceResult = adapter.sendQuery(serviceName, condition,
						RequesterConfig.getRequestusercardid(), RequesterConfig
								.getRequestusername(), RequesterConfig
								.getRequestuserdept());
				if (serviceResult != null && !"".equals(serviceResult)) {
					JdcResult[] parseList = parseXML(serviceResult);
					if (parseList != null && parseList.length > 0) {
						result = parseList[0];
					}
				}
			} catch (InvokeServiceException ex) {
				System.out.println("全国机动车信息服务调用错误，错误代码：" + ex.getErrorCode());
				System.out
						.println("Exception : com.founder.service.requestservice.JdcRequestService/selectJdc() "
								+ ex.getMessage());
			} catch (Exception ex) {
				System.out.println("全国机动车信息服务调用错误！");
				System.out
						.println("Exception : com.founder.service.requestservice.JdcRequestService/selectJdc() "
								+ ex.getMessage());
			}
		}
		return result;
	}

	/**
	 * 根据“车主身份证号码”查询全国机动车<br>
	 * 
	 * @param sfzh
	 * @return
	 */
	public static JdcResult selectJdc(String sfzh) {
		JdcResult result = null;
		if (sfzh != null && !"".equals(sfzh)) {
			try {
				String condition = "SFZH='" + sfzh + "'";
				QueryAdapterSend adapter = new QueryAdapterSend();
				String serviceResult = "";
				String serviceName = "jdcxx";
				serviceResult = adapter.sendQuery(serviceName, condition,
						RequesterConfig.getRequestusercardid(), RequesterConfig
								.getRequestusername(), RequesterConfig
								.getRequestuserdept());
				if (serviceResult != null && !"".equals(serviceResult)) {
					JdcResult[] parseList = parseXML(serviceResult);
					if (parseList != null && parseList.length > 0) {
						result = parseList[0];
					}
				}
			} catch (InvokeServiceException ex) {
				System.out.println("全国机动车信息服务调用错误，错误代码：" + ex.getErrorCode());
				System.out
						.println("Exception : com.founder.service.requestservice.JdcRequestService/selectJdc() "
								+ ex.getMessage());
			} catch (Exception ex) {
				System.out.println("全国机动车信息服务调用错误！");
				System.out
						.println("Exception : com.founder.service.requestservice.JdcRequestService/selectJdc() "
								+ ex.getMessage());
			}
		}
		return result;
	}

	private static JdcResult[] parseXML(String xmlContent) throws Exception {
		List returnValue = new ArrayList();
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
				JdcResult resultObject = new JdcResult();
				for (Iterator j = row.elementIterator("Data"); j.hasNext();) {
					String itemValueData = ((Element) j.next()).getTextTrim();
					String field = (String) fieldList.get(tempI);
					if ("HPZL".equals(field)) {
						resultObject.setHPZL(itemValueData);
					} else if ("HPHM".equals(field)) {
						resultObject.setHPHM(itemValueData);
					} else if ("CLPP1".equals(field)) {
						resultObject.setCLPP1(itemValueData);
					} else if ("CLXH".equals(field)) {
						resultObject.setCLXH(itemValueData);
					} else if ("CSYS".equals(field)) {
						resultObject.setCSYS(itemValueData);
					} else if ("FDJH".equals(field)) {
						resultObject.setFDJH(itemValueData);
					} else if ("CLSBDH".equals(field)) {
						resultObject.setCLSBDH(itemValueData);
					} else if ("CLLX".equals(field)) {
						resultObject.setCLLX(itemValueData);
					} else if ("JDCSYR".equals(field)) {
						resultObject.setJDCSYR(itemValueData);
					} else if ("SFZH".equals(field)) {
						resultObject.setSFZJHM(itemValueData);
					}
					tempI++;
				}
				returnValue.add(resultObject);
			}
			rowNo++;
		}
		return (JdcResult[]) returnValue.toArray(new JdcResult[0]);
	}

}
