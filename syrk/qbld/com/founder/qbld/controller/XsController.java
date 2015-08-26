package com.founder.qbld.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.Gson;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.qbld.bean.Xscjb;
import com.founder.qbld.service.XsService;
import com.founder.qbld.utils.QbldUtil;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.controller.XsController.java]  
 * @ClassName:    [XsController]   
 * @Description:  [线索控制器]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-5-4 上午11:23:06]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-4 上午11:23:06，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Controller
@RequestMapping(value = "xs")
public class XsController extends BaseController {
	
	@Resource(name = "xsService")
	private XsService xsService;
	
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;
	
	/**
	 * @Title: queryXsList
	 * @Description: TODO(线索列表查询)
	 * @param page
	 * @param rows
	 * @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryXsList",method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryXsList(EasyUIPage page,
			@RequestParam(value = "rows", required=false) Integer rows, 
			Xscjb entity, SessionBean sessionBean){
		sessionBean = getSessionBean(sessionBean);
		entity.setCjdwdm(QbldUtil.isOrg(sessionBean, orgOrganizationService));
		page.setPagePara(rows);
		return xsService.queryXsList(page, entity);
	}
	
	/**
	 * @Title: queryXs
	 * @Description: TODO(线索详情)
	 * @param entity
	 * @param sessionBean
	 * @param @return    设定文件
	 * @return Xscjb    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryXs", method = RequestMethod.POST)
	public @ResponseBody Xscjb queryXs(Xscjb entity, SessionBean sessionBean){
		sessionBean = getSessionBean(sessionBean);
		return xsService.queryXs(entity);
	}
	
	/**
	 * @Title: saveXscjb
	 * @Description: TODO(保存线索采集表)
	 * @param entity
	 * @param sessionBean
	 * @param @return    设定文件
	 * @return Xscjb    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveXscjb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveXscjb(Xscjb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		entity.setCjdwdm(sessionBean.getUserOrgCode());
		SimpleDateFormat formatStr = new SimpleDateFormat("yyyyMMddHHmmss"); 
		Calendar cal = Calendar.getInstance();
		String nowStr = formatStr.format(cal.getTime());
		entity.setBssj(nowStr);
		entity.setCjdwmc(sessionBean.getUserOrgNameQc());
		entity.setCjr(sessionBean.getUserName());
		try {
			xsService.saveXscjb(entity);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
}