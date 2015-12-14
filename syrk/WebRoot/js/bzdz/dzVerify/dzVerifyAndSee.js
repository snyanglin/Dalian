if(typeof DzVerifyAndSee == "undefined" || !DzVerifyAndSee){
	var DzVerifyAndSee = {};
};
DzVerifyAndSee = function(){
	this.pk = Math.random();
};
/**
 * @title:Jquery
 * @description:初始化地址管理
 * @author: zhang_guoliang@founder.com
 * @param      
 * @date:2015-02-06 16:30:12
 */
$(function(){
	//加载地图
	DzVerifyAndSee.onloadMap();
	//设置只读属性
	DzVerifyAndSee.onloadReadonly();
	//加载按钮事件
	DzVerifyAndSee.onloadButton();
	//加载层户结构页面
	DzVerifyAndSee.onloadChjg();
});
/**
 * @title:onloadMap
 * @description:加载地图
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-02-06 16:21:23
 */	
DzVerifyAndSee.onloadMap = function(){
	/*地图对象*/
	DzVerifyAndSee.map = new FrameTools.Map();
	/*设置地图代理*/
	DzVerifyAndSee.map.setProxy(contextPath + "/Proxy");
	/*设置地图加载容器*/
	DzVerifyAndSee.map.setMapDiv("mapDiv");
	/*加载地图*/
	DzVerifyAndSee.map.onloadMap();
	/*显示鹰眼*/
	DzVerifyAndSee.map.addOverView();
	/*隐藏自带矢量影像图层对象*/
	DzVerifyAndSee.map._MapApp.hideMapServer();
	/*加载自定义的矢量影像图层对象*/
	DzVerifyAndSee.map.showNewMapServer("mapDiv","DzVerifyAndSee.map");
	/*加载地图工具条*/
	DzVerifyAndSee.map.buildTools("mapDiv","toolDiv","DzVerifyAndSee.map");
	/*设置工具条显示的位置*/
	DzVerifyAndSee.diyToolDiv();
	/*窗口变化地图工具条自动变*/
	$("#mapDiv").resize(function(){DzVerifyAndSee.diyToolDiv();});
	/*加载边界坐标值*/
	if(bjzbz!="" && bjzbz!='null'){
		/*显示当前用户边界*/
		DzVerifyAndSee.moveMapToBjzbz();
	}
	//加载坐标点
	DzVerifyAndSee.loadInitMarker();
};
/**
 * @title:diyToolDiv
 * @description:设置工具条显示的位置
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-02-06 16:31:31
 */	
