package com.founder.alarm;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.utils.DateUtils;

public class BaseDock{
	
	public final Map<String,Object> result = new HashMap<String, Object>();
	private String message;
	
	public String getMessage() {
		return message;
	}

	@SuppressWarnings("unchecked")
	public void setMessage(List<String> exr) {
		try {
			Map map = new HashMap();
			map.put("result","执行结果:("+exr.size()+")");
			map.put("content",exr);
			this.message = new ObjectMapper().writeValueAsString(map);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		result.put("message",this.getMessage());
	}

	public SysMessage createMessage(){
		SysMessage message = new SysMessage();
		message.setYwurl("");	//业务URL
		message.setFsr("系统");		//发送人
		message.setFsrdm("XT");	//发送人代码
		message.setFssj(DateUtils.getSystemDateTimeString());	//发送时间
		message.setFsrssdw("系统");	//发送人所属单位
		message.setFsrssdwdm("XT");	//发送人所属单位代码
		message.setDxzt("0");		//短信状态
		message.setJsr("");			//接收人
		message.setJsrdm("");		//接收人代码
		message.setCksj("");		//查看时间
		return message;
	}
	
	public Map<String,String> getDate(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
		Calendar calendar = Calendar.getInstance();
		Date theDate = calendar.getTime();
		gcLast.setTime(theDate);
		gcLast.set(Calendar.DAY_OF_MONTH, 1);
		String day_first_prevM = df.format(gcLast.getTime());
		Map<String, String> map = new HashMap<String, String>();
		map.put("begin", day_first_prevM);
		return map;
	}
	
	@SuppressWarnings("static-access")
	public Map<String,String> findLastMonth(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		Date theDate = calendar.getTime();
		gcLast.setTime(theDate);
		gcLast.set(Calendar.DAY_OF_MONTH, 1);
		String day_first_prevM = df.format(gcLast.getTime());
//		StringBuffer str = new StringBuffer()
//			.append(day_first_prevM)
//			.append(" 00:00:00");
//		day_first_prevM = str.toString();
		calendar.add(cal.MONTH, 1);
		calendar.set(cal.DATE, 1);
		calendar.add(cal.DATE, -1);
		String day_end_prevM = df.format(calendar.getTime());
//		StringBuffer endStr = new StringBuffer()
//			.append(day_end_prevM)
//			.append(" 23:59:59");
//		day_end_prevM = endStr.toString();
		Map<String, String> map = new HashMap<String, String>();
		map.put("begin", day_first_prevM);
		map.put("end", day_end_prevM);
		return map;
	}
}
