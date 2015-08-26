package com.founder.sydw.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.components.AppConst;
import com.founder.framework.utils.ComboBox;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.sydw.bean.DwOwnXFBean;
import com.founder.sydw.bean.Dwcyjcrwxxb;
import com.founder.sydw.bean.Dwcyxxb;
import com.founder.sydw.bean.Xfdwcccsxxb;
import com.founder.sydw.service.CyjhService;
import com.founder.sydw.service.DwcyService;

import com.google.gson.Gson;
/**
 * ****************************************************************************
 * @Package:      [com.founder.sydw.controller.CyjhController.java]  
 * @ClassName:    [CyjhController]   
 * @Description:  抽样计划
 * @Author:       [yu_guangli@founder.com.cn]  
 * @CreateDate:   [2015-7-6 上午9:30:39]   
 * @UpdateUser:   [yuguangli(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-7-6 上午9:30:39，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Controller
@RequestMapping(value = "cyjh")
public class CyjhController extends BaseController {
	@Resource(name = "cyjhService")
	private CyjhService cyjhService;
	
	@Resource(name = "dwcyService")
	private DwcyService dwcyService;
	
	/**
	 * 
	 * @Title: queryXfdwlxByJbdwlb
	 * @Description: 按照消防监管类别统计本辖区消防单位数量
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryXfdwlxByJbdwlb", method = RequestMethod.GET)
	public @ResponseBody ModelAndView queryXfdwlxByJbdwlb() {
		ModelAndView mv = new ModelAndView("sydw/ndcyzjhlb");
		SessionBean sessionBean = getSessionBean();
		Map<String, Object> param = new HashMap<String,Object>();
		param.put("glbmid", sessionBean.getUserOrgCode());
		param.put("glpcsid", sessionBean.getExtendValue("ssPcsCode"));
		param.put("glfxjid", sessionBean.getExtendValue("ssFsxCode"));
		Map<String, Object> retmap = cyjhService.queryXfdwlxByJbdwlb(param);
		mv.addObject("entity", retmap);
		return mv;
	}
	/**
	 * 添加
	 * @param id
	 * @param dwid
	 * @return
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public @ResponseBody ModelAndView edit(String id) {
		ModelAndView mv = new ModelAndView("sydw/xfdwcccsxxbAdd");
		Xfdwcccsxxb entity = new Xfdwcccsxxb();
		entity.setId(id);
		if (!StringUtils.isBlank(id)) {
			entity = cyjhService.queryXfdwcccsxxb(entity);
		}else{
			entity.setZzjcrs("1");
			entity.setJzjcrs("0");
			entity.setZddwzccdwdbfb("90");
		}
		mv.addObject("entity", entity);
		return mv;
	}
	
	/**
	 * 
	 * @Title: saveXfdwcccsxxb
	 * @Description: 保存消防单位抽查参数配置
	 * @param @param entity
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveXfdwcccsxxb", method = RequestMethod.POST)
	public ModelAndView saveXfdwcccsxxb(Xfdwcccsxxb entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/"+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		if(null==entity.getId()||"".equals(entity.getId())){
			cyjhService.saveXfdwcccsxxb(entity, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, getAddSuccess());
			model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
		}else{
			cyjhService.modifyXfdwcccsxxb(entity, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, getUpdateSuccess());
			model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}

	/**
	 * 
	 * @Title: deleteXfdwcccsxxb
	 * @Description: 删除消防单位抽查参数配置
	 * @param @param entity
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/deleteXfdwcccsxxb", method = RequestMethod.POST)
	public ModelAndView deleteXfdwcccsxxb(Xfdwcccsxxb entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/"+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		Dwcyxxb dwcyxxb = new Dwcyxxb();
		dwcyxxb.setXfdwcccsxxbid(entity.getId());
		dwcyxxb.setXt_zxbz("0");
		List<Dwcyxxb> list = dwcyService.queryXfdwcyxxbList(dwcyxxb);
		if(list==null||list.size()==0){
			cyjhService.deleteXfdwcccsxxb(entity, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, getDeleteSuccess());
			mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		}else{
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, "数据已引用不能删除!");
			mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		}
		return mv;
	}
	/**
	 * 
	 * @Title: queryXfdwcccsxxbForPage
	 * @Description: 分页查询消防单位抽查参数配置
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryXfdwcccsxxbForPage", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryXfdwcccsxxbForPage(EasyUIPage page, @RequestParam(value = "rows")Integer rows,Xfdwcccsxxb entity){
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		BaseService.setSaveProperties(entity, sessionBean);
		return cyjhService.queryXfdwcccsxxbForPage(page, entity);
	}
	
	@RequestMapping(value = "/querynf", method = RequestMethod.GET)
	public @ResponseBody List<ComboBox> querynf() {
		Calendar cal=Calendar.getInstance();
		int year=cal.get(Calendar.YEAR);
		
		List<ComboBox> res = new ArrayList<ComboBox>();
	    for(int i=year;i<=year+1;i++){
	    	SessionBean sessionBean = getSessionBean();
	    	Xfdwcccsxxb entity = new Xfdwcccsxxb();
			BaseService.setSaveProperties(entity, sessionBean);
			entity.setNf(String.valueOf(i));
			entity.setXt_zxbz("0");
			entity = cyjhService.queryXfdwcccsxxb(entity);
			if(entity==null){
				ComboBox box = new ComboBox();
		    	box.setId(String.valueOf(i));
				box.setText(String.valueOf(i)+"年");
				res.add(box);
			}
	    }
		return res;
	}
	
	/**
	 * @Title: queryXfdwcyxxbForPage
	 * @Description: 分页查询消防单位抽样信息
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryXfdwcyxxbForPage", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryXfdwcyxxbForPage(EasyUIPage page, @RequestParam(value = "rows")Integer rows,Dwcyxxb entity,String id){
		entity.setXfdwcccsxxbid(id);
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		BaseService.setSaveProperties(entity, sessionBean);
		return dwcyService.queryXfdwcyxxbForPage(page, entity);
	}
	
	/**
	 * 
	 * @Title: queryXfdwcyxxbForPage
	 * @Description: 查询消防单位抽样信息列表不分页
	 * @param @param entity
	 * @param @param id
	 * @param @return    设定文件
	 * @return List<Dwcyxxb>    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryXfdwcyxxbList", method = RequestMethod.POST)
	public @ResponseBody List<Dwcyxxb> queryXfdwcyxxbList(Dwcyxxb entity){
		SessionBean sessionBean = getSessionBean();
		BaseService.setSaveProperties(entity, sessionBean);
		entity.setXt_zxbz("0");
		List<Dwcyxxb> list = dwcyService.queryXfdwcyxxbList(entity);
		return list;
	}
	/**
	 * 
	 * @Title: deleteXfdwcyxxb
	 * @Description: 删除消防单位单次抽样信息
	 * @param @param entity
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/deleteXfdwcyxxb", method = RequestMethod.POST)
	public ModelAndView deleteXfdwcyxxb(Dwcyxxb entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/"+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("xt_zxbz", "1");
		map.put("ccrwid", entity.getId());
		List<Dwcyjcrwxxb> list = cyjhService.queryDwcyjcrwxxbsByRwid(map);
		if(list!=null&&list.size()>0){
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, "数据已引用不能删除!");
			mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		}else{
			dwcyService.deleteXfdwcyxxb(entity, sessionBean);
			entity.setXt_lrrid(sessionBean.getUserId());
			String cs =dwcyService.querycccs(entity);
			int ss = 0;
			if(cs == null||cs==""||cs.equals(" ")||cs.equals("null")){
				cs="0";
			}
			ss = Integer.parseInt(cs);
			ss = ss+1;
			model.put("cs", ss);
			entity.setXt_zxbz("1");
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, getDeleteSuccess());
			mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		}
		return mv;
	}
	/**
	 * 
	 * @Title: saveXfdwcyxxb
	 * @Description: 消防单位单次抽样信息
	 * @param @param entity
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveXfdwcyxxb", method = RequestMethod.POST)
	public ModelAndView saveXfdwcyxxb(Dwcyxxb entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/"+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		if(null==entity.getId()||"".equals(entity.getId())){
			Dwcyxxb entitycs = new Dwcyxxb();
			entitycs.setXt_lrrid(sessionBean.getUserId());
			entitycs.setXfdwcccsxxbid(entity.getXfdwcccsxxbid());
			String cs =dwcyService.querycccs(entitycs);
			int ss = 0;
			if(cs == null||cs==""||cs.equals(" ")||cs.equals("null")){
				cs="0";
			}
			ss = Integer.parseInt(cs);
			ss = ss+1;
			entity.setCccs(String.valueOf(ss));
			dwcyService.saveXfdwcyxxb(entity, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, getAddSuccess());
			model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
		}else{
			dwcyService.modifyXfdwcyxxb(entity, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, getUpdateSuccess());
			model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * 跳转单次抽查页面
	 * @param id
	 * @param dwid
	 * @return
	 */
	@RequestMapping(value = "/todwcy", method = RequestMethod.GET)
	public @ResponseBody ModelAndView todwcy(String id) {
		SessionBean sessionBean = getSessionBean();
		ModelAndView mv = new ModelAndView("sydw/dccy");
		Xfdwcccsxxb entity = new Xfdwcccsxxb();
		Dwcyxxb entitycs = new Dwcyxxb();
		entity.setId(id);
		if (!StringUtils.isBlank(id)) {
			entity = cyjhService.queryXfdwcccsxxb(entity);
			//查询抽查次数
			entitycs.setXt_lrrid(sessionBean.getUserId());
			entitycs.setXfdwcccsxxbid(entity.getId());
			String cs =dwcyService.querycccs(entitycs);
			int ss = 0;
			if(cs == null||cs==""||cs.equals(" ")||cs.equals("null")){
				cs="0";
			}
			ss = Integer.parseInt(cs);
			ss = ss+1;
			entitycs.setCccs(String.valueOf(ss));
		}
		mv.addObject("entity", entity);
		mv.addObject("entitycs", entitycs);
		Map<String, Object> param = new HashMap<String,Object>();
		param.put("glbmid", sessionBean.getUserOrgCode());
		param.put("glpcsid", sessionBean.getExtendValue("ssPcsCode"));
		param.put("glfxjid", sessionBean.getExtendValue("ssFsxCode"));
		Map<String, Object> retmap = cyjhService.queryXfdwlxByJbdwlb(param);
		mv.addObject("entitydws", retmap);
		return mv;
	}
	
	/**
	 * 
	 * @Title: queryDwcyjcrwxxbForPage
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryDwcyjcrwxxbForPage", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryDwcyjcrwxxbForPage(EasyUIPage page, @RequestParam(value = "rows")Integer rows,Dwcyjcrwxxb entity){
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		BaseService.setSaveProperties(entity, sessionBean);
		entity.setFpryid(sessionBean.getUserId());
		return cyjhService.queryDwcyjcrwxxbForPage(page, entity);
	}
	
	/**
	 * 
	 * @Title: modifyDwcyjcrwxxb
	 * @Description: 修改单位抽样检查任务
	 * @param @param entity
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/modifyDwcyjcrwxxb", method = RequestMethod.POST)
	public ModelAndView modifyDwcyjcrwxxb(Dwcyjcrwxxb entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/"+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		cyjhService.modifyDwcyjcrwxxb(entity, sessionBean);
		model.put(AppConst.STATUS, AppConst.SUCCESS);
		model.put(AppConst.MESSAGES, getUpdateSuccess());
		model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * 跳转添加抽查页面
	 * @param id
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/todwcyadd", method = RequestMethod.GET)
	public @ResponseBody ModelAndView todwcyadd(String id,String cyid,String mainTabID) {
		ModelAndView mv = new ModelAndView("sydw/dccyAdd");
		Dwcyxxb entity = new Dwcyxxb();
		entity.setId(id);
		entity.setXfdwcccsxxbid(cyid);
		if (!StringUtils.isBlank(id)) {
			entity = dwcyService.queryXfdwcyxxb(entity);
		}
		Xfdwcccsxxb entitycs = new Xfdwcccsxxb();
		entitycs.setId(id);
		if (!StringUtils.isBlank(id)) {
			entitycs = cyjhService.queryXfdwcccsxxb(entitycs);
		}
		mv.addObject("entitycs", entitycs);
		mv.addObject("entity", entity);
		SessionBean sessionBean = getSessionBean();
		Map<String, Object> param = new HashMap<String,Object>();
		param.put("glbmid", sessionBean.getUserOrgCode());
		param.put("glpcsid", sessionBean.getExtendValue("ssPcsCode"));
		param.put("glfxjid", sessionBean.getExtendValue("ssFsxCode"));
		Map<String, Object> retmap = cyjhService.queryXfdwlxByJbdwlb(param);
		mv.addObject("entitydws", retmap);
		mv.addObject("mainTabID", mainTabID);
		return mv;
	}

}
