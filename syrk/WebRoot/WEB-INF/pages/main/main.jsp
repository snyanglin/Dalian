<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.founder.xjpt.controller.XjController"%>  
<%@page import="com.founder.framework.organization.right.service.OrgRightPublic"%>
<%@page import="com.founder.framework.organization.right.vo.*" %>
<%@page import="java.util.*" %>
<%@include file="/WEB-INF/pages/common.jsp"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@page import="com.founder.framework.base.entity.SessionBean"%>
<%
String httpURI = "http://10.80.5.228:9080/DLGA_XJPT_V2";
httpURI = new XjController().getURL();
SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
String userID = "";
String password = "";
String userName = "";
String userOrgName = "";
Long userPk = new Long(0);
String userOrgCode = "";
String ipdz = "";
String theme = "";
if (userInfo != null) {
   userPk = userInfo.getUserPk();
   userID =  userInfo.getUserId();
   password = userInfo.getPassword();
   if (password == null) {
      password = "";
   }
   userName =  userInfo.getUserName();
   userOrgName = userInfo.getUserOrgName();
   userOrgCode = userInfo.getUserOrgCode();
   ipdz = userInfo.getRemoteAddr();
   theme = userInfo.getTheme();
}

//定义数组，存放二级 菜单数据
String[][] menuArray=new String[20][2];  
for (int i=0;i<menuArray.length;i++){
   for (int j=0;j<2;j++){
        menuArray[i][j]="";
        
   }
}
// 局长专用数据
OrgRightPublic orgRightPublic = new OrgRightPublic();
		List<OrgMenuSystemInfo> dhList = orgRightPublic.getUserMenu(
				userInfo, "dhxt");
		List<OrgMenuInfo>	omi=new ArrayList<OrgMenuInfo>();
		List<OrgMenuInfo>	tt=new ArrayList<OrgMenuInfo>();
		String temp="";
		if (dhList.size() > 0 && dhList != null) {
		   for (int i = 0; i < dhList.size(); i++) {
				OrgMenuSystemInfo webLink = (OrgMenuSystemInfo) dhList.get(i);
				  omi=  webLink.getMenuList();  
				  for(int j=0;j<omi.size();j++){
				       OrgMenuInfo  t1= (OrgMenuInfo) omi.get(j);
				       // menuArray[j][0]=t1.getMenuname()+","+t1.getMenuurl();
				          menuArray[j][0]=t1.getMenuname();
				          tt=t1.getMenuList();
				       temp="";
				       for (int k=0;k<tt.size();k++){
				            OrgMenuInfo t2=(OrgMenuInfo) tt.get(k);
				            // temp+= (t2.getMenuname()+" "+t2.getMenutype());
				            temp+=t2.getMenuname()+","+t2.getMenuurl()+";"; 
				       }
				       if (temp.length()>0){
				           temp=temp.substring(0,temp.length()-1);
				       }
				      // out.println(temp+"<br>");
				       menuArray[j][1]= temp;				       
				  }				
			}
		}
	
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/mainFrame.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/windowTopPage.js"></script>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/common/skin/main.css">
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/main.css">
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/common/skin/style.css">
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/body.css">

<script type="text/javascript" src="<%=contextPath%>/common/layer/layer.min.js"></script>

<script type="text/javascript" src="<%=contextPath%>/common/websocket/jWebSocket.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/websocket/jwsMosPlugIn.js"></script>
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
	
<HTML>
<HEAD>
<TITLE><%=SystemConfig.getString("systemOrganization")%>－<%=SystemConfig.getString("systemName")%></TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
  body{font-family:Verdana,Arial,Helvetica,sans-serif;font-size:12px;line-height:1.5;}
  #menu ul{margin:0;padding:0;list-style:none;border:0px solid #67a0ff;width:100px;}
  #menu ul li{background-color:#007be3;color:#ffffff; height:26px;line-height:26px;border-bottom:1px solid #67a0ff;position:relative;}
  #menu ul li a{color:#ffffff;text-decoration:none}
  #menu ul li a:hover{color:#FF0000;}
  
  #menu ul li ul{display:none;position:absolute;left:100px;top:0px;}
  #menu ul li.current ul{display:block;}
  
  #menus ul{margin:0;padding:0;list-style:none;border:0px solid #67a0ff;width:100px;}
  #menus ul li{background-color:#007be3;color:#ffffff; height:26px;line-height:26px;border-bottom:1px solid #67a0ff;position:relative;}
  #menus ul li a{color:#ffffff;text-decoration:none}
  #menus ul li a:hover{color:#FF0000;}
  
  #menus ul li ul{display:none;position:absolute;left:100px;top:0px;}
  #menus ul li.current ul{display:block;}
  
</style>
</HEAD>

