package com.founder.framework.portal;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.utils.PropertitiesManagement;

/**
 * ****************************************************************************
 * @Package:      [com.founder.framework.portal.PKIRandomController.java]  
 * @ClassName:    [PKIRandomController]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [weiwen]   
 * @CreateDate:   [2014-12-24 上午10:31:25]   
 * @UpdateUser:   [weiwen(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2014-12-24 上午10:31:25，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Controller
public class PKIRandomController extends BaseController{
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	private String tempURL = PropertitiesManagement.getResouceString("randomPage") ,
			propertiesURL =  PropertitiesManagement.getResouceString("propertiesURL");

	private Properties props = null;

	/** 认证地址 */
	private final String KEY_AUTHURL = "authURL";

	/** 应用标识 */
	private final String KEY_APP_ID = "appId";


	@RequestMapping("/random")
	public ModelAndView random(HttpServletResponse response) throws Exception{
		ModelAndView mv = new ModelAndView(tempURL);

		// 设置页面不缓存
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		try{
			String parentPath = getSession().getServletContext().getRealPath("/WEB-INF");
			InputStream in = new FileInputStream(parentPath + "/" + propertiesURL);
			props = new Properties();
			props.load(in);
			this.setProperties(KEY_APP_ID,getSession());
			this.setProperties(KEY_AUTHURL,getSession());
		}catch(Exception e){
			logger.error("从配置文件中获得应用标识，网关地址，认证方式发生异常", e);
			System.out.println("从配置文件中获得应用标识，网关地址，认证方式发生异常");
		}

		String randNum = generateRandomNum();
		if (randNum == null || randNum.trim().equals("")) {
			System.out.println("证书认证数据不完整！");
			throw new Exception("证书认证数据不完整！");
		}

		/**************************
		 * 第三步 服务端返回认证原文   *
		 **************************/
		// 设置认证原文到session，用于程序向后传递，通讯报文中使用
		getSession().setAttribute("original_data", randNum);

		// 设置认证原文到页面，给页面程序提供参数，用于产生认证请求数据包
		getRequest().setAttribute("original", randNum);

		// 设置跳转页面
		//	request.getRequestDispatcher(tempURL).forward(request, response);

		// 产生认证原文

		return mv;
	}
	/**
	 * 产生认证原文
	 */
	private String generateRandomNum() {
		/**************************
		 * 第二步 服务端产生认证原文   *
		 **************************/
		String num = "1234567890abcdefghijklmnopqrstopqrstuvwxyz";
		int size = 6;
		char[] charArray = num.toCharArray();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < size; i++) {
			sb
			.append(charArray[((int) (Math.random() * 10000) % charArray.length)]);
		}
		return sb.toString();
	}

	/**
	 * 获取文件中的属性值
	 * @param httpSession 
	 */
	private String   setProperties(String key, HttpSession httpSession) {

		httpSession.setAttribute(key,props.get(key) == null ? null : (String) props.get(key) );
		return props.get(key) == null ? null : (String) props.get(key);
	}
}
