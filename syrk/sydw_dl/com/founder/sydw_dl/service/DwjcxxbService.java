package com.founder.sydw_dl.service;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.sydw_dl.bean.Dwjcxxb;

@TypeAnnotation("单位检查信息")
public interface DwjcxxbService {
	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void save(Dwjcxxb entity, SessionBean sessionBean);
	/**
	 * 修改<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "修改", type = logType.update)
	public void update(Dwjcxxb entity, SessionBean sessionBean);	
	/**
	 * 查询单条<br>
	 * 
	 * @param entity
	 * @return
	 */
	public Dwjcxxb query(Dwjcxxb entity);

}
