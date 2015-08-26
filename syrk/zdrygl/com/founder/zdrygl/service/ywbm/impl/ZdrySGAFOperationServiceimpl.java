package com.founder.zdrygl.service.ywbm.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.exception.BussinessException;
import com.founder.framework.utils.BeanUtils;
import com.founder.framework.utils.StringUtils;
import com.founder.framework.utils.UUID;
import com.founder.syrkgl.bean.RyRyjbxxb;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
import com.founder.syrkgl.service.RyRyjbxxbService;
import com.founder.syrkgl.service.SyrkSyrkxxzbService;
import com.founder.zdrygl.bean.ZdryZdryzb;
import com.founder.zdrygl.dao.ZdrySgafzdryxxbDao;
import com.founder.zdrygl.dao.ZdryZdryzbDao;
import com.founder.zdrygl.service.impl.ZdryQYOperationServiceimpl;
import com.founder.zdrygl.vo.ZdryVO;

@Transactional
@Service("zdrySGAFOperationService")
public class ZdrySGAFOperationServiceimpl extends ZdryQYOperationServiceimpl {
	@Resource(name="zdryZdryzbDao")
	private ZdryZdryzbDao zdryZdryzbDao;
	@Resource(name = "zdrySgafzdryxxbDao")
	private ZdrySgafzdryxxbDao zdrySgafzdryxxbDao;
	
	@Resource(name = "syrkSyrkxxzbService")
	private SyrkSyrkxxzbService syrkSyrkxxzbService;
	
	@Resource(name = "ryRyjbxxbService")
	private RyRyjbxxbService ryRyjbxxbService;

	@Override
	public void saveLg(ZdryVO zdryVO) throws BussinessException {
		
		ZdryZdryzb zdryZdryzb=zdryVO.getZdryZdryzb();
		//看是否已经被列管过
		List<ZdryZdryzb> ylg=this.zdryZdryzbDao.queryZdryByRyid(zdryZdryzb.getRyid());
		if(ylg!=null &&ylg.size()>0){
			
			throw new BussinessException("此人已被列管为涉公安访重点人员，不可重复了列管");
		}

		if (!StringUtils.isBlank(zdryVO)) {
			zdryZdryzb = zdryVO.getZdryZdryzb();
		} else {
			throw new BussinessException("zdryVO is not exist");
		}
		
		SyrkSyrkxxzb syrkSyrkxxzb;
		if (!StringUtils.isBlank(zdryZdryzb)) {
			syrkSyrkxxzb = syrkSyrkxxzbService.queryById(zdryZdryzb.getSyrkid());//实有人口信息
		} else {
			throw new BussinessException("zdryVO.zdryZdyzb is not exist");
		}
		
		RyRyjbxxb ryjbxxb;
		if (!StringUtils.isBlank(syrkSyrkxxzb)) {
			ryjbxxb = ryRyjbxxbService.queryById(syrkSyrkxxzb.getRyid());//人员基本信息			
		} else {
			throw new BussinessException(
					"zdryVO.zdryZdyzb.Syrkid matching Syrkzb is not exist");
		}
		
		if (StringUtils.isBlank(ryjbxxb)) {
			throw new BussinessException(
					"zdryVO.zdryZdyzb.Ryid matching RYJBXXB is not exist");
		}
		try{
			BeanUtils.copyObjectSameProperties(ryjbxxb, zdryZdryzb);
			BeanUtils.copyObjectSameProperties(syrkSyrkxxzb, zdryZdryzb);	
		}catch(Exception e){
			
		}
		zdryZdryzb.setSfjm("0");// 默认不加密
		zdryZdryzb.setGlzt("1");
		zdryZdryzb.setId(UUID.create());		
		zdryZdryzbDao.insert(zdryZdryzb);
		
		zdryVO.getZdrySgafzdryxxb().setId(zdryZdryzb.getId());		
		
		zdrySgafzdryxxbDao.save(zdryVO.getZdrySgafzdryxxb());	
	}	
	
	@Override
	public void saveCg(ZdryVO zdryVO) throws BussinessException {
		ZdryZdryzb entity = new ZdryZdryzb();
		entity.setId(zdryVO.getZdryZdryzb().getId());
		entity.setGlzt("3");
		zdryZdryzbDao.update(entity);
	}
}
