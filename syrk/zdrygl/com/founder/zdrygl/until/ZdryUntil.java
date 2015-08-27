package com.founder.zdrygl.until;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.config.SystemConfig;
import com.founder.framework.dictionary.service.SysDictGlService;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.message.dao.SysMessageDao;
import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.organization.user.bean.OrgUser;
import com.founder.framework.organization.user.service.OrgUserService;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.StringUtils;
import com.founder.tzgg.bean.Org_Organization;
import com.founder.tzgg.dao.TzggDao;
import com.founder.zdrygl.bean.ZdryFzcsfryxxb;
import com.founder.zdrygl.bean.ZdryGzb;
import com.founder.zdrygl.bean.ZdryJgdxxxb;
import com.founder.zdrygl.bean.ZdrySgafzdryxxb;
import com.founder.zdrygl.bean.ZdryShbzdryxxb;
import com.founder.zdrygl.bean.ZdrySqjzryxxb;
import com.founder.zdrygl.bean.ZdrySqsbzdryxxb;
import com.founder.zdrygl.bean.ZdryZdrkxxb;
import com.founder.zdrygl.bean.ZdryZdryzb;
import com.founder.zdrygl.bean.ZdryZszhjsbrxxb;
import com.founder.zdrygl.bean.Zdrylxylbdyb;
import com.founder.zdrygl.dao.ZdryFzcsfryxxbDao;
import com.founder.zdrygl.dao.ZdryGzbDao;
import com.founder.zdrygl.dao.ZdryJgdxxxbDao;
import com.founder.zdrygl.dao.ZdrySgafzdryxxbDao;
import com.founder.zdrygl.dao.ZdryShbzdryxxbDao;
import com.founder.zdrygl.dao.ZdrySqjzryxxbDao;
import com.founder.zdrygl.dao.ZdryZdrkxxbDao;
import com.founder.zdrygl.dao.ZdryZdryzbDao;
import com.founder.zdrygl.dao.ZdryZszhjsbrxxbDao;
import com.founder.zdrygl.service.ZdryOperationService;
import com.founder.zdrygl.service.ZdryZdryzbService;
import com.founder.zdrygl.service.ZdrylxylbdybService;
import com.founder.zdrygl.vo.ZdryVO;
import com.founder.zdrygl.vo.ZdryZdryzbVO;

@Service("ZdryUntil")
@Transactional
public class ZdryUntil {

	@Resource(name = "sysDictGlService")
	private SysDictGlService sysDictGlService;
	@Resource(name = "zdryGzbDao")
	private ZdryGzbDao zdryGzbDao;

	@Resource(name = "zdryZdryzbDao")
	private ZdryZdryzbDao zdryZdryzbDao;
	@Resource(name = "zdryZAOperationService")
	private ZdryOperationService zdryZAOperationService;

	@Resource(name = "zdryFzcsfOperationService")
	private ZdryOperationService zdryFzcsfOperationService;

	@Resource(name = "zdryJgdxOperationService")
	private ZdryOperationService zdryJgdxOperationService;

	@Resource(name = "zdryZdrkOperationService")
	private ZdryOperationService zdryZdrkOperationService;

	@Resource(name = "zdryZszhjsbrOperationService")
	private ZdryOperationService zdryZszhjsbrOperationService;

	@Resource(name = "zdryHBOperationService")
	private ZdryOperationService zdryHBOperationService;

	@Resource(name = "zdrySqjzOperationService")
	private ZdryOperationService zdrySqjzOperationService;

	@Resource(name = "zdrySqsbOperationService")
	private ZdryOperationService zdrySqsbOperationService;
	
	@Resource(name = "zdrySGAFOperationService")
	private ZdryOperationService zdrySGAFOperationService;

	@Resource(name="zdrylxylbdybService")
	private ZdrylxylbdybService zdrylxylbdybService;
	
	@Resource(name = "zdryJgdxxxbDao")
	private ZdryJgdxxxbDao zdryJgdxxxbDao;
	
