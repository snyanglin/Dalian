//ssyj
var kk = "";
var ssyj_zzjgdm ="";
var ssyj_zzjglx = "";
var time1 = "";
var time2 = "";
var chestr = "";
var jqlb = "";
var markerArr = new Array;
var intoMC = '';
var num = 0;

function intoMap(pnodes){
	//alert(JSON.stringify(pnodes));
	//alert(pnodes!='');
	if(pnodes!=''){
		var temp = "";
		for(var i=0; i<pnodes.length; i++){
			temp += pnodes[i].orgcode + ",";
		}
		var params = {zzjgdm: temp.substr(0, temp.length-1), time1: time1, time2: time2, ssyj_zzjglx: ssyj_zzjglx, chestr: chestr, jqlbdm: jqlb};
		var fajax =new FrameTools.Ajax(contextPath+"/jz/queryXjZzjgxj",queryXjZzjg_into);
		fajax.send(params);
	}
};

function queryXjZzjg_into(json){
	 
	 //alert(JSON.stringify(json));
	 //XjMap.removeMark();
	 if(json[0].bjzbz!=""){
			//XjMap.map._MapApp.clear();
		}
		if(json!=null&&json.length>0){
			//区域范围显示则四色预警清除
			//XjMap.bjJson = json;
			var countZrq = json.length;
			//"#4dc2ed", "#85d021", "#ffb543", "#ff7a7b"
			var colors = new Array("red", "green", "orange", "yellow");
			//辖区面
				 //for(var i=0;i<XjMap.countZrq;i++){
			var i = 0;
			
			/*记录当前展示的组织机构代码*/
			XjMap.zzjgdm = userOrgCode;
			/*记录当前展示的组织机构名称*/
			XjMap.zzjgmc = userOrgName;
			json.MMM = setInterval(function(){
				if(i<countZrq){
		        	if(undefined != json[i].bjzbz && null!=json[i].bjzbz && json[i].bjzbz!=""){
		        		var col = colors[i];
		        		showArea(json[i].zzjgdm, json[i].zzjgmc, json[i].bjzbz, json[i].color=='' ? 'green' : json[i].color);
		        	}
		        	
				} else {
					clearInterval(json.MMM);
				}
		        	
		        	i++;
			}, 130);
			     //}
		}
};

/**
 * @title:showArea
 * @description:各个辖区面
 * @author: sny
 * @param  begin
 * @date:2014-10-23 14:17:48
 */	


function showArea(dm,mc,zbz,col){
	var ObjMap = new Polygon(zbz, "red", 3, 0.4,col);
	var pMbr = ObjMap.getMBR();
	var cPoint = pMbr.centerPoint();
	var _pTitle = new Title(mc,12,7,"宋体","#000000","#FFFFFF","#FFFFFF","2");
	_pTitle.setPoint(cPoint);
	XjMap.map._MapApp.addOverlay(ObjMap);
	markerArr.push(ObjMap);
	markerArr.push(_pTitle);
	XjMap.map._MapApp.addOverlay(_pTitle);
	//点击下钻到责任区
	_pTitle.addListener("click", function (){
		XjMap.removeMark();
		/*加载本责任区*/
		//XjMap.showArea(dm,mc,zbz,col);
		queryXjZrq(dm);
		//全局变量
		dms = dm;
		/*根据图元素将地图放到最适合的级别和位置*/
		XjMap.map._MapApp.centerAtMBR(pMbr);
		if(userOrgCode!="210204410000"||screen.width>1600){
			/*新版本cliect自动适应级别有问题必须降一级*/
			XjMap.map._MapApp.zoomOut();
		}
		/*记录当前展示的组织机构代码*/
		XjMap.zzjgdm = dm;
		/*记录当前展示的组织机构名称*/
		XjMap.zzjgmc = mc;
		var htmlStr = "";
		if(XjMap.zzjgmc != userOrgName)
		    htmlStr+="<span class='infoOrgTitle_on' onclick='XjMap.query(\"ssyj_tj\");'>"+userOrgName+"</span>--"+XjMap.zzjgmc;
	    else
	    	htmlStr+="<span >"+userOrgName+"</span>";
		$(".infoOrgTitle").html(htmlStr);
		intoMC = mc;
	});	
	
};

