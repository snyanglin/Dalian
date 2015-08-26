package com.founder.ggfw.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import org.apache.commons.beanutils.MethodUtils;

import com.founder.framework.base.controller.BaseController;
import com.founder.ggfw.service.YwxtRuleService;
import com.founder.ggfw.service.impl.YwxtRuleServiceImpl;

@Controller
@RequestMapping(value = "/ywxtRule")
@Resource(name = "ywxtRuleController")
public class YwxtRuleController extends BaseController {
	
	@Resource(name = "ywxtRuleService")
	private YwxtRuleService ywxtRuleService;
	
	/**
	 * 执行业务协同规则的（同意、拒绝、共存）方法
	 * @param methodName   eg:"lxdh_agree"
	 * @return
	 */
	@RequestMapping(value = "/executeRuleMethod")
	public ModelAndView executeRuleMethod(Map<String, Object> param, String s/*String methodName, Ywxtgzrwb entity*/){
//		Map<String, Object> param = new HashMap<String, Object>();
		param.put("sessionBean", getSessionBean());
//		param.put("entity", entity);
		try {
			System.out.println("---------->invoked"+s);
//			MethodUtils.invokeMethod(ywxtRuleService, methodName, param);
//		} catch (NoSuchMethodException e) {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args){
		YwxtRuleServiceImpl ywxtRuleService = new YwxtRuleServiceImpl();
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			MethodUtils.invokeMethod(ywxtRuleService, "lxdh_agree", param);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
