package com.founder.syrkgl.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.founder.framework.annotation.RestfulAnnotation;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.syrkgl.bean.RyRyjbxxb;
import com.founder.syrkgl.service.RyRyjbxxbService;
import com.founder.syrkgl.vo.SyrkZtxx;

/******************************************************************************
 * @Package: [com.founder.syrkgl.controller.SyrkGlController.java]
 * @ClassName: [SyrkGlController]
 * @Description: [人员基本信息]
 * @Author: [hongguanjun]
 * @CreateDate: [2015-4-3 下午1:50:49]
 * @UpdateUser: [hongguanjun(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-4-3 下午1:50:49，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@Controller
@RequestMapping(value = "ryRyjbxxb")
public class RyRyjbxxbController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "ryRyjbxxbService")
	private RyRyjbxxbService ryRyjbxxbService;

	/**
	 * @Title: dataApply
	 * @Description: TODO(人员基本信息复用)
	 * @param @param syrkgllbdm
	 * @param @param ryid
	 * @param @return 设定文件
	 * @return Map 返回类型
	 * @throws
	 */
	@RestfulAnnotation(valiField = "cyzjdm,zjhm", serverId = "3")
	@RequestMapping(value = "/dataApply", method = RequestMethod.POST)
	public @ResponseBody
	Map dataApply(String cyzjdm, String zjhm, SessionBean sessionBean) {
		Map<String, Object> map = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		RyRyjbxxb ryRyjbxxb = ryRyjbxxbService.dataApply(cyzjdm, zjhm,
				sessionBean);
		if (ryRyjbxxb == null) {
			ryRyjbxxb = new RyRyjbxxb();
		}
		try{
			SyrkZtxx ztxx = ryRyjbxxbService.getZtxx(zjhm);
	        if(StringUtils.isNotBlank(ztxx.getZtrysfzh())){
	    		map.put("ztxx", ztxx);
	        }
		}catch(Exception e){			
			e.printStackTrace();
		}
		map.put("ryRyjbxxb", ryRyjbxxb);
		return map;
	}

	/**
	 * 补充人员照片信息（调用省厅服务，取没有照片的人员照片，浏览器输入url直接调用）
	 * @param sessionBean
	 * @return
	 */
	@RequestMapping(value = "/bcPhoto", method = RequestMethod.GET)
	public @ResponseBody Map<String,Object> bcPhoto(SessionBean sessionBean) {
		sessionBean = getSessionBean(sessionBean);
		Date startDate=new Date();

		long count = ryRyjbxxbService.bcPhoto(sessionBean);
		
		Date endDate=new Date();

		Map<String,Object> map=new HashMap<String, Object>();
		map.put("补充条数", count);
		map.put("用时", String.valueOf(((endDate.getTime()-startDate.getTime())/1000))+"秒");
		return map;
	}
	
	/**
	 * 补充人员照片信息（调用省厅服务，取没有照片的人员照片,浏览器输入url直接调用）
	 * @param sessionBean
	 * @return
	 */
	@RequestMapping(value = "/bcRyjbxx", method = RequestMethod.GET)
	public @ResponseBody Map<String,Object> bcRyjbxx(SessionBean sessionBean) {
		sessionBean = getSessionBean(sessionBean);
		Date startDate=new Date();
		long count = ryRyjbxxbService.bcRyJbxx(sessionBean);
		
		Date endDate=new Date();

		Map<String,Object> map=new HashMap<String, Object>();
		map.put("补充条数", count);
		map.put("用时", String.valueOf(((endDate.getTime()-startDate.getTime())/1000))+"秒");
		return map;
	}
}