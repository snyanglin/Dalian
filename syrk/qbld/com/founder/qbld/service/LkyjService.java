package com.founder.qbld.service;

import java.util.List;
import java.util.Map;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.qbld.bean.LkyjczFkb;
import com.founder.qbld.bean.LkyjxxQsb;
import com.founder.qbld.bean.Lkyjxxb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.service.LkyjService.java]  
 * @ClassName:    [LkyjService]   
 * @Description:  [临控预警服务接口]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-4-22 上午9:50:25]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-22 上午9:50:25，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@TypeAnnotation("临控预警")
public interface LkyjService {

	/**
	 * @Title: queryLkyjList
	 * @Description: TODO(临控预警信息列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryLkyjList(EasyUIPage page, Lkyjxxb entity);
	
	/**
	 * @Title: queryYjzl
	 * @Description: TODO(临控预警详情)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Lkyjxxb    返回类型
	 * @throws
	 */
	public Lkyjxxb queryLkyj(Lkyjxxb entity);
	
	/**
	 * @Title: queryLkyjFkb
	 * @Description: TODO(反馈记录查询服务-根据预警编号查询临控预警反馈表详情)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Lkyjczfkb    返回类型
	 * @throws
	 */
	public LkyjczFkb queryLkyjFkb(LkyjczFkb entity);
	
	/**
	 * @Title: updateLkyjxxb
	 * @Description: TODO(签收：修改常控预警表)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	public int updateLkyjxxb(String qsfkzt, Lkyjxxb entity, SessionBean session);
	
	/**
	 * @Title: saveLkyjzlQsb
	 * @Description: TODO(新增常控预警签收信息表)
	 * @param @param entity
	 * @param @param session
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveLkyjzlQsb(LkyjxxQsb entity, SessionBean session);
	
	/**
	 * @Title: saveLkyjzlFkb
	 * @Description: TODO(反馈：新增常控预警反馈信息表)
	 * @param @param entity
	 * @param @param session
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveLkyjzlFkb(LkyjczFkb entity, SessionBean session);
	
	/**
	 * @Title: queryLkyjFkList
	 * @Description: TODO(临控预警反馈信息列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryLkyjFkList(EasyUIPage page, LkyjczFkb entity);
	
	/**
	 * @Title: lkyjxxb_query_export
	 * @Description: TODO(根据预警编号查询临控预警表数据)
	 * @param @param jqid
	 * @param @return    设定文件
	 * @return List<Map<String,String>>    返回类型
	 * @throws
	 */
	public List<Map<String, String>> lkyjxxb_query_export(Lkyjxxb entity);
	
}
