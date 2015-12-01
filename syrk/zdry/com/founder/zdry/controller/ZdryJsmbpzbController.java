/**********************************************************************   
 * <p>文件名：ZdryJsmbpzbController.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk_syrk
 * @author xu_wenjun@founder.com.cn 
 * @date 2015-3-13 下午2:34:13 
 * @history
 * @department：研发部
 *
*/
package com.founder.zdry.controller;

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

import com.google.gson.Gson;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zdry.bean.ZdryJsmbpzb;
import com.founder.zdry.service.ZdryJsmbpzbService;

/******************************************************************************
 * @Package:      [com.founder.zdry.controller.ZdryJsmbpzbController.java]  
 * @ClassName:    [ZdryJsmbpzbController]   
 * @Description:  [重点人员纪实模板配置表]   
 * @Author:       [xu_wenjun@founder.com.cn]  
 * @CreateDate:   [2015-3-13 下午2:34:13]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-3-13 下午2:34:13，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Controller
@RequestMapping("zdryJsmbpzb")
public class ZdryJsmbpzbController extends BaseController {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name="zdryJsmbpzbService")
	private ZdryJsmbpzbService zdryJsmbpzbService;
	
	/**
	 * 
	 * @Title: queryList
	 * @Description: 查询列表
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryList(EasyUIPage page, 
			@RequestParam(value = "rows") Integer rows, 
			ZdryJsmbpzb entity, SessionBean sessionBean){
		sessionBean = getSessionBean(sessionBean);
		page.setPagePara(rows);
		return zdryJsmbpzbService.queryList(page, entity);
	}
	
	/**
	 * 
	 * @Title: add
	 * @Description: 编辑 跳转
	 * @param @param id
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView add(@RequestParam(value="id",required=false)String id, SessionBean sessionBean) {
		ZdryJsmbpzb entity = new ZdryJsmbpzb();
		if(!StringUtils.isBlank(id)){
			entity = zdryJsmbpzbService.queryById(id);
		}
		ModelAndView mv = new ModelAndView("zdry/zdryJsmbpzbAdd");
		mv.addObject("entity", entity);
		return mv;
	}
	
	/**
	 * 
	 * @Title: save
	 * @Description: 保存
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(ZdryJsmbpzb entity, SessionBean sessionBean){
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			if(StringUtils.isBlank(entity.getId())){
				zdryJsmbpzbService.insert(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, getAddSuccess());
			}else{
				zdryJsmbpzbService.update(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, getUpdateSuccess());
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
	 * @Title: delete
	 * @Description: 删除
	 * @param @param id
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView delete(@RequestParam(value="id",required=false)String id, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			if(!StringUtils.isBlank(id)){
				ZdryJsmbpzb entity = new ZdryJsmbpzb();
				entity.setId(id);
				zdryJsmbpzbService.delete(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, getDeleteSuccess());
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getDeleteFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	@RequestMapping(value = "/setDefault", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView setDefault(@RequestParam(value="id",required=true)String id, @RequestParam(value="zdrygllxdm",required=true)String zdrygllxdm, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			if(!StringUtils.isBlank(id)){
				ZdryJsmbpzb entity = new ZdryJsmbpzb();
				entity.setId(id);
				entity.setZdrygllxdm(zdrygllxdm);
				zdryJsmbpzbService.setDefault(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, getUpdateSuccess());
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getDeleteFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}

}
