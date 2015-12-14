<%@page pageEncoding="UTF-8"%>
<%@page import="com.founder.framework.base.entity.SessionBean"%>
<%@include file="/WEB-INF/pages/common.jsp"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<%
java.util.Date now = new java.util.Date();
java.text.SimpleDateFormat defaultDateTimeFormatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String nowString = defaultDateTimeFormatter.format(now);

SessionBean userInfo = (SessionBean) session.getAttribute("userSession");
String userID = "";
String password = "";
String userName = "";
String userOrgName = "";
String userRemoteAddr = "";
if (userInfo != null) {
   userID =  userInfo.getUserId();
   password = userInfo.getPassword();
   if (password == null) {
      password = "";
   }
   userName =  userInfo.getUserName();
   userOrgName = userInfo.getUserOrgName();
   userRemoteAddr = userInfo.getRemoteAddr();
   java.util.Map extendMap = userInfo.getExtendMap();
   if (extendMap != null && extendMap.size() > 0) {
   }
}
%>
<HTML>
<HEAD>
<TITLE></TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/jquery1.11.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/locale/easyui-lang-zh_CN.js"></script>
<link href="<%=contextPath%>/common/skin/main.css" type="text/css" rel="stylesheet">

<style type="text/css">
.changeTd1 {
   cursor: pointer;
   color: #990000;
}
.changeTd2 {
   cursor: pointer;
   color: #FF0000;
}
</style>

</HEAD>

<BODY class="footBody" onselectstart="return false;" oncontextmenu="return false;">

<table border="0" cellpadding="0" cellspacing="0" align="center" width="100%" class="footTable">
<input type="Hidden" id="passwrod" value="<%=password%>">
<tbody><tr>
   <td>
    <table border="0" cellpadding="0" cellspacing="0" width="100%">
    <tbody><tr>
        <td nowrap id="userInforTD">
        <table width="100%" border="0">
           <tr>
              <td nowrap id="userRefreshTD">
                 &nbsp;登陆用户：<%=userName%>
                 &nbsp;&nbsp;&nbsp;所在单位：<%=userOrgName%>
                 &nbsp;&nbsp;&nbsp;登陆时间：<%=nowString%>
                 &nbsp;&nbsp;&nbsp;登陆IP：<%=userRemoteAddr%>
              </td>
           </tr>
       </table>
    </td>
    </tr></tbody>
    </table>
  </td>
</tr></tbody>
</table>

<SCRIPT language="JavaScript">

function popAdvice(openURL) {
	var properties = "LEFT=0,TOP=0,HEIGHT=600,WIDTH=800,menubar=no,toolbar=no,location=no,directories=no,scrollbars=yes,resizable=yes,status=yes";
	window.open(openURL, "popAdvice", properties); 
}

// 页面退出事件（dwr的ajax方法360浏览器捕获后无法执行）
window.onbeforeunload = function() { 
	try {
		$.ajax({url:"userLogin_loginOut.action",async:false});
	}
	catch (err) {}
}

</SCRIPT> 

</BODY>
</HTML>

