/**********************************************************************   
 * <p>文件名：DwxyaqBayServiceImpl.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu_chunhui@founder.com.cn 
 * @date 2014-12-5 下午12:26:27 
 * @history
 * @department：研发部
 *
*/
package com.founder.sydw.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.message.dao.SysMessageDao;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.sydw.bean.DwjbxxbBay;
import com.founder.sydw.dao.DwxyaqxxbBayDao;
import com.founder.sydw.service.DwxyaqBayService;

/******************************************************************************
 * @Package:      [com.founder.sydw.service.impl.DwxyaqBayServiceImpl.java]  
 * @ClassName:    [DwxyaqBayServiceImpl]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2014-12-5 下午12:26:27]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2014-12-5 下午12:26:27，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Service("dwxyaqBayService")
@Transactional
public class DwxyaqBayServiceImpl extends BaseService implements
		DwxyaqBayService {
	@Resource(name = "dwxyaqxxbBaydao")
	private DwxyaqxxbBayDao dwxyaqxxbBaydao;
	
	@Resource(name = "sysMessageDao")
	private SysMessageDao sysMessageDao;
	
	@Override
	public DwjbxxbBay query(String id) {
		return dwxyaqxxbBaydao.queryEntityById(id);
	}
	
	@Override
	public DwjbxxbBay getBayxx(String zjhm) {
		return dwxyaqxxbBaydao.queryEntityByZjhm(zjhm);
	}
	
	
	@Override
	public void savemessage(DwjbxxbBay entity, SessionBean sessionBean) {
		/*
		 * message添加
		 */
		String xm = entity.getXm();
		SysMessage message = new SysMessage();
		message.setXxlb("5");
		message.setYwurl("/dwxyaqxxbBay/createZxPage?id="+entity.getId());
		message.setFsr(sessionBean.getUserName());
		message.setFsrdm(sessionBean.getUserId());
		message.setFsrssdw(sessionBean.getUserOrgName());
		message.setFsrssdwdm(sessionBean.getUserOrgCode());
		message.setFssj(DateUtils.getSystemDateTimeString());
		message.setXxbt("保安员注销通知");
		message.setDkfs("0");
		message.setXxnr("【"+xm+"】责令进行注销通知，请您尽快进行注销！");
		sysMessageDao.saveMessageByUser(message, sessionBean.getUserId());

	}

	@Override
	public void save(DwjbxxbBay entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity,sessionBean);
		dwxyaqxxbBaydao.saveEntity(entity);

	}

	@Override
	public void update(DwjbxxbBay entity, SessionBean sessionBean) {
		setUpdateProperties(entity,sessionBean);
		dwxyaqxxbBaydao.updateEntity(entity);

	}
	

	/**
	 *保安员
	 *time:2015-5-7 
	 *author：star
	 */
	@Override
	public EasyUIPage baryxxb_query_all(EasyUIPage page, String condition, String dwid) {
		return dwxyaqxxbBaydao.bary_query_all(page, condition, dwid);
	}
	@Override
	public long baryxxb_query_all_count(String condition, String dwid){
		return dwxyaqxxbBaydao.bary_query_all_count(condition, dwid);
	}

}
