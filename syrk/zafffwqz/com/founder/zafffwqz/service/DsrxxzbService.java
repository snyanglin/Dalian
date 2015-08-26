package com.founder.zafffwqz.service;
import java.util.Map;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zafffwqz.bean.Dsrxxzb;

@TypeAnnotation("当事人信息")
public interface DsrxxzbService {
	
	@MethodAnnotation(value = "当事人信息", type = logType.query)
	public Dsrxxzb queryDsrxxzb(Dsrxxzb entity);
	
	@MethodAnnotation(value = "新增当事人信息", type = logType.insert)
	public void saveDsrxxzb(Dsrxxzb entity, SessionBean sessionBean);
	
	@MethodAnnotation(value = "修改当事人信息", type = logType.update)
	public void updateDsrxxzb(Dsrxxzb entity, SessionBean sessionBean);
	
	/**
	 * 注销当事人信息信息
	 * @return
	 */
	public void delete(Dsrxxzb entity, SessionBean sessionBean);
	
	/**
	 * 查询列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	@MethodAnnotation(value = "查询")
	public EasyUIPage queryList(EasyUIPage page,Map map);
	
}
