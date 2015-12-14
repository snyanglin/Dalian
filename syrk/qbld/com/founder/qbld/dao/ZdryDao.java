package com.founder.qbld.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.qbld.bean.Clxxb;
import com.founder.qbld.bean.Saxxb;
import com.founder.qbld.bean.Shgxrb;
import com.founder.qbld.bean.Zdjlb;
import com.founder.qbld.bean.ZdryGxbg;
import com.founder.qbld.bean.ZdrySdFd;
import com.founder.qbld.bean.ZdrySdXd;
import com.founder.qbld.bean.ZdrySdZd;
import com.founder.qbld.bean.ZdrySf;
import com.founder.qbld.bean.ZdrySw;
import com.founder.qbld.bean.ZdryZdxsfzqk;
import com.founder.qbld.bean.ZdryZszhjsb;
import com.founder.qbld.bean.ZdryZt;
import com.founder.qbld.bean.Zdryb;
import com.founder.qbld.bean.Zsjlb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.dao.ZdryDao.java]  
 * @ClassName:    [ZdryDao]   
 * @Description:  [重点人员dao]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-5-14 上午9:44:06]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-14 上午9:44:06，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("zdryDao")
public class ZdryDao extends BaseDaoImpl {
	
	/**
	 * @Title: queryZdryList
	 * @Description: TODO(重点人员列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public List<?> queryZdryList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("Zdry.queryZdryList", map);
	}
	
	/**
	 * @Title: queryCountCkyj
	 * @Description: TODO(常控预警信息条数查询)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long queryZdryListCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("Zdry.queryZdryCount", map);
		return count.longValue();
	}
	
	/**
	 * @Title: queryZdryb
	 * @Description: TODO(重点人员详情查询服务)
	 * @param @param entity
	 * @param @param map
	 * @param @return    设定文件
	 * @return Zdryb    返回类型
	 * @throws
	 */
	public Zdryb queryZdryb(Map<String, Object> map) {
		return (Zdryb) queryForObject("Zdry.queryZdryb", map);
	}	
	
	
	/**
	 * @Title: saveZdryb
	 * @Description: TODO(保存重点人员表-重点人员)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveZdryb(Zdryb entity) {
		insert("Zdry.saveZdryb", entity); 
		return entity.getObjectid();
	}
	
	/**
	 * @Title: updateZdryxxb
	 * @Description: TODO(更新重点人员信息)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	public int updateZdryxxb(Zdryb entity) {
		return update("Zdry.updateZdryxxb", entity); 
	}
	
	/**
	 * @Title: queryZdryZtList
	 * @Description: TODO(重点人员在逃列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public List<?> queryZdryZtList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("Zdry.queryZdryZtList", map);
	}
	
	/**
	 * @Title: queryZdryZtListCount
	 * @Description: TODO(在逃信息条数查询)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long queryZdryZtListCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("Zdry.queryZdryZtCount", map);
		return count.longValue();
	}
	
	/**
	 * @Title: queryZdryb
	 * @Description: TODO(在逃人员详情查询服务)
	 * @param @param entity
	 * @param @param map
	 * @param @return    设定文件
	 * @return Zdryb    返回类型
	 * @throws
	 */
	public ZdryZt queryZdryZtb(Map<String, Object> map) {
		return (ZdryZt) queryForObject("Zdry.queryZdryZtb", map);
	}	
	
	
	/**
	 * @Title: saveZdryb
	 * @Description: TODO(保存重点人员表-重点人员)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveZdryZtb(ZdryZt entity) {
		insert("Zdry.saveZdryZtb", entity); 
		return entity.getId();
	}
	
	/**
	 * @Title: queryZdrySwList
	 * @Description: TODO(重点人员在逃列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public List<?> queryZdrySwList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("Zdry.queryZdrySwList", map);
	}
	
	/**
	 * @Title: queryZdrySwListCount
	 * @Description: TODO(在逃信息条数查询)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long queryZdrySwListCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("Zdry.queryZdrySwCount", map);
		return count.longValue();
	}
	
	/**
	 * @Title: queryZdryb
	 * @Description: TODO(在逃人员详情查询服务)
	 * @param @param entity
	 * @param @param map
	 * @param @return    设定文件
	 * @return Zdryb    返回类型
	 * @throws
	 */
	public ZdrySw queryZdrySwb(Map<String, Object> map) {
		return (ZdrySw) queryForObject("Zdry.queryZdrySwb", map);
	}	
	
	
	/**
	 * @Title: saveZdryb
	 * @Description: TODO(保存重点人员表-重点人员)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveZdrySwb(ZdrySw entity) {
		insert("Zdry.saveZdrySwb", entity); 
		return entity.getId();
	}
	
	/**
	 * @Title: queryZdryZszhjsbList
	 * @Description: TODO(重点人员在逃列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public List<?> queryZdryZszhjsbList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("Zdry.queryZdryZszhjsbList", map);
	}
	
	/**
	 * @Title: queryZdryZszhjsbListCount
	 * @Description: TODO(在逃信息条数查询)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long queryZdryZszhjsbListCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("Zdry.queryZdryZszhjsbCount", map);
		return count.longValue();
	}
	
	/**
	 * @Title: queryZdryb
	 * @Description: TODO(在逃人员详情查询服务)
	 * @param @param entity
	 * @param @param map
	 * @param @return    设定文件
	 * @return Zdryb    返回类型
	 * @throws
	 */
	public ZdryZszhjsb queryZdryZszhjsb(Map<String, Object> map) {
		return (ZdryZszhjsb) queryForObject("Zdry.queryZdryZszhjsb", map);
	}	
	
	
	/**
	 * @Title: saveZdryb
	 * @Description: TODO(保存重点人员表-重点人员)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveZdryZszhjsb(ZdryZszhjsb entity) {
		insert("Zdry.saveZdryZszhjsb", entity); 
		return entity.getId();
	}
	
	/**
	 * @Title: queryZdryZdxsfzqkList
	 * @Description: TODO(重点人员在逃列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public List<?> queryZdryZdxsfzqkList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("Zdry.queryZdryZdxsfzqkList", map);
	}
	
	/**
	 * @Title: queryZdryZdxsfzqkListCount
	 * @Description: TODO(在逃信息条数查询)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long queryZdryZdxsfzqkListCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("Zdry.queryZdryZdxsfzqkCount", map);
		return count.longValue();
	}
	
	/**
	 * @Title: queryZdryb
	 * @Description: TODO(在逃人员详情查询服务)
	 * @param @param entity
	 * @param @param map
	 * @param @return    设定文件
	 * @return Zdryb    返回类型
	 * @throws
	 */
	public ZdryZdxsfzqk queryZdryZdxsfzqk(Map<String, Object> map) {
		return (ZdryZdxsfzqk) queryForObject("Zdry.queryZdryZdxsfzqkb", map);
	}	
	
	
	/**
	 * @Title: saveZdryb
	 * @Description: TODO(保存重点人员表-重点人员)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveZdryZdxsfzqk(ZdryZdxsfzqk entity) {
		insert("Zdry.saveZdryZdxsfzqkb", entity); 
		return entity.getId();
	}
	
	/**
	 * @Title: queryZdrySfList
	 * @Description: TODO(重点人员涉访列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public List<?> queryZdrySfList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("Zdry.queryZdrySfList", map);
	}
	
	/**
	 * @Title: queryZdrySfListCount
	 * @Description: TODO(涉访信息条数查询)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long queryZdrySfListCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("Zdry.queryZdrySfCount", map);
		return count.longValue();
	}
	
	/**
	 * @Title: queryZdryb
	 * @Description: TODO(涉访人员详情查询服务)
	 * @param @param entity
	 * @param @param map
	 * @param @return    设定文件
	 * @return Zdryb    返回类型
	 * @throws
	 */
	public ZdrySf queryZdrySf(Map<String, Object> map) {
		return (ZdrySf) queryForObject("Zdry.queryZdrySfb", map);
	}	
	
	
	/**
	 * @Title: saveZdryb
	 * @Description: TODO(保存涉访)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveZdrySf(ZdrySf entity) {
		insert("Zdry.saveZdrySfb", entity); 
		return entity.getId();
	}
	
	/**
	 * @Title: queryZdrySdFdList
	 * @Description: TODO(重点人员贩毒列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public List<?> queryZdrySdFdList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("Zdry.queryZdrySdFdList", map);
	}
	
	/**
	 * @Title: queryZdrySdFdListCount
	 * @Description: TODO(贩毒信息条数查询)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long queryZdrySdFdListCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("Zdry.queryZdrySdFdCount", map);
		return count.longValue();
	}
	
	/**
	 * @Title: queryZdryb
	 * @Description: TODO(贩毒人员详情查询服务)
	 * @param @param entity
	 * @param @param map
	 * @param @return    设定文件
	 * @return Zdryb    返回类型
	 * @throws
	 */
	public ZdrySdFd queryZdrySdFd(Map<String, Object> map) {
		return (ZdrySdFd) queryForObject("Zdry.queryZdrySdFdb", map);
	}	
	
	
	/**
	 * @Title: saveZdryb
	 * @Description: TODO(保存贩毒)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveZdrySdFd(ZdrySdFd entity) {
		insert("Zdry.saveZdrySdFdb", entity); 
		return entity.getId();
	}
	
	/**
	 * @Title: queryZdrySdXdList
	 * @Description: TODO(重点人员吸毒列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public List<?> queryZdrySdXdList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("Zdry.queryZdrySdXdList", map);
	}
	
	/**
	 * @Title: queryZdrySdXdListCount
	 * @Description: TODO(吸毒信息条数查询)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long queryZdrySdXdListCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("Zdry.queryZdrySdXdCount", map);
		return count.longValue();
	}
	
	/**
	 * @Title: queryZdryb
	 * @Description: TODO(吸毒人员详情查询服务)
	 * @param @param entity
	 * @param @param map
	 * @param @return    设定文件
	 * @return Zdryb    返回类型
	 * @throws
	 */
	public ZdrySdXd queryZdrySdXd(Map<String, Object> map) {
		return (ZdrySdXd) queryForObject("Zdry.queryZdrySdXdb", map);
	}	
	
	
	/**
	 * @Title: saveZdryb
	 * @Description: TODO(保存吸毒)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveZdrySdXd(ZdrySdXd entity) {
		insert("Zdry.saveZdrySdXdb", entity); 
		return entity.getId();
	}
	
	/**
	 * @Title: queryZdrySdZdList
	 * @Description: TODO(重点人员制毒列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public List<?> queryZdrySdZdList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("Zdry.queryZdrySdZdList", map);
	}
	
	/**
	 * @Title: queryZdrySdZdListCount
	 * @Description: TODO(制毒信息条数查询)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long queryZdrySdZdListCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("Zdry.queryZdrySdZdCount", map);
		return count.longValue();
	}
	
	/**
	 * @Title: queryZdryb
	 * @Description: TODO(制毒人员详情查询服务)
	 * @param @param entity
	 * @param @param map
	 * @param @return    设定文件
	 * @return Zdryb    返回类型
	 * @throws
	 */
	public ZdrySdZd queryZdrySdZd(Map<String, Object> map) {
		return (ZdrySdZd) queryForObject("Zdry.queryZdrySdZdb", map);
	}	
	
	
	/**
	 * @Title: saveZdryb
	 * @Description: TODO(保存制毒)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveZdrySdZd(ZdrySdZd entity) {
		insert("Zdry.saveZdrySdZdb", entity); 
		return entity.getId();
	}
	
	/**
	 * @Title: queryShgxrList
	 * @Description: TODO(重点人员社会关系人列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public List<?> queryShgxrList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("Zdry.queryShgxrList", map);
	}
	
	/**
	 * @Title: queryShgxrListCount
	 * @Description: TODO(社会关系人信息条数查询)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long queryShgxrListCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("Zdry.queryShgxrCount", map);
		return count.longValue();
	}
	
	/**
	 * @Title: queryZdryb
	 * @Description: TODO(社会关系人人员详情查询服务)
	 * @param @param entity
	 * @param @param map
	 * @param @return    设定文件
	 * @return Zdryb    返回类型
	 * @throws
	 */
	public Shgxrb queryShgxr(Map<String, Object> map) {
		return (Shgxrb) queryForObject("Zdry.queryShgxrb", map);
	}	
	
	
	/**
	 * @Title: saveZdryb
	 * @Description: TODO(保存社会关系人)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveShgxr(Shgxrb entity) {
		insert("Zdry.saveShgxrb", entity); 
		return entity.getObjectid();
	}
	
	/**
	 * @Title: querySaxxList
	 * @Description: TODO(涉案列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public List<?> querySaxxList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("Zdry.querySaxxList", map);
	}
	
	/**
	 * @Title: querySaxxListCount
	 * @Description: TODO(涉案信息条数查询)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long querySaxxListCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("Zdry.querySaxxCount", map);
		return count.longValue();
	}
	
	/**
	 * @Title: querySaxx
	 * @Description: TODO(涉案详情查询服务)
	 * @param @param entity
	 * @param @param map
	 * @param @return    设定文件
	 * @return Zdryb    返回类型
	 * @throws
	 */
	public Saxxb querySaxx(Map<String, Object> map) {
		return (Saxxb) queryForObject("Zdry.querySaxxb", map);
	}	
	
	
	/**
	 * @Title: saveSaxx
	 * @Description: TODO(保存涉案)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveSaxx(Saxxb entity) {
		insert("Zdry.saveSaxxb", entity); 
		return entity.getId();
	}
	
	/**
	 * @Title: queryClxxList
	 * @Description: TODO(车辆列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public List<?> queryClxxList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("Zdry.queryClxxList", map);
	}
	
	/**
	 * @Title: queryClxxListCount
	 * @Description: TODO(车辆信息条数查询)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long queryClxxListCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("Zdry.queryClxxCount", map);
		return count.longValue();
	}
	
	/**
	 * @Title: queryZdryb
	 * @Description: TODO(车辆详情查询服务)
	 * @param @param entity
	 * @param @param map
	 * @param @return    设定文件
	 * @return Zdryb    返回类型
	 * @throws
	 */
	public Clxxb queryClxx(Map<String, Object> map) {
		return (Clxxb) queryForObject("Zdry.queryClxxb", map);
	}	
	
	
	/**
	 * @Title: saveZdryb
	 * @Description: TODO(保存车辆)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveClxx(Clxxb entity) {
		insert("Zdry.saveClxxb", entity); 
		return entity.getId();
	}
	
	/**
	 * @Title: queryZdjlList
	 * @Description: TODO(诊断列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public List<?> queryZdjlList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("Zdry.queryZdjlList", map);
	}
	
	/**
	 * @Title: queryZdjlListCount
	 * @Description: TODO(诊断信息条数查询)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long queryZdjlListCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("Zdry.queryZdjlCount", map);
		return count.longValue();
	}
	
	/**
	 * @Title: queryZdryb
	 * @Description: TODO(诊断详情查询服务)
	 * @param @param entity
	 * @param @param map
	 * @param @return    设定文件
	 * @return Zdryb    返回类型
	 * @throws
	 */
	public Zdjlb queryZdjl(Map<String, Object> map) {
		return (Zdjlb) queryForObject("Zdry.queryZdjlb", map);
	}	
	
	
	/**
	 * @Title: saveZdryb
	 * @Description: TODO(保存诊断)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveZdjl(Zdjlb entity) {
		insert("Zdry.saveZdjlb", entity); 
		return entity.getId();
	}
	
	/**
	 * @Title: queryZsjlList
	 * @Description: TODO(肇事肇祸列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public List<?> queryZsjlList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("Zdry.queryZsjlList", map);
	}
	
	/**
	 * @Title: queryZsjlListCount
	 * @Description: TODO(肇事肇祸信息条数查询)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long queryZsjlListCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("Zdry.queryZsjlCount", map);
		return count.longValue();
	}
	
	/**
	 * @Title: queryZdryb
	 * @Description: TODO(肇事肇祸详情查询服务)
	 * @param @param entity
	 * @param @param map
	 * @param @return    设定文件
	 * @return Zdryb    返回类型
	 * @throws
	 */
	public Zsjlb queryZsjl(Map<String, Object> map) {
		return (Zsjlb) queryForObject("Zdry.queryZsjlb", map);
	}	
	
	
	/**
	 * @Title: saveZdryb
	 * @Description: TODO(保存肇事肇祸)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveZsjl(Zsjlb entity) {
		insert("Zdry.saveZsjlb", entity); 
		return entity.getId();
	}
	
	/**
	 * @Title: queryZdrySfList
	 * @Description: TODO(管辖单位变更列表)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public List<?> queryGxbgList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("Zdry.queryGxbgList", map);
	}
	
	/**
	 * @Title: queryGxbgListCount
	 * @Description: TODO(重点人员管辖变更总数)
	 * @param @param map
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long queryGxbgListCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("Zdry.queryGxbgListCount", map);
		return count.longValue();
	}
	
	/**
	 * @Title: saveZsjl
	 * @Description: TODO(修改管辖单位)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String updateGxdw(ZdryGxbg entity) {
		insert("Zdry.updateGxdw", entity); 
		return entity.getZdryzjhm();
	}
	
}
