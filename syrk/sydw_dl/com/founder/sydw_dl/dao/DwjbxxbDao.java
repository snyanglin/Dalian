package com.founder.sydw_dl.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.entity.OperationLog;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.sydw_dl.bean.Ddxxb;
import com.founder.sydw_dl.bean.Dwbmxxb;
import com.founder.sydw_dl.bean.Dwccxxb;
import com.founder.sydw_dl.bean.Dwcfxxb;
import com.founder.sydw_dl.bean.Dwjbxxb;
import com.founder.sydw_dl.bean.Dwjcxxb;
import com.founder.sydw_dl.bean.Dwyhflcxxb;
import com.founder.sydw_dl.bean.DwzybwXxb;
import com.founder.sydw_dl.bean.Frfzrllrb;
import com.founder.sydw_dl.bean.Jhsgxxb;
import com.founder.sydw_dl.bean.Ldxxb;
import com.founder.sydw_dl.bean.Yhxxb;
import com.founder.sydw_dl.vo.DwxzxxVO;
import com.founder.sydw_dl.vo.SydwgnVO;
import com.founder.sydw_dl.vo.SydwxxzsVO;


@Repository("dwjbxxbDao")
public class DwjbxxbDao extends BaseDaoImpl {

	public Dwjbxxb queryDwjbxxbById(String id) {
		return (Dwjbxxb) queryForObject("Dwjbxxb.queryById", id);
	}

	/**
	 * 根据单位ID查询法人与责任人
	 * 
	 * @param dwid
	 * @return
	 */
	public List<Frfzrllrb> queryDwfrfzrByDwid(String dwid) {
		return queryForList("Dwjbxxb.queryDwfrfzrByDwid", dwid);
	}

	/**
	 * 查询列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	public EasyUIPage queryList(EasyUIPage page, Dwjbxxb entity) {
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
		entity.setZagldwbm(StringUtils.getSqlExpression(entity.getZagldwbm()));
		entity.setDwmc(StringUtils.getSqlExpression(entity.getDwmc()));
		map.put("dwjbxxb", entity);
		page.setTotal((Integer) queryForObject("Dwjbxxb.queryCount", map));
		page.setRows(queryForList("Dwjbxxb.queryList", map));
		return page;
	}

	/**
	 * 查询单条<br>
	 * 
	 * @param entity
	 * @return
	 */
	public Dwjbxxb query(Dwjbxxb entity) {
		Dwjbxxb returnValue = null;
		List<?> list = queryForList("Dwjbxxb.query", entity);
		if (list != null && list.size() > 0) {
			returnValue = (Dwjbxxb) list.get(0);
		}
		return returnValue;
	}

	/**
	 * 查询未核实ById<br>
	 * 
	 * @param id
	 * @return
	 */
	public Dwjbxxb queryWhsById(String id) {
		Dwjbxxb returnValue = null;
		if (!StringUtils.isBlank(id)) {
			List<?> list = queryForList("Dwjbxxb.queryWhsById", id);
			if (list != null && list.size() > 0) {
				returnValue = (Dwjbxxb) list.get(0);
			}
		}
		return returnValue;
	}

