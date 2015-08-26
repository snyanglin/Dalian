<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ include file="/WEB-INF/pages/commonMap.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:v="urn:schemas-microsoft-com:vml">
  <head>
    <title>跨域访问中转方法</title>
    <script>
    <!--
    function getParm(name){
  	  var flag = ""; 
    	  var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    	  var r = window.location.search.substr(1).match(reg);
    	  if(r != null){
    		  flag = unescape(r[2]);
    	  } 
    	  return flag;
    }
    
    //跨域访问必须传递2个参数url和name
	$(function(){
  	    var r = window.location.search.substr(1);
		var urls = r.substring(r.indexOf("url=")+4, r.length);
		var url = urls.replace("&", "?");
	   	var name = getParm("name");
	   	if(url != ''){
	   		if(null==name || ''==name){
	   			name = '新窗口';
	   		} else {
	   			name = decodeURI(decodeURI(name));
	   		}
	   		alert(url);
	   		menu_open(name, url);
	   	}
	});
    -->
    </script>
  </head>
  <body>
  </body>
</html>