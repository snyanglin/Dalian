package com.founder.shhxxcj.service;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.shhxxcj.bean.EmEmployees;
import com.founder.sydw_dl.bean.Cyryxxb;

public interface EmEmployeesService {

	
	/**
	 * @Title: queryList
	 * @Description: 查询列表
	 * @param @param entity
	 * @param @param page
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryList(EmEmployees entity, EasyUIPage page,SessionBean sessionBean);
	
	/**
	 * @Title: update
	 * @Description: 更新列表
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void update(EmEmployees entity, SessionBean sessionBean);
	
	
	/**
	 * 根基id查询
	 * @Title: queryById
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param id
	 * @param @return    设定文件
	 * @return Houses    返回类型
	 * @throws
	 */
	public EmEmployees queryById(String id);

	
	/**
	 * 从业人员核实
	 * @Title: saveCyryhs
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void saveCyryhs(Cyryxxb entity,String emEmployeeId,SessionBean sessionBean);
}
