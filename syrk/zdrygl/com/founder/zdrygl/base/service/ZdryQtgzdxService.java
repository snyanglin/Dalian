package com.founder.zdrygl.base.service;

import com.founder.framework.base.entity.SessionBean;
import com.founder.zdrygl.core.decorator.ZdryServiceDecorator;
import com.founder.zdrygl.core.inteface.ZdryService;
import com.founder.zdrygl.core.model.Zdry;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.service.ZdrySqsbService.java]  
 * @ClassName:    [ZdrySqsbService]   
 * @Description:  [其他关注对象， 没有表，不需要实现具体功能]   
 * @Author:       [cong_rihong@founder.com.cn] 
 * @CreateDate:   [2015年9月21日 下午7:16:11]   
 * @UpdateUser:   [cong_rihong@founder.com.cn(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年9月28日 下午14:16:11，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
public class ZdryQtgzdxService  extends ZdryServiceDecorator{
	

	public ZdryQtgzdxService(ZdryService zdryService) {
		super(zdryService);
	}

	/**
	 * 列管重点人口
	 */
	@Override
	protected void lg_(SessionBean sessionBean,Zdry zdrylbdx) {
	}
	
	@Override
	protected void lgFail_(SessionBean sessionBean, Zdry zdrylbdx) {
	}
	
	@Override
	protected void cg_(SessionBean sessionBean, Zdry zdrylbdx) {
		
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
	}
	
	@Override
	protected void zd_(SessionBean sessionBean, Zdry zdrylbdx) {
	}

	@Override
	protected void zdFail_(SessionBean sessionBean, Zdry zdrylbdx) {
	}
}
