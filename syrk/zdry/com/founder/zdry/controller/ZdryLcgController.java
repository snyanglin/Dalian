package com.founder.zdry.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.annotation.RestfulAnnotation;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.config.SystemConfig;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.exception.RestException;
import com.founder.framework.organization.assign.service.OrgOrgAssignUserService;
import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.StringUtils;
import com.founder.service.attachment.bean.ZpfjFjxxb;
import com.founder.service.attachment.service.ZpfjFjxxbService;
import com.founder.syrkgl.bean.RyRyjbxxb;
import com.founder.syrkgl.bean.RyZyjwryxxb;
import com.founder.syrkgl.service.RyRyjbxxbService;
import com.founder.zdry.bean.ZdryHsb;
import com.founder.zdry.bean.ZdryLczywblb;
import com.founder.zdry.bean.ZdryYwspb;
import com.founder.zdry.bean.ZdryZdryzb;
import com.founder.zdry.bean.Zdrylxylbdyb;
import com.founder.zdry.dao.ZdryHsbDao;
import com.founder.zdry.dao.ZdryZdryzbDao;
import com.founder.zdry.service.ZdryHsbService;
import com.founder.zdry.service.ZdryLcgService;
import com.founder.zdry.service.ZdryLczywblbService;
import com.founder.zdry.service.ZdryYwspbService;
import com.founder.zdry.service.ZdrylxylbdybService;
import com.founder.zdry.vo.ZdryVO;
import com.founder.zdry.vo.ZdryZdryzbVO;

import com.google.gson.Gson;

