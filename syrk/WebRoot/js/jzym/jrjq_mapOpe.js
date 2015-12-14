var jrjq_markers=[];
var jrjq_legendFunc=null;

var jrjq_showAlermInMap=function(org){
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
			jrjq_clear();
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
									jrjq_getHotPic();
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
			XjMap.initFloatWin_backs(ol[1]);
		},
		error:function(res){
			
		}
	});
};

var jrjq_clear=function(){
	jrjq_markers.length=0;
	XjMap.clearMarkers();
	jrjq_hotPicClose();
};

//map上添加Marker
function jrjq_addMarkers(title,zbx,zby,imgName,msgHtml,mouseFun,imgWidth,imgHeight,ifClearMap,dz_jzdzdm,type){
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

var jrjq_getHotPic=function(){
	var format = basePath+"alermAnalyse_getHotPic?BBOX=EZBOX&WIDTH=EZWIDTH&ALPHA=40&MINS=0.0000019073486328125";
	if (jrjq_legendFunc != null) {
		jrjq_legendFunc.close();
	}
	jrjq_legendFunc = new LegendFunc();
	jrjq_legendFunc.format = format;
	jrjq_legendFunc.open();
};

var jrjq_hotPicClose=function(){
	if (jrjq_legendFunc != null) {
		jrjq_legendFunc.close();
		jrjq_legendFunc=null;
	}
};