package com.founder.qbld.service;

import java.util.List;
import java.util.Map;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.qbld.bean.LkyjzlQsb;
import com.founder.qbld.bean.Lkyjzlb;
import com.founder.qbld.bean.LkyjzlczFkb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.service.LkyjzlService.java]  
 * @ClassName:    [LkyjzlService]   
 * @Description:  [临控预警指令服务接口]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-4-22 上午9:11:15]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-22 上午9:11:15，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@TypeAnnotation("临控预警指令")
public interface LkyjzlService {

	/**
	 * @Title: queryLkyjzlList
	 * @Description: TODO(临控预警指令信息列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryLkyjzlList(EasyUIPage page, Lkyjzlb entity);
	
	/**
	 * @Title: queryLkyjzl
	 * @Description: TODO(根据id获取临控预警指令详情)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Lkyjzlb    返回类型
	 * @throws
	 */
	public Lkyjzlb queryLkyjzl(Lkyjzlb entity);
	
	/**
	 * @Title: queryLkyjzlFkb
	 * @Description: TODO(反馈记录查询服务-根据预警编号查询临控预警指令反馈表详情)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Lkyjzlb    返回类型
	 * @throws
	 */
	public LkyjzlczFkb queryLkyjzlFkb(LkyjzlczFkb entity);
	
	/**
	 * @Title: updateCkjqxxb
	 * @Description: TODO(签收：修改临控预警指令表)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	public int updateLkyjzlb(String qsfkzt, Lkyjzlb entity, SessionBean session);
	
	/**
	 * @Title: saveLkyjzlqs
	 * @Description: TODO(签收：新增临控预警指令签收信息表)
	 * @param @param entity
	 * @param @param session
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveLkyjzlqs(LkyjzlQsb entity, SessionBean session);
	
	/**
	 * @Title: saveLkyjzlfk
	 * @Description: TODO(反馈：新增临控预警指令反馈信息表)
	 * @param @param entity
	 * @param @param session
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveLkyjzlfk(LkyjzlczFkb entity, SessionBean session);
	
	/**
	 * @Title: queryLkyjzlFkList
	 * @Description: TODO(临控预警指令反馈信息列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryLkyjzlFkList(EasyUIPage page, LkyjzlczFkb entity);
	
	/**
	 * @Title: lkyjzlb_query_export
	 * @Description: TODO(根据预警编号查询临控预警指令表数据)
	 * @param @param jqid
	 * @param @return    设定文件
	 * @return List<Map<String,String>>    返回类型
	 * @throws
	 */
	public List<Map<String, String>> lkyjzlb_query_export(Lkyjzlb entity);
	
}
