package com.founder.shhxxcj.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

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
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.framework.utils.UUID;
import com.founder.shhxxcj.bean.Enterprises;
import com.founder.shhxxcj.bean.Houses;
import com.founder.shhxxcj.service.EnterprisesService;
import com.founder.shhxxcj.service.HousesService;
import com.founder.syfw.bean.Czfwxxb;
import com.founder.syfw.bean.Fwjbxxb;
import com.founder.syfw.vo.FwEditVO;
import com.founder.syrkgl.bean.RyRyjbxxb;
import com.founder.syrkgl.bean.RyRylxfsxxb;
import com.founder.syrkgl.service.RyRyjbxxbService;
import com.founder.syrkgl.service.RyRylxfsxxbService;

import com.google.gson.Gson;


/******************************************************************************
 * @Package:      [com.mos.shhxxcj.controller.HousesController.java]  
 * @ClassName:    [HousesController]   
 * @Description:  [社会化信息采集 房屋核实]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015-9-15 下午3:12:41]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-9-15 下午3:12:41，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Controller
@RequestMapping(value = "/shhxxcj")
public class HousesController extends BaseController {


	@Resource
	private RyRyjbxxbService ryRyjbxxbService;
	
	@Resource
	private HousesService housesService;
	
	@Resource
	private RyRylxfsxxbService ryRylxfsxxbService;
	
	@Resource
	private EnterprisesService enterprisesService;
	
	/**
	 * @Title: query
	 * @Description: TODO(实有人口管理列表页面)
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/houseList", method = RequestMethod.GET)
	public ModelAndView query() {
		ModelAndView mv = new ModelAndView("shhxxcj/housesList");
		return mv;
	}

	/**
	 * @Title: queryList
	 * @描述: 查询实有人口管理列表数据【服务接口】
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-4-14 上午11:18:01
	 * @返回值: EasyUIPage 返回类型
	 * @throws
	 */
	@RestfulAnnotation(serverId = "3")
	@RequestMapping(value = "/queryHousesList", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryList(EasyUIPage page,
			@RequestParam(value = "rows", required = false) Integer rows,
			Houses entity, SessionBean sessionBean) {
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);

				
		return housesService.queryList(entity, page,sessionBean);
	}
	
	@RequestMapping(value = "/czfwhs", method = RequestMethod.GET)
	public ModelAndView czfwhs(String id, String mainTabID,
			String invokeJSMethod, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView("shhxxcj/czfwhs");
		sessionBean = getSessionBean(sessionBean);

		Fwjbxxb fwjbxxb=new Fwjbxxb();
		
		Houses houses=this.housesService.queryById(id);
		
		Enterprises enterprise = enterprisesService.queryById(houses.getEnterpriseid());
		
		fwjbxxb.setFwcqzh(houses.getFwcqh());
		fwjbxxb.setFwjs(Long.valueOf(houses.getFwjs()));
		fwjbxxb.setFwmj_mjpfm(Double.valueOf(houses.getFwmj()));
		fwjbxxb.setSfczfw("1");
		fwjbxxb.setBz(houses.getBz());
        if("居民身份证".equals(houses.getFzzjlb())){
        	RyRyjbxxb ryjbxxb = ryRyjbxxbService.dataApply("111", houses.getFzzjhm(), sessionBean);
        	fwjbxxb.setFz_cyzjdm("111");
        	fwjbxxb.setFz_ryid(ryjbxxb.getId());
			if (StringUtils.isBlank(ryjbxxb.getLxdh())) {
				ryjbxxb.setLxdh(houses.getFzyddh());
				RyRylxfsxxb lxfs = new RyRylxfsxxb();
				lxfs.setRyid(ryjbxxb.getId());
				lxfs.setLxfslxdm("1");// 手机
				lxfs.setLxfs(houses.getFzyddh());
				lxfs.setBz("从社会化信息采集房屋核实加进来的");
				lxfs.setId(UUID.create());
				this.ryRylxfsxxbService.save(lxfs, sessionBean);

			}
        }
    	fwjbxxb.setFz_zjhm(houses.getFzzjhm());
    	fwjbxxb.setFz_xm(houses.getXm());
    	fwjbxxb.setFz_lxdh(houses.getFzyddh());

		
		Czfwxxb czfwxxb=new Czfwxxb();
		czfwxxb.setCz_rq(houses.getCzrq());
		czfwxxb.setZj(Double.valueOf(houses.getZj()));
		
		mv.addObject("mainTabID", mainTabID);
		mv.addObject("invokeJSMethod", invokeJSMethod);
		mv.addObject("housesId", id);

		mv.addObject("nowtime", DateUtils.getShortString(new Date()));
		mv.addObject("zrqdm", sessionBean.getUserOrgCode());
		mv.addObject("fwjbxxb",fwjbxxb);
		mv.addObject("czfwxxb",czfwxxb);
		mv.addObject("enterprises",enterprise);

		
		return mv;
	}
	
	@RequestMapping(value = "/saveCzfwhs", method = {RequestMethod.POST})
	public @ResponseBody ModelAndView saveCzfwhs(FwEditVO vo ,SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();

		sessionBean = getSessionBean(sessionBean);
		Fwjbxxb entity = vo.getFwjbxxb();
		entity.setSs2jbmdm(sessionBean.getExtendValue("ssFsxCode"));
		entity.setSs3jbmdm(sessionBean.getExtendValue("ssPcsCode"));
		entity.setSs4jbmdm(sessionBean.getUserOrgCode());
		try {
				if(!StringUtils.isBlank(vo.getCzfwxxb().getZazrr_id()) &&!StringUtils.isBlank(vo.getCzfwxxb().getZazrr_xm())
						&&!StringUtils.isBlank(vo.getCzfwxxb().getZrs_qd_rq())){
					vo.getCzfwxxb().setFwid(entity.getId());					
					this.housesService.saveCzfwhs(entity, vo.getCzfwxxb(),vo.getHousesId(), sessionBean);
				}else{
					model.put(AppConst.STATUS, AppConst.FAIL);
					model.put(AppConst.MESSAGES, "治安责任人ID、姓名和责任书签订日期不能为空！");
				}

			
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "新增【实有房屋信息】成功！");
			model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键

		} catch (Exception e) {
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
}