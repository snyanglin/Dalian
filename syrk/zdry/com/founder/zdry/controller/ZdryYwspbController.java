package com.founder.zdry.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdry.service.ZdryYwspbService;
import com.founder.zdry.vo.ZdryYwspbVo;

/***
 * ****************************************************************************
 * 
 * @Package: [com.founder.zdry.controller.ZdryYwspbController.java]
 * @ClassName: [ZdryYwspbController]
 * @Description: [审批表controller]
 * @Author: [wu_chunhui@founder.com.cn]
 * @CreateDate: [2015-3-24 下午4:47:36]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-3-24 下午4:47:36，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@Controller
@RequestMapping(value = "zdryYwspb")
public class ZdryYwspbController extends BaseController {
	
	private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "zdryYwspbService")
	private ZdryYwspbService zdryYwspbService;
	
	
	/**
	 * @Title: query
	 * @Description: TODO(查询列表页面)
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public ModelAndView query() {
		ModelAndView mv = new ModelAndView("zdry/zdryYwspbList");
		return mv;
	}
	
	/**
	 * 
	 * @Title: queryList
	 * @Description: 列表
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return EasyUIPage 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryList(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, ZdryYwspbVo entity,
			SessionBean sessionBean) {
		sessionBean = getSessionBean(sessionBean);
		page.setPagePara(rows);
		 EasyUIPage easyUIPage =zdryYwspbService.queryList(entity, page, sessionBean);
		 return easyUIPage;
	}
}
