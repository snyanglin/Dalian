package com.founder.spsxt.dao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.founder.framework.base.dao.BaseDaoImpl;




@Component(value="nameValuePairDao")  //��mzDao��ע�뵽bean����
public class NameValuePairDao extends BaseDaoImpl {

	
	//通用方法
	public List getNameValueByCondition(Map paramMap){
		String name=(String)paramMap.get("name");//表别名
		String statementName="getOrganizationByCondition";
		//增加下面的else if语句
		if(name.equalsIgnoreCase("XZQH"))//行政区划
			statementName="getXzqhByCondition";
		else if(name.equalsIgnoreCase("ORG"))//组织机构
			statementName="getOrgCodeNameByCondition";

		else if(name.equalsIgnoreCase("AREA"))//地理区域
			statementName="getAreaByCondition";			
		
		return queryForList("NameValuePair."+statementName,paramMap);
	}
	
	
	//根据条件(如编码,拼音等)模糊查询
	public List getOrgCodeNameByCondition(Map paramMap){
		return queryForList("NameValuePair.getOrgCodeNameByCondition",paramMap);
	}
	//获得建设单位id,dwmc列表
	public List getSpdwIdNameByCondition(Map paramMap){
		return queryForList("NameValuePair.getSpdwIdNameByCondition",paramMap);
	}
		
	//根据机构代码查找其所在父级树路径， 返回值,形如：_210200000000_210200200000_210200200600_
	public String getParentTreePathByOrgCode(String orgCode){
		//形如：_210200000000_210200200000_210200200600_
		return (String)super.queryForObject("NameValuePair.getParentTreePathByOrgCode",orgCode);

	}	
	//根据2级机构获得平台名称
	public List getPlatformByOrgCode(String ssOrgCode){
		return queryForList("NameValuePair.getPlatformByOrgCode",ssOrgCode);
	}
	//根据2级机构获得其边界坐标串2014.12.19。
	public String getBjzbzByOrgCode(String ssOrgCode){
		return (String)queryForObject("NameValuePair.getBjzbzByOrgCode",ssOrgCode);
	}
	//得到摄像头统计值
	public List getSxtStatistic(Map paramMap){
		return queryForList("NameValuePair.getSxtStatistic",paramMap);
	}
	
 	//根据机构代码获得计数值作为当前摄像头的编号	
	synchronized public int getCurrentCounterValue(String orgCode){
		update("NameValuePair.updateCounterValue", orgCode);
		return (Integer) super.queryForObject("NameValuePair.getCurrentCounterValue",orgCode);
		
	}	
}


