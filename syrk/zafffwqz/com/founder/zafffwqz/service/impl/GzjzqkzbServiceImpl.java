package com.founder.zafffwqz.service.impl;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.zafffwqz.bean.Gzjzqkzb;
import com.founder.zafffwqz.bean.Mdxxb;
import com.founder.zafffwqz.dao.GzjzqkzbDao;
import com.founder.zafffwqz.dao.MdxxbDao;
import com.founder.zafffwqz.service.GzjzqkzbService;

/******************************************************************************
 * @Package:      [com.founder.zafffwqz.service.impl.GzjzqkzbServiceImpl.java]  
 * @ClassName:    [GzjzqkzbServiceImpl]   
 * @Description:  [矛盾-跟踪进展服务实现类]   
 * @Author:       [tian_chengwei@founder.com.cn]  
 * @CreateDate:   [2015-6-2 下午11:56:34]   
 * @UpdateUser:   [lk(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-2 下午11:56:34，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Service("gzjzqkzbService")
@Transactional
public class GzjzqkzbServiceImpl extends BaseService implements GzjzqkzbService {
	
	@Resource(name = "gzjzqkzbDao")
	private GzjzqkzbDao gzjzqkzbDao;
	
	@Resource(name = "mdxxbDao")
	private MdxxbDao mdxxbDao;

	/*
	 * (注销)
	 * <p>Title: delete</p>
	 * <p>Description: </p>
	 * @param entity
	 * @param sessionBean
	 * @see com.founder.zafffwqz.service.GzjzqkzbService#delete(com.founder.zafffwqz.bean.Gzjzqkzb, com.founder.framework.base.entity.SessionBean)
	 */
	@Override
	public void delete(Gzjzqkzb entity, SessionBean sessionBean) {
		setCrossoutProperties(entity, sessionBean);
		gzjzqkzbDao.delete(entity);
	}

	/*
	 * (查询)
	 * <p>Title: queryGzjzqkzb</p>
	 * <p>Description: </p>
	 * @param entity
	 * @return
	 * @see com.founder.zafffwqz.service.GzjzqkzbService#queryGzjzqkzb(com.founder.zafffwqz.bean.Gzjzqkzb)
	 */
	@Override
	public Gzjzqkzb queryGzjzqkzb(Gzjzqkzb entity) {
		return gzjzqkzbDao.queryGzjzqkzb(entity);
	}

	/*
	 * (保存)
	 * <p>Title: saveGzjzqkzb</p>
	 * <p>Description: </p>
	 * @param entity
	 * @param sessionBean
	 * @see com.founder.zafffwqz.service.GzjzqkzbService#saveGzjzqkzb(com.founder.zafffwqz.bean.Gzjzqkzb, com.founder.framework.base.entity.SessionBean)
	 */
	@Override
	public void saveGzjzqkzb(Gzjzqkzb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity, sessionBean);
		gzjzqkzbDao.saveGzjzqkzb(entity);
		Mdxxb md = new Mdxxb();
		md.setId(entity.getMdjfxxid());
		md.setTjjgdm(entity.getTjjgdm());
		mdxxbDao.updateMdxxb(md);
	}

	/*
	 * (修改)
	 * <p>Title: updateGzjzqkzb</p>
	 * <p>Description: </p>
	 * @param entity
	 * @param sessionBean
	 * @see com.founder.zafffwqz.service.GzjzqkzbService#updateGzjzqkzb(com.founder.zafffwqz.bean.Gzjzqkzb, com.founder.framework.base.entity.SessionBean)
	 */
	@Override
	public void updateGzjzqkzb(Gzjzqkzb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		gzjzqkzbDao.updateGzjzqkzb(entity);
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
	 * @see com.founder.zafffwqz.service.GzjzqkzbService#queryList(com.founder.framework.utils.EasyUIPage, java.util.Map)
	 */
	@Override
	public EasyUIPage queryList(EasyUIPage page, Map map) {
		return gzjzqkzbDao.queryList(page, map);
	}

	

}
