package com.founder.syrkgl.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.exception.BussinessException;
import com.founder.syrkgl.bean.RyRyjlxxb;
import com.founder.syrkgl.service.RyRyjlxxbService;

import com.google.gson.Gson;


/******************************************************************************
 * @Package:      [com.founder.syrkgl.controller.RyRyhykxxbController.java]  
 * @ClassName:    [RyRyhykxxbController]   
 * @Description:  [实有人口附加信息-人员经历信息控制器]   
 * @Author:       [congrihong@founder.com.cn]  
 * @CreateDate:   [2015-4-8 下午4:55:47]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-8 下午4:55:47，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Controller
@RequestMapping(value = "ryRyjlxxb")
public class RyRyjlxxbController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "ryRyjlxxbService")
	private RyRyjlxxbService ryRyjlxxbService;

	/**
	 * @Title: add
	 * @Description: TODO(新增页面)
	 * @param @param ryid
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add(String ryid) {
		ModelAndView mv = new ModelAndView("syrkgl/ryRyjlSave");
		RyRyjlxxb entity = new RyRyjlxxb();
		entity.setRyid(ryid);
		mv.addObject("entity", entity);
		return mv;
	}

	/**
	 * @Title: edit
	 * @Description: TODO(编辑页面)
	 * @param @param id
	 * @param @return
	 * @param @throws BussinessException 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable(value = "id") String id) throws BussinessException {
			ModelAndView mv = new ModelAndView("syrkgl/ryRyjlSave");
			RyRyjlxxb entity = ryRyjlxxbService.queryById(id);
			if (entity == null) {
				throw new BussinessException("查询无数据！");
			}
			mv.addObject("entity", entity);
			return mv;
	}

	/**
	 * @Title: save
	 * @Description: TODO(新增保存)
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(RyRyjlxxb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> map = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			this.ryRyjlxxbService.save(entity, sessionBean);
			map.put(AppConst.STATUS, AppConst.SUCCESS);
			map.put(AppConst.MESSAGES, getAddSuccess());
			map.put(AppConst.SAVE_ID, "" + entity.getId()); // 返回主键
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			map.put(AppConst.STATUS, AppConst.FAIL);
			map.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(map));
		return mv;
	}

	/**
	 * @Title: update
	 * @Description: TODO(修改保存)
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(RyRyjlxxb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> map = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			ryRyjlxxbService.update(entity, sessionBean);
			map.put(AppConst.STATUS, AppConst.SUCCESS);
			map.put(AppConst.MESSAGES, getUpdateSuccess());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			map.put(AppConst.STATUS, AppConst.FAIL);
			map.put(AppConst.MESSAGES, getUpdateFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(map));
		return mv;
	}

	


}
