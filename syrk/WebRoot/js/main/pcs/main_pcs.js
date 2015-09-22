if(typeof MainPcs =="undefined" || !MainPcs){
	MainPcs = {};
}
MainPcs.ezMap=null;//地图对象
MainPcs.initMarkerArr = new Array();//放点对象
MainPcs.setInt = "";//记录延时
var orgcode ="";
/**
 * @method:$
 * @description:初始化页面
 * @author: zhang_guoliang@founder.com
 * @date:2015-8-13上午9:56:32
 */
$(function(){
	MainPcs.loadXqMap();//加载辖区地图
	MainPcs.initECharts();//加载辖区概况统计图
	MainPcs.initJobCounts();//加载工作统计
	MainPcs.initPcsXqgk();//加载派出所辖区概况
	MainPcs.initNews();//加载通知公告模块
	MainPcs.initWaitingWork();//加载待办事项模块
	MainPcs.initRemindDiv();//加载工作提醒模块
	$(window).resize(function() {//调整datagrid的宽度
		var leftwidth = $("#leftid").width();
		var rightwidth = $("#rightid11").width();
		var bodywidth = $("body").width();
		var datawidth = bodywidth-leftwidth-rightwidth-10;
		$('#dg').datagrid({
			width:datawidth
		});
	});
});
/**
 * @method:loadXqMap
 * @description:加载派出所主页地图
 * @author: zhang_guoliang@founder.com
 * @date:2015-8-4上午9:16:36
 */
MainPcs.loadXqMap = function(){
	/*地图对象*/
	MainPcs.ezMap = new FrameTools.Map();
	/*设置地图代理*/
	MainPcs.ezMap.setProxy(contextPath + "/Proxy");
	/*设置地图加载容器*/
	MainPcs.ezMap.setMapDiv("xqMap");
	/*加载地图*/
	MainPcs.ezMap.onloadMap();
	/*隐藏自带矢量影像图层对象*/
	MainPcs.ezMap._MapApp.hideMapServer();
	/*加载辖区边界*/
	if(bjzbz!=""||bjzbz!=null){
		MainPcs.ezMap.moveMapToBjzbz(bjzbz);
	}
};
/**
 * @method:initECharts
 * @description:加载辖区概况统计图
 * @author: zhang_guoliang@founder.com
 * @date:2015-8-13上午10:09:43
 */
MainPcs.initECharts = function(){
	//初始化ECharts图表
	var myChart = echarts.init(document.getElementById('echartsBar'));
	var option = {
		    title : {
		        text: '辖区内实有人口类型统计图',
		        x:'center'
		    },
		    tooltip : {
		        trigger: 'item',
		        formatter: "{a} <br/>{b} : {c} ({d}%)"
		    },
		    legend: {
		        orient : 'vertical',
		        x : 'left',
		        data:['常住人口','寄住人口','暂住人口','境外人员','未落户人员']
		    },
		    toolbox: {
		        show : true,
		        feature : {
		            mark : {show: false},
		            dataView : {show: false, readOnly: false},
		            magicType : {
		                show: true, 
		                type: ['pie', 'funnel'],
		                option: {
		                    funnel: {
		                        x: '25%',
		                        width: '50%',
		                        funnelAlign: 'left',
		                        max: 1548
		                    }
		                }
		            },
		            restore : {show: true},
		            saveAsImage : {show: true}
		        }
		    },
		    calculable : true,
		    series : [
		        {
		            name:'访问来源',
		            type:'pie',
		            radius : '55%',
		            center: ['50%', '60%'],
		            data:[
		                {value:7, name:'常住人口'},
		                {value:8, name:'寄住人口'},
		                {value:5, name:'暂住人口'},
		                {value:3, name:'境外人员'},
		                {value:2, name:'未落户人员'}
		            ]
		        }
		    ]
		};
	//为ECHARTS对象加载数据 
	myChart.setOption(option,true);
	//图表宽度自动适应
	window.onresize = myChart.resize;
};
/**
 * @method:initJobCounts
 * @description:加载派出所辖区概况详情
 * @author: zhang_guoliang@founder.com
 * @date:2015-8-15下午17:58:57
 */
MainPcs.initJobCounts = function(){
	orgcode = userOrgCode;
	var params = {orgid:orgcode};
	var fajax =new FrameTools.Ajax(contextPath+"/main/countPcs",MainPcs.initJobCounts_back);
	fajax.send(params);
	$("#xqTj").mask("数据加载中...");
	
};
/**
 * @method:initJobCounts_back
 * @description:加载派出所辖区概况详情_回调函数
 * @author: zhang_guoliang@founder.com
 * @date:2015-8-15下午18:01:05
 */
