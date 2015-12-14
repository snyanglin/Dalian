package com.founder.syfw.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.annotation.RestfulAnnotation;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.syfw.bean.Czfwxxb;
import com.founder.syfw.service.CzfwzbService;
import com.founder.syfw.service.SyfwEditService;

import com.google.gson.Gson;

/**
 * ****************************************************************************
 * @Package:      [com.founder.syfw.controller.CzfwzbController.java]  
 * @ClassName:    [CzfwzbController]   
 * @Description:  [出租房屋管理控制器]   
 * @Author:       [weiwen]  
 * @CreateDate:   [2015-2-5 下午9:53:52]   
 * @UpdateUser:   [weiwen]   
 * @UpdateDate:   [2015-2-5 下午9:53:52，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Controller
@RequestMapping(value = "/czfw")
public class CzfwzbController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "czfwzbService")
	private CzfwzbService czfwzbService;
	
	@Resource(name="syfwEditService")
	private SyfwEditService syfwEditService;
	/**
	 * 添加 出租房屋子表
	 * @param id
	 * @param fwid
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView addCzfwzb(String id,String fwid) {
		ModelAndView mv = new ModelAndView("syfw/czfwzbAdd");
		Czfwxxb entity = null;
		if(!StringUtils.isEmpty(id))
			entity =  czfwzbService.queryCzfwxxb(id);
		else if(!StringUtils.isEmpty(fwid))
			entity =  czfwzbService.queryCzfwxxbByfwid(fwid);
		if(entity == null){
			entity = new Czfwxxb();
			entity.setFwid(fwid);
		}
		mv.addObject("entity", entity);
		return mv;
	}

	/**
	 * 
	 * @Title: saveCzfwzb
	 * @Description: TODO(新增)
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RestfulAnnotation(valiField="fwid,zazrr_xm,zazrr_id,zrs_qd_rq",serverId = "3")
	@RequestMapping(value = "", method = RequestMethod.POST)
	public @ResponseBody ModelAndView saveCzfwzb(Czfwxxb entity ,SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean); 
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("fwid", entity.getFwid());
			Czfwxxb czfwxxb = syfwEditService.czfwzb_query(map);
			if(null ==czfwxxb){
				czfwzbService.saveCzfwxxb(entity, sessionBean);
				model.put(AppConst.MESSAGES, "新增【出租房屋】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
				model.put(AppConst.STATUS, AppConst.SUCCESS);
			}else{
				model.put(AppConst.STATUS, AppConst.FAIL);
				model.put(AppConst.MESSAGES, "此房屋已经是出租房屋,不能再新增！");
			}
			
			
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}


	/**"
	 * 
	 * @Title: updateCzfwzb
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RestfulAnnotation(serverId = "3")
	@RequestMapping(value = "/{id}", method = {RequestMethod.POST,RequestMethod.PUT})
	public @ResponseBody ModelAndView updateCzfwzb(Czfwxxb entity,SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			czfwzbService.updateCzfwxxb(entity, sessionBean);
			model.put(AppConst.MESSAGES, "修改【出租房屋】成功！");
			model.put(AppConst.STATUS, AppConst.SUCCESS);
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getUpdateFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}

	/**
	 * v3
	 * @Title: deleteCzfwzb
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RestfulAnnotation(valiField="fwid",serverId = "3")
	@RequestMapping(value = "/{id}/delete", method = {RequestMethod.DELETE,RequestMethod.POST})
	public @ResponseBody ModelAndView deleteCzfwzb(Czfwxxb entity,SessionBean sessionBean ) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			czfwzbService.removeCzfwxxb(entity, sessionBean);
			model.put(AppConst.MESSAGES, "注销【出租房屋】成功！");
			model.put(AppConst.STATUS, AppConst.SUCCESS);
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES,getDeleteFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}

}
