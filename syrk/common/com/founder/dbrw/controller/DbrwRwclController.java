package com.founder.dbrw.controller;

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
import com.google.gson.Gson;
import com.founder.dbrw.bean.DbrwDbrwb;
import com.founder.dbrw.bean.DbrwDbrwsjmxb;
import com.founder.dbrw.service.DbrwRwclService;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.utils.EasyUIPage;


@Controller
@RequestMapping(value = "dbrwRwcl")
public class DbrwRwclController extends BaseController {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	
	@Resource(name = "dbrwRwclService")
	private DbrwRwclService dbrwRwclService;
	
	
	
	/**
	 * 创建任务处理界面
	 * @param id
	 * @param mainTabID
	 * @return
	 */
	@RequestMapping(value = "/rwcl", method = RequestMethod.GET)
	public ModelAndView rwcl(DbrwDbrwb entity,String messageid) {
		ModelAndView mv = new ModelAndView("dbrw/rwcl");
		entity = dbrwRwclService.queryDbrwb(entity);
		mv.addObject("entity", entity);
		mv.addObject("messageid", messageid);
		mv.addObject("filedTitle",dbrwRwclService.getFiledTitle(entity.getDbmxid()));
		return mv;
	}
	
	
	/**
	 * 获取任务列表
	 * @param id
	 * @param mainTabID
	 * @return
	 */
	@RequestMapping(value = "/getTaskList", method = RequestMethod.POST)
		public @ResponseBody
		EasyUIPage getTaskList(EasyUIPage page,
				@RequestParam(value = "rows") Integer rows,DbrwDbrwsjmxb dbrwDbrwsjmxb) {
			page.setPagePara(rows);
			return dbrwRwclService.queryDbrwsjmxb(dbrwDbrwsjmxb,super.getSessionBean(), page);
		}
	
	
	
	/**
	 * 刷新任务处理情况
	 * @param id
	 * @param mainTabID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/refreshClqk", method = RequestMethod.POST)
	public boolean refreshClqk(DbrwDbrwb entity) {
		try {
			dbrwRwclService.Refresh(entity, super.getSessionBean());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	/**
	 * 列表任务完成
	 * @param id
	 * @param mainTabID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/complete", method = RequestMethod.POST)
	public boolean complete(DbrwDbrwb entity,String MessageID) {
		try {
			dbrwRwclService.Complete(entity, super.getSessionBean(),MessageID);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	/**
	 * 打开反馈
	 * @param id
	 * @param mainTabID
	 * @return
	 */
	@RequestMapping(value = "/openFk", method = RequestMethod.GET)
	public ModelAndView openFk(String dbrwsjmxbID) {
		ModelAndView mv = new ModelAndView("dbrw/rwcl_fk");
		DbrwDbrwsjmxb entity = new DbrwDbrwsjmxb();
		entity.setId(dbrwsjmxbID);
		mv.addObject("entity",dbrwRwclService.queryDbrwDbrwsjmxb(entity));
		return mv;
	}
	
	
	/**
	 * 保存反馈
	 * @param id
	 * @param mainTabID
	 * @return
	 */
	@RequestMapping(value = "/saveFk", method = RequestMethod.POST)
	public ModelAndView saveFk(DbrwDbrwsjmxb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/" + AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {

			if (entity.getId() != null || !entity.getId().equals("")) {
				dbrwRwclService.saveFk(entity,sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "反馈成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} 

		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * 获取图形题展示需要的数据
	 * @param id
	 * @param mainTabID
	 * @return
	 */
	@RequestMapping(value = "/getfigdata", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getFigData(DbrwDbrwsjmxb entity) {
		entity.setDbrwid(entity.getDbrwid().substring(0, entity.getDbrwid().indexOf("~")));
		return dbrwRwclService.getFigData(entity, super.getSessionBean());
	}
	
}
