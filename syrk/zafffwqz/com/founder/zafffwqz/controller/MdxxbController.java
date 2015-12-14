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
import com.founder.zafffwqz.bean.Mdxxb;
import com.founder.zafffwqz.service.MdxxbService;

import com.google.gson.Gson;
/**
 * ****************************************************************************
 * @Package:      [com.founder.zafffwqz.controller.MdxxbController.java]  
 * @ClassName:    [MdxxbController]   
 * @Description:  [矛盾调节控制器]   
 * @Author:       [tian_chengwei@founder.com.cn]  
 * @CreateDate:   [2015-6-2 下午3:13:33]   
 * @UpdateUser:   [lk(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-2 下午3:13:33，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 * 
 * @review      :wu.w@founder.com.cn
 * @reviewDate  : 20150604
 */

@Controller
@RequestMapping(value = "/mdxxb")
public class MdxxbController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name="mdxxbService")
	private MdxxbService mdxxbService;
	
	/**
	 * 跳转-矛盾详细信息
	 * @param id
	 * @param mainTabID
	 * @return ModelAndView
	 */
	@RequestMapping(value ="/queryMdxxxx",method=RequestMethod.GET)
	public @ResponseBody
	ModelAndView queryMdxxxx(String id,String mainTabID){
		ModelAndView mv = new ModelAndView("zafffwqz/mdtjDetail");
		Mdxxb entity = new Mdxxb();
		mv.addObject("mainTabID", mainTabID);
		try {
			mv.addObject("entity", entity);
			if(id!=null){
				entity.setId(id);
			}
			entity = mdxxbService.queryMdxxb(entity);
			if(entity != null){
				mv.addObject("entity", entity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
		
	}
	
	/**
	 * 跳转-矛盾调解
	 * @param ryid
	 * @return
	 */
	@RequestMapping(value = "/addMdxxb", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView addMdxxb(String id,String mainTabID ) {
		ModelAndView mv = new ModelAndView("zafffwqz/mdtjadd");
		Mdxxb entity = new Mdxxb();
		mv.addObject("mainTabID", mainTabID);
		String flag ="add";
		try {
			mv.addObject("entity", entity);
			if(id!=null){
				entity.setId(id);
			}
			entity = mdxxbService.queryMdxxb(entity);
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
	 * 保存-矛盾调解
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/saveMdxxb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveMdxxb(Mdxxb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() == null || entity.getId().equals("")) {
				entity.setTjjgdm("3");
				mdxxbService.saveMdxxb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【矛盾调解】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				mdxxbService.updateMdxxb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【矛盾调解】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
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
	/**
	 * 
	 * @Title: queryList
	 * @Description: TODO(分页查询)
	 * @param @param page
	 * @param @param rows
	 * @param @param mdgxgsdm
	 * @param @param mdfssj
	 * @param @param mdlydm
	 * @param @param mdlx
	 * @param @param mdfsddmc
	 * @param @param tjjgdm
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryList(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows,
			String mdgxgsdm,String mdfssj,String mdlydm,String mdlx,String mdfsddmc,String tjjgdm) {
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		Map map=new HashMap();
		if(!"".equals(mdgxgsdm)&&mdgxgsdm!=null){
			map.put("mdgxgsdm", mdgxgsdm);
		}else{
			map.put("mdgxgsdm", null);
		}
		if(!"".equals(mdlydm)&&mdlydm!=null){
			map.put("mdlydm", mdlydm);
		}else{
			map.put("mdlydm", null);
		}
		if(!"".equals(mdlx)&&mdlx!=null){
			map.put("mdlx", mdlx);
		}else{
			map.put("mdlx", null);
		}
		if(!"".equals(mdfssj)&&mdfssj!=null){
			map.put("mdfssj", mdfssj);
		}else{
			map.put("mdfssj", null);
		}
		if(!"".equals(mdfsddmc)&&mdfsddmc!=null){
			map.put("mdfsddmc", mdfsddmc);
		}else{
			map.put("mdfsddmc", null);
		}
		if(!"".equals(tjjgdm)&&tjjgdm!=null){
			map.put("tjjgdm", tjjgdm);
		}else{
			map.put("tjjgdm", null);
		}
		map.put("xt_lrrbmid", sessionBean.getUserOrgCode());
		
		return mdxxbService.queryList(page, map);
	}
	
	/**
	 * 注销-矛盾调解
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView DeleteMdxxb(Mdxxb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() != null) { // 注销
				mdxxbService.delete(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "注销【矛盾调解】成功！");
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
