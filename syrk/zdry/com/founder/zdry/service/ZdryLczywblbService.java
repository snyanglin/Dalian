package com.founder.zdry.service;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.zdry.bean.ZdryLczywblb;

/***
 * ****************************************************************************
 * @Package:      [com.founder.zdry.service.ZdryLczywblbService.java]  
 * @ClassName:    [ZdryLczywblbService]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2015-3-16 下午8:48:18]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-3-16 下午8:48:18，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
public interface ZdryLczywblbService {
	public void changeStateByYwjg(String  zdryLczywblbId,SessionBean sessionBean);
	
	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "更新", type = logType.update)
	public void update(ZdryLczywblb entity, SessionBean sessionBean);
	/***
	 * 
	 * @Title: queryById
	 * @Description: TODO(根据ID查询实体)
	 * @param @param id    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public ZdryLczywblb queryById(String id);
}
