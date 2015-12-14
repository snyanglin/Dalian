<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>

<%
/*
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    String bjzbz = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
        bjzbz = userInfo.getBjzbz();//获得该账号所属区域的边界坐标串
    }
 */  
    
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<!-- 必须是这个js版本 -->
<script type="text/javascript" src="<%=contextPath%>/js/jquery_1.5.min.js"></script>
<!-- 用绝对地址引用，否则错误！ -->
<script type="text/javascript" src="http://10.80.1.165:9080/PGIS_S_TileMap1/js/EzMapAPI.js"></script>


<style type="text/css">	
	v\:*{
		BEHAVIOR:url(#default#VML)
	}
</style>
<script type="text/javascript">

//根据边界坐标值获得区域边界中心
function getRegionCenter(bjzbz){
	/*清楚地图上所有的标记*/
	//DmManage.map._MapApp.clear();
	/*非地坐标*/
	var bj = bjzbz.split(";");
	var bjnum = bj.length;
	/*记录边线中心点坐标*/
	var DmManage={};
	DmManage.Mbr==null;
	//DmManage.mbrArr = new Array();
	//alert("region number="+bjnum);
	for(var j=0;j<bjnum;j++){
		var gArr = bj[j];
		/*创建边界图元素*/

		var polyline = new Polyline(gArr, "#68228B",3,1);
		//alert("polyline:=>"+polyline);
		/*图元素添加到地图上*/
		if(polyline){
			_MapApp.addOverlay(polyline);//绘制多边形区域边界线
			//DmManage.mbrArr.push(polyline);
			if(DmManage.Mbr==null){
				DmManage.Mbr = polyline.getMBR();
			}else{
				DmManage.Mbr = MBR.union(DmManage.Mbr,polyline.getMBR());
			}
		}
	}
	/*根据图元素将地图放到最适合的级别和位置*/
	//DmManage.map._MapApp.centerAtMBR(DmManage.Mbr);
	/*新版本cliect自动适应级别有问题必须降一级*/
	//DmManage.map._MapApp.zoomOut();
	return DmManage.Mbr;
}


</script>


<script type="text/javascript">

	var g_parentTabPageID=${param.tabPageID};//父窗口标签页索引
    var g_bjzbz;// 
	//本市中心店坐标:121.61263,38.91223;     //地图中心点X,y	var _MapApp;//全局变量
	//初始化地图
	function initMap(){
		// 实例化EzMap类，
		_MapApp=new EzMap(document.getElementById("map"));
		_MapApp.showMapControl();//显示一个地图控件，级别，放大，缩小
		if(g_bjzbz!="" && g_bjzbz!=null){
			var regionMbr=getRegionCenter(g_bjzbz);//获得边界中心
			//_MapApp.centerAtMBR(polyline.getMBR());//将地图平移到该账号所属区域的中心位置
			_MapApp.centerAtMBR(regionMbr);
		}
		else{
			alert("g_bjzbz为空了！！");
		}
	
	}//end initMap()


	
	//画摄像头新坐标
	var dataInputx;
	var dataInputy;
	function drawNewPoint(idx){
			//改变地图模式为画点
			_MapApp.changeDragMode('drawPoint',null,null,function(result){
				//获得新位置并保存其信息，以便为修改做准备
				var coordArray=result.split(',');

				var pIcon=new Icon();
				pIcon.image=basePath+"images/jfxt/dz_zb03.png";//绿色图标
				pIcon.height=25; 
				pIcon.width=25;				
				var newMarker = new Marker(new Point(coordArray[0],coordArray[1]),pIcon); //实例化一个标记
				_MapApp.addOverlay(newMarker);//添加当前对象
				if(!confirm('位置正确吗?')){
					_MapApp.removeOverlay(newMarker);//删除标记
					return;
				}
				//alert(coordArray[0]+","+coordArray[1]);
				//updateCoordinate();
				//将坐标写入父窗口中
				$("#jdGA",window.opener.document).val(coordArray[0]) ;
				$("#wdGA",window.opener.document).val(coordArray[1]) ;
				//closeSelf();//关闭当前标签页
				window.close();
		});
	}
//根据2级机构获得其边界坐标串
function getBjzbzByOrgCode(){
	url="<%=contextPath%>/idName/getBjzbzByOrgCode";
	//alert(url);
	//当心此处：默认为异步请求
	$.getJSON(url,function(rsult){		
		g_bjzbz=rsult;//为全局变量赋值
		//alert(g_bjzbz);
		initMap();//初始化地图
		
		
	});
	
}
//开始
$(function(){

	//重新定义上下文菜单，单击鼠标右键为地图平移
	document.oncontextmenu =function(){
		_MapApp.changeDragMode("pan", null, null, null);
	}
	
	//alert(g_parentTabPageID);
	getBjzbzByOrgCode();//获得其边界坐标串
	//initMap();//初始化地图
	
})


	
//通过地图定位摄像头坐标
function getSxtLocationByMap(){
	//alert('定位');
	drawNewPoint();

}	
window.onload=function(){
	window.moveTo(0,0);
	window.resizeTo(screen.availWidth,screen.availHeight);

}

</script>

</head>
  

<body class="easyui-layout">   
    <div data-options="region:'center'" style="padding:5px;background:#eee;">
	    <div id="cc" class="easyui-layout" data-options="fit:true">   
		 	<!-- 地图区域start  -->   
		    <div data-options="region:'center',title:'中心地图区域',tools:'#tt' ">
		    	<div id="map" > </div>
		    </div>
		    <div id="tt">				
		    	<span style="background-color:yellow">操作说明:1.首先用鼠标左键移动地图到摄像头的大致区域，然后点击该行右侧按钮在地图上定位。2.鼠标右键点击取消定位&nbsp;&nbsp;</span>
				<a href="#"   onclick="javascript:getSxtLocationByMap()">
					<img alt="开始定位" src="<%=contextPath %>/images/jfxt/dz_zb01.png" width="20" height="20" >
				</a>			
			</div>
		     
		    <!-- 地图区域end  -->   

    	</div>
    	<!-- div id="cc" end  -->  
    </div>
     <!-- data-options="region:'center'" end  -->
</body>      

</html>
