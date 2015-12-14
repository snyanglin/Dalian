package com.founder.shhxxcj.service;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.shhxxcj.bean.EmEnterprises;
import com.founder.sydw_dl.bean.Dwbmxxb;
import com.founder.sydw_dl.bean.Dwjbxxb;

public interface EmEnterprisesService {


	/**
	 * 根基id查询
	 * @Title: queryById
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param id
	 * @param @return    设定文件
	 * @return Houses    返回类型
	 * @throws
	 */
	public EmEnterprises queryById(String id);
	
	
	
	/**
	 * @Title: queryList
	 * @Description: 查询列表
	 * @param @param entity
	 * @param @param page
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryList(EmEnterprises entity, EasyUIPage page,SessionBean sessionBean);
	
	/**
	 * @Title: update
	 * @Description: 更新列表
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void update(EmEnterprises entity, SessionBean sessionBean);
	
	
	/**
	 * 保存实有单位核实
	 * @Title: saveSydwhs
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param dwjbxxb
	 * @param @param enterpriseId
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void saveSydwhs(Dwjbxxb dwjbxxb,String enterpriseId,Dwbmxxb [] dwbmxxbArray,SessionBean sessionBean);

}
