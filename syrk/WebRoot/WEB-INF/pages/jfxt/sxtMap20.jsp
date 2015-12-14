<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>




<!-- 
<script type="text/javascript" src="http://10.80.5.222:9080/EzServerClientNew/js/EzMapAPI.js"></script>
<script type="text/javascript" src="<%=contextPath%>/js/tools/map/map.js"></script>
 -->
<!-- 必须是这个js版本 -->
<script type="text/javascript" src="<%=contextPath%>/js/jquery_1.5.min.js"></script>


<!-- 用绝对地址引用，否则错误！ -->
<script type="text/javascript" src="http://10.80.1.165:9080/PGIS_S_TileMap1/js/EzMapAPI.js"></script>


<style type="text/css">
/**/	
	v\:*{
		BEHAVIOR:url(#default#VML)
	}

	.clickRow{
		background-color:#FFEFD5;
	}
	
	table tr{
		cursor:pointer;
	}
</style>



<script type="text/javascript">
	//本市中心店坐标:121.61263,38.91223;     //地图中心点X,y

	//变量：dataInputx,dataInputy在服务器上某个js文件中定义
	var markList=[];//Mark对象列表
	var _MapApp;//全局变量
	var currentMark;//当前点位对象(Mark)
	//初始化地图
	function initMap(){
		// 实例化EzMap类，
		_MapApp=new EzMap(document.getElementById("map"));
		_MapApp.showMapControl();//显示一个地图控件，级别，放大，缩小
		_MapApp.centerAndZoom(new Point(121.77386, 39.30718),5);//根据指定的点和级别进行对中
		
		/*
		var uOverview=new OverView();//对鹰眼设计
		uOverview.width=200;
		uOverview.height=200;
		uOverview.minLevel=5;
		uOverview.maxLevel=12;		
		_MapApp.addOverView(uOverview);
		*/
	
	}//end initMap()



	//new add:用于重定位时使用的存储数组，每次重新查询前先清空
	var markerListForRelocate=[];

	//增加摄像头点位
	function addCameraMark(){
			markerListForRelocate.length=0;//清空数组
			var url="<%=contextPath%>/sptgl/querySpsxtForMap?d="+(new Date()).getTime();
			var params={};//{'queryTimeSpan':30*9};//240ms
			//返回json格式的字符串
			$.getJSON(url,params,function(cameraInfoList){			
				fillCameraInfo(cameraInfoList);//在地图上标注摄像头
				//alert(cameraInfoList.length);
			});				

	}
	

	//在地图上标注摄像头信息
	function fillCameraInfo(policeCarList){
		//遍历每一个摄像头
		$.each(policeCarList,function(index,item){
			var pIcon=new Icon(); 
			pIcon.image=basePath+"images/jfxt/"+"dz_zb01.png"; 
			pIcon.height=25; 
			pIcon.width=25; 
			
			var pCoord=new Point(item.jd,item.wd);//坐标
			var marker = new Marker(pCoord,pIcon); //实例化一个标记
			marker['_ID']=item.id;//增加属性
			//markList.push(marker);//添加Mark对象到列表中
			_MapApp.addOverlay(marker); //添加标记到地图中
			
			//add new:marker对象放入数组指定下标位置
			markerListForRelocate[index]=marker;
			
			//为标记增加click事件监听器
			marker.addListener("click",function(){
				var msg="名称："+item.dwmc+"<br>经度:"+item.jd+",纬度:"+item.wd+"<br>点位条码:"+item.tm+",朝向:"+item.cx;
				var link="<a href='javascript: drawNewPoint("+index+")'>重新定位</a>"//modify :传入下标
				msg+="<br>"+link
				marker.openInfoWindowHtml(msg);//显示摄像头点位信息
				marker.flash();//闪烁 看不到闪烁效果是因为重复点位挡住了
				//改变图标
				//pIcon.image="images/GR_PIN.GIF";
				currentMark=marker;//保存当前marker对象
				//显示当前摄像头信息
				var p=currentMark.getPoint();
				$('#id').val(item.id);//保存唯一标识
				$('#longitudeOld').val(p.x);
				$('#latitudeOld').val(p.y);
			}); 
            
            //将摄像头点位信息在行对象中
            var $tr=$("<tr></tr>"); 

            $tr.append("<td>"+(index)+"</td>");//索引(0)
            $tr.append("<td style='display:none'>"+item.tm+"</td>");//名称(1)
            $tr.append("<td>"+item.jd+"</td>");//经度(2)
            $tr.append("<td>"+item.wd+"</td>");//纬度(3)
            $tr.append("<td>"+item.dwmc+"</td>");//摄像头名称(点位名称)(4)
            $tr.append("<td style='display:none'>"+item.id+"</td>");//摄像头ID(隐藏列)(5)
            $tr.append("<td style='display:none'>"+item.cx+"</td>");//摄像头cx隐藏列)(6)

            //var bs=item.id;//标识
            //var longitude=item.jd;
            //var latitude=item.wd;
            
            //var msg="名称："+item.dwmc+"<br>经度:"+item.jd+",纬度:"+item.wd+"<br>点位条码:"+item.tm+",朝向:"+item.cx;
            //var hypeLink="<a href='javascript: drawNewPoint("+index+")'>重新定位</a>"//modify :传入下标
            //var msg="名称:"+item.dwmc+",朝向:"+item.cx+"<br>"+hypeLink;
            var curMarkerIndex=index;//对象索引
            //var rowInfo=bs+"@"+longitude+"@"+latitude+"@"+msg+"@"+curMarkerIndex;
            //$tr.data("rowInfo",rowInfo);//保存这个信息到行对象中
            //$tr.data("rowInfo",item);//保存一行信息到属性rowInfo中
            //$tr.append("<td>"+strDisplay+"</td>");//详细情况 
            $("#infoTable").append($tr);//增加行到表中
			
			
		});

	}
	
	//画摄像头新坐标
	var dataInputx;
	var dataInputy;
	function drawNewPoint(idx){
			//add new :得到当前操作对象
			var oldMarker=markerListForRelocate[idx];

			//alert(oldMarker['_ID']);
			//_MapApp.changeDragMode('drawPoint',dataInputx,dataInputy,function(result){
			_MapApp.changeDragMode('drawPoint',null,null,function(result){
				//alert(result);	
				oldMarker.closeInfoWindowHtml();//关闭气泡,这个函数开发文档中没有！			
				_MapApp.removeOverlay(oldMarker);//移除当前对象				
				//获得新位置并保存其信息，以便为修改做准备
				var coordArray=result.split(',');
				$('#longitudeNew').val(coordArray[0]);
				$('#latitudeNew').val(coordArray[1]);	

				var pIcon=new Icon();
				pIcon.image=basePath+"images/jfxt/dz_zb03.png";//绿色图标
				pIcon.height=25; 
				pIcon.width=25; 
				
				var newMarker = new Marker(new Point(coordArray[0],coordArray[1]),pIcon); //实例化一个标记
				newMarker['_ID']=oldMarker['_ID'];//为新marker添加自定义属性
				//更新对应列表行信息(经纬度坐标)
				var rowObject=$('#infoTable').children().eq(idx);//获得索引为idx的行对象
				//alert(idx+","+rowObject.children().length);
				rowObject.children().eq(2).text(coordArray[0]);//新经度
				rowObject.children().eq(3).text(coordArray[1]);//新纬度
				$('#id').val(rowObject.children().eq(5).text());//保存当前被修改对象的唯一标识id
				
				var curMarkerIndex=idx;//对象索引
				
				//为新标记增加click事件监听器
				newMarker.addListener("click",function(){
					var colArray=rowObject.children();//本行单元格(列)数组

					var msg="名称："+colArray.eq(4).text()+"<br>经度:"+colArray.eq(2).text()+",纬度:"+colArray.eq(3).text()+"<br>点位条码:"+colArray.eq(1).text()+",朝向:"+colArray.eq(6).text();
					var link="该点位已经修改过了";//"<a href='javascript: drawNewPoint("+index+")'>重新定位</a>"//modify :传入下标
					msg+="<br>"+link
					newMarker.openInfoWindowHtml(msg);//显示摄像头点位信息
					newMarker.flash();//闪烁 看不到闪烁效果是因为重复点位挡住了
					

				
				});
				
				markerListForRelocate[idx]=newMarker;//新建对象替换老对象,click事件需要重新绑定
				_MapApp.addOverlay(newMarker);//添加当前对象
				//调用保存按钮功能保存本次更改到数据库
				//alert('准备保存');
				updateCoordinate();
			
		});
	}

//开始
$(function(){
	initMap();//初始化地图
	addCameraMark();//增加摄像头
	
	bandEventForRow();//为行绑定click事件
	
})
//为行绑定click事件
function bandEventForRow(){
		////为行绑定click事件
		$("#infoTable tr").unbind('click');//解除绑定
		$("#infoTable tr").live('click',function(){
			$(this).siblings().removeClass('clickRow');//移除高亮显示的行
			$(this).addClass('clickRow');//使本行高亮显示
			
			var colArray=$(this).children();//获得当前行的单元格对象数组
			//alert(rowInfo);

			var curRowIndex=colArray.eq(0).text();//索引
			var tm=colArray.eq(1).text();
			var longitude=colArray.eq(2).text();//coords[0];
			var latitude=colArray.eq(3).text();
			var dwmc=colArray.eq(4).text();
									
			var message="名称："+colArray.eq(4).text()+"<br>经度:"+colArray.eq(2).text()+",纬度:"+colArray.eq(3).text()+"<br>点位条码:"+colArray.eq(1).text()+",朝向:"+colArray.eq(6).text();
			var link="<a href='javascript: drawNewPoint("+curRowIndex+")'>重新定位</a>"//modify :传入下标
			message+="<br>"+link;		
			//alert(dispName+","+longitude+","+latitude);//
			var pp=new Point(longitude,latitude);
			_MapApp.centerAndZoom(pp,  _MapApp.getZoomLevel());//对中			
			_MapApp.openInfoWindow(pp,message);//弹出消息框new Point(longitude,latitude)
			
			var oldMarker=markerListForRelocate[curRowIndex];//获得当前Marker
			oldMarker.flash();//闪烁
			

		})	

}
//修改坐标
function updateCoordinate(){
	//获得参数
	var id=$('#id').val();
	var longitudeNew=$('#longitudeNew').val();
	var latitudeNew=$('#latitudeNew').val();
	
	//alert(id+","+longitudeNew+","+latitudeNew);
	//更新数据库
	//markerListForRelocate.length=0;//清空数组
	var url="<%=contextPath%>/sptgl/modifyCoordinateById";
	var params={id:id,jd:longitudeNew,wd:latitudeNew};
	//返回json格式的字符串
	$.getJSON(url,params,function(result){
		var msg=(result>0)?"点位新位置已经保存":"保存失败，请与开发商联系(88058977)";
		alert(msg);
	});				
}


//测试用！
function locateByCoord(){
	var rowLength=$('#infoTable').children().length;
	alert(rowLength);
}
		
</script>

</head>
  

<body class="easyui-layout">   
    <div data-options="region:'center'" style="padding:5px;background:#eee;">
	    <div id="cc" class="easyui-layout" data-options="fit:true">   
		 	<!-- 地图区域start  -->   
		    <div data-options="region:'center',title:'中心地图区域',split:true" >
		    	<div id="map" > </div>
		    </div> 
		    <!-- 地图区域end  -->   
		    <!-- 东侧区域start  -->  
	    	<div data-options="region:'east',iconCls:'icon-reload',title:'东边',split:true" style="width:300px;">
				<!-- 摄像头唯一标识 -->
				<input type="hidden" id="id" name="id" value="">
				<fieldset style="display:none">
					<legend>摄像头点位初始坐标</legend>
					经度<input type="text" id="longitudeOld">
					纬度<input type="text" id="latitudeOld">
				</fieldset>
				<p>
				<fieldset style="display:none">
					<legend>摄像头点位当前坐标</legend>
					经度<input type="text" id="longitudeNew">
					纬度<input type="text" id="latitudeNew"><br>
					<input type="button" value="修改坐标" onclick="updateCoordinate()">
				</fieldset>
				<hr>
				<!-- 表格区域开始 -->
				<div style="height:460px;overflow-y: auto;">
					<div class="list"><!-- 列表 start -->
						<table>
						<thead>
						<tr>
							<th>行号</th>			
							<th  style='display:none'>条码</th>
							<th>经度</th>
							<th>纬度</th>
							<th>名称</th>
						</tr>
						</thead>
						<tbody id="infoTable"></tbody>
						</table>
					</div><!-- 列表 end -->
					
				</div>  
	    		<!-- 表格区域结束 -->
    
    		</div>
    		<!-- 东侧区域end  --> 
    	</div>
    	<!-- div id="cc" end  -->  
    </div>
     <!-- data-options="region:'center'" end  -->
</body>      

</html>
