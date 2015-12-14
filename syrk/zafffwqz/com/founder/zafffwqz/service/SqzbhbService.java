package com.founder.zafffwqz.service;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.zafffwqz.bean.Sqzbhb;

@TypeAnnotation("社区治保会")
public interface SqzbhbService {
	@MethodAnnotation(value = "查询社区治保会", type = logType.query)
	public Sqzbhb querySqzbhb(Sqzbhb entity);
	@MethodAnnotation(value = "新增社区治保会", type = logType.insert)
	public void saveSqzbhb(Sqzbhb entity, SessionBean sessionBean);
	@MethodAnnotation(value = "修改社区治保会", type = logType.update)
	public void updateSqzbhb(Sqzbhb entity, SessionBean sessionBean);
}