<SCRIPT language=JavaScript>
var mainLeftFrameCount = 1; // 左边框架中包含页面的总数
var mainLeftFrameOpened = 1; // 左边框架中当前打开的第几个页面

// session 相关数据
var sessionUserID = "<%=userID%>";
var sessionPassword = "<%=password%>";
var sessionUserOrgCode = "<%=userOrgCode%>";
var theme = "<%=theme%>";
function body_resize() {
   document.getElementById("divShadow").style.width = window.document.body.clientWidth;
   document.getElementById("divShadow").style.height = window.document.body.clientHeight;
   var lockTableObject = document.getElementById("lockTable");
   lockTableObject.style.top = Math.floor((window.document.body.clientHeight - 114) / 2);
   lockTableObject.style.left = Math.floor((window.document.body.clientWidth - 335) / 2);
   
   var showDiv = document.getElementById("showRightDiv");
   if("none" != showDiv.style.display){
     showDysCalendar();
   }
}

function lock() {
   document.getElementById("divShadow").style.display = "block";
   document.getElementById("lockTable").style.display = "block";
   document.getElementById("password").value = "";
   document.getElementById("password").focus();
}

function checkPassword(e) {
   e = e || window.event;
   var keyCode;
   if (IE) { 
      keyCode = e.keyCode;
   }
   else { 
      keyCode = e.which;
   }
   if (keyCode == 13) { // 回车
      getPassword();
      if (document.getElementById("password").value == lockPassword) {
         document.getElementById("divShadow").style.display = "none";
         document.getElementById("lockTable").style.display = "none";
      }
      else {
         document.getElementById("errorTd").innerHTML = "输入密码错误，请重新输入！";
         document.getElementById("password").value = "";
         setTimeout("disappear();", 3000);
      }
   }
}

function disappear() {
   document.getElementById("errorTd").innerHTML = "";
}
//显示DIV层
function showDysCalendar(){
	var trigger="";
	if(IE){
		trigger= document.frames['main_frame'].frames['main_top'].document.getElementById("userImg");
	}else{
		var obj1= parent.frames.document.getElementById("main_frame").contentWindow;
		trigger = obj1.document.getElementById("main_top").contentWindow.document.getElementById("userImg")
	}
	var l = trigger.offsetLeft;
	var t = trigger.offsetTop;
	var vParent = trigger.offsetParent;
	while (vParent.tagName.toUpperCase() != "BODY"){
		l += vParent.offsetLeft;
		t += vParent.offsetTop;
		vParent = vParent.offsetParent;
	}
	 var showDiv = document.getElementById("showRightDiv");
	//var showDiv = document.getElementById("showRightDivNew");
	if(IE){
		$("#showRightDiv").show("slow");
	}else{
		showDiv.style.display = "block";
	}
	//
	var nowLeft = l-45;
	var nowTop = t;
	if((nowLeft + 150) < document.body.clientWidth){
	  showDiv.style.left = document.body.clientWidth-240;
	}else{
	  showDiv.style.left = nowLeft - 150 ; 
	}
	if((nowTop + 62) < document.body.clientHeight){
	  showDiv.style.top = nowTop+53;
	}else{
	  showDiv.style.top = nowTop +53;
	}
	userAjax();
};

//显示DIV层
function showDysCalendar_jz(){
	var trigger="";
	if(IE){
		trigger= document.frames['main_frame'].frames['main_top'].document.getElementById("userImg");
	}else{
		var obj1= parent.frames.document.getElementById("main_frame").contentWindow;
		trigger = obj1.document.getElementById("main_top").contentWindow.document.getElementById("userImg")
	}
	var l = trigger.offsetLeft;
	var t = trigger.offsetTop;
	var vParent = trigger.offsetParent;
	while (vParent.tagName.toUpperCase() != "BODY"){
		l += vParent.offsetLeft;
		t += vParent.offsetTop;
		vParent = vParent.offsetParent;
	}
	 var showDiv = document.getElementById("showRightDiv");
	//var showDiv = document.getElementById("showRightDivNew");
	if(IE){
		$("#showRightDiv").show("slow");
	}else{
		showDiv.style.display = "block";
	}
	//
	var nowLeft = l-45;
	var nowTop = t;
	if((nowLeft + 150) < document.body.clientWidth){
	  showDiv.style.left = nowLeft-30;
	}else{
	  showDiv.style.left = nowLeft - 150 ; 
	}
	if((nowTop + 62) < document.body.clientHeight){
	  showDiv.style.top = nowTop+53;
	}else{
	  showDiv.style.top = nowTop +53;
	}
	userAjax();
};

