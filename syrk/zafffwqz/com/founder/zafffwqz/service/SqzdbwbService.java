package com.founder.zafffwqz.service;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.zafffwqz.bean.Sqzdbwb;

@TypeAnnotation("社区重点部位表")
public interface SqzdbwbService {
	
	@MethodAnnotation(value = "新增社区重点部位表", type = logType.insert)
	public void saveSqzdbwb(Sqzdbwb entity, SessionBean sessionBean);
	
	@MethodAnnotation(value = "查询社区重点部位表", type = logType.query)
	public Sqzdbwb querySqzdbwb(Sqzdbwb entity);
	
	@MethodAnnotation(value = "修改社区重点部位表", type = logType.update)
	public int updateSqzdbwb(Sqzdbwb entity, SessionBean sessionBean);

}
