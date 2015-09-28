package com.founder.zdrygl.base.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.zdrygl.base.model.ZdrySqsbzdryxxb;
import com.founder.zdrygl.core.inteface.ZdryGllxEntityDaoService;
import com.founder.zdrygl.core.model.Zdry;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.dao.ZdrySqsbzdryxxbDao.java]  
 * @ClassName:    [ZdrySqsbzdryxxbDao]   
 * @Description:  [涉枪涉爆 dao]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015年9月28日 下午2:51:16]   
 * @UpdateUser:   [cong_rihong@founder.com.cn(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年9月28日 下午2:51:16，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("zdrySqsbzdryxxbDao")
public class ZdrySqsbzdryxxbDao extends BaseDaoImpl implements ZdryGllxEntityDaoService{

	@Override
	public void insert(Zdry zdry) {
		ZdrySqsbzdryxxb sqsb = (ZdrySqsbzdryxxb)zdry;
		super.insert("ZdrySqsbzdryxxb.save", sqsb);
	}

	@Override
	public void update(Zdry zdry) {
		ZdrySqsbzdryxxb sqsb = (ZdrySqsbzdryxxb)zdry;
		super.insert("ZdrySqsbzdryxxb.update", sqsb);
	}

	@Override
	public void delete(Zdry zdry) {
		ZdrySqsbzdryxxb sqsb = (ZdrySqsbzdryxxb)zdry;
		super.insert("ZdrySqsbzdryxxb.delete", sqsb);
	}

	@Override
	public Zdry queryById(String entityId) {
		return (Zdry)super.queryForObject("ZdrySqsbzdryxxb.queryById", entityId);
	}

	@Override
	public Zdry queryViewByMap(Map<String, Object> queryMap) {
		return (Zdry)super.queryForObject("ZdrySqsbzdryxxb.queryViewByMap", queryMap);
	}

}
