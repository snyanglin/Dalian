package com.founder.ggfw.dao;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.UUID;
import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.message.bean.SysMessage;
import com.founder.ggfw.bean.Ywxtgzrwb;

@Repository("ywxtgzrwbDao")
public class YwxtgzrwbDao extends BaseDaoImpl {
	
	/**
	 * 根据id查询'业务协同规则任务表'
	 * 
	 * @param id
	 * @return
	 */
	public SysMessage queryYwxtgzrwbById(String id) {
		return (SysMessage) super.queryForObject("Ywxtgzrwb.queryYwxtgzrwbById", id);
	}
	
	public void savaYwxtgzrwb(Ywxtgzrwb entity){
		super.insert("Ywxtgzrwb.insertYwxtgzrwb", entity);
	}
	public void updateYwxtgzrwb(Ywxtgzrwb entity){
		super.insert("Ywxtgzrwb.updateYwxtgzrwb", entity);
	}

	public String savaYwxtgzrwb(Ywxtgzrwb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		String sysStringDate = DateUtils.getSystemDateTimeString();
		entity.setFqsj(sysStringDate);
		entity.setFqrbmid(sessionBean.getUserOrgCode());
		entity.setFqrbm(sessionBean.getUserOrgName());
		entity.setFqrid(sessionBean.getUserId());
		entity.setFqr(sessionBean.getUserName());
		entity.setYwrwztdm("1");
		BaseService.setSaveProperties(entity, sessionBean);
		savaYwxtgzrwb(entity);
		return entity.getId();
	}

	public void updateYwxtgzrwbByClr(Ywxtgzrwb ywxtgzrwb,SessionBean sessionBean) {
		String sysStringDate = DateUtils.getSystemDateTimeString();
		ywxtgzrwb.setRwclsj(sysStringDate);
		ywxtgzrwb.setRwclrbmid(sessionBean.getUserOrgCode());
		ywxtgzrwb.setRwclrbm(sessionBean.getUserOrgName());
		ywxtgzrwb.setRwclrid(sessionBean.getUserId());
		ywxtgzrwb.setRwclr(sessionBean.getUserName());
		updateYwxtgzrwb(ywxtgzrwb);

	}

	public void updateYwxtgzrwbByCjr(Ywxtgzrwb ywxtgzrwb,SessionBean sessionBean){
		String sysStringDate = DateUtils.getSystemDateTimeString();
		ywxtgzrwb.setCjsj(sysStringDate);
		ywxtgzrwb.setCjrbmid(sessionBean.getUserOrgCode());
		ywxtgzrwb.setCjrbm(sessionBean.getUserOrgName());
		ywxtgzrwb.setCjrid(sessionBean.getUserId());
		ywxtgzrwb.setCjr(sessionBean.getUserName());
		updateYwxtgzrwb(ywxtgzrwb);

	}
}
