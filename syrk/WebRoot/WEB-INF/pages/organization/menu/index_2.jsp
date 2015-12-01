<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ include file="/WEB-INF/pages/commonMap.jsp"%>
<%@page import="com.founder.framework.base.entity.SessionBean"%>
<%@page import="com.founder.framework.config.SystemConfig" %>
<%

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
   //System.out.println(theme);
   if(theme == null || "".equals(theme)){
       theme = "1_2";
   }
}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>首页-index_2</title>
    <script type="text/javascript" src="<%=contextPath%>/js/theme.js"></script>
    <% if(theme.equals("1_1")){ %>
    <link href="<%=contextPath%>/css/index_css1.css" rel="stylesheet" type="text/css" />
    <%}else if(theme.equals("1_2")){ %>
   	<link href="<%=contextPath%>/css/index_css2.css" rel="stylesheet" type="text/css" />
    <%}else if(theme.equals("1_3")){%>
    <link href="<%=contextPath%>/css/index_css3.css" rel="stylesheet" type="text/css" />
	<%} %>
  </head>
  <body style="text-align: center;">
  <%
  	if(theme.equals("1_1")){
  	%>
	  	<div class="nav_wrap_01">
		<img src="<%=contextPath%>/images/index/nav_01.png" width="524" height="542" border="0" usemap="#Map" />
			<map name="Map" id="Map">
				 <area shape="rect" coords="197,28,322,158"  href="javascript:void(0);"   onclick="openWinDow('实有人口管理','/forward/syrk|syrkMain')"/>
				 <area shape="rect" coords="357,124,483,245" href="javascript:void(0);" 	onclick="openWinDow('实有人口核实','/forward/syrk|syrkHs')"/>
				 
				 <area shape="rect" coords="361,292,486,424" href="javascript:void(0);" 	onclick="window.open('http://10.80.5.226:7001/bzdz/userLogin_loginExternal.action?userId=<%=userID %>')"/>
				 <area shape="rect" coords="215,384,322,525" href="javascript:void(0);" 	onclick="window.open('http://10.80.5.226:7001/bzdz/userLogin_loginExternal.action?userId=<%=userID %>')"/>
				 
				 <area shape="rect" coords="41,309,171,425"  href="javascript:void(0);" 	 onclick="openWinDow('实有单位管理','/sydwcx_dl/queryDwByLx')"/>
				 <area shape="rect" coords="47,116,169,252"  href="javascript:void(0);" 	onclick="openWinDow('实有单位核实','/forward/sydw_dl|sydwHs')"/>
				 <area shape="rect" coords="192,212,321,332" href="javascript:void(0);" 	onclick="openWinDow('消息提醒','/forward/message|sysMessage')"	/>
			</map>
	</div>
   <%}else if(theme.equals("1_2")){
  %>
	  <div class="nav_wrap_01">
	   <ul>
		   <c:forEach items ="${list}" var="ztys">
		    <c:choose>
		       <c:when test="${ztys.bigicontext3=='标准地址管理' && ztys.menuopenmode =='2'}">
		           <li style="font-size:150%"><a href="javascript:void(0);" onclick="window.open('${ztys.menuurl}<%=userID %>')"><img src="<%=contextPath %>/images/navigatorNew/icon/${ztys.bigiconimg3}" width="120" height="120" /></a><br/><br/><span style="font-weight:bold;font-size:18px;">${ztys.bigicontext3}</span></li>
		       </c:when>
		       <c:otherwise>
		           <c:if test="${ztys.menuopenmode=='2'}">
		              <li style="font-size:150%"><a href="javascript:void(0);" onclick="window.open('${ztys.menuurl}')"><img src="<%=contextPath %>/images/navigatorNew/icon/${ztys.bigiconimg3}" width="120" height="120" /></a><br/><br/><span style="font-weight:bold;font-size:18px;">${ztys.bigicontext3}</span></li>
		           </c:if>
		           <c:if test="${ztys.menuopenmode!='2'}">
		              <li style="font-size:150%"><a href="javascript:void(0);" onclick="openWinDow('${ztys.bigicontext3}','${ztys.menuurl}')"><img src="<%=contextPath %>/images/navigatorNew/icon/${ztys.bigiconimg3}" width="120" height="120" /></a><br/><br/><span style="font-weight:bold;font-size:18px;">${ztys.bigicontext3}</span></li>
		           </c:if> 
		       </c:otherwise>
		     </c:choose>
		   </c:forEach>
		  
		</ul>
     </div>
	 <%	

   }else{%>
	    <div class="nav_wrap_01">
	   <ul>
		   <c:forEach items ="${list}" var="ztys">
		        <c:choose>
			       <c:when test="${ztys.bigicontext3=='标准地址管理' && ztys.menuopenmode =='2'}">
			           <li>
				            <div class="navImages"><a href="javascript:void(0);" onclick="window.open('${ztys.menuurl}<%=userID %>')"><img src="<%=contextPath %>/images/navigatorNew/icon/${ztys.bigiconimg3}" width="120" height="120" /></a></div>
				            <div class="touying"></div>
				            <div class="navText"><a href="javascript:void(0);">${ztys.bigicontext3}</a></div>
		               </li>
			       </c:when>
			       <c:otherwise>
			           <c:if test="${ztys.menuopenmode=='2'}">
			               <li>
				             <div class="navImages"><a href="javascript:void(0);" onclick="window.open('${ztys.menuurl}')"><img src="<%=contextPath %>/images/navigatorNew/icon/${ztys.bigiconimg3}" width="120" height="120" /></a></div>
				             <div class="touying"></div>
				             <div class="navText"><a href="javascript:void(0);">${ztys.bigicontext3}</a></div>
		                  </li>
			           </c:if>
			           <c:if test="${ztys.menuopenmode!='2'}">
			              <li>
				             <div class="navImages"><a href="javascript:void(0);" onclick="openWinDow('${ztys.bigicontext3}','${ztys.menuurl}')"><img src="<%=contextPath %>/images/navigatorNew/icon/${ztys.bigiconimg3}" width="120" height="120" /></a></div>
				             <div class="touying"></div>
				             <div class="navText"><a href="javascript:void(0);">${ztys.bigicontext3}</a></div>
		                  </li>
			           </c:if> 
			       </c:otherwise>
		      </c:choose>
		   </c:forEach>
		  
		</ul>
     </div>
	   
	   
   <%}
  %>
  <script type="text/javascript">
  	function openWinDow(title,url){
  		menu_open(title, url);
  	}
  	
  	function iconAjax(){
  		$.ajax({
  			type:"POST",
  			sync:true,
  			url:contextPath+"/func/queryFunc",
  			data:{},
  			dataType:'json',
  			success:function(json){
  				alert(json.length);
  			}
  	});
  	}
  	
  	
 	
  </script>
  
  </body>
</html>
