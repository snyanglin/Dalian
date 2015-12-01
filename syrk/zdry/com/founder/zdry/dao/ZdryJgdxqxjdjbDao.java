package com.founder.zdry.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zdry.bean.ZdryJgdxqxjdjb;

/******************************************************************************
 * @Package: [com.founder.zdry.dao.ZdryJgdxqxjdjbDao.java]
 * @ClassName: [ZdryJgdxqxjdjbDao]
 * @Description: [重点人员补充信息－监管对象请销假]
 * @Author: [hongguanjun]
 * @CreateDate: [2015-3-12 上午10:07:21]
 * @UpdateUser: [hongguanjun(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-3-12 上午10:07:21，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@Repository("zdryJgdxqxjdjbDao")
public class ZdryJgdxqxjdjbDao extends BaseDaoImpl {

	/**
	 * 查询列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	public EasyUIPage queryList(EasyUIPage page, ZdryJgdxqxjdjb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "qjrq";
			order = "desc";
		}
		map.put("sort", sort);
		map.put("order", order);
		entity.setQjyy(StringUtils.getSqlExpression(entity.getQjyy()));
		map.put("zdryJgdxqxjdjb", entity);
		page.setTotal((Integer) queryForObject("ZdryJgdxqxjdjb.queryCount", map));
		page.setRows(queryForList("ZdryJgdxqxjdjb.queryList", map));
		return page;
	}

	/**
	 * 查询列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	public List<ZdryJgdxqxjdjb> queryViewList(Map<String, Object> map) {
		List<ZdryJgdxqxjdjb> list = null;
		if (map != null) {
			String zdryid = (String) map.get("zdryid");
			if (!StringUtils.isBlank(zdryid)) {
				list = queryForList("ZdryJgdxqxjdjb.queryViewList", map);
			}
		}
		return list;
	}

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return ZdryJgdxqxjdjb 返回类型
	 * @throws
	 */
	public ZdryJgdxqxjdjb queryById(String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		} else {
			return (ZdryJgdxqxjdjb) queryForObject("ZdryJgdxqxjdjb.queryById", id);
		}

	}

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	public void save(ZdryJgdxqxjdjb entity, SessionBean sessionBean) {
		insert("ZdryJgdxqxjdjb.save", entity);
	}

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	public void update(ZdryJgdxqxjdjb entity, SessionBean sessionBean) {
		update("ZdryJgdxqxjdjb.update", entity);
	}

	/**
	 * 更新审批<br>
	 * 
	 * @param entity
	 */
	public void updateSp(ZdryJgdxqxjdjb entity, SessionBean sessionBean) {
		update("ZdryJgdxqxjdjb.updateSp", entity);
	}

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	public void delete(ZdryJgdxqxjdjb entity, SessionBean sessionBean) {
		update("ZdryJgdxqxjdjb.delete", entity);
	}

}
