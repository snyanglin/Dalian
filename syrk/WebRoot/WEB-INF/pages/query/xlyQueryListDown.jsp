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
  	 obj.XjMap.show_dw_map_xly(gxsxj_);
	  showxly();
	  initOpeDiv();
     // showqbbj_xly();

  });

  var xlymakelist=new Array();
  var xlyfootlist=new Array();
  var xlyMovemaplist=new Array();

  //查询5分钟内在线车辆 因为无数据暂时无时间限制
  var showxly=function(){

  		var obj = parent.frames.document.getElementById("biz_center").contentWindow;
  	
  	var	xlymaplist=new Array();
  		xlymakelist=new Array();
  	
  	
  	$.ajax({
  		url:contextPath+"/xlySevlet?gxsxj="+ gxsxj_ + "&gxpcs=" + gxpcs_,
  		type:"post",
  		dataType:"xml",
     	success:function(xmls){
		
	$(xmls).find('menu').each(function(idx){
        var bm="";
	    var sfz= "";	
		var jh="";	
		var cph="";	
		var name="";	
		var zbx="";	
		var zby="";
	    var gpsid="";
	   bm= $(this).attr("bm");
	   sfz= $(this).attr("sfz");	
	   jh= $(this).attr("jh");	
	   cph= $(this).attr("cph");	
	   name=$(this).attr("name");	
       zbx=$(this).attr("x");	
       zby=$(this).attr("y");
       gpsid=$(this).attr("gpsid"); 
       var id_s="aaa"+(idx+1);
       xlymaplist.push(zbx+"||"+zby+"||"+name+"||"+gpsid);
       var makes=obj.XjMap.showmap_xly_make(xlymaplist[idx]);
       xlymakelist.push({id:id_s,"jh":jh,"hh":cph,"sfz":sfz,"xm":name,"ssbm":bm,"zbx":zbx,"zby":zby,"gpsid":gpsid,"makes":makes}); 
     }
   );

		showmapPoint_xly();
		},
		error:function(){
			
		}
	});
};
function showmapPoint_xly(){
   //每10秒执行
	   showqbbj_xly();
	}

var timer_xly;
function showqbbj_xly(){
	  window.clearInterval(timer_xly);
	  timer_xly= window.setInterval("show5MOVExly()",10000);

}
//解除
function jscx_xly(){
	  window.clearInterval(timer_xly);
}

//因为数据不全查全部
var show5MOVExly=function(){
	var obj = parent.frames.document.getElementById("biz_center").contentWindow;
var	xlynewmakelist=new Array();
	xlyMovemaplist=new Array();
 	xlyfootlist =new Array();
	$.ajax({
		url:contextPath+"/xlySevlet?gxsxj="+ gxsxj_ + "&gxpcs=" + gxpcs_,
		type:"post",
		dataType:"xml",
 	    success:function(xmls){

      $(xmls).find('menu').each(function(idx){
    	 var bm="";
  	    var sfz= "";	
  		var jh="";	
  		var cph="";	
  		var name="";	
  		var zbx="";	
  		var zby="";
  	    var GPSID="";
  	   bm= $(this).attr("bm");
  	   sfz= $(this).attr("sfz");	
  	   jh= $(this).attr("jh");	
  	   cph= $(this).attr("cph");	
  	   name=$(this).attr("name");	
         zbx=$(this).attr("x");	
         zby=$(this).attr("y");
         gpsid=$(this).attr("gpsid"); 
         var id_s="aaa"+(idx+1);

   xlynewmakelist.push(zbx+"||"+zby+"||"+name+"||"+GPSID);
   var makesE=obj.XjMap.showmap_xly_MAKENEW(xlynewmakelist[idx]);
   xlyMovemaplist.push({id:id_s,"jh":jh,"hh":cph,"sfz":sfz,"xm":name,"ssbm":bm,"zbx":zbx,"zby":zby,"gpsid":gpsid,"makes":makesE});
  
 }
);

 showstatistics_xly();

	},
	error:function(){
		
	}
});
};



