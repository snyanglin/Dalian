package com.founder.service.provinceservice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;
import com.founder.framework.config.SystemConfig;
import com.founder.framework.httpService.BaseHttpClient;
import com.founder.framework.httpService.HttpClientResultBean;
import com.founder.framework.utils.StringUtils;
import com.founder.service.provinceservice.bean.ServiceLdyBean;
import com.founder.service.provinceservice.bean.ServiceLkxxBean;
import com.founder.service.provinceservice.bean.ServiceResult;
import com.founder.service.provinceservice.bean.ServiceResult2;
import com.founder.service.provinceservice.bean.ServiceZtryBean;

/**
 * ****************************************************************************
 * 
 * @Package: [cn.ccsgroup.ccsframework.httpService.SSOAuthHttpClient.java]
 * @ClassName: [SSOAuthHttpClient]
 * @Description: [SSO登录权限认证服务 调用client]
 * @Author: [weiwen ]
 * @CreateDate: [2014-2-18 下午3:21:54]
 * @UpdateUser: [weiwen(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2014-2-18 下午3:21:54，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
public class ServiceHttpClient extends BaseHttpClient {

	private static Map<String, String> map = new HashMap<String, String>();
	static {
		map.put("QueryEscapedCriminalByID", ""); // 通过身份证号码查找在逃人员
	}
	private String url;
	private String bizType;

	/**
	 * arr[0] 存放S001,S002.... arr[1] 存放值 GET用STRING POST用MAP
	 * */
	@Override
	protected Object bulidParam(Object[] arr) {
		// TODO Auto-generated method stub
		bizType = (String) arr[0];
		return arr[1];
	}

	@Override
	protected HttpClientResultBean formatResults(HttpClientResultBean result) {
		// TODO Auto-generated method stub
		if (bizType.equals("QueryEscapedCriminalByID")) {
			if (result.isSuccess()) {

				// 该方法可以运行，但必须指明具体的结果类，无法实现某个结点指定类
				// result.setResult(new
				// com.google.gson.GsonBuilder().create().fromJson(
				// getResResult(), new
				// com.google.gson.reflect.TypeToken<ServiceZtryResult>() {
				// }.getType()));

				JSONObject jsonObject = JSONObject.fromObject(getResResult());
				Map<String, Class> classMap = new HashMap<String, Class>();
				classMap.put("value", ServiceZtryBean.class); // 定义value中对象类
				ServiceResult serviceResult = (ServiceResult) JSONObject
						.toBean(jsonObject, ServiceResult.class, classMap);
				result.setResult(serviceResult);
			}
		} else if (bizType.equals("QueryLdyCyryBysfzh")) {
			JSONObject jsonObject = JSONObject.fromObject(getResResult());
			Map<String, Class> classMap = new HashMap<String, Class>();
			classMap.put("data", ServiceLdyBean.class); // 定义value中对象类
			ServiceResult2 serviceResult = (ServiceResult2) JSONObject.toBean(
					jsonObject, ServiceResult2.class, classMap);
			result.setResult(serviceResult);
		} else if (bizType.equals("QueryLkxxBysfzh")) {
			JSONObject jsonObject = JSONObject.fromObject(getResResult());
			Map<String, Class> classMap = new HashMap<String, Class>();
			classMap.put("data", ServiceLkxxBean.class); // 定义value中对象类
			ServiceResult2 serviceResult = (ServiceResult2) JSONObject.toBean(
					jsonObject, ServiceResult2.class, classMap);
			result.setResult(serviceResult);
		}
		return result;
	}

	@Override
	protected String getUrl() {
		// TODO Auto-generated method stub
		return this.url;
	}

	public List<ServiceZtryBean> QueryEscapedCriminalByID(String ztrysfzh) {
		List<ServiceZtryBean> list = new ArrayList<ServiceZtryBean>();
		this.url = SystemConfig.getString("provinceServiceUrl");
		// this.url = "http://10.78.17.238:8093/lbs";
		if (!StringUtils.isBlank(ztrysfzh)) {
			Object[] arr = new Object[2];
			arr[0] = "QueryEscapedCriminalByID";
			arr[1] = StringUtils
					.URLEncode("bean=QueryEscapedCriminalByID&content={\"root\":[{\"condition\":{\"ztrysfzh\":\""
							+ ztrysfzh
							+ "\"},\"offset\":\"0\",\"count\":\"1\"}]}");
			HttpClientResultBean result = getResult(arr, "GET");
			if (result.isSuccess()) {
				ServiceResult serviceResult = (ServiceResult) result
						.getResult();
				if (serviceResult.getRoot().getValue() != null) {
					list = (List) serviceResult.getRoot().getValue();
				}
			}
		}
		return list;
	}

	public List<ServiceLdyBean> QueryLdyCyryBysfzh(String sfzh) {
		List<ServiceLdyBean> list = new ArrayList<ServiceLdyBean>();
		this.url = SystemConfig.getString("provinceServiceUrl");
		this.url = "http://10.78.17.238:9999/bns";
		if (!StringUtils.isBlank(sfzh)) {
			Object[] arr = new Object[2];
			arr[0] = "QueryLdyCyryBysfzh";
			arr[1] = StringUtils
					.URLEncode("operation=CX_ZA_LGY_CYRYJBXX&content={\"data\":[{\"sfzhm\":\""
							+ sfzh + "\"},\"pageindex\":0,\"pagesize\":100}]}");
			// arr[1] =
			// StringUtils.URLEncode("operation=CX_ZA_LGY_CYRYJBXX&content={\"data\":[{\"qybh\":\""
			// + "A9921060319970002000003"
			// + "\"}],\"pageindex\":0,\"pagesize\":100}");
			HttpClientResultBean result = getResult(arr, "GET");
			if (result.isSuccess()) {
				ServiceResult2 serviceResult = (ServiceResult2) result
						.getResult();
				if (serviceResult.getData() != null) {
					list = (List) serviceResult.getData();
				}
			}
		}
		return list;
	}

	/**
	 * 查询旅客基础信息
	 * 
	 * @param sfzh
	 * @return
	 */
	public List<ServiceLkxxBean> QueryLkxxBysfzh(String sfzh) {
		List<ServiceLkxxBean> list = new ArrayList<ServiceLkxxBean>();
		this.url = SystemConfig.getString("provinceServiceUrl");
		this.url = "http://10.78.17.238:9999/bns";
		if (!StringUtils.isBlank(sfzh)) {
			Object[] arr = new Object[2];
			arr[0] = "QueryLkxxBysfzh";
			arr[1] = StringUtils
					.URLEncode("operation=CX_ZA_LGY_LKXX&content={\"data\":[{\"lkdjzjhm\":\""
							+ sfzh + "\"}],\"pageindex\":0,\"pagesize\":10}");
			HttpClientResultBean result = getResult(arr, "GET");
			if (result.isSuccess()) {
				ServiceResult2 serviceResult = (ServiceResult2) result
						.getResult();
				if (serviceResult.getData() != null) {
					list = (List) serviceResult.getData();
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {
		ServiceHttpClient client = new ServiceHttpClient();
		// List list = client.QueryEscapedCriminalByID("210219196410175717");
		// for (int i = 0; i < list.size(); i++) {
		// ServiceZtryBean bean = (ServiceZtryBean) list.get(i);
		// System.out.println(bean.getZtryxm());
		// }

		// String a =
		// "{\"root\":{\"head\":{\"code\":\"1\",\"message\":\"ok\",\"rowscount\":\"1\"},\"value\":[{\"ztryxbname\":\"男\",\"ztryladwname\":\"江西九江市\",\"ztrybh\":\"3604000029992010051101\",\"ztryxm\":\"倪乃武\",\"ztryxb\":\"1\",\"ztrysfzh\":\"210219196410175717\",\"mz_dm\":\"1 \",\"ztryhjxz\":\"五一路二段68号2-4-2\",\"ztryxzxz\":\"五一路二段68号2-4-2\",\"ztrysg\":null,\"ztryajbh\":\"3604001700002010030123\",\"ztryladw\":\"360400\",\"ztryzbr\":\"九江市\",\"ztrylxfs\":\"0792-8278103 8278102 13907026850\",\"ajlbname\":\"合同诈骗案\",\"ztryzd18\":\"030805\",\"csrqq\":\"19641017\",\"csrqz\":\"19641017\",\"tprq\":\"20100511\"}]}}";
		// JSONObject j = JSONObject.fromObject(a);
		// Map classMap = new HashMap();
		// classMap.put("value", ServiceZtryBean.class);
		// ServiceResult result = (ServiceResult) JSONObject.toBean(j,
		// ServiceResult.class, classMap);
		// List list2 = result.getRoot().getValue();
		// System.out.println(result);
		// System.out.println();

		// client.QueryLdyCyryBysfzh("210219196410175717");

		// JSONObject jsonObject = JSONObject.fromObject(new Date());
		// System.out.println(jsonObject);

		List<ServiceLkxxBean> list = client
				.QueryLkxxBysfzh("210624198510162712");
		System.out.println();
	}
}
