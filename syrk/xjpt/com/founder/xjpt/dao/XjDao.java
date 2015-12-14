package com.founder.xjpt.dao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.xjpt.bean.Xj_ajxxb;
import com.founder.xjpt.bean.Xj_jqxxb;
import com.founder.xjpt.bean.Xj_sjxxb;
import com.founder.xjpt.bean.Zdryjbxxb;

@Repository("xjDao")
public class XjDao extends BaseDaoImpl {
	
	/**
	 * 警情
	 * @param page
	 * @param entity
	 * @return
	 */
	public EasyUIPage queryJq(EasyUIPage page, Xj_jqxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			//sort = "id";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("jqxxb", entity);
		
		 String zzjgdm = entity.getGxzrqdm();
		 String zero8 = zzjgdm.substring(zzjgdm.length()-8, zzjgdm.length());
		 String zero6 = zzjgdm.substring(zzjgdm.length()-6, zzjgdm.length());
		 String zero4 = zzjgdm.substring(zzjgdm.length()-4, zzjgdm.length());
		 if (zero8.equals("00000000")) {
			 map.put("flag", "FJ");
		 } else if(zero6.equals("000000")){
			 map.put("flag", "PCS");
		 } else if(!zero8.equals("00000000") && !zero6.equals("000000") && zero4.equals("0000")){
			 map.put("flag", "ZRQ");
		 }
		 
		//page.setTotal((Integer)queryForObject("Zdryjbxxb.queryCountZdryjbxxNoPt",map));
		//page.setRows(queryForList("Zdryjbxxb.queryZdryjbxxNoPt", map));
		//后期修改增加延时加载
		List<?> list = queryForList("Xj.queryJq", map);
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
	 * 警情
	 * @param page
	 * @param entity
	 * @return
	 */
	public long queryCountJq(Xj_jqxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("jqxxb", entity);
		
		 String zzjgdm = entity.getGxzrqdm();
		 String zero8 = zzjgdm.substring(zzjgdm.length()-8, zzjgdm.length());
		 String zero6 = zzjgdm.substring(zzjgdm.length()-6, zzjgdm.length());
		 String zero4 = zzjgdm.substring(zzjgdm.length()-4, zzjgdm.length());
		 if (zero8.equals("00000000")) {
			 map.put("flag", "FJ");
		 } else if(zero6.equals("000000")){
			 map.put("flag", "PCS");
		 } else if(!zero8.equals("00000000") && !zero6.equals("000000") && zero4.equals("0000")){
			 map.put("flag", "ZRQ");
		 }
		 
		Integer count = (Integer) queryForObject("Xj.queryCountJq",map);
		return count.longValue();
	}
	
	/**
	 * 案件
	 * @param page
	 * @param entity
	 * @return
	 */
	public EasyUIPage queryAj(EasyUIPage page, Xj_ajxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			//sort = "id";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("ajxxb", entity);
		
		 String zzjgdm = entity.getGxzrqdm();
		 String zero8 = zzjgdm.substring(zzjgdm.length()-8, zzjgdm.length());
		 String zero6 = zzjgdm.substring(zzjgdm.length()-6, zzjgdm.length());
		 String zero4 = zzjgdm.substring(zzjgdm.length()-4, zzjgdm.length());
		 if (zero8.equals("00000000")) {
			 map.put("flag", "FJ");
		 } else if(zero6.equals("000000")){
			 map.put("flag", "PCS");
		 } else if(!zero8.equals("00000000") && !zero6.equals("000000") && zero4.equals("0000")){
			 map.put("flag", "ZRQ");
		 }
		 
		//page.setTotal((Integer)queryForObject("Zdryjbxxb.queryCountZdryjbxxNoPt",map));
		//page.setRows(queryForList("Zdryjbxxb.queryZdryjbxxNoPt", map));
		//后期修改增加延时加载
		List<?> list = queryForList("Xj.queryAj", map);
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
	 * 案件
	 * @param page
	 * @param entity
	 * @return
	 */
	public long queryCountAj(Xj_ajxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ajxxb", entity);
		
		 String zzjgdm = entity.getGxzrqdm();
		 String zero8 = zzjgdm.substring(zzjgdm.length()-8, zzjgdm.length());
		 String zero6 = zzjgdm.substring(zzjgdm.length()-6, zzjgdm.length());
		 String zero4 = zzjgdm.substring(zzjgdm.length()-4, zzjgdm.length());
		 if (zero8.equals("00000000")) {
			 map.put("flag", "FJ");
		 } else if(zero6.equals("000000")){
			 map.put("flag", "PCS");
		 } else if(!zero8.equals("00000000") && !zero6.equals("000000") && zero4.equals("0000")){
			 map.put("flag", "ZRQ");
		 }
		 
		Integer count = (Integer) queryForObject("Xj.queryCountAj",map);
		return count.longValue();
	}
	
	/**
	 * 事件
	 * @param page
	 * @param entity
	 * @return
	 */
	public EasyUIPage querySj(EasyUIPage page, Xj_sjxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			//sort = "id";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("sjxxb", entity);
		//page.setTotal((Integer)queryForObject("Zdryjbxxb.queryCountZdryjbxxNoPt",map));
		//page.setRows(queryForList("Zdryjbxxb.queryZdryjbxxNoPt", map));
		//后期修改增加延时加载
		List<?> list = queryForList("Xj.querySj", map);
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
	 * 案件
	 * @param page
	 * @param entity
	 * @return
	 */
	public long queryCountSj(Xj_sjxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sjxxb", entity);
		Integer count = (Integer) queryForObject("Xj.queryCountSj",map);
		return count.longValue();
	}
	
	/***
	 * 
	 * @Title: queryZdryjbxxNoPt
	 * @Description: 重点人员基本列表查询
	 * @author wu_chunhui@founder.com.cn
	 * @param @param page
	 * @param @param entity
	 * @param @return    
	 * @return EasyUIPage    
	 * @throws
	 */
	public EasyUIPage queryZdryjbxxNoPt(EasyUIPage page, Zdryjbxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			//sort = "id";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("zdryjbxxb", entity);
		//后期修改增加延时加载
		List<?> list = queryForList("Xj.queryZdryjbxxNoPt", map);
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
	 * 延时重点人口列表统计列表记录数<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	public long queryCountZdryjbxxNoPt(Zdryjbxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("zdryjbxxb", entity);
		Integer count = (Integer) queryForObject("Xj.queryCountZdryjbxxNoPt",
				map);
		return count.longValue();
	}
}
