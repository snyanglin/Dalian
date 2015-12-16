package com.founder.zdrygl.base.service;

import javax.annotation.Resource;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.zdrygl.base.dao.ZdryNrsxdxxxbDao;
import com.founder.zdrygl.base.model.ZdryNrsxdxxxb;
import com.founder.zdrygl.core.decorator.ZdryServiceDecorator;
import com.founder.zdrygl.core.inteface.ZdryService;
import com.founder.zdrygl.core.model.Zdry;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.service.ZdryNrsxService.java]  
 * @ClassName:    [ZdryNrsxService]   

 * @Description:  [纳入视线对象服务]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年12月9日 下午4:33:55]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年12月9日 下午4:33:55，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
public class ZdryNrsxService  extends ZdryServiceDecorator{

	@Resource(name="zdryNrsxdxxxbDao")
	private ZdryNrsxdxxxbDao  zdryNrsxdxxxbDao;

	public ZdryNrsxService(ZdryService zdryService) {
		super(zdryService);
	}

	/**
	 * 列管重点人口
	 */
	@Override
	protected void lg_(SessionBean sessionBean,Zdry zdrylbdx) {
		insert(sessionBean,zdrylbdx);
	}

	@Override
	protected void lgFail_(SessionBean sessionBean, Zdry zdrylbdx) {
		delete(sessionBean,zdrylbdx);
	}
	@Override
	protected void cg_(SessionBean sessionBean, Zdry zdrylbdx) {
		if(zdrylbdx != null){
			ZdryNrsxdxxxb zdryNrsxdxxxb = (ZdryNrsxdxxxb) zdrylbdx ;
			BaseService.setSaveProperties(zdryNrsxdxxxb, sessionBean);	
			zdryNrsxdxxxbDao.insert(zdryNrsxdxxxb);
		}
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
		ZdryNrsxdxxxb zdryNrsxdxxxb = (ZdryNrsxdxxxb) zdrylbdx;
		BaseService.setUpdateProperties(zdryNrsxdxxxb, sessionBean);
		zdryNrsxdxxxbDao.update(zdryNrsxdxxxb);
	}
	
	@Override
	protected void zd_(SessionBean sessionBean, Zdry zdrylbdx) {
		insert(sessionBean,zdrylbdx);
	}

	@Override
	protected void zdFail_(SessionBean sessionBean, Zdry zdrylbdx) {
		delete(sessionBean,zdrylbdx);
	}
	protected void insert(SessionBean sessionBean,Zdry zdrylbdx) {
		ZdryNrsxdxxxb zdryNrsxdxxxb = (ZdryNrsxdxxxb) zdrylbdx ;
		BaseService.setSaveProperties(zdryNrsxdxxxb, sessionBean);	
		zdryNrsxdxxxbDao.insert(zdryNrsxdxxxb);
	}

	protected void delete(SessionBean sessionBean, Zdry zdrylbdx) {
		ZdryNrsxdxxxb zdryNrsxdxxxb = (ZdryNrsxdxxxb) zdrylbdx;
		BaseService.setCrossoutProperties(zdryNrsxdxxxb, sessionBean);
		zdryNrsxdxxxbDao.delete(zdryNrsxdxxxb);
		
	}
}
