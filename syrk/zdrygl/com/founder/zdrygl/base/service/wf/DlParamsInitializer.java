package com.founder.zdrygl.base.service.wf;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.founder.framework.base.entity.SessionBean;
import com.founder.workflow.bean.StartProcessInstance;
import com.founder.zdrygl.base.model.ZdryJgdxqxjdjb;
import com.founder.zdrygl.base.model.ZdryZb;
import com.founder.zdrygl.base.model.Zdrylxylbdyb;
import com.founder.zdrygl.base.service.ZdryInfoQueryService;
import com.founder.zdrygl.base.vo.ZdryVO;
import com.founder.zdrygl.base.vo.ZdryZdryzbVO;
import com.founder.zdrygl.core.utils.ZdryConstant;

public class DlParamsInitializer implements IfParamInitializer {
	ZdryConstant zdryConstant;
	ZdryInfoQueryService zdryQueryService;
	
	public DlParamsInitializer() {
		super();
	}

	public DlParamsInitializer( ZdryConstant zdryConstant,ZdryInfoQueryService zdryQueryService) {
		this.zdryConstant = zdryConstant;
		this.zdryQueryService = zdryQueryService;
	}
	@Override
	public void setZdryConstant(ZdryConstant zdryConstant) {
		this.zdryConstant = zdryConstant;
	}
	@Override
	public void setZdryQueryService(ZdryInfoQueryService zdryQueryService) {
		this.zdryQueryService = zdryQueryService;
	}

	@Override
	public StartProcessInstance initialProcessInstance(SessionBean sessionBean, ZdryVO zdryVO,
			LcgFlagEnum lcgFlag) {
		// TODO Auto-generated method stub
		Map<String, Object> variables = new HashMap<String, Object>();
		StartProcessInstance spi = new StartProcessInstance();
		spi.setApplyUserId(sessionBean.getUserId());
		
		variables.put("sqrName", sessionBean.getUserName());// 申请人姓名
		variables.put("sqrOrgCode", sessionBean.getUserOrgCode());// 设置申请人组织机构代码
		variables.put("sqrOrgLevel", sessionBean.getUserOrgLevel());// 设置申请人组织机构级别
		variables.put("lrrzrq", sessionBean.getUserOrgCode());// 录入人管辖责任区
		variables.put("applyUserId", sessionBean.getUserId());
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String createTime = formatter.format(new Date());// 申请时间
		variables.put("createTime", createTime);
		
		variables.put("sqlxdm", lcgFlag.getValue());// 申请类型
		
		if(lcgFlag.getValue().equals("01")){
			//列管
			prepareLg(spi,sessionBean,zdryVO,variables);
		}else if(lcgFlag.getValue().equals("02")){
			//撤管
			prepareCg(spi,sessionBean,zdryVO,variables);
		}else if(lcgFlag.getValue().equals("03")){
			//转递
			prepareZd(spi,sessionBean,zdryVO,variables);
		}else if(lcgFlag.getValue().equals("04")){
			//转类
			prepareZl(spi,sessionBean,zdryVO,variables);
		}else if(lcgFlag.getValue().equals("05")){
			//请销假
			prepareQxj(spi,sessionBean,zdryVO,variables);
		}else{
		}
		return spi;
	}

	private void prepareQxj(StartProcessInstance spi, SessionBean sessionBean,
			ZdryVO zdryVO, Map<String, Object> variables) {
		ZdryJgdxqxjdjb zdryJgdxqxjdjb = zdryVO.getZdryJgdxqxjdjb();
		String lrrzrq = sessionBean.getUserOrgCode();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String createTime = formatter.format(new Date());// 申请时间
		variables.put("createTime", createTime);
		variables.put("lrrzrq", lrrzrq);//录入人管辖责任区
 		variables.put("zdryId", zdryJgdxqxjdjb.getZdryid()); //重点人员总表Id
 		
 		variables.put("xm", zdryVO.getXm());//请假人员姓名
		variables.put("zjhm", zdryVO.getZjhm());//证件号码
		variables.put("sqlx", "监管对象请假");//申请类型	  			
	    variables.put("sqyj", zdryVO.getYwsqyy());//申请意见		
		variables.put("sqlxdm", "05");
		variables.put("approvalMethod", "szApproval");
		variables.put("sqyj","监管对象" + zdryVO.getXm()+"请假");
		// set parameters of processinstance
		spi.setProcessKey("dl_jgdxqj");
		spi.setBusinessKey(zdryVO.getZdryJgdxqxjdjb().getZdryid());
		spi.setVariables(variables);

	}

