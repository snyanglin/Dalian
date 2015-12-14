if(typeof DzBuildingShow == "undefined" || !DzBuildingShow){
	var DzBuildingShow = {};
};
DzBuildingShow = function(){
	this.pk = Math.random();
};
DzBuildingShow.divdsMaxWidth = 0;//地上最大宽度
DzBuildingShow.divdxMaxWidth = 0;//地下最大宽度
DzBuildingShow.dsdyHtml = "";//地上单元HTML
DzBuildingShow.dxdyHtml = "";//地下单元HTML
DzBuildingShow.czrknum = 0;//常住人口
DzBuildingShow.jzrknum = 0;//寄住人口
DzBuildingShow.ldrynum = 0;//流动人员
DzBuildingShow.jwrynum = 0;//境外人员
DzBuildingShow.wlhrynum = 0;//未落户人员
DzBuildingShow.sydwnum = 0;//实有单位
/**
 * @title:Jquery
 * @description:初始化层户结构
 * @author: zhang_guoliang@founder.com
 * @param       
 * @date:2015-05-7 09:12:34
 */
$(function(){
	//加载层户结构
	DzBuildingShow.onloadChjg();
});
/**
 * @title:onloadChjg
 * @description:加载门楼地址信息（房间）
 * @author: zhang_guoliang@founder.com
 * @param mldzid【门楼地址ID】
 * @date:2015-05-07 09:54:43
 */
DzBuildingShow.onloadChjg = function(){
	var url = contextPath+"/dz/queryChdzdxbShow/"+mldzid;
	//层户地址
	$.ajax({
		type:"GET",
		sync:true,
		url:url,
		dataType:'json',
		success:function(json){
			DzBuildingShow.onloadChshdz_back(json);
		}
	});
};
/**
 * @title:onloadChshdz_back
 * @description:加载层户结构
 * @author: zhang_guoliang@founder.com
 * @param mldzid【门楼地址ID】 
 * @date:2015-05-07 09:58:24
 */   
DzBuildingShow.onloadChshdz_back = function(json){
	if(json){
		DzBuildingShow.jsonHsdz = json;
		var url = contextPath+"/dz/queryJzwChjg/"+mldzid;
		$.ajax({
			type:"GET",
			sync:true,
			url:url,
			dataType:'json',
			success:function(json){
				DzBuildingShow.onloadChjg_back(json);
			}
		});
	}
};
/**
 * @title:onloadChjg_back
 * @description:加载层户结构_回调函数
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-05-07 10:00:32
 */
DzBuildingShow.onloadChjg_back = function(json){
	var chjglen = json.length;
	if(chjglen>0){
		for(var t=0;t<chjglen;t++){
			var zddys = json[t].dyh;
			var zdcs = json[t].zdlcs;
			var zdhs = json[t].zdhs;
			var dyhlx = json[t].dyhlx;
			if(dyhlx=="1"){
				DzBuildingShow.dsdyHtml += DzBuildingShow.addDsDys(zddys,zdcs,zdhs);
			}else if(dyhlx=="0"){
				DzBuildingShow.dxdyHtml += DzBuildingShow.addDxDys(zddys,zdcs,zdhs);
			}
		}
		//加载地上单元信息
		DzBuildingShow.onloadDsDys();
		//加载地下单元信息
		DzBuildingShow.onloadDxDys();
		//设置整体宽度
		DzBuildingShow.divWidth();
		//统计层户结构人员、单位信息
		DzBuildingShow.onloadChjgJbxx();
	}
};
/**
 * @title:onloadChjgJbxx
 * @description:加载层户结构基本信息
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-05-08 14:27:35
 */
