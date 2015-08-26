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
import com.founder.qbld.bean.LkyjzlQsb;
import com.founder.qbld.bean.Lkyjzlb;
import com.founder.qbld.bean.LkyjzlczFkb;
import com.founder.qbld.service.LkyjzlService;
import com.founder.qbld.utils.QbldUtil;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.controller.LkyjzlController.java]  
 * @ClassName:    [LkyjzlController]   
 * @Description:  [临控预警指令功能控制器]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-4-22 上午9:07:39]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-22 上午9:07:39，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Controller
@RequestMapping(value = "lkyjzl")
public class LkyjzlController extends BaseController {
	
	@Resource(name = "lkyjzlService")
	private LkyjzlService lkyjzlService;
	
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;
	
	/**
	 * @Title: queryLkyjzlList
	 * @Description: TODO(临控预警指令列表查询)
	 * @param page
	 * @param rows
	 * @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryLkyjzlList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryLkyjzlList(EasyUIPage page,
			@RequestParam(value = "rows",required=false) Integer rows, 
			Lkyjzlb entity,
			SessionBean sessionBean){
		sessionBean = getSessionBean(sessionBean);
		//若前未台传入组织机构代码，则判断‘分局’、‘派出所’级别，进行分权限查询
		if (StringUtils.isBlank(entity.getZljsdw())) {
			entity.setZljsdw(QbldUtil.isOrg(sessionBean, orgOrganizationService));
		}
		page.setPagePara(rows);
		return lkyjzlService.queryLkyjzlList(page, entity);
	}
	
	/**
	 * @Title: queryCkyj
	 * @Description: TODO(临控预警指令详情)
	 * @param entity
	 * @param sessionBean
	 * @param @return    设定文件
	 * @return Lkyjzlb    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryLkyjzl", method = RequestMethod.POST)
	public @ResponseBody Lkyjzlb queryCkyj(Lkyjzlb entity, SessionBean sessionBean){
		sessionBean = getSessionBean(sessionBean);
		return lkyjzlService.queryLkyjzl(entity);
	}
	
	/**
	 * @Title: queryLkyjzlFkb
	 * @Description: TODO(反馈记录查询服务-根据预警编号查询临控预警指令反馈表详情)
	 * @param entity
	 * @param @return    设定文件
	 * @return Lkyjczfkb    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryLkyjzlFkb", method = RequestMethod.POST)
	public @ResponseBody LkyjzlczFkb queryLkyjzlFkb(LkyjzlczFkb entity){
		return lkyjzlService.queryLkyjzlFkb(entity);
	}
	
	/**
	 * @Title: updateLkyjzlbAndSaveQsb
	 * @Description: TODO(警情指令签收)
	 * @param entity
	 * @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/updateLkyjzlbAndSaveQsb", method = RequestMethod.POST)
	public @ResponseBody ModelAndView updateLkyjzlbAndSaveQsb(Lkyjzlb entity, LkyjzlQsb bean, SessionBean sessionBean){
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			//更改预警表签收状态为1，已签收
			lkyjzlService.updateLkyjzlb(QbldUtil.QS, entity, sessionBean);
			//新增预警签收数据
			lkyjzlService.saveLkyjzlqs(bean, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * @Title: updateLkyjzlbAndSaveFkb
	 * @Description: TODO(临控预警指令反馈功能)
	 * @param entity
	 * @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/updateLkyjzlbAndSaveFkb", method = RequestMethod.POST)
	public @ResponseBody ModelAndView updateLkyjzlbAndSaveFkb(Lkyjzlb entity, LkyjzlczFkb bean, SessionBean sessionBean){
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			//更改预警表签收状态为2，已反馈
			lkyjzlService.updateLkyjzlb(QbldUtil.FK, entity, sessionBean);
			//新增预警反馈数据
			lkyjzlService.saveLkyjzlfk(bean, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * @Title: queryLkyjzlFkList
	 * @Description: TODO(临控预警指令反馈列表查询)
	 * @param page
	 * @param rows
	 * @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryLkyjzlFkList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryLkyjzlFkList(EasyUIPage page,
			@RequestParam(value = "rows",required=false) Integer rows, 
			LkyjzlczFkb entity){
		page.setPagePara(rows);
		return lkyjzlService.queryLkyjzlFkList(page, entity);
	}
	
	/**
	 * @Title: lkyjzlxxb_export
	 * @Description: TODO(常控预警指令导出功能)
	 * @param dwid
	 * @param response    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/lkyjzlb_export")
	public void lkyjzlxxb_export(Lkyjzlb entity, HttpServletResponse response){
		response.setContentType("application/binary;charset=UTF-8");
		try {
			ServletOutputStream outputStream = response.getOutputStream();
			String fileName = new String(("临控预警指令信息表").getBytes(), "ISO8859-1");
			response.setHeader("Content-disposition", "attachment;filename=" + fileName
					+ DateUtils.getSystemDateString() + ".xlsx");
			String[] titleArray = {"临控指令编号","签收反馈状态"};
			String[] keyArray = {"lkzlbh","qsfkzt"};
			List<Map<String, String>> list = lkyjzlService.lkyjzlb_query_export(entity);
			if (list!=null && list.size()>0) {
				QbldUtil.exportExcel(fileName, titleArray, keyArray, list, outputStream);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}