package com.founder.framework.newmain.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.organization.right.service.OrgRightPublic;

@Controller
@RequestMapping("/newmain")
public class newmain extends BaseController {
	private Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(value = "/getaccord", method = RequestMethod.GET)
	public ModelAndView addOrEditjhyxswjbxxb(){
		SessionBean sessionBean = getSessionBean();
		String userid = sessionBean.getUserId();
		
		OrgRightPublic orgRightPublic = new OrgRightPublic();
		Object json = orgRightPublic.getUserMenuJson(userid,"",false);
		ModelAndView mv = new ModelAndView("newmain/main_lefttest");
		mv.addObject("jsondata",json);
		return mv;
		
	}
	
	/**
	 * 
	 * @Title: checkSubSystemUsable
	 * @Description: TODO(服务启动验证)
	 * @param @param checkUrl 验证系统的URL
	 * @param @param tagId 菜单标签的ID,返回给js用
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throw
	 */
	@RequestMapping(value = "/checkSubSystemUsable", method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Map<String, String> checkSubSystemUsable(String checkUrl,String tagId){	
		Map<String, String> map=new HashMap<String, String>();
		map.put("status", "systemNotStarted");
		map.put("tagId", tagId);
		
		try {
			/*******************************************************************
			 * 创建与网关的HTTP连接，发送认证请求报文，并接收认证响应报文*
			 ******************************************************************/
			/** *  创建与网关的HTTP连接 ** 开始 * */
			int statusCode = 500;
			HttpClient httpClient =  new HttpClient();
			httpClient.setTimeout(10000);
			httpClient.setConnectionTimeout(10000);
			GetMethod method = new GetMethod(checkUrl);
			//设置报文传送的编码格式
			method.setRequestHeader("Content-Type","text/xml;charset=UTF-8");	
			
				/** * 发送通讯报文与网关通讯 ** 开始 * */
			statusCode = httpClient.executeMethod(method);				
				/** *  发送通讯报文与网关通讯 ** 结束 * */
				
			if (statusCode == HttpStatus.SC_OK
					|| statusCode == HttpStatus.SC_INTERNAL_SERVER_ERROR) {
					
				String res=method.getResponseBodyAsString();
				if("systemStarted".equals(res)){					
					map.put("status", "systemStarted");						
				}
					
			}
		} catch (Exception e) {
			//e.printStackTrace();
			logger.info("Cannot connect to URL:"+checkUrl);
		}
			
	    return map;
	}
	
	@RequestMapping(value = "/checkSubSystemUsableWeb", method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String checkSubSystemUsableWeb(){
		return "systemStarted";//已启动		
	}
}
