package com.founder.zdry.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.annotation.RestfulAnnotation;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.StringUtils;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
import com.founder.syrkgl.dao.SyrkSyrkxxzbDao;
import com.founder.zdry.bean.ZdryLczywblb;
import com.founder.zdry.bean.ZdryZdryzb;
import com.founder.zdry.dao.ZdryZdryzbDao;
import com.founder.zdry.service.ZdryLcgService;
import com.founder.zdry.service.ZdryLczywblbService;
import com.founder.zdry.service.ZdryZdService;
import com.founder.zdry.vo.ZdryZdryzbVO;

import com.google.gson.Gson;

/***
 * ****************************************************************************
 * 
 * @Package: [com.founder.zdry.controller.ZdryZdController.java]
 * @ClassName: [ZdryZdController]
 * @Description: [转递业务]
 * @Author: [wu_chunhui@founder.com.cn]
 * @CreateDate: [2015-3-12 下午3:56:09]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-3-12 下午3:56:09，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@Controller
@RequestMapping("zdryZd")
public class ZdryZdController extends BaseController {
	private Logger logger = Logger.getLogger(this.getClass());
	@Resource(name = "zdryZdryzbDao")
	private ZdryZdryzbDao zdryZdryzbDao;
	@Resource(name = "zdryLcgService")
	private ZdryLcgService zdryLcgService;
	@Resource(name = "zdryLczywblbService")
	private ZdryLczywblbService zdryLczywblbService;
	@Resource(name = "zdryZdService")
	private ZdryZdService zdryZdService;
	@Resource(name = "syrkSyrkxxzbDao")
	private SyrkSyrkxxzbDao syrkSyrkxxzbDao;

	/***
	 * 
	 * @Title: createLg
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param syrkid
	 * @param @param ryid
	 * @param @param ywlx
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/createZd", method = RequestMethod.GET)
	public ModelAndView createZd(String syrkid) {
		SessionBean sessionBean = getSessionBean();
		ModelAndView mv = new ModelAndView("zdry/zdryZd");
		List<ZdryZdryzbVO> zdryZdList = null;
		ZdryZdryzbVO zdryZdryzbVO = null;
		if (!StringUtils.isBlank(syrkid)) {
			zdryZdList = zdryZdryzbDao.queryZdryBySyrkid(syrkid);
		}
		if (zdryZdList != null && zdryZdList.size() > 0) {// 不是第一次，取得已经列管的类型
			Map<String, String> map = zdryLcgService
					.getZdryGlLxByList(zdryZdList,syrkid);
			mv.addAllObjects(map);
			zdryZdryzbVO = zdryZdList.get(0);
		}
		ZdryLczywblb zdryLczywblb = new ZdryLczywblb();
		zdryLczywblb.setYwblr_id(sessionBean.getUserId());
		zdryLczywblb.setYwblr_xm(sessionBean.getUserName());
		zdryLczywblb.setYwclsj(DateUtils.getSystemDateString());
		mv.addObject("zdryZdryzbVO", zdryZdryzbVO);
		mv.addObject("zdryLczywblb", zdryLczywblb);
		return mv;
	}

	/***
	 * 
	 * @Title: saveZd
	 * @Description: TODO重点人员转递保存逻辑
	 * @param @param zdryLczywblb
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RestfulAnnotation(valiField = "ygxzrqdm,ygxpcsdm,zdrygllxdm,syrkid,ryid,sspcsdm,sszrqdm,ywfqyy,dz_jzdzdm,dz_jzdzxz,dz_jzdzmlpdm,dz_jzdzmlpxz,ywblr_xm,ywblr_id", serverId = "3")
	@RequestMapping(value = "/saveZd", method = RequestMethod.POST)
	public ModelAndView saveZd(ZdryLczywblb zdryLczywblb,
			ZdryZdryzbVO zdryZdryzbVO, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			//zdryLczywblb.setSspcsdm(zdryZdryzbVO.getYgxpcsdm());
			//zdryLczywblb.setSszrqdm(zdryZdryzbVO.getYgxzrqdm());
			zdryZdService.sendZd(zdryLczywblb, zdryZdryzbVO, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "转递发起成功");
		} catch (Exception e) {
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
	 * @Title: createZdjs
	 * @Description: TODO(打开转递接收或者裁决页面)
	 * @param @param zdryLczywblbId
	 * @param @param messageid
	 * @param @param type
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/createZdjs", method = RequestMethod.GET)
	public ModelAndView createZdjs(String zdryLczywblbId, String messageid,
			String type, SessionBean sessionBean,String openType) {
		sessionBean = getSessionBean(sessionBean);
		ModelAndView mv = new ModelAndView("zdry/zdjs");
		
		
		ZdryLczywblb jsywb;
		ZdryLczywblb fqywb;
		ZdryLczywblb cjywb = null;
		if ("sjcj".equals(type)) {
			cjywb = zdryLczywblbService.queryById(zdryLczywblbId);// 这里取得裁决业务
			jsywb = zdryLczywblbService.queryById(cjywb.getQxywid());// 这里取得接收业务
			fqywb = zdryLczywblbService.queryById(jsywb.getQxywid());// 这里取得发起业务
			if("2".equals(jsywb.getYwcljg())){
				jsywb.setYwcljg("0");
			}
		} else {
			jsywb = zdryLczywblbService.queryById(zdryLczywblbId);// 这里取得接收业务
			fqywb = zdryLczywblbService.queryById(jsywb.getQxywid());// 这里取得发起业务
			jsywb.setYwblr_xm(sessionBean.getUserName());
			if("2".equals(jsywb.getYwcljg())){
				jsywb.setYwcljg("0");
			}
		}
		
		ZdryZdryzb zdryZdryzb = zdryZdryzbDao.queryById(jsywb.getZdryid());
		//查询本辖区转递人员的实有人口信息,如果没有则新增加实有人口
		Map<String,String> map= new HashMap<String,String>();
		map.put("gxzrqdm", jsywb.getSszrqdm());
		map.put("zjhm", zdryZdryzb.getZjhm());
		List<SyrkSyrkxxzb> list = syrkSyrkxxzbDao.queryHsbSyrkidByZjhm(map);
		//实有人口查询end
		
		mv.addObject("ryjzdzList", list);
		mv.addObject("jsywb", jsywb);
		if(!StringUtils.isBlank(jsywb.getYwcljg())&&!"sjcj".equals(type)){
			openType="view";
		}else if(cjywb!=null&&!StringUtils.isBlank(cjywb.getYwcljg())){
			openType="view";
		}
		
		mv.addObject("fqywb", fqywb);
		mv.addObject("cjywb", cjywb);
		mv.addObject("type", type);
		mv.addObject("openType",openType);
		mv.addObject("zdryZdryzb", zdryZdryzb);
		mv.addObject("messageid", messageid);
		return mv;
	}

	/***
	 * 
	 * @Title: receiveZd
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param messageid
	 * @param @param zdryLczywblb
	 * @param @param cyly
	 * @param @param cjjgdm
	 * @param @param type
	 * @param @param xgxzrqdm
	 * @param @param xgxpcsdm
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveZdjs", method = RequestMethod.POST)
	public ModelAndView receiveZd(String messageid, ZdryLczywblb zdryLczywblb,
			String cyly, String cjjgdm, String type, String xgxzrqdm,
			String xgxpcsdm, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			if (type.equals("sjcj")) {
				zdryLczywblb.setYwfqyy(cyly);
				// 这里页面审批结果和业务表不对应,手动转递
				if ("0".equals(cjjgdm)) {// 拒绝
					zdryLczywblb.setYwcljg("2");
				} else if ("1".equals(cjjgdm)) {// 同意
					zdryLczywblb.setYwcljg("1");
				}
				zdryZdService.ruleZd(messageid, zdryLczywblb, sessionBean);
			} else {
				// 这里页面审批结果和业务表不对应,手动转递
				if ("0".equals(zdryLczywblb.getYwcljg())) {// 拒绝
					zdryLczywblb.setYwcljg("2");
				} else if ("1".equals(zdryLczywblb.getYwcljg())) {// 同意
					zdryLczywblb.setYwcljg("1");
				}
				zdryZdService.receiveZd(messageid, zdryLczywblb, sessionBean, xgxzrqdm,
						 xgxpcsdm);
			}
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, getAddSuccess());
		} catch (Exception e) {
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
	 * @Title: ruleZd
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param messageid
	 * @param @param zdryLczywblb
	 * @param @param sessionBean
	 * @param @param cjjgdm
	 * @param @param sp_cjly
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveZdcj", method = RequestMethod.POST)
	public ModelAndView ruleZd(String messageid, ZdryLczywblb zdryLczywblb,
			SessionBean sessionBean, String cjjgdm, String sp_cjly) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		// 这里放入裁决人,和裁决信息
		zdryLczywblb.setYwcljg(cjjgdm);
		zdryLczywblb.setYwfqyy(sp_cjly);
		try {
			zdryZdService.ruleZd(messageid, zdryLczywblb, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, getAddSuccess());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}

}
