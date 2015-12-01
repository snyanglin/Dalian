package com.founder.framework.message.dao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.organization.assign.vo.OrgUserInfo;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.framework.utils.UUID;
import com.founder.ggfw.bean.Ywxtgzrwb;
import com.founder.ggfw.dao.YwxtgzrwbDao;

@Repository("sysMessageDao")
public class SysMessageDao extends BaseDaoImpl {

	private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "ywxtgzrwbDao")
	private YwxtgzrwbDao ywxtgzrwbDao;


	/**
	 * 保存单条消息（消息中的所有属性值由外部传入）<br>
	 * 
	 * @param GzycXxb
	 *            消息表对象
	 * @return Long 新增的消息表主键
	 */
	public Long saveMessage(SysMessage entity) {
		Long returnValue = new Long(0);
		if (entity != null) {
			entity.setId(getSequence("")); // 生成主键
			entity.setSfck("0");
			String xxnr = StringUtils.nullToStr(entity.getXxnr());
			if (xxnr.length() > 200) {
				entity.setXxnr(xxnr.substring(0, 200));
			}
			String ywurl = entity.getYwurl();
			if (!StringUtils.isBlank(ywurl)) {
				if (ywurl.indexOf("?") == -1) {
					ywurl = ywurl + "?messageid=" + entity.getId();
				} else {
					ywurl = ywurl + "&messageid=" + entity.getId();
				}
				entity.setYwurl(ywurl);
			}
			if (StringUtils.isBlank(entity.getJslx())) {
				entity.setJslx("0"); // 默认接收类型为人员
			}
			insert("Message.save", entity);
			returnValue = entity.getId();
		}
		return returnValue;
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
	 * @return Long[] 新增的消息表主键数组
	 */
	public Long[] saveMessage(SysMessage entity, OrgUserInfo[] userArray) {
		Long[] returnArray = null;
		if (entity != null && userArray != null) {
			returnArray = new Long[userArray.length];
			for (int i = 0; i < userArray.length; i++) {
				SysMessage saveEntity = new SysMessage();
				String xxnr = StringUtils.nullToStr(entity.getXxnr());
				if (xxnr.length() > 200) {
					saveEntity.setXxnr(xxnr.substring(0, 200));
				} else {
					saveEntity.setXxnr(xxnr);
				}
				saveEntity.setId(getSequence("")); // 生成主键
				saveEntity.setXxlb(entity.getXxlb());
				saveEntity.setFsr(entity.getFsr());
				saveEntity.setFsrdm(entity.getFsrdm());
				saveEntity.setFssj(entity.getFssj());
				saveEntity.setFsrssdw(entity.getFsrssdw());
				saveEntity.setFsrssdwdm(entity.getFsrssdwdm());
				saveEntity.setDxzt(entity.getDxzt());
				saveEntity.setJslx(entity.getJslx());
				if (StringUtils.isBlank(saveEntity.getJslx())) {
					saveEntity.setJslx("0"); // 默认接收类型为人员
				}
				saveEntity.setJsr(userArray[i].getUsername());
				saveEntity.setJsrdm(userArray[i].getUserid());
				saveEntity.setJsrssdw(userArray[i].getOrgcode());
				saveEntity.setJsrssdwdm(userArray[i].getOrgname());
				saveEntity.setSfck("0");
				saveEntity.setXxbt(entity.getXxbt());
				String ywurl = entity.getYwurl();
				if (!StringUtils.isBlank(ywurl)) {
					if (ywurl.indexOf("?") == -1) {
						ywurl = ywurl + "?messageid=" + saveEntity.getId();
					} else {
						ywurl = ywurl + "&messageid=" + saveEntity.getId();
					}
					saveEntity.setYwurl(ywurl);
				}
				insert("Message.save", saveEntity);
				returnArray[i] = saveEntity.getId();
			}
		}
		return returnArray;
	}

	/**
	 * 根据用户帐号保存消息（SysMessage对象需要xxnr,xxlb,ywurl,fsr,fsrdm,fssj,fsrssdw,fsrssdwdm
	 * , dxzt,xxbt赋值，但不填接收人相关信息）<br>
	 * 
	 * @param entity
	 *            消息表对象
	 * @param userIDString
	 *            用户帐号（多个时用逗号分隔）
	 * @return Long[] 新增的消息表主键数组
	 */
	public Long[] saveMessageByUser(SysMessage entity, String userIDString) {
		Long[] returnArray = null;
		if (entity != null && !StringUtils.isBlank(userIDString)) {
			List<OrgUserInfo> userList = this
					.queryOrgUserByUserIds(userIDString);
			if (userList != null && userList.size() > 0) {
				returnArray = new Long[userList.size()];
				for (int i = 0; i < userList.size(); i++) {
					OrgUserInfo userInfo = (OrgUserInfo) userList.get(i);
					SysMessage saveEntity = new SysMessage();
					String xxnr = StringUtils.nullToStr(entity.getXxnr());
					if (xxnr.length() > 200) {
						saveEntity.setXxnr(xxnr.substring(0, 200));
					} else {
						saveEntity.setXxnr(xxnr);
					}
					saveEntity.setId(getSequence("")); // 生成主键
					saveEntity.setXxlb(entity.getXxlb());
					saveEntity.setFsr(entity.getFsr());
					saveEntity.setFsrdm(entity.getFsrdm());
					saveEntity.setFssj(entity.getFssj());
					saveEntity.setFsrssdw(entity.getFsrssdw());
					saveEntity.setFsrssdwdm(entity.getFsrssdwdm());
					saveEntity.setDxzt(entity.getDxzt());
					saveEntity.setJslx(entity.getJslx());
					saveEntity.setJslx("0"); // 默认接收类型为人员
					saveEntity.setJsr(userInfo.getUsername());
					saveEntity.setJsrdm(userInfo.getUserid());
					saveEntity.setJsrssdw(userInfo.getOrgname());
					saveEntity.setJsrssdwdm(userInfo.getOrgcode());
					saveEntity.setSfck("0");
					saveEntity.setXxbt(entity.getXxbt());
					String ywurl = entity.getYwurl();
					if (!StringUtils.isBlank(ywurl)) {
						if (ywurl.indexOf("?") == -1) {
							ywurl = ywurl + "?messageid=" + saveEntity.getId();
						} else {
							ywurl = ywurl + "&messageid=" + saveEntity.getId();
						}
						saveEntity.setYwurl(ywurl);
					}
					insert("Message.save", saveEntity);
					returnArray[i] = saveEntity.getId();
				}
			}
		}

		return returnArray;
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
	 * @return Long[] 新增的消息表主键数组
	 */
	public Long[] saveMessageByOrg(SysMessage entity, String orgCodeString,
			boolean inculdeSubOrg, boolean noRepeatUser) {
		Long[] returnArray = new Long[2];
		if (entity != null && !StringUtils.isBlank(orgCodeString)) {
			String orgCodeCondition = "'"
					+ orgCodeString.replaceAll(",", "','") + "'";
			SysMessage sysMessage = new SysMessage();
			String xxnr = StringUtils.nullToStr(entity.getXxnr());
			if (xxnr.length() > 200) {
				sysMessage.setXxnr(xxnr.substring(0, 200));
			} else {
				sysMessage.setXxnr(xxnr);
			}
			sysMessage.setXxlb(entity.getXxlb());
			sysMessage.setFsr(entity.getFsr());
			sysMessage.setFsrdm(entity.getFsrdm());
			sysMessage.setFssj(entity.getFssj());
			sysMessage.setFsrssdw(entity.getFsrssdw());
			sysMessage.setFsrssdwdm(entity.getFsrssdwdm());
			sysMessage.setJslx("1"); // 接收类型为部门
			sysMessage.setDxzt(entity.getDxzt());
			sysMessage.setSfck("0");
			sysMessage.setXxbt(entity.getXxbt());
			sysMessage.setDkfs(entity.getDkfs());
			String ywurl = entity.getYwurl();
			if (!StringUtils.isBlank(ywurl)) {
				if (ywurl.indexOf("?") == -1) {
					ywurl = ywurl + "?messageid=";
				} else {
					ywurl = ywurl + "&messageid=";
				}
				sysMessage.setYwurl(ywurl);
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("sysMessage", sysMessage);
			map.put("orgCodeCondition", orgCodeCondition);
			if (inculdeSubOrg) {
				insert("Message.saveByOrgcodeIncludeChildren", map); // 强行去除重复
			} else {
				insert("Message.saveByOrgcode", map);
			}
			returnArray[0] = Long.parseLong("1");
		}

		/*JSONObject messageJson = new JSONObject();
		messageJson.element("type", "1");
		messageJson.element("entity", entity);

		Map coultMap = new HashMap();
		coultMap.put("sendType", "2");
		coultMap.put("sendCode", orgCodeString);
		coultMap.put("sendMsg", messageJson);
		coultMap.put("callback", "messageToke");
		SendWebSocket sendWebSocket = new SendWebSocket();
		sendWebSocket.shendMessage(coultMap);*/

		return returnArray;
	}

	/**
	 * 根据部门代码和岗位为条件保存消息，按接收人保存（SysMessage对象需要xxnr,xxlb,ywurl,fsr,fsrdm,fssj,
	 * fsrssdw ,fsrssdwdm , dxzt,xxbt赋值）<br>
	 * 
	 * @param entity
	 *            消息表对象
	 * @param orgCodeString
	 *            部门代码（多个时用逗号分隔）
	 * @param posIDString
	 *            虚拟岗位（ORG_POSITION.POSID，多个时用逗号分隔，为空时不用虚拟岗位过滤）
	 * @return Long[] 新增的消息表主键数组
	 */
	public Long[] saveMessageByOrgAndPos(SysMessage entity,
			String orgCodeString, String posIdString) {
		Long[] returnArray = null;
		if (entity != null && !StringUtils.isBlank(orgCodeString)) {
			String orgCodeCondition = "'"
					+ orgCodeString.replaceAll(",", "','") + "'";
			String posIdCondition = "";
			if (!StringUtils.isBlank(posIdString)) {
				posIdCondition = "'" + posIdString.replaceAll(",", "','") + "'";
			}
			SysMessage sysMessage = new SysMessage();
			String xxnr = StringUtils.nullToStr(entity.getXxnr());
			if (xxnr.length() > 200) {
				sysMessage.setXxnr(xxnr.substring(0, 200));
			} else {
				sysMessage.setXxnr(xxnr);
			}
			sysMessage.setXxlb(entity.getXxlb());
			sysMessage.setFsr(entity.getFsr());
			sysMessage.setFsrdm(entity.getFsrdm());
			sysMessage.setFssj(entity.getFssj());
			sysMessage.setFsrssdw(entity.getFsrssdw());
			sysMessage.setFsrssdwdm(entity.getFsrssdwdm());
			sysMessage.setDxzt(entity.getDxzt());
			sysMessage.setSfck("0");
			sysMessage.setXxbt(entity.getXxbt());
			sysMessage.setDkfs(entity.getDkfs());
			sysMessage.setJslx("0"); // 默认接收类型为人员
			String ywurl = entity.getYwurl();
			if (!StringUtils.isBlank(ywurl)) {
				if (ywurl.indexOf("?") == -1) {
					ywurl = ywurl + "?messageid=";
				} else {
					ywurl = ywurl + "&messageid=";
				}
				sysMessage.setYwurl(ywurl);
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("sysMessage", sysMessage);
			map.put("orgCodeCondition", orgCodeCondition);
			map.put("posIdCondition", posIdCondition);
			if (StringUtils.isBlank(posIdCondition)) {
				insert("Message.saveFromOrgUserByOrgcode", map);
			} else {
				insert("Message.saveMessageByOrgAndPos", map);
			}
		}
		return returnArray;
	}

	/**
	 * 根据部门代码为条件保存消息，按接收人保存（SysMessage对象需要xxnr,xxlb,ywurl,fsr,fsrdm,fssj,fsrssdw
	 * ,fsrssdwdm , dxzt,xxbt赋值，但不填接收人相关信息）<br>
	 * 
	 * @param entity
	 *            消息表对象
	 * @param orgCodeString
	 *            部门代码（多个时用逗号分隔）
	 * @param orgType
	 *            部门类型
	 * @param orgLevel
	 *            部门等级（多个时用逗号分隔）
	 * @param orgBizType
	 *            部门业务类型（多个时用逗号分隔）
	 * @param inculdeSubOrg
	 *            是否包含所有下级部门
	 * @param noRepeatUser
	 *            同一个用户是否出现重复（部门与工作组中有相同的人时，是否只出现一次该人员）
	 * @return Long[] 新增的消息表主键数组
	 */
	public Long[] saveMessageByOrgCondition(SysMessage entity,
			String orgCodeString, String orgType, String orgLevel,
			String orgBizType, boolean inculdeSubOrg, boolean noRepeatUser) {
		Long[] returnArray = null;
		if (entity != null && !StringUtils.isBlank(orgCodeString)) {
			String orgCodeCondition = "'"
					+ orgCodeString.replaceAll(",", "','") + "'";
			SysMessage sysMessage = new SysMessage();
			String xxnr = StringUtils.nullToStr(entity.getXxnr());
			if (xxnr.length() > 200) {
				sysMessage.setXxnr(xxnr.substring(0, 200));
			} else {
				sysMessage.setXxnr(xxnr);
			}
			sysMessage.setXxlb(entity.getXxlb());
			sysMessage.setFsr(entity.getFsr());
			sysMessage.setFsrdm(entity.getFsrdm());
			sysMessage.setFssj(entity.getFssj());
			sysMessage.setFsrssdw(entity.getFsrssdw());
			sysMessage.setFsrssdwdm(entity.getFsrssdwdm());
			sysMessage.setDxzt(entity.getDxzt());
			sysMessage.setSfck("0");
			sysMessage.setXxbt(entity.getXxbt());
			sysMessage.setDkfs(entity.getDkfs());
			sysMessage.setJslx("0"); // 默认接收类型为人员
			String ywurl = entity.getYwurl();
			if (!StringUtils.isBlank(ywurl)) {
				if (ywurl.indexOf("?") == -1) {
					ywurl = ywurl + "?messageid=";
				} else {
					ywurl = ywurl + "&messageid=";
				}
				sysMessage.setYwurl(ywurl);
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("sysMessage", sysMessage);
			map.put("orgCodeCondition", orgCodeCondition);
			String orgParameterCondition = "";
			if (!StringUtils.isBlank(orgType)) {
				orgParameterCondition = "a.ORGTYPE = '" + orgType + "'";
			}
			if (!StringUtils.isBlank(orgLevel)) {
				if (!StringUtils.isBlank(orgParameterCondition)) {
					orgParameterCondition += " and ";
				}
				orgParameterCondition = "a.ORGLEVEL in ('"
						+ orgLevel.replaceAll(",", "','") + "')";
			}
			if (!StringUtils.isBlank(orgBizType)) {
				if (!StringUtils.isBlank(orgParameterCondition)) {
					orgParameterCondition += " and ";
				}
				orgParameterCondition += "a.ORGBIZTYPE in ('"
						+ orgBizType.replaceAll(",", "','") + "')";
			}
			if (StringUtils.isBlank(orgParameterCondition)) {
				orgParameterCondition = "1=1";
			}
			map.put("orgParameterCondition", orgParameterCondition);
			if (inculdeSubOrg) {
				insert("Message.saveByOrgcodeAndConditionIncludeChildren", map); // 强行去除重复
			} else {
				insert("Message.saveByOrgcodeAndCondition", map);
			}
		}
		return returnArray;
	}

	/**
	 * 查询消息表消息
	 * 
	 * @return
	 */
	public List searchMessage(Map map) {
		return queryForList("Message.queryList", map);
	}

	/**
	 * 修改<br>
	 * 
	 * @param entity
	 */
	public void upadate(SysMessage entity) {
		update("Message.update", entity);
	}
	/**
	 * @Title: updateReply 
	 * @描述: 更新消息【回复】
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-3-14 下午4:25:22 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public void updateReply(SysMessage entity) {
		update("Message.updateReply", entity);
	}
	/**
	 * 修改<br>
	 * 
	 * @param entity
	 */
	public void updateYjjb(String ywurl) {
		SysMessage sysMessage = new SysMessage();
		sysMessage.setYwurl(ywurl);
		sysMessage.setCksj(DateUtils.getSystemDateTimeString());
		update("Message.updateYjjb", sysMessage);
	}

	/**
	 * 查询列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	public EasyUIPage queryList(EasyUIPage page, Map map) {
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "sfck,fssj ";
			order = "desc";
		}
		map.put("sort", sort);
		map.put("order", order);
		page.setTotal((Integer) queryForObject("Message.queryCount", map));
		page.setRows(queryForList("Message.queryMsgList", map));
		return page;
	}

	/**
	 * 查询单条<br>
	 * 
	 * @param entity
	 * @return
	 */
	public SysMessage query(SysMessage entity) {
		SysMessage returnValue = null;
		List<?> list = queryForList("Message.query", entity);
		if (list != null && list.size() > 0) {
			returnValue = (SysMessage) list.get(0);
		}
		return returnValue;
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
	public Long getViewPrevID(SysMessage entity) throws SQLException, Exception {
		Long returnValue = new Long(0);
		Map map = new HashMap();
		List list1 = queryForList("Message.getViewRowno", entity);
		if (list1 != null && list1.size() > 0) {
			Long rowNo = (Long) list1.get(0);
			map.put("rowno", rowNo - 1);
			map.put("jsrdm", entity.getJsrdm());
			map.put("jsrssdwdm", entity.getJsrssdwdm());
			if (rowNo.longValue() > 1) {
				List list2 = queryForList("Message.getViewNextID", map);
				if (list2 != null && list2.size() > 0) {
					returnValue = (Long) list2.get(0);
				}
			}
		}
		return returnValue;
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
	public Long getViewNextID(SysMessage entity) throws SQLException, Exception {
		Long returnValue = new Long(0);
		Map map = new HashMap();
		List list1 = queryForList("Message.getViewRowno", entity);
		if (list1 != null && list1.size() > 0) {
			Long rowNo = (Long) list1.get(0);
			map.put("rowno", rowNo + 1);
			map.put("jsrdm", entity.getJsrdm());
			map.put("jsrssdwdm", entity.getJsrssdwdm());
			List list2 = queryForList("Message.getViewNextID", map);
			if (list2 != null && list2.size() > 0) {
				returnValue = (Long) list2.get(0);
			}

		}
		return returnValue;
	}

	


	public Long queryJzdz(Map map) {
		return (Long) queryForObject("Message.queryJzdz", map);
	}

	public Long queryJzdzs(Map map) {
		return (Long) queryForObject("Message.queryJzdzs", map);
	}



	

	

	

	// 分县局名（责任区代码前6位加000000）、派出所名（责任区代码前8位加000000）、责任区名（责任区代码）
	public List<Map<String, Object>> quyerFxq(Map map) {
		List<Map<String, Object>> list = queryForList("Message.quyerFxq", map);
		return list;
	}


	public Long[] saveMessageNotToAdmin(SysMessage entity,
			String orgCodeString, boolean inculdeSubOrg, boolean noRepeatUser) {
		Long[] returnArray = null;
		if (entity != null && !StringUtils.isBlank(orgCodeString)) {
			List<OrgUserInfo> userList = this.queryOrgUser(orgCodeString,
					inculdeSubOrg, noRepeatUser);
			if (userList != null && userList.size() > 0) {
				returnArray = new Long[userList.size()];
				for (int i = 0; i < userList.size(); i++) {
					OrgUserInfo userInfo = (OrgUserInfo) userList.get(i);
					SysMessage saveEntity = new SysMessage();
					String xxnr = StringUtils.nullToStr(entity.getXxnr());
					if (xxnr.length() > 200) {
						saveEntity.setXxnr(xxnr.substring(0, 200));
					} else {
						saveEntity.setXxnr(xxnr);
					}
					saveEntity.setId(getSequence("")); // 生成主键
					saveEntity.setXxlb(entity.getXxlb());
					saveEntity.setFsr(entity.getFsr());
					saveEntity.setFsrdm(entity.getFsrdm());
					saveEntity.setFssj(entity.getFssj());
					saveEntity.setFsrssdw(entity.getFsrssdw());
					saveEntity.setFsrssdwdm(entity.getFsrssdwdm());
					saveEntity.setDxzt(entity.getDxzt());
					saveEntity.setJslx("0"); // 默认接收类型为人员
					saveEntity.setJsr(userInfo.getUsername());
					saveEntity.setJsrdm(userInfo.getUserid());
					saveEntity.setJsrssdw(userInfo.getOrgname());
					saveEntity.setJsrssdwdm(userInfo.getOrgcode());
					saveEntity.setSfck("0");
					saveEntity.setXxbt(entity.getXxbt());
					String ywurl = entity.getYwurl();
					if (!StringUtils.isBlank(ywurl)) {
						if (ywurl.indexOf("?") == -1) {
							ywurl = ywurl + "?messageid=" + saveEntity.getId();
						} else {
							ywurl = ywurl + "&messageid=" + saveEntity.getId();
						}
						saveEntity.setYwurl(ywurl);
					}
					insert("Message.save", saveEntity);
					returnArray[i] = saveEntity.getId();
				}
			} else {
				// 【系统消息提醒】经核实，【ＸＸＸ责任区】没有分配社区民警，请知晓！
				String xxnr = "【系统消息提醒】经核实，【" + orgCodeString
						+ "责任区】没有分配社区民警，请知晓！";
				entity.setXxnr(xxnr);
				saveMessageByUser(entity, orgCodeString);
				// saveMessageToAdmin(entity,orgCodeString,inculdeSubOrg,noRepeatUser);
			}
		}
		return returnArray;
	}

	public long saveMessageToAdmin(SysMessage entity, String orgCodeString,
			boolean inculdeSubOrg, boolean noRepeatUser) {
		long returnArray = 1;
		if (entity != null && !StringUtils.isBlank(orgCodeString)) {
			SysMessage saveEntity = new SysMessage();
			String xxnr = StringUtils.nullToStr(entity.getXxnr());
			if (xxnr.length() > 200) {
				saveEntity.setXxnr(xxnr.substring(0, 200));
			} else {
				saveEntity.setXxnr(xxnr);
			}
			saveEntity.setId(getSequence("")); // 生成主键
			saveEntity.setXxlb(entity.getXxlb());
			saveEntity.setFsr(entity.getFsr());
			saveEntity.setFsrdm(entity.getFsrdm());
			saveEntity.setFssj(entity.getFssj());
			saveEntity.setFsrssdw(entity.getFsrssdw());
			saveEntity.setFsrssdwdm(entity.getFsrssdwdm());
			saveEntity.setDxzt(entity.getDxzt());
			saveEntity.setJslx("0"); // 默认接收类型为人员
			saveEntity.setJsr(orgCodeString);
			saveEntity.setJsrdm(orgCodeString);
			saveEntity.setJsrssdw("");
			saveEntity.setJsrssdwdm("");
			saveEntity.setSfck("0");
			saveEntity.setXxbt(entity.getXxbt());
			String ywurl = entity.getYwurl();
			if (!StringUtils.isBlank(ywurl)) {
				if (ywurl.indexOf("?") == -1) {
					ywurl = ywurl + "?messageid=" + saveEntity.getId();
				} else {
					ywurl = ywurl + "&messageid=" + saveEntity.getId();
				}
				saveEntity.setYwurl(ywurl);
			}
			insert("Message.save", saveEntity);
			returnArray = saveEntity.getId();
		}
		return returnArray;
	}

	/**
	 * 联系电话变更提醒 (先注掉此方法 之前的sqlmap里的查询语句是老版实有人口  表已经对不上了)
	 * 
	 * @param map
	 *            (ryid:人员id, lxdh:联系电话, ywmc:业务名称)
	 * @param sessionBean
	 * @param check
	 *            是否排除当前用户责任区
	 * @return
	 */
	/*@SuppressWarnings("unchecked")
	public String lxdhBgTx(Map<String, Object> map, SessionBean sessionBean,
			boolean check) {
		String returnValue = "0";
		if (!StringUtils.isBlank(map.get("ryid"))
				&& !StringUtils.isBlank(map.get("lxdh"))) {
			try {
				if (sessionBean != null) {
					List<Map<String, Object>> list = queryForList(
							"Message.lxdhBgTx", map);
					SysMessage sysMsg = new SysMessage();
					sysMsg.setFsr(sessionBean.getUserName());
					sysMsg.setFsrdm(sessionBean.getUserId());
					sysMsg.setFsrssdw(sessionBean.getUserOrgName());
					sysMsg.setFsrssdwdm(sessionBean.getUserOrgCode());
					sysMsg.setFssj(DateUtils.getSystemDateTimeString());
					sysMsg.setSfck("0");
					sysMsg.setXxlb("2");
					sysMsg.setXxbt("联系方式变更");
					String xxnr = "";
					Map<String, String> tempMap = new HashMap<String, String>();
					for (Map<String, Object> entity : list) { // 数据规则的话只有一条记录
						
						 * if(StringUtils.isBlank(entity.get("ZDRYID"))){//不是重点人员
						 * break; }
						 
						if (StringUtils.isBlank(entity.get("GXZRQDM"))) {// 无所属责任区
							break;
						} else {
							if (entity.get("GXZRQDM").toString()
									.equals(sessionBean.getUserOrgCode())) {// 为当前登陆用户自己的责任区
								if (check) {// 排除自己责任区，结束流程
									break;
								}
							}
							tempMap.put("gxzrqdm", entity.get("GXZRQDM")
									.toString());
						}
						if (!StringUtils.isBlank(entity.get("ORGNAME"))) {
							tempMap.put("orgname", entity.get("ORGNAME")
									.toString());
						}
						if (!StringUtils.isBlank(entity.get("XM"))) {
							tempMap.put("xm", entity.get("XM").toString());
						}
						
						 * if(!StringUtils.isBlank(map.get("lxdh"))){
						 * if(!StringUtils.isBlank(entity.get("LXFS"))){//原值不为空
						 * if
						 * (map.get("lxdh").toString().trim().equals(entity.get
						 * ("LXFS").toString().trim())){//未发生变化 break; }
						 * }else{//原值为空
						 * if(StringUtils.isBlank(map.get("lxdh"))){//未发生变化
						 * break; } } }
						 
						if (entity.get("ZB_RYID") != null) {// 联系方式子表的ryid字段不为空,说明已存在此联系电话
							break;
						}

						Ywxtgzrwb ywxtgzrwb = new Ywxtgzrwb();
						ywxtgzrwb.setYwxtgzrwmc("联系方式核实");
						xxnr = "【电话变更提醒】经核实，你辖区的实有人口【"
								+ (tempMap.get("xm") == null ? "" : tempMap
										.get("xm").toString()) + "】，在办理"
								+ map.get("ywmc") + "业务时，联系电话登记为【"
								+ map.get("lxdh") + "】,请核实！";
						ywxtgzrwb.setYwxtrwms(xxnr);
						String ywxtgzrwbid = savaYwxtgzrwb(ywxtgzrwb,
								sessionBean);
						String url = url("lxdh", map, sessionBean, ywxtgzrwbid);
						sysMsg.setYwurl(url);

						if (entity.get("USER_COUNT") != null
								&& Integer.parseInt(entity.get("USER_COUNT")
										.toString()) > 0) {// 责任区有社区民警
							sysMsg.setXxnr(xxnr);
							saveMessageByOrg(sysMsg, tempMap.get("gxzrqdm"),
									false, false);
						} else {// 责任区无社区民警,发送给管理员,结束流程
							xxnr = "【系统消息提醒】经核实，"
									+ "【"
									+ (tempMap.get("orgname") == null ? ""
											: tempMap.get("orgname").toString())
									+ "责任区】没有分配社区民警，请知晓！";
							sysMsg.setXxnr(xxnr);
							// saveMessageByUser(sysMsg, "admin");
							saveMessageToAdmin(sysMsg, "admin", false, false);
							// 更新人员联系方式子表
							
							 * Rylxfszb entity = new Rylxfszb();
							 * entity.setRyid(map.get("ryid").toString());
							 * entity
							 * .setLxfslxdm(map.get("lxfslxdm").toString());
							 * entity.setLxfs(map.get("lxfs").toString());
							 * BaseService.setUpdateProperties(entity,
							 * sessionBean); update("Message.updateRylxdh",
							 * entity);
							 
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				returnValue = "1";
			}
		}
		return returnValue;
	}
*/


	public String url(String type, Map map, SessionBean sessionBean,
			String ywxtgzrwbid) {
		String url = "";
		if ("syrk".equals(type)) {
			if ("0".equals(map.get("hslx"))) {
				url = "/ywxtgzrwb/ywxtgzrwbView?flag=0&businessName=syrkxz&methodName=createSyrk&hsrwid="
						+ map.get("hsrwid")
						+ "&hslx="
						+ map.get("hslx")
						+ "&userid="
						+ sessionBean.getUserId()
						+ "&ywxtgzrwbid=" + ywxtgzrwbid;
			} else {
				url = "/ywxtgzrwb/ywxtgzrwbView?flag=0&businessName=syrkzx&methodName=createSyrk&hsrwid="
						+ map.get("hsrwid")
						+ "&hslx="
						+ map.get("hslx")
						+ "&userid="
						+ sessionBean.getUserId()
						+ "&ywxtgzrwbid=" + ywxtgzrwbid;
			}
		} else if ("lxdh".equals(type)) {
			url = "/ywxtgzrwb/ywxtgzrwbView?flag=0&businessName=lxdh&methodName=createLxdh&ryid="
					+ map.get("ryid")
					+ "&lxfslxdm=1&lxfs="
					+ map.get("lxdh")
					+ "&userid="
					+ sessionBean.getUserId()
					+ "&ywxtgzrwbid="
					+ ywxtgzrwbid;
		} else if ("cyry".equals(type)) {
			url = "/ywxtgzrwb/ywxtgzrwbView?flag=0&businessName=cyry&methodName=createCyry&ryid="
					+ map.get("ryid")
					+ "&dwid="
					+ map.get("ryid")
					+ "&userid="
					+ sessionBean.getUserId() + "&ywxtgzrwbid=" + ywxtgzrwbid;
		} else if ("fwcs".equals(type)) {
			if ("0".equals(map.get("hslx"))) {
				url = "/ywxtgzrwb/ywxtgzrwbView?flag=0&businessName=fwcsxz&methodName=createCyry&ryid="
						+ map.get("ryid")
						+ "&dwid="
						+ map.get("dwid")
						+ "&dwmc="
						+ map.get("dwmc")
						+ "&hslx="
						+ map.get("hslx")
						+ "&userid="
						+ sessionBean.getUserId()
						+ "&ywxtgzrwbid="
						+ ywxtgzrwbid;
			} else {
				url = "/ywxtgzrwb/ywxtgzrwbView?flag=0&businessName=fwcszx&methodName=createCyry&ryid="
						+ map.get("ryid")
						+ "&dwid="
						+ map.get("dwid")
						+ "&dwmc="
						+ map.get("dwmc")
						+ "&hslx="
						+ map.get("hslx")
						+ "&userid="
						+ sessionBean.getUserId()
						+ "&ywxtgzrwbid="
						+ ywxtgzrwbid;
			}
		}

		return url;
	}

	public String savaYwxtgzrwb(Ywxtgzrwb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		String sysStringDate = DateUtils.getSystemDateTimeString();
		entity.setFqsj(sysStringDate);
		entity.setFqrbmid(sessionBean.getUserOrgCode());
		entity.setFqrbm(sessionBean.getUserOrgName());
		entity.setFqrid(sessionBean.getUserId());
		entity.setFqr(sessionBean.getUserName());
		entity.setYwrwztdm("1");
		BaseService.setSaveProperties(entity, sessionBean);
		ywxtgzrwbDao.savaYwxtgzrwb(entity);
		return entity.getId();
	}

	public void updateYwxtgzrwbByClr(Ywxtgzrwb ywxtgzrwb,
			SessionBean sessionBean) {
		String sysStringDate = DateUtils.getSystemDateTimeString();
		ywxtgzrwb.setRwclsj(sysStringDate);
		ywxtgzrwb.setRwclrbmid(sessionBean.getUserOrgCode());
		ywxtgzrwb.setRwclrbm(sessionBean.getUserOrgName());
		ywxtgzrwb.setRwclrid(sessionBean.getUserId());
		ywxtgzrwb.setRwclr(sessionBean.getUserName());
		ywxtgzrwbDao.updateYwxtgzrwb(ywxtgzrwb);

	}

	public void updateYwxtgzrwbByCjr(Ywxtgzrwb ywxtgzrwb,
			SessionBean sessionBean) {
		String sysStringDate = DateUtils.getSystemDateTimeString();
		ywxtgzrwb.setCjsj(sysStringDate);
		ywxtgzrwb.setCjrbmid(sessionBean.getUserOrgCode());
		ywxtgzrwb.setCjrbm(sessionBean.getUserOrgName());
		ywxtgzrwb.setCjrid(sessionBean.getUserId());
		ywxtgzrwb.setCjr(sessionBean.getUserName());
		ywxtgzrwbDao.updateYwxtgzrwb(ywxtgzrwb);

	}

	// begin
	public String saveMsg(SysMessage entity) {
		entity.setId(getSequence("")); // 生成主键
		String returnValue = "0";
		try {
			insert("Ywxtgzrwb.insertMsg", entity);
		} catch (Exception e) {
			returnValue = "1";
		}
		return returnValue;
	}

	public String saveMessages(SysMessage entity) {
		Long returnValue = new Long(0);
		StringBuffer sb = new StringBuffer();
		if (entity != null) {
			List list = new ArrayList();
			String jsrs[] = entity.getJsr().split(",");
			String[] jsrdms = entity.getUserid().split(",");
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			String fssj = format.format(date);
			SysMessage entitys;
			for (int i = 0; i < jsrs.length; i++) {
				entitys = new SysMessage();
				entitys.setId(getSequence("")); // 生成主键
				entitys.setSfck("0");
				String xxnr = StringUtils.nullToStr(entity.getXxnr());
				if (xxnr.length() > 200) {
					entitys.setXxnr(xxnr.substring(0, 200));
				} else {
					entitys.setXxnr(xxnr);
				}
				String ywurl = entitys.getYwurl();
				if (!StringUtils.isBlank(ywurl)) {
					if (ywurl.indexOf("?") == -1) {
						ywurl = ywurl + "?messageid=" + entity.getId();
					} else {
						ywurl = ywurl + "&messageid=" + entity.getId();
					}
					entitys.setYwurl(ywurl);
				}

				if (StringUtils.isBlank(entity.getJslx())) {
					entity.setJslx("0"); // 默认接收类型为人员
				}
				entitys.setJsr(jsrs[i]);
				entitys.setJsrdm(jsrdms[i]);
				entitys.setXxlb("3");
				entitys.setFssj(fssj);
				entitys.setFsr(entity.getFsr());
				entitys.setFsrdm(entity.getFsrdm());
				entitys.setFsrssdw(entity.getFsrssdw());
				list.add(entitys);
				returnValue = entitys.getId();
				sb.append(returnValue).append(",");
			}
			insert("Message.saves", list);
		}
		return sb.toString().substring(0, sb.toString().lastIndexOf(","));
	}

}