//显示DIV层
function showDysCalendar_jz(){
	var trigger="";
	if(IE){
		trigger= document.frames['main_frame'].frames['main_top'].document.getElementById("userImg");
	}else{
		var obj1= parent.frames.document.getElementById("main_frame").contentWindow;
		trigger = obj1.document.getElementById("main_top").contentWindow.document.getElementById("userImg")
	}
	var l = trigger.offsetLeft;
	var t = trigger.offsetTop;
	var vParent = trigger.offsetParent;
	while (vParent.tagName.toUpperCase() != "BODY"){
		l += vParent.offsetLeft;
		t += vParent.offsetTop;
		vParent = vParent.offsetParent;
	}
	 var showDiv = document.getElementById("showRightDiv");
	//var showDiv = document.getElementById("showRightDivNew");
	if(IE){
		$("#showRightDiv").show("slow");
	}else{
		showDiv.style.display = "block";
	}
	//
	var nowLeft = l-45;
	var nowTop = t;
	if((nowLeft + 150) < document.body.clientWidth){
	  showDiv.style.left = nowLeft-30;
	}else{
	  showDiv.style.left = nowLeft - 150 ; 
	}
	if((nowTop + 62) < document.body.clientHeight){
	  showDiv.style.top = nowTop+53;
	}else{
	  showDiv.style.top = nowTop +53;
	}
	userAjax();
};

//隐藏DIV层
function hiddenCalendar(){
   var showDiv = document.getElementById("showRightDiv");
   //var showDiv = document.getElementById("showRightDivNew");
  if(IE){
  $("#showRightDiv").hide("slow");
	//  $("#showRightDivNew").hide("slow");
  }else{
	  showDiv.style.display = "none";
  }
   //
   
}

//局长页面专用
//显示DIV层
function showDysCalendar_menu(){
	var trigger="";
	if(IE){
		trigger= document.frames['main_frame'].frames['main_top'].document.getElementById("userImg");
	}else{
		var obj1= parent.frames.document.getElementById("main_frame").contentWindow;
		trigger = obj1.document.getElementById("main_top").contentWindow.document.getElementById("userImg")
	}
	var l = trigger.offsetLeft;
	var t = trigger.offsetTop;
	var vParent = trigger.offsetParent;
	while (vParent.tagName.toUpperCase() != "BODY"){
		l += vParent.offsetLeft;
		t += vParent.offsetTop;
		vParent = vParent.offsetParent;
	}
	 var showDiv = document.getElementById("menu");
	//var showDiv = document.getElementById("showRightDivNew");
	if(IE){
		$("#menu").show("slow");
	}else{
		showDiv.style.display = "block";
	}
	//
	var nowLeft = l-32;
	var nowTop = t;
	if((nowLeft + 150) < document.body.clientWidth){
	  showDiv.style.left = nowLeft-30;
	}else{
	  showDiv.style.left = nowLeft - 150 ; 
	}
	if((nowTop + 62) < document.body.clientHeight){
	  showDiv.style.top = nowTop+60;
	}else{
	  showDiv.style.top = nowTop +60;
	}
	
	
	//userAjax();
};

//巡警平台专用
//显示DIV层
function showXjCalendar_menu(){
	var trigger="";
	if(IE){
		trigger= document.frames['main_frame'].frames['main_top'].document.getElementById("userImg");
	}else{
		var obj1= parent.frames.document.getElementById("main_frame").contentWindow;
		trigger = obj1.document.getElementById("main_top").contentWindow.document.getElementById("userImg")
	}
	var l = trigger.offsetLeft;
	var t = trigger.offsetTop;
	var vParent = trigger.offsetParent;
	while (vParent.tagName.toUpperCase() != "BODY"){
		l += vParent.offsetLeft;
		t += vParent.offsetTop;
		vParent = vParent.offsetParent;
	}
	 var showDiv = document.getElementById("menus");
	//var showDiv = document.getElementById("showRightDivNew");
	if(IE){
		$("#menus").show("slow");
	}else{
		showDiv.style.display = "block";
	}
	//
	var nowLeft = l-32;
	var nowTop = t;
	if((nowLeft + 150) < document.body.clientWidth){
	  showDiv.style.left = nowLeft+50;
	}else{
	  showDiv.style.left = nowLeft - 150 ; 
	}
	if((nowTop + 62) < document.body.clientHeight){
	  showDiv.style.top = nowTop+60;
	}else{
	  showDiv.style.top = nowTop +60;
	}
	
	
	//userAjax();
};

//隐藏巡警DIV层
function hiddenXjCalendar_menu(){
   
   var showDiv = document.getElementById("menus");
   //var showDiv = document.getElementById("showRightDivNew");
  if(IE){
  $("#menus").hide("slow");
	//  $("#showRightDivNew").hide("slow");
  }else{
	  showDiv.style.display = "none";
  }
   //
   
}

