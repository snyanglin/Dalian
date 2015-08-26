//patrolLine show operate start
var patrolLine_drawMarkerTemp=[];
var patrolLine_drawLineTemp=[];

//clear temp overlay
var patrolLine_clearShapeBeforeDraw=function(){
	var mapObj=XjMap.map._MapApp;
	for(var i=0;i<patrolLine_drawMarkerTemp.length;i++){
		mapObj.removeOverlay(patrolLine_drawMarkerTemp[i]);
	}
	for(var i=0;i<patrolLine_drawLineTemp.length;i++){
		mapObj.removeOverlay(patrolLine_drawLineTemp[i]);
	}
	patrolLine_drawMarkerTemp.length=0;
	patrolLine_drawLineTemp.length=0;
};

//dbclick show sites
var patrolLine_draw_patrolLineBySites=function(sites){
	patrolLine_clearShapeBeforeDraw();
	patrolLine_clearShapeBeforeNewPlan();
	var mapObj=XjMap.map._MapApp;
	var lineStr="";
	if(sites.length==0){
		alert('尚未设定路线！');
		return;
	}
	for(var i=0;i<sites.length;i++){
		var site=sites[i];
		if(site.x==''||site.y==''||site.x=='null'||site.y=='null')continue;
		var icon=new Icon();
		icon.image=basePath+"images/map/icons/location.png";
		icon.width=20;
		icon.height=20;
		var marker=new Marker(new Point(site.x,site.y),icon,new Title(site.name));
		patrolLine_drawMarkerTemp.push(marker);
		lineStr+=site.x+","+site.y+",";
		mapObj.addOverlay(marker);
	}
	if(sites.length>2){
		var pline = new Polyline(lineStr.substring(0, lineStr.length-1), "red", 5, 1, 1);
		patrolLine_drawLineTemp.push(pline);
		mapObj.addOverlay(pline);
		mapObj.centerAndZoom(pline.getMBR().centerPoint(),16);
	}
};
//-------------------------------------巡逻计划执行情况
var patroLine_showPatrolPlan=function(linkObject,code,bdate,edate){
	$.ajax({
		url:basePath+"alermAnalyse_patrolLineOpe",
		type:"post",
		dataType:"html",
		data:{
			opeFlag:"getPatrolPlanList",
			patrolId:code,
			bdate:bdate,
			edate:edate
		},
		success:function(html){
			var win = patroLine_getPatrolInfoWin();
			win.window('open');
			win.html(html);
		}
	});
};

var patroLine_getPatrolInfoWin=function(){
	var div=$('#patroLine_infoWin');
	if(div.length==0){
		div=$('<div id="patroLine_infoWin"></div>');
		$(document.body).append(div);
		div.window({
			title:' ',
			width:600,
			height:400
		});
	}
	return div;
};

var patrolLine_planMarkerTemp=[];
var patrolLine_planLineTemp=[];

var patrolLine_clearShapeBeforeNewPlan=function(){
	var mapObj=XjMap.map._MapApp;
	for(var i=0;i<patrolLine_planMarkerTemp.length;i++){
		mapObj.removeOverlay(patrolLine_planMarkerTemp[i]);
	}
	for(var i=0;i<patrolLine_planLineTemp.length;i++){
		mapObj.removeOverlay(patrolLine_planLineTemp[i]);
	}
	patrolLine_planMarkerTemp.length=0;
	patrolLine_planLineTemp.length=0;
};
//
var patrolLine_patrolPlanShow=function(planId,planDate,btime,etime){
	$.ajax({
		url:basePath+"alermAnalyse_patrolLineOpe",
		type:"post",
		dataType:"json",
		data:{
			opeFlag:"getPatrolPlanExecute",
			planId:planId,
			planDate:planDate,
			btime:btime,
			etime:etime
		},
		success:function(json){
			var mapObj=XjMap.map._MapApp;
			patrolLine_clearShapeBeforeDraw();
			patrolLine_clearShapeBeforeNewPlan();
			var lineStr="";
			for(var i=0;i<json.length;i++){
				var site=json[i];
				if(site.x==''||site.y==''||site.x=='null'||site.y=='null')continue;
				var icon=new Icon();
				icon.image=basePath+patrolLine_point_patrolExecuteConvert(site.status);
				icon.width=20;
				icon.height=20;
				var marker=new Marker(new Point(site.x,site.y),icon,new Title(site.name));
				patrolLine_planMarkerTemp.push(marker);
				lineStr+=site.x+","+site.y+",";
				marker.addListener('click',function(marker,site){
					return function(){
						var str="<div style='width:240px' align='center'><table style='width:100%'>";
							str+="<tr style='height:20px'><td align='right' style='color:red'>巡检地点：</td><td align='left'>"+site.name+"</td></tr>";
							str+="<tr style='height:20px'><td align='right' style='color:red'>巡检到达时间：</td><td align='left'>"+site.time+"</td></tr>";
							str+="<tr style='height:20px'><td align='right' style='color:red'>巡检状态：</td><td align='left'>"+patrolLine_show_patrolExecuteConvert(site.status)+"</td></tr>";
							str+="<tr style='height:20px'><td align='right' style='color:red'>巡检人员：</td><td align='left'>"+site.perName+"</td></tr>";
							str+="</table></div>";
						marker.openInfoWindowHtml(str);
					};
				}(marker,site));
				mapObj.addOverlay(marker);
			}
			if(json.length>2){
				var line = new Polyline(lineStr.substring(0, lineStr.length-1), "red", 5, 0.6,1);
				patrolLine_planLineTemp.push(line);
				mapObj.addOverlay(line);
				mapObj.centerAndZoom(line.getMBR().centerPoint(),16); 
			}
		}
	});
};

