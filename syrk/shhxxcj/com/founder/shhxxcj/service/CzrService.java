package com.founder.shhxxcj.service;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.shhxxcj.bean.CzrhsCzqkdjxxb;
import com.founder.shhxxcj.bean.LesseeJZs;
import com.founder.shhxxcj.bean.LesseeZZs;

public interface CzrService {

	
	/**
	 * @Title: queryList
	 * @Description: 查询列表
	 * @param @param entity
	 * @param @param page
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryList(LesseeZZs entity, EasyUIPage page,SessionBean sessionBean);
	
	/**
	 * @Title: updateLesseeZZs
	 * @Description: 更新列表
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void updateLesseeZZs(LesseeZZs entity, SessionBean sessionBean);
	
	/**
	 * 
	 * @Title: updateLesseeJZs
	 * @Description: 更新
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void updateLesseeJZs(LesseeJZs entity, SessionBean sessionBean);


	/**
	 * 根基id查询
	 * @Title: queryLesseeZZsById
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param id
	 * @param @return    设定文件
	 * @return Houses    返回类型
	 * @throws
	 */
	public LesseeZZs queryLesseeZZsById(String id);
	
	
	/**
	 * 根据id查询
	 * @Title: queryLesseeJZsById
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param id
	 * @param @return    设定文件
	 * @return LesseeJZs    返回类型
	 * @throws
	 */
	public LesseeJZs queryLesseeJZsById(String id);

	
	
	/**
	 * 保存出租房屋核实信息
	 * @Title: saveCzfwhs
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param fwjbxxb
	 * @param @param czfwxxb    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void saveCzrhs(CzrhsCzqkdjxxb entity,SessionBean sessionBean);
}
