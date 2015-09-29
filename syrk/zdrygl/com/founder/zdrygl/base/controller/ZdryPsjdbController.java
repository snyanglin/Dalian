package com.founder.zdrygl.base.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.annotation.RestfulAnnotation;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.zdrygl.base.model.ZdryPsjdb;
import com.founder.zdrygl.base.service.ZdryPsjdbService;
import com.google.gson.Gson;

@Controller
@RequestMapping(value = "zdryPsjdb")
public class ZdryPsjdbController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "zdryPsjdbService")
	private ZdryPsjdbService zdryPsjdbService;

	/**
	 * 
	 * @Title: add
	 * @Description: TODO(评审鉴定 新增 页面)
	 * @param @param id
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add(String id) {
		ModelAndView mv = new ModelAndView("zdrygl/edit/zdryPsjdb");
		ZdryPsjdb entity = new ZdryPsjdb();
		entity.setZdryid(id);
		mv.addObject("entity", entity);
		return mv;
	}
	
	/**
	 * 
	 * @Title: save
	 * @Description: TODO(评审鉴定 保存请求)
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RestfulAnnotation(valiField = "zdryid,py_sj,pydd,cjry,nrjy", serverId = "3")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(ZdryPsjdb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> map = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryPsjdbService.save(entity, sessionBean);
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
	 * 
	 * @Title: queryDetail
	 * @Description: TODO(评审鉴定 详情查询)
	 * @param @param id
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryDetail", method = RequestMethod.GET)
	public ModelAndView queryDetail(String id) {		
		ModelAndView mv = new ModelAndView("zdrygl/edit/zdryPsjdbInfo");
		mv.addObject("entity",zdryPsjdbService.queryById(id));
		return mv;
	}
	
	/**
	 * 
	 * @Title: update
	 * @Description: TODO(评审鉴定 修改)
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RestfulAnnotation(valiField = "id,zdryid,py_sj,pydd,cjry,nrjy", serverId = "3")
	@RequestMapping(value = "/{id}", method = { RequestMethod.POST,
			RequestMethod.PUT })
	public ModelAndView update(ZdryPsjdb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> map = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryPsjdbService.update(entity, sessionBean);
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
