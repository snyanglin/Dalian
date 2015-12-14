/**********************************************************************   
 * <p>文件名：KjzmglController.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu.w@founder.com.cn 
 * @date 2015-5-12 上午10:51:00 
 * @history
 * @department：研发部
 *
*/
package com.founder.zafffwqz.controller;

import java.util.*;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.utils.EasyUIPage;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
import com.founder.syrkgl.service.SyrkSyrkxxzbService;
import com.founder.zafffwqz.bean.KjzmglBean;
import com.founder.zafffwqz.service.KjzmglService;

/******************************************************************************
 * @Package:      [com.founder.zafffwqz.controller.KjzmglController.java]  
 * @ClassName:    [KjzmglController]   
 * @Description:  [服务民众-开具证明管理]   
 * @Author:       [wu.w@founder.com.cn]  
 * @CreateDate:   [2015-5-12 上午10:51:00]   
 * @UpdateUser:   [way(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-12 上午10:51:00，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)] 
 * @review      : tian_chengwei@founder.com.cn
 * @reviewDate  : 20150604 
 * @Version:      [v1.0] 
 */

@Controller
@RequestMapping(value = "/fwqzkjzmgl")
public class KjzmglController extends BaseController{
	
	@Resource(name="kjzmglService")
	private KjzmglService kjzmglService;
	
	@Resource(name = "syrkSyrkxxzbService")
	private SyrkSyrkxxzbService syrkSyrkxxzbService;

	/**
	 * @Title: query
	 * @Description: (查询人员在其它资源库中是否有数据)
	 * @param @param sfz
	 * @param @param zyks 1#2#3 1全国违法犯罪人员库 2吸毒人员库 3重点人员库 4全国在逃人员库
	 * @param @return    设定文件
	 * @return Map    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/bdcx", method = RequestMethod.POST)
	public @ResponseBody Map<String,String[]> query(KjzmglBean entity){
		return kjzmglService.query(entity);
	}
	
	/**
	 * 
	 * @Title: query
	 * @Description: 根据身份证得到用户信息
	 * @param @param sfz
	 * @param @return    设定文件
	 * @return Map<String,String>    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryRyBySfz", method = RequestMethod.POST)
	public @ResponseBody Map<String,String> queryIdBySfz(String sfz){
		
		SyrkSyrkxxzb entity=new SyrkSyrkxxzb();
		entity.setZjhm(sfz);
		
		EasyUIPage page =new EasyUIPage();
		page.setPage(1);
		page.setPagePara(1);
		
		syrkSyrkxxzbService.querySyrk(entity, page);
		
		List<?> list=page.getRows();
		Map<String,String> m=new HashMap<String,String>();
		if(list.size()>0){
			SyrkSyrkxxzb bean=(SyrkSyrkxxzb)list.get(0);
			m.put("exist", "1");
			m.put("ryid", bean.getRyid());
			m.put("syrkid", bean.getId());
		}else{
			m.put("exist", "0");
		}
		return m;
	}
	
}
