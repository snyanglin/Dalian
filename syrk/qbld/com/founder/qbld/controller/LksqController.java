package com.founder.qbld.controller;

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
import com.founder.qbld.bean.Lksqb;
import com.founder.qbld.service.LksqService;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.controller.LksqController.java]  
 * @ClassName:    [LksqController]   
 * @Description:  [临控申请控制器]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-5-14 上午9:43:31]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-14 上午9:43:31，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Controller
@RequestMapping(value = "lksq")
public class LksqController extends BaseController {
	
	@Resource(name = "lksqService")
	private LksqService lksqService;
	
	/**
	 * @Title: queryCkyjList
	 * @Description: TODO(临控申请表查询)
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryLksqList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryCkyjList(EasyUIPage page,
			@RequestParam(value = "rows", required=false) Integer rows, 
			Lksqb entity,
			SessionBean sessionBean){
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		entity.setBc_fbr(sessionBean.getUserName());
		entity.setBc_fbrsfzh(sessionBean.getUserId());
		return lksqService.queryLksqList(page, entity);
	}
	
	/**
	 * @Title: queryCkyjCount
	 * @Description: TODO(临控预警信息总数查询/历史预警信息总数查询)
	 * @param entity
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryLksqListCount", method = RequestMethod.POST)
	public @ResponseBody long queryLksqListCount(Lksqb entity, SessionBean sessionBean){
		sessionBean = getSessionBean(sessionBean);
		entity.setSqrxm(sessionBean.getUserName());
		entity.setSqrsfhm(sessionBean.getUserId());
		return lksqService.queryLksqListCount(entity);
	}
	
	/**
	 * @Title: queryLksq
	 * @Description: TODO(临控申请详情查询服务)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Lksqb    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryLksq", method = RequestMethod.POST)
	public @ResponseBody Lksqb queryLksq(Lksqb entity){
		return lksqService.queryLksqb(entity);
	}
	
	/**
	 * @Title: saveCjxxb
	 * @Description: TODO(申请临控)
	 * @param entity
	 * @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveLksqb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveLkyjxxb(Lksqb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			lksqService.saveLksqb(entity, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
}