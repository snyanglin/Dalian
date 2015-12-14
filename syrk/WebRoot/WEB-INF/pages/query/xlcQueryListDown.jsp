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
  <!--
  var markerArr = parent.frames.markerArrZdrk;
  var option = parent.frames.options;
  
  function getParm(name){
	  var flag = ""; 
  	  var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
  	  var r = window.location.search.substr(1).match(reg);
  	  if(r != null){
  		  flag = unescape(r[2]);
  	  } 
  	  return flag;
  }
var gxsxj_="";
var gxpcs_="";

  $(function(){
	 
	   gxsxj_ = "";
	   gxpcs_ = "";
	  gxsxj_ = getParm("gxsxj");
	  gxpcs_ = getParm("gxpcs");
      if(gxsxj_=="2102000000000"){
        alert('公安局无定位数据!');
        return;
      }
      if(gxsxj_==""){
    	  return;
      }
  	var obj = parent.frames.document.getElementById("biz_center").contentWindow;
  	 obj.XjMap.show_dw_map_xlc(gxsxj_);
      showxlc();
	  initOpeDiv();
	 // showqbbj_xlc();

  });


  var xlcmakelist=new Array();
  var xlcfootlist=new Array();
  var xlcMovemaplist=new Array();

  var showxlc=function(){
	var obj = parent.frames.document.getElementById("biz_center").contentWindow;
  	var	xlcmaplist=new Array();
		xlcmakelist=new Array();
  	 	$.ajax({
  		url:contextPath+"/xlcSevlet?gxsxj="+ gxsxj_ + "&gxpcs=" + gxpcs_,
  		type:"post",
  		dataType:"xml",
     	success:function(xmls){
 
	$(xmls).find('menu').each(function(idx){
        var carno="";
	    var callno="";	
		var bm="";	
		var type="";		
		var zbx="";	
		var zby="";
	    var gpsid="";
	    carno= $(this).attr("carno");
	    callno= $(this).attr("callno");	
        bm= $(this).attr("bm");	
        type=$(this).attr("type");	
        zbx=$(this).attr("x");	
        zby=$(this).attr("y");
        gpsid=$(this).attr("gpsid"); 	
       var id_s="aaa"+(idx+1);
       xlcmaplist.push(zbx+"||"+zby+"||"+carno+"||"+gpsid);
       var makes=obj.XjMap.showmap_xlc_make(xlcmaplist[idx]);
       xlcmakelist.push({id:id_s,"cph":carno,"hh":callno,"lx":type,"ssbm":bm,"zbx":zbx,"zby":zby,"gpsid":gpsid,"makes":makes}); 
   
      }
   );

		showmapPoint_xlc();
		},
		error:function(){
			
		}
	});
};
function showmapPoint_xlc(){
	   //每10秒执行
	   showqbbj_xlc();

}

var timer_xlc;
function showqbbj_xlc(){
	  window.clearInterval(timer_xlc);
	  timer_xlc= window.setInterval("show5MOVExlc()",10000);

}
//解除
function jscx_xlc(){
	  window.clearInterval(timer_xlc);
}

//因为数据不全查全部
var show5MOVExlc=function(){
	var obj = parent.frames.document.getElementById("biz_center").contentWindow;
var	xlcnewmakelist=new Array();
	xlcMovemaplist=new Array();
 	xlcfootlist =new Array();
	$.ajax({
  		url:contextPath+"/xlcSevlet?gxsxj="+ gxsxj_ + "&gxpcs=" + gxpcs_,
		type:"post",
		dataType:"xml",
 	    success:function(xmls){

      $(xmls).find('menu').each(function(idx){
    	 var carno="";
  	    var callno="";	
  		var bm="";	
  		var type="";		
  		var zbx="";	
  		var zby="";
  	    var gpsid="";
  	    carno= $(this).attr("carno");
  	    callno= $(this).attr("callno");	
          bm= $(this).attr("bm");	
          type=$(this).attr("type");	
          zbx=$(this).attr("x");	
          zby=$(this).attr("y");
          gpsid=$(this).attr("gpsid"); 	
         var id_s="aaa"+(idx+1);
         xlcnewmakelist.push(zbx+"||"+zby+"||"+carno+"||"+gpsid);
         var makesE=obj.XjMap.showmap_xlc_MAKENEW(xlcnewmakelist[idx]);
         xlcMovemaplist.push({id:id_s,"cph":carno,"hh":callno,"lx":type,"ssbm":bm,"zbx":zbx,"zby":zby,"gpsid":gpsid,"makes":makesE}); 

 }
);

 showstatistics_xlc();

	},
	error:function(){
		
	}
});
};



