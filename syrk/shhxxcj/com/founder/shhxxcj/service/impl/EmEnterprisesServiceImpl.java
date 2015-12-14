package com.founder.shhxxcj.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.shhxxcj.bean.EmEnterprises;
import com.founder.shhxxcj.dao.EmEnterprisesDao;
import com.founder.shhxxcj.service.EmEnterprisesService;
import com.founder.sydw_dl.bean.Dwbmxxb;
import com.founder.sydw_dl.bean.Dwjbxxb;
import com.founder.sydw_dl.service.DwjbxxbService;

@Service
@Transactional
public class EmEnterprisesServiceImpl implements EmEnterprisesService {

	@Resource
	private EmEnterprisesDao emEnterprisesDao;
	@Resource
	private OrgOrganizationService orgOrganizationService;	
	@Resource
	private DwjbxxbService dwjbxxbService;
	@Override
	public EmEnterprises queryById(String id) {
		
		return emEnterprisesDao.queryById(id);

	}

	@Override
	public EasyUIPage queryList(EmEnterprises entity, EasyUIPage page,
			SessionBean sessionBean) {
		if("50".equals(sessionBean.getUserOrgLevel())){
			OrgOrganization pcs = orgOrganizationService.queryParentOrgByOrgcode(sessionBean.getUserOrgCode());
			entity.setSs4jbmdm(sessionBean.getUserOrgCode());
			entity.setPcscode(pcs.getOrgcode());
		}else{
			entity.setPcscode("只有责任区的民警能查到数据");
		}
	    page=emEnterprisesDao.queryList(entity, page);
	    List<EmEnterprises> list=(List<EmEnterprises> )page.getRows();

	/*    for(int i=0;i<list.size();i++){
	    	EmEnterprises enterprise=list.get(i);
	    	if(enterprise.getBzdzid()==null){
	    		list.get(i).setBzdzid(enterprise.getBzdzmc());
	    	}
	    }*/
	    page.setRows(list);
		return page;
	}

	@Override
	public void update(EmEnterprises entity, SessionBean sessionBean) {
		emEnterprisesDao.update(entity);


	}

	@Override
	public void saveSydwhs(Dwjbxxb dwjbxxb, String ementerpriseId,
			Dwbmxxb[] dwbmxxbArray, SessionBean sessionBean) {
		try{
			String dwjbxxbId =dwjbxxbService.save(dwjbxxb, dwbmxxbArray, "", sessionBean);
			
			EmEnterprises enterprise=this.emEnterprisesDao.queryById(ementerpriseId);
		    enterprise.setHszt("1");
		    //如果新建单位的时候选的是非标准地址，则把核实表的地址id设置成非标准地址的值
		    if(!StringUtils.isBlank(dwjbxxb.getDz_dwdzdm())){
			    enterprise.setBzdzid(dwjbxxb.getDz_dwdzdm());

		    }else{
		    	enterprise.setBzdzid(dwjbxxb.getDzms_dwdzmlpxz()+dwjbxxb.getDzms_chdz());
		    }
		    enterprise.setSs4jbmdm(dwjbxxb.getGlbmid());
		    enterprise.setSydwid(dwjbxxbId);
		
			this.update(enterprise, sessionBean);
			
			}catch(Exception ex){
				ex.printStackTrace();
				throw new BussinessException("保存失败");
			}
		
	}

}
