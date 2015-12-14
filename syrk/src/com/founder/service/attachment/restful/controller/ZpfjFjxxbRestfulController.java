package com.founder.service.attachment.restful.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import com.founder.framework.annotation.RestfulAnnotation;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.config.SystemConfig;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.service.attachment.bean.ZpfjFjxxb;
import com.founder.service.attachment.service.ZpfjFjxxbService;

import com.google.gson.Gson;
/**
 * ****************************************************************************
 * @Package:      [com.founder.service.attachment.restful.ZpfjFjxxbRestful.java]  
 * @ClassName:    [ZpfjFjxxbRestful]   
 * @Description:  [照片与附件REST服务]   
 * @Author:       [weiwen]  
 * @CreateDate:   [2015-3-25 下午2:53:14]   
 * @UpdateUser:   [weiwen]   
 * @UpdateDate:   [2015-3-25 下午2:53:14，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Controller
@RequestMapping("/fj")
public class ZpfjFjxxbRestfulController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "zpfjFjxxbService")
	private ZpfjFjxxbService zpfjFjxxbService;

	/**
	 * 
	 * @Title: save
	 * @Description: TODO(附件上传)
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @param uploadFile
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RestfulAnnotation(serverId="33" ,valiField="lybm,lyid,lyms")
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody ModelAndView save(ZpfjFjxxb entity,SessionBean sessionBean,
			@RequestParam(required = false) CommonsMultipartFile[] uploadFile	) {
		ModelAndView mv = new ModelAndView(AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			List<ZpfjFjxxb> list = new ArrayList<ZpfjFjxxb>();
			if(uploadFile != null){
				for (int i = 0; i < uploadFile.length; i++) {
					CommonsMultipartFile multipartFile = uploadFile[i];
					if (!multipartFile.isEmpty()) {
						FileItem fileItem = multipartFile.getFileItem();
						String wjmc = fileItem.getName();
						if (wjmc.indexOf("\\") != -1)  // 去除完整路径
							wjmc = wjmc.substring(wjmc.lastIndexOf("\\") + 1);
						String wjhzlx = "";
						int atI = wjmc.lastIndexOf(".");
						if (atI != -1) {
							wjhzlx = wjmc.substring(atI + 1);
							wjhzlx = wjhzlx.toLowerCase();
						}
						entity.setWjmc(wjmc);
						entity.setWjhzlx(wjhzlx);
						entity.setWj(multipartFile.getBytes());
						long wjdx = entity.getWj().length;
						entity.setWjdx(new Long(wjdx));
						String wjdxsm = "";
						if (wjdx < 1024) {
							wjdxsm = "" + wjdx + " B";
						} else if (wjdx > 1048576) {
							double mb = Math.floor(wjdx / 1048576);
							DecimalFormat formater = new DecimalFormat( "###,###,###.00");
							wjdxsm = "" + formater.format(mb) + " MB";
						} else {
							long kb = (long) Math.floor(wjdx / 1024);
							wjdxsm = "" + kb + " KB";
						}
						entity.setWjdxsm(wjdxsm);
						entity.setWjxzcs(new Long(0));
						list.add(entity);
					}
				}
			}else if( entity.getUploadFile() != null){
				Map<String,String> map = entity.getUploadFile();
				for(Entry<String,String> entry:map.entrySet()){
					entity.setWjmc(entry.getKey());
					String wjhzlx = "";
					int atI = entry.getKey().lastIndexOf(".");
					if (atI != -1) {
						wjhzlx = entry.getKey().substring(atI + 1);
						wjhzlx = wjhzlx.toLowerCase();
					}
					entity.setWjhzlx(wjhzlx);
					entity.setWj(base64Decoder(entry.getValue()));
					long wjdx = entity.getWj().length;
					entity.setWjdx(new Long(wjdx));
					String wjdxsm = "";
					if (wjdx < 1024) {
						wjdxsm = "" + wjdx + " B";
					} else if (wjdx > 1048576) {
						double mb = Math.floor(wjdx / 1048576);
						DecimalFormat formater = new DecimalFormat( "###,###,###.00");
						wjdxsm = "" + formater.format(mb) + " MB";
					} else {
						long kb = (long) Math.floor(wjdx / 1024);
						wjdxsm = "" + kb + " KB";
					}
					entity.setWjdxsm(wjdxsm);
					entity.setWjxzcs(new Long(0));
					list.add(entity);
				}
			}
			if (list.size() > 0) {
				zpfjFjxxbService.saveZpfjFjxxb(list, getSessionBean(sessionBean));
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, getAddSuccess());
			} else {
				model.put(AppConst.STATUS, AppConst.FAIL);
				model.put(AppConst.MESSAGES, "保存失败！由于上传文件为空！");
			}
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}

	/**
	 * 
	 * @Title: delete
	 * @Description: TODO(附件删除)
	 * @param @param id
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RestfulAnnotation(serverId="12")
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
	public @ResponseBody ModelAndView delete(@PathVariable(value="id")String id,SessionBean sessionBean){
		ModelAndView mv = new ModelAndView(AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			if (id != null) { // 注销
				ZpfjFjxxb entity = new ZpfjFjxxb();
				entity.setId(id);
				zpfjFjxxbService.deleteZpfjFjxxb(entity, getSessionBean(sessionBean));
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, getDeleteSuccess());
			}
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getDeleteFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}

	/**
	 * 
	 * @Title: download
	 * @Description: TODO(照片附件下载)
	 * @param @param id
	 * @param @param response
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RestfulAnnotation(serverId="3")
	@RequestMapping(value = "/{id}/download", method = RequestMethod.POST)
	public @ResponseBody ModelAndView download(@PathVariable(value="id")String id,
			HttpServletResponse response ,SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView( AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			if (!StringUtils.isBlank(id)) {
				ZpfjFjxxb entity = zpfjFjxxbService.downloadZpfjFjxxbById(id,getSessionBean(sessionBean));
				if (entity != null) {
					String downLoadFileName = StringUtils.nullToStr(entity
							.getWjmc());
					downLoadFileName = downLoadFileName.replaceAll(" ", "");
					downLoadFileName = URLEncoder.encode(downLoadFileName,
							"UTF-8");
					String fileName = "attachment; filename=\""
							+ downLoadFileName + "\"";
					response.reset();
					response.setHeader("Content-Disposition", fileName);
					response.setContentType("application/x-msdownload");
					OutputStream out = null;
					try {
						out = response.getOutputStream();
						out.write(entity.getWj());
						out.flush();
						return null;
					} catch (Exception e) {
					} finally {
						if (out != null) {
							try {
								out.close();
							} catch (Exception e) {
							}
						}
					}
				} else {
					model.put(AppConst.STATUS, AppConst.FAIL);
					model.put(AppConst.MESSAGES, "下载的附件不存在！");
				}
			} else {
				model.put(AppConst.STATUS, AppConst.FAIL);
				model.put(AppConst.MESSAGES, "参数不能为空！");
			}
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, "下载文件失败！");
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * 
	 * @Title: queryList
	 * @Description: TODO(附件列表查询,根据来源表名,来源ID 或者文件名称)
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RestfulAnnotation(serverId="32",valiField="lybm,lyid")
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryList(EasyUIPage page,
			@RequestParam(value = "rows",required=false) Integer rows, ZpfjFjxxb entity) {
		page.setPagePara(rows);
		return zpfjFjxxbService.queryList(page, entity);
	}
	
	/**
	 * 
	 * @Title: queryZpByLyid
	 * @Description: TODO(根据ID查询附件照片)
	 * @param @param id
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@RestfulAnnotation(serverId="3")
	@RequestMapping(value = "/{id}/pic", method = RequestMethod.GET)
	public @ResponseBody String queryZpByLyid( @PathVariable(value = "id") String id) {
		ZpfjFjxxb entity = zpfjFjxxbService.queryZpfjFjxxbById(id);
		if (entity != null && entity.getWj() != null
				&& entity.getWj().length > 0) {
			return base64Edcoder(entity.getWj());
		} else {
			byte[] empty_ryzp = SystemConfig.getByteArray("empty_ryzp");
			return base64Edcoder(empty_ryzp);
		}
	}
	
	private byte[] base64Decoder(String file) throws IOException{
		return new BASE64Decoder().decodeBuffer(file);
	}
	
	private String base64Edcoder(byte[] file){
		return new BASE64Encoder().encode(file);
	}
}
