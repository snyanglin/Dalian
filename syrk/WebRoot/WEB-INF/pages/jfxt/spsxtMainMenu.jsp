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
   //String xtzt = userInfo.getXtzt();
   //System.out.println(userName+","+userOrgName+","+userOrgCode+","+xtzt+","+userInfo.getUserOrgNameQc());
   session.setAttribute("owner","noPolice");//取值：police--公安自建，noPolice--社会资源
   System.out.println("进入技防管理主页...---->>>>>>社会资源");
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
<script type="text/javascript">
	
	//请求后台，检查是否有满足条件的记录	
	function queryResult(){
		function displayMsg(content){
			//alert((new date()).toLocaleString());
			//var currentTime='你有'+content+'条摄像头信息必须修改!';//(new date()).toLocalString();
			var myMessage='<div style="background-color:#EBEBEB">你有<span style="color:red">'+content+'</span>条摄像头信息必须修改!</div>';		
			$.messager.show({
					title:'友情提示',
					msg:myMessage,
					showType:'show'
			});
		}
	
		var url="<%=contextPath%>/sptgl/getRemindInfo";
		//alert(url);
		$.getJSON(url,function(result){			
			if(!((result==null) || (result==undefined))){
				//alert(result);
				if(result>0){
					displayMsg(result);
				}
			}
			else{
				alert("OK");
			}
		});
	
	}

window.setInterval(queryResult,2*60000);


</script>

</HEAD>
<body class="easyui-layout" data-options="fit:true" style="overflow: hidden;height: 100%;width: 100%;" leftmargin="0" topmargin="0" bottommargin="0" marginwidth="0" marginheight="0">   
    <div data-options="region:'center',border:false">   
        <div id="mainLayout" class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'west',title:'社会视频采集导航区域'" style="width:200px">
            	<!-- 功能导航   -->
				<div id="aa" class="easyui-accordion" data-options="border:false"> 
				    <!-- 社会视频   -->
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
</body>
</html>