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
import com.founder.zdrygl.base.model.ZdryJkbjllxxb;
import com.founder.zdrygl.base.service.ZdryJkbjllxxbService;
import com.google.gson.Gson;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.controller.ZdryJkbjllxxbController.java]  
 * @ClassName:    [ZdryJkbjllxxbController]   
 * @Description:  [监控帮教力量]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年12月15日 下午3:49:56]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年12月15日 下午3:49:56，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Controller
@RequestMapping(value = "zdryJkbjllxxb")
public class ZdryJkbjllxxbController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "zdryJkbjllxxbService")
	private ZdryJkbjllxxbService zdryJkbjllxxbService;

	/**
	 * @Title: add
	 * @Description: TODO(新增页面)
	 * @param @param zdryid
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add(String zdryid) {
		ModelAndView mv = new ModelAndView("zdrygl/edit/zdryJkbjllxxb");
		ZdryJkbjllxxb entity = new ZdryJkbjllxxb();
		entity.setZdryid(zdryid);
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
	@RestfulAnnotation(valiField = "zdryid,jkbjlxdm,jkbjry_ybbjr_rygx,jkbjry_gmsfhm,jkbjry_xm", serverId = "3")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(ZdryJkbjllxxb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> map = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryJkbjllxxbService.save(entity, sessionBean);
			map.put(AppConst.STATUS, AppConst.SUCCESS);
			map.put(AppConst.MESSAGES, getAddSuccess());
			map.put(AppConst.SAVE_ID, "" + entity.getId()); // 返回主键
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			map.put(AppConst.STATUS, AppConst.FAIL);
			map.put(AppConst.MESSAGES, getAddFail()+e.getLocalizedMessage());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(map));
		return mv;
	}
	
	
	@RequestMapping(value = "/queryDetail", method = RequestMethod.GET)
	public ModelAndView queryDetail(String id) {		
		ModelAndView mv = new ModelAndView("zdrygl/edit/zdryJkbjllxxbInfo");
		mv.addObject("entity",zdryJkbjllxxbService.queryById(id));
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
	@RestfulAnnotation(valiField = "id,zdryid,jkbjlxdm,jkbjry_ybbjr_rygx,jkbjry_gmsfhm,jkbjry_xm", serverId = "3")
	@RequestMapping(value = "/{id}", method = { RequestMethod.POST,RequestMethod.GET })
	public ModelAndView update(ZdryJkbjllxxb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> map = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryJkbjllxxbService.update(entity, sessionBean);
			map.put(AppConst.STATUS, AppConst.SUCCESS);
			map.put(AppConst.MESSAGES, getUpdateSuccess());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			map.put(AppConst.STATUS, AppConst.FAIL);
			map.put(AppConst.MESSAGES, getUpdateFail()+e.getLocalizedMessage());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(map));
		return mv;
	}
		
}
