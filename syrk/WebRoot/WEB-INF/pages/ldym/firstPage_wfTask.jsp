<%@page language="java" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page import="com.founder.framework.message.bean.SysMessage"%>

<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/global.js" ></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/mainFrame.js"></script>
<link href="<%=contextPath%>/common/skin/firstPage.css" type="text/css" rel="stylesheet" >
<HTML>
<HEAD>
<TITLE></TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</HEAD>
<script language="JavaScript">

function title_onclick(xxID, ywurl,xxbt) {
  editMsgStar(xxID);
  if(null != ywurl && "" != ywurl){
     menu_open(xxbt, "/"+ywurl);
  }else{
     window.top.openWindow(false,'', '<%=contextPath %>' +"/sysMessage/view?id="+xxID, {document: document}, {title: '消息信息',    
	    width: 880,   
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
}
//业务协同规则任务表
function ywxtgzrwb(url){ 
	var editUrl = contextPath + '/forward/ldym|rkxt';
	var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
   	window.top.openWindow(false, 'xtrwclWindow', editUrl, {document: document}, {title: '协同任务处理',    
	    width: 880,   
	    height: 420,  
		collapsible: false, 
		minimizable: false, 
		maximizable: false,
		closable: true,
	    closed: false,    
	    cache: false,
	    inline: false,
		resizable: false, 
	    modal: true
	    }
   	);
}


function more_click() {
   menuLink("待处理任务", "/wf_engine_taskQuery.action");
}
//ajax修改消息状态
function editMsgStar(xxid){
    $.ajax({
       type:"POST",
       url :"<%=basePath%>sysMessage/update",
       data:{id:xxid},
       dataType:"json",
       success:function(data){
       }
    });
}
function openTabPage(url) {
	var editUrl = contextPath + '/forward/ldym|czrkrhfl';
	var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
   	window.top.openWindow(false, 'xtrwclWindow', editUrl, {document: document}, {title: '协同任务处理',    
	    width: 880,   
	    height: 420,  
		collapsible: false, 
		minimizable: false, 
		maximizable: false,
		closable: true,
	    closed: false,    
	    cache: false,
	    inline: false,
		resizable: false, 
	    modal: true
	    }
   	);
}

function openWindow(xxbt, ywurl) {
  if(null != ywurl && "" != ywurl){
     window.top.openWindow(false, "windowWithoutSave", '<%=contextPath %>' + '/forward/ldym|zdryLCApproval', {document: document}, {title: xxbt,    
	    width: 880,   
	    height: 520,  
		collapsible: false, 
		minimizable: false, 
		maximizable: false,
		style:{overflow:'auto'},
		closable: true,
	    closed: false,    
	    cache: false,
	    inline: false,
		resizable: false, 
	    modal: true});
  }
}

//信息类型为6时，打开menu页面
function  openMenuWindow (menuTitle,ywurl){
	menu_open(menuTitle,ywurl);
}
</script>

<body class="messageBody">

<table align="center" width="100%" height="100%" border="0" cellpadding="0" cellspacing="1" class="messageTable">
<tbody>

    <tr class="messageTableTr">
        <td class="messageTableTd" valign="top" >
            <table width="100%" border="0" cellpadding="0" cellspacing="0" id="TaskPushId">
             <tr><td colspan="3" height="2"></td></tr>
             <c:forEach items="${taskList }" var="o">
                 <tr height="35px" valign="middle">
                         <!-- 0:未读 -->
                         <c:if test="${o.sfck ==0 }" >
		                    <td width="5%"><div class="divMessageRead1" title="未读"></div></td>
		                   	<!-- 2:业务协同 -->
                            <c:if test="${o.xxlb ==2 }" >
                            	<c:choose>
                            		<c:when test="${o.dkfs == 1}">
                            			<td width="65%" class="messageContentTd1"><a href="#" title="${o.xxbt }" onclick="openTabPage('${o.ywurl }')" style="line-height: 25px"><font color="#009900">[${o.xxbt}]</font>&nbsp;${o.xxnr }</a></td>
                            		</c:when>
                            		<c:otherwise>
                            			<td width="65%" class="messageContentTd1"><a href="#" title="${o.xxbt }" onclick="ywxtgzrwb('${o.ywurl }')" style="line-height: 25px"><font color="#009900">[${o.xxbt}]</font>&nbsp;${o.xxnr }</a></td>
                            		</c:otherwise>
                            	</c:choose>
                            </c:if>
                            <!-- 5:工作任务 -->
                            <c:if test="${o.xxlb ==5 }" >
                            	<c:choose>
                            		<c:when test="${o.dkfs == 1}">
                            			<td width="65%" class="messageContentTd1"><a href="#" title="${o.xxbt }" onclick="openTabPage('${o.xxbt}', '${o.ywurl}')" style="line-height: 25px"><font color="#009900">[${o.xxbt}]</font>&nbsp;${o.xxnr }</a></td>
                            		</c:when>
                            		<c:otherwise>
		                            	<td width="65%" class="messageContentTd1"><a href="#" title="${o.xxbt }" onclick="openWindow('${o.xxbt }', '${o.ywurl }')" style="line-height: 25px"><font color="#009900">[${o.xxbt }]</font>&nbsp;${o.xxnr }</a></td>
                            		</c:otherwise>
                            	</c:choose>
                            </c:if>
                              <!-- 6:打开menu页面 -->
                            <c:if test="${o.xxlb ==6 }" >
		                            	<td width="65%" class="messageContentTd1"><a href="#" title="${o.xxbt }" onclick="openMenuWindow('${o.xxbt }', '${o.ywurl }')" style="line-height: 25px"><font color="#009900">[${o.xxbt }]</font>&nbsp;${o.xxnr }</a></td>
                            </c:if>
                            <td width="35%" class="messageContentTd1" >&nbsp;${o.fssj }</td>
		                </c:if>
		                
		               
                        
                 </tr>
              </c:forEach>
             </table>
        </td>
    </tr>
</table>

</body>
</HTML>
