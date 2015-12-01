package com.founder.zdry.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zdry.bean.ZdryZdrykcxxb;

/******************************************************************************
 * @Package: [com.founder.zdry.dao.ZdryZdrykcxxbDao.java]
 * @ClassName: [ZdryZdrykcxxbDao]
 * @Description: [重点人员补充信息－考察]
 * @Author: [hongguanjun]
 * @CreateDate: [2015-3-12 上午10:07:21]
 * @UpdateUser: [hongguanjun(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-3-12 上午10:07:21，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@Repository("zdryZdrykcxxbDao")
public class ZdryZdrykcxxbDao extends BaseDaoImpl {

	/**
	 * 查询列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	public EasyUIPage queryList(EasyUIPage page, ZdryZdrykcxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "kc_sj";
			order = "desc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("zdryZdrykcxxb", entity);
		page.setTotal((Integer) queryForObject("ZdryZdrykcxxb.queryCount", map));
		page.setRows(queryForList("ZdryZdrykcxxb.queryList", map));
		return page;
	}

	/**
	 * 查询列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	public List<ZdryZdrykcxxb> queryViewList(Map<String, Object> map) {
		List<ZdryZdrykcxxb> list = null;
		if (map != null) {
			String zdryid = (String) map.get("zdryid");
			if (!StringUtils.isBlank(zdryid)) {
				list = queryForList("ZdryZdrykcxxb.queryViewList", map);
			}
		}
		return list;
	}

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return ZdryZdrykcxxb 返回类型
	 * @throws
	 */
	public ZdryZdrykcxxb queryById(String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		} else {
			return (ZdryZdrykcxxb) queryForObject("ZdryZdrykcxxb.queryById", id);
		}
	}

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	public void save(ZdryZdrykcxxb entity, SessionBean sessionBean) {
		insert("ZdryZdrykcxxb.save", entity);
	}

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	public void update(ZdryZdrykcxxb entity, SessionBean sessionBean) {
		update("ZdryZdrykcxxb.update", entity);
	}

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	public void delete(ZdryZdrykcxxb entity, SessionBean sessionBean) {
		update("ZdryZdrykcxxb.delete", entity);
	}

}
