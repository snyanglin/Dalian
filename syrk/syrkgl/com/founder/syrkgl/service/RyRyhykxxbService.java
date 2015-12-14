package com.founder.syrkgl.service;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.syrkgl.bean.RyRyhykxxb;


/******************************************************************************
 * @Package:      [com.founder.syrkgl.service.RyRyhykxxbService.java]  
 * @ClassName:    [RyRyhykxxbService]   
 * @Description:  [实有人口附加信息-人员会员卡信息表]   
 * @Author:       [congrihong@founder.com.cn]  
 * @CreateDate:   [2015-4-9 下午5:34:11]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-9 下午5:34:11，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@TypeAnnotation("实有人口附加信息-人员会员卡信息表")
public interface RyRyhykxxbService {

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return RyRyhykxxb 返回类型
	 * @throws
	 */
	public RyRyhykxxb queryById(String id);

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void save(RyRyhykxxb entity, SessionBean sessionBean);

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "更新", type = logType.update)
	public void update(RyRyhykxxb entity, SessionBean sessionBean);


}
