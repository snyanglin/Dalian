package com.founder.syrkgl.service;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.syrkgl.bean.RyRybmchxxb;
import com.founder.syrkgl.bean.RyZyjwryxxb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.syrkgl.service.RyRybmchxxbService.java]  
 * @ClassName:    [RyRybmchxxbService]   
 * @Description:  [实有人口附加信息-人员别名绰号信息表]   
 * @Author:       [xu_wenjun@founder.com.cn]  
 * @CreateDate:   [2015-4-3 上午10:18:58]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-3 上午10:18:58，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@TypeAnnotation("实有人口附加信息-人员别名绰号信息表")
public interface RyZyjwryxxbService {

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return RyRybmchxxb 返回类型
	 * @throws
	 */
	public RyZyjwryxxb queryById(String id);

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void save(RyZyjwryxxb entity, SessionBean sessionBean);

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "更新", type = logType.update)
	public void update(RyZyjwryxxb entity, SessionBean sessionBean);

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "注销", type = logType.delete)
	public void delete(RyZyjwryxxb entity, SessionBean sessionBean);
	
	/**
	 * 
	 * @Title: queryCount
	 * @Description: TODO(根据条件查询记录数)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Integer    返回类型
	 * @throws
	 */
	public Integer queryCount(RyZyjwryxxb entity);

}
