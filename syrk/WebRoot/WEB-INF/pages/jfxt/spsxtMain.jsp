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
   System.out.println("进入技防管理主页...---->>>>>社会资源");
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
		})
	
	}

window.setInterval(queryResult,2*60000);


</script>

</HEAD>
<body class="easyui-layout" data-options="fit:true" style="overflow: hidden;height: 100%;width: 100%;" leftmargin="0" topmargin="0" bottommargin="0" marginwidth="0" marginheight="0">   
    <div data-options="region:'center',border:false">   
        <div id="mainLayout" class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'west',title:'西边导航区域'" style="width:200px">
            	<!-- 功能导航   -->
				<div id="aa" class="easyui-accordion" data-options="border:false"> 
				    <!-- 视频区域   -->
				    <!-- 视频建设单位   -->
				    <div title="视频建设单位" data-options="iconCls:'icon-add'" style="padding:10px;">   
						<a href="<%=contextPath%>/forward/jfxt|spjsdwAdd" onclick="setCaption('视频建设单位','新增视频建设单位')" target="mainArea">新增视频建设单位</a><p>
						<a href="<%=contextPath%>/forward/jfxt|spjsdwModify"  onclick="setCaption('视频建设单位','修改视频建设单位')" target="mainArea">修改视频建设单位</a><p>
						<a href="<%=contextPath%>/forward/jfxt|spjsdwDelete"  onclick="setCaption('视频建设单位','删除视频建设单位')" target="mainArea">删除视频建设单位</a>
						
					 </div>  
				    <!-- 视频建监控系统   -->
				    <div title="视频监控系统" data-options="iconCls:'icon-search'" style="padding:10px;">   
						<a href="<%=contextPath%>/forward/jfxt|spjkxtAdd" onclick="setCaption('视频监控系统','新增视频监控系统')"  target="mainArea">新增视频监控系统</a><p>
						<a href="<%=contextPath%>/forward/jfxt|spjkxtModify" onclick="setCaption('视频监控系统','修改视频监控系统')"  target="mainArea">修改视频监控系统</a><p>
				    	<a href="<%=contextPath%>/forward/jfxt|spjkxtDelete" onclick="setCaption('视频监控系统','删除视频监控系统')"  target="mainArea">删除视频监控系统</a>
				    </div>   
				    <!-- 视频摄像头   -->
				    <div title="视频摄像头" data-options="iconCls:'icon-remove'" style="padding:10px;">   
						<a href="<%=contextPath%>/forward/jfxt|spsxtAdd" onclick="setCaption('视频摄像头','新增视频摄像头')"  target="mainArea">新增视频摄像头</a><p>
						<a href="<%=contextPath%>/forward/jfxt|spsxtList" onclick="setCaption('视频摄像头','修改视频摄像头')"  target="mainArea">修改视频摄像头</a><p>
						<a href="<%=contextPath%>/forward/jfxt|spsxtDelete"  onclick="setCaption('视频摄像头','删除视频摄像头')" target="mainArea">删除视频摄像头</a>
				    </div>   
				    <!-- test   -->
				    <div title="查询" data-options="iconCls:'icon-remove'" style="padding:10px;">   
						<a href="<%=contextPath%>/forward/jfxt|spjsdwQuery"  onclick="setCaption('查询','视频建设单位查询')" target="mainArea">视频建设单位查询</a><p>
						<a href="<%=contextPath%>/forward/jfxt|spsxtQuery"  onclick="setCaption('查询','视频摄像头查询')" target="mainArea">视频摄像头查询</a><p>
						<a href="<%=contextPath%>/forward/jfxt|sxtMap2" onclick="setCaption('查询','视频摄像头定位')"  target="mainArea">视频摄像头定位</a><p>
						<a href="<%=contextPath%>/forward/jfxt|sxtMap20" onclick="setCaption('查询','视频摄像头纠偏')"  target="mainArea">视频摄像头纠偏</a><p>	
						<!-- 		
						<a href="<%=contextPath%>/forward/organization|applyselect|testOrgSelect" target="mainArea">测试组织机构选择</a><p>
 						-->
				    </div>  
				    <!-- test   -->
				    <!-- <div title="开发测试" data-options="iconCls:'icon-remove'" style="padding:10px;"> -->  
				    <!-- 	<a href="<%=contextPath%>/forward/jfxt|spsxtDemo|testDictionary"  onclick="setCaption('开发测试','Test字典翻译')" target="mainArea">Test字典翻译</a><p>-->

				    <!-- </div> -->				     
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