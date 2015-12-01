package com.founder.zdry.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.components.AppConst;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.exception.RestException;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.message.dao.SysMessageDao;
import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.framework.utils.UUID;
import com.founder.syrkgl.bean.RyRyjbxxb;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
import com.founder.syrkgl.service.RyRyjbxxbService;
import com.founder.tzgg.bean.Org_Organization;
import com.founder.zdry.bean.ZdryFzcsfryxxb;
import com.founder.zdry.bean.ZdryHsb;
import com.founder.zdry.bean.ZdryJgdxxxb;
import com.founder.zdry.bean.ZdryLczywblb;
import com.founder.zdry.bean.ZdryShbzdryxxb;
import com.founder.zdry.bean.ZdryYwspb;
import com.founder.zdry.bean.ZdryZdrkxxb;
import com.founder.zdry.bean.ZdryZdryzb;
import com.founder.zdry.bean.ZdryZszhjsbrxxb;
import com.founder.zdry.dao.ZdryLczywblbDao;
import com.founder.zdry.dao.ZdryShbzdryxxbDao;
import com.founder.zdry.dao.ZdryYwspbDao;
import com.founder.zdry.dao.ZdryZdryzbDao;
import com.founder.zdry.service.ZdryLcgService;
import com.founder.zdry.service.ZdryShbzdryxxbService;
import com.founder.zdry.vo.ZdryShbzdryVo;
/***
 * ****************************************************************************
 * @Package:      [com.founder.zdry.service.impl.ZdryShbzdryxxbServiceImpl.java]  
 * @ClassName:    [ZdryShbzdryxxbServiceImpl]   
 * @Description:  [涉环保重点人员service实现类]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2015-6-15 上午10:53:03]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-15 上午10:53:03，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("zdryShbzdryxxbService")
@Transactional
public class ZdryShbzdryxxbServiceImpl extends BaseService implements ZdryShbzdryxxbService {
	@Resource(name="zdryShbzdryxxbDao")
	private ZdryShbzdryxxbDao zdryShbzdryxxbDao;
	@Resource
	private ZdryZdryzbDao zdryZdryzbDao;
	@Resource(name = "ryRyjbxxbService")
	private RyRyjbxxbService ryRyjbxxbService;
	@Resource(name = "zdryYwspbDao")
	private ZdryYwspbDao zdryYwspbDao;
	@Resource
	private ZdryLcgService zdryLcgService;
	@Resource(name = "sysMessageDao")
	private SysMessageDao sysMessageDao;
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;
	
	
	public static final String ZDRYGLLXDM ="7";

	
	//列撤转业务办理发起原因
	public static final String ZDRY_LCZYWBLB_FQYY = "申请涉环保人员登记";
	
	@Resource(name = "zdryLczywblbDao")
	private ZdryLczywblbDao zdryLczywblbDao;
	
	@Override
	public EasyUIPage queryList(ZdryZdryzb entity, EasyUIPage page,SessionBean sessionBean) {
		
        String userLevel=sessionBean.getUserOrgLevel();
		if(userLevel.equals("30")){
			entity.setSszrqdm(sessionBean.getUserOrgCode());	
		}else if(userLevel.equals("31")){
			entity.setSszrqdm(this.orgOrganizationService.queryParentOrgByOrgcode(sessionBean.getUserOrgCode()).getOrgcode());

		}
		page=zdryShbzdryxxbDao.queryList(entity, page);
		String userOrgCode=sessionBean.getUserOrgCode();
		String userOrgName=sessionBean.getUserOrgName();
		for(ZdryZdryzb zb:(List<ZdryZdryzb>)page.getRows()){
			//为了页面展现登记部门
			if(userLevel.equals("31")){
				zb.setSsfxjdm(userOrgName);
			}else if(userLevel.equals("30")){
				zb.setSsfxjdm(this.orgOrganizationService.queryByOrgcode(zb.getSsfxjdm()).getOrgname());
			}
		}
		return page;
	}
	
	
	@Override
	public void create(ZdryShbzdryVo zdryShbzdryVo,SessionBean sessionBean) throws BussinessException {
		ZdryZdryzb zdryzb=zdryShbzdryVo.getZdryzb();
		ZdryShbzdryxxb shbzdry=zdryShbzdryVo.getShbzdry();
		RyRyjbxxb ryjbxxb=null;
		if(!StringUtils.isBlank(zdryzb.getRyid())){
			ryjbxxb= ryRyjbxxbService.queryById(zdryzb.getRyid());
		}
		//1、判断是否登记为涉环保人员
		//身份证、临时身份证、驾驶证
		if("111".equals(zdryzb.getCyzjdm()) || "112".equals(zdryzb.getCyzjdm())
				|| "335".equals(zdryzb.getCyzjdm())){
			List<ZdryZdryzb>  zbs=zdryZdryzbDao.queryZdrylxdmByGmsfhm(zdryzb.getZjhm());
            if(zbs!=null && zbs.size()>0){
                throw new BussinessException("该人员已被登记为涉环保重点人员，不能重复登记");
            }
			
		}
		
		//2、生成重点人员总表数据（管理状态设置为1）
		zdryzb.setId(UUID.create());
		zdryzb.setSyrkid("shehuanbaozdryid");
		zdryzb.setGlzt("1");//申请中
		zdryzb.setSfzkdm("1");
		zdryzb.setZdrygllxdm(ZDRYGLLXDM);//设置类别为7
		zdryzb.setSfjm("1");
		//TODO 暂时写死 大连 需要计算
		zdryzb.setJzd_szdsdm("210200");
		if(ryjbxxb!=null){
			zdryzb.setDz_hjdzdm(ryjbxxb.getHjd_dzid());
			zdryzb.setDz_hjdzmlpdm(ryjbxxb.getHjd_mlpdm());
			zdryzb.setDz_hjdzmlpxz(ryjbxxb.getHjd_mlpxz());
			zdryzb.setDz_hjdzxz(ryjbxxb.getHjd_dzxz());
		}
		BaseService.setSaveProperties(zdryzb, sessionBean);
		this.zdryZdryzbDao.insert(zdryzb);
		//3、生成重点人员类别表数据
		//没有类别 不需要保存
		
		
		//4、生成涉环保重点人员表数据
		shbzdry.setId(zdryzb.getId());
		BaseService.setSaveProperties(shbzdry, sessionBean);
		this.zdryShbzdryxxbDao.save(shbzdry);
		
		
		//5、生成列撤转业务办理表数据
		ZdryLczywblb zdryLczywblb = new ZdryLczywblb();
		zdryLczywblb.setId(UUID.create());
		zdryLczywblb.setZdryid(zdryzb.getId());
		zdryLczywblb.setYwlx(ZdryShbzdryxxbServiceImpl.ZDRYGLLXDM);
		zdryLczywblb.setSspcsdm(zdryzb.getSspcsdm());
		zdryLczywblb.setDz_jzdzmlpdm(zdryzb.getDz_jzdzmlpdm());
		zdryLczywblb.setDz_jzdzmlpxz(zdryzb.getDz_jzdzmlpxz());
		zdryLczywblb.setDz_jzdzdm(zdryzb.getDz_jzdzdm());
		zdryLczywblb.setDz_jzdzxz(zdryzb.getDz_jzdzxz());
		zdryLczywblb.setYwblr_xm(sessionBean.getUserName());
		zdryLczywblb.setYwblr_id(sessionBean.getUserId());
		zdryLczywblb.setYwfqyy(ZDRY_LCZYWBLB_FQYY);
		zdryLczywblb.setYwclsj(DateUtils.getSystemDateString());
		zdryLczywblb.setYwcljg(ZdryLczywblb.YWCLJG_CLZ);
		zdryLczywblb.setBz(sessionBean.getUserOrgName());
		BaseService.setSaveProperties(zdryLczywblb, sessionBean);
		zdryLczywblbDao.save(zdryLczywblb);

		
		//6、生成一级审批 7、发消息审批
		//判断录入人市市局还是分县局的// 以0结尾并且不等于50的是市局，以1结尾是分县局
		String userLevel = sessionBean.getUserOrgLevel();
		if(userLevel.equals("10")||userLevel.equals("20")||userLevel.equals("30")||userLevel.equals("40")){
	    	zdryLcgService.sendApproval(sessionBean.getUserOrgCode(), "DDZ", zdryLczywblb.getId(), sessionBean);
		}else if(userLevel.equals("21")||userLevel.equals("31")||userLevel.equals("41")){
	    	zdryLcgService.sendApproval(sessionBean.getUserOrgCode(), "DDZ", zdryLczywblb.getId(), sessionBean);
		}
		
		
		
		
	}


	@Override
	public void updateSybzdry1jYwspb(ZdryYwspb zdryYwspb,
			SessionBean sessionBean, String messageid) {
        //1、修改业务审批表
		//2、修改系统消息被查看过
		//3、生成二级审批表数据
		super.setUpdateProperties(zdryYwspb, sessionBean);
		zdryYwspbDao.update(zdryYwspb);
		zdryYwspb = zdryYwspbDao.queryById(zdryYwspb.getId());
		try{
			SysMessage sysmessage = new SysMessage();
			sysmessage.setId(Long.valueOf(messageid));
			sysmessage.setCksj(DateUtils.getSystemDateTimeString());
			sysMessageDao.upadate(sysmessage);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		   ZdryLczywblb zdryLczywblb = zdryLczywblbDao.queryById(zdryYwspb
				.getYwbid());
		   if ("1".equals(zdryYwspb.getSpjg())) {// 审批通过
			   //通过之后发起二级审批
			   String userLevel = sessionBean.getUserOrgLevel();
				if(userLevel.equals("10")||userLevel.equals("20")||userLevel.equals("30")||userLevel.equals("40")){
					OrgOrganization org = this.orgOrganizationService.queryParentOrgByOrgcode(sessionBean.getUserOrgCode());

			    	zdryLcgService.sendApproval(org.getOrgcode(), "ZDZ", zdryLczywblb.getId(), sessionBean);
				}else if(userLevel.equals("21")||userLevel.equals("31")||userLevel.equals("41")){
					OrgOrganization org = this.orgOrganizationService.queryParentOrgByOrgcode(sessionBean.getUserOrgCode());
	                
			    	zdryLcgService.sendApproval(org.getOrgcode(), "FJZ", zdryLczywblb.getId(), sessionBean);
				}
				
			} else if ("0".equals(zdryYwspb.getSpjg())) {
				
				//1 业务办理表结果改成失败
				zdryLczywblb.setYwcljg(ZdryLczywblb.YWCLJG_SB);
				zdryLczywblbDao.update(zdryLczywblb);
				//2 重点人员总表注销标志改成1
				ZdryZdryzb zbZdryzd=this.zdryZdryzbDao.queryById(zdryLczywblb.getZdryid());
				this.zdryZdryzbDao.delete(zbZdryzd);
				//3 涉环保重点人员注销标志改成1	
				ZdryShbzdryxxb zdryShbzdryxxb = zdryShbzdryxxbDao.queryById(zbZdryzd.getId());
				zdryShbzdryxxbDao.delete(zdryShbzdryxxb);
				//4 审批失败 给发起人发消息 提醒审批失败
				SysMessage sbMessage = new SysMessage();
				sbMessage.setFsr(sessionBean.getUserName());
				sbMessage.setFsrdm(sessionBean.getUserId());
				sbMessage.setFssj(DateUtils.getSystemDateTimeString());
				sbMessage.setFsrssdw(sessionBean.getUserOrgName());
				sbMessage.setFsrssdwdm(sessionBean.getUserOrgCode());
				sbMessage.setXxbt("涉环保重点人员审批提醒");
				sbMessage.setXxnr(sessionBean.getUserName()+"拒绝您的涉环保重点人员"+zbZdryzd.getXm()+"申请");
				sbMessage.setXxlb("1");
			
				sysMessageDao.saveMessageByUser(sbMessage,zdryLczywblb.getYwblr_id());

			}

		
	
		
	}


	@Override
	public void updateSybzdry2jYwspb(ZdryYwspb zdryYwspb,
			SessionBean sessionBean, String messageid) {

	        //1、修改业务审批表
			//2、修改系统消息被查看过
			//3、生成二级审批表数据
			super.setUpdateProperties(zdryYwspb, sessionBean);
			zdryYwspbDao.update(zdryYwspb);
			zdryYwspb = zdryYwspbDao.queryById(zdryYwspb.getId());
			try{
				SysMessage sysmessage = new SysMessage();
				sysmessage.setId(Long.valueOf(messageid));
				sysmessage.setCksj(DateUtils.getSystemDateTimeString());
				sysMessageDao.upadate(sysmessage);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			   ZdryLczywblb zdryLczywblb = zdryLczywblbDao.queryById(zdryYwspb
					.getYwbid());
			   
			   if ("1".equals(zdryYwspb.getSpjg())) {// 审批通过
				   //1 修改业务办理表结果为成功
					zdryLczywblb.setYwcljg(ZdryLczywblb.YWCLJG_CG);
					zdryLczywblbDao.update(zdryLczywblb);
				   //2 修改重点人员状态为2
					ZdryZdryzb zbZdryzb=this.zdryZdryzbDao.queryById(zdryLczywblb.getZdryid());
					zbZdryzb.setGlzt("2");
					this.zdryZdryzbDao.update(zbZdryzb);
				   //3 给发起人发消息 通知成功
					SysMessage cgMessage = new SysMessage();
					cgMessage.setFsr(sessionBean.getUserName());
					cgMessage.setFsrdm(sessionBean.getUserId());
					cgMessage.setFssj(DateUtils.getSystemDateTimeString());
					cgMessage.setFsrssdw(sessionBean.getUserOrgName());
					cgMessage.setFsrssdwdm(sessionBean.getUserOrgCode());
					cgMessage.setXxbt("涉环保重点人员审批提醒");
					cgMessage.setXxnr(sessionBean.getUserName()+"同意您的涉环保重点人员"+zbZdryzb.getXm()+"的申请");
					cgMessage.setXxlb("1");
					sysMessageDao.saveMessageByUser(cgMessage,zdryLczywblb.getYwblr_id());

			   
				} else if ("0".equals(zdryYwspb.getSpjg())) {
					//1 业务办理表结果改成失败
					zdryLczywblb.setYwcljg(ZdryLczywblb.YWCLJG_SB);
					zdryLczywblbDao.update(zdryLczywblb);
					//2 重点人员总表注销标志改成1
					ZdryZdryzb zbZdryzd=this.zdryZdryzbDao.queryById(zdryLczywblb.getZdryid());
					this.zdryZdryzbDao.delete(zbZdryzd);
					//3 涉环保重点人员注销标志改成1	
					ZdryShbzdryxxb zdryShbzdryxxb = zdryShbzdryxxbDao.queryById(zbZdryzd.getId());
					zdryShbzdryxxbDao.delete(zdryShbzdryxxb);
					//4 给发起人发生消息提醒
					SysMessage sbMessage = new SysMessage();
					sbMessage.setFsr(sessionBean.getUserName());
					sbMessage.setFsrdm(sessionBean.getUserId());
					sbMessage.setFssj(DateUtils.getSystemDateTimeString());
					sbMessage.setFsrssdw(sessionBean.getUserOrgName());
					sbMessage.setFsrssdwdm(sessionBean.getUserOrgCode());
					sbMessage.setXxbt("涉环保重点人员审批提醒");
					sbMessage.setXxnr(sessionBean.getUserName()+"拒绝您的涉环保重点人员"+zbZdryzd.getXm()+"的申请");
					sbMessage.setXxlb("1");
				
					sysMessageDao.saveMessageByUser(sbMessage,zdryLczywblb.getYwblr_id());
				}
			   
	}
			
}
