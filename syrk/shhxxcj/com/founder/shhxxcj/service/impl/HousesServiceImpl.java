package com.founder.shhxxcj.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.utils.EasyUIPage;

import com.founder.shhxxcj.bean.Houses;
import com.founder.shhxxcj.dao.HousesDao;
import com.founder.shhxxcj.service.HousesService;
import com.founder.syfw.bean.Czfwxxb;
import com.founder.syfw.bean.Fwjbxxb;
import com.founder.syfw.dao.SyfwQueryDao;
import com.founder.syfw.service.SyfwEditService;


@Transactional
@Service
public class HousesServiceImpl implements HousesService {

	@Resource
	private HousesDao housesDao;
	@Resource
	private SyfwEditService syfwEditService;
	@Resource
	private SyfwQueryDao syfwQueryDao;
	@Resource
	private OrgOrganizationService orgOrganizationService;

	@Override
	public EasyUIPage queryList(Houses entity, EasyUIPage page,SessionBean sessionBean) {

		if("50".equals(sessionBean.getUserOrgLevel())){
			OrgOrganization pcs = orgOrganizationService.queryParentOrgByOrgcode(sessionBean.getUserOrgCode());
			entity.setSs4jbmdm(sessionBean.getUserOrgCode());
			entity.setFwszdpcscod(pcs.getOrgcode());
		}else{
			entity.setFwszdpcscod("只有责任区的民警能查到数据");
		}
	
		return housesDao.queryList(entity, page);

	}

	@Override
	public void update(Houses entity, SessionBean sessionBean) {
		housesDao.update(entity);
		
	}

	@Override
	public Houses queryById(String id) {
		
		return housesDao.queryById(id);
	}

	@Override
	public void saveCzfwhs(Fwjbxxb fwjbxxb, Czfwxxb czfwxxb,String housesId,SessionBean sessionBean) {
		
	
		try{
		syfwEditService.insertFwjbxxb(fwjbxxb, sessionBean);
		
	    fwjbxxb = syfwQueryDao.queryByDzid(fwjbxxb.getFwdz_dzid());
	    
		Houses houses =this.queryById(housesId);
		houses.setBzdzid(fwjbxxb.getFwdz_dzid());
		houses.setHszt("1");
		houses.setSs4jbmdm(sessionBean.getUserOrgCode());
		houses.setSyfwid(fwjbxxb.getId());
		this.update(houses, sessionBean);
		
		}catch(Exception ex){
			ex.printStackTrace();
		}
		czfwxxb.setFwid(fwjbxxb.getId());
		syfwEditService.insertCzfwxxb(czfwxxb, sessionBean);
		
	}

	@Override
	public String queryBzdzById(String bzdzid) {
		
		return this.housesDao.queryByBzdzId(bzdzid);
	}
	
	
	
	
	
}
