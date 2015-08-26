<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.founder.framework.config.SystemConfig" %>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<style type="text/css">
	.searchText {
	   font-size: 13px;
	   font-color: #222222;
	   height: 32px;
	   border: 1px solid #95B8E7;
	   line-height：32px;
	   padding-left: 5px;
	   padding-top: 8px;
	   width:200px;
	}

	.searchIcon {
		width:28px;
		height:28px;
   		background: url('<%=contextPath%>/images/search_icon.png') no-repeat center;
   		cursor: pointer;
	}
	
</style>
<script type="text/javascript">

  function getParm(name){
	  var flag = ""; 
  	  var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
  	  var r = window.location.search.substr(1).match(reg);
  	  if(r != null){
  		  flag = unescape(r[2]);
  	  } 
  	  return flag;
  }
var lx1_="";
var lx2_="";
var lx3_="";
var zsum="0";
var  onlinesum="0";

  var gpsmaplist=new Array();
  var gpsMovemaplist=new Array();
   var gpsfootlist =new Array();
   


  $(function(){
	   lx1_="";
	   lx2_="";
	   lx3_="";
	   lx1_ = getParm("lx1");
	   lx2_ = getParm("lx2");
	   lx3_ = getParm("lx3");
	   if(lx1_==""){
    	return;
      }
	
  	var obj = parent.frames.document.getElementById("biz_center").contentWindow;
  	 obj.XjMap.show_dw_map_gps();
      initOpeDiv();
      jscx_gps();
      showgps();

  });


 
  //所有4分钟在线车辆
  var showgps=function(){

  	var obj = parent.frames.document.getElementById("biz_center").contentWindow;
  
  	var gpsmakelist=new Array()
  	 gpsfootlist =new Array();
	 obj.XjMap.show_dw_map_gps_clear();
	
  	$.ajax({
  		url:contextPath+"/showzzjgsevlet?type=14&fz=4&pdz=1&lx1="+ lx1_+ "&lx2=" + lx2_+ "&lx3=" + lx3_,
  		type:"post",
  		dataType:"xml",
     	success:function(xmls){

	$(xmls).find('menu').each(function(idx){
        
	
		var hh="";	
		var cph="";	
		var dw="";
		var lx="";		
		var zbx="";	
		var zby="";
	    var gpsid="";
	    var times="";
	   
	   hh= $(this).attr("hh");	
	   cph= $(this).attr("cph");	
	   dw= $(this).attr("dw");	
	   lx=$(this).attr("lx");	
       zbx=$(this).attr("x");	
       zby=$(this).attr("y");
       gpsid=$(this).attr("gpsid"); 
       times=$(this).attr("times"); 
       zsum=$(this).attr("sum"); 

       gpsmakelist.push(zbx+"||"+zby+"||"+cph+"||"+hh+"||"+gpsid+"||"+dw+"||"+lx+"||"+times);
       var makes=obj.XjMap.showmap_gps(gpsmakelist[idx]);
       gpsmaplist.push({"zbx":zbx,"zby":zby,"cph":cph,"gpsid":gpsid,"dw":dw,"lx":lx,"tims":times,"makes":makes}); 
     //  obj.XjMap.clearshowpoint_map_gps(makes);
     
    }

    
   );
	onlinesum=gpsmaplist.length; 
	obj.XjMap.show_dw_sum_gps(zsum,onlinesum);
//	showmapPoint_gps();
	showFootlist_gps();
		},
		error:function(){
			
		}
	});
};

//
function showmapPoint_gps(){

   //没几秒执行
   showqbbj_gps();
     
}

var timer_gps;

function showqbbj_gps(){
	show5MOVEgps();
	//  window.clearInterval(timer_gps);
	//  timer_gps= window.setInterval("show5MOVEgps()",10000);

}
function jscx_gps(){
	  window.clearInterval(timer_gps);
}


