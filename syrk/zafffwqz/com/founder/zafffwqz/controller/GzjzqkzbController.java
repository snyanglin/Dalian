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
import com.founder.zafffwqz.bean.Gzjzqkzb;
import com.founder.zafffwqz.service.GzjzqkzbService;

import com.google.gson.Gson;

/******************************************************************************
 * @Package:      [com.founder.zafffwqz.controller.GzjzqkzbController.java]  
 * @ClassName:    [GzjzqkzbController]   
 * @Description:  [跟进进展情况控制类]   
 * @Author:       [tian_chengwei@founder.com.cn]  
 * @CreateDate:   [2015-6-5 上午9:13:07]   
 * @UpdateUser:   [lk(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-5 上午9:13:07，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Controller
@RequestMapping(value = "/gzjzqkzb")
public class GzjzqkzbController extends BaseController {
	
private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name="gzjzqkzbService")
	private GzjzqkzbService gzjzqkzbService;
	
	/**
	 * 
	 * @Title: queryGzjzqkInfo
	 * @Description: TODO(跟踪进展详情)
	 * @param id
	 * @return
	 * @return ModelAndView返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryGzjzqkInfo", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView queryGzjzqkInfo(String id){
		ModelAndView mv = new ModelAndView("/zafffwqz/gzjzqkDetail");
		try{
		Gzjzqkzb entity = new Gzjzqkzb();
		if(id != null){
			entity.setId(id);
		}
		mv.addObject("entity", entity);
		entity = gzjzqkzbService.queryGzjzqkzb(entity);
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
	 * @Title: addGzjzqkzb
	 * @Description: TODO(添加修改跳转操作)
	 * @param id
	 * @param mdjfxxid
	 * @return
	 * @return ModelAndView返回类型
	 * @throws
	 */
	@RequestMapping(value = "/addGzjzqkzb", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView addGzjzqkzb(String id,String mdjfxxid) {
		ModelAndView mv = new ModelAndView("zafffwqz/gzjzqkadd");
		Gzjzqkzb entity = new Gzjzqkzb();
		SessionBean sessionBean = getSessionBean();
		try {
			entity.setGzjzr(sessionBean.getUserName());
			if(!"".equals(id)&&id!=null){
				entity.setId(id);
			}
			entity.setMdjfxxid(mdjfxxid);
			mv.addObject("entity", entity);
			entity =  gzjzqkzbService.queryGzjzqkzb(entity);
			if(entity != null){
				mv.addObject("entity", entity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * @Title: saveGzjzqkzb
	 * @Description: TODO(保存操作)
	 * @param entity
	 * @return
	 * @return ModelAndView返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveGzjzqkzb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveGzjzqkzb(Gzjzqkzb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() == null || entity.getId().equals("")) {
				gzjzqkzbService.saveGzjzqkzb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【跟踪进展情况】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				gzjzqkzbService.updateGzjzqkzb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【跟踪进展情况】成功！");
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
	 * @Title: DeleteGzjzqkzb
	 * @Description: TODO(注销操作跳转)
	 * @param entity
	 * @return
	 * @return ModelAndView返回类型
	 * @throws
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView DeleteGzjzqkzb(Gzjzqkzb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() != null) { // 注销
				gzjzqkzbService.delete(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "注销【跟踪进展情况】成功！");
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
	 * @Description: TODO(分页查询)
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
		
		return gzjzqkzbService.queryList(page, map);
	}
}
