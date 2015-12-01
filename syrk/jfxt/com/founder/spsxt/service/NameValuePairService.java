package com.founder.spsxt.service;


import java.util.List;
import java.util.Map;

import com.founder.framework.annotation.TypeAnnotation;




@TypeAnnotation("NameValue")
public interface NameValuePairService {
	
	public List getOrgCodeNameByCondition(Map paramMap);

	//获得建设单位id,dwmc列表
	public List getSpdwIdNameByCondition(Map paramMap);
	
	public List getNameValueByCondition(Map paramMap);
	
	//根据机构代码查找其所在的2级部门(大连市公安局为第1级),返回值为空，说明本级为大连市公安局，否则为orgCode所在的2级部门
	public String get2LevelDepartByOrgCode(String orgCode);
	
	//根据2级机构获得平台名称
	public List getPlatformByOrgCode(String ssOrgCode);
	//根据2级机构获得其边界坐标串2014.12.19。
	public String getBjzbzByOrgCode(String ssOrgCode);	
	//得到摄像头统计值
	public List getSxtStatistic(Map paramMap);
	
	//根据分局代码获得计数值作为当前摄像头的编号	
	public int getCurrentCounterValue(String orgCode);	
}
