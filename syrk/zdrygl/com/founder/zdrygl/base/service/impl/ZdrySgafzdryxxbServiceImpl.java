package com.founder.zdrygl.base.service.impl;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.syrkgl.bean.RyRyjbxxb;
import com.founder.syrkgl.dao.RyRyjbxxbDao;
import com.founder.zdrygl.base.dao.ZdrySgafzdryxxbDao;
import com.founder.zdrygl.base.dao.ZdryZdryZbDao;
import com.founder.zdrygl.base.model.ZdrySgafzdryxxb;
import com.founder.zdrygl.base.model.ZdryZb;
import com.founder.zdrygl.base.service.ZdrySgafzdryxxbService;
import com.founder.zdrygl.base.vo.ZdrySgafzdryAddVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Transactional
@Service
public class ZdrySgafzdryxxbServiceImpl extends BaseService implements ZdrySgafzdryxxbService {

	@Resource
	private ZdrySgafzdryxxbDao zdrySgafzdryxxbDao;
	
	@Resource
	private RyRyjbxxbDao ryRyjbxxbDao;
	
	@Resource
	private ZdryZdryZbDao zdryZdryZbDao;
	
	@Resource
	private OrgOrganizationService orgOrganizationService;
	
	@Override
	public EasyUIPage queryList(ZdrySgafzdryxxb entity, EasyUIPage page) {
		
		return this.zdrySgafzdryxxbDao.queryList(entity, page);
	}

	@Override
	public ZdrySgafzdryxxb queryById(String id) {
		return (ZdrySgafzdryxxb)this.zdrySgafzdryxxbDao.queryById(id);
	}

	@Override
	public void sgafzdryXiaFa(ZdrySgafzdryxxb entity, SessionBean sessionBean) {
		
		if(StringUtils.isBlank(entity.getId())){
			throw new BussinessException("该涉公安访重点人员信息不存在");
		}
		
		ZdrySgafzdryxxb xiaFaEntity = (ZdrySgafzdryxxb)this.zdrySgafzdryxxbDao.queryById(entity.getId());
		if(xiaFaEntity == null){
			throw new BussinessException("该涉公安访重点人员信息不存在");
		}
		
		ZdrySgafzdryxxb updateEntity = new ZdrySgafzdryxxb();
		updateEntity.setId(entity.getId());
		super.setUpdateProperties(updateEntity, sessionBean);
		String orglevel = sessionBean.getUserOrgLevel();
		if("10".equals(orglevel)){
			if(StringUtils.isBlank(entity.getSsfj())){
				throw new BussinessException("未指定下发的分局");
			}
			updateEntity.setSsfj(entity.getSsfj());
			updateEntity.setFjzrld(entity.getFjzrld());
			//更新下发信息
			this.zdrySgafzdryxxbDao.update(updateEntity);
		}else if("21".equals(orglevel)){
			if(StringUtils.isBlank(entity.getSspcs())){
				throw new BussinessException("未指定下发的派出所");
			}
			updateEntity.setSspcs(entity.getSspcs());
			updateEntity.setPcszrld(entity.getPcszrld());
			//更新下发信息
			this.zdrySgafzdryxxbDao.update(updateEntity);
		}else if("32".equals(orglevel)){
			if(StringUtils.isBlank(entity.getSszrq())){
				throw new BussinessException("未指定下发的责任区");
			}
			updateEntity.setSszrq(entity.getSszrq());
			updateEntity.setZrqmj(entity.getZrqmj());
			//更新下发信息
			this.zdrySgafzdryxxbDao.update(updateEntity);
			//更新完指定民警信息，还得调用列管
			ZdryZb zdryzb = (ZdryZb)this.zdryZdryZbDao.queryById(updateEntity.getId());
			if(zdryzb != null){
				zdryzb.setGlbm(entity.getSszrq());
				zdryzb.setGxbm(entity.getSszrq());
				zdryzb.setGlzt("2");
				super.setUpdateProperties(zdryzb, sessionBean);
				this.zdryZdryZbDao.update(zdryzb);
			}
		}
		
	}

