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
import com.founder.zafffwqz.bean.Tjxxzb;
import com.founder.zafffwqz.service.TjxxzbService;

import com.google.gson.Gson;

/******************************************************************************
 * @Package:      [com.founder.zafffwqz.controller.TjxxzbController.java]  
 * @ClassName:    [TjxxzbController]   
 * @Description:  [矛盾纠纷-调节信息控制类]   
 * @Author:       [tian_chengwei@founder.com.cn]  
 * @CreateDate:   [2015-6-5 下午1:29:20]   
 * @UpdateUser:   [lk(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-5 下午1:29:20，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Controller
@RequestMapping(value = "/tjxxzb")
public class TjxxzbController extends BaseController {
	
private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name="tjxxzbService")
	private TjxxzbService tjxxzbService;
	
	
	/**
	 * 
	 * @Title: queryTjxx
	 * @Description: TODO(详情)
	 * @param id
	 * @return ModelAndView返回类型
	 * @throws
	 */
	@RequestMapping(value = "queryTjxx", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView queryTjxx(String id){
		ModelAndView mv = new ModelAndView("zafffwqz/tjxxDetail");
		try{
		Tjxxzb entity = new Tjxxzb();
		if(id != null){
			entity.setId(id);
		}
		mv.addObject("entity", entity);
		entity = tjxxzbService.queryTjxxzb(entity);
		if(entity != null){
			mv.addObject("entity", entity);
		}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return mv;
		
	}
	
	
	/**
	 * 
	 * @Title: addTjxxzb
	 * @Description: TODO(跳转-增加修改)
	 * @param id
	 * @param mdjfxxid
	 * @return ModelAndView返回类型
	 * @throws
	 */
	@RequestMapping(value = "/addTjxxzb", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView addTjxxzb(String id,String mdjfxxid) {
		ModelAndView mv = new ModelAndView("zafffwqz/tjxxadd");
		Tjxxzb entity = new Tjxxzb();
		SessionBean sessionBean = getSessionBean();
		String flag ="add";
		try {
			entity.setTjdwmc(sessionBean.getExtendValue("ssPcsName"));
			mv.addObject("entity", entity);
			if(id!=null){
				entity.setId(id);
			}
			entity.setMdjfxxid(mdjfxxid);
			entity = tjxxzbService.queryTjxxzb(entity);
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
	 * @Title: saveTjxxzb
	 * @Description: TODO(保存)
	 * @param entity
	 * @return ModelAndView返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveTjxxzb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveTjxxzb(Tjxxzb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() == null || entity.getId().equals("")) {
				tjxxzbService.saveTjxxzb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【调解信息】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				tjxxzbService.updateTjxxzb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【调解信息】成功！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	
	
	/**
	 * 
	 * @Title: DeleteTjxxzb
	 * @Description: TODO(删除)
	 * @param entity
	 * @return ModelAndView返回类型
	 * @throws
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView DeleteTjxxzb(Tjxxzb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() != null) { // 注销
				tjxxzbService.delete(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "注销【调解信息】成功！");
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
	 * @Description: TODO(分页查询跳转)
	 * @param @param page
	 * @param @param rows
	 * @param @param mdjfxxid
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
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
		
		return tjxxzbService.queryList(page, map);
	}
}
