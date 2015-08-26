package com.founder.qbld.service;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.qbld.bean.Lksqb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.service.LksqService.java]  
 * @ClassName:    [LksqService]   
 * @Description:  [临控申请表相关服务接口]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-5-14 上午9:44:29]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-14 上午9:44:29，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@TypeAnnotation("临控申请")
public interface LksqService {

	/**
	 * @Title: queryLksqList
	 * @Description: TODO(临控申请列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryLksqList(EasyUIPage page, Lksqb entity);
	
	/**
	 * @Title: queryLksqListCount
	 * @Description: TODO(临控申请表总数查询)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long queryLksqListCount(Lksqb entity);
	
	/**
	 * @Title: queryCkyj
	 * @Description: TODO(临控申请详情查询服务)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Lksqb    返回类型
	 * @throws
	 */
	public Lksqb queryLksqb(Lksqb entity);
	
	/**
	 * @Title: saveLkyjxxb
	 * @Description: TODO(临控申请 - 保存临控申请表)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveLksqb(Lksqb entity, SessionBean sessionBean);
}
