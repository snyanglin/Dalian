if(typeof MainZrq =="undefined" || !MainZrq){
	MainZrq = {};
}
MainZrq.ezMap=null;//地图对象
MainZrq.initMarkerArr = new Array();//放点对象
MainZrq.setInt = "";//记录延时
/**
 * @method:$ 
 * @description:初始化页面
 * @author: zhang_guoliang@founder.com
 * @date:2015-8-13上午9:56:32
 */
$(function(){
	MainZrq.loadXqMap();//加载辖区地图
	MainZrq.initJobCounts();//加载工作统计
	MainZrq.initPcsXqgk();//加载派出所辖区概况
	MainZrq.initNews();//加载通知公告模块
	MainZrq.initWaitingWork();//加载待办事项模块
	MainZrq.initRemindDiv();//加载工作提醒模块
});
/**
 * @method:loadXqMap
 * @description:加载派出所主页地图
 * @author: zhang_guoliang@founder.com
 * @date:2015-8-4上午9:16:36
 */
MainZrq.loadXqMap = function(){
	/*地图对象*/
	MainZrq.ezMap = new FrameTools.Map();
	/*设置地图代理*/
	MainZrq.ezMap.setProxy(contextPath + "/Proxy");
	/*设置地图加载容器*/
	MainZrq.ezMap.setMapDiv("xqMap");
	/*加载地图*/
	MainZrq.ezMap.onloadMap();
	/*隐藏自带矢量影像图层对象*/
	MainZrq.ezMap._MapApp.hideMapServer();
	/*加载辖区边界*/
	if(bjzbz!=""||bjzbz!=null){
		MainZrq.ezMap.moveMapToBjzbz(bjzbz);
	}
};
/**
 * @method:initJobCounts
 * @description:加载派出所辖区概况详情
 * @author: zhang_guoliang@founder.com
 * @date:2015-8-15下午17:58:57
 */
MainZrq.initJobCounts = function(){
	var params = {zzjgdm:userOrgCode};
	var fajax =new FrameTools.Ajax(contextPath+"/homePage/queryPcsTj",MainZrq.initJobCounts_back);
	fajax.send(params);
};
/**
 * @method:initJobCounts_back
 * @description:加载派出所辖区概况详情_回调函数
 * @author: zhang_guoliang@founder.com
 * @date:2015-8-15下午18:01:05
 */
