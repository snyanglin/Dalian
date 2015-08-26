package com.founder.sydw.service;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.sydw.bean.Jhsgxxb;

@TypeAnnotation("旧货收购信息")
public interface JhsgxxbService {
	
	public Jhsgxxb queryJhsgxxbByRyid(Jhsgxxb entity);
	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void saveJhsgxxb(Jhsgxxb entity, SessionBean sessionBean);
	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "更新", type = logType.update)

	public void updateJhsgxxb(Jhsgxxb entity, SessionBean sessionBean);
}
