<%@page pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common.jsp"%>
<%
String contextPath = request.getContextPath();
String emptyImage = contextPath + "/common/skin/images/sys_empty.gif";

/*
UserInfo userInfo = (UserInfo)session.getAttribute("userSession");
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
*/
String userName = "用户名";
String userOrgName = "用户部门";
%>
<script type="text/javascript">
var contextPath = "<%=contextPath%>";
</script>

<link href="<%=contextPath%>/common/skin/main.css" type="text/css" rel="stylesheet" >
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/global.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/mainFrame.js"></script>

<HTML>
<HEAD>
<TITLE></TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</HEAD>

<SCRIPT language=JavaScript>

function bzdz_click() {
	mainLeftOpen(1, true, contextPath + "/forward/main|bzdz_jlx");
}

function zhdl_click() {
	mainLeftOpen(2, false, contextPath + "/forward/main|bzdz_zhdl");
}

function body_onload() {
}

function logout_click() {
	mainCenterOpen(contextPath + "/forward/bzdz|bzdz");
	//var mainCenter = getMainCenter();
	//mainCenter.test();
	//window.top.location.href = contextPath + "/index.jsp";
}

</SCRIPT>

<BODY class="bannerBody" onselectstart="return false;" onload="body_onload();" oncontextmenu="return false;">

<table border="0" cellpadding="0" cellspacing="0" align="center" width="100%" class="banner02">
<tbody><tr>
   <td width="650">
     <table border="0" cellpadding="0" cellspacing="0" height="72">
     <tbody><tr>
       <td class="banner01" valign="top"><img src="<%=emptyImage%>" width="650" height="1" border="0"></td>
    </tr></tbody>
    </table>
  </td>
  <td align="center">
    <table border="0" cellpadding="0" cellspacing="0" height="60">
    <tbody><tr>
      <td class="bannerBzdz" valign="top" onclick="bzdz_click();"><img src="<%=emptyImage%>" width="60" height="60" border="0"></td>
      <td><img src="<%=emptyImage%>" width="10" height="60" border="0"></td>
      <!-- 
      <td class="bannerSyrk" valign="top" onclick=""><img src="<%=emptyImage%>" width="60" height="60" border="0"></td>
      <td><img src="<%=emptyImage%>" width="10" height="60" border="0"></td>
      <td class="bannerGzdx" valign="top" onclick=""><img src="<%=emptyImage%>" width="60" height="60" border="0"></td>
      <td><img src="<%=emptyImage%>" width="10" height="60" border="0"></td>
       -->
      <td class="bannerZhdl" valign="top" onclick="zhdl_click();"><img src="<%=emptyImage%>" width="60" height="60" border="0"></td>
      <td><img src="<%=emptyImage%>" width="10" height="60" border="0"></td>
    </tr></tbody>
    </table>
  </td>
  <td align=right class="banner03" width="220">
  	<table border="0" cellpadding="0" cellspacing="0" height="42" width="160" valign="right">
    <tbody>
      <tr>
	      <td rowspan="2" width="42" class="bannerUser"><img src="<%=emptyImage%>" width="42" height="42" border="0"></td>
	      <td class="userInfo" width="86"><%=userName%></td>
	      <td rowspan="2" width="30" class="logout1" onclick="logout_click()" onmousemove="this.className='logout2'" onmouseout="this.className='logout1'">退出</td>
      </tr>
      <tr>
	      <td class="userInfo"><%=userOrgName%></td>
      </tr>
    </tbody>
    </table>
  </td>
</tr></tbody>
</table>

</BODY>
</HTML>
