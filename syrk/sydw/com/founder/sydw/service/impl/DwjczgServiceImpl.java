package com.founder.sydw.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.message.dao.SysMessageDao;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.UUID;
import com.founder.sydw.bean.Dwjcxxb;
import com.founder.sydw.bean.Dwlscftzs;
import com.founder.sydw.bean.Dwzdhzyhzgtzs;
import com.founder.sydw.bean.Dwzlzgtzs;
import com.founder.sydw.dao.DwjcxxbDao;
import com.founder.sydw.dao.DwjczgDao;
import com.founder.sydw.service.DwjczgService;
/**
 * ****************************************************************************
 * @Package:      [com.founder.sydw.service.impl.DwjczgServiceImpl.java]  
 * @ClassName:    [DwjczgServiceImpl]   
 * @Description:  单位检查整改
 * @Author:       [yu_guangli@founder.com.cn]  
 * @CreateDate:   [2015-6-24 下午3:01:18]   
 * @UpdateUser:   [yuguangli(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-24 下午3:01:18，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("dwjczgService")
@Transactional
public class DwjczgServiceImpl implements DwjczgService {
	
	@Resource(name = "dwjczgDao")
	private DwjczgDao dwjczgDao;
	
	@Resource(name = "dwjcxxbDao")
	private DwjcxxbDao dwjcxxbDao;
	
	@Resource(name = "sysMessageDao")
	private SysMessageDao sysMessageDao;

	@Override
	public void saveZlzgtzs(Dwzlzgtzs entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		BaseService.setSaveProperties(entity, sessionBean);
		dwjczgDao.saveZlzgtzs(entity, sessionBean);
		Dwjcxxb dwjcxxb = new Dwjcxxb();
		dwjcxxb.setId(entity.getJcid());
		dwjcxxb.setZt("50");//责令限期整改通知书已发送
		BaseService.setSaveProperties(dwjcxxb, sessionBean);
		dwjcxxbDao.update(dwjcxxb, sessionBean);
		String zgxzgrq = entity.getZgxzgrq();
		String hzyhzgrq = entity.getHzyhzgrq();
		String dwmc = entity.getDwmc();
		/*
		 * message添加
		 */
		SysMessage message = new SysMessage();
		message.setXxlb("5");
		message.setYwurl("/dwjcxxb/addXf?dwid="+entity.getDwid()+"&flag=checked");
		message.setFsr(sessionBean.getUserName());
		message.setFsrdm(sessionBean.getUserId());
		message.setFsrssdw(sessionBean.getUserOrgName());
		message.setFsrssdwdm(sessionBean.getUserOrgCode());
		message.setFssj(DateUtils.getSystemDateTimeString());
		message.setXxbt("单位消防检查");
		message.setDkfs("2");
		if(zgxzgrq.equals(hzyhzgrq)&&zgxzgrq!=""){
			message.setXxnr("【"+dwmc+"】责令限期整改通知，请您于"+zgxzgrq+"前检查！");
			sysMessageDao.saveMessageByUser(message, sessionBean.getUserId());
		}else if(!zgxzgrq.equals(hzyhzgrq)&&zgxzgrq!=""&&hzyhzgrq!=""){
			message.setXxnr("【"+dwmc+"】责令限期整改通知，请您于"+zgxzgrq+"前检查！");
			sysMessageDao.saveMessageByUser(message, sessionBean.getUserId());
			message.setXxnr("【"+dwmc+"】责令限期整改通知，请您于"+hzyhzgrq+"前检查！");
			sysMessageDao.saveMessageByUser(message, sessionBean.getUserId());
		}else if(zgxzgrq!=""){
			message.setXxnr("【"+dwmc+"】责令限期整改通知，请您于"+zgxzgrq+"前检查！");
			sysMessageDao.saveMessageByUser(message, sessionBean.getUserId());
		}else if(hzyhzgrq!=""){
			message.setXxnr("【"+dwmc+"】责令限期整改通知，请您于"+hzyhzgrq+"前检查！");
			sysMessageDao.saveMessageByUser(message, sessionBean.getUserId());
		}
	}

	@Override
	public Dwzlzgtzs queryZlzgtzs(Map<String, Object> param) {
		return dwjczgDao.queryZlzgtzs(param);
	}

	@Override
	public void saveLscftzs(Dwlscftzs entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		BaseService.setSaveProperties(entity, sessionBean);
		dwjczgDao.saveLscftzs(entity, sessionBean);
		Dwjcxxb dwjcxxb = new Dwjcxxb();
		dwjcxxb.setId(entity.getJcid());
		dwjcxxb.setZt("70");//临时查封通知书已发送
		BaseService.setSaveProperties(dwjcxxb, sessionBean);
		dwjcxxbDao.update(dwjcxxb, sessionBean);
		/*
		 * message添加
		 */
		String cf_jsrq = entity.getCf_jsrq();
		String dwmc = entity.getDwmc();
		SysMessage message = new SysMessage();
		message.setXxnr("【"+dwmc+"】临时查封通知，请您于"+cf_jsrq+"前检查！");
		message.setXxlb("5");
		message.setYwurl("/dwjcxxb/addXf?dwid="+entity.getDwid()+"&flag=checked");
		message.setFsr(sessionBean.getUserName());
		message.setFsrdm(sessionBean.getUserId());
		message.setFsrssdw(sessionBean.getUserOrgName());
		message.setFsrssdwdm(sessionBean.getUserOrgCode());
		message.setFssj(DateUtils.getSystemDateTimeString());
		message.setXxbt("单位消防检查");
		message.setDkfs("2");
		sysMessageDao.saveMessageByUser(message, sessionBean.getUserId());
	}

	@Override
	public Dwlscftzs queryLscftzs(Map<String, Object> param) {
		return dwjczgDao.queryLscftzs(param);
	}

	@Override
	public void saveZdhzyhzgtzs(Dwzdhzyhzgtzs entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		BaseService.setSaveProperties(entity, sessionBean);
		dwjczgDao.saveZdhzyhzgtzs(entity, sessionBean);
		Dwjcxxb dwjcxxb = new Dwjcxxb();
		dwjcxxb.setId(entity.getJcid());
		dwjcxxb.setZt("60");//重大火灾隐患整改通知书已发送
		BaseService.setSaveProperties(dwjcxxb, sessionBean);
		dwjcxxbDao.update(dwjcxxb, sessionBean);
		String dwmc = entity.getDwmc();
		/*
		 * message添加
		 */
		SysMessage message = new SysMessage();
		message.setXxnr("【"+dwmc+"】重大火灾隐患整改通知，请您按期检查！");
		message.setXxlb("5");
		message.setYwurl("/dwjcxxb/addXf?dwid="+entity.getDwid()+"&flag=checked");
		message.setFsr(sessionBean.getUserName());
		message.setFsrdm(sessionBean.getUserId());
		message.setFsrssdw(sessionBean.getUserOrgName());
		message.setFsrssdwdm(sessionBean.getUserOrgCode());
		message.setFssj(DateUtils.getSystemDateTimeString());
		message.setXxbt("单位消防检查");
		message.setDkfs("2");
		sysMessageDao.saveMessageByUser(message, sessionBean.getUserId());
	}

	@Override
	public Dwzdhzyhzgtzs queryZdhzyhzgtzs(Map<String, Object> param) {
		return dwjczgDao.queryZdhzyhzgtzs(param);
	}

	@Override
	public String queryXh(Map<String, Object> param) {
		return dwjczgDao.queryXh(param);
	}

}
