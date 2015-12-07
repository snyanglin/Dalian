package com.founder.drools.base.zdry.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.drools.core.request.DroolsRequest;
import com.founder.drools.core.request.RuleBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.config.SystemConfig;

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
	
	@Resource(name = "droolsRequest")
	private DroolsRequest droolsRequest;
	
	
	
	/**
	 * 
	 * @Title: getKlglx
	 * @Description: TODO(根据已列管类型查可列管类型，取交集)
	 * @param @param ylglxStr 已列管类型，如："01,02"
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws Exception 
	 * @throw
	 */
	public String getKlglx(String ylglxStr) throws Exception{
		String[] ylglxAry=ylglxStr.split(",");		
		List<String> klgList;
		String klgStr;
		RuleBean ruleBean;
		
		Map<String, String> klgMap=new HashMap<String, String>();
		for(int i=0;i<ylglxAry.length;i++){
			if(i>0){//已查询有可列管的类型
				if(klgMap.size()==0)//已不能再列管其他类型
					break;
				
				ruleBean=droolsRequest.requestDroolsServer(SystemConfig.getString(AppConst.XZQH)+"_ZDRY_KTSLGLX", ylglxAry[i], null);
				if(ruleBean.getResStatus()==1){
					throw new RuntimeException("Drools Exception:"+ruleBean.getResponse());			
				}
				klgList = (List<String>) ruleBean.getResponse();
					
				if(klgList!=null){
					Map<String, String> tempMap=new HashMap<String, String>();//临时存储可列管类型的交集
					for(int j=0;j<klgList.size();j++){
						klgStr=klgList.get(j);
						if(klgMap.get(klgStr)!=null){//可列管此类型，是交集
							tempMap.put(klgStr,klgStr);
						}
					}
					klgMap=tempMap;//保存最新可列管的类型
				}
				
			}else{//还没有可列管类型，所以本次查询结果全都可列管
				ruleBean=droolsRequest.requestDroolsServer(SystemConfig.getString(AppConst.XZQH)+"_ZDRY_KTSLGLX", ylglxAry[i], null);
				if(ruleBean.getResStatus()==1){
					throw new RuntimeException("Drools Exception:"+ruleBean.getResponse());			
				}
				klgList = (List<String>) ruleBean.getResponse();
				if(klgList!=null){
					for(int j=0;j<klgList.size();j++){
						klgStr=klgList.get(j);
						klgMap.put(klgStr,klgStr);
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
	 * @throws Exception 
	 * @throw
	 */
	public String getKcglx(String zdrylxdm) throws Exception{
		RuleBean ruleBean=droolsRequest.requestDroolsServer(SystemConfig.getString(AppConst.XZQH)+"_ZDRY_CGLX", zdrylxdm, null);
		if(ruleBean.getResStatus()==1){
			throw new RuntimeException("Drools Exception:"+ruleBean.getResponse());			
		}
		List<String> list = (List<String>) ruleBean.getResponse();
				
		if(list!=null){
			Map<String, String> tempMap=new HashMap<String, String>();//临时存储可撤管类型
			String kcgStr;
			for(int j=0;j<list.size();j++){
				kcgStr=list.get(j);				
				tempMap.put(kcgStr,kcgStr);				
			}
			String kcglxStr=tempMap.keySet().toString();
			kcglxStr=kcglxStr.replaceAll(",", "|");
			kcglxStr=kcglxStr.replaceAll(" ", "");
			return kcglxStr.substring(1,kcglxStr.length()-1);
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
		
		try {
			RuleBean ruleBean = droolsRequest.requestDroolsServer(SystemConfig.getString(AppConst.XZQH)+"_ZDRY_SFKZL", zdrylxdm, null);
			if(ruleBean.getResStatus()==1){
				throw new RuntimeException("Drools Exception:"+ruleBean.getResponse());			
			}
			return "0".equals(ruleBean.getResponse());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
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
		try {
			RuleBean ruleBean = droolsRequest.requestDroolsServer(SystemConfig.getString(AppConst.XZQH)+"_ZDRY_SFSLG", zdrylxdm, null);
			if(ruleBean.getResStatus()==1){
				throw new RuntimeException("Drools Exception:"+ruleBean.getResponse());			
			}
			if("0".equals(ruleBean.getResponse())){//双列管
				return "2";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "1";
	}
	
	/**
	 * 
	 * @Title: getZdryMessage
	 * @Description: TODO(获取消息标题和内容)
	 * @param @param xxlx
	 * @param @param param
	 * @param @return
	 * @param @throws Exception    设定文件
	 * @return Map    返回类型
	 * @throw
	 */
	public Map<String,Object> getZdryMessage(String xxlx, Object param) throws Exception{
		
		RuleBean ruleBean = droolsRequest.requestDroolsServer(SystemConfig.getString(AppConst.XZQH)+"_ZDRY_MESSAGE", xxlx, param);
		if(ruleBean.getResStatus()==1){
			throw new RuntimeException("Drools Exception:"+ruleBean.getResponse());			
		}
		Map<String,Object> resMap=(Map) ruleBean.getResponse();
		return resMap;
	}
	
	public RuleBean validateZdryVO(Object paramObj) throws Exception{
		RuleBean ruleBean=droolsRequest.requestDroolsServer(SystemConfig.getString(AppConst.XZQH)+"_ZDRY_VALIDATION", "ZdryVO", paramObj);
		return ruleBean;					
	}
}
