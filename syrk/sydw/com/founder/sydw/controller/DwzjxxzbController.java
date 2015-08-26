package com.founder.sydw.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.utils.StringUtils;
import com.founder.sydw.bean.Dwzjb;
import com.founder.sydw.service.DwzjxxzbService;
import com.google.gson.Gson;
@Controller
@RequestMapping(value = "dwzjxxb")
public class DwzjxxzbController extends BaseController {
	
	private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "dwzjxxzbService")
	private DwzjxxzbService dwzjxxzbService;
	
	/**
	 * 添加 单位证件信息
	 * @param id
	 * @param ryid
	 * @return
	 */
	@RequestMapping(value = "/addZjxx", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView addDdxxb(String id, String dwid) {
		ModelAndView mv = new ModelAndView("sydw/dwzjxxAdd");
		Dwzjb entity = new Dwzjb();
		entity.setDwid(dwid);
		String flag ="add";
		if (!StringUtils.isBlank(id)) {
			entity.setId(id);
			entity = dwzjxxzbService.queryZjxx(entity);
			flag ="update";
		}
		mv.addObject("entity", entity);
		mv.addObject("flag", flag);
		return mv;
	}

	/**
	 * 保存 单位证件信息
	 * @param tkjzryxxb
	 * @return
	 */
	@RequestMapping(value = "/saveZjxx", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveDdxxb(Dwzjb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() == null || entity.getId().equals("")) {
				dwzjxxzbService.saveZjxx(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【单位证件信息】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				dwzjxxzbService.updateZjxx(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【单位证件信息】成功！");
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
	 * 查询同一个证件种类只能有一条证件信息
	 * 
	 * @param 
	 * @param zjhm
	 * @return
	 * @throws BussinessException
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/getZjbh", method = RequestMethod.POST)
	public @ResponseBody
	Map getDwzjxxzb(String zjzldm, String zjbh) {
		Map<String, Object> model = new HashMap<String, Object>();
		List<Dwzjb>	dwjzjxxb = dwzjxxzbService.queryDwzjxx(zjzldm, zjbh);
		boolean sfzhflag = false;
		if (dwjzjxxb.size() > 0) {
			sfzhflag = true;
		} else {
			sfzhflag = false;
		}
		model.put("sfzhflag", sfzhflag);
		return model;
	}
}
