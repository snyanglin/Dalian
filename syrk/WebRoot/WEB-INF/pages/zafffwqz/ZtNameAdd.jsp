<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ include file="/WEB-INF/pages/commonMap.jsp"%>
<%@page import="com.founder.framework.base.entity.SessionBean"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>首页-index_2</title>
   	<link href="<%=contextPath%>${entity.css}" rel="stylesheet" type="text/css" />
  </head>
  <body>

  <div class="nav_wrap_01">
   <ul>
   <c:forEach items ="${list}" var="ztys">
          <li style="font-size:150%"><a href="#" onclick="openWinDow('${ztys.menuname}','${ztys.menuurl}')"><img src="<%=contextPath %>${ztys.iconurl}" width="120" height="120" /></a>${ztys.menuname}</li>
   </c:forEach>
	</ul>
  </div>

  <script type="text/javascript">
  	function openWinDow(title,url){
  	    var lujin =url;
  	    if(title =="标准地址管理"){
  	        lujin = url+"?userId="+"${userId}";	
  	        window.open(lujin);
  	    }else{
  	       menu_open(title, lujin);
  	    }
  		
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
