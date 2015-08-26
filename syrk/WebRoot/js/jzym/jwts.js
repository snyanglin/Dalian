if(typeof XjMap == "undefined" || !XjMap){
	var XjMap = {};
};

XjMap.gpsmaplist=new Array();//GPS集合
XjMap.zsum="0"; //GPS总数
XjMap.gpsfootlist = new Array();
/**
 * 查询警务态势信息
 */
XjMap.queryJwts = function(){
	   XjMap.map._MapApp.centerAndZoom(new Point('121.56234','38.99528'),10);//	
	   var jwtsHtml = 
		   "<div id='queryValue' style='width:400px;height:30px;'>" +
		   "<table><tr>" +
		   "<td align='center' >分县局:<input id='orgid_fj'></input></td>" +
		   "<td align='center' >派出所:<input id='orgid_pcs'></input></td></tr>" +
		   "<tr><td align='center' ><a id='queryButton' href='#' onclick='XjMap.showgps();'>查询</a></td>" +
		   "<td align='center' ><a id='newWinButton' href='#' onclick='menu_open(\"详情\", \"http://10.80.8.178:9080/Component/\");'>详情</a></td>" +
		   "</tr></table>" +
		   "</div><br>"
		   +"<div id='jwtsCount' style='width:400px;height:60px;' align='center'></div><br>"
		   +"<div id='jwtsList'  style='width:400px;height:100%;overflow:auto;'></div>";
	   $("#infoShowDiv").html(jwtsHtml);
	   $("#queryButton").linkbutton({
		   iconCls:'icon-search'
	   } 
	   );
	   $("#newWinButton").linkbutton({
		   iconCls:'icon-search'
	   } 
	   );
	   $("#orgid_fj").combobox({
		   url: basePath+'gzjk/queryOrg',
		   valueField:'id',
		   width:130, 
		   textField:'text',
		   onSelect: function(rec1){
			   var url = basePath+'gzjk/queryOrgLower?orgCode='+rec1.id;
			   $('#orgid_pcs').combobox('reload',url);
	   		}
	   });
	   $("#orgid_pcs").combobox({
		   valueField:'id',
		   width:130, 
		   textField:'text'
	   });
	  XjMap.initOpeDiv();
	  window.setTimeout(function(){ XjMap.showgps()},1000);
};
/**
 * 显示GPS车辆列表
 */
XjMap.initOpeDiv=function(){
	$('#jwtsList').datagrid({
		   width:400,
		   pageSize:10,
	       columns:[[    
	  		    {field:'cph',title:'车牌号',width:100,align:'center'},    
	  		    {field:'hh',title:'呼号',width:100,align:'center'},    
	  		    {field:'dw',title:'所属机构',width:100,align:'center'},
	  		    {field:'lx',title:'类型',width:100,align:'center'},        
	  		    {field:'zbx',hidden:true,width:0},   
	  		    {field:'zby',hidden:true,width:0},
	  		    {field:'tims',hidden:true,width:0},
	  		    {field:'gpsid',hidden:true,width:0}        
	  	    ]],
	  		onClickRow:function(index,row){
	  			XjMap.showpoint_map_gps(row.zbx,row.zby,row.cph,row.hh,row.gpsid,row.dw,row.lx,row.tims);
			}
	  	});
	$('#jwtsList').datagrid('getPager').pagination({
		showPageList:false,
		showRefresh:false,
		displayMsg : ''
	});
	$("#jwtsList").datagrid('resize', {});
  };
/**
 * 定位GPS车辆
 */
XjMap.showpoint_map_gps = function (zbx,zby,cph,hh,gpsid,dw,lx,tims){
		var _point = new Point(zbx, zby);
		XjMap.map._MapApp.centerAndZoom(_point,12);
		var htmlStr= XjMap.addListenerEvent_gps(zbx,zby,cph,hh,gpsid,dw,lx,tims);
		XjMap.map._MapApp.openInfoWindow(_point, htmlStr, true) 
};
/**
 * GPS标记显示内容
 */
XjMap.addListenerEvent_gps = function(zbx,zby,cph,hh,gpsid,dw,lx,tims){
	var htmlStr = "<table  cellspacing='0' cellpadding='2'>";
	htmlStr += "<tr>";
	htmlStr += "<td style='color:blue'>车牌号:</td><td>" +cph+ "</td>";
	htmlStr += "</tr>";
	htmlStr += "<tr>";
	htmlStr += "<td style='color:blue'>呼号:</td><td>" + hh + "</td>";
	htmlStr += "</tr>";
	htmlStr += "<tr>";
	htmlStr += "<tr>";
	htmlStr += "<td style='color:blue'>GPSID:</td><td>" + gpsid + "</td>";
	htmlStr += "</tr>";
	htmlStr += "<tr>";
	htmlStr += "<tr>";
	htmlStr += "<td style='color:blue'>所属单位:</td><td>" + dw + "</td>";
	htmlStr += "</tr>";
	htmlStr += "<tr>";
	htmlStr += "<td style='color:blue'>所属类型:</td><td>" + lx + "</td>";
	htmlStr += "</tr>";
	htmlStr += "<tr>";
	htmlStr += "<td style='color:blue'>时间:</td><td>" + tims + "</td>";
	htmlStr += "</tr>";
	htmlStr += "<tr>";
	htmlStr += "<td style='color:blue'>坐标&nbsp;&nbsp;X:</td><td>" + zbx + "</td>";
	htmlStr += "</tr>";
	htmlStr += "<tr>";
	htmlStr += "<td style='color:blue'>坐标&nbsp;&nbsp;Y:</td><td>" + zby + "</td>";
	htmlStr += "</tr>";
	htmlStr += "<tr>";
	htmlStr += "<td>&nbsp;</td>";
	htmlStr += "</tr>";
	htmlStr += "</table>";
	return htmlStr;
}

