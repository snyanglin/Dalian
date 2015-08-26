package com.founder.yjjb.controller;

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
import com.founder.framework.utils.StringUtils;
import com.founder.framework.utils.UUID;
import com.founder.service.attachment.bean.ZpfjFjxxb;
import com.founder.service.attachment.service.ZpfjFjxxbService;
import com.founder.yjjb.bean.Ajxxb;
import com.founder.yjjb.bean.Fjajgxb;
import com.founder.yjjb.bean.Xsajgxb;
import com.founder.yjjb.service.AjxxbService;
import com.founder.yjjb.service.CommonService;
import com.founder.yjjb.service.FjajgxbService;
import com.founder.yjjb.service.XsajgxbService;

import com.google.gson.Gson;

@Controller
@RequestMapping(value = "/ajxxb")
public class AjxxbController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name="ajxxbService")
	private AjxxbService ajxxbService;
	@Resource(name="xsajgxbService")
	private XsajgxbService xsajgxbService;
	@Resource(name="fjajgxbService")
	private FjajgxbService fjajgxbService;
	@Resource(name="zpfjFjxxbService")
	private ZpfjFjxxbService zpfjFjxxbService;
	@Resource(name="commonService")
	private CommonService commonService;
	
	/**
	 * 查询</br>
	 * @param page
	 * @param rows
	 * @param entity
	 * @return
	 */
	
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryList(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, Ajxxb entity,String xsId){
		entity.setXsbh(xsId);
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		String orgCode = sessionBean.getUserOrgCode();
		if(null != sessionBean){
			entity.setBadw(orgCode);
		}
		return this.ajxxbService.queryList(page,entity);
	}
	
	/**
	 * 查看案件
	 * @param id
	 * @param mainTabID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/viewCase", method = RequestMethod.GET)
	public ModelAndView viewCase(String ajId,String xsbh,String showFlag,String mainTabID) {

		ModelAndView mv = new ModelAndView("yjjb/ckajxxxx");
		mv.addObject("mainTabID", mainTabID);
		Ajxxb entity = new Ajxxb();
		List<Fjajgxb> fjajgxbList = null;
		if (!StringUtils.isBlank(ajId)) {
			entity.setAjbh(ajId);
			entity = ajxxbService.queryByAjbh(entity);
			fjajgxbList =  fjajgxbService.queryByAjbh(ajId);
			if(fjajgxbList != null){
				if(fjajgxbList.size() > 0){
					for(int i = 0; i < fjajgxbList.size(); i++){
						fjajgxbList.get(i).setFjVersion("1");
					}
				}
			}
		}
		
		mv.addObject("entity", entity);
		mv.addObject("fjajgxbList", fjajgxbList);
		mv.addObject("xsbh", xsbh);
		mv.addObject("showFlag", showFlag);
		return mv;
		}
	
	/**
	 * 新增
	 * @param entity
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveAjxx", method = RequestMethod.POST)
	public Object save(Ajxxb entity,String xsId,String mainTabID){
//		ModelAndView mv = new ModelAndView("yjjb/xgajList");
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		entity.setId(entity.getId());
		//如果是受案状态，则将jjxx存到sajyxx里，其他三项类似
		//if(entity.getAjzt().equals("0")){
		entity.setSajyxx(entity.getJyxx());
		entity.setBadw(sessionBean.getUserOrgCode());
		
		// 增加受理分站受理站受理中心，用于统计 开始
		entity.setSlfzdm(entity.getBadw());
		entity.setSlzdm(commonService.queryUpOrgID(entity.getBadw()));
		entity.setSlzxdm(commonService.queryUpOrgID(entity.getSlzdm()));
		// 增加受理分站受理站受理中心，用于统计  结束
		/*
		}else if(entity.getAjzt().equals("1")){
			entity.setLajyxx(entity.getJyxx());
		}else if(entity.getAjzt().equals("2")){
			entity.setPajyxx(entity.getJyxx());
		}else if(entity.getAjzt().equals("3")){
			entity.setCfjyxx(entity.getJyxx());
		}
		*/
		ajxxbService.save(entity, sessionBean);
		
		Xsajgxb entitySa = new Xsajgxb();
		entitySa.setId(UUID.create());
		entitySa.setXsbh(xsId);
		entitySa.setAjbh(entity.getAjbh());
		entitySa.setAjsource("0");
		entitySa.setSfffjl("0");
		xsajgxbService.save(entitySa, sessionBean);
		Fjajgxb entityFu = new Fjajgxb();
		if(entity.getFjid() != null){
			for(int i = 0;i<entity.getFjid().size();i++) {
				entityFu.setId(entity.getFjid().get(i));
				entityFu.setAjbh(entity.getAjbh());
				entityFu.setFjmc(entity.getFjmc().get(i));
				entityFu.setFjms(entity.getFjms().get(i));
				entityFu.setFjlx(entity.getFjlx().get(i));
				fjajgxbService.save(entityFu, sessionBean);
			}
		}
		model.put(AppConst.STATUS, AppConst.SUCCESS);
		model.put(AppConst.MESSAGES,  getMessage("add.success"));
		model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
		model.put("tabId", mainTabID);
		
