/**********************************************************************   
 * <p>文件名：ZdryGlpzpzbController.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk_syrk
 * @author xu_wenjun@founder.com.cn 
 * @date 2015-3-16 上午8:50:56 
 * @history
 * @department：研发部
 *
*/
package com.founder.zdry.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import com.founder.zdry.bean.ZdryGlpzpzb;
import com.founder.zdry.bean.ZdryJsmbpzb;
import com.founder.zdry.service.ZdryGlpzpzbService;
import com.founder.zdry.service.ZdryJsmbpzbService;

/******************************************************************************
 * @Package:      [com.founder.zdry.controller.ZdryGlpzpzbController.java]  
 * @ClassName:    [ZdryGlpzpzbController]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [xu_wenjun@founder.com.cn]  
 * @CreateDate:   [2015-3-16 上午8:50:56]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-3-16 上午8:50:56，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Controller
@RequestMapping("zdryGlpzpzb")
public class ZdryGlpzpzbController extends BaseController{
	
private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name="zdryGlpzpzbService")
	private ZdryGlpzpzbService zdryGlpzpzbService;
	
	@Resource(name="zdryJsmbpzbService")
	private ZdryJsmbpzbService zdryJsmbpzbService;
	
	/**
	 * 
	 * @Title: queryList
	 * @Description: 列表
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
			ZdryGlpzpzb entity, SessionBean sessionBean){
		sessionBean = getSessionBean(sessionBean);
		page.setPagePara(rows);
		return zdryGlpzpzbService.queryList(page, entity);
	}
	
	/**
	 * 
	 * @Title: add
	 * @Description: 配置  跳转
	 * @param @param id
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView add(@RequestParam(value="id",required=false)String id, SessionBean sessionBean) {
		ZdryGlpzpzb entity = new ZdryGlpzpzb();
		if(!StringUtils.isBlank(id)){
			entity = zdryGlpzpzbService.queryById(id);
		}
		ModelAndView mv = new ModelAndView("zdry/zdryGlpzpzbAdd");
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
	public ModelAndView save(ZdryGlpzpzb entity, SessionBean sessionBean){
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			if(StringUtils.isBlank(entity.getId())){
				zdryGlpzpzbService.insert(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "保存成功！");
			}else{
				zdryGlpzpzbService.update(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改成功！");
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
	 * @Title: check
	 * @Description: 根据类型代码判断是否存在
	 * @param @param zdrygllxdm
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return boolean    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	public @ResponseBody boolean check(String zdrygllxdm, SessionBean sessionBean){
		sessionBean = getSessionBean(sessionBean);
		boolean existFlag = false;
		try {
			ZdryGlpzpzb entity = zdryGlpzpzbService.queryByZdrygllxdm(zdrygllxdm);
			if(entity != null){
				existFlag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
		}
		return existFlag;
	}

}
