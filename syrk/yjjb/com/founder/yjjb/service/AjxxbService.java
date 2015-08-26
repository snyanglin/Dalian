package com.founder.yjjb.service;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.yjjb.bean.Ajxxb;

/**
 * </br>
 * @author 于宏宇
 * @since 2014-11-18
 */
@TypeAnnotation("有奖举报_相关案件")
public interface AjxxbService {
	
	/**
	 * 查询单条<br>
	 * @param entity
	 * @return
	 */
	@MethodAnnotation(value = "查询单条", type = logType.query)
	public EasyUIPage queryList(EasyUIPage page,Ajxxb entity);
	
	/**
	 * 查询单条<br>
	 * @param entity
	 * @return
	 */
	@MethodAnnotation(value = "查询单条", type = logType.query)
	public Ajxxb queryById(Ajxxb entity);
	
	/**
	 * 新增<br>
	 * @param entity
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void save(Ajxxb entity, SessionBean sessionBean);

	/**
	 * 更新<br>
	 * @param entity
	 */
	@MethodAnnotation(value = "更新", type = logType.update)
	public void update(Ajxxb entity, SessionBean sessionBean);

	/**
	 * 删除<br>
	 * @param entity
	 */
	@MethodAnnotation(value = "注销", type = logType.delete)
	public void delete(Ajxxb entity, SessionBean sessionBean);
	
	/**
	 * 查询单条通过案件编号<br>
	 * @param entity
	 * @return
	 */
	@MethodAnnotation(value = "查询单条通过案件编号", type = logType.query)
	public Ajxxb queryByAjbh(Ajxxb entity);
	
	
	/**
	 * 根据案件编号在举报表和老警综里面查询单条<br>
	 * @param entity
	 * @return
	 */
	@MethodAnnotation(value = "在举报表和老警综里面", type = logType.query)
	public Ajxxb queryAllAjxxByAjbh(Ajxxb entity);
	
	/**
	 * 查询案件编号是否存在</br>
	 * @param xsbh
	 * @return
	 */
	@MethodAnnotation(value = "查询案件编号是否存在", type = logType.query)
	public int ifExistAjNum(String ajbh);

	/**
	 * @Title: queryByAjbhLjz
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param entityAj
	 * @param @return    设定文件
	 * @return Ajxxb    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "通过id查询老警综数据", type = logType.query)
	public Ajxxb queryByAjbhLjz(Ajxxb entity);

}
