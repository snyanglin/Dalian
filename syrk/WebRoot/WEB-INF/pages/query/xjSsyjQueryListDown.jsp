<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.founder.framework.config.SystemConfig" %>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ include file="/WEB-INF/pages/commonMap.jsp"%>
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
  var markerArr = parent.frames.markerArrAj;
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

  var ko1="";
  var ko2="";
  var allS_ssyj=new Array();
  var allQ_ssyj=new Array();
  
  //父页面调用的方法
  function init(p1, p2){
	  ko1="";
	  ko2="";
	  allS_ssyj=new Array();
	  allQ_ssyj=new Array();
	  ko1=p1;
	  ko2=p2;
	  showbegin();
  }
	  
  $(function(){
	  var kk = "";
	  var ssyj_zzjgdm = "";
	  var ssyj_zzjglx = "";
	  var time1 = "";
	  var time2 = "";
	  var chestr = "";
	  kk = getParm("kk");
	  initOpeDiv();
	  if(kk=='0'||kk=='1'){
	  ssyj_zzjgdm = getParm("ssyj_zzjgdm");
	  ssyj_zzjglx = getParm("ssyj_zzjglx");
	  time1 = getParm("time1");
	  time2 = getParm("time2");
	  chestr = getParm("chestr");
	 	var mapWindow = null;    
	 	if (IE) {
			mapWindow = parent.frames["biz_center"];
		}
		else {
			mapWindow = parent.frames.document.getElementById("biz_center").contentWindow;
		}
		mapWindow.XjMap.showcx_(kk,ssyj_zzjgdm,ssyj_zzjglx,time1,time2,chestr);
	  }
	
  });
function showbegin(){
	   var allneirong_ssyj=ko1.split("==");
       var allneirong_ssyj_list=ko2.split("==");
 
			for(var k=0;k<allneirong_ssyj.length-1;k++){
				var  ss=allneirong_ssyj[k].split("||");
				//star
				allS_ssyj.push({id:ss[0],"mc":ss[1],"sum":ss[2],"fz":ss[3],"bfb":ss[5],"ys":ss[4]}); 
			}
			for(var k1=0;k1<allneirong_ssyj_list.length-1;k1++){
				allQ_ssyj.push(allneirong_ssyj_list[k1]);
			}
		   
		$('#ssyj_yh').datagrid('loadData',allS_ssyj);
	
}

  var initOpeDiv=function(){

  $('#ssyj_yh').datagrid({
  	    width:900,
       columns:[[    
  		    {field:'mc',title:'部门名称',width:150,align:'center'},    
  		    {field:'sum',title:'警情总数',width:150,align:'center'},    
  		    {field:'fz',title:'阀值',width:200,align:'center'},
  		    {field:'bfb',title:'变化幅度（百分比）',width:200,align:'center'},        
  		    {field:'ys',title:'预警级别（颜色）',width:200,align:'center',formatter:patrolLineListOpeFormater}
   
  	    ]],
  	    data:[],
  	    view:detailview,
  	    detailFormatter:function(index,row){
  			return "<div style='height:50px'><table id='ssyjq"+index+"'></table></div>";
  		},
  	    onExpandRow:function(index,row){
  			$('#ssyjq'+index).datagrid({
  				height:150,
  				fitColumns:true,
  				columns:[[    
  				 {field:'z_1',title:'三年前同比警情',width:150,align:'center'},
  		         {field:'z_2',title:'两年前同比警情',width:150,align:'center'},      
  		         {field:'z_3',title:'一年前同比警情',width:150,align:'center'},  
  		         {field:'z_4',title:'上一年度同期同比警情数量',width:200,align:'center'},  
  		         {field:'z_5',title:'本年度上一周期环比警情数量',width:200,align:'center'},  
  		         {field:'z_6',title:'前一年警情数量',width:150,align:'center'}  
  			    ]],
  				data:showeachnr_(row.id),
  				onClickRow:function(index,row){
  					
  				}
  			});

  		}
  	});
  	
  };

  
  function showeachnr_(id){
		var date="";
		var newnei_ssyj=new Array();
		for(var k=0;k<allQ_ssyj.length;k++){

			 var s=allQ_ssyj[k].split("||");
			 if(s[0]==id){
			 newnei_ssyj.push({"z_1":s[1],"z_2":s[2],"z_3":s[3],"z_4":s[4],"z_5":s[5],"z_6":s[6]}); 
			}

			
	}
	    date=newnei_ssyj;
	  
	return date;
	}


    var patrolLineListOpeFormater=function(val, row, index){
   	return '<div style="cursor:hand;width:60px;height:20px;background='+row.ys+'" />';
  };
  -->
</script>
</head>
<body class="easyui-layout" data-options="fit:false,pagination:false">  

            	<table id="ssyj_yh" data-options="pagination:false">
            		<!-- onClickRow:doOnClickRow 单击行事件 --> 
				  
				</table>
		 
</body>
<script type="text/javascript">

function onSelectRow(rowIndex, data){
	if(typeof(markerArr[rowIndex])!="undefined" && markerArr[rowIndex]!="" && markerArr[rowIndex]!=null){
		if (IE) {
			parent.frames["biz_center"].XjMap.centerByPoint(markerArr[rowIndex],19,data, 'aj');
		}else{
			var obj = parent.frames.document.getElementById("biz_center").contentWindow;
			obj.XjMap.centerByPoint(markerArr[rowIndex],19,data, 'aj');
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
				if (option.indexOf('aj') != -1) {
					var marker = null;
					if (IE) {
						marker = mapWindow.addMarker('盗',rows[i].zbx,rows[i].zby,"location.png",null,null,34,34,false,rows[i], 'aj');
					}
					else {
						marker = mapWindow.addMarker('盗',rows[i].zbx,rows[i].zby,"location.png",null,null,32,32,false,rows[i], 'aj');
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
		var allmark_FJ_ssyj=parent.frames.allmark_FJ_ssyjs;
		var allmark_PCS_ssyj=parent.frames.allmark_PCS_ssyjs;
		var allplane_FJ_ssyj=parent.frames.allplane_FJ_ssyjs;
		var allplane_PCS_ssyj=parent.frames.allplane_PCS_ssyjs;
		if(allmark_PCS_ssyj.length!=0){
		    for(var i1=0; i1 < allmark_PCS_ssyj.length; i1++){
		    	mapWindow.XjMap.map._MapApp.removeOverlay(allmark_PCS_ssyj[i1]);
		    }
	        for(var i2=0; i2 < allplane_PCS_ssyj.length; i2++){
	        	mapWindow.XjMap.map._MapApp.removeOverlay(allplane_PCS_ssyj[i2]);
		    }
		}
			
		if(allmark_FJ_ssyj.length!=0){
		    for(var i3=0; i3 < allmark_FJ_ssyj.length; i3++){
		    	mapWindow.XjMap.map._MapApp.removeOverlay(allmark_FJ_ssyj[i3]);
		    }
	        for(var i4=0; i4 < allplane_FJ_ssyj.length; i4++){
	        	mapWindow.XjMap.map._MapApp.removeOverlay(allplane_FJ_ssyj[i4]);
		    }
		    
		}
	}
	parent.frames.document.getElementById('biz_center').contentWindow.XjMap.removeMark();
}

</script>  

</html>