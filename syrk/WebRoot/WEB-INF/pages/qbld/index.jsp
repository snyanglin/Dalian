<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/qbld/commonInclude.jsp"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    String userOrgName = "";
    String bjzbz = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
        userOrgName = userInfo.getUserOrgName();
        bjzbz = userInfo.getBjzbz();
    }
 %>
<html>
  <head>
    <title>警情落地</title>
	<link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/qbld/index.css" />
    <script type="text/javascript" src="<%=contextPath%>/js/qbld/index.js" ></script>
    <script type="text/javascript" src="<%=contextPath%>/js/qbld/jquery.SuperSlide.2.1.1.js" ></script>
    <script type="text/javascript">
    $(function(){
		$("#nav").slide({ 
			type:"menu", 
			titCell:".nLi", 
			targetCell:".sub",
			effect:"slideDown",
			delayTime:300,
			triggerTime:0,
			returnDefault:true
		});
		Index.openPage(1);//初始化显示常规管控
		$(window).resize();
    });
	$(window).resize(function() {
		$("#modulePageIframe").css("height",$(document).height()-46);
	});
    </script>
  </head>
  
  <body>
  	<div id="title">
    	<div class="nav_bar">
					<ul id="nav" class="nav clearfix">
						<li class="nLi" onclick="Index.setMenuIndex(0);Index.openPage(1);">
							<h3>常规管控</h3>
						</li>
						<li class="nLi "  onclick="Index.setMenuIndex(1);Index.openPage(2);">
								<h3>临控申请</h3>
						</li>
						<li class="nLi " onclick="Index.setMenuIndex(2);Index.openPage(3);">
								<h3>线索采集</h3>
						</li>
						<li class="nLi "  onclick="Index.setMenuIndex(3);Index.openPage(4);">
								<h3>重点人写实</h3>
						</li>
						<%--<li class="nLi "  onclick="$('#modulePageIframe').attr('src','<%=basePath %>forward/qbld|zdrxs');">
								<h3>指令下发</h3>
						</li>
					--%></ul>
	  	</div>
      </div>
	  <div class="modulePage"><iframe id="modulePageIframe"></iframe></div>
  </body>
</html>
