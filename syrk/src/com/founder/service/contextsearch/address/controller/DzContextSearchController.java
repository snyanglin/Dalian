package com.founder.service.contextsearch.address.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
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

	/**
	 * 
	 * @Title: searchNbAddressMlph
	 * @Description: TODO(搜索内保单位下的单位的地址门楼牌)
	 * @param @param condition
	 * @param @return    设定文件
	 * @return List<DzContextCombo>    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/searchNbAddressMlph", method = RequestMethod.POST)
	public @ResponseBody
	List<DzContextCombo> searchNbAddressMlph(String searchKey,SessionBean sessionBean) {
		 sessionBean = getSessionBean();
		 String nbdwOrgcode = sessionBean.getUserOrgCode();
		return dzContextSearchService.searchNbAddressMlph(nbdwOrgcode,searchKey);
	}

	/**
	 * 
	 * @Title: searchNbAddressMlphXz
	 * @Description: TODO(搜索内保单位下的单位的地址门楼牌详址)
	 * @param @param condition
	 * @param @return    设定文件
	 * @return List<DzContextCombo>    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/searchNbAddressMlphXz", method = RequestMethod.POST)
	public @ResponseBody
	List<DzContextCombo> searchNbAddressMlphXz(String searchKey,String id,SessionBean sessionBean) {
		 sessionBean = getSessionBean();
		 String nbdwOrgcode = sessionBean.getUserOrgCode();
		return dzContextSearchService.searchNbAddressMlphXz(nbdwOrgcode,id,searchKey);
	}

	
}
