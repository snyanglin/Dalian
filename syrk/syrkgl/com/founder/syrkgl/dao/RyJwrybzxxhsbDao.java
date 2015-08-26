package com.founder.syrkgl.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.syrkgl.webservice.jwry.residence.Inhabitancy;
import com.founder.syrkgl.webservice.jwry.residence.ResidenceInfo;
import com.founder.syrkgl.webservice.jwry.residence.Workplace;

/**
 * @类名: RyJwrybzxxhsbDao
 * @描述: 境外人员办证信息核实
 * @作者: zhang_guoliang@founder.com
 * @日期: 2015-6-17 下午2:20:21
 */
@Repository("ryJwrybzxxhsbDao")
public class RyJwrybzxxhsbDao extends BaseDaoImpl {
	/**
	 * @Title: queryJwryHsxf
	 * @描述: 境外人员核实下发列表
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-6-15 下午5:41:08
	 * @返回值: EasyUIPage 返回类型
	 * @throws
	 */
	public EasyUIPage queryJwryHsxf(EasyUIPage page, ResidenceInfo entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		map.put("entity", entity);
		page.setRows(queryForList("RyJwrybzxxhsb.queryJwryHsxfList", map));
		page.setTotal((Integer) queryForObject(
				"RyJwrybzxxhsb.queryJwryHsxfCount", map));
		return page;
	}

	/**
	 * @Title: reporteInhabitancyInfo 
	 * @描述: 常住境外人员居住地信息核实反馈
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public void reporteInhabitancyInfo(Inhabitancy entity) {
		ResidenceInfo jbxx = new ResidenceInfo();
		jbxx.setPersonNO(entity.getPersonNO());
		jbxx.setSjzt("1");
		//update("RyJwrybzxxhsb.updateResidenceInfo", jbxx);
		update("RyJwrybzxxhsb.reporteInhabitancyInfo", entity);
	}

	/**
	 * @Title: saveResidenceInfo
	 * @描述: 境外常驻人员基本信息
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @返回值: void 返回类型
	 * @throws
	 */
	public void saveResidenceInfo(ResidenceInfo res) {
		insert("RyJwrybzxxhsb.saveResidenceInfo", res);
	}

	/**
	 * @Title: saveInhabitancy
	 * @描述: 境外常驻人员居住地信息
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @返回值: void 返回类型
	 * @throws
	 */
	public void saveInhabitancy(Inhabitancy ins) {
		insert("RyJwrybzxxhsb.saveInhabitancy", ins);
	}

	/**
	 * @Title: saveWorkplace
	 * @描述: 境外常驻人员工作地信息
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @返回值: void 返回类型
	 * @throws
	 */
	public void saveWorkplace(Workplace wos) {
		insert("RyJwrybzxxhsb.saveWorkplace", wos);
	}
	/**
	 * @Title: queryResidenceInfo 
	 * @描述: 查询常住境外人员信息
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @返回值: ResidenceInfo    返回类型 
	 * @throws
	 */
	public ResidenceInfo queryResidenceInfo(String personNO,String inhabiBusinessNO) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("personNO", personNO);
		map.put("inhabiBusinessNO", inhabiBusinessNO);
		ResidenceInfo returnValue = null;
		List<?> list = queryForList("RyJwrybzxxhsb.queryResidenceInfo", map);
		if (list != null && list.size() > 0) {
			returnValue = (ResidenceInfo) list.get(0);
		}
		return returnValue;
	}
	/**
	 * @Title: queryInhabitancy 
	 * @描述: 查询境外常驻人员居住地信息表
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @返回值: Inhabitancy    返回类型 
	 * @throws
	 */
	public Inhabitancy queryInhabitancy(String personNO,String inhabiBusinessNO) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("personNO", personNO);
		map.put("inhabiBusinessNO", inhabiBusinessNO);
		Inhabitancy returnValue = null;
		List<?> list = queryForList("RyJwrybzxxhsb.queryInhabitancy", map);
		if (list != null && list.size() > 0) {
			returnValue = (Inhabitancy) list.get(0);
		}
		return returnValue;
	}
}