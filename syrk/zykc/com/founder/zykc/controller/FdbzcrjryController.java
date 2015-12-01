package com.founder.zykc.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.annotation.RestfulAnnotation;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.config.SystemConfig;
import com.founder.framework.dictionary.service.SysDictGlService;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zykc.vo.FdbzcrjryVo;
import net.sf.json.JSONObject;
import sun.misc.BASE64Decoder;

@Controller
@RequestMapping(value = "/zykc")
public class FdbzcrjryController extends BaseController {

	@Resource(name = "sysDictGlService")
	private SysDictGlService sysDictGlService;
	
	@RequestMapping(value = "/queryFdbzcrj", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView addCzfwzb(String sfzhm, String zwxm) {
		ModelAndView mv = new ModelAndView("zykc/fdbzcrjryList");
		// Czfwxxb entity = null;
		// if(!StringUtils.isEmpty(id))
		// entity = czfwzbService.queryCzfwxxb(id);
		// else if(!StringUtils.isEmpty(fwid))
		// entity = czfwzbService.queryCzfwxxbByfwid(fwid);
		// if(entity == null){
		// entity = new Czfwxxb();
		// entity.setFwid(fwid);
		// }
		mv.addObject("sfzhm", sfzhm);
		mv.addObject("zwxm", zwxm);

		return mv;
	}

	@RestfulAnnotation(serverId = "3")
	@RequestMapping(value = "/queryFdbzcrjList", method = RequestMethod.POST )
	public @ResponseBody
	EasyUIPage queryList(EasyUIPage page,
			@RequestParam(value = "rows", required = false) Integer rows,
			String sfzhm, String zwxm, SessionBean sessionBean) {
		
		page.setPagePara(rows);

		String url = "http://10.78.17.154:9999/lbs";
		String urlParameter = "operation=ForbiddenDepartureManagement_GetInfoByIDName_v001&license=a756244eb0236bdc26061cb6b6bdb481&content=";

		int total = 0;
		List<FdbzcrjryVo> list = new ArrayList<FdbzcrjryVo>();

		String content = "";
		boolean isUpdated = false;
		if (!StringUtils.isEmpty(sfzhm) && !StringUtils.isEmpty(zwxm)) {

			content = "{\"data\":[{\"SFZHM\":\"" + sfzhm + "\"," 
					+ "\"ZWXM\":\"" + zwxm + "\"}]," + "\"pageindex\":" + (Integer.valueOf(page.getPage())-1) 
					+ "," + "\"pagesize\":" + rows+ "}";
		} else if (StringUtils.isEmpty(sfzhm)) {
			content = "{\"data\":[{\"ZWXM\":\"" + zwxm + "\"}],"
					+ "\"pageindex\":" + (Integer.valueOf(page.getPage())-1) + "," + "\"pagesize\":"
					+ rows + "}";
		} else if (StringUtils.isEmpty(zwxm)) {
			// content = "{\"data\":[{\"SFZHM\":\"" + sfzhm
			// + "\"}]}";
			content = "{\"data\":[{\"SFZHM\":\"" + sfzhm + "\"}],"
					+ "\"pageindex\":" + (Integer.valueOf(page.getPage())-1)  + "," + "\"pagesize\":"
					+ rows + "}";
		}

		try {
			content = urlParameter
					+ java.net.URLEncoder.encode(content, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		PostMethod postMethod = new PostMethod(url);
		byte[] b;
		try {
			b = content.getBytes("utf-8");

			InputStream is = new ByteArrayInputStream(b, 0, b.length);
			RequestEntity re = new InputStreamRequestEntity(is, b.length,
					"application/soap+xml; charset=utf-8");
			postMethod.setRequestEntity(re);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		HttpClient httpClient = new HttpClient();
		HttpConnectionManagerParams managerParams = httpClient
				.getHttpConnectionManager().getParams();
		managerParams.setConnectionTimeout(50000);

		int statusCode = 0;
		try {
			statusCode = httpClient.executeMethod(postMethod);
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (statusCode == 200) {
			String soapResponseData = "";
			try {
				soapResponseData = postMethod.getResponseBodyAsString();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JSONObject jb = JSONObject.fromObject(soapResponseData);
			
			if ((Integer) jb.get("datalen") > 0) {
				
				Map<String, String> dictHkszd=new HashMap<String, String>();//户口所在地
				Map<String, String> dictFlyj=new HashMap<String, String>();//法律依据
				Map<String, String> dictCsd=new HashMap<String, String>();//出生地
				Map<String, String> dictBbrylx=new HashMap<String, String>();//报备人员类别
				Map<String, String> dictPcs=new HashMap<String, String>();//派出所
				Map<String, String> dictXb=new HashMap<String, String>();//性别
				Map<String, String> dictZjzl=new HashMap<String, String>();//证件种类   
				Map<String, String> dictZzjg=new HashMap<String, String>();//组织机构      
				Map<String, String> dictMj=new HashMap<String, String>();//密级

					try {
						dictHkszd = sysDictGlService.getDictMap("BD_D_FDBZCJHKSZD");
						dictFlyj = sysDictGlService.getDictMap("BD_D_FDBZCJFLYJ");
						dictCsd = sysDictGlService.getDictMap("BD_D_FDBZCJCSD");
						dictBbrylx = sysDictGlService.getDictMap("BD_D_FDBZCJBBRYLB");
						dictPcs = sysDictGlService.getDictMap("BD_D_FDBZCJPCS");
						dictXb = sysDictGlService.getDictMap("BD_D_FDBZCJXB");
						dictZjzl = sysDictGlService.getDictMap("BD_D_FDBZCJZJZL");
						dictZzjg = sysDictGlService.getDictMap("BD_D_FDBZCJORG");
						dictMj = sysDictGlService.getDictMap("BD_D_FDBZCJMJ");

					} catch (Exception e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				
				total = Integer.valueOf(jb.getString("total"));

				for (int i = 0; i < (Integer) jb.get("datalen"); i++) {
					JSONObject jo = jb.getJSONArray("data").getJSONObject(i);
					
					FdbzcrjryVo vo = new FdbzcrjryVo();
					if (jo.containsKey("BBDWBM")) {
						vo.setBbdwbm(dictZzjg.get(jo.getString("BBDWBM")));
					}
					if (jo.containsKey("BBLXDH")) {
						vo.setBblxdh(jo.getString("BBLXDH"));
					}
					if (jo.containsKey("BBLXR")) {
						vo.setBblxr(jo.getString("BBLXR"));
					}
					if (jo.containsKey("BBQX")) {
						vo.setBbqx(jo.getString("BBQX"));
					}
					if (jo.containsKey("BBRQ")) {
						vo.setBbrq(jo.getString("BBRQ"));
					}
					if (jo.containsKey("BBRYLB")) {
						vo.setBbrylb(dictBbrylx.get(jo.getString("BBRYLB")));
					}
					if (jo.containsKey("BBYY")) {
						vo.setBbyy(jo.getString("BBYY"));
					}
					if (jo.containsKey("BZ")) {
						vo.setBz(jo.getString("BZ"));
					}
					if (jo.containsKey("CSD")) {
						vo.setCsd(dictCsd.get(jo.getString("CSD")));
					}
					if (jo.containsKey("DAH")) {
					    vo.setDah(jo.getString("DAH"));
					}
					if (jo.containsKey("DWDH")) {
						 vo.setDwdh(jo.getString("DWDH"));
					}
					if (jo.containsKey("FLYJ")) {
						vo.setFlyj(dictFlyj.get(jo.getString("FLYJ")));
					}
					if (jo.containsKey("GZDW")) {
						vo.setGzdw(jo.getString("GZDW"));
					}
					if (jo.containsKey("HKSZD")) {
						vo.setHkszd(dictHkszd.get(jo.getString("HKSZD")));
					}
					if (jo.containsKey("FLYJ")) {
						vo.setFlyj(dictFlyj.get(jo.getString("FLYJ")));
					}
					if (jo.containsKey("JTDH")) {
						vo.setJtdh(jo.getString("JTDH"));
					}
					if (jo.containsKey("MJ")) {
						vo.setMj(dictMj.get(jo.getString("MJ")));
					}
					if (jo.containsKey("PCSSZD")) {
						 vo.setPcsszd(dictPcs.get(jo.getString("PCSSZD")));
					}
					if (jo.containsKey("PYXM")) {
						vo.setPyxm(jo.getString("PYXM"));
					}
					if (jo.containsKey("SFZDCK")) {
						vo.setSfzdck(jo.getString("SFZDCK"));
					}
					if (jo.containsKey("SFZHM")) {
						vo.setSfzhm(jo.getString("SFZHM"));
					}
					if (jo.containsKey("XB")) {									
						vo.setXb(dictXb.get(jo.getString("XB")));						
					}
					if (jo.containsKey("XZZ")) {
					    vo.setXzz(jo.getString("XZZ"));
					}
					if (jo.containsKey("ZJHM")) {
						vo.setZjhm(jo.getString("ZJHM"));
					}
					if (jo.containsKey("ZJZL")) {
						vo.setZjzl(dictZjzl.get(jo.getString("ZJZL")));
					}
					if (jo.containsKey("ZWM")) {
						vo.setZwm(jo.getString("ZWM"));
					}
					if (jo.containsKey("ZWX")) {
						vo.setZwx(jo.getString("ZWX"));
					}
					if (jo.containsKey("RYDH")) {
						vo.setRydh(jo.getString("RYDH"));
					}
					list.add(vo);
				}
			}
		} else {
			System.out.println("调用全国常住人口失败！错误码：" + statusCode);
		}
		page.setRows(list);
		page.setTotal(total);
		return page;
	}

	@SuppressWarnings("static-access")
	@RequestMapping(value = "/queryFdbzcrjryPhoto.jpg", method = RequestMethod.GET)
	public HttpEntity<byte[]> queryFdbzcrjryPhoto(String rydh,
			SessionBean sessionBean) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		sessionBean = getSessionBean(sessionBean);

		byte[] pictureByte = null;

		String url = "http://10.78.17.154:9999/lbs";
		String zpParameter = "operation=ForbiddenDepartureManagement_GetPhotoByID_v001&license=a756244eb0236bdc26061cb6b6bdb481&content=";
		String zpContent = "{\"data\":[{\"RYDH\":\"" + rydh + "\"}]}";
		try {

			zpContent = zpParameter
					+ java.net.URLEncoder.encode(zpContent, "UTF-8");
			PostMethod postMethod = new PostMethod(url);
			byte[] b = zpContent.getBytes("utf-8");
			InputStream is = new ByteArrayInputStream(b, 0, b.length);
			RequestEntity re = new InputStreamRequestEntity(is, b.length,
					"application/soap+xml; charset=utf-8");
			postMethod.setRequestEntity(re);
			HttpClient httpClient = new HttpClient();
			HttpConnectionManagerParams managerParams = httpClient
					.getHttpConnectionManager().getParams();
			managerParams.setConnectionTimeout(50000);
			int statusCode = httpClient.executeMethod(postMethod);
			if (statusCode == 200) {
				String soapResponseData = postMethod.getResponseBodyAsString();
				JSONObject jb = JSONObject.fromObject(soapResponseData);
				if ((Integer) jb.get("datalen") > 0) {
					JSONObject jo = jb.getJSONArray("data").getJSONObject(0);

					try {
						pictureByte = new BASE64Decoder().decodeBuffer(jo
								.getString("PHOTO"));
					} catch (Exception ex) {
					}
					if (pictureByte != null) {

					} else {
						System.out.println("调用照片失败！错误码：" + statusCode);
						byte[] empty_ryzp = SystemConfig
								.getByteArray("empty_ryzp");
						headers.setContentLength(empty_ryzp.length);
						return new HttpEntity(empty_ryzp, headers);
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

		headers.setContentLength(pictureByte.length);
		return new HttpEntity(pictureByte, headers);

	}

}
