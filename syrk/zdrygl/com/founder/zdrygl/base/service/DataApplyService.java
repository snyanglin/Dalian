package com.founder.zdrygl.base.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.service.BaseService;
import com.founder.syrkgl.bean.RyRyjbxxb;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
import com.founder.syrkgl.dao.RyRyjbxxbDao;
import com.founder.syrkgl.dao.SyrkSyrkxxzbDao;
import com.founder.zdrygl.base.model.DataApplyConfig;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.service.DataApplyService.java]  
 * @ClassName:    [DataApplyService]   
 * @Description:  [信息复用服务]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年9月25日 上午11:14:54]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年9月25日 上午11:14:54，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("dataApplyService")
@Transactional
public class DataApplyService extends BaseService{
	@Resource(name = "syrkSyrkxxzbDao")
	private SyrkSyrkxxzbDao syrkSyrkxxzbDao;
	
	@Resource(name = "ryRyjbxxbDao")
	private RyRyjbxxbDao ryRyjbxxbDao;
	
	private DataApplyConfig dataApplyConfig = new DataApplyConfig();
		
	public RyRyjbxxb ryjbxxApply(String cyzjdm, String zjhm) {
		return ryRyjbxxbDao.queryByCyzjdmZjhm(cyzjdm, zjhm);		
	}
	
	public SyrkSyrkxxzb syrkApply(String cyzjdm, String zjhm) {
		return syrkSyrkxxzbDao.querySyrkByZj(cyzjdm, zjhm);		
	}

	public String ryxxApply(String cyzjdm, String zjhm) {
		return dataApplyConfig.dataApply(cyzjdm, zjhm);		
	}
}
