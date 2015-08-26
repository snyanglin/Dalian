package com.founder.gis.controller;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.framework.annotation.RestfulAnnotation;
import com.founder.framework.base.controller.BaseController;
import com.founder.gis.service.GisService;
import com.founder.gis.vo.GisVo;
/**
 * @类名: GisController 
 * @描述: 地图应用【公共组件】
 * @作者: zhang_guoliang@founder.com 
 * @日期: 2015-3-11 下午6:14:30 
 */
@Controller
@RequestMapping(value = "gis")
public class GisController extends BaseController{
	@Resource(name = "gisService")
	private GisService gisService;
	/**
	 * @Title: queryMapBz 
	 * @描述: 获取地图坐标点信息【所属派出所、责任区信息】
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: ZBX【坐标X】、ZBY【坐标Y】
	 * @日期： 2015-3-11 下午6:40:38 
	 * @返回值: GisVo    返回类型 
	 * @throws
	 */
	@RestfulAnnotation(valiField="zbx,zby",serverId = "3")
	@RequestMapping(value = "/queryMapBz", method = RequestMethod.POST)
	public @ResponseBody GisVo queryMapBz(GisVo entity){
		return gisService.queryMapBz(entity);
	}
}