MainZrq.initJobCounts_back = function(json){
	var htmlStr = "<ul>";
	htmlStr	+="<li class='xqTitle'>&nbsp;实有人口</li>";
	var czrkNum = 0,jzrkNum = 0,ldrkNum = 0,jwrkNum = 0,wlhrkNum = 0;
	if(json!=null&&json.length>0){
		for(var i=0;i<json.length;i++){
			if(json[i].lxmc=="常住人口"){
				czrkNum = json[i].sl;
			}else if(json[i].lxmc=="寄住人口"){
				jzrkNum = json[i].sl;
			}else if(json[i].lxmc=="暂住人口"){
				ldrkNum = json[i].sl;
			}else if(json[i].lxmc=="境外人员"){
				jwrkNum = json[i].sl;
			}else if(json[i].lxmc=="未落户人员"){
				wlhrkNum = json[i].sl;
			}
		}
	}
	htmlStr	+="<li class='jobVal'><em></em><a href='javascript:void(0)' onclick='MainZrq.initJobMap(1)'>&nbsp;常住人口&nbsp;"+czrkNum+"</a></li>";
	htmlStr	+="<li class='jobVal'><em></em><a href='javascript:void(0)' onclick='MainZrq.initJobMap(2)'>&nbsp;寄住人口&nbsp;"+jzrkNum+"</a></li>";
	htmlStr	+="<li class='jobVal'><em></em><a href='javascript:void(0)' onclick='MainZrq.initJobMap(3)'>&nbsp;暂住人口&nbsp;"+ldrkNum+"</a></li>";
	htmlStr	+="<li class='jobVal'><em></em><a href='javascript:void(0)' onclick='MainZrq.initJobMap(4)'>&nbsp;境外人员&nbsp;"+jwrkNum+"</a></li>";
	htmlStr	+="<li class='jobVal'><em></em><a href='javascript:void(0)' onclick='MainZrq.initJobMap(5)'>&nbsp;未落户人员&nbsp;"+wlhrkNum+"</a></li>";
	htmlStr	+="<li class='xqTitle'>&nbsp;重点人员</li>";
	htmlStr	+="<li class='jobVal'><em></em><a href='javascript:void(0)'>&nbsp;社区矫正&nbsp;10</a></li>";
	htmlStr	+="<li class='jobVal'><em></em><a href='javascript:void(0)'>&nbsp;下落不明&nbsp;2</a></li>";
	htmlStr	+="<li class='jobVal'><em></em><a href='javascript:void(0)'>&nbsp;非正常访&nbsp;20</a></li>";
	htmlStr	+="<li class='jobVal'><em></em><a href='javascript:void(0)'>&nbsp;涉公安访&nbsp;3</a></li>";
	htmlStr	+="<li class='jobVal'><em></em><a href='javascript:void(0)'>&nbsp;其他关注&nbsp;10</a></li>";
	htmlStr	+="<li class='jobVal'><em></em><a href='javascript:void(0)'>&nbsp;肇事肇祸&nbsp;5</a></li>";
	htmlStr	+="<li class='jobVal'><em></em><a href='javascript:void(0)'>&nbsp;涉枪涉爆&nbsp;1</a></li>";
	htmlStr	+="<li class='jobVal'><em></em><a href='javascript:void(0)'>&nbsp;反恐&nbsp;0</a></li>";
	htmlStr	+="<li class='xqTitle'>&nbsp;实有房屋</li>";
	htmlStr	+="<li class='jobVal'><em></em><a href='javascript:void(0)'>&nbsp;出租房&nbsp;342</a></li>";
	htmlStr	+="<li class='jobVal'><em></em><a href='javascript:void(0)'>&nbsp;廉租房&nbsp;230</a></li>";
	htmlStr	+="<li class='jobVal'><em></em><a href='javascript:void(0)'>&nbsp;已查出租房&nbsp;530</a></li>";
	htmlStr	+="<li class='jobVal'><em></em><a href='javascript:void(0)'>&nbsp;未查出租房&nbsp;40</a></li>";
	htmlStr	+="<li class='xqTitle'>&nbsp;实有单位</li>";
	htmlStr	+="<li class='jobVal'><em></em><a href='javascript:void(0)'>&nbsp;治安单位&nbsp;32</a></li>";
	htmlStr	+="<li class='jobVal'><em></em><a href='javascript:void(0)'>&nbsp;内保单位&nbsp;15</a></li>";
	htmlStr	+="<li class='jobVal'><em></em><a href='javascript:void(0)'>&nbsp;保安单位&nbsp;25</a></li>";
	htmlStr	+="<li class='jobVal'><em></em><a href='javascript:void(0)'>&nbsp;环保单位&nbsp;12</a></li>";
	htmlStr	+="<li class='jobVal'><em></em><a href='javascript:void(0)'>&nbsp;消防单位&nbsp;21</a></li>";
	htmlStr	+="<li class='jobVal'><em></em><a href='javascript:void(0)'>&nbsp;技防单位&nbsp;52</a></li>";
	htmlStr += "</ul>";
	$("#xqTj").html(htmlStr);
};
/**
 * @method:initJobMap
 * @description:初始化地图标点
 * @author: zhang_guoliang@founder.com
 * @date:2015-8-15下午19:03:21
 */
MainZrq.initJobMap = function(lx){
	var params = {syrkywlxdm:lx,gxzrqdm:userOrgCode};
	var fajax =new FrameTools.Ajax(contextPath+"/syrkGl/queryListByRyidYwlx",MainZrq.initJobMap_back);
	fajax.send(params)
};
/**
 * @method:initJobMap_back
 * @description:初始化地图标点_回调函数
 * @author: zhang_guoliang@founder.com
 * @date:2015-8-15下午19:05:32
 */
