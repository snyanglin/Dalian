package com.founder.zdrygl.base.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.operationLog.service.OperationLogService;
import com.founder.zdrygl.core.inteface.ZdryglMessageService;

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
	
	@Resource(name="zdryglMessageService")
	private ZdryglMessageService zdryglMessageService;				
	
	/**
	 * 
	 * @Title: test
	 * @Description: TODO(规则引擎测试)
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throw
	 */
	@RequestMapping(value = "/test", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView test(SessionBean sessionBean){		
		ModelAndView mv = new ModelAndView("zdrygl/ruleTest");
		sessionBean = getSessionBean(sessionBean);
		List list=new LinkedList();
		//通过规则引擎获取消息
		Map<String, String> paraMap = new HashMap<String, String>();
		paraMap.put("zdryXm","测试姓名");
		paraMap.put("zdrylx","重点人员类型");
		paraMap.put("fsrUserCode",sessionBean.getUserId());
		paraMap.put("fsrOrgCode",sessionBean.getUserOrgCode());
		Map<String, Object> lgsq = zdryglMessageService.getTitleAndContents("LGSQ", paraMap);
		lgsq.put("rule", "LGSQ");
		list.add(lgsq);		
		
		Map<String, Object> LGSPJG = zdryglMessageService.getTitleAndContents("LGSPJG", paraMap);
		LGSPJG.put("rule", "LGSQ");
		list.add(LGSPJG);
		
		Map<String, Object> CGSQ = zdryglMessageService.getTitleAndContents("CGSQ", paraMap);
		CGSQ.put("rule", "CGSQ");
		list.add(CGSQ);
		
		Map<String, Object> CGSPJG = zdryglMessageService.getTitleAndContents("CGSPJG", paraMap);
		CGSPJG.put("rule", "CGSPJG");
		list.add(CGSPJG);
		
		Map<String, Object> ZDSQ = zdryglMessageService.getTitleAndContents("ZDSQ", paraMap);
		ZDSQ.put("rule", "ZDSQ");
		list.add(ZDSQ);
		
		Map<String, Object> JSZD = zdryglMessageService.getTitleAndContents("JSZD", paraMap);
		JSZD.put("rule", "JSZD");
		list.add(JSZD);
		
		Map<String, Object> BJSZD = zdryglMessageService.getTitleAndContents("BJSZD", paraMap);
		BJSZD.put("rule", "BJSZD");
		list.add(BJSZD);
		
		Map<String, Object> SJCDJG = zdryglMessageService.getTitleAndContents("SJCDJG", paraMap);
		SJCDJG.put("rule", "SJCDJG");
		list.add(SJCDJG);
		
		Map<String, Object> ZLSQ = zdryglMessageService.getTitleAndContents("ZLSQ", paraMap);
		ZLSQ.put("rule", "ZLSQ");
		list.add(ZLSQ);
		
		Map<String, Object> ZLSPJG = zdryglMessageService.getTitleAndContents("ZLSPJG", paraMap);
		ZLSPJG.put("rule", "ZLSPJG");
		list.add(ZLSPJG);
		
		mv.addObject("List",list);		
		return mv;
	
	}		
}
