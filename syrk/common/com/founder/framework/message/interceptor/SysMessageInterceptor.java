package com.founder.framework.message.interceptor;

import java.net.URL;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.WebUtils;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.config.SystemConfig;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.message.webservice.ITipInfoWebService;
import com.founder.framework.message.webservice.TipBean;
import com.founder.framework.message.webservice.TipInfoWebServiceImplService;



@Aspect
public class SysMessageInterceptor {
	private Logger logger = Logger.getLogger(this.getClass());
	
	/**
	 * 
	 * @Title: sysMessagePoint
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param     设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@Pointcut("execution(* com.founder.framework.message.dao.*.*(..))")
	public void sysMessagePoint() {
	}
	
	/**
	 * 
	 * @Title: afterPoint
	 * @Description: (这里用一句话描述这个方法的作用)
	 * @param @param jp    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@AfterReturning(value = "sysMessagePoint()")
	public void afterPoint(JoinPoint jp) {
		Object[] args = jp.getArgs();// 取得方法调用所有的参数
		String methodName = jp.getSignature().getName();// 取得切面的方法名称、
		if (methodName.indexOf("saveMessage") != -1) {
			for (int i = 0; i < args.length; i++) {
				if (args[i] instanceof SysMessage) {
					SysMessage sysMessage= (SysMessage)args[i];
					sysMessageSend(sysMessage);
				}
			}
		}
	}
	
	/**
	 * 
	 * @Title: sysMessageSend
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param sysMessage    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public  void sysMessageSend(SysMessage sysMessage){
		TipInfoWebServiceImplService tip= new TipInfoWebServiceImplService(); 
		ITipInfoWebService ms = tip.getTipInfoWebServiceImplPort(); 
		TipBean tib = new TipBean();  
		tib.setUploadFrom(SystemConfig.getString("systemName"));
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		SessionBean sessionBean = (SessionBean)WebUtils.getSessionAttribute(request, "userSession");
		String ip = sessionBean.getRemoteAddr();
		String userId = sessionBean.getUserId();
		tib.setUploadIP(ip);
		Date now = new Date();
		long time = now.getTime();
		tib.setUploadDate(time);
		tib.setUserID(userId);
//		tib.setUserPKIID(value);
		tib.setTipTitle(sysMessage.getXxbt());
		tib.setTipBigType("1");
		tib.setTipType("1");
//		tib.setTipDate(value);
		String url = "/sysMessage/view?id="+sysMessage.getId();
		tib.setTipURL(url);
		tib.setWinWidth(880);
		tib.setWinHeight(420);
//		String  result = ms.sendTip(tib);
	}
	
	public static void main(String[] args) {
		 //服务WSDL Document的地址  
		URL url;
		try {
			//方法1.
//			url = new URL("http://192.168.175.203:8080/ws/tipInfoWebServiceImpl?wsdl");
//			QName qname=new QName("http://tip.webservice.portal.modules.portal.magic.com/","TipInfoWebServiceImplService");  
//			Service service=Service.create(url, qname);  
//			ITipInfoWebService ms=service.getPort(ITipInfoWebService.class); 
//			System.out.println(ms.testOK("232323"));
//			TipBean tib = new TipBean();
//			tib.setUploadFrom("社区警务");
//			System.out.println(ms.sendTip(tib));
			//方法2.
			System.out.println(System.getProperty("java.endorsed.dirs"));
			System.out.println("1212");
			TipInfoWebServiceImplService tip= new TipInfoWebServiceImplService(); 
			System.out.println("wewe");
			ITipInfoWebService ms = tip.getTipInfoWebServiceImplPort(); 
			System.out.println(ms.testOK("232323"));
			TipBean tib = new TipBean(); 
			tib.setUploadFrom("社区警务"); 
			System.out.println(ms.sendTip(tib));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
}
