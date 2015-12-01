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
package com.founder.zakh.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.StringUtils;
import com.founder.zakh.bean.ZakhCjclBean;
import com.founder.zakh.service.ZakhCjclService;
import com.founder.zakh.service.ZakhJbxxCjService;
import com.founder.zakh.tools.Dateutil;
import com.founder.zakh.vo.KhfstjVO;

import com.google.gson.Gson;

/******************************************************************************
 * @Package:      [com.founder.zakh.controller.ZakhJbxxCjController.java]  
 * @ClassName:    [ZakhJbxxCjController]   
 * @Description:  [治安考核-基本信息采集控制类]   
 * @Author:       [wu.w@founder.com.cn]  
 * @CreateDate:   [2015-4-17 上午8:55:02]   
 * @UpdateUser:   [Way(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-17 上午8:55:02，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */

@Controller
@RequestMapping("zakh")
public class ZakhJbxxCjController extends BaseController {
	private Logger logger = Logger.getLogger(this.getClass());
	@Resource(name = "zakhCjclService")
	private ZakhCjclService clservice;
	
	@Resource(name = "zakhJbxxCjService")
	private ZakhJbxxCjService jbxxcjservice;
	

	/**
	 * 
	 * @Title: queryKh
	 * @Description: 上级组织查询考核
	 * @param @param khnf
	 * @param @param khz
	 * @param @param orgid
	 * @param @param zzjgdj 组织机构登记（分局fj,派出所pcs,责任区zrq）
	 * @param @return    设定文件
	 * @return Map<String,Object>    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/count" ,method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> queryKh(String khnf,String khz,String orgid,String zzjgdj){
		if(orgid==null||"".equals(orgid)){
			SessionBean user=getSessionBean();
			orgid=user.getUserOrgCode();
		}
		//return null;
		Map<String,String> map=new HashMap<String, String>();
		map.put("year", khnf);
		map.put("week", khz);
		map.put("zzjgdj", zzjgdj);
		map.put("orgCode", orgid);
		return jbxxcjservice.queryKhtj(map);
	}
	
	

	/**
	 * 每次补充一周的数据(只要输入的日期在要补充的那周的第一天)
	 * @Title: bckhfstj
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param date    格式为'2015-05-05'
	 * @return void    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/bckhfstj" ,method = RequestMethod.GET)
	public @ResponseBody Map<String,String> bckhfstj(String weekStartDate){
		Map<String,String> map=new HashMap<String, String>();
        try{
    		this.jbxxcjservice.bckhfstj(weekStartDate);
    		map.put("result", "success");
        }catch(Exception ex){
        	map.put("result", "failed");
        	ex.printStackTrace();
        }
        return map;
	}
	
	/**
	 * 补充某个组织的考核分数统计
	 * @Title: bckhfstj
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param weekStartDate
	 * @param @param orgCode
	 * @param @return    设定文件
	 * @return Map<String,String>    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/bckhfstjByOrgCode" ,method = RequestMethod.GET)
	public @ResponseBody Map<String,String> bckhfstj(String weekStartDate,String orgCode){
		Map<String,String> map=new HashMap<String, String>();
        try{
    		this.jbxxcjservice.bckhfstjByOrgCode(weekStartDate,orgCode);
    		map.put("result", "success");
        }catch(Exception ex){
        	map.put("result", "failed");
        	ex.printStackTrace();
        }
        return map;
	}
	
	/**
	 * 
	 * @Title: kh
	 * @Description: 根据周进行考核统计
	 * @param bweek
	 * @param eweek
	 * @param orgid
	 * @return json对象
	 * @throws
	 */
	@RequestMapping(value = "/countXX" ,method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> khxx(int year,String week,String orgid){

	    Dateutil dt=new Dateutil();
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    String startDate=formatter.format(dt.getFirstDayOfWeek(year,Integer.valueOf(week)));
	    String endDate = formatter.format(dt.getLastDayOfWeek(year,Integer.valueOf(week)));
	    Map<String,String> paramMap=new HashMap<String, String>();
	    paramMap.put("startDate", startDate);
	    paramMap.put("endDate", endDate);
	    paramMap.put("orgCode", orgid);

	    Map<String,Object> resMap = jbxxcjservice.queryXXByGzltj(paramMap);
		return resMap;
	}
	
	@RequestMapping(value = "/zakh_export")
	public void cyryxxb_query_all_export(String khnf,String khz,String orgid,String zzjgdj, HttpServletResponse response){

		response.setContentType("application/binary;charset=UTF-8");
		try {
			ServletOutputStream outputStream = response.getOutputStream();
			String fileName = new String(("工作量统计表").getBytes(), "ISO8859-1");
			response.setHeader("Content-disposition", "attachment;filename=zakh_" + DateUtils.getSystemDateString() + ".xlsx");
			
			
			if(orgid==null||"".equals(orgid)){
				SessionBean user=getSessionBean();
				orgid=user.getUserOrgCode();
			}
			//return null;
			Map<String,String> map=new HashMap<String, String>();
			map.put("year", khnf);
			map.put("week", khz);
			map.put("zzjgdj", zzjgdj);
			map.put("orgCode", orgid);
			Map<String,Object> resMap = jbxxcjservice.queryKhtj(map);			
			this.jbxxcjservice.exportExcel((List<KhfstjVO>)resMap.get("rows"), outputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @Title: queryCjCl
	 * @Description: 得到采集常量
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/getCl" ,method = RequestMethod.POST)
	public ModelAndView queryCjCl(String orgid){
		ModelAndView mv = new ModelAndView("zakh/zakhIndex");
		List<ZakhCjclBean> list = clservice.query(orgid);
		mv.addObject("cjclList", list);
		return mv;
	}
	
	/**
	 * 
	 * @Title: saveCjCl
	 * @Description: 保存/更新采集常量
	 * @param @param entity
	 * @param @param session
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveCl" ,method = RequestMethod.POST)
	public ModelAndView saveCjCl(ZakhCjclBean entity, SessionBean session){
		ModelAndView mv = new ModelAndView("redirect:/forward/"+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			if(StringUtils.isBlank(entity.getCl())){
				clservice.save(entity);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "保存成功");
			}else{
				entity.setUpduser(session.getUserId());
				entity.setUpddate(DateUtils.getSystemDateString());
				clservice.update(entity);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "更新成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, "操作失败");
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * 
	 * @Title: deleteCjCl
	 * @Description: 删除采集常量
	 * @param @param entity
	 * @param @param session
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/delCl" ,method = RequestMethod.POST)
	public ModelAndView deleteCjCl(String orgid, SessionBean session){
		ModelAndView mv = new ModelAndView("redirect:/forward/"+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			clservice.delete(orgid);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, "删除失败");
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
}
