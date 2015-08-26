/**********************************************************************   
 * <p>文件名：ZakhJbxxCjController.java </p>
 * <p>文件描述：治安考核-基本信息采集控制类
 * @project_name：syrk
 * @author wu.w@founder.com.cn 
 * @date 2015-4-17 上午8:55:02 
 * @history
 * @department：研发部
 *
 */
package com.founder.gzjk.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.utils.DateUtils;
import com.founder.gzjk.bean.Gzltjb;
import com.founder.gzjk.service.GzltjService;

/******************************************************************************
 * @Package: [com.founder.zakh.controller.ZakhJbxxCjController.java]
 * @ClassName: [ZakhJbxxCjController]
 * @Description: [治安考核-基本信息采集控制类]
 * @Author: [wu.w@founder.com.cn]
 * @CreateDate: [2015-4-17 上午8:55:02]
 * @UpdateUser: [Way(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-4-17 上午8:55:02，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */

@Controller
@RequestMapping("gzltj")
public class GzltjController extends BaseController {
	//private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "gzltjService")
	private GzltjService gzltjService;

	/**
	 * 
	 * @Title: kh
	 * @Description: 进行考核统计
	 * @param bweek
	 * @param eweek
	 * @param orgid
	 * @return json对象
	 * @throws
	 */
	@RequestMapping(value = "/count", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> gzltj(String startDate, String endDate,
			String orgCode, String level) {
		// 查询参数
		Map<String, String> parameterObject = new HashMap<String, String>();
		parameterObject.put("startDate", startDate);
		parameterObject.put("endDate", endDate);
        String groupByOrgType="";

		if("1".equals(level)){
			groupByOrgType="GXFJDM";

		}
		else if ("2".equals(level)) {
			parameterObject.put("orgCode", orgCode);
			groupByOrgType="GXPCSDM";

		}
		else if ("3".equals(level)) {
			groupByOrgType= "GXZRQDM";
			parameterObject.put("orgCode", orgCode);
		} 
		parameterObject.put("groupByOrgType", groupByOrgType);

		Map<String, Object> resMap = new HashMap<String, Object>();// 返回用

		List<Gzltjb> list = gzltjService.queryGzltj(parameterObject);

		resMap.put("rows", list);
		resMap.put("total", list.size());
		return resMap;
	}
	
	/**
	 * 补充工作量统计数据
	 * @param startDate
	 * @param endDate
	 */
	@RequestMapping(value = "/bcgzltjsj", method = RequestMethod.GET)
	public @ResponseBody Map<String,String> bcgzltjsj(String startDate, String endDate){

		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		 Map<String,String> resMap=new HashMap<String, String>();
		try {
			Date endTime=sdf.parse(endDate);
			String nowSting = sdf.format(new Date());			
			Date nowTime=sdf.parse(nowSting);
			//校验endTime不能大于当前日期
			if(endTime.after(nowTime)||endTime.equals(nowTime)){
				throw new BussinessException("截止日期不能超过系统当前日期！");
 
			}
			this.gzltjService.bcgzltjsj(startDate, endDate);
			resMap.put("result","success");

		} catch (ParseException e) {
			e.printStackTrace();
			resMap.put("result", "error");
		}
		return resMap;
	}
	
	/**
	 * excel导出功能
	 * @Title: gzltjb_export
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param startDate
	 * @param @param endDate
	 * @param @param orgCode
	 * @param @param level
	 * @param @param response    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/gzltjb_export")
	public void gzltjb_export(String startDate, String endDate,
			String orgCode, String level, HttpServletResponse response){
		response.setContentType("application/binary;charset=UTF-8");
		try {
			ServletOutputStream outputStream = response.getOutputStream();
			String fileName = new String(("工作量统计表").getBytes(), "ISO8859-1");
			response.setHeader("Content-disposition", "attachment;filename=gzltj_gzltjb_" + DateUtils.getSystemDateString() + ".xlsx");
			
			// 查询参数
			Map<String, String> parameterObject = new HashMap<String, String>();
			parameterObject.put("startDate", startDate);
			parameterObject.put("endDate", endDate);
	        String groupByOrgType="";

			if("1".equals(level)){
				groupByOrgType="GXFJDM";

			}
			else if ("2".equals(level)) {
				parameterObject.put("orgCode", orgCode);
				groupByOrgType="GXPCSDM";

			}
			else if ("3".equals(level)) {
				groupByOrgType= "GXZRQDM";
				parameterObject.put("orgCode", orgCode);
			} 
			parameterObject.put("groupByOrgType", groupByOrgType);


			List<Gzltjb> list = gzltjService.queryGzltj(parameterObject);

			this.gzltjService.exportGzltjb(level,list, outputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
