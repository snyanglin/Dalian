<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@include file="/WEB-INF/pages/common.jsp"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title></title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript">
   function setUrl(){
	    var level= '${level}';
	  	var url = contextPath + "/forward/gzjk|gzjkBzdzList?level="+level;
	  	if(IE){
	  		document.getElementById("main_left").src=url;
	  	}else{
	  		window.frames['main_left'].src=url;
	  	}
   }
  </script>
  </head>
  	<frameset id="gzjkMain" cols="540,65%" onload="setUrl()">
  	 <frame id="main_left" frameborder="0" style="height:90%;width:100%" src="" noresize scrolling="no"/>
	 <frame id="main_center" frameborder="0" style="height:100%;width:65%" src="<%=contextPath%>/forward/gzjk|gzjkBzdzMap" noresize scrolling="no">
  	</frameset>
</html>
