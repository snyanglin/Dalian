package com.founder.zdrygl.base.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.zdrygl.base.dao.ZdryZdrkxxbDao;
import com.founder.zdrygl.base.model.ZdryZdrkxxb;
import com.founder.zdrygl.core.decorator.ZdryServiceDecorator;
import com.founder.zdrygl.core.inteface.ZdryService;
import com.founder.zdrygl.core.model.Zdry;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.service.ZdryZdrkService.java]  
 * @ClassName:    [ZdryZdrkService]   
 * @Description:  [重点人口业务服务]   
 * @Author:       [wei.wen@founder.com.cn]  
 * @CreateDate:   [2015年9月21日 下午7:16:11]   
 * @UpdateUser:   [wei.wen@founder.com.cn(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年9月21日 下午7:16:11，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
public class ZdryZdrkService  extends ZdryServiceDecorator{

	private ZdryZdrkxxb zdry;
	
	@Autowired
	private ZdryZdrkxxbDao zdryZdrkxxbDao;

	public ZdryZdrkService(ZdryService zdryService) {
		super(zdryService);
	}

	@Override
	public void setZdry(Zdry entity) {
		this.zdry = (ZdryZdrkxxb) entity;
	}

	@Override
	protected void lg_(SessionBean sessionBean) {
		BaseService.setSaveProperties(zdry, sessionBean);
		zdry.setId(UUID.create());
		zdryZdrkxxbDao.insert(zdry);
	}

	@Override
	protected void cg_(SessionBean sessionBean) {
		if(zdry != null){
			BaseService.setSaveProperties(zdry, sessionBean);
			zdry.setId(UUID.create());
			zdryZdrkxxbDao.insert(zdry);
		}
		
	}

}