//fz=1正常fz=4演示
var show5MOVEgps=function(){
	var obj = parent.frames.document.getElementById("biz_center").contentWindow;
var	gpsnewmakelist=new Array();
	gpsMovemaplist=new Array();
 	gpsfootlist =new Array();
	$.ajax({
		url:contextPath+"/showzzjgsevlet?type=14&fz=1&pdz=2&lx1="+ lx1_+ "&lx2=" + lx2_+ "&lx3=" + lx3_,
		type:"post",
		dataType:"xml",
 	success:function(xmls){
		gpsfootlist=new Array();
		gpsMovemaplist=new Array();

      $(xmls).find('menu').each(function(idx){
    var hh="";	
	var cph="";	
	var dw="";
	var lx="";		
	var zbx="";	
	var zby="";
    var gpsid="";
    var times="";

   hh= $(this).attr("hh");	
   cph= $(this).attr("cph");	
   dw= $(this).attr("dw");	
   lx=$(this).attr("lx");	
   zbx=$(this).attr("x");	
   zby=$(this).attr("y");
   gpsid=$(this).attr("gpsid"); 
   times=$(this).attr("times"); 
 //  var obj={};
 //  obj.zbx=zbx;
 //  obj.marker=new Marker();
 //  gpsMovemaplist.push(obj);
 
   gpsnewmakelist.push(zbx+"||"+zby+"||"+cph+"||"+hh+"||"+gpsid+"||"+dw+"||"+lx+"||"+times);
   var makesE=obj.XjMap.showmap_gps_MAKENEW(gpsnewmakelist[idx]);
   gpsMovemaplist.push({"zbx":zbx,"zby":zby,"cph":cph,"gpsid":gpsid,"dw":dw,"lx":lx,"tims":times,"makes":makesE}); 
  
 }
);

 showstatistics_gps();

	},
	error:function(){
		
	}
});
};

//计算 清除相同部分后在铺色，不同直接添加并铺色
function showstatistics_gps(){
	if(gpsMovemaplist.length!=0){
	var obj = parent.frames.document.getElementById("biz_center").contentWindow;
	for(var i=0; i < gpsMovemaplist.length; i++){
        var tag=false;
       for (var z=0;z<gpsmaplist.length;z++){
     
           if(gpsMovemaplist[i].gpsid==gpsmaplist[z].gpsid){
    
            obj.XjMap.clearshowpoint_map_gps(gpsmaplist[z].makes);

        	  gpsmaplist[z]=gpsMovemaplist[i];
        	  obj.XjMap.showmap_gps_new(gpsMovemaplist[i]);
        	  tag=true;
        	   break;
           }
			
	  }
       if(!tag){

    	  gpsmaplist.push(gpsMovemaplist[i]);
       	  obj.XjMap.showmap_gps_new(gpsMovemaplist[i]);
     }
	}
	}
 	var obj = parent.frames.document.getElementById("biz_center").contentWindow;
	onlinesum=gpsmaplist.length;  
	obj.XjMap.show_dw_sum_gps(zsum,onlinesum);

	showFootlist_gps();

}

//底部LIST

function showFootlist_gps(){
 if (gpsmaplist.length>50){
	for(var i=0; i < 50; i++){
           var id_s="aaa"+i;
           var zbx=gpsmaplist[i].zbx;	
       	   var zby=gpsmaplist[i].zby;	
       	   var cph=gpsmaplist[i].cph;	
           var hh=gpsmaplist[i].hh;			
       	   var gpsid=gpsmaplist[i].gpsid;		
       	   var dw=gpsmaplist[i].dw;	
           var lx=gpsmaplist[i].lx;
           var times=gpsmaplist[i].times;	
       	 gpsfootlist.push({id:id_s,"cph":cph,"hh":hh,"dw":dw,"lx":lx,"zbx":zbx,"zby":zby,"tims":times,"gpsid":gpsid}); 

	}
 }else{
		for(var i=0; i < gpsmaplist.length; i++){
	           var id_s="aaa"+i;
	           var zbx=gpsmaplist[i].zbx;	
	       	   var zby=gpsmaplist[i].zby;	
	       	   var cph=gpsmaplist[i].cph;	
	           var hh=gpsmaplist[i].hh;			
	       	   var gpsid=gpsmaplist[i].gpsid;		
	       	   var dw=gpsmaplist[i].dw;	
	           var lx=gpsmaplist[i].lx;
	           var times=gpsmaplist[i].times;		
	       		 gpsfootlist.push({id:id_s,"cph":cph,"hh":hh,"dw":dw,"lx":lx,"zbx":zbx,"zby":zby,"tims":times,"gpsid":gpsid}); 

		}

 }
	
	$('#gps_yh').datagrid('loadData',gpsfootlist);
}
//底页面
  var initOpeDiv=function(){

$('#gps_yh').datagrid({
  	   width:900,
       columns:[[    
  		    {field:'cph',title:'车牌号',width:150,align:'center'},    
  		    {field:'hh',title:'呼号',width:150,align:'center'},    
  		    {field:'dw',title:'所属机构',width:200,align:'center'},
  		    {field:'lx',title:'类型',width:200,align:'center'},        
  
  		    {field:'zbx',hidden:true,width:0},   
  		    {field:'zby',hidden:true,width:0},
  		    {field:'tims',hidden:true,width:0},
  		    {field:'gpsid',hidden:true,width:0}        
   
  	    ]],
  	    data:[],
  		onClickRow:function(index,row){
		var obj = parent.frames.document.getElementById("biz_center").contentWindow;

		obj.XjMap.showpoint_map_gps(row.zbx,row.zby,row.cph,row.hh,row.gpsid,row.dw,row.lx,row.tims);
		 }
  	});
  	
  };


  
  -->
