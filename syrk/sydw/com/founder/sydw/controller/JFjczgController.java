package com.founder.sydw.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.sydw.bean.Dwlscftzs;
import com.founder.sydw.bean.Dwzdhzyhzgtzs;
import com.founder.sydw.bean.Dwzlzgtzs;
import com.founder.sydw.bean.JFDwzlzgtzs;
import com.founder.sydw.bean.JfFcyjs;
import com.founder.sydw.service.DwjczgService;
import com.founder.sydw.service.JFjczgService;

import com.google.gson.Gson;
/**
 * ****************************************************************************
 * @Package:      [com.founder.sydw.controller.JFjczgController.java]  
 * @ClassName:    [JFjczgController]   
 * @Description:  技防检查 整改 
 * @Author:       [xu_haibo@founder.com.cn]  
 * @CreateDate:   [2015-6-29 下午3:03:22]   
 * @UpdateUser:   [xuhaibo(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-29 下午3:03:22，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Controller
@RequestMapping(value = "jfjczg")
public class JFjczgController extends BaseController{
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "jfjczgService")
	private JFjczgService jfjczgService;
	/**
	 * 
	 * @Title: saveJfzlzgtzs
	 * @Description: 保存技防责令整改通知书
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveJfzlzgtzs", method = RequestMethod.POST)
	public @ResponseBody ModelAndView saveJfzlzgtzs(JFDwzlzgtzs entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/" + AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			jfjczgService.saveJfzlzgtzs(entity, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, getAddSuccess());
			model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
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
	 * 
	 * @Title: queryJfzlzgtzs
	 * @Description: 查询技防责令整改通知书
	 * @param @param param
	 * @param @return    设定文件
	 * @return JFDwzlzgtzs    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryJfzlzgtzs", method = RequestMethod.GET)
	public @ResponseBody ModelAndView queryJfzlzgtzs(String id,String jcid){
		ModelAndView mv = new ModelAndView("sydw/jfzlxqzgxxDetail");
		JFDwzlzgtzs entity = new JFDwzlzgtzs();
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("id", id);
		param.put("jcid", jcid);
		entity = jfjczgService.queryJfzlzgtzs(param);
		mv.addObject("entity", entity);
		return mv;
	}
	/**
	 * 
	 * @Title: saveJFfcyjs
	 * @Description: 保存技防复查意见书
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveJFfcyjs", method = RequestMethod.POST)
	public @ResponseBody ModelAndView saveJFfcyjs(JfFcyjs entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/" + AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			jfjczgService.saveJFfcyjs(entity, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, getAddSuccess());
			model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
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
	 * 
	 * @Title: queryJFfcyjs
	 * @Description: 查询技防复查意见书
	 * @param @param param
	 * @param @return    设定文件
	 * @return JfFcyjs    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryJFfcyjs", method = RequestMethod.GET)
	public @ResponseBody ModelAndView queryJFfcyjs(String id,String jcid){
		ModelAndView mv = new ModelAndView("sydw/jffcyjsDetail");
		JfFcyjs entity = new JfFcyjs();
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("id", id);
		param.put("jcid", jcid);
		entity = jfjczgService.queryJFfcyjs(param);
		mv.addObject("entity", entity);
		return mv;
	}

}
