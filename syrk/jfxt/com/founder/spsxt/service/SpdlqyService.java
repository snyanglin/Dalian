package com.founder.spsxt.service;

import java.util.Map;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.spsxt.bean.Spdlqy;
import com.founder.tzgg.bean.Sys_Tzggb;


@TypeAnnotation("视频地理区域")
public interface SpdlqyService {

	@MethodAnnotation(value = "视频地理区域", type = logType.query)
	public Spdlqy querySpdlqy();
	
	/**
	 * 查询列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	@MethodAnnotation(value = "查询")
	public EasyUIPage queryList(EasyUIPage page,Map map);
	
	@MethodAnnotation(value = "通过id查询")
	public Spdlqy queryById(String id);
	
	@MethodAnnotation(value = "新增区域", type = logType.insert)
	public void save(Spdlqy entity, SessionBean sessionBean);
	
	@MethodAnnotation(value = "更新区域")
	public void update(Spdlqy entity, SessionBean sessionBean);
	
	public String getParentCode(String policecode);
	public String getCode(String policecode);
	public Integer checkSameName(Map map);
}
