package com.founder.sydw.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.utils.StringUtils;
import com.founder.sydw.bean.Dwbmxxb;
import com.founder.sydw.bean.Dwjbxxb;
import com.founder.sydw.service.DwjbxxbService;
import com.founder.sydw.vo.DwjbxxbSaveVO;

import com.google.gson.Gson;

/**
 * 实有单位管理控制器
 * 
 * @author Administrator
 * 
 */
@Controller
@RequestMapping("/dwjbxxb")
public class DwjbxxbController extends BaseController {
	private Logger logger = Logger.getLogger(this.getClass());
	@Resource(name = "dwjbxxbService")
	private DwjbxxbService dwjbxxbService;
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;
	/**
	 * 实有单位 新增页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView createDwjbxxb(String id, String hsrwid) {
		ModelAndView mv = new ModelAndView("sydw/dwjbxxbAdd");
		SessionBean sessionBean = getSessionBean();
		if (sessionBean != null) {
			mv.addObject("pcsdm", sessionBean.getExtendValue("ssPcsCode"));
			mv.addObject("zrqdm", sessionBean.getUserOrgCode());
			mv.addObject("pcsmc", sessionBean.getExtendValue("ssPcsName"));
			mv.addObject("fsxdm", sessionBean.getExtendValue("ssFsxCode"));
			mv.addObject("fsxmc", sessionBean.getExtendValue("ssFsxName"));
			mv.addObject("dsjdm", sessionBean.getExtendValue("ssDsjCode"));
			mv.addObject("dsjmc", sessionBean.getExtendValue("ssDsjName"));
		}
		Dwjbxxb entity = new Dwjbxxb();
		Dwjbxxb parentEntity = new Dwjbxxb();
		entity.setId(id);
		if (!StringUtils.isBlank(id)) {
			entity = dwjbxxbService.query(entity);
		}
		if (!StringUtils.isBlank(entity.getSjdwid())) {
			parentEntity.setId(entity.getSjdwid());
			parentEntity = dwjbxxbService.query(parentEntity);
			if (parentEntity != null) {
				mv.addObject("sjdwmc", parentEntity.getDwmc());
			}
		}
	
		List<Dwbmxxb> dwbmxxbArray = new ArrayList<Dwbmxxb>();
		List<Dwbmxxb> bmlist = null;
		if (entity != null) {
			bmlist = dwjbxxbService.queryDwbmxxbByDwid(entity.getId());
		}
		if (bmlist != null) {
			dwbmxxbArray.addAll(bmlist);
		}
		if (dwbmxxbArray.size() == 0) {
			dwbmxxbArray.add(new Dwbmxxb());
		}
		mv.addObject("dwbmxxbArray", dwbmxxbArray);
		mv.addObject("dwbmxxbArrayLength", dwbmxxbArray.size());
		mv.addObject("fxjdm","");
		mv.addObject("pcsdm","");
		mv.addObject("zrqdm","");
		// 添加登录人的部门基本和DODE
		OrgOrganization orgOrganization = orgOrganizationService
				.queryById(sessionBean.getUserOrgId());
		String level = orgOrganization.getOrglevel();
		 if ("31".equals(level)) {
			mv.addObject("fxjdm",sessionBean.getUserOrgCode());
		} else if ("32".equals(level)) {
			mv.addObject("pcsdm",sessionBean.getUserOrgCode());
		} else if ("50".equals(level)) {
			mv.addObject("zrqdm",sessionBean.getUserOrgCode());
		}
		 entity.setGlbmid(sessionBean.getUserOrgCode());
		 mv.addObject("dwjbxxb", entity);
		return mv;
	}

	/**
	 * 保存-实有单位
	 * 
	 * @param swjbxxbSaveVO
	 * @param hsrwid
	 * @param dwlbdm
	 * @return
	 */
	@RequestMapping(value = "/saveDwjbxxb", method = RequestMethod.POST)
	public ModelAndView saveDwjbxxb(DwjbxxbSaveVO swjbxxbSaveVO, String hsrwid) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		Dwjbxxb dwjbxxb = swjbxxbSaveVO.getDwjbxxb();
		Dwbmxxb[] dwbmxxbArray = swjbxxbSaveVO.getDwbmxxbArray();
		SessionBean sessionBean = getSessionBean();
		try {

			if (StringUtils.isBlank(dwjbxxb.getId())) {
				dwjbxxbService.save(dwjbxxb, dwbmxxbArray, hsrwid, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, getAddSuccess());
				model.put(AppConst.SAVE_ID, "" + dwjbxxb.getId()); // 返回主键
			} else {
				dwjbxxbService.update(dwjbxxb, dwbmxxbArray, hsrwid,
						sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, getUpdateSuccess());
				model.put(AppConst.SAVE_ID, "" + dwjbxxb.getId()); // 返回主键
			}

		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}