var patrolLine_point_patrolExecuteConvert=function(flag){
	if(flag==0){
		return 'images/patrolLine/red.png';
	}else if(flag==1){
		return 'images/patrolLine/green.png';
	}else if(flag==2){
		return 'images/patrolLine/blue.png';
	}else if(flag==3){
		return 'images/patrolLine/orange.png';
	}
};

var patrolLine_show_patrolExecuteConvert=function(flag){
	if(flag==0){
		return '漏巡';
	}else if(flag==1){
		return '已巡';
	}else if(flag==2){
		return '早到';
	}else if(flag==3){
		return '迟到';
	}
};
//patrolLine show operate end

//patrolLine modify operate start
var modifyPatrolLine_pointId="";
var modifyPatrolLine_pointArr=[];
var modifyPatrolLine_tempLine=null;
var modifyPatrolLine_oldLine=null;
var modifyPatrolLine_tempCode=-1;
var patrolLine_modifyMarkerTemp=[];
var modifyPatrolLine_squenceMarkerArr=[];

var patrolLine_clearShapeBeforeModify=function(){
	var mapObj=XjMap.map._MapApp;
	for(var i=0;i<patrolLine_modifyMarkerTemp.length;i++){
		mapObj.removeOverlay(patrolLine_modifyMarkerTemp[i]);
	}
	if(modifyPatrolLine_tempLine!=null)
		mapObj.removeOverlay(modifyPatrolLine_tempLine);
	
	if(modifyPatrolLine_oldLine!=null)
		mapObj.removeOverlay(modifyPatrolLine_oldLine);
	
	patrolLine_modifyMarkerTemp.length=0;
	modifyPatrolLine_tempLine=null;
	modifyPatrolLine_oldLine=null;
};

//打开巡逻路线更新操作面板
var patroLine_modifyPatrolLine=function(linkObject,code,orgId,dgdata){
	$.ajax({
		url:basePath+"alermAnalyse_patrolLineOpe",
		type:"post",
		dataType:"json",
		data:{
			opeFlag:"getPatrolPointByOrgId",
			orgId:orgId
		},
		success:function(json){
			var mapObj=XjMap.map._MapApp;
			patrolLine_clearShapeBeforeDraw();
			patrolLine_clearShapeBeforeNewPlan();
			modifyPatrolLine_tempCode=code;
			modifyPatrolLine_pointId="";
			modifyPatrolLine_pointArr.length=0;
			patroLine_clear_squenceMarkerArr();
			modifyPatrolLine_squenceMarkerArr.length=0;
			modifyPatrolLine_tempLine=null;
			
			for(var i=0;i<json.length;i++){
				var site=json[i];
				if(site.x==''||site.y==''||site.x=='null'||site.y=='null')continue;
				var icon=new Icon();
				icon.image=basePath+"images/patrolLine/green.png";
				icon.width=20;
				icon.height=20;
				var marker=new Marker(new Point(site.x,site.y),icon,new Title(site.name));
				patrolLine_modifyMarkerTemp.push(marker);
				marker.addListener('click',function(site){
					return function(){
						patroLine_flag_patrolLine(site.x,site.y,site.id);
					};
				}(site));
				mapObj.addOverlay(marker);
			}
			
			var sites=null,lineStr="";
			for(var i=0;i<dgdata.rows.length;i++){
				var obj=dgdata.rows[i];
				if(obj.id==code){
					sites=obj.sites;
				}
			}
			
			for(var i=0;i<sites.length;i++){
				var site=sites[i];
				if(site.x==''||site.y==''||site.x=='null'||site.y=='null')continue;
				lineStr+=site.x+","+site.y+",";
				var icon=new Icon();
				icon.image=basePath+"images/patrolLine/green.png";
				icon.width=20;
				icon.height=20;
				var marker=new Marker(new Point(site.x,site.y),icon,new Title(site.name));
				patrolLine_modifyMarkerTemp.push(marker);
				marker.addListener('click',function(site){
					return function(){
						patroLine_flag_patrolLine(site.x,site.y,site.id);
					};
				}(site));
				mapObj.addOverlay(marker);
			}
			
			if(sites.length>2){
				modifyPatrolLine_oldLine = new Polyline(lineStr.substring(0, lineStr.length-1), "red", 5, 0.6, 1);
				mapObj.addOverlay(modifyPatrolLine_oldLine);
				mapObj.centerAndZoom(modifyPatrolLine_oldLine.getMBR().centerPoint(),16); 
			}
			$("#patrol_line_modify_div").show();
		}
	});
};

