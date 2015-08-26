package com.founder.zafffwqz.service;

import java.util.Map;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zafffwqz.bean.Tjxxzb;


@TypeAnnotation("调解信息")
public interface TjxxzbService {
	
	@MethodAnnotation(value = "调解信息", type = logType.query)
	public Tjxxzb queryTjxxzb(Tjxxzb entity);
	
	@MethodAnnotation(value = "新增调解信息", type = logType.insert)
	public void saveTjxxzb(Tjxxzb entity, SessionBean sessionBean);
	
	@MethodAnnotation(value = "修改调解信息", type = logType.update)
	public void updateTjxxzb(Tjxxzb entity, SessionBean sessionBean);
	
	/**
	 * 注销调解信息信息
	 * @return
	 */
	public void delete(Tjxxzb entity, SessionBean sessionBean);
	
	/**
	 * 查询列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	@MethodAnnotation(value = "查询")
	public EasyUIPage queryList(EasyUIPage page,Map map);
}
