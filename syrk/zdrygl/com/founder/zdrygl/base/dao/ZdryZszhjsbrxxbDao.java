package com.founder.zdrygl.base.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.zdrygl.base.model.ZdryJgdxxxb;
import com.founder.zdrygl.base.model.ZdryZszhjsbrxxb;
import com.founder.zdrygl.core.inteface.ZdryGllxEntityDaoService;
import com.founder.zdrygl.core.model.Zdry;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.dao.ZdryZdrkxxbDao.java]  
 * @ClassName:    [ZdryZdrkxxbDao]   
 * @Description:  [肇事肇祸精神病dao]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015年9月28日 下午2:51:16]   
 * @UpdateUser:   [cong_rihong@founder.com.cn(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年9月28日 下午2:51:16，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("zdryZszhjsbrxxbDao")
public class ZdryZszhjsbrxxbDao extends BaseDaoImpl implements ZdryGllxEntityDaoService{

	@Override
	public void insert(Zdry zdry) {
		ZdryZszhjsbrxxb zdryZszhjsbrxxb = (ZdryZszhjsbrxxb)zdry;
		super.insert("ZdryZszhjsbrxxb.save", zdryZszhjsbrxxb);
	}

	@Override
	public void update(Zdry zdry) {
		ZdryZszhjsbrxxb zdryZszhjsbrxxb = (ZdryZszhjsbrxxb)zdry;
		super.insert("ZdryZszhjsbrxxb.update", zdryZszhjsbrxxb);
	}

	@Override
	public void delete(Zdry zdry) {
		ZdryZszhjsbrxxb zdryZszhjsbrxxb = (ZdryZszhjsbrxxb)zdry;
		super.insert("ZdryZszhjsbrxxb.delete", zdryZszhjsbrxxb);
	}

	@Override
	public Zdry queryById(String entityId) {
		return (Zdry)super.queryForObject("ZdryZszhjsbrxxb.queryById", entityId);
	}

	@Override
	public Zdry queryViewByMap(Map<String, Object> queryMap) {
		return (Zdry)super.queryForObject("ZdryZszhjsbrxxb.queryViewByMap", queryMap);
	}

}
