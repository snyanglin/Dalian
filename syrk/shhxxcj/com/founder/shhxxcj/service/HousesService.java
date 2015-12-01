package com.founder.shhxxcj.service;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;

import com.founder.shhxxcj.bean.Houses;
import com.founder.syfw.bean.Czfwxxb;
import com.founder.syfw.bean.Fwjbxxb;

public interface HousesService {

	
	/**
	 * @Title: queryList
	 * @Description: 查询列表
	 * @param @param entity
	 * @param @param page
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryList(Houses entity, EasyUIPage page,SessionBean sessionBean);
	
	/**
	 * @Title: update
	 * @Description: 更新列表
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void update(Houses entity, SessionBean sessionBean);

	/**
	 * 根基id查询
	 * @Title: queryById
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param id
	 * @param @return    设定文件
	 * @return Houses    返回类型
	 * @throws
	 */
	public Houses queryById(String id);
	
	
	/**
	 * 保存出租房屋核实信息
	 * @Title: saveCzfwhs
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param fwjbxxb
	 * @param @param czfwxxb    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void saveCzfwhs(Fwjbxxb fwjbxxb,Czfwxxb czfwxxb,String housesId,SessionBean sessionBean);
	
	
	public String queryBzdzById(String id);
}
