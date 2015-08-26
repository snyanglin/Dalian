package com.founder.qbld.dao;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.qbld.bean.CkyjczFkb;
import com.founder.qbld.bean.CkyjxxQsb;
import com.founder.qbld.bean.Ckyjxxb;
import com.founder.qbld.bean.ZdryZp;
import com.founder.qbld.vo.YjTjVo;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.dao.CkyjDao.java]  
 * @ClassName:    [CkyjDao]   
 * @Description:  [常控预警dao]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-4-13 上午10:02:28]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-13 上午10:02:28，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("ckyjDao")
public class CkyjDao extends BaseDaoImpl {

	/**
	 * @Title: query_v_qbld_ckyjtj
	 * @Description: TODO(返回常控预警待签、待返数量 )
	 * @param @return    设定文件
	 * @return CkyjTjVo    返回类型
	 * @throws
	 */
	public YjTjVo query_v_qbld_ckyjtj(Map<String, Object> map) {
		return (YjTjVo)queryForObject("Ckyj.query_v_qbld_ckyjtj", map);
	}
	/**
	 * @Title: queryYjtj
	 * @Description: TODO(返回预警指令待签、待返数量 )
	 * @param @return    设定文件
	 * @return CkyjTjVo    返回类型
	 * @throws
	 */
	public YjTjVo query_v_qbld_ckzlyjtj(Map<String, Object> map) {
		return (YjTjVo)queryForObject("Ckyj.query_v_qbld_ckzlyjtj", map);
	}
	/**
	 * @Title: queryYjtj
	 * @Description: TODO(返回临空预警的待签、待返数量 )
	 * @param @return    设定文件
	 * @return CkyjTjVo    返回类型
	 * @throws
	 */
	public YjTjVo query_v_qbld_lkyjtj(Map<String, Object> map) {
		return (YjTjVo)queryForObject("Ckyj.query_v_qbld_lkyjtj", map);
	}
	/**
	 * @Title: queryYjtj
	 * @Description: TODO(返回临空预警指令的待签、待返数量 )
	 * @param @return    设定文件
	 * @return CkyjTjVo    返回类型
	 * @throws
	 */
	public YjTjVo query_v_qbld_lkyjzltj(Map<String, Object> map) {
		return (YjTjVo)queryForObject("Ckyj.query_v_qbld_lkyjzltj", map);
	}
	
	/**
	 * @Title: queryCkyj
	 * @Description: TODO(常控预警信息列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public List<?> queryCkyjList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("Ckyj.queryCkyjList", map);
	}
	
	/**
	 * @Title: queryCountCkyj
	 * @Description: TODO(常控预警信息条数查询)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long queryCkyjCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("Ckyj.queryCkyjCount", map);
		return count.longValue();
	}	
	
	/**
	 * @Title: queryCkyj
	 * @Description: TODO(根据id查询常控预警详情)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public Ckyjxxb queryCkyj(Ckyjxxb entity, Map<String, Object> map) {
		return (Ckyjxxb) queryForObject("Ckyj.queryCkyj", map);
	}	
	
	/**
	 * @Title: queryCkyjFkb
	 * @Description: TODO(反馈记录查询服务-根据预警编号查询常控预警反馈表)
	 * @param @param entity
	 * @param @param map
	 * @param @return    设定文件
	 * @return CkyjFkxxb    返回类型
	 * @throws
	 */
	public CkyjczFkb queryCkyjFkb(CkyjczFkb entity, Map<String, Object> map) {
		return (CkyjczFkb) queryForObject("Ckyj.queryCkyjFkb", map);
	}
	
	/**
	 * @Title: cyryxxb_export
	 * @Description: TODO(常控警情导出功能)
	 * @param @param dwid
	 * @param @return    设定文件
	 * @return List<Map<String,String>>    返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, String>> cyryxxb_query_export(Map<String, Object> map) {
		 return queryForList("Ckyj.queryCkyjListExport", map);
	}
	
	/**
	 * @Title: updateCkyjxxb
	 * @Description: TODO(更新常控预警信息表)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	public int updateCkyjxxb(Ckyjxxb entity) {
		return update("Ckyj.updateCkyjxxb", entity); 
	}
	
	/**
	 * @Title: updateCkyjqsb
	 * @Description: TODO(记录调用ws接口报错字段信息)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	public int updateCkyjqsb(CkyjxxQsb entity) {
		return update("Ckyj.updateCkyjqsb", entity); 
	}
	
	/**
	 * @Title: saveckyjQs
	 * @Description: TODO(插入预警签收表)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveckyjQs(CkyjxxQsb entity) {
		insert("Ckyj.saveCkyjQsxxb", entity); 
		return entity.getYjxxbh();
	}
	
	/**
	 * @Title: saveckyjFk
	 * @Description: TODO(新增常控预警反馈表)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveckyjFk(CkyjczFkb entity) {
		insert("Ckyj.saveCkyjFkxxb", entity); 
		return entity.getYjxxbh();
	}
	/**
	 * @Title: saveCkyj
	 * @Description: TODO(保存常控预警反馈信息)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveCkyjfk(CkyjczFkb entity) {
		insert("Cyryxxb.saveCkyjfk", entity); 
		return entity.getYjxxbh();
	}
	
	/**
	 * @Title: queryCkyjFkList
	 * @Description: TODO(常控预警反馈信息列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public List<?> queryCkyjFkList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("Ckyj.queryCkyjFkList", map);
	}
	
	/**
	 * @Title: queryCkyjFkCount
	 * @Description: TODO(常控预警反馈信息条数查询)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long queryCkyjFkCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("Ckyj.queryCkyjFkCount", map);
		return count.longValue();
	}
	
	/**
	 * @Title: updateCkyjczFkb
	 * @Description: TODO(尿检物品修改功能)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String updateCkyjczFkb(CkyjczFkb entity) {
		return "" + update("Ckyj.updateCkyjczFkb", entity); 
	}
	
	/**
	 * @Title: getYjSeq
	 * @Description: TODO(去的预警序列)
	 * @param @param sequenceName
	 * @param @return    设定文件
	 * @return Long    返回类型
	 * @throws
	 */
	public String queryYjSeq(Map<String, Object> map) {
		return (String) queryForObject("Ckyj.queryYjSeq", map);
	}
	
	/**
	 * @Title: queryJbxx
	 * @Description: TODO(根据证件号码查询人员基本信息)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public Ckyjxxb queryJbxx(Ckyjxxb entity) {
		return (Ckyjxxb) queryForObject("Ckyj.queryJbxx", entity);
	}
	
	/**
	 * @Title: queryZp
	 * @Description: TODO(获取本地照片信息)
	 * @param @param map
	 * @param @return    设定文件
	 * @return ZdryZp    返回类型
	 * @throws
	 */
	public ZdryZp queryZp (Map<String, Object> map) {
		return (ZdryZp)queryForObject("Ckyj.queryZp", map);
	}
	
	/**
	 * @Title: saveZp
	 * @Description: TODO(保存照片)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveZp(ZdryZp entity) {
		insert("Ckyj.saveZp", entity); 
		return entity.getId();
	}
	
}
