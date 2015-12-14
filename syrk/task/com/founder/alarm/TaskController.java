package com.founder.alarm;

import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.collections.map.HashedMap;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.utils.DateUtils;
import com.founder.zdrw.bean.Zdzxrwb;
import com.founder.zdrw.bean.Zdzxrwrzb;
import com.cgsoft.util.AuthCode;

@Controller
@RequestMapping("/task")
public class TaskController extends BaseController{
	
	private static final String KEY = "sss";
	private static ObjectMapper mapper = new ObjectMapper();
	
	/**
	 * 应用接口
	 * @param code
	 * @param time
	 * @param docking
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping("/dock")
	public Object dock(String code,Long time,String docking,HttpServletRequest request) {
		Map<String, Object> result = new HashedMap();
		Zdzxrwrzb log = null;
		if(AuthCode.MD5(KEY+time).equals(code)){
			Docking dock = null;
			try {
				Zdzxrwb zdrw = mapper.readValue(docking,Zdzxrwb.class);
				ApplicationContext ctx = ContextLoader.getCurrentWebApplicationContext();
				dock = (Docking)ctx.getBean(zdrw.getRwzxff());
				if(null!=dock && dock instanceof Object){
					log = new Zdzxrwrzb();
					log.setZdzxrwid(zdrw.getId());
					log.setRwmc(zdrw.getRwmc());
					log.setRwzxkssj(DateUtils.getSystemDateTimeString());//开始执行
					Long ms = new Date().getTime();
					result = dock.main(request);
					log.setRwzxwcsj(DateUtils.getSystemDateTimeString());//执行完毕
					log.setRwzxsc(new Date().getTime() - ms);	//执行时长
					log.setRwzxff(zdrw.getRwzxff());	//执行方法
					log.setZxqk(result.get("message").toString());		//执行情况
					log.setSfzxcg(Boolean.parseBoolean(result.get("status").toString())?"1":"0");		//是否成功
					log.setXt_cjsj(DateUtils.getSystemDateTimeString());
					result.put("data",mapper.writeValueAsString(log));
				}
			} catch (Exception e) {
				result.put("data","");
				result.put("message", e.getMessage());
			}finally{
				dock = null;
			}
		}
		return result; 
	}
	
	
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping("/test")
	public Object dock(String docking,HttpServletRequest request) {
		Map<String, Object> result = new HashedMap();
		Docking dock = null;
		try {
			ApplicationContext ctx = ContextLoader.getCurrentWebApplicationContext();
			dock = (Docking)ctx.getBean(docking);
			if(null!=dock && dock instanceof Object){
				result = dock.main(request);
			}
		} catch (Exception e) {
			result.put("data","");
			result.put("message", e.getMessage());
		}finally{
			dock = null;
		}
		return result; 
	}
}
