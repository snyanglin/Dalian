package com.founder.zdrygl.base.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.zdrygl.base.model.ZdrySgafzdryxxb;
import com.founder.zdrygl.base.model.ZdrySqjzryxxb;
import com.founder.zdrygl.core.inteface.ZdryGllxEntityDaoService;
import com.founder.zdrygl.core.model.Zdry;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.dao.ZdrySgafzdryxxbDao.java]  
 * @ClassName:    [ZdrySgafzdryxxbDao]   
 * @Description:  [涉公安访 dao]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015年9月28日 下午2:51:16]   
 * @UpdateUser:   [cong_rihong@founder.com.cn(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年9月28日 下午2:51:16，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("zdrySgafzdryxxbDao")
public class ZdrySgafzdryxxbDao extends BaseDaoImpl implements ZdryGllxEntityDaoService{

	@Override
	public void insert(Zdry zdry) {
		ZdrySgafzdryxxb sgaf = (ZdrySgafzdryxxb)zdry;
		super.insert("ZdrySgafzdryxxb.save", sgaf);
	}

	@Override
	public void update(Zdry zdry) {
		ZdrySgafzdryxxb sgaf = (ZdrySgafzdryxxb)zdry;
		super.insert("ZdrySgafzdryxxb.update", sgaf);
	}

	@Override
	public void delete(Zdry zdry) {
		ZdrySgafzdryxxb sgaf = (ZdrySgafzdryxxb)zdry;
		super.insert("ZdrySgafzdryxxb.delete", sgaf);
	}

	@Override
	public Zdry queryById(String entityId) {
		return (Zdry)super.queryForObject("ZdrySgafzdryxxb.queryById", entityId);
	}

	@Override
	public Zdry queryViewByMap(Map<String, Object> queryMap) {
		return (Zdry)super.queryForObject("ZdrySgafzdryxxb.queryViewByMap", queryMap);
	}

}