	@Resource(name = "zdryShbzdryxxbDao")
	private ZdryShbzdryxxbDao zdryShbzdryxxbDao;
	@Resource(name = "zdryZdrkxxbDao")
	private ZdryZdrkxxbDao zdryZdrkxxbDao;
	@Resource(name = "zdryZszhjsbrxxbDao")
	private ZdryZszhjsbrxxbDao zdryZszhjsbrxxbDao;
	
	@Resource(name = "zdryFzcsfryxxbDao")
	private ZdryFzcsfryxxbDao zdryFzcsfryxxbDao;
	
	@Resource(name = "zdrySgafzdryxxbDao")
	private ZdrySgafzdryxxbDao zdrySgafzdryxxbDao;
	
	
	@Resource(name = "zdrySqjzryxxbDao")
	private ZdrySqjzryxxbDao zdrySqjzryxxbDao;
	
	
	@Resource(name = "sysMessageDao")
	private SysMessageDao sysMessageDao;
	@Resource(name = "zdryZdryzbService")
	private ZdryZdryzbService zdryZdryzbService;
	@Resource
	private OrgOrganizationService orgOrganizationService;
	@Resource
	private TzggDao tzggDao;
	@Resource
	private  OrgUserService orgUserService;
	
	
	
	
	
	
	
	/***
	 * 
	 * @Title: getZdryGlLxByList
	 * @Description: 根据查询结果处理要显示的STR和撤管可选择的过滤条件
	 * @param @param list
	 * @param @return 设定文件
	 * @return Map<String,String> 返回类型包含要显示的str和可以过滤的条件
	 * @throws
	 */
	public Map<String, String> getZdryGlLxByList(List<ZdryZdryzbVO> list,
			String syrkid) {

		return null;
	}
	

	/***
	 * 
	 * @Title: querySYSConfig
	 * @Description: TODO(查询重口区域)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String querySYSConfig() {
		return SystemConfig.getString("zdryQY");
	}

	/**
	 * 
	 * @Title: getZdryService
	 * @Description: TODO(获取重点人员服务类)
	 * @param @param servie
	 * @param @return 设定文件
	 * @return ZdryOperationService 返回类型
	 * @throws
	 */
	public ZdryOperationService getZdryService(String service) {
		if (("JGDX").equals(service)||"06".equals(service)) {// 监管对象
			return zdryJgdxOperationService;
		} else if (("ZDRK").equals(service)||"02".equals(service)) {// 重口
			return zdryZdrkOperationService;

		} else if (("ZSZHJSBR").equals(service)||"03".equals(service)) {// 精神病人
			return zdryZszhjsbrOperationService;

		} else if (("FZCSF").equals(service)||"04".equals(service)) {// 非正常上访
			return zdryFzcsfOperationService;

		} else if (("SHB").equals(service)||"07".equals(service)) {// 涉环保
			return zdryHBOperationService;

		} else if (("SQJZRY").equals(service)||"01".equals(service)) {// 社区矫正
			return zdrySqjzOperationService;

		} else if (("SQSB").equals(service)||"08".equals(service)) {// 涉枪涉暴
			return zdrySqsbOperationService;

		} else if (("SGAF").equals(service)||"05".equals(service)) {// 涉公安访
			return zdrySGAFOperationService;

		} else {
			return zdryZAOperationService;
		}
	}

