package com.founder.syrkgl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.StringUtils;
import com.founder.syrkgl.bean.SyrkCzrkxxb;
import com.founder.syrkgl.dao.SyrkCzrkxxbDao;
import com.founder.syrkgl.service.RyRyjbxxbService;
import com.founder.syrkgl.service.RyRylxfsxxbService;
import com.founder.syrkgl.service.SyrkCzrkxxbService;
import com.founder.syrkgl.service.SyrkSyrkxxzbService;

/**
 * ****************************************************************************
 * 
 * @Package: [com.founder.syrkgl.service.impl.SyrkCzrkxxbServiceImpl.java]
 * @ClassName: [SyrkCzrkxxbServiceImpl]
 * @Description: [常住人口业务逻辑服务]
 * @Author: [weiwen]
 * @CreateDate: [2015-4-2 下午8:04:43]
 * @UpdateUser: [weiwen]
 * @UpdateDate: [2015-4-2 下午8:04:43，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@Service("syrkCzrkxxbService")
@Transactional
public class SyrkCzrkxxbServiceImpl extends BaseService implements
		SyrkCzrkxxbService {

	@Resource(name = "syrkCzrkxxbDao")
	private SyrkCzrkxxbDao czrkxxbDao;

	@Resource(name = "syrkSyrkxxzbService")
	private SyrkSyrkxxzbService syrkxxzbService;

	@Resource(name = "ryRyjbxxbService")
	private RyRyjbxxbService ryRyjbxxbService;

	@Resource(name = "ryRylxfsxxbService")
	private RyRylxfsxxbService ryRylxfsxxbService;

	@Override
	public SyrkCzrkxxb queryById(String id) {
		return czrkxxbDao.queryById(id);
	}

	@Override
	public void save(SyrkCzrkxxb entity, SessionBean sessionBean) {
		setSaveProperties(entity, sessionBean);
		czrkxxbDao.insert(entity);
		syrkxxzbService.synchronizeSyrkxxzb(entity);
	}

	@Override
	public void update(SyrkCzrkxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		czrkxxbDao.update(entity);
		syrkxxzbService.synchronizeSyrkxxzb(entity);
		ryRyjbxxbService.synchronizeRyjbxxb(entity, sessionBean);
		if (!StringUtils.isBlank(entity.getLxdh())) { // 保存联系电话
			ryRylxfsxxbService.saveLxdh(entity.getRyid(), entity.getLxdh(),
					sessionBean);
		}
	}

	@Override
	public void delete(SyrkCzrkxxb entity, SessionBean sessionBean) {
		setCrossoutProperties(entity, sessionBean);
		czrkxxbDao.delete(entity);
		syrkxxzbService.synchronizeCrossoutSyrkxxzb(entity);
	}

}