//隐藏DIV层
function hiddenCalendar_menu(){
   
   var showDiv = document.getElementById("menu");
   //var showDiv = document.getElementById("showRightDivNew");
  if(IE){
  $("#menu").hide("slow");
	//  $("#showRightDivNew").hide("slow");
  }else{
	  showDiv.style.display = "none";
  }
   //
   
}
function getShowDiv(){
  return document.getElementById("menu");
}


//ajax调用
function userAjax(){
   var idValue = '<%=userPk%>';
  $.ajax({
          type:"POST",
           url:"<%=basePath%>LoginPage/getUser",
           data:"id="+idValue,
           dataType:"json",
           success:function(data){
               if(null != data.alarm && typeof undefined != data.alarm){
                  document.getElementById("alarm").value = data.alarm;
               }
               if(null != data.password && typeof undefined != data.password){
                 // document.getElementById("psword").value = data.password;
               }
               if(null != data.mobilephone && typeof undefined != data.mobilephone){
                  document.getElementById("mobilephone").value = data.mobilephone;
               }
               if(null != data.telephone && typeof undefined != data.telephone){
                  document.getElementById("telephone").value = data.telephone;
               }
               if(null != data.theme && typeof undefined != data.theme){
                   $("input[name=theme][value="+data.theme+"]").attr("checked",true);
                }
           }
  });
}


function RefreshPage(){
	topMessager.confirm('', '当前主题设置已经更变您是否要重新载入当前页面？', function(r) {
		if (r) {
			location.reload();
		}
	});
}


//ajax修改人员信息
function editUser(){
  var formObject = $('form');
  //主题
  var theme = $('input[name="theme"]:checked').val();
  if (formObject.form('validate')) {
  	var idValue = '<%=userPk%>';
    $.ajax({
       type:"POST",
       url :"<%=basePath%>LoginPage/editUser",
       data:{id:idValue,alarm:$("#alarm").val(),
             mobilephone:$("#mobilephone").val(),telephone:$("#telephone").val(),
             theme:theme,
             xt_zhxgip:'<%=ipdz%>',xt_zhxgrxm:'<%=userName%>',xt_zhxgrid:'<%=userID%>',
             xt_zhxgrbm:'<%=userOrgName%>',xt_zhxgrbmid:'<%=userOrgCode%>'},
       dataType:"json",
       success:function(data){
			topMessager.show({
				title: MESSAGER_TITLE,
				msg: '保存成功！',
				timeout:1500
			});
         hiddenCalendar();
         RefreshPage();
       }
    });
  }
}

var totalUploadIdArray;//弹出新增工作纪实附件窗口的文件id数组
var isUploadSubmited;//弹出新增工作纪实附件窗口的提交标识
function addGzjsUploadEvent(){
	totalUploadIdArray = new Array();
	isUploadSubmited = false;
	if($('#addGzjsdmtWindow')){
		$('#addGzjsdmtWindow').window({
	   		onClose:function(){
	   			$(this).dialog('destroy');
	   			if(!isUploadSubmited){//未保存情况下的关闭，清空附件临时文件
					$.ajax({
						url:"<%= basePath%>gzjs/deleteTmpFileWithCancel?idArrayStr="+totalUploadIdArray.join()
					});
				}
	   		}
   		});
	}
}

</SCRIPT>

<BODY scroll="no" topmargin="0" leftmargin="0" rightmargin="0" bottommargin="0" 
   style="BORDER-RIGHT: 0px none; BORDER-TOP: 0px none; MARGIN: 0px; BORDER-LEFT: 0px none; BORDER-BOTTOM: 0px none; overflow: hidden;"
   onselectstart="return false;" oncontextmenu="return false;" onresize="body_resize();" >
   
<IFRAME id="main_frame" src="<%=contextPath%>/forward/main|main_frame" frameborder="0" scrolling="no" style="WIDTH: 100%; HEIGHT: 100%"></IFRAME>

<DIV id="divShadow" style="z-index:255; display:none; background: Silver; filter:alpha(opacity=75); -moz-opacity: 0.75;
    position:absolute; left:0; top:0; width:0px; height:0px;">
</DIV>

<table id="lockTable" border="0" cellpadding="0" cellspacing="0" class="lockTable" style="z-index:256; display:none; position:absolute; left:10px; top:0;">
  <tr><td colspan="2" style="height:45px"></td></tr>
  <tr><td width="145"></td>
     <td valign="top" height="22"><input type="password" id="password" style="height:22; width: 170;padding-top:3px;" onKeyPress="checkPassword(event);"></td></tr>
  <tr><td colspan="2" id="errorTd" style="padding-top: 12px; padding-left: 15px; color: #ec0112;" align="center" valign="top"></td></tr>
</table>