MainZrq.initJobMap_back = function(json){
	//关闭所有器已经打开的气泡框
	MainZrq.ezMap._MapApp.closeInfoWindow();
	//判断延时是否执行完，没执行完终止此方法
	if(MainZrq.setInt!=""){
		clearInterval(MainZrq.setInt);
	}
	//判断地图上已经存在点图层清除
	if(MainZrq.initMarkerArr!=null){
		var markerLen = MainZrq.initMarkerArr.length;
		for(var j=0;j<markerLen;j++){
			MainZrq.ezMap._MapApp.removeOverlay(MainZrq.initMarkerArr[j]);
		}
	}
	//延时加载点图层
	var len = json.length;
	var count = 0;
	MainZrq.setInt = setInterval(function(){
		if(count<len){
			var zbx = json[count].jzd_zbx;
			var zby = json[count].jzd_zby;
			var title = json[count].xm;
			if(zbx!=""&&zby!=""){
				var initMarker = MainZrq.ezMap.initMarker(title,zbx,zby,'syrkBlue.png',null,null,43,37);
				MainZrq.ezMap._MapApp.addOverlay(initMarker);
				MainZrq.initMarkerArr.push(initMarker);
			}
		}else{
			clearInterval(MainZrq.setInt);
		}
		count++;
	},90);
};
/**
 * @method:initPcsXqgk
 * @description:初始化派出所辖区统计列表
 * @author: zhang_guoliang@founder.com
 * @date:2015-8-13上午10:41:32
 */
MainZrq.initPcsXqgk = function(){
	$('#dg').datagrid({
		url:contextPath+"/main/queryPcsXqgkTj",
		selectOnCheck:true,
		checkOnSelect:true,
		singleSelect:true,
		fitColumns:true,
		border:false,
		pagination:false,
		columns:[[
	          	{field:'orgname',title:'责任区',width:150,align:'center',halign:'center'},
				{field:'syrknum',title:'实有人口',width:80,align:'center',halign:'center'},
				{field:'sydwnum',title:'实有单位',width:80,align:'center',halign:'center'},      
				{field:'syfwnum',title:'实有房屋',width:80,align:'center',halign:'center'},
				{field:'bzdznum',title:'标准地址',width:80,align:'center',halign:'center'}
		 ]],
		 rownumbers:true
	});
};
/**
 * @method:initNews
 * @description:加载通知公告
 * @author: zhang_guoliang@founder.com
 * @date:2015-8-13下午16:17:21
 */
MainZrq.initNews = function(){
	var params = {xxlb:3};
	var fajax = new FrameTools.Ajax(contextPath+"/sysMessage/queryMessage",MainZrq.initNews_back);
	fajax.send(params);
};
/**
 * @method:initNews_back
 * @description:加载通知公告_回调函数
 * @author: zhang_guoliang@founder.com
 * @date:2015-8-14上午10:59:21
 */
MainZrq.initNews_back = function(json){
	var message = json.length;
	if(message>0){
		var htmlStr = "<ul>";
		for(var i=0;i<message;i++){
			if(json[i].sfck==0){
				htmlStr	+="<li><p><a href='javascript:void(0)' onclick='MainZrq.hrefUrl(\""+json[i].id+"\",\""+json[i].ywurl+"\")' title="+json[i].xxnr+"><font>【"+json[i].xxbt+"】</font>"+json[i].xxnr+"<span>【"+json[i].fssj+"】</span></a></p></li>";
			}
		}
		htmlStr += "</ul>";
		$("#newDiv").html(htmlStr);
	}
};
/**
 * @method:initWaitingWork
 * @description:加载待办事项
 * @author: zhang_guoliang@founder.com
 * @date:2015-8-14上午11:09:32
 */
MainZrq.initWaitingWork = function(){
	var params = {xxlb:2};
	var fajax = new FrameTools.Ajax(contextPath+"/sysMessage/queryMessage",MainZrq.initWaitingWork_back);
	fajax.send(params);
};
/**
 * @method:initWaitingWork_back
 * @description:加载待办事项_回调函数
 * @author: zhang_guoliang@founder.com
 * @date:2015-8-14上午11:12:43
 */
