<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
	<title>摄像头地图定位</title>
	<!-- 必须是这个js版本 
	<script type="text/javascript" src="<%=contextPath%>/js/jquery_1.5.min.js"></script>
	-->
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
	
	//根据点绘制图表
	function drawOverlay(theJd,theWd){
		var pIcon=new Icon();
		pIcon.image=contextPath+"/images/jfxt/dz_zb01.png";//绿色图标
		pIcon.height=25; 
		pIcon.width=25;				
		var newMarker = new Marker(new Point(theJd,theWd),pIcon); //实例化一个标记
		_MapApp.addOverlay(newMarker);//添加当前对象
		newMarker.flash();//闪烁它
		return newMarker;
	}

	
	//在新坐标处画摄像头
	var sxtMapping={}; //保存已经定位的每一个摄像头信息	
	function drawNewPoint(rowIndex){
	
			var rows = $('#dgSxt').datagrid('getData');//获得表格行对象
			var rowData = rows.rows[rowIndex];//索引为rowIndex的行对象
			//组合消息
			var message="名称："+rowData.dwmc+"<br>经度："+rowData.jd+"<br>纬度："+rowData.wd;
			var link="<a href='javascript: redrawNewPoint("+rowIndex+")'>重新定位</a>"//modify :传入下标
			message+="<br>"+link;	
							
			//alert("该行主键:"+rowData['id']+","+rowData['dwmc']);//显示该行对应的主键
			var theJd=rowData['jd'];
			var theWd=rowData['wd'];
			//if((sxtMapping[rowData.id]=='undefined') || (sxtMapping[rowData.id]==null)){//该点尚未标注在地图上
			if(!(sxtMapping[rowData.id])){//该点尚未标注在地图上
				//alert("该点尚未标注在地图上,点击标注它:");
				if(!theJd){//当前行(摄像头)尚未有坐标
					alert("使地图处于画点状态，准备画点");			
					//改变地图模式为画点
					_MapApp.changeDragMode('drawPoint',null,null,function(result){
						//获得新位置并保存其信息，以便为修改做准备
						var coordArray=result.split(',');
						theJd=coordArray[0];
						theWd=coordArray[1];
						var newMarker=drawOverlay(theJd,theWd);//画图标
						sxtMapping[rowData.id]=newMarker;//保存这个点对象
						updateCoordinate(rowData.id,theJd,theWd);//保存这个坐标到数据库
						//修改该行经纬度列的值
						$('#dgSxt').datagrid('updateRow',{index: rowIndex,row: {jd:theJd,wd: theWd}});
						//为新标记增加click事件监听器
						newMarker.addListener("click",function(){
							/*
							var msg="名称："+rowData.dwmc+"<br>经度:"+rowData.jd+",纬度:"+rowData.wd;
							var link="<a href='javascript: redrawNewPoint("+rowIndex+")'>重新定位</a>"//modify :传入下标
							msg+="<br>"+link
							*/
							var msg="名称："+rowData.dwmc+"<br>经度："+theJd+"<br>纬度："+theWd;
							var link="<a href='javascript: redrawNewPoint("+rowIndex+")'>重新定位</a>"//modify :传入下标
							msg+="<br>"+link							
							newMarker.openInfoWindowHtml(msg);//显示摄像头点位信息
							//newMarker.flash();//闪烁 看不到闪烁效果是因为重复点位挡住了
							
						});					
					});
				}//end if(!theJd)
				else{//当前行(摄像头)有经纬度
					//alert('draw point...');
					var newMarker=drawOverlay(theJd,theWd);//画图标
					sxtMapping[rowData.id]=newMarker;//保存这个点对象
					var pp=newMarker.getPoint();
					_MapApp.centerAndZoom(pp,  _MapApp.getZoomLevel());//对中			
					_MapApp.openInfoWindow(pp,message);//弹出消息框new Point(longitude,latitude)
					
					//为新标记增加click事件监听器
					newMarker.addListener("click",function(){
						//var msg="名称："+rowData.dwmc+"<br>经度:"+rowData.jd+",纬度:"+rowData.wd;
						//var link="<a href='javascript: redrawNewPoint("+rowIndex+")'>重新定位</a>"//modify :传入下标
						//msg+="<br>"+link
						newMarker.openInfoWindowHtml(message);//显示摄像头点位信息
						//newMarker.flash();//闪烁 看不到闪烁效果是因为重复点位挡住了
						
					});
				}//end else

			}
			else{//该点存在
				//闪烁该点
				//alert('旧点:');
				var existsPoint=sxtMapping[rowData.id];//取出这个点对象
				var pp=existsPoint.getPoint();
				_MapApp.centerAndZoom(pp,  _MapApp.getZoomLevel());//对中			
				_MapApp.openInfoWindow(pp,message);//弹出消息框new Point(longitude,latitude)
				//existsPoint.showTilte();//click();
				existsPoint.flash();//闪烁它
			}
	}
	//修改点位置(重新画图标)
	function redrawNewPoint(rowIndex){
		var rows = $('#dgSxt').datagrid('getData');//获得表格行对象
		var rowData = rows.rows[rowIndex];//索引为rowIndex的行对象
		//组合消息
		var message="名称："+rowData.dwmc+"<br>经度："+rowData.jd+"<br>纬度："+rowData.wd;
		var link="<a href='javascript: redrawNewPoint("+rowIndex+")'>重新定位</a>"//modify :传入下标
		message+="<br>"+link;	
		//在新位置重新绘制
		//改变地图模式为画点
		_MapApp.changeDragMode('drawPoint',null,null,function(result){
			//获得新位置并保存其信息，以便为修改做准备
			var coordArray=result.split(',');
			var theJd=coordArray[0];
			var theWd=coordArray[1];			
			var existsPoint=sxtMapping[rowData.id];//取出这个点对象
			existsPoint.closeInfoWindowHtml();//关闭气泡,这个函数开发文档中没有！
			_MapApp.removeOverlay(existsPoint);//删除标记
			var newMarker=drawOverlay(theJd,theWd);//画新图标
			sxtMapping[rowData.id]=newMarker;//用新图标替换旧图标	
			//更新该行经纬度列的值
			$('#dgSxt').datagrid('updateRow',{index: rowIndex,row: {jd:theJd,wd: theWd}});
			//调用保存按钮功能保存本次更改到数据库
			//alert('准备保存');
			updateCoordinate(rowData.id,theJd,theWd);
			
			//为新标记增加click事件监听器
			newMarker.addListener("click",function(){
				//var msg="名称："+rowData.dwmc+"<br>经度:"+rowData.jd+",纬度:"+rowData.wd;
				//var link="<a href='javascript: redrawNewPoint("+rowIndex+")'>重新定位</a>"//modify :传入下标
				//msg+="<br>"+link
				newMarker.openInfoWindowHtml(message);//显示摄像头点位信息
				//newMarker.flash();//闪烁 看不到闪烁效果是因为重复点位挡住了
			});			
		});
			
	}
	
