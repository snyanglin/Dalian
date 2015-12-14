package com.founder.syrkgl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.StringUtils;
import com.founder.syrkgl.bean.SyrkJwryxxb;
import com.founder.syrkgl.dao.SyrkJwryxxbDao;
import com.founder.syrkgl.service.RyRyjbxxbService;
import com.founder.syrkgl.service.RyRylxfsxxbService;
import com.founder.syrkgl.service.SyrkJwryxxbService;
import com.founder.syrkgl.service.SyrkSyrkxxzbService;
/**
 * ****************************************************************************
 * @Package:      [com.founder.syrkgl.service.impl.SyrkJwryxxbServiceImpl.java]  
 * @ClassName:    [SyrkJwryxxbServiceImpl]   
 * @Description:  [境外人员业务实现类]   
 * @Author:       [weiwen]  
 * @CreateDate:   [2015-4-3 下午5:36:45]   
 * @UpdateUser:   [weiwen]   
 * @UpdateDate:   [2015-4-3 下午5:36:45，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Transactional
@Service("syrkJwryxxbService")
public class SyrkJwryxxbServiceImpl extends BaseService implements
		SyrkJwryxxbService {
	
	@Resource(name="syrkJwryxxbDao")
	private SyrkJwryxxbDao syrkJwryxxbDao;
	
	@Resource(name="syrkSyrkxxzbService")
	private SyrkSyrkxxzbService syrkxxzbService;
	
	@Resource(name = "ryRyjbxxbService")
	private RyRyjbxxbService ryRyjbxxbService;

	@Resource(name = "ryRylxfsxxbService")
	private RyRylxfsxxbService ryRylxfsxxbService;
	
	@Override
	public SyrkJwryxxb queryById(String id) {
		return syrkJwryxxbDao.queryById(id);
	}

	@Override
	public void save(SyrkJwryxxb entity, SessionBean sessionBean) {
		setSaveProperties(entity, sessionBean);
		syrkJwryxxbDao.insert(entity);
		syrkxxzbService.synchronizeSyrkxxzb(entity);
	}

	@Override
	public void update(SyrkJwryxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		syrkJwryxxbDao.update(entity);
		syrkxxzbService.synchronizeSyrkxxzb(entity);
		ryRyjbxxbService.synchronizeRyjbxxb(entity, sessionBean);
		if (!StringUtils.isBlank(entity.getLxdh())) { // 保存联系电话
			ryRylxfsxxbService.saveLxdh(entity.getRyid(), entity.getLxdh(),
					sessionBean);
		}
		// TODO 基本信息表同步
	}

	@Override
	public void delete(SyrkJwryxxb entity, SessionBean sessionBean) {
		setCrossoutProperties(entity, sessionBean);
		syrkJwryxxbDao.delete(entity);
		syrkxxzbService.synchronizeCrossoutSyrkxxzb(entity);
	}

}
