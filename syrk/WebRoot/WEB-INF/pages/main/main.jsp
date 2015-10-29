<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.config.SystemConfig"%>
<html>
<head>
    <title><%=SystemConfig.getString("systemOrganization")%>－<%=SystemConfig.getString("systemName")%></title>
    <%@include file="/WEB-INF/pages/common.jsp"%>
	<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
	<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/mainFrame.js"></script>
	<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/windowTopPage.js"></script>
	<script type="text/javascript">
	//接收消息
	var topWindow = new Messenger("topWindow",'Founder');
	topWindow.listen(
			function(msg){
				if(msg == "relogin"){
					topMessager.alert(MESSAGER_TITLE, '用户操作超时，请重新登录！', 'error', function() {
						window.top.location.href = contextPath + "/index.jsp";
					});
				}
				
			}

	);
	</script>
</head>
<body scroll="no" topmargin="0" leftmargin="0" rightmargin="0" bottommargin="0" 
   	  style="BORDER-RIGHT: 0px none; BORDER-TOP: 0px none; MARGIN: 0px; BORDER-LEFT: 0px none; BORDER-BOTTOM: 0px none; overflow: hidden;"
  	  onselectstart="return false;" oncontextmenu="return false;" >
	<iframe id="main_frame" src="<%=contextPath%>/forward/main|main_frame" frameborder="0" scrolling="no" style="width: 100%; height: 100%"></iframe>
</body>
</html>