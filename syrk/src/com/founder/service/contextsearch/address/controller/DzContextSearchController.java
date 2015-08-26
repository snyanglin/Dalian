package com.founder.service.contextsearch.address.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.framework.base.controller.BaseController;
import com.founder.service.contextsearch.address.bean.DzContextCombo;
import com.founder.service.contextsearch.address.bean.DzContextCondition;
import com.founder.service.contextsearch.address.service.DzContextSearchService;

@Controller
@RequestMapping(value = "dzContextSearch")
public class DzContextSearchController extends BaseController {

	@Resource(name = "dzContextSearchService")
	private DzContextSearchService dzContextSearchService;

	@RequestMapping(value = "/searchAddressMlph", method = RequestMethod.POST)
	public @ResponseBody
	List<DzContextCombo> searchAddressMlph(DzContextCondition condition ) {
		return dzContextSearchService.searchAddressMlph(condition);
	}

	@RequestMapping(value = "/searchAddressMlphXz", method = RequestMethod.POST)
	public @ResponseBody
	List<DzContextCombo> searchAddressMlphXz(DzContextCondition condition) {
		return dzContextSearchService.searchAddressMlphXz(condition);
	}

}
