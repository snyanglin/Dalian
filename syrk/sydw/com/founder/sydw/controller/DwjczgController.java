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
import com.founder.sydw.service.DwjczgService;

import com.google.gson.Gson;
/**
 * ****************************************************************************
 * @Package:      [com.founder.sydw.controller.DwjczgController.java]  
 * @ClassName:    [DwjczgController]   
 * @Description:  单位检查 整改 
 * @Author:       [yu_guangli@founder.com.cn]  
 * @CreateDate:   [2015-6-24 下午3:03:22]   
 * @UpdateUser:   [yuguangli(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-24 下午3:03:22，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Controller
@RequestMapping(value = "dwjczg")
public class DwjczgController extends BaseController{
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "dwjczgService")
	private DwjczgService dwjczgService;
	/**
	 * 
	 * @Title: saveZlzgtzs
	 * @Description: 保存责令整改通知书
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveZlzgtzs", method = RequestMethod.POST)
	public @ResponseBody ModelAndView saveZlzgtzs(Dwzlzgtzs entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/" + AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			dwjczgService.saveZlzgtzs(entity, sessionBean);
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
	 * @Title: queryZlzgtzs
	 * @Description: 查询责令整改通知书
	 * @param @param param
	 * @param @return    设定文件
	 * @return Dwzlzgtzs    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryZlzgtzs", method = RequestMethod.GET)
	public @ResponseBody ModelAndView queryZlzgtzs(String id,String jcid){
		ModelAndView mv = new ModelAndView("sydw/zlxqzgxxbDetail");
		Dwzlzgtzs entity = new Dwzlzgtzs();
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("id", id);
		param.put("jcid", jcid);
		entity = dwjczgService.queryZlzgtzs(param);
		mv.addObject("entity", entity);
		return mv;
	}
	
	/**
	 * 
	 * @Title: saveLscftzs
	 * @Description: 保存临时查封通知书
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveLscftzs", method = RequestMethod.POST)
	public @ResponseBody ModelAndView saveLscftzs(Dwlscftzs entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/" + AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			dwjczgService.saveLscftzs(entity, sessionBean);
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
	 * @Title: queryLscftzs
	 * @Description: 查询临时查封通知书
	 * @param @param param
	 * @param @return    设定文件
	 * @return Dwlscftzs    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryLscftzs", method = RequestMethod.GET)
	public @ResponseBody ModelAndView queryLscftzs(String id,String jcid){
		ModelAndView mv = new ModelAndView("sydw/lscfzgDetail");
		Dwlscftzs entity = new Dwlscftzs();
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("id", id);
		param.put("jcid", jcid);
		entity = dwjczgService.queryLscftzs(param);
		mv.addObject("entity", entity);
		return mv;
	}
	/**
	 * 
	 * @Title: saveZdhzyhzgtzs
	 * @Description: 保存重大火灾隐患整改通知书
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveZdhzyhzgtzs", method = RequestMethod.POST)
	public @ResponseBody ModelAndView saveZdhzyhzgtzs(Dwzdhzyhzgtzs entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/" + AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			dwjczgService.saveZdhzyhzgtzs(entity, sessionBean);
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
	 * @Title: queryZdhzyhzgtzs
	 * @Description: 查询重大火灾隐患整改通知书
	 * @param @param param
	 * @param @return    设定文件
	 * @return Dwzdhzyhzgtzs    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryZdhzyhzgtzs", method = RequestMethod.GET)
	public @ResponseBody ModelAndView queryZdhzyhzgtzs(String id,String jcid){
		ModelAndView mv = new ModelAndView("sydw/zdhzyhzgDetail");
		Dwzdhzyhzgtzs entity = new Dwzdhzyhzgtzs();
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("id", id);
		param.put("jcid", jcid);
		entity = dwjczgService.queryZdhzyhzgtzs(param);
		mv.addObject("entity", entity);
		return mv;
	}
	/**
	 * 
	 * @Title: queryXh
	 * @Description: 查询序号
	 * @param @return    设定文件
	 * @return  Map<String,Object>   返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryXh", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> queryXh(){
		Map<String,Object> param = new HashMap<String,Object>();
		String xh = dwjczgService.queryXh(param);
		param.put("xh", xh);
		return param;
	}
}
