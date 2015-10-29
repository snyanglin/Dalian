package com.founder.zdrygl.base.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.founder.drools.base.zdry.service.ZdryRuleService;
import com.founder.framework.annotation.RestfulAnnotation;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.organization.position.service.OrgPositionService;
import com.founder.framework.organization.user.service.OrgUserService;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.service.attachment.service.ZpfjFjxxbService;
import com.founder.workflow.bean.StartProcessInstance;
import com.founder.workflow.service.inteface.JProcessDefinitionService;
import com.founder.zdrygl.base.model.ZdryZb;
import com.founder.zdrygl.base.model.Zdrycg;
import com.founder.zdrygl.base.model.Zdrylxylbdyb;
import com.founder.zdrygl.base.service.ZdryInfoQueryService;
import com.founder.zdrygl.base.vo.ZdryVO;
import com.founder.zdrygl.core.factory.ZdryAbstractFactory;
import com.founder.zdrygl.core.inteface.ZdryService;
import com.founder.zdrygl.core.inteface.ZdrylxylbdybService;
import com.founder.zdrygl.core.model.Zdry;
import com.founder.zdrygl.core.utils.ZdryConstant;
import com.google.gson.Gson;

/**
 * ****************************************************************************
 * 
 * @Package: [com.founder.zdrygl.base.controller.ZdryZdryzbControl.java]
 * @ClassName: [ZdryZdryzbControl]
 * @Description: [重点人员总表控制器]
 * @Author: [wei.wen@founder.com.cn]
 * @CreateDate: [2015年9月18日 下午3:20:01]
 * @UpdateUser: [wei.wen@founder.com.cn(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015年9月18日 下午3:20:01，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@Controller
@RequestMapping("/zdryzb")
public class ZdryZdryzbControl extends BaseController {
	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	public ZdryAbstractFactory zdryFactory;

	@Resource(name = "zdryQueryService")
	private ZdryInfoQueryService zdryQueryService;

	@Autowired
	private ZdryConstant zdryConstant;

	@Autowired
	private JProcessDefinitionService processDefinitionService;

	@Resource(name = "orgUserService")
	private OrgUserService orgUserService;

	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;

	@Resource(name = "orgPositionService")
	private OrgPositionService orgPositionService;

	@Resource(name = "zdrylxylbdybService")
	private ZdrylxylbdybService zdrylxylbdybService;

	@Resource(name = "zpfjFjxxbService")
	private ZpfjFjxxbService zpfjFjxxbService;
	
	@Autowired
	private ZdryRuleService zdryRuleService;

	/**
	 * 
	 * @Title: manage
	 * @Description: TODO(打开重点人员管理列表)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/manager", method = RequestMethod.GET)
	public String manage() {
		zdryConstant.createTreeJS();
		return "zdrygl/zdryManage";
	}

	/**
	 * 
	 * @Title: getManageList
	 * @Description: TODO(重点人员管理列表 查询)
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return EasyUIPage 返回类型
	 * @throws
	 */
	@RestfulAnnotation(serverId = "3")
	@RequestMapping(value = "/getManageList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage getManageList(EasyUIPage page,
			@RequestParam(value = "rows", required = false) Integer rows,
			ZdryZb entity, SessionBean sessionBean) {
		page.setPagePara(rows);
		entity.setGlbm(getSessionBean(sessionBean).getUserOrgCode());
		return zdryQueryService.queryList(page, entity);
	}

	/**
	 * 
	 * @Title: queryZdryOnPT
	 * @Description: TODO(重点人员查询 列表)
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @return 设定文件
	 * @return EasyUIPage 返回类型
	 * @throw
	 */
	@RequestMapping(value = "/getQeryList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage getQeryList(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, ZdryZb entity,
			SessionBean sessionBean) {
		page.setPagePara(rows);
		if (entity.getGlbm() == null)
			entity.setGlbm(getSessionBean(sessionBean).getUserOrgCode());
		return zdryQueryService.getQueryList(page, entity);
	}

	/**
	 * 
	 * @Title: queryZdryChildLbList
	 * @Description: 查询当前区域下的子类别列表
	 * @param @param lbdm_p 上级类型
	 * @param @return 设定文件
	 * @return List 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryZdryChildLbList", method = RequestMethod.GET)
	public @ResponseBody List queryZdryChildLbList(String lbdm_p) {
		List list = zdryQueryService.getChildList(lbdm_p);
		return list;
	}

	/**
	 * 
	 * @Title: zdryAddPre
	 * @Description: TODO(打开重点人员新增页面)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/zdryAddPre", method = RequestMethod.GET)
	public ModelAndView zdryAddPre(SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView("zdrygl/add/zdryAddPre");
		sessionBean = getSessionBean(sessionBean);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		mv.addObject("applyUser", sessionBean.getUserName());
		mv.addObject("applyDate", formatter.format(new Date()));
		return mv;
	}

	/**
	 * 
	 * @Title: saveLg
	 * @Description: TODO(保存列管)
	 * @param @param zdryVO
	 * @param @param uploadFile
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throw
	 */
	@RequestMapping(value = "/saveLg", method = RequestMethod.POST)
	public ModelAndView saveLg(ZdryVO zdryVO, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			String zdrygllxdm = zdryVO.getZdryZdryzb().getZdrygllxdm();// 重点人员类型
			ZdryService zdryService = zdryFactory.createZdryService(zdrygllxdm,
					zdryVO.getZdryZdryzb(), zdryVO.getZdrylbdx());
			// start process
			StartProcessInstance spi = initialProcessInstance(sessionBean,
					zdryVO);
			zdryService.setStartProcessInstance(spi.getProcessKey(), spi.getApplyUserId(),
					spi.getVariables());
			zdryService.lg(sessionBean);

			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, getAddSuccess());
		} catch (BussinessException e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, e.getLocalizedMessage());
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}

		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;

	}

	/**
	 * 
	 * @Title: startLgProcess
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param sessionBean
	 * @param @param zdryVO 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	private StartProcessInstance initialProcessInstance(
			SessionBean sessionBean, ZdryVO zdryVO) {
		// StartProcessInstance initializes
		StartProcessInstance spi = new StartProcessInstance();
		spi.setApplyUserId(sessionBean.getUserId());

		Map<String, Object> variables = new HashMap<String, Object>();
		String lrrzrq = sessionBean.getUserOrgCode();
		String zdryxm = zdryVO.getZdryZdryzb().getXm();
		Zdrylxylbdyb zdrylxylbdyb = new Zdrylxylbdyb();
		ZdryZb zdryZdryzb = zdryVO.getZdryZdryzb();
		zdrylxylbdyb.setLbdm(zdryZdryzb.getZdrygllxdm());
		String zdrylxmc = zdrylxylbdybService.query(zdrylxylbdyb).getBz();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		

		variables.put("zdrylx", zdryZdryzb.getZdrygllxdm());// 人员类型
		variables.put("zdryzb", zdryVO.getZdryZdryzb());
		variables.put("zdrylbdx", zdryVO.getZdrylbdx());
		
		String createTime = formatter.format(new Date());// 申请时间
		variables.put("createTime", createTime);
		variables.put("lrrzrq", lrrzrq);// 录入人管辖责任区
		variables.put("zdryId", zdryZdryzb.getId()); // 重点人员总表Id
		variables.put("zdrylxmc", zdrylxmc);// 人员类型名称
		variables.put("xm", zdryxm);// 被列管人员姓名
		variables.put("cyzjdm", zdryVO.getZdryZdryzb().getCyzjdm());
		variables.put("zjhm", zdryVO.getZdryZdryzb().getZjhm());// 证件号码
		// variables.put("splx", "重点人口列管");//审批类型
		variables.put("sqyj", zdryVO.getYwsqyy());// 申请意见
		variables.put("sqrName", sessionBean.getUserName());// 申请意见
		variables.put("zdryName", zdryxm);// 申请意见
		variables.put("applyUserId", sessionBean.getUserId());
		if (zdryZdryzb.getZdrygllxdm().equals("07")) {// 环保
			variables.put("sqlx", "涉环保");
			variables.put("sqlxdm", "01");// 列管01 撤管02
			variables.put("splevel", "1");// 设置审批级别，一级审批
			variables.put("sqrOrgCode", sessionBean.getUserOrgCode());// 设置申请人组织机构代码
			variables.put("sqrOrgLevel", sessionBean.getUserOrgLevel());// 设置申请人组织机构级别
			variables.put("approvalMethod", "shbApproval");
			variables.put("zdryId", zdryZdryzb.getId());
			variables.put("sqyj", "申请将" + zdryVO.getZdryShbzdryxxb().getXm()
					+ "列管为涉环保重点人员");
			variables.put("xm", zdryVO.getZdryShbzdryxxb().getXm());// 被列管人员姓名
			variables.put("zjhm", zdryVO.getZdryShbzdryxxb().getZjhm());// 证件号码

			// set parameters of processinstance
			spi.setProcessKey("shb_lcg");
			spi.setBusinessKey(zdryZdryzb.getId());
			spi.setVariables(variables);
		} else if (zdryZdryzb.getZdrygllxdm().equals("06")) {// 其他关注对象 改为也要 所长
																// 审批
			variables.put("sqlx", "治安列管");// 申请类型
			variables.put("sqlxdm", "01");// 申请类型为列管

			OrgOrganization orgOrganization = orgOrganizationService
					.queryUpOrgByLevel(lrrzrq, "32");
			String fsxOrgCode = orgOrganization.getOrgcode();// 得到本名等级为三级，派出所部门code
			String taskParameter = fsxOrgCode + "_"
					+ orgPositionService.queryByPosid("SZ").getId().toString(); // 部门code+所长岗位ID
			variables.put("sz", taskParameter);
			variables.put("approvalMethod", "szApproval");

			// set parameters of processinstance
			spi.setProcessKey("szsp");
			spi.setBusinessKey(zdryZdryzb.getId());
			spi.setVariables(variables);
		} else if (zdryZdryzb.getZdrygllxdm().equals("05")) {// 涉公安访
			variables.put("sqlx", "涉公安访列管");
			variables.put("sqlxdm", "01");// 列管01 撤管02

			OrgOrganization orgOrganization = orgOrganizationService
					.queryUpOrgByLevel(lrrzrq, "32");
			String fsxOrgCode = orgOrganization.getOrgcode();// 得到本名等级为三级，派出所部门code
			String taskParameter = fsxOrgCode + "_"
					+ orgPositionService.queryByPosid("SZ").getId().toString(); // 部门code+所长岗位ID
			variables.put("approvalMethod", "sgafApproval");
			variables.put("szsp", taskParameter);

			// set parameters of processinstance
			spi.setProcessKey("sgaj_lcg");
			spi.setBusinessKey(zdryZdryzb.getId());
			spi.setVariables(variables);
		} else // 治安

		if (zdryZdryzb.getZdrygllxdm().equals("01")) {
			ZdryZb zdryZb = (ZdryZb) zdryQueryService.queryById(zdryZdryzb
					.getId());
			if ("0104".equals(zdryZb.getZdrylb())) {

				variables.put("sqlx", "治安列管");// 申请类型
				variables.put("sqlxdm", "01");// 申请类型为列管
				/*
				 * processDefinitionService.startProcessInstance(
				 * sessionBean.getUserId(), "zalcg", zdryZdryzb.getId(),
				 * variables);
				 */
				// set parameters of processinstance
				spi.setProcessKey("zalcg");
				spi.setBusinessKey(zdryZdryzb.getId());
				spi.setVariables(variables);
			} else {
				// TODO:
				/*
				 * zdryUntil.lgSuccess(zdryZdryzb.getId(), zdryxm,
				 * sessionBean.getUserId(), sessionBean.getUserName(),
				 * sessionBean.getUserOrgCode(), null);
				 */
			}

		} else {
			variables.put("sqlx", "治安列管");// 申请类型
			variables.put("sqlxdm", "01");// 申请类型为列管

			// set parameters of processinstance
			spi.setProcessKey("zalcg");
			spi.setBusinessKey(zdryZdryzb.getId());
			spi.setVariables(variables);
		}
		return spi;
	}

	/**
	 * 
	 * @Title: view
	 * @Description: TODO(打开重点人员编辑查看页面)
	 * @param @param mode 编辑模式
	 * @param @param mainTabID
	 * @param @param id 重点人员ID
	 * @param @return
	 * @param @throws BussinessException 设定文件
	 * @return ModelAndView 返回类型
	 * @throw
	 */
	@RequestMapping(value = "/{ryid}/{id}/view", method = RequestMethod.GET)
	public @ResponseBody ModelAndView view(
			@PathVariable(value = "ryid") String ryid,
			@RequestParam(value = "mode", defaultValue = "edit") String mode,
			String mainTabID, @PathVariable(value = "id") String id)
			throws BussinessException {
		ModelAndView mv = new ModelAndView("zdrygl/edit/zdryEdit");

		ZdryZb zdryZb = new ZdryZb();
		// ryid可能为空
		if (ryid != null && ryid.length() > 0) {
			zdryZb.setRyid(ryid);
		} else {
			zdryZb.setId(id);
		}
		List zdryList = zdryQueryService.queryListByEntity(zdryZb);
		if (zdryList.isEmpty())
			throw new BussinessException("Zdry not Exist");

		ZdryZb temp = null;
		List<Map<String, String>> zdrylxList = new ArrayList<Map<String, String>>();
		String zdrygllxmc;
		StringBuffer zdrylxBuffer = new StringBuffer();// 已列管类型名字

		for (int i = 0; i < zdryList.size(); i++) {
			temp = (ZdryZb) zdryList.get(i);

			// 只取当前重点人员id的重点人员类型
			if (temp.getId().equals(id)) {
				mv.addObject("zdry", temp);
				Map<String, String> map = new HashMap<String, String>();
				map.put("zdryid", temp.getId());
				map.put("zdrylx", temp.getZdrygllxdm());
				zdrylxList.add(map);
			}

			// 已列管 重点人员 类型
			zdrygllxmc = zdryConstant.zdryDict().get(temp.getZdrygllxdm());
			if (zdrygllxmc != null && zdrygllxmc.length() > 0
					&& !"4".equals(temp.getGlzt())) {
				if (zdrylxBuffer.length() > 0)
					zdrylxBuffer.append(" ");
				zdrylxBuffer.append(zdrygllxmc);
			}

		}

		String zdrylxStr = zdrylxBuffer.toString();
		if (zdrylxStr.length() > 17) {
			mv.addObject("zdrylxMore", zdrylxBuffer.toString());// 全部的已列管类型
			zdrylxStr = zdrylxStr.subSequence(0, 17) + "……";
		}
		mv.addObject("zdrylx", zdrylxStr);// 简化的已列管类型
		mv.addObject("zdrylxList", zdrylxList);
		mv.addObject("zdrylxJson", new Gson().toJson(zdrylxList));
		mv.addObject("mainTabID", mainTabID);
		mv.addObject("mode", mode);

		return mv;
	}

	/**
	 * 
	 * @Title: queryYlglx
	 * @Description: TODO(根据人员ID查询已列管的类型)
	 * @param @param ryid
	 * @param @param syrkid
	 * @param @return
	 * @param @throws BussinessException 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryYlglx", method = RequestMethod.POST)
	public @ResponseBody String queryYlglx(String ryid, String syrkid) {
		if (ryid == null || syrkid == null)
			return "";

		List zdryList = zdryQueryService.queryListByRyid(ryid);

		if (zdryList.isEmpty())
			return "";

		ZdryZb temp = null;
		StringBuffer resStrBuffer = new StringBuffer("");
		StringBuffer klgStrBuffer = new StringBuffer("");
		for (int i = 0; i < zdryList.size(); i++) {
			temp = (ZdryZb) zdryList.get(i);

			if (syrkid.equals(temp.getSyrkid())) {
				if (resStrBuffer.length() > 0) {
					resStrBuffer.append("，");// 中文符号，显示页面用
					klgStrBuffer.append(",");// 英文符号，后续查询用
				}
				resStrBuffer.append(zdryConstant.zdryDict().get(
						temp.getZdrygllxdm()));
				klgStrBuffer.append(temp.getZdrygllxdm());
			}
		}

		return resStrBuffer.append("/").append(klgStrBuffer).toString();
	}

	/**
	 * 
	 * @Title: queryklglx
	 * @Description: TODO(查询可同时列管的类型)
	 * @param @param ylglxStr
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throw
	 */
	@RequestMapping(value = "/queryklglx", method = RequestMethod.POST)
	public @ResponseBody String queryklglx(String ylglxStr) {
		String klgStr = zdryRuleService.getKlglx(ylglxStr);
		if ("".equals(klgStr)) {// 没有可列管的类型，不能返回“”，此时应该没有匹配的选项
			klgStr = "999999";
		}
		return klgStr;
	}

	/**
	 * 
	 * @Title: zdryDelPre
	 * @Description: TODO(打开重点人员撤管页面)
	 * @param @param id 重点人员ID
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throw
	 */
	@RequestMapping(value = "/zdryDelPre", method = RequestMethod.GET)
	public ModelAndView zdryDelPre(String id) {
		ModelAndView mv = new ModelAndView("zdrygl/add/zdryDelPre");
		SessionBean sessionBean = getSessionBean();
		Zdry zdry = zdryQueryService.queryById(id);
		if (zdry == null)
			throw new BussinessException("zdry.notExist");
		String zdrygllxdm = ((ZdryZb) zdry).getZdrygllxdm();
		String zdrygllxmc = zdryConstant.zdryDict().get(zdrygllxdm);
		// 可撤管类型
		String kcgStr = zdryRuleService.getKcglx(zdrygllxdm);
		if (kcgStr == null || kcgStr.length() == 0)
			kcgStr = "999999";

		mv.addObject("userName", sessionBean.getUserName());
		mv.addObject("blrq", DateUtils.getSystemDateString());
		mv.addObject("zdry", zdry);
		mv.addObject("zdrylxmc", zdrygllxmc);
		mv.addObject("kcgStr", kcgStr);
		return mv;
	}

	/**
	 * 
	 * @Title: saveCg
	 * @Description: TODO(撤管保存)
	 * @param @param zdryVO
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throw
	 */
	@RequestMapping(value = "/saveCg", method = RequestMethod.POST)
	public ModelAndView saveCg(ZdryVO zdryVO, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);

		try {
			ZdryZb zb_new = zdryVO.getZdryZdryzb();

			// 查询撤管前的重点人员信息
			ZdryZb zb_old = (ZdryZb) zdryQueryService.queryById(zb_new.getId());
			if (zb_old == null) {
				throw new BussinessException("未查询到该重点人员的信息");
			}
			// 验证状态是否正确
			if (!ZdryConstant.YLG.equals(zb_old.getGlzt())) {
				throw new BussinessException("该重点人员正在【"
						+ zdryConstant.getGlztStr(zb_old.getGlzt())
						+ "】，不能办理其他业务");
			}

			Zdrycg zdrycg = new Zdrycg();
			BeanUtils.copyProperties(zb_old, zdrycg);

			zdrycg.setZdryid_old(zb_old.getId());
			zdrycg.setZdrygllxdm_old(zb_old.getZdrygllxdm());
			zdrycg.setZdrygllxdm(zb_new.getZdrygllxdm());
			zdrycg.setZdrylb(zb_new.getZdrylb());
			// 撤管重点人员
			ZdryService zdryService = zdryFactory.createZdryService(
					zb_new.getZdrygllxdm(), zdrycg, zdryVO.getZdrylbdx());
			zdryService.cg(sessionBean);

			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, getAddSuccess());

		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, e.getLocalizedMessage());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}

	/**
	 * 
	 * @Title: queryZdryTopLbList
	 * @Description: 查询当前区域下的一级类别列表
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return List 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryZdryTopLbList", method = RequestMethod.GET)
	public @ResponseBody List queryZdryTopLbList(SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		List list = zdrylxylbdybService.getTopList();
		Zdrylxylbdyb zdrylxylbdyb;
		for (int i = 0; i < list.size(); i++) {
			zdrylxylbdyb = (Zdrylxylbdyb) list.get(i);
			zdrylxylbdyb.setLbdm(zdrylxylbdyb.getLbdm() + "/"
					+ zdrylxylbdyb.getFz());
		}
		return list;
	}

}
