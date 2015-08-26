package com.founder.service.provinceservice.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.framework.base.controller.BaseController;
import com.founder.service.provinceservice.service.ServiceHttpClient;

@Controller
@RequestMapping(value = "provinceService")
public class ProvinceServiceController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());

	@RequestMapping(value = "/QueryEscapedCriminalByID", method = RequestMethod.GET)
	public @ResponseBody
	List QueryEscapedCriminalByID(String ztrysfzh) {
		ServiceHttpClient client = new ServiceHttpClient();
		return client.QueryEscapedCriminalByID(ztrysfzh);
	}

}
