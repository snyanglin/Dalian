/**********************************************************************   
 * <p>文件名：AqffXcXcjyController.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu.w@founder.com.cn 
 * @date 2015-5-25 上午9:51:22 
 * @history
 * @department：研发部
 *
*/
package com.founder.aqff.controller;

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

import com.founder.aqff.bean.AqffXcXcjyxxb;
import com.founder.aqff.service.AqffXcXcjyService;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.components.AppConst;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;

/******************************************************************************
 * @Package:      [com.founder.aqff.controller.AqffXcXcjyController.java]  
 * @ClassName:    [AqffXcXcjyController]   
 * @Description:  [宣传教育]   
 * @Author:       [wu.w@founder.com.cn]  
 * @CreateDate:   [2015-5-25 上午9:51:22]   
 * @UpdateUser:   [way(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-25 上午9:51:22，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 * @review      : tian_chengwei@founder.com.cn
 * @reviewDate  : 20150604
 */
@Controller
@RequestMapping("/aqffxcjy")
public class AqffXcXcjyController extends BaseController {
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "aqffxcjyService")
	private AqffXcXcjyService xcjyService;
	
	/**
	 * @Title: queryList
	 * @Description: querylist
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryList(EasyUIPage page,@RequestParam(value = "rows")Integer rows,AqffXcXcjyxxb entity){
		page.setPagePara(rows);
		return xcjyService.query(page, entity);
	}
	
	/**
	 * @Title: edit
	 * @Description: save or modify by id isExist
	 * @param @param entity
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView editXcjy(AqffXcXcjyxxb entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/" + AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		if(StringUtils.isBlank(entity.getId())){
			try{
				xcjyService.saveXcjy(entity, getSessionBean());
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增成功！");
				mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
			}catch(Exception e){
				logger.error(e.getLocalizedMessage(), e);
				model.put(AppConst.STATUS, AppConst.FAIL);
				model.put(AppConst.MESSAGES, "新增失败！");
				mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
			}
		}else{
			try{
				xcjyService.updateXcjy(entity, getSessionBean());
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "更新成功！");
				mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
			}catch(Exception e){
				logger.error(e.getLocalizedMessage(), e);
				model.put(AppConst.STATUS, AppConst.FAIL);
				model.put(AppConst.MESSAGES, "更新失败！");
				mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
			}
		}
		return mv;
	}
	
	/**
	 * @Title: delete
	 * @Description: delete
	 * @param @param id
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody ModelAndView delete(String id){
		ModelAndView mv = new ModelAndView("redirect:/forward/" + AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		try{
			xcjyService.deleteXcjy(id,getSessionBean());
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "注销成功！");
			mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, "注销失败！");
			mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		}
		return mv;
	}
}
