package com.founder.syrkgl.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.annotation.RestfulAnnotation;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.syrkgl.bean.Jzzblxxb;
import com.founder.syrkgl.bean.RyRyjbxxb;
import com.founder.syrkgl.bean.SyrkLdrkxxb;
import com.founder.syrkgl.service.JzzblxxbService;
import com.founder.syrkgl.service.RyRyjbxxbService;

import com.google.gson.Gson;

/**
 * ****************************************************************************
 * 
 * @Package: [com.founder.syrkgl.controller.JzzblxxbController.java]
 * @ClassName: [JzzblxxbController]
 * @Description: [居住证办理]
 * @Author: [陈红彬]
 * @CreateDate: [2015-4-27 下午6:14:13]
 * @UpdateUser: [zdk(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-4-27 下午6:14:13，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@Controller
@RequestMapping(value = "jzzblxxb")
public class JzzblxxbController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "jzzblxxbService")
	private JzzblxxbService jzzblxxbService;

	@Resource(name = "ryRyjbxxbService")
	private RyRyjbxxbService ryRyjbxxbService;

	/**
	 * 
	 * @Title: add
	 * @Description: TODO(跳转居住证办理)
	 * @param @param id
	 * @param @param ryid
	 * @param @param ryflid
	 * @param @return
	 * @param @throws BussinessException 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add(
			@RequestParam(value = "id", required = false) String id,
			String ryid, String syrkid) throws BussinessException {
		ModelAndView mv = new ModelAndView("syrkgl/jzzblxxbAdd");
		SessionBean sessionBean = getSessionBean();
		Jzzblxxb entity = new Jzzblxxb();
		if (!StringUtils.isBlank(id) || !StringUtils.isBlank(syrkid)) {
			SyrkLdrkxxb SyrkLdrkxxb = null;

			if (!StringUtils.isBlank(id)) {
				SyrkLdrkxxb = jzzblxxbService.queryLdrk(id);
				entity.setSyrkid(id);
			} else {
				SyrkLdrkxxb = jzzblxxbService.queryLdrk(syrkid);
				entity.setSyrkid(syrkid);
			}
			entity.setZjhm(SyrkLdrkxxb.getZjhm());
			entity.setXm(SyrkLdrkxxb.getXm());
			entity.setXbdm(SyrkLdrkxxb.getXbdm());
			entity.setMzdm(SyrkLdrkxxb.getMzdm());
			entity.setCsrq(SyrkLdrkxxb.getCsrq());
			//这里取基础人口信息的描述
			RyRyjbxxb ryRyjbxxb =ryRyjbxxbService.queryById(SyrkLdrkxxb.getRyid());
			entity.setHjd_dzxz(ryRyjbxxb.getHjd_dzms());
			entity.setJzd_dzxz(SyrkLdrkxxb.getJzd_dzxz());
			String nowDate = DateUtils.getSystemDateString();
			entity.setJzzblrq(nowDate);// 居住证办理日期
			entity.setRyid(ryid);
			entity.setCyzjdm(SyrkLdrkxxb.getCyzjdm());
			entity.setBlr_id(sessionBean.getUserId());
			entity.setBlr_xm(sessionBean.getUserName());
			entity.setJzz_blztdm("1");
			entity.setJzzblrq(DateUtils.getSystemDateString());

		}
		mv.addObject("entity", entity);
		return mv;
	}

	/**
	 * 
	 * @Title: edit
	 * @Description: TODO(跳转制证编辑页面)
	 * @param @param id
	 * @param @return
	 * @param @throws BussinessException 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam(value = "id") String id)
			throws BussinessException {
		ModelAndView mv = new ModelAndView("syrkgl/jzzblxxbEdit");
		SessionBean sessionBean = getSessionBean();
		Jzzblxxb entity = new Jzzblxxb();
		if (!StringUtils.isBlank(id)) {
			entity = jzzblxxbService.queryJzzblxxb(id);
			entity.setZzr_id(sessionBean.getUserId());
			entity.setZzr_xm(sessionBean.getUserName());
		}
		mv.addObject("entity", entity);
		return mv;
	}

	/**
	 * 
	 * @Title: edit
	 * @Description: TODO(保存编辑信息)
	 * @param @param id
	 * @param @return
	 * @param @throws BussinessException 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveEdit", method = RequestMethod.POST)
	public ModelAndView saveEdit(Jzzblxxb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			jzzblxxbService.updateJzzblxxb(entity, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "修改居住证信息成功！");
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getUpdateFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}

	/**
	 * 
	 * @Title: saveLg
	 * @Description: TODO(居住证新增保存)
	 * @param @param entity
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(Jzzblxxb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);

		// 添加不可重复录入居住证规则
		Jzzblxxb hasJzz = jzzblxxbService.checkRyJzz(entity.getRyid());
		if (hasJzz != null) {
			model.put(AppConst.STATUS, AppConst.FAIL);
			if (StringUtils.isBlank(hasJzz.getYxq_jzrq())){
				model.put(AppConst.MESSAGES, hasJzz.getBl_pcsmc() + "已经申请居住证");
			}else{
			model.put(AppConst.MESSAGES, hasJzz.getBl_pcsmc() + "已经申请居住证，有效期至"
					+ hasJzz.getYxq_jzrq());
			}
		} else {
			try {
				if ("50".equals(sessionBean.getUserOrgLevel())) {
					entity.setBl_fjmc(sessionBean.getExtendValue("ssFsxName"));
					entity.setBl_fjdm(sessionBean.getExtendValue("ssFsxCode"));
					entity.setBl_pcsmc(sessionBean.getExtendValue("ssPcsName"));
					entity.setBl_pcsdm(sessionBean.getExtendValue("ssPcsCode"));
					entity.setBl_zrqmc(sessionBean.getUserOrgName());
					entity.setBl_zrqdm(sessionBean.getUserOrgCode());
					jzzblxxbService.saveJzzblxx(entity, sessionBean);
				} else if ("32".equals(sessionBean.getUserOrgLevel())) {
					entity.setBl_fjmc(sessionBean.getExtendValue("ssFsxName"));
					entity.setBl_fjdm(sessionBean.getExtendValue("ssFsxCode"));
					entity.setBl_pcsmc(sessionBean.getUserOrgName());
					entity.setBl_pcsdm(sessionBean.getUserOrgCode());
					jzzblxxbService.saveJzzblxx(entity, sessionBean);
				}
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, getAddSuccess());
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e.getLocalizedMessage(), e);
				model.put(AppConst.STATUS, AppConst.FAIL);
				model.put(AppConst.MESSAGES, getAddFail());
			}
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}

	/**
	 * 
	 * @Title: queryJzzblxxList
	 * @Description: TODO(查询居住证办理信息列表)
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return EasyUIPage 返回类型
	 * @throws
	 */
	@RestfulAnnotation(serverId = "3")
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryJzzblxxList(EasyUIPage page,
			@RequestParam(value = "rows", required = false) Integer rows,
			Jzzblxxb entity, SessionBean sessionBean) {
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		String orglevel = sessionBean.getUserOrgLevel();
		EasyUIPage easyui = null;
		String fxjdm = sessionBean.getExtendValue("ssFsxCode");
		if (!"30".equals(orglevel)) {
			entity.setBl_fjdm(fxjdm);
		}
		if ("31".equals(orglevel) || "30".equals(orglevel)) {
			easyui = jzzblxxbService.queryJzzblList(page, entity);
		}

		return easyui;
	}

	/**
	 * 
	 * @Title: jzzView
	 * @Description: TODO(居住证办理预览)
	 * @param @param id
	 * @param @return
	 * @param @throws BussinessException 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/jzzView", method = RequestMethod.GET)
	public ModelAndView jzzView(@RequestParam(value = "id") String id,
			SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView("syrkgl/jzzblView");
		sessionBean = getSessionBean(sessionBean);
		Jzzblxxb entity = null;
		if (!StringUtils.isBlank(id)) {
			entity = jzzblxxbService.jzzView(id, sessionBean);
		}
		mv.addObject("entity", entity);
		return mv;
	}
	
	
	/***
	 * 
	 * @Title: getZdrylbdmExceptYlg
	 * @Description: 批量打印调用填写日期，和更改状态
	 * @author wu_chunhui@founder.com.cn
	 * @param @return
	 * @return String
	 * @throws
	 */
	@RequestMapping(value = "/piLiangDaYing", method = RequestMethod.POST)
	public @ResponseBody
	String piLiangDaYing(String id) {
		Jzzblxxb entity = null;
		SessionBean sessionBean = getSessionBean();
		if (!StringUtils.isBlank(id)) {
			entity = jzzblxxbService.jzzView(id, sessionBean);
		}
		String str = new Gson().toJson(entity);
		return str;
	}
	/***
	 * 
	 * @Title: piLiangDaYing
	 * @Description: TODO(打印全部查询结果，取得所有ID)
	 * @param @param id
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/getAllIds", method = RequestMethod.POST)
	public @ResponseBody
	String getAllIds(Jzzblxxb entity) {
		return new Gson().toJson(jzzblxxbService.queryIdsForPrint(entity)) ;
	}

	/***
	 * 
	 * @Title: jzzbl_export
	 * @Description: TODO(居住证导出)
	 * @author wu_chunhui@founder.com.cn
	 * @param @param dwid
	 * @param @param response 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/jzzbl_export")
	public void jzzbl_export(String exportIds, HttpServletResponse response,
			HttpServletRequest request, SessionBean sessionBean) {
		response.setContentType("application/binary;charset=UTF-8");
		ServletOutputStream outputStream = null;
		sessionBean = getSessionBean(sessionBean);
		try {
			outputStream = response.getOutputStream();
			File file = jzzblxxbService.jzzbl_export(exportIds, response,
					request, sessionBean);
			response.setHeader("Content-disposition", "attachment;filename="
					+ URLEncoder.encode("居住证导出.zip", "UTF-8"));
			FileInputStream in = new FileInputStream(file);
			byte bytes[] = new byte[1024];
			int len = 0;
			while ((len = in.read(bytes)) != -1) {
				outputStream.write(bytes, 0, len);
			}
			outputStream.flush();
			outputStream.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				outputStream.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			// 删除临时文件

		}
	}
	
	
	
	

}
