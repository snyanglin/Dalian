<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/common.jsp"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<%
   SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
   String userName =  userInfo.getUserName();
   String userOrgName = userInfo.getUserOrgName();
   String userOrgCode = userInfo.getUserOrgCode();
   String ipdz = userInfo.getRemoteAddr();
   String xtzt ="";// userInfo.getXtzt();
   System.out.println(userName+","+userOrgName+","+userOrgCode+","+xtzt+","+userInfo.getUserOrgNameQc());
   session.setAttribute("owner","police");//取值：police--公安自建，noPolice--社会资源
   System.out.println("进入技防管理主页...---->>>公安自建");
%>
<HTML>
<%
	System.out.println("contextPath:"+contextPath);
%>
<HEAD>
<TITLE></TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function setCaption(mainTitle,minorTitle){
		var title=mainTitle+"&gt&gt&gt&gt"+minorTitle
		var centerPanel=$('#mainLayout').layout('panel','center');
		
		centerPanel.panel('setTitle',title);
	}

</script>


</HEAD>
<body class="easyui-layout" data-options="fit:true" style="overflow: hidden;height: 100%;width: 100%;" leftmargin="0" topmargin="0" bottommargin="0" marginwidth="0" marginheight="0">   

    <div data-options="region:'center',border:false">   
        <div id="mainLayout" class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'west',title:'公安视频导航区域'" style="width:200px">
            	<!-- 功能导航   -->
				<div id="aa" class="easyui-accordion" data-options="border:false"> 
				    <!-- 公安自建视频   -->
				    <c:forEach var="rowObject"  varStatus="curStatus" items="${rightMenuList}">
				    <div title="${rowObject.menuname}" data-options="iconCls:'icon-add'" style="padding:10px;"> 
				      	<c:forEach var="rowObject2"  varStatus="curStatus" items="${rowObject.menuList}">
							<a href="<%=contextPath%>${rowObject2.menuurl}" onclick="setCaption('${rowObject.menuname}','${rowObject2.menuname}')" target="mainArea">${rowObject2.menuname}</a><p>
						</c:forEach>
						
					 </div>  
			     	</c:forEach>
				</div>  
            </div>   
            <div data-options="region:'center',title:'主工作区域'">
         		<iframe id="mainAreaId" src="<%=contextPath%>/forward/jfxt|welcome" name="mainArea" width="100%" height="100%" frameborder="0" scrolling="no"></iframe>
            </div>   
        </div>   
    </div>   

</body>
</html>