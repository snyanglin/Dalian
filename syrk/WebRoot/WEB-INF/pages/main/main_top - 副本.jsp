<%@page pageEncoding="UTF-8"%>
<%@page import="com.founder.framework.base.entity.SessionBean"%>
<%
String contextPath = request.getContextPath();
String emptyImage = contextPath + "/common/skin/images/sys_empty.gif";

SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
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
<script type="text/javascript">
var contextPath = "<%=contextPath%>";
</script>

<link href="<%=contextPath%>/common/skin/main.css" type="text/css" rel="stylesheet" >
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/global.js" ></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/mainFrame.js"></script>
<script type="text/javascript" src="<%=contextPath%>/js/jquery-1.10.1.min.js"></script>

<HTML>
<HEAD>
<TITLE></TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</HEAD>

<SCRIPT language=JavaScript>

function body_onload() {
}

function logout_click(){
  window.top.location.href=contextPath+"/index.jsp";
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
  <td align="right">
    <table border="0" cellpadding="0" cellspacing="0" height="60">
    <tbody><tr>
      <td class="bannerDwHs" valign="top" title="实有单位核实" onclick="menu_open('实有单位核实', '/forward/sydw_dl|sydwHs')"><img src="<%=emptyImage%>" width="60" height="60" border="0"></td>
      <td><img src="<%=emptyImage%>" width="10" height="60" border="0"></td>    
      
      <td class="bannerSydw" valign="top" title="实有单位" onclick="menu_open('实有单位', '/forward/sydw_dl|sydwMain')"><img src="<%=emptyImage%>" width="60" height="60" border="0"></td>
      <td><img src="<%=emptyImage%>" width="10" height="60" border="0"></td>
        
      <td class="bannerZdrkHs" valign="top" title="重点人员核实" onclick="menu_open('重点人员核实', '/forward/zdrk|zdrkHs')"><img src="<%=emptyImage%>" width="60" height="60" border="0"></td>
      <td><img src="<%=emptyImage%>" width="10" height="60" border="0"></td>
    
      <td class="bannerSyrkHs" valign="top" title="实有人口核实" onclick="menu_open('实有人口核实', '/forward/syrk|syrkHs')"><img src="<%=emptyImage%>" width="60" height="60" border="0"></td>
      <td><img src="<%=emptyImage%>" width="10" height="60" border="0"></td>
     
      <td class="bannerZdry" valign="top" title="重点人员管理" onclick="menu_open('重点人员管理', '/forward/zdrk|zdrkMain')"><img src="<%=emptyImage%>" width="60" height="60" border="0"></td>
      <td><img src="<%=emptyImage%>" width="10" height="60" border="0"></td>
     
      <td class="bannerSyrk" valign="top" title="实有人口" onclick="menu_open('实有人口', '/forward/syrk|bzdzMain')"><img src="<%=emptyImage%>" width="60" height="60" border="0"></td>
      <td><img src="<%=emptyImage%>" width="10" height="60" border="0"></td>
      
      <td class="bannerSyrk" valign="top" title="实有房屋" onclick="menu_open('实有房屋', '/forward/syfw|syfwMain')"><img src="<%=emptyImage%>" width="60" height="60" border="0"></td>
      <td><img src="<%=emptyImage%>" width="10" height="60" border="0"></td>
     
      <td class="bannerBzdz" valign="top" title="" onclick="window.open('http://10.80.5.222:7001/bzdz/userLogin_loginExternal.action?userId=<%=userID %>')" ><img src="<%=emptyImage%>" width="60" height="60" border="0"></td>
      <td><img src="<%=emptyImage%>" width="10" height="60" border="0"></td>
     
      <td class="bannerNavi" valign="top" onclick=""><img src="<%=emptyImage%>" width="60" height="60" border="0" onclick="
      	var height = $(window).height(), offright=$(this).offset().left, index = parent.parent.$.layer({
			type : 2,
			shadeClose : true,
			border : [0],
			title : false,
			closeBtn : false,
			area : ['650px', '450px'],
			iframe : {src : contextPath + '/forward/organization|menu|navigator'},
			success : function(layer){
				
			}
		})"></td>
      <td><img src="<%=emptyImage%>" width="10" height="60" border="0"></td>
       <!--
      <td class="bannerZhdl" valign="top" onclick=""><img src="<%=emptyImage%>" width="60" height="60" border="0"></td>
      <td><img src="<%=emptyImage%>" width="10" height="60" border="0"></td>-->
    </tr></tbody>
    </table>
  </td>
  <td align=right class="banner03" width="220">
  	<table border="0" cellpadding="0" cellspacing="0" height="42" width="160" valign="right">
    <tbody>
      <tr>
	      <td rowspan="2" width="42" class="bannerUser" id="userImg"><img src="<%=emptyImage%>" width="42" height="42" border="0" onclick="window.top.showDysCalendar();"></td>
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
