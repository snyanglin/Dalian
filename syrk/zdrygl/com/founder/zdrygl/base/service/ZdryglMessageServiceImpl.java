package com.founder.zdrygl.base.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.drools.KnowledgeBase;
import org.drools.runtime.StatefulKnowledgeSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.organization.user.service.OrgUserService;
import com.founder.zdrygl.base.dao.ZdryZdryZbDao;
import com.founder.zdrygl.base.model.ZdryGlMessageBean;
import com.founder.zdrygl.core.inteface.ZdryglMessageService;
import com.founder.zdrygl.core.utils.DroolsUtils;

@Service("zdryglMessageService")
public class ZdryglMessageServiceImpl implements ZdryglMessageService{

	@Autowired
	private ZdryZdryZbDao zdryZdryZbDao;
	
	@Resource(name = "orgUserService")
	private OrgUserService orgUserService;
	
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;
	
	@Override
	public Map<String, Object> getTitleAndContents(String xxlx, Map<String, String> paraMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			KnowledgeBase kbase = DroolsUtils.buildKnowledgeBaseByUrl("http://localhost:8090/guvnor/rest/packages/com.founder.zdrygl.message/binary", null, null);
            //KnowledgeBase kbase = DroolsUtils.buildKnowledgeBaseByResource("title_and_contents.drl");			            
            StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
            
            //将工具类作为全局变量，导入规则引擎中
            ksession.setGlobal("zdryZdryZbDao", zdryZdryZbDao);
            //因实际使用中，用户难以运维，放弃下面两个工具类的引入
//            ksession.setGlobal("orgUserService", orgUserService);
//            ksession.setGlobal("orgOrganizationService", orgOrganizationService);
            
            //构建规则引擎数据源对象
            ZdryGlMessageBean bean = new ZdryGlMessageBean();
            bean.setXxlx(xxlx);
            bean.setParaMap(paraMap);
            
            //将数据源插入工作区
            ksession.insert(bean);
            //触发规则引擎
            ksession.fireAllRules();
            ksession.dispose();
            
            map = bean.getResultMap();
        } catch (Throwable t) {
            t.printStackTrace();
        }
		
		return map;
	}

	@Override
	public Map<String, Object> getReceiverAndReceiveType(String xxlx, Map<String, String> paraMap) {
		// TODO Auto-generated method stub
		return null;
	}

}
