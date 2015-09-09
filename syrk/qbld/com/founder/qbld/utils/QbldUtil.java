package com.founder.qbld.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletOutputStream;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.poi3.xssf.usermodel.XSSFCell;
import org.apache.poi3.xssf.usermodel.XSSFRow;
import org.apache.poi3.xssf.usermodel.XSSFSheet;
import org.apache.poi3.xssf.usermodel.XSSFWorkbook;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.utils.QbldUtil.java]  
 * @ClassName:    [QbldUtil]   
 * @Description:  [情报落地工具类]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-5-29 上午11:29:34]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-29 上午11:29:34，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
public class QbldUtil {

	//签收状态
	public static final String QS = "1";
	//反馈状态
	public static final String FK = "2";
	//发送成功状态码
	public static final String FSCG = "1";
	//全国库url
	public static final String URL = "http://10.78.17.238:9999/lbs";
	
	public static final String WSURL = "http://10.78.42.201:9010";
	
	/**
	 * @Title: isOrg
	 * @Description: TODO(判断组织机构后返回截取的字符串)
	 * @param @param orgid
	 * @param @param org
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public static String isOrg(SessionBean sessionBean, OrgOrganizationService orgOrganizationServices){
		long orgcodeId = sessionBean.getUserOrgId();
		String orgcodes = sessionBean.getUserOrgCode();
		OrgOrganization userOrg = orgOrganizationServices.queryById(orgcodeId);
		String orglevel = userOrg.getOrglevel();
		String orgcode = "";
		//分局级别
		if(("21").equals(orglevel)){
			orgcode = orgcodes.substring(0, 6);
		}
		//派出所级别
		else if("32".equals(orglevel)){
			orgcode = orgcodes.substring(0, 8);
		} 
		//情报落地功能只有分局、派出所可见；else就是为了防止责任区用户操作后报错；
		else {
			orgcode = orgcodes;
		}
		return orgcode;
	}
	
	/**
	 * @Title: exportExcel
	 * @Description: TODO(导出功能)
	 * @param @param titleArray
	 * @param @param keyArray
	 * @param @param list
	 * @param @param outputStream    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public static void exportExcel(String sheetName, String[] titleArray, String[] keyArray, List<Map<String, String>> list, ServletOutputStream outputStream){
		try {
			XSSFWorkbook wb = new XSSFWorkbook();
			XSSFSheet sheet = wb.createSheet(sheetName);
			XSSFRow head = sheet.createRow(0);
			XSSFCell cell = null;
			//表头
			for(int i = 0; i < keyArray.length; i++){
				cell = head.createCell(i);
				cell.setCellValue(titleArray[i]);
			}
			Map<String, String> map = new HashMap<String, String>();
			for(int i = 0; i < list.size(); i ++){
				XSSFRow row = sheet.createRow(i + 1);
				map = list.get(i);
				for(int j = 0; j < keyArray.length; j++){
					cell = row.createCell(j);
					cell.setCellValue(map.get(keyArray[j].toUpperCase()));
				}
			}
			wb.write(outputStream);
			outputStream.flush();
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				outputStream.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}		
	}
	
	/**
	 * @Title: getService
	 * @Description: TODO(调用全国库)
	 * @param @param url
	 * @param @param urlParameter
	 * @param @param content
	 * @param @return    设定文件
	 * @return JSONObject    返回类型
	 * @throws
	 */
	public static JSONObject getService(String urlParameter, String content){
		JSONObject json = null;
		try {
			content = urlParameter + java.net.URLEncoder.encode(content, "UTF-8");
			PostMethod postMethod = new PostMethod(URL);
			byte[] b = content.getBytes("utf-8");
			InputStream is = new ByteArrayInputStream(b, 0, b.length);
			RequestEntity re = new InputStreamRequestEntity(is, b.length, "application/soap+xml; charset=utf-8");
			postMethod.setRequestEntity(re);
			HttpClient httpClient = new HttpClient();
			HttpConnectionManagerParams managerParams = httpClient.getHttpConnectionManager().getParams();
			managerParams.setConnectionTimeout(50000);
			int statusCode = httpClient.executeMethod(postMethod);
			if (statusCode == 200) {
				String soapResponseData = postMethod.getResponseBodyAsString();
				JSONObject jsonObject = JSONObject.fromObject(soapResponseData);
				if ((Integer) jsonObject.get("datalen") > 0) {
					json = jsonObject.getJSONArray("data").getJSONObject(0);
				}
			} else {
				System.out.println("调用全国常住人口失败！错误码：" + statusCode);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}
	
}
