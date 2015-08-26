package com.founder.syrkgl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.syrkgl.service.RyJwrybzxxhsbService;
import com.founder.syrkgl.webservice.jwry.loginservice.LoginService;
import com.founder.syrkgl.webservice.jwry.loginservice.LoginServiceSoap;
import com.founder.syrkgl.webservice.jwry.residence.ArrayOfReportResidenceInfo;
import com.founder.syrkgl.webservice.jwry.residence.ConditionForDownLoad;
import com.founder.syrkgl.webservice.jwry.residence.Inhabitancy;
import com.founder.syrkgl.webservice.jwry.residence.OperationReturn;
import com.founder.syrkgl.webservice.jwry.residence.ReportResidenceInfo;
import com.founder.syrkgl.webservice.jwry.residence.Residence;
import com.founder.syrkgl.webservice.jwry.residence.ResidenceInfo;
import com.founder.syrkgl.webservice.jwry.residence.ResidenceInfoReturn;
import com.founder.syrkgl.webservice.jwry.residence.ResidenceSoap;

import com.google.gson.Gson;

/**
 * @类名: RyJwrybzxxhsbController
 * @描述: 境外人员办证信息核实
 * @作者: zhang_guoliang@founder.com
 * @日期: 2015-6-17 上午11:35:13
 */
@Controller
@RequestMapping(value = "jwrybzxxhs")
public class RyJwrybzxxhsbController extends BaseController {
	@Resource(name = "ryJwrybzxxhsbService")
	private RyJwrybzxxhsbService ryJwrybzxxhsbService;
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;

	/**
	 * @Title: queryJwryHsxf
	 * @描述: 境外人员核实下发列表
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-6-15 下午5:23:36
	 * @返回值: EasyUIPage 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryJwryHsxf", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryJwryHsxf(EasyUIPage page,
			@RequestParam(value = "rows", required = false) Integer rows,
			ResidenceInfo entity, SessionBean sessionBean) {
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		if (null != sessionBean) {
			OrgOrganization userOrg = orgOrganizationService
					.queryById(sessionBean.getUserOrgId());
			String orglevel = userOrg.getOrglevel();
			if (("21").equals(orglevel)) {
				//entity.setFxjdm((String) sessionBean.getUserOrgCode());
			} else if ("32".equals(orglevel)) {
				//entity.setPcsdm((String) sessionBean.getUserOrgCode());
			} else if ("50".equals(orglevel)) {
				//entity.setZrqdm((String) sessionBean.getUserOrgCode());
			}
		}
		return ryJwrybzxxhsbService.queryJwryHsxf(page, entity);
	}

	/**
	 * @Title: reporteInhabitancyInfo
	 * @描述: 常住境外人员居住地信息核实反馈
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-6-18 下午4:21:32
	 * @返回值: ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/reporteInhabitancyInfo", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView reporteInhabitancyInfo(Inhabitancy entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView("redirect:/forward/" + AppConst.FORWORD);
		sessionBean = getSessionBean(sessionBean);
		// 返回提示
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			ryJwrybzxxhsbService.reporteInhabitancyInfo(entity, sessionBean);
			//常住境外人员居住地信息核实反馈（外部系统对出入境系统提供数据）【登录用户】
			LoginService ls = new LoginService();
			LoginServiceSoap lss = ls.getLoginServiceSoap();
			lss.logout();
			lss.login("201411210000000000", "1111");
			Residence rs = new Residence();
			ResidenceSoap rss = rs.getResidenceSoap();
			OperationReturn ret = rss.reporteInhabitancyInfo(entity);
			if("0000".equals(ret.getReturnCode())){
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "核实接口处理成功！");
			}else{
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "核实接口处理失败！");
			}
		} catch (Exception e) {
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, "核实接口处理失败！");
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}

	/**
	 * @Title: downLoadInfo
	 * @描述: 常住境外人员信息下载 （出入境系统对外提供数据）【服务接口】
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @返回值: void 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/downLoadInfo", method = RequestMethod.GET)
	public void downLoadInfo() {
		// 登录用户
		LoginService ls = new LoginService();
		LoginServiceSoap lss = ls.getLoginServiceSoap();
		// 退出登录
		lss.logout();
		lss.login("201411210000000000", "1111");
		// 常住境外人员信息下载
		Residence rs = new Residence();
		ResidenceSoap rss = rs.getResidenceSoap();
		ConditionForDownLoad co = new ConditionForDownLoad();
		co.setStartDate("20140101");
		co.setEndDate("20150729");
		ResidenceInfoReturn infoRe = rss.downLoadInfo(co);
		ArrayOfReportResidenceInfo li = infoRe.getInfo();
		List<ReportResidenceInfo> lizz = li.getReportResidenceInfo();
		for (int i = 0; i < lizz.size(); i++) {
			ReportResidenceInfo info = lizz.get(i);
			ryJwrybzxxhsbService.saveReportResidenceInfo(info);
		}
		// 退出登录
		lss.logout();
	}
	/**
	 * @Title: openJzdSh 
	 * @描述: 打开居住地核实页面
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @返回值: ModelAndView    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/openJzdSh", method = RequestMethod.GET)
	public ModelAndView openJzdSh(String personNO,String inhabiBusinessNO) {
		ModelAndView mv = new ModelAndView("syrkgl/ryJwryjzdxxhsfk");
		//查询常住境外人员信息
		ResidenceInfo jbxx = ryJwrybzxxhsbService.queryResidenceInfo(personNO,inhabiBusinessNO);
		//查询境外常驻人员居住地信息表
		Inhabitancy jzdxx = ryJwrybzxxhsbService.queryInhabitancy(personNO,inhabiBusinessNO);
		mv.addObject("jbxx", jbxx);
		mv.addObject("jzdxx", jzdxx);
		return mv;
	}
}