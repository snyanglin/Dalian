package com.founder.xlff.controller;

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
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.utils.EasyUIPage;
import com.founder.xlff.bean.Fkzl;
import com.founder.xlff.bean.Zlqsfk;
import com.founder.xlff.service.ZlxfService;

/**
 * ****************************************************************************
 * @Package:      [com.founder.xlff.controller.ZlxfController.java]  
 * @ClassName:    [ZlxfController]   
 * @Description:  [指令下发]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-6-24 上午10:14:05]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-24 上午10:14:05，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Controller
@RequestMapping(value = "fkzl")
public class ZlxfController extends BaseController {
	
	@Resource(name = "zlxfService")
	private ZlxfService zlxfService;
	
	/**
	 * @Title: queryZlxfList
	 * @Description: TODO(指令下发查询列表)
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryZlxfList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryZlxfList(EasyUIPage page,
		   @RequestParam(value = "rows", required=false) Integer rows, 
		   Fkzl entity,
		   SessionBean sessionBean){
		sessionBean = getSessionBean(sessionBean);
		page.setPagePara(rows);
		return zlxfService.queryZlxfList(page, entity);
	}
	
	/**
	 * @Title: saveZlxf
	 * @Description: TODO(指令下发保存)
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveZlxf", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveZlxf(Fkzl entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			//保存指令下发表
			String zlid = zlxfService.saveZlxf(entity);
			//批量保存指令签收反馈表
			entity.setId(zlid);
			zlxfService.saveFkzlqsfk(entity, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * @Title: queryZlqsfkList
	 * @Description: TODO(指令签收反馈列表)
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryZlqsfkList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryZlqsfkList(EasyUIPage page,
		   @RequestParam(value = "rows", required=false) Integer rows, 
		   Fkzl entity,
		   SessionBean sessionBean){
		sessionBean = getSessionBean(sessionBean);
		//设置组织机构到bean，用于查询该组织机构下的指令
		entity.setXfdwdm(sessionBean.getUserOrgCode());
		page.setPagePara(rows);
		return zlxfService.queryZlqsfkList(page, entity);
	}
	
	/**
	 * @Title: updateZlqsfk
	 * @Description: TODO(指令签收操作-更新指令签收反馈表)
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/updateZlqsfk", method = RequestMethod.POST)
	public @ResponseBody ModelAndView updateZlqsfk(Zlqsfk entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zlxfService.updateZlqsfk(entity);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	
}