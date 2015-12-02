package com.founder.zdrygl.base.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.zdrygl.base.model.ZdryShbzdryxxb;
import com.founder.zdrygl.core.inteface.ZdryGllxEntityDaoService;
import com.founder.zdrygl.core.model.Zdry;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.dao.ZdryShbzdryxxbDao.java]  
 * @ClassName:    [ZdryShbzdryxxbDao]   
 * @Description:  [涉环保重点人员 dao]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015年9月28日 下午2:51:16]   
 * @UpdateUser:   [cong_rihong@founder.com.cn(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年9月28日 下午2:51:16，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("zdryShbzdryxxbDao")
public class ZdryShbzdryxxbDao extends BaseDaoImpl implements ZdryGllxEntityDaoService{

	@Override
	public void insert(Zdry zdry) {
		ZdryShbzdryxxb shb = (ZdryShbzdryxxb)zdry;
		super.insert("ZdryShbzdryxxb.save", shb);
	}

	@Override
	public void update(Zdry zdry) {
		ZdryShbzdryxxb shb = (ZdryShbzdryxxb)zdry;
		super.insert("ZdryShbzdryxxb.update", shb);
	}

	@Override
	public void delete(Zdry zdry) {
		ZdryShbzdryxxb shb = (ZdryShbzdryxxb)zdry;
		super.insert("ZdryShbzdryxxb.delete", shb);
	}

	@Override
	public Zdry queryById(String entityId) {
		return (Zdry)super.queryForObject("ZdryShbzdryxxb.queryById", entityId);
	}

	@Override
	public Zdry queryViewByMap(Map<String, Object> queryMap) {
		return (Zdry)super.queryForObject("ZdryShbzdryxxb.queryViewByMap", queryMap);
	}

}
