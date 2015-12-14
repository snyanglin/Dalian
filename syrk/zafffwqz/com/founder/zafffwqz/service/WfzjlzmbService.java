package com.founder.zafffwqz.service;

import java.util.List;
import java.util.Map;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zafffwqz.bean.Wfzjlzmb;

@TypeAnnotation("无犯罪记录证明")
public interface WfzjlzmbService {
	@MethodAnnotation(value = "查询无犯罪记录证明单条", type = logType.query)
	public Wfzjlzmb queryWfzjlzmb(Wfzjlzmb entity);
	@MethodAnnotation(value = "新增无犯罪记录证明", type = logType.insert)
	public void saveWfzjlzmb(Wfzjlzmb entity, SessionBean sessionBean);
	@MethodAnnotation(value = "修改无犯罪记录证明", type = logType.update)
	public void updateWfzjlzmb(Wfzjlzmb entity, SessionBean sessionBean);
	@MethodAnnotation(value = "查询无犯罪记录证明集合", type = logType.query)
	public List<Wfzjlzmb> queryWfzjlzmbList(Map map);
	@MethodAnnotation(value = "注销无犯罪记录证明", type = logType.update)
	public void removeWfzjlzmb(Wfzjlzmb entity, SessionBean sessionBean);
	public EasyUIPage queryList(EasyUIPage page, Map map);

}
