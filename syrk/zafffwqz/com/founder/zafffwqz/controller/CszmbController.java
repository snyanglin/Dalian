package com.founder.zafffwqz.controller;
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
import com.founder.framework.exception.BussinessException;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zafffwqz.bean.Cszmb;
import com.founder.zafffwqz.service.CszmbService;
import com.google.gson.Gson;



@Controller
@RequestMapping(value = "/cszmb")
public class CszmbController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name="cszmbService")
	private CszmbService cszmbService;
	
	/**
	 * 跳转-出生证明
	 * @param ryid
	 * @return
	 */
	@RequestMapping(value = "/addCszmb", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView addCszmb(String id,String mainTabID) {
		ModelAndView mv = new ModelAndView("zafffwqz/cszmadd");
		Cszmb entity = new Cszmb();
		mv.addObject("mainTabID", mainTabID);
		String flag ="add";
		SessionBean sessionBean = getSessionBean();
		String nowDate = DateUtils.getSystemDateString();
		try {
			entity.setZmkjr(sessionBean.getUserName());
			entity.setZmkjrid(sessionBean.getUserId());
			entity.setKjrq(nowDate);
			entity.setZmkjdw(sessionBean.getExtendValue("ssPcsName"));
			entity.setZmkjdwid(sessionBean.getExtendValue("ssPcsCode"));
			mv.addObject("entity", entity);
			if(id!=null){
				entity.setId(id);
			}
			entity = cszmbService.queryCszmb(entity);
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
	 * 保存-出生证明
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/saveCszmb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveCszmb(Cszmb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() == null || entity.getId().equals("")) {
				cszmbService.saveCszmb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【出生证明】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				cszmbService.updateCszmb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【出生证明】成功！");
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
			@RequestParam(value = "rows") Integer rows, String gmsfhm, 
			String xm,String sfxm,String smxm,String startime,String endtime) {
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
		if(!"".equals(sfxm)&&sfxm!=null){
			map.put("sfxm", sfxm);
		}else{
			map.put("sfxm", null);
		}
		if(!"".equals(smxm)&&smxm!=null){
			map.put("smxm", smxm);
		}else{
			map.put("smxm", null);
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
		map.put("xt_lrrbmid", sessionBean.getUserOrgCode());
		
		return cszmbService.queryList(page, map);
	}
	
	/**
	 * 注销出生证明
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView DeleteCszmb(Cszmb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() != null) { // 注销
				cszmbService.delete(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "注销【出生证明】成功！");
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
	 * 查询同一个号码只能有一条出生证明信息
	 * 
	 * @param zjhm
	 * @return
	 * @throws BussinessException
	 */
	@RequestMapping(value = "/getCszmb", method = RequestMethod.POST)
	public @ResponseBody
	Map getRyCszmb(String zjhm) {
		Map<String, Object> model = new HashMap<String, Object>();
		List<Cszmb> Cszmb = cszmbService.queryRyCs(zjhm);
		boolean sfzhflag = false;
		if (Cszmb.size() > 0) {
			sfzhflag = true;
		} else {
			sfzhflag = false;
		}
		model.put("sfzhflag", sfzhflag);
		return model;
	}
}
