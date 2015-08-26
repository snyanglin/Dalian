<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>摄像头照片</title>

  </head>
  
  <body>
  <!--
    <img src="D:\temp\pic\loginBoxBg.png" id="display">
  -->
  <input type="hidden" id="path" name="path" value="${entity.path }"/>
  <img src=""  id="display">
    <div id="saveDiv" style="text-align:center; height:50px; padding-top: 10px; display:block;">
			&nbsp;&nbsp;
			<a id="backBotton" class="l-btn l-btn-small" href="javascript:void(0)" group="" onclick="exitOnclick()">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">返回</span>
					<span class="l-btn-icon icon-back"> </span>
				</span>
			</a>
		</div>
<script type="text/javascript">
//$(function(){
//	dispImg();
//});

window.onload=function(){
	dispImg();
}

function exitOnclick(){
    //后退
    //var url = contextPath+"/forward/jfxt|spdlqyList";
    //parent.document.getElementById("mainAreaId").src = url;
    closeSelf();
}

function dispImg(){
	var path_pic=$("#path").val();
	//alert("path_pic"+path_pic);
	var src='<%=basePath %>sptgl/showPic?path='+path_pic;
	document.getElementById("display").src=src;
}
</script>

  </body>
</html>
 