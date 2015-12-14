package com.founder.zafffwqz.service;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.zafffwqz.bean.Bazzb;

@TypeAnnotation("保安组织")
public interface BazzbService {

	@MethodAnnotation(value = "查询保安组织", type = logType.query)
	public Bazzb queryBazzb(Bazzb entity);
	@MethodAnnotation(value = "新增保安组织", type = logType.insert)
	public void saveBazzb(Bazzb entity, SessionBean sessionBean);
	@MethodAnnotation(value = "修改保安组织", type = logType.update)
	public void updateBazzb(Bazzb entity, SessionBean sessionBean);
	


}
