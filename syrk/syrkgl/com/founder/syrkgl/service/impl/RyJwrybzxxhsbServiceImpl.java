package com.founder.syrkgl.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.syrkgl.dao.RyJwrybzxxhsbDao;
import com.founder.syrkgl.service.RyJwrybzxxhsbService;
import com.founder.syrkgl.webservice.jwry.residence.Inhabitancy;
import com.founder.syrkgl.webservice.jwry.residence.ReportResidenceInfo;
import com.founder.syrkgl.webservice.jwry.residence.ResidenceInfo;
import com.founder.syrkgl.webservice.jwry.residence.Workplace;

/**
 * @类名: RyJwrybzxxhsbServiceImpl
 * @描述: 境外人员办证信息核实
 * @作者: zhang_guoliang@founder.com
 * @日期: 2015-6-17 下午2:18:34
 */
@Transactional
@Service("ryJwrybzxxhsbService")
public class RyJwrybzxxhsbServiceImpl extends BaseService implements
		RyJwrybzxxhsbService {
	@Resource(name = "ryJwrybzxxhsbDao")
	private RyJwrybzxxhsbDao ryJwrybzxxhsbDao;

	/**
	 * @Title: queryJwryHsxf
	 * @描述: 境外人员核实下发列表
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-6-15 下午5:37:54
	 * @throws
	 */
	public EasyUIPage queryJwryHsxf(EasyUIPage page, ResidenceInfo entity) {
		return ryJwrybzxxhsbDao.queryJwryHsxf(page, entity);
	}

	/**
	 * @Title: reporteInhabitancyInfo 
	 * @描述: 常住境外人员居住地信息核实反馈
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public void reporteInhabitancyInfo(Inhabitancy entity, SessionBean sessionBean) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		entity.setRegTime(formatter.format(new Date()));
		entity.setRegperson(sessionBean.getUserOrgCode());
		ryJwrybzxxhsbDao.reporteInhabitancyInfo(entity);
	}

	/**
	 * @Title: saveReportResidenceInfo
	 * @描述: 保存下载常住境外人员信息
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-8-03 下午4:55:43
	 * @返回值: void 返回类型
	 * @throws
	 */
	public void saveReportResidenceInfo(ReportResidenceInfo info) {
		//境外常驻人员基本信息
		ResidenceInfo res = info.getResidenceInfo();
		//境外常驻人员居住地信息
		Inhabitancy ins = info.getInhabitancy();
		//境外常驻人员工作地信息
		Workplace wos = info.getWorkplace();
		if (res != null && res.getPersonNO()!=null) {
			if(!"".equals(ins.getInhabiBusinessNO())&&ins.getInhabiBusinessNO()!=null){
				res.setInhabiBusinessNO(ins.getInhabiBusinessNO());
			}
			if(!"".equals(wos.getWorkplaceBusinessNO())&&wos.getWorkplaceBusinessNO()!=null){
				res.setInhabiBusinessNO(wos.getWorkplaceBusinessNO());
			}
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			res.setSjddrq(formatter.format(new Date()));
			res.setSjzt("0");
			ryJwrybzxxhsbDao.saveResidenceInfo(res);
		}
		if (ins != null && ins.getPersonNO()!=null) {
			ryJwrybzxxhsbDao.saveInhabitancy(ins);
		}
		if (wos != null && wos.getPersonNO()!=null) {
			ryJwrybzxxhsbDao.saveWorkplace(wos);
		}
	}
	/**
	 * @Title: queryResidenceInfo 
	 * @Description: 查询常住境外人员信息
	 * @author zhang_guoliang@founder.com 
	 * @param 传入参数定义 
	 * @throws
	 */
	public ResidenceInfo queryResidenceInfo(String personNO,String inhabiBusinessNO) {
		return ryJwrybzxxhsbDao.queryResidenceInfo(personNO, inhabiBusinessNO);
	}
	/**
	 * @Title: queryInhabitancy 
	 * @Description: 查询境外常驻人员居住地信息表
	 * @author zhang_guoliang@founder.com 
	 * @param 传入参数定义 
	 * @throws
	 */
	public Inhabitancy queryInhabitancy(String personNO, String inhabiBusinessNO) {
		return ryJwrybzxxhsbDao.queryInhabitancy(personNO, inhabiBusinessNO);
	}
}