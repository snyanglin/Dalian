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

/**
 * @描述: 单位检查模板配置
 * @作者:yu_guangli@founder.com 
 * @日期： 2015-6-5 下午1:28:39 
 * @throws
 */
@Repository("dwjctempDao")
public class DwjctempDao  extends BaseDaoImpl {
	/**
	 * @Title: saveDwjctype 
	 * @描述: 保存到DW_DWJC_TYPE表数据
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-5 下午1:28:39 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public void saveDwjctype(Dwjctype entity, SessionBean sessionBean) {
		insert("Dwjctemp.insertDwjctype", entity);
	}
	/**
	 * @Title: queryOneDwjctype 
	 * @描述: 从DW_DWJC_TYPE表中查询单条数据
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-5 下午1:28:39 
	 * @返回值: Dwjctype    返回类型 
	 * @throws
	 */
	public Dwjctype queryOneDwjctype(Dwjctype entity){
		return (Dwjctype)queryForObject("Dwjctemp.queryOneDwjctype", entity);
	}
	/**
	 * @Title: updateDwjctype 
	 * @描述: 修改DW_DWJC_TYPE表数据
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-5 下午1:28:39 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public void updateDwjctype(Dwjctype entity, SessionBean sessionBean) {
		update("Dwjctemp.updateDwjctype", entity);
	}
	/**
	 * @Title: deleteDwjctype 
	 * @描述: 变更DW_DWJC_TYPE表数据的状态
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-5 下午1:28:39 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public void deleteDwjctype(Dwjctype entity, SessionBean sessionBean) {
		update("Dwjctemp.deleteDwjctype", entity);
	}
	/**
	 * @Title: queryDwjctype 
	 * @描述: 单位检查类型分页查询
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-5 下午1:28:39 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public EasyUIPage queryDwjctype(EasyUIPage page, Dwjctype entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		entity.setSydwlx(StringUtils.getSqlExpression(entity.getSydwlx()));
		entity.setName(StringUtils.getSqlExpression(entity.getName()));
		map.put("dwjctype", entity);
		page.setTotal((Integer) queryForObject("Dwjctemp.queryCountDwjctype",map));
		page.setRows(queryForList("Dwjctemp.queryDwjctype", map));
		return page;
	}
	/**
	 * @Title: saveDwjcdata 
	 * @描述: 保存到DW_DWJC_DATA表数据
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-5 下午1:28:39 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public void saveDwjcdata(Dwjcdata entity, SessionBean sessionBean) {
		insert("Dwjctemp.insertDwjcdata", entity);
	}
	/**
	 * @Title: queryOneDwjcdata 
	 * @描述: 从DW_DWJC_DATA表中查询单条数据
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-5 下午1:28:39 
	 * @返回值: Dwjcdata    返回类型 
	 * @throws
	 */
	public Dwjcdata queryOneDwjcdata(Dwjcdata entity){
		return (Dwjcdata)queryForObject("Dwjctemp.queryOneDwjcdata", entity);
	}
	/**
	 * @Title: updateDwjcdata 
	 * @描述: 修改DW_DWJC_DATA表数据
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-5 下午1:28:39 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public void updateDwjcdata(Dwjcdata entity, SessionBean sessionBean) {
		update("Dwjctemp.updateDwjcdata", entity);
	}
	/**
	 * @Title: deleteDwjcdata 
	 * @描述: 变更DW_DWJC_DATA表数据的状态
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-5 下午1:28:39 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public void deleteDwjcdata(Dwjcdata entity, SessionBean sessionBean) {
		update("Dwjctemp.deleteDwjcdata", entity);
	}
	/**
	 * @Title: queryDwjcdata 
	 * @描述: 单位检查项分页查询
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-5 下午1:28:39 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public EasyUIPage queryDwjcdata(EasyUIPage page, Dwjcdata entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		entity.setDef(StringUtils.getSqlExpression(entity.getDef()));
		entity.setName(StringUtils.getSqlExpression(entity.getName()));
		map.put("dwjcdata", entity);
		page.setTotal((Integer) queryForObject("Dwjctemp.queryCountDwjcdata",map));
		page.setRows(queryForList("Dwjctemp.queryDwjcdata", map));
		return page;
	}
	
	/**
	 * 单位检查类型查询
	 * @param param
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Dwjctype> queryDwjctypeTemp(Map<String,Object> param){
		List<Dwjctype> list = queryForList("Dwjctemp.queryDwjctypeTemp", param);
		return list;
	}
	
	/**
	 * 单位检查项查询
	 * @param param
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Dwjcdata> queryDwjcdataTemp(Map<String,Object> param){
		List<Dwjcdata> list = queryForList("Dwjctemp.queryDwjcdataTemp", param);
		return list;
	}
}
