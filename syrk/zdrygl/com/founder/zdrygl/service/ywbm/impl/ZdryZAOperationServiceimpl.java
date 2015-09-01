package com.founder.zdrygl.service.ywbm.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.exception.BussinessException;
import com.founder.framework.utils.BeanUtils;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.StringUtils;
import com.founder.framework.utils.UUID;
import com.founder.syrkgl.bean.RyRyjbxxb;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
import com.founder.syrkgl.service.RyRyjbxxbService;
import com.founder.syrkgl.service.SyrkSyrkxxzbService;
import com.founder.zdrygl.bean.ZdryGzb;
import com.founder.zdrygl.bean.ZdryZdryzb;
import com.founder.zdrygl.dao.ZdryGzbDao;
import com.founder.zdrygl.dao.ZdryZdryzbDao;
import com.founder.zdrygl.service.impl.ZdryQYOperationServiceimpl;
import com.founder.zdrygl.until.ZdryUntil;
import com.founder.zdrygl.vo.ZdryVO;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.service.za.obj.impl.ZdryFzcsfOperationServiceimpl.java]  
 * @ClassName:    [ZdryFzcsfOperationServiceimpl]   
 * @Description:  [重点人口治安部门服务类]   
 * @Author:       [zhang.hai]  
 * @CreateDate:   [2015-07-27 9:00:00]   
 * @UpdateUser:   [zhang.hai]   
 * @UpdateDate:   [2015-07-27 9:00:00，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */

@Service("zdryZAOperationService")
@Transactional
public  class ZdryZAOperationServiceimpl extends ZdryQYOperationServiceimpl {
	
	@Resource(name = "syrkSyrkxxzbService")
	private SyrkSyrkxxzbService syrkSyrkxxzbService;
	
	@Resource(name = "ryRyjbxxbService")
	private RyRyjbxxbService ryRyjbxxbService;
	
	@Resource(name="zdryZdryzbDao")
	private ZdryZdryzbDao zdryZdryzbDao;
	
	@Resource(name="zdryGzbDao")
	private ZdryGzbDao zdryGzbDao;
	
	@Resource(name="ZdryUntil")
	private ZdryUntil zdryUntil;
	
	@Override
	public void saveLg(ZdryVO zdryVO) throws BussinessException {
		ZdryZdryzb zdryZdryzb=zdryVO.getZdryZdryzb();
		
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
			//BeanUtils.copyObjectSameProperties(ryjbxxb, zdryZdryzb);
			//BeanUtils.copyObjectSameProperties(syrkSyrkxxzb, zdryZdryzb);	
			//这样写，会把创建时间修改时间这些公用信息全复制的
			zdryZdryzb.setJgssxdm(ryjbxxb.getJgssxdm());
			
			/*这三个没找到相同名字的字段赋值
			zdryZdryzb.setHjd_sspcsdm(hjd_sspcsdm);
			zdryZdryzb.setHjd_sssq(hjd_sssq);
			zdryZdryzb.setHjd_ssxjgajgdm(hjd_ssxjgajgdm);
			*/
		}catch(Exception e){
			
		}
		
		ZdryGzb zdryGzb=zdryGzbDao.queryByZdrylx(zdryZdryzb.getZdrygllxdm(),zdryUntil.querySYSConfig());
		if(zdryGzb!=null && "1".equals(zdryGzb.getSfslg())){//双列管，查询户籍地管理部门
			String gxbm=zdryZdryzbDao.queryHjdZrqdm(ryjbxxb.getHjd_mlpdm());
			if(gxbm!=null && gxbm.length()>0)
				zdryZdryzb.setGxbm(gxbm);
		}
		
		zdryZdryzb.setSfjm("0");// 默认不加密
		zdryZdryzb.setGlzt("1");
		zdryZdryzb.setId(UUID.create());		
		zdryZdryzbDao.insert(zdryZdryzb);
	}

	@Override
	public void saveCg(ZdryVO vo) throws BussinessException {
		ZdryZdryzb entity = new ZdryZdryzb();
		entity.setId(vo.getZdryZdryzb().getId());
		entity.setGlzt("3");
		entity.setXt_zhxgsj(DateUtils.getSystemDateTimeString());		
		entity.setXt_zhxgrxm(vo.getZdryZdryzb().getXt_zhxgrxm());
		entity.setXt_zhxgrid(vo.getZdryZdryzb().getXt_zhxgrid());
		entity.setXt_zhxgrbm(vo.getZdryZdryzb().getXt_zhxgrbm());
		entity.setXt_zhxgrbmid(vo.getZdryZdryzb().getXt_zhxgrbmid());
		entity.setXt_zhxgip(vo.getZdryZdryzb().getXt_zhxgip());		
		zdryZdryzbDao.update(entity);
	}
}