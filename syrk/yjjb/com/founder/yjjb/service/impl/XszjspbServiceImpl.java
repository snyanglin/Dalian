package com.founder.yjjb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.yjjb.bean.Xszjspb;
import com.founder.yjjb.dao.XszjspbDao;
import com.founder.yjjb.service.XszjspbService;

@Service("xszjspbService")
@Transactional
public class XszjspbServiceImpl extends BaseService implements XszjspbService  {
	@Resource(name = "xszjspbDao")
	private XszjspbDao xszjspbDao;
	/**
	 * 查询</br>
	 */
	public EasyUIPage queryList(EasyUIPage page,Xszjspb entity) {
		
		return xszjspbDao.queryList(page, entity);
	}

	/**
	 * 查询</br>
	 */
	public Xszjspb queryById(Xszjspb entity) {
		
		return xszjspbDao.queryById(entity);
	}
	
	/**
	 * 查询</br>
	 */
	public List<Xszjspb> queryBySqbh(Xszjspb entity) {
		
		return xszjspbDao.queryBySqbh(entity);
	}
	
	/**
	 * 同意或拒绝审批--新增审批记录</br>
	 */
	public void save(Xszjspb entity, SessionBean sessionBean) {
		
		setSaveProperties(entity, sessionBean);
		xszjspbDao.save(entity, sessionBean);
	}
	/**
	 * 同意或拒绝审批--修改审批记录</br>
	 */
	public void update(Xszjspb entity, SessionBean sessionBean) {
		
		setSaveProperties(entity, sessionBean);
		xszjspbDao.update(entity, sessionBean);
	}
	
}
