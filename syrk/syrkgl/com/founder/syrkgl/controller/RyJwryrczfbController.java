package com.founder.syrkgl.controller;
import java.util.HashMap;
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
import com.founder.syrkgl.bean.RyJwryrczfb;
import com.founder.syrkgl.service.RyJwryrczfbService;

import com.google.gson.Gson;
/**
 * @类名: RyJwryrczfbController 
 * @描述: 境外人员日常走访表  
 * @作者: zhang_guoliang@founder.com 
 * @日期: 2015-6-26 上午9:24:12 
 */
@Controller
@RequestMapping(value = "jwryrczf")
public class RyJwryrczfbController extends BaseController{
	@Resource(name = "ryJwryrczfbService")
	private RyJwryrczfbService ryJwryrczfbService;
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;
	/**
	 * @Title: queryJwryHsxf 
	 * @描述: 境外人员日常走访列表
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-6-26 上午9:29:00 
	 * @返回值: EasyUIPage    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/queryJwryRczf",method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryJwryRczf(EasyUIPage page,@RequestParam(value = "rows",required=false) Integer rows,RyJwryrczfb entity,SessionBean sessionBean){
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		if(null != sessionBean){
			OrgOrganization userOrg = orgOrganizationService.queryById(sessionBean.getUserOrgId());
			String orglevel = userOrg.getOrglevel();
			if(("21").equals(orglevel)){
				entity.setFxjdm((String)sessionBean.getUserOrgCode());
			}else if("32".equals(orglevel)){
				entity.setPcsdm((String)sessionBean.getUserOrgCode());
			}else if("50".equals(orglevel)){
				entity.setZrqdm((String)sessionBean.getUserOrgCode());
			}
		}
		return ryJwryrczfbService.queryJwryRczf(page, entity);
	}
	/**
	 * @Title: update 
	 * @描述: 境外人员日常走访更新
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-6-26 上午9:29:30 
	 * @返回值: ModelAndView    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public @ResponseBody ModelAndView update(RyJwryrczfb entity,SessionBean sessionBean){
		ModelAndView mv = new ModelAndView("redirect:/forward/"+ AppConst.FORWORD);
		sessionBean = getSessionBean(sessionBean);
		//返回提示
		Map<String, Object> model = new HashMap<String, Object>();
		try{
			ryJwryrczfbService.update(entity, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "走访核实成功！");
			model.put(AppConst.SAVE_ID, entity.getId());
		}catch(Exception e){
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, "走访核实失败！");
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
}