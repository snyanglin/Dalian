<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@include file="/WEB-INF/pages/common.jsp"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%
/******************************************************************************
 * @JSPName:      [wfxxMain.jsp]   
 * @Description:  [物防信息集成地图和列表显示页面]   
 * @Author:       [tian_chengwei@founder.com.cn]  
 * @CreateDate:   [2015-06-03]   
 * @UpdateUser:   [lk(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-06-03(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 
  * @review      : wu.w@founder.com.cn
 * @reviewDate  : 20150604
 */


%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<TITLE></TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</HEAD>
  <frameset id="wfxxMain" cols="540,65%" border="0" frameborder="0">
  	<frame id="main_left" frameborder="0" style="height:90%;width:100%" src="<%=contextPath%>/forward/zafffwqz|wfxxList" noresize scrolling="no"/>
	<frame id="main_center" frameborder="0" style="height:100%;width:65%" src="<%=contextPath%>/forward/zafffwqz|wfxxMap" noresize scrolling="no">
  </frameset>
</html>
