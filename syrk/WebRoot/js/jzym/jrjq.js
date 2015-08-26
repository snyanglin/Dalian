if(typeof XjMap == "undefined" || !XjMap){
	var XjMap = {};
};
XjMap.jrjq_legendFunc=null;//警情热力图对象
XjMap.jrjq_markers=[];//今日警情地图标记集合
/**
 * 查询警情信息
 */
XjMap.jrjq_showAlermInMap=function(org){
	var date = new Date();
	var y = date.getFullYear();
	var m = date.getMonth()+1+'';
	if(m.length != 2){
		m = '0'+m;
	}
	var d = date.getDate()+'';
	if(d.length != 2){
		d = '0'+d;
	}
	var last = y + "-" + m + "-" + d;
	var ol=org.split('|');
	$.ajax({
		url:basePath+'jz/queryJq',
		type:'post',
		dataType:'json',
		data:{
			'rows':10000,
			'fqsj':last,
			'jssj':last,
			'gxdwdm':ol[1]
		},
		success:function(res){
			XjMap.jrjq_clear();
			var rows=res.rows;
			var len = rows.length;
			if(len>0){
				if(ol[0]==1){
					var zbs="";
					for (var i = 0; i < len; i++) {
						var jqEntity = rows[i];
						if (jqEntity != "" && jqEntity.zddw_zxdhzb != null && jqEntity.zddw_zxdhzb != "") {
							zbs+=jqEntity.zddw_zxdhzb+','+jqEntity.zddw_zxdzzb+'|';
						}
					}
					if(zbs.length>0){
						zbs=zbs.substring(0, zbs.length-1);
						$.ajax({
							url:basePath+'forward/jzym|jqcx|jzjqQueryHotPic',
							type:'post',
							dataType:'json',
							data:{'zbs':zbs},
							success:function(res){
								if(res){
									XjMap.jrjq_getHotPic();
								}
							}
						});
					}
				}else{
					for (var i = 0; i < len; i++) {
						var jqEntity = rows[i];
						if (jqEntity != "" && jqEntity.zddw_zxdhzb != null && jqEntity.zddw_zxdhzb != "") {
							var marker = null;
							//根据设置决定是否显示图层
							var img = "dz_zb02.png";
							/*
						if(rows[i].jqlb == '1'){
							img = "jq_qz.png";
						} else if(rows[i].jqlb == '2'){
							img = "jq_tj.png";
						} else if(rows[i].jqlb == '3'){
							img = "jq_xs.png";
						} else if(rows[i].jqlb == '4'){
							img = "jq_za.png";
						}
							 */
							if (IE) {
								marker = jrjq_addMarkers('',jqEntity.zddw_zxdhzb,jqEntity.zddw_zxdzzb, img,null,null,25,25,false,jqEntity, 'jq');
							}
							else {
								marker = jrjq_addMarkers('',jqEntity.zddw_zxdhzb,jqEntity.zddw_zxdzzb, img,null,null,25,25,false,jqEntity, 'jq');
							}
							jrjq_markers.push(marker);
						}
					}
				}
			}
			XjMap.showJrjqInfo(ol[1]);
		},
		error:function(res){
			
		}
	});
};
/**
 * 获取热力图
 * @returns
 */
XjMap.jrjq_getHotPic=function(){
	var format = basePath+"alermAnalyse_getHotPic?BBOX=EZBOX&WIDTH=EZWIDTH&ALPHA=40&MINS=0.0000019073486328125";
	if (XjMap.jrjq_legendFunc != null) {
		XjMap.jrjq_legendFunc.close();
	}
	XjMap.jrjq_legendFunc = new LegendFunc();
	XjMap.jrjq_legendFunc.format = format;
	XjMap.jrjq_legendFunc.open();
};
/**
 * 地图上添加警情标记
 */
XjMap.rjq_addMarkers = function(title,zbx,zby,imgName,msgHtml,mouseFun,imgWidth,imgHeight,ifClearMap,dz_jzdzdm,type){
	XjMap.map._MapApp.closeInfoWindow();
	if(ifClearMap){
		XjMap.clearMap();
	}
	 if(title=="" || title==null){
		 title="";
	 }
	var marker = XjMap.map.initMarker(title,zbx,zby,imgName,null,null,imgWidth,imgHeight);
	//使用2张图片实现虚实效果
//	marker.addListener("mouseover", function(){
//	});
	
	XjMap.map._MapApp.addOverlay(marker);
	return marker;
};
/**
 * 清除今日警情信息
 * @returns
 */
XjMap.jrjq_clear=function(){
	XjMap.jrjq_markers.length=0;
	XjMap.clearMarkers();
	XjMap.jrjq_hotPicClose();
};
/**
 * 关门热力图图层
 */
XjMap.jrjq_hotPicClose=function(){
	if (XjMap.jrjq_legendFunc != null) {
		XjMap.jrjq_legendFunc.close();
		XjMap.jrjq_legendFunc=null;
	}
};

/**
 * 今日警情信息查询
 */
XjMap.showJrjqInfo = function(json){
	var date = new Date();
	var y = date.getFullYear();
	var m = date.getMonth()+1+'';
	if(m.length != 2){
		m = '0'+m;
	}
	var d = date.getDate()+'';
	if(d.length != 2){
		d = '0'+d;
	}
	var last = y + "-" + m + "-" + d;
	
	 var htmlStr = '';
   $.ajax
		({
			url:contextPath+"/jz/queryJrjq",
			type:"post",
			data: "gxdwdm=" + json + "&fqsj=" + last + "&jssj=" + last,
			dataType:"json",
			success:function(xmls){
				htmlStr="<ul class='infoUl'>" +
		   		"<li><h2>报警总数</h2><h3>"+xmls.countTotal+"起</h3>" +
		   		"<li><h2>违法犯罪警情</h2><h3>"+xmls.countWffz+"起</h3>" +
		   		"<li><h2>行事警情</h2><h3>"+xmls.countXs+"起</h3>" +
		   		"<li><h2>治安警情</h2><h3>"+xmls.countZa+"起</h3>" +
		   		"<li><h2>其他</h2><h3>"+xmls.countQt+"起</h3>" +
		   		"</ul>";
				$("#infoShowDiv").html(htmlStr);
			},
			error:function(){
			}
		});
};