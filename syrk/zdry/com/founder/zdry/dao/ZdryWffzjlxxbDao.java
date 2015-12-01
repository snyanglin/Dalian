package com.founder.zdry.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zdry.bean.ZdryWffzjlxxb;

/******************************************************************************
 * @Package: [com.founder.zdry.dao.ZdryWffzjlxxbDao.java]
 * @ClassName: [ZdryWffzjlxxbDao]
 * @Description: [重点人员补充信息－违法犯罪记录]
 * @Author: [hongguanjun]
 * @CreateDate: [2015-3-12 上午10:07:21]
 * @UpdateUser: [hongguanjun(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-3-12 上午10:07:21，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@Repository("zdryWffzjlxxbDao")
public class ZdryWffzjlxxbDao extends BaseDaoImpl {

	/**
	 * 查询列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	public EasyUIPage queryList(EasyUIPage page, ZdryWffzjlxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "djsj";
			order = "desc";
		}
		map.put("sort", sort);
		map.put("order", order);
		entity.setAjmc(StringUtils.getSqlExpression(entity.getAjmc()));
		map.put("zdryWffzjlxxb", entity);
		page.setTotal((Integer) queryForObject("ZdryWffzjlxxb.queryCount", map));
		page.setRows(queryForList("ZdryWffzjlxxb.queryList", map));
		return page;
	}

	/**
	 * 查询列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	public List<ZdryWffzjlxxb> queryViewList(Map<String, Object> map) {
		List<ZdryWffzjlxxb> list = null;
		if (map != null) {
			String zdryid = (String) map.get("zdryid");
			if (!StringUtils.isBlank(zdryid)) {
				list = queryForList("ZdryWffzjlxxb.queryViewList", map);
			}
		}
		return list;
	}

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return ZdryWffzjlxxb 返回类型
	 * @throws
	 */
	public ZdryWffzjlxxb queryById(String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		} else {
			return (ZdryWffzjlxxb) queryForObject("ZdryWffzjlxxb.queryById", id);
		}
	}

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	public void save(ZdryWffzjlxxb entity, SessionBean sessionBean) {
		insert("ZdryWffzjlxxb.save", entity);
	}

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	public void update(ZdryWffzjlxxb entity, SessionBean sessionBean) {
		update("ZdryWffzjlxxb.update", entity);
	}

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	public void delete(ZdryWffzjlxxb entity, SessionBean sessionBean) {
		update("ZdryWffzjlxxb.delete", entity);
	}

}
