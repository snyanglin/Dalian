package com.founder.framework.newmain.controller;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
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
	
	@RequestMapping(value = "/checkSubSystemUsable", method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String checkSubSystemUsable(String checkUrl){	
		
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
					
			// 执行postMethod
		try {
				/** * 发送通讯报文与网关通讯 ** 开始 * */
			statusCode = httpClient.executeMethod(method);				
				/** *  发送通讯报文与网关通讯 ** 结束 * */
				
			if (statusCode == HttpStatus.SC_OK
					|| statusCode == HttpStatus.SC_INTERNAL_SERVER_ERROR) {
					
				String res=method.getResponseBodyAsString();
				if("systemStarted".equals(res))
						return res;					
					
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	    return "systemNotStarted";//未启动
	}
	
	@RequestMapping(value = "/checkSubSystemUsableWeb", method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String checkSubSystemUsableWeb(){
		return "systemStarted";//已启动		
	}
}
