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
package com.founder.sydw.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.annotation.RestfulAnnotation;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.utils.EasyUIPage;
import com.founder.sydw.bean.Dwbacyqkxxb;
import com.founder.sydw.bean.Dwxyaqxxb;
import com.founder.sydw.bean.DwjbxxbBay;
import com.founder.sydw.service.DwxyaqBayService;
import com.founder.sydw.service.DwxyaqService;
import com.founder.syrkgl.bean.RyRyjbxxb;
import com.founder.syrkgl.service.RyRyjbxxbService;
import com.founder.syrkgl.vo.SyrkZtxx;

import com.google.gson.Gson;

/******************************************************************************
 * @Package:      [com.founder.sydw.controller.DwxyaqxxbBayController.java]  
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
@RequestMapping("/dwxyaqxxbBay")
public class DwxyaqxxbBayController extends BaseController {
	private Logger logger = Logger.getLogger(this.getClass());
	@Resource(name = "dwxyaqBayService")
	private DwxyaqBayService dwxyaqBayService;
	
	@Resource(name = "dwxyaqService")
	private DwxyaqService dwxyaqService;
	
	@Resource(name = "ryRyjbxxbService")
	private RyRyjbxxbService ryRyjbxxbService;
	
	/**
	 * 跳转
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/createPage", method = RequestMethod.GET)
	public ModelAndView creatPage(String id,String dwid){
		ModelAndView mv = new ModelAndView("sydw/dwxyaqxxbBayAdd");
		DwjbxxbBay entity = new DwjbxxbBay();
		if(null!=id&&!"".equals(id)){
			entity.setId(id);
			entity = dwxyaqBayService.query(id);
		}
		entity.setDwid(dwid);
		mv.addObject("entity", entity);
		return mv;
	}
	
	/**
	 * 跳转
	 * @Title: createZxPage
	 * @Description: 首页工作代办-注销页面
	 * @param id
	 * @param dwid
	 * @return
	 * @return ModelAndView返回类型
	 * @throws
	 */
	@RequestMapping(value = "/createZxPage", method = RequestMethod.GET)
	public ModelAndView createZxPage(String id){
		ModelAndView mv = new ModelAndView("sydw/dwxyaqxxbBayZx");
		DwjbxxbBay entity = new DwjbxxbBay();
		entity = dwxyaqBayService.query(id);
	    if(entity == null){
		   entity =new DwjbxxbBay();
	   	}
		mv.addObject("entity", entity);
		return mv;
	}
	
	/**
	 * 保存、修改
	 * @param jgdxpsjdb
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(DwjbxxbBay entity){
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
	
	/**
	 * 
	 * @Title: savemessage
	 * @Description: 保安员注销情况-添加首页工作待办记录
	 * @param entity
	 * @return void返回类型
	 * @throws
	 */
	@RequestMapping(value = "/savemessage", method = RequestMethod.POST)
	public @ResponseBody 
	String savemessage(String xm, String id, SessionBean sessionBean) {
		sessionBean = getSessionBean(sessionBean);
		DwjbxxbBay entity = new DwjbxxbBay();
		entity.setXm(xm);
		entity.setId(id);
		dwxyaqBayService.savemessage(entity, sessionBean);
		return "success";	
	}
	
	
	
	@RequestMapping(value = "/baryxxb_query_more", method = RequestMethod.GET)
	public ModelAndView baryxxb_query_more(String dwid,String mode){
		ModelAndView mv = new ModelAndView("sydw/baryxxbDetail");
		mv.addObject("dwid", dwid);
		mv.addObject("mode", mode);
		return mv;
	}
	
	@RequestMapping(value = "/baryxxb_query_all", method = RequestMethod.POST)
	@ResponseBody
	public EasyUIPage baryxxb_query_all(EasyUIPage page, Integer rows, String condition, String dwid){
		page.setPagePara(rows);
		return dwxyaqBayService.baryxxb_query_all(page, condition, dwid);
	}
	
	@RequestMapping(value = "/baryxxb_query_all_count", method = RequestMethod.POST)
	@ResponseBody
	public long baryxxb_query_all_count(EasyUIPage page, Integer rows, String condition, String dwid){
		return dwxyaqBayService.baryxxb_query_all_count(condition, dwid);
	}
	
	/**
	 * 
	 * @Title: dataApply
	 * @Description: 查询证件号码有或无，进行信息回填
	 * @param cyzjdm
	 * @param zjhm
	 * @param sessionBean
	 * @return
	 * @return Map返回类型
	 * @throws
	 */
	@RequestMapping(value = "/dataApply", method = RequestMethod.POST)
	public @ResponseBody
	Map dataApply(String cyzjdm, String zjhm, SessionBean sessionBean) {
		Map<String, Object> map = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
        DwjbxxbBay entity = dwxyaqBayService.getBayxx(zjhm);
    	if (entity == null) {
    		entity = new DwjbxxbBay();
    		RyRyjbxxb ryRyjbxxb = ryRyjbxxbService.dataApply(cyzjdm, zjhm,
    				sessionBean);
    		if (ryRyjbxxb == null) {
    			ryRyjbxxb = new RyRyjbxxb();
    		}
    		SyrkZtxx ztxx = ryRyjbxxbService.getZtxx(zjhm);
            if(StringUtils.isNotBlank(ztxx.getZtrysfzh())){
        		map.put("ztxx", ztxx);
            }
    		map.put("ryRyjbxxb", ryRyjbxxb);
		}
		map.put("entity", entity);
		return map;
	}
}