MainPcs.initJobCounts_back = function(json){
	var czf = json.czf;//出租房
	var checkf = json.checkf;
    var syfwnums = json.syfwnum;
	var zzjg = json.zzjg;
	var zdry = json.zdry;
	var dwtj = json.dwtj;
	var htmlStr = "<ul>";
	htmlStr	+="<li class='xqTitle'>&nbsp;实有人口</li>";
	var czrkNum = 0,jzrkNum = 0,ldrkNum = 0,jwrkNum = 0,wlhrkNum = 0;
	var sqjznum =0,zdrknum =0,jsbnum =0,fzcswnum=0,xgzzdrynum=0,qugznum=0,sqnum=0,sbnum=0;
	var ylnum =0,tznum=0,schoolnum=0,jrnum=0,wbnum=0,gqdwnum=0,qttj=0;
	if(zzjg!=null&&zzjg.length>0){
		for(var i=0;i<zzjg.length;i++){
			if(zzjg[i].lxmc=="常住人口"){
				czrkNum = zzjg[i].sl;	
			}else if(zzjg[i].lxmc=="寄住人口"){
				jzrkNum = zzjg[i].sl;
			}else if(zzjg[i].lxmc=="暂住人口"){
				ldrkNum = zzjg[i].sl;
			}else if(zzjg[i].lxmc=="境外人员"){
				jwrkNum = zzjg[i].sl;	
			}else if(zzjg[i].lxmc=="未落户人员"){
				wlhrkNum = zzjg[i].sl;
				
			}
		}
	}
	
	if(zdry!=null&&zdry.length>0){
		for(var i=0;i<zdry.length;i++){
			if (zdry[i].zdrybm == "01") {
				sqjznum = zdry[i].zdrycount;

			}
			if (zdry[i].zdrybm == "02") {
				zdrknum = zdry[i].zdrycount;

			}
			if (zdry[i].zdrybm == "03") {
				jsbnum = zdry[i].zdrycount;

			}
			if (zdry[i].zdrybm == "04") {
				fzcswnum = zdry[i].zdrycount;

			}
			if (zdry[i].zdrybm == "05") {
				xgzzdrynum = zdry[i].zdrycount;

			}
			if (zdry[i].zdrybm == "06") {
				qugznum = zdry[i].zdrycount;

			}
			if (zdry[i].zdrybm == "07") {
				sbnum = zdry[i].zdrycount;

			}
			if (zdry[i].zdrybm == "08") {
				sqnum = zdry[i].zdrycount;

			}
		}
	}
	if(dwtj!=null&&dwtj.length>0){
		for(var i=0;i<dwtj.length;i++){
			if (dwtj[i].zdrybm == "01") {
				ylnum = dwtj[i].zdrycount;
				
			}else if (dwtj[i].zdrybm == "02") {
				tznum = dwtj[i].zdrycount;

			} else if (dwtj[i].zdrybm == "07") {
				schoolnum = dwtj[i].zdrycount;

			}else if (dwtj[i].zdrybm == "08") {
				jrnum = dwtj[i].zdrycount;

			}else if (dwtj[i].zdrybm == "09") {
				wbnum = dwtj[i].zdrycount;

			}else if (dwtj[i].zdrybm == "10") {
				gqdwnum = dwtj[i].zdrycount;

			}else{
				qttj = qttj+parseInt(dwtj[i].zdrycount);
			}
			
		}
	}
	htmlStr	+="<li class='jobVal'><em></em><a style= 'cursor:default' href='javascript:void(0)'>&nbsp;常住人口&nbsp;"+czrkNum+"</a></li>";
	htmlStr	+="<li class='jobVal'><em></em><a style= 'cursor:default' href='javascript:void(0)'>&nbsp;寄住人口&nbsp;"+jzrkNum+"</a></li>";
	htmlStr	+="<li class='jobVal'><em></em><a style= 'cursor:default' href='javascript:void(0)'>&nbsp;暂住人口&nbsp;"+ldrkNum+"</a></li>";
	htmlStr	+="<li class='jobVal'><em></em><a style= 'cursor:default' href='javascript:void(0)'>&nbsp;境外人员&nbsp;"+jwrkNum+"</a></li>";
	htmlStr	+="<li class='jobVal'><em></em><a style= 'cursor:default' href='javascript:void(0)'>&nbsp;未落户人员&nbsp;"+wlhrkNum+"</a></li>";
	htmlStr	+="<li class='xqTitle'>&nbsp;重点人员</li>";
	htmlStr	+="<li class='jobVal1'><em></em><a href='javascript:void(0)'onclick=\"MainPcs.initJobzdryMap('01')\">&nbsp;社区矫正&nbsp;"+sqjznum+"</a></li>";
	htmlStr	+="<li class='jobVal1'><em></em><a href='javascript:void(0)'onclick=\"MainPcs.initJobzdryMap('02')\">&nbsp;重点人口&nbsp;"+zdrknum+"</a></li>";
	htmlStr	+="<li class='jobVal1'><em></em><a href='javascript:void(0)'onclick=\"MainPcs.initJobzdryMap('03')\">&nbsp;肇事肇祸精神病人&nbsp;"+jsbnum+"</a></li>";
	htmlStr	+="<li class='jobVal1'><em></em><a href='javascript:void(0)'onclick=\"MainPcs.initJobzdryMap('04')\">&nbsp;非正常上访重点人员&nbsp;"+fzcswnum+"</a></li>";
	htmlStr	+="<li class='jobVal1'><em></em><a href='javascript:void(0)'onclick=\"MainPcs.initJobzdryMap('05')\">&nbsp;涉公安访重点人员&nbsp;"+xgzzdrynum+"</a></li>";
	htmlStr	+="<li class='jobVal1'><em></em><a href='javascript:void(0)'onclick=\"MainPcs.initJobzdryMap('06')\">&nbsp;其他工作对象&nbsp;"+qugznum+"</a></li>";
	htmlStr	+="<li class='jobVal1'><em></em><a href='javascript:void(0)'onclick=\"MainPcs.initJobzdryMap('07')\">&nbsp;涉爆重点人员&nbsp;"+sbnum+"</a></li>";
	htmlStr	+="<li class='jobVal1'><em></em><a href='javascript:void(0)'onclick=\"MainPcs.initJobzdryMap('07')\">&nbsp;涉枪重点人员&nbsp;"+sqnum+"</a></li>";
	htmlStr	+="<li class='xqTitle'>&nbsp;实有房屋</li>";
	htmlStr	+="<li class='jobVal'><em></em><a style= 'cursor:default' href='javascript:void(0)'>&nbsp;实有房屋&nbsp;"+syfwnums+"</a></li>";
	htmlStr	+="<li class='jobVal'><em></em><a style= 'cursor:default'  href='javascript:void(0)'>&nbsp;出租房&nbsp;"+czf+"</a></li>";
	htmlStr	+="<li class='jobVal'><em></em><a style= 'cursor:default' href='javascript:void(0)'>&nbsp;已检查租房&nbsp;"+checkf+"</a></li>";

	htmlStr	+="<li class='xqTitle'>&nbsp;实有单位</li>";
	htmlStr	+="<li class='jobVal'><em></em><a style= 'cursor:default' href='javascript:void(0)'>&nbsp;娱乐服务场所&nbsp;"+ylnum+"</a></li>";
	htmlStr	+="<li class='jobVal'><em></em><a style= 'cursor:default' href='javascript:void(0)'>&nbsp;特种行业&nbsp;"+tznum+"</a></li>";
	htmlStr	+="<li class='jobVal'><em></em><a style= 'cursor:default' href='javascript:void(0)'>&nbsp;学校&nbsp;"+schoolnum+"</a></li>";
	htmlStr	+="<li class='jobVal'><em></em><a style= 'cursor:default' href='javascript:void(0)'>&nbsp;金融单位&nbsp;"+jrnum+"</a></li>";
	htmlStr	+="<li class='jobVal'><em></em><a style= 'cursor:default' href='javascript:void(0)'>&nbsp;文保单位&nbsp;"+wbnum+"</a></li>";
	htmlStr	+="<li class='jobVal'><em></em><a style= 'cursor:default' href='javascript:void(0)'>&nbsp;工企单位&nbsp;"+gqdwnum+"</a></li>";
	htmlStr	+="<li class='jobVal'><em></em><a style= 'cursor:default' href='javascript:void(0)'>&nbsp;其他单位&nbsp;"+qttj+"</a></li>";
	htmlStr += "</ul>";
	$("#xqTj").html(htmlStr);
	$("#xqTj").unmask("数据加载中...");
};
/**
 * @method:initJobMap
 * @description:初始化地图标点
 * @author: zhang_guoliang@founder.com
 * @date:2015-8-15下午19:03:21
 */
