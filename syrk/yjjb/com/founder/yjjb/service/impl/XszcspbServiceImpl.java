package com.founder.yjjb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.yjjb.bean.Xszcspb;
import com.founder.yjjb.dao.XszcspbDao;
import com.founder.yjjb.service.XszcspbService;
import com.founder.yjjb.utils.MessageUtils;

@Service("xszcspbService")
@Transactional
public class XszcspbServiceImpl extends BaseService implements XszcspbService {

	@Resource(name = "xszcspbDao")
	private XszcspbDao xszcspbDao;
	
	/**
	 * 查询</br>
	 */
	public EasyUIPage queryList(EasyUIPage page,Xszcspb entity) {
		
		return xszcspbDao.queryList(page, entity);
	}

	/**
	 * 查询</br>
	 */
	public Xszcspb queryById(Xszcspb entity) {
		
		return xszcspbDao.queryById(entity);
	}

	/**
	 * 新增</br>
	 */
	public void save(Xszcspb entity, SessionBean sessionBean) {
		
//		entity.setId(UUID.create());
		setSaveProperties(entity, sessionBean);
		xszcspbDao.save(entity, sessionBean);
		
	}

	/**
	 * 修改</br>
	 */
	public void update(Xszcspb entity, SessionBean sessionBean) {
		
		setUpdateProperties(entity, sessionBean);
		xszcspbDao.update(entity, sessionBean);
	}

	/**
	 * 删除</br>
	 */
	public void delete(Xszcspb entity, SessionBean sessionBean) {
		
		setCrossoutProperties(entity, sessionBean);
		xszcspbDao.delete(entity, sessionBean);
	}

	public List<Xszcspb> queryListBySqid(String sqid) {
		
		return xszcspbDao.queryListBySqid(sqid);
		
	}
}
