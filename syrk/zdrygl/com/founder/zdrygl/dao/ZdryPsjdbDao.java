package com.founder.zdrygl.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zdrygl.bean.ZdryPsjdb;


/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.dao.ZdryPsjdbDao.java]  
 * @ClassName:    [ZdryPsjdbDao]   
 * @Description:  [评审鉴定 DAO]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年9月6日 下午3:36:58]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年9月6日 下午3:36:58，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("zdryPsjdbDao")
public class ZdryPsjdbDao extends BaseDaoImpl {

	/**
	 * 查询列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	public EasyUIPage queryList(EasyUIPage page, ZdryPsjdb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "py_sj";
			order = "desc";
		}
		map.put("sort", sort);
		map.put("order", order);
		entity.setPydd(StringUtils.getSqlExpression(entity.getPydd()));
		entity.setNrjy(StringUtils.getSqlExpression(entity.getNrjy()));
		map.put("zdryPsjdb", entity);
		page.setTotal((Integer) queryForObject("ZdryPsjdb.queryCount", map));
		page.setRows(queryForList("ZdryPsjdb.queryList", map));
		return page;
	}

	/**
	 * 查询列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	public List<ZdryPsjdb> queryViewList(Map<String, Object> map) {
		List<ZdryPsjdb> list = null;
		if (map != null) {
			String zdryid = (String) map.get("zdryid");
			if (!StringUtils.isBlank(zdryid)) {
				list = queryForList("ZdryPsjdb.queryViewList", map);
			}
		}
		return list;
	}

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return ZdryPsjdb 返回类型
	 * @throws
	 */
	public ZdryPsjdb queryById(String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		} else {
			return (ZdryPsjdb) queryForObject("ZdryPsjdb.queryById", id);
		}
	}

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	public void save(ZdryPsjdb entity, SessionBean sessionBean) {
		insert("ZdryPsjdb.save", entity);
	}

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	public void update(ZdryPsjdb entity, SessionBean sessionBean) {
		update("ZdryPsjdb.update", entity);
	}

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	public void delete(ZdryPsjdb entity, SessionBean sessionBean) {
		update("ZdryPsjdb.delete", entity);
	}

}