	@Override
	public void saveAdd(ZdrySgafzdryAddVO addVO, SessionBean sessionBean) {
		
		RyRyjbxxb entity = addVO.getRyRyjbxxb();
		
		Integer esistsCount = this.zdrySgafzdryxxbDao.queryCount(entity.getZjhm());
		if(esistsCount > 0){
			throw new BussinessException("该涉公安访重点人员信息已存在");
		}
		
		//人员基本信息维护
		RyRyjbxxb ryJbxx = this.ryRyjbxxbDao.queryById(addVO.getRyRyjbxxb().getId());
		if(ryJbxx== null){
			entity.setId(UUID.create());
			entity.setSyrkbz("0");
			super.setSaveProperties(entity, sessionBean);
			//没有信息，需要插入
			this.ryRyjbxxbDao.save(entity, sessionBean);
		}else{
			entity = ryJbxx;
		}
		
		//重点人员总表信息维护
		ZdryZb zdryzb = new ZdryZb();
		super.setSaveProperties(zdryzb, sessionBean);
		zdryzb.setId(UUID.create());
		zdryzb.setRyid(entity.getId());
		zdryzb.setXm(entity.getXm());
		zdryzb.setCsrq(entity.getCsrq());
		zdryzb.setCyzjdm(entity.getCyzjdm());
		zdryzb.setXbdm(entity.getXbdm());
		zdryzb.setZjhm(entity.getZjhm());
		zdryzb.setGlzt("6");
		zdryzb.setZdrylb("05");
		zdryzb.setZdrygllxdm("05");
		
		zdryzb.setHjd_dzid(entity.getHjd_dzid());
		zdryzb.setHjd_dzxz(entity.getHjd_dzxz());
		zdryzb.setHjd_mlpdm(entity.getHjd_mlpdm());
		zdryzb.setHjd_mlpxz(entity.getHjd_mlpxz());
		zdryzb.setHjd_xzqhdm(entity.getHjd_xzqhdm());
		zdryzb.setMzdm(entity.getMzdm());
		this.zdryZdryZbDao.insert(zdryzb);
		
		//涉公安访信息表
		ZdrySgafzdryxxb sgafzdry = addVO.getZdrySgafzdryxxb();
		super.setSaveProperties(sgafzdry, sessionBean);
		sgafzdry.setId(zdryzb.getId());
		sgafzdry.setSfganbfdm("0");
		sgafzdry.setSfxk("0");
		sgafzdry.setXm(entity.getXm());
		sgafzdry.setXbdm(entity.getXbdm());
		sgafzdry.setGmsfhm(entity.getZjhm());
		sgafzdry.setHjd_dzid(entity.getHjd_dzid());
		sgafzdry.setHjd_dzxz(entity.getHjd_dzxz());
		sgafzdry.setHjd_mlpdm(entity.getHjd_mlpdm());
		sgafzdry.setHjd_mlpxz(entity.getHjd_mlpxz());
		sgafzdry.setHjd_xzqhdm(entity.getHjd_xzqhdm());
		sgafzdry.setJzd_dzid(entity.getJzd_dzid());
		sgafzdry.setJzd_dzxz(entity.getJzd_dzxz());
		sgafzdry.setJzd_mlpdm(entity.getJzd_mlpdm());
		sgafzdry.setJzd_mlpxz(entity.getJzd_mlpxz());
		sgafzdry.setJzd_xzqhdm(entity.getJzd_xzqhdm());
		
		String orglevel = sessionBean.getUserOrgLevel();
		String orgcode = sessionBean.getUserOrgCode();
		if("10".equals(orglevel)){
			sgafzdry.setSssj(orgcode);
		}else if("21".equals(orglevel)){
			sgafzdry.setSsfj(orgcode);
			String parentOrgcode = this.orgOrganizationService.queryParentOrgByOrgcode(orgcode).getOrgcode();
			sgafzdry.setSssj(parentOrgcode);
		}
		
		//添加批次信息
		ZdrySgafzdryxxb pcEntity = this.zdrySgafzdryxxbDao.queryMaxPc(sgafzdry);
				Long sequences = new Long(1);
		if (!StringUtils.isBlank(pcEntity.getPc())) {
			sequences = Long.valueOf(pcEntity.getPc()) + 1;
		}
		
		sgafzdry.setPc("LNDL"+DateUtils.getSystemYearString()+String.format("%05d", sequences));
		
		this.zdrySgafzdryxxbDao.insert(sgafzdry);
	}

	@Override
	public String queryRyidByZdrySgafzdryId(String zdrySgafzdryId) {

		ZdryZb entity = (ZdryZb)this.zdryZdryZbDao.queryById(zdrySgafzdryId);
		if(entity == null){
			return null;
		}
		
		return entity.getRyid();
	}

}
