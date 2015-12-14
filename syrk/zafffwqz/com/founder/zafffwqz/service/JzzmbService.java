package com.founder.zafffwqz.service;

import java.util.Map;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zafffwqz.bean.Jzzmb;

@TypeAnnotation("居住证明")
public interface JzzmbService {
	@MethodAnnotation(value = "居住证明", type = logType.query)
	public Jzzmb queryJzzmb(Jzzmb entity);
	
	@MethodAnnotation(value = "新增居住证明", type = logType.insert)
	public void saveJzzmb(Jzzmb entity, SessionBean sessionBean);
	
	@MethodAnnotation(value = "修改居住证明", type = logType.update)
	public void updateJzzmb(Jzzmb entity, SessionBean sessionBean);
	
	/**
	 * 查询列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	@MethodAnnotation(value = "查询")
	public EasyUIPage queryList(EasyUIPage page,Map map);
	
	
	/**
	 * 注销居住证明信息
	 * @return
	 */
	public void delete(Jzzmb entity, SessionBean sessionBean);

}