	/**
	 * 
	 * @Title: initZdryEntity
	 * @Description: TODO(初始化重点人员实体)
	 * @param @param service
	 * @param @param zdryVO
	 * @param @param sessionBean 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void initZdryEntity(String service, ZdryVO zdryVO,
			SessionBean sessionBean) {
		if (("JGDX").equals(service)||"06".equals(service)) {// 监管对象
			ZdryJgdxxxb zdryJgdxxxb = zdryVO.getZdryJgdxxxb();
			if (zdryJgdxxxb == null) {
				zdryJgdxxxb = new ZdryJgdxxxb();
				zdryVO.setZdryJgdxxxb(zdryJgdxxxb);
			}
			BaseService.setSaveProperties(zdryJgdxxxb, sessionBean);

		} else if (("ZDRK").equals(service)||"02".equals(service)) {// 重口
			ZdryZdrkxxb zdryZdrkxxb = zdryVO.getZdryZdrkxxb();
			if (zdryZdrkxxb == null) {
				zdryZdrkxxb = new ZdryZdrkxxb();
				zdryVO.setZdryZdrkxxb(zdryZdrkxxb);
			}
			BaseService.setSaveProperties(zdryZdrkxxb, sessionBean);

		} else if (("ZSZHJSBR").equals(service)||"03".equals(service)) {// 精神病人
			ZdryZszhjsbrxxb zdryZszhjsbrxxb = zdryVO.getZdryZszhjsbrxxb();
			if (zdryZszhjsbrxxb == null) {
				zdryZszhjsbrxxb = new ZdryZszhjsbrxxb();
				zdryVO.setZdryZszhjsbrxxb(zdryZszhjsbrxxb);
			}
			BaseService.setSaveProperties(zdryZszhjsbrxxb, sessionBean);

		} else if (("FZCSF").equals(service)||"04".equals(service)) {// 非正常上访
			ZdryFzcsfryxxb zdryFzcsfryxxb = zdryVO.getZdryFzcsfryxxb();
			if (zdryFzcsfryxxb == null) {
				zdryFzcsfryxxb = new ZdryFzcsfryxxb();
				zdryVO.setZdryFzcsfryxxb(zdryFzcsfryxxb);
			}
			BaseService.setSaveProperties(zdryFzcsfryxxb, sessionBean);
		} else if (("SHB").equals(service)||"07".equals(service)) {// 涉环保
			ZdryShbzdryxxb zdryShbzdryxxb = zdryVO.getZdryShbzdryxxb();
			if (zdryShbzdryxxb == null) {
				zdryShbzdryxxb = new ZdryShbzdryxxb();
				zdryVO.setZdryShbzdryxxb(zdryShbzdryxxb);
			}
			BaseService.setSaveProperties(zdryShbzdryxxb, sessionBean);
		} else if (("SQJZRY").equals(service)||"01".equals(service)) {// 社区矫正人员
			ZdrySqjzryxxb zdrySqjzryxxb = zdryVO.getZdrySqjzryxxb();
			if (zdrySqjzryxxb == null) {
				zdrySqjzryxxb = new ZdrySqjzryxxb();
				zdryVO.setZdrySqjzryxxb(zdrySqjzryxxb);
			}
			BaseService.setSaveProperties(zdrySqjzryxxb, sessionBean);
		} else if (("SQSB").equals(service)||"08".equals(service)) {// 涉枪涉暴
			ZdrySqsbzdryxxb zdrySqsbzdryxxb = zdryVO.getZdrySqsbzdryxxb();
			if (zdrySqsbzdryxxb == null) {
				zdrySqsbzdryxxb = new ZdrySqsbzdryxxb();
				zdryVO.setZdrySqsbzdryxxb(zdrySqsbzdryxxb);
			}
			BaseService.setSaveProperties(zdrySqsbzdryxxb, sessionBean);
		}else if (("SGAF").equals(service)||"05".equals(service)) {// 涉公安访
			ZdrySgafzdryxxb zdrySgafzdryxxb = zdryVO.getZdrySgafzdryxxb();
			if (zdrySgafzdryxxb == null) {
				zdrySgafzdryxxb = new ZdrySgafzdryxxb();
				zdryVO.setZdrySgafzdryxxb(zdrySgafzdryxxb);
			}
			BaseService.setSaveProperties(zdrySgafzdryxxb, sessionBean);
		}
	}

	/***
	 * 
	 * @Title: lgSuccess
	 * @Description: TODO(列管成功，修改数据库状态)
	 * @param 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void lgSuccess(String zdryId,String zdryxm,String ywsqrId,String spr,String spbm,String cghZdryId) {
		ZdryZdryzb zdryZdryzb = (ZdryZdryzb) zdryZdryzbDao.queryById(zdryId);
		zdryZdryzb.setGlzt("2");
		zdryZdryzbDao.update(zdryZdryzb);
		sendMessageByLC(zdryxm, ywsqrId, spr, spbm, zdryId, cghZdryId, "LG", "1");
		//如果是涉环保重点人员列管成功，还要给接受部门的人发消息提醒
	     if("07".equals(zdryZdryzb.getZdrygllxdm())){
	    	 //给环保接收部门发消息
	    	 sendMessageToJsbm(zdryId, ywsqrId); 
	     
	     }
	}

	/**
	 * 涉环保重口 要给接收的环保大队发消息
	 * @param zdryId
	 * @param ywsqrId
	 */
	private void sendMessageToJsbm(String zdryId, String ywsqrId) {
		ZdryShbzdryxxb shb=this.zdryShbzdryxxbDao.queryById(zdryId);
		 
		 OrgOrganization fxj=this.orgOrganizationService.queryByOrgcode(shb.getSsfxjdm());
		 Org_Organization org=new Org_Organization();
		 org.setOrgbiztype("11");
		 org.setParentid(fxj.getId());
		 //查分县局下的环保大队
		 List<Org_Organization> hbdds =  this.tzggDao.queryOrg(org);
		 Org_Organization hbdd = hbdds.get(0);
		 OrgUser orgUser = orgUserService.queryByUserid(ywsqrId);
		 
		 SysMessage message = new SysMessage();
		 message.setXxbt("涉环保重点人员管控提醒");
		 message.setXxnr(orgUser.getUsername()+"把涉环保重点人员" +shb.getXm() +"("+shb.getZjhm()+")下发给你部门，请开展日常管理工作");	 		
		 message.setXxlb("1");
		 message.setFssj(DateUtils.getSystemDateTimeString());
		 message.setFsr(orgUser.getUsername());
		 message.setFsrdm(ywsqrId);
		 message.setFsrssdw(shb.getXt_lrrbm());
		 message.setFsrssdwdm(shb.getXt_lrrbmid());
	//	 sysMessageDao.saveMessageByOrg(message, hbdd.getOrgcode(), false,true);
	}

