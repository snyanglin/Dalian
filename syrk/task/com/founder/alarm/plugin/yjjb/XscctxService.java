package com.founder.alarm.plugin.yjjb;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;

import com.founder.alarm.BaseDock;
import com.founder.alarm.Docking;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.message.dao.SysMessageDao;
import com.founder.framework.organization.user.bean.OrgUser;
import com.founder.framework.utils.DateUtils;
import com.founder.yjjb.bean.Xsjbxxb;
import com.founder.yjjb.dao.CommonDao;
import com.founder.yjjb.dao.XsjbxxbDao;
import com.founder.yjjb.service.CommonService;
import com.founder.yjjb.utils.MessageUtils;

/**
 * 线索初查提醒
 * @author Administrator
 *
 */
@Service()
public class XscctxService extends BaseDock implements Docking {
	private static String R_BLRY = "59549930";	//办理人员
	private static String R_SPRY = "59550161";	//审批人员
	public static ApplicationContext AC = ContextLoader.getCurrentWebApplicationContext();

	@Autowired
	private XsjbxxbDao xsjbxxbDao;
	@Autowired
	private SysMessageDao sysMessageDao;
	@Autowired
	private CommonDao commonDao;
	@Resource(name="commonService")
	private CommonService commonService;
	
	public Map<String, Object> main(HttpServletRequest request) {
		//返回所有未初查记录
		//int diff = 3;
		int diff = 3;
		List<Xsjbxxb> list = new ArrayList<Xsjbxxb>();
		list = xsjbxxbDao.queryCCById();
		List<String> exr = new ArrayList<String>();
		try {
			for (Xsjbxxb item : list) {
				if(nowDayDiff(item.getCcsj()) >= diff){
					List<OrgUser> list2 = new ArrayList<OrgUser>();
					list2 = commonDao.queryOrgUserByOrgCode(item.getSlfzdm(),R_BLRY);	//有奖举报办理人员
					for (OrgUser orgUser : list2) {
						//发送消息		
						SysMessage message = super.createMessage();
						message.setYwurl("/xsjbxxb/openCC?id="+item.getId()+"&mainTabID=0");		//业务URL
						message.setFssj(DateUtils.getSystemDateTimeString());	//发送时间
						message.setDxzt("");						//短信状态
						message.setSfck("0");						//是否查看
						message.setJsr(orgUser.getUsername());		//接收人
						message.setJsrdm(orgUser.getUserid());		//接收人代码
						message.setCksj("");						//查看时间
						message.setXxnr("【有奖举报】，【"+commonService.queryNameOrgID(item.getSlfzdm())+"】有一条线索【"+item.getId()+"】需要进行3日反馈处理，已逾期"+nowDayDiff(item.getCcsj())+"天");	//消息内容
						message.setXxlb("1");								//消息类别
						message.setJsrssdw(commonService.queryNameOrgID(item.getSlfzdm()));		//接收人所属单位
						message.setJsrssdwdm(item.getSlfzdm());	//接收人所属单位代码
						message.setXxbt("线索3日反馈处理提醒");		//信息标题
						message.setDkfs("0");					//打开方式
						this.sysMessageDao.saveMessage(message);
						exr.add("向部门["+item.getSlfzdm()+"]发送消息提醒（有一条线索["+item.getId()+"]需要进行3日反馈处理）");
					}
				}
				super.setMessage(exr);
			}
			result.put("status",true);
		} catch (Exception e) {
			result.put("message", e.getMessage());
			result.put("status",false);
		}
		return result;
	}
	
	private Integer nowDayDiff(String dateStr){
		try {
			Date date = DateUtils.stringToDate(dateStr, "yyyy-MM-dd");
			Date now = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			int day1 = calendar.get(Calendar.DAY_OF_YEAR);
			calendar.setTime(now);
			int day2 = calendar.get(Calendar.DAY_OF_YEAR);
			return day2 - day1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
