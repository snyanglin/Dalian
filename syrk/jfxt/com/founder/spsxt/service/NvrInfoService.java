package com.founder.spsxt.service;


import java.util.List;
import java.util.Map;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.spsxt.bean.NvrInfo;





@TypeAnnotation("视频NVR")
public interface NvrInfoService {


	
	@MethodAnnotation(value = "视频NVR", type = logType.insert)
	public void insertNvrInfo(NvrInfo entity, SessionBean sessionBean);
	
	@MethodAnnotation(value = "视频NVR")//千万别加属性type = logType.update!!	
	public void updateNvrInfo(NvrInfo entity, SessionBean sessionBean);
	//根据主键查询
	@MethodAnnotation(value = "视频NVR", type = logType.query)
	public NvrInfo queryNvrInfoById(String id);
	//根据主键删除
	@MethodAnnotation(value = "视频NVR", type = logType.delete)//, type = logType.delete
	public String deleteNvrInfoById(String id);
	
	/**
	 * 分页查询<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	@MethodAnnotation(value = "查询")
	public EasyUIPage pageQueryByCondition(EasyUIPage page,Map map);

	public List getNVRByPt(String dwbm);
	//检查同一平台下设备名称(NVR)是否唯一
	public int isUniqueForPlatformName(Map paramMap);		
}