MainPcs.initJobMap = function(lx){
	var params = {syrkywlxdm:lx,gxpcsdm:orgcode,gxzrqdm:orgcode};
	var fajax =new FrameTools.Ajax(contextPath+"/main/queryListMapsyrk",MainPcs.initJobMap_back);
	fajax.send(params);
};

MainPcs.initJobzdryMap = function(lx){
	var params = {zdrybm:lx,orgid:orgcode};
	var fajax =new FrameTools.Ajax(contextPath+"/main/queryListMapzdrk",MainPcs.initJobMap_back);
	fajax.send(params);
};
/**
 * @method:initJobMap_back
 * @description:初始化地图标点_回调函数
 * @author: zhang_guoliang@founder.com
 * @date:2015-8-15下午19:05:32
 */
MainPcs.initJobMap_back = function(json){
	//关闭所有器已经打开的气泡框
	MainPcs.ezMap._MapApp.closeInfoWindow();
	//判断延时是否执行完，没执行完终止此方法
	if(MainPcs.setInt!=""){
		clearInterval(MainPcs.setInt);
	}
	//判断地图上已经存在点图层清除
	if(MainPcs.initMarkerArr!=null){
		var markerLen = MainPcs.initMarkerArr.length;
		for(var j=0;j<markerLen;j++){
			MainPcs.ezMap._MapApp.removeOverlay(MainPcs.initMarkerArr[j]);
		}
	}
	//延时加载点图层
	var len = json.length;
	var count = 0;
	MainPcs.setInt = setInterval(function(){
		if(count<len){
			var zbx = json[count].zbx;
			var zby = json[count].zby;
			var title = json[count].title;
			if(zbx!=""&&zby!=""){
				var initMarker = MainPcs.ezMap.initMarker(title,zbx,zby,'syrkBlue.png',null,null,43,37);
				MainPcs.ezMap._MapApp.addOverlay(initMarker);
				MainPcs.initMarkerArr.push(initMarker);
			}
		}else{
			clearInterval(MainPcs.setInt);
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
MainPcs.initPcsXqgk = function(){
	$('#dg').datagrid({
		url:contextPath+"/main/queryPcsXqgkTj",
		selectOnCheck:true,
		checkOnSelect:true,
		singleSelect:true,
		fitColumns:true,
		border:false,
		pagination:false,
		width:100,
		onClickRow:function (index, row){
			MainPcs.onClickRow(index, row);
		},
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

MainPcs.onClickRow = function(rowIndex,rowData){
	MainPcs.initJobzrqCounts(rowData.orgcode);
}

MainPcs.initJobzrqCounts = function(Orgcode){
	orgcode = Orgcode;
	var params = {orgid:orgcode};
	var fajax =new FrameTools.Ajax(contextPath+"/main/countPcs",MainPcs.initJobCounts_back);
	fajax.send(params);
	$("#xqTj").mask("数据加载中...");
}

/**
 * @method:initNews
 * @description:加载通知公告
 * @author: zhang_guoliang@founder.com
 * @date:2015-8-13下午16:17:21
 */
MainPcs.initNews = function(){
	var params = {xxlb:3};
	var fajax = new FrameTools.Ajax(contextPath+"/sysMessage/queryMessage",MainPcs.initNews_back);
	fajax.send(params);
};
/**
 * @method:initNews_back
 * @description:加载通知公告_回调函数
 * @author: zhang_guoliang@founder.com
 * @date:2015-8-14上午10:59:21
 */
MainPcs.initNews_back = function(json){
	var message = json.length;
	if(message>0){
		var htmlStr = "<ul>";
		for(var i=0;i<message;i++){
			if(json[i].sfck==0){
				htmlStr	+="<li><a href='javascript:void(0)' onclick='MainPcs.hrefUrl(\""+json[i].id+"\",\""+json[i].ywurl+"\")' title="+json[i].xxnr+"><font>【"+json[i].xxbt+"】</font>"+json[i].xxnr+"<span>【"+json[i].fssj+"】</span></a></li>";
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
MainPcs.initWaitingWork = function(){
	var params = {xxlb:2};
	var fajax = new FrameTools.Ajax(contextPath+"/sysMessage/queryMessage",MainPcs.initWaitingWork_back);
	fajax.send(params);
};
/**
 * @method:initWaitingWork_back
 * @description:加载待办事项_回调函数
 * @author: zhang_guoliang@founder.com
 * @date:2015-8-14上午11:12:43
 */
MainPcs.initWaitingWork_back = function(json){
	var message = json.length;
	if(message>0){
		var htmlStr = "<ul>";
		for(var i=0;i<message;i++){
			if(json[i].sfck==0){
				if(json[i].xxlb==2||json[i].xxlb==6){
					if(json[i].dkfs==1||json[i].xxlb==6){
						htmlStr	+="<li><a href='javascript:void(0)' onclick='MainPcs.openTabPage(\""+json[i].xxbt+"\",\""+json[i].ywurl+"\")' title="+json[i].xxnr+"><font>【"+json[i].xxbt+"】</font>"+json[i].xxnr+"<span>【"+json[i].fssj+"】</span></a></li>";
					}else{
						htmlStr	+="<li><a href='javascript:void(0)' onclick='MainPcs.ywxtgzrwb(\""+json[i].ywurl+"\")' title="+json[i].xxnr+"><font>【"+json[i].xxbt+"】</font>"+json[i].xxnr+"<span>【"+json[i].fssj+"】</span></a></li>";
					}
				}else if(json[i].xxlb==5){
					if(json[i].dkfs==1){
						htmlStr	+="<li><a href='javascript:void(0)' onclick='MainPcs.openTabPage(\""+json[i].xxbt+"\",\""+json[i].ywurl+"\")' title="+json[i].xxnr+"><font>【"+json[i].xxbt+"】</font>"+json[i].xxnr+"<span>【"+json[i].fssj+"】</span></a></li>";
					}else{
						htmlStr	+="<li><a href='javascript:void(0)' onclick='MainPcs.openWindow(\""+json[i].xxbt+"\",\""+json[i].ywurl+"\")' title="+json[i].xxnr+"><font>【"+json[i].xxbt+"】</font>"+json[i].xxnr+"<span>【"+json[i].fssj+"】</span></a></li>";
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
MainPcs.initRemindDiv = function(){
	var params = {xxlb:1};
	var fajax = new FrameTools.Ajax(contextPath+"/sysMessage/queryMessage",MainPcs.initRemindDiv_back);
	fajax.send(params);
};
/**
 * @method:initRemindDiv_back
 * @description:加载工作提醒_回调函数
 * @author: zhang_guoliang@founder.com
 * @date:2015-8-14上午11:14:11
 */
MainPcs.initRemindDiv_back = function(json){
	var message = json.length;
	if(message>0){
		var htmlStr = "<ul>";
		for(var i=0;i<message;i++){
			if(json[i].sfck==0){
				htmlStr	+="<li><a href='javascript:void(0)' onclick='MainPcs.title_onclick(\""+json[i].id+"\",\""+json[i].xxbt+"\",\""+json[i].ywurl+"\")' title="+json[i].xxnr+"><font>【"+json[i].xxbt+"】</font>"+json[i].xxnr+"<span>【"+json[i].fssj+"】</span></a></li>";
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
MainPcs.openTabPage = function(menuName,openURL){
	menu_open(menuName, openURL);
};
/**
 * @method:ywxtgzrwb
 * @description:业务协同规则任务表
 * @author: zhang_guoliang@founder.com
 * @date:2015-8-14下午15:32:21
 */
MainPcs.ywxtgzrwb = function(url){ 
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
	        				MainPcs.initWaitingWork();
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
	        				MainPcs.initWaitingWork();
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
	        				MainPcs.initWaitingWork();
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
MainPcs.openWindow = function(xxbt, ywurl) {
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
MainPcs.title_onclick = function(xxID,xxbt,ywurl) {
  MainPcs.editMsgStar(xxID);
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
MainPcs.editMsgStar = function(xxid){
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
MainPcs.hrefUrl = function(xxID,url){
	MainPcs.editMsgStar(xxID);
	window.open(url,'通知公告',"");
};

/**
 * @method:hrefUrl
 * @description:打开通知公告
 * @author: zhang_guoliang@founder.com
 * @date:2015-8-14下午16:29:12
 */
function queryMsg(bs){
	if("通知公告" == bs){
	       menu_open(bs, "/forward/message|sysMessage");
	    }else if("消息提醒" == bs){
	       menu_open(bs, "/forward/message|sysMessage1");
	    }  else{
	       menu_open(bs, "/forward/message|sysMessage2");
	    }
}