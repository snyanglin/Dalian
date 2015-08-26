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
import com.founder.zafffwqz.bean.Jzzmb;
import com.founder.zafffwqz.service.JzzmbService;
import com.google.gson.Gson;

@Controller
@RequestMapping(value = "/jzzmb")
public class JzzmbController extends BaseController {
	private Logger logger = Logger.getLogger(this.getClass());
	@Resource(name="jzzmbService")
	private JzzmbService jzzmbService;
	
	/**
	 * 跳转-居住证明
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/addJzzmb", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView addJzzmb(String id,String mainTabID) {
		ModelAndView mv = new ModelAndView("zafffwqz/jzzmbadd");
		mv.addObject("mainTabID", mainTabID);
		Jzzmb entity = new Jzzmb();
		String flag ="add";
		SessionBean sessionBean = getSessionBean();
		String nowDate = DateUtils.getSystemDateString();
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
			entity = jzzmbService.queryJzzmb(entity);
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
	 * 保存-居住证明
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/saveJzzmb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveJzzmb(Jzzmb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() == null || entity.getId().equals("")) {
 				jzzmbService.saveJzzmb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【居住证明】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				jzzmbService.updateJzzmb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【居住证明】成功！");
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
		return jzzmbService.queryList(page, map);
	}
	
	/**
	 * 注销-居住证明
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView DeleteJzzmb(Jzzmb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() != null) { // 注销
				jzzmbService.delete(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "注销【居住证明】成功！");
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
