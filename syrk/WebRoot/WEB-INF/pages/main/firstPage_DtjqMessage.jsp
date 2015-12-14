<%@page language="java" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page import="com.founder.framework.message.bean.SysMessage"%>
<%@page import="com.founder.framework.base.entity.SessionBean"%>

<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/global.js" ></script>
<link href="<%=contextPath%>/common/skin/firstPage.css" type="text/css" rel="stylesheet" >
<script type="text/javascript" src="<%=contextPath%>/common/websocket/jWebSocket.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/websocket/jwsMosPlugIn.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE></TITLE>
  </head>
  
  
  <script language="JavaScript">

function title_onclick(xxID) {
  window.top.openWindow(false,'', '<%=contextPath %>' +"/jcj/queryJjxx?id="+xxID, {document: document}, {title: '警情信息',    
	    width: 850,   
	    height: 420,  
		collapsible: false, 
		minimizable: false, 
		maximizable: false,
		closable: true,
	    closed: false,    
	    cache: false,
	    inline: false,
		resizable: false, 
	    modal: true});
}


</script>
 <body class="messageBody">

<table align="center" width="100%" height="100%" border="0" cellpadding="0" cellspacing="1" class="messageTable">
    <tr class="messageTableTr">
        <td class="messageTableTd" valign="top" >
              <table width="100%" border="0" cellpadding="0" cellspacing="0">
             <tr><td colspan="3" height="2"></td></tr>
               <c:forEach items="${dtjqMessage }" var="o" varStatus="status">
	               <c:choose>
	                  <c:when test="${status.first}" >
	                       <tr height="35px" valign="middle">
			                    <td width="5%"><div class="divMessageRead1" title="未读"></div></td>
			                    <td width="73%" class="messageContentTd1"><a href="#" title="${o.bjnr }" onclick="title_onclick('${o.id }')" style="line-height: 25px;color: red;"><font color="#009900">[警情提醒]</font>&nbsp;<strong>${o.bjnr }</strong></a></td>
	                            <td width="22%" class="messageContentTd1">&nbsp;${o.xt_lrsj }</td>
	                      </tr>
	                  </c:when>
	                  <c:otherwise>
			               <tr height="35px" valign="middle">
			                    <td width="5%"><div class="divMessageRead1" title="未读"></div></td>
			                    <td width="73%" class="messageContentTd1"><a href="#" title="${o.bjnr }" onclick="title_onclick('${o.id }')" style="line-height: 25px"><font color="#009900">[警情提醒]</font>&nbsp;${o.bjnr }</a></td>
	                            <td width="22%" class="messageContentTd1">&nbsp;${o.xt_lrsj }</td>
	                       </tr>		           
	               </c:otherwise>
	              </c:choose>    
                  
              </c:forEach>
             </table> 
             
        </td>
    </tr>
</table>

</body>
</html>

 <script type="text/javascript">


</script>
