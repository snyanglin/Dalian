package com.founder.zafffwqz.service;

import java.util.Map;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zafffwqz.bean.Bazzryxxb;

@TypeAnnotation("保安组织人员信息")
public interface BazzryxxbService {
	/**
	 * 查询单条保安组织人员信息
	 * @param entity
	 * @return
	 */
	@MethodAnnotation(value = "查询保安组织人员信息", type = logType.query)
	public Bazzryxxb queryBazzryxxb(Bazzryxxb entity);
	
	/**
	 * 插入保安组织人员信息
	 * @param entity
	 * @param sessionBean
	 */
	@MethodAnnotation(value = "插入保安组织人员信息", type = logType.insert)
	public void saveBazzryxxb(Bazzryxxb entity,SessionBean sessionBean);
	
	/**
	 * 更新保安组织人员信息
	 * @param entity
	 * @param sessionBean
	 */
	@MethodAnnotation(value = "更新保安组织人员信息", type = logType.update)
	public void updateBazzryxxb(Bazzryxxb entity,SessionBean sessionBean);
	/**
	 * 注销保安组织人员信息
	 * @param entity
	 * @param sessionBean
	 */
	@MethodAnnotation(value = "注销保安在组织人员信息", type = logType.delete)
	public void deleteBazzryxxb(Bazzryxxb entity,SessionBean sessionBean);
	/**
	 * 查询集合
	 * @param page
	 * @param map
	 * @return
	 */
	@MethodAnnotation(value = "查询集合",type = logType.query)
	public EasyUIPage queryList(EasyUIPage page,Map map);
	
}
