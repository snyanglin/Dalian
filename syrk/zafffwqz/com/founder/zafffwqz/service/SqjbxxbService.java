package com.founder.zafffwqz.service;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.zafffwqz.bean.Sqjbxxb;

@TypeAnnotation("社区基本信息表")
public interface SqjbxxbService {
	
	@MethodAnnotation(value = "新增社区基本信息表", type = logType.insert)
	public void saveSqjbxxb(Sqjbxxb entity, SessionBean sessionBean);
	
	@MethodAnnotation(value = "查询社区基本信息表", type = logType.query)
	public Sqjbxxb querySqjbxxb(Sqjbxxb entity);
	
	@MethodAnnotation(value = "修改社区基本信息表", type = logType.update)
	public int updateSqjbxxb(Sqjbxxb entity, SessionBean sessionBean);
	
	public Sqjbxxb querrBySqjwsid(String sqjwsid);
	

}