function queryXjZrq(parm){
	XjMap.clearMarkers();
	XjMap.moveMapToBjzbz();
	/*新版本cliect自动适应级别有问题必须降一级*/
	XjMap.map._MapApp.zoomOut();
	if(parm!=''){
		var temp = parm["ssyj_zzjgdm"];
		if(typeof temp != "undefined"){
			kk = parm["kk"];
	 	    ssyj_zzjgdm = parm["ssyj_zzjgdm"];
	 	    ssyj_zzjglx = parm["ssyj_zzjglx"];
	 	    time1 = parm["time1"];
	 	    time2 = parm["time2"];
	 	    chestr = parm["chestr"];
	 	    jqlb = parm["jqlb"];
		} else {
			ssyj_zzjgdm = parm;
		}
		//alert(ssyj_zzjgdm);
		var params = {id: '', orgcode: ssyj_zzjgdm};
		var fajax =new FrameTools.Ajax(contextPath+"/jz/downMap", intoMap);
		fajax.send(params);
		//加载统计
		//XjMap.initFloatWin_back(pnodes);
	}
};

function zdParm_chars(ssyj_zzjgdm,ssyj_zzjgdm,ssyj_zzjglx,time1,time2,chestr){
    XjMap.queryXjChar(ssyj_zzjgdm,ssyj_zzjglx,time1,time2,chestr);
}

XjMap.queryXjChar = function (a,b,c,d,e){
	 selectTJT(a,b,c,d,e);
};

