package com.founder.framework.message.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.organization.assign.vo.OrgUserInfo;
import com.founder.framework.utils.EasyUIPage;

@TypeAnnotation("系统消息表")
public interface SysMessageService {

	/**
	 * 保存单条消息（消息中的所有属性值由外部传入）<br>
	 * 
	 * @param GzycXxb
	 *            消息表对象
	 * @return Long
	 */
	public Long saveMessage(SysMessage entity);

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
	public Long[] saveMessage(SysMessage entity, OrgUserInfo[] userArray);

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
	public Long[] saveMessageByUser(SysMessage entity, String userIDString);

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
			boolean inculdeSubOrg, boolean noRepeatUser);

	/**
	 * 查询消息表消息
	 * 
	 * @return
	 */
	public List searchMessage(Map map);

	/**
	 * 修改消息表状态
	 * 
	 * @return
	 */
	public void update(SysMessage entity, SessionBean sessionBean);
	/**
	 * @Title: updateReply 
	 * @描述: 更新消息【回复】
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-3-14 下午4:20:12 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public void updateReply(SysMessage entity, SessionBean sessionBean);
	/**
	 * 查询消息分页List
	 * 
	 * @return
	 */
	public EasyUIPage queryList(EasyUIPage page, Map map);

	/**
	 * 查询单条<br>
	 * 
	 * @param entity
	 * @return
	 */
	public SysMessage query(SysMessage entity);

	/**
	 * 取得上一条的ID<br>
	 * 
	 * @param whereSql
	 * @param ID
	 * @return
	 * @throws SQLException
	 * @throws Exception boolean
	 */
	public Long getViewPrevID(SysMessage entity) throws SQLException, Exception;

	/**
	 * 取得下一条的ID<br>
	 * 
	 * @param whereSql
	 * @param ID
	 * @return
	 * @throws SQLException
	 * @throws Exception boolean
	 */
	public Long getViewNextID(SysMessage entity) throws SQLException, Exception;


	
	//begin
	public String saveMsg(SysMessage entity);
	
	
	
}
