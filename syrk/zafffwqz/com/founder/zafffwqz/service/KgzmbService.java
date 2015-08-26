package com.founder.zafffwqz.service;

import java.util.Map;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zafffwqz.bean.Kgzmb;

@TypeAnnotation("空挂证明")
public interface KgzmbService {
	@MethodAnnotation(value = "空挂证明", type = logType.query)
	public Kgzmb queryKgzmb(Kgzmb entity);
	
	@MethodAnnotation(value = "新增空挂证明", type = logType.insert)
	public void saveKgzmb(Kgzmb entity, SessionBean sessionBean);
	
	@MethodAnnotation(value = "修改空挂证明", type = logType.update)
	public void updateKgzmb(Kgzmb entity, SessionBean sessionBean);
	
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
	 * 注销空挂证明信息
	 * @return
	 */
	public void delete(Kgzmb entity, SessionBean sessionBean);

}
