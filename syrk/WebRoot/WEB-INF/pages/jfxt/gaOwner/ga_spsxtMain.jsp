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

//关闭标签页
/*
function closeTabPage(){
	//var tabPages=["公安视频","社会视频"];
	//var theTitle=$('#idName').val();
	alert("关闭社会视频");
	closeMainPageByName("社会视频");
}
*/

$(function(){
	//alert("关闭社会视频");
	closeMainPageByName("社会视频");
})

function testPopupWindow(){
	//alert("theTabPageID="+theTabPageID);
	var theTabPageID=1
	var url=contextPath+"/forward/jfxt|sxtMapLocation?tabPageID="+theTabPageID;
	
	//openWindow(false, theTabPageID, url, null, null)
	//menu_open("获得坐标",url );
	
	openWindow(false, theTabPageID, url, null, null);

}

</script>

</HEAD>
<body class="easyui-layout" data-options="fit:true" style="overflow: hidden;height: 100%;width: 100%;" leftmargin="0" topmargin="0" bottommargin="0" marginwidth="0" marginheight="0">   
    <div data-options="region:'center',border:false">   
        <div id="mainLayout" class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'west',title:'西边导航区域'" style="width:200px">
            	<!-- 功能导航   -->
				<div id="aa" class="easyui-accordion" data-options="border:false"> 
				    <!-- 公安自建平台   -->
				    <div title="公安自建平台" data-options="iconCls:'icon-add'" style="padding:10px;">   
						<a href="<%=contextPath%>/forward/jfxt|gaOwner|ga_platformAdd" onclick="setCaption('公安自建平台','新增平台')" target="mainArea">新增平台</a><p>
						<a href="<%=contextPath%>/forward/jfxt|gaOwner|ga_platformModify"  onclick="setCaption('公安自建平台','修改平台')" target="mainArea">修改平台</a><p>
						<a href="<%=contextPath%>/forward/jfxt|gaOwner|ga_platformDelete"  onclick="setCaption('公安自建平台','删除平台')" target="mainArea">删除平台</a>
						
					 </div>  					    
				    <!-- NVR   -->
				    <div title="NVR" data-options="iconCls:'icon-add'" style="padding:10px;">   
						<a href="<%=contextPath%>/forward/jfxt|gaOwner|ga_nvrInfoAdd" onclick="setCaption('NVR','新增NVR')" target="mainArea">新增NVR</a><p>
						<a href="<%=contextPath%>/forward/jfxt|gaOwner|ga_nvrInfoModify"  onclick="setCaption('NVR','修改NVR')" target="mainArea">修改NVR</a><p>
						<a href="<%=contextPath%>/forward/jfxt|gaOwner|ga_nvrInfoDelete"  onclick="setCaption('NVR','删除NVR')" target="mainArea">删除NVR</a>
						
					 </div>  						    
				    <!-- 视频摄像头   -->
				    <div title="公安自建视频摄像头" data-options="iconCls:'icon-remove'" style="padding:10px;">   
						<a href="<%=contextPath%>/forward/jfxt|gaOwner|ga_spsxtAdd" onclick="setCaption('视频摄像头','新增公安自建视频摄像头')"  target="mainArea">新增公安自建视频摄像头</a><p>
						<a href="<%=contextPath%>/forward/jfxt|gaOwner|ga_spsxtList" onclick="setCaption('视频摄像头','修改视频摄像头')"  target="mainArea">修改视频摄像头</a><p>
						<a href="<%=contextPath%>/forward/jfxt|gaOwner|ga_spsxtDelete"  onclick="setCaption('视频摄像头','删除视频摄像头')" target="mainArea">删除视频摄像头</a>
				    </div>   

				    <!-- test   -->
				    <div title="查询与统计" data-options="iconCls:'icon-remove'" style="padding:10px;">   
						
						<a href="<%=contextPath%>/forward/jfxt|spsxtQuery"  onclick="setCaption('查询与统计','视频摄像头查询')" target="mainArea">视频摄像头查询</a><p>
						<!-- -->
						<a href="<%=contextPath%>/forward/jfxt|sxtMapRelocate2" onclick="setCaption('查询与统计','摄像头定位与修改')"  target="mainArea">摄像头定位与修改</a><p>
						 
						<a href="<%=contextPath%>/forward/jfxt|sxtMap20" onclick="setCaption('查询与统计','摄像头位置浏览(不建议使用)')"  target="mainArea">摄像头位置浏览(不建议使用!)</a><p>	
						<!--
						<a href="<%=contextPath%>/forward/jfxt|gaOwner|ga_sxtStatistic" onclick="setCaption('查询与统计','摄像头统计')"  target="mainArea">摄像头统计</a><p>	
						 
						<a href="<%=contextPath%>/forward/jfxt|sxtMapLocation" onclick="setCaption('查询统计','视频摄像头坐标获取')"  target="mainArea">视频摄像头坐标获取</a><p>	
						<button onclick="testPopupWindow()">testPopupWindow()</button>  
						 -->
		
		<!-- 
			输入要关闭的标签页名称:<input type="text" id="idName" />
		<button onclick="closeTabPage()">关闭标签页</button>  
			 -->			

				    </div>  
				    <!-- test   -->
				    <!--div title="开发测试" data-options="iconCls:'icon-remove'" style="padding:10px;"-->   

				    	<!--<a href="<%=contextPath%>/forward/jfxt|spsxtDemo|comboBox1"  onclick="setCaption('开发测试','实时从后台抽取数据')" target="mainArea">实时从后台抽取数据</a><p>-->
						<!--<a href="<%=contextPath%>/forward/jfxt|spsxtDemo|orgSelect"  onclick="setCaption('开发测试','组织机构选择')" target="mainArea">组织机构选择</a><p>-->


				    <!--</div>--> 				     
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