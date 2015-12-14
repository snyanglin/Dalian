package com.founder.ywxt.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.syrkgl.bean.RyRybmchxxb;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
import com.founder.ywxt.bean.Ywxtsfqypzb;

/******************************************************************************
 * @Package:      [com.founder.ywxt.dao.YwxtsfqypzbDao.java]  
 * @ClassName:    [YwxtsfqypzbDao]   
 * @Description:  [业务协同是否启用配置表DAO]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015-11-6 下午2:06:14]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-11-6 下午2:06:14，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Repository("ywxtsfqypzbDao")
public class YwxtsfqypzbDao  extends BaseDaoImpl{

	/***
	 * 
	 * @Title: queryById
	 * @Description: TODO(查询)
	 * @param @param id
	 * @param @return    设定文件
	 * @return Ywxtcyryxxb    返回类型
	 * @throws
	 */
	public Ywxtsfqypzb queryByYwxtlx(String ywxtlx) {
		if (StringUtils.isBlank(ywxtlx)) {
			return null;
		} else {
			return (Ywxtsfqypzb) queryForObject("Ywxtsfqypzb.queryByYwxtlx", ywxtlx);
		}
	}

	public Ywxtsfqypzb queryById(String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		} else {
			return (Ywxtsfqypzb) queryForObject("Ywxtsfqypzb.queryById", id);
		}
	}
	
	
	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	public void save(Ywxtsfqypzb entity, SessionBean sessionBean) {
		insert("Ywxtsfqypzb.save", entity);
	}

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	public void update(Ywxtsfqypzb entity, SessionBean sessionBean) {
		update("Ywxtsfqypzb.update", entity);
	}

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	public void delete(Ywxtsfqypzb entity, SessionBean sessionBean) {
		update("Ywxtsfqypzb.delete", entity);
	}
	
	
	public EasyUIPage queryList(Ywxtsfqypzb entity, EasyUIPage page) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());		
		map.put("entity", entity);
		page.setRows(queryForList("Ywxtsfqypzb.query", map));
		page.setTotal((Integer) queryForObject("Ywxtsfqypzb.queryCount", map));
		return page;
	}

}
