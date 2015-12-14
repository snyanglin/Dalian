package com.founder.yjjb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.ComboBox;
import com.founder.framework.utils.EasyUIPage;
import com.founder.yjjb.bean.Xsjbxxb;
import com.founder.yjjb.bean.Xszjxxb;
import com.founder.yjjb.dao.XszjxxbDao;
import com.founder.yjjb.service.XszjxxbService;

@Service("xszjxxbService")
@Transactional
public class XszjxxbServiceImpl extends BaseService implements XszjxxbService  {
	@Resource(name = "xszjxxbDao")
	private XszjxxbDao xszjxxbDao;
	
	/**
	 * 查询</br>
	 */
	public EasyUIPage queryList(EasyUIPage page,Xszjxxb entity) {
		
		return xszjxxbDao.queryList(page, entity);
	}

	/**
	 * 查询</br>
	 */
	public Xszjxxb queryById(Xszjxxb entity) {
		
		return xszjxxbDao.queryById(entity);
	}
	
	/**
	 * 新增</br>
	 */
	public void save(Xszjxxb entity, SessionBean sessionBean) {
		
		setSaveProperties(entity, sessionBean);
		xszjxxbDao.save(entity, sessionBean);
	}
	
	/**
	 * 设置线索征集信息被同意或拒绝</br>
	 */
	public void update(Xszjxxb entity, SessionBean sessionBean) {
		
		setSaveProperties(entity, sessionBean);
		xszjxxbDao.update(entity, sessionBean);
	}
	
}
