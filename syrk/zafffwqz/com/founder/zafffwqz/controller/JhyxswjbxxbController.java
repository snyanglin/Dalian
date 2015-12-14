/**********************************************************************   
 * <p>文件名：JhyxswjbxxbController.java </p>
 * <p>文件描述：TODO(集会游行示威控制类) 
 * @project_name：syrk
 * @author tian_chengwei@founder.com.cn 
 * @date 2015-5-18 下午1:09:24 
 * @history
 * @department：研发部
 *
*/
package com.founder.zafffwqz.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import jxl.common.Logger;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zafffwqz.bean.Jhyxswjbxxb;
import com.founder.zafffwqz.service.JhyxswjbxxbService;


/******************************************************************************
 * @Package:      [com.founder.zafffwqz.controller.JhyxswjbxxbController.java]  
 * @ClassName:    [JhyxswjbxxbController]   
 * @Description:  [集会游行示威控制类]   
 * @Author:       [tian_chengwei@founder.com.cn]  
 * @CreateDate:   [2015-5-21 下午4:18:15]   
 * @UpdateUser:   [lk(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-21 下午4:18:15，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 * 
 * @review      : wu.w@founder.com.cn
 * @reviewDate  : 20150604
 */
@Controller
@RequestMapping("/jhyxswjbxxb")
public class JhyxswjbxxbController extends BaseController {
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "jhyxswjbxxbService")
	private JhyxswjbxxbService jhyxswjbxxbService;
	
	/**
	 * 
	 * @Title: queryJhyxswjbxxb
	 * @Description: TODO(详细页面跳转)
	 * @param @param id
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryJhyxswjbxxb", method = RequestMethod.GET)
	public@ResponseBody
	ModelAndView queryJhyxswjbxxb(String id){
		ModelAndView mv = new ModelAndView("zafffwqz/jhyxswDetail");
		Jhyxswjbxxb entity = new Jhyxswjbxxb();
		if(!StringUtils.isBlank(id)){
		entity.setId(id);
		}
		entity = jhyxswjbxxbService.queryJhyxswjbxxb(entity);
		if(entity != null){
			mv.addObject("entity", entity);
		}
		return mv;
		
	}
	/**
	 * 
	 * @Title: addOrEditjhyxswjbxxb
	 * @Description: TODO(添加修改)
	 * @param @param id
	 * @param @param mainTabID
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/addJhyxswjbxxb", method = RequestMethod.GET)
	public ModelAndView addOrEditjhyxswjbxxb(String id,String mainTabID){
		ModelAndView mv = new ModelAndView("zafffwqz/jhyxswAdd");
		mv.addObject("mainTabID", mainTabID);
		Jhyxswjbxxb entity = new Jhyxswjbxxb();
		try{
		mv.addObject("entity", entity);
		if(id != null){
			entity.setId(id);
		}
		entity = jhyxswjbxxbService.queryJhyxswjbxxb(entity);
		if(entity != null){
			mv.addObject("entity", entity);
			
		}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return mv;
		
	}
	/**
	 * 
	 * @Title: saveJhyxswjbxxb
	 * @Description: TODO(添加保存)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveJhyxswjbxxb",method = RequestMethod.POST)
	public ModelAndView saveAfxxb(Jhyxswjbxxb entity){
		SessionBean sessionBean = getSessionBean();
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			if (entity.getId() == null || entity.getId().equals("")) {
				jhyxswjbxxbService.saveJhyxswjbxxb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【大型游行示威】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				jhyxswjbxxbService.updateJhyxswjbxxb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【大型游行示威】成功！");
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
	 * @Title: queryList
	 * @Description: TODO(分页查询跳转)
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryList",method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryList(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows,Jhyxswjbxxb entity){
		page.setPagePara(rows);
		return jhyxswjbxxbService.queryList(page, entity);
		
	}

}
