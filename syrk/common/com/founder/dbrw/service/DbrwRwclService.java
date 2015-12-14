package com.founder.dbrw.service;

import java.util.List;
import java.util.Map;

import com.founder.dbrw.bean.DbrwDbrwb;
import com.founder.dbrw.bean.DbrwDbrwsjmxb;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;

public interface DbrwRwclService {
	
	
	/**
	 *  根据督办任务ID查询督办任务主表
	 * @return
	 */
	public DbrwDbrwb queryDbrwb(DbrwDbrwb entity);
	
	
	/**
	 *  根据督办任务ID查询督办任务主表
	 * @return
	 */
	public DbrwDbrwsjmxb queryDbrwDbrwsjmxb(DbrwDbrwsjmxb entity);
	
	
	/**
	 * 根据督办任务ID查询督办任务子表 
	 * @return
	 */
	public EasyUIPage queryDbrwsjmxb(DbrwDbrwsjmxb dbrwDbrwsjmxb,SessionBean sessionBean,EasyUIPage page);
	
	
	
	/**
	 * 刷新处理情况
	 * @return
	 */
	public void Refresh(DbrwDbrwb entity,SessionBean sessionBean);
	
	
	
	/**
	 * 完成任务处理
	 * @return
	 */
	public void Complete(DbrwDbrwb entity,SessionBean sessionBean,String MessageID);
	
	
	
	/**
	 * 保存反馈
	 * @return
	 */
	public void saveFk(DbrwDbrwsjmxb entity,SessionBean sessionBean);
	
	
	
	
	/**
	 *  根据传入业务模型类别查询展示字段
	 * @return
	 */
	public List<Map> getFiledTitle(String dbmxID);


	public Map<String, Object> getFigData(DbrwDbrwsjmxb entity,SessionBean sessionBean);
	
	
}
