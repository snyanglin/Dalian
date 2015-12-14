<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ include file="/WEB-INF/pages/commonMap.jsp"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String bjzbz = "";
    if(userInfo!=null){
        bjzbz = userInfo.getBjzbz();
    }
%>
<%
/******************************************************************************
 * @JSPName:      [wfxxMapBz.jsp]   
 * @Description:  [物防标注显示页面]   
 * @Author:       [tian_chengwei@founder.com.cn]  
 * @CreateDate:   [2015-06-03]   
 * @UpdateUser:   [lk(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-06-03(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */


%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:v="urn:schemas-microsoft-com:vml">
  <head>
    <title>地图标点</title>
    <script type="text/javascript" src="<%=contextPath%>/js/wfxx/wfxxMapBz.js"></script>
    <script type="text/javascript">
    	var bjzbz = "<%=bjzbz%>";
    	var bz = "${bz}";//bz标识 0或空返回X、Y坐标，1返回X、Y坐标并所属派出所、责任区信息,2为标点只读无法重新标点
    	var title = "${title}";//坐标标题
    	
    </script>
  </head>
  <body onload="loadMap();" style="overflow: hidden;">
     <div id="mapDiv" style="width:100%;height:100%;"></div>
  </body>
</html>