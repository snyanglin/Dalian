package com.founder.zdry.service.impl;

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
import com.founder.zdry.bean.ZdryJgdxqxjdjb;
import com.founder.zdry.bean.ZdryZdryzb;
import com.founder.zdry.dao.ZdryJgdxqxjdjbDao;
import com.founder.zdry.service.ZdryJgdxqxjdjbService;
import com.founder.zdry.service.ZdryZdryzbService;

/******************************************************************************
 * @Package: [com.founder.zdry.service.ZdryJgdxqxjdjbServiceImpl.java]
 * @ClassName: [ZdryJgdxqxjdjbServiceImpl]
 * @Description: [重点人员补充信息－监管对象请销假]
 * @Author: [hongguanjun]
 * @CreateDate: [2015-3-12 上午10:35:29]
 * @UpdateUser: [hongguanjun(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-3-12 上午10:35:29，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */

@Service("zdryJgdxqxjdjbService")
@Transactional
public class ZdryJgdxqxjdjbServiceImpl implements ZdryJgdxqxjdjbService {

	@Resource(name = "zdryJgdxqxjdjbDao")
	private ZdryJgdxqxjdjbDao zdryJgdxqxjdjbDao;

	@Resource(name = "zdryZdryzbService")
	private ZdryZdryzbService zdryZdryzbService;

	@Resource(name = "sysMessageDao")
	private SysMessageDao sysMessageDao;

	/**
	 * 查询列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	public EasyUIPage queryList(EasyUIPage page, ZdryJgdxqxjdjb entity) {
		return zdryJgdxqxjdjbDao.queryList(page, entity);
	}

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return ZdryJgdxqxjdjb 返回类型
	 * @throws
	 */
	public ZdryJgdxqxjdjb queryById(String id) {
		return zdryJgdxqxjdjbDao.queryById(id);
	}

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	public void save(ZdryJgdxqxjdjb entity, SessionBean sessionBean) {
		entity.setId(UUID.create()); // 生成主键
		BaseService.setSaveProperties(entity, sessionBean);
		zdryJgdxqxjdjbDao.save(entity, sessionBean);
		sendQjMessage(entity, sessionBean);
	}

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	public void update(ZdryJgdxqxjdjb entity, SessionBean sessionBean) {
		BaseService.setUpdateProperties(entity, sessionBean);
		zdryJgdxqxjdjbDao.update(entity, sessionBean);
		sendXjMessage(entity, sessionBean);
	}

	/**
	 * 更新审批<br>
	 * 
	 * @param entity
	 */
	public void updateSp(ZdryJgdxqxjdjb entity, SessionBean sessionBean) {
		entity.setSpr_xm(sessionBean.getUserName());
		entity.setSpr_id(sessionBean.getUserId());
		entity.setSpsj(DateUtils.getSystemDateTimeString());
		zdryJgdxqxjdjbDao.updateSp(entity, sessionBean);
		sendQjspMessage(entity, sessionBean);

		SysMessage sysMessage = new SysMessage();
		sysMessage.setId(entity.getMessageid());
		sysMessage.setCksj(DateUtils.getSystemDateTimeString());
		sysMessageDao.upadate(sysMessage); // 更新原来的审批消息
	}

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	public void delete(ZdryJgdxqxjdjb entity, SessionBean sessionBean) {
		BaseService.setCrossoutProperties(entity, sessionBean);
		zdryJgdxqxjdjbDao.delete(entity, sessionBean);
	}

	/**
	 * 删除批量<br>
	 * 
	 * @param entity
	 */
	public void deletePatch(ZdryJgdxqxjdjb[] entityArray,
			SessionBean sessionBean) {
		for (int i = 0; i < entityArray.length; i++) {
			BaseService.setCrossoutProperties(entityArray[i], sessionBean);
			zdryJgdxqxjdjbDao.delete(entityArray[i], sessionBean);
		}
	}

