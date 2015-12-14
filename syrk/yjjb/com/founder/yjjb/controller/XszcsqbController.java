package com.founder.yjjb.controller;

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
import com.founder.framework.utils.StringUtils;
import com.founder.yjjb.bean.Xszcsqb;
import com.founder.yjjb.service.XszcsqbService;

import com.google.gson.Gson;

/**
 * 线索递转申请表</br>
 * @author Administrator
 * @since 2014-11-20
 */
@Controller
@RequestMapping(value = "/xszcsqb")
public class XszcsqbController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name="xszcsqbService")
	private XszcsqbService xszcsqbService;
	
	/**
	 * 跳转
	 * @param id
	 * @param mainTabID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/openList", method = RequestMethod.GET)
	public ModelAndView xszcsqbList(String id,String mainTabID) {
		
		ModelAndView mv = new ModelAndView("yjjb/zcsqList");
		mv.addObject("mainTabID", mainTabID);
		Xszcsqb entity = new Xszcsqb();
		
		if (!StringUtils.isBlank(id)) {
			
			entity.setId(id);
			entity = xszcsqbService.queryById(entity);
		}
		mv.addObject("entity", entity);
		return mv;
	}
	
	/**
	 * 查询</br>
	 * @param page
	 * @param rows
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryList(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, Xszcsqb entity){
		
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		if(null != sessionBean){
			String orgCode = sessionBean.getUserOrgCode();
			// 去掉右侧的零，进行模糊查询
			entity.setXt_lrrbmid(orgCode.replaceAll("0+?$", ""));
		}
		
		return this.xszcsqbService.queryList(page,entity);
	}
	
	/**
	 * 跳转新增/编辑页面
	 * @param id
	 * @param mainTabID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/openAdd", method = RequestMethod.GET)
	public ModelAndView add(String id,String mainTabID) {
		
		ModelAndView mv = new ModelAndView("yjjb/zcsqAdd");
		mv.addObject("mainTabID", mainTabID);
		Xszcsqb entity = new Xszcsqb();
		
		if (!StringUtils.isBlank(id)) {
			
			entity.setId(id);
			entity = xszcsqbService.queryById(entity);
		}
		
		mv.addObject("entity", entity);
		return mv;
	}
	
	/**
	 * 新增和修改
	 * @param entity
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(Xszcsqb entity){
		
		ModelAndView mv = new ModelAndView("redirect:/forward/" + AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			
			if (entity.getId() == null || entity.getId().equals("")) {	//新增
				
				xszcsqbService.save(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES,  getMessage("add.success"));
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {	//修改
				
				xszcsqbService.update(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES,  getMessage("update.success"));
			}
		}catch (Exception e) {
			
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * 注销
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView delete(Xszcsqb entity){
		
		ModelAndView mv = new ModelAndView("redirect:/forward/"	+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		
		try {
			
			xszcsqbService.delete(entity, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES,  getMessage("cancel.success"));
		} catch (Exception e) {
			
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
}
