package com.founder.jcj.service.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.jcj.bean.JcjCjxxb;
import com.founder.jcj.bean.JcjCshpz;
import com.founder.jcj.bean.JcjCwrzb;
import com.founder.jcj.bean.JcjFkxxb;
import com.founder.jcj.bean.JcjJjxxb;
import com.founder.jcj.bean.jcjSaveVo;
import com.founder.jcj.dao.JcjEditDao;
import com.founder.jcj.service.JcjEditService;
import com.founder.jcj.vo.JcjgnVO;
import com.founder.jcj.vo.JcjxxzsVO;
import com.founder.service.socketMessage.SendWebSocket;

@Transactional
@Service("jcjEditService")
public class JcjEditServiceImpl extends BaseService implements JcjEditService {
	public static String jjbh = DateUtils
			.getSystemDateTimeMillionCompactString();
	
	private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "jcjEditDao")
	private JcjEditDao jcjEditDao;

	@Override
	public List<JcjxxzsVO> queryZsxx(Map<String, Object> map) {
		map.put("xxdxlxdm", "1");
		List<JcjxxzsVO> infoList = jcjEditDao.queryFwzsxx(map);
		if (infoList != null && !infoList.isEmpty()) {
			map.put("xxdxlxdm", "2");
			for (int i = 0; i < infoList.size(); i++) {
				map.put("dlbh", infoList.get(i).getXxbh().substring(0, 2));
				infoList.get(i).setList(jcjEditDao.queryFwzsxx(map));
			}
		}
		return infoList;
	}

	@Override
	public List<JcjgnVO> queryYwglgn(Map<String, Object> map) {
		return jcjEditDao.queryYwglgn(map);
	}

	@Override
	public void delete_xxzsnrb(Map<String, Object> map) {
		jcjEditDao.delete_xxzsnrb(map);
	}

	@Override
	public JcjJjxxb queryJcjJjxxb(String id) {
		return jcjEditDao.queryJcjJjxxb(id);
	}

	@Override
	public EasyUIPage queryJcjNoPt(EasyUIPage page, JcjJjxxb entity) {
		// TODO Auto-generated method stub
		return jcjEditDao.queryJcjNoPt(page, entity);
	}

	@Override
	public JcjCjxxb queryJcjxxbById(String id) {
		// TODO Auto-generated method stub
		return jcjEditDao.queryJcjxxbById(id);
	}

	/**
	 * 签收
	 */
	public void insertCjxxb(JcjCjxxb entity, SessionBean sessionBean) {
		String cjdbh = entity.getJjbh() + "301";
		entity.setCjdbh(cjdbh);
		String uuid =UUID.create();
		entity.setId(uuid);
		setSaveProperties(entity, sessionBean);
		jcjEditDao.insertCjxxb(entity);

		String orgCode = sessionBean.getUserOrgCode();
		orgCode = orgCode.substring(0, 6);
		JcjCshpz cshpz = jcjEditDao.queryCshpzByXzqh(orgCode);
		String currentTime = DateUtils.getSystemDateTimeString();
		if (cshpz != null) {
			String url = "http://10.78.17.238:9999/lbs?";
			String urlParameter = "operation=AlarmConfirm&content=";
			String content = "{\"data\":[{\"MSGID\":\""
					+ cshpz.getMsgid()
					+ "\",\"MSGTYPE\":\""
					+ cshpz.getMsgtype()
					+ "\","
					+ "\"MSGSENDER\":\"警综平台\",\"MSGRECEIVER\":\"110系统\",\"MSGDATATIME\":\""
					+ currentTime + "\",\"EVENTID\":\"" + entity.getJjbh()
					+ "\"," + "\"CONFTIME\":\"" + currentTime
					+ "\",\"ORGSEATNO\":\"" + entity.getOrgseatno()
					+ "\",\"CONFNAME\":\"" + sessionBean.getUserName() + "\","
					+ "\"CONFORGID\":\"" + sessionBean.getUserOrgCode()
					+ "\",\"PROCESSID\":\"" + entity.getJjbh() + "\",\"IP\":\""
					+ cshpz.getIp() + "\"}]}";
			try {
				JcjCwrzb  cwrz = new JcjCwrzb();
				cwrz.setJkmc("签收");
				cwrz.setYwbm("JCJ_CJXXB");
				cwrz.setYwid(uuid);
				cwrz.setFwdz(url+urlParameter);
				cwrz.setSendtime(DateUtils.getSystemDateTimeString());
				cwrz.setParameter(content);
				cwrz.setId(UUID.create());
				setSaveProperties(cwrz, sessionBean);
				content = urlParameter
						+ java.net.URLEncoder.encode(content, "UTF-8");
				PostMethod postMethod = new PostMethod(url);
				byte[] b = content.getBytes("utf-8");
				InputStream is = new ByteArrayInputStream(b, 0, b.length);
				RequestEntity re = new InputStreamRequestEntity(is, b.length,
						"application/soap+xml; charset=utf-8");
				postMethod.setRequestEntity(re);
				HttpClient httpClient = new HttpClient();
				HttpConnectionManagerParams managerParams = httpClient
						.getHttpConnectionManager().getParams();
				managerParams.setConnectionTimeout(50000);
				int statusCode = httpClient.executeMethod(postMethod);
				if (statusCode == 200) {
					logger.debug("调用成功！");
					String soapResponseData = postMethod
							.getResponseBodyAsString();
					JSONObject jb = JSONObject.fromObject(soapResponseData);
					JSONArray ja = jb.getJSONArray("data");
					String cgbz = ja.getJSONObject(0).getString("result");
					if("F".equals(cgbz)){//判断成功标志
						cwrz.setSuccesstype("1");
						cwrz.setStatuscode(String.valueOf(statusCode));
						cwrz.setSfcxcw("1");
						jcjEditDao.insertJkCwrzb(cwrz);
					}
					logger.debug(soapResponseData);
				} else {
					//调用程序失败
					cwrz.setSuccesstype("0");
					cwrz.setStatuscode(String.valueOf(statusCode));
					cwrz.setSfcxcw("0");
					jcjEditDao.insertJkCwrzb(cwrz);
					logger.debug("调用失败！错误码：" + statusCode);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	public void updateCjxxb(JcjCjxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		jcjEditDao.updateCjxxb(entity);

	}

	@Override
	public JcjFkxxb queryFkxxbById(String id) {
		// TODO Auto-generated method stub
		return jcjEditDao.queryFkxxbById(id);
	}

	/**
	 * 反馈
	 */
	public void insertFkxxb(JcjFkxxb entity, SessionBean sessionBean) {
		int count = jcjEditDao.queryCountFkxxb(entity.getJjbh());
		count = count + 1;
		String fkws="";
		if(String.valueOf(count).length()==1){
			fkws ="0"+count;
		}else{
			fkws =String.valueOf(count);
		}
		String fkdbh = entity.getJjbh() + "5" + fkws;
		entity.setFkdbh(fkdbh);
		entity.setFkdwdm(sessionBean.getUserOrgCode());
		entity.setFkjy_xm(sessionBean.getUserName());
		entity.setFkjybh(sessionBean.getUserId());
		String uuid=UUID.create();
		entity.setId(uuid);
		setSaveProperties(entity, sessionBean);
		jcjEditDao.insertFkxxb(entity);
		// 调用接口开始

		JcjJjxxb jjxxb = jcjEditDao.queryJcjjjxxbByJJXBH(entity.getJjbh());// 接警信息

		JcjCjxxb cjxxb = jcjEditDao.queryJcjxxbById(entity.getJjbh());// 处警信息
		if (jjxxb != null) {
			String orgCode = sessionBean.getUserOrgCode();
			orgCode = orgCode.substring(0, 6);
			JcjCshpz cshpz = jcjEditDao.queryCshpzByXzqh(orgCode);
			String currentTime = DateUtils.getSystemDateTimeString();
			if (cshpz != null) {
				String url = "http://10.78.17.238:9999/lbs?";
				String urlParameter = "operation=FeedbackPolicePlatform&content=";
				String content = "{\"data\":[{\"MSGID\":\""
						+ cshpz.getMsgid()
						+ "\",\"MSGTYPE\":\""
						+ cshpz.getMsgtype()
						+ "\",\"MSGSENDER\":\"警综平台\","
						+ "\"MSGRECEIVER\":\"110系统\",\"MSGDATATIME\":\""
						+ currentTime
						+ "\",\"SEX\":\""
						+ jjxxb.getBjr_xbdm()
						+ "\",\"EVENTLEVEL\":\""
						+ jjxxb.getEventlevel()
						+ "\","
						+ "\"FEEDCONTENT\":\"\",\"ACTIONCARNUM\":\"\",\"CALLTIME\":\""
						+ jjxxb.getBj_sj()
						+ "\",\"INCEPTTYPE\":\""
						+ jjxxb.getLhlxdm()
						+ "\","
						+ "\"NUMBER2\":\"\",\"TELNUM\":\""
						+ jjxxb.getBj_lxdh()
						+ "\",\"NUMBER1\":\""
						+ entity.getJz_rs()
						+ "\",\"ACTIONNUM\":\"\","
						+ "\"ARVTIME\":\""
						+ entity.getDdxc_sj()
						+ "\",\"CONTENT\":\""
						+ jjxxb.getBjnr()
						+ "\",\"CALLADDRESS\":\"\",\"DISPOSITIONRESULT\":\""
						+ entity.getJqcl_jg()
						+ "\","
						+ "\"ORGSEATNO\":\""
						+ jjxxb.getOrgseatno()
						+ "\",\"NUMBER3\":\"\",\"CALLNAME\":\""
						+ jjxxb.getBjdhyh_xm()
						+ "\",\"ACTIONNAME\":\"\","
						+ "\"ACTIONSAILNUM\":\"\",\"CASETYPE\":\""
						+ jjxxb.getJqlxdm()
						+ "\",\"FEEDBACKORGID\":\""
						+ entity.getFkdwdm()
						+ "\",\"EVENTID\":\""
						+ entity.getJjbh()
						+ "\","
						+ "\"FEEDBACKTIME\":\""
						+ entity.getFk_sj()
						+ "\",\"FEEDBACKORGNAME\":\""
						+ sessionBean.getUserOrgName()
						+ "\",\"STATIONHOUSECODE\":\""
						+ sessionBean.getUserOrgCode()
						+ "\",\"FEEDBACKNAME\":\""
						+ sessionBean.getUserName()
						+ "\","
						+ "\"BRUISENUM\":\""
						+ entity.getSs_rs()
						+ "\",\"ECONOMYLOSS\":\""
						+ entity.getJjssqk()
						+ "\",\"DIENUM\":\""
						+ entity.getSw_rs()
						+ "\",\"PERSONNUM\":\""
						+ entity.getZh_rs()
						+ "\","
						+ "\"ACTIONTIME\":\""
						+ cjxxb.getCj_sj()
						+ "\",\"CASEADDRESS\":\""
						+ jjxxb.getJqdzxz()
						+ "\",\"CASEKIND\":\""
						+ jjxxb.getCasekind()
						+ "\",\"ALARMSOURCE\":\""
						+ jjxxb.getBjfsdm()
						+ "\","
						+ "\"CASEPORT\":\""
						+ jjxxb.getJqlbdm()
						+ "\",\"STATIONHOUSE\":\"\",\"CALLS\":\""
						+ jjxxb.getBjr_xm()
						+ "\",\"EVENTDETAIL1\":\"\","
						+ "\"EVENTDETAIL2\":\"\",\"EVENTDETAIL3\":\"\",\"EVENTDETAIL4\":\"\",\"EVENTDETAIL5\":\"\","
						+ "\"FEEDBACKID\":\"" + entity.getFkdbh()
						+ "\",\"PROCESSID\":\"" + entity.getJjbh()
						+ "\",\"IP\":\"" + cshpz.getIp() + "\"}]}";
				try {
					JcjCwrzb  cwrz = new JcjCwrzb();
					cwrz.setJkmc("反馈");
					cwrz.setYwbm("JCJ_FKXXB");
					cwrz.setYwid(uuid);
					cwrz.setFwdz(url+urlParameter);
					cwrz.setSendtime(DateUtils.getSystemDateTimeString());
					cwrz.setParameter(content);
					cwrz.setId(UUID.create());
					setSaveProperties(cwrz, sessionBean);
					content = urlParameter
							+ java.net.URLEncoder.encode(content, "UTF-8");
					PostMethod postMethod = new PostMethod(url);
					byte[] b = content.getBytes("utf-8");

					InputStream is = new ByteArrayInputStream(b, 0, b.length);
					RequestEntity re = new InputStreamRequestEntity(is,
							b.length, "application/soap+xml; charset=utf-8");
					postMethod.setRequestEntity(re);
					// 最后生成一个HttpClient对象，并发出postMethod请求
					HttpClient httpClient = new HttpClient();
					int statusCode = httpClient.executeMethod(postMethod);
					if (statusCode == 200) {
						logger.debug("调用成功！");
						String soapResponseData = postMethod
								.getResponseBodyAsString();
						JSONObject jb = JSONObject.fromObject(soapResponseData);
						JSONArray ja = jb.getJSONArray("data");
						String cgbz = ja.getJSONObject(0).getString("result");
						if("F".equals(cgbz)){//判断成功标志
							cwrz.setSuccesstype("1");
							cwrz.setStatuscode(String.valueOf(statusCode));
							cwrz.setSfcxcw("1");
							jcjEditDao.insertJkCwrzb(cwrz);
						}
						logger.debug(soapResponseData);
					} else {
						//调用程序失败
						cwrz.setSuccesstype("0");
						cwrz.setStatuscode(String.valueOf(statusCode));
						cwrz.setSfcxcw("0");
						jcjEditDao.insertJkCwrzb(cwrz);
						
						logger.debug("调用失败！错误码：" + statusCode);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		}
		// 调用接口结束
		JcjCjxxb cj = new JcjCjxxb();// 处警信息
		cj.setJqztdm("08");
		cj.setJjbh(entity.getJjbh());
		jcjEditDao.updateCjxxb(cj);

	}

	@Override
	public void updateFkxxb(JcjFkxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		jcjEditDao.updateFkxxb(entity);
	}

	@Override
	public List<JcjFkxxb> fankuixx_query(Map<String, Object> map) {
		return jcjEditDao.queryJcjfkxxbByJjbh(map.get("jjbh").toString());
	}

	/**
	 * 新增警情信息
	 */
	public void insertJjxxb(JcjJjxxb entity, SessionBean sessionBean) {

		JcjJjxxb jjxxb = new JcjJjxxb();
		jjxxb.setJjbh(entity.getJjbh());
		List<JcjJjxxb> list = jcjEditDao.queryJcjjjxxb(jjxxb);
		if (list.size() > 0 && list != null) {// 判断这条警情编号是否存在，存在就注销
			BaseService.setCrossoutProperties(entity, sessionBean);
			jcjEditDao.cancelJjxxb(entity);
		}
		entity.setId(UUID.create());
		setSaveProperties(entity, sessionBean);
		jcjEditDao.insertJjxxb(entity);
		// 动态推送开始
	/*	JSONObject messageJson = new JSONObject();
		messageJson.element("type", "1");
		messageJson.element("entity", entity);
		Map coultMap = new HashMap();
		coultMap.put("sendType", "2");
		coultMap.put("sendCode", sessionBean.getUserOrgCode());
		coultMap.put("sendMsg", messageJson);
		coultMap.put("callback", "DtjqBackFunc");
		SendWebSocket sendWebSocket = new SendWebSocket();
		sendWebSocket.shendMessage(coultMap);*/
		// 动态推送结束

	}

	@Override
	public void insertCshpzb(JcjCshpz entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity, sessionBean);
		jcjEditDao.insertCshpzb(entity);

	}

	@Override
	public void updateCshpzb(JcjCshpz entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		jcjEditDao.updateCshpz(entity);

	}

	@Override
	public JcjCshpz queryCshpzByXzqh(String district) {
		// TODO Auto-generated method stub
		return jcjEditDao.queryCshpzByXzqh(district);
	}

	@Override
	public JcjJjxxb queryJcjjjxxbByJJXBH(String jjbh) {
		// TODO Auto-generated method stub
		return jcjEditDao.queryJcjjjxxbByJJXBH(jjbh);
	}

	@Override
	public void sqveZjjxx(jcjSaveVo jcjvo, SessionBean sessionBean) {
		jcjvo.getJcjjjxxb().setStationhousecode(sessionBean.getUserOrgCode());
		jcjvo.getJcjjjxxb().setStationhouse(sessionBean.getUserOrgName());
		String orgCode = sessionBean.getUserOrgCode();
		orgCode = orgCode.substring(0, 6);
		JcjCshpz cshpz = jcjEditDao.queryCshpzByXzqh(orgCode);
		String currentTime = DateUtils.getSystemDateTimeString();
		String id=UUID.create();
		if (cshpz != null) {
			/*String url = "http://10.78.17.238:9999/lbs?";
			String urlParameter = "operation=AlarmFormPolicePlatform&content=";
			String content = "{\"data\":[{\"MSGID\":\""
					+ cshpz.getMsgid()
					+ "\",\"MSGTYPE\":\""
					+ cshpz.getMsgtype()
					+ "\","
					+ "\"MSGSENDER\":\"警综平台\",\"MSGRECEIVER\":\"110系统\",\"MSGDATATIME\":\""
					+ currentTime + "\",\"EVENTID\":\""+id+"\"," + "\"ALARMTYPE\":\""
					+ 110 + "\",\"CALLTIME\":\"" + currentTime
					+ "\",\"TELNUM\":\"" + jcjvo.getJcjjjxxb().getBjr_lxdh()
					+ "\"," + "\"INCEPTTYPE\":\"\",\"SEX\":\""
					+ jcjvo.getJcjjjxxb().getBjr_xbdm() + "\","
					+ "\"CASETYPE\":\"\",\"CASEPORT\":\""
					+ jcjvo.getJcjfkxxb().getJqlbdm() + "\",\"CASEADDRESS\":\""
					+ jcjvo.getJcjjjxxb().getJqdzxz() + "\","
					+ "\"PROCESSNAME\":\"" + sessionBean.getUserName()
					+ "\",\"CONTENT\":\"" + jcjvo.getJcjjjxxb().getBjnr()
					+ "\",\"ALARMSOURCE\":\"" + jcjvo.getJcjjjxxb().getBjfsdm()
					+ "\"," + "\"PROCESSID\":\"\",\"STATIONHOUSECODE\":\""
					+ sessionBean.getUserOrgCode() + "\",\"STATIONHOUSE\":\""
					+ sessionBean.getUserOrgName() + "\",\"IP\":\""
					+ cshpz.getIp() + "\"," + "\"CALLNAME\":\""
					+ jcjvo.getJcjjjxxb().getBjdhyh_xm()
					+ "\",\"CALLADDRESS\":\""
					+ jcjvo.getJcjjjxxb().getBjdhyhdz() + "\",\"CALLS\":\""
					+ jcjvo.getJcjjjxxb().getBjr_xm() + "\"}]}";*/
			try {
			/*	content = urlParameter
						+ java.net.URLEncoder.encode(content, "UTF-8");
				PostMethod postMethod = new PostMethod(url);
				byte[] b = content.getBytes("utf-8");

				InputStream is = new ByteArrayInputStream(b, 0, b.length);
				RequestEntity re = new InputStreamRequestEntity(is, b.length,
						"application/soap+xml; charset=utf-8");
				postMethod.setRequestEntity(re);
				HttpClient httpClient = new HttpClient();
				int statusCode = httpClient.executeMethod(postMethod);
				if (statusCode == 200) {
					logger.debug("调用成功！");
					String soapResponseData = postMethod
							.getResponseBodyAsString();
					logger.debug(soapResponseData);
				} else {
					logger.debug("调用失败！错误码：" + statusCode);
				}*/

				// 默认接警单编号
				jjbh = jjbh + 1;
				// 保存接警信息
				jcjvo.getJcjjjxxb().setId(UUID.create());
				jcjvo.getJcjjjxxb().setGxdwdm(sessionBean.getUserOrgCode());
				jcjvo.getJcjjjxxb().setJjbh(String.valueOf(jjbh));
				setSaveProperties(jcjvo.getJcjjjxxb(), sessionBean);
				jcjEditDao.insertJjxxb(jcjvo.getJcjjjxxb());
				// 动态推送开始
				JSONObject messageJson = new JSONObject();
				messageJson.element("type", "1");
				messageJson.element("entity", jcjvo.getJcjjjxxb());
				Map coultMap = new HashMap();
				coultMap.put("sendType", "2");
				coultMap.put("sendCode", sessionBean.getUserOrgCode());
				coultMap.put("sendMsg", messageJson);
				coultMap.put("callback", "DtjqBackFunc");
				SendWebSocket sendWebSocket = new SendWebSocket();
				sendWebSocket.shendMessage(coultMap);
				// 动态推送结束

				// 保存处警信息表
				
				  String cjid= UUID.create(); jcjvo.setJcjcjxxb(new
				  JcjCjxxb()); String cjdbh = jjbh+"301";
				  jcjvo.getJcjcjxxb().setCjdbh(cjdbh);
				  jcjvo.getJcjcjxxb().setId(cjid);
				  jcjvo.getJcjcjxxb().setQszt("1");
				  jcjvo.getJcjcjxxb().setJqztdm("03");
				  jcjvo.getJcjcjxxb().setCjdwdm(sessionBean.getUserOrgCode());
				  jcjvo.getJcjcjxxb().setCj_jybh(sessionBean.getUserId());
				  jcjvo.getJcjcjxxb().setCjy_xm(sessionBean.getUserName());
				  jcjvo.getJcjcjxxb().setJjbh(String.valueOf(jjbh));
				  setSaveProperties(jcjvo.getJcjcjxxb(), sessionBean);
				  jcjEditDao.insertCjxxb(jcjvo.getJcjcjxxb()); //保存反馈信息表 
				  int count = 0; count = count +1; 
				  String fkdbh = jjbh+"5"+count;
				  jcjvo.getJcjfkxxb().setJjbh(String.valueOf(jjbh));
				  jcjvo.getJcjfkxxb().setFk_sj(DateUtils.getSystemDateTimeString());
				  jcjvo.getJcjfkxxb().setFkdbh(fkdbh);
				  jcjvo.getJcjfkxxb().setFkdwdm(sessionBean.getUserOrgCode());
				  jcjvo.getJcjfkxxb().setFkjy_xm(sessionBean.getUserName());
				  jcjvo.getJcjfkxxb().setFkjybh(sessionBean.getUserId());
				  jcjvo.getJcjfkxxb().setId(UUID.create());
				  setSaveProperties(jcjvo.getJcjfkxxb(), sessionBean);
				  jcjEditDao.insertFkxxb(jcjvo.getJcjfkxxb());
				 
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}


	/**
	 * 查询接警信息表列表
	 */
	public List<JcjJjxxb> queryJcjjjxxb(JcjJjxxb JcjJjxxb) {
		// TODO Auto-generated method stub
		return jcjEditDao.queryJcjjjxxb(JcjJjxxb);
	}

}
