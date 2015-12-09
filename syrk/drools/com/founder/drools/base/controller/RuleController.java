package com.founder.drools.base.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.framework.annotation.RestfulAnnotation;
import com.founder.framework.base.controller.BaseController;
import com.founder.zdrygl.base.service.ZdryInfoQueryService;
import com.founder.zdrygl.core.utils.ZdryConstant;
import com.founder.zdrygl.core.model.Zdry;

/**
 * ****************************************************************************
 * @Package:      [com.founder.drools.base.controller.RuleController.java]  
 * @ClassName:    [RuleController]   
 * @Description:  [给规则平台提供的规则调用接口]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年12月1日 下午2:19:48]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年12月1日 下午2:19:48，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Controller
@RequestMapping("zdrySys")
public class RuleController extends BaseController {					
	
	@Autowired
	private ZdryConstant zdryConstant;
	
	@Resource(name = "zdryQueryService")
	private ZdryInfoQueryService zdryQueryService;

	/**
	 * 
	 * @Title: getZdrylx
	 * @Description: TODO(获取重点人员类型中文)
	 * @param @param zdrygllx
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throw
	 */
	@RestfulAnnotation(valiField = "zdrygllx", serverId = "3")
	@RequestMapping(value = "/getZdrylx", method = {RequestMethod.GET})
	public @ResponseBody String getZdrylx(String zdrygllx){
		
		return zdryConstant.getValueOfZdryDict(zdrygllx);
	}

	@RestfulAnnotation(valiField = "zdryId", serverId = "3")
	@RequestMapping(value = "/{zdryId}", method = {RequestMethod.GET})
	public @ResponseBody Zdry getZdryInfo(@PathVariable String zdryId){
		return zdryQueryService.queryById(zdryId);		
	}
	
	
}
