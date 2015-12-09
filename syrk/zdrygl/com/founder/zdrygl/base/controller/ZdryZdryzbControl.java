package com.founder.zdrygl.base.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
import com.founder.framework.exception.RestException;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.organization.position.service.OrgPositionService;
import com.founder.framework.organization.user.service.OrgUserService;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.ldym.util.SystemConfig;
import com.founder.service.attachment.service.ZpfjFjxxbService;
import com.founder.workflow.bean.StartProcessInstance;
import com.founder.workflow.service.inteface.JProcessDefinitionService;
import com.founder.zdrygl.base.model.ZdryZb;
import com.founder.zdrygl.base.model.Zdrycg;
import com.founder.zdrygl.base.service.ZdryInfoQueryService;
import com.founder.zdrygl.base.service.wf.LcgFlagEnum;
import com.founder.zdrygl.base.service.wf.WorkFlowParametersInitialService;
import com.founder.zdrygl.base.validator.ZdryVOValidator;
import com.founder.zdrygl.base.vo.ZdryVO;
import com.founder.zdrygl.core.factory.ZdryAbstractFactory;
import com.founder.zdrygl.core.inteface.ZdryService;
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

	@Resource(name = "zpfjFjxxbService")
	private ZpfjFjxxbService zpfjFjxxbService;
	
	@Autowired
	private ZdryRuleService zdryRuleService;
	
	@Autowired
	private ZdryVOValidator zdryVOValidator;

	@InitBinder
	public void initBinder(WebDataBinder binder) { 
		Object target=binder.getTarget();
		if(target!=null && target.getClass().equals(ZdryVO.class))
			binder.setValidator(zdryVOValidator);  
		else{
			//多个验证器的时候使用
		}
	}
	
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
		SystemConfig.add(AppConst.XZQH,"210200");//TODO for test
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
	public @ResponseBody List<?> queryZdryChildLbList(String lbdm_p) {
		return zdryQueryService.getChildList(lbdm_p);
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
	 * @throws RestException 
	 * @throw
	 */
	@RequestMapping(value = "/saveLg", method = RequestMethod.POST)
	public ModelAndView saveLg(@Valid ZdryVO zdryVO,BindingResult result, SessionBean sessionBean) throws RestException {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		
		/*if(!super.validateResult(mv, result)){
			return mv;
		}*/
		
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			String zdrygllxdm = zdryVO.getZdryZdryzb().getZdrygllxdm();// 重点人员类型
			ZdryService zdryService = zdryFactory.createZdryService(zdrygllxdm,
					zdryVO.getZdryZdryzb(), zdryVO.getZdrylbdx());
			// start process
			WorkFlowParametersInitialService wfpis = new WorkFlowParametersInitialService(zdryConstant,zdryQueryService);
			StartProcessInstance spi = wfpis.initialProcessInstance(sessionBean,zdryVO,LcgFlagEnum.LG);
			zdryService.setStartProcessInstance(spi.getProcessKey(), spi.getApplyUserId(),spi.getVariables());
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
		List<?> zdryList = zdryQueryService.queryListByEntity(zdryZb);
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

		List<?> zdryList = zdryQueryService.queryListByRyid(ryid);

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
		String klgStr;
		try {
			klgStr = zdryRuleService.getKlglx(ylglxStr);
			if ("".equals(klgStr)) {// 没有可列管的类型，不能返回“”，此时应该没有匹配的选项
				klgStr = "999999";
			}
			return klgStr;
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		return "999999";
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
		String kcgStr = null;
		try {
			kcgStr = zdryRuleService.getKcglx(zdrygllxdm);
			
		} catch (Exception e) {			
			e.printStackTrace();			
		}
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
			// start process
			WorkFlowParametersInitialService wfpis = new WorkFlowParametersInitialService(zdryConstant,zdryQueryService);
			StartProcessInstance spi = wfpis.initialProcessInstance(sessionBean, zdryVO,LcgFlagEnum.CG);
			zdryService.setStartProcessInstance(spi.getProcessKey(), spi.getApplyUserId(), spi.getVariables());
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

}
