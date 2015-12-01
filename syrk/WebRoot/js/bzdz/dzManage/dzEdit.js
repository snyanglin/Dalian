if(typeof DzEdit == "undefined" || !DzEdit){
	var DzEdit = {};
};
DzEdit = function(){
	this.pk = Math.random();
};
DzEdit.JSONArray = null;
/**
 * @title:Jquery
 * @description:初始化地址管理
 * @author: zhang_guoliang@founder.com
 * @param      
 * @date:2015-02-09 20:26:45
 */
$(function(){
	//加载地图
	DzEdit.onloadMap();
	//设置只读属性
	DzEdit.onloadReadonly();
	//加载按钮事件
	DzEdit.onloadButton();
	//加载层户结构页面
	DzEdit.onloadChjg();
	//延时获取照片信息
	setTimeout(function(){
		//将form表单封装成JSON串，在修改提交前验证
		DzEdit.JSONArray = JSON.stringify($("#dataForm").serializeArray());
	},5);
	//重新加载门楼牌号
	DzEdit.setMlpqc();
});
/**
 * @title:onloadMap
 * @description:加载地图
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-01-06 11:02:21
 */	
DzEdit.onloadMap = function(){
	/*地图对象*/
	DzEdit.map = new FrameTools.Map();
	/*设置地图代理*/
	DzEdit.map.setProxy(contextPath + "/Proxy");
	/*设置地图加载容器*/
	DzEdit.map.setMapDiv("mapDiv");
	/*加载地图*/
	DzEdit.map.onloadMap();
	/*显示鹰眼*/
	DzEdit.map.addOverView();
	/*隐藏自带矢量影像图层对象*/
	DzEdit.map._MapApp.hideMapServer();
	/*加载自定义的矢量影像图层对象*/
	DzEdit.map.showNewMapServer("mapDiv","DzEdit.map");
	/*加载地图工具条*/
	DzEdit.map.buildTools("mapDiv","toolDiv","DzEdit.map");
	/*设置工具条显示的位置*/
	DzEdit.diyToolDiv();
	/*窗口变化地图工具条自动变*/
	$("#mapDiv").resize(function(){DzEdit.diyToolDiv();});
	/*加载边界坐标值*/
	if(bjzbz!="" && bjzbz!='null'){
		/*显示当前用户边界*/
		DzEdit.moveMapToBjzbz();
	}
	//加载坐标点
	DzEdit.loadInitMarker();
};
/**
 * @title:diyToolDiv
 * @description:设置工具条显示的位置
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-01-06 11:03:22
 */	
