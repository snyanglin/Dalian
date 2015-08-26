package com.founder.sydw.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.sydw.bean.Dwjcdata;
import com.founder.sydw.bean.Dwjctype;
import com.founder.sydw.bean.Dwjcxxb;
/**
 * ****************************************************************************
 * @Package:      [com.founder.sydw.dao.DwjcxxbDao.java]  
 * @ClassName:    [DwjcxxbDao]   
 * @Description:  [单位检查Dao]   
 * @Author:       [yu_guangli@founder.com.cn]  
 * @CreateDate:   [2015-6-8 下午4:25:58]   
 * @UpdateUser:   [yuguangli(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-8 下午4:25:58，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("dwjcxxbDao")
public class DwjcxxbDao extends BaseDaoImpl {

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	public void save(Dwjcxxb entity, SessionBean sessionBean) {
		insert("Dwjcxxb.insertDwjcxxb", entity);
	}
	
	/**
	 * 修改<br>
	 * 
	 * @param entity
	 */
	public void update(Dwjcxxb entity, SessionBean sessionBean) {
		update("Dwjcxxb.updateDwjcxxb", entity);
	}
	
	/**
	 * 查询单条<br>
	 * 
	 * @param entity
	 * @return
	 */
	public Dwjcxxb query(String id) {
		Dwjcxxb returnValue = null;
		List<?> list = queryForList("Dwjcxxb.queryDwjcxxb", id);
		if (list != null && list.size() > 0) {
			returnValue = (Dwjcxxb) list.get(0);
		}
		return returnValue;
	}
	/**
	 * 单位检查类型查询
	 * @param param
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Dwjctype> queryDwjctype(Map<String,Object> param){
		List<Dwjctype> list = queryForList("Dwjcxxb.queryDwjctype", param);
		return list;
	}
	/**
	 * 单位修改检查类型查询
	 * @param param
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Dwjctype> queryDwjcxxbtype(Map<String,Object> param){
		List<Dwjctype> list = queryForList("Dwjcxxb.queryDwjcxxbtype", param);
		return list;
	}
	/**
	 * 单位检查项查询
	 * @param param
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Dwjcdata> queryDwjcdata(Map<String,Object> param){
		List<Dwjcdata> list = queryForList("Dwjcxxb.queryDwjcdata", param);
		return list;
	}
	/**
	 * 单位修改检查项查询
	 * @param param
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Dwjcdata> queryDwjcxxbdata(Map<String,Object> param){
		List<Dwjcdata> list = queryForList("Dwjcxxb.queryDwjcxxbdata", param);
		return list;
	}
	
	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	public void saveDwjctype(Dwjctype entity, SessionBean sessionBean) {
		insert("Dwjcxxb.insertDwjctype", entity);
	}
	
	/**
	 * 新增单位检查项<br>
	 * 
	 * @param entity
	 */
	public void saveDwjcdata(Dwjcdata entity, SessionBean sessionBean) {
		insert("Dwjcxxb.insertDwjcdata", entity);
	}
	
	/**
	 * 删除单位检查类型<br>
	 * 
	 * @param entity
	 */
	public void deleteDwjctype(Dwjcxxb entity, SessionBean sessionBean) {
		delete("Dwjcxxb.deleteDwjctype", entity);
	}
	
	/**
	 * 删除单位检查类型<br>
	 * 
	 * @param entity
	 */
	public void deleteDwjcdata(Dwjcxxb entity, SessionBean sessionBean) {
		delete("Dwjcxxb.deleteDwjcdata", entity);
	}
	
	/**
	 * 
	 * @Title: queryList
	 * @Description: 查询列表-单位检查管理
	 * @param page
	 * @param entity
	 * @return EasyUIPage   返回类型
	 * @throws
	 */
	public EasyUIPage queryList(EasyUIPage page, Dwjcxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "id";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("dwjcxxb", entity);
		page.setTotal((Integer) queryForObject("Dwjcxxb.queryCountDwjcxxb", map));
		page.setRows(queryForList("Dwjcxxb.queryDwjcxxbList", map));
		return page;
	}
	/**
	 * 
	 * @Title: queryDwfsxxByDwid
	 * @Description: 根据单位ID获取消防单位的一些附属信息回填
	 * @param @param dwid
	 * @param @return    设定文件
	 * @return Dwjcxxb    返回类型
	 * @throws
	 */
	public Dwjcxxb queryDwfsxxByDwid(String dwid){
		Dwjcxxb returnValue = null;
		List<?> list = queryForList("Dwjcxxb.queryDwfsxxByDwid", dwid);
		if (list != null && list.size() > 0) {
			returnValue = (Dwjcxxb) list.get(0);
		}
		return returnValue;
	}
	
	/**
	 * 单位检查信息
	 * @param map
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Dwjcxxb> dwjcxxb_query(Map<String, Object> map) {
		return queryForList("Dwjcxxb.dwjcxxb_query", map);
	}
}
