package com.founder.zafffwqz.service;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.zafffwqz.bean.Sqmjxxb;

@TypeAnnotation("社区民警")
public interface SqmjxxbService {

	@MethodAnnotation(value = "查询社民警", type = logType.query)
	public Sqmjxxb querySqmjxxb(Sqmjxxb entity);
	@MethodAnnotation(value = "新增社民警", type = logType.insert)
	public void saveSqmjxxb(Sqmjxxb entity, SessionBean sessionBean);
	@MethodAnnotation(value = "修改社民警", type = logType.update)
	public void updateSqmjxxb(Sqmjxxb entity, SessionBean sessionBean);

}
