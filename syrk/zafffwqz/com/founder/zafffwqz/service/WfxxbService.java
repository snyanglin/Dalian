package com.founder.zafffwqz.service;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.zafffwqz.bean.ZaffWfxx;

/******************************************************************************
 * @Package:      [com.founder.zafffwqz.service.WfxxbService.java]  
 * @ClassName:    [WfxxbService]   
 * @Description:  [物防信息表服务接口]   
 * @Author:       [tian_chengwei@founder.com.cn]  
 * @CreateDate:   [2015-6-5 下午1:53:45]   
 * @UpdateUser:   [lk(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-5 下午1:53:45，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@TypeAnnotation("治安防范物防信息表")
public interface WfxxbService {
	/**
	 * 
	 * @Title: saveWfxxb
	 * @Description: TODO(插入操作)
	 * @param entity
	 * @param sessionBean
	 * @return void返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "治安防范物防信息表插入", type = logType.insert)
	public void saveWfxxb(ZaffWfxx entity, SessionBean sessionBean);
	/**
	 * 
	 * @Title: queryWfxxb
	 * @Description: TODO(查询操作)
	 * @param entity
	 * @return ZaffWfxx返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "治安防范物防信息表查询", type = logType.query)
	public ZaffWfxx queryWfxxb(ZaffWfxx entity);
	/**
	 * 
	 * @Title: updateWfxxb
	 * @Description: TODO(修改操作)
	 * @param entity
	 * @param sessionBean
	 * @return int返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "治安防范物防信息表修改", type = logType.update)
	public int updateWfxxb(ZaffWfxx entity, SessionBean sessionBean);
}
