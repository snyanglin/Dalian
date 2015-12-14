package com.founder.zafffwqz.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.framework.utils.UUID;
import com.founder.zafffwqz.bean.Gzjsdmtxxb;
import com.founder.zafffwqz.bean.Gzjsxxb;
import com.founder.zafffwqz.service.GzjsxxbService;

import com.google.gson.Gson;


@Controller
@RequestMapping(value = "/gzjs")
public class GzjsxxbController extends BaseController {
private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name="gzjsxxbService")
	private GzjsxxbService gzjsxxbService;
	
	/**
	 * 附件管理
	 * @param gzjsid
	 * @return
	 */
	@RequestMapping(value = "/uploadImg", method = RequestMethod.GET)
	public ModelAndView uploadImg(String gzjsid){
		ModelAndView mv = new ModelAndView("zafffwqz/gzjsUpload");
		String tmpPath = "";
		String tmpFileName = "";
		File tmpFile = null;
		FileOutputStream fos = null;
		List<String> currIdList = null;
		List<Gzjsdmtxxb> list = gzjsxxbService.queryGzjsdmtxxb(gzjsid);
		try {
			tmpPath = getRequest().getSession().getServletContext().getRealPath("tmpImg");
			File dir = new File(tmpPath);
			if(!dir.exists()){
				dir.mkdir();
			}
			currIdList = new ArrayList<String>();
			for(Gzjsdmtxxb entity : list){
				tmpFileName = String.valueOf(new Date().getTime());
				tmpFile = new File(tmpPath, tmpFileName);
				if(!tmpFile.exists()){
					tmpFile.createNewFile();
					fos = new FileOutputStream(tmpFile);
					fos.write(entity.getGzjsxczp());
					fos.flush();
					fos.close();
					currIdList.add(tmpFileName);
				}
			}
			mv.addObject("currIdList", currIdList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(fos != null){
				try {
					fos.close();
					fos = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return mv;
	}
	
	/**
	 * 保存单个/全部附件
	 * @param gzjsid
	 * @param cmfile
	 * @param uploadFileId
	 * @param totalIdArray
	 * @param changedFileId
	 * @return
	 */
	@RequestMapping(value = "/saveTmpImg", method = RequestMethod.POST)
	@ResponseBody
	public Object saveTmpImg(String gzjsid, @RequestParam CommonsMultipartFile[] cmfile, String[] uploadFileId, String totalUploadIdArray, String changedFileId){
		String tmpPath = "";
		String tmpFileName = "";
		File tmpFile = null;
		FileOutputStream fos = null;
		FileInputStream fis = null;
		byte[] bytes = null;
		try {
			tmpPath = getRequest().getSession().getServletContext().getRealPath("tmpImg");
			File dir = new File(tmpPath);
			if(!dir.exists()){
				dir.mkdir();
			}
			if(!StringUtils.isBlank(changedFileId)){//编辑单张图片，非保存操作
				for(int i = 0; i < uploadFileId.length; i++){
					if(changedFileId.equals(uploadFileId[i])){
						CommonsMultipartFile file = cmfile[i];
						tmpFileName = uploadFileId[i];
						tmpFile = new File(tmpPath, tmpFileName);
						tmpFile.createNewFile();
						if(tmpFile != null){
							fos = new FileOutputStream(tmpFile);
							fos.write(file.getBytes());
							fos.flush();
							fos.close();
						}
					}
				}
			}else{//保存操作，非编辑单张图片
				ModelAndView mv = new ModelAndView("redirect:/forward/"
						+ AppConst.FORWORD);
				Map<String, Object> model = new HashMap<String, Object>();
				try {
					gzjsxxbService.deleteGzjsdmtxxb(gzjsid);
					for(int i = 0; i < cmfile.length; i++){
						CommonsMultipartFile file = cmfile[i];
						Gzjsdmtxxb entity = new Gzjsdmtxxb();
						entity.setGzjsid(gzjsid);
						if(file.getBytes().length == 0){//读取出的、未编辑的文件
							tmpFile = new File(tmpPath, uploadFileId[i]);
							if(tmpFile.exists()){
								fis = new FileInputStream(tmpFile);
								bytes = new byte[(int)tmpFile.length()];
								fis.read(bytes);
								entity.setGzjsxczp(bytes);
								fis.close();
							}
						}else{
							entity.setGzjsxczp(file.getBytes());
						}
						gzjsxxbService.insertGzjsdmtxxb(entity, getSessionBean());
					}
					//清空临时文件
					String[] idArray = totalUploadIdArray.split(",");
					for(String id : idArray){
						tmpFile = new File(tmpPath, id);
						if(tmpFile.exists()){
							tmpFile.delete();
						}
					}
					model.put(AppConst.STATUS, AppConst.SUCCESS);
					model.put(AppConst.MESSAGES, "保存【工作纪实现场照片附件】成功！");
				} catch (Exception e) {
					e.printStackTrace();
					logger.error(e.getLocalizedMessage(), e);
					model.put(AppConst.STATUS, AppConst.FAIL);
					model.put(AppConst.MESSAGES, getAddFail());
				}
				mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
				return mv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(fis != null){
				try {
					fis.close();
					fis = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fos != null){
				try {
					fos.close();
					fos = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "/tmpImg/"+tmpFileName;
	}
	
	/**
	 * 取消新建工作纪实时，清除已保存的附件
	 * @param gzjsid
	 */
	@RequestMapping(value = "/deleteWithCancel", method = RequestMethod.GET)
	public ModelAndView deleteWithCancel(String gzjsid){
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		try {
			gzjsxxbService.deleteGzjsdmtxxb(gzjsid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	/**
	 * 未提交保存工作纪实附件时，清除附件的临时文件
	 * @param gzjsid
	 */
	@RequestMapping(value = "/deleteTmpFileWithCancel", method = RequestMethod.GET)
	public ModelAndView deleteTmpFileWithCancel(String idArrayStr){
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		String tmpPath = "";
		String tmpFileName = "";
		File tmpFile = null;
		try {
			tmpPath = getRequest().getSession().getServletContext().getRealPath("tmpImg");
			if(idArrayStr != null){
				String[] idArray = idArrayStr.split(",");
				for(int i = 0; i < idArray.length; i++){
					tmpFileName = idArray[i];
					tmpFile = new File(tmpPath, tmpFileName);
					if(tmpFile.exists()){
						tmpFile.delete();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	/**
	 * 跳转-工作纪实
	 * @param ryid
	 * @return
	 */
	@RequestMapping(value = "/addGzjsxxb", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView addGzjsxxb(String id) {
		ModelAndView mv = new ModelAndView("zafffwqz/gzjsadd");
		Gzjsxxb entity = new Gzjsxxb();
		String flag ="add";
		try {
			if (!StringUtils.isBlank(id)) {
				entity.setId(id);
				entity = gzjsxxbService.queryGzjsxxb(entity);
				flag ="update";
			}else{
				//鉴于有附件，先预置id
				entity.setId(UUID.create());
			}
			mv.addObject("flag", flag);
			mv.addObject("entity", entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 保存-工作纪实
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/saveGzjsxxb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveGzjsxxb(Gzjsxxb entity, String flag) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if ("add".equals(flag)) {
				gzjsxxbService.saveGzjsxxb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【工作纪实】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				gzjsxxbService.updateGzjsxxb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【工作纪实】成功！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryList(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows,String gzjszldm,String gzjshbsj,String gzjshbdd) {
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		Map map=new HashMap();
		if(!"".equals(gzjszldm)&&gzjszldm!=null){
			map.put("gzjszldm", gzjszldm);
		}else{
			map.put("gzjszldm", null);
		}
		if(!"".equals(gzjshbsj)&&gzjshbsj!=null){
			map.put("gzjshbsj", gzjshbsj);
		}else{
			map.put("gzjshbsj", null);
		}
		if(!"".equals(gzjshbdd)&&gzjshbdd!=null){
			map.put("gzjshbdd", gzjshbdd);
		}else{
			map.put("gzjshbdd", null);
		}
		
		map.put("xt_lrrbmid", sessionBean.getUserOrgCode());
		
		return gzjsxxbService.queryList(page, map);
	}
	
	/**
	 * 注销-工作纪实
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView DeleteGzjsxxb(Gzjsxxb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() != null) { // 注销
				gzjsxxbService.delete(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "注销【工作纪实】成功！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getMessage("cancel.fail"));
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
}
