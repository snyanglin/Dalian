package com.founder.qbld.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
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
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.qbld.bean.LkyjczFkb;
import com.founder.qbld.bean.LkyjxxQsb;
import com.founder.qbld.bean.Lkyjxxb;
import com.founder.qbld.service.LkyjService;
import com.founder.qbld.utils.QbldUtil;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.controller.LkyjController.java]  
 * @ClassName:    [LkyjController]   
 * @Description:  [临空预警控制器]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-4-22 上午9:46:22]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-22 上午9:46:22，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Controller
@RequestMapping(value = "lkyj")
public class LkyjController extends BaseController {
	
	@Resource(name = "lkyjService")
	private LkyjService lkyjService;
	
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;
	
	/**
	 * @Title: queryLkyjList
	 * @Description: TODO(查询临控预警列表)
	 * @param page
	 * @param rows
	 * @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryLkyjList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryLkyjList(EasyUIPage page,
			@RequestParam(value = "rows",required=false) Integer rows, 
			Lkyjxxb entity,
			SessionBean sessionBean){
		sessionBean = getSessionBean(sessionBean);
		//若前未台传入组织机构代码，则判断‘分局’、‘派出所’级别，进行分权限查询
		if (StringUtils.isBlank(entity.getZljsdw())) {
			entity.setZljsdw(QbldUtil.isOrg(sessionBean, orgOrganizationService));
		}
		page.setPagePara(rows);
		return lkyjService.queryLkyjList(page, entity);
	}
	
	/**
	 * @Title: updateLkyjxxbAndSaveQsb
	 * @Description: TODO(临控预警签收)
	 * @param entity
	 * @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/updateLkyjxxbAndSaveQsb", method = RequestMethod.POST)
	public @ResponseBody ModelAndView updateLkyjxxbAndSaveQsb(Lkyjxxb entity, LkyjxxQsb bean, SessionBean sessionBean){
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			//更改预警表签收状态为1，已签收
			lkyjService.updateLkyjxxb(QbldUtil.QS, entity, sessionBean);
			//新增预警签收数据
			lkyjService.saveLkyjzlQsb(bean, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * @Title: updateLkyjxxbAndSaveFkb
	 * @Description: TODO(临控预警反馈)
	 * @param entity
	 * @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/updateLkyjxxbAndSaveFkb", method = RequestMethod.POST)
	public @ResponseBody ModelAndView updateLkyjxxbAndSaveFkb(Lkyjxxb entity, LkyjczFkb bean, SessionBean sessionBean){
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			//更改预警表签收状态为2，已反馈
			lkyjService.updateLkyjxxb(QbldUtil.FK, entity, sessionBean);
			//新增预警反馈数据
			lkyjService.saveLkyjzlFkb(bean, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * @Title: queryLkyj
	 * @Description: TODO(根据id查询临空预警详情信息)
	 * @param entity
	 * @param sessionBean
	 * @param @return    设定文件
	 * @return Lkyjxxb    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryLkyj", method = RequestMethod.POST)
	public @ResponseBody Lkyjxxb queryLkyj(Lkyjxxb entity, SessionBean sessionBean){
		sessionBean = getSessionBean(sessionBean);
		return lkyjService.queryLkyj(entity);
	}
	
	/**
	 * @Title: queryLkyjFkb
	 * @Description: TODO(反馈记录查询服务-根据预警编号查询临控预警反馈表)
	 * @param entity
	 * @param @return    设定文件
	 * @return queryLkyjFkb    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryLkyjFkb", method = RequestMethod.POST)
	public @ResponseBody LkyjczFkb queryLkyjFkb(LkyjczFkb entity){
		return lkyjService.queryLkyjFkb(entity);
	}
	
	/**
	 * @Title: queryLkyjFkList
	 * @Description: TODO(查询临控预警反馈列表)
	 * @param page
	 * @param rows
	 * @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryLkyjFkList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryLkyjFkList(EasyUIPage page,
			@RequestParam(value = "rows",required=false) Integer rows, 
			LkyjczFkb entity){
		page.setPagePara(rows);
		return lkyjService.queryLkyjFkList(page, entity);
	}
	
	/**
	 * @Title: lkyjxxb_export
	 * @Description: TODO(常控预警指令导出功能)
	 * @param dwid
	 * @param response    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/lkyjxxb_export")
	public void lkyjxxb_export(Lkyjxxb entity, HttpServletResponse response){
		response.setContentType("application/binary;charset=UTF-8");
		try {
			ServletOutputStream outputStream = response.getOutputStream();
			String fileName = new String(("临控预警信息表").getBytes(), "ISO8859-1");
			response.setHeader("Content-disposition", "attachment;filename=" + fileName
					+ DateUtils.getSystemDateString() + ".xlsx");
			String[] titleArray = {"临控指令编号","签收反馈状态"};
			String[] keyArray = {"lkzlbh","qsfkzt"};
			List<Map<String, String>> list = lkyjService.lkyjxxb_query_export(entity);
			if (list!=null && list.size()>0) {
				QbldUtil.exportExcel(fileName, titleArray, keyArray, list, outputStream);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}