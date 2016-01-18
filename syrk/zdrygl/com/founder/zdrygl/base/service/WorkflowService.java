package com.founder.zdrygl.base.service;

import org.springframework.stereotype.Service;

import com.founder.framework.base.service.BaseService;
import com.founder.framework.components.AppConst;
import com.founder.framework.config.SystemConfig;
import com.founder.framework.exception.BussinessException;
import com.founder.zdrygl.base.service.wf.WfywEnum;
/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.service.WorkflowService.java]  
 * @ClassName:    [WorkflowService]   
 * @Description:  [提供workflow相关的辅助功能]   
 * @Author:       [huang_jifei@founder.com.cn]  
 * @CreateDate:   [2015年12月23日 上午11:21:18]   
 * @UpdateUser:   [huangjifei(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年12月23日 上午11:21:18，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service
public class WorkflowService  extends BaseService {
	/**
	 * 
	 * @Title: getSuffixNameByZdryLxdm
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param businessType
	 * @param @param zdrygllxdm
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String getSuffixNameByZdryLxdm(String businessType,String zdrygllxdm){
		if(businessType.trim().equals(WfywEnum.ZALCG.getName())){
			return getZalcgWfSuffix(zdrygllxdm);
		}else if(businessType.trim().equals(WfywEnum.ZD.getName())){
			return WfywEnum.ZD.getValue();
		}else if(businessType.trim().equals(WfywEnum.ZL.getName())){
			return WfywEnum.ZL.getValue();
		}else if(businessType.trim().equals(WfywEnum.JGDXQJ.getName())){
			return WfywEnum.JGDXQJ.getValue();
		}else if(businessType.trim().equals(WfywEnum.ZDRYHS.getName())){
			return WfywEnum.ZDRYHS.getValue();
		}else{
			throw new BussinessException("未定义或未找到该业务类型!");
		}
	}
	/**
	 * 
	 * @Title: getZalcgWfSuffix
	 * @Description: (根据区域和类型代码，获取具体zalcg名称)
	 * @param @param zdrygllxdm
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	private String getZalcgWfSuffix(String zdrygllxdm) {
		String suffixName = null;
		String systemXzqh = SystemConfig.getString(AppConst.XZQH)==null?"210000":SystemConfig.getString(AppConst.XZQH);
		if("210000".equals(systemXzqh)){//辽宁
			if(zdrygllxdm.equals("01")){
				//社区矫正人员
				suffixName="sqjz";
			}else if(zdrygllxdm.equals("02")){
				//重点人口
				suffixName="zalcg";
			}else if(zdrygllxdm .equals("03")){
				//肇事肇祸精神病人
				suffixName="zalcg";
			}else if(zdrygllxdm .equals("04")){
				//非正常上访重点人员
				suffixName="zalcg";
			}else if(zdrygllxdm.equals("05")){
				//涉公安访重点人员
				suffixName="sgaf_lcg";
			}else if(zdrygllxdm.equals("06")){
				//其他关注对象
				suffixName="szsp";
			}else if(zdrygllxdm.equals("07")){
				//涉环保重点人员
				suffixName="shb_lcg";
			}else if(zdrygllxdm.equals("08")){
				//涉枪涉爆重点人员
				suffixName="zalcg";
			}
		}else if("210200".equals(systemXzqh)){//大连
			switch (zdrygllxdm){
				case "30":
					suffixName="shb_lcg";
					break;
				default:
					suffixName="zalcg";
					break;
			}

		}else{
			throw new BussinessException("未定义行政区域代码" + systemXzqh + "的流程!");
		}
		return suffixName;
	}
}
