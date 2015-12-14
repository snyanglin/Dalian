<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="/errorPage.jsp"%>
<%@page import="com.founder.framework.base.entity.SessionBean"%>
<%
String contextPath = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + contextPath + "/";
%>
<script type="text/javascript">
var contextPath = "<%=contextPath%>";
var basePath = "<%=basePath%>";
</script>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html >
<head>
<%
SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
Long userPk =new Long(0);
if (userInfo != null) {
	userPk = userInfo.getUserPk();
}
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="<%=contextPath%>/css/lrtk.css" rel="stylesheet" />
<style type="text/css">

	.picbox ul,li { list-style:none;float:left;padding:35px}
	img{ border:none;}
	a{ color:#6cf;}
	a:hover{ color:#84B263;}
	.box{margin-top:100px; width:1000px; margin:0 auto; position:relative; overflow:hidden; height:380px;}
	
	.picbox{ width:1000px; height:380px; overflow:hidden; position:relative;}
	
	.piclist{ height:380px;position:absolute; left:0px; top:100px}
	
	.piclist li{ background:#eee; margin-right:20px; padding:5px; float:left;}
	
	.swaplist{ position:absolute; left:-3000px; top:100px}

</style>
<link href="<%=contextPath%>/common/skin/login.css" rel="stylesheet" />
<script type="text/javascript" src="<%=contextPath%>/js/jquery-1.10.1.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/global.js" ></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/mainFrame.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/json2.js"></script>
<script type="text/javascript">
var windowID = null;
var currPage =1;
var totalPage =null;
function doInit(paramArray) {
	windowID = paramArray['windowID'];
}

function openTabPage(menuName, openURL) {
	menu_open(menuName, openURL);
	window.parent.$('#' + windowID).window('close');
}

function openWbTabPage(menuName, openURL) {
	menu_open(menuName, openURL);
	window.parent.$('#' + windowID).window('close');
}

function loadIcon(){
	$.ajax({
		type:"POST",
		sync:true,
		url:contextPath+"/func/queryFunc",
		data:{},
		dataType:'json',
		success:function(json){
			var len = json.length;
			var pageCount = parseInt(len/10);
			if(len%10>0){
				pageCount = pageCount +1;
			}
			totalPage = pageCount;
			var pageHtml = "";
			for(var i=0;i<pageCount;i++){
				pageHtml+="<span id='page_"+(i+1)+"' style='margin:0 auto;color:#D1D1D1;height:5px;text-align:center;padding:20px;display:inline'>▄</span>";
			}
			$("#pageCount").append(pageHtml);
			
			var iconHtml = "";
			var userid = "<%= userInfo.getUserId() %>";
			if(userid== "610113197208231717" ){
				iconHtml +="<ul class=\"\" id=\"pg1\" >";
				iconHtml+="<li onclick=\"openWbTabPage('巡检系统', 'http://10.78.17.239:9009/patrol/html/Index.html')\" style=\"cursor:pointer;\"><img src=\""+contextPath+"/images/navigator/gzdtts.png\" width=\"96\" height=\"96\"/><br/><span style='font-family:微软雅黑;font-size:13px;color:blue'>&nbsp;&nbsp;巡检系统</span></li>";
				iconHtml+="<li onclick=\"openWbTabPage('考核系统', 'http://10.78.17.239:9009/patrol/html/CheckIndex.html')\" style=\"cursor:pointer;\"><img src=\""+contextPath+"/images/navigator/gzdtts.png\" width=\"96\" height=\"96\"/><br/><span style='font-family:微软雅黑;font-size:13px;color:blue'>&nbsp;&nbsp;考核系统</span></li>";
				iconHtml+="<li onclick=\"openWbTabPage('巡逻车管理', 'http://10.78.17.239:9009/patrol/html/CarIndex.html')\" style=\"cursor:pointer;\"><img src=\""+contextPath+"/images/navigator/gzdtts.png\" width=\"96\" height=\"96\"/><br/><span style='font-family:微软雅黑;font-size:13px;color:blue'>&nbsp;&nbsp;巡逻车管理</span></li>";
				iconHtml+="<li onclick=\"openWbTabPage('巡逻员管理', 'http://10.78.17.239:9009/patrol/html/PeopleIndex.html')\" style=\"cursor:pointer;\"><img src=\""+contextPath+"/images/navigator/gzdtts.png\" width=\"96\" height=\"96\"/><br/><span style='font-family:微软雅黑;font-size:13px;color:blue'>&nbsp;&nbsp;巡逻员管理</span></li>";
				iconHtml+="<li onclick=\"openWbTabPage('执法实录', 'http://10.78.17.239:9009/patrol/html/recorderlogs.html')\" style=\"cursor:pointer;\"><img src=\""+contextPath+"/images/navigator/gzdtts.png\" width=\"96\" height=\"96\"/><br/><span style='font-family:微软雅黑;font-size:13px;color:blue'>&nbsp;&nbsp;执法实录</span></li>";
				
				iconHtml+="<li onclick=\"openWbTabPage('四色预警', 'http://10.80.1.126:8877/DL_EASYUI_Project/')\" style=\"cursor:pointer;\"><img src=\""+contextPath+"/images/navigator/gzdtts.png\" width=\"96\" height=\"96\"/><br/><span style='font-family:微软雅黑;font-size:13px;color:blue'>&nbsp;&nbsp;四色预警</span></li>";
				iconHtml+="<li onclick=\"openWbTabPage('警情分析', 'http://10.78.17.241:8877/DL_EASYUI_Project/page/alermAnalyse/index.jsp')\" style=\"cursor:pointer;\"><img src=\""+contextPath+"/images/navigator/gzdtts.png\" width=\"96\" height=\"96\"/><br/><span style='font-family:微软雅黑;font-size:13px;color:blue'>&nbsp;&nbsp;警情分析</span></li>";
				iconHtml+="<li onclick=\"openWbTabPage('可防性案件', 'http://10.78.17.241:8877/DL_EASYUI_Project/page/alermAnalyse/index.jsp')\" style=\"cursor:pointer;\"><img src=\""+contextPath+"/images/navigator/gzdtts.png\" width=\"96\" height=\"96\"/><br/><span style='font-family:微软雅黑;font-size:13px;color:blue'>&nbsp;&nbsp;可防性案件</span></li>";
				iconHtml+="<li onclick=\"openWbTabPage('GPS巡值管理', 'http://10.80.1.126:8877/Gps1')\" style=\"cursor:pointer;\"><img src=\""+contextPath+"/images/navigator/gzdtts.png\" width=\"96\" height=\"96\"/><br/><span style='font-family:微软雅黑;font-size:13px;color:blue'>&nbsp;&nbsp;GPS巡值管理</span></li>";
				iconHtml+="</ul>";
			}else{
				for(var i=0;i<pageCount;i++){
				 iconHtml +="<ul class=\"\" id=\"pg"+(i+1)+"\" >";
				 	for(var j=(i*10);j<((i+1)*10);j++){
				 		var sm = json[j].sm;
				 		if(sm.length > 4 && sm.substr(0, 4) == "http"){
				 			//iconHtml+="<li onclick=\"window.open('"+sm+"')\" style=\"cursor:pointer;\"><img src=\""+contextPath+""+json[j].url+"\" width=\"96\" height=\"96\"/><br/><span style='font-family:微软雅黑;font-size:13px;color:blue'>&nbsp;&nbsp;"+json[j].mc+"</span></li>";
				 			iconHtml+="<li onclick=\"openWbTabPage('"+json[j].mc+"', '"+json[j].sm+"')\" style=\"cursor:pointer;\"><img src=\""+contextPath+""+json[j].url+"\" width=\"96\" height=\"96\"/><br/><span style='font-family:微软雅黑;font-size:13px;color:blue'>&nbsp;&nbsp;"+json[j].mc+"</span></li>";
				 		}else{
					 		iconHtml+="<li onclick=\"openTabPage('"+json[j].mc+"', '"+json[j].sm+"')\" style=\"cursor:pointer;\"><img src=\""+contextPath+""+json[j].url+"\" width=\"96\" height=\"96\"/><br/><span style='font-family:微软雅黑;font-size:13px;color:blue'>&nbsp;&nbsp;"+json[j].mc+"</span></li>";	
				 		}
				 		if(j>=(len-1)){
				 			break;
				 		}
				 	}
					iconHtml+="</ul>";
				}
			}
			
			$(".picbox").append(iconHtml);
		}
	});
}
</script>
</head>
<body style="background:none;overflow:hidden">

<div class="box" >
	<div class="picbox">
	
	
     <ul class="piclist swaplist">
     </ul>
	</div>
	<div class="og_prev"></div>
	<div class="og_next"></div>
</div>
	<div style="text-align:center;width:100%;margin-bottom:10px;align:center" id ="pageCount">
	
	</div>
	
    <div class="peizhi"><img src="<%=contextPath%>/common/skin/images/peizhi.png" width="434" height="45" onclick="window.top.openWindow(false,'', contextPath + '/navigator/query?id='+<%=id %>, {document: document}, {title: '配置导航项',    
	    width: 690,   
	    height: 450,  
		collapsible: false, 
		minimizable: false, 
		maximizable: false,
		closable: true,
	    closed: false,    
	    cache: false,
	    inline: false,
		resizable: false, 
	    modal: true})"/></div>
<script type="text/javascript">
$(document).ready(function(e) {
	$(".og_next").click(function(){
		if(currPage ==null || currPage ==totalPage || currPage>totalPage){
			return;
		}else{
			$("#pg"+currPage).hide("slow");
			$("#pg"+(currPage+1)).show("slow");
			changColor(currPage+1);
			currPage = currPage+1;
		}
	});
	
	$(".og_prev").click(function(){
		if(currPage=="1" || currPage=="0" || currPage<0){
			return ;
		}else{
			$("#pg"+currPage).hide("slow");
			$("#pg"+(currPage-1)).show("slow");
			changColor(currPage-1);
			currPage = currPage-1;
		}
	});
	loadIcon();
	setTimeout("changColor(1)",100);
});

function changColor(currPage){
	for(var i=1;i<=totalPage;i++){
		if(currPage==i){
			$("#page_"+i).css("color","blue");
		}else{
			$("#page_"+i).css("color","#D1D1D1");
		}
	}
}
</script>

</body>
</html>