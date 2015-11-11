package com.founder.zdrygl.core.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrygl.base.model.ZdryDtjsSdfdxxb;
import com.founder.zdrygl.base.model.ZdryDtjsSdxdxxb;
import com.founder.zdrygl.base.model.ZdryDtjsSdzdxxb;
import com.founder.zdrygl.base.model.ZdryDtjsSfxxb;
import com.founder.zdrygl.base.model.ZdryDtjsSwxxb;
import com.founder.zdrygl.base.model.ZdryDtjsZdxsfzqkxxb;
import com.founder.zdrygl.base.model.ZdryDtjsZszhjsbrZdjlxxb;
import com.founder.zdrygl.base.model.ZdryDtjsZszhjsbrZszhjlxxb;
import com.founder.zdrygl.base.model.ZdryDtjsZszhjsbrxxb;
import com.founder.zdrygl.base.model.ZdryDtjsZtxxb;

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
@Repository("zdryDtjsSxDao")
public class ZdryDtjsSxDao extends BaseDaoImpl {

	/**
	 * 
	 * @Title: saveZtxxb
	 * @Description: TODO(动态记实 在逃 保存)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveZtxxb(ZdryDtjsZtxxb entity) {
		insert("ZdryDtjsSx.saveZtxxb", entity); 
		return entity.getId();
	}
	
	/**
	 * 
	 * @Title: saveSwxxb
	 * @Description: TODO(动态记实 涉稳 保存)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveSwxxb(ZdryDtjsSwxxb entity) {
		insert("ZdryDtjsSx.saveSwxxb", entity); 
		return entity.getId();
	}
	
	/**
	 * 
	 * @Title: saveSfxxb
	 * @Description: TODO(动态记实 涉访 保存)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveSfxxb(ZdryDtjsSfxxb entity) {
		insert("ZdryDtjsSx.saveSfxxb", entity); 
		return entity.getId();
	}
	
	/**
	 * 
	 * @Title: saveSdxdxxb
	 * @Description: TODO(动态记实 涉毒-吸毒 保存)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveSdxdxxb(ZdryDtjsSdxdxxb entity) {
		insert("ZdryDtjsSx.saveSdxdxxb", entity); 
		return entity.getId();
	}
	
	/**
	 * 
	 * @Title: saveSdfdxxb
	 * @Description: TODO(动态记实 涉毒-贩毒 保存)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveSdfdxxb(ZdryDtjsSdfdxxb entity) {
		insert("ZdryDtjsSx.saveSdfdxxb", entity); 
		return entity.getId();
	}
	
	/**
	 * 
	 * @Title: saveSdzdxxb
	 * @Description: TODO(动态记实 涉毒-制毒 保存)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveSdzdxxb(ZdryDtjsSdzdxxb entity) {
		insert("ZdryDtjsSx.saveSdzdxxb", entity); 
		return entity.getId();
	}
	
	/**
	 * 
	 * @Title: saveZdxsfzqkxxb
	 * @Description: TODO(动态记实 重大刑事犯罪前科  保存)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveZdxsfzqkxxb(ZdryDtjsZdxsfzqkxxb entity) {
		insert("ZdryDtjsSx.saveZdxsfzqkxxb", entity); 
		return entity.getId();
	}
	
	/**
	 * 
	 * @Title: saveZszhjsbrxxb
	 * @Description: TODO(动态记实 肇事肇祸精神病  保存)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveZszhjsbrxxb(ZdryDtjsZszhjsbrxxb entity) {
		insert("ZdryDtjsSx.saveZszhjsbrxxb", entity); 
		return entity.getId();
	}
	
	public String saveZszhjsbrZdjlxxb(ZdryDtjsZszhjsbrZdjlxxb entity) {
		insert("ZdryDtjsSx.saveZszhjsbrZdjlxxb", entity); 
		return entity.getId();
	}

	public String saveZszhjsbrZszhjlxxb(ZdryDtjsZszhjsbrZszhjlxxb entity) {
		insert("ZdryDtjsSx.saveZszhjsbrZszhjlxxb", entity); 
		return entity.getId();
	}
	
	

	/**
	 * 
	 * @Title: queryDtjsZtxxList
	 * @Description: TODO(动态记实 在逃 查询列表)
	 * @param @param page
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<?>    返回类型
	 * @throws
	 */
	public List<?> queryDtjsZtxxList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("ZdryDtjsSx.queryDtjsZtxxList", map);
	}
	
	/**
	 * 
	 * @Title: queryDtjsSwxxList
	 * @Description: TODO(动态记实 涉稳 查询列表)
	 * @param @param page
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<?>    返回类型
	 * @throws
	 */
	public List<?> queryDtjsSwxxList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("ZdryDtjsSx.queryDtjsSwxxList", map);
	}
	
	/**
	 * 
	 * @Title: queryDtjsSfxxList
	 * @Description: TODO(动态记实 涉访 查询列表)
	 * @param @param page
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<?>    返回类型
	 * @throws
	 */
	public List<?> queryDtjsSfxxList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("ZdryDtjsSx.queryDtjsSfxxList", map);
	}
	
	/**
	 * 
	 * @Title: queryDtjsSdxdxxList
	 * @Description: TODO(动态记实 涉毒-吸毒 查询列表)
	 * @param @param page
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<?>    返回类型
	 * @throws
	 */
	public List<?> queryDtjsSdxdxxList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("ZdryDtjsSx.queryDtjsSdxdxxList", map);
	}
	
	/**
	 * 
	 * @Title: queryDtjsSdfdxxList
	 * @Description: TODO(动态记实 涉毒-贩毒 查询列表)
	 * @param @param page
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<?>    返回类型
	 * @throws
	 */
	public List<?> queryDtjsSdfdxxList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("ZdryDtjsSx.queryDtjsSdfdxxList", map);
	}
	
	/**
	 * 
	 * @Title: queryDtjsSdzdxxList
	 * @Description: TODO(动态记实 涉毒-制毒 查询列表)
	 * @param @param page
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<?>    返回类型
	 * @throws
	 */
	public List<?> queryDtjsSdzdxxList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("ZdryDtjsSx.queryDtjsSdzdxxList", map);
	}

	/**
	 * 
	 * @Title: queryDtjsZdxsfzqkxxList
	 * @Description: TODO(动态记实 重大刑事犯罪前科 查询列表)
	 * @param @param page
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<?>    返回类型
	 * @throws
	 */
	public List<?> queryDtjsZdxsfzqkxxList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("ZdryDtjsSx.queryDtjsZdxsfzqkxxList", map);
	}
	
	/**
	 * 
	 * @Title: queryDtjsZszhjsbrxxList
	 * @Description: TODO(动态记实  肇事肇祸精神病 查询列表)
	 * @param @param page
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<?>    返回类型
	 * @throws
	 */
	public List<?> queryDtjsZszhjsbrxxList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("ZdryDtjsSx.queryDtjsZszhjsbrxxList", map);
	}
	
	/**
	 * 
	 * @Title: queryDtjsZszhjsbrZdjlxxList
	 * @Description: TODO(动态记实  肇事肇祸精神病 诊断记录 查询列表)
	 * @param @param page
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<?>    返回类型
	 * @throws
	 */
	public List<?> queryDtjsZszhjsbrZdjlxxList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("ZdryDtjsSx.queryDtjsZszhjsbrZdjlxxList", map);
	}
	
	/**
	 * 
	 * @Title: queryDtjsZszhjsbrZszhjlxxList
	 * @Description: TODO(动态记实  肇事肇祸精神病 肇事肇祸记录 查询列表)
	 * @param @param page
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<?>    返回类型
	 * @throws
	 */
	public List<?> queryDtjsZszhjsbrZszhjlxxList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("ZdryDtjsSx.queryDtjsZszhjsbrZszhjlxxList", map);
	}
	
	/**
	 * 
	 * @Title: queryDtjsZtxxListCount
	 * @Description: TODO(动态记实 在逃 查询总数)
	 * @param @param map
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long queryDtjsZtxxListCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("ZdryDtjsSx.queryDtjsZtxxListCount", map);
		return count.longValue();
	}
	
	/**
	 * 
	 * @Title: queryDtjsSwxxListCount
	 * @Description: TODO(动态记实 涉稳 查询总数)
	 * @param @param map
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long queryDtjsSwxxListCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("ZdryDtjsSx.queryDtjsSwxxListCount", map);
		return count.longValue();
	}
	
	/**
	 * 
	 * @Title: queryDtjsSfxxListCount
	 * @Description: TODO(动态记实 涉访 查询总数)
	 * @param @param map
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long queryDtjsSfxxListCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("ZdryDtjsSx.queryDtjsSfxxListCount", map);
		return count.longValue();
	}
	
	/**
	 * 
	 * @Title: queryDtjsSdxdxxListCount
	 * @Description: TODO(动态记实  涉毒-吸毒 查询总数)
	 * @param @param map
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long queryDtjsSdxdxxListCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("ZdryDtjsSx.queryDtjsSdxdxxListCount", map);
		return count.longValue();
	}
	
	/**
	 * 
	 * @Title: queryDtjsSdfdxxListCount
	 * @Description: TODO(动态记实 涉毒-贩毒  查询总数)
	 * @param @param map
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long queryDtjsSdfdxxListCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("ZdryDtjsSx.queryDtjsSdfdxxListCount", map);
		return count.longValue();
	}
	
	/**
	 * 
	 * @Title: queryDtjsSdzdxxListCount
	 * @Description: TODO(动态记实 涉毒-制毒  查询总数)
	 * @param @param map
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long queryDtjsSdzdxxListCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("ZdryDtjsSx.queryDtjsSdzdxxListCount", map);
		return count.longValue();
	}
	
	/**
	 * 
	 * @Title: queryDtjsZdxsfzqkxxListCount
	 * @Description: TODO(动态记实 重大刑事犯罪前科  查询总数)
	 * @param @param map
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long queryDtjsZdxsfzqkxxListCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("ZdryDtjsSx.queryDtjsZdxsfzqkxxListCount", map);
		return count.longValue();
	}
	
	/**
	 * 
	 * @Title: queryDtjsZszhjsbrxxListCount
	 * @Description: TODO(动态记实 肇事肇祸精神病  查询总数)
	 * @param @param map
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long queryDtjsZszhjsbrxxListCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("ZdryDtjsSx.queryDtjsZszhjsbrxxListCount", map);
		return count.longValue();
	}

	/**
	 * 
	 * @Title: queryDtjsZszhjsbrZdjlxxListCount
	 * @Description: TODO(动态记实 肇事肇祸精神病  诊断记录 查询总数)
	 * @param @param map
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long queryDtjsZszhjsbrZdjlxxListCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("ZdryDtjsSx.queryDtjsZszhjsbrZdjlxxListCount", map);
		return count.longValue();
	}
	
	/**
	 * 
	 * @Title: queryDtjsZszhjsbrZszhjlxxListCount
	 * @Description: TODO(动态记实 肇事肇祸精神病 肇事肇祸记录  查询总数)
	 * @param @param map
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long queryDtjsZszhjsbrZszhjlxxListCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("ZdryDtjsSx.queryDtjsZszhjsbrZszhjlxxListCount", map);
		return count.longValue();	
	}

	
	
}
