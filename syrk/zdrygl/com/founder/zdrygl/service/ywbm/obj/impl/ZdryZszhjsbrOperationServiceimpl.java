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
 * @Package:      [com.founder.zdrygl.service.za.obj.impl.ZdryJsbrOperationServiceimpl.java]  
 * @ClassName:    [ZdryJsbrOperationServiceimpl]   
 * @Description:  [重点人员 肇事肇祸精神病人 服务类]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年8月5日 上午11:23:37]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年8月5日 上午11:23:37，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("zdryZszhjsbrOperationService")
@Transactional
public class ZdryZszhjsbrOperationServiceimpl extends ZdryZAOperationServiceimpl {
	@Resource(name="zdryZszhjsbrxxbDao")
	private ZdryZszhjsbrxxbDao zdryZszhjsbrxxbDao;		
	


	@Override
	public void saveLg(ZdryVO vo) throws BussinessException {
		super.saveLg(vo);
		vo.getZdryZszhjsbrxxb().setId(vo.getZdryZdryzb().getId());
		zdryZszhjsbrxxbDao.insert( vo.getZdryZszhjsbrxxb());
		
		
	}

	@Override
	public void saveCg(ZdryVO vo) throws BussinessException {
		super.saveCg(vo);
		vo.getZdryZszhjsbrxxb().setId(vo.getZdryZdryzb().getId());
		zdryZszhjsbrxxbDao.delete( vo.getZdryZszhjsbrxxb());
	}

}
