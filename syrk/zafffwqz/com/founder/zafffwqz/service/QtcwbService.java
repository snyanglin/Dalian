package com.founder.zafffwqz.service;

import java.util.Map;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zafffwqz.bean.Qtcwb;



@TypeAnnotation("其它宠物")
public interface QtcwbService {
	@MethodAnnotation(value = "其它宠物", type = logType.query)
	public Qtcwb queryQtcwb(Qtcwb entity);
	
	@MethodAnnotation(value = "新增其它宠物", type = logType.insert)
	public void saveQtcwb(Qtcwb entity, SessionBean sessionBean);
	
	@MethodAnnotation(value = "修改其它宠物", type = logType.update)
	public void updateQtcwb(Qtcwb entity, SessionBean sessionBean);
	
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
	 * 注销其它宠物信息
	 * @return
	 */
	public void delete(Qtcwb entity, SessionBean sessionBean);
	
	
}
