package com.founder.zdrygl.base.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.annotation.RestfulAnnotation;
import com.founder.framework.base.controller.BaseController;
import com.founder.zdrygl.core.inteface.SysMessageInfoService;
import com.founder.zdrygl.core.model.SysMessage;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.controller.RuleTestController.java]  
 * @ClassName:    [RuleTestController]   
 * @Description:  [规则引擎测试控制器]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年10月14日 下午2:34:49]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年10月14日 下午2:34:49，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Controller
@RequestMapping("rule")
public class RuleTestController extends BaseController {					
	
	@Resource(name="sysMessageInfoService")
	private SysMessageInfoService zdryMessageService;		
	
	/**
	 * 
	 * @Title: test
	 * @Description: TODO(规则引擎测试)
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throw
	 */
	@RestfulAnnotation(serverId="3")
	@RequestMapping(value = "/test", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView test(){			
		ModelAndView mv = new ModelAndView("zdrygl/ruleTest");
		//sessionBean = getSessionBean(sessionBean);
		List list=new LinkedList();
		//通过规则引擎获取消息
		Map<String, String> paraMap = new HashMap<String, String>();
		paraMap.put("zdryXm","测试姓名");
		paraMap.put("zdrylx","重点人员类型");
		paraMap.put("fsrUserCode","210203194703112293");
		paraMap.put("fsrOrgCode","210204410102");
		paraMap.put("fsrName","发送人姓名");
		 
		SysMessage sysMessage = zdryMessageService.initSysMessage("LGSQ", paraMap);
		Map<String, Object> lgsq = new HashMap();
		lgsq.put("title", sysMessage.getXxbt());
		lgsq.put("contents", sysMessage.getXxnr());
		lgsq.put("rule", "LGSQ");
		list.add(lgsq);		
		
		sysMessage = zdryMessageService.initSysMessage("CGSQ", paraMap);
		Map<String, Object> CGSQ = new HashMap();
		CGSQ.put("title", sysMessage.getXxbt());
		CGSQ.put("contents", sysMessage.getXxnr());
		CGSQ.put("rule", "CGSQ");
		list.add(CGSQ);
		
		paraMap.put("spjg","1");
		sysMessage = zdryMessageService.initSysMessage("LGSPJG", paraMap);
		Map<String, Object> LGSPJG = new HashMap();
		LGSPJG.put("title", sysMessage.getXxbt());
		LGSPJG.put("contents", sysMessage.getXxnr());
		LGSPJG.put("rule", "LGSPJG_SPTG");
		list.add(LGSPJG);
		
		paraMap.put("spjg","0");
		sysMessage = zdryMessageService.initSysMessage("LGSPJG", paraMap);
		Map<String, Object> LGSPJG2 = new HashMap();
		LGSPJG2.put("title", sysMessage.getXxbt());
		LGSPJG2.put("contents", sysMessage.getXxnr());
		LGSPJG2.put("rule", "LGSPJG_SPBTG");
		list.add(LGSPJG2);
		
		mv.addObject("List",list);		
		return mv;
	
	}		
}
