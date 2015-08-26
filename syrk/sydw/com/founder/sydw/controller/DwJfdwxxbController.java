/**********************************************************************   
 * <p>文件名：DwJfdwxxbController.java </p>
 * <p>文件描述：技防单位信息
 * @project_name：sydw
 * @author yu_guangli@founder.com
 * @date 2015-06-6
 * @history
 * @department：研发部
 *
*/
package com.founder.sydw.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.sydw.bean.Dwbadwxxb;
import com.founder.sydw.bean.Dwjfdwxxb;
import com.founder.sydw.service.DwJfdwxxbService;

import com.google.gson.Gson;

@Controller
@RequestMapping("/dwjfdwxxb")
public class DwJfdwxxbController extends BaseController {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "dwJfdwxxbService")
	private DwJfdwxxbService dwJfdwxxbService;
	
	/**
	 * 跳转
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView add(String id,String dwid){
		ModelAndView mv = new ModelAndView("sydw/jfdwxxbAdd");
		Dwjfdwxxb entity = new Dwjfdwxxb();
		String flag = "add";
		if(null!=id&&!"".equals(id)){
			entity.setId(id);
			entity = dwJfdwxxbService.queryJfdwxxbByid(entity);
			flag="update";
		}
		entity.setDwid(dwid);
		mv.addObject("flag", flag);
		mv.addObject("entity", entity);
		return mv;
	}
	
	/**
	 * 跳转
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/edit_jfb", method = RequestMethod.GET)
	public ModelAndView add_b(String id,String dwid){
		ModelAndView mv = new ModelAndView("sydw/jfdw_bxxbAdd");
		Dwjfdwxxb entity = new Dwjfdwxxb();
		String flag = "add";
		if(null!=id&&!"".equals(id)){
			entity.setId(id);
			entity = dwJfdwxxbService.queryJfdwxxbByid(entity);
			flag="update";
		}
		entity.setDwid(dwid);
		mv.addObject("flag", flag);
		mv.addObject("entity", entity);
		return mv;
	}
	
	/**
	 * 保存、修改
	 * @param Dwhbxxb
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(Dwjfdwxxb entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if(null==entity.getId()||"".equals(entity.getId())){
				entity.setXt_zxbz("0");
				dwJfdwxxbService.saveJfdwxxb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【技防单位信息】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				dwJfdwxxbService.updateJfdwxxb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【技防单位信息】成功！");
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

}
