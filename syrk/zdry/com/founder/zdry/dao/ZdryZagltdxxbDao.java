package com.founder.zdry.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zdry.bean.ZdryZagltdxxb;

/******************************************************************************
 * @Package: [com.founder.zdry.dao.ZdryZagltdxxbDao.java]
 * @ClassName: [ZdryZagltdxxbDao]
 * @Description: [重点人员补充信息－作案规律特点]
 * @Author: [hongguanjun]
 * @CreateDate: [2015-3-12 上午10:07:21]
 * @UpdateUser: [hongguanjun(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-3-12 上午10:07:21，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@Repository("zdryZagltdxxbDao")
public class ZdryZagltdxxbDao extends BaseDaoImpl {

	/**
	 * 查询列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	public EasyUIPage queryList(EasyUIPage page, ZdryZagltdxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "xt_cjsj";
			order = "desc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("zdryZagltdxxb", entity);
		page.setTotal((Integer) queryForObject("ZdryZagltdxxb.queryCount", map));
		page.setRows(queryForList("ZdryZagltdxxb.queryList", map));
		return page;
	}

	/**
	 * 查询列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	public List<ZdryZagltdxxb> queryViewList(Map<String, Object> map) {
		List<ZdryZagltdxxb> list = null;
		if (map != null) {
			String zdryid = (String) map.get("zdryid");
			if (!StringUtils.isBlank(zdryid)) {
				list = queryForList("ZdryZagltdxxb.queryViewList", map);
			}
		}
		return list;
	}

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return ZdryZagltdxxb 返回类型
	 * @throws
	 */
	public ZdryZagltdxxb queryById(String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		} else {
			return (ZdryZagltdxxb) queryForObject("ZdryZagltdxxb.queryById", id);
		}
	}

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	public void save(ZdryZagltdxxb entity, SessionBean sessionBean) {
		insert("ZdryZagltdxxb.save", entity);
	}

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	public void update(ZdryZagltdxxb entity, SessionBean sessionBean) {
		update("ZdryZagltdxxb.update", entity);
	}

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	public void delete(ZdryZagltdxxb entity, SessionBean sessionBean) {
		update("ZdryZagltdxxb.delete", entity);
	}

}