/***
 * ****************************************************************************
 * 
 * @Package: [com.founder.zdry.controller.ZdryLcgController.java]
 * @ClassName: [ZdryLcgController]
 * @Description: [列撤管业务]
 * @Author: [wu_chunhui@founder.com.cn]
 * @CreateDate: [2015-3-12 下午3:55:50]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-3-12 下午3:55:50，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@Controller
@RequestMapping("zdryLcg")
public class ZdryLcgController extends BaseController {
	private Logger logger = Logger.getLogger(this.getClass());
	@Resource(name = "zdryLcgService")
	private ZdryLcgService zdryLcgService;
	@Resource(name = "ryRyjbxxbService")
	private RyRyjbxxbService ryRyjbxxbService;
	@Resource(name = "zdryZdryzbDao")
	private ZdryZdryzbDao zdryZdryzbDao;
	@Resource(name = "zdryYwspbService")
	private ZdryYwspbService zdryYwspbService;
	@Resource(name = "zdrylxylbdybService")
	private ZdrylxylbdybService zdrylxylbdybService;
	@Resource(name = "zdryLczywblbService")
	private ZdryLczywblbService zdryLczywblbService;
	@Resource(name = "zdryHsbService")
	private ZdryHsbService zdryHsbService;
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;
	@Resource(name = "orgOrgAssignUserService")
	private OrgOrgAssignUserService orgOrgAssignUserService;
	@Resource(name = "zdryHsbDao")
	private ZdryHsbDao zdryHsbDao;

	@Resource(name = "zpfjFjxxbService")
	private ZpfjFjxxbService zpfjFjxxbService;

	/***
	 * 
	 * @Title: createLg
	 * @Description: TODO
	 * @author wu_chunhui@founder.com.cn
	 * @param @param ryid
	 * @param @return
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping(value = "/createLcg/{ywlx}", method = RequestMethod.GET)
	public ModelAndView createLg(String syrkid,
			@RequestParam(required = true) String ryid,
			@PathVariable(value = "ywlx") String ywlx, String zdrygllxdm,
			String zdryHsbId) {
		SessionBean sessionBean = getSessionBean();
		ModelAndView mv = new ModelAndView("zdry/zdryLcg");
		List<ZdryZdryzbVO> zdryZdList = null;
		if (!StringUtils.isBlank(ryid)) {
			zdryZdList = zdryZdryzbDao.queryZdryVoByRyid(ryid);
		}

		ZdryZdryzbVO zdryZdryzbVO = new ZdryZdryzbVO();
		if (zdryZdList != null && zdryZdList.size() > 0) {// 不是第一次，取得已经列管的类型
			zdryZdryzbVO = zdryZdList.get(0);
			Map<String, String> map = zdryLcgService
					.getZdryGlLxByList(zdryZdList,syrkid);
			mv.addAllObjects(map);
		} else {// 查询列管对象的姓名，身份等基本信息
			// 等待实有人口改造，后期添加,根据居住地址查询信息
			RyRyjbxxb ryjbxxb = ryRyjbxxbService.queryById(ryid);
			if(ryjbxxb!=null){
			zdryZdryzbVO.setXm(ryjbxxb.getXm());
			zdryZdryzbVO.setCyzjdm("111");// 身份证
			zdryZdryzbVO.setZjhm(ryjbxxb.getZjhm());
			}
		}
		
		if(!org.apache.commons.lang.StringUtils.isBlank(zdryHsbId)){
			ZdryHsb zdryHsb = this.zdryHsbDao.queryById(zdryHsbId);
			if(zdryHsb != null){
				mv.addObject("zdrygllxdm", zdryHsb.getZdrygllxdm());
				mv.addObject("zdrylbdm", zdryHsb.getZdrylbdm());
				mv.addObject("glffdm",zdryHsb.getZdrk_glffdm());
				mv.addObject("lglydm",zdryHsb.getZdrk_lglydm());
			}
		}
		
		zdryZdryzbVO.setSyrkid(syrkid);
		ZdryLczywblb zdryLczywblb = new ZdryLczywblb();
		zdryLczywblb.setYwblr_id(sessionBean.getUserId());
		zdryLczywblb.setYwblr_xm(sessionBean.getUserName());
		zdryLczywblb.setYwclsj(DateUtils.getSystemDateString());
		mv.addObject("zdryZdryzbVO", zdryZdryzbVO);
		mv.addObject("zdryLczywblb", zdryLczywblb);
		mv.addObject("ywlx", ywlx);
		mv.addObject("zdrygllxdm", zdrygllxdm);
		mv.addObject("zdryHsbId", zdryHsbId);

		return mv;
	}

	/***
	 * 
	 * @Title: saveLg
	 * @Description: 列管保存逻辑。
	 * @author wu_chunhui@founder.com.cn
	 * @param @return
	 * @return ModelAndView
	 * @throws
	 */
	@RestfulAnnotation(valiField = "zdryZdryzb.ryid,zdryZdryzb.syrkid,zdryZdryzb.zdrygllxdm,zdryLczywblb.ywblr_xm,zdryLczywblb.ywblr_id,zdryLczywblb.ywfqyy,zdryLczywblb.ywclsj", serverId = "3")
	@RequestMapping(value = "/saveLg", method = RequestMethod.POST)
	public ModelAndView saveLg(ZdryVO zdryVO,@RequestParam(value="uploadFile") CommonsMultipartFile[] uploadFile,  SessionBean sessionBean,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
	    String placeVersion = SystemConfig.getString("PlaceVersion");
		try {
			if (!StringUtils.isBlank(zdryVO.getZdryHsbId())) {
				zdryLcgService.saveLg(zdryVO, ZdryLczywblb.NOAPPROVALTYPE,
						sessionBean);
				ZdryHsb zdryHsb = zdryHsbService.queryById(zdryVO.getZdryHsbId());
				zdryHsb.setHszt("1");
				zdryHsbService.update(zdryHsb, sessionBean);
			} else {
				Map<String, String> map = zdryLcgService.saveLg(zdryVO, ZdryLczywblb.NORMALTYPE,
						sessionBean);

				if("辽宁省厅版".equals(placeVersion) && "01".equals(zdryVO.getZdryZdryzb().getZdrygllxdm())){
					List<ZpfjFjxxb> list = new ArrayList<ZpfjFjxxb>();

					for (int i = 0; i < uploadFile.length; i++) {
						CommonsMultipartFile multipartFile = uploadFile[i];
						if (!multipartFile.isEmpty()) {
							FileItem fileItem = multipartFile.getFileItem();
							ZpfjFjxxb entity = new ZpfjFjxxb();
							entity.setLybm("ZDRY_ZDRYZB");
							entity.setLyid(zdryVO.getZdryZdryzb().getId());
							entity.setLyms("社区矫正人员-判决书");
							String wjmc = fileItem.getName();
							if (wjmc.indexOf("\\") != -1) { // 去除完整路径
								wjmc = wjmc.substring(wjmc.lastIndexOf("\\") + 1);
							}
							String wjhzlx = "";
							int atI = wjmc.lastIndexOf(".");
							if (atI != -1) {
								wjhzlx = wjmc.substring(atI + 1);
								wjhzlx = wjhzlx.toLowerCase();
							}
							entity.setWjmc(wjmc);
							entity.setWjhzlx(wjhzlx);
							entity.setWj(multipartFile.getBytes());
							long wjdx = entity.getWj().length;
							entity.setWjdx(new Long(wjdx));
							String wjdxsm = "";
							if (wjdx < 1024) {
								wjdxsm = "" + wjdx + " B";
							} else if (wjdx > 1048576) {
								double mb = Math.floor(wjdx / 1048576);
								DecimalFormat formater = new DecimalFormat(
										"###,###,###.00");
								wjdxsm = "" + formater.format(mb) + " MB";
							} else {
								long kb = (long) Math.floor(wjdx / 1024);
								wjdxsm = "" + kb + " KB";
							}
							entity.setWjdxsm(wjdxsm);
							entity.setWjxzcs(new Long(0));
							list.add(entity);
						}
					}
					if (list.size() > 0) {
						zpfjFjxxbService.saveZpfjFjxxb(list, sessionBean);
						model.put(AppConst.STATUS, AppConst.SUCCESS);
						model.put(AppConst.MESSAGES, getAddSuccess());
					}
				}
				
			}

			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, getAddSuccess());
		}catch(BussinessException e){
			e.printStackTrace();
			new RestException(e.getLocalizedMessage());
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, e.getLocalizedMessage());
		}
		catch (Exception e) {
			e.printStackTrace();
			new RestException(e.getLocalizedMessage());
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}

	/***
	 * 
	 * @Title: saveCg
	 * @Description: 撤管保存逻辑。
	 * @author wu_chunhui@founder.com.cn
	 * @param @return
	 * @return ModelAndView
	 * @throws
	 */
	@RestfulAnnotation(valiField = "zdryZdryzb.ryid,zdryZdryzb.syrkid,cglxdm,zdryZdryzb.zdrygllxdm,zdryLczywblb.ywblr_xm,zdryLczywblb.ywblr_id,zdryLczywblb.ywfqyyzdryLczywblb.ywclsj", serverId = "3")
	@RequestMapping(value = "/saveCg", method = RequestMethod.POST)
	public ModelAndView saveCg(ZdryVO zdryVO, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryLcgService.saveCg(zdryVO, ZdryLczywblb.NORMALTYPE, sessionBean,
					zdryVO.getCglxdm());
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, getAddSuccess());
		} 
		catch(BussinessException e){
			e.printStackTrace();
			new RestException(e.getLocalizedMessage());
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, e.getLocalizedMessage());
		}catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}

	/***
	 * 
	 * @Title: creatLgApporval
	 * @Description: 列撤管审批页面生成、跳转
	 * @author wu_chunhui@founder.com.cn
	 * @param @param zdryId
	 * @param @return
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping(value = "/creatLcgApporval", method = RequestMethod.GET)
	public ModelAndView creatLgApporval(String zdryYwspbId, String messageid,String openType,String spdj) {
		ModelAndView mv = new ModelAndView("zdry/zdryLCApproval");
		SessionBean sessionBean = getSessionBean();
		ZdryYwspb zdryYwspb = zdryYwspbService.queryById(zdryYwspbId);
		if(StringUtils.isBlank(zdryYwspb.getSpjg())){
		zdryYwspb.setSpbm(sessionBean.getUserOrgCode());
		zdryYwspb.setSpr_id(sessionBean.getUserId());
		zdryYwspb.setSpr_xm(sessionBean.getUserName());
		zdryYwspb.setSpsj(DateUtils.getSystemDateString());
		}else {
			openType="view";
		}
		ZdryLczywblb zdryLczywblb = zdryLczywblbService.queryById(zdryYwspb
				.getYwbid());
		ZdryZdryzb zdryZdryzb = zdryZdryzbDao.queryById(zdryLczywblb
				.getZdryid());
		//这里修改申请人加上单位信息
		OrgOrganization  zrqOrg =orgOrganizationService.queryByOrgcode(zdryZdryzb.getSszrqdm());
		OrgOrganization  pcsOrg =orgOrganizationService.queryByOrgcode(zdryZdryzb.getSspcsdm());
		OrgOrganization  fxjOrg =orgOrganizationService.queryByOrgcode(zdryZdryzb.getSsfxjdm());
		if(zrqOrg!=null&&pcsOrg!=null&&fxjOrg!=null){
		zdryYwspb.setSqr_xm(fxjOrg.getOrgname()+pcsOrg.getOrgname()+zrqOrg.getOrgname()+zdryYwspb.getSqr_xm());
		}
		
		ZdryVO zdryVO = new ZdryVO();
		//取得小类
		zdryVO.setZdrylbStr(zdryLcgService.getALLZdrylb(zdryZdryzb.getId()));
		zdryVO.setZdryZdryzb(zdryZdryzb);
		zdryVO.setZdryYwspb(zdryYwspb);
		mv.addObject("zdryVO", zdryVO);
		mv.addObject("messageid", messageid);
		mv.addObject("openType", openType);
		mv.addObject("spdj", spdj);
		
		return mv;
	}

	/***
	 * 
	 * @Title: getZdrylbdmExceptYlg
	 * @Description: 根据大类取小类,去掉已列管
	 * @author wu_chunhui@founder.com.cn
	 * @param @return
	 * @return String
	 * @throws
	 */
	@RequestMapping(value = "/getZdrylbdmExceptYlg", method = RequestMethod.POST)
	public @ResponseBody
	String getZdrylbdmExceptYlg(String zdrylxdm, String syrkid) {
		String zdrylbdm = "";
		List<Zdrylxylbdyb> zdrylbdmList = zdrylxylbdybService
				.queryZdrylbdm(zdrylxdm);
		List<String> zdrylbdmListStr = zdryLcgService.getZdrylbdmExceptYlg(
				zdrylbdmList, syrkid);
		for (int i = 0; i < zdrylbdmListStr.size(); i++) {
			if (i == zdrylbdmListStr.size() - 1) {
				zdrylbdm += zdrylbdmListStr.get(i);
			} else {
				zdrylbdm += zdrylbdmListStr.get(i) + "|";
			}
		}
		return zdrylbdm;
	}
	
	
	@RequestMapping(value = "/getYlgZdrylbdm", method = RequestMethod.POST)
	public @ResponseBody
	String getYlgZdrylb(String syrkid) {
		String zdrylbdm = "";
		List<String> zdrylbdmListStr = zdryLcgService.getYlgZdrylb(syrkid);
		for (int i = 0; i < zdrylbdmListStr.size(); i++) {
			if (i == zdrylbdmListStr.size() - 1) {
				zdrylbdm += zdrylbdmListStr.get(i);
			} else {
				zdrylbdm += zdrylbdmListStr.get(i) + "|";
			}
		}
		return zdrylbdm;
	}
	

	/***
	 * 
	 * @Title: updateZdryYwspb
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param lcgxxb
	 * @param @param type
	 * @param @param messageid
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/updateZdryYwspb", method = RequestMethod.POST)
	public ModelAndView updateLcgxxb(ZdryYwspb zdryYwspb, String messageid,
			SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		
		try {
			zdryYwspb.setSpbm(sessionBean.getUserOrgCode());
			zdryYwspbService.updateZdryYwspb(zdryYwspb, sessionBean, messageid);
			zdryLczywblbService.changeStateByYwjg(zdryYwspb.getYwbid(),
					sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, getUpdateSuccess());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getUpdateFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * @Title: edit
	 * @Description: TODO(重点人员信息编辑)
	 * @param @param id
	 * @param @return
	 * @param @throws BussinessException 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RestfulAnnotation(serverId = "3")
	@RequestMapping(value = "/zdryEdit", method = RequestMethod.GET)
	public ModelAndView edit( String zdryid,
			SessionBean sessionBean) throws BussinessException {
			ModelAndView mv = new ModelAndView("zdry/zdryUpdate");
			ZdryVO zdryVO =zdryLcgService.queryByZdrylx(zdryid);
			mv.addObject("zdryVO", zdryVO);
			return mv;
	}
	
	
	/***
	 * 
	 * @Title: update
	 * @Description: 保存修改！
	 * @author wu_chunhui@founder.com.cn
	 * @param @return
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(ZdryVO zdryVO, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryLcgService.updateByZdrylx(zdryVO,sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, getUpdateSuccess());
		}catch(BussinessException e){
			e.printStackTrace();
			new RestException(e.getLocalizedMessage());
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, e.getLocalizedMessage());
		}
		catch (Exception e) {
			e.printStackTrace();
			new RestException(e.getLocalizedMessage());
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getUpdateFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	

}
