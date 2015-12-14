if(typeof DzAdd == "undefined" || !DzAdd){
	var DzAdd = {};
};
DzAdd = function(){
	this.pk = Math.random();
};
DzAdd.layoutWest = true;//判断左收缩框是否打开
/**
 * @title:Jquery
 * @description:初始化地址管理
 * @author: zhang_guoliang@founder.com
 * @param      
 * @date:2015-01-06 10:23:32
 */
$(function(){
	//加载地图
	DzAdd.onloadMap();
	//设置只读属性
	DzAdd.onloadReadonly();
	//加载按钮事件
	DzAdd.onloadButton();
	//判断左面板展开还是折叠($("#panelid").layout('panel','west').panel({方法体}); 此方法有问题样式走偏)
	var tt = $("#tt").width()+28;
	$("#tt").resize(function(){
		var ttW = $("#tt").width();
		if(ttW>tt){
			DzAdd.layoutWest = false;
		}else{
			DzAdd.layoutWest = true;
		}
	});
});
/**
 * @title:onloadMap
 * @description:加载地图
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-01-06 11:02:21
 */	
DzAdd.onloadMap = function(){
	/*地图对象*/
	DzAdd.map = new FrameTools.Map();
	/*设置地图代理*/
	DzAdd.map.setProxy(contextPath + "/Proxy");
	/*设置地图加载容器*/
	DzAdd.map.setMapDiv("mapDiv");
	/*加载地图*/
	DzAdd.map.onloadMap();
	/*显示鹰眼*/
	DzAdd.map.addOverView();
	/*隐藏自带矢量影像图层对象*/
	DzAdd.map._MapApp.hideMapServer();
	/*加载自定义的矢量影像图层对象*/
	DzAdd.map.showNewMapServer("mapDiv","DzAdd.map");
	/*加载地图工具条*/
	DzAdd.map.buildTools("mapDiv","toolDiv","DzAdd.map");
	/*设置工具条显示的位置*/
	DzAdd.diyToolDiv();
	/*窗口变化地图工具条自动变*/
	$("#mapDiv").resize(function(){DzAdd.diyToolDiv();});
	/*加载边界坐标值*/
	if(bjzbz!="" && bjzbz!='null'){
		/*显示当前用户边界*/
		DzAdd.moveMapToBjzbz();
	}
};
/**
 * @title:diyToolDiv
 * @description:设置工具条显示的位置
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-01-06 11:03:22
 */	
DzAdd.diyToolDiv = function(){
	var top = $("#mapDiv").height() - 40;
	$("#toolDiv").css({
		"top" : top,
		"left" : 10
	});
};
/**
 * @title:moveMapToBjzbz
 * @description:加载当前用户边界
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-01-06 11:05:43
 */	
DzAdd.moveMapToBjzbz = function(){
	/*清楚地图上所有的标记*/
	DzAdd.map._MapApp.clear();
	/*非地坐标*/
	var bj = bjzbz.split(";");
	var bjnum = bj.length;
	/*记录边线中心点坐标*/
	DzAdd.mbrArr = new Array();
	for(var j=0;j<bjnum;j++){
		var gArr = bj[j];
		/*创建边界图元素*/
		var polyline = DzAdd.map.initPolyline(gArr,"blue");
		/*图元素添加到地图上*/
		if(polyline){
			DzAdd.map._MapApp.addOverlay(polyline);
			DzAdd.mbrArr.push(polyline);
			if(DzAdd.Mbr==null){
				DzAdd.Mbr = polyline.getMBR();
			}else{
				DzAdd.Mbr = MBR.union(DzAdd.Mbr,polyline.getMBR());
			}
		}
	}
	/*根据图元素将地图放到最适合的级别和位置*/
	DzAdd.map._MapApp.centerAtMBR(DzAdd.Mbr);
	/*新版本cliect自动适应级别有问题必须降一级*/
	DzAdd.map._MapApp.zoomOut();
};
/**
 * @title:onloadReadonly
 * @description:设置只读属性
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-01-06 19:24:32
 */	
