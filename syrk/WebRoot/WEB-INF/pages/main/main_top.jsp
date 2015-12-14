<%@page pageEncoding="UTF-8"%>
<%@page import="com.founder.framework.base.entity.SessionBean"%>
<%@page import="com.founder.framework.config.SystemConfig"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page import="com.founder.xjpt.controller.XjController"%> 
<%
	String contextPath = request.getContextPath();
	String emptyImage = contextPath
			+ "/common/skin/images/sys_empty.gif";
	//局长页面
	String jzImage = contextPath
			+ "/common/skin/images/lunbo-6.png";
			
	SessionBean userInfo = (SessionBean) session
			.getAttribute("userSession");
	String userID = "";
	String password = "";
	String userName = "";
	String userOrgName = "";
	String userRemoteAddr = "";
	String userOrgCode = "";
	String theme = "";
	String userType = "";
	String ManageOrgName="";
	String httpURI = "http://10.80.5.228:9080/DLGA_XJPT_V2";
	httpURI = new XjController().getURL();
	if (userInfo != null) {
		userID = userInfo.getUserId();
		password = userInfo.getPassword();
		if (password == null) {
			password = "";
		}
		userName = userInfo.getUserName();
		userOrgName = userInfo.getUserOrgName();
		userRemoteAddr = userInfo.getRemoteAddr();
		userOrgCode = userInfo.getUserOrgCode();
		userType = userInfo.getUserType();
		ManageOrgName=userInfo.getExtendValue("parentOrgName");
		theme = userInfo.getTheme();
		java.util.Map extendMap = userInfo.getExtendMap();
		if (extendMap != null && extendMap.size() > 0) {
		}

		if ("".equals(theme) && "1".equals(userType)) { // 系统管理员默认主题
			theme = "2_1";
		}
	}
	
%>
<script type="text/javascript">
var contextPath = "<%=contextPath%>";
</script>

<link href="<%=contextPath%>/common/skin/main.css" type="text/css"
	rel="stylesheet">
<script type="text/javascript"
	src="<%=contextPath%>/js/jquery-1.10.1.min.js"></script>
<script type="text/javascript"
	src="<%=contextPath%>/common/jeasyui/global.js"></script>
<script type="text/javascript"
	src="<%=contextPath%>/common/jeasyui/mainFrame.js"></script>

<HTML>
<HEAD>
<TITLE></TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</HEAD>

<SCRIPT language=JavaScript>

function jcywcd(){
 
   var showDivMenu= window.top.getShowDiv();
  
   if( showDivMenu.style.display=="none"){     
      window.top.showDysCalendar_menu();
   }else{
      window.top.hiddenCalendar_menu();
   }
  
}

function body_onload() {
}

function logout_click(){
  window.top.location.href=contextPath+"/LoginPage/login?action=logout";
}

function show_cur_times(){
//获取当前日期
 var date_time = new Date();
 //定义星期
 var week;
 //switch判断
 switch (date_time.getDay()){
case 1: week="星期一"; break;
case 2: week="星期二"; break;
case 3: week="星期三"; break;
case 4: week="星期四"; break;
case 5: week="星期五"; break;
case 6: week="星期六"; break;
default:week="星期天"; break;

 }
 //年
 var year = date_time.getFullYear();
  //判断小于10，前面补0
   if(year<10){
  year="0"+year;
 }
 //月
 var month = date_time.getMonth()+1;
  //判断小于10，前面补0
  if(month<10){
month="0"+month;

 }
 //日
 var day = date_time.getDate();
  //判断小于10，前面补0
   if(day<10){
  day="0"+day;
 }
 //时
 var hours =date_time.getHours();
  //判断小于10，前面补0
    if(hours<10){
  hours="0"+hours;
 }
 //分
 var minutes =date_time.getMinutes();
  //判断小于10，前面补0
    if(minutes<10){
  minutes="0"+minutes;
 }
 //秒
 var seconds=date_time.getSeconds();
  //判断小于10，前面补0
    if(seconds<10){
  seconds="0"+seconds;
 }
 //拼接年月日时分秒
 var date_str = year+"年"+month+"月"+day+"日 "+hours+":"+minutes+":"+seconds+" "+week;
 var ri = day;
 var yue = month + "月";
 var fen = hours+":"+minutes + ":" + seconds;

 //显示在id为showtimes的容器里
 document.getElementById("showtimes").innerHTML= fen;
 document.getElementById("month").innerHTML= yue;
 document.getElementById("week").innerHTML= week;
 document.getElementById("day").innerHTML= ri;


}

 //设置1秒调用一次show_cur_times函数
 if("<%=theme%>" == "2_3"){
	//setInterval("show_cur_times()",100);
	}

 //巡警平台(开关菜单)
 var isOpen = false;
 function openOrClose(){
	 if(!isOpen){
		 window.top.showXjCalendar_menu();
		 isOpen = true;
	 } else {
		 window.top.hiddenXjCalendar_menu();
		 isOpen = false;
	 }
 }
