package com.founder.dbrw.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.dbrw.bean.DbrwDbrwb;
import com.founder.dbrw.bean.DbrwDbrwfkb;
import com.founder.dbrw.bean.DbrwDbrwsjmxb;
import com.founder.dbrw.bean.RuleYwxtgzrwlsjlb;
import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;

/**
 * ****************************************************************************
 * 
 * @Package: [com.founder.dbrw.dao.DbrwDbrwbDao.java]
 * @ClassName: [DbrwDbrwbDao]
 * @Description: [督办任务DAO]
 * @Author: [weiwen]
 * @CreateDate: [2014-10-26 下午4:35:43]
 * @UpdateUser: [weiwen(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2014-10-26 下午4:35:43，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@Repository("dbrwDbrwbDao")
public class DbrwDbrwbDao extends BaseDaoImpl {

	public DbrwDbrwb queryById(String id) {
		return (DbrwDbrwb) queryForObject("DbrwDbrwb.queryDbrwb", id);
	}

	public EasyUIPage queryList(EasyUIPage page, DbrwDbrwb rwb) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "XT_CJSJ";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("entity", rwb);
		page
				.setTotal((Integer) queryForObject("DbrwDbrwb.queryDbrwCount",
						map));
		page.setRows(queryForList("DbrwDbrwb.queryDbrwList", map));
		return page;
	}

	public EasyUIPage queryList(EasyUIPage page, DbrwDbrwb rwb, String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		map.put("id", id);
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "XT_CJSJ";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("entity", rwb);
		page
				.setTotal((Integer) queryForObject("DbrwDbrwb.queryDbrwCount",
						map));
		List<DbrwDbrwb> list = new ArrayList<DbrwDbrwb>();
		list.add((DbrwDbrwb) queryForObject("DbrwDbrwb.queryDbrwb", id));
		list.addAll(queryForList("DbrwDbrwb.queryDbrwList", map));
		page.setRows(list);
		return page;
	}

	public EasyUIPage rwmxlist(EasyUIPage page, DbrwDbrwsjmxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "XT_CJSJ";
			order = "asc";
		}
		if ("sszrqmc".equals(sort)) {
			sort = "sszrqdm";
		}
		map.put("sort", sort);
		map.put("order", order);
		entity.setDbsjx1(StringUtils.getSqlExpression(entity.getDbsjx1()));
		entity.setDbsjx2(StringUtils.getSqlExpression(entity.getDbsjx2()));
		entity.setDbsjx3(StringUtils.getSqlExpression(entity.getDbsjx3()));
		entity.setDbsjx4(StringUtils.getSqlExpression(entity.getDbsjx4()));
		entity.setDbsjx5(StringUtils.getSqlExpression(entity.getDbsjx5()));
		entity.setDbsjx6(StringUtils.getSqlExpression(entity.getDbsjx6()));
		entity.setDbsjx7(StringUtils.getSqlExpression(entity.getDbsjx7()));
		entity.setDbsjx8(StringUtils.getSqlExpression(entity.getDbsjx8()));
		entity.setDbsjx9(StringUtils.getSqlExpression(entity.getDbsjx9()));
		map.put("dbrwDbrwsjmxb", entity);
		page.setTotal((Integer) queryForObject("DbrwRwcl.queryDbrwsjmxbCount",
				map));
		page.setRows(queryForList("DbrwRwcl.queryDbrwsjmxb", map));
		return page;
	}

	public List<DbrwDbrwfkb> queryCountArray(String rwid) {
		return queryForList("DbrwDbrwb.queryCountArray", rwid);
	}

	public List<DbrwDbrwfkb> queryCountTotal(String rwid) {
		return queryForList("DbrwDbrwb.queryCountTotal", rwid);
	}

	/**
	 * sny
	 * 
	 * @Title: queryDbList
	 * @Description: TODO(更多督办功能查询)
	 * @param @param page
	 * @param @param db
	 * @param @return 设定文件
	 * @return EasyUIPage 返回类型
	 * @throws
	 */
	public EasyUIPage queryDbList(EasyUIPage page, DbrwDbrwb db) {
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
		map.put("db", db);
		// 后期修改增加延时加载
		List<?> list = queryForList("DbrwDbrwb.queryDb", map);
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
	 * sny
	 * 
	 * @Title: queryDbTotal
	 * @Description: TODO(更多督办功能总条数)
	 * @param @param entity
	 * @param @return 设定文件
	 * @return long 返回类型
	 * @throws
	 */
	public long queryDbTotal(DbrwDbrwb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("db", entity);
		Integer count = (Integer) queryForObject("DbrwDbrwb.queryDbCount", map);
		return count.longValue();
	}
	
	//begin
	/**
	 * sny
	 * 
	 * @Title: queryDbList
	 * @Description: TODO(更多督办功能查询)
	 * @param @param page
	 * @param @param db
	 * @param @return 设定文件
	 * @return EasyUIPage 返回类型
	 * @throws
	 */
	public EasyUIPage queryXtList(EasyUIPage page, RuleYwxtgzrwlsjlb db) {
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
		map.put("db", db);
		// 后期修改增加延时加载
		List<?> list = queryForList("RuleYwxtgzrwlsjlb.querys", map);
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
	 * sny
	 * 
	 * @Title: queryDbTotal
	 * @Description: TODO(更多督办功能总条数)
	 * @param @param entity
	 * @param @return 设定文件
	 * @return long 返回类型
	 * @throws
	 */
	public long queryXtTotal(RuleYwxtgzrwlsjlb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("db", entity);
		Integer count = (Integer) queryForObject("RuleYwxtgzrwlsjlb.queryCounts", map);
		return count.longValue();
	}

	public RuleYwxtgzrwlsjlb queryXtById(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		RuleYwxtgzrwlsjlb entity = new RuleYwxtgzrwlsjlb();
		entity.setId(id);
		map.put("db", entity);
		return (RuleYwxtgzrwlsjlb) queryForObject("RuleYwxtgzrwlsjlb.queryById", map);
	}
	
	/**
	 * sny
	 * 
	 * @Title: queryDbList
	 * @Description: TODO(更多督办功能查询)
	 * @param @param page
	 * @param @param db
	 * @param @return 设定文件
	 * @return EasyUIPage 返回类型
	 * @throws
	 */
	public EasyUIPage queryMsgList(EasyUIPage page, SysMessage db) {
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
		map.put("db", db);
		// 后期修改增加延时加载
		List<?> list = queryForList("Ywxtgzrwb.queryYwxtgzrwbByParm", map);
		List<SysMessage> lists = new ArrayList<SysMessage>();
		Map<String, Object> maps = new HashMap<String, Object>();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			SysMessage msg = (SysMessage)list.get(i);
			String fssj = msg.getFssj();
			String xxnr = msg.getXxnr();
			String jsr = msg.getJsr();
			maps.put(fssj+"-"+xxnr, jsr);
		}
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
	 * sny
	 * 
	 * @Title: queryDbTotal
	 * @Description: TODO(更多督办功能总条数)
	 * @param @param entity
	 * @param @return 设定文件
	 * @return long 返回类型
	 * @throws
	 */
	public long queryMsgTotal(SysMessage entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("db", entity);
		Integer count = (Integer) queryForObject("Ywxtgzrwb.queryYwxtgzrwbByCount", map);
		return count.longValue();
	}
	
	
	public String backMsg(String id) {
		List list = new ArrayList();
		String [] str = id.split(",");
		for (int i = 0; i < str.length; i++) {
			SysMessage entity = new SysMessage();
			entity.setId(Long.parseLong(str[i]));
			list.add(entity);
		}
		
		int r = delete("Ywxtgzrwb.backMsg", list);
		return r+"";
	}
	
	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("1", "a, b");
		map.put("1", "c, d");
		System.out.println(map);
	}
	
}
