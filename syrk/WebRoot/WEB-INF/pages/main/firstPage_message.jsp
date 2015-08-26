<%@	page language="java" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@	include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@	taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@	taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@	page import="com.founder.framework.message.bean.SysMessage"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ page import="com.founder.framework.config.SystemConfig"%>
<%
	SessionBean userInfo = (SessionBean) session.getAttribute("userSession");
	String userID = "";
	String userOrgCode = "";
	if(userInfo != null){
		userID = userInfo.getUserId();
		userOrgCode = userInfo.getUserOrgCode();
	}
%>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/global.js" ></script>
<link href="<%=contextPath%>/common/skin/firstPage.css" type="text/css" rel="stylesheet" >
<HTML>
<HEAD>
<TITLE></TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</HEAD>
<script language="JavaScript">
var userOrgCode = "<%=userOrgCode%>";
function title_onclick(xxID,xxbt,ywurl) {
  editMsgStar(xxID);
  if(xxbt=="标准地址维护"){
	  var editUrl = contextPath + '/sysMessage/view?id='+xxID;
	  datagridEdit('editWindow', null,
	  		{
	   		title: '消息信息',
	   		url: editUrl,
	   		width: 850,
	   		height: 320
	   		},
	   		'您是否要保存数据？',
	   		xxbt,
	   		ywurl,
	   		xxID
	  );
  }else{
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
}

function more_click(bs) {
    if("通知公告" == bs){
       menu_open(bs, "/forward/message|sysMessage");
    }else if("消息提醒" == bs){
       menu_open(bs, "/forward/message|sysMessage1");
    } else if("巡警" == bs){
       menu_open(bs, "/forward/message|xjsysMessage");
    } else{
       menu_open(bs, "/forward/message|sysMessage2");
    }
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
//datagrid 修改
//默认在本页面中弹出，不缓存页面
//paramArray 可以传入参数（如：{document:document, param1: 'test1', param2: 2}）
//dataOptions jquery.window中的data-options定义参数
//submitConfirm 提交确认提示信息（为空则不出现确认框）
//xxbt 消息标题（用于处理【标准地址维护】判断）
function datagridEdit(windowID, paramArray, dataOptions, submitConfirm,xxbt,ywurl,id) {
	if (!dataOptions.url) {
		topMessagerAlert('', '弹出层缺少 url 参数！');
		return;
	}
	dataOptions.title = '&nbsp;' + dataOptions.title;
	if (!dataOptions.width) {
		dataOptions.width = 850;
	}
	if (!dataOptions.height) {
		dataOptions.height = 420;
	}
	if (!windowID) {
		windowID = "editWindow";
	}
	dataOptions.collapsible = dataOptions.collapsible ? dataOptions.collapsible : false;
	dataOptions.minimizable = dataOptions.minimizable ? dataOptions.minimizable : false;
	dataOptions.maximizable = dataOptions.maximizable ? dataOptions.maximizable : false; // 是否最大化图标
	dataOptions.closable = true;
	dataOptions.closed = false;   
	dataOptions.cache = false;
	dataOptions.inline = false;
	dataOptions.modal = true;
	if(xxbt=="标准地址维护"){
		var zbz = ywurl.split(",");
		if(userOrgCode.substring(8, 12)!="0000"){
			if(zbz[5]=="1"){
				if(zbz[0]==null||zbz[0]==""){
					dataOptions.buttons = [{
           				text: '实有单位编辑',
           				iconCls: 'icon-home',
           				handler: function(){
           					window.top.$('#' + windowID).dialog('close');
           					var editUrl = "/sydwgl/view?id="+zbz[1];
           					menu_open("实有单位编辑",editUrl);
           				}
           			},{
               			text: '地址定位',
               			iconCls: 'icon-biaodian',
               			handler: function(){
               				var url = contextPath+"/forward/map|mapBz?bz=2&title="+encodeURI(zbz[2])+"&zbx="+zbz[3]+"&zby="+zbz[4];
               				var paramArray = [];
               				openWindow(false, null, url, 
               			   		paramArray, 
               			   		{
               				   		title:"地址定位",
               				   		maximizable: false,
               				   		width: 850,	
               				   		height:560
               			   		}
               			   	);
               			}
               		}];
				}else{
					dataOptions.buttons = [{
           				text: '实有人口编辑',
           				iconCls: 'icon-user',
           				handler: function(){
           					window.top.$('#' + windowID).dialog('close');
           					var editUrl = "/syrkEdit/"+zbz[1]+"/"+zbz[0]+"/view";
           					menu_open("实有人口编辑",editUrl);
           				}
           			},{
               			text: '地址定位',
               			iconCls: 'icon-biaodian',
               			handler: function(){
               				var url = contextPath+"/forward/map|mapBz?bz=2&title="+encodeURI(zbz[2])+"&zbx="+zbz[3]+"&zby="+zbz[4];
               				var paramArray = [];
               				openWindow(false, null, url, 
               			   		paramArray, 
               			   		{
               				   		title:"地址定位",
               				   		maximizable: false,
               				   		width: 850,	
               				   		height:560
               			   		}
               			   	);
               			}
               		}];
				}
			}else{
				dataOptions.buttons = [
              			{
              				text: '转发至所长',
              				iconCls: 'icon-user',
              				handler: function(){
              					var editUrl = contextPath + "/sysMessage/viewReply?id="+id+"&hfbz=0";
              					window.top.openWindowWithSave(false, null,this.Window, 
              				   		{}, 
              				   		{
              						title:"转发至所长",
              				   		url: editUrl,
              				   		maximizable: false,
              				   		width: 380,	
                    				height:190
              				   		}, 
              				   		null, null
              					);
              				}
              			},
              			{
              				text: '回复',
              				iconCls: 'tree-leaf',
              				handler: function(){
              					var editUrl = contextPath + "/sysMessage/viewReply?id="+id+"&hfbz=1";
              					window.top.openWindowWithSave(false, null,this.Window, 
              				   		{}, 
              				   		{
              						title:"消息回复",
              				   		url: editUrl,
              				   		maximizable: false,
              				   		width: 380,	
                    				height:190
              				   		}, 
              				   		null, null
              					);
              				}
              			},
              			{
              				text: '打开地址管理',
              				iconCls: 'icon-home',
              				handler: function(){
              					window.top.$('#' + windowID).dialog('close');
              					menu_open('地址管理', "/forward/bzdz|dzManage|dzManage");
              					
              				}
              			},
                  		{
                  			text: '地址定位',
                  			iconCls: 'icon-biaodian',
                  			handler: function(){
                  				var url = contextPath+"/forward/map|mapBz?bz=2&title="+encodeURI(zbz[2])+"&zbx="+zbz[3]+"&zby="+zbz[4];
                  				var paramArray = [];
                  				window.top.openWindow(false, null, url, 
                  			   		paramArray, 
                  			   		{
                  				   		title:"地址定位",
                  				   		maximizable: false,
                  				   		width: 850,	
                  				   		height:560
                  			   		}
                  			   	);
                  			}
                  		}
                  	];
			}
		}else{
			dataOptions.buttons = [
          			{
          				text: '转发至责任区',
          				iconCls: 'icon-user',
          				handler: function(){
          					var editUrl = contextPath + "/sysMessage/viewReply?id="+id+"&hfbz=2";
          					window.top.openWindowWithSave(false, null,this.Window, 
          				   		{}, 
          				   		{
          						title:"转发至责任区",
          				   		url: editUrl,
          				   		maximizable: false,
          				   		width:400,	
                				height:290
          				   		}, 
          				   		null, null
          					);
          				}
          			},
               		{
               			text: '地址定位',
               			iconCls: 'icon-biaodian',
               			handler: function(){
               				var url = contextPath+"/forward/map|mapBz?bz=2&title="+encodeURI(zbz[2])+"&zbx="+zbz[3]+"&zby="+zbz[4];
               				var paramArray = [];
               				window.top.openWindow(false, null, url, 
               			   		paramArray, 
               			   		{
               				   		title:"地址定位",
               				   		maximizable: false,
               				   		width: 850,	
               				   		height:560
               			   		}
               			   	);
               			}
               		}
               	];
		}
		
	}else{
		dataOptions.buttons = [
      		{
      			text: '上一条',
      			iconCls: 'icon-moveLeft',
      			handler: function() {
      				var bottonObject = this;
      				var iframeObject = window.frames[windowID + '_iframe'];
      				if (iframeObject.contentWindow) {
      					iframeObject = iframeObject.contentWindow;
      				}
      				iframeObject.viewPrev();
      			}
      		},
      		{
      			text: '下一条',
      			iconCls: 'icon-moveRight',
      			handler: function() {
      			   var iframeObject = window.frames[windowID + '_iframe'];
      				if (iframeObject.contentWindow) {
      					iframeObject = iframeObject.contentWindow;
      				}
      				iframeObject.viewNext();
      			}
      		}
      	];
	}
	window.top.openWindow(false, windowID, dataOptions.url, paramArray, dataOptions);
}
</script>

<body class="messageBody">

<table align="center" width="100%" height="100%" border="0" cellpadding="0" cellspacing="1" class="messageTable">
<tbody>
   <!--  <tr class="messageTableTr">
        <td class="messageTableTitleBg">
            <table width="100%" height="25" border="0" cellpadding="0" cellspacing="0">
            <tr>
               <td width="20" class="messageTableTitleIcon"></td>
               <td width="280" class="messageTableTitleText">个人消息查看</td>
               <td width="50" class="messageTableTitleText" align="right"><a href="#" onclick="more_click()">更多 >></a>&nbsp;</td>
            </tr>
            </table>
        </td>
    </tr> -->
    <tr class="messageTableTr">
        <td class="messageTableTd" valign="top" >
              <table width="100%" border="0" cellpadding="0" cellspacing="0">
             <tr><td colspan="3" height="2"></td></tr>
               <c:forEach items="${msgList }" var="o">
                  <tr height="35px" valign="middle">
		                <c:if test="${o.sfck ==0 }" >
		                    <td width="5%"><div class="divMessageRead1" title="未读"></div></td>
		                    <td width="73%" class="messageContentTd1"><a href="javascript:void(0)" title="${o.xxbt }" onclick="title_onclick('${o.id }','${o.xxbt}','${o.ywurl}')" style="line-height: 25px"><font color="#009900">[${o.xxbt}]</font>&nbsp;${o.xxnr }</a></td>
                            <td width="22%" class="messageContentTd1">&nbsp;${o.fssj }</td>
		                </c:if>
		                 <c:if test="${o.sfck ==1 }" >
		                    <td width="5%"><div class="divMessageRead2" title="已读"></div></td>
		                    <td width="73%" class="messageContentTd2"  onclick="title_onclick('${o.id }','${o.xxbt}','${o.ywurl}')" style="cursor: pointer;line-height: 25px">&nbsp;<font color="#009900" >[${o.xxbt}]</font>&nbsp;${o.xxnr }</td>
                            <td width="22%" class="messageContentTd1" >&nbsp;${o.fssj }</td>
		                </c:if>  
                 </tr>
              </c:forEach>
             </table> 
           
        </td>
    </tr>
</table>

</body>
</HTML>