	/**
	 * *
	 * 
	 * @Title: lgFail
	 * @Description: TODO(列管失败,修改数据库状态)
	 * @param 设定文件
	 * @return void 返回类型
	 * @throws
	 */

	public void lgFail(String zdryId,String zdryxm,String ywsqrId,String spr,String spbm,String cghZdryId) {
		ZdryZdryzb zdryZdryzb = (ZdryZdryzb) zdryZdryzbDao.queryById(zdryId);
		zdryZdryzbDao.delete(zdryZdryzb);
		String zdrylx = zdryZdryzb.getZdrygllxdm();
		Zdrylxylbdyb zdrylxylbdyb = new Zdrylxylbdyb();
		zdrylxylbdyb.setLbdm(zdrylx);
		zdrylxylbdyb = zdrylxylbdybService.query(zdrylxylbdyb);
		// 根据类型删除对应表数据
		if ("监管对象".equals(zdrylxylbdyb.getBz())) {
			zdryJgdxxxbDao.delete(zdryJgdxxxbDao.queryById(zdryId));
		} else if ("社区矫正人员".equals(zdrylxylbdyb.getBz())) {
			zdrySqjzryxxbDao.delete(zdrySqjzryxxbDao.queryById(zdryId));
		} else if ("重点人口".equals(zdrylxylbdyb.getBz())) {
			zdryZdrkxxbDao.delete(zdryZdrkxxbDao.queryById(zdryId));
		} else if ("肇事肇祸精神病人".equals(zdrylxylbdyb.getBz())) {
			zdryZszhjsbrxxbDao.delete(zdryZszhjsbrxxbDao.queryById(zdryId));
		} else if ("非正常上访重点人员".equals(zdrylxylbdyb.getBz())) {
			zdryFzcsfryxxbDao.delete(zdryFzcsfryxxbDao.queryById(zdryId));
		} else if ("涉环保重点人员".equals(zdrylxylbdyb.getBz())) {
			zdryShbzdryxxbDao.delete(zdryShbzdryxxbDao.queryById(zdryId));
		} else if ("涉公安访重点人员".equals(zdrylxylbdyb.getBz())) {
			zdrySgafzdryxxbDao.delete(zdrySgafzdryxxbDao.queryById(zdryId));
		}
		sendMessageByLC(zdryxm, ywsqrId, spr, spbm, zdryId, cghZdryId, "LG", "0");
	}
	/***
	 * 
	 * @Title: cgFail
	 * @Description: TODO(撤管失败，修改数据库状态)
	 * @param 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void cgFail(String zdryId,String zdryxm,String ywsqrId,String spr,String spbm,String cghZdryId) {
		ZdryZdryzb zdryZdryzb = (ZdryZdryzb) zdryZdryzbDao.queryById(zdryId);
		zdryZdryzb.setGlzt("2");
		zdryZdryzbDao.update(zdryZdryzb);
		if(!StringUtils.isBlank(cghZdryId)){
			ZdryZdryzb entity = new ZdryZdryzb();
			entity.setId(cghZdryId);
			entity.setGlzt("1");
			zdryZdryzbDao.delete(entity);
		}
		sendMessageByLC(zdryxm, ywsqrId, spr, spbm, zdryId, cghZdryId, "CG", "0");
	}

	/**
	 * *
	 * 
	 * @Title: cgSuccess
	 * @Description: TODO(撤管成功,修改数据库状态)
	 * @param 设定文件
	 * @return void 返回类型
	 * @throws
	 */

