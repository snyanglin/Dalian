package com.founder.zdrygl.base.service;

import javax.annotation.Resource;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.zdrygl.base.dao.ZdryShbzdryxxbDao;
import com.founder.zdrygl.base.model.ZdryShbzdryxxb;
import com.founder.zdrygl.core.decorator.ZdryServiceDecorator;
import com.founder.zdrygl.core.inteface.ZdryService;
import com.founder.zdrygl.core.model.Zdry;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.service.ZdryShbService.java]  
 * @ClassName:    [ZdryShbService]   
 * @Description:  [涉环保重点人员业务服务]   
 * @Author:       [cong_rihong@founder.com.cn] 
 * @CreateDate:   [2015年9月21日 下午7:16:11]   
 * @UpdateUser:   [cong_rihong@founder.com.cn(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年9月28日 下午14:16:11，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
public class ZdryShbService  extends ZdryServiceDecorator{

	private ZdryShbzdryxxb zdry;
	
	@Resource(name="zdryShbzdryxxbDao")
	private ZdryShbzdryxxbDao  zdryShbzdryxxbDao;

	public ZdryShbService(ZdryService zdryService) {
		super(zdryService);
	}
	
	

	@Override
	public void setZdry(Zdry entity) {
		this.zdry = (ZdryShbzdryxxb) entity;
	}

	/**
	 * 列管重点人口
	 */
	@Override
	protected void lg_(SessionBean sessionBean) {
		BaseService.setSaveProperties(zdry, sessionBean);	
		zdry.setId(this.getZdryId());
		zdryShbzdryxxbDao.insert(zdry);
	}

	@Override
	protected void cg_(SessionBean sessionBean) {
		if(zdry != null){
			BaseService.setSaveProperties(zdry, sessionBean);
			zdry.setId(this.getZdryId());
			zdryShbzdryxxbDao.insert(zdry);
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
		zdryShbzdryxxbDao.update(zdry);
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
		return zdryShbzdryxxbDao.queryById(zdryid);
	}

}
