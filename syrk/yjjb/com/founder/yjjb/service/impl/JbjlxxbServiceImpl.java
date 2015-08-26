package com.founder.yjjb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.yjjb.bean.Jbjlxxb;
import com.founder.yjjb.dao.JbjlxxbDao;
import com.founder.yjjb.service.JbjlxxbService;

@Service("jbjlxxbService")
@Transactional
public class JbjlxxbServiceImpl extends BaseService implements JbjlxxbService  {
	
	@Resource(name = "jbjlxxbDao")
	private JbjlxxbDao jbjlxxbDao;
	
	/**
	 * 查询</br>
	 */
	public EasyUIPage queryList(EasyUIPage page,Jbjlxxb entity) {
		
		return jbjlxxbDao.queryList(page, entity);
	}

	/**
	 * 查询</br>
	 */
	public Jbjlxxb queryById(Jbjlxxb entity) {
		
		return jbjlxxbDao.queryById(entity);
	}
	
	/**
	 * 新增</br>
	 */
	public void save(Jbjlxxb entity, SessionBean sessionBean) {
		
		setSaveProperties(entity, sessionBean);
		jbjlxxbDao.save(entity, sessionBean);
	}
	
	/**
	 * 修改</br>
	 */
	public void update(Jbjlxxb entity, SessionBean sessionBean) {
		
		setUpdateProperties(entity, sessionBean);
		jbjlxxbDao.update(entity, sessionBean);
	}
	/**
	 * 删除</br>
	 */
	public void delete(Jbjlxxb entity, SessionBean sessionBean) {
		
		setCrossoutProperties(entity, sessionBean);
		jbjlxxbDao.delete(entity, sessionBean);
	}

	/* (非 Javadoc)
	 * <p>Title: queryId</p>
	 * <p>Description: </p>
	 * @param jbjlxxb
	 * @return
	 * @see com.founder.yjjb.service.JbjlxxbService#queryId(com.founder.yjjb.bean.Jbjlxxb)
	 */
	public Jbjlxxb queryId(Jbjlxxb entity) {
		return jbjlxxbDao.queryId(entity);
	}

	/* (非 Javadoc)
	 * <p>Title: queryByXsbhAjbh</p>
	 * 根据线索编号案件编号查询申请表中的数据
	 * @param entJbjlxxb
	 * @return
	 * @see com.founder.yjjb.service.JbjlxxbService#queryByXsbhAjbh(com.founder.yjjb.bean.Jbjlxxb)
	 */
	public List<Jbjlxxb> queryByXsbhAjbh(Jbjlxxb entity) {
		return jbjlxxbDao.queryByXsbhAjbh(entity);
	}
}
