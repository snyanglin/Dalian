package com.founder.sydw_dl.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.config.SystemConfig;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.sydw_dl.bean.Dwjbxxb;
import com.founder.sydw_dl.vo.SydwxxzsVO;

@Repository("sydwQueryDao")
public class SydwQueryDao extends BaseDaoImpl {
	/**
	 * 实有单位地址坐标查询 <br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	public EasyUIPage queryDw(EasyUIPage page, Dwjbxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			// sort = "id";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		entity.setZagldwbm(StringUtils.getSqlExpression(entity.getZagldwbm()));
		entity.setDwmc(StringUtils.getSqlExpression(entity.getDwmc()));

		map.put("dwjbxxb", entity);

		 page.setTotal((Integer) queryForObject("SydwQuery.queryCountDw",
		 map));
		 page.setRows(queryForList("SydwQuery.queryDw", map));
		// 后期修改增加延时加载
//		List<?> list = queryForList("SydwQuery.queryDw", map);
//		if (page.getBegin() == 0) {
//			if (list != null && list.size() > 0) {
//				page.setTotal(list.size());
//			} else {
//				page.setTotal(0);
//			}
//		} else {
//			if (page.getTotal() == 0) {
//				if (list != null && list.size() > 0) {
//					page.setTotal(list.size());
//				}
//			}
//		}
//		page.setRows(list);
		return page;
	}

	/**
	 * 延时实有单位列表统计列表记录数<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	public long queryCountDw(Dwjbxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dwjbxxb", entity);
		Integer count = (Integer) queryForObject("SydwQuery.queryCountDw", map);
		return count.longValue();
	}

	/**
	 * 根据单位id查询坐标列表
	 * 
	 * @param dwid
	 * @return
	 */
	public List<Dwjbxxb> queryZbByDzId(String dwid) {
		List<Dwjbxxb> list = null;
		Map<String, Object> map = new HashMap<String, Object>();

		if (!StringUtils.isBlank(dwid)) {
			map.put("dwid", dwid);
			list = queryForList("SydwQuery.queryZbByDzId", map);
		}
		return list;
	}

	/**
	 * 实有单位核实列表
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	public EasyUIPage queryDwHs(EasyUIPage page, Dwjbxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			// sort = "id";
			order = "asc";
		}
		map.put("sort", StringUtils.nullToStr(sort));
		map.put("order", StringUtils.nullToStr(order));
		entity.setZagldwbm(StringUtils.getSqlExpression(entity.getZagldwbm()));
		entity.setDwmc(StringUtils.getSqlExpression(entity.getDwmc()));
		map.put("dwjbxxb", entity);
		// page.setTotal((Integer) queryForObject("SydwQuery.queryCountDwHs",
		// map));
		// page.setRows(queryForList("SydwQuery.queryDwHs", map));
		// 后期修改增加延时加载
		List<?> list = queryForList("SydwQuery.queryDwHs", map);
		if (page.getBegin() == 0) {
			if (list != null && list.size() > 0) {
				page.setTotal(list.size());
			} else {
				page.setTotal(0);
			}
		} else {
			if (page.getTotal() == 0) {
				if (list != null && list.size() > 0) {
					page.setTotal(list.size());
				}
			}
		}
		page.setRows(list);
		return page;
	}

	/**
	 * 延时实有单位核实列表统计列表记录数<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	public long queryCountSydwHs(Dwjbxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dwjbxxb", entity);
		Integer count = (Integer) queryForObject("SydwQuery.queryCountDwHs",
				map);
		return count.longValue();
	}

	/**
	 * 更新单位表
	 * 
	 * @param entity
	 * @return
	 */
	public int updateDwhsById(Dwjbxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dwjbxxb", entity);
		return update("SydwQuery.updateDwhsById", map);
	}



