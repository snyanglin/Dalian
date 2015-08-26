package com.founder.yjjb.service;

import java.util.List;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.organization.role.bean.OrgRole;
import com.founder.framework.utils.EasyUIPage;
import com.founder.yjjb.bean.Xsjbxxb;

/**
 * 线索举报</br>
 * @author Administrator
 * @since 2014-11-17
 */
@TypeAnnotation("有奖举报_线索信息")
public interface XsjbxxbService {

	/**
	 * 查询单条<br>
	 * @param entity
	 * @return
	 */
	@MethodAnnotation(value = "查询单条", type = logType.query)
	public EasyUIPage queryList(EasyUIPage page,Xsjbxxb entity);
	
	/**
	 * 查询单条<br>
	 * @param entity
	 * @return
	 */
	@MethodAnnotation(value = "查询单条", type = logType.query)
	public Xsjbxxb queryById(Xsjbxxb entity);
	
	/**
	 * 查询未初查数据<br>
	 * @param entity
	 * @return
	 */
	@MethodAnnotation(value = "查询未初查数据", type = logType.query)
	public List<Xsjbxxb> queryCCById();
	
	/**
	 * 查询未复查数据<br>
	 * @param entity
	 * @return
	 */
	@MethodAnnotation(value = "查询未复查数据", type = logType.query)
	public List<Xsjbxxb> queryFCById();
	
	/**
	 * 新增<br>
	 * @param entity
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void save(Xsjbxxb entity, SessionBean sessionBean);

	/**
	 * 更新<br>
	 * @param entity
	 */
	@MethodAnnotation(value = "更新", type = logType.update)
	public void update(Xsjbxxb entity, SessionBean sessionBean);

	/**
	 * 删除<br>
	 * @param entity
	 */
	@MethodAnnotation(value = "注销", type = logType.delete)
	public void delete(Xsjbxxb entity, SessionBean sessionBean);

	/**
	 * 查询所有线索<br>
	 * @param entity
	 * @return
	 */
	@MethodAnnotation(value = "查询所有线索", type = logType.query)
	public EasyUIPage queryAllList(EasyUIPage page,Xsjbxxb entity);

	/**
	 * @Title: queryUserAssignRole
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param userId
	 * @param @return    设定文件
	 * @return List<OrgRole>    返回类型
	 * @throws
	 */
	public List<Xsjbxxb> queryUserAssignRole(SessionBean sessionBean);

}
