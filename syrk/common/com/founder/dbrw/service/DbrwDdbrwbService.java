package com.founder.dbrw.service;

import java.util.Map;

import com.founder.dbrw.bean.DbrwDbrwb;
import com.founder.dbrw.bean.DbrwDdbrwb;
import com.founder.dbrw.bean.DbrwDdbrwsjmxb;
import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;

@TypeAnnotation("督办任务－待督办任务管理")
public interface DbrwDdbrwbService {

	/**
	 * 查询单条待督办任务<br>
	 * 
	 * @param id
	 * @return DbrwDbpzb
	 */
	public DbrwDdbrwb queryDdbrwb(String id);

	/**
	 * 查询待督办任务数据明细列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	public EasyUIPage querySjmxbList(EasyUIPage page, DbrwDdbrwb entity);

	/**
	 * 删除单条待督办任务数据明细<br>
	 * 
	 * @param id
	 *            待督办任务数据明细ID
	 */
	@MethodAnnotation(value = "注销", type = logType.delete)
	public void deleteDdbrwSjmxbById(DbrwDdbrwsjmxb entity);

	/**
	 * 删除批量待督办任务数据明细<br>
	 * 
	 * @param entityArray
	 */
	@MethodAnnotation(value = "注销批量", type = logType.delete)
	public void deleteDdbrwSjmxbPatch(DbrwDdbrwsjmxb[] entityArray);

	/**
	 * 新增督办任务<br>
	 * 
	 * @param entity
	 * @param ddbrwid
	 * @param sessionBean
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void insertDbrwb(DbrwDbrwb entity, Map<String,String> coultMap,
			SessionBean sessionBean);

}
