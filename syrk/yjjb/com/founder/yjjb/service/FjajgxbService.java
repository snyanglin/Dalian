package com.founder.yjjb.service;

import java.util.List;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.yjjb.bean.Fjajgxb;

/**
 * </br>
 * @author 于宏宇
 * @since 2014-11-18
 */
@TypeAnnotation("有奖举报_相关案件")
public interface FjajgxbService {
	
	/**
	 * 查询单条<br>
	 * @param entity
	 * @return
	 */
	public Fjajgxb queryById(Fjajgxb entity);
	
	/**
	 * 新增<br>
	 * @param entity
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void save(Fjajgxb entity, SessionBean sessionBean);
	/**
	 * 删除<br>
	 * @param entity
	 */
	@MethodAnnotation(value = "注销", type = logType.delete)
	public void delete(Fjajgxb entity, SessionBean sessionBean);
	
	/**
	 * 查询单条<br>
	 * @param entity
	 * @return
	 */
	public List<Fjajgxb> queryByAjbh(String ajbh);

	/**
	 * 通过案件编号删除<br>
	 * @param entity
	 */
	@MethodAnnotation(value = "注销通过ajbh", type = logType.delete)
	public void deleteByAjbh(Fjajgxb entity, SessionBean sessionBean);

	/**
	 * @Title: update
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param entityFu
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void update(Fjajgxb entityFu, SessionBean sessionBean);
	
}
