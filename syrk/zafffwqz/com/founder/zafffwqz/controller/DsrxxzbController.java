package com.founder.zafffwqz.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.zafffwqz.bean.Dsrxxzb;
import com.founder.zafffwqz.service.DsrxxzbService;

import com.google.gson.Gson;

/******************************************************************************
 * @Package:      [com.founder.zafffwqz.controller.DsrxxzbController.java]  
 * @ClassName:    [DsrxxzbController]   
 * @Description:  [当时人控制类]   
 * @Author:       [tian_chengwei@founder.com.cn]  
 * @CreateDate:   [2015-6-5 下午1:25:59]   
 * @UpdateUser:   [lk(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-5 下午1:25:59，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Controller
@RequestMapping(value = "/dsrxxzb")
public class DsrxxzbController extends BaseController {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name="dsrxxzbService")
	private DsrxxzbService dsrxxzbService;
	

	/**
	 * 
	 * @Title: dsrInfo
	 * @Description: TODO(想起)
	 * @param id
	 * @return ModelAndView返回类型
	 * @throws
	 */
	@RequestMapping(value="/dsrInfo",method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView dsrInfo(String id){
		ModelAndView mv = new ModelAndView("zafffwqz/dsrDetail");
		Dsrxxzb entity = new Dsrxxzb();
		String flag ="add";
		try {
			if(!"".equals(id)&&id!=null){
				entity.setId(id);
			}
			mv.addObject("entity", entity);
			entity = dsrxxzbService.queryDsrxxzb(entity);
			if(entity != null){
				mv.addObject("entity", entity);
				flag ="update";
			}
			mv.addObject("flag", flag);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
		
	}
	/**
	 * 
	 * @Title: addDsrxxzb
	 * @Description: TODO(跳转-添加修改)
	 * @param id
	 * @param mdjfxxid
	 * @param mainTabID
	 * @return ModelAndView返回类型
	 * @throws
	 */
	@RequestMapping(value = "/addDsrxxzb", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView addDsrxxzb(String id,String mdjfxxid,String mainTabID) {
		ModelAndView mv = new ModelAndView("zafffwqz/dsrxxadd");
		Dsrxxzb entity = new Dsrxxzb();
		String flag ="add";
		try {
			if(!"".equals(id)&&id!=null){
				entity.setId(id);
			}
			entity.setMdjfxxid(mdjfxxid);
			mv.addObject("entity", entity);
			mv.addObject("mdjfxxid", mdjfxxid);
			entity = dsrxxzbService.queryDsrxxzb(entity);
			if(entity != null){
				mv.addObject("entity", entity);
				flag ="update";
			}
			mv.addObject("flag", flag);
			mv.addObject("mainTabID", mainTabID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * @Title: saveDsrxxzb
	 * @Description: TODO(保存-当事人)
	 * @param entity
	 * @return ModelAndView返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveDsrxxzb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveDsrxxzb(Dsrxxzb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() == null || entity.getId().equals("")) {
				if("".equals(entity.getRyid())||entity.getRyid()==null){
					entity.setRyid(UUID.create());
				}
				dsrxxzbService.saveDsrxxzb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【当事人信息】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				dsrxxzbService.updateDsrxxzb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【当事人信息】成功！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		System.out.println(new Gson().toJson(model));
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	
	
	/**
	 * 
	 * @Title: DeleteDsrxxzb
	 * @Description: TODO(删除)
	 * @param entity
	 * @return ModelAndView返回类型
	 * @throws
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView DeleteDsrxxzb(Dsrxxzb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() != null) { // 注销
				dsrxxzbService.delete(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "注销【当事人信息】成功！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getMessage("cancel.fail"));
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	/**
	 * 
	 * @Title: queryList
	 * @Description: TODO(列表查询)
	 * @param page
	 * @param rows
	 * @param mdjfxxid
	 * @return EasyUIPage返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryList(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, String mdjfxxid) {
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		Map map=new HashMap();
		if(!"".equals(mdjfxxid)&&mdjfxxid!=null){
			map.put("mdjfxxid", mdjfxxid);
		}else{
			map.put("mdjfxxid", null);
		}
		map.put("xt_lrrbmid", sessionBean.getUserOrgCode());
		
		return dsrxxzbService.queryList(page, map);
	}
}
