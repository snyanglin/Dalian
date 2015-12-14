package com.founder.syrkgl.service;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.syrkgl.bean.RyRytmtzxxb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.syrkgl.service.RyRytmtzxxbService.java]  
 * @ClassName:    [RyRytmtzxxbService]   
 * @Description:  [实有人口附加信息-人员体貌特征信息表]   
 * @Author:       [xu_wenjun@founder.com.cn]  
 * @CreateDate:   [2015-4-12 下午4:32:04]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-12 下午4:32:04，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@TypeAnnotation("实有人口附加信息-人员体貌特征信息表")
public interface RyRytmtzxxbService {

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return RyRytmtzxxb 返回类型
	 * @throws
	 */
	public RyRytmtzxxb queryById(String id);

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void save(RyRytmtzxxb entity, SessionBean sessionBean);

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "更新", type = logType.update)
	public void update(RyRytmtzxxb entity, SessionBean sessionBean);

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "注销", type = logType.delete)
	public void delete(RyRytmtzxxb entity, SessionBean sessionBean);
	
	/**
	 * 
	 * @Title: queryCount
	 * @Description: TODO(根据条件查询记录数)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Integer    返回类型
	 * @throws
	 */
	public Integer queryCount(RyRytmtzxxb entity);

}