MainZrq.initWaitingWork_back = function(json){
	var message = json.length;
	if(message>0){
		var htmlStr = "<ul>";
		for(var i=0;i<message;i++){
			if(json[i].sfck==0){
				if(json[i].xxlb==2||json[i].xxlb==6){
					if(json[i].dkfs==1||json[i].xxlb==6){
						htmlStr	+="<li><p><a href='javascript:void(0)' onclick='MainZrq.openTabPage(\""+json[i].xxbt+"\",\""+json[i].ywurl+"\")' title="+json[i].xxnr+"><font>【"+json[i].xxbt+"】</font>"+json[i].xxnr+"<span>【"+json[i].fssj+"】</span></a></p></li>";
					}else{
						htmlStr	+="<li><p><a href='javascript:void(0)' onclick='MainZrq.ywxtgzrwb(\""+json[i].ywurl+"\")' title="+json[i].xxnr+"><font>【"+json[i].xxbt+"】</font>"+json[i].xxnr+"<span>【"+json[i].fssj+"】</span></a></p></li>";
					}
				}else if(json[i].xxlb==5){
					if(json[i].dkfs==1){
						htmlStr	+="<li><p><a href='javascript:void(0)' onclick='MainZrq.openTabPage(\""+json[i].xxbt+"\",\""+json[i].ywurl+"\")' title="+json[i].xxnr+"><font>【"+json[i].xxbt+"】</font>"+json[i].xxnr+"<span>【"+json[i].fssj+"】</span></a></p></li>";
					}else{
						htmlStr	+="<li><p><a href='javascript:void(0)' onclick='MainZrq.openWindow(\""+json[i].xxbt+"\",\""+json[i].ywurl+"\")' title="+json[i].xxnr+"><font>【"+json[i].xxbt+"】</font>"+json[i].xxnr+"<span>【"+json[i].fssj+"】</span></a></p></li>";
					}
				}
			}
		}
		htmlStr += "</ul>";
		$("#waitingWorkDiv").html(htmlStr);
	}
};
/**
 * @method:initRemindDiv
 * @description:加载工作提醒
 * @author: zhang_guoliang@founder.com
 * @date:2015-8-14上午11:12:53
 */
MainZrq.initRemindDiv = function(){
	var params = {xxlb:1};
	var fajax = new FrameTools.Ajax(contextPath+"/sysMessage/queryMessage",MainZrq.initRemindDiv_back);
	fajax.send(params);
};
/**
 * @method:initRemindDiv_back
 * @description:加载工作提醒_回调函数
 * @author: zhang_guoliang@founder.com
 * @date:2015-8-14上午11:14:11
 */
MainZrq.initRemindDiv_back = function(json){
	var message = json.length;
	if(message>0){
		var htmlStr = "<ul>";
		for(var i=0;i<message;i++){
			if(json[i].sfck==0){
				htmlStr	+="<li><p><a href='javascript:void(0)' onclick='MainZrq.title_onclick(\""+json[i].id+"\",\""+json[i].xxbt+"\",\""+json[i].ywurl+"\")' title="+json[i].xxnr+"><font>【"+json[i].xxbt+"】</font>"+json[i].xxnr+"<span>【"+json[i].fssj+"】</span></a></p></li>";
			}
		}
		htmlStr += "</ul>";
		$("#remindDiv").html(htmlStr);
	}
};
/**
 * @method:openTabPage
 * @description:消息打开方式【Tab页】
 * @author: zhang_guoliang@founder.com
 * @date:2015-8-14下午15:29:32
 */
MainZrq.openTabPage = function(menuName,openURL){
	menu_open(menuName, openURL);
};
/**
 * @method:ywxtgzrwb
 * @description:业务协同规则任务表
 * @author: zhang_guoliang@founder.com
 * @date:2015-8-14下午15:32:21
 */