DzBuildingShow.onloadChjgJbxx = function(){
	var zs = DzBuildingShow.czrknum + DzBuildingShow.jzrknum + DzBuildingShow.ldrynum + DzBuildingShow.jwrynum + DzBuildingShow.wlhrynum;
	$("#jzwjbxxDiv").html("地址："+dzmc+"；共居住<span id='zsId' style='font-size: 16px;font-family:微软雅黑;font-weight:normal;'>"+zs+"</span>人，" +
		"其中常住人口<span id='czrkId' style='font-size: 16px;font-family:微软雅黑; font-weight:normal;'>"+DzBuildingShow.czrknum+"</span>人、" +
			"寄住人口<span id='zzrkId' style='font-size: 16px;font-family:微软雅黑; font-weight:normal;'>"+DzBuildingShow.jzrknum+"</span>人、" +
		    "流动人员<span id='jwrkId' style='font-size: 16px;font-family:微软雅黑; font-weight:normal;'>"+DzBuildingShow.ldrynum+"</span>人、" +
			"境外人员<span id='jzrkId' style='font-size: 16px;font-family:微软雅黑; font-weight:normal;'>"+DzBuildingShow.jwrynum+"</span>人、" +
			"未落户人员<span id='jzrkId' style='font-size: 16px;font-family:微软雅黑; font-weight:normal;'>"+DzBuildingShow.wlhrynum+"</span>人、" +
			"重点人口<span id='zdrkId' style='font-size: 16px;font-family:微软雅黑; font-weight:normal;'>0</span>人；" +
			"实有单位<span id='sydwId' style='font-size: 16px;font-family:微软雅黑; font-weight:normal;'>"+DzBuildingShow.sydwnum+"</span>个；");
}
/**
 * @title:onloadDsDys
 * @description:加载地上单元数容器
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-05-07 10:05:21
 */
DzBuildingShow.onloadDsDys = function(){
	//层户结构容器
	var chjgHtml = "<table cellpadding='0' cellspacing='0' class='juzhong'>";
	//定义单元Html
	var dyHtml = "<div class='t_list'><dl>"+DzBuildingShow.dsdyHtml+"</dl></div>";
	chjgHtml += "<tr><td>"+dyHtml+"</td></tr></table>";
	$("#chjgAddDsDiv").html(chjgHtml);
};
/**
 * @title:addDsDys
 * @description:创建地上单元数
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-05-07 10:09:21
 */
DzBuildingShow.addDsDys = function(dys,cs,hs){
	var topHtml = DzBuildingShow.setTopHtml(dys,cs,hs);
	var LcHtml = DzBuildingShow.setLcHtml(dys,cs,hs);
	var Maxwidth = DzBuildingShow.dyWidth(hs);
	DzBuildingShow.divdsMaxWidth += Maxwidth;
	var dyHtml = "<dt id='dsdydt_"+dys+"' style='width:"+Maxwidth+"px;'><table cellpadding='0' cellspacing='0' width='100%'>"+topHtml+""+LcHtml+"</table></dt>";
	return dyHtml;
};
/**
 * @title:setTopHtml
 * @description:加载屋顶和单元数
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-05-07 10:26:54
 */
DzBuildingShow.setTopHtml = function(dys,cs,hs){
	//begin:屋顶
	var dyTopHtml = "<tr><td>" +
			"<table cellpadding='0' cellspacing='0' align='center' width='100%' class='b_top_table'>" +
			"<tr>" +
			"<td class='b_top_l'></td>" +
			"<td class='b_top_c'></td>" +
			"<td class='b_top_r'></td>" +
			"</tr>" +
			"</table>" +
			"</td></tr><tr><td>";
	dyTopHtml += "<div class='floot_numOnly' id='dsdyh_"+dys+"-"+cs+"'><input type='hidden' name='dsdymcName' value='"+dys+"'/><a href='javascript:void(0);' id='dsdy_"+dys+"-"+cs+"-"+hs+"' name='dsdyName' value='"+dys+"-"+cs+"-"+hs+"'>"+dys+"</a></div>";
	dyTopHtml += "</td></tr>";
	//end:屋顶
	return dyTopHtml;
};
/**
 * @title:setLcHtml
 * @description:加载楼层
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-05-07 10:28:11
 */
DzBuildingShow.setLcHtml = function(i,cs,hs){
	var htmlStr = "";
	for(var l=cs;l>0;l--){
		var hsHtml = DzBuildingShow.getHsHtml(l,hs,i,"ds");
		htmlStr += "<tr><td class='gd_line'>" +
				"<div class='ceng_W'>" +
				"<ul id='dslchs_"+i+"-"+l+"'>" +
				"<li class='qiang3'></li>";
		htmlStr += "<li class='cengNumOnlyShow'><input type='hidden' name='dszdlchs_"+i+"' value='"+hs+"'/><a href='javascript:void(0);' id='dslc_"+i+"-"+l+"' name='dslcName' value='"+i+"-"+l+"'>"+l+"层</a></li>"+hsHtml+"<li class='qiang4'></li>";
		htmlStr += "</ul></div></td></tr>";
	}
	return htmlStr;
};
/**
 * @title:getHsHtml
 * @description:加载单元房间
 * @author: zhang_guoliang@founder.com   
 * @param   
 * @date:2015-05-07 10:10:12
 */
