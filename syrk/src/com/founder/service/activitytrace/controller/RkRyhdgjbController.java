package com.founder.service.activitytrace.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.framework.base.controller.BaseController;
import com.founder.service.activitytrace.bean.RkRyhdgjb;
import com.founder.service.activitytrace.service.RkRyhdgjbService;

@Controller
@RequestMapping(value = "rkRyhdgjb")
public class RkRyhdgjbController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "rkRyhdgjbService")
	private RkRyhdgjbService rkRyhdgjbService;

	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	public @ResponseBody
	List queryList(RkRyhdgjb entity) {
		return rkRyhdgjbService.queryRkRyhdgjb(entity.getZjhm());
	}

}
