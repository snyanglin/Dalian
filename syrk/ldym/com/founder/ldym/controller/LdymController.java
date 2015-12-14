package com.founder.ldym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.founder.framework.base.controller.BaseController;

@Controller
@RequestMapping("/ldym")
public class LdymController extends BaseController {

	/**
	 * 
	 * @Title: main
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@RequestMapping(value = "index" , method = RequestMethod.GET)
	public String main(){
		return "base/index";
	}
	
	@RequestMapping(value = "main" , method = RequestMethod.GET)
	public String lydm(){
		return "ldym/ldym";
	}
	
	@RequestMapping(value = "xqgk" , method = RequestMethod.GET)
	public String xqgk(){
		return "ldym/page/xqgk";
	}
	
	@RequestMapping(value = "zcjy" , method = RequestMethod.GET)
	public String zcjy(){
		return "ldym/page/zcjy";
	}
	
	@RequestMapping(value = "qfqz" , method = RequestMethod.GET)
	public String qfqz(){
		return "ldym/page/qfqz";
	}
}