<table id ="userInfo">
       <tr>
       <td >
         <div id='menu' style='display: none;overflow:hidden;width:210px;height:650px;POSITION: absolute;z-index:9;' >
			 <ul>
			<%for (int i=0;i<20;i++){
			      if (!"".equals(menuArray[i][0])){
			          %>
			  
			   <li class=""><a href="#">&nbsp;&nbsp;<%=menuArray[i][0] %></a>
			      <ul>	
			      <%
			         if (menuArray[i][1].length()>0){ 
			              String[] str1=  menuArray[i][1].split(";");
			              
			              for (int j=0;j<str1.length;j++){
			                 String[] str2=str1[j].split(",");
			         %>
					  <li><a href="#"  onclick="menu_open('<%=str2[0] %>','<%=str2[1] %>');">&nbsp;&nbsp;<%=str2[0] %></a></li>
				 <%}
				 } %>	 
			      </ul>
			   </li>
			        
			<%}
					
			} %>
			</ul>	
			
					
	    </div>
	    <div id='menus' style='display: none;overflow:hidden;width:210px;height:650px;POSITION: absolute;z-index:9;' >
			 <ul>
			   <li class=""><a href="#" onclick="menu_open('巡逻路线管理', '<%=httpURI%>/basic/Line.jsp?UserID=<%=userID%>'); hiddenXjCalendar_menu();">&nbsp;&nbsp;巡逻路线管理</a>
			      <ul>	
					  <li><a href="#">&nbsp;&nbsp;巡逻路线管理</a></li>
			      </ul>
			   </li>
			   <li class=""><a href="#" onclick="menu_open('巡逻地点管理', '<%=httpURI%>/basic/Sites.jsp?UserID=<%=userID%>'); hiddenXjCalendar_menu();">&nbsp;&nbsp;巡逻地点管理</a>
			      <ul>	
					  <li><a href="#">&nbsp;&nbsp;巡逻地点管理</a></li>
			      </ul>
			   </li>
			   <li class=""><a href="#" onclick="menu_open('巡检计划设置', '<%=httpURI%>/basic/Plan.jsp?UserID=<%=userID%>'); hiddenXjCalendar_menu();">&nbsp;&nbsp;巡检计划设置</a>
			      <ul>	
					  <li><a href="#">&nbsp;&nbsp;巡检计划设置</a></li>
			      </ul>
			   </li>
			   <li class=""><a href="#" onclick="menu_open('巡逻事件', '<%=httpURI%>/basic/Event.jsp?UserID=<%=userID%>'); hiddenXjCalendar_menu();">&nbsp;&nbsp;巡逻事件</a>
			      <ul>	
					  <li><a href="#">&nbsp;&nbsp;巡逻事件</a></li>
			      </ul>
			   </li>
			   <li class=""><a href="#" onclick="menu_open('巡逻事件卡', '<%=httpURI%>/basic/EventCode.jsp?UserID=<%=userID%>'); hiddenXjCalendar_menu();">&nbsp;&nbsp;巡逻事件卡</a>
			      <ul>	
					  <li><a href="#">&nbsp;&nbsp;巡逻事件卡</a></li>
			      </ul>
			   </li>
			   <li class=""><a href="#" onclick="menu_open('考核项目管理', '<%=httpURI%>/evaluation/EvaluationItem_List.jsp?UserID=<%=userID%>'); hiddenXjCalendar_menu();">&nbsp;&nbsp;考核项目管理</a>
			      <ul>	
					  <li><a href="#">&nbsp;&nbsp;考核项目管理</a></li>
			      </ul>
			   </li>
			   <li class=""><a href="#" onclick="menu_open('考核项目类型管理', '<%=httpURI%>/evaluation/EvaluationItemType_List.jsp?UserID=<%=userID%>'); hiddenXjCalendar_menu();">&nbsp;&nbsp;考核项目类型</a>
			      <ul>	
					  <li><a href="#">&nbsp;&nbsp;考核项目类型</a></li>
			      </ul>
			   </li>
			   <li class=""><a href="#" onclick="menu_open('执法记录仪信息维护', '<%=httpURI%>/data/RecorderLogs.jsp?UserID=<%=userID%>'); hiddenXjCalendar_menu();">&nbsp;&nbsp;记录仪信息维护</a>
			      <ul>	
					  <li><a href="#">&nbsp;&nbsp;记录仪信息维护</a></li>
			      </ul>
			   </li>
			   <li class=""><a href="#" onclick="menu_open('巡逻员管理', '<%=httpURI%>/basic/Employee.jsp?UserID=<%=userID%>'); hiddenXjCalendar_menu();">&nbsp;&nbsp;巡逻员管理</a>
			      <ul>	
					  <li><a href="#">&nbsp;&nbsp;巡逻员管理</a></li>
			      </ul>
			   </li>
			   <li class=""><a href="#" onclick="menu_open('巡逻员查询', '<%=httpURI%>/basic/EmployeeSearch.jsp?UserID=<%=userID%>'); hiddenXjCalendar_menu();">&nbsp;&nbsp;巡逻员查询</a>
			      <ul>	
					  <li><a href="#">&nbsp;&nbsp;巡逻员查询</a></li>
			      </ul>
			   </li>
			   <li class=""><a href="#" onclick="menu_open('巡逻员审批', '<%=httpURI%>/basic/EmployeeApprove.jsp?UserID=<%=userID%>'); hiddenXjCalendar_menu();">&nbsp;&nbsp;巡逻员审批</a>
			      <ul>	
					  <li><a href="#">&nbsp;&nbsp;巡逻员审批</a></li>
			      </ul>
			   </li>
			   <li class=""><a href="#" onclick="menu_open('巡逻车管理', '<%=httpURI%>/basic/PoliceCar.jsp?UserID=<%=userID%>'); hiddenXjCalendar_menu();">&nbsp;&nbsp;巡逻车管理</a>
			      <ul>	
					  <li><a href="#">&nbsp;&nbsp;巡逻车管理</a></li>
			      </ul>
			   </li>
			   <li class=""><a href="#" onclick="menu_open('巡逻车查询', '<%=httpURI%>/basic/PoliceCarSearch.jsp?UserID=<%=userID%>'); hiddenXjCalendar_menu();">&nbsp;&nbsp;巡逻车查询</a>
			      <ul>	
					  <li><a href="#">&nbsp;&nbsp;巡逻车查询</a></li>
			      </ul>
			   </li>
			   <li class=""><a href="#" onclick="menu_open('巡逻车审批', '<%=httpURI%>/basic/PoliceCarApprove.jsp?UserID=<%=userID%>'); hiddenXjCalendar_menu();">&nbsp;&nbsp;巡逻车审批</a>
			      <ul>	
					  <li><a href="#">&nbsp;&nbsp;巡逻车审批</a></li>
			      </ul>
			   </li>
			   <li class=""><a href="#" onclick="menu_open('执法记录仪', '<%=httpURI%>/data/RecorderManage.jsp?UserID=<%=userID%>'); hiddenXjCalendar_menu();">&nbsp;&nbsp;执法记录仪</a>
			      <ul>	
					  <li><a href="#">&nbsp;&nbsp;执法记录仪</a></li>
			      </ul>
			   </li>
			   <li class=""><a href="#" onclick="menu_open('读取数据', '<%=httpURI%>/data/ReadData.jsp?UserID=<%=userID%>'); hiddenXjCalendar_menu();">&nbsp;&nbsp;读取数据</a>
			      <ul>	
					  <li><a href="#">&nbsp;&nbsp;读取数据</a></li>
			      </ul>
			   </li>
			   <li class=""><a href="#" onclick="menu_open('查询报表', '<%=httpURI%>/data/QueryReport.jsp?UserID=<%=userID%>'); hiddenXjCalendar_menu();">&nbsp;&nbsp;查询报表</a>
			      <ul>	
					  <li><a href="#">&nbsp;&nbsp;查询报表</a></li>
			      </ul>
			   </li>
			   <li class=""><a href="#" onclick="menu_open('历史数据', '<%=httpURI%>/data/HistoryData.jsp?UserID=<%=userID%>'); hiddenXjCalendar_menu();">&nbsp;&nbsp;历史数据</a>
			      <ul>	
					  <li><a href="#">&nbsp;&nbsp;历史数据</a></li>
			      </ul>
			   </li>
			   <li class=""><a href="#" onclick="menu_open('部门负责人', '<%=httpURI%>/basic/DeptLeader.jsp?UserID=<%=userID%>'); hiddenXjCalendar_menu();">&nbsp;&nbsp;部门负责人</a>
			      <ul>	
					  <li><a href="#">&nbsp;&nbsp;部门负责人</a></li>
			      </ul>
			   </li>
			   
			   <li class=""><a href="#" onclick="hiddenXjCalendar_menu();">&nbsp;&nbsp;<font color="red">关闭菜单</font></a>
			      <ul>	
					  <li><a href="#"></a></li>
			      </ul>
			   </li>
			</ul>	
	    </div>
	    
	    
         <div id='showRightDiv' style='display: none;overflow:hidden;width:200px;height:350px;POSITION: absolute;z-index:9;' >
				<table id="userTable" cellpadding="0" cellspacing="0" border="0" width="100%" align="center" class="Border_Color_Div" style="background-color:#fff; border:1px solid #007be3;">
					<tr height="28">
						<td align="right" class="Border_Color_Td_Div" width="30%">
							<!-- <img src="<%=contextPath%>/images/jh.png" style="width:24;height:24;margin-bottom:-5px;"> -->警号：
						</td>
						<td class="Border_Color_Td_Div" width="70%" >	
							<input type='text' maxlength=6 style='width: 90px;' class="easyui-validatebox" name="alarm" id='alarm' value=''>
						</td>
					</tr>
					
					
					<tr height="28">
						<td align='right' class="Border_Color_Td_Div" >
							<!-- <img src="<%=contextPath%>/images/mobile.png" style="width:20;height:20;margin-bottom:-5px;"> -->手机号：
						<td class="Border_Color_Td_Div" width="60%">	
							<input type='text' maxlength=20 style='width: 90px;'  class="easyui-validatebox" data-options="validType:['mobile']"  name="mobilephone" id='mobilephone' value=''>
						</td>
					</tr>
					
					<tr height="28">
						<td align='right' class="Border_Color_Td_Div" width="40%">
							<!-- <img src="<%=contextPath%>/images/phone.png" style="width:24;height:24;margin-bottom:-5px;"> -->办公电话：
						<td class="Border_Color_Td_Div" width="60%">	
							<input type='text' maxlength=20 style='width: 90px;'  class="easyui-validatebox" data-options="validType:['phone']" name="telephone" id='telephone' value=''>
						</td>
					</tr>
					<tr height="28">
						<td colspan='2' align='center' class="Border_Color_Td_Div_1" width="100%">
						<img src="<%=contextPath%>/images/index/face.png" width="21" height="16"  align="middle"/>&nbsp;首页配置</td>
					</tr>
					<tr height="28">
						<td colspan='2' align='center' class="Border_Color_Td_Div_2" width="100%">
							<div class="head_son_title1">功能导航</div>
							<div class="head_zt">
							<input type='radio' name="theme" value ="1_2" id ="theme">主题1
							</div>
						</td>
					</tr>		
					<tr height="28">
						<td colspan='2' align='center' class="Border_Color_Td_Div" width="100%">
						<div class="head_son_title1">社区服务</div>
						<div class="head_zt">
							<input type='radio' name="theme" value ="2_1" id ="theme" checked>社区主页
						</div>
						<!-- 
						<input type='radio' name="theme" value ="2_2" id ="theme" checked>所长主页
						<div class="head_zt">
							<input type='radio' name="theme" value ="2_4" id ="theme" checked>巡警平台
						</div>
						-->
						</td>
					</tr>
					
					<tr height="28">
						<td valign="middle" align='center' colspan="2" class="Border_Color_Td_Div" width="40%">
						<%----<img src="<%=contextPath%>/images/update.png"> <img src="<%=contextPath%>/images/close.png" style="width:24;height:24">--%>
							<font color='white' style='cursor: hand;font-family:微软雅黑' onClick="editUser();">
							<input type="button" class="head_save" value=""/></font>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<font color='white' style='cursor: hand;font-family:微软雅黑' onClick="hiddenCalendar();">
							<input type="button" class="head_cancel" value=""/></font>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							&nbsp;
						</td>
					</tr>
					
				 </table>
	    </div>
       </td>
       </tr>
     </table>
     
    
