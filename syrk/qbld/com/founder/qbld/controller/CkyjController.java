package com.founder.qbld.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.qbld.bean.CkyjczFkb;
import com.founder.qbld.bean.CkyjxxQsb;
import com.founder.qbld.bean.Ckyjxxb;
import com.founder.qbld.service.CkyjService;
import com.founder.qbld.utils.QbldUtil;
import com.founder.qbld.vo.YjTjVo;
import com.google.gson.Gson;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.controller.CkyjController.java]  
 * @ClassName:    [CkyjController]   
 * @Description:  [常控预警控制器]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-4-13 上午10:15:27]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-13 上午10:15:27，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Controller
@RequestMapping(value = "ckyj")
public class CkyjController extends BaseController {
	
	@Resource(name = "ckyjService")
	private CkyjService ckyjService;
	
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;
	
	/**
	 * @Title: queryYjtj
	 * @Description: TODO(返回常控预警、常控预警指令、临空预警、临控预警指令的待签、待返数量)
	 * @param ckyj
	 * @param sessionBean
	 * @param @return    设定文件
	 * @return Map<String,Object>    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryYjtj", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> queryYjtj(YjTjVo entity, SessionBean sessionBean){
		sessionBean = getSessionBean(sessionBean);
		//若前未台传入组织机构代码，则判断‘分局’、‘派出所’级别，进行分权限查询
		if (StringUtils.isBlank(entity.getOrgcode())) {
			entity.setOrgcode(QbldUtil.isOrg(sessionBean, orgOrganizationService));
		}
		YjTjVo ckyjTj = ckyjService.queryYjtj(entity);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ckyjTotal", ckyjTj);
		return map;
	}
	
	/**
	 * @Title: queryCkyjList
	 * @Description: TODO(常控预警列表查询/历史预警查询)
	 * @param page
	 * @param rows
	 * @param entity
	 * @param sessionBean
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryCkyjList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryCkyjList(EasyUIPage page,
		   @RequestParam(value = "rows", required=false) Integer rows, 
		   Ckyjxxb entity,
		   SessionBean sessionBean){
		sessionBean = getSessionBean(sessionBean);
		//若前未台传入组织机构代码，则判断‘分局’、‘派出所’级别，进行分权限查询
		if (StringUtils.isBlank(entity.getYjjsdw())) {
			entity.setYjjsdw(QbldUtil.isOrg(sessionBean, orgOrganizationService));
		}
		page.setPagePara(rows);
		return ckyjService.queryCkyjList(page, entity);
	}
	
	/**
	 * @Title: queryCkyj
	 * @Description: TODO(常控预警信息详情查询服务/历史信息)
	 * @param entity
	 * @param sessionBean
	 * @param @return    设定文件
	 * @return Ckyjxxb    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryCkyj", method = RequestMethod.POST)
	public @ResponseBody Ckyjxxb queryCkyj(Ckyjxxb entity){
		return ckyjService.queryCkyj(entity);
	}
	
	/**
	 * @Title: updateCkyjxxbAndSaveQsb
	 * @Description: TODO(常控警情签收)
	 * @param @param entity
	 * @param @param bean
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/updateCkyjxxbAndSaveQsb", method = RequestMethod.POST)
	public @ResponseBody ModelAndView updateCkyjxxbAndSaveQsb(Ckyjxxb entity, CkyjxxQsb bean, SessionBean sessionBean){
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			//更改预警表签收状态为1，已签收
			ckyjService.updateCkyjxxb(QbldUtil.QS, entity);
			//新增预警签收数据
			ckyjService.saveCkyjqs(bean, sessionBean);
			//TODO 推送数据给情报平台
			model.put(AppConst.STATUS, AppConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * @Title: updateCkyjxxbAndSaveFkb
	 * @Description: TODO(预警反馈功能)
	 * @param entity
	 * @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/updateCkyjxxbAndSaveFkb", method = RequestMethod.POST)
	public @ResponseBody ModelAndView updateCkyjxxbAndSaveFkb(Ckyjxxb entity, CkyjczFkb bean, SessionBean sessionBean){
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			//更改预警表签收状态为2，已反馈
			ckyjService.updateCkyjxxb(QbldUtil.FK, entity);
			//新增预警反馈数据
			ckyjService.saveCkyjfk(bean, sessionBean);
			//TODO 推送数据给情报平台
			model.put(AppConst.STATUS, AppConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * @Title: queryCkyjFkb
	 * @Description: TODO(反馈记录查询服务-根据预警编号查询常控预警反馈表)
	 * @param entity
	 * @param @return    设定文件
	 * @return Ckyjxxb    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryCkyjFkb", method = RequestMethod.POST)
	public @ResponseBody CkyjczFkb queryCkyjFkb(CkyjczFkb entity){
		return ckyjService.queryCkyjFkb(entity);
	}
	
	/**
	 * @Title: ckyjxxb_export
	 * @Description: TODO(常控预警导出功能)
	 * @param dwid
	 * @param response    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/ckyjxxb_export")
	public void ckyjxxb_export(Ckyjxxb entity, HttpServletResponse response){
		response.setContentType("application/binary;charset=UTF-8");
		try {
			ServletOutputStream outputStream = response.getOutputStream();
			String fileName = new String(("常控预警信息表").getBytes(), "ISO8859-1");
			response.setHeader("Content-disposition", "attachment;filename=" + fileName
					+ DateUtils.getSystemDateString() + ".xlsx");
			String[] titleArray = {"预警信息编号","预警级别","身份证号","签收反馈状态"};
			String[] keyArray = {"yjxxbh","yjjb","sfzh","qsfkzt"};
			List<Map<String, String>> list = ckyjService.cyryxxb_query_export(entity);
			QbldUtil.exportExcel(fileName, titleArray, keyArray, list, outputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @Title: queryCkyjFkList
	 * @Description: TODO(常控预警反馈列表查询)
	 * @param page
	 * @param rows
	 * @param entity
	 * @param sessionBean
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryCkyjFkList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryCkyjFkList(EasyUIPage page,
			@RequestParam(value = "rows",required=false) Integer rows, 
			CkyjczFkb entity){
		page.setPagePara(rows);
		return ckyjService.queryCkyjFkList(page, entity);
	}
	
	/**
	 * @Title: updateCkyjczFkb
	 * @Description: TODO(修改尿检、物品信息)
	 * @param entity
	 * @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/updateCkyjczFkb", method = RequestMethod.POST)
	public @ResponseBody ModelAndView updateCkyjczFkb(CkyjczFkb entity, SessionBean sessionBean){
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			ckyjService.updateCkyjczFkb(entity);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * @Title: queryQbldZpSingle
	 * @Description: TODO(取得人口照片-photo表查不到则查询全国库并入photo库)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return HttpEntity<byte[]>    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryQbldZpSingle.jpg", method = RequestMethod.GET)
	public HttpEntity<byte[]> queryQbldZpSingle(Ckyjxxb entity) {
		return ckyjService.queryQbldZpSingle(entity);
	}
	
}