package com.founder.zdrygl.base.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.organization.user.service.OrgUserService;
import com.founder.zdrygl.base.dao.ZdryZdryZbDao;
import com.founder.zdrygl.base.model.ZdryGlMessageBean;
import com.founder.zdrygl.core.inteface.RuleService;
import com.founder.zdrygl.core.inteface.ZdryglMessageService;


@Service("zdryglMessageService")
public class ZdryglMessageServiceImpl implements ZdryglMessageService{

	@Autowired
	private ZdryZdryZbDao zdryZdryZbDao;
	
	@Resource(name = "orgUserService")
	private OrgUserService orgUserService;
	
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;
	
	@Autowired
	private RuleService ruleService;
	
	@Override
	public Map<String, Object> getTitleAndContents(String xxlx, Map<String, String> paraMap) {				
		
		//私有参数处理
		ZdryGlMessageBean bean = new ZdryGlMessageBean();
        bean.setXxlx(xxlx);
        bean.setParaMap(paraMap);
        
        //公共参数处理
        Map globalParam=new HashMap();
        globalParam.put("zdryZdryZbDao", zdryZdryZbDao);
        
        //执行规则
		ruleService.executeRule("zdryMessageRule", bean, globalParam);
		
		Map map = bean.getResultMap();//规则执行后，bean的成员变量值已修改
        
		return map;
	}

	@Override
	public Map<String, Object> getReceiverAndReceiveType(String xxlx, Map<String, String> paraMap) {
		// TODO Auto-generated method stub
		return null;
	}

}
