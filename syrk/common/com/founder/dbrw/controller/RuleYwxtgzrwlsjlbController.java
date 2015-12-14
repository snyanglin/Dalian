/**********************************************************************   
 * <p>文件名：RuleYwxtgzrwlsjlbController.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu_chunhui@founder.com.cn 
 * @date 2014-11-3 下午10:44:48 
 * @history
 * @department：研发部
 *
*/
package com.founder.dbrw.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.founder.dbrw.bean.RuleYwxtgzrwlsjlb;
import com.founder.dbrw.service.RuleYwxtgzrwlsjlbService;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;

/******************************************************************************
 * @Package:      [com.founder.dbrw.controller.RuleYwxtgzrwlsjlbController.java]  
 * @ClassName:    [RuleYwxtgzrwlsjlbController]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2014-11-3 下午10:44:48]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2014-11-3 下午10:44:48，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */

@Controller
@RequestMapping(value = "/RuleYwxtgzrwlsjlb")
public class RuleYwxtgzrwlsjlbController extends BaseController {
	
	@Resource(name = "ruleYwxtgzrwlsjlbService")
	private RuleYwxtgzrwlsjlbService ruleYwxtgzrwlsjlbService;
	
	@RequestMapping(value = "/queryRuleYwxtgzrwlsjlbList", method = RequestMethod.GET)
	public @ResponseBody
	EasyUIPage queryJctjList(EasyUIPage page, @RequestParam(value = "rows") Integer rows,String fqrbmid,String rwclrbmid) {
		page.setPagePara(rows);
		Map map= new HashMap();
		map.put("fqrbmid", fqrbmid);
		map.put("rwclrbmid", rwclrbmid);
		return ruleYwxtgzrwlsjlbService.list(page, map);
	}
	
	@RequestMapping(value = "/showList", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView createPage(String fqrbmid, String rwclrbmid) {
		ModelAndView mv = new ModelAndView("dbrw/rwJctjList");
		RuleYwxtgzrwlsjlb entity = new RuleYwxtgzrwlsjlb();
		if (!StringUtils.isBlank(fqrbmid)) {
			entity.setFqrbmid(fqrbmid);
		} else if(!StringUtils.isBlank(rwclrbmid)) {
			entity.setRwclrbmid(rwclrbmid);
		}
		mv.addObject("entity", entity);
		return mv;
	}
}
