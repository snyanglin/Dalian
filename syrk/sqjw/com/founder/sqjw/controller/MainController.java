package com.founder.sqjw.controller;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.utils.EasyUIPage;
import com.founder.sqjw.service.MainService;
import com.founder.sqjw.vo.MainVo;
/**
 * @类名: MainController 
 * @描述: 主页Controller
 * @作者: zhang_guoliang@founder.com 
 * @日期: 2015-8-14 下午6:20:53
 */
@Controller
@RequestMapping("/main")
public class MainController extends BaseController{
	@Resource(name = "mainService")
	private MainService mainService;
	/**
	 * @Title: queryPcsXqgkTj
	 * @描述: 查询派出所辖区概况统计
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @返回值: EasyUIPage    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/queryPcsXqgkTj",method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryPcsXqgkTj(EasyUIPage page,@RequestParam(value = "rows",required=false) Integer rows,MainVo entity){
		return mainService.queryPcsXqgkTj(page,entity);
	}
	/**
	 * @Title: queryPcsXqgkXq 
	 * @描述: 查询派出所辖区概况详情
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @返回值: EasyUIPage    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/queryPcsXqgkXq",method = RequestMethod.POST)
	public @ResponseBody List<MainVo> queryPcsXqgkXq(MainVo entity){
		return mainService.queryPcsXqgkXq(entity);
	}
}