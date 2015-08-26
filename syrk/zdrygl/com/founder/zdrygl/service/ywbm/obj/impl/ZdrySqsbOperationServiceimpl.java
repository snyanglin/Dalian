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
 * @Package:      [com.founder.zdrygl.service.za.obj.impl.ZdrySqsbOperationServiceimpl.java]  
 * @ClassName:    [ZdrySqsbOperationServiceimpl]   
 * @Description:  [涉枪涉暴重点人员服务类]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年8月7日 下午1:48:19]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年8月7日 下午1:48:19，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("zdrySqsbOperationService")
@Transactional
public class ZdrySqsbOperationServiceimpl extends ZdryZAOperationServiceimpl {
	@Resource(name="zdrySqsbzdryxxbDao")
	private ZdrySqsbzdryxxbDao zdrySqsbzdryxxbDao;		
	


	@Override
	public void saveLg(ZdryVO vo) throws BussinessException {
		super.saveLg(vo);
		vo.getZdrySqsbzdryxxb().setId(vo.getZdryZdryzb().getId());
		zdrySqsbzdryxxbDao.insert( vo.getZdrySqsbzdryxxb());				
	}	

}
