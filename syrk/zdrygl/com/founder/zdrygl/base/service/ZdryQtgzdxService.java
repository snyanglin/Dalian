package com.founder.zdrygl.base.service;

import javax.annotation.Resource;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.zdrygl.base.dao.ZdrySqsbzdryxxbDao;
import com.founder.zdrygl.base.model.ZdrySqsbzdryxxb;
import com.founder.zdrygl.base.vo.ZdryVO;
import com.founder.zdrygl.core.decorator.ZdryServiceDecorator;
import com.founder.zdrygl.core.inteface.ZdryService;
import com.founder.zdrygl.core.model.Zdry;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.service.ZdryQtgzdxService.java]  
 * @ClassName:    [ZdryQtgzdxService]   
 * @Description:  [其它关注对象]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年11月3日 下午2:29:02]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年11月3日 下午2:29:02，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
public class ZdryQtgzdxService  extends ZdryServiceDecorator{

	public ZdryQtgzdxService(ZdryService zdryService) {
		super(zdryService);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setZdry(Zdry entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void lg_(SessionBean sessionBean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void cg_(SessionBean sessionBean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void update_(SessionBean sessionBean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void queryZdryAllInfo_(String zdryid, ZdryVO zdryVO) {
		// TODO Auto-generated method stub
		
	}

	

}