//计算 清除相同部分后在铺色，不同直接添加并铺色
function showstatistics_xlc(){
	if(xlcMovemaplist.length!=0){
	var obj = parent.frames.document.getElementById("biz_center").contentWindow;
	for(var i=0; i < xlcMovemaplist.length; i++){
      var tag=false;
     for (var z=0;z<xlcmakelist.length;z++){
   
         if(xlcMovemaplist[i].gpsid==xlcmakelist[z].gpsid){
  
          obj.XjMap.clearshowpoint_map_xlc(xlcmakelist[z].makes);

          xlcmakelist[z]=xlcMovemaplist[i];
      	  obj.XjMap.showmap_xlc_new(xlcMovemaplist[i]);
      	  tag=true;
      	   break;
         }
			
	  }
     if(!tag){

    	 xlcmakelist.push(xlcMovemaplist[i]);
     	  obj.XjMap.showmap_xlc_new(xlcMovemaplist[i]);
   }
	}
	}
	var obj = parent.frames.document.getElementById("biz_center").contentWindow;
    showFootlist_xlc();

}

//底部LIST

function showFootlist_xlc(){
if (xlcmakelist.length>50){
	for(var i=0; i < 50; i++){
         var id_s="aaa"+i;
    	 var carno=xlcmakelist[i].cph;
   	    var callno=xlcmakelist[i].hh;	
   		var bm=xlcmakelist[i].ssbm;	
   		var type=xlcmakelist[i].lx;		
   		var zbx=xlcmakelist[i].zbx;	
   		var zby=xlcmakelist[i].zby;
   	    var gpsid=xlcmakelist[i].gpsid;
   	 xlcfootlist.push({id:id_s,"cph":carno,"hh":callno,"lx":type,"ssbm":bm,"zbx":zbx,"zby":zby,"gpsid":gpsid}); 

	}
}else{
		for(var i=0; i < xlcmakelist.length; i++){
	         var id_s="aaa"+i;
	    	 var carno=xlcmakelist[i].cph;
	    	    var callno=xlcmakelist[i].hh;	
	    		var bm=xlcmakelist[i].ssbm;	
	    		var type=xlcmakelist[i].lx;		
	    		var zbx=xlcmakelist[i].zbx;	
	    		var zby=xlcmakelist[i].zby;
	    	    var gpsid=xlcmakelist[i].gpsid;
	    	 xlcfootlist.push({id:id_s,"cph":carno,"hh":callno,"lx":type,"ssbm":bm,"zbx":zbx,"zby":zby,"gpsid":gpsid}); 

		}

}
	
	$('#xlc_yh').datagrid('loadData',xlcfootlist);
}




  var initOpeDiv=function(){
	  
  $('#xlc_yh').datagrid({
  	    width:900,
       columns:[[    
  		    {field:'cph',title:'车牌号',width:150,align:'center'},    
  		    {field:'hh',title:'呼号',width:150,align:'center'},    
  		    {field:'lx',title:'巡逻车类型',width:200,align:'center'},        
  		    {field:'ssbm',title:'所属部门',width:200,align:'center'},
  		    {field:'zbx',hidden:true,width:0},   
  		    {field:'zby',hidden:true,width:0},
  		    {field:'gpsid',hidden:true,width:0}        
   
  	    ]],
  	    data:[],
  		onClickRow:function(index,row){
		var obj = parent.frames.document.getElementById("biz_center").contentWindow;
		obj.XjMap.showpoint_map_xlc(row.cph,row.zbx,row.zby,row.gpsid);
		 }
  	});
  	
  };


  
  -->
</script>
</head>
<body class="easyui-layout" data-options="fit:true">  
  <table id="xlc_yh" data-options="pagination:false">
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
		//mapWindow.XjMap.clearMarkers();
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