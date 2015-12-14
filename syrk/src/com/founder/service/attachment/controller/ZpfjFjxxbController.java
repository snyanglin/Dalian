package com.founder.service.attachment.controller;

import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
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
import com.founder.framework.config.SystemConfig;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.service.attachment.bean.ZpfjFjxxb;
import com.founder.service.attachment.service.ZpfjFjxxbService;

import com.google.gson.Gson;

@Controller
@RequestMapping(value = "zpfjFjxxb")
public class ZpfjFjxxbController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "zpfjFjxxbService")
	private ZpfjFjxxbService zpfjFjxxbService;

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(String lybm, String lyid, String lyms,
			String fileType, String fileOnly) {
		ModelAndView mv = new ModelAndView("zpfj/zpfjFjxxbEdit");
		mv.addObject("lybm", lybm);
		mv.addObject("lyid", lyid);
		mv.addObject("lyms", lyms);
		mv.addObject("fileType", fileType);
		mv.addObject("fileOnly", fileOnly);
		return mv;
	}

	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public ModelAndView query(String lybm, String lyid) {
		ModelAndView mv = new ModelAndView("zpfj/zpfjFjxxbQuery");
		mv.addObject("lybm", lybm);
		mv.addObject("lyid", lyid);
		return mv;
	}

	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryList(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, ZpfjFjxxb entity) {
		page.setPagePara(rows);
		return zpfjFjxxbService.queryList(page, entity);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@RequestParam CommonsMultipartFile[] uploadFile,
			String lybm, String lyid, String lyms, String fileOnly) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if ("1".equals(fileOnly)) {
				CommonsMultipartFile multipartFile = uploadFile[0];
				if (!multipartFile.isEmpty()) {
					FileItem fileItem = multipartFile.getFileItem();
					ZpfjFjxxb entity = new ZpfjFjxxb();
					entity.setLybm(lybm);
					entity.setLyid(lyid);
					entity.setLyms(lyms);
					String wjmc = fileItem.getName();
					if (wjmc.indexOf("\\") != -1) { // 去除完整路径
						wjmc = wjmc.substring(wjmc.lastIndexOf("\\") + 1);
					}
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
						DecimalFormat formater = new DecimalFormat(
								"###,###,###.00");
						wjdxsm = "" + formater.format(mb) + " MB";
					} else {
						long kb = (long) Math.floor(wjdx / 1024);
						wjdxsm = "" + kb + " KB";
					}
					entity.setWjdxsm(wjdxsm);
					entity.setWjxzcs(new Long(0));
					zpfjFjxxbService.updateZpfjFjxxb(entity, sessionBean);
					model.put(AppConst.STATUS, AppConst.SUCCESS);
					model.put(AppConst.MESSAGES, getAddSuccess());
				} else {
					model.put(AppConst.STATUS, AppConst.FAIL);
					model.put(AppConst.MESSAGES, "保存失败！由于上传文件为空！");
				}
			} else {
				List<ZpfjFjxxb> list = new ArrayList<ZpfjFjxxb>();
				for (int i = 0; i < uploadFile.length; i++) {
					CommonsMultipartFile multipartFile = uploadFile[i];
					if (!multipartFile.isEmpty()) {
						FileItem fileItem = multipartFile.getFileItem();
						ZpfjFjxxb entity = new ZpfjFjxxb();
						entity.setLybm(lybm);
						entity.setLyid(lyid);
						entity.setLyms(lyms);
						String wjmc = fileItem.getName();
						if (wjmc.indexOf("\\") != -1) { // 去除完整路径
							wjmc = wjmc.substring(wjmc.lastIndexOf("\\") + 1);
						}
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
							DecimalFormat formater = new DecimalFormat(
									"###,###,###.00");
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
					zpfjFjxxbService.saveZpfjFjxxb(list, sessionBean);
					model.put(AppConst.STATUS, AppConst.SUCCESS);
					model.put(AppConst.MESSAGES, getAddSuccess());
				} else {
					model.put(AppConst.STATUS, AppConst.FAIL);
					model.put(AppConst.MESSAGES, "保存失败！由于上传文件为空！");
				}
			}
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView delete(ZpfjFjxxb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() != null) { // 注销
				zpfjFjxxbService.deleteZpfjFjxxb(entity, sessionBean);
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

	@RequestMapping(value = "/download", method = RequestMethod.POST)
	public ModelAndView download(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			String id = request.getParameter("id");
			if (!StringUtils.isBlank(id)) {
				SessionBean sessionBean = getSessionBean();
				ZpfjFjxxb entity = zpfjFjxxbService.downloadZpfjFjxxbById(id,
						sessionBean);
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

	@RequestMapping(value = "/queryZpByLyid.jpg", method = RequestMethod.GET)
	public HttpEntity<byte[]> queryZpByLyid(
			@RequestParam(value = "id", required = true) String id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		ZpfjFjxxb entity = zpfjFjxxbService.showZpByLyid(id);
		if (entity != null && entity.getWj() != null
				&& entity.getWj().length > 0) {
			headers.setContentLength(entity.getWj().length);
			return new HttpEntity(entity.getWj(), headers);
		} else {
			byte[] empty_ryzp = SystemConfig.getByteArray("empty_ryzp");
			headers.setContentLength(empty_ryzp.length);
			return new HttpEntity(empty_ryzp, headers);
		}
	}

	/**
	 * 
	 * @Title: editFJ
	 * @Description: TODO(附件照片上传页面)
	 * @param @param lybm
	 * @param @param lyid
	 * @param @param lyms
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/editFJ", method = RequestMethod.GET)
	public ModelAndView editFJ(String lybm, String lyid, String lyms) {
		ModelAndView mv = new ModelAndView("zpfj/zpfjZpEdit");
		mv.addObject("lybm", lybm);
		mv.addObject("lyid", lyid);
		mv.addObject("lyms", lyms);
		return mv;
	}

	/**
	 * 查询附件ID列表，多个时用（如多张图片时控制上一张、下一张显示）<br>
	 * 
	 * @param lybm
	 * @param lyid
	 * @return String
	 */
	@RequestMapping(value = "/queryZpfjIdList", method = RequestMethod.POST)
	public @ResponseBody
	String queryZpfjIdList(String lybm, String lyid) {
		String idString = "";
		idString = zpfjFjxxbService.queryZpfjIdList(lybm, lyid);
		return idString;
	}

	/**
	 * 查看单个附件图片<br>
	 * 
	 * @param id
	 * @return HttpEntity<byte[]>
	 */
	@RequestMapping(value = "/queryZpfjById.jpg", method = RequestMethod.GET)
	public HttpEntity<byte[]> queryZpfjById(String id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		ZpfjFjxxb entity = null;
		if (!StringUtils.isBlank(id)) {
			entity = zpfjFjxxbService.queryZpfjFjxxbById(id);
		}
		if (entity != null && entity.getWj() != null
				&& entity.getWj().length > 0) {
			headers.setContentLength(entity.getWj().length);
			return new HttpEntity(entity.getWj(), headers);
		} else {
			byte[] empty_ryzp = SystemConfig.getByteArray("empty_ryzp");
			headers.setContentLength(empty_ryzp.length);
			return new HttpEntity(empty_ryzp, headers);
		}
	}

}
