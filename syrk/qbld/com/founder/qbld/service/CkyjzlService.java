package com.founder.qbld.service;

import java.util.List;
import java.util.Map;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.qbld.bean.CkyjzlQsb;
import com.founder.qbld.bean.CkyjzlczFkb;
import com.founder.qbld.bean.Ckyjzlb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.service.CkyjzlService.java]  
 * @ClassName:    [CkyjzlService]   
 * @Description:  [常控预警指令服务接口]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-4-22 上午9:11:15]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-22 上午9:11:15，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@TypeAnnotation("常控预警指令")
public interface CkyjzlService {

	/**
	 * @Title: queryCkyjzlList
	 * @Description: TODO(常控预警指令信息列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryCkyjzlList(EasyUIPage page, Ckyjzlb entity);
	
	/**
	 * @Title: queryCkyjzl
	 * @Description: TODO(根据id获取常控预警指令详情)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Ckyjzlb    返回类型
	 * @throws
	 */
	public Ckyjzlb queryCkyjzl(Ckyjzlb entity);
	
	/**
	 * @Title: queryCkyjzlFkb
	 * @Description: TODO(反馈记录查询服务-根据预警编号查询常控预警指令反馈表详情)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return CkyjzlczFkb    返回类型
	 * @throws
	 */
	public CkyjzlczFkb queryCkyjzlFkb(CkyjzlczFkb entity);
	
	/**
	 * @Title: updateCkyjzlb
	 * @Description: TODO(修改常控预警指令表)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	public int updateCkyjzlb(String qsfkzt, Ckyjzlb entity, SessionBean session);
	
	/**
	 * @Title: saveCkyjzlQsb
	 * @Description: TODO(新增常控预警指令签收信息表)
	 * @param @param entity
	 * @param @param session
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveCkyjzlQsb(CkyjzlQsb entity, SessionBean session);
	
	/**
	 * @Title: saveCkyjzlFkb
	 * @Description: TODO(新增常控预警指令反馈信息表)
	 * @param @param entity
	 * @param @param session
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveCkyjzlFkb(CkyjzlczFkb entity, SessionBean session);
	
	/**
	 * @Title: updateCkyjxxbAndSaveFkb
	 * @Description: TODO(反馈：修改常控预警指令表)
	 * @param @param entity
	 * @param @param session
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String updateCkyjzlbAndSaveFkb(Ckyjzlb entity, SessionBean session);
	
	/**
	 * @Title: queryCkyjzlFkList
	 * @Description: TODO(常控预警指令反馈信息列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryCkyjzlFkList(EasyUIPage page, CkyjzlczFkb entity);
	
	/**
	 * @Title: updateCkyjzlczFkb
	 * @Description: TODO(尿检物品修改功能)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String updateCkyjzlczFkb(CkyjzlczFkb entity);
	
	/**
	 * @Title: ckjqxxb_export
	 * @Description: TODO(根据id查询常控预警指令表数据)
	 * @param @param jqid
	 * @param @return    设定文件
	 * @return List<Map<String,String>>    返回类型
	 * @throws
	 */
	public List<Map<String, String>> ckyjzlxxb_query_export(Ckyjzlb entity);
	
}
