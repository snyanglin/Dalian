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

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.zafffwqz.bean.Dsrxxzb;
import com.founder.zafffwqz.bean.DxqzxhdFspxxb;
import com.founder.zafffwqz.service.DsrxxzbService;
import com.founder.zafffwqz.service.DxqzxhdfsplService;

import com.google.gson.Gson;

/******************************************************************************
 * @Package:      [com.founder.zafffwqz.controller.DxqzxhdFspxxbController.java]  
 * @ClassName:    [DxqzxhdFspxxbController]   
 * @Description:  [大型群众性活动-非审批类：控制层]   
 * @Author:       [xu_haibo@founder.com.cn]  
 * @CreateDate:   [2015-5-21 上午9:25:07]   
 * @UpdateUser:   [haibo(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-21 上午9:25:07，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Controller
@RequestMapping(value = "/DxqzxhdFspxxb")
public class DxqzxhdFspxxbController extends BaseController {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name="DxqzxhdfsplService")
	private DxqzxhdfsplService dxqzxhdfsplService;
	

/**
 * 
 * @Title: dxhdfspInfo
 * @Description: TODO(跳转-大型活动非审批类详情)
 * @param @param id
 * @param @return    设定文件
 * @return ModelAndView    返回类型
 * @throws
 */
	@RequestMapping(value="/dxhdfspInfo",method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView dxhdfspInfo(String id){
		System.out.println("============走起========");
		ModelAndView mv = new ModelAndView("zafffwqz/dxqzxhdFspxxDetail");
		DxqzxhdFspxxb entity = new DxqzxhdFspxxb();
		String flag ="add";
		try {
			if(!"".equals(id)&&id!=null){
				entity.setId(id);
			}
			mv.addObject("entity", entity);
			entity = dxqzxhdfsplService.queryDxqzxhdFspxxb(entity);
			if(entity != null){
				mv.addObject("entity", entity);
				flag ="dxhdfspInfo";
			}
			mv.addObject("flag", flag);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
		
	}
	
	/**
	 * 
	 * @Title: addDxqzxhdFspxxb
	 * @Description: TODO(跳转添加页面)
	 * @param @param id
	 * @param @param DxqzxhdFspxxbid
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/addDxqzxhdFspxxb", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView addDxqzxhdFspxxb(String id,String DxqzxhdFspxxbid) {
		ModelAndView mv = new ModelAndView("zafffwqz/dxqzxhdFspxxadd");
		DxqzxhdFspxxb entity = new DxqzxhdFspxxb();
		String flag ="add";
		try {
			if(!"".equals(id)&&id!=null){
				entity.setId(id);
			}
			mv.addObject("entity", entity);
			mv.addObject("id", id);
			entity = dxqzxhdfsplService.queryDxqzxhdFspxxb(entity);
			if(entity != null){
				mv.addObject("entity", entity);
				flag ="update";
			}
			mv.addObject("flag", flag);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
/**
 * 
 * @Title: saveDxqzxhdFspxxb
 * @Description: TODO(保存-大型活动非审批类)
 * @param @param entity
 * @param @return    设定文件
 * @return ModelAndView    返回类型
 * @throws
 */
	@RequestMapping(value = "/saveDxqzxhdFspxxb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveDxqzxhdFspxxb(DxqzxhdFspxxb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() == null || entity.getId().equals("")) {
				if("".equals(entity.getId())||entity.getId()==null){
					entity.setId(UUID.create());
				}
				dxqzxhdfsplService.save(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【大型活动非审批信息】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				dxqzxhdfsplService.modifyFsp(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【大型活动非审批信息】成功！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		System.out.println(new Gson().toJson(model));
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
/**
 * 
 * @Title: DeleteDxqzxhdFspxxb
 * @Description: TODO(注销-大型活动非审批类)
 * @param @param entity
 * @param @return    设定文件
 * @return ModelAndView    返回类型
 * @throws
 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView DeleteDxqzxhdFspxxb(DxqzxhdFspxxb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() != null) { // 注销
				dxqzxhdfsplService.delete(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "注销【大型活动非审批信息】成功！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getMessage("cancel.fail"));
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
/**
 * 
 * @Title: queryList
 * @Description: TODO(分页查询)
 * @param @param page
 * @param @param rows
 * @param @param id
 * @param @param hdmc
 * @param @param hdgmbegin
 * @param @param hdgmend
 * @param @param jbdw
 * @param @param hdkssjbegin
 * @param @param hdkssjend
 * @param @param hdjssjbegin
 * @param @param hdjssjend
 * @param @return    设定文件
 * @return EasyUIPage    返回类型
 * @throws
 */
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryList(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, String id ,String hdmc, 
			String hdgmbegin,String hdgmend,String jbdw,String hdkssjbegin,String hdkssjend,String hdjssjbegin,String hdjssjend) {
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		Map map=new HashMap();
		if(!"".equals(id)&&id!=null){
			map.put("id", id);
		}else{
			map.put("id", null);
		}
		if(!"".equals(hdmc)&&hdmc!=null){
			map.put("hdmc", hdmc);
		}else{
			map.put("hdmc", null);
		}
		if(!"".equals(hdgmbegin)&&hdgmbegin!=null){
			map.put("hdgmbegin", hdgmbegin);
		}else{
			map.put("hdgmbegin", null);
		}
		if(!"".equals(hdgmend)&&hdgmend!=null){
			map.put("hdgmend", hdgmend);
		}else{
			map.put("hdgmend", null);
		}
		if(!"".equals(jbdw)&&jbdw!=null){
			map.put("jbdw", jbdw);
		}else{
			map.put("jbdw", null);
		}
		if(!"".equals(hdkssjbegin)&&hdkssjbegin!=null){
			map.put("hdkssjbegin", hdkssjbegin);
		}else{
			map.put("hdkssjbegin", null);
		}
		if(!"".equals(hdkssjend)&&hdkssjend!=null){
			map.put("hdkssjend", hdkssjend);
		}else{
			map.put("hdkssjend", null);
		}
		if(!"".equals(hdjssjbegin)&&hdjssjbegin!=null){
			map.put("hdjssjbegin", hdjssjbegin);
		}else{
			map.put("hdjssjbegin", null);
		}
		if(!"".equals(hdjssjend)&&hdjssjend!=null){
			map.put("hdjssjend", hdjssjend);
		}else{
			map.put("hdjssjend", null);
		}
		map.put("xt_lrrbmid", sessionBean.getUserOrgCode());
		
		return dxqzxhdfsplService.queryList(page, map);
	}
}
