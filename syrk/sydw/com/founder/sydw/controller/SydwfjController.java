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
import com.founder.service.attachment.bean.ZpfjFjxxb;
import com.founder.sydw.service.SydwEditService;

@Controller
@RequestMapping(value = "/sydwfj")
public class SydwfjController extends BaseController {
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "sydwEditService")
	private SydwEditService sydwEditService;
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(String dwid) {
		SessionBean sessionBean = getSessionBean();
		ModelAndView mv = new ModelAndView("sydw/sydwfjEdit");
		mv.addObject("lybm", "DW_DWJBXXB");
		mv.addObject("lyid", dwid);
		mv.addObject("lyms", "实有单位-附件");
		mv.addObject("fileType", "");
		mv.addObject("fileOnly", 0);
		return mv;
	}
	
	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public @ResponseBody List<ZpfjFjxxb> query(String dwid){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dwid", dwid);
		List<ZpfjFjxxb> fjxx = sydwEditService.fjxx_query(map);
		return fjxx;
	}
}
