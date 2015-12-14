package com.founder.yjjb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.yjjb.bean.Xszcsqb;
import com.founder.yjjb.dao.XszcsqbDao;
import com.founder.yjjb.service.XszcsqbService;

@Service("xszcsqbService")
@Transactional
public class XszcsqbServiceImpl extends BaseService implements XszcsqbService {

	@Resource(name = "xszcsqbDao")
	private XszcsqbDao xszcsqbDao;
	
	/**
	 * 查询</br>
	 */
	public EasyUIPage queryList(EasyUIPage page,Xszcsqb entity) {
		
		return xszcsqbDao.queryList(page, entity);
	}

	/**
	 * 查询</br>
	 */
	public Xszcsqb queryById(Xszcsqb entity) {
		
		return xszcsqbDao.queryById(entity);
	}

	/**
	 * 新增</br>
	 */
	public void save(Xszcsqb entity, SessionBean sessionBean) {
		
//		entity.setId(UUID.create());
		setSaveProperties(entity, sessionBean);
		xszcsqbDao.save(entity, sessionBean);
	}

	/**
	 * 修改</br>
	 */
	public void update(Xszcsqb entity, SessionBean sessionBean) {
		
		setUpdateProperties(entity, sessionBean);
		xszcsqbDao.update(entity, sessionBean);
	}

	/**
	 * 删除</br>
	 */
	public void delete(Xszcsqb entity, SessionBean sessionBean) {
		
		setCrossoutProperties(entity, sessionBean);
		xszcsqbDao.delete(entity, sessionBean);
	}

	/* (非 Javadoc)
	 * <p>Title: queryListByXsbh</p>
	 * <p>Description: </p>
	 * @param entitySq
	 * @return
	 * @see com.founder.yjjb.service.XszcsqbService#queryListByXsbh(com.founder.yjjb.bean.Xszcsqb)
	 */
	public List<Xszcsqb> queryListByXsbh(Xszcsqb entity) {
		return xszcsqbDao.queryListByXsbh(entity);
	}
}
