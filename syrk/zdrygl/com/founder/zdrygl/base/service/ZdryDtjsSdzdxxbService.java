package com.founder.zdrygl.base.service;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrygl.base.model.ZdryDtjsSdzdxxb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrylb.service.ZdryDtjsSdzdxxbService.java]  
 * @ClassName:    [ZdryDtjsSdzdxxbService]   
 * @Description:  [动态纪实涉毒贩毒信息]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015-12-15 上午9:44:29]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-12-15 上午9:44:29，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@TypeAnnotation("动态纪实涉毒贩毒信息服务")
public interface ZdryDtjsSdzdxxbService {


	public EasyUIPage queryList(EasyUIPage page, ZdryDtjsSdzdxxb entity);	
	

	public String save(ZdryDtjsSdzdxxb entity,SessionBean sessionBean);
	
	
	public ZdryDtjsSdzdxxb queryById(String id);
	
	
	public void delete(ZdryDtjsSdzdxxb entity,SessionBean sessionBean);

	
	public String update(ZdryDtjsSdzdxxb entity,SessionBean sessionBean);



	

}
