package com.founder.spsxt.controller;



import java.util.HashMap;
import java.util.List;
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

import com.founder.spsxt.bean.Spjkxt;
import com.founder.spsxt.service.SpjkxtService;
import com.founder.spsxt.vo.SpsxtZBVO;


import com.google.gson.Gson;

@Controller
@RequestMapping(value = "spjkxt")
public class SpjkxtController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name="spjkxtService")
	private SpjkxtService spjkxtService;

	//根据主键查询实体对象
	@RequestMapping(value = "/queryByXh",  method = RequestMethod.GET)
	public ModelAndView query(@RequestParam(value = "xh") Integer xh) {
		ModelAndView mv = new ModelAndView("jfxt/spjkxtAdd");		
		Spjkxt spjkxt=spjkxtService.querySpjkxtByXh(xh);
		System.out.println("根据主键查询实体对象成功！");
		mv.addObject("entity",spjkxt);
		return mv;
	}
	//根据主键删除实体对象
	@RequestMapping(value = "/deleteSpjkxtByXh", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam(value = "xh") String xh) {		
		System.out.println("删除视监控系统：xh="+xh);
		ModelAndView mv = new ModelAndView("jfxt/spjkxtDelete");//返回到删除(列表)页面
		String affectedRow=spjkxtService.deleteSpjkxtByXh(xh);
		System.out.println("affectedRow="+affectedRow);
		return mv;
	}
	
	
	//分页查询本人录入的信息
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryList(EasyUIPage page,@RequestParam(value = "rows") Integer rows) {
		System.out.println("rows="+rows+","+page.getBegin()+","+page.getEnd());
		System.out.println("sort,"+page.getSort()+","+page.getOrder());
		
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();		
		String pcsbm=sessionBean.getUserOrgCode();//派出所编码
		String policeId=sessionBean.getUserId();//民警警号
		
		Map map=new HashMap();
		//map.put("xt_lrrbmid", sessionBean.getUserOrgCode());
		map.put("pcsbm", pcsbm);//派出所编码
		map.put("policeId", policeId);//民警警号
		System.out.println("分页查询开始");
		return spjkxtService.queryList(page, map);
	}

	
	
	/*
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage list(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, Jlx jlx) {
		page.setPagePara(rows);
		return spjkxtService.list(page, jlx);
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public @ResponseBody
	List<ComboBox> search(String q) {
		return spjkxtService.searchJlx(q);
	}
*/
	/*
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addJlx() {
		ModelAndView mv = new ModelAndView("bzdz/bzdzAdd");
		mv.addObject("userId", "weiwen");
		return mv;
	}
	*/
/*
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editJlx(Jlx jlx) {
		ModelAndView mv = new ModelAndView("bzdz/bzdzEdit");
		Jlx jlxData = spjkxtService.selectJlx(jlx);
		mv.addObject("userId", "weiwen");
		mv.addObject("jlx", jlxData);
		return mv;
	}
	*/
	
	//新增或修改
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveSpjkxt(Spjkxt spjkxt) {
		System.out.println("技术人员姓名："+spjkxt.getJsryxm()+","+spjkxt.getXh());
		ModelAndView mv = new ModelAndView("redirect:/forward/"	+ AppConst.FORWORD);
		SessionBean sessionBean=getSessionBean();
		Map<String, Object> model = new HashMap<String, Object>();
		if(null != sessionBean){
			spjkxt.setXt_lrrxm(sessionBean.getUserName());
			spjkxt.setXt_lrrid(sessionBean.getUserId());
			spjkxt.setXt_lrrbm(sessionBean.getUserOrgName());
			spjkxt.setXt_lrrbmid(sessionBean.getUserOrgCode());
		}
		try {
			if (spjkxt.getXh() == null || spjkxt.getXh().trim().length()<1) { // 新增
				System.out.println("准备新增"+"copyfs"+spjkxt.getCopyfs());
				//spjkxt.setXh("210204");
				spjkxtService.insertSpjkxt(spjkxt,sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, getAddSuccess());
			} 
			else { // 修改
				System.out.println("准备修改！"+spjkxt.getXh());
				spjkxtService.updateSpjkxt(spjkxt,sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, getUpdateSuccess());
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
			System.out.println("保存失败！~！！"+e.getMessage());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/*
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public	ModelAndView save(Spjkxt  entity) {
		ModelAndView mv = new ModelAndView("jfxt/spdlqyList");
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		
		if(null != sessionBean){
			entity.setXt_lrrxm(sessionBean.getUserName());
			entity.setXt_lrrid(sessionBean.getUserId());
			entity.setXt_lrrbm(sessionBean.getUserOrgName());
			entity.setXt_lrrbmid(sessionBean.getUserOrgCode());
		}
		try {
			if (entity.getXh() == null || entity.getXh().equals("")) {
				spjkxtService.insertSpjkxt(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【视频区域】成功！");
				model.put(AppConst.SAVE_ID, entity.getXh()); // 返回主键
			} else {
				spjkxtService.updateSpjkxt(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【视频区域】成功！");
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}	
	*/
/*
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView DeleteJlx(Jlx jlx) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			if (jlx.getId() != null) { // 注销
				spjkxtService.deleteJlx(jlx);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, getDeleteSuccess());
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getDeleteFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}

	@RequestMapping(value = "/deletePatch", method = RequestMethod.POST)
	public ModelAndView DeletePatchJlx(@RequestBody Jlx[] jlxArray) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			for (int i = 0; i < jlxArray.length; i++) {
				spjkxtService.deleteJlx(jlxArray[i]);
			}
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, getDeleteSuccess());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getDeleteFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	*/
	@RequestMapping(value = "/checkSameName", method = RequestMethod.POST)
	public @ResponseBody int checkSameName(@RequestParam(value = "dwbm")String dwbm,
			@RequestParam(value = "xtmc")String xtmc){
		//Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		Map<String,String> map=new HashMap<String,String>();
		map.put("xt_lrrid", sessionBean.getUserId());
		map.put("dwbm", dwbm);
		map.put("xtmc", xtmc);
		int SameNameNum= spjkxtService.checkSameName(map);
		//SpsxtZBVO Spsxtvo = new SpsxtZBVO();
		/*try {
			Spsxtvo.setSameName(SameNameNum.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		model.put("Spsxtvo", Spsxtvo);
		return model;*/
		return SameNameNum;
	}
	@RequestMapping(value = "/queryLwsxByXh")
	public @ResponseBody Map queryLwsxByXh(@RequestParam(value = "xh") String xh){
		Map<String, String>  org=new HashMap<String, String>();
		org=spjkxtService.queryLwsxByXh(xh);
		return org;
	}
}
