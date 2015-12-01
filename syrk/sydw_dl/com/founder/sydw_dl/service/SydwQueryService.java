package com.founder.sydw_dl.service;

import java.util.List;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.sydw_dl.bean.Dwjbxxb;


@TypeAnnotation("实有单位查询")
public interface SydwQueryService {

	/**
	 * 
	 * @param entity
	 * @param sessionBean
	 */
	public void delete(Dwjbxxb entity, SessionBean sessionBean);
	/**
	 * 根据地址代码查询地址列表
	 * @param entity
	 * @return
	 */
	public List<Dwjbxxb> queryDwByDzDm(Dwjbxxb entity);
	/**
	 * 核实列表
	 * @param page
	 * @param entity
	 * @return
	 */
	public EasyUIPage queryDwHs(EasyUIPage page, Dwjbxxb entity);
	
	/**
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	public EasyUIPage queryDw(EasyUIPage page, Dwjbxxb entity);
	/**
	 * 
	 * @param dwids
	 * @return
	 */
	public List<Dwjbxxb> queryZbByDzId(String dwids);
	
	/**
	 * 
	 * @param entity
	 * @param sessionBean
	 * @return
	 */
	public int updateHs(Dwjbxxb entity,SessionBean sessionBean);
	/**
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	public EasyUIPage queryDwDzOnPT(EasyUIPage page, Dwjbxxb entity);
	
	public long queryCountSydw(Dwjbxxb entity) ;
	public long queryCountSydwHs(Dwjbxxb entity) ;
	public long queryCountDw(Dwjbxxb entity);
}
