package com.founder.zdrygl.base.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.zdrygl.base.dao.ZdryZdryZbDao;
import com.founder.zdrygl.base.model.ZdryGlMessageBean;
import com.founder.zdrygl.core.inteface.RuleService;
import com.founder.zdrygl.core.inteface.ZdryglMessageService;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.service.ZdryglMessageServiceImpl.java]  
 * @ClassName:    [ZdryglMessageServiceImpl]   
 * @Description:  [规则引擎例子，参数处理]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年10月20日 上午10:48:58]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年10月20日 上午10:48:58，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("zdryglMessageService")
public class ZdryglMessageServiceImpl implements ZdryglMessageService{

	@Autowired
	private ZdryZdryZbDao zdryZdryZbDao;		
	
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

}
