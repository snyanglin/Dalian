package com.founder.qbld.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.qbld.bean.CkyjczFkb;
import com.founder.qbld.bean.CkyjxxQsb;
import com.founder.qbld.bean.Ckyjxxb;
import com.founder.qbld.vo.YjTjVo;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.service.CkyjService.java]  
 * @ClassName:    [CkyjService]   
 * @Description:  [常控预警service]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-4-13 上午9:59:42]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-13 上午9:59:42，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@TypeAnnotation("常控预警")
public interface CkyjService {

	/**
	 * @Title: queryYjtj
	 * @Description: TODO(返回常控预警、预警指令、临空预警的待签、待返数量)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return YjTjVo    返回类型
	 * @throws
	 */
	public YjTjVo queryYjtj(YjTjVo entity);
	
	/**
	 * @Title: queryCkyjList
	 * @Description: TODO(常控预警信息列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryCkyjList(EasyUIPage page, Ckyjxxb entity);
	
	/**
	 * @Title: queryCkyj
	 * @Description: TODO(根据id查询常控预警详情)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Ckyjxxb    返回类型
	 * @throws
	 */
	public Ckyjxxb queryCkyj(Ckyjxxb entity);
	
	/**
	 * @Title: cyryxxb_query_export
	 * @Description: TODO(根据id查询常控警情数据用于excle导出)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return List<Map<String,String>>    返回类型
	 * @throws
	 */
	public List<Map<String, String>> cyryxxb_query_export(Ckyjxxb entity);
	
	/**
	 * @Title: updateCkjqxxb
	 * @Description: TODO(签收：修改常控预警表)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	public int updateCkyjxxb(String qsfkzt, Ckyjxxb entity);
	
	
	/**
	 * @Title: saveCkyjqs
	 * @Description: TODO(保存常控预警签收表)
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveCkyjqs(CkyjxxQsb entity, SessionBean session);
	
	/**
	 * @Title: saveCkyjfk
	 * @Description: TODO(保存常控预警信息反馈表)
	 * @param @param entity
	 * @param @param session
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveCkyjfk(CkyjczFkb entity, SessionBean session);
	
	/**
	 * @Title: queryCkyjFkb
	 * @Description: TODO(反馈记录查询服务-根据预警编号查询常控预警反馈表)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return CkyjczFkb    返回类型
	 * @throws
	 */
	public CkyjczFkb queryCkyjFkb(CkyjczFkb entity);
	
	/**
	 * @Title: queryCkyjFkList
	 * @Description: TODO(常控预警反馈信息列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryCkyjFkList(EasyUIPage page, CkyjczFkb entity);
	
	/**
	 * @Title: updateCkyjczFkb
	 * @Description: TODO(尿检物品修改功能)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String updateCkyjczFkb(CkyjczFkb entity);
	
	/**
	 * @Title: queryQbldZpSingle
	 * @Description: TODO(情报落地全国库取得照片)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return HttpEntity<byte[]>    返回类型
	 * @throws
	 */
	public HttpEntity<byte[]> queryQbldZpSingle(Ckyjxxb entity);
	
}
