package com.founder.zdrygl.service.ywbm.obj.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.zdrygl.dao.*;
import com.founder.zdrygl.service.ywbm.impl.ZdryZAOperationServiceimpl;
import com.founder.zdrygl.vo.ZdryVO;
import com.founder.framework.exception.BussinessException;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.service.za.obj.impl.ZdryZdrkOperationServiceimpl.java]  
 * @ClassName:    [ZdryZdrkOperationServiceimpl]   
 * @Description:  [重点人员 重点人口 服务类]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年8月5日 上午11:22:46]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年8月5日 上午11:22:46，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("zdryZdrkOperationService")
@Transactional
public class ZdryZdrkOperationServiceimpl extends ZdryZAOperationServiceimpl {
	@Resource(name="zdryZdrkxxbDao")
	private ZdryZdrkxxbDao zdryZdrkxxbDao;		
	


	@Override
	public void saveLg(ZdryVO vo) throws BussinessException {
		super.saveLg(vo);
		vo.getZdryZdrkxxb().setId(vo.getZdryZdryzb().getId());
		zdryZdrkxxbDao.insert( vo.getZdryZdrkxxb());
		
		
	}

	@Override
	public void saveCg(ZdryVO vo) throws BussinessException {
		super.saveCg(vo);
		vo.getZdryZdrkxxb().setId(vo.getZdryZdryzb().getId());
		zdryZdrkxxbDao.delete( vo.getZdryZdrkxxb());
	}

}
