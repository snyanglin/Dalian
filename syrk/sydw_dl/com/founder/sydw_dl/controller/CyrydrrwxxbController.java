/**********************************************************************   
 * <p>文件名：cyrydrrwxxbController.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu_chunhui@founder.com.cn 
 * @date 2014-11-26 下午4:05:43 
 * @history
 * @department：研发部
 *
*/
package com.founder.sydw_dl.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.config.SystemConfig;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.sydw_dl.bean.Cyrydrrwxxb;
import com.founder.sydw_dl.bean.Dwjbxxb;
import com.founder.sydw_dl.service.CyrydrrwxxbService;
import com.founder.sydw_dl.service.DwjbxxbService;

import com.google.gson.Gson;

/******************************************************************************
 * @Package:      [com.founder.sydw_dl.controller.cyrydrrwxxbController.java]  
 * @ClassName:    [cyrydrrwxxbController]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2014-11-26 下午4:05:43]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2014-11-26 下午4:05:43，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */

@Controller
@RequestMapping(value = "cyrydrrwxxb_dl")
public class CyrydrrwxxbController extends BaseController {


	private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "cyrydrrwxxbService")
	private CyrydrrwxxbService cyrydrrwxxbService;
	@Resource(name = "dwjbxxbService")
	private DwjbxxbService dwjbxxbService;
	
	
	@RequestMapping(value = "/createPage", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView createPage(String dwid) {
		ModelAndView mv = new ModelAndView("sydw_dl/dwcyrydrrwView");
		mv.addObject("dwid", dwid);
		return mv;
	}
	
	/***
	 * 
	 * @Title: view
	 * @Description: TODO(查询任务列表展现)
	 * @param @param page
	 * @param @param rows
	 * @param @param dwid
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public @ResponseBody
	EasyUIPage view(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows,String dwid){
		SessionBean sessionBean = getSessionBean();
		page.setPagePara(rows);
		return cyrydrrwxxbService.queryByDwId(sessionBean, dwid, page);
	} 
	
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@RequestParam("uploadFile") MultipartFile uploadFile,
			String dwid, String fileOnly){
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		Cyrydrrwxxb cyrydrrwxxb = new Cyrydrrwxxb();
		SessionBean sessionBean = getSessionBean();
		EasyUIPage page = new EasyUIPage();
		//验证当前是否又任务在上传如果有直接跳出
		
		if(!uploadFile.isEmpty()){
			cyrydrrwxxb.setRwmc(uploadFile.getOriginalFilename());
			cyrydrrwxxb.setDwid(dwid);
			Dwjbxxb dwjb=new Dwjbxxb();
			dwjb.setId(dwid);
			dwjb=dwjbxxbService.query(dwjb);
			cyrydrrwxxb.setDwmc(dwjb.getDwmc());
			cyrydrrwxxb.setRwsm(DateUtils.getSystemDateString()+"导入");
			cyrydrrwxxbService.saveEntity(cyrydrrwxxb,sessionBean);
			//解析excel内容
			
			try {
				/*//新启线程后台上传
				ImportToCyry imp = new ImportToCyry(uploadFile.getInputStream(), sessionBean, dwid);
				imp.run();*/
				String fileName= uploadFile.getOriginalFilename();
				fileName=fileName.substring(fileName.lastIndexOf('.'),fileName.length());
				cyrydrrwxxbService.importToCyry(uploadFile.getInputStream(), sessionBean, cyrydrrwxxb.getId(),fileName);
			} catch (IOException e) {
				e.printStackTrace();
			}
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "文件上传中，请稍后！");
			
		}else{
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, "未上传文件");
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	
	@RequestMapping(value = "/exportTemplate")
	public void exprotTemplate(HttpServletRequest request,HttpServletResponse response){
		response.setContentType("application/binary;charset=UTF-8");
		ServletOutputStream outputStream = null;
		try {
			outputStream = response.getOutputStream();
			String path = SystemConfig.getString("webRootPath")+"/upload";
			String fileName="cyry_template.xls";
			File file= new File(path+"/"+fileName);
			response.setHeader("Content-disposition", "attachment;filename="+URLEncoder.encode(fileName, "UTF-8"));
			FileInputStream in = new FileInputStream(file);
			byte bytes[]=new byte[1024];
			int len=0;
			while((len=in.read(bytes))!=-1){
				outputStream.write(bytes, 0, len);
			}
			outputStream.flush();
			outputStream.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				outputStream.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
