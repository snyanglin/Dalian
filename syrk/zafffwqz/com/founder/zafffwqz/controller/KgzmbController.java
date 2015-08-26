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
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zafffwqz.bean.Kgzmb;
import com.founder.zafffwqz.service.KgzmbService;
import com.google.gson.Gson;

@Controller
@RequestMapping(value = "/kgzmb")
public class KgzmbController extends BaseController{
	private Logger logger = Logger.getLogger(this.getClass());
	@Resource(name="kgzmbService")
	private KgzmbService kgzmbService;
	
	/**
	 * 跳转-空挂证明
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/addKgzmb", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView addKgzmb(String id,String mainTabID) {
		ModelAndView mv = new ModelAndView("zafffwqz/kgzmbadd");
		mv.addObject("mainTabID", mainTabID);
		Kgzmb entity = new Kgzmb();
		SessionBean sessionBean = getSessionBean();
		String nowDate = DateUtils.getSystemDateString();
		String flag ="add";
		try {
			entity.setZmkjr(sessionBean.getUserName());
			entity.setKjrq(nowDate);
			entity.setZmkjdw(sessionBean.getExtendValue("ssPcsName"));
			entity.setZmkjrid(sessionBean.getUserId());
			entity.setZmkjdwid(sessionBean.getExtendValue("ssPcsCode"));
			mv.addObject("entity", entity);
			if(id!=null){
				entity.setId(id);
			}
			entity = kgzmbService.queryKgzmb(entity);
			if(entity != null){
				mv.addObject("entity", entity);
				if(entity.getXt_lrrbmid().equals(sessionBean.getUserOrgCode())){
					flag ="update";
				}else {
					flag ="see";
				}
			}
			mv.addObject("flag", flag);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 保存-空挂证明
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/saveKgzmb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveKgzmb(Kgzmb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() == null || entity.getId().equals("")) {
				kgzmbService.saveKgzmb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【空挂证明】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				kgzmbService.updateKgzmb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【空挂证明】成功！");
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
	
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryList(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows,String gmsfhm,String xm,String xbdm,String dz_jzdzxz,String dz_hjdzxz,String startime,String endtime) {
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		Map map=new HashMap();
		if(!"".equals(gmsfhm)&&gmsfhm!=null){
			map.put("gmsfhm", gmsfhm);
		}else{
			map.put("gmsfhm", null);
		}
		if(!"".equals(xm)&&xm!=null){
			map.put("xm", xm);
		}else{
			map.put("xm", null);
		}
		if(!"".equals(xbdm)&&xbdm!=null){
			map.put("xbdm", xbdm);
		}else{
			map.put("xbdm", null);
		}
		if(!"".equals(dz_jzdzxz)&&dz_jzdzxz!=null){
			map.put("dz_jzdzxz",dz_jzdzxz);
		}else{
			map.put("dz_jzdzxz",null);
		}
		if(!"".equals(dz_hjdzxz)&&dz_hjdzxz!=null){
			map.put("dz_hjdzxz",dz_hjdzxz);
		}else{
			map.put("dz_hjdzxz",null);
		}
		if(!"".equals(startime)&&startime!=null){
			map.put("startime", startime);
		}else{
			map.put("startime", null);
		}
		if(!"".equals(endtime)&&endtime!=null){
			map.put("endtime", endtime);
		}else{
			map.put("endtime", null);
		}
		return kgzmbService.queryList(page, map);
	}
	
	/**
	 * 注销-空挂证明
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView DeleteKgzmb(Kgzmb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() != null) { // 注销
				kgzmbService.delete(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "注销【空挂证明】成功！");
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
}