	public void cgSuccess(String zdryId,String zdryxm,String ywsqrId,String spr,String spbm,String cghZdryId ) {
		ZdryZdryzb zdryZdryzb = (ZdryZdryzb) zdryZdryzbDao.queryById(zdryId);
		zdryZdryzb.setGlzt("4");
		zdryZdryzbDao.delete(zdryZdryzb);
		String zdrylx = zdryZdryzb.getZdrygllxdm();
		Zdrylxylbdyb zdrylxylbdyb = new Zdrylxylbdyb();
		zdrylxylbdyb.setLbdm(zdrylx);
		zdrylxylbdyb = zdrylxylbdybService.query(zdrylxylbdyb);
		// 根据类型删除对应表数据
		if ("监管对象".equals(zdrylxylbdyb.getBz())) {
			zdryJgdxxxbDao.delete(zdryJgdxxxbDao.queryById(zdryId));
		} else if ("社区矫正人员".equals(zdrylxylbdyb.getBz())) {
			zdrySqjzryxxbDao.delete(zdrySqjzryxxbDao.queryById(zdryId));
		} else if ("重点人口".equals(zdrylxylbdyb.getBz())) {
			zdryZdrkxxbDao.delete(zdryZdrkxxbDao.queryById(zdryId));
		} else if ("肇事肇祸精神病人".equals(zdrylxylbdyb.getBz())) {
			zdryZszhjsbrxxbDao.delete(zdryZszhjsbrxxbDao.queryById(zdryId));
		} else if ("非正常上访重点人员".equals(zdrylxylbdyb.getBz())) {
			zdryFzcsfryxxbDao.delete(zdryFzcsfryxxbDao.queryById(zdryId));
		} else if ("涉环保重点人员".equals(zdrylxylbdyb.getBz())) {
			zdryShbzdryxxbDao.delete(zdryShbzdryxxbDao.queryById(zdryId));
		} else if ("涉公安访重点人员".equals(zdrylxylbdyb.getBz())) {
			zdrySgafzdryxxbDao.delete(zdrySgafzdryxxbDao.queryById(zdryId));
		}
		if(!StringUtils.isBlank(cghZdryId)){
			ZdryZdryzb entity = new ZdryZdryzb();
			entity.setId(cghZdryId);
			entity.setGlzt("2");
			zdryZdryzbDao.update(entity);
		}
		
	//后期删除所有附件属性表
		sendMessageByLC(zdryxm, ywsqrId, spr, spbm, zdryId, cghZdryId, "CG", "1");
	}
	
	
	/**
	 * 
	 * @Title: zdSuccess
	 * @Description: TODO(转递成功)
	 * @param     设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void zdSuccess(String zdryid,String zdryxm,String ywsqrId,String spr,String spbm,String ywsqr,String sfcj,String yglbm ,String xglbm){
		
		ZdryZdryzb zdryZdryzb=(ZdryZdryzb)zdryZdryzbDao.queryById(zdryid);
		zdryZdryzb.setGlzt("2");
		zdryZdryzb.setGlbm(xglbm);
		zdryZdryzbDao.update(zdryZdryzb);
		sendMessageByZd( zdryxm, ywsqr, spr, spbm, zdryZdryzb.getId(), "ZD", "1", sfcj, ywsqrId, yglbm, xglbm);
		
		
	}
	/**
	 * 
	 * @Title: zdFail
	 * @Description: TODO(转递失败)
	 * @param     设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void zdFail(String zdryid,String zdryxm,String ywsqrId,String spr,String spbm,String ywsqr,String sfcj,String yglbm ,String xglbm){
		
		ZdryZdryzb zdryZdryzb=(ZdryZdryzb)zdryZdryzbDao.queryById(zdryid);
		zdryZdryzb.setGlzt("2");
		zdryZdryzbDao.update(zdryZdryzb);
		sendMessageByZd( zdryxm, ywsqr, spr, spbm, zdryZdryzb.getId(), "ZD", "1", sfcj, ywsqrId, yglbm, xglbm);
		
	}

	/***
	 * 
	 * @Title: sendMessageByLczywb
	 * @Description: TODO(根据不同业务给不同的人发送不同的消息内容)
	 * @param @param lczywbId
	 * @param @param sessionBean 设定文件
	 * @return void 返回类型
	 * @throws
	 */

