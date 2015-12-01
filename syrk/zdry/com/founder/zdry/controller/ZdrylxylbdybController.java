package com.founder.zdry.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zdry.bean.Zdrylxylbdyb;
import com.founder.zdry.service.ZdrylxylbdybService;

import com.google.gson.Gson;

/**
 * ****************************************************************************
 * @Package:      [com.founder.syrk.controller.ZdrylxylbdybController.java]  
 * @ClassName:    [ZdrylxylbdybController]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [lixiaoqin@founder.com.cn]  
 * @CreateDate:   [2015-1-23 上午11:10:25]   
 * @UpdateUser:   [zhangxijiu@founder.com.cn(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-2-3 上午9:57:25，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(添加添加、修改、删除方法 ,查询count方法)]  
 * @Version:      [v1.0]
 */

@Controller
@RequestMapping("/zdrylxylbdyb")
public class ZdrylxylbdybController extends BaseController {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "zdrylxylbdybService")
	private ZdrylxylbdybService zdrylxylbdybService;
	
	/***
	 * 
	 * @Title: queryList
	 * @Description:重点人员类型与类别对应管理列表
	 * @author zhangxijiu@founder.com.cn
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @return    
	 * @return EasyUIPage    
	 * @throws
	 */
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage list(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, Zdrylxylbdyb entity) {
		page.setPagePara(rows);
		return zdrylxylbdybService.queryList(page, entity);
	}
	/***
	 * 
	 * @Title: queryCount
	 * @Description:重点人员类型与类别对应管理列表
	 * @author zhangxijiu@founder.com.cn
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @return    
	 * @return EasyUIPage    
	 * @throws
	 */
	@RequestMapping(value = "/queryCount", method = RequestMethod.POST)
	public @ResponseBody long queryCount(Zdrylxylbdyb entity) {
		return zdrylxylbdybService.queryCount(entity);
	}
	
	/***
	 * 
	 * @Title: delete
	 * @Description:删除重点人员类型与类别对应关系
	 * @author zhangxijiu@founder.com.cn
	 * @param @param entity
	 * @param @return    
	 * @throws
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView DeleteZdrylxylbdyb(Zdrylxylbdyb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() != null) { // 注销
				zdrylxylbdybService.delete(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, getMessage("cancel.success"));
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
	
	/***
	 * 
	 * @Title: query
	 * @Description:查询重点人员类型与类别对应关系
	 * @author zhangxijiu@founder.com.cn
	 * @param @param entity
	 * @param @return    
	 * @throws
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView createZdrylxylbdyb(String id) {
		ModelAndView mv = new ModelAndView("zdry/ZdrylxylbdybAdd");
		Zdrylxylbdyb entity = new Zdrylxylbdyb();
		if (!StringUtils.isBlank(id)) {
			entity.setId(id);
			entity = zdrylxylbdybService.query(entity);
		}
		mv.addObject("entity", entity);
		return mv;
	}
	/***
	 * 
	 * @Title: queryCondition
	 * @Description:查询重点人员类型与类别对应关系
	 * @author zhangxijiu@founder.com.cn
	 * @param @param 
	 * @param @return    
	 * @throws
	 */
	
	@RequestMapping(value={"/queryCondition"}, method=RequestMethod.GET)
	public ModelAndView queryCondition() {
		ModelAndView mv = new ModelAndView("zdry/ZdrylxylbdyqueryCondition");
		return mv;
	}
	/***
	 * 
	 * @Title: saveZdrylxylbdyb
	 * @Description:新增和修改重点人员类型与类别对应关系
	 * @author zhangxijiu@founder.com.cn
	 * @param @param entity
	 * @param @return    
	 * @throws
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveZdrylxylbdyb(Zdrylxylbdyb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() == null || entity.getId().equals("")) {	
				String zdrylbdm = entity.getZdrylbdm();
				List<Zdrylxylbdyb> zdrylxylbdybList = zdrylxylbdybService.getisExist(zdrylbdm);
				if (zdrylxylbdybList.size() > 0) {
					Zdrylxylbdyb zdrylxylbdyb = zdrylxylbdybList.get(0);
					zdrylxylbdybService.delete(zdrylxylbdyb, sessionBean);
					zdrylxylbdybService.saveZdrylxylbdyb(entity, sessionBean);
					model.put(AppConst.STATUS, AppConst.SUCCESS);
					model.put(AppConst.MESSAGES, "新增【重点人员类型与类别对应】成功！");
					model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
				} else {
					zdrylxylbdybService.saveZdrylxylbdyb(entity, sessionBean);
					model.put(AppConst.STATUS, AppConst.SUCCESS);
					model.put(AppConst.MESSAGES, "新增【重点人员类型与类别对应】成功！");
					model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
				}
				
			} else {
				String zdrylbdm = entity.getZdrylbdm();
				List<Zdrylxylbdyb> zdrylxylbdybList = zdrylxylbdybService.getisExist(zdrylbdm);
				if (zdrylxylbdybList.size() > 0) {
					Zdrylxylbdyb zdrylxylbdyb = zdrylxylbdybList.get(0);
					zdrylxylbdybService.delete(zdrylxylbdyb, sessionBean);
					zdrylxylbdybService.updateZdrylxylbdyb(entity, sessionBean);
					model.put(AppConst.STATUS, AppConst.SUCCESS);
					model.put(AppConst.MESSAGES, "修改【重点人员类型与类别对应】成功！");
				}else {
					zdrylxylbdybService.updateZdrylxylbdyb(entity, sessionBean);
					model.put(AppConst.STATUS, AppConst.SUCCESS);
					model.put(AppConst.MESSAGES, "修改【重点人员类型与类别对应】成功！");
					
				}
				
			}

		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	/***
	 * 
	 * @Title: edit
	 * @Description:编辑重点人员类型与类别对应关系
	 * @author zhangxijiu@founder.com.cn
	 * @param @param 
	 * @param @return    
	 * @throws
	 */
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public ModelAndView edit(Zdrylxylbdyb entity) throws BussinessException {
		entity = zdrylxylbdybService.query(entity);
		if (entity == null) {
			throw new BussinessException("该数据不存在或已被注销！");
		}
		ModelAndView mv = new ModelAndView("zdry/ZdrylxylbdyEdit");
		mv.addObject("entity", entity);
		return mv;
	}
	
	/***
	 * 
	 * @Title: deletePatch
	 * @Description:批量删除重点人员类型与类别对应关系
	 * @author zhangxijiu@founder.com.cn
	 * @param @param Zdrylxylbdyb[] entityArray
	 * @param @return    
	 * @throws
	 */
	@RequestMapping(value="/deletePatch", method=RequestMethod.POST)
	public ModelAndView deletePatch(@RequestBody Zdrylxylbdyb[] entityArray) {
	ModelAndView mv = new ModelAndView("redirect:/forward/forword");
		Map model = new HashMap();
		SessionBean sessionBean = getSessionBean();
		try {
			zdrylxylbdybService.deletePatch(entityArray, sessionBean);
			model.put("status", "success");
			model.put("message", getDeleteSuccess());
		} catch (Exception e) {
			this.logger.error(e.getLocalizedMessage(), e);
			model.put("status", "error");
			model.put("message", getDeleteFail());
		}
		mv.addObject("message", new Gson().toJson(model));
		return mv;
	}
	
	/***
	 * 
	 * @Title: getisExist
	 * @Description:判断重点人员类型与类别对应关系
	 * @author zhangxijiu@founder.com.cn
	 * @param @param zdrylxdm,zdrylbdm
	 * @param @return  map  
	 * @throws
	 */
	
	@RequestMapping(value = "/getisExist", method = RequestMethod.POST)
	public @ResponseBody
	Map getisExist(String zdrylbdm) {
		Map<String, Object> model = new HashMap<String, Object>();
		List<Zdrylxylbdyb> zdrylxylbdyb = zdrylxylbdybService.getisExist(zdrylbdm);
		boolean sfzhflag = false;
		String zdrylx ="";
		if (zdrylxylbdyb.size() > 0&&zdrylxylbdyb!=null) {
			sfzhflag = true;
			for(int i=0;i<zdrylxylbdyb.size();i++){
				if(i==zdrylxylbdyb.size()-1){
					zdrylx+=zdrylxylbdyb.get(i).getZdrylxdm();
				}else {
					zdrylx+= zdrylxylbdyb.get(i).getZdrylxdm()+",";
				}
				
			}
		} else {
			sfzhflag = false;
		}
		model.put("sfzhflag", sfzhflag);
		model.put("zdrylxdm", zdrylx);
		return model;
	}
	
	@RequestMapping(value = "/getZdrylxdm", method = RequestMethod.POST)
	public @ResponseBody
	Map getZdrylxdm(String zdrylxdm) {
		Map<String, Object> model = new HashMap<String, Object>();
		List<Zdrylxylbdyb> zdrylxylbdybList = zdrylxylbdybService.queryZdrylbdm(zdrylxdm);
		boolean sfzhflag = false;
		String zdrylb="";
		if (zdrylxylbdybList.size() > 0&& zdrylxylbdybList!=null) {
			sfzhflag = true;
			for(int i=0;i<zdrylxylbdybList.size();i++){
				if(i==zdrylxylbdybList.size()-1){
					zdrylb+=zdrylxylbdybList.get(i).getZdrylbdm();
				}else {
					zdrylb+= zdrylxylbdybList.get(i).getZdrylbdm()+",";
				}
				
			}
		} else {
			sfzhflag = false;
		}
		
		model.put("sfzhflag", sfzhflag);
		model.put("zdrylbdm", zdrylb);
		return model;
	}
	
	
}

