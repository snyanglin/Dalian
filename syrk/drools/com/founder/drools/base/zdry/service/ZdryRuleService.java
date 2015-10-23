package com.founder.drools.base.zdry.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.drools.base.zdry.model.ZdryGlMessageBean;
import com.founder.drools.core.inteface.RuleService;
import com.founder.zdrygl.base.dao.ZdryZdryZbDao;

/**
 * ****************************************************************************
 * @Package:      [com.founder.drools.base.zdry.service.ZdryRuleService.java]  
 * @ClassName:    [ZdryRuleService]   
 * @Description:  [重点人员规则调用服务]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年10月21日 下午5:17:58]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年10月21日 下午5:17:58，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service
public class ZdryRuleService {
	
	public static String LGSQ="LGSQ";//列管申请
	public static String CGSQ="CGSQ";//撤管申请
	public static String LGSPJG="LGSPJG";	
	
	@Autowired
	private ZdryZdryZbDao zdryZdryZbDao;		
	
	@Autowired
	private RuleService ruleService;
	
	/**
	 * 
	 * @Title: getTitleAndContents
	 * @Description: TODO(重点人员消息规则获取)
	 * @param @param xxlx 消息类型
	 * @param @param paraMap
	 * @param @return    设定文件
	 * @return Map<String,Object>    返回类型
	 * @throw
	 */
	public Map<String, Object> getTitleAndContents(String xxlx, Map<String, String> paraMap) {				
		
		//私有参数处理
		ZdryGlMessageBean bean = new ZdryGlMessageBean();
        bean.setXxlx(xxlx);
        bean.setParaMap(paraMap);
        
        //公共参数处理
        Map<String,Object> globalParam = new HashMap<String,Object>();
        globalParam.put("zdryZdryzbDao", zdryZdryZbDao);
        
        //执行规则
		ruleService.executeRule("zdryMessageRule", bean, globalParam);
		
		Map<String, Object> map = bean.getResultMap();//规则执行后，bean的成员变量值已修改
        
		return map;
	}	
}
