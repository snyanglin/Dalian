package com.founder.zafffwqz.service;

import java.util.Map;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zafffwqz.bean.Qsgxrzb;
import com.founder.zafffwqz.bean.Qsgxzmb;
import com.founder.zafffwqz.bean.Wfzjlzmb;

@TypeAnnotation("亲属关系证明")
public interface QsgxzmbService {

	@MethodAnnotation(value = "查询集合")
	public EasyUIPage queryList(EasyUIPage page, Map map);
	@MethodAnnotation(value = "查询亲属关系证明", type = logType.query)
	public Qsgxzmb queryQsgxzmb(Qsgxzmb entity);
	@MethodAnnotation(value = "新增亲属关系证明", type = logType.insert)
	public void saveQsgxzmb(Qsgxzmb entity, SessionBean sessionBean);
	@MethodAnnotation(value = "注销亲属关系证明", type = logType.update)
	public void removeQsgxzmb(Qsgxzmb entity,Qsgxrzb qsgxrzb, SessionBean sessionBean);
	@MethodAnnotation(value = "新增亲属关系", type = logType.insert)
	public void saveQsgxrzb(Qsgxrzb entity, SessionBean sessionBean);
	@MethodAnnotation(value = "查询亲属集合")
	public EasyUIPage queryQsList(EasyUIPage page, Map map);

	
}
