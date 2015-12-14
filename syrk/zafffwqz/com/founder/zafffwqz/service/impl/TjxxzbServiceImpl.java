package com.founder.zafffwqz.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.zafffwqz.bean.Mdxxb;
import com.founder.zafffwqz.bean.Tjxxzb;
import com.founder.zafffwqz.dao.MdxxbDao;
import com.founder.zafffwqz.dao.TjxxzbDao;
import com.founder.zafffwqz.service.TjxxzbService;

@Service("tjxxzbService")
@Transactional
public class TjxxzbServiceImpl extends BaseService implements TjxxzbService {
	
	@Resource(name = "tjxxzbDao")
	private TjxxzbDao tjxxzbDao;
	
	@Resource(name = "mdxxbDao")
	private MdxxbDao mdxxbDao;
	/*
	 * (注销)
	 * <p>Title: delete</p>
	 * <p>Description: </p>
	 * @param entity
	 * @param sessionBean
	 * @see com.founder.zafffwqz.service.TjxxzbService#delete(com.founder.zafffwqz.bean.Tjxxzb, com.founder.framework.base.entity.SessionBean)
	 */
	@Override
	public void delete(Tjxxzb entity, SessionBean sessionBean) {
		setCrossoutProperties(entity, sessionBean);
		tjxxzbDao.delete(entity);
		
	}
	/*
	 * (查询)
	 * <p>Title: queryTjxxzb</p>
	 * <p>Description: </p>
	 * @param entity
	 * @return
	 * @see com.founder.zafffwqz.service.TjxxzbService#queryTjxxzb(com.founder.zafffwqz.bean.Tjxxzb)
	 */
	@Override
	public Tjxxzb queryTjxxzb(Tjxxzb entity) {
		return tjxxzbDao.queryTjxxzb(entity);
	}
	/*
	 * (保存)
	 * <p>Title: saveTjxxzb</p>
	 * <p>Description: </p>
	 * @param entity
	 * @param sessionBean
	 * @see com.founder.zafffwqz.service.TjxxzbService#saveTjxxzb(com.founder.zafffwqz.bean.Tjxxzb, com.founder.framework.base.entity.SessionBean)
	 */
	@Override
	public void saveTjxxzb(Tjxxzb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity, sessionBean);
		tjxxzbDao.saveTjxxzb(entity);
		Mdxxb md = new Mdxxb();
		md.setId(entity.getMdjfxxid());
		md.setTjjgdm(entity.getTjjgdm());
		mdxxbDao.updateMdxxb(md);
		
		
		
	}
	/*
	 * (修改)
	 * <p>Title: updateTjxxzb</p>
	 * <p>Description: </p>
	 * @param entity
	 * @param sessionBean
	 * @see com.founder.zafffwqz.service.TjxxzbService#updateTjxxzb(com.founder.zafffwqz.bean.Tjxxzb, com.founder.framework.base.entity.SessionBean)
	 */
	@Override
	public void updateTjxxzb(Tjxxzb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		tjxxzbDao.updateTjxxzb(entity);
		Mdxxb md = new Mdxxb();
		md.setId(entity.getMdjfxxid());
		md.setTjjgdm(entity.getTjjgdm());
		mdxxbDao.updateMdxxb(md);
		
	}
	/*
	 * (分页查询)
	 * <p>Title: queryList</p>
	 * <p>Description: </p>
	 * @param page
	 * @param map
	 * @return
	 * @see com.founder.zafffwqz.service.TjxxzbService#queryList(com.founder.framework.utils.EasyUIPage, java.util.Map)
	 */
	@Override
	public EasyUIPage queryList(EasyUIPage page, Map map) {
		return tjxxzbDao.queryList(page, map);
	}

}
