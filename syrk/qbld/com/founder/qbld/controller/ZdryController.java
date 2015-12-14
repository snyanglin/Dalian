package com.founder.qbld.controller;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.Gson;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.qbld.bean.Clxxb;
import com.founder.qbld.bean.Saxxb;
import com.founder.qbld.bean.Shgxrb;
import com.founder.qbld.bean.Zdjlb;
import com.founder.qbld.bean.ZdryGxbg;
import com.founder.qbld.bean.ZdrySdFd;
import com.founder.qbld.bean.ZdrySdXd;
import com.founder.qbld.bean.ZdrySdZd;
import com.founder.qbld.bean.ZdrySf;
import com.founder.qbld.bean.ZdrySw;
import com.founder.qbld.bean.ZdryZdxsfzqk;
import com.founder.qbld.bean.ZdryZszhjsb;
import com.founder.qbld.bean.ZdryZt;
import com.founder.qbld.bean.Zdryb;
import com.founder.qbld.bean.Zsjlb;
import com.founder.qbld.service.ZdryService;
import com.founder.qbld.utils.QbldUtil;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.controller.ZdryController.java]  
 * @ClassName:    [ZdryController]   
 * @Description:  [重点人员控制器]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-5-14 上午9:43:31]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-14 上午9:43:31，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Controller
@RequestMapping(value = "zdry")
public class ZdryController extends BaseController {
	
	@Resource(name = "zdryService")
	private ZdryService zdryService;
	
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;
	
