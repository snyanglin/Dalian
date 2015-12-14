package com.founder.service.attachment.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
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

import sun.misc.BASE64Decoder;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.components.AppConst;
import com.founder.framework.config.SystemConfig;
import com.founder.framework.utils.ImageUtils;
import com.founder.framework.utils.StringUtils;
import com.founder.framework.utils.UUID;
import com.founder.service.attachment.bean.ZpfjFjxxb;
import com.founder.service.attachment.bean.ZpfjPtryzpglb;
import com.founder.service.attachment.bean.ZpfjPtryzpxxb;
import com.founder.service.attachment.dao.ZpfjPtryzpDao;
import com.founder.service.attachment.service.ZpfjFjxxbService;
import com.founder.service.attachment.service.ZpfjPtryzpService;
import com.founder.service.requestservice.CzrkRequestService;
import com.founder.service.requestservice.CzrkResult;

import com.google.gson.Gson;

@Controller
@RequestMapping(value = "zpfjPtryzp")
public class ZpfjPtryzpController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());
	@Resource
	private ZpfjPtryzpDao zpfjPtryzpDao;
	@Resource(name = "zpfjPtryzpService")
	private ZpfjPtryzpService zpfjPtryzpService;

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(String ryid, String lybm, String lyid, String lyms) {
		ModelAndView mv = new ModelAndView("zpfj/zpfjPtryzpEdit");
		mv.addObject("ryid", ryid);
		mv.addObject("lybm", lybm);
		mv.addObject("lyid", lyid);
		mv.addObject("lyms", lyms);
		return mv;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@RequestParam CommonsMultipartFile uploadFile,
			String ryid, String lybm, String lyid, String lyms) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (!uploadFile.isEmpty()) {
				byte[] imageByte = uploadFile.getBytes();
				ZpfjPtryzpxxb zpfjPtryzpxxb = new ZpfjPtryzpxxb();
				zpfjPtryzpxxb.setZp(imageByte);
				zpfjPtryzpxxb.setZpslt(ImageUtils.convertImageSize(imageByte,
						179, 220, false));
				ZpfjPtryzpglb zpfjPtryzpglb = new ZpfjPtryzpglb();
				zpfjPtryzpglb.setRyid(ryid);
				zpfjPtryzpglb.setLybm(lybm);
				zpfjPtryzpglb.setLyid(lyid);
				zpfjPtryzpglb.setLyms(lyms);
				zpfjPtryzpService.savePtryzpxxb(zpfjPtryzpglb, zpfjPtryzpxxb,
						sessionBean);
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
	
	
	@RequestMapping(value = "/queryRyzpIdList", method = RequestMethod.POST)
	public @ResponseBody
	String queryZpfjIdList(ZpfjPtryzpglb entity,SessionBean sessionBean) {
		String idString = "";
		List<ZpfjPtryzpxxb> list= zpfjPtryzpService.queryPtryzpList(entity);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i).getId());
			if (i < list.size() - 1) {
				sb.append(",");
			}
		}
		idString = sb.toString();
		return idString;
	}

