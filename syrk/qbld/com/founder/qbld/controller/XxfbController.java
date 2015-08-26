package com.founder.qbld.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.qbld.bean.XxfbArticle;
import com.founder.qbld.bean.XxfbClass;
import com.founder.qbld.service.XxfbService;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.controller.XxfbController.java]  
 * @ClassName:    [XxfbController]   
 * @Description:  [信息发布控制器]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-6-26 上午9:18:32]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-26 上午9:18:32，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Controller
@RequestMapping(value = "xxfb")
public class XxfbController extends BaseController {
	
	@Resource(name = "xxfbService")
	private XxfbService xxfbService;
	
	/**
	 * @Title: queryClassList
	 * @Description: TODO(信息发布类型列表查询)
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryClassList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryClassList(EasyUIPage page,
			@RequestParam(value = "rows", required=false) Integer rows, 
			XxfbClass entity,
			SessionBean sessionBean){
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		return xxfbService.queryClassList(page, entity);
	}
	
	/**
	 * @Title: queryArticleListFive
	 * @Description: TODO(取得前五条信息发布内容列表)
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryArticleListFive", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryArticleListFive(EasyUIPage page,
			@RequestParam(value = "rows", required=false) Integer rows, 
			XxfbArticle entity,
			SessionBean sessionBean){
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		return xxfbService.queryArticleListFive(page, entity);
	}
	
	/**
	 * @Title: queryArticleList
	 * @Description: TODO(信息发布内容列表查询)
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryArticleList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryArticleList(EasyUIPage page,
			@RequestParam(value = "rows", required=false) Integer rows, 
			XxfbArticle entity,
			SessionBean sessionBean){
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		return xxfbService.queryArticleList(page, entity);
	}
	
	/**
	 * @Title: queryArticle
	 * @Description: TODO(信息发布详情)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return XxfbArticle    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryArticle", method = RequestMethod.POST)
	public @ResponseBody XxfbArticle queryArticle(XxfbArticle entity){
		return xxfbService.queryArticle(entity);
	}
	
}