	/**
	 * 查询单条，根据单位名称与单位地址代码<br>
	 * 
	 * @param dwmc
	 * @param dz_dwdzdm
	 * @return
	 */
	public Dwjbxxb queryByDwmcDwdzdm(String dwmc, String dz_dwdzdm) {
		Dwjbxxb returnValue = null;
		if (!StringUtils.isBlank(dwmc) && !StringUtils.isBlank(dz_dwdzdm)) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("dwmc", StringUtils.getSqlExpression(dwmc));
			map.put("dz_dwdzdm", StringUtils.getSqlExpression(dz_dwdzdm));
			List<?> list = queryForList("Dwjbxxb.queryByDwmcDwdzdm", map);
			if (list != null && list.size() > 0) {
				returnValue = (Dwjbxxb) list.get(0);
			}
		}
		return returnValue;
	}

	/**
	 * 判断是否存在该单位，根据单位ID、单位名称、单位地址代码<br>
	 * 
	 * @param dwmc
	 * @param dz_dwdzdm
	 * @return
	 */
	public boolean queryExistDw(String id, String dz_dwdzdm, String dwmc) {
		boolean returnValue = false;
		if (!StringUtils.isBlank(dwmc) && !StringUtils.isBlank(dz_dwdzdm)) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			map.put("dwmc", StringUtils.getSqlExpression(dwmc));
			map.put("dz_dwdzdm", StringUtils.getSqlExpression(dz_dwdzdm));
			Integer count = (Integer) queryForObject("Dwjbxxb.queryExistDw",
					map);
			if (count > 0) {
				returnValue = true;
			}
		}
		return returnValue;
	}
 
	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	public void save(Dwjbxxb entity, SessionBean sessionBean) {
		insert("Dwjbxxb.save", entity);
	}

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	public void update(Dwjbxxb entity, SessionBean sessionBean) {
		update("Dwjbxxb.update", entity);
	}
	/**
	 * @Title: dwXzUpdate 
	 * @描述: 另存为到DW_DWXZXXB表数据更新
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-9-20 下午6:28:39 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public void dwXzUpdate(DwxzxxVO entity) {
		update("Dwjbxxb.dwXzUpdate", entity);
	}
	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	public void delete(Dwjbxxb entity, SessionBean sessionBean) {
		update("Dwjbxxb.delete", entity);
	}
	/**
	 * @Title: dwXzSave 
	 * @描述:新增单位选择表 
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-9-20 下午5:40:00 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public void dwXzSave(DwxzxxVO entity) {
		insert("Dwjbxxb.dwXzSave", entity);
	}


	/**
	 * @Title: dwXzDelete 
	 * @描述: 删除DW_DWXZXXB表
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-9-20 下午6:37:16 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public void dwXzDelete(String id) {
		update("Dwjbxxb.dwXzDelete", id);
	}
	/**
	 * 查询单位展示页面配置信息
	 * 
	 * @param map
	 * @return
	 */
	public List<SydwxxzsVO> queryDwzsxx(Map<String, Object> map) {
		return queryForList("Sydwglpz.queryZhxxzspz", map);
	}

	/**
	 * 查询业务办理与可增加信息
	 * 
	 * @param map
	 * @return
	 */
	public List<SydwgnVO> queryYwglgn(Map<String, Object> map) {
		return queryForList("Sydwglpz.queryYwglgn", map);
	}

	/**
	 * 注销子项信息
	 * 
	 * @param map
	 * @return
	 */
	public int delete_xxzsnrb(Map map) {
		List<?> list = queryForList("Sydwglpz.queryxxzsnrbByxxdybm", map
				.get("url"));
		map.put("tablename", list.get(0).toString());
		if (list != null && list.size() > 0) {
			return update("Sydwglpz.updateTableByxxdybm", map);
		} else {
			return 0;
		}
	}
	/**
	 * 根据地址代码查询地址列表
	 * @param entity
	 * @return
	 */
	public List<Dwjbxxb> queryDwByDzDm(Dwjbxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dwjbxxb", entity);
		return queryForList("Dwjbxxb.queryDwByDzDm", map);
	}
	/**
	 * 获取空间图层Srid
	 * @return
	 */
	public int getSrid() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tableName", "bzdz_bzdzxxb_pt");
		map.put("shapeDbName", "GIS210200000000");
		return (Integer) queryForObject("Ryjzdzzb.queryShapetableSrid", map);
	}
	

	/**
	 * 查询旧货收购信息
	 * 
	 * @param map
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Jhsgxxb jhsgxxb_query(Map<String, Object> map) {
		return (Jhsgxxb)queryForObject("Dwjbxxb.jhsgxxb_query", map);
		
	}
	/**
	 * 查询金融单位
	 * 
	 * @param map
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Yhxxb yhxxb_query(Map<String, Object> map) {
		return  (Yhxxb) queryForObject("Dwjbxxb.yhxxb_query", map);
		
	}
	
	/**
	 * 银行分理处信息
	 * 
	 * @param map
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Dwyhflcxxb> dwyhflcxxb_query(Map<String, Object> map) {
		return queryForList("Dwjbxxb.dwyhflcxxb_query", map);
		
	}
	/**
	 * 单位仓储信息
	 * 
	 * @param map
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Dwccxxb> dwccxxb_query(Map<String, Object> map) {
		return  queryForList("Dwjbxxb.dwccxxb_query", map);
	}								  
	
	
	
	/**
	 * 旅馆业信息
	 * @param map
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Ldxxb ldxxb_query(Map<String, Object> map) {
		return (Ldxxb)queryForObject("Ldxxb.ldxxb_query", map);
	}
	
	/**
	 * 典当业信息
	 * @param map
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Ddxxb ddxxb_query(Map<String, Object> map) {
		return (Ddxxb)queryForObject("Ddxxb.ddxxb_query", map);
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

	
	/**
	 * 单位处罚信息
	 * @param map
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Dwcfxxb> dwcfxxb_query(Map<String, Object> map) {
		return queryForList("Dwcfxx.dwcfxxb_query", map);
	}

	
	
	/**
	 * 重要部位
	 * @param map
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DwzybwXxb> dwzybwxxb_query(Map<String, Object> map) {
		return queryForList("Dwzybw.dwzybwxxb_query", map);
	}
	
	
	/**
	 * 查询联系方式<br>
	 * 
	 * @param lxfs
	 * @param ryid
	 * @return
	 */
	public boolean queryLxfsValid(String lxdh, String dwid) {
		boolean returnValue = true;
		if (!StringUtils.isBlank(lxdh)) {
			Map map = new HashMap();
			map.put("lxdh", lxdh);
			map.put("dwid", dwid);
			Long count = (Long) queryForObject("Dwlxfszb.queryDwLxfsValid", map);
			if (count > 0) {
				returnValue = false;
			}
		}
		return returnValue;
	}
	
	public Long queryExistLxfs(Map map) {
		return (Long) queryForObject("Dwlxfszb.queryDwLxfsExist", map);
	}
	
	/**
	 * 查询单位别名表By单位dwid<br>
	 * 
	 * @param dwid
	 * @return
	 */
	public List<Dwbmxxb> queryDwbmxxbByDwid(String dwid) {
		List<Dwbmxxb> list = null;
		if (!StringUtils.isBlank(dwid)) {
			list = queryForList("Dwjbxxb.queryDwbmxxbByDwid", dwid);
		}
		return list;
	}
	/**
	 * 判断是否存在该单位，根据单位ID、单位别名
	 * 
	 * @param dwmc
	 * @param dz_dwdzdm
	 * @return
	 */
	public boolean queryExistBm(String id, String dwbm) {
		boolean returnValue = false;
		if (!StringUtils.isBlank(dwbm)) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			map.put("dwbm",dwbm);
			Integer count = (Integer) queryForObject("Dwjbxxb.queryExistDwbm",
					map);
			if (count > 0) {
				returnValue = true;
			}
		}
		return returnValue;
	}
	
	/**
	 * 新增单位别名<br>
	 * 
	 * @param entity
	 */
	public void saveDwbmxxb(Dwbmxxb entity, SessionBean sessionBean) {
		insert("Dwjbxxb.saveDwbmxxb", entity);
	}

	/**
	 * 更新单位别名<br>
	 * 
	 * @param entity
	 */
	public void updateDwbmxxb(Dwbmxxb entity, SessionBean sessionBean) {
		update("Dwjbxxb.updateDwbmxxb", entity);
	}

	
	public void deteleDwbm(String dwid){
		delete("Dwjbxxb.deleteDwbmxxb", dwid);
	}		
	
	
	public String queryDwbh(String dwbh,Integer zl){
		Map map = new HashMap();
		map.put("dwbh", dwbh);
		map.put("zl", zl);
		map.put("result", "");
		queryForObject("Dwjbxxb.queryDwbh",map);
		String result = map.get("result").toString();
		return result;
	}
	
	/*
	 * 查询当前企业日志记录信息
	 */
	public List<OperationLog> queryDwjqdtjl(Map map){
		List<OperationLog> list = null;
		if (!StringUtils.isBlank(map.get("dwid"))) {
			list = queryForList("Dwjbxxb.dwjqdt_query", map);
		}
		return list;
	}

}