/*	@RequestMapping(value = "/queryZpById.jpg", method = RequestMethod.GET)
	public HttpEntity<byte[]> queryZpfjById(String id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		ZpfjPtryzpxxb entity = null;
		if (!StringUtils.isBlank(id)) {
			entity = zpfjPtryzpService.queryZpById(id);
		}
		if (entity != null && entity.getZp() != null
				&& entity.getZp().length > 0) {
			headers.setContentLength(entity.getZp().length);
			return new HttpEntity(entity.getZp(), headers);
		} else {
			byte[] empty_ryzp = SystemConfig.getByteArray("empty_ryzp");
			headers.setContentLength(empty_ryzp.length);
			return new HttpEntity(empty_ryzp, headers);
		}
	}*/

	@SuppressWarnings("static-access")
	@RequestMapping(value = "/queryPtryzpSingle.jpg", method = RequestMethod.GET)
	public HttpEntity<byte[]> queryPtryzpSingle(ZpfjPtryzpglb entity,SessionBean sessionBean) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		sessionBean = getSessionBean(sessionBean);

		ZpfjPtryzpxxb zpfjPtryzpxxb = zpfjPtryzpService
				.queryPtryzpSingle(entity);		
		if (zpfjPtryzpxxb != null && zpfjPtryzpxxb.getZp() != null
				&& zpfjPtryzpxxb.getZp().length > 0) {
			headers.setContentLength(zpfjPtryzpxxb.getZp().length);
			return new HttpEntity(zpfjPtryzpxxb.getZp(), headers);
		} else {
			if ("111".equals(entity.getCyzjdm())
					|| "112".equals(entity.getCyzjdm())
					|| "335".equals(entity.getCyzjdm())) {
				

				String url = "http://10.78.17.238:9999/lbs";
				String zpParameter = "operation=GetPersonPhotoByID&content=";
				String zpContent = "{\"data\":[{\"rybh\":\"" + entity.getZjhm()
						+ "\"}]}";
				try {

					zpContent = zpParameter
							+ java.net.URLEncoder.encode(zpContent, "UTF-8");
					PostMethod postMethod = new PostMethod(url);
					byte[] b = zpContent.getBytes("utf-8");
					InputStream is = new ByteArrayInputStream(b, 0, b.length);
					RequestEntity re = new InputStreamRequestEntity(is,
							b.length, "application/soap+xml; charset=utf-8");
					postMethod.setRequestEntity(re);
					HttpClient httpClient = new HttpClient();
					HttpConnectionManagerParams managerParams = httpClient
							.getHttpConnectionManager().getParams();
					managerParams.setConnectionTimeout(50000);
					int statusCode = httpClient.executeMethod(postMethod);
					if (statusCode == 200) {
						logger.debug("调用成功！");
						String soapResponseData = postMethod
								.getResponseBodyAsString();
						JSONObject jb = JSONObject.fromObject(soapResponseData);
						if ((Integer) jb.get("datalen") > 0) {
							JSONObject jo = jb.getJSONArray("data")
									.getJSONObject(0);
							byte[] pictureByte = null;
							try {
								pictureByte = new BASE64Decoder()
										.decodeBuffer(jo.getString("photo"));
							} catch (Exception ex) {
							}
							if (pictureByte != null) {
								zpfjPtryzpxxb=new ZpfjPtryzpxxb();
								zpfjPtryzpxxb.setId(UUID.create());
								zpfjPtryzpxxb.setZp(pictureByte);
								zpfjPtryzpxxb.setZpslt(pictureByte);
								BaseService.setSaveProperties(zpfjPtryzpxxb,
										sessionBean);
								zpfjPtryzpDao
										.savePtryzpxxb(zpfjPtryzpxxb, null);
								ZpfjPtryzpglb zpfjPtryzpglb = new ZpfjPtryzpglb();
								zpfjPtryzpglb.setId(UUID.create());
								zpfjPtryzpglb.setRyid(entity.getRyid());
								zpfjPtryzpglb.setZpid(zpfjPtryzpxxb.getId());
								zpfjPtryzpglb.setLyms("人员基本信息表");
								zpfjPtryzpglb.setLyid(entity.getRyid());
								zpfjPtryzpglb.setLybm("RY_RYJBXXB");
								BaseService.setSaveProperties(zpfjPtryzpglb,
										sessionBean);
								zpfjPtryzpDao
										.savePtryzpglb(zpfjPtryzpglb, null);
							}

						} else {
							System.out.println("调用照片失败！错误码：" + statusCode);
							byte[] empty_ryzp = SystemConfig.getByteArray("empty_ryzp");
							headers.setContentLength(empty_ryzp.length);
							return new HttpEntity(empty_ryzp, headers);
						}

					}
				} catch (Exception e) {
					e.printStackTrace();
				}		
			}
			zpfjPtryzpxxb = zpfjPtryzpService
					.queryPtryzpSingle(entity);
            headers.setContentLength(zpfjPtryzpxxb.getZp().length);
			return new HttpEntity(zpfjPtryzpxxb.getZp(), headers);
			
		}
	}

	@RequestMapping(value = "/queryPtryzpsltSingle.jpg", method = RequestMethod.GET)
	public HttpEntity<byte[]> queryPtryzpsltSingle(ZpfjPtryzpglb entity) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		ZpfjPtryzpxxb zpfjPtryzpxxb = zpfjPtryzpService
				.queryPtryzpsltSingle(entity);
		if (zpfjPtryzpxxb != null && zpfjPtryzpxxb.getZpslt() != null
				&& zpfjPtryzpxxb.getZpslt().length > 0) {
			headers.setContentLength(zpfjPtryzpxxb.getZpslt().length);
			return new HttpEntity(zpfjPtryzpxxb.getZpslt(), headers);
		} else {
			byte[] empty_ryzp = SystemConfig.getByteArray("empty_ryzp");
			headers.setContentLength(empty_ryzp.length);
			return new HttpEntity(empty_ryzp, headers);
		}
	}

	@RequestMapping(value = "/queryZpById.jpg", method = RequestMethod.GET)
	public HttpEntity<byte[]> queryZpById(String id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		ZpfjPtryzpxxb zpfjPtryzpxxb = zpfjPtryzpService.queryZpById(StringUtils
				.nullToStr(id));
		if (zpfjPtryzpxxb != null && zpfjPtryzpxxb.getZp() != null
				&& zpfjPtryzpxxb.getZp().length > 0) {
			headers.setContentLength(zpfjPtryzpxxb.getZp().length);
			return new HttpEntity(zpfjPtryzpxxb.getZp(), headers);
		} else {
			byte[] empty_ryzp = SystemConfig.getByteArray("empty_ryzp");
			headers.setContentLength(empty_ryzp.length);
			return new HttpEntity(empty_ryzp, headers);
		}
	}

}
