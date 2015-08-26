package com.founder.dbrw.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.founder.dbrw.bean.DbrwDbpzb;
import com.founder.dbrw.bean.DbrwDbrwb;
import com.founder.dbrw.bean.DbrwDdbrwb;
import com.founder.dbrw.bean.DbrwDdbrwsjmxb;
import com.founder.dbrw.service.DbrwDbpzbService;
import com.founder.dbrw.service.DbrwDdbrwbService;
import com.founder.dbrw.service.DbrwRwclService;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;

import com.google.gson.Gson;

@Controller
@RequestMapping(value = "dbrwDdbrwb")
public class DbrwDdbrwbController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "dbrwDdbrwbService")
	private DbrwDdbrwbService dbrwDdbrwbService;

	@Resource(name = "dbrwDbpzbService")
	private DbrwDbpzbService dbrwDbpzbService;

	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;

	@Resource(name = "dbrwRwclService")
	private DbrwRwclService dbrwRwclService;

	@RequestMapping(value = "/startAdd", method = RequestMethod.GET)
	public ModelAndView startAdd(DbrwDdbrwb entityCondiTions) {
		SessionBean sessionBean = getSessionBean();
		DbrwDdbrwb dbrwDdbrwb = dbrwDdbrwbService.queryDdbrwb(entityCondiTions
				.getId().toString());
		if (dbrwDdbrwb == null) {
			ModelAndView mv = new ModelAndView("bussiness");
			mv.addObject("message", getMessage("authority.fail"));
			return mv;
		}
		DbrwDbpzb dbrwDbpzb = dbrwDbpzbService.query(dbrwDdbrwb.getDbmxid());
		if (dbrwDbpzb == null) {
			ModelAndView mv = new ModelAndView("bussiness");
			mv.addObject("message", getMessage("authority.fail"));
			return mv;
		}
		ModelAndView mv = new ModelAndView("dbrw/dbrwStartAdd");
		String dbsjxbtm = dbrwDbpzb.getDbsjxbtm();
		String[] titleArray = null;
		if (!StringUtils.isBlank(dbsjxbtm)) {
			titleArray = dbsjxbtm.split("#");
		}
		DbrwDbrwb entity = new DbrwDbrwb();
		entity.setDbrwfqdwdm(sessionBean.getUserOrgCode());
		entity.setRwkssj(DateUtils.getSystemDateTimeString());
		mv.addObject("dbrwDbpzb", dbrwDbpzb);
		mv.addObject("dbrwDdbrwb", dbrwDdbrwb);
		mv.addObject("entity", entity);
		mv.addObject("entityCondiTions", entityCondiTions);
		if (!StringUtils.isBlank(entityCondiTions.getDdbsjx1())) {
			entityCondiTions.setYwfl("1");
		}
		mv.addObject("titleArray", dbrwRwclService.getFiledTitle(dbrwDdbrwb
				.getDbmxid()));
		mv.addObject("dbrwfqdw", sessionBean.getUserOrgName());
		mv.addObject("dbrwfqfxj", orgOrganizationService
				.queryOrgNameByOrgcodes(dbrwDdbrwb.getDbrwfqfxjdm()));
		mv.addObject("dbrwfqpcs", orgOrganizationService
				.queryOrgNameByOrgcodes(dbrwDdbrwb.getDbrwfqpcsdm()));
		return mv;
	}

	@RequestMapping(value = "/queryCondition", method = RequestMethod.GET)
	public ModelAndView queryCondition(String dbmxid) {
		ModelAndView mv = new ModelAndView("dbrw/dbrwMxQueryCondition");
		DbrwDbpzb dbrwDbpzb = dbrwDbpzbService.query(dbmxid);
		if (dbrwDbpzb != null) {
			String dbsjxbtm = dbrwDbpzb.getDbsjxbtm();
			if (!StringUtils.isBlank(dbsjxbtm)) {
				String[] fieldNameArray = dbsjxbtm.split("#");
				mv.addObject("fieldNameArray", fieldNameArray);
			}
		}
		SessionBean sessionBean = getSessionBean();
		mv.addObject("userOrgCode", sessionBean.getUserOrgCode());
		return mv;
	}

	@RequestMapping(value = "/querySjmxbList", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage querySjmxbList(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, DbrwDdbrwb entity) {
		page.setPagePara(rows);
		return dbrwDdbrwbService.querySjmxbList(page, entity);
	}

	@RequestMapping(value = "/deleteDdbrwSjmxb", method = RequestMethod.POST)
	public ModelAndView deleteDdbrwSjmxb(DbrwDdbrwsjmxb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			if (entity.getId() != null) { // 注销
				dbrwDdbrwbService.deleteDdbrwSjmxbById(entity);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, getDeleteSuccess());
			}
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getDeleteFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}

	@RequestMapping(value = "/deleteDdbrwSjmxbPatch", method = RequestMethod.POST)
	public ModelAndView deleteDdbrwSjmxbPatch(
			@RequestBody DbrwDdbrwsjmxb[] entityArray) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			dbrwDdbrwbService.deleteDdbrwSjmxbPatch(entityArray);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, getDeleteSuccess());
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getDeleteFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}

	@RequestMapping(value = "/insertDbrwb", method = RequestMethod.POST)
	public ModelAndView insertDbrwb(DbrwDbrwb entity, String ddbrwid,
			String ywfl, String ddbsjx1, String ddbsjx2, String ddbsjx3,
			String ddbsjx4, String ddbsjx5, String ddbsjx6, String ddbsjx7,
			String ddbsjx8, String ddbsjx9, String sszrqdm, String selectAllMx,
			String selectMxIds) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			Map<String, String> coultMap = new HashMap<String, String>();
			coultMap.put("ddbrwid", ddbrwid);
			coultMap.put("ywfl", ywfl);
			if ("1".equals(ywfl)) {
				coultMap.put("ddbsjx1", ddbsjx1);
			} else {
				coultMap.put("ddbsjx1", StringUtils.getSqlExpression(ddbsjx1));
			}
			coultMap.put("ddbsjx2", StringUtils.getSqlExpression(ddbsjx2));
			coultMap.put("ddbsjx3", StringUtils.getSqlExpression(ddbsjx3));
			coultMap.put("ddbsjx4", StringUtils.getSqlExpression(ddbsjx4));
			coultMap.put("ddbsjx5", StringUtils.getSqlExpression(ddbsjx5));
			coultMap.put("ddbsjx6", StringUtils.getSqlExpression(ddbsjx6));
			coultMap.put("ddbsjx7", StringUtils.getSqlExpression(ddbsjx7));
			coultMap.put("ddbsjx8", StringUtils.getSqlExpression(ddbsjx8));
			coultMap.put("ddbsjx9", StringUtils.getSqlExpression(ddbsjx9));
			coultMap.put("sszrqdm", sszrqdm);
			coultMap.put("selectAllMx", selectAllMx);
			selectMxIds = StringUtils.nullToStr(selectMxIds);
			if (!StringUtils.isBlank(selectMxIds)) {
				selectMxIds = "'" + selectMxIds.replaceAll(",", "','") + "'";
			}
			coultMap.put("selectMxIds", selectMxIds);
			dbrwDdbrwbService.insertDbrwb(entity, coultMap, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, getAddSuccess());
			model.put(AppConst.SAVE_ID, "" + entity.getId()); // 返回主键
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}

}
