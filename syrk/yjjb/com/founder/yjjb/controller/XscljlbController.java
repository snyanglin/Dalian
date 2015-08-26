/**
*** ┏┓           ┏┓
* ┏┛ ┻━━┛ ┻┓ 　
* ┃             ━              ┃
* ┃    ┳┛    ┗┳    ┃
* ┃    …                    …    ┃
* ┃             ┻              ┃
* ┗━┓            ┏━┛
*     ┃           ┃ Code is far away from bug with the animal protecting.
*     ┃           ┃ 神兽护佑, 代码无Bug.
*     ┃           ┗ ━━━━━━━━┓
*     ┃                                                         ┣┓
*     ┃                                                         ┏┛
*     ┗┓┓ ┏━━━━┳┓ ┏━┛
*       ┃┫┫                     ┃┫┫
*       ┗┻┛                     ┗┻┛ 
***/
package com.founder.yjjb.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.yjjb.bean.Xscljlb;
import com.founder.yjjb.service.XscljlbService;

@Controller
@RequestMapping(value = "/xscljlb")
public class XscljlbController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());
	
	// 日志处理
	@Resource(name="xscljlbService")
	private XscljlbService xscljlbService;
	
	/**
	 * 跳转
	 * @param id
	 * @param mainTabID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/openList", method = RequestMethod.GET)
	public ModelAndView xsjbxxbList(String id,String mainTabID) {
		
		ModelAndView mv = new ModelAndView("yjjb/xscljlList");
		mv.addObject("mainTabID", mainTabID);
		Xscljlb entity = new Xscljlb();
		
		if (!StringUtils.isBlank(id)) {
			
			entity.setId(id);
			entity = xscljlbService.queryById(entity);
		}
		mv.addObject("entity", entity);
		return mv;
	}
	
	/**
	 * 查询</br>
	 * @param page
	 * @param rows
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryList(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, Xscljlb entity){
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		if(null != sessionBean){
			
		}
		
		return this.xscljlbService.queryList(page,entity);
	}
}