DzAdd.onloadReadonly = function(){
	//门楼牌全称【只读】
	setInputReadonly('mlphqc', true);
	//责任区【只读】
	setInputReadonly('zrqmc', true);
};
/**
 * @title:onloadButton
 * @description:加载按钮事件
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-01-06 19:25:43
 */	
DzAdd.onloadButton = function(){
	//后退
    $('#backButton').click(function(){
    	closeSelf();
	});
    //保存
    $('#saveButton').click(function(){
        if($("#saveId").html()!="保存中..."){
	    	if($("#dataForm").form('validate')){
	    		var zbx = $("#zbx").val();
	    		var zby = $("#zby").val();
	    		var chqd = document.getElementById("qdid").disabled;
	    		if(zbx==""&&zby==""){
	    			topMessager.show({
						title: MESSAGER_TITLE,
						msg: '该地址未采集地址位置，请进行标点。',
						timeout:2500
					});
	    			return;
	    		}else if(chqd==false){
	    			topMessager.show({
						title: MESSAGER_TITLE,
						msg: '该地址未生成层户结构，请生成层户。',
						timeout:2500
					});
	    			return;
	    		}else{
	    			$("#saveId").html("保存中..."); 
	    			//地上单元信息
	    			if(DzBuildingAdd.dscheckBox){
	    				var dszddys = document.getElementById("dszddys").value;
	    				var dslcs = document.getElementById("dslcs").value;
	    				var dshs = document.getElementById("dshs").value;
	    				document.getElementById("dsdys").value = dszddys;
	    				document.getElementById("dszdcs").value = dslcs;
	    				document.getElementById("dszdhs").value = dshs;
	    				var dsdyjbxx = new Array();  
	    				var dsdy = document.getElementsByName("dsdyName");
	    				for(var i=0;i<dsdy.length;i++){
	    					dsdyjbxx[i] = dsdy[i].value;
	    				}
	    				var dslcjbxx = new Array();  
	    				var dslc = document.getElementsByName("dslcName");
	    				for(var i=0;i<dslc.length;i++){
	    					dslcjbxx[i] = dslc[i].value;
	    				}
	    				var dsfjjbxx = new Array();  
	    				var dsfj = document.getElementsByName("dsfjName");
	    				for(var i=0;i<dsfj.length;i++){
	    					dsfjjbxx[i] = dsfj[i].value;
	    				}
	    				document.getElementById("dsdyjbxx").value = dsdyjbxx;
	    				document.getElementById("dslcjbxx").value = dslcjbxx;
	    				document.getElementById("dsfjjbxx").value = dsfjjbxx ;
	    			}
	    			//地下单元信息
	    			if(DzBuildingAdd.dxcheckBox){
	    				var dszddys = document.getElementById("dszddys").value;
	    				var dslcs = document.getElementById("dslcs").value;
	    				var dshs = document.getElementById("dshs").value;
	    				document.getElementById("dxdys").value = dszddys;
	    				document.getElementById("dxzdcs").value = dslcs;
	    				document.getElementById("dxzdhs").value = dshs;
	    				var dxdyjbxx = new Array();  
	    				var dxdy = document.getElementsByName("dxdyName");
	    				for(var i=0;i<dxdy.length;i++){
	    					dxdyjbxx[i] = dxdy[i].value;
	    				}
	    				var dxlcjbxx = new Array();  
	    				var dxlc = document.getElementsByName("dxlcName");
	    				for(var i=0;i<dxlc.length;i++){
	    					dxlcjbxx[i] = dxlc[i].value;
	    				}
	    				var dxfjjbxx = new Array();  
	    				var dxfj = document.getElementsByName("dxfjName");
	    				for(var i=0;i<dxfj.length;i++){
	    					dxfjjbxx[i] = dxfj[i].value;
	    				}
	    				document.getElementById("dxdyjbxx").value = dxdyjbxx;
	    				document.getElementById("dxlcjbxx").value = dxlcjbxx;
	    				document.getElementById("dxfjjbxx").value = dxfjjbxx ;
	    			}
	    			//提交保存
	    			$("#dataForm").form('submit',{
	    				dataType : 'json',
	    				onSubmit: function() {
						},
						success:function(result) {
							//解析JSON格式
							result = parseReturn(result);
							 //返回成功后执行的方法
							if(result.status == 'success'){
								closeSelf();
								executeTabPageMethod(mainTabID, "DzManage.queryButton()");
							}else if(result.status == 'error'){
								$("#saveId").html("保存"); 
							}
							topMessager.show({
								title: MESSAGER_TITLE,
								msg: result.message,
								timeout:3500
							});
						}
	    			});
	    		}
	    	}
        } 
	});
    //标点
    $('#dtbdButton').click(function(){
    	$('#tt').tabs("select", "地图");
    	//设置当前地图操作状态为获取地图坐标的状态
    	DzAdd.moveMapToDrawPoint();
	});
    //生成层户
    $('#scchButton').click(function(){
    	$('#tt').tabs("select", "层户");
    	//折叠左侧新建地址
    	$('#panelid').layout('collapse','west');
	});
};
/**
 * @title:moveMapToDrawPoint
 * @description:设置当前地图操作状态为获取地图坐标的状态
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-01-06 20:03:21
 */	
