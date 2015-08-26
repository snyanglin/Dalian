package com.founder.service.contextsearch.department.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.framework.base.controller.BaseController;
import com.founder.service.contextsearch.department.bean.DwContextCombo;
import com.founder.service.contextsearch.department.bean.DwContextCondition;
import com.founder.service.contextsearch.department.service.DwContextSearchService;

@Controller
@RequestMapping(value = "dwContextSearch")
public class DwContextSearchController extends BaseController {

	@Resource(name = "dwContextSearchService")
	private DwContextSearchService dwContextSearchService;

	@RequestMapping(value = "/searchDepartment", method = RequestMethod.POST)
	public @ResponseBody
	List<DwContextCombo> searchDepartment(DwContextCondition condition) {
		return dwContextSearchService.searchDepartment(condition);
	}

}
