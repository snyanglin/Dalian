package com.founder.zdrygl.base.message;

import java.util.Map;

import javax.annotation.Resource;

import com.founder.framework.exception.BussinessException;
import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.organization.user.bean.OrgUser;
import com.founder.framework.organization.user.service.OrgUserService;
import com.founder.zdrygl.base.model.ZdryZb;
import com.founder.zdrygl.core.inteface.SysMessageInfoService;
import com.founder.zdrygl.core.model.SysMessage;

public class SysMessageInfoServiceImpl implements SysMessageInfoService {
	
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;

	@Resource(name = "orgUserService")
	private OrgUserService orgUserService;
	
	@SuppressWarnings("unchecked")
	@Override
	public SysMessage initSysMessage(String xxlx, Object param) {
		if(param instanceof Map){
			Map<String,String> paraMap=(Map<String,String>) param;
			String fsrName=(String) paraMap.get("fsrName");//发送人姓名
			String fsrUserCode=(String) paraMap.get("fsrUserCode");//发送人代码					
			
			if(fsrName==null || fsrName.length()==0){
				throw new BussinessException("fsrName can not be null");
			}
			if(fsrUserCode==null || fsrUserCode.length()==0){
				throw new BussinessException("fsrUserCode can not be null");
			}
			
			//信息标题
			String xxbt=this.getXxbt(xxlx);
			//信息内容
			String xxnr =this.getXxInfo(xxlx,paraMap);
			
			
			SysMessage sysMessage=new SysMessage();
			sysMessage.setXxbt(xxbt);
			sysMessage.setXxnr(xxnr);
			sysMessage.setFsr(fsrName);//发送人的名字 
			sysMessage.setFsrdm(fsrUserCode);//发送人的code								
			//sysMessage.setJslx("");//0 按人  1 按部门
			
			return sysMessage;
		}else{
			throw new BussinessException("param object must be java.util.Map");
		}
		
	}
	
	
	
	
	/**
	 * 
	 * @Title: getXxbt
	 * @Description: TODO(根据类型获取消息标题)
	 * @param @param xxlx 消息类型，参考 MessageDict.java
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throw 
	 */
	public String getXxbt(String xxlx) {
		String xxbt = "";
		if (MessageDict.XXLX_LGSQ.equals(xxlx)) {
			xxbt = "重口人员列管申请";
		} else if (MessageDict.XXLX_LGSPJG.equals(xxlx)) {
			xxbt = "重点人员列管审批结果";

		} else if (MessageDict.XXLX_CGSQ.equals(xxlx)) {
			xxbt = "重点人员撤管申请";

		} else if (MessageDict.XXLX_CGSPJG.equals(xxlx)) {
			xxbt = "重点人员撤管审批结果";

		} else if (MessageDict.XXLX_ZDSQ.equals(xxlx)) {
			xxbt = "重点人员转递申请";

		} else if (MessageDict.XXLX_JSZD.equals(xxlx)) {
			xxbt = "重点人员转递接收";

		} else if (MessageDict.XXLX_BJSZD.equals(xxlx)) {
			xxbt = "重点人员拒绝接收转递";

		} else if (MessageDict.XXLX_ZD_SJCDJG.equals(xxlx)) {
			xxbt = "重点人员转递裁定";

		} else if (MessageDict.XXLX_ZLSQ.equals(xxlx)) {
			xxbt = "重点人员转类申请";

		} else if (MessageDict.XXLX_ZLSPJG.equals(xxlx)) {
			xxbt = "重点人员转类审批结果";

		}
		return xxbt;
	}

