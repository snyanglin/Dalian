/**********************************************************************   
 * <p>文件名：DwaqycyqkxxbController.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author liang_lihe@founder.com.cn 
 * @date 2015-7-8 下午2:18:02 
 * @history
 * @department：研发部
 *
*/
package com.founder.sydw.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.ws.rs.core.Request;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.sydw.bean.Dwbacyqkxxb;
import com.founder.sydw.bean.DwjbxxbBay;
import com.founder.sydw.service.DwbaycyqkxxbService;
import com.founder.sydw.service.DwxyaqBayService;


/******************************************************************************
 * @Package:      [com.founder.sydw.controller.DwaqycyqkxxbController.java]  
 * @ClassName:    [DwaqycyqkxxbController]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [liang_lihe@founder.com.cn]  
 * @CreateDate:   [2015-7-8 下午2:18:02]   
 * @UpdateUser:   [lk(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-7-8 下午2:18:02，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Controller
@RequestMapping("/dwbaycyqkxxb")
public class DwbaycyqkxxbController extends BaseController{
	private Logger logger = Logger.getLogger(this.getClass());
   
	@Resource(name = "dwbaycyqkxxbService")
	private DwbaycyqkxxbService dwbaycyqkxxbService;
	
	@Resource(name = "dwxyaqBayService")
	private DwxyaqBayService dwxyaqBayService;
	
	/**
	 * 
	 * @Title: creatPage
	 * @Description: 安全员从业情况添加、修改页面
	 * @param id
	 * @param dwid
	 * @return
	 * @return ModelAndView返回类型
	 * @throws
	 */
	@RequestMapping(value = "/createPage", method = RequestMethod.GET)
	public ModelAndView creatPage(String id,String dwid){
		ModelAndView mv = new ModelAndView("sydw/dwbaycyqkxxbAdd");
		Dwbacyqkxxb entity = new Dwbacyqkxxb();
		DwjbxxbBay entity_b = new DwjbxxbBay();
		entity = dwbaycyqkxxbService.query(id);
		entity_b = dwxyaqBayService.query(id);
	    if(entity == null){
		   entity =new Dwbacyqkxxb();
		   entity.setDwxh(dwid);
		   entity.setBaybm(id);
		   entity.setBacyxxbm(entity_b.getBayzbh());
	   	}
	    entity.setBacyxxbm(entity_b.getBayzbh());
		mv.addObject("entity", entity);
		return mv;
	}
	
	/**
	 * 
	 * @Title: save
	 * @Description: 保存、修改
	 * @Description: ID为空时表示进入添加功能、ID不为空时表示进入修改功能
	 * @param entity
	 * @return
	 * @return ModelAndView返回类型
	 * @throws
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(Dwbacyqkxxb entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		if (entity.getId() == null || entity.getId().equals("")) {
			try {
				dwbaycyqkxxbService.save(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【保安员从业情况】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
				
			} catch (Exception e) {
				logger.error(e.getLocalizedMessage(), e);
				model.put(AppConst.STATUS, AppConst.FAIL);
				model.put(AppConst.MESSAGES, getAddFail());
			}

		} else {
			try {
				dwbaycyqkxxbService.update(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【保安员从业情况】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); 
			} catch (Exception e) {
				logger.error(e.getLocalizedMessage(), e);
				model.put(AppConst.STATUS, AppConst.FAIL);
				model.put(AppConst.MESSAGES, getUpdateFail());
			}
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
}
