package com.founder.zdrygl.base.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.framework.annotation.RestfulAnnotation;
import com.founder.framework.base.controller.BaseController;
import com.founder.syrkgl.bean.RyRyjbxxb;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
import com.founder.zdrygl.base.service.DataApplyService;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.controller.DataApplyController.java]  
 * @ClassName:    [DataApplyController]   
 * @Description:  [基本信息复用，提供给华云]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年9月22日 上午10:16:01]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年9月22日 上午10:16:01，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Controller
@RequestMapping("dataApply")
public class DataApplyController extends BaseController {		
	@Resource(name="dataApplyService")
	private DataApplyService dataApplyService;
	
	/**
	 * 
	 * @Title: syrkApply
	 * @Description: TODO(实有人口信息复用)	 * 
	 * @param @param cyzjdm 证件类型
	 * @param @param zjhm 证件号码
	 * @param @return    设定文件
	 * @return SyrkSyrkxxzb    返回类型
	 * @throw
	 */
	@RestfulAnnotation(valiField = "cyzjdm,zjhm", serverId = "3")
	@RequestMapping(value = "/syrkApply", method = RequestMethod.GET)
	public @ResponseBody SyrkSyrkxxzb syrkApply(String cyzjdm, String zjhm) {		
		return dataApplyService.syrkApply(cyzjdm, zjhm);		
	}
	
	/**
	 * 
	 * @Title: ryjbxxApply
	 * @Description: TODO(人员基本信息复用)	 
	 * @param @param cyzjdm 证件类型
	 * @param @param zjhm 证件号码
	 * @param @return    设定文件
	 * @return RyRyjbxxb    返回类型
	 * @throw
	 */
	@RestfulAnnotation(valiField = "cyzjdm,zjhm", serverId = "3")
	@RequestMapping(value = "/ryjbxxApply", method = RequestMethod.GET)
	public @ResponseBody RyRyjbxxb ryjbxxApply(String cyzjdm, String zjhm) {		
		return dataApplyService.ryjbxxApply(cyzjdm, zjhm);		
	}
	
	
	/**
	 * 
	 * @Title: ryxxApply
	 * @Description: TODO(人员信息复用本地测试用，以后改用华云的URL)
	 * @param @param cyzjdm
	 * @param @param zjhm
	 * @param @return    设定文件
	 * @return obj    返回类型
	 * @throw
	 */
	@RequestMapping(value = "/ryxxApply", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Object ryxxApply(String cyzjdm, String zjhm) {	
		Object obj= dataApplyService.syrkApply(cyzjdm, zjhm);
		if(obj==null) obj=dataApplyService.ryjbxxApply(cyzjdm, zjhm);
		return 		obj;
	}
}
