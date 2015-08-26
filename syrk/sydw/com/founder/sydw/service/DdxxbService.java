package com.founder.sydw.service;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.sydw.bean.Ddxxb;

@TypeAnnotation("典当业信息表")
public interface DdxxbService {
	
	@MethodAnnotation(value = "新增典当业信息表", type = logType.insert)
	public void saveDdxxb(Ddxxb entity, SessionBean sessionBean);
	
	@MethodAnnotation(value = "查询典当业信息表", type = logType.query)
	public Ddxxb queryDdxxb(Ddxxb entity);
	
	@MethodAnnotation(value = "修改典当业信息表", type = logType.update)
	public int updateDdxxb(Ddxxb entity, SessionBean sessionBean);

}
