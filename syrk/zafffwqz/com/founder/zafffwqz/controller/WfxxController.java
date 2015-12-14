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
import com.founder.framework.utils.MapUtils;
import com.founder.zafffwqz.bean.ZaffWfxx;
import com.founder.zafffwqz.service.WfxxService;

import com.google.gson.Gson;
/******************************************************************************
 * @Package:      [com.founder.zafffwqz.controller.WfxxController.java]  
 * @ClassName:    [WfxxController]   
 * @Description:  [物防空间与属性表控制类]   
 * @Author:       [tian_chengwei@founder.com.cn]  
 * @CreateDate:   [2015-6-5 下午1:49:30]   
 * @UpdateUser:   [lk(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-5 下午1:49:30，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 * 
 *  @review      : wu.w@founder.com.cn
 * @reviewDate  : 20150604
 */
@Controller
@RequestMapping(value = "/wfxx")
public class WfxxController  extends BaseController{
	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "wfxxService")
	private WfxxService wfxxService;
	
	/**
	 * 
	 * @Title: updateWf
	 * @Description: TODO(同时修改空间表和属性表操作)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/updateWf", method = RequestMethod.POST)
	public ModelAndView updateWf(ZaffWfxx entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();		
		try {
			if (entity.getId() != null) { 
				wfxxService.updateWf(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, getMessage("update.success"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getMessage("update.fail"));
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	/**
	 * 
	 * @Title: delete
	 * @Description: TODO(删除物防信息)
	 * @param     设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView delete(ZaffWfxx entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() != null) { // 注销
				wfxxService.delete(entity, sessionBean);
				
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, getMessage("cancel.success"));
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
	 * @Title: queryWf
	 * @Description: TODO(物防基本信息查询)
	 * @param page
	 * @param rows
	 * @param entity
	 * @return EasyUIPage返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryWf", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryWf(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, ZaffWfxx entity) {
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		if(null != sessionBean){
			entity.setGxzrqdm(sessionBean.getUserOrgCode());
			entity.setGxpcsdm((String)sessionBean.getExtendMap().get("ssPcsCode"));
		}
		return wfxxService.queryWf(page, entity);
	}
	
	/**
	 * 
	 * @Title: queryWfxxOnPT
	 * @Description: TODO(空间查询分页，3，2，1，分别为框查/圆查/多边形查)
	 * @param  page
	 * @param  rows
	 * @param  entity
	 * @param     设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryWfxxOnPT", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryWfxxOnPT(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, ZaffWfxx entity) {
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		if(null != sessionBean){
			entity.setGxzrqdm(sessionBean.getUserOrgCode());
			entity.setGxpcsdm((String)sessionBean.getExtendMap().get("ssPcsCode"));
		}
		if(entity.getType()!=null &&!"".equals(entity.getType())){
			if(entity.getType().equals("3")){
				
				entity.setZbz(entity.getZbz());
			}else if(entity.getType().equals("2")){
				
				String[] str =  entity.getZbz().split(",");
				entity.setZbz(str[0]+" "+str[1]);
				entity.setMapRadius(str[2]);
			}else{
				
				entity.setZbz(MapUtils.getSdeZbz(entity.getZbz()));
			}
		}
		return wfxxService.queryWfxxOnPT(page, entity);
	}
}