</script>
</head>
<body class="easyui-layout" data-options="fit:true">  
  <table id="gps_yh" data-options="pagination:false">
	</table>
</body>
<script type="text/javascript">

function onSelectRow(rowIndex, data){
	if(typeof(markerArr[rowIndex])!="undefined" && markerArr[rowIndex]!="" && markerArr[rowIndex]!=null){
		if (IE) {
			parent.frames["biz_center"].XjMap.centerByPoint(markerArr[rowIndex],19,data.jzdzdm);
		}else{
			var obj = parent.frames.document.getElementById("biz_center").contentWindow;
			obj.XjMap.centerByPoint(markerArr[rowIndex],19,data.jzdzdm);
		}
	}else{
		//alert("人员无坐标");
	}
}

var addressPrefix = "<%=SystemConfig.getString("addressPrefix")%>";
var addressPrefixArray = addressPrefix.split(",");

//截地址字段
function subjzdz(val, row, index){
	for (var i = 0; i < addressPrefixArray.length; i++) {
		val = val.replace(addressPrefixArray[i], "");
	}
	return val;
}

//页面载入画点
function loadPoints(data) {
	//延迟加载统计
	beforeTableLoad(data,'dg');
	
	var mapWindow = null;
	if (IE) {
		mapWindow = parent.frames["biz_center"];
	}
	else {
		mapWindow = parent.frames.document.getElementById("biz_center").contentWindow;
	}
	if ("undefined" != typeof mapWindow && mapWindow != null) {
		if (mapWindow.XjMap) {
			mapPoint(mapWindow);
		}
		else {
			setTimeout(function() {mapPoint(mapWindow);}, 3000);
		}
	}
}

function mapPoint(mapWindow) {
	if (mapWindow.XjMap) {
		var rows = $('#dg').datagrid("getRows");
		var len = rows.length;
		for (var i = 0; i < len; i++) {
			var dz = rows[i].dz_jzdzxz;
			if (dz != "" && rows[i].zbx != null && rows[i].zbx != "") {
				if (option.indexOf('zdrk') != -1) {
					var marker = null;
					if (IE) {
						marker = mapWindow.addMarker(dz,rows[i].zbx,rows[i].zby,"location.png",null,null,34,34,false,rows[i].dz_jzdzdm, 'zdrk');
					}
					else {
						marker = mapWindow.addMarker(dz,rows[i].zbx,rows[i].zby,"location.png",null,null,32,32,false,rows[i].dz_jzdzdm, 'zdrk');
					}
					markerArr.push(marker);
				}
			}
		}
	}
}

//清空已存在坐标点
function clearPoints(){
	var mapWindow = null;
	if (IE) {
		mapWindow = parent.frames["biz_center"];
	}
	else {
		mapWindow = parent.frames.document.getElementById("biz_center").contentWindow;
	}
	if ("undefined" != typeof mapWindow && mapWindow != null) {
		if(markerArr != null){
			var markerLen = markerArr.length;
			for(var j=0;j<markerLen;j++){
				mapWindow.XjMap.map._MapApp.removeOverlay(markerArr[j]);
			}
		}
	}
	mapWindow.XjMap.map._MapApp.closeInfoWindow();
}

</script>  

</html>