	/**
	 * 
	 * @Title: getXxInfo
	 * @Description: TODO(根据消息类型获取消息内容)
	 * @param @param xxlx 消息类型，参考 MessageDict.java
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throw
	 */
	private String getXxInfo(String xxlx,Map paraMap){
		String xxinfo = "";
		ZdryZb zdryZb =(ZdryZb) paraMap.get("zdryZb");
		if (MessageDict.XXLX_LGSQ.equals(xxlx)) {
			String fsrUserCode=(String) paraMap.get("fsrUserCode");
			String fsrOrgCode=(String) paraMap.get("fsrOrgCode");
			xxinfo = this.getLgsqXxnr(zdryZb.getXm(),zdryZb.getZdrygllxdm(),fsrUserCode,fsrOrgCode);
		} else if (MessageDict.XXLX_LGSPJG.equals(xxlx)) {
			xxinfo = "重点人员列管审批结果";

		} else if (MessageDict.XXLX_CGSQ.equals(xxlx)) {
			String fsrUserCode=(String) paraMap.get("fsrUserCode");
			String fsrOrgCode=(String) paraMap.get("fsrOrgCode");
			xxinfo = this.getCgsqXxnr(zdryZb.getXm(),zdryZb.getZdrygllxdm(),fsrUserCode,fsrOrgCode);

		} else if (MessageDict.XXLX_CGSPJG.equals(xxlx)) {
			xxinfo = "重点人员撤管审批结果";

		} else if (MessageDict.XXLX_ZDSQ.equals(xxlx)) {
			xxinfo = "重点人员转递申请";

		} else if (MessageDict.XXLX_JSZD.equals(xxlx)) {
			xxinfo = "重点人员转递接收";

		} else if (MessageDict.XXLX_BJSZD.equals(xxlx)) {
			xxinfo = "重点人员拒绝接收转递";

		} else if (MessageDict.XXLX_ZD_SJCDJG.equals(xxlx)) {
			xxinfo = "重点人员转递裁定";

		} else if (MessageDict.XXLX_ZLSQ.equals(xxlx)) {
			xxinfo = "重点人员转类申请";

		} else if (MessageDict.XXLX_ZLSPJG.equals(xxlx)) {
			xxinfo = "重点人员转类审批结果";

		}
		return xxinfo;
	}
	
	
	/**
	 * 
	 * @Title: getLgsqXxnr
	 * @Description: TODO(获取列管申请消息)
	 * @param @param zdryXm 重点人员姓名
	 * @param @param zdrylx 重点人员类型名称
	 * @param @param fsrUserCode 发送人用户代码
	 * @param @param fsrOrgCode 发送人机构代码
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throw
	 */
	public String getLgsqXxnr(String zdryXm, String zdrylx, String fsrUserCode, String fsrOrgCode) {
		OrgOrganization fsrOrg = orgOrganizationService.queryByOrgcode(fsrOrgCode);

		OrgUser fsr = orgUserService.queryByUserid(fsrUserCode);
		String xxnr = fsrOrg.getOrgname() + "民警" + fsr.getUsername() + "提交" + zdrylx + zdryXm + "的列管申请，请审批";

		return xxnr;
	}

