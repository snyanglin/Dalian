package com.founder.zdrw.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrw.bean.Zdzxrwrzb;
import com.founder.zdrw.service.ZdzxrwrzbService;

@Controller
@RequestMapping(value = "zdzxrwrzb")
public class ZdzxrwrzbController extends BaseController {
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name="zdzxrwrzbService")
	private ZdzxrwrzbService zdzxrwrzbService;
	
	@RequestMapping(value = "/queryList")
	public @ResponseBody
	EasyUIPage queryList(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, Zdzxrwrzb entity){
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		if(null != sessionBean){
		}
		return this.zdzxrwrzbService.queryList(page, entity);
	}
}