	public void sendMessageByLC(String zdryxm,String ywsqrId,String spr,String spbm,String zdryId,String cghZdryId,String ywType,String ywjg) {
		Map<String, String> dictMap = new HashMap<String, String>();
		try {
			dictMap = sysDictGlService.getDictMap("DL_D_ZDRYGLLXDM");
		} catch (Exception e) {
			e.printStackTrace();
		}
		ZdryZdryzb zb=this.zdryZdryzbService.queryById(zdryId);
		
		//把code 改成名称
		spbm=this.orgOrganizationService.queryByOrgcode(spbm).getOrgname();
//		spr=this.orgUserService.queryByUserid(ywsqrId).getUsername();
		// 根据业务表数据,构造代办消息
		String xxnr = "";
		String userIDString = ywsqrId;
		String orgcode="";
		SysMessage message = new SysMessage();
		// 查询相关重点人员总表
		if ("LG".equals(ywType)) {
			message.setXxbt("重点人员列管审批结果");
			if (ywjg.equals("1")) {
				xxnr = spbm + spr + "审批同意重点人员"
						+ zdryxm + "的列管申请。";
			} else if (ywjg.equals("0")) {
				xxnr = spbm + spr + "审批不同意重点人员"
						+ zdryxm + "的列管申请。";
			}
		} else if ("CG".equals(ywType)) {
			message.setXxbt("重点人员撤管审批结果");
			// 撤管，找寻撤管后类型
			ZdryZdryzb cghZdryZb=null;
			if(StringUtils.isBlank(cghZdryId)){
				cghZdryZb =new ZdryZdryzb();
				cghZdryZb.setZdrygllxdm("6");
			}else{
			 cghZdryZb = (ZdryZdryzb) zdryZdryzbDao.queryById(cghZdryId);
			}
			if (ywjg.equals("1")) {
				xxnr = spbm + spr + "审批同意将重点人员"
						+ zdryxm + "撤管为"
						+ dictMap.get(cghZdryZb.getZdrygllxdm()) + "的申请。";
			} else if (ywjg.equals("0")) {
				xxnr = spbm + spr + "审批不同意将重点人员"
						+ zdryxm + "撤管为"
						+ dictMap.get(cghZdryZb.getZdrygllxdm()) + "的申请。";
			}
		} 
		 OrgUser orgUser = orgUserService.queryByUserid(ywsqrId);
		message.setXxnr(xxnr);
		message.setXxlb("1");
		 message.setXxlb("1");
		 message.setFssj(DateUtils.getSystemDateTimeString());
		 message.setFsr(orgUser.getUsername());
		 message.setFsrdm(ywsqrId);
		 message.setFsrssdw(zb.getXt_lrrbm());
		 message.setFsrssdwdm(zb.getXt_lrrbmid());
	//	sysMessageDao.saveMessageByUser(message, userIDString);
	//	sysMessageDao.saveMessageByOrgAndPos(message, orgcode, "SZ");
	}
	
	
	
