package com.founder.sydw_dl.service;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.sydw_dl.bean.XyaqxxbXc;

@TypeAnnotation("校车信息表")
public interface XyaqxxbXcService {
	
	@MethodAnnotation(value = "新增校车信息表", type = logType.insert)
	public void saveXyaqxxbXc(XyaqxxbXc entity, SessionBean sessionBean);
	
	@MethodAnnotation(value = "查询校车信息表", type = logType.query)
	public XyaqxxbXc queryXyaqxxbXc(XyaqxxbXc entity);
	
	@MethodAnnotation(value = "修改校车信息表", type = logType.update)
	public int update(XyaqxxbXc entity, SessionBean sessionBean);

}