/**
 * 所有4分钟在线车辆
 */
XjMap.showgps=function(){
	 var lx1 = $("#orgid_fj").val();
	 var lx2 = $("#orgid_pcs").val()
	 if(lx1==""){
		   XjMap.show_dw_sum_gps(0,0);
		   return;
	 }
	 var gpsmakelist=new Array()
	 XjMap.gpsfootlist =new Array();
	 XjMap.map._MapApp.clear();
	 $.ajax({
		url:contextPath+"/showzzjgsevlet?type=14&fz=4&pdz=1&lx1="+ lx1+ "&lx2=" + lx2,
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
		    XjMap.zsum=$(this).attr("sum"); 
		    gpsmakelist.push(zbx+"||"+zby+"||"+cph+"||"+hh+"||"+gpsid+"||"+dw+"||"+lx+"||"+times);
		    var makes=XjMap.showmap_gps(gpsmakelist[idx]);
		    XjMap.gpsmaplist.push({"zbx":zbx,"zby":zby,"cph":cph,"gpsid":gpsid,"dw":dw,"lx":lx,"tims":times,"makes":makes}); 
	   	   	}
	   	    );
	   	  	onlinesum=XjMap.gpsmaplist.length; 
	   	  	XjMap.show_dw_sum_gps(XjMap.zsum,onlinesum);
	   	  	XjMap.showFootlist_gps();
   	  		},
   	  		error:function(){
   	  			
   	  		}
   	  	});
   	  };
/**
 * 在地图上叠加建GPS地图标记
 */
XjMap.showmap_gps = function (list){

    	var zbx=list.split("||")[0];
    	var zby=list.split("||")[1];
		 var cph=list.split("||")[2];
		 var hh=list.split("||")[3];
		 var gpsid=list.split("||")[4];
		 var dw=list.split("||")[5];
		 var lx=list.split("||")[6];
		 var tims=list.split("||")[7];
  
		 var _point = new Point(zbx, zby);
		 var _icon = new Icon();
     	_icon.image =contextPath+"/images/jzym/pad1.png";
	    
		_icon.width = 20;
		_icon.height = 20;
		var _title = new Title(gpsid, 12, 2,"宋体", "#000000", "#e4f2fc", "#00B2FF", "1");
		var  _maker = new Marker(_point, _icon, _title);
		_maker.addListener("click",function(_maker,zbx,zby,cph,hh,gpsid,dw,lx,tims){
		return function(){
				var strMsg= XjMap.addListenerEvent_gps(zbx,zby,cph,hh,gpsid,dw,lx,tims);
					_maker.openInfoWindowHtml(strMsg);
			}
		}(_maker,zbx,zby,cph,hh,gpsid,dw,lx,tims));
		 XjMap.map._MapApp.addOverlay(_maker);
		 return _maker;
};


/**
 * 统计数目
 */
XjMap.show_dw_sum_gps = function (SYRK_NUM,CZRK_NUM){
	var htmlStr="<ul class='infoUlGPS'>" +
   		"<li><h2>总车辆</h2><h3>"+SYRK_NUM+"辆</h3>" +
   		"<li><h2>在线车辆</h2><h3>"+CZRK_NUM+"辆</h3>" +
   		"</ul>";
		$("#jwtsCount").html(htmlStr);
};

//底部LIST

XjMap.showFootlist_gps = function(){
 if (XjMap.gpsmaplist.length>50){
	for(var i=0; i < 50; i++){
           var id_s="aaa"+i;
           var zbx=XjMap.gpsmaplist[i].zbx;	
       	   var zby=XjMap.gpsmaplist[i].zby;	
       	   var cph=XjMap.gpsmaplist[i].cph;	
           var hh=XjMap.gpsmaplist[i].hh;			
       	   var gpsid=XjMap.gpsmaplist[i].gpsid;		
       	   var dw=XjMap.gpsmaplist[i].dw;	
           var lx=XjMap.gpsmaplist[i].lx;
           var times=XjMap.gpsmaplist[i].times;	
           XjMap.gpsfootlist.push({id:id_s,"cph":cph,"hh":hh,"dw":dw,"lx":lx,"zbx":zbx,"zby":zby,"tims":times,"gpsid":gpsid}); 

	}
 }else{
		for(var i=0; i < XjMap.gpsmaplist.length; i++){
	           var id_s="aaa"+i;
	           var zbx=XjMap.gpsmaplist[i].zbx;	
	       	   var zby=XjMap.gpsmaplist[i].zby;	
	       	   var cph=XjMap.gpsmaplist[i].cph;	
	           var hh=XjMap.gpsmaplist[i].hh;			
	       	   var gpsid=XjMap.gpsmaplist[i].gpsid;		
	       	   var dw=XjMap.gpsmaplist[i].dw;	
	           var lx=XjMap.gpsmaplist[i].lx;
	           var times=XjMap.gpsmaplist[i].times;		
	           XjMap.gpsfootlist.push({id:id_s,"cph":cph,"hh":hh,"dw":dw,"lx":lx,"zbx":zbx,"zby":zby,"tims":times,"gpsid":gpsid}); 

		}

 }
	$('#jwtsList').datagrid('loadData',XjMap.gpsfootlist);
}