package com.founder.qbld.service.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.framework.utils.UUID;
import com.founder.qbld.bean.Xscjb;
import com.founder.qbld.dao.XsDao;
import com.founder.qbld.service.XsService;
import com.founder.qbld.utils.QbldUtil;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.service.impl.LkyjzlServiceImpl.java]  
 * @ClassName:    [LkyjzlServiceImpl]   
 * @Description:  [临控预警指令服务实现类]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-4-22 上午9:29:54]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-22 上午9:29:54，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("xsService")
@Transactional
public class XsServiceImpl extends BaseService implements XsService {
	
	@Resource(name = "xsDao")
	private XsDao xsDao;

	/**
	 * @Title: queryXsList
	 * @Description: TODO(线索列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@Override
	public EasyUIPage queryXsList(EasyUIPage page, Xscjb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "bssj";
			order = "desc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("xscjb", entity);
		List<?> list = xsDao.queryXsList(page, map);
		int count = (int) xsDao.queryXsCount(map);
		page.setTotal(count);
		page.setRows(list);	
		return page;
	}

	/**
	 * @Title: queryLkyjzl
	 * @Description: TODO(根据id获取线索信息详情)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Lkyjzlb    返回类型
	 * @throws
	 */
	@Override
	public Xscjb queryXs(Xscjb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("xscjb", entity);
		return xsDao.queryXs(map);
	}

	/**
	 * @Title: saveXscjb
	 * @Description: TODO(保存线索采集表)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@Override
	public String saveXscjb(final Xscjb entity) {
		entity.setJlid(UUID.create());
		String result = xsDao.saveXscjb(entity);
		//ws异步发送数据
		new Thread(new Runnable()
	    {
			public void run() {
				sendXS(entity);
	        }
	    }).start();
		return result;
	}
	
	/**
	 * @Title: sendXS
	 * @Description: TODO(发送签收数据)
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void sendXS(Xscjb entity){
		String parms = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
				"<DATAINFO>" +
				"<ROW>" +
				"<JLID>" + entity.getJlid() + "</JLID>" +
				"<BSSJ>" + entity.getBssj() + "</BSSJ>" +
				"<JJCD>" + entity.getJjcd() + "</JJCD>" +
				"<SFYFS>" + entity.getSfyfs() + "</SFYFS>" +
				"<SFXB>" + entity.getSfxb() + "</SFXB>" +
				"<XSLY>" + entity.getXsly() + "</XSLY>" +
				"<BT>" + entity.getBt() + "</BT>" +
				"<GJC>" + entity.getGjc() + "</GJC>" +
				"<CJDWDM>" + entity.getCjdwdm() + "</CJDWDM>" +
				"<CJDWMC>" + entity.getCjdwmc() + "</CJDWMC>" +
				"<CJR>" + entity.getCjr() + "</CJR>" +
				"<TBDWDM>" + entity.getTbdwdm() + "</TBDWDM>" +
				"<TBDWMC>" + entity.getTbdwmc() + "</TBDWMC>" +
				"<TBR>" + entity.getTbr() + "</TBR>" +
				"<SHR>" + entity.getShr() + "</SHR>" +
				"<SSZT>" + entity.getSszt() + "</SSZT>" +
				"<SSLBDL>" + entity.getSslbdl() + "</SSLBDL>" +
				"<SSLB>" + entity.getSslb() + "</SSLB>" +
				"<SJMGSD>" + entity.getSjmgsd() + "</SJMGSD>" +
				"<SJZDHD>" + entity.getSjzdhd() + "</SJZDHD>" +
				"<SJRS>" + entity.getSjrs() + "</SJRS>" +
				"<SJSS>" + entity.getSjss() + "</SJSS>" +
				"<SSYY>" + entity.getSsyy() + "</SSYY>" +
				"<BXXS>" + entity.getBxxs() + "</BXXS>" +
				"<ASSJ>" + entity.getAssj() + "</ASSJ>" +
				"<ASDDLB>" + entity.getAsddlb() + "</ASDDLB>" +
				"<SSGGQK>" + entity.getSsggqk() + "</SSGGQK>" +
				"<XBYJLID>" + entity.getXbyjlid() + "</XBYJLID>" +
				"<SFSC>" + entity.getSfsc() + "</SFSC>" +
				"<SCYY>" + entity.getScyy() + "</SCYY>" +
				"<SCSJ>" + entity.getScsj() + "</SCSJ>" +
				"<B_ASSJ_KS>" + entity.getB_assj_ks() + "</B_ASSJ_KS>" +
				"<B_ASSJ_JS>" + entity.getB_assj_js() + "</B_ASSJ_JS>" +
				"<B_SSZTDM>" + entity.getB_ssztdm() + "</B_SSZTDM>" +
				"<XXZW>" + entity.getXxzw() + "</XXZW>" +
				"</ROW>" +
				"</DATAINFO>";
			try {
				parms = URLEncoder.encode(parms, "UTF-8");
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			String url = "http://10.79.1.38:9000/lnga_service/service/IRecvYJXXCZJGFromJZService?";
			String soap = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:q0=\"http://test/ws\" " +
					"xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">" +
					"<soapenv:Body>" +
					"<q0:sendClueMsg>" +
					"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
					"<CCFMsg>" +
					parms +
					"</CCFMsg>" +
					"</q0:sendClueMsg>" +
					"</soapenv:Body></soapenv:Envelope>";
			try {
				PostMethod postMethod = new PostMethod(url);
				byte[] b = soap.getBytes("utf-8");
				InputStream is = new ByteArrayInputStream(b, 0, b.length);
				RequestEntity re = new InputStreamRequestEntity(is, b.length, "application/soap+xml; charset=utf-8");
				postMethod.setRequestEntity(re);
				HttpClient httpClient = new HttpClient();
				HttpConnectionManagerParams managerParams = httpClient.getHttpConnectionManager().getParams();
				managerParams.setConnectionTimeout(50000);
				int statusCode = httpClient.executeMethod(postMethod);
				if (statusCode == 200) {
					String str = postMethod.getResponseBodyAsString();
					int begin = str.indexOf("&lt;test&gt;");
					int end =  str.indexOf("&lt;/test&gt;");
					String test = str.substring(begin, end).replace("&lt;test&gt;", "");
					System.out.println(test);
				} else {
					//调用程序失败
					entity.setCode(""+statusCode);
					entity.setFszt(QbldUtil.FSCG);
					xsDao.updateXsb(entity);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
}
