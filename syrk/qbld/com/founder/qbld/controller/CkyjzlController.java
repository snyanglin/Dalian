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
import com.founder.qbld.bean.CkyjzlQsb;
import com.founder.qbld.bean.CkyjzlczFkb;
import com.founder.qbld.bean.Ckyjzlb;
import com.founder.qbld.service.CkyjzlService;
import com.founder.qbld.utils.QbldUtil;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.controller.CkyjzlController.java]  
 * @ClassName:    [CkyjzlController]   
 * @Description:  [常控预警指令功能控制器]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-4-22 上午9:07:39]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-22 上午9:07:39，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Controller
@RequestMapping(value = "ckyjzl")
public class CkyjzlController extends BaseController {
	
	@Resource(name = "ckyjzlService")
	private CkyjzlService ckyjzlService;
	
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;
	
	/**
	 * @Title: queryCkyjList
	 * @Description: TODO(常控预警指令列表查询)
	 * @param page
	 * @param rows
	 * @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryCkyjzlList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryCkyjzlList(EasyUIPage page,
			@RequestParam(value = "rows",required=false) Integer rows, 
			Ckyjzlb entity,
			SessionBean sessionBean){
		sessionBean = getSessionBean(sessionBean);
		//若前未台传入组织机构代码，则判断‘分局’、‘派出所’级别，进行分权限查询
		if (StringUtils.isBlank(entity.getXfjsdw())) {
			entity.setXfjsdw(QbldUtil.isOrg(sessionBean, orgOrganizationService));
		}
		page.setPagePara(rows);
		return ckyjzlService.queryCkyjzlList(page, entity);
	}
	
	/**
	 * @Title: queryCkyj
	 * @Description: TODO(常控预警指令详情)
	 * @param entity
	 * @param sessionBean
	 * @param @return    设定文件
	 * @return Ckyjzlb    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryCkyjzl", method = RequestMethod.POST)
	public @ResponseBody Ckyjzlb queryCkyj(Ckyjzlb entity, SessionBean sessionBean){
		sessionBean = getSessionBean(sessionBean);
		return ckyjzlService.queryCkyjzl(entity);
	}
	
	/**
	 * @Title: queryCkyjzlFkb
	 * @Description: TODO(反馈记录查询服务-根据预警编号查询预警指令反馈表详情)
	 * @param entity
	 * @param @return    设定文件
	 * @return Lkyjczfkb    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryCkyjzlFkb", method = RequestMethod.POST)
	public @ResponseBody CkyjzlczFkb queryCkyjzlFkb(CkyjzlczFkb entity){
		return ckyjzlService.queryCkyjzlFkb(entity);
	}
	
	/**
	 * @Title: updateCkyjzlbAndSaveQsb
	 * @Description: TODO(常控警情指令签收)
	 * @param entity
	 * @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/updateCkyjzlbAndSaveQsb", method = RequestMethod.POST)
	public @ResponseBody ModelAndView updateCkyjzlbAndSaveQsb(Ckyjzlb entity, CkyjzlQsb bean, SessionBean sessionBean){
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			//更改预警表签收状态为1，已签收
			ckyjzlService.updateCkyjzlb(QbldUtil.QS, entity, sessionBean);
			//新增预警签收数据
			ckyjzlService.saveCkyjzlQsb(bean, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * @Title: updateCkyjzlbAndSaveFkb
	 * @Description: TODO(常控预警指令反馈功能)
	 * @param entity
	 * @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/updateCkyjzlbAndSaveFkb", method = RequestMethod.POST)
	public @ResponseBody ModelAndView updateCkyjzlbAndSaveFkb(Ckyjzlb entity, CkyjzlczFkb bean, SessionBean sessionBean){
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			//更改预警表签收状态为2，已反馈
			ckyjzlService.updateCkyjzlb(QbldUtil.FK, entity, sessionBean);
			//新增预警反馈数据
			ckyjzlService.saveCkyjzlFkb(bean, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * @Title: queryCkyjzlFkList
	 * @Description: TODO(常控预警指令反馈列表查询)
	 * @param page
	 * @param rows
	 * @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryCkyjzlFkList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryCkyjzlFkList(EasyUIPage page,
			@RequestParam(value = "rows",required=false) Integer rows, 
			CkyjzlczFkb entity){
		page.setPagePara(rows);
		return ckyjzlService.queryCkyjzlFkList(page, entity);
	}
	
	/**
	 * @Title: updateCkyjzlczFkb
	 * @Description: TODO(修改尿检、物品信息)
	 * @param entity
	 * @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/updateCkyjzlczFkb", method = RequestMethod.POST)
	public @ResponseBody ModelAndView updateCkyjzlczFkb(CkyjzlczFkb entity, SessionBean sessionBean){
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			ckyjzlService.updateCkyjzlczFkb(entity);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * @Title: ckyjzlxxb_export
	 * @Description: TODO(常控预警指令导出功能)
	 * @param dwid
	 * @param response    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/ckyjzlxxb_export")
	public void ckyjzlxxb_export(Ckyjzlb entity, HttpServletResponse response){
		response.setContentType("application/binary;charset=UTF-8");
		try {
			ServletOutputStream outputStream = response.getOutputStream();
			String fileName = new String(("常控预警指令信息表").getBytes(), "ISO8859-1");
			response.setHeader("Content-disposition", "attachment;filename=" + fileName
					+ DateUtils.getSystemDateString() + ".xlsx");
			String[] titleArray = {"预警信息编号","指令级别","指令标题","签收反馈状态"};
			String[] keyArray = {"yjxxbh","zljb","zlbt","qsfkzt"};
			List<Map<String, String>> list = ckyjzlService.ckyjzlxxb_query_export(entity);
			if (list!=null && list.size()>0) {
				QbldUtil.exportExcel(fileName, titleArray, keyArray, list, outputStream);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}