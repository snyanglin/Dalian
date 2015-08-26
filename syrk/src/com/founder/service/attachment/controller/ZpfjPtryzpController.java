package com.founder.service.attachment.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import sun.misc.BASE64Decoder;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.config.SystemConfig;
import com.founder.framework.utils.ImageUtils;
import com.founder.framework.utils.StringUtils;
import com.founder.service.attachment.bean.ZpfjPtryzpglb;
import com.founder.service.attachment.bean.ZpfjPtryzpxxb;
import com.founder.service.attachment.service.ZpfjPtryzpService;
import com.founder.service.requestservice.CzrkRequestService;
import com.founder.service.requestservice.CzrkResult;

import com.google.gson.Gson;

@Controller
@RequestMapping(value = "zpfjPtryzp")
public class ZpfjPtryzpController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());

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

	@SuppressWarnings("static-access")
	@RequestMapping(value = "/queryPtryzpSingle.jpg", method = RequestMethod.GET)
	public HttpEntity<byte[]> queryPtryzpSingle(ZpfjPtryzpglb entity) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
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
				SessionBean sessionBean = getSessionBean();
				CzrkRequestService czrkRequestService = new CzrkRequestService();
				CzrkResult result = czrkRequestService.selectCzrk(entity
						.getZjhm(), true);
				if (result != null && !StringUtils.isBlank(result.getXP())) {
					byte[] pictureByte = null;
					try {
						pictureByte = new BASE64Decoder().decodeBuffer(result
								.getXP());
					} catch (Exception ex) {
						byte[] empty_ryzp = SystemConfig
								.getByteArray("empty_ryzp");
						headers.setContentLength(empty_ryzp.length);
						return new HttpEntity(empty_ryzp, headers);
					}
					if (pictureByte != null) {
						ZpfjPtryzpxxb zpfjPtryzpxxb1 = new ZpfjPtryzpxxb();
						zpfjPtryzpxxb1.setZp(pictureByte);
						try {
							zpfjPtryzpxxb1.setZpslt(ImageUtils
									.convertImageSize(pictureByte, 179, 220,
											false));
						} catch (Exception e) {
							e.printStackTrace();
						}
						ZpfjPtryzpglb zpfjPtryzpglb = new ZpfjPtryzpglb();
						zpfjPtryzpglb.setRyid(entity.getRyid());
						zpfjPtryzpglb.setLybm("人员基本信息表");
						zpfjPtryzpglb.setLyid(entity.getRyid());
						zpfjPtryzpglb.setLyms("RK_RYJBXXB");
						zpfjPtryzpService.savePtryzpxxb(zpfjPtryzpglb,
								zpfjPtryzpxxb1, sessionBean);
						headers.setContentLength(pictureByte.length);
						return new HttpEntity(pictureByte, headers);
					}
				}
			}
			byte[] empty_ryzp = SystemConfig.getByteArray("empty_ryzp");
			headers.setContentLength(empty_ryzp.length);
			return new HttpEntity(empty_ryzp, headers);
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
