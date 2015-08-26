package com.founder.sydw.service;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.sydw.bean.Gxxxb;

@TypeAnnotation("高校信息")
public interface GxxxbService {
	
	
	public Gxxxb queryGxxxbByRyid(Gxxxb entity);
	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void saveGxxxb(Gxxxb entity, SessionBean sessionBean);
	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "更新", type = logType.update)
	public void updateGxxxb(Gxxxb entity, SessionBean sessionBean);
	
}