	private void prepareZl(StartProcessInstance spi, SessionBean sessionBean,
			ZdryVO zdryVO, Map<String, Object> variables) {
		// TODO Auto-generated method stub
		String  lrrzrq= sessionBean.getUserOrgCode();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String createTime=formatter.format(new Date());//申请时间
		variables.put("createTime", createTime);
		//variables.put("zdryzb", zdryVO.getZdryZdryzb());
		variables.put("lrrzrq", lrrzrq);//录入人管辖责任区
 		variables.put("zdryId", zdryVO.getZdryZdryzb().getId()); //重点人员总表Id
		variables.put("zdryName", zdryVO.getXm());
		variables.put("zdrylxmc", zdryVO.getZdryZdryzbVO().getZdrygllxmc());//人员类型名称	
		variables.put("yzdrylbmc", zdryVO.getZdryZdryzbVO().getZdrylbmc());//转递前类型
		variables.put("xzdrylbmc", zdryVO.getZdryZdryzbVO().getZdrylbmc());//转递后类型
		variables.put("yzdrylb", zdryVO.getZdryZdryzbVO().getZdrylb());//转递前类别
		variables.put("xzdrylb", zdryVO.getZdryZdryzb().getZdrylb());//转递后类别
		variables.put("zdrylx", zdryVO.getZdryZdryzb().getZdrygllxdm());
		
		variables.put("xm", zdryVO.getXm());//被列管人员姓名
		variables.put("zjhm", zdryVO.getZjhm());//证件号码
		variables.put("sqlx", "重点人口转类");//申请类型	  			
	    variables.put("sqyj", zdryVO.getYwsqyy());//申请意见		
		variables.put("sqlxdm", "03");//列管01  撤管02 专类03
		variables.put("approvalMethod", "szzlApproval");
		variables.put("sqyj", "申请将"+zdryVO.getXm()+"转换重点人员类别");

		// set parameters of processinstance
		spi.setProcessKey("ln_zl");
		spi.setBusinessKey(zdryVO.getZdryZdryzb().getId());
		spi.setVariables(variables);
	}

	private void prepareCg(StartProcessInstance spi, SessionBean sessionBean, ZdryVO zdryVO, Map<String, Object> variables) {
		String zdryxm = zdryVO.getZdryZdryzb().getXm();
		Zdrylxylbdyb zdrylxylbdyb = new Zdrylxylbdyb();
		ZdryZb zdryZdryzb = zdryVO.getZdryZdryzb();
		zdrylxylbdyb.setLbdm(zdryZdryzb.getZdrygllxdm());
		String zdrylxmc = zdryConstant.getValueOfZdryDict(zdryZdryzb.getZdrygllxdm());
		

		variables.put("zdrylx", zdryZdryzb.getZdrygllxdm());// 人员类型
		variables.put("zdryzb", zdryVO.getZdryZdryzb());
		variables.put("zdrylbdx", zdryVO.getZdrylbdx());
		
		variables.put("zdryId", zdryZdryzb.getId()); // 重点人员总表Id
		variables.put("zdrylxmc", zdrylxmc);// 人员类型名称
		variables.put("xm", zdryxm);// 被列管人员姓名
		variables.put("cyzjdm", zdryVO.getZdryZdryzb().getCyzjdm());
		variables.put("zjhm", zdryVO.getZdryZdryzb().getZjhm());// 证件号码
		// variables.put("splx", "重点人口列管");//审批类型
		variables.put("sqyj", zdryVO.getYwsqyy());// 申请意见
		variables.put("zdryName", zdryxm);// 申请意见
		/**
		 * 01	监管对象(sqjz)
		 * 02	重点人口(zdrk)
		 * 03	其他重点管理对象(zdrk)
		 * 04	肇事肇祸精神病人(zszh)
		 * 05	轻微滋事精神病人(zszh)
		 * 06	非正常上访重点人员(sgaf)
		 * 07	纳入视线对象（无流程）(nrsx)
		 * 08	一般关注对象(不持久 化 )
		 */
		variables.put("sqlx", zdrylxmc +"撤管");
		variables.put("splevel", "1");// 设置审批级别，一级审批
		variables.put("zdryId", zdryZdryzb.getId());
		variables.put("sqyj", "申请将" + zdryxm	+ "撤管");
		variables.put("xm", zdryxm);// 被列管人员姓名
		variables.put("zjhm", zdryVO.getZdryZdryzb().getZjhm());// 证件号码

		// set parameters of processinstance
		spi.setProcessKey("dl_zalcg");
		spi.setBusinessKey(zdryZdryzb.getId());
		spi.setVariables(variables);
		
	}

