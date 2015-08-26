package com.founder.yjjb.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sun.misc.BASE64Decoder;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.utils.ComboBox;
import com.founder.syrkgl.bean.RyRyjbxxb;
import com.founder.syrkgl.service.RyRyjbxxbService;
import com.founder.yjjb.service.CommonService;

import com.cgsoft.util.HttpUtil;

@Controller
@RequestMapping(value = "/common")
public class CommonController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name="commonService")
	private CommonService commonService;
	
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;
	
	@Resource(name = "ryRyjbxxbService")
	private RyRyjbxxbService ryRyjbxxbService;
	
	/**
	 * 下级单位列表：分局和派出所</br>
	 * @param orgCode
	 * @return
	 */
	@RequestMapping(value = "/queryOrgLower" , method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody List<ComboBox> queryOrgLowerList(String orgCode){
		
		return commonService.searchOrgListLower(orgCode);
	}

	/**
	 * 下级单位列表：分局和公安局</br>
	 * @param orgCode
	 * @return
	 */
	@RequestMapping(value = "/queryOrgHigher" , method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody List<ComboBox> queryOrgHigherList(String orgCode){
		
		return commonService.searchOrgListHigher(orgCode);
	}
	
	/**
	 * 下级单位列表</br>
	 * @param orgCode
	 * @return
	 */
	@RequestMapping(value = "/searchOrgListChildren" , method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody List<ComboBox> searchOrgListChildren(String orgCode){
		
		return commonService.searchOrgListChildren(orgCode);
	}
	
	/**
	 * 单位列表</br>
	 * @param orgCode
	 * @return
	 */
	@RequestMapping(value = "/queryOrg" , method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody List<ComboBox> queryOrgrList(String orgCode){
		
		return commonService.searchOrgList(orgCode);
	}
	
	/**
	 * 接收单位列表</br>
	 * @param orgCode
	 * @return
	 */
	@RequestMapping(value = "/myOrg" , method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody List<ComboBox> myOrg(String type){
		
		return commonService.myOrg(type);
	}
	
	/**
	 * 接收单位列表(有参数)</br>
	 * @param orgCode
	 * @return
	 */
	@RequestMapping(value = "/myOrgPara" , method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody List<ComboBox> myOrg(String type,Map map){
		SessionBean sessionBean = getSessionBean();
		if (type.equals("XSZJSP")||type.equals("XSZJSQ"))
			map.put("orgCode", sessionBean.getUserOrgCode());
		return commonService.myOrg(type,map);
	}
	
	/**
	 * 返回责任区
	 * @return
	 */
	@RequestMapping(value="/bzzrq")
	@ResponseBody
	public Object mapBzZrq(String x,String y){
		
		Map item = commonService.mapBzZrq(x, y);
		if(item != null){
			
			return item;
		} else {
			
			return false;
		}
	}
	
	/**
	 * 根据orgcode获取orglevel 02-支队 10-中心 21-分局</br>
	 * 根据orgcode和orglevel获取下级单位
	 * @param orgCode
	 * @return
	 */
	@RequestMapping(value = "/queryDownOrg", method = { RequestMethod.GET,RequestMethod.POST })
	public @ResponseBody List<ComboBox> queryDownOrg(String orgCode) {
		
		String orglevel = orgOrganizationService.queryByOrgcode(orgCode).getOrglevel();
		return commonService.queryDownOrg(orgCode,orglevel);
	}
	
	/**
	 * 老警综案件状态</br>
	 * @param orgCode
	 * @return
	 */
	@RequestMapping(value = "/myOldAjzt" , method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody List<ComboBox> myOldAjzt(String type){
		
		return commonService.myOldAjzt(type);
	}
	
	/**
	 * 用户列表</br>
	 * @param orgCode
	 * @return
	 */
	@RequestMapping(value = "/queryUserList" , method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody List<ComboBox> queryUserList(){
		
		return commonService.queryUserList();
	}
	
	/**
	 * 返回出租车信息
	 * @return
	 */
	@RequestMapping(value = "/tinfo" , method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Map<String, Object> queryTaxiInfo(String id){
		String bStr = HttpUtil.post("http://10.80.1.246/car/tinfo?id="+id);
		Map<String, Object> item = new HashMap<String, Object>();
		if(!"bnVsbA==".equals(bStr)){
			String json = "";
			BASE64Decoder decoder = new BASE64Decoder();
			try {
				byte[] b = decoder.decodeBuffer(bStr);
				json = new String(b);
			} catch (IOException e) {
				e.printStackTrace();
			}
			ObjectMapper mapper = new ObjectMapper();
			try {
				item = mapper.readValue(json,HashMap.class);
			} catch (JsonParseException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			// 从人员信息表取数
			RyRyjbxxb ryjbxxb = ryRyjbxxbService.queryByCyzjdmZjhm("111",id);
			
			item.put("JBRXM", ryjbxxb.getXm());
			item.put("JBRSR", ryjbxxb.getCsrq());
			item.put("JBRXB", ryjbxxb.getXbdm());
			//item.put("JBRLXFS", ryjbxxb.getJjqklxdh());
			item.put("JBRLXFS", "");
		}
		
		return item;
	}
	
	/**
	 * 出租车信息获取
	 * @return
	 */
	@RequestMapping(value = "/tcdic", method = RequestMethod.GET)
	@ResponseBody
	public List tcdic(){
		String bStr = HttpUtil.post("http://10.80.1.246/car/tcdic");
		String json = "";
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			byte[] b = decoder.decodeBuffer(bStr);
			json = new String(b);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ObjectMapper mapper = new ObjectMapper();
		List list = new ArrayList();
		try {
			list = mapper.readValue(json,List.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
}
