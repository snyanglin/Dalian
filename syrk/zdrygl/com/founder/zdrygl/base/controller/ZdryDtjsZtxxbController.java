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
import com.founder.zdrygl.base.model.ZdryDtjsZtxxb;
import com.founder.zdrygl.base.service.ZdryDtjsZtxxbService;
@Controller
@RequestMapping("dtjsMore")
public class ZdryDtjsZtxxbController extends BaseController {
	@Resource
	private ZdryDtjsZtxxbService  zdryDtjsZtxxbService;
	
	@RequestMapping(value = "/moreDtjsZtxxb", method = RequestMethod.POST)	
	public @ResponseBody EasyUIPage queryDtjsZtxxList(EasyUIPage page,
			@RequestParam(value = "rows", required=false) Integer rows, 
			String zdryZjhm,
			SessionBean sessionBean){
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		ZdryDtjsZtxxb entity=new ZdryDtjsZtxxb();
		entity.setZdryzjhm(zdryZjhm);
		return zdryDtjsZtxxbService.queryList(page, entity);
	}
	


}