	/**
	 * 
	 * @Title: getCgsqXxnr
	 * @Description: TODO(获取撤管申请信息)
	 * @param @param zdryXm 重点人员姓名
	 * @param @param zdrylx 重点人员类型名称
	 * @param @param fsrUserCode 发送人用户代码
	 * @param @param fsrOrgCode 发送人机构代码
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throw
	 */
	public String getCgsqXxnr(String zdryXm, String zdrylx, String fsrUserCode, String fsrOrgCode) {
		OrgOrganization fsrOrg = orgOrganizationService.queryByOrgcode(fsrOrgCode);

		OrgUser fsr = orgUserService.queryByUserid(fsrUserCode);
		String xxnr = fsrOrg.getOrgname() + "民警" + fsr.getUsername() + "提交" + zdrylx + zdryXm + "的撤管申请，请审批";

		return xxnr;
	}

	
	public String getLgspjgXxnr(String spjg, String zdryXm, String fsrCode, String fsrOrgCode) {
		OrgOrganization fsrOrg = orgOrganizationService.queryByOrgcode(fsrOrgCode);

		OrgUser fsr = orgUserService.queryByUserid(fsrCode);
		String xxnr="";
         // 同意
		if("1".equals("spjg")){
			 xxnr = fsrOrg.getOrgname() + fsr.getUsername() + "审批同意重点人员" + zdryXm + "的列管申请";

		}else{
			 xxnr = fsrOrg.getOrgname() + fsr.getUsername() + "审批拒绝重点人员" + zdryXm + "的列管申请";

		}

		return xxnr;
	}

	
	public String getCgspjgXxnr(String spjg, String zdryXm, String fsrCode, String fsrOrgCode) {
		OrgOrganization fsrOrg = orgOrganizationService.queryByOrgcode(fsrOrgCode);

		OrgUser fsr = orgUserService.queryByUserid(fsrCode);

		String xxnr="";
        // 同意
		if("1".equals("spjg")){
			 xxnr = fsrOrg.getOrgname() + fsr.getUsername() + "审批同意重点人员" + zdryXm + "的撤管申请";

		}else{
			 xxnr = fsrOrg.getOrgname() + fsr.getUsername() + "审批拒绝重点人员" + zdryXm + "的撤管申请";

		}

		return xxnr;
	}

	
	public String getZdsqXxnr(String zdryXm, String zdrylx, String fsrCode, String fsrOrgCode) {
		OrgOrganization fsrOrg = orgOrganizationService.queryByOrgcode(fsrOrgCode);

		OrgOrganization parentOrg = orgOrganizationService.queryParentOrgByOrgcode(fsrOrgCode);

		OrgUser fsr = orgUserService.queryByUserid(fsrCode);

		String xxnr = parentOrg.getOrgname() + "、" + fsrOrg.getOrgname() + "民警" + fsr.getUsername() + "将" + zdrylx
				+ zdryXm + "转递给你辖区，请接收";

		return xxnr;
	}

	
	public String getJszdXxnr(String zdryXm, String zdrylx, String fsrCode, String fsrOrgCode) {
		OrgOrganization fsrOrg = orgOrganizationService.queryByOrgcode(fsrOrgCode);

		OrgOrganization parentOrg = orgOrganizationService.queryParentOrgByOrgcode(fsrOrgCode);

		OrgUser fsr = orgUserService.queryByUserid(fsrCode);

		String xxnr = parentOrg.getOrgname() + "、" + fsrOrg.getOrgname() + "民警" + fsr.getUsername() + "已同意接收" + zdrylx
				+ zdryXm;

		return xxnr;
	}

	
	public String getBjszdXxnr(String zdryXm, String zdrylx, String fsrCode, String fsrOrgCode) {
		OrgOrganization fsrOrg = orgOrganizationService.queryByOrgcode(fsrOrgCode);

		OrgOrganization parentOrg = orgOrganizationService.queryParentOrgByOrgcode(fsrOrgCode);

		OrgUser fsr = orgUserService.queryByUserid(fsrCode);

		String xxnr = parentOrg.getOrgname() + "、" + fsrOrg.getOrgname() + "民警" + fsr.getUsername() + "拒绝" + zdrylx
				+ zdryXm + "转递请求,已发送给共同上级进行裁定";

		return xxnr;
	}


	
	public String getZdCdjgXxnr(String cdjg, String zdryXm, String zdrylx, String yPcsdm, String yZrqdm, String zdPcsdm,
			String zdZrqdm) {
		OrgOrganization yPcsOrg = orgOrganizationService.queryByOrgcode(yPcsdm);

		OrgOrganization yZrqOrg = orgOrganizationService.queryByOrgcode(yZrqdm);
		String xxnr="";
		//1 同意 
		//0 拒绝
		if("1".equals(cdjg)){
			xxnr="原辖区为"+yPcsOrg.getOrgname()+yZrqOrg.getOrgname()+"的"+zdrylx+zdryXm+"裁定为由原辖区继续管理";
			
		}else{
			OrgOrganization jsPcsOrg = orgOrganizationService.queryByOrgcode(zdPcsdm);

			OrgOrganization jsZrqOrg = orgOrganizationService.queryByOrgcode(zdZrqdm);
			xxnr="原辖区为"+yPcsOrg.getOrgname()+yZrqOrg.getOrgname()+"的"+zdrylx+zdryXm+"裁定为由接收辖区"+jsPcsOrg.getOrgname()+jsZrqOrg.getOrgname()+"管理";
		}
		return xxnr;
	}

	
	public String getZlsqXxnr(String zdryXm, String yZdrylx, String zlZdrylx, String fsrCode, String fsrOrgCode) {
		OrgOrganization fsrOrg = orgOrganizationService.queryByOrgcode(fsrOrgCode);

		OrgUser fsr = orgUserService.queryByUserid(fsrCode);
		String xxnr = fsrOrg.getOrgname() + "民警" + fsr.getUsername() + "提交将" +  zdryXm +"从"+yZdrylx+"转为"+zlZdrylx+"的转类申请，请审批";

		return xxnr;
	}

	
	public String getZlspjgXxnr(String spjg, String zdryXm, String yZdrylx, String zlZdrylx, String fsrCode,
			String fsrOrgCode) {
		OrgOrganization fsrOrg = orgOrganizationService.queryByOrgcode(fsrOrgCode);

		OrgUser fsr = orgUserService.queryByUserid(fsrCode);
		String xxnr="";
         // 同意
		if("1".equals("spjg")){
			 xxnr = fsrOrg.getOrgname() + fsr.getUsername() + "审批同意重点人员" +yZdrylx+ zdryXm + "转类为"+zlZdrylx;

		}else{
			 xxnr = fsrOrg.getOrgname() + fsr.getUsername() + "审批拒绝重点人员"  +yZdrylx+ zdryXm + "转类为"+zlZdrylx;

		}

		return xxnr;
	}

	
	public String getZdSjCdXxnr(String cdjg, String zdryXm, String zdrylx, String yPcsdm, String yZrqdm, String fsrCode,
			String fsrOrgCode) {
		OrgOrganization yPcsOrg = orgOrganizationService.queryByOrgcode(yPcsdm);

		OrgOrganization yZrqOrg = orgOrganizationService.queryByOrgcode(yZrqdm);

		OrgUser fsr = orgUserService.queryByUserid(fsrCode);

		OrgOrganization fsrOrg = orgOrganizationService.queryByOrgcode(fsrOrgCode);

		OrgOrganization parentOrg = orgOrganizationService.queryParentOrgByOrgcode(fsrOrgCode);

		String xxnr = yPcsOrg.getOrgname() + "、" + yZrqOrg.getOrgname() + "民警将" + zdrylx + zdryXm + "转递至"
				+ parentOrg.getOrgname() + fsrOrg.getOrgname() + ",该责任区民警" + fsr.getUsername() + "拒绝接收，请裁定";

		return xxnr;
	}

	

}
