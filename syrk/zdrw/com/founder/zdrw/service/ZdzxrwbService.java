package com.founder.zdrw.service;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrw.bean.Zdzxrwb;

@TypeAnnotation("自动执行任务")
public interface ZdzxrwbService {
	/**
	 * 查询列表
	 * @param page
	 * @param entity
	 * @return
	 */
	@MethodAnnotation(value = "查询")
	public EasyUIPage queryList(EasyUIPage page,Zdzxrwb entity);
	
	public Zdzxrwb queryZdzxrwbById(Zdzxrwb entity);
	
	/**
	 * 更新
	 * @param entity
	 * @param sessionBean
	 * @return
	 */
	public int updateZdzxrwb(Zdzxrwb entity, SessionBean sessionBean);
	
	/**
	 * 注销
	 * @param entity
	 * @param sessionBean
	 * @return
	 */
	public int deleteZdzxrwb(Zdzxrwb entity, SessionBean sessionBean);
	
	/**
	 * 增加
	 * @param entity
	 * @param sessionBean
	 */
	public void insertZdzxrwb(Zdzxrwb entity, SessionBean sessionBean);
}
