package com.founder.syrkgl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.StringUtils;
import com.founder.syrkgl.bean.SyrkLdrkxxb;
import com.founder.syrkgl.dao.SyrkLdrkxxbDao;
import com.founder.syrkgl.service.RyRyjbxxbService;
import com.founder.syrkgl.service.RyRylxfsxxbService;
import com.founder.syrkgl.service.SyrkLdrkxxbService;
import com.founder.syrkgl.service.SyrkSyrkxxzbService;

/**
 * ****************************************************************************
 * @Package:      [com.founder.syrkgl.service.impl.SyrkLdrkxxbServiceImpl.java]  
 * @ClassName:    [SyrkLdrkxxbServiceImpl]   
 * @Description:  [流动人口业务服务]   
 * @Author:       [weiwen]  
 * @CreateDate:   [2015-4-9 上午10:23:45]   
 * @UpdateUser:   [weiwen]   
 * @UpdateDate:   [2015-4-9 上午10:23:45，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Transactional
@Service("syrkLdrkxxbService")
public class SyrkLdrkxxbServiceImpl extends BaseService implements
		SyrkLdrkxxbService {

	@Resource(name="syrkLdrkxxbDao")
	private SyrkLdrkxxbDao syrkLdrkxxbDao;
	
	@Resource(name="syrkSyrkxxzbService")
	private SyrkSyrkxxzbService syrkxxzbService;
	
	@Resource(name = "ryRyjbxxbService")
	private RyRyjbxxbService ryRyjbxxbService;

	@Resource(name = "ryRylxfsxxbService")
	private RyRylxfsxxbService ryRylxfsxxbService;
	
	@Override
	public SyrkLdrkxxb queryById(String id) {
		return syrkLdrkxxbDao.queryById(id);
	}

	@Override
	public void save(SyrkLdrkxxb entity, SessionBean sessionBean) {
		setSaveProperties(entity, sessionBean);
		syrkLdrkxxbDao.insert(entity);
		syrkxxzbService.synchronizeSyrkxxzb(entity);
	}

	@Override
	public void update(SyrkLdrkxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		syrkLdrkxxbDao.update(entity);
		syrkxxzbService.synchronizeSyrkxxzb(entity);
		ryRyjbxxbService.synchronizeRyjbxxb(entity, sessionBean);
		if (!StringUtils.isBlank(entity.getLxdh())) { // 保存联系电话
			ryRylxfsxxbService.saveLxdh(entity.getRyid(), entity.getLxdh(),
					sessionBean);
		}
	}

	@Override
	public void delete(SyrkLdrkxxb entity, SessionBean sessionBean) {
		setCrossoutProperties(entity, sessionBean);
		syrkLdrkxxbDao.delete(entity);
		syrkxxzbService.synchronizeCrossoutSyrkxxzb(entity);
	}


}
