package com.founder.zafffwqz.service;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.zafffwqz.bean.Sqwyhcyb;

@TypeAnnotation("社区委员会成员表")
public interface SqwyhcybService {
	
	@MethodAnnotation(value = "社区委员会成员表", type = logType.insert)
	public void saveSqwyhcyb(Sqwyhcyb entity, SessionBean sessionBean);
	
	@MethodAnnotation(value = "社区委员会成员表", type = logType.query)
	public Sqwyhcyb querySqwyhcyb(Sqwyhcyb entity);
	
	@MethodAnnotation(value = "社区委员会成员表", type = logType.update)
	public int updateSqwyhcyb(Sqwyhcyb entity, SessionBean sessionBean);
	

}
