package com.founder.sydw.service;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.sydw.bean.XyaqxxbHxd;

@TypeAnnotation("护校队信息表")
public interface XyaqxxbHxdService {
	
	@MethodAnnotation(value = "新增护校队信息表", type = logType.insert)
	public void saveXyaqxxbHxd(XyaqxxbHxd entity, SessionBean sessionBean);
	
	@MethodAnnotation(value = "查询护校队信息表", type = logType.query)
	public XyaqxxbHxd queryXyaqxxbHxd(XyaqxxbHxd entity);
	
	@MethodAnnotation(value = "修改护校队信息表", type = logType.update)
	public int update(XyaqxxbHxd entity, SessionBean sessionBean);

}
