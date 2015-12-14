/**********************************************************************   
 * <p>文件名：DwxyaqxxbBayController.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu_chunhui@founder.com.cn 
 * @date 2014-12-4 下午03:06:20 
 * @history
 * @department：研发部
 *
*/
package com.founder.sydw_dl.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.sydw_dl.bean.Dwxyaqxxb;
import com.founder.sydw_dl.bean.DwxyaqxxbBay;
import com.founder.sydw_dl.service.DwxyaqBayService;
import com.founder.sydw_dl.service.DwxyaqService;

import com.google.gson.Gson;

/******************************************************************************
 * @Package:      [com.founder.sydw_dl.controller.DwxyaqxxbBayController.java]  
 * @ClassName:    [DwxyaqxxbBayController]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2014-12-4 下午03:06:20]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2014-12-4 下午03:06:20，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Controller
@RequestMapping("/dwxyaqxxbBay_dl")
public class DwxyaqxxbBayController extends BaseController {
	private Logger logger = Logger.getLogger(this.getClass());
	@Resource(name = "dwxyaqBayService")
	private DwxyaqBayService dwxyaqBayService;
	@Resource(name = "dwxyaqService")
	private DwxyaqService dwxyaqService;
	
	/**
	 * 跳转
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/createPage", method = RequestMethod.GET)
	public ModelAndView creatPage(String id,String dwid){
		ModelAndView mv = new ModelAndView("sydw_dl/dwxyaqxxbBayAdd");
		DwxyaqxxbBay entity = new DwxyaqxxbBay();
		if(null!=id&&!"".equals(id)){
			entity.setId(id);
			entity = dwxyaqBayService.query(id);
		}
		Dwxyaqxxb dwxyaqxxb =dwxyaqService.queryByDwid(dwid);
		entity.setXyid(dwxyaqxxb.getId());
		mv.addObject("entity", entity);
		return mv;
	}
	
	/**
	 * 保存、修改
	 * @param jgdxpsjdb
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(DwxyaqxxbBay entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		if (entity.getId() == null || entity.getId().equals("")) {
			try {
				dwxyaqBayService.save(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【保安员】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
				
			} catch (Exception e) {
				logger.error(e.getLocalizedMessage(), e);
				model.put(AppConst.STATUS, AppConst.FAIL);
				model.put(AppConst.MESSAGES, getAddFail());
			}

		} else {
			try {
				dwxyaqBayService.update(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【保安员】成功！");
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
