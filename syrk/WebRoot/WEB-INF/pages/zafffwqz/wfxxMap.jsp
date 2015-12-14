<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@page import="com.founder.framework.config.SystemConfig" %>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ include file="/WEB-INF/pages/commonMap.jsp"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    String bjzbz = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
        bjzbz = userInfo.getBjzbz();
    }
    
 %>
 <%
/******************************************************************************
 * @JSPName:      [wfxxMap.jsp]   
 * @Description:  [物防地图显示页面]   
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
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:v="urn:schemas-microsoft-com:vml">
  <head>
    <title>地图</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript">
       var userOrgCode = "<%=userOrgCode%>"; 
       var bjzbz = "<%=bjzbz%>";
       var chAddress = "<%=SystemConfig.getString("chAddress")%>";
    </script>
	<script type="text/javascript" src="<%=contextPath%>/js/wfxx/wfxx.js"></script>
  </head>
  
  <body>
      <div id="mapDiv"></div>
      <div id="toolDiv" style="position:absolute;left:0px;top:0px;height:20px;filter:alpha(opacity=90);"></div>
  </body>
</html>
