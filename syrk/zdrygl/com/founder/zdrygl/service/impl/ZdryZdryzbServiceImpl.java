package com.founder.zdrygl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrygl.bean.ZdryZdryzb;
import com.founder.zdrygl.dao.ZdryZdryzbDao;
import com.founder.zdrygl.service.ZdryZdryzbService;
import com.founder.zdrygl.vo.ZdryZdryzbVO;

@Service("zdryZdryzbService")
public class ZdryZdryzbServiceImpl extends BaseService implements
		ZdryZdryzbService {

	@Resource(name="zdryZdryzbDao")
	private ZdryZdryzbDao zdryZdryzbDao;
	
	@Override
	public List<ZdryZdryzb> queryZdryByRyid(String ryid) {
		return zdryZdryzbDao.queryZdryByRyid(ryid);
	}

	@Override 
	public List<ZdryZdryzb> queryZdryBySyrkid(String syrkid) {
		return zdryZdryzbDao.queryZdryBySyrkid(syrkid);
	}
	
	@Override
	public void insert(ZdryZdryzb entity,SessionBean sessionBean) {
		super.setSaveProperties(entity, sessionBean);
		zdryZdryzbDao.insert(entity);
	}

	@Override
	public void update(ZdryZdryzb entity,SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		zdryZdryzbDao.update(entity);
	}

	@Override
	public void delete(ZdryZdryzb entity,SessionBean sessionBean) {
		setCrossoutProperties(entity, sessionBean);
		zdryZdryzbDao.delete(entity);
	}

	@Override
	public ZdryZdryzb queryById(String id) {
		return (ZdryZdryzb) zdryZdryzbDao.queryById(id);
	}

	@Override
	public EasyUIPage queryList(ZdryZdryzbVO entity, EasyUIPage page) {
		return zdryZdryzbDao.queryManagerList(entity, page);
	}
	
	@Override
	public List queryList(String ryid){
		
		return zdryZdryzbDao.queryZdryVoByRyid(ryid);
	}
	
	@Override
	public List querySgafList(String ryid){
		
		return zdryZdryzbDao.querySgafZdryVOByRyid(ryid);
	}

	@Override
	public ZdryZdryzb queryBySyrkidAndgllx(String syrkid, String gllx) {
		return zdryZdryzbDao.queryBySyrkidAndgllx(syrkid,gllx);
	}

	@Override
	public EasyUIPage queryDwDzOnPT(EasyUIPage page, ZdryZdryzbVO entity){
		return zdryZdryzbDao.queryDwDzOnPT(page, entity);
	}
	@Override
	public List<ZdryZdryzb> queryZdrylxdmByGmsfhm(String zjhm){
		return zdryZdryzbDao.queryZdrylxdmByGmsfhm(zjhm);
	}

	@Override
	public Integer queryForCount(String syrkId) {
		return zdryZdryzbDao.queryCount(syrkId);
	}
	

}
