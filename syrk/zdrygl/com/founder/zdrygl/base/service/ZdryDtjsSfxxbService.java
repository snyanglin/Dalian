package com.founder.zdrygl.base.service;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrygl.base.model.ZdryDtjsSfxxb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.service.ZdryService.java]  
 * @ClassName:    [ZdryService]   
 * @Description:  [重点人员上访信息]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015-12-9 上午9:44:29]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-12-9 上午9:44:29，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@TypeAnnotation("动态纪实上访信息服务")
public interface ZdryDtjsSfxxbService {



	public EasyUIPage queryList(EasyUIPage page, ZdryDtjsSfxxb entity);	
	
	
	public String save(ZdryDtjsSfxxb entity,SessionBean sessionBean);
	
	
	public ZdryDtjsSfxxb queryById(String id);
	
	
	public void delete(ZdryDtjsSfxxb entity,SessionBean sessionBean);

	
	public String update(ZdryDtjsSfxxb entity,SessionBean sessionBean);



	

}
