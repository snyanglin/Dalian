package com.founder.sydw_dl.service;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.sydw_dl.bean.DwzybwXxb;

@TypeAnnotation("重要部位信息")
public interface DwZyBwService {

	/**
	 * 重要部位信息保存
	 * @param entity
	 */
	@MethodAnnotation(value = "新增重要部位信息", type = logType.insert)
	public void save(DwzybwXxb entity, SessionBean sessionBean);

	/**
	 * 重要部位信息修改
	 * @param entity
	 */
	@MethodAnnotation(value = "修改重要部位信息", type = logType.update)
	public void update(DwzybwXxb entity, SessionBean sessionBean);
	/**
	 * 查询单条,重要部位信息
	 * @param entity
	 * @return
	 */
	@MethodAnnotation(value = "查询重要部位信息", type = logType.query)
	public DwzybwXxb queryZybw(DwzybwXxb entity, SessionBean sessionBean);
	
	
	@MethodAnnotation(value = "验证联系方式是否有效", type = logType.query)
	public boolean queryLxfsValid(String lxdh, String dwid);
}
