package com.founder.zafffwqz.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.syrkgl.service.RyRylxfsxxbService;
import com.founder.zafffwqz.bean.Dsrxxzb;
import com.founder.zafffwqz.dao.DsrxxzbDao;
import com.founder.zafffwqz.service.DsrxxzbService;


/******************************************************************************
 * @Package:      [com.founder.zafffwqz.service.impl.DsrxxzbServiceImpl.java]  
 * @ClassName:    [DsrxxzbServiceImpl]   
 * @Description:  [矛盾-当事人服务层]   
 * @Author:       [tian_chengwei@founder.com.cn]  
 * @CreateDate:   [2015-6-2 下午11:53:59]   
 * @UpdateUser:   [lk(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-2 下午11:53:59，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Service("dsrxxzbService")
@Transactional
public class DsrxxzbServiceImpl extends BaseService implements DsrxxzbService {
	
	@Resource(name = "dsrxxzbDao")
	private DsrxxzbDao dsrxxzbDao;
	@Resource(name="ryRylxfsxxbService")
	private RyRylxfsxxbService ryRylxfsxxbService;
	/*
	 * (注销操作)
	 * <p>Title: delete</p>
	 * <p>Description: </p>
	 * @param entity
	 * @param sessionBean
	 * @see com.founder.zafffwqz.service.DsrxxzbService#delete(com.founder.zafffwqz.bean.Dsrxxzb, com.founder.framework.base.entity.SessionBean)
	 */
	@Override
	public void delete(Dsrxxzb entity, SessionBean sessionBean) {
		setCrossoutProperties(entity, sessionBean);
		dsrxxzbDao.delete(entity);	
	}
	/*
	 * (查询)
	 * <p>Title: queryDsrxxzb</p>
	 * <p>Description: </p>
	 * @param entity
	 * @return
	 * @see com.founder.zafffwqz.service.DsrxxzbService#queryDsrxxzb(com.founder.zafffwqz.bean.Dsrxxzb)
	 */
	@Override
	public Dsrxxzb queryDsrxxzb(Dsrxxzb entity) {
		return dsrxxzbDao.queryDsrxxzb(entity);
	}
	/*
	 * (保存)
	 * <p>Title: saveDsrxxzb</p>
	 * <p>Description: </p>
	 * @param entity
	 * @param sessionBean
	 * @see com.founder.zafffwqz.service.DsrxxzbService#saveDsrxxzb(com.founder.zafffwqz.bean.Dsrxxzb, com.founder.framework.base.entity.SessionBean)
	 */
	@Override
	public void saveDsrxxzb(Dsrxxzb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity, sessionBean);
		dsrxxzbDao.saveDsrxxzb(entity);
		this.ryRylxfsxxbService.saveLxdh(entity.getRyid(), entity.getLxdh(), sessionBean);

	}
	/*
	 * (修改)
	 * <p>Title: updateDsrxxzb</p>
	 * <p>Description: </p>
	 * @param entity
	 * @param sessionBean
	 * @see com.founder.zafffwqz.service.DsrxxzbService#updateDsrxxzb(com.founder.zafffwqz.bean.Dsrxxzb, com.founder.framework.base.entity.SessionBean)
	 */
	@Override
	public void updateDsrxxzb(Dsrxxzb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		dsrxxzbDao.updateDsrxxzb(entity);
		this.ryRylxfsxxbService.saveLxdh(entity.getRyid(), entity.getLxdh(), sessionBean);

	}
	/*
	 * (分页查询)
	 * <p>Title: queryList</p>
	 * <p>Description: </p>
	 * @param page
	 * @param map
	 * @return
	 * @see com.founder.zafffwqz.service.DsrxxzbService#queryList(com.founder.framework.utils.EasyUIPage, java.util.Map)
	 */
	@Override
	public EasyUIPage queryList(EasyUIPage page, Map map) {
		return dsrxxzbDao.queryList(page, map);
	}

}
