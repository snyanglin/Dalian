package com.founder.ldym.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.framework.base.controller.BaseController;
import com.founder.ldym.service.LdymXqgkService;
import com.founder.ldym.vo.XqgkDataCountVo;
import com.founder.sydw_dl.bean.Dwjbxxb;




/******************************************************************************
 * @Package:      [com.founder.ldym.controller.XqgkController.java]  
 * @ClassName:    [XqgkController]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015-7-2 上午10:20:50]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-7-2 上午10:20:50，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Controller
@RequestMapping(value="/xqgk", method=RequestMethod.POST)
public class XqgkController extends BaseController{
	
	@Resource(name="ldymXqgkService")
	private LdymXqgkService ldymXqgkService;

	
	@RequestMapping("/getData")
	public @ResponseBody XqgkDataCountVo getData(@RequestParam String orgCode) {

		return ldymXqgkService.getDataNum(orgCode);
	}
	
	@RequestMapping("/getSydwList")
	public @ResponseBody List<Dwjbxxb> getSydwList(@RequestParam String orgCode,@RequestParam String dwlbdm) {

		Map<String, String> map=new HashMap<String, String>();
		map.put("orgCode",orgCode);
		map.put("dwlbdm",dwlbdm);
		return ldymXqgkService.queryDwjbxxb(map);
	}
	

}
