<%@page language="java" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page import="com.founder.framework.message.bean.SysMessage"%>

<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/global.js" ></script>
<link href="<%=contextPath%>/common/skin/firstPage.css" type="text/css" rel="stylesheet" >
<HTML>
<HEAD>
<TITLE></TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</HEAD>
<script language="JavaScript">

// 菜单链接
function menuLink(menuName, openURL) {
   try {
      if (menuName == "" || openURL == "") {
         return;
      }
      var menuNameLink = "";
      if (openURL.indexOf("?") == -1) {
         menuNameLink = "?";
      }
      else {
         menuNameLink = "&";
      }
      if (IE) {
         top.document.frames["main_frame"].main_center.main_tabTitle.tabTitle_add(menuName, openURL + menuNameLink + "menuName=" + menuName, true);
      }
      else {
         var main_center = top.document.getElementById("main_frame").contentWindow.frames.document.getElementById("main_center");
         var main_tabTitle = main_center.contentWindow.frames.document.getElementById("main_tabTitle");
         main_tabTitle.contentWindow.tabTitle_add(menuName, openURL + menuNameLink + "menuName=" + menuName, true);
      }
   }
   catch (err) {}     
}

function title_onclick(xxID) {
	
  window.top.openWindow(false,'', '<%=contextPath %>' +"/sysMessage/view?id="+xxID, {document: document}, {title: '消息信息',    
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
function more_click() {
    menu_open("个人信息查看", "/forward/message|sysMessage");
}
//弹出窗口打开!
function title_onclick2(xxID,str) {
	//先更新查看状态;
	updateTzggZt(xxID);
	var strArray =new Array;
	if(str.indexOf("?")>0){
		strArray = str.split("?");
	
		var url = '<%=contextPath %>' +"/tzgg/tzggInfo?id="+strArray[0]+"&mode=inFo&xxID="+xxID;
		window.open(url,'通知公告',"");
	}else{
		var url = '<%=contextPath %>' +"/tzgg/tzggInfo?id="+str+"&mode=inFo&xxID="+xxID;
		window.open(url,'通知公告',"");
	}
}

function hrefUrl(xxID,url){
	//先更新查看状态;
	updateTzggZt(xxID);
	
	window.open(url,'通知公告',"");
}

//ajax修改查看消息的状态
function updateTzggZt(xxid){
    $.ajax({
       type:"POST",
       url :contextPath+"/tzgg/view",
       data:{id:xxid},
       dataType:'json',
       success:function(data){
    	   
       }
    });
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

function subStr(str,url){
	var strArray =new Array;
	//str =str.replace(/数据主键/g," ");
	if(url.indexOf("?")>0){
		strArray = url.split("?");
		//strArray[0] = strArray[0].substring(0,str.indexOf("?"));
		return queryFj(str ,strArray[0]);
		//if(fjhtml!=""){
			//return strArray[0] +"&nbsp;&nbsp;&nbsp;&nbsp;<span style='color:#0000FF;font-weight:bold' id='fjhtml'>"+fjhtml+"</span>" ;
		//}
	}else{
		return queryFj(str ,url);
		//return str +"";
	}
}
function queryFj(xxnr,id){
	var html ="";
	if(id!=""){
		$.ajax({
			type:"GET",
			async:false,
			sync:true,
			url:contextPath+"/tzgg/queryFj",
			data:{lybm:'SYS_TZGGB',lyid:id},
			dataType:'json',
			success:function(json){
				for(var i=0;i<json.length;i++){
					var fjid= json[i].id+"";
					html+="<a href='javascript:void(0);' style='color:#007BE3;font-weight:bold' onclick='downLoad(\""+fjid+"\")'>&nbsp;&nbsp;[附件"+(i+1)+"]</a>&nbsp;&nbsp;";
				}
			}
		});
	}
	return  xxnr +"&nbsp;&nbsp;&nbsp;&nbsp;"+html;
}

function downLoad(id){
	$('#downloadID').val(id);
	$('#downloadform').form('submit', {
		success: function(result) {
			if (result) {
				result = parseReturn(result);
				if (result.status == 'success') {
				}
				else {
					topMessager.alert('', result.message);
				}
			}
		}
	});

}

function replaceContent(content){
	if(content!=null && content !=""){
		if(content=="3"){
			return "通知";
		}else if(content=="4"){
			return "通报";
		}
	}
	
}
</script>

<body class="messageBody">



<table align="center" width="100%" height="100%" border="0" cellpadding="0" cellspacing="1" class="messageTable">
<tbody>
    <tr class="messageTableTr">
        <td class="messageTableTd" valign="top" >
              <table width="100%" border="0" cellpadding="0" cellspacing="0">
             <tr><td colspan="3" height="2"></td></tr>
               <c:forEach items="${infoList }" var="o">
                  <tr height="35px" valign="middle">
		                 <c:if test="${o.sfck ==0 }" >
		                    <td width="5%"><div class="divMessageRead1" title="未读"></div></td>
		                    <c:choose>
		                    	<c:when test="${o.bool==1 }">
		                    	<td width="73%" class="messageContentTd1"><a href="javascript:void(0)" onclick="hrefUrl('${o.id }','${ o.ywurl}')" title="${o.xxbt }"  style="line-height: 25px">
		                    	<font color="#009900">[<script type="text/javascript">
			                    		document.write(replaceContent('${o.xxlb}'));
			                    	</script>]</font>&nbsp;
			                    	<font style="font-weight:bold;">
			                    	 
			                    	<script type="text/javascript">
			                    		document.write(subStr('${o.xxnr}','${o.ywurl}'));
			                    	</script>
			                    	
			                    	</font>
		                    	</a>
		                    		<img alt="" src="<%=contextPath%>/images/new.gif">
		                    	</td>
		                    	</c:when>
		                    	<c:otherwise>
		                    	<td width="73%" class="messageContentTd1">
		                    	<a href="#" title="${o.xxbt }" onclick="title_onclick2('${o.id }','${o.ywurl}')" style="line-height: 25px">
		                    	<font color="#009900">[<script type="text/javascript">
			                    		document.write(replaceContent('${o.xxlb}'));
			                    	</script>]</font>&nbsp;
			                    	
			                    	<font style="font-weight:bold;">
			                    	<script type="text/javascript">
			                    		document.write(subStr('${o.xxnr}','${o.ywurl}'));
			                    	</script>
			                    	</font>
		                    	</a>
		                    		<img alt="" src="<%=contextPath%>/images/new.gif">
		                    	</td>
		                    	</c:otherwise>
		                    </c:choose>
                            <td width="22%" class="messageContentTd1">${o.fssj }</td>
		                </c:if>
		                
		                 <c:if test="${o.sfck ==1 }" >
                            <td width="5%"><div class="divMessageRead2" title="已读"></div></td>
                            
                            
		                    <c:choose>
		                    	<c:when test="${o.bool==1  }">
		                    	<td width="73%" class="messageContentTd1">
		                    	<a href="javascript:javascript:void(0)" onclick="hrefUrl('${o.id }','${ o.ywurl}')" title="${o.xxbt }"  style="line-height: 25px">
		                    	<font color="#009900">[<script type="text/javascript">
			                    		document.write(replaceContent('${o.xxlb}'));
			                    	</script>]</font>&nbsp;
		                    	
			                    	<script type="text/javascript">
			                    		document.write(subStr('${o.xxnr}','${o.ywurl}'));
			                    	</script>
		                    	</a>
		                    	</td>
		                    	</c:when>
		                    	<c:otherwise>
		                    	<td width="73%" class="messageContentTd1"><a href="#" title="${o.xxbt }" onclick="title_onclick2('${o.id }','${o.ywurl}')" style="line-height: 25px">
		                    	
		                    	<font color="#009900">[<script type="text/javascript">
			                    		document.write(replaceContent('${o.xxlb}'));
			                    	</script>]
			                    </font>&nbsp;
			                    
			                    <script type="text/javascript">
			                    		document.write(subStr('${o.xxnr}','${o.ywurl}'));
			                    </script>
			                    	
		                    	</a>
		                    	</td>
		                    	</c:otherwise>
		                    </c:choose>
                            <td width="22%" class="messageContentTd1" >${o.fssj }</td>
		                </c:if>
                       
                 </tr>
              </c:forEach>
             </table> 
           
        </td>
    </tr>
</table>

 <div style="display:none;">
	    <form name="downloadform" id="downloadform" action="<%=basePath%>zpfjFjxxb/download" target="submitFrame" method="post">
	    <input type="hidden" name="id" id="downloadID"/>
	    </form>
	</div>
</body>
</HTML>