var selectTJT=function(ssyj_zzjgdm,ssyj_zzjglx,time1,time2,type){

	$.ajax({
		url:contextPath+"/SsyjtjtSevlet?type="+ type + "&time1=" + time1 + "&time2=" + time2+"&zzjgdm="+ssyj_zzjgdm+"&zzjglx="+ssyj_zzjglx,
		type:"post",
		dataType:"xml",
		success:function(xmls){
			/*
			var Tzzjg="";	
			var Tfz="";
			var Tsum="";
			$(xmls).find('menu').each(
			 function(){
			   var zzjgdm_= $(this).attr("zzjgdm");	
			     var zzjgmc_= $(this).attr("zzjgmc");
			       var sum_= $(this).attr("sum");
			       var yszs=$(this).attr("ysz");	
			        var fz_=yszs.split("||")[7];
			   Tzzjg +='{"label":"'+zzjgmc_+'"},';
			  Tfz +='{"value":"'+fz_+'"},';
			  Tsum +='{"value":"'+sum_+'"},';
			 }
		);

			jsonData='';
			if(type=='1'){
			jsonData += '{"chart":{"caption":"'+time1+'年'+time2+'月统计",';
			}else if(type=='2'){
			jsonData += '{"chart":{"caption":"'+time1+'年第'+time2+'季度统计",';
			}
			jsonData += '"numberprefix": "值", "plotgradientcolor": "","bgcolor": "FFFFFF", "showalternatehgridcolor": "0", "divlinecolor": "CCCCCC", "showvalues": "0",';
				jsonData += ' "showcanvasborder": "0", "canvasborderalpha": "0", "canvasbordercolor": "CCCCCC",  "canvasborderthickness": "1", "yaxismaxvalue": "5000", "captionpadding": "30",';
					jsonData += ' "yaxisvaluespadding": "15", "legendshadow": "0", "legendborderalpha": "0","palettecolors": "#f8bd19,#008ee4,#33bdda,#e44a00,#6baa01,#583e78", "showplotborder": "0", "showborder": "0","formatNumberScale": "0"},';
					jsonData += ' "categories": [{ "category": [';
					jsonData +=Tzzjg;
					jsonData +=' ] } ], "dataset": [ { "seriesname": "案件数", "data": [';
					jsonData +=Tsum;
					jsonData +=' ] }, {"seriesname": "阀值","data": [';
					jsonData +=Tfz;
					jsonData +='   ] } ]}';
					*/
			var colors = ["#ee431b","#e96a3b","#ee9539","#fdbe63","#f1e740","#85d021","#4dc2ed","#ffb543","#ff7a7b","#008080","#AA4400","#0000FF"];
			var colorLen=colors.length;
			var num=0;
			var zzjgs=[];
			var tfzs=[];
			var tsums=[];
			$(xmls).find('menu').each(function(){
			   var zzjgdm_= $(this).attr("zzjgdm");	
			   var zzjgmc_= $(this).attr("zzjgmc");
			   var sum_= $(this).attr("sum");
			   var yszs=$(this).attr("ysz");	
			   var fz_=yszs.split("||")[7];
			   
			   zzjgs[num]='"'+zzjgmc_+'"';
			   tfzs[num]=fz_;
			   tsums[num]=sum_;
			   ++num;
			});
			/*
			var jsonData='{';
			if(type=='1'){
				jsonData +='"title":{"text":"'+time1+'年'+time2+'月统计","style":"font-size:18px;color: #000000;"}';
			}else if(type=='2'){
				jsonData +='"title":{"text":"'+time1+'年第'+time2+'季度统计","style":"font-size:18px;color: #000000;"}';
			}
			jsonData +=',"y_axis":{"min":0,"max":5000,"steps":'+num+'}';
			jsonData +=',"bg_colour":"#FFFFFF"';
			jsonData +=',"x_axis":{"labels":{"labels":['+zzjgs.join(',')+'],"size":12}}';
			jsonData +=',"elements":[{"values":[';
			for(var i=0;i<num;i++){
				jsonData +='{"colour":"#ee431b","on-click":"","tip":"'+tsums[i]+'","top":'+tsums[i]+'}';
				if(i<num-1)jsonData +=',';
			}
			jsonData +='],"type":"bar_filled"}';
			jsonData +=',{"colour":"'+colors[~~(Math.random()*colorLen)]+'","text":"","values":[';
			for(var i=0;i<num;i++){
				jsonData +='{"y":'+tsums[i]+',"x":'+i+'}';
				if(i<num-1)jsonData +=',';
			}
			jsonData +='],"font":"Verdana","font-size":12,"type":"tags","align-x":"center"}]';
			jsonData +='}';
			*/
			var jsonData='{';
			if(type=='1'){
				jsonData +='"title":{"text":"'+time1+'年'+time2+'月统计"}';
			}else if(type=='2'){
				jsonData +='"title":{"text":"'+time1+'年第'+time2+'季度统计"}';
			}
			jsonData +=',"elements":[{"type":"hbar","values":[';
			for(var i=num-1;i>=0;i--){
//				jsonData +='{"colour":"'+colors[~~(Math.random()*colorLen)]+'","tip":"3000","right":3000}';
				jsonData +='{"colour":"'+colors[~~(Math.random()*colorLen)]+'","tip":"'+tsums[i]+'","right":'+tsums[i]+'}';
				if(i>0)jsonData +=',';
			}
			jsonData +=']}],"x_axis":{"offset":false,"min":0,"max":5000,"steps":1000}';
			jsonData +=',"y_axis":{"offset":1,"labels":['+zzjgs.join(',')+']}';
			jsonData +=',"tooltip":{"mouse":2,"stroke":1,"color":"#000000","bg_colour":"#FFFFFF"}';
			jsonData +='}';
			
			//alert(jsonData);
			show_tjt(jsonData);
		},
		error:function(){}
	});
};

function show_tjt(jsonData){
  zdParms_ssyj(jsonData);
}

var ssyj_chart_json="";
function zdParms_ssyj(json){
	ssyj_chart_json=json;
	/*
    document.getElementById("chartdiv1").innerHTML="";
    var data="";
    var data=json;
    var myChart=new FusionCharts(contextPath+"/js/ssyj/swf/MSBar2D.swf","统计结果","400","400");
        myChart.setJSONData(data);
	    myChart.render("chartdiv1");
		 document.getElementById("winser").style.display="block";
		*/ 
	//alert(json);
	var htmlStr = "<div id='ssyj_chart'></div>";
	$("#winser").html(htmlStr);
    swfobject.embedSWF(
		contextPath+"/js/tools/flashChart/open-flash-chart.swf",
		"ssyj_chart",
		"400px",
		"400px",
		"9.0.0",
		"expressInstall.swf",
		{},
//		{"data-file":json},
		{wmode:"transparent"}
    );
}

function open_flash_chart_data(){
	return ssyj_chart_json;
}

