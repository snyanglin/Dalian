package com.founder.zdrygl.base.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.framework.base.service.BaseService;
import com.founder.framework.config.SystemConfig;
import com.founder.zdrygl.base.dao.ZdryGzbDao;
import com.founder.zdrygl.base.model.ZdryGzb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.service.ZdryGzService.java]  
 * @ClassName:    [ZdryGzService]   
 * @Description:  [重点人员规则服务]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年9月28日 上午10:07:42]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年9月28日 上午10:07:42，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */

@Service("zdryGzService")
public class ZdryGzService  extends BaseService {
	@Resource(name="zdryGzbDao")
	private ZdryGzbDao zdryGzbDao;	
	
	/**
	 * 
	 * @Title: queryKcglx
	 * @Description: TODO(查询可撤管类型)
	 * @param @param zdrylxdm 重点人员类型
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throw
	 */
	public String queryKcglx(String zdrylxdm){
		ZdryGzb zdryGzb=zdryGzbDao.queryByZdrylx(zdrylxdm,SystemConfig.getString("systemXzqh")==""?"210000":SystemConfig.getString("systemXzqh"));
		if(zdryGzb!=null) return zdryGzb.getCglx();
		return null;
	}
	
	/**
	 * 
	 * @Title: queryIsZL
	 * @Description: TODO(查询是否可转类)
	 * @param @param zdrylxdm
	 * @param @return    设定文件
	 * @return boolean    返回类型
	 * @throw
	 */
	public boolean queryIsZL(String zdrylxdm){
		ZdryGzb zdryGzb=zdryGzbDao.queryByZdrylx(zdrylxdm,SystemConfig.getString("systemXzqh")==""?"210000":SystemConfig.getString("systemXzqh"));
		if(zdryGzb!=null && "0".equals(zdryGzb.getSfkzl())){//可转类
			return true;
		}
		return false;
	} 
	
	/**
	 * 
	 * @Title: queryKlglx
	 * @Description: TODO(根据已列管类型查可列管类型，取交集)
	 * @param @param ylglxStr 已列管类型，如："01,02"
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throw
	 */
	public String queryKlglx(String ylglxStr){
		String[] ylglxAry=ylglxStr.split(",");		
		String queryStr;
		String[] queryAry;
		ZdryGzb zdryGzb;
		Map map=new HashMap();
		for(int i=0;i<ylglxAry.length;i++){
			zdryGzb=zdryGzbDao.queryByZdrylx(ylglxAry[i],SystemConfig.getString("systemXzqh")==""?"210000":SystemConfig.getString("systemXzqh"));
			if(zdryGzb!=null){
				queryStr=zdryGzb.getTslglx();//同时可列管的类型
				if(queryStr==null) continue;
				queryAry=queryStr.split(",");
				if(i>0){//已查询有可列管的类型
					if(map.size()==0)//已不能再列管其他类型
						break;
					if(queryAry.length>0){
						Map tempMap=new HashMap();//临时存储可列管类型的交集
						for(int j=0;j<queryAry.length;j++){
							if(map.get(queryAry[j])!=null){//可列管此类型，是交集
								tempMap.put(queryAry[j], true);//该类型可列管
							}
						}
						
						//保存最新可列管的类型
						map=tempMap;
					}
				}else{//还没有可列管类型，所以本次查询结果全都可列管
					for(int j=0;j<queryAry.length;j++){	
						map.put(queryAry[j],true);//该类型可列管										
					}
				}
				
				
			}
		}		
		String klglxStr=map.keySet().toString();
		klglxStr=klglxStr.replaceAll(",", "|");
		klglxStr=klglxStr.replaceAll(" ", "");
		return klglxStr.substring(1,klglxStr.length()-1);
	}
}