</SCRIPT>

	<%
	 	//if ("2_3".equals(theme)) {
	%>
		<!--  
		<BODY class="bannerBody1" onselectstart="return false;"
			onload="body_onload();" oncontextmenu="return false;">
			<div class="bannerbg banner04">
				<div class="banner_lf">
					<img src="<%=emptyImage%>" width="650" height="1" border="0">
				</div>
				 -->
	<%
		//} else {
	%>
		<BODY class="bannerBody" onselectstart="return false;"
		onload="body_onload();" oncontextmenu="return false;">
			<div class="bannerbg banner02">
				<div class="banner_lf banner01">
					<img src="<%=emptyImage%>" width="650" height="1" border="0">
				</div>
	<%
		//} 
	%>	
		<div class="banner_ct">
			<!-- 
		<a href="javascript:;" class="banner_btnlf"></a>
		<a href="javascript:;" class="banner_btnrt"></a>
		 -->
			<div class="banner_ctct">
				<div class="bannerul">
					<ul >
						<%
							if ("2_2".equals(theme)) {
						%>
						<li class="bannerZdgz" title="日常工作"
							onclick="menu_open('日常工作管理', '/dbrwMain/main')"><a><img
								src="<%=emptyImage%>" width="60" height="60" border="0">
						</a>
						</li>

						<li class="bannerGzts" title="实时工作"
							onclick="menu_open('实时工作管理', '/gzjk/main/1')"><a><img
								src="<%=emptyImage%>" width="60" height="60" border="0">
						</a>
						</li>
						<li class="bannerGztj" title="工作统计"
							onclick="menu_open('工作统计管理', '/forward/tzgg|sqjw')"><a><img
								src="<%=emptyImage%>" width="60" height="60" border="0">
						</a>
						</li>
						
						<%
							//这个判断不现实导航图标
						 	//} else if ("2_3".equals(theme)) { 
						%>
						<%
						//巡警平台
						 	} else if ("2_4".equals(theme)) { 
						%>
							<!-- begin -->
							<li class="" title="智能巡检" style="cursor: pointer;"
								onclick="menu_open('智能巡检', '/forward/query|xj_zdrkQueryMain')"><a><img
									src="<%=contextPath%>/common/skin/images/xj_znxj.jpg" width="60" height="60" border="0">
							</a>
							</li>
							<li class="" title="更多链接" style="cursor: pointer;" id="userImg"
								onclick="openOrClose();"><a><img
									src="<%=contextPath%>/common/skin/images/xj_xlsj.jpg" width="60" height="60" border="0">
							</a>
							</li>
							<!-- 
							<li class="" title="智能巡检" style="padding-top: 45; background: url('<%=contextPath%>/common/skin/images/xj_znxj.jpg') no-repeat right;"
								onmouseover="this.style.cursor = 'hand';" onmouseout="this.style.cursor = 'default';"
								onclick="menu_open('智能巡检', '/forward/query|xj_zdrkQueryMain')"><a>智能巡检
							</a>
							</li>
							<li class="" title="more" style="padding-top: 35;" id="userImg"
								onmouseover="this.style.cursor = 'hand';" onmouseout="this.style.cursor = 'default';"
								onclick="openOrClose();"><a>>>
							</a>
							</li>
							 -->
							<!-- end -->
						<%
							} else {
						%>
						<c:forEach items="${list}" var="ztys">
							<c:choose>
								<c:when test="${ztys.bigicontext1=='标准地址' && ztys.menuopenmode =='2'}">
									<li style=" background: url('<%=contextPath %>/images/navigatorNew/icon/${ztys.bigiconimg1}') no-repeat center top;margin-top:5px;"
										title="${ztys.menuname}"
										onclick="window.open('${ztys.menuurl}<%=userID %>')">
										<div
											style="width:60px;float:left;text-align:center;height:36px;">
											<a href="#"><img src="<%=emptyImage%>" width="36"
												height="36" border="0"> </a>
										</div>
										<div
											style="width:60px;float:left;text-align:center;line-height:32px;margin-top:5px;">
											<a href="#">${fn:substring(ztys.bigicontext1, 0, 4)}</a>
										</div>
									</li>

								</c:when>
								<c:otherwise>
									<c:if test="${ztys.menuopenmode =='2'}">
										<li style=" background: url('<%=contextPath %>/images/navigatorNew/icon/${ztys.bigiconimg1}') no-repeat center top;margin-top:5px;"
										title="${ztys.menuname}"
										onclick="window.open('${ztys.menuurl}')">
										<div
											style="width:60px;float:left;text-align:center;height:36px;">
											<a href="#"><img src="<%=emptyImage%>" width="36"
												height="36" border="0"> </a>
										</div>
										<div
											style="width:60px;float:left;text-align:center;line-height:32px;margin-top:5px;">
											<a href="#">${fn:substring(ztys.bigicontext1, 0, 4)}</a>
										</div>
									</li>
									</c:if>
									<c:if test="${ztys.menuopenmode!='2'}">
										<li style="background: url('<%=contextPath %>/images/navigatorNew/icon/${ztys.bigiconimg1}') no-repeat center top;margin-top:5px;"
										title="${ztys.menuname}"
										onclick="menu_open('${ztys.menuname}', '${ztys.menuurl}')">
										<div
											style="width:60px;float:left;text-align:center;height:36px;">
											<a href="#"><img src="<%=emptyImage%>" width="36"
												height="36" border="0"> </a>
										</div>
										<div
											style="width:60px;float:left;text-align:center;line-height:32px;margin-top:5px;">
											<a href="#">${fn:substring(ztys.bigicontext1, 0, 4)}</a>
										</div>
									</li>
									</c:if>
								</c:otherwise>
							</c:choose>

						</c:forEach>
						<%
							}
						%>
			</div>
		</div>
		<div class="banner_rt">
			<%
			  //if (!"2_3".equals(theme)) {
			%>
			<div style="float:left;width:60px;">
				<table border="0" cellpadding="0" cellspacing="0" height="42"
					width="60" valign="right">
					<tbody>
						<tr>
							<td class="bannerNavi" valign="top" onclick=""><img
								src="<%=emptyImage%>" width="60" height="60" border="0"
								onclick="window.top.openWindow(false,'', contextPath + '/ztTheme/DhMenu', {document: document}, {title: '&nbsp;个人菜单导航',    
			    width: 1020,   
			    height: 550,  
				collapsible: false, 
				minimizable: false, 
				maximizable: false,
				closable: true,
			    closed: false,    
			    cache: false,
			    inline: false,
				resizable: false, 
			    modal: true})">
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<%
				//} 
			%>
			<%
			  //if ("2_3".equals(theme)) {
			%>
			<!-- 
			<div class="top_menu" style="float:right;width:20px;height:72px;">
				<table border="0" cellpadding="0" cellspacing="0" height="50"
					width="300" valign="right" style="margin:2px 0 0;">
					<tbody>
						<tr>
							<td rowspan="2" width="3" class="logout1"></td>
							<td rowspan="2" width="3" class="logout1"></td>
							<td rowspan="2" width="60" class="bannerJz" style="cursor:pointer; background-color: red;" id="userImg" align="center">
								<img src="<%=emptyImage%>" width="40" height="60" border="0"
									onclick="window.top.showDysCalendar_jz();">
							</td>
							<td rowspan="2" width="3" class="logout1"></td>
							<td class="userInfo" width="86" style="background-color: #1abc9c">
								<table border="0" width=100% height="100%" style="background-color: #1abc9c">
									<tr>
										<td rowspan="2" width="3" class="userInfo"><span style="font-size: 20; font-weight: 35" id="day"></span></td>
										<td class="userInfo" align="center"><span style="font-size: 11;" id="month"></span></td>
									</tr>
									<tr>
										<td class="userInfo" align="center"><span style="font-size: 11;" id="week"></span></td>
									</tr>
								</table>
							</td>
							<td class="userInfo1" width="86">
								<table border="0" width=100% height="100%" style="background-color: #ffffff">
									<tr height="30" width="86">
										<td class="userInfo1">
											<div class="datert"><span id="showtimes" style="font-size: 15;"></span><a class="loginout" href="javascript:;" onclick="logout_click()"></a></div>
										</td>
									</tr>
								</table>
							</td>
							<td rowspan="2" width="3" class="logout1"></td>
						</tr>
						<tr height="20">
							<td class="userInfo"><span style="font-size: 12;"><%=userName%>&nbsp;局长</span></td>
							<td class="userInfo"><span style="font-size: 12;"><%=userOrgName%></span></td>
						</tr>
					</tbody>
				</table>
				<div class="banner_info">
					
				</div>
			</div>
			  -->
			  
			 <!-- 
			<div class="top_menu" style="float:right;width:185px;height:72px;">
			 <div class="top_menu">
	      		<div class="user_info user_info_on">
	                <div class="user_icon"><img src="images/user_icon.png" width="27" height="27" /></div>
	                <span>警务业务</span>
	            </div>
	            <div class="top_menurt">
	            	<div class="topdate">
	                	<div class="datelf"><b>10</b><span>一月</span><span>星期六</span></div>
	                	<div class="datert"><span>23:30</span><a class="loginout" href="javascript:;"></a></div>
	                </div>
	            	<div class="topry">
	                	<div class="toprylf">某某某<br/>局长</div>
	                	<div class="topryrt">大连市公安局西岗分局</div>
	                </div>
	            </div>
    		</div>
    		-->
            <%
				//} else {
			%>
			<div class="banner03" style="float:right;width:160px;height:72px;">
				<table border="0" cellpadding="0" cellspacing="0" height="42"
					width="160" valign="right" style="margin:10px 0 0;">
					<tbody>
						<tr>
							<td rowspan="3" width="42" class="bannerUser"
								style="cursor:pointer;" id="userImg"><img
								src="<%=emptyImage%>" width="42" height="42" border="0"
								onclick="window.top.showDysCalendar();">
							</td>
							<td class="userInfo" width="86"><%=userName%></td>
							<td rowspan="2" width="30" class="logout1"
								onclick="logout_click()" onmousemove="this.className='logout2'"
								onmouseout="this.className='logout1'">退出</td>
						</tr>
						<tr>
							<td class="userInfo"><%=userOrgName%></td>
						</tr>
						<tr>
							<td class="userInfo"><%=ManageOrgName%></td>
						</tr>
					</tbody>
				</table>
				<div class="banner_info">
					
				</div>
			</div>
			<%
				//}
			%>
		</div>
	</div>

</BODY>
</HTML>
