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
import com.founder.sydw.bean.Dwjbxxb;
import com.founder.sydw.bean.Dwjcxxb;
import com.founder.sydw.bean.JFDwzlzgtzs;
import com.founder.sydw.bean.JfFcyjs;
import com.founder.sydw.dao.DwjcxxbDao;
import com.founder.sydw.dao.JfjczgDao;
import com.founder.sydw.service.DwjbxxbService;
import com.founder.sydw.service.JFjczgService;
/**
 * ****************************************************************************
 * @Package:      [com.founder.sydw.service.impl.JFjczgServiceImpl.java]  
 * @ClassName:    [JFjczgServiceImpl]   
 * @Description:  技防检查整改
 * @Author:       [xu_haibo@founder.com.cn]  
 * @CreateDate:   [2015-6-29 下午3:01:18]   
 * @UpdateUser:   [xuhaibo(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-29 下午3:01:18，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("jfjczgService")
@Transactional
public class JFjczgServiceImpl implements JFjczgService {
	
	@Resource(name = "jfjczgDao")
	private JfjczgDao jfjczgDao;
	
	@Resource(name = "dwjcxxbDao")
	private DwjcxxbDao dwjcxxbDao;
	
	@Resource(name = "sysMessageDao")
	private SysMessageDao sysMessageDao;
	
	//单位基本信息表service
	@Resource(name = "dwjbxxbService")
	private DwjbxxbService dwjbxxbService;

	@Override
	public void saveJfzlzgtzs(JFDwzlzgtzs entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		BaseService.setSaveProperties(entity, sessionBean);
		jfjczgDao.saveJFzlzgtzs(entity, sessionBean);
		Dwjcxxb dwjcxxb = new Dwjcxxb();
		dwjcxxb.setId(entity.getJcid());
		dwjcxxb.setZt("90");//责令限期整改通知书已发送
		BaseService.setSaveProperties(dwjcxxb, sessionBean);
		dwjcxxbDao.update(dwjcxxb, sessionBean);
		String gzrq = entity.getGzrq();
		String dwmc = "";
		Dwjbxxb dwjbxxb = new Dwjbxxb();
		dwjbxxb.setId(entity.getDwid());
		dwjbxxb = dwjbxxbService.query(dwjbxxb);
		if(dwjbxxb!=null){
			dwmc=dwjbxxb.getDwmc();
		}
		/*
		 * message添加
		 */
		SysMessage message = new SysMessage();
		message.setXxlb("5");
		message.setYwurl("/dwjcxxb/addJf?dwid="+entity.getDwid()+"&flag=checked&id=");
		message.setFsr(sessionBean.getUserName());
		message.setFsrdm(sessionBean.getUserId());
		message.setFsrssdw(sessionBean.getUserOrgName());
		message.setFsrssdwdm(sessionBean.getUserOrgCode());
		message.setFssj(DateUtils.getSystemDateTimeString());
		message.setXxbt("单位技防检查");
		message.setDkfs("2");
		if(gzrq!=""){
			message.setXxnr("【"+dwmc+"】责令限期整改通知，请您于"+gzrq+"前检查！");
			sysMessageDao.saveMessageByUser(message, sessionBean.getUserId());
		}
	}

	@Override
	public JFDwzlzgtzs queryJfzlzgtzs(Map<String, Object> param) {
		return jfjczgDao.queryJFzlzgtzs(param);
	}
	
	@Override
	public void saveJFfcyjs(JfFcyjs entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		BaseService.setSaveProperties(entity, sessionBean);
		jfjczgDao.saveJFfcyjs(entity, sessionBean);
		Dwjcxxb dwjcxxb = new Dwjcxxb();
		dwjcxxb.setId(entity.getJcid());
		dwjcxxb.setZt("120");//责令限期整改通知书已发送
		BaseService.setSaveProperties(dwjcxxb, sessionBean);
		dwjcxxbDao.update(dwjcxxb, sessionBean);

	}

	@Override
	public JfFcyjs queryJFfcyjs(Map<String, Object> param) {
		return jfjczgDao.queryJFfcyjs(param);
	}
}
