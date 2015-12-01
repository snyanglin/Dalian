package com.founder.zdry.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zdry.bean.ZdryHsb;
import com.founder.zdry.bean.ZdryHsbZdls;

/***
 * ****************************************************************************
 * 
 * @Package: [com.founder.zdry.dao.ZdryHsbDao.java]
 * @ClassName: [ZdryHsbDao]
 * @Description: [核实功能DAO类]
 * @Author: [wu_chunhui@founder.com.cn]
 * @CreateDate: [2015-3-17 下午7:38:39]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-3-17 下午7:38:39，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@Repository("zdryHsbDao")
public class ZdryHsbDao extends BaseDaoImpl {

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
	public EasyUIPage queryList(ZdryHsb entity, EasyUIPage page) {
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
		map.put("zdryHsb", entity);

		page.setTotal((Integer) queryForObject("ZdryHsb.queryCount", map));
		page.setRows(queryForList("ZdryHsb.query", map));
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
	public ZdryHsb queryById(String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		} else {
			return (ZdryHsb) queryForObject("ZdryHsb.queryById", id);
		}

	}

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	public void update(ZdryHsb entity) {
		update("ZdryHsb.update", entity);
	}

	/**
	 * 新增转递历史<br>
	 * 
	 * @param entity
	 */
	public void saveZdls(ZdryHsbZdls entity, SessionBean sessionBean) {
		insert("ZdryHsb.saveZdls", entity);
	}
	/***
	 * 
	 * @Title: queryHsbSyrkidByZjhm
	 * @Description: TODO(根据身份证和所属责任区查询实有人口ID)
	 * @param @param zjhm
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public List<ZdryHsb> queryHsbSyrkidByZjhm(Map<String,String> map){
		return queryForList("ZdryHsb.queryHsbSyrkidByZjhm", map);
	}

}
