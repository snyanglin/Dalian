package com.founder.zdrygl.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zdrygl.bean.ZdrySgafzdryxxb;
import com.founder.zdrygl.until.ZdryUntil;

/***
 * ****************************************************************************
 * 
 * @Package: [com.founder.zdrygl.dao.ZdrySgafzdryxxbDao.java]
 * @ClassName: [ZdrySgafzdryxxbDao]
 * @Description: [涉公安访重点人员DAO类]
 * @Author: [guo_tianlin@founder.com.cn]
 * @CreateDate: [2015-3-17 下午7:38:39]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-3-17 下午7:38:39，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@Repository("zdrySgafzdryxxbDao")
public class ZdrySgafzdryxxbDao extends BaseDaoImpl {

	@Resource(name = "ZdryUntil")
	private ZdryUntil zdryUntil;
	
	public ZdrySgafzdryxxb queryMaxPc(ZdrySgafzdryxxb zdrySgafzdryxxb){
		return (ZdrySgafzdryxxb) queryForObject("ZdrySgafzdryxxb.queryMaxPc", zdrySgafzdryxxb);
	}
	
	public Integer queryCount(String gmsfhm){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("gmsfhm", gmsfhm);
		return (Integer)queryForObject("ZdrySgafzdryxxb.queryCount", map);
	}
	
	/***
	 * 
	 * @Title: queryList
	 * @Description: TODO(核实数据列表展示)
	 * @param @param entity
	 * @param @param page
	 * @param @return 设定文件
	 * @return EasyUIPage 返回类型
	 * @throws
	 */
	public EasyUIPage queryList(ZdrySgafzdryxxb entity, EasyUIPage page) {
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
		map.put("zdrySgafzdryxxb", entity);

		page.setTotal((Integer) queryForObject("ZdrySgafzdryxxb.queryListCount", map));
		page.setRows(queryForList("ZdrySgafzdryxxb.queryList", map));
		return page;
	}

	/**
	 * 
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return ZdryHsb 返回类型
	 * @throws
	 */
	public ZdrySgafzdryxxb queryById(String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		} else {
			return (ZdrySgafzdryxxb) queryForObject("ZdrySgafzdryxxb.queryById", id);
		}
	}
		
	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	public void update(ZdrySgafzdryxxb entity) {
		update("ZdrySgafzdryxxb.update", entity);
	}
	
	/**
	 * 
	 * @Title: save
	 * @Description: (保存)
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void save(ZdrySgafzdryxxb entity) {
		insert("ZdrySgafzdryxxb.save", entity);
	}

	/**
	 * 
	 * @Title: delete
	 * @Description: (删除)
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void delete(ZdrySgafzdryxxb entity) {
		update("ZdrySgafzdryxxb.delete", entity);
	}

	public ZdrySgafzdryxxb queryByZdryId(String zdryId) {
		return (ZdrySgafzdryxxb) queryForObject("ZdrySgafzdryxxb.queryById", zdryId);
	}

}