//修改坐标
function updateCoordinate(rowId,longitudeNew,latitudeNew){
	//alert(rowId+","+longitudeNew+","+latitudeNew);
	//更新数据库
	var url="<%=contextPath%>/sptgl/modifyCoordinateById";
	var params={id:rowId,jd:longitudeNew,wd:latitudeNew};
	//返回json格式的字符串
	$.getJSON(url,params,function(result){
		var msg=(result>0)?"点位新位置已经保存":"保存失败，请与开发商联系(88058977)";
		alert(msg);
	});				
}

//日期初始化
function initDate(){
	function formatDate(curDate){
		var month=curDate.getMonth()+1;
		if(month<10) month='0'+month;
		var days=curDate.getDate();
		if(days<10) days='0'+days;
		var curDateString=curDate.getFullYear()+"-"+month+"-"+days;
		return curDateString;
	}
	
	var date1=new Date();
	var startDate=formatDate(new Date(date1.getTime()-2*24*60*60*1000));
	$('#startDate').val(startDate);
	var endDate=formatDate(date1);
	$('#endDate').val(endDate);
	
	//alert(startDate+"---"+endDate);
	
	
	
}
//清除上次保存的点位对象及其地图标记
function clearSxtMapping(){
	//alert('clearSxtMapping');
	for(obj in sxtMapping){
		_MapApp.removeOverlay(sxtMapping[obj]);//删除地图标记
		delete sxtMapping[obj];//删除属性
	}
	//alert('clearComplete....');
}

