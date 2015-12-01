package com.founder.zdry.quartzjob;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.founder.framework.config.SpringCreator;
import com.founder.framework.dictionary.service.SysDictGlService;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.message.service.SysMessageService;
import com.founder.framework.organization.assign.service.OrgAssignPublic;
import com.founder.framework.organization.assign.vo.OrgUserInfo;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.StringUtils;
import com.founder.zdry.bean.ZdryDtgljsxxb;
import com.founder.zdry.bean.ZdryGlpzpzb;
import com.founder.zdry.bean.ZdryJsmbpzb;
import com.founder.zdry.dao.ZdryDtgljsxxbDao;
import com.founder.zdry.dao.ZdryGlpzpzbDao;
import com.founder.zdry.service.ZdryDtgljsxxbService;
import com.founder.zdry.service.ZdryJsmbpzbService;

/******************************************************************************
 * @Package: [com.founder.zdry.quartzjob.ZdryDtgljsJob.java]
 * @ClassName: [ZdryDtgljsJob]
 * @Description: [重点人员-动态管理纪实定时任务]
 * @Author: [hongguanjun]
 * @CreateDate: [2015-3-19 上午10:14:59]
 * @UpdateUser: [hongguanjun(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-3-19 上午10:14:59，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
public class ZdryDtgljsxxbJob {

	/**
	 * @Title: messageRemind
	 * @Description: TODO(重点人员-动态管理纪实消息提醒)
	 * @param 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void messageRemind() {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int date = calendar.get(Calendar.DATE);
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DATE, 1);
		calendar.add(Calendar.DATE, -3);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		if (DateUtils.getSystemDateString().equals(
				DateUtils.getShortString(calendar.getTime()))) { // 是否为当前月的倒数第三天
			// System.out.println(DateUtils.getFullString(calendar.getTime()));
			// if (System.currentTimeMillis() >= calendar.getTimeInMillis()) {
			// 是否为当前月的最后三天
			Map<String, String> dateMap = new HashMap<String, String>();
			// 1＝一个月；2=一季度；3＝半年；4＝一年
			calendar.set(Calendar.DATE, 1);
			String dateString = "";
			dateString = DateUtils.getShortString(calendar.getTime());
			dateString = dateString.substring(0, 7);
			dateMap.put("1", dateString);

			calendar.set(Calendar.MONTH, (int) (month / 3) * 3);
			dateString = DateUtils.getShortString(calendar.getTime());
			dateString = dateString.substring(0, 7);
			dateMap.put("2", dateString);

			calendar.set(Calendar.MONTH, (int) (month / 6) * 6);
			dateString = DateUtils.getShortString(calendar.getTime());
			dateString = dateString.substring(0, 7);
			dateMap.put("3", dateString);

			calendar.set(Calendar.MONTH, 0);
			dateString = DateUtils.getShortString(calendar.getTime());
			dateString = dateString.substring(0, 7);
			dateMap.put("4", dateString);

			Map<String, String> dtjszqMap = new HashMap<String, String>();
			dtjszqMap.put("1", "一个月");
			dtjszqMap.put("2", "一季度");
			dtjszqMap.put("3", "半年");
			dtjszqMap.put("4", "一年");

			ZdryGlpzpzbDao zdryGlpzpzbDao = (ZdryGlpzpzbDao) SpringCreator
					.getBean("zdryGlpzpzbDao");
			List<ZdryGlpzpzb> list = zdryGlpzpzbDao.queryByDtjszqdmNotNull();
			if (list != null && list.size() > 0) {
				String caseWhen = "";
				Map<String, String> zdrygllxdmMap = new HashMap<String, String>();
				for (int i = 0; i < list.size(); i++) {
					ZdryGlpzpzb zdryGlpzpzb = (ZdryGlpzpzb) list.get(i);
					String zdrygllxdm = StringUtils.nullToStr(zdryGlpzpzb
							.getZdrygllxdm());
					String dtjszqdm = StringUtils.nullToStr(zdryGlpzpzb
							.getDtjszqdm());
					if (!zdrygllxdmMap.containsKey(zdrygllxdm)) { // 去除重复的配置
						if (dateMap.containsKey(dtjszqdm)) {
							caseWhen += " when a.zdrygllxdm='" + zdrygllxdm
									+ "' then '" + dateMap.get(dtjszqdm) + "'";
							zdrygllxdmMap.put(zdrygllxdm,
									dtjszqMap.get(dtjszqdm));
						}
					}
				}
				if (!StringUtils.isBlank(caseWhen)) { // 有配置条件时执行任务
					caseWhen = "(case " + caseWhen + " else '0' end)";
					messageRemindExecute(caseWhen, zdrygllxdmMap);
				}
			}
		}
	}

	/**
	 * @Title: messageRemindExecute
	 * @Description: TODO(重点人员-动态管理纪实消息提醒执行)
	 * @param @param caseWhen 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	private void messageRemindExecute(String caseWhen,
			Map<String, String> zdrygllxdmMap) {
		ZdryDtgljsxxbDao zdryDtgljsxxbDao = (ZdryDtgljsxxbDao) SpringCreator
				.getBean("zdryDtgljsxxbDao");
		SysDictGlService sysDictGlService = (SysDictGlService) SpringCreator
				.getBean("sysDictGlService");
		SysMessageService sysMessageService = (SysMessageService) SpringCreator
				.getBean("sysMessageService");

		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			Map<String, String> zdrygllxdmDictMap = sysDictGlService
					.getDictMap("DL_D_ZDRYLXDM");
			SysMessage sysMessage = new SysMessage();
			sysMessage.setXxlb("1");
			sysMessage.setFsr("系统管理员");
			sysMessage.setFsrdm("admin");
			sysMessage.setFssj(DateUtils.getSystemDateTimeString());
			sysMessage.setFsrssdw("系统");
			sysMessage.setFsrssdwdm("0");
			sysMessage.setDxzt("0");
			sysMessage.setJslx("1"); // 默认接收类型为部门
			String ywurl = "";
			sysMessage.setYwurl(ywurl);
			sysMessage.setXxbt("重点人员动态纪实提醒");

			String zdrygllxdmCondition = "";
			Iterator iterator = zdrygllxdmMap.keySet().iterator();
			String key, value;
			while (iterator.hasNext()) {
				key = (String) iterator.next();
				zdrygllxdmCondition += "'" + key + "',";
			}
			if (!StringUtils.isBlank(zdrygllxdmCondition)) { // 取得有周期配置的重点人员管理类型代码
				zdrygllxdmCondition = zdrygllxdmCondition.substring(0,
						zdrygllxdmCondition.length() - 1);
			}

			conn = zdryDtgljsxxbDao.getDataSource().getConnection();
			statement = conn.createStatement();
			String sql = "select a.ID,a.ZJHM,a.XM,a.ZDRYGLLXDM,a.SSZRQDM from ZDRY_ZDRYZB a where a.XT_ZXBZ='0' and a.SSZRQDM is not null"
					+ " and a.ZDRYGLLXDM in ("
					+ zdrygllxdmCondition
					+ ") and not exists(select b.ZDRYID from ZDRY_DTGLJSXXB b where b.ZDRYID=a.ID and b.XT_ZXBZ='0' and b.JS_SJ>="
					+ caseWhen + ")";
			rs = statement.executeQuery(sql);
			int i = 1;
			while (rs.next()) {
				String id = StringUtils.nullToStr(rs.getString("ID"));
				String zjhm = StringUtils.nullToStr(rs.getString("ZJHM"));
				String xm = StringUtils.nullToStr(rs.getString("XM"));
				String zdrygllxdm = StringUtils.nullToStr(rs
						.getString("ZDRYGLLXDM"));
				String sszrqdm = StringUtils.nullToStr(rs.getString("SSZRQDM"));
				String zdrygllxmc = StringUtils.nullToStr(zdrygllxdmDictMap
						.get(zdrygllxdm));
				String dtjszqmc = StringUtils.nullToStr(zdrygllxdmMap
						.get(zdrygllxdm));
				String xxnr = zdrygllxmc + xm + "于" + dtjszqmc
						+ "尚未录入动态管理纪实，请录入。";
				sysMessage.setXxnr(xxnr);
				sysMessageService.saveMessageByOrg(sysMessage, sszrqdm, false,
						false);
				i++;
			}
		} catch (Exception ex) {

		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (statement != null) {
					statement.close();
					statement = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Exception ex) {

			}
		}
	}

	/**
	 * @Title: autoAdd
	 * @Description: TODO(重点人员-动态管理纪实自动新增)
	 * @param 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void autoAdd() {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int date = calendar.get(Calendar.DATE);
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DATE, 1);
		calendar.add(Calendar.DATE, -1);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		if (DateUtils.getSystemDateString().equals(
				DateUtils.getShortString(calendar.getTime()))) { // 是否为当前月的最后一天
			Map<String, String> dateMap = new HashMap<String, String>();
			// 1＝一个月；2=一季度；3＝半年；4＝一年
			calendar.set(Calendar.DATE, 1);
			String dateString = "";
			dateString = DateUtils.getShortString(calendar.getTime());
			dateString = dateString.substring(0, 7);
			dateMap.put("1", dateString);

			calendar.set(Calendar.MONTH, (int) (month / 3) * 3);
			dateString = DateUtils.getShortString(calendar.getTime());
			dateString = dateString.substring(0, 7);
			dateMap.put("2", dateString);

			calendar.set(Calendar.MONTH, (int) (month / 6) * 6);
			dateString = DateUtils.getShortString(calendar.getTime());
			dateString = dateString.substring(0, 7);
			dateMap.put("3", dateString);

			calendar.set(Calendar.MONTH, 0);
			dateString = DateUtils.getShortString(calendar.getTime());
			dateString = dateString.substring(0, 7);
			dateMap.put("4", dateString);

			Map<String, String> dtjszqMap = new HashMap<String, String>();
			dtjszqMap.put("1", "一个月");
			dtjszqMap.put("2", "一季度");
			dtjszqMap.put("3", "半年");
			dtjszqMap.put("4", "一年");

			ZdryGlpzpzbDao zdryGlpzpzbDao = (ZdryGlpzpzbDao) SpringCreator
					.getBean("zdryGlpzpzbDao");
			List<ZdryGlpzpzb> list = zdryGlpzpzbDao.queryByDtjszqdmNotNull();
			if (list != null && list.size() > 0) {
				String caseWhen = "";
				Map<String, String> zdrygllxdmMap = new HashMap<String, String>();
				for (int i = 0; i < list.size(); i++) {
					ZdryGlpzpzb zdryGlpzpzb = (ZdryGlpzpzb) list.get(i);
					String zdrygllxdm = StringUtils.nullToStr(zdryGlpzpzb
							.getZdrygllxdm());
					String dtjszqdm = StringUtils.nullToStr(zdryGlpzpzb
							.getDtjszqdm());
					if (!zdrygllxdmMap.containsKey(zdrygllxdm)) { // 去除重复的配置
						if (dateMap.containsKey(dtjszqdm)) {
							caseWhen += " when a.zdrygllxdm='" + zdrygllxdm
									+ "' then '" + dateMap.get(dtjszqdm) + "'";
							zdrygllxdmMap.put(zdrygllxdm,
									dtjszqMap.get(dtjszqdm));
						}
					}
				}
				if (!StringUtils.isBlank(caseWhen)) { // 有配置条件时执行任务
					caseWhen = "(case " + caseWhen + " end)";
					autoAddExecute(caseWhen, zdrygllxdmMap);
				}
			}
		}
	}

	/**
	 * @Title: messageRemindExecute
	 * @Description: TODO(重点人员-动态管理纪实自动新增执行)
	 * @param @param caseWhen 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	private void autoAddExecute(String caseWhen,
			Map<String, String> zdrygllxdmMap) {
		ZdryDtgljsxxbService zdryDtgljsxxbService = (ZdryDtgljsxxbService) SpringCreator
				.getBean("zdryDtgljsxxbService");
		ZdryDtgljsxxbDao zdryDtgljsxxbDao = (ZdryDtgljsxxbDao) SpringCreator
				.getBean("zdryDtgljsxxbDao");
		ZdryJsmbpzbService zdryJsmbpzbService = (ZdryJsmbpzbService) SpringCreator
				.getBean("zdryJsmbpzbService");
		List<ZdryJsmbpzb> zdryJsmbpzbList = zdryJsmbpzbService
				.queryDefaultList();
		if (zdryJsmbpzbList != null && zdryJsmbpzbList.size() > 0) {
			Map<String, String> jsmbMap = new HashMap<String, String>();
			for (int i = 0; i < zdryJsmbpzbList.size(); i++) {
				ZdryJsmbpzb zdryJsmbpzb = (ZdryJsmbpzb) zdryJsmbpzbList.get(i);
				String zdrygllxdm = zdryJsmbpzb.getZdrygllxdm();
				String mbnr = zdryJsmbpzb.getMbnr();
				if (!StringUtils.isBlank(zdrygllxdm)
						&& !StringUtils.isBlank(mbnr)) {
					jsmbMap.put(zdrygllxdm, mbnr);
				}
			}

			String zdrygllxdmCondition = "";
			Iterator iterator = zdrygllxdmMap.keySet().iterator();
			String key, value;
			while (iterator.hasNext()) {
				key = (String) iterator.next();
				if (jsmbMap.containsKey(key)) { // 同时有周期配置与纪实模板配置的才处理
					zdrygllxdmCondition += "'" + key + "',";
				}
			}
			if (!StringUtils.isBlank(zdrygllxdmCondition)) {
				zdrygllxdmCondition = zdrygllxdmCondition.substring(0,
						zdrygllxdmCondition.length() - 1);
				Connection conn = null;
				Statement statement = null;
				ResultSet rs = null;
				try {
					String systemDateTime = DateUtils.getSystemDateTimeString();
					ZdryDtgljsxxb zdryDtgljsxxb = new ZdryDtgljsxxb();
					zdryDtgljsxxb.setJs_sj(DateUtils.getSystemDateString());
					zdryDtgljsxxb.setJslxdm("0");
					zdryDtgljsxxb.setSfzkdm("1");
					zdryDtgljsxxb.setXt_lrrxm("系统管理员");
					zdryDtgljsxxb.setXt_lrrid("admin");
					zdryDtgljsxxb.setXt_lrrbm("系统");
					zdryDtgljsxxb.setXt_lrrbmid("0");
					zdryDtgljsxxb.setXt_lrip("127.0.0.1");
					zdryDtgljsxxb.setXt_zhxgrxm("系统管理员");
					zdryDtgljsxxb.setXt_zhxgrid("admin");
					zdryDtgljsxxb.setXt_zhxgrbm("系统");
					zdryDtgljsxxb.setXt_zhxgrbmid("0");
					zdryDtgljsxxb.setXt_zhxgip("127.0.0.1");
					zdryDtgljsxxb.setXt_cjsj(systemDateTime);
					zdryDtgljsxxb.setXt_lrsj(systemDateTime);
					zdryDtgljsxxb.setXt_zhxgsj(systemDateTime);
					zdryDtgljsxxb.setXt_zxbz("0");

					OrgAssignPublic orgAssignPublic = new OrgAssignPublic();
					List<OrgUserInfo> zrqmjList = orgAssignPublic
							.queryOrgUserByComposite("", true, "01", "50", "",
									""); // 查询所有责任区民警
					Map<String, OrgUserInfo> zrqmjMap = new HashMap<String, OrgUserInfo>();
					if (zrqmjList != null && zrqmjList.size() > 0) {
						for (int i = 0; i < zrqmjList.size(); i++) {
							OrgUserInfo orgUserInfo = zrqmjList.get(i);
							String orgcode = orgUserInfo.getOrgcode();
							if (!zrqmjMap.containsKey(orgcode)) {
								zrqmjMap.put(orgcode, orgUserInfo);
							}
						}
					}

					conn = zdryDtgljsxxbDao.getDataSource().getConnection();
					statement = conn.createStatement();
					String sql = "select a.ID,a.ZJHM,a.XM,a.ZDRYGLLXDM,a.SSZRQDM from ZDRY_ZDRYZB a where a.XT_ZXBZ='0' and a.SSZRQDM is not null"
							+ " and a.ZDRYGLLXDM in ("
							+ zdrygllxdmCondition
							+ ") and not exists(select b.ZDRYID from ZDRY_DTGLJSXXB b where b.ZDRYID=a.ID and b.XT_ZXBZ='0' and b.JS_SJ>="
							+ caseWhen + ")";
					rs = statement.executeQuery(sql);
					int i = 1;
					while (rs.next()) {
						String id = StringUtils.nullToStr(rs.getString("ID"));
						String zdrygllxdm = StringUtils.nullToStr(rs
								.getString("ZDRYGLLXDM"));
						String sszrqdm = StringUtils.nullToStr(rs
								.getString("SSZRQDM"));
						if (jsmbMap.containsKey(zdrygllxdm)) {
							zdryDtgljsxxb.setZdryid(id);
							zdryDtgljsxxb.setDtjs(jsmbMap.get(zdrygllxdm));
							if (zrqmjMap.containsKey(sszrqdm)) { // 模拟责任区民警录入动态管理纪实
								OrgUserInfo orgUserInfo = zrqmjMap.get(sszrqdm);
								zdryDtgljsxxb.setDtjsmj_id(orgUserInfo
										.getUserid());
								zdryDtgljsxxb.setDtjsmj_xm(orgUserInfo
										.getUsername());
							} else {
								zdryDtgljsxxb.setDtjsmj_id("admin");
								zdryDtgljsxxb.setDtjsmj_xm("系统管理员");
							}
							zdryDtgljsxxbService.autoSave(zdryDtgljsxxb, null);
							i++;
						}
					}
				} catch (Exception ex) {

				} finally {
					try {
						if (rs != null) {
							rs.close();
							rs = null;
						}
						if (statement != null) {
							statement.close();
							statement = null;
						}
						if (conn != null) {
							conn.close();
							conn = null;
						}
					} catch (Exception ex) {

					}
				}
			}
		}
	}

	public static void main(String[] args) {
		ZdryDtgljsxxbJob job = new ZdryDtgljsxxbJob();
		job.messageRemind();
	}

}