DzEdit.diyToolDiv = function(){
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
DzEdit.moveMapToBjzbz = function(){
	/*清楚地图上所有的标记*/
	DzEdit.map._MapApp.clear();
	/*非地坐标*/
	var bj = bjzbz.split(";");
	var bjnum = bj.length;
	/*记录边线中心点坐标*/
	DzEdit.mbrArr = new Array();
	for(var j=0;j<bjnum;j++){
		var gArr = bj[j];
		/*创建边界图元素*/
		var polyline = DzEdit.map.initPolyline(gArr,"blue");
		/*图元素添加到地图上*/
		if(polyline){
			DzEdit.map._MapApp.addOverlay(polyline);
			DzEdit.mbrArr.push(polyline);
			if(DzEdit.Mbr==null){
				DzEdit.Mbr = polyline.getMBR();
			}else{
				DzEdit.Mbr = MBR.union(DzEdit.Mbr,polyline.getMBR());
			}
		}
	}
	/*根据图元素将地图放到最适合的级别和位置*/
	DzEdit.map._MapApp.centerAtMBR(DzEdit.Mbr);
	/*新版本cliect自动适应级别有问题必须降一级*/
	DzEdit.map._MapApp.zoomOut();
};
/**
 * @title:loadInitMarker
 * @description:气泡框内容
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-02-09 20:34:43
 */	
DzEdit.loadInitMarker = function(){
	if(zbx!=""&&zby!=""){
		//气泡框内容
		var openHtml =  "<div id='uploadFileImageDiv' style='width: 300px; height: 300px;text-align: center;'></div>" +
				        "<div class='divwrap'><div class='oneText'>1</div><div class='title_big'>地址全称："+dzmc+"</div></div>" +
						"<div class='divwrap'><div class='oneText'>2</div><div class='title_big'>采集人："+xt_lrrxm+"&nbsp;&nbsp;&nbsp;采集时间："+xt_cjsj+"</div></div>";
		openHtml += "<div class='divwrap'><div class='title_big'><div class='blueText'>" +
					"<a class='blueText' href='javascript:javascript:void(0)' onclick='DzEdit.uploadFileEdit(\""+mldzid+"\",\""+mlphqc+"\")'>【照片管理】</a>" +
					"</div></div></div>";
		var img = "jzw3.png";
		if(dzChb=="1"){
			img = "jzw1.png";
		}
		DzEdit.markerObj = DzEdit.map.initMarker(mlphqc,zbx,zby,img,openHtml,null,43,37);
		DzEdit.map._MapApp.addOverlay(DzEdit.markerObj);
		DzEdit.markerObj.addListener("click", function(){
			DzEdit.uploadFileImageView();
		});
	}
};
/**
 * @title:uploadFileImageView
 * @description:加载照片
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2015-03-21 14:56:32
 */
DzEdit.uploadFileImageView = function(){
	uploadFileImageView('BZDZ_ADD_MLDZDXB',mldzid, 'uploadFileImageDiv', 300, 275,contextPath+'/images/bzdz/building/building.jpg'); //附件图片多张显示
};
/**
 * @title:uploadFileEdit
 * @description:照片管理
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2015-03-21 14:56:32
 */
DzEdit.uploadFileEdit = function(mldzid,title){
	//关闭所有器已经打开的气泡框
	DzEdit.map._MapApp.closeInfoWindow();
	uploadFileEdit('BZDZ_ADD_MLDZDXB',mldzid, '【'+title+'】照片', 'img', '0', '','【'+title+'】照片管理');
};
/**
 * @title:onloadReadonly
 * @description:设置只读属性
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-02-10 10:52:43
 */	
DzEdit.onloadReadonly = function(){
	//行政区划【只读】
	setInputReadonly('xzqhdm', true);
	//地名【只读】
	setInputReadonly('dmmc', true);
	//门楼牌全称【只读】
	setInputReadonly('mlphqc', true);
	//责任区【只读】
	setInputReadonly('zrqmc', true);
	//不合格原因【只读】
	setInputReadonly('shbhgyy', true);
	
	if(dzChb=="1"){
		document.getElementById("bhgyyid").style.display = "";	
	}
	
	if(type == "1"){  
		setInputReadonly('mlphqz', true);
		setInputReadonly('mlphhz', true);
		setInputReadonly('mlph', true);
		setInputReadonly('sqdm', true);
		setInputReadonly('dtcwfk', true);
	}
};
/**
 * @title:onloadButton
 * @description:加载按钮事件
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-02-10 10:52:43
 */
DzEdit.onloadButton = function(){
	//后退
    $('#backButton').click(function(){
    	closeSelf();
	});
    if(type=="0"){
	    //保存
	    $('#saveButton').click(function(){
	    	var jsonArr = JSON.stringify($("#dataForm").serializeArray());
	    	//判断表单是否修改过
	    	if(DzEdit.JSONArray == jsonArr){
	    		topMessager.show({
					title: MESSAGER_TITLE,
					msg: '您未修改任何信息，无法进行保存！',
					timeout:2500
				});
	    	}else{
	    		if($("#dataForm").form('validate')){
	    			if($("#saveId").html()!="保存中..."){
	    				$("#saveId").html("保存中..."); 
		    			//提交保存
		    			$("#dataForm").form('submit',{
		    				dataType : 'json',
		    				onSubmit: function(){
							},
							success:function(result){
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
	    	DzEdit.moveMapToDrawPoint();
		});
	    document.getElementById("ckchButton").style.display = "none";
    }else{
    	document.getElementById("saveButton").style.display = "none";
    	document.getElementById("dtbdButton").style.display = "none";
    	document.getElementById("whchButton").style.display = "none";
    }
    //维护层户
    $('#whchButton').click(function(){
    	$('#tt').tabs("select", "层户");
	});
    //查看层户
    $('#ckchButton').click(function(){
    	$('#tt').tabs("select", "层户");
	});
};
/**
 * @title:setMlpqc
 * @description:地址全称
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-01-07 14:35:05
 */	
DzEdit.setMlpqc = function(temp){
	var dmmc = $('#dmmc').val();
	var mlphqzmc = $('#mlphqzmc').val();
	var mlph = $('#mlph').val();
	var mlphhzmc = $('#mlphhzmc').val();
	var mlphqc = dmmc+mlphqzmc+mlph+mlphhzmc;
	$('#mlphqc').val(mlphqc);
};
/**
 * @title:moveMapToDrawPoint
 * @description:设置当前地图操作状态为获取地图坐标的状态
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-02-10 10:52:43
 */	
DzEdit.moveMapToDrawPoint = function(){
	DzEdit.map._MapApp.changeDragMode("drawPoint",null,null,function(obj){
		if(bjzbz!="" && bjzbz!='null'){
			//判断后坐标是否在区域内
			var judge = DzEdit.map.PtInPolygon(obj,bjzbz);
			if(judge){
				//获取定位的坐标点
				var pointArray = obj.split(",");
				if(DzEdit.markerObj!=null){
					DzEdit.map._MapApp.removeOverlay(DzEdit.markerObj);
				}
				DzEdit.markerObj = DzEdit.map.initMarker(mlphqc,pointArray[0],pointArray[1],"jzw2.png",null,null,43,37);
		  		DzEdit.map._MapApp.addOverlay(DzEdit.markerObj);
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
DzEdit.addDzBm = function(){
	 var tr1 = $('<tr id="dzBmTr1'+ dzBmCount +'"><td height="5"></td></tr>');
	 var tr2 = $('<tr class="dialogTr" id="dzBmTr2'+dzBmCount+'"></tr>');
     var td1 = $('<td width="30%" class="dialogTd" align="right">地址别名：</td>'); 	  
     var td2 = $('<td width="70%" class="dialogTd" id="dzbmTd'+ dzBmCount +'"></td>'); 
     var td2Html = new StringBuffer();
     td2Html.append("<input class='easyui-validatebox' type='text' id='dzbm_"+dzBmCount+"' name='dzBmArray["+dzBmCount+"].dzbm' style='width:215px;'/>");
     td2Html.append("&nbsp;<a class='delLine_btn' href='javascript:void(0);' onclick='DzEdit.delDzBm("+ dzBmCount +")' title='注销当前地址别名'></a>");
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
DzEdit.delDzBm = function(No){
	 $("#dzBmTr1" + No).remove();
	 $("#dzBmTr2" + No).remove();
};
/**
 * @title:onloadChjg
 * @description:加载层户结构页面
 * @author: zhang_guoliang@founder.com
 * @param type 0为可编辑、1为只读,dzChb地址层户表 0为层户地址对象表、1为层户地址审核表,chType层户结构 0为编辑、1为只读   
 * @date:2015-03-02 15:01:43
 */
DzEdit.onloadChjg = function(){
	//层户结构URL
	var src = contextPath+"/dz/dzBuilding?mldzid="+mldzid+"&type="+type+"&dzChb="+dzChb+"&chType="+chType+"&mainTabID="+mainTabID;
	//Iframe页面加载，解决加载页面先出输入框在加载样式问题
	var chjgHtml = "<iframe id='chjgid' style='width: 100%;height: 100%;' frameborder='no' src='"+src+"'></iframe>";
	$("#chDivId").html(chjgHtml);
};