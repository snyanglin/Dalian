package com.founder.yjjb.service;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.yjjb.bean.Xsdzsqb;

/**
 * 线索递转</br>
 * @author Administrator
 * @since 2014-11-17
 */
@TypeAnnotation("有奖举报_递转申请")
public interface XsdzsqbService {

	/**
	 * 查询单条<br>
	 * @param entity
	 * @return
	 */
	@MethodAnnotation(value = "查询单条", type = logType.query)
	public EasyUIPage queryList(EasyUIPage page,Xsdzsqb entity);
	
	/**
	 * 查询单条<br>
	 * @param entity
	 * @return
	 */
	@MethodAnnotation(value = "查询单条", type = logType.query)
	public Xsdzsqb queryById(Xsdzsqb entity);
	
	/**
	 * 新增<br>
	 * @param entity
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void save(Xsdzsqb entity, SessionBean sessionBean);

	/**
	 * 更新<br>
	 * @param entity
	 */
	@MethodAnnotation(value = "更新", type = logType.update)
	public void update(Xsdzsqb entity, SessionBean sessionBean);

	/**
	 * 删除<br>
	 * @param entity
	 */
	@MethodAnnotation(value = "注销", type = logType.delete)
	public void delete(Xsdzsqb entity, SessionBean sessionBean);
}
