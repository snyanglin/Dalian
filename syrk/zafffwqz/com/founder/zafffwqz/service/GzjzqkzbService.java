package com.founder.zafffwqz.service;

import java.util.Map;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zafffwqz.bean.Gzjzqkzb;

@TypeAnnotation("跟踪进展情况")
public interface GzjzqkzbService {
	@MethodAnnotation(value = "跟踪进展情况", type = logType.query)
	public Gzjzqkzb queryGzjzqkzb(Gzjzqkzb entity);
	
	@MethodAnnotation(value = "新增跟踪进展情况", type = logType.insert)
	public void saveGzjzqkzb(Gzjzqkzb entity, SessionBean sessionBean);
	
	@MethodAnnotation(value = "修改跟踪进展情况", type = logType.update)
	public void updateGzjzqkzb(Gzjzqkzb entity, SessionBean sessionBean);
	
	/**
	 * 注销跟踪进展情况信息
	 * @return
	 */
	public void delete(Gzjzqkzb entity, SessionBean sessionBean);
	
	/**
	 * 查询列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	@MethodAnnotation(value = "查询")
	public EasyUIPage queryList(EasyUIPage page,Map map);
}
