package com.founder.zdrygl.base.service;

import javax.annotation.Resource;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.zdrygl.base.dao.ZdryJgdxxxbDao;
import com.founder.zdrygl.base.model.ZdryJgdxxxb;
import com.founder.zdrygl.core.decorator.ZdryServiceDecorator;
import com.founder.zdrygl.core.inteface.ZdryService;
import com.founder.zdrygl.core.model.Zdry;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.service.ZdryZdrkService.java]  
 * @ClassName:    [ZdryZdrkService]   
 * @Description:  [重点人口业务服务]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015年9月21日 下午7:16:11]   
 * @UpdateUser:   [cong_rihong@founder.com.cn(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年9月28日 下午14:16:11，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容, (如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
public class ZdryJgdxService  extends ZdryServiceDecorator{

	private ZdryJgdxxxb zdry;
	
	@Resource(name="zdryJgdxxxbDao")
	private ZdryJgdxxxbDao zdryJgdxxxbDao;

	public ZdryJgdxService(ZdryService zdryService) {
		super(zdryService);
	}

	@Override
	public void setZdry(Zdry entity) {
		this.zdry = (ZdryJgdxxxb) entity;
	}

	/**
	 * 列管重点人口
	 */
	@Override
	protected void lg_(SessionBean sessionBean ,Zdry zdrylbdx) {
		insert(sessionBean,zdrylbdx);
	}
	
	@Override
	protected void lgFail_(SessionBean sessionBean, Zdry zdrylbdx) {
		delete(sessionBean,zdrylbdx);
		
	}
	@Override
	protected void cg_(SessionBean sessionBean, Zdry zdrylbdx) {
		if(zdrylbdx != null){
			ZdryJgdxxxb zdryJgdxxxb = (ZdryJgdxxxb) zdrylbdx;
			BaseService.setSaveProperties(zdryJgdxxxb, sessionBean);
			zdryJgdxxxbDao.insert(zdryJgdxxxb);
		}
	}
	
	/**
	 * 
	 * @Title: update_
	 * @Description: TODO(子表（重点人口）修改)
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throw
	 */
	@Override
	protected void update_(SessionBean sessionBean) {
		BaseService.setUpdateProperties(zdry, sessionBean);
		zdry.setId(this.getZdryId());
		zdryJgdxxxbDao.update(zdry);
	}
	
	/**
	 * 
	 * @Title: queryZdryInfo_
	 * @Description: TODO(查询重点人员子表)
	 * @param @param zdryid
	 * @return Zdry    返回类型
	 * @throw
	 */
//	@Override
	public Zdry queryZdryInfo_(String zdryid) {
		return zdryJgdxxxbDao.queryById(zdryid);
	}

	@Override
	protected void zd_(SessionBean sessionBean, Zdry zdrylbdx) {
		insert(sessionBean,zdrylbdx);
	}

	@Override
	protected void zdFail_(SessionBean sessionBean, Zdry zdrylbdx) {
		delete(sessionBean,zdrylbdx);
	}
	protected void insert(SessionBean sessionBean ,Zdry zdrylbdx) {
		ZdryJgdxxxb zdryJgdxxxb = (ZdryJgdxxxb) zdrylbdx;
		BaseService.setSaveProperties(zdryJgdxxxb, sessionBean);	
		zdryJgdxxxbDao.insert(zdryJgdxxxb);
	}
	
	protected void delete(SessionBean sessionBean, Zdry zdrylbdx) {
		ZdryJgdxxxb zdryJgdxxxb = (ZdryJgdxxxb) zdrylbdx;
		BaseService.setCrossoutProperties(zdryJgdxxxb, sessionBean);
		zdryJgdxxxbDao.delete(zdryJgdxxxb);
		
	}
}
