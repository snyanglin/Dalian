package com.founder.service.relationmessage.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.framework.base.controller.BaseController;
import com.founder.service.relationmessage.service.RelationRyxxService;

@Controller
@RequestMapping(value = "relationRyxx")
public class RelationRyxxController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "relationRyxxService")
	private RelationRyxxService relationRyxxService;

	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	public @ResponseBody
	List queryList(String sfzh) {
		return relationRyxxService.queryRelationMessage(sfzh);
	}

}
