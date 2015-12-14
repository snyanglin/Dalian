package com.founder.zafffwqz.service;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zafffwqz.bean.ZaffWfxx;

/******************************************************************************
 * @Package:      [com.founder.zafffwqz.service.WfxxService.java]  
 * @ClassName:    [WfxxService]   
 * @Description:  [物防信息空间表与属性表服务层接口]   
 * @Author:       [tian_chengwei@founder.com.cn]  
 * @CreateDate:   [2015-6-5 下午1:52:19]   
 * @UpdateUser:   [lk(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-5 下午1:52:19，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@TypeAnnotation("物防信息")
public interface WfxxService {

	
	/**
	 * 
	 * @Title: queryWf
	 * @Description: TODO(基本信息表查询)
	 * @param page
	 * @param entity
	 * @return
	 * @return EasyUIPage返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "治安防范物防信息表查询", type = logType.query)
	public EasyUIPage queryWf(EasyUIPage page, ZaffWfxx entity);
	/**
	 * 
	 * @Title: delete
	 * @Description: TODO(删除操作)
	 * @param entity
	 * @param sessionBean
	 * @return void返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "治安防范物防信息表删除", type = logType.delete)
	public void delete(ZaffWfxx entity,SessionBean sessionBean) ;
	/**
	 * 
	 * @Title: updateWf
	 * @Description: TODO(对空间表和属性同时做修改操作)
	 * @param entity
	 * @param sessionBean
	 * @return void返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "治安防范物防信息表修改", type = logType.update)
	public void updateWf(ZaffWfxx entity,SessionBean sessionBean);
	/**
	 * 
	 * @Title: queryWfxxOnPT
	 * @Description: TODO(空间表和属性表关联查询空间查询)
	 * @param page
	 * @param entity
	 * @return EasyUIPage返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "治安防范物防信息表和空间表", type = logType.query)
	public EasyUIPage queryWfxxOnPT(EasyUIPage page, ZaffWfxx entity);
}