DzBuildingShow.getHsHtml = function(cs,hs,dys,bz){
	var htmlStr = "";
	for(var t=0;t<DzBuildingShow.jsonHsdz.length;t++){
		var dyh = DzBuildingShow.jsonHsdz[t].dyh;
		var lch = DzBuildingShow.jsonHsdz[t].lch;
		var dyhlx = DzBuildingShow.jsonHsdz[t].dyhlx;
		var dzmc = DzBuildingShow.jsonHsdz[t].dzmc;
		var chdz = DzBuildingShow.jsonHsdz[t].chdzid;
		var shbs = DzBuildingShow.jsonHsdz[t].shbs;
		if(dyhlx=="1"&&bz=="ds"&&lch==cs&&dys==dyh){
			var roomName = DzBuildingShow.jsonHsdz[t].shmc;
			if(shbs!=null&&shbs!=""){
				htmlStr += "<li style='background: #"+shbs+";'>";
				if(chdz==chdzid){
					htmlStr += "<div class='cengButton' id='dsfjh_"+dys+"-"+roomName+"'><a href='javascript:void(0);' id='dsfj_"+roomName+"' name='dsfjName' style='background: peachpuff;' title='"+dzmc+"' value='"+dys+"-"+roomName+"'>"+roomName+"</a>";
				}else{
					htmlStr += "<div class='cengButton' id='dsfjh_"+dys+"-"+roomName+"'><a href='javascript:void(0);' id='dsfj_"+roomName+"' name='dsfjName' title='"+dzmc+"' value='"+dys+"-"+roomName+"'>"+roomName+"</a>";
				}
			}else{
				if(chdz==chdzid){
					htmlStr += "<li style='background: peachpuff;'>";
				}else{
					htmlStr += "<li>";
				}
				htmlStr += "<div class='cengButton' id='dsfjh_"+dys+"-"+roomName+"'><a href='javascript:void(0);' id='dsfj_"+roomName+"' name='dsfjName' title='"+dzmc+"' onclick='DzBuildingShow.showCalendarHouseDiv(\""+dys+"-"+roomName+"\",\""+chdz+"\");' value='"+dys+"-"+roomName+"'>"+roomName+"</a>";
			}
			htmlStr += "<table cellpadding = '0' cellspacing = '0' height='100%' width='100%' style='text-align: center;'>" +
					   "<tr><td style='width:25px;height:13px;'>";
			if(DzBuildingShow.jsonHsdz[t].czrknum!=0){
			    //常住人口
				htmlStr += "<img src='"+contextPath+"/images/bzdz/building/czrk.png' alt='常住人口共："+DzBuildingShow.jsonHsdz[t].czrknum+"人' style='width:14px;height:13px;'/>";
				DzBuildingShow.czrknum += parseInt(DzBuildingShow.jsonHsdz[t].czrknum);
			}
			htmlStr += "</td><td style='width:25px;height:13px;'>";
			if(DzBuildingShow.jsonHsdz[t].jzrknum!=0){
				//寄住人口
				htmlStr += "<img src='"+contextPath+"/images/bzdz/building/jzrk.png' alt='寄住人口共："+DzBuildingShow.jsonHsdz[t].jzrknum+"人' style='width:14px;height:13px;'/>";
				DzBuildingShow.jzrknum += parseInt(DzBuildingShow.jsonHsdz[t].jzrknum);
			}
			htmlStr += "</td></tr><tr><td style='width:25px;height:13px;'>";
			if(DzBuildingShow.jsonHsdz[t].ldrynum!=0){
				//流动人员
				htmlStr += "<img src='"+contextPath+"/images/bzdz/building/zzrk.png' alt='流动人员共："+DzBuildingShow.jsonHsdz[t].ldrynum+"人' style='width:14px;height:13px;'/>";
				DzBuildingShow.ldrynum += parseInt(DzBuildingShow.jsonHsdz[t].ldrynum);
			}
			htmlStr += "</td><td style='width:25px;height:13px;'>";
			if(DzBuildingShow.jsonHsdz[t].jwrynum!=0){
				//境外人员
				htmlStr += "<img src='"+contextPath+"/images/bzdz/building/jwrk.png' alt='境外人员共："+DzBuildingShow.jsonHsdz[t].jwrynum+"人' style='width:14px;height:13px;'/>";
				DzBuildingShow.jwrynum += parseInt(DzBuildingShow.jsonHsdz[t].jwrynum);
			}
			htmlStr += "</td></tr><tr><td style='width:25px;height:13px;'>";
			if(false){
				htmlStr += "<img src='"+contextPath+"/images/bzdz/building/zdrk.png' style='width:14px;height:13px;'/>";
			}
			htmlStr += "</td><td style='width:25px;height:13px;'>";
			if(DzBuildingShow.jsonHsdz[t].sydwnum!=0){
				htmlStr += "<img src='"+contextPath+"/images/bzdz/building/sydw.png' alt='实有单位共："+DzBuildingShow.jsonHsdz[t].sydwnum+"个' style='width:14px;height:13px;'/>";
				DzBuildingShow.sydwnum += parseInt(DzBuildingShow.jsonHsdz[t].sydwnum);
			}
			htmlStr += "</td></tr>" +
					   "</table>" +
					   "</div></li>";
			if(DzBuildingShow.jsonHsdz[t].wlhrynum!=0){
				//未落户人员
				DzBuildingShow.wlhrynum += parseInt(DzBuildingShow.jsonHsdz[t].wlhrynum);
			}
			DzBuildingShow.jsonHsdz.splice(t,1);
			t = t - 1;
		}else if(dyhlx=="0"&&bz=="dx"&&lch==cs&&dys==dyh){
			var roomName = DzBuildingShow.jsonHsdz[t].shmc;
			if(shbs!=null&&shbs!=""){
				htmlStr += "<li style='background: #"+shbs+";'>";
				if(chdz==chdzid){
					htmlStr += "<div class='cengButton' id='dxfjh_"+dys+"-"+roomName+"'><a href='javascript:void(0);' id='dxfj_"+roomName+"' name='dxfjName' style='background: peachpuff;' title='"+dzmc+"' value='"+dys+"-"+cs+"-"+DzBuildingShow.jsonHsdz[t].sh+"'>"+roomName+"</a>";
				}else{
					htmlStr += "<div class='cengButton' id='dxfjh_"+dys+"-"+roomName+"'><a href='javascript:void(0);' id='dxfj_"+roomName+"' name='dxfjName' title='"+dzmc+"' value='"+dys+"-"+cs+"-"+DzBuildingShow.jsonHsdz[t].sh+"'>"+roomName+"</a>";
				}
			}else{
				if(chdz==chdzid){
					htmlStr += "<li style='background: peachpuff;'>";
				}else{
					htmlStr += "<li>";
				}
				htmlStr += "<div class='cengButton' id='dxfjh_"+dys+"-"+roomName+"'><a href='javascript:void(0);' id='dxfj_"+roomName+"' name='dxfjName' title='"+dzmc+"' value='"+dys+"-"+cs+"-"+DzBuildingShow.jsonHsdz[t].sh+"'>"+roomName+"</a>";
			}
			htmlStr += "<table cellpadding = '0' cellspacing = '0' height='100%' width='100%' style='text-align: center;'>" +
					   "<tr><td style='width:25px;height:13px;'>";
			if(DzBuildingShow.jsonHsdz[t].czrknum!=0){
			    //常住人口
				htmlStr += "<img src='"+contextPath+"/images/bzdz/building/czrk.png' alt='常住人口共："+DzBuildingShow.jsonHsdz[t].czrknum+"人' style='width:14px;height:13px;'/>";
				DzBuildingShow.czrknum += parseInt(DzBuildingShow.jsonHsdz[t].czrknum);
			}
			htmlStr += "</td><td style='width:25px;height:13px;'>";
			if(DzBuildingShow.jsonHsdz[t].jzrknum!=0){
				//寄住人口
				htmlStr += "<img src='"+contextPath+"/images/bzdz/building/jzrk.png' alt='寄住人口共："+DzBuildingShow.jsonHsdz[t].jzrknum+"人' style='width:14px;height:13px;'/>";
				DzBuildingShow.jzrknum += parseInt(DzBuildingShow.jsonHsdz[t].jzrknum);
			}
			htmlStr += "</td></tr><tr><td style='width:25px;height:13px;'>";
			if(DzBuildingShow.jsonHsdz[t].ldrynum!=0){
				//流动人员
				htmlStr += "<img src='"+contextPath+"/images/bzdz/building/zzrk.png' alt='流动人员共："+DzBuildingShow.jsonHsdz[t].ldrynum+"人' style='width:14px;height:13px;'/>";
				DzBuildingShow.ldrynum += parseInt(DzBuildingShow.jsonHsdz[t].ldrynum);
			}
			htmlStr += "</td><td style='width:25px;height:13px;'>";
			if(DzBuildingShow.jsonHsdz[t].jwrynum!=0){
				//境外人员
				htmlStr += "<img src='"+contextPath+"/images/bzdz/building/jwrk.png' alt='境外人员共："+DzBuildingShow.jsonHsdz[t].jwrynum+"人' style='width:14px;height:13px;'/>";
				DzBuildingShow.jwrynum += parseInt(DzBuildingShow.jsonHsdz[t].jwrynum);
			}
			htmlStr += "</td></tr><tr><td style='width:25px;height:13px;'>";
			if(false){
				htmlStr += "<img src='"+contextPath+"/images/bzdz/building/zdrk.png' style='width:14px;height:13px;'/>";
			}
			htmlStr += "</td><td style='width:25px;height:13px;'>";
			if(DzBuildingShow.jsonHsdz[t].sydwnum!=0){
				htmlStr += "<img src='"+contextPath+"/images/bzdz/building/sydw.png' alt='实有单位共："+DzBuildingShow.jsonHsdz[t].sydwnum+"个' style='width:14px;height:13px;'/>";
				DzBuildingShow.sydwnum += parseInt(DzBuildingShow.jsonHsdz[t].sydwnum);
			}
			htmlStr += "</td></tr>" +
					   "</table>" +
					   "</div></li>";
			if(DzBuildingShow.jsonHsdz[t].wlhrynum!=0){
				//未落户人员
				DzBuildingShow.wlhrynum += parseInt(DzBuildingShow.jsonHsdz[t].wlhrynum);
			}
			DzBuildingShow.jsonHsdz.splice(t,1);
			t = t - 1;
		}
	}
	return htmlStr;
};
/**
 * @title:getRoomBm
 * @description:根据房间层户信息获取标准房间编码
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-01-19 14:01:35
 */	