//从这里开始执行代码
$(function(){
	initDate();
	//重新定义上下文菜单，单击鼠标右键为地图平移(即取消画点操作)
	document.oncontextmenu =function(){
		_MapApp.changeDragMode("pan", null, null, null);
	}
	
	//alert(g_parentTabPageID);
	getBjzbzByOrgCode();//获得其边界坐标串
	//initMap();//初始化地图
	
})


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
				<table id="dgSxt" class="easyui-datagrid" data-options="method:'post',toolbar:'#datagridToolbar',					
		            method:'post',
		            singleSelect:true,		            
		            selectOnCheck:true,
		            checkOnSelect:true,
		            border:false,
		            sortOrder:'asc',
		            sortName:'dwmc',
		            idField:'id',
		            pageSize:getAutoPageSize(),
		            pageList:[getAutoPageSize(),getAutoPageSize() * 2]">
						    <thead>
						        <tr>
						            <th data-options="field:'dwmc', width:15,	align:'left',	halign:'center',sortable:true">点位名称</th>
						            <th data-options="field:'jd', width:15,	align:'left',	halign:'center',sortable:true">经度</th>
						            <th data-options="field:'wd', width:15,	align:'left',halign:'center',sortable:true">纬度</th>
						            <th data-options="field:'process',width:10,align:'center',	halign:'center',formatter:datagridProcessFormater">修改位置</th>
						        </tr>

						    </thead>
						</table>
				<!-- 工具条  -->
				<div id="datagridToolbar" style="padding:5px;height:30px;width:100%">
				   	<table width="100%">				   	
				   	<tr>
					   	<td width="60">开始日期：</td>
					   	<td>
					   		<input type="text" name="startDate" id="startDate"  style="width:100px;" value="2014-12-23"
							data-options="required:false,tipPosition:'right',validType:['date[\'yyyy-MM-dd\']']"  onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" /></td>
					   	</td>
					</tr>
					<tr>
					   	<td>结束日期：</td>
					   	<td>
					   		<input type="text" name="endDate" id="endDate"    style="width:100px;"  value="2014-12-26"
							data-options="required:false,tipPosition:'right',validType:['date[\'yyyy-MM-dd\']']"  onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" /></td>
					   	</td>
				    </tr>
					<tr>
					   	<td>摄像头名称:</td>
					   	<td>
					   		<input type="text" name="sxtName" id="sxtName"  />							
					   	</td>
				    </tr>						    
			        <tr>
			        	<td colspan="2">
			        	<img src ="<%=contextPath%>/images/search_btn_sousuo_01.png" style="cursor: pointer;height:32px" onclick="searchSxt();"/>
			        	<input type="checkbox" id="noCoordinate" checked="checked" value="Y">无经纬度的摄像头
			        	</td>
			        </tr>				    
				    </table>
					
				</div>
    
    		</div>
    		<!-- 东侧区域end  --> 
    	</div>
    	<!-- div id="cc" end  -->  
    </div>
     <!-- data-options="region:'center'" end  -->
</body> 
     
<script type="text/javascript">

//自定义列--定位
function datagridProcessFormater(val, row, index) { // 自定义操作生成
  return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doLocation(this,'+index+')">修改</a>&nbsp;&nbsp;';
}
//开始定位
function doLocation(linkObject, index) {
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var rows = $('#' + datagrid_ID).datagrid('getData');
	var rowData = rows.rows[index];//点击的行对象
	//alert("该行对应的主键:"+rowData['id']+","+rowData['dwmc']);//显示该行对应的主键
	drawNewPoint(index);

}

//根据条件搜索摄像头
function searchSxt(){
	clearSxtMapping();//清除上次保存的点位对象及其地图标记
	var startDate=$('#startDate').val();//开始日期
	var endDate=$('#endDate').val();//结束日期	
	var sxtName=$('#sxtName').val();//摄像头名称	
	var noCoordinate=document.getElementById('noCoordinate').checked ? "Y":"N";
	//alert(noCoordinate);
	var reloadUrl  = contextPath + '/sptgl/querySpsxtForMap2';
	//alert(startDate+","+endDate+","+reloadUrl);
	var opt = $('#dgSxt').datagrid('options');
	opt.url = reloadUrl;
	//opt1.url = reloadUrl;	
	//alert(opt.url);	
	$('#dgSxt').datagrid('reload',{startDate:startDate,endDate:endDate,dwmc:sxtName,locate:noCoordinate});

}

//日期初始化
function initDate(){
	function formatDate(curDate){
		var month=curDate.getMonth()+1;
		if(month<10) month='0'+month;
		var days=curDate.getDate();
		if(days<10) days='0'+days;
		var curDateString=curDate.getFullYear()+"-"+month+"-"+days;
		return curDateString;
	}
	
	var date1=new Date();
	var startDate=formatDate(new Date(date1.getTime()-2*24*60*60*1000));
	$('#startDate').val(startDate);
	var endDate=formatDate(date1);
	$('#endDate').val(endDate);
	
	//alert(startDate+"---"+endDate);
	
}
//2014.12.24.
$(function(){
	initDate();
	//定制页导航属性
	$('#dgSxt').datagrid('getPager').pagination({showRefresh:false,layout:['first','prev','next','last']})	
	
}) 

</script>
</html>
