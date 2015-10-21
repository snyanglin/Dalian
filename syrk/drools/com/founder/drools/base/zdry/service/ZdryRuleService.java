package com.founder.drools.base.zdry.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.drools.base.zdry.model.ZdryGlMessageBean;
import com.founder.drools.core.inteface.RuleService;
import com.founder.zdrygl.base.dao.ZdryZdryZbDao;

@Service
public class ZdryRuleService {
	@Autowired
	private ZdryZdryZbDao zdryZdryZbDao;		
	
	@Autowired
	private RuleService ruleService;
	
	public Map<String, Object> getTitleAndContents(String xxlx, Map<String, String> paraMap) {				
		
		//私有参数处理
		ZdryGlMessageBean bean = new ZdryGlMessageBean();
        bean.setXxlx(xxlx);
        bean.setParaMap(paraMap);
        
        //公共参数处理
        Map globalParam=new HashMap();
        globalParam.put("zdryZdryzbDao", zdryZdryZbDao);
        
        //执行规则
		ruleService.executeRule("zdryMessageRule", bean, globalParam);
		
		Map map = bean.getResultMap();//规则执行后，bean的成员变量值已修改
        
		return map;
	}	
}