//		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
//		mv.addObject("xsId", xsId);
		return model;
	}
	
	/**
	 * 注销
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView delete(Ajxxb entity){
		
		ModelAndView mv = new ModelAndView("redirect:/forward/"	+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		
		try {
			
			ajxxbService.delete(entity, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES,  getMessage("cancel.success"));
		} catch (Exception e) {
			
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * 跳转到创建案件并关联页面
	 * @param id
	 * @param mainTabID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/createAndLink", method = RequestMethod.GET)
	public ModelAndView createAndLink(String xsId,String mainTabID) {
		SessionBean sessionBean = getSessionBean();
		String orgCode = "";
		if (null != sessionBean) {
			orgCode = sessionBean.getUserOrgCode();
		}
		ModelAndView mv = new ModelAndView("yjjb/cjbglaj");
		mv.addObject("mainTabID", mainTabID);
		String newId = UUID.create();
		String ajbh = commonService.CreateNewSeq("11", orgCode);
		mv.addObject("ajbh", ajbh);
		mv.addObject("newCaseId", newId);
		mv.addObject("xsId", xsId);
		
		return mv;
		}
	
	/**
	 * 查询某线索关联的案件数量
	 * @param xsbh
	 * @return
	 */
	@RequestMapping(value = "/ifExistAjNum", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> ifExistAjNum(String ajbh){
		Map<String, Object> model = new HashMap<String, Object>();
		int sta = ajxxbService.ifExistAjNum(ajbh);
		model.put("sta", sta);
		return model;
	}
	
	/**
	 * 新增
	 * @param entity
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updateDetail", method = RequestMethod.POST)
	public Object updateDetail(Ajxxb entity,String xsbh,String mainTabID){
		//ModelAndView mv = new ModelAndView("yjjb/xgajList");
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		//更新案件信息表内容
		Ajxxb entityAjxxb = new Ajxxb();
		entityAjxxb.setId(entity.getId());
		entityAjxxb.setAjmc(entity.getAjmc());
		entityAjxxb.setAjlx(entity.getAjlx());
		entityAjxxb.setSajyxx(entity.getSajyxx());
		ajxxbService.update(entityAjxxb, sessionBean);
		
		Fjajgxb entityFu = new Fjajgxb();
		entityFu.setAjbh(entity.getAjbh());
		//先删除表中所有附件
		/*
		List<Fjajgxb> fj = fjajgxbService.queryByAjbh(entityFu.getAjbh());
		ZpfjFjxxb entityZpfjFjxxb = new ZpfjFjxxb();
		
		if(fj != null) {
			if (fj.size()>0) {
				for(int i=0;i<fj.size();i++) {
					entityAjfjb.setLybm("YJJB_FJAJGXB");
					entityAjfjb.setLyid(fj.get(i).getId());
					ajfjbService.deleteByLyidLybm(entityAjfjb, sessionBean);
				}
				fjajgxbService.deleteByAjbh(entityFu, sessionBean);
			}
		}
		*/
		
		//保存页面所有附件
		if(entity.getFjid() != null){
			for(int i = 0;i<entity.getFjid().size();i++) {
				if("0".equals(entity.getFjVersion().get(i))) {
					entityFu.setId(entity.getFjid().get(i));
					entityFu.setAjbh(entity.getAjbh());
					entityFu.setFjmc(entity.getFjmc().get(i));
					entityFu.setFjms(entity.getFjms().get(i));
					entityFu.setFjlx(entity.getFjlx().get(i));
					fjajgxbService.save(entityFu, sessionBean);
				}else{
					entityFu.setId(entity.getFjid().get(i));
					entityFu.setAjbh(entity.getAjbh());
					entityFu.setFjmc(entity.getFjmc().get(i));
					entityFu.setFjms(entity.getFjms().get(i));
					entityFu.setFjlx(entity.getFjlx().get(i));
					fjajgxbService.update(entityFu, sessionBean);
				}
			}
		}
		model.put(AppConst.STATUS, AppConst.SUCCESS);
		model.put(AppConst.MESSAGES,  getMessage("add.success"));
		model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
		model.put("tabId", mainTabID);
		
		//mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		//mv.addObject("xsId", xsbh);
		//return mv;
		
		return model;
	}
	
	/**
	 * 删除刚刚上传了的附件
	 * 考虑编辑的时候删除模块调用删除，然后又没保存的情况，暂时编辑不使用该方法
	 * @param xsbh
	 * @return
	 */
	/*
	@RequestMapping(value = "/deleteFj", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> deleteFj(String lyid){
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		ZpfjFjxxb entityZpfjFjxxb = new ZpfjFjxxb();
		entityZpfjFjxxb.setLybm("YJJB_FJAJGXB");
		entityZpfjFjxxb.setLyid(lyid);
		zpfjFjxxbService.deleteByLyidLybm(entityZpfjFjxxb, sessionBean);
		return model;
	}
	*/
	
}