	/**
	 * @Title: sendMessage
	 * @Description: TODO(发送监管对象请假申请（所长）)
	 * @param @param entity
	 * @param @param sessionBean 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void sendQjMessage(ZdryJgdxqxjdjb entity, SessionBean sessionBean) {
		if (entity != null) {
			ZdryZdryzb zdryZdryzb = zdryZdryzbService.queryById(entity
					.getZdryid());
			if (zdryZdryzb != null) {
				SysMessage sysMessage = new SysMessage();
				sysMessage.setXxlb("5");
				sysMessage.setFsr(sessionBean.getUserName());
				sysMessage.setFsrdm(sessionBean.getUserId());
				sysMessage.setFssj(DateUtils.getSystemDateTimeString());
				sysMessage.setFsrssdw(sessionBean.getUserOrgName());
				sysMessage.setFsrssdwdm(sessionBean.getUserOrgCode());
				sysMessage.setDxzt("0");
				sysMessage.setJslx("0"); // 默认接收类型为人员
				String ywurl = "/zdryJgdxqxjdjb/sp?id=" + entity.getId();
				sysMessage.setYwurl(ywurl);
				sysMessage.setXxbt("监管对象请假申请");
				StringBuffer xxnr = new StringBuffer();
				xxnr.append("监管对象");
				xxnr.append(zdryZdryzb.getXm());
				xxnr.append("请假申请，请申批。");
				sysMessage.setXxnr(xxnr.toString());
				sysMessageDao.saveMessageByOrgAndPos(sysMessage,
						sessionBean.getExtendValue("ssPcsCode"), "SZ");
			}
		}
	}

	/**
	 * @Title: sendMessage
	 * @Description: TODO(发送审批结果消息（民警）)
	 * @param @param entity
	 * @param @param sessionBean 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void sendQjspMessage(ZdryJgdxqxjdjb entity, SessionBean sessionBean) {
		if (entity != null) {
			ZdryZdryzb zdryZdryzb = zdryZdryzbService.queryById(entity
					.getZdryid());
			if (zdryZdryzb != null) {
				SysMessage sysMessageOld = new SysMessage();
				sysMessageOld.setId(entity.getMessageid());
				sysMessageOld = sysMessageDao.query(sysMessageOld); // 查询原消息（取得原发送人为接收者）
				if (sysMessageOld != null) {
					SysMessage sysMessage = new SysMessage();
					sysMessage.setXxlb("1");
					sysMessage.setFsr(sessionBean.getUserName());
					sysMessage.setFsrdm(sessionBean.getUserId());
					sysMessage.setFssj(DateUtils.getSystemDateTimeString());
					sysMessage.setFsrssdw(sessionBean.getUserOrgName());
					sysMessage.setFsrssdwdm(sessionBean.getUserOrgCode());
					sysMessage.setDxzt("0");
					sysMessage.setJslx("0"); // 默认接收类型为人员
					String ywurl = "";
					sysMessage.setYwurl(ywurl);
					sysMessage.setXxbt("监管对象请假审批结果");
					StringBuffer xxnr = new StringBuffer();
					xxnr.append("监管对象");
					xxnr.append(zdryZdryzb.getXm());

					if ("1".equals(entity.getSpjg())) {
						xxnr.append("请假审批已通过。");
					} else {
						xxnr.append("请假申请未通过。");
					}
					sysMessage.setXxnr(xxnr.toString());
					sysMessage.setJsr(sysMessageOld.getFsr());
					sysMessage.setJsrdm(sysMessageOld.getFsrdm());
					sysMessage.setJsrssdw(sysMessageOld.getFsrssdw());
					sysMessage.setJsrssdwdm(sysMessageOld.getFsrssdwdm());
					sysMessageDao.saveMessage(sysMessage);
				}
			}
		}
	}

	/**
	 * @Title: sendMessage
	 * @Description: TODO(发送监管对象销假消息（所长）)
	 * @param @param entity
	 * @param @param sessionBean 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void sendXjMessage(ZdryJgdxqxjdjb entity, SessionBean sessionBean) {
		if (entity != null) {
			ZdryZdryzb zdryZdryzb = zdryZdryzbService.queryById(entity
					.getZdryid());
			if (zdryZdryzb != null) {
				SysMessage sysMessage = new SysMessage();
				sysMessage.setXxlb("1");
				sysMessage.setFsr(sessionBean.getUserName());
				sysMessage.setFsrdm(sessionBean.getUserId());
				sysMessage.setFssj(DateUtils.getSystemDateTimeString());
				sysMessage.setFsrssdw(sessionBean.getUserOrgName());
				sysMessage.setFsrssdwdm(sessionBean.getUserOrgCode());
				sysMessage.setDxzt("0");
				sysMessage.setJslx("0"); // 默认接收类型为人员
				String ywurl = "";
				sysMessage.setYwurl(ywurl);
				sysMessage.setXxbt("监管对象销假情况");
				StringBuffer xxnr = new StringBuffer();
				xxnr.append("监管对象");
				xxnr.append(zdryZdryzb.getXm());
				xxnr.append("请假已返回。");
				sysMessage.setXxnr(xxnr.toString());
				sysMessageDao.saveMessageByOrgAndPos(sysMessage,
						sessionBean.getExtendValue("ssPcsCode"), "SZ");
			}
		}
	}

}