DzBuildingShow.getRoomBm = function(cs,hs,bz){
	var roomBm = "";
	if(bz == "ds"){
		roomBm = cs+"-"+hs;
	}else if(bz == "dx"){
		roomBm = "B"+cs+"-"+hs;
	}
	return roomBm;
};
/**
 * @title:onloadDxDys
 * @description:加载地下单元数容器
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-02-08 16:59:21
 */
DzBuildingShow.onloadDxDys = function(){
	//层户结构容器
	var chjgHtml = "<table cellpadding='0' cellspacing='0' class='juzhong'>";
	//定义单元Html
	var dyHtml = "<div class='t_listDx'><dl>"+DzBuildingShow.dxdyHtml+"</dl></div>";
	chjgHtml += "<tr><td>"+dyHtml+"</td></tr></table>";
	$("#chjgAddDxDiv").html(chjgHtml);
};
/**
 * @title:addDxDys
 * @description:创建地下单元数
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-02-02 19:38:26
 */
DzBuildingShow.addDxDys = function(dys,cs,hs){
    var downHtml = DzBuildingShow.setDownHtml(dys,cs,hs);
	var DxLcHtml = DzBuildingShow.setDxLcHtml(dys,cs,hs);
	var Maxwidth = DzBuildingShow.dyWidth(hs);
	DzBuildingShow.divdxMaxWidth += Maxwidth;
	var dyHtml = "<dt id='dxdydt_"+dys+"' style='width:"+Maxwidth+"px;'><table cellpadding='0' cellspacing='0' width='100%'>"+downHtml+""+DxLcHtml+"</table></dt>";
	return dyHtml;
};
/**
 * @title:setDownHtml
 * @description:加载地下单元数
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-01-20 15:19:43
 */