	/**
	 * @Title: queryCkyjList
	 * @Description: TODO(重点人员表查询)
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryZdryList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryCkyjList(EasyUIPage page,
			@RequestParam(value = "rows", required=false) Integer rows, 
			Zdryb entity,
			SessionBean sessionBean){
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		if (StringUtils.isBlank(entity.getGxdwjgdm())) {
			entity.setGxdwjgdm(QbldUtil.isOrg(sessionBean, orgOrganizationService));
		}
		return zdryService.queryZdryList(page, entity);
	}
	
	/**
	 * @Title: queryZdry
	 * @Description: TODO(重点人员详情查询服务)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Zdryb    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryZdry", method = RequestMethod.POST)
	public @ResponseBody Zdryb queryZdry(Zdryb entity){
		return zdryService.queryZdryb(entity);
	}
	
	/**
	 * @Title: saveCjxxb
	 * @Description: TODO(申请临控)
	 * @param entity
	 * @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveZdryxxb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveZdryxxb(Zdryb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		entity.setGxdwjgdm(sessionBean.getUserOrgCode());
		try {
			zdryService.saveZdryb(entity);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * @Title: queryZdryZtList
	 * @Description: TODO(重点人员在逃表查询)
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryZdryZtList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryZdryZtList(EasyUIPage page,
			@RequestParam(value = "rows", required=false) Integer rows, 
			ZdryZt entity,
			SessionBean sessionBean){
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		entity.setLadwdm(QbldUtil.isOrg(sessionBean, orgOrganizationService));
		return zdryService.queryZdryZtList(page, entity);
	}
	
	/**
	 * @Title: queryZdryZt
	 * @Description: TODO(重点人员在逃详情查询服务)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Zdryb    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryZdryZt", method = RequestMethod.POST)
	public @ResponseBody ZdryZt queryZdryZt(ZdryZt entity){
		return zdryService.queryZdryZtb(entity);
	}
	
	/**
	 * @Title: saveZdryZtxxb
	 * @Description: TODO(保存在逃人员)
	 * @param entity
	 * @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveZdryZtxxb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveZdryZtxxb(ZdryZt entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		entity.setLadwdm(sessionBean.getUserOrgCode());
		try {
			zdryService.saveZdryZtb(entity);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * @Title: queryZdrySwList
	 * @Description: TODO(重点人员涉稳表查询)
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryZdrySwList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryZdrySwList(EasyUIPage page,
			@RequestParam(value = "rows", required=false) Integer rows, 
			ZdrySw entity,
			SessionBean sessionBean){
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		return zdryService.queryZdrySwList(page, entity);
	}
	
	/**
	 * @Title: queryZdrySw
	 * @Description: TODO(重点人员涉稳详情查询服务)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Zdryb    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryZdrySw", method = RequestMethod.POST)
	public @ResponseBody ZdrySw queryZdrySw(ZdrySw entity){
		return zdryService.queryZdrySwb(entity);
	}
	
	/**
	 * @Title: saveZdrySwxxb
	 * @Description: TODO(保存涉稳人员)
	 * @param entity
	 * @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveZdrySwxxb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveZdrySwxxb(ZdrySw entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryService.saveZdrySwb(entity);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * @Title: queryZdrySwList
	 * @Description: TODO(肇事肇祸精神病查询)
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryZdryZszhjsbList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryZdryZszhjsbList(EasyUIPage page,
			@RequestParam(value = "rows", required=false) Integer rows, 
			ZdryZszhjsb entity,
			SessionBean sessionBean){
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		return zdryService.queryZdryZszhjsbList(page, entity);
	}
	
	/**
	 * @Title: queryZdryZszhjsb
	 * @Description: TODO(肇事肇祸精神病详情查询服务)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Zdryb    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryZdryZszhjsb", method = RequestMethod.POST)
	public @ResponseBody ZdryZszhjsb queryZdryZszhjsb(ZdryZszhjsb entity){
		return zdryService.queryZdryZszhjsb(entity);
	}
	
	/**
	 * @Title: saveZdryZszhjsbxxb
	 * @Description: TODO(保存肇事肇祸精神病)
	 * @param entity
	 * @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveZdryZszhjsbxxb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveZdryZszhjsbxxb(ZdryZszhjsb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryService.saveZdryZszhjsb(entity);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * @Title: queryZdrySwList
	 * @Description: TODO(重大刑事犯罪前科查询)
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryZdryZdxsfzqkList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryZdryZdxsfzqkList(EasyUIPage page,
			@RequestParam(value = "rows", required=false) Integer rows, 
			ZdryZdxsfzqk entity,
			SessionBean sessionBean){
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		return zdryService.queryZdryZdxsfzqkList(page, entity);
	}
	
	/**
	 * @Title: queryZdryZdxsfzqk
	 * @Description: TODO(重大刑事犯罪前科详情查询服务)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Zdryb    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryZdryZdxsfzqk", method = RequestMethod.POST)
	public @ResponseBody ZdryZdxsfzqk queryZdryZdxsfzqk(ZdryZdxsfzqk entity){
		return zdryService.queryZdryZdxsfzqk(entity);
	}
	
	/**
	 * @Title: saveZdryZdxsfzqkxxb
	 * @Description: TODO(保存重大刑事犯罪前科)
	 * @param entity
	 * @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveZdryZdxsfzqkxxb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveZdryZdxsfzqkxxb(ZdryZdxsfzqk entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryService.saveZdryZdxsfzqk(entity);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}

	/**
	 * @Title: queryZdrySfList
	 * @Description: TODO(涉访查询)
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryZdrySfList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryZdrySfList(EasyUIPage page,
			@RequestParam(value = "rows", required=false) Integer rows, 
			ZdrySf entity,
			SessionBean sessionBean){
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		return zdryService.queryZdrySfList(page, entity);
	}
	
	/**
	 * @Title: queryZdrySf
	 * @Description: TODO(涉访详情查询服务)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Zdryb    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryZdrySf", method = RequestMethod.POST)
	public @ResponseBody ZdrySf queryZdrySf(ZdrySf entity){
		return zdryService.queryZdrySf(entity);
	}
	
	/**
	 * @Title: saveZdrySfxxb
	 * @Description: TODO(保存涉访)
	 * @param entity
	 * @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveZdrySfxxb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveZdrySfxxb(ZdrySf entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryService.saveZdrySf(entity);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * @Title: queryZdryZdrySdFdList
	 * @Description: TODO(贩毒查询)
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryZdrySdFdList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryZdrySdFdList(EasyUIPage page,
			@RequestParam(value = "rows", required=false) Integer rows, 
			ZdrySdFd entity,
			SessionBean sessionBean){
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		return zdryService.queryZdrySdFdList(page, entity);
	}
	
	/**
	 * @Title: queryZdrySdFd
	 * @Description: TODO(贩毒详情查询服务)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Zdryb    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryZdrySdFd", method = RequestMethod.POST)
	public @ResponseBody ZdrySdFd queryZdrySdFd(ZdrySdFd entity){
		return zdryService.queryZdrySdFd(entity);
	}
	
	/**
	 * @Title: saveZdrySdFdxxb
	 * @Description: TODO(贩毒涉访)
	 * @param entity
	 * @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveZdrySdFdxxb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveZdrySdFdxxb(ZdrySdFd entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryService.saveZdrySdFd(entity);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * @Title: queryZdryZdrySdZdList
	 * @Description: TODO(吸毒查询)
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryZdrySdXdList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryZdrySdXdList(EasyUIPage page,
			@RequestParam(value = "rows", required=false) Integer rows, 
			ZdrySdXd entity,
			SessionBean sessionBean){
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		return zdryService.queryZdrySdXdList(page, entity);
	}
	
	/**
	 * @Title: queryZdrySdXd
	 * @Description: TODO(吸毒详情查询服务)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Zdryb    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryZdrySdXd", method = RequestMethod.POST)
	public @ResponseBody ZdrySdXd queryZdrySdXd(ZdrySdXd entity){
		return zdryService.queryZdrySdXd(entity);
	}
	
	/**
	 * @Title: saveZdrySdXdxxb
	 * @Description: TODO(吸毒涉访)
	 * @param entity
	 * @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveZdrySdXdxxb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveZdrySdXdxxb(ZdrySdXd entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryService.saveZdrySdXd(entity);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * @Title: queryZdryZdrySdZdList
	 * @Description: TODO(制毒查询)
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryZdrySdZdList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryZdrySdZdList(EasyUIPage page,
			@RequestParam(value = "rows", required=false) Integer rows, 
			ZdrySdZd entity,
			SessionBean sessionBean){
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		return zdryService.queryZdrySdZdList(page, entity);
	}
	
	/**
	 * @Title: queryZdrySdZd
	 * @Description: TODO(制毒详情查询服务)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Zdryb    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryZdrySdZd", method = RequestMethod.POST)
	public @ResponseBody ZdrySdZd queryZdrySdZd(ZdrySdZd entity){
		return zdryService.queryZdrySdZd(entity);
	}
	
	/**
	 * @Title: saveZdrySdZdxxb
	 * @Description: TODO(制毒涉访)
	 * @param entity
	 * @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveZdrySdZdxxb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveZdrySdZdxxb(ZdrySdZd entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryService.saveZdrySdZd(entity);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * @Title: queryShgxrList
	 * @Description: TODO(制毒查询)
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryShgxrList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryShgxrList(EasyUIPage page,
			@RequestParam(value = "rows", required=false) Integer rows, 
			Shgxrb entity,
			SessionBean sessionBean){
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		return zdryService.queryShgxrList(page, entity);
	}
	
	/**
	 * @Title: queryShgxr
	 * @Description: TODO(制毒详情查询服务)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Zdryb    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryShgxr", method = RequestMethod.POST)
	public @ResponseBody Shgxrb queryShgxr(Shgxrb entity){
		return zdryService.queryShgxr(entity);
	}
	
	/**
	 * @Title: saveShgxrxxb
	 * @Description: TODO(制毒涉访)
	 * @param entity
	 * @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveShgxrxxb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveShgxrxxb(Shgxrb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		entity.setTbdwdm(sessionBean.getUserOrgCode());
		entity.setTbdwmc(sessionBean.getUserOrgNameQc());
		try {
			zdryService.saveShgxr(entity);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * @Title: querySaxxList
	 * @Description: TODO(涉案信息查询)
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/querySaxxList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage querySaxxList(EasyUIPage page,
			@RequestParam(value = "rows", required=false) Integer rows, 
			Saxxb entity,
			SessionBean sessionBean){
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		return zdryService.querySaxxList(page, entity);
	}
	
	/**
	 * @Title: querySaxx
	 * @Description: TODO(涉案信息详情查询服务)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Zdryb    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/querySaxx", method = RequestMethod.POST)
	public @ResponseBody Saxxb querySaxx(Saxxb entity){
		return zdryService.querySaxx(entity);
	}
	
	/**
	 * @Title: saveSaxxb
	 * @Description: TODO(保存涉案信息)
	 * @param entity
	 * @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveSaxxb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveSaxxb(Saxxb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryService.saveSaxx(entity);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * @Title: queryClxxList
	 * @Description: TODO(车辆信息查询)
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryClxxList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryClxxList(EasyUIPage page,
			@RequestParam(value = "rows", required=false) Integer rows, 
			Clxxb entity,
			SessionBean sessionBean){
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		return zdryService.queryClxxList(page, entity);
	}
	
	/**
	 * @Title: queryClxx
	 * @Description: TODO(车辆信息详情查询服务)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Zdryb    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryClxx", method = RequestMethod.POST)
	public @ResponseBody Clxxb queryClxx(Clxxb entity){
		return zdryService.queryClxx(entity);
	}
	
	/**
	 * @Title: saveClxxxxb
	 * @Description: TODO(保存车辆信息)
	 * @param entity
	 * @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveClxxb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveClxxb(Clxxb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryService.saveClxx(entity);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * @Title: queryZdjlList
	 * @Description: TODO(诊断信息查询)
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryZdjlList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryZdjlList(EasyUIPage page,
			@RequestParam(value = "rows", required=false) Integer rows, 
			Zdjlb entity,
			SessionBean sessionBean){
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		return zdryService.queryZdjlList(page, entity);
	}
	
	/**
	 * @Title: queryZdjl
	 * @Description: TODO(诊断信息详情查询服务)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Zdryb    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryZdjl", method = RequestMethod.POST)
	public @ResponseBody Zdjlb queryZdjl(Zdjlb entity){
		return zdryService.queryZdjl(entity);
	}
	
	/**
	 * @Title: saveZdjlxxb
	 * @Description: TODO(保存诊断信息)
	 * @param entity
	 * @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveZdjlb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveZdjlb(Zdjlb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryService.saveZdjl(entity);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * @Title: queryZsjlList
	 * @Description: TODO(肇事肇祸信息查询)
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryZsjlList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryZsjlList(EasyUIPage page,
			@RequestParam(value = "rows", required=false) Integer rows, 
			Zsjlb entity,
			SessionBean sessionBean){
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		return zdryService.queryZsjlList(page, entity);
	}
	
	/**
	 * @Title: queryZsjl
	 * @Description: TODO(肇事肇祸信息详情查询服务)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Zdryb    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryZsjl", method = RequestMethod.POST)
	public @ResponseBody Zsjlb queryZsjl(Zsjlb entity){
		return zdryService.queryZsjl(entity);
	}
	
	/**
	 * @Title: saveZsjlxxb
	 * @Description: TODO(保存肇事肇祸)
	 * @param entity
	 * @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveZsjlb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveZsjlb(Zsjlb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryService.saveZsjl(entity);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * @Title: queryZsjlList
	 * @Description: TODO(重点人员管辖变更)
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryGxbgList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryGxbgList(EasyUIPage page,
			@RequestParam(value = "rows", required=false) Integer rows, 
			ZdryGxbg entity,
			SessionBean sessionBean){
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		return zdryService.queryGxbgList(page, entity);
	}
	
	/**
	 * @Title: updateGxbg
	 * @Description: TODO(修改管辖单位变更)
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/updateGxbg", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView updateGxbg(ZdryGxbg entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryService.updateGxbg(entity);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
}