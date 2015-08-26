/**********************************************************************   
 * <p>文件名：DxqzxhdsplController.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu.w@founder.com.cn 
 * @date 2015-5-15 上午8:51:54 
 * @history
 * @department：研发部
 *
*/
package com.founder.zafffwqz.controller;

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
import com.founder.framework.components.AppConst;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.zafffwqz.bean.*;
import com.founder.zafffwqz.service.DxqzxhdSplJbxxbService;
import com.founder.zafffwqz.vo.DxqzxhdSplVo;

/******************************************************************************
 * @Package:      [com.founder.zafffwqz.controller.DxqzxhdsplController.java]  
 * @ClassName:    [DxqzxhdsplController]   
 * @Description:  [大型群众性活动-审批类 controller]   
 * @Author:       [wu.w@founder.com.cn]  
 * @CreateDate:   [2015-5-15 上午8:51:54]   
 * @UpdateUser:   [way(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-15 上午8:51:54，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 * 
 * @review      : tian_chengwei@founder.com.cn
 * @reviewDate  : 20150604
 */

@Controller
@RequestMapping(value = "/dxqzxhdspl")
public class DxqzxhdsplController extends BaseController{
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name="dxqzxhdSplJbxxbService")
	private DxqzxhdSplJbxxbService jbxxService;
	
	/**
	 * @Title: queryList
	 * @Description: 查询大型活动
	 * @param @param page
	 * @param @param rows
	 * @param @param jbxx
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryList(EasyUIPage page,@RequestParam(value = "rows")Integer rows,DxqzxhdSplJbxxb jbxx){
		page.setPagePara(rows);
		return jbxxService.queryList(page, jbxx);
	}
	
	/**
	 * @Title: queryById
	 * @Description: 转入大型活动编辑页面
	 * @param @param hdid
	 * @param @param mainTabID
	 * @param @param mode
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView queryById(String hdid,String mainTabID,String mode){
		ModelAndView mv = new ModelAndView("zafffwqz/dxqzhdSplEdit");
		if("add".equals(mode))hdid=UUID.create();
		DxqzxhdSplVo vo=jbxxService.queryById(hdid);
		mv.addObject("hd",vo);
		mv.addObject("mode", mode);
		mv.addObject("mainTabID", mainTabID);
		return mv;
	}
	
	/**
	 * @Title: save
	 * @Description: 保存大型活动信息
	 * @param @param vo
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody ModelAndView saveDxhdSpl(DxqzxhdSplVo vo){
		ModelAndView mv = new ModelAndView("redirect:/forward/" + AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		try{
			
			jbxxService.saveDxhdSpl(vo,getSessionBean());
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "新增成功！");
			mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, "新增失败！");
			mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		}
		return mv;
	}
	
	/**
	 * @Title: update
	 * @Description: 修改大型活动信息
	 * @param @param vo
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody ModelAndView updateDxhdSpl(DxqzxhdSplVo vo){
		ModelAndView mv = new ModelAndView("redirect:/forward/" + AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		try{
			jbxxService.updateDxhdSpl(vo,getSessionBean());
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "更新成功！");
			mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, "更新失败！");
			mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		}
		return mv;
	}
	
	/**
	 * @Title: delete
	 * @Description: 注销大型活动信息
	 * @param @param hdid
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody ModelAndView deleteDxhdSpl(String hdid){
		ModelAndView mv = new ModelAndView("redirect:/forward/" + AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		try{
			jbxxService.deleteDxhdSpl(hdid,getSessionBean());
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
	
	/**
	 * @Title: uploadWS
	 * @Description: 活动文书上传
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/uploadWS", method = RequestMethod.GET)
	public ModelAndView uploadWS() {
		ModelAndView mv = new ModelAndView("zpfj/fjEdit");
		mv.addObject("lybm", "DXQZXHDSPL_JBXXB");
		mv.addObject("lyid", "WSXZ");
		mv.addObject("lyms", "大型群众性活动审批类-文书");
		mv.addObject("fileType", "");
		mv.addObject("fileOnly", 0);
		return mv;
	}

}