	private void prepareLg(StartProcessInstance spi, SessionBean sessionBean, ZdryVO zdryVO, Map<String, Object> variables) {
		String zdryxm = zdryVO.getZdryZdryzb().getXm();
		Zdrylxylbdyb zdrylxylbdyb = new Zdrylxylbdyb();
		ZdryZb zdryZdryzb = zdryVO.getZdryZdryzb();
		zdrylxylbdyb.setLbdm(zdryZdryzb.getZdrygllxdm());
		String zdrylxmc = zdryConstant.getValueOfZdryDict(zdryZdryzb.getZdrygllxdm());
		

		variables.put("zdrylx", zdryZdryzb.getZdrygllxdm());// 人员类型
		variables.put("zdrylxmc", zdrylxmc);// 人员类型名称
		variables.put("xm", zdryxm);// 被列管人员姓名
		variables.put("cyzjdm", zdryVO.getZdryZdryzb().getCyzjdm());
		variables.put("zjhm", zdryVO.getZdryZdryzb().getZjhm());// 证件号码
		// variables.put("splx", "重点人口列管");//审批类型
		variables.put("sqyj", zdryVO.getYwsqyy());// 申请意见
		/**
		 * 01	监管对象
		 * 02	重点人口
		 * 03	其他重点管理对象
		 * 04	肇事肇祸精神病人
		 * 05	轻微滋事精神病人
		 * 06	非正常上访重点人员
		 * 07	纳入视线对象（无流程）
		 * 08	一般关注对象
		 */
		if (!zdryZdryzb.getZdrygllxdm().equals("07") ) {
			variables.put("sqlx", zdrylxmc);
			variables.put("splevel", "1");// 设置审批级别，一级审批
			variables.put("approvalMethod", "shbApproval");
			variables.put("sqyj", "申请将" + zdryxm	+ "列管为"+zdrylxmc);

			// set parameters of processinstance
			spi.setProcessKey("dl_zalcg");
			spi.setBusinessKey(zdryZdryzb.getId());
			spi.setVariables(variables);
		}  else {
			//07	纳入视线对象（无流程）
			spi.setHasWorkflow(false);
		}
	}

	private void prepareZd(StartProcessInstance spi, SessionBean sessionBean,
			ZdryVO zdryVO, Map<String, Object> variables) {
		// TODO Auto-generated method stub
		ZdryZdryzbVO zdryZdryVo= zdryVO.getZdryZdryzbVO();
		ZdryZb zb = zdryVO.getZdryZdryzb();
		//zdryVO.getZdryZdryzb();
		ZdryZb yzb = (ZdryZb) zdryQueryService.queryById(zdryVO.getZdryZdryzb().getId());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		variables.put("sqsj",formatter.format(new Date())); //申请时间
		variables.put("sqlx", "转递流程：" + zdryVO.getXm());// 申请类型
		
		variables.put("zdryId", zdryVO.getZdryZdryzb().getId()); //重点人员总表Id
		variables.put("zdryName",zdryVO.getXm());//重点人员姓名
		variables.put("xm", zdryVO.getXm());//被列管人员姓名
		variables.put("cyzjdm", zb.getCyzjdm());//证件类型
		variables.put("zjhm", zdryVO.getZjhm());//证件号码
		variables.put("yjzddz", zdryZdryVo.getDz_hjdzmlpxz());//原居住地址	--
		variables.put("ygxpcsdm", zdryZdryVo.getYgxpcsdm());//原居住地址所属派出所代码
		variables.put("ygxzrqdm", zdryZdryVo.getYgxzrqdm());//原居住地址所属责任区代码	
		variables.put("zddz", zb.getJzd_mlpxz());//转递地址
		variables.put("sspcsdm", zdryZdryVo.getSspcsdm());//转递派出所--
		variables.put("sszrqdm", zdryZdryVo.getSszrqdm());//转递责任区--
		variables.put("ywfqyy", zdryZdryVo.getYwfqyy());//转递原因
		variables.put("sqrName", sessionBean.getUserName());//转递发起人名称
		variables.put("sqrbmdm", sessionBean.getUserOrgCode());//转递发起人名称
		variables.put("zdrylx", zb.getZdrygllxdm());//重点人员类型
		//variables.put("current_jzd_mlpdm", zdryZdryVo.getDz_jzdzmlpdm());//转递原地址
		//variables.put("target_jzd_mlpdm", zb.getJzd_mlpdm());//转递新地址
		variables.put("sszrqdm", zdryZdryVo.getSszrqdm());
		variables.put("ygxzrqdm", zdryZdryVo.getYgxzrqdm());
		variables.put("yglbm", sessionBean.getUserOrgCode());
		//
		variables.put("yjzd_dzid", yzb.getJzd_dzid());
		variables.put("yjzd_dzxz", yzb.getJzd_dzxz());
		variables.put("yjzd_mlpdm", yzb.getJzd_mlpdm());
		variables.put("yjzd_mlpxz", yzb.getJzd_mlpxz());
		variables.put("yjzd_xzqhdm", yzb.getJzd_xzqhdm());
		variables.put("yjzd_zbx", yzb.getJzd_zbx());
		variables.put("yjzd_zby", yzb.getJzd_zby());
		variables.put("ryid", yzb.getRyid());
		variables.put("zdryzb", zdryVO.getZdryZdryzb());
		variables.put("zdrylbdx", zdryVO.getZdrylbdx());

		// set parameters of processinstance
		spi.setProcessKey("dl_zd");
		spi.setBusinessKey(zdryVO.getZdryZdryzb().getId());
		spi.setVariables(variables);
	}

}

