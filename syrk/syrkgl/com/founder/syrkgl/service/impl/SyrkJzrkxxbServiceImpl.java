package com.founder.syrkgl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.StringUtils;
import com.founder.syrkgl.bean.SyrkJzrkxxb;
import com.founder.syrkgl.dao.SyrkJzrkxxbDao;
import com.founder.syrkgl.service.RyRyjbxxbService;
import com.founder.syrkgl.service.RyRylxfsxxbService;
import com.founder.syrkgl.service.SyrkJzrkxxbService;
import com.founder.syrkgl.service.SyrkSyrkxxzbService;

/**
 * ****************************************************************************
 * @Package:      [com.founder.syrkgl.service.impl.SyrkJzrkxxbServiceImpl.java]  
 * @ClassName:    [SyrkJzrkxxbServiceImpl]   
 * @Description:  [寄住人口业务服务]   
 * @Author:       [weiwen]   
 * @CreateDate:   [2015-4-5 下午11:09:07]   
 * @UpdateUser:   [weiwen(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-5 下午11:09:07，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Transactional
@Service("syrkJzrkxxbService")
public class SyrkJzrkxxbServiceImpl extends BaseService implements
		SyrkJzrkxxbService {

	@Resource(name="syrkJzrkxxbDao")
	private SyrkJzrkxxbDao syrkJzrkxxbDao;
	
	@Resource(name="syrkSyrkxxzbService")
	private SyrkSyrkxxzbService syrkxxzbService;
	
	@Resource(name = "ryRyjbxxbService")
	private RyRyjbxxbService ryRyjbxxbService;

	@Resource(name = "ryRylxfsxxbService")
	private RyRylxfsxxbService ryRylxfsxxbService;
	
	@Override
	public SyrkJzrkxxb queryById(String id) {
		return syrkJzrkxxbDao.queryById(id);
	}

	@Override
	public void save(SyrkJzrkxxb entity, SessionBean sessionBean) {
		setSaveProperties(entity, sessionBean);
		syrkJzrkxxbDao.insert(entity);
		syrkxxzbService.synchronizeSyrkxxzb(entity);
	}

	@Override
	public void update(SyrkJzrkxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		syrkJzrkxxbDao.update(entity);
		syrkxxzbService.synchronizeSyrkxxzb(entity);
		ryRyjbxxbService.synchronizeRyjbxxb(entity, sessionBean);
		if (!StringUtils.isBlank(entity.getLxdh())) { // 保存联系电话
			ryRylxfsxxbService.saveLxdh(entity.getRyid(), entity.getLxdh(),
					sessionBean);
		}
	}

	@Override
	public void delete(SyrkJzrkxxb entity, SessionBean sessionBean) {
		setCrossoutProperties(entity, sessionBean);
		syrkJzrkxxbDao.delete(entity);
		syrkxxzbService.synchronizeCrossoutSyrkxxzb(entity);
	}

}