//标记新巡逻路线
var patroLine_flag_patrolLine=function(x,y,id){
	if(modifyPatrolLine_pointId.indexOf(id)!=-1)return;
	modifyPatrolLine_pointId+=id+"@@";
	var p={};
	p.x=x;
	p.y=y;
	modifyPatrolLine_pointArr.push(p);
	
	var icon=new Icon();
	icon.width=0;
	icon.height=0;
	icon.image='';
	var title=new Title((modifyPatrolLine_pointId.split("@@").length-1)+'', 16, 0, '宋体', 'blue', '', '', 0);
	var marker=new Marker(new Point(x,y),icon,title);
	var mapObj=XjMap.map._MapApp;
	mapObj.addOverlay(marker);
	modifyPatrolLine_squenceMarkerArr.push(marker);
	
	patroLine_draw_patrolLineForModify();
};

var patroLine_clear_squenceMarkerArr=function(){
	var mapObj=XjMap.map._MapApp;
	for(var i=0;i<modifyPatrolLine_squenceMarkerArr.length;i++){
		var marker=modifyPatrolLine_squenceMarkerArr[i];
		mapObj.removeOverlay(marker);
	}
};

//新巡逻路线显示
var patroLine_draw_patrolLineForModify=function(){
//	if(modifyPatrolLine_pointArr.length==1)return;
	var mapObj=XjMap.map._MapApp;
	if(modifyPatrolLine_tempLine!=null)mapObj.removeOverlay(modifyPatrolLine_tempLine);
	var points="";
	for(var i=0;i<modifyPatrolLine_pointArr.length;i++){
		points+=modifyPatrolLine_pointArr[i].x+","+modifyPatrolLine_pointArr[i].y+",";
	}
	modifyPatrolLine_tempLine=new Polyline(points.substring(0, points.length-1), "green", 5, 0.6, 1);
	mapObj.addOverlay(modifyPatrolLine_tempLine);
};

//重新标记巡逻路线
var modifyPatrolLine_reflag=function(){
	var mapObj=XjMap.map._MapApp;
	modifyPatrolLine_pointId="";
	modifyPatrolLine_pointArr.length=0;
	patroLine_clear_squenceMarkerArr();
	modifyPatrolLine_squenceMarkerArr.length=0;
	if(modifyPatrolLine_tempLine!=null)mapObj.removeOverlay(modifyPatrolLine_tempLine);
	modifyPatrolLine_tempLine=null;
};

//确认更新巡逻路线
var modifyPatrolLine_confirmModify=function(){
	//alert(modifyPatrolLine_pointId);
	$.ajax({
		url:basePath+"alermAnalyse_patrolLineOpe",
		type:"post",
		dataType:"json",
		data:{
			opeFlag:"udpatePatrolLine",
			patrolId:modifyPatrolLine_tempCode,
			lineId:modifyPatrolLine_pointId
		},
		success:function(json){
			if(json){
				alert("更新成功！");
				modifyPatrolLine_close();
				parent.frames['xllxs'].reloadDG();
			}else{
				alert("更新失败");
			}
		}
	});
};

//关闭巡逻路线更新操作面板
var modifyPatrolLine_close=function(){
	patrolLine_clearShapeBeforeModify();
	$("#patrol_line_modify_div").hide();
	modifyPatrolLine_tempCode=-1;
	modifyPatrolLine_pointId="";
	modifyPatrolLine_pointArr.length=0;
	patroLine_clear_squenceMarkerArr();
	modifyPatrolLine_squenceMarkerArr.length=0;
	patrolLine_modifyMarkerTemp.length=0;
	modifyPatrolLine_tempLine=null;
};
//patrolLine modify operate end