//计算 清除相同部分后在铺色，不同直接添加并铺色
function showstatistics_xly(){
	if(xlyMovemaplist.length!=0){
	var obj = parent.frames.document.getElementById("biz_center").contentWindow;
	for(var i=0; i < xlyMovemaplist.length; i++){
      var tag=false;
     for (var z=0;z<xlymakelist.length;z++){
   
         if(xlyMovemaplist[i].gpsid==xlymakelist[z].gpsid){
  
          obj.XjMap.clearshowpoint_map_xly(xlymakelist[z].makes);

          xlymakelist[z]=xlyMovemaplist[i];
      	  obj.XjMap.showmap_xly_new(xlyMovemaplist[i]);
      	  tag=true;
      	   break;
         }
			
	  }
     if(!tag){

    	 xlymakelist.push(xlyMovemaplist[i]);
     	  obj.XjMap.showmap_xly_new(xlyMovemaplist[i]);
   }
	}
	}
	var obj = parent.frames.document.getElementById("biz_center").contentWindow;
    showFootlist_xly();

}

//底部LIST

function showFootlist_xly(){
if (xlymakelist.length>50){
	for(var i=0; i < 50; i++){
         var id_s="aaa"+i;
         var jh=xlymakelist[i].jh;
         var hh=xlymakelist[i].hh;
         var sfz=xlymakelist[i].sfz;
         var xm=xlymakelist[i].xm;
         var ssbm=xlymakelist[i].ssbm;
         var zbx=xlymakelist[i].zbx;
         var zby=xlymakelist[i].zby;
         var gpsid=xlymakelist[i].gpsid;
      	xlyfootlist.push({id:id_s,"jh":jh,"hh":hh,"sfz":sfz,"xm":xm,"ssbm":ssbm,"zbx":zbx,"zby":zby,"gpsid":gpsid});

	}
}else{
		for(var i=0; i < xlymakelist.length; i++){
	         var id_s="aaa"+i;
	         var jh=xlymakelist[i].jh;
	         var hh=xlymakelist[i].hh;
	         var sfz=xlymakelist[i].sfz;
	         var xm=xlymakelist[i].xm;
	         var ssbm=xlymakelist[i].ssbm;
	         var zbx=xlymakelist[i].zbx;
	         var zby=xlymakelist[i].zby;
	         var gpsid=xlymakelist[i].gpsid;
	      	xlyfootlist.push({id:id_s,"jh":jh,"hh":hh,"sfz":sfz,"xm":xm,"ssbm":ssbm,"zbx":zbx,"zby":zby,"gpsid":gpsid});

		}

}
	
	$('#xly_yh').datagrid('loadData',xlyfootlist);
}



  var initOpeDiv=function(){

$('#xly_yh').datagrid({
  	   width:900,
       columns:[[    
  		    {field:'jh',title:'警号',width:150,align:'center'},    
  		    {field:'hh',title:'呼号',width:150,align:'center'},    
  		    {field:'sfz',title:'身份证号',width:200,align:'center'},
  		    {field:'xm',title:'姓名',width:200,align:'center'},        
  		    {field:'ssbm',title:'所属部门',width:200,align:'center'},
  		    {field:'zbx',hidden:true,width:0},   
  		    {field:'zby',hidden:true,width:0},
  		    {field:'gpsid',hidden:true,width:0}        
   
  	    ]],
  	    data:[],
  		onClickRow:function(index,row){
		var obj = parent.frames.document.getElementById("biz_center").contentWindow;
		obj.XjMap.showpoint_map_xly(row.xm,row.zbx,row.zby,row.gpsid);
		 }
  	});
  	
  };


  
  -->
</script>
</head>
<body class="easyui-layout" data-options="fit:true">  
  <table id="xly_yh" data-options="pagination:false">
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