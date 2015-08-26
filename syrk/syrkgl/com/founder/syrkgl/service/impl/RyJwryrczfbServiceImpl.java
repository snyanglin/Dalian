package com.founder.syrkgl.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.syrkgl.bean.RyJwryrczfb;
import com.founder.syrkgl.dao.RyJwryrczfbDao;
import com.founder.syrkgl.service.RyJwryrczfbService;
/**
 * @类名: RyJwryrczfbServiceImpl 
 * @描述: 境外人员日常走访 
 * @作者: zhang_guoliang@founder.com 
 * @日期: 2015-6-26 上午9:36:15 
 */
@Transactional
@Service("ryJwryrczfbService")
public class RyJwryrczfbServiceImpl extends BaseService implements RyJwryrczfbService{
	@Resource(name="ryJwryrczfbDao")
	private RyJwryrczfbDao ryJwryrczfbDao;
    /**
     * @Title: queryJwryRczf 
     * @描述: 境外人员核实下发列表
     * @作者: zhang_guoliang@founder.com 
     * @参数: 传入参数定义 
     * @日期： 2015-6-26 上午9:38:58 
     * @throws
     */
	public EasyUIPage queryJwryRczf(EasyUIPage page, RyJwryrczfb entity) {
		return ryJwryrczfbDao.queryJwryRczf(page, entity);
	}
    /**
     * @Title: update 
     * @描述: 境外人员日常走访更新
     * @作者: zhang_guoliang@founder.com 
     * @参数: 传入参数定义 
     * @日期： 2015-6-26 上午9:41:44 
     * @throws
     */
	public void update(RyJwryrczfb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		entity.setZt("1");
		ryJwryrczfbDao.update(entity);
	}
}