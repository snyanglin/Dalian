package com.founder.yjjb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.yjjb.bean.Xscljlb;
import com.founder.yjjb.dao.XscljlbDao;
import com.founder.yjjb.service.CommonService;
import com.founder.yjjb.service.XscljlbService;

@Service("xscljlbService")
@Transactional
public class XscljlbServiceImpl extends BaseService implements XscljlbService {

	@Resource(name = "xscljlbDao")
	private XscljlbDao xscljlbDao;
	
	Xscljlb xscljlb = new Xscljlb();
	
	@Resource(name="commonService")
	private CommonService commonService;
	/**
	 * 查询</br>
	 */
	public EasyUIPage queryList(EasyUIPage page,Xscljlb entity) {
		
		return xscljlbDao.queryList(page, entity);
	}

	/**
	 * 查询</br>
	 */
	public Xscljlb queryById(Xscljlb entity) {
		
		return xscljlbDao.queryById(entity);
	}

	/**
	 * 新增</br>
	 */
	public void save(Xscljlb entity, SessionBean sessionBean) {
		
		commonService.CreateNewSeq("10", sessionBean.getUserOrgCode());
		setSaveProperties(entity, sessionBean);
		xscljlbDao.save(entity, sessionBean);
	}

	/**
	 * 修改</br>
	 */
	public void update(Xscljlb entity, SessionBean sessionBean) {
		
		setUpdateProperties(entity, sessionBean);
		xscljlbDao.update(entity, sessionBean);
	}

	/**
	 * 删除</br>
	 */
	public void delete(Xscljlb entity, SessionBean sessionBean) {
		
		setCrossoutProperties(entity, sessionBean);
		xscljlbDao.delete(entity, sessionBean);
	}

	public void saveLog(String xsbh, String cznr,String czlx, SessionBean sessionBean){
		
		String id = commonService.CreateNewSeq("10", sessionBean.getUserOrgCode());
		xscljlb.setId(id);
		xscljlb.setXsbh(xsbh);
		xscljlb.setCznr(cznr);
		xscljlb.setCzlx(czlx);
		
		setSaveProperties(xscljlb, sessionBean);
		xscljlbDao.save(xscljlb, sessionBean);
	}

	/* (非 Javadoc)
	 * <p>Title: queryByXsbh</p>
	 * <p>Description: </p>
	 * @param entity
	 * @see com.founder.yjjb.service.XscljlbService#queryByXsbh(com.founder.yjjb.bean.Xscljlb)
	 */
	public List<Xscljlb> queryListByXsbh(Xscljlb entity) {
		return xscljlbDao.queryListByXsbh(entity);
	}
	
}