	/**
	 * 实有单位 核实页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/createHs", method = RequestMethod.GET)
	public ModelAndView createHs(String dwidString, String dwid,
			String mainTabID) throws BussinessException {
		ModelAndView mv = new ModelAndView("sydw/dwjbxxbAddHs");
		mv.addObject("mainTabID", mainTabID);
		SessionBean sessionBean = getSessionBean();
		if (sessionBean != null) {
			mv.addObject("pcsdm", sessionBean.getExtendValue("ssPcsCode"));
			mv.addObject("zrqdm", sessionBean.getUserOrgCode());
			mv.addObject("pcsmc", sessionBean.getExtendValue("ssPcsName"));
			mv.addObject("fsxdm", sessionBean.getExtendValue("ssFsxCode"));
			mv.addObject("fsxmc", sessionBean.getExtendValue("ssFsxName"));
			mv.addObject("dsjdm", sessionBean.getExtendValue("ssDsjCode"));
			mv.addObject("dsjmc", sessionBean.getExtendValue("ssDsjName"));
		}
		mv.addObject("dwidString", dwidString);
		if (!StringUtils.isBlank(dwidString)) {
			String[] jzdzidArray = dwidString.split(",");
			if (StringUtils.isBlank(dwid)) {
				dwid = jzdzidArray[0];
			}
			String nextDwid = "";
			for (int i = 0; i < jzdzidArray.length; i++) {
				if (dwid.equals(jzdzidArray[i])) {
					if (i + 1 < jzdzidArray.length) {
						nextDwid = jzdzidArray[i + 1];
						break;
					}
				}
			}
			mv.addObject("nextDwid", nextDwid);
			Dwjbxxb entity = dwjbxxbService.queryWhsById(dwid);
			List<Dwbmxxb> dwbmxxbArray = new ArrayList<Dwbmxxb>();
			List<Dwbmxxb> bmlist = null;
			if (entity != null) {
				bmlist = dwjbxxbService.queryDwbmxxbByDwid(entity.getId());
			}
			if (bmlist != null) {
				dwbmxxbArray.addAll(bmlist);
			}
			if (dwbmxxbArray.size() == 0) {
				dwbmxxbArray.add(new Dwbmxxb());
			}
			mv.addObject("dwbmxxbArray", dwbmxxbArray);
			mv.addObject("dwbmxxbArrayLength", dwbmxxbArray.size());
			mv.addObject("fxjdm","");
			mv.addObject("pcsdm","");
			mv.addObject("zrqdm","");
			// 添加登录人的部门基本和DODE
			OrgOrganization orgOrganization = orgOrganizationService
					.queryById(sessionBean.getUserOrgId());
			String level = orgOrganization.getOrglevel();
			 if ("31".equals(level)) {
				mv.addObject("fxjdm",sessionBean.getUserOrgCode());
			} else if ("32".equals(level)) {
				mv.addObject("pcsdm",sessionBean.getUserOrgCode());
			} else if ("50".equals(level)) {
				mv.addObject("zrqdm",sessionBean.getUserOrgCode());
			}
			 entity.setGlbmid(sessionBean.getUserOrgCode());
			 mv.addObject("dwjbxxb", entity);

		} else {
			throw new BussinessException("sydw.notExist");
		}
		return mv;
	}

	/**
	 * @Title: createRoomHs
	 * @描述: 实有单位房间 核实页面
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-9-16 下午7:40:40
	 * @返回值: ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/createRoomHs", method = RequestMethod.GET)
	public ModelAndView createRoomHs(String dwidString, String dwid,
			String jzdzssxdm, String jzdmlpdm, String jzdmlpxz, String bzdzdm,
			String bzdzmc) throws BussinessException {
		ModelAndView mv = new ModelAndView("sydw/dwjbxxbAddHs");
		SessionBean sessionBean = getSessionBean();
		if (sessionBean != null) {
			mv.addObject("pcsdm", sessionBean.getExtendValue("ssPcsCode"));
			mv.addObject("zrqdm", sessionBean.getUserOrgCode());
			mv.addObject("pcsmc", sessionBean.getExtendValue("ssPcsName"));
			mv.addObject("fsxdm", sessionBean.getExtendValue("ssFsxCode"));
			mv.addObject("fsxmc", sessionBean.getExtendValue("ssFsxName"));
			mv.addObject("dsjdm", sessionBean.getExtendValue("ssDsjCode"));
			mv.addObject("dsjmc", sessionBean.getExtendValue("ssDsjName"));
		}
		mv.addObject("dwidString", dwidString);
		if (!StringUtils.isBlank(dwidString)) {
			String[] jzdzidArray = dwidString.split(",");
			if (StringUtils.isBlank(dwid)) {
				dwid = jzdzidArray[0];
			}
			String nextDwid = "";
			for (int i = 0; i < jzdzidArray.length; i++) {
				if (dwid.equals(jzdzidArray[i])) {
					if (i + 1 < jzdzidArray.length) {
						nextDwid = jzdzidArray[i + 1];
						break;
					}
				}
			}
			mv.addObject("nextDwid", nextDwid);
			Dwjbxxb dwjbxxb = dwjbxxbService.queryWhsById(dwid);
			dwjbxxb.setDz_dwdzdm(bzdzdm);
			dwjbxxb.setDz_dwdzmlpdm(jzdmlpdm);
			dwjbxxb.setDz_dwdzmlpxz(jzdmlpxz);
			dwjbxxb.setDz_dwdzssxdm(jzdzssxdm);
			dwjbxxb.setDz_dwdzxz(bzdzmc);
			if (dwjbxxb != null) {
				mv.addObject("dwjbxxb", dwjbxxb);
				mv.addObject("type", "RoomHs");

			}
		} else {
			throw new BussinessException("sydw.notExist");
		}
		return mv;
	}

	/**
	 * 校验是否存在单位<br>
	 * 
	 * @param dwmc
	 * @param dz_dwdzdm
	 * @return
	 */
	@RequestMapping(value = "/queryExistDw", method = RequestMethod.POST)
	public @ResponseBody
	Map queryExistDw(String id, String dz_dwdzdm, String dwmc) {
		Map<String, Object> model = new HashMap<String, Object>();
		boolean isExist = dwjbxxbService.queryExistDw(id, dz_dwdzdm, dwmc);
		model.put("isExist", "" + isExist);
		return model;
	}