	/**
	 * 实有单位在地图上查询
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	public EasyUIPage queryDwDzOnPT(EasyUIPage page, Dwjbxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			// sort = "id";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		entity.setDwmc(StringUtils.getSqlExpression(entity.getDwmc()));
		entity.setZagldwbm(StringUtils.getSqlExpression(entity.getZagldwbm()));
		entity.setSrid(getSrid());
		map.put("dwjbxxb", entity);
		// page.setTotal((Integer)
		// queryForObject("SydwQuery.queryCountDwDzOnPT", map));
		// page.setRows(queryForList("SydwQuery.queryDwDzOnPT", map));
		// 后期修改增加延时加载
		List<?> list = queryForList("SydwQuery.queryDwDzOnPT", map);
		if (page.getBegin() == 0) {
			if (list != null && list.size() > 0) {
				page.setTotal(list.size());
			} else {
				page.setTotal(0);
			}
		} else {
			if (page.getTotal() == 0) {
				if (list != null && list.size() > 0) {
					page.setTotal(list.size());
				}
			}
		}
		page.setRows(list);
		return page;
	}

	/**
	 * 延时实有单位列表统计列表记录数<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	public long queryCountSydw(Dwjbxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dwjbxxb", entity);
		Integer count = (Integer) queryForObject(
				"SydwQuery.queryCountDwDzOnPT", map);
		return count.longValue();
	}

	/**
	 * 获取空间图层Srid
	 * 
	 * @return
	 */
	public int getSrid() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tableName", "bzdz_bzdzxxb_pt");
		map.put("shapeDbName", SystemConfig.getString("gisUser"));
		return (Integer) queryForObject("SydwQuery.queryShapetableSrid", map);
	}

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	public void delete(Dwjbxxb entity) {
		update("SydwQuery.cancelDw", entity);
	}

	/**
	 * @Title: dwXzDelete
	 * @描述: 删除DW_DWXZXXB表
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-9-20 下午6:37:16
	 * @返回值: void 返回类型
	 * @throws
	 */
	public void dwXzDelete(String id) {
		update("SydwQuery.dwXzDelete", id);
	}

	public int getCountByCol(Map<String, Object> map) {
		return (Integer) queryForObject("Sydwglpz.getCountByCol", map);
	}

	public int delete_xxzsnrb(Map<String, Object> map) {
		int returnNum = 0;
		List<SydwxxzsVO> list = queryForList("Sydwglpz.queryxxzsnrbByxxdybm",
				map.get("url"));
		SydwxxzsVO infovo = null;
		if (list.size() > 0) {
			infovo = list.get(0);
		}
		String xxdybm = infovo.getXxdybm();
		String bmdyzb = infovo.getBmdyzb();
		if (xxdybm != null && !"".equals(xxdybm)) {
			map.put("tablename", xxdybm);
			returnNum = update("Sydwglpz.updateTableByxxdybm", map);
		}
		// 此处解开子表 多表用','间隔。表和字段之间用'&'间隔
		if (bmdyzb != null && !"".equals(bmdyzb)) {
			List<String> childIdList = new ArrayList<String>();
			String childTable = "";
			String childCloumn = "";
			if (bmdyzb.indexOf(",") >= 0) {
				String[] bmdyzbS = bmdyzb.split(",");
				for (int i = 0; i < bmdyzbS.length; i++) {
					String[] childTableAndCloumn = bmdyzbS[i].split("&");
					childTable = childTableAndCloumn[0];
					childCloumn = childTableAndCloumn[1];
					map.put("childTable", childTable);
					map.put("childCloumn", childCloumn);
					List<String> idList = queryForList(
							"Sydwglpz.queryChildTableId", map);
					childIdList.addAll(idList);
				}
			} else {
				String[] childTableAndCloumn = bmdyzb.split("&");
				childTable = childTableAndCloumn[0];
				childCloumn = childTableAndCloumn[1];
				map.put("childTable", childTable);
				map.put("childCloumn", childCloumn);
				List<String> idList = queryForList(
						"Sydwglpz.queryChildTableId", map);
				childIdList.addAll(idList);
			}

			map.put("tablename", map.get("childTable"));
			for (int j = 0; j < childIdList.size(); j++) {
				map.put("id", childIdList.get(j).toString());
				returnNum = update("Sydwglpz.updateTableByxxdybm", map);
			}
		}
		return returnNum;

	}
}
