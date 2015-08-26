/**********************************************************************   
 * <p>文件名：AddressRequestService.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu_chunhui@founder.com.cn 
 * @date 2014-12-2 下午02:44:35 
 * @history
 * @department：研发部
 *
 */
package com.founder.service.requestservice;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.founder.sydw.bean.AddressResultBean;

import com.google.gson.Gson;

/******************************************************************************
 * @Package: [com.founder.service.requestservice.AddressRequestService.java]
 * @ClassName: [AddressRequestService]
 * @Description: [地址引用服务接口]
 * @Author: [wu_chunhui@founder.com.cn]
 * @CreateDate: [2014-12-2 下午02:44:35]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2014-12-2 下午02:44:35，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [本次只添加正向地址匹配功能，如果还需要其他功能请自行按照2次开发手册添加]
 * @Version: [v1.0]
 */

public class AddressRequestService {
	private static final String serviceUrl = "http://10.80.8.178:8090/PADD_S_Match/addressService";
	protected static final Log logger = LogFactory
			.getLog(AddressRequestService.class);

	/**
	 * 
	 * @Title: getAddressIdByGeocode
	 * @Description: TODO(根据地址正向匹配)
	 * @param @param address
	 * @param @return 设定文件
	 * @return AddressResultBean 返回类型
	 * @throws
	 */
	public static AddressResultBean getAddressIdByGeocode(String address) {
		AddressResultBean addressResultBean = null;
		try {
			URL serviceUrl = new URL(AddressRequestService.serviceUrl
					+ "?type=Geocode&mode=single&address="
					+ URLEncoder.encode(address, "UTF-8"));
			URLConnection conn = serviceUrl.openConnection();
			conn.setDoInput(true);
			conn.setConnectTimeout(3000);
			// BufferedReader in = new BufferedReader(new
			// InputStreamReader(conn.getInputStream()));
			String jsonStr = convertStreamToString(conn.getInputStream());
			if (jsonStr != null) {
				Gson gson = new Gson();
				addressResultBean = gson.fromJson(jsonStr,
						AddressResultBean.class);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("地址引用服务接口出错：【AddressRequestService】");
		}
		return addressResultBean;
	}

	/**
	 * @Title: convertStreamToString
	 * @Description: TODO(InputStream 转String串)
	 * @param @param is
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public static String convertStreamToString(InputStream is) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		String rStr=null;
		int len = -1;
		try {
			while ((len = is.read(buffer)) != -1) {
				baos.write(buffer, 0, len);
			}

			rStr=new String(baos.toByteArray(),"UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				baos.close();
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return rStr;
		
	}

	public static void main(String[] args) {
		AddressResultBean addressResultBean = AddressRequestService
				.getAddressIdByGeocode("123");
		System.out.println(addressResultBean.getSuccess());
	}
}
