package com.founder.yjjb.utils;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.message.dao.SysMessageDao;
import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.dao.OrgOrganizationDao;
import com.founder.framework.organization.user.bean.OrgUser;
import com.founder.framework.utils.DateUtils;
import com.founder.yjjb.bean.Jbjlspb;
import com.founder.yjjb.bean.Xszcspb;
import com.founder.yjjb.bean.Xszjspb;
import com.founder.yjjb.dao.CommonDao;

public class MessageUtils {
	
	private static String R_BLRY = "59549930";	//办理人员
	private static String R_SPRY = "59550161";	//审批人员
	public static ApplicationContext AC = ContextLoader.getCurrentWebApplicationContext();
	
	/**
	 * 3日反馈待办任务提醒
	 * @param id
	 * @param slfzdm
	 * @param session
	 * @return
	 */
	public static int db_3d(String id,String slfzdm,SessionBean session){
		OrgOrganizationDao orgOrganizationDao = AC.getBean(OrgOrganizationDao.class);
		CommonDao commonDao = AC.getBean(CommonDao.class);
		SysMessageDao sysMessageDao = AC.getBean(SysMessageDao.class);
		
		OrgOrganization organization = orgOrganizationDao.queryByOrgcode(slfzdm);
		List<OrgUser> list = commonDao.queryOrgUserByOrgCode(organization.getOrgcode(),R_BLRY);	//有奖举报办理人员
		int i = 0;
		for (OrgUser orgUser : list) {
			SysMessage message = new SysMessage();
			message.setYwurl("/xsjbxxb/openCC?id="+id+"&mainTabID=0");		//业务URL
			message.setFsr(session.getUserName());					//发送人
			message.setFsrdm(session.getUserId());					//发送人代码
			message.setFssj(DateUtils.getSystemDateTimeString());	//发送时间
			message.setFsrssdw(session.getUserOrgName());	//发送人所属单位
			message.setFsrssdwdm(session.getUserOrgCode());	//发送人所属单位代码
			message.setDxzt("");						//短信状态
			message.setSfck("0");						//是否查看
			message.setJsr(orgUser.getUsername());		//接收人
			message.setJsrdm(orgUser.getUserid());		//接收人代码
			message.setCksj("");						//查看时间
			message.setXxnr("接到来自"+session.getUserOrgName()+"的线索["+id+"]请于3日内反馈");	//消息内容
			
			// D_SYS_XXLB	消息类别	1	消息提醒	XXTX
			// D_SYS_XXLB	消息类别	2	工作任务	GZRW
			// D_SYS_XXLB	消息类别	3	通知公告	TZGG
			// D_SYS_XXLB	消息类别	4	通报公告	TBGG
			message.setXxlb("2");								
			message.setJsrssdw(organization.getOrgname());		//接收人所属单位
			message.setJsrssdwdm(organization.getOrgcode());	//接收人所属单位代码
			message.setXxbt("举报线索3日反馈");		//信息标题
			message.setDkfs("2");					//打开方式
			sysMessageDao.saveMessage(message);
			i++;
		}
		return i;
	}
	
	public static void rmdb_3d(String xsid){
		SysMessageDao sysMessageDao = AC.getBean(SysMessageDao.class);
		String ywurl = "/xsjbxxb/openCC?id="+xsid;
		sysMessageDao.updateYjjb(ywurl);
	}
	
	/**
	 * 30日反馈待办任务提醒
	 * @param id
	 * @param slfzdm
	 * @param session
	 * @return
	 */
	public static int db_30d(String id,String slfzdm,SessionBean session){
		OrgOrganizationDao orgOrganizationDao = AC.getBean(OrgOrganizationDao.class);
		CommonDao commonDao = AC.getBean(CommonDao.class);
		SysMessageDao sysMessageDao = AC.getBean(SysMessageDao.class);
		
		OrgOrganization organization = orgOrganizationDao.queryByOrgcode(slfzdm);
		List<OrgUser> list = commonDao.queryOrgUserByOrgCode(organization.getOrgcode(),R_BLRY);	//有奖举报办理人员
		int i = 0;
		for (OrgUser orgUser : list) {
			SysMessage message = new SysMessage();
			message.setYwurl("/xsjbxxb/openFC?id="+id+"&mainTabID=0");		//业务URL
			message.setFsr(session.getUserName());					//发送人
			message.setFsrdm(session.getUserId());					//发送人代码
			message.setFssj(DateUtils.getSystemDateTimeString());	//发送时间
			message.setFsrssdw(session.getUserOrgName());	//发送人所属单位
			message.setFsrssdwdm(session.getUserOrgCode());	//发送人所属单位代码
			message.setDxzt("");						//短信状态
			message.setSfck("0");						//是否查看
			message.setJsr(orgUser.getUsername());		//接收人
			message.setJsrdm(orgUser.getUserid());		//接收人代码
			message.setCksj("");						//查看时间
			message.setXxnr("已处理线索["+id+"]请于30日内反馈");	//消息内容
			message.setXxlb("2");								//消息类别
			message.setJsrssdw(organization.getOrgname());		//接收人所属单位
			message.setJsrssdwdm(organization.getOrgcode());	//接收人所属单位代码
			message.setXxbt("举报线索30日反馈");		//信息标题
			message.setDkfs("2");					//打开方式
			sysMessageDao.saveMessage(message);
			i++;
		}
		return i;
	}
	
