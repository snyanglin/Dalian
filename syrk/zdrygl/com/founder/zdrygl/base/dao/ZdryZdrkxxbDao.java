package com.founder.zdrygl.base.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.zdrygl.base.model.ZdryZdrkxxb;
import com.founder.zdrygl.core.inteface.ZdryGllxEntityDaoService;
import com.founder.zdrygl.core.model.Zdry;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.dao.ZdryZdrkxxbDao.java]  
 * @ClassName:    [ZdryZdrkxxbDao]   
 * @Description:  [重点人口信息表DAO]   
 * @Author:       [wei.wen@founder.com.cn]  
 * @CreateDate:   [2015年9月17日 下午2:51:16]   
 * @UpdateUser:   [wei.wen@founder.com.cn(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年9月17日 下午2:51:16，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("zdryZdrkxxbDao")
public class ZdryZdrkxxbDao extends BaseDaoImpl implements ZdryGllxEntityDaoService{

	@Override
	public void insert(Zdry zdry) {
		ZdryZdrkxxb zdryZdrkxxb = (ZdryZdrkxxb)zdry;
		super.insert("ZdryZdrkxxb.save", zdryZdrkxxb);
	}
//88888
	@Override
	public void update(Zdry zdry) {
		ZdryZdrkxxb zdryZdrkxxb = (ZdryZdrkxxb)zdry;
		super.insert("ZdryZdrkxxb.update", zdryZdrkxxb);
	}

	@Override
	public void delete(Zdry zdry) {
		ZdryZdrkxxb zdryZdrkxxb = (ZdryZdrkxxb)zdry;
		super.insert("ZdryZdrkxxb.delete", zdryZdrkxxb);
	}

	@Override
	public Zdry queryById(String entityId) {
		return (Zdry)super.queryForObject("ZdryZdrkxxb.queryById", entityId);
	}

	@Override
	public Zdry queryViewByMap(Map<String, Object> queryMap) {
		return (Zdry)super.queryForObject("ZdryZdrkxxb.queryViewByMap", queryMap);
	}

}
