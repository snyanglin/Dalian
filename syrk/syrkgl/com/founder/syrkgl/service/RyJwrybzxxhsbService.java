package com.founder.syrkgl.service;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.syrkgl.webservice.jwry.residence.Inhabitancy;
import com.founder.syrkgl.webservice.jwry.residence.ReportResidenceInfo;
import com.founder.syrkgl.webservice.jwry.residence.ResidenceInfo;

/**
 * @类名: RyJwrybzxxhsbService
 * @描述: 境外人员办证信息核实
 * @作者: zhang_guoliang@founder.com
 * @日期: 2015-6-17 上午11:40:05
 */
@TypeAnnotation("境外人员办证信息核实")
public interface RyJwrybzxxhsbService {
	/**
	 * @Title: queryJwryHsxf
	 * @描述: 境外人员核实下发列表
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-6-15 下午5:30:09
	 * @返回值: EasyUIPage 返回类型
	 * @throws
	 */
	public EasyUIPage queryJwryHsxf(EasyUIPage page, ResidenceInfo entity);

	/**
	 * @Title: reporteInhabitancyInfo 
	 * @描述: 常住境外人员居住地信息核实反馈
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public void reporteInhabitancyInfo(Inhabitancy entity, SessionBean sessionBean);

	/**
	 * @Title: saveReportResidenceInfo
	 * @描述: 保存下载常住境外人员信息
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @返回值: void 返回类型
	 * @throws
	 */
	public void saveReportResidenceInfo(ReportResidenceInfo info);
	/**
	 * @Title: queryResidenceInfo 
	 * @描述: 查询常住境外人员信息
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @返回值: ResidenceInfo    返回类型 
	 * @throws
	 */
	public ResidenceInfo queryResidenceInfo(String personNO,String inhabiBusinessNO);
	/**
	 * @Title: queryInhabitancy 
	 * @描述: 查询境外常驻人员居住地信息表
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @返回值: ResidenceInfo    返回类型 
	 * @throws
	 */
	public Inhabitancy queryInhabitancy(String personNO,String inhabiBusinessNO);
}