	/**
	 * 数据复用（暂时不用）<br>
	 * 
	 * @param dwmc
	 * @param dz_dwdzdm
	 * @return
	 */
	@RequestMapping(value = "/queryDwxx", method = RequestMethod.POST)
	public @ResponseBody
	Map applyData(String dwmc, String dz_dwdzdm) {
		Map<String, Object> model = new HashMap<String, Object>();
		Dwjbxxb dwjbxxb = dwjbxxbService.queryByDwmcDwdzdm(dwmc, dz_dwdzdm);
		model.put("dwjbxxb", dwjbxxb);
		return model;
	}

	/**
	 * (编辑主页面->基本信息->编辑)
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/editDwjbxxb", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView edit(String id) {
		ModelAndView mv = new ModelAndView("sydw/dwjbxxbAdd");
		Dwjbxxb entity = new Dwjbxxb();
		entity.setId(id);
		if (!StringUtils.isBlank(id)) {
			entity = dwjbxxbService.query(entity);
		}
		mv.addObject("dwjbxxb", entity);
		SessionBean sessionBean = getSessionBean();
		if (sessionBean != null) {
			mv.addObject("pcsdm", sessionBean.getExtendValue("ssPcsCode"));
			mv.addObject("zrqdm", sessionBean.getUserOrgCode());
			mv.addObject("pcsmc", sessionBean.getExtendValue("ssPcsName"));
			mv.addObject("fsxdm", sessionBean.getExtendValue("ssFsxCode"));
			mv.addObject("fsxmc", sessionBean.getExtendValue("ssFsxName"));
			mv.addObject("dsjdm", sessionBean.getExtendValue("ssDsjCode"));
			mv.addObject("dsjmc", sessionBean.getExtendValue("ssDsjName"));
		}
		return mv;
	}

}