	private void sendMessageByZd(String zdryxm,String ywsqr,String spr,String spbm,String zdryId,String ywType,String ywjg,String sfcj,String ywsqrId,String yglbm,String xglbm){
		Map<String, String> dictMap = new HashMap<String, String>();
		try {
			dictMap = sysDictGlService.getDictMap("DL_D_ZDRYGLLXDM");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 根据业务表数据,构造代办消息
		String xxnr = "";
		String userIDString = ywsqrId;
		String orgcode="";
		SysMessage message = new SysMessage();
		ZdryZdryzb zdryZdryzb = (ZdryZdryzb) zdryZdryzbDao.queryById(zdryId);
		if ("ZD".equals(ywType)) {
			// 发起辖区
			message.setXxbt("重点人员转递结果");
			if (ywjg.equals("1")) {
				xxnr =spbm + "民警"
						+ spr + "已同意接收"
						+ dictMap.get(zdryZdryzb.getZdrygllxdm())
						+ zdryxm + "。";
			}
			if ("1".equals(sfcj)) {
				message.setXxbt("重点人员裁定结果");
				if (ywjg.equals("0")) {
					xxnr = "原辖区为" +ywsqr + "的"
							+ dictMap.get(zdryZdryzb.getZdrygllxdm())
							+ zdryxm + "裁定为由原辖区继续管理。";
				} else if (ywjg.equals("1")) {
					xxnr = "原辖区为" + ywsqr + "的"
							+ dictMap.get(zdryZdryzb.getZdrygllxdm())
							+ zdryxm+ "裁定为由接收辖区" + xglbm+ "管理。";
				}
			}
		}  
		message.setXxnr(xxnr);
		message.setXxlb("1");
	//	sysMessageDao.saveMessageByUser(message, userIDString);
	//	sysMessageDao.saveMessageByOrgAndPos(message, orgcode, "SZ");
	}
	
		
	/**
	 * 
	 * @Title: validateState
	 * @Description: TODO(验证可办理业务的状态,管理状态:1列管申请中,2已列管,3撤管申请中,4已撤管,5转递申请中,6涉公安访下发中,7转类申请中)
	 * @param @param glzt    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void validateState(String glzt){
		if("1".equals(glzt)){
			throw new BussinessException("该重点人员正在【列管申请中】，不能办理其他业务");
		}
		if("3".equals(glzt)){
			throw new BussinessException("该重点人员正在【撤管申请中】，不能办理其他业务");
		}
		if("4".equals(glzt)){
			throw new BussinessException("该重点人员 【已撤管】，不能办理其他业务");
		}
		if("5".equals(glzt)){
			throw new BussinessException("该重点人员正在 【转递申请中】，不能办理其他业务");
		}
		if("6".equals(glzt)){
			throw new BussinessException("该重点人员正在【涉公安访下发中】，不能办理其他业务");
		}
		if("7".equals(glzt)){
			throw new BussinessException("该重点人员正在【转类申请中】，不能办理其他业务");
		}
	}
}
