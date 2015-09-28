package com.founder.zdrygl.base.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.zdrygl.base.model.ZdryJgdxxxb;
import com.founder.zdrygl.core.inteface.ZdryGllxEntityDaoService;
import com.founder.zdrygl.core.model.Zdry;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.dao.ZdryZdrkxxbDao.java]  
 * @ClassName:    [ZdryZdrkxxbDao]   
 * @Description:  [监管对象DAO]   
 * @Author:       [wei.wen@founder.com.cn]  
 * @CreateDate:   [2015年9月17日 下午2:51:16]   
 * @UpdateUser:   [wei.wen@founder.com.cn(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年9月17日 下午2:51:16，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("zdryJgdxxxbDao")
public class ZdryJgdxxxbDao extends BaseDaoImpl implements ZdryGllxEntityDaoService{

	@Override
	public void insert(Zdry zdry) {
		ZdryJgdxxxb zdryJgdxxxb = (ZdryJgdxxxb)zdry;
		super.insert("ZdryJgdxxxb.save", zdryJgdxxxb);
	}

	@Override
	public void update(Zdry zdry) {
		ZdryJgdxxxb zdryJgdxxxb = (ZdryJgdxxxb)zdry;
		super.insert("ZdryJgdxxxb.update", zdryJgdxxxb);
	}

	@Override
	public void delete(Zdry zdry) {
		ZdryJgdxxxb zdryJgdxxxb = (ZdryJgdxxxb)zdry;
		super.insert("ZdryJgdxxxb.delete", zdryJgdxxxb);
	}

	@Override
	public Zdry queryById(String entityId) {
		return (Zdry)super.queryForObject("ZdryJgdxxxb.queryById", entityId);
	}

	@Override
	public Zdry queryViewByMap(Map<String, Object> queryMap) {
		return (Zdry)super.queryForObject("ZdryJgdxxxb.queryViewByMap", queryMap);
	}

}
