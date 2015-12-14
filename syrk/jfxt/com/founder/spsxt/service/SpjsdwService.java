package com.founder.spsxt.service;

import java.util.List;
import java.util.Map;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;

import com.founder.spsxt.bean.Spjsdw;


@TypeAnnotation("视频建设单位")
public interface SpjsdwService {

	@MethodAnnotation(value = "视频建设单位", type = logType.query)
	public Spjsdw querySpjsdwByDwbm(String dwbm);

	
	//根据派出所编码和民警警号查询
	@MethodAnnotation(value = "视频建设单位", type = logType.query)
	public List queryByPcsPoliceId(String pcsbm,String policeId);
	
	public List getGazjByDw(String dwbm);
	
	
	//根据部门id查询其下的所有建设单位
	public List queryByBmid(Map paramMap);
	
	@MethodAnnotation(value = "视频建设单位", type = logType.insert)
	public void insertSpjsdw(Spjsdw entity, SessionBean sessionBean);
	
	@MethodAnnotation(value = "视频建设单位")//千万别加属性type = logType.update!!	
	public void updateSpjsdw(Spjsdw entity, SessionBean sessionBean);
	
	//根据主键删除
	@MethodAnnotation(value = "视频建设单位", type = logType.delete)//, type = logType.delete
	public String deleteSpjsdwByDwbm(String dwbm);
	
	/**
	 * 分页查询<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	@MethodAnnotation(value = "查询")
	public EasyUIPage queryList(EasyUIPage page,Map map);
	/**
	 * 通用分页查询<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	@MethodAnnotation(value = "查询")
	public EasyUIPage queryListByBmid(EasyUIPage page,Map map);	
	
	public Integer checkSameName(Map map);

	
	//根据派出所编码、民警警号和拼音查询(为视监控系统提供下拉列表内容)
	public List getDepartmentBasicInfoByPy(String pcsbm,String policeId,String py);
	//根据单位id查询其详细信息2014.11.7.
	public List getDepartmentInfoByDwId(String dwId);
	//全局范围检查视频单位的唯一性
	public Integer isUniqueForSpjsdw(String dwbm);
}
