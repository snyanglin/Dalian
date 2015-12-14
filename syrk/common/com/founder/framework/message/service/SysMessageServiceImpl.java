package com.founder.framework.message.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.message.dao.SysMessageDao;
import com.founder.framework.organization.assign.vo.OrgUserInfo;
import com.founder.framework.utils.EasyUIPage;

/**
 * @author Founder
 * 
 */
@Service("sysMessageService")
@TypeAnnotation("系统消息表")
@Transactional
@Resource(name = "sysMessageService")
public class SysMessageServiceImpl extends BaseService implements
		SysMessageService {

	@Resource(name = "sysMessageDao")
	private SysMessageDao sysMessageDao;


	/**
	 * 保存单条消息（消息中的所有属性值由外部传入）<br>
	 * 
	 * @param GzycXxb
	 *            消息表对象
	 * @return Long
	 */
	public Long saveMessage(SysMessage entity) {
		return sysMessageDao.saveMessage(entity);
	}

	/**
	 * 保存批量消息（SysMessage对象需要对xxnr,xxlb,ywurl,fsr,fsrdm,fssj,fsrssdw,fsrssdwdm,
	 * dxzt,xxbt赋值，但不填接收人相关信息，<br>
	 * userArray数组中传入“接收人”、“接收人代码”、“接收人所属单位”、“接收人所属单位代码”）<br>
	 * 
	 * @param entity
	 *            消息表对象
	 * @param userArray
	 *            用户对象数组
	 * @return Long[]
	 */
	public Long[] saveMessage(SysMessage entity, OrgUserInfo[] userArray) {
		return sysMessageDao.saveMessage(entity, userArray);
	}

	/**
	 * 根据用户帐号保存消息（SysMessage对象需要xxnr,xxlb,ywurl,fsr,fsrdm,fssj,fsrssdw,fsrssdwdm
	 * , dxzt,xxbt赋值，但不填接收人相关信息）<br>
	 * 
	 * @param entity
	 *            消息表对象
	 * @param userIDString
	 *            用户帐号（多个时用逗号分隔）
	 * @return Long[]
	 */
	public Long[] saveMessageByUser(SysMessage entity, String userIDString) {
		return sysMessageDao.saveMessageByUser(entity, userIDString);
	}

	/**
	 * 根据部门代码保存消息（SysMessage对象需要xxnr,xxlb,ywurl,fsr,fsrdm,fssj,fsrssdw,fsrssdwdm
	 * , dxzt,xxbt赋值，但不填接收人相关信息）<br>
	 * 
	 * @param entity
	 *            消息表对象
	 * @param orgCodeString
	 *            部门代码（多个时用逗号分隔）
	 * @param inculdeSubOrg
	 *            是否包含所有下级部门
	 * @param noRepeatUser
	 *            同一个用户是否出现重复（部门与工作组中有相同的人时，是否只出现一次该人员）
	 * @return Long[]
	 */
	public Long[] saveMessageByOrg(SysMessage entity, String orgCodeString,
			boolean inculdeSubOrg, boolean noRepeatUser) {
		return sysMessageDao.saveMessageByOrg(entity, orgCodeString,
				inculdeSubOrg, noRepeatUser);
	}

	/**
	 * 查询消息表消息
	 * 
	 * @return
	 */
	@MethodAnnotation(value = "查询", type = logType.query)
	public List searchMessage(Map map) {
		return sysMessageDao.searchMessage(map);
	}

	@Override
	public void update(SysMessage entity, SessionBean sessionBean) {
		// TODO Auto-generated method stub
		sysMessageDao.upadate(entity);
	}
	/**
	 * @Title: updateReply 
	 * @描述: 更新消息【回复】
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-3-14 下午4:21:25 
	 * @throws
	 */
	public void updateReply(SysMessage entity, SessionBean sessionBean) {
		//消息更新
		if("1".equals(entity.getHfbz())){
			entity.setJsrssdw(entity.getFsrssdw());
			entity.setJsrssdwdm(entity.getFsrssdwdm());
			entity.setXxnr(entity.getXxnr()+"\n【"+sessionBean.getUserOrgName()+"】回复："+entity.getHfnr());
		}else if("0".equals(entity.getHfbz())){
			entity.setJsrssdw((String)sessionBean.getExtendMap().get("ssPcsName"));
			entity.setJsrssdwdm((String)sessionBean.getExtendMap().get("ssPcsCode"));
			entity.setXxnr(entity.getXxnr()+"\n【"+sessionBean.getUserOrgName()+"】转发："+entity.getHfnr());
		}else if("2".equals(entity.getHfbz())){
			entity.setXxnr(entity.getXxnr()+"\n【"+sessionBean.getUserOrgName()+"】转发："+entity.getHfnr());
		}
		String ywurl[] = entity.getYwurl().split(",");
		entity.setYwurl(ywurl[0]+","+ywurl[1]+","+ywurl[2]+","+ywurl[3]+","+ywurl[4]+","+entity.getHfbz());
		entity.setSfck("0");
		sysMessageDao.updateReply(entity);
	}
	/**
	 * 取得上一条的ID<br>
	 * 
	 * @param whereSql
	 * @param ID
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 *             boolean
	 */
	@Override
	public Long getViewPrevID(SysMessage entity) throws SQLException, Exception {
		return sysMessageDao.getViewPrevID(entity);
	}

	/**
	 * 取得下一条的ID<br>
	 * 
	 * @param whereSql
	 * @param ID
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 *             boolean
	 */
	@Override
	public Long getViewNextID(SysMessage entity) throws SQLException, Exception {
		return sysMessageDao.getViewNextID(entity);
	}

	/**
	 * 查询消息分页List
	 * 
	 * @return
	 */
	@MethodAnnotation(value = "查询", type = logType.query)
	public EasyUIPage queryList(EasyUIPage page, Map map) {
		return sysMessageDao.queryList(page, map);
	};

	public SysMessage query(SysMessage entity) {
		return sysMessageDao.query(entity);
	}


	// 分县局名（责任区代码前6位加000000）、派出所名（责任区代码前8位加000000）、责任区名（责任区代码）
	public List<Map<String, Object>> quyerFxq(Map map) {
		List<Map<String, Object>> list = sysMessageDao.queryForList(
				"Message.quyerFxq", map);
		return list;
	}




	// begin
	public String saveMsg(SysMessage entity) {
		return sysMessageDao.saveMessages(entity);
	}

}
