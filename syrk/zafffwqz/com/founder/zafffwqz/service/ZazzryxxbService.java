package com.founder.zafffwqz.service;

import java.util.Map;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zafffwqz.bean.Zazzryxxb;

@TypeAnnotation("治安组织人员信息")
public interface ZazzryxxbService {
	/**
	 * 查询单条治安组织人员信息
	 * @param entity
	 * @return
	 */
	@MethodAnnotation(value = "查询治安组织人员信息", type = logType.query)
	public Zazzryxxb queryZazzryxxb(Zazzryxxb entity);
	
	/**
	 * 插入治安组织人员信息
	 * @param entity
	 * @param sessionBean
	 */
	@MethodAnnotation(value = "插入治安组织人员信息", type = logType.insert)
	public void saveZazzryxxb(Zazzryxxb entity,SessionBean sessionBean);
	
	/**
	 * 更新治安组织人员信息
	 * @param entity
	 * @param sessionBean
	 */
	@MethodAnnotation(value = "更新治安组织人员信息", type = logType.update)
	public void updateZazzryxxb(Zazzryxxb entity,SessionBean sessionBean);
	
	/**
	 * 注销治安组织人员信息
	 * @param entity
	 * @param sessionBean
	 */
	@MethodAnnotation(value = "注销治安组织人员信息", type = logType.delete)
	public void deleteZazzryxxb(Zazzryxxb entity,SessionBean sessionBean);
	
	/**
	 * 查询集合治安组织人员信息
	 * @param page
	 * @param map
	 * @return
	 */
	@MethodAnnotation(value = "查询集合", type = logType.query)
	public EasyUIPage queryList(EasyUIPage page,Map map);
	
}
