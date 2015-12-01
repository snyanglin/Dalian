package com.founder.jzym.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.jzym.service.JzjcxxService;
import com.founder.xjpt.vo.ZzjgVo;
import com.founder.jzym.bean.Ryjzdzzb;
import com.founder.xjpt.bean.Zdryjbxxb;

/**
 * @类名: JzjcxxController
 * @描述: 局长基础信息
 * 
 */
@Controller
// 声明控制器
@RequestMapping("/jzjcxx")
// 映射URL
public class JzjcxxController extends BaseController {

	@Resource(name = "jzjcxxService")
	private JzjcxxService jzjcxxService;

	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView edit() {
		ModelAndView mv = new ModelAndView("/jzym/jzjcxx/jzjcxx");
		List<OrgOrganization> list = orgOrganizationService
				.queryPublicListByParentID(new Long(0), "01", "10", "");
		if (list != null && list.size() > 0) {
			OrgOrganization orgOrganization = list.get(0);
			mv.addObject("sjOrgcode", orgOrganization.getOrgcode());
			mv.addObject("sjOrgname", orgOrganization.getOrgname());
		}
		return mv;
	}

	/**
	 * @Title: queryPcsTj
	 * @描述:查询基础信息
	 * @参数: 传入参数定义
	 * @日期： 2014-10-25 下午4:43:03
	 * @返回值: List<ZzjgVo> 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryJcxx", method = RequestMethod.POST)
	public @ResponseBody
	List<ZzjgVo> queryJcxx(String tjjb, String tjOrgcode) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("tjjb", tjjb);
		param.put("tjOrgcode", tjOrgcode);
		return jzjcxxService.queryJcxx(param);
	}

	/**
	 * @Title: queryPcsTj
	 * @描述:查询实有人口列表
	 * @参数: 传入参数定义
	 * @日期： 2014-10-25 下午4:43:03
	 * @返回值: List<ZzjgVo> 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/querySyrkList", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage querySyrkList(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, Ryjzdzzb entity,
			Long tjCount) {
		page.setPagePara(rows);
		return jzjcxxService.querySyrkList(page, entity, tjCount);
	}

	/**
	 * @Title: queryPcsTj
	 * @描述:查询重点人员列表
	 * @参数: 传入参数定义
	 * @日期： 2014-10-25 下午4:43:03
	 * @返回值: List<ZzjgVo> 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryZdryList", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryZdryList(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, Zdryjbxxb entity,
			Long tjCount) {
		page.setPagePara(rows);
		return jzjcxxService.queryZdryList(page, entity, tjCount);
	}

	/**
	 * @Title: queryPcsTj
	 * @描述:查询实有人员列表
	 * @参数: 传入参数定义
	 * @日期： 2014-10-25 下午4:43:03
	 * @返回值: List<ZzjgVo> 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/syrkQueryCondition", method = RequestMethod.GET)
	public ModelAndView syrkQueryCondition() {
		ModelAndView mv = new ModelAndView("jzym/jzjcxx/syrkQueryCondition");
		return mv;
	}

}