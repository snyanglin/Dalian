package com.founder.ywxt.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.message.dao.SysMessageDao;
import com.founder.framework.organization.assign.service.OrgAssignPublic;
import com.founder.framework.organization.assign.vo.OrgUserInfo;
import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.utils.DateUtils;
import com.founder.ywxt.bean.YwxtYwxtCdxxb;
import com.founder.ywxt.bean.Ywxtcyryxxb;
import com.founder.ywxt.dao.YwxtStoreDao;
import com.founder.ywxt.dao.YwxtYwxtCdxxbDao;
import com.founder.ywxt.dao.YwxtcyryxxbDao;

/***
 * ****************************************************************************
 * 
 * @Package: [cn.mos.ywxt.service.AbstractXtTask.java]
 * @ClassName: [AbstractXtTask]
 * @Description: [工厂接口的抽象类，抽象一些通用的方法]
 * @Author: [wu_chunhui@founder.com.cn]
 * @CreateDate: [2015-6-1 下午4:47:32]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-6-1 下午4:47:32，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
public abstract class AbstractXtTask implements XtTaskService {
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;
	@Resource
	private SysMessageDao sysMessageDao;
	protected final int APPROVALLEVEL = 2;
	@Resource(name = "ywxtcyryxxbDao")
	private YwxtcyryxxbDao ywxtcyryxxbDao;
	@Resource(name = "ywxtYwxtCdxxbDao")
	private YwxtYwxtCdxxbDao ywxtYwxtCdxxbDao;
	@Resource(name = "ywxtStoreDao")
	private YwxtStoreDao ywxtStoreDao;
	
	public static final String RIGHT = "1";
	public static final String ERROR = "0";

	@Override
	public void sendMessage(String messageContent, String xxbt,
			Ywxtcyryxxb fqrxxb, String url, String orgCode) {
		SysMessage message = new SysMessage();
		message.setXxnr(messageContent);
		message.setXxbt(xxbt);
		message.setXxlb("5");
		message.setYwurl(url);
		message.setFsr(fqrxxb.getCyrxm());
		message.setFsrdm(fqrxxb.getCyrid());
		message.setFssj(DateUtils.getSystemDateTimeString());
		message.setFsrssdw(orgOrganizationService.queryOrgNameByOrgcodes(fqrxxb
				.getSszrq()));
		message.setFsrssdwdm(fqrxxb.getSszrq());
		sysMessageDao.saveMessageByOrg(message, orgCode,false,false);
	}

	
	@Override
	public void updateXtjgByCyr(Map<String, Object> map, int approvalLevel,
			SessionBean sessionBean,String xtType) throws BussinessException {
		//处理信息为已查看
		String messageid =(String)map.get("messageid");
		SysMessage sysmessage = new SysMessage();
		try{
			sysmessage.setId(Long.valueOf(messageid));
			sysMessageDao.upadate(sysmessage);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		String xtjg = (String)map.get("xtjg");
		
		// 这里解析协同结果，断言转换成每个成员的结果，多选折时，前台直接传递正确选项，不用转换
		List<Ywxtcyryxxb> list = ywxtcyryxxbDao.queryByXtid((String)map.get("xtId"));
		// 这里适用大连情况，取得发起和接收人
		Ywxtcyryxxb fqCyr = null;
		Ywxtcyryxxb jsCyr = null;
		for (int i = 0; i < list.size(); i++) {
			Ywxtcyryxxb ywxtcyryxxb = list.get(i);
			if ("发起".equals(ywxtcyryxxb.getXtdz())) {
				fqCyr = ywxtcyryxxb;
			} else if ("接收".equals(ywxtcyryxxb.getXtdz())) {
				jsCyr = ywxtcyryxxb;
			}
		}
		
		//维护接收方信息，判断条件：（不是领导裁定） 且 （当前登录人不是发起人） 且 （接收人信息为空）
		if(sessionBean != null && approvalLevel<APPROVALLEVEL && !fqCyr.getCyrid().equals(sessionBean.getUserId()) && StringUtils.isBlank(jsCyr.getCyrid()) ){
			//有些情况下，参与人员可能为空
			//如：实有人口注销协同
			//因为发协同的时候，不知道谁能接收协同任务
			//所以，如果发现参与人为空的情况，人工补充一下
			jsCyr.setCyrid(sessionBean.getUserId());
			jsCyr.setCyrxm(sessionBean.getUserName());
		}
		
		if ("0".equals(xtjg)&&approvalLevel<APPROVALLEVEL) {//如果当前等级小于配置等级,找寻共同上级,进行裁定
			sysmessage=sysMessageDao.query(sysmessage);
			String url="/ywxt/creatRyxt?xtId="+(String)map.get("xtId")+"&approvalLevel="+(approvalLevel+1)+"&xtType="+xtType;
			sysmessage.setXxnr(sysmessage.getXxnr()+","+jsCyr.getCyrxm()+"不同意修改协同任务，请裁定");
			sysmessage.setXxlb("5");
			sysmessage.setYwurl(url);
			sysmessage.setFsr(jsCyr.getCyrxm());
			sysmessage.setFsrdm(jsCyr.getCyrid());
			sysmessage.setFssj(DateUtils.getSystemDateTimeString());
			sysmessage.setFsrssdw(orgOrganizationService.queryOrgNameByOrgcodes(jsCyr
					.getSszrq()));
			sysmessage.setFsrssdwdm(jsCyr.getSszrq());
			OrgOrganization orgOrganization=orgOrganizationService.querySameParentOrgWithOrgbiztype(fqCyr.getSszrq(), jsCyr.getSszrq(),"04");
			if(orgOrganization==null){
				throw new BussinessException("系统未设置上级治安条线部门,无法提交裁定,请与系统管理员联系");
			}
			//如果是派出所发送到SZ如果是责任区发送到上级SZ
			if("50".equals(orgOrganization.getOrglevel())){//责任区也发送到所长
				orgOrganization=orgOrganizationService.queryParentOrgById(orgOrganization.getId());
			}
		     if("32".equals(orgOrganization.getOrglevel())){
				OrgAssignPublic orgAssignPublic = new OrgAssignPublic();
				List<OrgUserInfo> orgList = orgAssignPublic.queryUserByOrgAndPos(orgOrganization.getOrgcode(),"SZ");
				if(orgList == null || orgList.isEmpty()){
					throw new BussinessException("没有配置所长，无法找到审批人！");
				}
				sysMessageDao.saveMessageByOrgAndPos(sysmessage, orgOrganization.getOrgcode(), "SZ"); 
			} else{
				sysMessageDao.saveMessageByOrg(sysmessage, orgOrganization.getOrgcode(), false, false);
			}
		}

		//维护协同裁定结果
		if ("1".equals(xtjg)) {
			//同意修改 或 发起方正确
			fqCyr.setXtjg(RIGHT);
			jsCyr.setXtjg(ERROR);
		}else if("0".equals(xtjg)){
			//拒绝修改 或 接收方正确
			fqCyr.setXtjg(ERROR);
			jsCyr.setXtjg(RIGHT);
		}else if("2".equals(xtjg)){
			//领导裁定：都正确
			fqCyr.setXtjg(RIGHT);
			jsCyr.setXtjg(RIGHT);
		}else if("4".equals(xtjg)){
			//领导裁定：都错误
			fqCyr.setXtjg(ERROR);
			jsCyr.setXtjg(ERROR);
		}
		
		//BaseService.setUpdateProperties(fqCyr, sessionBean);
		fqCyr.setXt_zhxgsj(DateUtils.getSystemDateTimeString());
		ywxtcyryxxbDao.update(fqCyr);
		//BaseService.setUpdateProperties(jsCyr, sessionBean);
		jsCyr.setXt_zhxgsj(DateUtils.getSystemDateTimeString());
		ywxtcyryxxbDao.update(jsCyr);
	}
	
	@Override
	public void doBusinessOpration(String xtid, SessionBean sessionBean) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 回收协同业务数据
	 * @param approvalLevel
	 * @param xtjg
	 * @param xtId
	 */
	protected void receiveXtywxx(Map<String, Object> map, int approvalLevel,
			SessionBean sessionBean,String xtType){
		
		String xtjg = (String)map.get("xtjg");
		String xtId = (String)map.get("xtId");
		
		//如果不是领导拒绝，而是底层拒绝，那么证明不能清除协同数据
		if(approvalLevel < APPROVALLEVEL && xtjg.equals("0")){
			return;
		}
		
		List<Ywxtcyryxxb> list = ywxtcyryxxbDao.queryByXtid(xtId);
		if(list == null || list.isEmpty()){
			return;
		}
		
		//回收数据
		for( Ywxtcyryxxb xxb : list ){
			//维护最后的更新状态
			BaseService.setUpdateProperties(xxb, sessionBean);
			ywxtcyryxxbDao.update(xxb);
			
			//备份数据
			ywxtStoreDao.storeCyryxxb(xxb.getId());
			//删除原数据
			ywxtStoreDao.physicalDeleteCyryxxb(xxb.getId());
		}
		//备份数据
		ywxtStoreDao.storeYwxtxxb(xtId);
		//删除原数据
		ywxtStoreDao.physicalDeleteYwxtxxb(xtId);
		
		//如果是领导裁定，需要存储裁定信息
		if(approvalLevel == APPROVALLEVEL){
			String spjg = "";
			//维护协同裁定结果
			if ("1".equals(xtjg)) {
				//发起方正确
				spjg = "发起方正确";
			}else if("0".equals(xtjg)){
				//接收方正确
				spjg = "接收方正确";
			}else if("2".equals(xtjg)){
				//领导裁定：都正确
				spjg = "都正确";
			}else if("4".equals(xtjg)){
				//领导裁定：都错误
				spjg = "都错误";
			}
			
			YwxtYwxtCdxxb ywxtYwxtCdxxb = new YwxtYwxtCdxxb();
			ywxtYwxtCdxxb.setSpbmid(sessionBean.getUserOrgCode());
			ywxtYwxtCdxxb.setSpr(sessionBean.getUserName());
			ywxtYwxtCdxxb.setSprid(sessionBean.getUserId());
			ywxtYwxtCdxxb.setXtywid(xtId);
			ywxtYwxtCdxxb.setSpjg(spjg);
			BaseService.setSaveProperties(ywxtYwxtCdxxb, sessionBean);
			//BaseService.setUpdateProperties(ywxtYwxtCdxxb, sessionBean);
			ywxtYwxtCdxxbDao.save(ywxtYwxtCdxxb);
		}
		
	}
}