DzVerifyAndSee.diyToolDiv = function(){
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
 * @date:2015-02-06 16:37:54
 */	
DzVerifyAndSee.moveMapToBjzbz = function(){
	/*清楚地图上所有的标记*/
	DzVerifyAndSee.map._MapApp.clear();
	/*非地坐标*/
	var bj = bjzbz.split(";");
	var bjnum = bj.length;
	/*记录边线中心点坐标*/
	DzVerifyAndSee.mbrArr = new Array();
	for(var j=0;j<bjnum;j++){
		var gArr = bj[j];
		/*创建边界图元素*/
		var polyline = DzVerifyAndSee.map.initPolyline(gArr,"blue");
		/*图元素添加到地图上*/
		if(polyline){
			DzVerifyAndSee.map._MapApp.addOverlay(polyline);
			DzVerifyAndSee.mbrArr.push(polyline);
			if(DzVerifyAndSee.Mbr==null){
				DzVerifyAndSee.Mbr = polyline.getMBR();
			}else{
				DzVerifyAndSee.Mbr = MBR.union(DzVerifyAndSee.Mbr,polyline.getMBR());
			}
		}
	}
	/*根据图元素将地图放到最适合的级别和位置*/
	DzVerifyAndSee.map._MapApp.centerAtMBR(DzVerifyAndSee.Mbr);
	/*新版本cliect自动适应级别有问题必须降一级*/
	DzVerifyAndSee.map._MapApp.zoomOut();
};
/**
 * @title:onloadReadonly
 * @description:设置只读属性
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-02-06 16:40:32
 */	
DzVerifyAndSee.onloadReadonly = function(){
	//行政区划【只读】
	setInputReadonly('xzqhdm', true);
	//地名【只读】
	setInputReadonly('dmmc', true);
	//门楼牌前缀【只读】
	setInputReadonly('mlphqz', true);
	//门楼牌号【只读】
	setInputReadonly('mlph', true);
	//门楼牌后缀【只读】
	setInputReadonly('mlphhz', true);
	//门楼牌全称【只读】
	setInputReadonly('mlphqc', true);
	//地址别名【只读】
	for(var i=0;i<dzbmArr.length;i++){
		setInputReadonly('dzbm'+i, true);
	}
	//责任区【只读】
	setInputReadonly('zrqmc', true);
	//社区【只读】
	setInputReadonly('sqmc', true);
	//地图错误反馈【只读】
	setInputReadonly('dtcwfk', true);
	//不合格原因【只读】
	setInputReadonly('shbhgyy', true);
	if(shztdm=="03"){
	   document.getElementById("bhgyyid").style.display = "";	
	}
};
/**
 * @title:loadInitMarker
 * @description:气泡框内容
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-02-07 13:20:21
 */	
DzVerifyAndSee.loadInitMarker = function(){
	if(zbx!=""&&zby!=""){
		//气泡框内容
		var openHtml =  "<div id='uploadFileImageDiv' style='width: 300px; height: 300px;text-align: center;'></div>" +
				        "<div class='divwrap'><div class='oneText'>1</div><div class='title_big'>地址全称："+dzmc+"</div></div>" +
						"<div class='divwrap'><div class='oneText'>2</div><div class='title_big'>采集人："+xt_lrrxm+"&nbsp;&nbsp;&nbsp;采集时间："+xt_cjsj+"</div></div>";
		//地图标点
		var img = "";
		if(shztdm=="01"){
			//黄色
			img = "jzw4.png";
			openHtml += "<div class='divwrap'><div class='oneText'>3</div><div class='title_big'>管辖派出所："+pcsmc+"</div></div>" +
			"<div class='divwrap'><div class='oneText'>4</div><div class='title_big'>管辖责任区："+zrqmc+"</div></div>";
		}else if(shztdm=="02"){
			//绿色
			img = "jzw3.png";
			openHtml += "<div class='divwrap'><div class='oneText'>3</div><div class='title_big'>管辖派出所："+pcsmc+"</div></div>" +
			"<div class='divwrap'><div class='oneText'>4</div><div class='title_big'>管辖责任区："+zrqmc+"</div></div>";
		}else if(shztdm=="03"){
			//红色
			img = "jzw1.png";
			openHtml += "<div class='divwrap'><div class='oneText'>3</div><div class='title_big'>审批人："+shrxm+"&nbsp;&nbsp;&nbsp;审核时间："+shsj+"</div></div>";
			openHtml += "<div class='divwrap'><div class='oneText'>4</div><div class='title_big'>管辖派出所："+pcsmc+"</div></div>" +
			"<div class='divwrap'><div class='oneText'>5</div><div class='title_big'>管辖责任区："+zrqmc+"</div></div>";
		}else{
			//灰色
			img = "jzw0.png";
		}
		var initMarker = DzVerifyAndSee.map.initMarker(mlphqc,zbx,zby,img,openHtml,null,43,37);
		DzVerifyAndSee.map._MapApp.addOverlay(initMarker);
		initMarker.addListener("click", function(){
			DzVerifyAndSee.uploadFileImageView();
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
DzVerifyAndSee.uploadFileImageView = function(){
	uploadFileImageView('BZDZ_ADD_MLDZDXB',mldzid, 'uploadFileImageDiv', 300, 275,contextPath+'/images/bzdz/building/building.jpg'); //附件图片多张显示
};
/**
 * @title:onloadButton
 * @description:按钮事件
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-02-07 13:21:32
 */
DzVerifyAndSee.onloadButton = function(){
	//后退
    $('#backButton').click(function(){
    	closeSelf();
	});
    if(type=="0"){
    	 //合格
        $('#hgButton').click(function(){
        	  topMessager.confirm('操作确认', '您是否确定地址【'+mlphqc+'】合格？',function(r){
        		  if(r){
        			   var params = {mlphqc:mlphqc,mldzid:mldzid,shztdm:'02',bz:bz};
        			   var fajax = new FrameTools.Ajax(contextPath+"/dz/updateShzt",DzVerifyAndSee.updateShzt_back);
        			   fajax.send(params);
        		  }
        	  });
    	});
        //不合格
        $('#bhgButton').click(function(){
        	$("#dataBhgForm").form("reset");
        	$("#bhgWin").show();
        	$("#bhgWin").dialog({
        		title:"地址【"+mlphqc+"】审核不合格",
        		width:340,
        		height:180,
        		modal:false,
        		collapsible:false,
        		minimizable:false,
        		maximizable:false,
        		iconCls:"icon-no",
        		buttons:[{
    				text:'确定',
    				iconCls:'icon-save',
    				handler:function(){
    					if($("#dataBhgForm").form('validate')){
                             var shbhgyy = $("#shbhgyy1").val();
                             shbhgyy = $.trim(shbhgyy);
    						 var params = {mlphqc:mlphqc,mldzid:mldzid,shztdm:'03',shbhgyy:shbhgyy,bz:bz};
    			  			 var fajax = new FrameTools.Ajax(contextPath+"/dz/updateShzt",DzVerifyAndSee.updateShzt_back);
    			  			 fajax.send(params);
    					}
    				}
    			},{
    				text:'取消',
    				iconCls:'icon-cancel',
    				handler:function(){
    					$('#bhgWin').window('close');
    				}
    			}]
        	});
    	});
    }else{
    	 document.getElementById("hgButton").style.display = "none";
    	 document.getElementById("bhgButton").style.display = "none";
    }
    //查看层户
    $('#ckchButton').click(function(){
    	$('#tt').tabs("select", "层户");
	});
};
/**
 * @title:updateShzt_back
 * @description:地址审核状态_回调函数
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-02-07 14:55:43
 */
DzVerifyAndSee.updateShzt_back = function(result){
	if(result){
		if(result.status == 'success'){
			closeSelf();
			executeTabPageMethod(mainTabID, "DzVerify.queryButton()");
		}
		topMessager.show({
			title: MESSAGER_TITLE,
			msg: result.message,
			timeout:3500
		});
	}
};
/**
 * @title:onloadChjg
 * @description:加载层户结构页面
 * @author: zhang_guoliang@founder.com
 * @param type 0为可编辑、1为只读,dzChb地址层户表 0为层户地址对象表、1为层户地址审核表、chType层户结构 0为编辑、1为只读 
 * @date:2015-03-02 14:50:32
 */
DzVerifyAndSee.onloadChjg = function(){
	//层户结构URL
	var src = contextPath+"/dz/dzBuilding?mldzid="+mldzid+"&type="+type+"&dzChb="+dzChb+"&chType="+chType+"&mainTabID="+mainTabID;
	//Iframe页面加载，解决加载页面先出输入框在加载样式问题
	var chjgHtml = "<iframe id='chjgid' style='width: 100%;height: 100%;' frameborder='no' src='"+src+"'></iframe>";
	$("#chDivId").html(chjgHtml);
};