</BODY>     
</HTML>
<SCRIPT language=JavaScript>



   body_resize();
   function hideZt(){
		$("#showRightDiv #userTable tr").find("td").each(function(){
			$(this).bind("mouseover",function(){
				$(this).css("background","red").siblings().css("background","red");;
			})
			$(this).bind("mouseout",function(){
				$(this).css("background","#007BE3").siblings().css("background","#007BE3");
			})
		})
	}
   
   

   
//判断属于哪个区域动态消息  自己扩展方法 
function LoadDataDynamic(messageObject){
	if(messageObject.xxlb == "2" || messageObject.xxlb == "5"){
		 DynamicGzdb(messageObject);
	}
}



function DynamicGzdb(messageObject){
	
	
	var TaskPushDom = $(firstPageTask.document.getElementById("TaskPushId"));
	var TrHtml = "";
		TrHtml = "<tr height='66px' valign='middle'>";
	if(!messageObject.sfck){
		TrHtml += "<td width='5%'><div class='divMessageRead1' title='未读'></div></td>";
		if(messageObject.xxlb == "2"){
			TrHtml += "<td width='73%' class='messageContentTd1'>" +
					  "<a href='#' title='"+messageObject.xxbt+"' onclick='ywxtgzrwb(\""+messageObject.ywurl+"\")' "+
					  "style='line-height: 25px'><font color='#009900'>[任务]</font>&nbsp;"+messageObject.xxnr+"</a></td>";
			TrHtml += "<td width='22%' class='messageContentTd1' >&nbsp;"+ messageObject.fssj +"</td>";
		}else if(messageObject.xxlb == "5"){
			TrHtml += "<td width='73%' class='messageContentTd1'>" +
					  "<a href='#' title='"+messageObject.xxbt+"' onclick='menu_open(\"督办任务\", \""+messageObject.ywurl+"\")' "+
					  "style='line-height: 25px'><font color='#009900'>[督办任务]</font>&nbsp;"+messageObject.xxnr+"</a></td>";
			TrHtml += "<td width='22%' class='messageContentTd1' >&nbsp;"+ messageObject.fssj +"</td>";
		}
	    
	}else{
		TrHtml += "<td width='5%'><div class='divMessageRead2' title='已读'></div></td>";
		if(messageObject.xxlb == "2"){
			TrHtml += "<td width='73%' class='messageContentTd2'>" +
					  "<a href='#' title='"+messageObject.xxbt+"' onclick='ywxtgzrwb(\""+messageObject.ywurl+"\")' "+
					  "style='line-height: 25px'><font color='#009900'>[任务]</font>&nbsp;"+messageObject.xxnr+"</a></td>";
			TrHtml += "<td width='22%' class='messageContentTd1' >&nbsp;"+ messageObject.fssj +"</td>";
		}else if(messageObject.xxlb == "5"){
			TrHtml += "<td width='73%' class='messageContentTd2'>" +
					  "<a href='#' title='"+messageObject.xxbt+"' onclick='menu_open(\"督办任务\", \""+messageObject.ywurl+"\")' "+
					  "style='line-height: 25px'><font color='#009900'>[督办任务]</font>&nbsp;"+messageObject.xxnr+"</a></td>";
			TrHtml += "<td width='22%' class='messageContentTd1' >&nbsp;"+ messageObject.fssj +"</td>";
		}
	}
	TaskPushDom.prepend(TrHtml);
}
   

