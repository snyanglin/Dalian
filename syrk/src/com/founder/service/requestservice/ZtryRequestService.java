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

/**
 * 全国在逃人员请求服务查询
 * 
 * @author redstorm
 * @version 2014-7-8
 * 
 */
public class ZtryRequestService {

	static private boolean connectEnable = true;

	static private long disconnectTime = 0;

	public static ZtryResult selectZtry(String sfzh) {
		ZtryResult result = null;
		if (sfzh != null && !"".equals(sfzh)) {
			try {
				String condition = "SFZH='" + sfzh + "'";
				QueryAdapterSend adapter = new QueryAdapterSend();
				String serviceResult = "";
				String serviceName = "ztry";
				serviceResult = adapter.sendQuery(serviceName, condition,
						RequesterConfig.getRequestusercardid(), RequesterConfig
								.getRequestusername(), RequesterConfig
								.getRequestuserdept());
				if (serviceResult != null && !"".equals(serviceResult)) {
					ZtryResult[] parseList = parseXML(serviceResult);
					if (parseList != null && parseList.length > 0) {
						result = parseList[0];
					}
				}
			} catch (InvokeServiceException ex) {
				System.out.println("全国在逃人员服务调用错误，错误代码：" + ex.getErrorCode());
				System.out
						.println("Exception : com.founder.service.requestservice.instance.ZtryRequestService/selectZtry() "
								+ ex.getMessage());
			} catch (Exception ex) {
				System.out.println("全国在逃人员服务调用错误！");
				System.out
						.println("Exception : com.founder.service.requestservice.instance.ZtryRequestService/selectZtry() "
								+ ex.getMessage());
			}
		}
		return result;
	}

	private static ZtryResult[] parseXML(String xmlContent) throws Exception {
		List<ZtryResult> returnValue = new ArrayList<ZtryResult>();
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
				ZtryResult resultObject = new ZtryResult();
				for (Iterator j = row.elementIterator("Data"); j.hasNext();) {
					String itemValueData = ((Element) j.next()).getTextTrim();
					String field = (String) fieldList.get(tempI);
					if ("SFZH".equals(field)) {
						resultObject.setSFZH(itemValueData);
					} else if ("XM".equals(field)) {
						resultObject.setXM(itemValueData);
					} else if ("XB".equals(field)) {
						resultObject.setXB(itemValueData);
					} else if ("CSRQ".equals(field)) {
						resultObject.setCSRQ(itemValueData);
					} else if ("HJDSSXQ".equals(field)) {
						resultObject.setHJDSSXQ(itemValueData);
					} else if ("XZXXDZ".equals(field)) {
						resultObject.setXZXXDZ(itemValueData);
					} else if ("XZSSXQ".equals(field)) {
						resultObject.setXZSSXQ(itemValueData);
					} else if ("HYKY".equals(field)) {
						resultObject.setHYKY(itemValueData);
					} else if ("AJBH".equals(field)) {
						resultObject.setAJBH(itemValueData);
					} else if ("AJLB".equals(field)) {
						resultObject.setAJLB(itemValueData);
					} else if ("RYBH".equals(field)) {
						resultObject.setRYBH(itemValueData);
					} else if ("TPRQ".equals(field)) {
						resultObject.setTPRQ(itemValueData);
					} else if ("SG".equals(field)) {
						resultObject.setSG(itemValueData);
					} else if ("LXRDH".equals(field)) {
						resultObject.setLXRDH(itemValueData);
					} else if ("LASSXQ".equals(field)) {
						resultObject.setLASSXQ(itemValueData);
					} else if ("LADWMC".equals(field)) {
						resultObject.setLADWMC(itemValueData);
					} else if ("JYAQ".equals(field)) {
						resultObject.setJYAQ(itemValueData);
					} else if ("GNTJBH".equals(field)) {
						resultObject.setGNTJBH(itemValueData);
					} else if ("DBJB".equals(field)) {
						resultObject.setDBJB(itemValueData);
					}
					tempI++;
				}
				returnValue.add(resultObject);
			}
			rowNo++;
		}
		return (ZtryResult[]) returnValue.toArray(new ZtryResult[0]);
	}

	public static void main(String[] args) {
		try {
			// Profile profile = new Profile("rbsp_setup.ini");
			// System.out.println(profile.getValue("base", "ip"));

			String sfzh = "";
			sfzh = "210219196410175717";
			ZtryRequestService service = new ZtryRequestService();
			ZtryResult result = service.selectZtry(sfzh);

			if (result != null) {
				System.out.println("SFZH    = " + result.getSFZH());
				System.out.println("XM      = " + result.getXM());
				System.out.println("XB      = " + result.getXB());
				System.out.println("CSRQ    = " + result.getCSRQ());
				System.out.println("HJDSSXQ = " + result.getHJDSSXQ());
				System.out.println("XZXXDZ  = " + result.getXZXXDZ());
				System.out.println("XZSSXQ  = " + result.getXZSSXQ());
				System.out.println("HYKY    = " + result.getHYKY());
				System.out.println("AJBH    = " + result.getAJBH());
				System.out.println("AJLB    = " + result.getAJLB());
				System.out.println("RYBH    = " + result.getRYBH());
				System.out.println("TPRQ    = " + result.getTPRQ());
				System.out.println("SG      = " + result.getSG());
				System.out.println("LXRDH   = " + result.getLXRDH());
				System.out.println("LASSXQ  = " + result.getLASSXQ());
				System.out.println("LADWMC  = " + result.getLADWMC());
				System.out.println("JYAQ    = " + result.getJYAQ());
				System.out.println("GNTJBH  = " + result.getGNTJBH());
				System.out.println("DBJB    = " + result.getDBJB());

			} else {
				System.out.println("查询无记录！");
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
