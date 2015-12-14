package com.founder.spsxt.service;


import java.util.List;
import java.util.Map;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.spsxt.bean.Platform;




@TypeAnnotation("视频平台")
public interface PlatformService {


	
	@MethodAnnotation(value = "视频平台", type = logType.insert)
	public void insertPlatform(Platform entity, SessionBean sessionBean);
	
	@MethodAnnotation(value = "视频平台")//千万别加属性type = logType.update!!	
	public void updatePlatform(Platform entity, SessionBean sessionBean);
	//根据主键查询
	@MethodAnnotation(value = "视频平台", type = logType.query)
	public Platform queryPlatformById(String id);
	//根据主键删除
	@MethodAnnotation(value = "视频平台", type = logType.delete)//, type = logType.delete
	public String deletePlatformById(String id);
	
	/**
	 * 分页查询<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	@MethodAnnotation(value = "查询")
	public EasyUIPage pageQueryByCondition(EasyUIPage page,Map map);

	//获得平台名称和id(为NVR提供下拉列表内容)
	public List getPlatformNameAndId(String ssOrgCode);
	//检查平台名称是否全局唯一.唯一,返回true
	public int isUniqueForPlatformName(String ptmc);
}