MainZrq.ywxtgzrwb = function(url){ 
	var editUrl = contextPath + url;
	var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
   	window.top.openWindow(false, 'xtrwclWindow', editUrl, {document: document}, {title: '协同任务处理',    
	    width: 880,   
	    height: 420,  
		collapsible: false, 
		minimizable: false, 
		maximizable: false,
		closable: true,
	    closed: false,    
	    cache: false,
	    inline: false,
		resizable: false, 
	    modal: true,
	    buttons:[
	    	{
	    		id: 'button_agree',
				text: '同意',
				handler: function() {
					var iframeObject = window.top.frames['xtrwclWindow_iframe'];
					if (iframeObject.contentWindow) {
						iframeObject = iframeObject.contentWindow;
					}
					iframeObject.$('#operType').val('_agree');
					var formObject = iframeObject.$('#xtrwForm');
									
					formObject.form('submit',{
						success: function(data){    
	        				$.messager.show({
								title:'提示',
								msg:'【同意】操作成功！',
								timeout:5000,
								showType:'slide'
							});
	        				MainZrq.initWaitingWork();
							window.top.$('#xtrwclWindow').dialog('close');
    					}    
					});
				}
			},
			{
				id: 'button_refuse',
				text: '拒绝',
				handler: function() {
					var iframeObject = window.top.frames['xtrwclWindow_iframe'];
					if (iframeObject.contentWindow) {
						iframeObject = iframeObject.contentWindow;
					}
					iframeObject.$('#operType').val('_refuse');
					var formObject = iframeObject.$('#xtrwForm');
									
					formObject.form('submit',{
						success: function(data){    
	        				$.messager.show({
								title:'提示',
								msg:'【拒绝】操作成功！',
								timeout:5000,
								showType:'slide'
							});
	        				MainZrq.initWaitingWork();
							window.top.$('#xtrwclWindow').dialog('close');
    					}    
					});
				}
			},
			{
				id: 'button_conexist',
				text: '共存',
				handler: function() {
					var iframeObject = window.top.frames['xtrwclWindow_iframe'];
					if (iframeObject.contentWindow) {
						iframeObject = iframeObject.contentWindow;
					}
					iframeObject.$('#operType').val('_coexist');
					var formObject = iframeObject.$('#xtrwForm');
									
					formObject.form('submit',{
						success: function(data){    
	        				$.messager.show({
								title:'提示',
								msg:'【共存】操作成功！',
								timeout:5000,
								showType:'slide'
							});
	        				MainZrq.initWaitingWork();
							window.top.$('#xtrwclWindow').dialog('close');
    					}    
					});
				}
			}
		]}
   	);
};
/**
 * @method:openWindow
 * @description:打开方式
 * @author: zhang_guoliang@founder.com
 * @date:2015-8-14下午15:50:32
 */
MainZrq.openWindow = function(xxbt, ywurl) {
  if(null != ywurl && "" != ywurl){
     window.top.openWindow(false, "windowWithoutSave", contextPath+ywurl, {document: document}, {title: xxbt,    
	    width: 880,   
	    height: 520,  
		collapsible: false, 
		minimizable: false, 
		maximizable: false,
		style:{overflow:'auto'},
		closable: true,
	    closed: false,    
	    cache: false,
	    inline: false,
		resizable: false, 
	    modal: true});
  }
};
/**
 * @method:title_onclick
 * @description:打开消息提醒
 * @author: zhang_guoliang@founder.com
 * @date:2015-8-14下午15:50:32
 */
MainZrq.title_onclick = function(xxID,xxbt,ywurl) {
  MainZrq.editMsgStar(xxID);
  if(xxbt=="标准地址维护"){
	  var editUrl = contextPath + '/sysMessage/view?id='+xxID;
	  datagridEdit('editWindow', null,
	  		{
	   		title: '消息信息',
	   		url: editUrl,
	   		width: 850,
	   		height: 320
	   		},
	   		'您是否要保存数据？',
	   		xxbt,
	   		ywurl,
	   		xxID
	  );
  }else{
	  window.top.openWindow(false,'', contextPath+"/sysMessage/view?id="+xxID, {document: document}, {title: '消息信息',    
		    width: 850,   
		    height: 420,  
			collapsible: false, 
			minimizable: false, 
			maximizable: false,
			closable: true,
		    closed: false,    
		    cache: false,
		    inline: false,
			resizable: false, 
		    modal: true});
  }
};
/**
 * @method:editMsgStar
 * @description:修改消息状态
 * @author: zhang_guoliang@founder.com
 * @date:2015-8-14下午16:05:32
 */
MainZrq.editMsgStar = function(xxid){
    $.ajax({
       type:"POST",
       url :contextPath+"/sysMessage/update",
       data:{id:xxid},
       dataType:"json",
       success:function(data){
    	   
       }
    });
};
/**
 * @method:hrefUrl
 * @description:打开通知公告
 * @author: zhang_guoliang@founder.com
 * @date:2015-8-14下午16:29:12
 */
MainZrq.hrefUrl = function(xxID,url){
	MainZrq.editMsgStar(xxID);
	window.open(url,'通知公告',"");
};
/**
 * @method:menuOpenSyrk
 * @description:打开实有人口
 * @author: zhang_guoliang@founder.com
 * @date:2015-8-18下午18:25:32
 */
MainZrq.menuOpenSyrk = function(){
	menu_open('登记人员','/syrkGl/add?mainTabID=111');
};