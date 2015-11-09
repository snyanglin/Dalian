<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@	page import="com.founder.framework.base.entity.SessionBean"%>
<%
	String contextPath = request.getContextPath();
	String emptyImage = contextPath+ "/common/skin/images/sys_empty.gif";
	SessionBean userInfo = (SessionBean) session.getAttribute("userSession");
	String userName = "";
	String userOrgName = "";
	if (userInfo != null) {
		userName = userInfo.getUserName();
		userOrgName = userInfo.getUserOrgName();
	}
%>
<HTML>
<HEAD>
<style type="text/css">
</style>
<TITLE></TITLE>
<link href="<%=contextPath%>/common/skin/mainnew.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="<%=contextPath%>/js/jquery-1.10.1.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/mainFrame.js"></script>
<script type="text/javascript">
	var contextPath = "<%=contextPath%>";
	function logout_click(){
	 	window.top.location.href = contextPath+"/LoginPage/login?action=logout";
	 	//document.forms["dataform"].submit();
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</HEAD>
<BODY class="bannerBody" onselectstart="return false;" oncontextmenu="return false;">
	<form name="dataform" action="<%=contextPath%>/LoginPage/login?action=caslogout" checkType="blur" target="_self" method="post"></form>
	<div class="banner_lf banner01">
		<img src="<%=emptyImage%>" width="650" height="1" border="0">
		<div class="banner_ct">
			<div class="banner_rt">
		        <div class="banner03" style="float:right;width:220px;height:72px;">
					<table border="0" cellpadding="0" cellspacing="0" height="42" width="220" style="margin-top: 12px;">
						<tr>
							<td>
								<a href="https://www.baidu.com" target="_blank" ><img src="<%=contextPath%>/images/pt.jpg" width="40" height="40" border="0"></a>
							</td>
							<td class="bannerUser">
								<img src="<%=emptyImage%>" width="42" height="42" border="0">
							</td>
							<td style="width: 95px;">
							    <span class="userInfo">
							       <%=userName%>
							    </span>
							    <br>
							    <span class="userInfo">
							       <%=userOrgName%>
							    </span>
							</td>
							<td width="30" class="logout1" onclick="logout_click()" onmousemove="this.className='logout2'" onmouseout="this.className='logout1'">退出</td>
						</tr>
				    </table>
			   </div>
	    	</div>
		</div>
	 </div>
</BODY>
</HTML>