DzAdd.moveMapToDrawPoint = function(){
	DzAdd.map._MapApp.changeDragMode("drawPoint",null,null,function(obj){
		if(bjzbz!="" && bjzbz!='null'){
			//判断后坐标是否在区域内
			var judge = DzAdd.map.AreaInPolygon(obj,bjzbz);
			if(judge){
				//获取定位的坐标点
				var pointArray = obj.split(",");
				if(DzAdd.markerObj!=null){
					DzAdd.map._MapApp.removeOverlay(DzAdd.markerObj);
				}
				DzAdd.markerObj = DzAdd.map.initMarker("",pointArray[0],pointArray[1],"jzw2.png",null,null,43,37);
		  		DzAdd.map._MapApp.addOverlay(DzAdd.markerObj);
		  		document.getElementById("zbx").value = pointArray[0];
				document.getElementById("zby").value = pointArray[1];
			}else{
				topMessager.show({
					title: MESSAGER_TITLE,
					msg: '坐标超出边界,请重新标点！',
					timeout:2500
				});
			}
		}
	});
};
/**
 * @title:addDzBm
 * @description:增加一个地址别名
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-01-06 19:02:54
 */	
DzAdd.addDzBm = function(){
	 var tr1 = $('<tr id="dzBmTr1'+ dzBmCount +'"><td height="5"></td></tr>');
	 var tr2 = $('<tr class="dialogTr" id="dzBmTr2'+dzBmCount+'"></tr>');
     var td1 = $('<td width="30%" class="dialogTd" align="right">地址别名：</td>'); 	  
     var td2 = $('<td width="70%" class="dialogTd" id="dzbmTd'+ dzBmCount +'"></td>'); 
     var td2Html = new StringBuffer();
     td2Html.append("<input class='easyui-validatebox' type='text' id='dzbm_"+dzBmCount+"' name='dzBmArray["+dzBmCount+"].dzbm' style='width:215px;'/>");
     td2Html.append("&nbsp;<a class='delLine_btn' href='javascript:void(0);' onclick='DzAdd.delDzBm("+ dzBmCount +")' title='注销当前地址别名'></a>");
     td2.html(td2Html.toString());
     tr2.append(td1);
     tr2.append(td2);
     $('#dzBmTable').append(tr1);
     $('#dzBmTable').append(tr2);
 	 $.parser.parse('#dzbmTd' + dzBmCount);
     dzBmCount++;
};
/**
 * @title:delDzBm
 * @description:注销当前地址别名
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-01-06 19:03:32
 */	
DzAdd.delDzBm = function(No){
	 $("#dzBmTr1" + No).remove();
	 $("#dzBmTr2" + No).remove();
};
/**
 * @title:setMlpqc
 * @description:地址全称
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-01-07 14:35:05
 */	
DzAdd.setMlpqc = function(temp){
	var dmmc = $('#dmmc').val();
	var mlphqzmc = $('#mlphqzmc').val();
	var mlph = $('#mlph').val();
	var mlphhzmc = $('#mlphhzmc').val();
	var mlphqc = dmmc+mlphqzmc+mlph+mlphhzmc;
	$('#mlphqc').val(mlphqc);
};