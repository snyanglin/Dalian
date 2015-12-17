package com.founder.zdrygl.base.service;

import javax.annotation.Resource;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
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

	@Resource(name="zdryZdrkxxbDao")
	private ZdryZdrkxxbDao zdryZdrkxxbDao;

	public ZdryZdrkService(ZdryService zdryService) {
		super(zdryService);
	}

	/**
	 * 列管重点人口
	 */
	@Override
	protected void lg_(SessionBean sessionBean , Zdry zdrylbdx) {
		insert(sessionBean, zdrylbdx);
	}
	
	@Override
	protected void lgFail_(SessionBean sessionBean, Zdry zdrylbdx) {
		ZdryZdrkxxb zdryZdrkxxb = (ZdryZdrkxxb) zdrylbdx;
		BaseService.setCrossoutProperties(zdryZdrkxxb, sessionBean);
		zdryZdrkxxbDao.delete(zdryZdrkxxb);
	}

	@Override
	protected void cg_(SessionBean sessionBean , Zdry zdrylbdx) {
		insert(sessionBean, zdrylbdx);
	}
	
	@Override
	protected void cgFail_(SessionBean sessionBean, Zdry zdrylbdx) {
		ZdryZdrkxxb zdryZdrkxxb = (ZdryZdrkxxb) zdrylbdx;
		BaseService.setCrossoutProperties(zdryZdrkxxb, sessionBean);
		zdryZdrkxxbDao.delete(zdryZdrkxxb);
	}
	
	/**
	 * 
	 * @Title: update_
	 * @Description: (子表（重点人口）修改)
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throw
	 */
	@Override
	protected void update_(SessionBean sessionBean, Zdry zdrylbdx) {
		ZdryZdrkxxb zdryZdrkxxb = (ZdryZdrkxxb) zdrylbdx;
		BaseService.setUpdateProperties(zdryZdrkxxb, sessionBean);
		zdryZdrkxxbDao.update(zdryZdrkxxb);
	}
	
	@Override
	protected void zd_(SessionBean sessionBean, Zdry zdrylbdx) {
		insert(sessionBean, zdrylbdx);		
	}

	@Override
	protected void zdFail_(SessionBean sessionBean, Zdry zdrylbdx) {
		ZdryZdrkxxb zdryZdrkxxb = (ZdryZdrkxxb) zdrylbdx;
		BaseService.setCrossoutProperties(zdryZdrkxxb, sessionBean);
		zdryZdrkxxbDao.delete(zdryZdrkxxb);
	}
	
	private void insert(SessionBean sessionBean, Zdry zdrylbdx){
		if(zdrylbdx != null){
			ZdryZdrkxxb zdryZdrkxxb = (ZdryZdrkxxb) zdrylbdx;
			BaseService.setSaveProperties(zdryZdrkxxb, sessionBean);	
			zdryZdrkxxbDao.insert(zdryZdrkxxb);
		}
	}
}
