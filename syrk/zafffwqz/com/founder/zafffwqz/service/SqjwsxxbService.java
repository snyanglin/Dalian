package com.founder.zafffwqz.service;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.zafffwqz.bean.Sqjwsxxb;
import com.founder.zafffwqz.bean.Sqjwszrqglxxb;
@TypeAnnotation("社区警务室录入")
public interface SqjwsxxbService {

	@MethodAnnotation(value = "查询社区警务室", type = logType.query)
	public Sqjwsxxb querySqjwsxxb(Sqjwsxxb entity);
	@MethodAnnotation(value = "新增社区警务室", type = logType.insert)
	public void saveSqjwsxxb(Sqjwsxxb entity, SessionBean sessionBean);
	@MethodAnnotation(value = "修改社区警务室", type = logType.update)
	public void updateSqjwsxxb(Sqjwsxxb entity, SessionBean sessionBean);
	@MethodAnnotation(value = "根据责任区查询社区警务室", type = logType.query)
	public Sqjwszrqglxxb queryByZrqdm(Sqjwszrqglxxb entity);
	
}
