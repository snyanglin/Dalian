package com.founder.yjjb.service;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.yjjb.bean.Jlxxb;

/**
 * 奖励信息</br>
 * @author yuhongyu
 * @since 2014-11-27
 */
@TypeAnnotation("有奖举报_奖励信息")
public interface JlxxbService {
	
	/**
	 * 查询单条<br>
	 * @param entity
	 * @return
	 */
	@MethodAnnotation(value = "查询单条", type = logType.query)
	public EasyUIPage queryList(EasyUIPage page,Jlxxb entity);
	
	/**
	 * 查询单条<br>
	 * @param entity
	 * @return
	 */
	@MethodAnnotation(value = "查询单条", type = logType.query)
	public Jlxxb queryById(Jlxxb entity);
	
	/**
	 * 新增<br>
	 * @param entity
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void save(Jlxxb entity, SessionBean sessionBean);
	
	/**
	 * 更新<br>
	 * @param entity
	 */
	@MethodAnnotation(value = "更新", type = logType.update)
	public void update(Jlxxb entity, SessionBean sessionBean);
	
	/**
	 * 删除<br>
	 * @param entity
	 */
	@MethodAnnotation(value = "删除", type = logType.delete)
	public void delete(Jlxxb entity, SessionBean sessionBean);
}
