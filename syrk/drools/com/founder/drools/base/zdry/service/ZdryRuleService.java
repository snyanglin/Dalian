package com.founder.drools.base.zdry.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.drools.base.zdry.model.ZdryGlMessageBean;
import com.founder.drools.base.zdry.model.ZdryGlOperationInfoBean;
import com.founder.drools.base.zdry.model.ZdryLcgGllxBean;
import com.founder.drools.core.inteface.RuleService;
import com.founder.drools.core.model.RuleBean;
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
	public static String LGSPJG="LGSPJG";//列管审批结果	
	
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
		
		//私有参数
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
	
	/**
	 * 
	 * @Title: getKlglx
	 * @Description: TODO(根据已列管类型查可列管类型，取交集)
	 * @param @param ylglxStr 已列管类型，如："01,02"
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throw
	 */
	public String getKlglx(String ylglxStr){
		String[] ylglxAry=ylglxStr.split(",");
		ZdryLcgGllxBean bean ;
		List<Map<String, String>> klgList;
		Map<String, String> map;
		Map<String, String> klgMap=new HashMap<String, String>();
		for(int i=0;i<ylglxAry.length;i++){
			if(i>0){//已查询有可列管的类型
				if(klgMap.size()==0)//已不能再列管其他类型
					break;
				bean = new ZdryLcgGllxBean();
				bean.setZdryGllxdm(ylglxAry[i]);
				ruleService.executeRule("zdryKlgRule", bean, null);
				klgList = bean.getTslglx();
				if(klgList!=null){
					Map<String, String> tempMap=new HashMap<String, String>();//临时存储可列管类型的交集
					for(int j=0;j<klgList.size();j++){
						map=klgList.get(j);
						if(klgMap.get(map.get("id"))!=null){//可列管此类型，是交集
							tempMap.put(map.get("id"),map.get("text"));
						}
					}
					klgMap=tempMap;//保存最新可列管的类型
				}
				
			}else{//还没有可列管类型，所以本次查询结果全都可列管
				bean = new ZdryLcgGllxBean();
				bean.setZdryGllxdm(ylglxAry[i]);
				ruleService.executeRule("zdryKlgRule", bean, null);
				klgList = bean.getTslglx();
				if(klgList!=null){
					for(int j=0;j<klgList.size();j++){
						map=klgList.get(j);
						klgMap.put(map.get("id"),map.get("text"));
					}
				}
				
				
			}
		}	
		
		String klglxStr=klgMap.keySet().toString();
		klglxStr=klglxStr.replaceAll(",", "|");
		klglxStr=klglxStr.replaceAll(" ", "");
		return klglxStr.substring(1,klglxStr.length()-1);
	}
	
	/**
	 * 
	 * @Title: getKcglx
	 * @Description: TODO(获取可撤管类型)
	 * @param @param zdryGllxdm
	 * @param @return    设定文件
	 * @return List    返回类型
	 * @throw
	 */
	public String getKcglx(String zdrylxdm){
		ZdryLcgGllxBean bean = new ZdryLcgGllxBean();
		bean.setZdryGllxdm(zdrylxdm);
		ruleService.executeRule("zdryKlgRule", bean, null);
		List<Map<String, String>>  list = bean.getCgkzlx();
		if(list!=null){
			Map<String, String> tempMap=new HashMap<String, String>();//临时存储可撤管类型
			Map<String, String> map;
			for(int j=0;j<list.size();j++){
				map=list.get(j);				
				tempMap.put(map.get("id"),map.get("text"));				
			}
			String klglxStr=tempMap.keySet().toString();
			klglxStr=klglxStr.replaceAll(",", "|");
			klglxStr=klglxStr.replaceAll(" ", "");
			return klglxStr.substring(1,klglxStr.length()-1);
		}
		return null;
	}
	
	/**
	 * 
	 * @Title: getSfkzl
	 * @Description: TODO(查询是否可转类)
	 * @param @param zdrylxdm
	 * @param @return    设定文件
	 * @return boolean    返回类型
	 * @throw
	 */
	public boolean getSfkzl(String zdrylxdm){
		ZdryGlOperationInfoBean bean=new ZdryGlOperationInfoBean();
		bean.setZdryGllxdm(zdrylxdm);
		ruleService.executeRule("zdryOperationRule", bean, null);
		return bean.isSfZl();
	}
	
	/**
	 * 
	 * @Title: getLglx
	 * @Description: TODO(获取列管类型，1单列管，2双列管)
	 * @param @param zdrylxdm
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throw
	 */
	public String getLglx(String zdrylxdm){
		ZdryGlOperationInfoBean bean=new ZdryGlOperationInfoBean();
		bean.setZdryGllxdm(zdrylxdm);
		ruleService.executeRule("zdryOperationRule", bean, null);
		return bean.getLglx();
	}
	
	public Map validateZdryVO(RuleBean ruleBean){
		List list=new ArrayList();
		list.add(ruleBean);
		list.add(ruleBean.getParamObj());
		
		ruleService.executeRule("zdryValidation", list, null);
		Map resMap=new HashMap();
        resMap.put("ruleStatus", ruleBean.getResStatus());
        resMap.put("ruleResponse", ruleBean.getResponse());
		return resMap;
	}
}