DzBuildingShow.setDownHtml = function(dxdys,cs,hs){
	//begin:地下单元
	var dyDownHtml = "<tr><td><div class='floot_numOnly' id='dxdyh_"+dxdys+"-"+cs+"'><input type='hidden' name='dxdymcName' value='"+dxdys+"'/><a href='javascript:void(0);' id='dxdy_"+dxdys+"-B"+cs+"-"+hs+"' name='dxdyName' value='"+dxdys+"-"+cs+"-"+hs+"'>地下"+dxdys+"</a></div></td></tr>";
	//end:地下单元
	return dyDownHtml;
};
/**
 * @title:setDxLcHtml
 * @description:加载地下楼层数
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-01-20 15:19:43
 */
DzBuildingShow.setDxLcHtml = function(i,cs,hs){
	var htmlStr = "";
	for(var l=1;l<=cs;l++){
		var hsHtml = DzBuildingShow.getHsHtml(l,hs,i,"dx");
		htmlStr += "<tr><td class='gd_line'>" +
				"<div class='ceng_W'>" +
				"<ul id='dxlchs_"+i+"-"+l+"'>" +
				"<li class='qiang3'></li>";
		htmlStr += "<li class='cengNumOnlyShow'><input type='hidden' name='dxzdlchs_"+i+"' value='"+hs+"'/><a href='javascript:void(0);' id='dxlc_"+i+"-"+l+"' name='dxlcName' value='"+i+"-"+l+"'>B"+l+"层</a></li>"+hsHtml+"<li class='qiang4'></li>";
		htmlStr += "</ul></div></td></tr>";
	}
	return htmlStr;
};
/**
 * @title:dyWidth
 * @description:计算单元的宽度
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-02-08 20:18:45
 */
