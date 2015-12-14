package com.founder.zafffwqz.service;

import java.util.List;
import java.util.Map;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zafffwqz.bean.Cszmb;

@TypeAnnotation("出生证明")
public interface CszmbService {
	
	@MethodAnnotation(value = "出生证明", type = logType.query)
	public Cszmb queryCszmb(Cszmb entity);
	
	@MethodAnnotation(value = "新增出生证明", type = logType.insert)
	public void saveCszmb(Cszmb entity, SessionBean sessionBean);
	
	@MethodAnnotation(value = "修改出生证明", type = logType.update)
	public void updateCszmb(Cszmb entity, SessionBean sessionBean);
	
	/**
	 * 查询列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	@MethodAnnotation(value = "查询")
	public EasyUIPage queryList(EasyUIPage page,Map map);
	
	
	/**
	 * 注销出生证明信息
	 * @return
	 */
	public void delete(Cszmb entity, SessionBean sessionBean);
	
	public List<Cszmb> queryRyCs(String zjhm);
}
