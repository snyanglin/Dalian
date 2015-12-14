package com.founder.syrkgl.service;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.syrkgl.bean.RyRyjlxxb;



/******************************************************************************
 * @Package:      [com.founder.syrkgl.service.RyRyjlxxbService.java]  
 * @ClassName:    [RyRyjlxxbService]   
 * @Description:  [实有人口附加信息-人员经历信息表]   
 * @Author:       [congrihong@founder.com.cn]  
 * @CreateDate:   [2015-4-10 上午10:04:41]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-10 上午10:04:41，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@TypeAnnotation("实有人口附加信息-人员经历信息表")
public interface RyRyjlxxbService {

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return RyRyhykxxb 返回类型
	 * @throws
	 */
	public RyRyjlxxb queryById(String id);

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void save(RyRyjlxxb entity, SessionBean sessionBean);

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "更新", type = logType.update)
	public void update(RyRyjlxxb entity, SessionBean sessionBean);


}