DzBuildingShow.dyWidth = function(hs){
	//IE和谷歌浏览器差2像素
	var ieWid = 64;
	if(!IE){
		ieWid = 66;
	}
	//修改本单元的宽度
	var maxW = 0;
	if(hs==""){
		maxW = 116+ieWid;
	}else{
		maxW = 116+ieWid*hs;
	}
	return maxW;
};
/**
 * @title:divWidth
 * @description:修正层户结构整体宽度
 * @author: zhang_guoliang@founder.com
 * @param 16为X轴滚动条的宽度
 * @date:2015-01-20 10:33:45
 */	
DzBuildingShow.divWidth = function(){ 
	var oldMaxW = $("#tt").width();
	if((DzBuildingShow.divdsMaxWidth+16)>oldMaxW||(DzBuildingShow.divdxMaxWidth+16)>oldMaxW){
		if(DzBuildingShow.divdsMaxWidth>DzBuildingShow.divdxMaxWidth){
			document.getElementById("chjgAddDsDiv").style.width = DzBuildingShow.divdsMaxWidth+16+"px";
			document.getElementById("chjgAddDxDiv").style.width = DzBuildingShow.divdsMaxWidth+16+"px";
		}else if(DzBuildingShow.divdsMaxWidth<DzBuildingShow.divdxMaxWidth){
			document.getElementById("chjgAddDsDiv").style.width = DzBuildingShow.divdxMaxWidth+16+"px";
			document.getElementById("chjgAddDxDiv").style.width = DzBuildingShow.divdxMaxWidth+16+"px";
		}else if(DzBuildingShow.divdsMaxWidth==DzBuildingShow.divdxMaxWidth){
			document.getElementById("chjgAddDsDiv").style.width = DzBuildingShow.divdsMaxWidth+16+"px";
			document.getElementById("chjgAddDxDiv").style.width = DzBuildingShow.divdxMaxWidth+16+"px";
		}
   	}else{
   		document.getElementById("chjgAddDsDiv").style.width = "100%";
		document.getElementById("chjgAddDxDiv").style.width = "100%";
   	}
};
/**
 * @title:showCalendarHouseDiv
 * @description:房间展示信息
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date:2015-05-08 16:14:44
 */	
DzBuildingShow.showCalendarHouseDiv = function(roomName,chdzid){
	$("#winZsxx").show();
	$("#winZsxx").window({
		title:"房间【"+roomName+"】信息展示",
		width:672,
		height:600,
		modal:true,
		collapsible:false,
		minimizable:false,
		maximizable:false,
		iconCls:"icon-home"
	});
	$("#fjZsxxFrame").attr("src",contextPath+"/dz/dzBuildingRoom?mldzid="+mldzid+"&chdzid="+chdzid);
};