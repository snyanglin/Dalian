package com.founder.dbrw.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.dbrw.bean.DbrwDbrwb;
import com.founder.dbrw.bean.DbrwDbrwfkb;
import com.founder.dbrw.bean.DbrwDdbrwb;
import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;

@Repository("dbrwDdbrwbDao")
public class DbrwDdbrwbDao extends BaseDaoImpl {

	/**
	 * 查询单条待督办任务<br>
	 * 
	 * @param id
	 * @return DbrwDbpzb
	 */
	public DbrwDdbrwb queryDdbrwb(String id) {
		return (DbrwDdbrwb) queryForObject("DbrwDdbrwb.queryDdbrwb", id);
	}

	/**
	 * 查询待督办任务数据明细列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	public EasyUIPage querySjmxbList(EasyUIPage page, DbrwDdbrwb entity) {
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
		map.put("ddbrwid", entity.getId());
		map.put("ywfl", entity.getYwfl());
		if ("1".equals(entity.getYwfl())) {
			map.put("ddbsjx1", StringUtils
					.getSqlExpression(entity.getDdbsjx1()));
		} else {
			map.put("ddbsjx1", entity.getDdbsjx1());
		}
		map.put("ddbsjx2", StringUtils.getSqlExpression(entity.getDdbsjx2()));
		map.put("ddbsjx3", StringUtils.getSqlExpression(entity.getDdbsjx3()));
		map.put("ddbsjx4", StringUtils.getSqlExpression(entity.getDdbsjx4()));
		map.put("ddbsjx5", StringUtils.getSqlExpression(entity.getDdbsjx5()));
		map.put("ddbsjx6", StringUtils.getSqlExpression(entity.getDdbsjx6()));
		map.put("ddbsjx7", StringUtils.getSqlExpression(entity.getDdbsjx7()));
		map.put("ddbsjx8", StringUtils.getSqlExpression(entity.getDdbsjx8()));
		map.put("ddbsjx9", StringUtils.getSqlExpression(entity.getDdbsjx9()));
		map.put("sszrqdm", StringUtils.getSqlExpression(entity.getSszrqdm()));
		page.setTotal((Integer) queryForObject(
				"DbrwDdbrwb.queryDdbrwSjmxbCount", map));
		page.setRows(queryForList("DbrwDdbrwb.queryDdbrwSjmxbList", map));
		return page;
	}

	/**
	 * 删除单条待督办任务数据明细<br>
	 * 
	 * @param id
	 *            待督办任务数据明细ID
	 */
	public void deleteDdbrwSjmxbById(String id) {
		if (!StringUtils.isBlank(id)) {
			delete("DbrwDdbrwb.deleteDdbrwSjmxbById", id);
		}
	}

	/**
	 * 将待督办任务转入督办任务<br>
	 * 
	 * @param entity
	 *            void
	 */
	public void insertDbrwb(DbrwDbrwb entity) {
		insert("DbrwDdbrwb.insertDbrwb", entity);
	}

	/**
	 * 将待督办数据明细转入督办数据明细表<br>
	 * 
	 * @param dbrwid
	 *            督办任务ID
	 * @param ddbrwid
	 *            待督办任务ID void
	 */
	public void insertDbsjmxb(Map<String, String> coultMap) {
		String selectAllMx = coultMap.get("selectAllMx");
		if ("1".equals(selectAllMx)) { // 选择满足条件的所有数据
			insert("DbrwDdbrwb.insertDbsjmxb", coultMap);
		} else { // 手工选择的部分数据
			insert("DbrwDdbrwb.insertDbsjmxbSelected", coultMap);
		}
	}

	/**
	 * 查询督办任务消息发送单位<br>
	 * 
	 * @param ddbrwid
	 *            待督办任务ID
	 * @return String
	 */
	public String queryDbrwMessageOrg(Map<String, String> coultMap) {
		StringBuffer sb = new StringBuffer();
		List<String> list = queryForList("DbrwDdbrwb.queryDbrwMessageOrg",
				coultMap);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				sb.append(list.get(i));
				if (i < list.size() - 1) {
					sb.append(",");
				}
			}
		}
		return sb.toString();
	}

	/**
	 * 删除单条待督办任务<br>
	 * 
	 * @param entity
	 */
	public void deleteDdbrwb(Map<String, String> coultMap) {
		if (!StringUtils.isBlank(coultMap.get("ddbrwid"))) {
			String selectAllMx = coultMap.get("selectAllMx");
			if ("1".equals(selectAllMx)) { // 选择满足条件的所有数据
				delete("DbrwDdbrwb.deleteDdbrwSjmxb", coultMap);
			} else { // 手工选择的部分数据
				delete("DbrwDdbrwb.deleteDdbrwSjmxbSelected", coultMap);
			}
			int count = (Integer) queryForObject(
					"DbrwDdbrwb.queryExistDdbrwSjmxbCount", coultMap);
			if (count == 0) { // 不存在明细数据则删除待督办任务
				delete("DbrwDdbrwb.deleteDdbrwb", coultMap);
			}
		}
	}

	/**
	 * 查询督办任务反馈表任务总数量 <br>
	 * 
	 * @param coultMap
	 * @return Long
	 */
	public Long queryDbrwfkbRwzsl(Map<String, String> coultMap) {
		return (Long) queryForObject("DbrwDdbrwb.queryDbrwfkbRwzsl", coultMap);
	}

	/**
	 * 插入督办任务反馈表 <br>
	 * 
	 * @param entity
	 *            void
	 */
	public void insertDbrwDbrwfkb(DbrwDbrwfkb entity) {
		insert("DbrwDdbrwb.insertDbrwDbrwfkb", entity);
	}

}
