package com.founder.zdrygl.base.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrygl.base.model.ZdryDtjsSaxxb;
import com.founder.zdrygl.base.service.ZdryDtjsSaxxbService;
@Controller
@RequestMapping("dtjsMore")
public class ZdryDtjsSaxxbController extends BaseController {
	
	@Resource
	private ZdryDtjsSaxxbService  zdryDtjsSaxxbService;

	@RequestMapping(value = "/moreDtjsSaxxb", method = RequestMethod.POST)	
	public @ResponseBody EasyUIPage queryDtjsZtxxList(EasyUIPage page,
			@RequestParam(value = "rows", required=false) Integer rows, 
			String zdryZjhm,
			SessionBean sessionBean){
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		ZdryDtjsSaxxb entity=new ZdryDtjsSaxxb();
		entity.setZjhm(zdryZjhm);
		return zdryDtjsSaxxbService.queryList(page, entity);
	}
	


}
