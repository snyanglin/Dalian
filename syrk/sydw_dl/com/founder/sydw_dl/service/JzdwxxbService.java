package com.founder.sydw_dl.service;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.sydw_dl.bean.Jzdwxxb;
import com.founder.sydw_dl.bean.Ldxxb;


/******************************************************************************
 * @Package:      [com.founder.sydw_dl.service.JzdwxxbService.java]  
 * @ClassName:    [JzdwxxbService]   
 * @Description:  [技侦单位信息表]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015-8-24 下午4:19:32]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-8-24 下午4:19:32，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
public interface JzdwxxbService {
	
	@MethodAnnotation(value = "新增技侦单位信息表", type = logType.insert)
	public void saveJzdwxxb(Jzdwxxb entity, SessionBean sessionBean);
	
	@MethodAnnotation(value = "查询技侦单位信息表", type = logType.query)
	public Jzdwxxb  queryById(String id);
	
	@MethodAnnotation(value = "修改技侦单位信息表", type = logType.update)
	public void updateJzdwxb(Jzdwxxb entity, SessionBean sessionBean);

	
	
}
