package com.founder.zdrygl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.service.BaseService;
import com.founder.syrkgl.bean.RyRyjbxxb;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
import com.founder.syrkgl.dao.RyRyjbxxbDao;
import com.founder.syrkgl.dao.SyrkSyrkxxzbDao;
import com.founder.zdrygl.service.DataApplyService;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.service.impl.DataApplyServiceImpl.java]  
 * @ClassName:    [DataApplyServiceImpl]   
 * @Description:  [信息复用服务实现]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年9月22日 上午10:36:37]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年9月22日 上午10:36:37，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("dataApplyService")
@Transactional
public class DataApplyServiceImpl extends BaseService implements DataApplyService{
	@Resource(name = "syrkSyrkxxzbDao")
	private SyrkSyrkxxzbDao syrkSyrkxxzbDao;
	
	@Resource(name = "ryRyjbxxbDao")
	private RyRyjbxxbDao ryRyjbxxbDao;
	
	@Override
	public RyRyjbxxb ryjbxxApply(String cyzjdm, String zjhm) {
		return ryRyjbxxbDao.queryByCyzjdmZjhm(cyzjdm, zjhm);		
	}

	@Override
	public SyrkSyrkxxzb syrkApply(String cyzjdm, String zjhm) {
		return syrkSyrkxxzbDao.querySyrkByZj(cyzjdm, zjhm);		
	}

}
