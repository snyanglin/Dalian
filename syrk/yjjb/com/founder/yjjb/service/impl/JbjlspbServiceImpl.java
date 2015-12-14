package com.founder.yjjb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.yjjb.bean.Jbjlspb;
import com.founder.yjjb.dao.JbjlspbDao;
import com.founder.yjjb.service.JbjlspbService;

@Service("jbjlspbService")
@Transactional
public class JbjlspbServiceImpl extends BaseService implements JbjlspbService  {
	
	@Resource(name = "jbjlspbDao")
	private JbjlspbDao jbjlspbDao;
	
	/**
	 * 查询</br>
	 */
	public EasyUIPage queryList(EasyUIPage page,Jbjlspb entity) {
		
		return jbjlspbDao.queryList(page, entity);
	}

	/**
	 * 查询</br>
	 */
	public Jbjlspb queryById(Jbjlspb entity) {
		
		return jbjlspbDao.queryById(entity);
	}
	
	/**
	 * 新增</br>
	 */
	public void save(Jbjlspb entity, SessionBean sessionBean) {
		
		setSaveProperties(entity, sessionBean);
		jbjlspbDao.save(entity, sessionBean);
	}
	
	/**
	 * 修改</br>
	 */
	public void update(Jbjlspb entity, SessionBean sessionBean) {
		
		setUpdateProperties(entity, sessionBean);
		jbjlspbDao.update(entity, sessionBean);
	}
	/**
	 * 删除</br>
	 */
	public void delete(Jbjlspb entity, SessionBean sessionBean) {
		
		setCrossoutProperties(entity, sessionBean);
		jbjlspbDao.delete(entity, sessionBean);
	}

	/**
	 * 根据申请id查询list
	 */
	public List<Jbjlspb> queryBySqbh(Jbjlspb entity) {
		return jbjlspbDao.queryBySqbh(entity);
	}

}