var firstPageTask;

var pageType;

function initFramePage(){
	if(IE){
		firstPageTask = document.frames['main_frame'].frames['main_center'];
		if(firstPageTask){
			firstPageTask.onload = function(){
				pageType = firstPageTask.document.getElementById("main_tab0").getAttribute("pageType");
				if(pageType == "1" ){
						firstPageTask = firstPageTask.frames['main_tab0'].frames['wfTask'];
				}
			}
		}
	}else{
		var main_frame = document.getElementById("main_frame").contentWindow;
		if(main_frame){
			main_frame.onload = function(){ //第一层main_frame
				var main_center = main_frame.document.getElementById("main_center");
					main_center.onload = function(){//第二层main_center
						main_center = main_center.contentWindow;
						pageType = main_center.document.getElementById("main_tab0").getAttribute("pageType");
						if(pageType == "1" ){//第三层main_tab
							var main_tab = main_center.document.getElementById("main_tab0").contentWindow;
							firstPageTask = main_tab.document.getElementById("wfTask").contentWindow; //第四层firstPageTask
						}
				}
			}
		}
	}
}


function NewsTips(title,message){  //右下角消息提示
			topMessager.show({
			title: title,
			msg: message,
			timeout:30000
		 	});
}



//回调函数
function messageToke(message){
	if(message.type == "1"){  //民警待办任务消息提示
		var ShowMessage =　"";
		if(message.entity.xxlb == "2"){
  			ShowMessage =  "<a href='#' title='" + message.entity.xxbt + "' ";
  			ShowMessage += "onclick='ywxtgzrwb(\"" + message.entity.ywurl + "\")'";
  			ShowMessage += "style='line-height: 25px'>";
  			ShowMessage += "<font color='#009900'>[任务]</font>&nbsp;"+ message.entity.xxnr +"</a>";
  		}else if(message.entity.xxlb == "5"){
  			ShowMessage = "<a href='#' title='" + message.entity.xxbt + "' ";
  			ShowMessage += "onclick='menu_open(\"督办任务\", \""+  message.entity.ywurl +"\")'";
  			ShowMessage += "style='line-height: 25px'>";
  			ShowMessage += "<font color='#009900'>[督办任务]</font>&nbsp;"+ message.entity.xxnr +"</a>";
  		}else{
  			ShowMessage = message.entity.xxnr;
  		}
		LoadDataDynamic(message.entity);
  		NewsTips("任务消息提示",ShowMessage);
	}else{
		
		
	}
}
   
//初始化WebSocket
$(function(){
	var userId = "<%=userID%>";
	var userOrgCode = "<%=userOrgCode%>";
	initConnect({loginType:'1',userId:userId,orgCode:userOrgCode,businCode:null});
	initFramePage();
});
//局长专用
startList=function() {
	  navRoot=document.getElementById("menu");
	  var allli=navRoot.getElementsByTagName("li");
	  for (i=0;i<allli.length;i++){
	      node=allli[i];
	      node.onmouseover=function (){
	        this.className+="current";
	      }
	      node.onmouseout=function(){
	        this.className=this.className.replace("current","");
	      }
	  }
	}
	
	window.onload=startList;
</SCRIPT>
</BODY>
</HTML>