	public static void rmdb_30d(String xsid){
		SysMessageDao sysMessageDao = AC.getBean(SysMessageDao.class);
		String ywurl = "/xsjbxxb/openFC?id="+xsid;
		sysMessageDao.updateYjjb(ywurl);
	}
	/**
	 * 递转审批待办
	 * @param id
	 * @param slfzdm
	 * @return
	 */
	public static int db_dzsp(Xszcspb entity){
		OrgOrganizationDao orgOrganizationDao = AC.getBean(OrgOrganizationDao.class);
		CommonDao commonDao = AC.getBean(CommonDao.class);
		SysMessageDao sysMessageDao = AC.getBean(SysMessageDao.class);
		
		OrgOrganization organization = orgOrganizationDao.queryByOrgcode(entity.getSpdw());
		OrgOrganization sqdw = orgOrganizationDao.queryByOrgcode(entity.getSqdw());
		List<OrgUser> list = commonDao.queryOrgUserByOrgCode(organization.getOrgcode(),R_SPRY);	//有奖举报审批人员
		int i = 0;
		for (OrgUser orgUser : list) {
			SysMessage message = new SysMessage();
			message.setYwurl("/xszcspb/approval?id="+entity.getId()+"&sqbh="+entity.getSqbh()+"&xsbh="+entity.getXsbh()+"&mainTabID=0");		//业务URL
			message.setFsr(entity.getXt_lrrxm());					//发送人
			message.setFsrdm(entity.getXt_lrrid());					//发送人代码
			message.setFssj(DateUtils.getSystemDateTimeString());	//发送时间
			message.setFsrssdw(entity.getXt_lrrbm());	//发送人所属单位
			message.setFsrssdwdm(entity.getXt_lrrbmid());	//发送人所属单位代码
			message.setDxzt("");						//短信状态
			message.setSfck("0");						//是否查看
			message.setJsr(orgUser.getUsername());		//接收人
			message.setJsrdm(orgUser.getUserid());		//接收人代码
			message.setCksj("");						//查看时间
			message.setXxnr("【举报奖励提醒】，【"+sqdw.getOrgname()+"】的线索申请【递转】，申请编号为【"+entity.getSqbh()+"】，请上级审批");	//消息内容
			message.setXxlb("2");								//消息类别
			message.setJsrssdw(organization.getOrgname());		//接收人所属单位
			message.setJsrssdwdm(organization.getOrgcode());	//接收人所属单位代码
			message.setXxbt("线索递转审批");		//信息标题
			message.setDkfs("2");					//打开方式
			sysMessageDao.saveMessage(message);
			i++;
		}
		return i;
	}
	
	public static void rmdb_dzsp(String dzsid){
		SysMessageDao sysMessageDao = AC.getBean(SysMessageDao.class);
		String ywurl = "/xszcspb/approval?id="+dzsid;
		sysMessageDao.updateYjjb(ywurl);
	}
	
