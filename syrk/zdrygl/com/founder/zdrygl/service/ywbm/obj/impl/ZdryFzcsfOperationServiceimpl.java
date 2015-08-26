package com.founder.zdrygl.service.ywbm.obj.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.exception.BussinessException;
import com.founder.zdrygl.dao.ZdryFzcsfryxxbDao;
import com.founder.zdrygl.service.ywbm.impl.ZdryZAOperationServiceimpl;
import com.founder.zdrygl.vo.ZdryVO;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.service.za.obj.impl.ZdryFzcsfOperationServiceimpl.java]  
 * @ClassName:    [ZdryFzcsfOperationServiceimpl]   
 * @Description:  [重点人口非正常上访服务类]   
 * @Author:       [zhang.hai]  
 * @CreateDate:   [2015-07-27 9:00:00]   
 * @UpdateUser:   [zhang.hai]   
 * @UpdateDate:   [2015-07-27 9:00:00，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("zdryFzcsfOperationService")
@Transactional
public class ZdryFzcsfOperationServiceimpl extends ZdryZAOperationServiceimpl {
	@Resource(name="zdryFzcsfryxxbDao")
	private ZdryFzcsfryxxbDao zdryFzcsfryxxbDao;		
	


	@Override
	public void saveLg(ZdryVO vo) throws BussinessException {
		super.saveLg(vo);
		vo.getZdryFzcsfryxxb().setId(vo.getZdryZdryzb().getId());
		zdryFzcsfryxxbDao.insert( vo.getZdryFzcsfryxxb());
		
		
	}

	@Override
	public void saveCg(ZdryVO vo) throws BussinessException {
		super.saveCg(vo);
		vo.getZdryFzcsfryxxb().setId(vo.getZdryZdryzb().getId());
		zdryFzcsfryxxbDao.delete( vo.getZdryFzcsfryxxb());
	}

}
