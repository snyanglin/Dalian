/**********************************************************************   
 * <p>文件名：CyrydrrwmxbComtroller.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu_chunhui@founder.com.cn 
 * @date 2014-12-3 下午05:45:49 
 * @history
 * @department：研发部
 *
*/
package com.founder.sydw.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.sydw.service.CyrydrrwmxbService;
import com.founder.sydw.service.SydwEditService;

/******************************************************************************
 * @Package:      [com.founder.sydw.controller.CyrydrrwmxbComtroller.java]  
 * @ClassName:    [CyrydrrwmxbComtroller]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2014-12-3 下午05:45:49]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2014-12-3 下午05:45:49，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Controller
@RequestMapping(value = "cyrydrrwmxb")
public class CyrydrrwmxbController extends BaseController {
	
	@Resource(name = "cyrydrrwmxbService")
	private CyrydrrwmxbService cyrydrrwmxbService;
	
	@Resource(name="sydwEditService")
	private SydwEditService sydwEditService;
	
	@RequestMapping(value = "/createPage", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView createPage(String rwid) {
		ModelAndView mv = new ModelAndView("sydw/cyrydrrwmxbDetail");
		mv.addObject("rwid", rwid);
		return mv;
	}
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public @ResponseBody
	EasyUIPage view(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows,String rwid){
		SessionBean sessionBean = getSessionBean();
		page.setPagePara(rows);
		return cyrydrrwmxbService.queryByRwId(sessionBean, rwid, page);
	} 
	
	@RequestMapping(value = "/export")
	public void cyryxxb_query_all_export(String rwid, HttpServletResponse response){
		response.setContentType("application/binary;charset=UTF-8");
		try {
			ServletOutputStream outputStream = response.getOutputStream();
			String fileName = new String(("导入反馈表").getBytes(), "ISO8859-1");
			response.setHeader("Content-disposition", "attachment;filename=dw_cyryxxb_" + DateUtils.getSystemDateString() + ".xlsx");
			String[] titleArray = {"身份证号码","姓名 ","性别","出生日期","居住地址","联系电话","工作部门","工种","进公司时间"};
			String[] keyArray = {"zjhm","xm","xbdm","csrq","dz_xzzxz","lxdh","szbmmc","zylbdm","pysj"};
			List<Map<String, String>> list = cyrydrrwmxbService.cyrydrrwmxb_query_all_export(rwid);
			sydwEditService.exportExcel(titleArray, keyArray, list, outputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
