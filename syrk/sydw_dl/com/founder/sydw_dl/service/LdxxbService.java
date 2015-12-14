package com.founder.sydw_dl.service;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.sydw_dl.bean.Ldxxb;

@TypeAnnotation("旅馆信息表")
public interface LdxxbService {
	
	@MethodAnnotation(value = "新增旅馆信息表", type = logType.insert)
	public void saveLdxxb(Ldxxb entity, SessionBean sessionBean);
	
	@MethodAnnotation(value = "查询旅馆信息表", type = logType.query)
	public Ldxxb queryLdxxb(Ldxxb entity);
	
	@MethodAnnotation(value = "修改旅馆信息表", type = logType.update)
	public int updateLdxxb(Ldxxb entity, SessionBean sessionBean);

}
