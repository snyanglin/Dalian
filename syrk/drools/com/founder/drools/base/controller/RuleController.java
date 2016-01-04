package com.founder.drools.base.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.framework.annotation.RestfulAnnotation;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.dictionary.service.SysDictService;
import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
import com.founder.syrkgl.service.SyrkSyrkxxzbService;
import com.founder.zdrygl.base.service.ZdryInfoQueryService;
import com.founder.zdrygl.core.model.Zdry;
import com.founder.zdrygl.core.utils.ZdryConstant;

/**
 * ****************************************************************************
 * @Package:      [com.founder.drools.base.controller.RuleController.java]  
 * @ClassName:    [RuleController]   
 * @Description:  [给规则平台提供的规则调用接口]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年12月1日 下午2:19:48]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年12月1日 下午2:19:48，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Controller
@RequestMapping("zdrySys")
public class RuleController extends BaseController {					
	
	@Autowired
	private ZdryConstant zdryConstant;
	
	@Resource(name = "zdryQueryService")
	private ZdryInfoQueryService zdryQueryService;
	
	@Resource(name = "syrkSyrkxxzbService")
	private SyrkSyrkxxzbService syrkSyrkxxzbService;
	
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;	
	
	@Resource(name = "sysDictService")
	private SysDictService sysDictService;	
	

	/**
	 * 
	 * @Title: getZdrylx
	 * @Description: TODO(获取重点人员类型中文)
	 * @param @param zdrygllx
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throw
	 */
	@RestfulAnnotation(valiField = "zdrygllx", serverId = "3")
	@RequestMapping(value = "/getZdrylx", method = {RequestMethod.GET})
	public @ResponseBody String getZdrylx(String zdrygllx){
		
		return zdryConstant.getValueOfZdryDict(zdrygllx);
	}

	/**
	 * 
	 * @Title: getZdryInfo
	 * @Description: TODO(根据重点人员ID查询重点人员总表信息)
	 * @param @param zdryId
	 * @param @return    设定文件
	 * @return Zdry    返回类型
	 * @throw
	 */
	@RestfulAnnotation(valiField = "zdryId", serverId = "3")
	@RequestMapping(value = "/{zdryId}", method = {RequestMethod.GET})
	public @ResponseBody Zdry getZdryInfo(@PathVariable String zdryId){
		return zdryQueryService.queryById(zdryId);		
	}
	
	/**
	 * 
	 * @Title: getSyrkJzdZrq
	 * @Description: TODO(根据实有人口ID查询人员的所有居住地责任区)
	 * @param @param syrkId
	 * @param @return    设定文件
	 * @return String[][]    返回类型
	 * @throw
	 */
	@RestfulAnnotation(valiField = "syrkId", serverId = "3")
	@RequestMapping(value = "/getSyrkJzdZrq/{syrkId}", method = {RequestMethod.GET})
	public @ResponseBody Object[][] getSyrkJzdZrq(@PathVariable String syrkId){
		SyrkSyrkxxzb syrkEntity=syrkSyrkxxzbService.queryById(syrkId);//根据实有人口ID查询当前的实有人口总表
		if(syrkEntity==null)
			return null;
		
		List<SyrkSyrkxxzb> list=syrkSyrkxxzbService.queryListByRyid(syrkEntity.getRyid());//根据人员ID查询实有人口列表，同一个人可能用不同的证件号码注册，但是人员基本信息表的ID是一样的。

		//遍历List：居住地的管辖责任区可能重复，所以要排除重复
		Map<String, Boolean> map=new HashMap<String, Boolean>();//防重复Map
		SyrkSyrkxxzb entity;
		for(int i=0;i<list.size();i++){
			entity=list.get(i);
			if(map.get(entity.getGxzrqdm()) == null){//防止重复
				map.put(entity.getGxzrqdm(), true);
			}else{
				list.remove(i);//删除重复的
				i--;
			}
		}
		
		//处理返回的数组
		Object[][] jsrAry=new Object[list.size()][4];
		for(int i=0;i<list.size();i++){
			entity=list.get(i);
			jsrAry[i][0]=entity.getGxzrqdm();//接收机构代码
			jsrAry[i][1]=getOrgName(entity.getGxzrqdm());//接收机构名称
			//jsrAry[i][2]和jsrAry[i][3]是在规则平台赋值，分别存“是否包含下级机构，是否重复发给同一个人”			
		}
				
		return jsrAry;		
	}
	
	/**
	 * 
	 * @Title: getSyrk
	 * @Description: TODO(根据实有人口ID查询实有人口信息，BZ中是实有人口类型名称)
	 * @param @param syrkId
	 * @param @return    设定文件
	 * @return SyrkSyrkxxzb    返回类型
	 * @throw
	 */
	@RestfulAnnotation(valiField = "syrkId", serverId = "3")
	@RequestMapping(value = "/getSyrk/{syrkId}", method = {RequestMethod.GET})
	public @ResponseBody SyrkSyrkxxzb getSyrk(@PathVariable String syrkId){
		SyrkSyrkxxzb syrkEntity=syrkSyrkxxzbService.queryById(syrkId);//根据实有人口ID查询当前的实有人口总表
		if(syrkEntity==null)
			return null;
		
		syrkEntity.setBz(sysDictService.getDictCt("BD_D_SYRKYWLXDM", syrkEntity.getSyrkywlxdm()));
		return syrkEntity;		
	}
	
	private String getOrgName(String orgCode){
		try{
			OrgOrganization org=orgOrganizationService.queryByOrgcode(orgCode);
			return org.getOrgname();
		}catch(Exception e){
			return "";
		}
	}
}
