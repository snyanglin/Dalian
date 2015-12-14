package com.founder.syrkgl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.StringUtils;
import com.founder.syrkgl.bean.SyrkWlhryxxb;
import com.founder.syrkgl.dao.SyrkWlhryxxbDao;
import com.founder.syrkgl.service.RyRyjbxxbService;
import com.founder.syrkgl.service.RyRylxfsxxbService;
import com.founder.syrkgl.service.SyrkSyrkxxzbService;
import com.founder.syrkgl.service.SyrkWlhryxxbService;
/**
 * ****************************************************************************
 * @Package:      [com.founder.syrkgl.service.impl.SyrkWlhryxxbServiceImpl.java]  
 * @ClassName:    [SyrkWlhryxxbServiceImpl]   
 * @Description:  [未落户人员业务服务]   
 * @Author:       [weiwen]  
 * @CreateDate:   [2015-4-9 上午11:02:38]   
 * @UpdateUser:   [weiwen]   
 * @UpdateDate:   [2015-4-9 上午11:02:38，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Transactional
@Service("syrkWlhryxxbService")
public class SyrkWlhryxxbServiceImpl extends BaseService implements
		SyrkWlhryxxbService {

	@Resource(name="syrkWlhryxxbDao")
	private SyrkWlhryxxbDao syrkWlhryxxbDao;
	
	@Resource(name="syrkSyrkxxzbService")
	private SyrkSyrkxxzbService syrkxxzbService;
	
	@Resource(name = "ryRyjbxxbService")
	private RyRyjbxxbService ryRyjbxxbService;

	@Resource(name = "ryRylxfsxxbService")
	private RyRylxfsxxbService ryRylxfsxxbService;
	
	@Override
	public SyrkWlhryxxb queryById(String id) {
		return syrkWlhryxxbDao.queryById(id);
	}

	@Override
	public void save(SyrkWlhryxxb entity, SessionBean sessionBean) {
		setSaveProperties(entity, sessionBean);
		syrkWlhryxxbDao.insert(entity);
		syrkxxzbService.synchronizeSyrkxxzb(entity);
	}

	@Override
	public void update(SyrkWlhryxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		syrkWlhryxxbDao.update(entity);
		syrkxxzbService.synchronizeSyrkxxzb(entity);
		ryRyjbxxbService.synchronizeRyjbxxb(entity, sessionBean);
		if (!StringUtils.isBlank(entity.getLxdh())) { // 保存联系电话
			ryRylxfsxxbService.saveLxdh(entity.getRyid(), entity.getLxdh(),
					sessionBean);
		}
	}

	@Override
	public void delete(SyrkWlhryxxb entity, SessionBean sessionBean) {
		setCrossoutProperties(entity, sessionBean);
		syrkWlhryxxbDao.delete(entity);
		syrkxxzbService.synchronizeCrossoutSyrkxxzb(entity);
	}
}