	/**
	 * 奖励审批待办
	 * @param id
	 * @param slfzdm
	 * @return
	 */
	public static int db_jlsp(Jbjlspb entity){
		OrgOrganizationDao orgOrganizationDao = AC.getBean(OrgOrganizationDao.class);
		CommonDao commonDao = AC.getBean(CommonDao.class);
		SysMessageDao sysMessageDao = AC.getBean(SysMessageDao.class);
		
		OrgOrganization organization = orgOrganizationDao.queryByOrgcode(entity.getSpdw());
		OrgOrganization sqdw = orgOrganizationDao.queryByOrgcode(entity.getSqdw());
		List<OrgUser> list = commonDao.queryOrgUserByOrgCode(organization.getOrgcode(),R_SPRY);	//有奖举报审批人员
		int i = 0;
		for (OrgUser orgUser : list) {
			SysMessage message = new SysMessage();
			message.setYwurl("/jbjlspb/openAdd?id="+entity.getId()+"&mainTabID=0");		//业务URL
			message.setFsr(entity.getXt_lrrxm());					//发送人
			message.setFsrdm(entity.getXt_lrrid());					//发送人代码
			message.setFssj(DateUtils.getSystemDateTimeString());	//发送时间
			message.setFsrssdw(entity.getXt_lrrbm());	//发送人所属单位
			message.setFsrssdwdm(entity.getXt_lrrbmid());	//发送人所属单位代码
			message.setDxzt("");						//短信状态
			message.setSfck("0");						//是否查看
			message.setJsr(orgUser.getUsername());		//接收人
			message.setJsrdm(orgUser.getUserid());		//接收人代码
			message.setCksj("");						//查看时间
			message.setXxnr("【举报奖励提醒】，【"+sqdw.getOrgname()+"】的线索申请【奖励】，申请编号为【"+entity.getSqbh()+"】，请上级审批");	//消息内容
			message.setXxlb("2");								//消息类别
			message.setJsrssdw(organization.getOrgname());		//接收人所属单位
			message.setJsrssdwdm(organization.getOrgcode());	//接收人所属单位代码
			message.setXxbt("线索奖励审批");		//信息标题
			message.setDkfs("2");					//打开方式
			sysMessageDao.saveMessage(message);
			i++;
		}
		return i;
	}
	/**
	 * 
	 * @Title: rmdb_jlsp
	 * @Description: 奖励申请删除message
	 * @param @param jlsid    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public static void rmdb_jlsp(String jlsid){
		SysMessageDao sysMessageDao = AC.getBean(SysMessageDao.class);
		String ywurl = "/jbjlspb/openAdd?id="+jlsid;
		sysMessageDao.updateYjjb(ywurl);
	}
	/**
	 * 线索征集审批待办
	 * @param id
	 * @param slfzdm
	 * @return
	 */
	public static int db_xszjsp(Xszjspb entity){
		OrgOrganizationDao orgOrganizationDao = AC.getBean(OrgOrganizationDao.class);
		CommonDao commonDao = AC.getBean(CommonDao.class);
		SysMessageDao sysMessageDao = AC.getBean(SysMessageDao.class);
		
		OrgOrganization organization = orgOrganizationDao.queryByOrgcode(entity.getSpdw());
		OrgOrganization sqdw = orgOrganizationDao.queryByOrgcode(entity.getSqdw());
		List<OrgUser> list = commonDao.queryOrgUserByOrgCode(organization.getOrgcode(),R_SPRY);	//有奖举报审批人员
		int i = 0;
		for (OrgUser orgUser : list) {
			SysMessage message = new SysMessage();
			message.setYwurl("/xszjspb/openAdd?id="+entity.getId()+"&mainTabID=0");		//业务URL
			message.setFsr(entity.getXt_lrrxm());					//发送人
			message.setFsrdm(entity.getXt_lrrid());					//发送人代码
			message.setFssj(DateUtils.getSystemDateTimeString());	//发送时间
			message.setFsrssdw(entity.getXt_lrrbm());	//发送人所属单位
			message.setFsrssdwdm(entity.getXt_lrrbmid());	//发送人所属单位代码
			message.setDxzt("");						//短信状态
			message.setSfck("0");						//是否查看
			message.setJsr(orgUser.getUsername());		//接收人
			message.setJsrdm(orgUser.getUserid());		//接收人代码
			message.setCksj("");						//查看时间
			message.setXxnr("【举报奖励提醒】，【"+sqdw.getOrgname()+"】申请【线索征集】，申请编号为【"+entity.getSqbh()+"】，请上级审批");	//消息内容
			message.setXxlb("2");								//消息类别
			message.setJsrssdw(organization.getOrgname());		//接收人所属单位
			message.setJsrssdwdm(organization.getOrgcode());	//接收人所属单位代码
			message.setXxbt("线索征集审批");		//信息标题
			message.setDkfs("2");					//打开方式
			sysMessageDao.saveMessage(message);
			i++;
		}
		return i;
	}
	/**
	 * 
	 * @Title: rmdb_xszjsp
	 * @Description: 奖励申请删除message
	 * @param @param jlsid    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public static void rmdb_xszjsp(String zjsid){
		SysMessageDao sysMessageDao = AC.getBean(SysMessageDao.class);
		String ywurl = "/xszjspb/openAdd?id="+zjsid;
		sysMessageDao.updateYjjb(ywurl);
	}
	
	/**
	 * 
	 * @Title: rmdb_xszjsp
	 * @Description: 删除全部CCmessage
	 * @param @param jlsid    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public static void rmdb_allCc(){
		SysMessageDao sysMessageDao = AC.getBean(SysMessageDao.class);
		String ywurl = "/xsjbxxb/openCC";
		sysMessageDao.updateYjjb(ywurl);
	}
	
	/**
	 * 
	 * @Title: rmdb_xszjsp
	 * @Description: 删除当前xsbhCCmessage
	 * @param @param jlsid    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public static void rmdb_xsbhCc(String xsbh){
		SysMessageDao sysMessageDao = AC.getBean(SysMessageDao.class);
		String ywurl = "/xsjbxxb/openCC?id="+xsbh;
		sysMessageDao.updateYjjb(ywurl);
	}
	
	/**
	 * 
	 * @Title: rmdb_xszjsp
	 * @Description: 删除全部FCmessage
	 * @param @param jlsid    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public static void rmdb_allFc(){
		SysMessageDao sysMessageDao = AC.getBean(SysMessageDao.class);
		String ywurl = "/xsjbxxb/openFC";
		sysMessageDao.updateYjjb(ywurl);
	}
	
	/**
	 * 
	 * @Title: rmdb_xszjsp
	 * @Description: 删除当前xsbhFCmessage
	 * @param @param jlsid    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public static void rmdb_xsbhFc(String xsbh){
		SysMessageDao sysMessageDao = AC.getBean(SysMessageDao.class);
		String ywurl = "/xsjbxxb/openFC?id="+xsbh;
		sysMessageDao.updateYjjb(ywurl);
	}
}
