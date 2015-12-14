if(typeof DzBuilding == "undefined" || !DzBuilding){
	var DzBuilding = {};
};
DzBuilding = function(){
	this.pk = Math.random();
};
DzBuilding.jsonHsdz = "";//层户地址户室地址
DzBuilding.dsdyHtml = "";//地上单元HTML
DzBuilding.dxdyHtml = "";//地下单元HTML
DzBuilding.divdsMaxWidth = 0;//地上最大宽度
DzBuilding.divdxMaxWidth = 0;//地下最大宽度
DzBuilding.dsddzddys = 0;//地上单独一单元最大单元数【异形楼】
DzBuilding.dsddzdcs = 0;//地上单独一单元最大层数【异形楼】
DzBuilding.dsddzdhs = 0;//地上单独一单元最大户数【异形楼】
DzBuilding.dxddzddys = 0;//地下单独一单元最大单元数【异形楼】
DzBuilding.dxddzdcs = 0;//地下单独一单元最大层数【异形楼】
DzBuilding.dxddzdhs = 0;//地下单独一单元最大户数【异形楼】
/**
 * @title:Jquery
 * @description:初始化层户结构
 * @author: zhang_guoliang@founder.com
 * @param       
 * @date:2015-03-02 13:34:54
 */
$(function(){
	//加载层户结构
	DzBuilding.onloadChjg();
	//新增【注销重建】权限判断
    if(chType !="0"){
 	   document.getElementById("zxcjId").style.display = "none";
    }
});
/**
 * @title:onloadChjg
 * @description:加载门楼地址信息（房间）
 * @author: zhang_guoliang@founder.com
 * @param mldzid【门楼地址ID】、dzChb【地址层户表 0为层户地址对象表、1为层户地址审核表】
 * @date:2015-03-02 17:01:21
 */
DzBuilding.onloadChjg = function(){
	var url = contextPath+"/dz/queryChdzdxb/"+mldzid;
	if(dzChb==1){
		url = contextPath+"/dz/queryChShdz/"+mldzid;
	}
	//层户地址
	$.ajax({
		type:"GET",
		sync:true,
		url:url,
		dataType:'json',
		success:function(json){
			DzBuilding.onloadChshdz_back(json);
		}
	});
};
/**
 * @title:onloadChshdz_back
 * @description:加载层户结构
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-03-02 17:11:24
 */   
DzBuilding.onloadChshdz_back = function(json){
	if(json){
		DzBuilding.jsonHsdz = json;
		var url = contextPath+"/dz/queryJzwChjg/"+mldzid;
		if(dzChb==1){
			url = contextPath+"/dz/queryJzwChjgSh/"+mldzid;
		}
		$.ajax({
			type:"GET",
			sync:true,
			url:url,
			dataType:'json',
			success:function(json){
				DzBuilding.onloadChjg_back(json);
			}
		});
	}
};
/**
 * @title:onloadChjg_back
 * @description:加载层户结构_回调函数
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-02-07 17:30:48
 */
DzBuilding.onloadChjg_back = function(json){
	DzBuilding.divdsMaxWidth = 0;//地上最大宽度
	DzBuilding.divdxMaxWidth = 0;//地下最大宽度
	var chjglen = json.length;
	if(chjglen>0){
		DzBuilding.dsdyHtml = "";
		DzBuilding.dxdyHtml = "";
		for(var t=0;t<chjglen;t++){
			var zddys = json[t].dyh;
			var zdcs = json[t].zdlcs;
			var zdhs = json[t].zdhs;
			var dyhlx = json[t].dyhlx;
			if(dyhlx=="1"){
				DzBuilding.dsdyHtml += DzBuilding.addDsDys(zddys,zdcs,zdhs);
			}else if(dyhlx=="0"){
				DzBuilding.dxdyHtml += DzBuilding.addDxDys(zddys,zdcs,zdhs);
			}
		}
		//加载地上单元信息
		DzBuilding.onloadDsDys();
		//加载地下单元信息
		DzBuilding.onloadDxDys();
		//设置整体宽度
		DzBuilding.divWidth();
	}
};
/**
 * @title:onloadDsDys
 * @description:加载地上单元数容器
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-02-08 15:04:43
 */
DzBuilding.onloadDsDys = function(){
	//层户结构容器
	var chjgHtml = "<table cellpadding='0' cellspacing='0' class='juzhong'>";
	//定义单元Html
	var dyHtml = "<div class='t_list'><dl>"+DzBuilding.dsdyHtml+"</dl></div>";
	chjgHtml += "<tr><td>"+dyHtml+"</td></tr></table>";
	$("#chjgAddDsDiv").html(chjgHtml);
};
/**
 * @title:addDsDys
 * @description:创建地上单元数
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-01-20 10:26:32
 */
DzBuilding.addDsDys = function(dys,cs,hs){
	var topHtml = DzBuilding.setTopHtml(dys,cs,hs);
	var LcHtml = DzBuilding.setLcHtml(dys,cs,hs);
	var Maxwidth = DzBuilding.dyWidth(hs);
	DzBuilding.divdsMaxWidth += Maxwidth;
	var dyHtml = "<dt id='dsdydt_"+dys+"' style='width:"+Maxwidth+"px;'><table cellpadding='0' cellspacing='0' width='100%'>"+topHtml+""+LcHtml+"</table></dt>";
	return dyHtml;
};
/**
 * @title:setTopHtml
 * @description:加载屋顶和单元数
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-01-20 10:26:54
 */
DzBuilding.setTopHtml = function(dys,cs,hs){
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
	if(chType=="0"){
		dyTopHtml += "<div class='floot_num' id='dsdyh_"+dys+"-"+cs+"'><input type='hidden' name='dsdymcName' value='"+dys+"'/><a href='javascript:void(0);' id='dsdy_"+dys+"-"+cs+"-"+hs+"' name='dsdyName' onClick='DzBuilding.showDysCalendar("+dys+","+cs+","+hs+",\"ds\");' value='"+dys+"-"+cs+"-"+hs+"'>"+dys+"</a></div>";
	}else{
		dyTopHtml += "<div class='floot_numOnly' id='dsdyh_"+dys+"-"+cs+"'><input type='hidden' name='dsdymcName' value='"+dys+"'/><a href='javascript:void(0);' id='dsdy_"+dys+"-"+cs+"-"+hs+"' name='dsdyName' value='"+dys+"-"+cs+"-"+hs+"'>"+dys+"</a></div>";
	}		
	dyTopHtml += "</td></tr>";
	//end:屋顶
	return dyTopHtml;
};
/**
 * @title:setLcHtml
 * @description:加载楼层
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-01-20 10:28:11
 */
DzBuilding.setLcHtml = function(i,cs,hs){
	var htmlStr = "";
	for(var l=cs;l>0;l--){
		var hsHtml = DzBuilding.getHsHtml(l,hs,i,"ds");
		htmlStr += "<tr><td class='gd_line'>" +
				"<div class='ceng_W'>" +
				"<ul id='dslchs_"+i+"-"+l+"'>" +
				"<li class='qiang'></li>";
		if(chType=="0"){
			htmlStr += "<li class='cengNum'><input type='hidden' name='dszdlchs_"+i+"' value='"+hs+"'/><a href='javascript:void(0);' id='dslc_"+i+"-"+l+"' name='dslcName' onClick='DzBuilding.showLcHsCalendar("+i+","+l+","+hs+","+cs+",\"ds\");' value='"+i+"-"+l+"'>"+l+"层</a></li>"+hsHtml+"<li class='qiang1'></li>";
		}else{
			htmlStr += "<li class='cengNumOnly'><input type='hidden' name='dszdlchs_"+i+"' value='"+hs+"'/><a href='javascript:void(0);' id='dslc_"+i+"-"+l+"' name='dslcName' value='"+i+"-"+l+"'>"+l+"层</a></li>"+hsHtml+"<li class='qiang1'></li>";
		}
		htmlStr += "</ul></div></td></tr>";
	}
	return htmlStr;
};
/**
 * @title:getHsHtml
 * @description:加载单元房间
 * @author: zhang_guoliang@founder.com   
 * @param   
 * @date:2015-01-20 10:30:32
 */
DzBuilding.getHsHtml = function(cs,hs,dys,bz){
	var htmlStr = "";
	for(var t=0;t<DzBuilding.jsonHsdz.length;t++){
		var dyh = DzBuilding.jsonHsdz[t].dyh;
		var lch = DzBuilding.jsonHsdz[t].lch;
		var dyhlx = DzBuilding.jsonHsdz[t].dyhlx;
		var dzmc = DzBuilding.jsonHsdz[t].dzmc;
		var chdzid = DzBuilding.jsonHsdz[t].chdzid;
		var shbs = DzBuilding.jsonHsdz[t].shbs;
		if(dyhlx=="1"&&bz=="ds"&&lch==cs&&dys==dyh){
			var roomName = DzBuilding.jsonHsdz[t].shmc;
			if(chType=="0"){
				if(shbs!=null&&shbs!=""){
					htmlStr += "<li style='background: #"+shbs+";'>";
				}else{
					htmlStr += "<li>";
				}
				htmlStr +=  "<div class='cengButton' id='dsfjh_"+dys+"-"+roomName+"'><a href='javascript:void(0);' id='dsfj_"+roomName+"' name='dsfjName' title='"+dzmc+"' onClick='DzBuilding.showFjCalendar("+dys+","+cs+","+DzBuilding.jsonHsdz[t].sh+",\"ds\",\""+shbs+"\");' value='"+dys+"-"+roomName+"'>"+roomName+"</a></div>" +
							"<div><input id='DsHb_"+dys+"-"+roomName+"' type='checkbox' name='checkName' style='display:none;' value='"+chdzid+"'></div>" +
						    "<div align='center'><input type='button' id='DsQd_"+dys+"-"+roomName+"' class='lou_xiugai' style='cursor:hand;display:none;' value='确定' onclick='DzBuilding.HouseHbDiv();'></div>" +
							"</li>";
			}else{
				if(shbs!=null&&shbs!=""){
					htmlStr += "<li style='background: #"+shbs+";'>";
				}else{
					htmlStr += "<li>";
				}
				htmlStr += "<div class='cengButtonOnly' id='dsfjh_"+dys+"-"+roomName+"'><a href='javascript:void(0);' id='dsfj_"+roomName+"' name='dsfjName' title='"+dzmc+"' value='"+dys+"-"+roomName+"'>"+roomName+"</a></div></li>";
			}
		}else if(dyhlx=="0"&&bz=="dx"&&lch==cs&&dys==dyh){
			var roomName = DzBuilding.jsonHsdz[t].shmc;
			if(chType=="0"){
				if(shbs!=null&&shbs!=""){
					htmlStr += "<li style='background: #"+shbs+";'>";
				}else{
					htmlStr += "<li>";
				}
				htmlStr += "<div class='cengButton' id='dxfjh_"+dys+"-"+roomName+"'><a href='javascript:void(0);' id='dxfj_"+roomName+"' name='dxfjName' title='"+dzmc+"' onClick='DzBuilding.showFjCalendar("+dys+","+cs+","+DzBuilding.jsonHsdz[t].sh+",\"dx\",\""+shbs+"\");' value='"+dys+"-"+cs+"-"+DzBuilding.jsonHsdz[t].sh+"'>"+roomName+"</a></div>" +
							"<div><input id='DxHb_"+dys+"-"+roomName+"' type='checkbox' name='checkName' style='display:none;' value='"+chdzid+"'></div>" +
						    "<div align='center'><input type='button' id='DxQd_"+dys+"-"+roomName+"' class='lou_xiugai' style='cursor:hand;display:none;' value='确定' onclick='DzBuilding.HouseHbDiv();'></div>" +		
							"</li>";
			}else{
				if(shbs!=null&&shbs!=""){
					htmlStr += "<li style='background: #"+shbs+";'>";
				}else{
					htmlStr += "<li>";
				}
				htmlStr += "<div class='cengButtonOnly' id='dxfjh_"+dys+"-"+roomName+"'><a href='javascript:void(0);' id='dxfj_"+roomName+"' name='dxfjName' title='"+dzmc+"' value='"+dys+"-"+cs+"-"+DzBuilding.jsonHsdz[t].sh+"'>"+roomName+"</a></div></li>";
			}
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
DzBuilding.getRoomBm = function(cs,hs,bz){
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
DzBuilding.onloadDxDys = function(){
	//层户结构容器
	var chjgHtml = "<table cellpadding='0' cellspacing='0' class='juzhong'>";
	//定义单元Html
	var dyHtml = "<div class='t_listDx'><dl>"+DzBuilding.dxdyHtml+"</dl></div>";
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
DzBuilding.addDxDys = function(dys,cs,hs){
    var downHtml = DzBuilding.setDownHtml(dys,cs,hs);
	var DxLcHtml = DzBuilding.setDxLcHtml(dys,cs,hs);
	var Maxwidth = DzBuilding.dyWidth(hs);
	DzBuilding.divdxMaxWidth += Maxwidth;
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
DzBuilding.setDownHtml = function(dxdys,cs,hs){
	//begin:地下单元
	var dyDownHtml = "";
	if(chType=="0"){
		dyDownHtml = "<tr><td><div class='floot_num' id='dxdyh_"+dxdys+"-"+cs+"'><input type='hidden' name='dxdymcName' value='"+dxdys+"'/><a href='javascript:void(0);' id='dxdy_"+dxdys+"-B"+cs+"-"+hs+"' name='dxdyName' onClick='DzBuilding.showDysCalendar("+dxdys+","+cs+","+hs+",\"dx\");' value='"+dxdys+"-"+cs+"-"+hs+"'>地下"+dxdys+"</a></div></td></tr>";
	}else{
		dyDownHtml = "<tr><td><div class='floot_numOnly' id='dxdyh_"+dxdys+"-"+cs+"'><input type='hidden' name='dxdymcName' value='"+dxdys+"'/><a href='javascript:void(0);' id='dxdy_"+dxdys+"-B"+cs+"-"+hs+"' name='dxdyName' value='"+dxdys+"-"+cs+"-"+hs+"'>地下"+dxdys+"</a></div></td></tr>";
	}
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
DzBuilding.setDxLcHtml = function(i,cs,hs){
	var htmlStr = "";
	for(var l=1;l<=cs;l++){
		var hsHtml = DzBuilding.getHsHtml(l,hs,i,"dx");
		htmlStr += "<tr><td class='gd_line'>" +
				"<div class='ceng_W'>" +
				"<ul id='dxlchs_"+i+"-"+l+"'>" +
				"<li class='qiang'></li>";
		if(chType=="0"){
			htmlStr += "<li class='cengNum'><input type='hidden' name='dxzdlchs_"+i+"' value='"+hs+"'/><a href='javascript:void(0);' id='dxlc_"+i+"-"+l+"' name='dxlcName' onClick='DzBuilding.showLcHsCalendar("+i+","+l+","+hs+","+cs+",\"dx\");' value='"+i+"-"+l+"'>B"+l+"层</a></li>"+hsHtml+"<li class='qiang1'></li>";
		}else{
			htmlStr += "<li class='cengNumOnly'><input type='hidden' name='dxzdlchs_"+i+"' value='"+hs+"'/><a href='javascript:void(0);' id='dxlc_"+i+"-"+l+"' name='dxlcName' value='"+i+"-"+l+"'>B"+l+"层</a></li>"+hsHtml+"<li class='qiang1'></li>";
		}
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
DzBuilding.dyWidth = function(hs){
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
 * @param   16为X轴滚动条的宽度
 * @date:2015-01-20 10:33:45
 */	
DzBuilding.divWidth = function(){ 
	var oldMaxW = $("#tt").width();
	if((DzBuilding.divdsMaxWidth+16)>oldMaxW||(DzBuilding.divdxMaxWidth+16)>oldMaxW){
		if(DzBuilding.divdsMaxWidth>DzBuilding.divdxMaxWidth){
			document.getElementById("chjgAddDsDiv").style.width = DzBuilding.divdsMaxWidth+16+"px";
			document.getElementById("chjgAddDxDiv").style.width = DzBuilding.divdsMaxWidth+16+"px";
		}else if(DzBuilding.divdsMaxWidth<DzBuilding.divdxMaxWidth){
			document.getElementById("chjgAddDsDiv").style.width = DzBuilding.divdxMaxWidth+16+"px";
			document.getElementById("chjgAddDxDiv").style.width = DzBuilding.divdxMaxWidth+16+"px";
		}else if(DzBuilding.divdsMaxWidth==DzBuilding.divdxMaxWidth){
			document.getElementById("chjgAddDsDiv").style.width = DzBuilding.divdsMaxWidth+16+"px";
			document.getElementById("chjgAddDxDiv").style.width = DzBuilding.divdxMaxWidth+16+"px";
		}
   	}else{
   		document.getElementById("chjgAddDsDiv").style.width = "100%";
		document.getElementById("chjgAddDxDiv").style.width = "100%";
   	}
};
/**
 * @title:hiddenCalendar
 * @description:隐藏显示的div
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-01-26 13:59:35
 */
DzBuilding.hiddenCalendar = function(){
	//隐藏修改单元DIV
	var showDiv = document.getElementById("showRightDiv");
	showDiv.style.visibility = "hidden";
	showDiv.style.display = "none";
	document.getElementById("xg_dsdymc").value = "";
    document.getElementById("xg_dslcs").value = "";
	document.getElementById("xg_dshs").value = "";
	//隐藏修改地上单层户数DIV
	var showDivHs = document.getElementById("showRightHsDiv");
	showDivHs.style.visibility = "hidden";
	showDivHs.style.display = "none";
	document.getElementById("xg_dslchs").value = "";
	//隐藏修改房间名称
	var showDivFJ = document.getElementById("showRightHouseDiv");
	showDivFJ.style.visibility = "hidden";
	showDivFJ.style.display = "none";
	document.getElementById("xg_fjmc").value = "";
	//隐藏修改地下单元DIV
	var showDxDiv = document.getElementById("showDxRightDiv");
	showDxDiv.style.visibility = "hidden";
	showDxDiv.style.display = "none";
	document.getElementById("xg_dxdymc").value = "";
    document.getElementById("xg_dxlcs").value = "";
	document.getElementById("xg_dxhs").value = "";
	//隐藏修改地下单层户数DIV
	var showDxDivHs = document.getElementById("showDxRightHsDiv");
	showDxDivHs.style.visibility = "hidden";
	showDxDivHs.style.display = "none";
	document.getElementById("xg_dxlchs").value = "";
	//隐藏地下修改房间名称
	var showDxDivFJ = document.getElementById("showDxRightHouseDiv");
	showDxDivFJ.style.visibility = "hidden";
	showDxDivFJ.style.display = "none";
	document.getElementById("xg_dxfjmc").value = "";
};
/**
 * @title:showDysCalendar
 * @description:显示修改单元名称
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-01-26 13:59:35
 */
DzBuilding.showDysCalendar = function(dys,cs,hs,bz){
	//隐藏修改单元DIV
	DzBuilding.hiddenCalendar();
	//显示修改单元DIV
	var trigger = window.event.srcElement;
	var l = trigger.offsetLeft;
	var t = trigger.offsetTop;
	var vParent = trigger.offsetParent;
	while (vParent.tagName.toUpperCase() != "BODY"){
		l += vParent.offsetLeft;
		t += vParent.offsetTop;
		vParent = vParent.offsetParent;
	}
	if(bz=="ds"){
		DzBuilding.dsddzddys = dys;
		DzBuilding.dsddzdcs = cs;
		DzBuilding.dsddzdhs = hs;
		var GatetowerHoust = document.getElementById("chjgAddDsDiv");
		var showDiv = document.getElementById("showRightDiv");
	}else if(bz=="dx"){
		DzBuilding.dxddzddys = dys;
		DzBuilding.dxddzdcs = cs;
		DzBuilding.dxddzdhs = hs;
		var GatetowerHoust = document.getElementById("chjgAddDxDiv");
		var showDiv = document.getElementById("showDxRightDiv");
	}
	showDiv.style.display = "block";
	showDiv.style.visibility="visible";
	var nowLeft = l - GatetowerHoust.scrollLeft;
	var nowTop = t + 26 - GatetowerHoust.scrollTop;
    showDiv.style.left = nowLeft;
	showDiv.style.top = nowTop - 5;
};
/**
 * @title:showDysCalendar
 * @description:显示修改单层户数
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-01-28 14:10:45
 */
DzBuilding.showLcHsCalendar = function(dys,cs,hs,zdcs,bz){
	//隐藏修改单元DIV
	DzBuilding.hiddenCalendar();
	//显示修改单元DIV
	var trigger = window.event.srcElement;
	var l = trigger.offsetLeft;
	var t = trigger.offsetTop;
	var vParent = trigger.offsetParent;
	while (vParent.tagName.toUpperCase() != "BODY"){
		l += vParent.offsetLeft;
		t += vParent.offsetTop;
		vParent = vParent.offsetParent;
	}
	if(bz=="ds"){
		DzBuilding.dsddzddys = dys;
		DzBuilding.dsddzdcs = cs;
		DzBuilding.dsddzdhs = hs;
		DzBuilding.dszdcs = zdcs;
		var GatetowerHoust = document.getElementById("chjgAddDsDiv");
		var showDiv = document.getElementById("showRightHsDiv");
	}else if(bz=="dx"){
		DzBuilding.dxddzddys = dys;
		DzBuilding.dxddzdcs = cs;
		DzBuilding.dxddzdhs = hs;
		DzBuilding.dxzdcs = zdcs;
		var GatetowerHoust = document.getElementById("chjgAddDxDiv");
		var showDiv = document.getElementById("showDxRightHsDiv");
	}
	showDiv.style.display = "block";
	showDiv.style.visibility="visible";
	var nowLeft = l - GatetowerHoust.scrollLeft;
	var nowTop = t + 26 - GatetowerHoust.scrollTop;
	showDiv.style.left = nowLeft;
	showDiv.style.top = nowTop - 25;
};
/**
 * @title:showFjCalendar
 * @description:显示修改房间名称
 * @author: zhang_guoliang@founder.com
 * @param DYS【单元数】、CS【层数】、HS【户数】、BZ【标识】、SHBS【是否有显示取消房间关联】  
 * @date:2015-01-28 14:22:32
 */
DzBuilding.showFjCalendar = function(dys,cs,hs,bz,shbs){
	//隐藏修改单元DIV
	DzBuilding.hiddenCalendar();
	//显示修改单元DIV
	var trigger = window.event.srcElement;
	var l = trigger.offsetLeft;
	var t = trigger.offsetTop;
	var vParent = trigger.offsetParent;
	while (vParent.tagName.toUpperCase() != "BODY"){
		l += vParent.offsetLeft;
		t += vParent.offsetTop;
		vParent = vParent.offsetParent;
	}
	if(bz=="ds"){
		DzBuilding.dsddzddys = dys;
		DzBuilding.dsddzdcs = cs;
		DzBuilding.dsddzdhs = hs;
		var GatetowerHoust = document.getElementById("chjgAddDsDiv");
		var showDiv = document.getElementById("showRightHouseDiv");
		if(shbs!=null&&shbs!=""){
			document.getElementById("dsqxfjbhId").style.display="block";
		}else{
			document.getElementById("dsqxfjbhId").style.display="none";
		}
	}else if(bz=="dx"){
		DzBuilding.dxddzddys = dys;
		DzBuilding.dxddzdcs = cs;
		DzBuilding.dxddzdhs = hs;
		var GatetowerHoust = document.getElementById("chjgAddDxDiv");
		var showDiv = document.getElementById("showDxRightHouseDiv");
		if(shbs!=null&&shbs!=""){
			document.getElementById("dxqxfjbhId").style.display="block";
		}else{
			document.getElementById("dxqxfjbhId").style.display="none";
		}
	}
	showDiv.style.display = "block";
	showDiv.style.visibility="visible";
	var nowLeft = l - GatetowerHoust.scrollLeft;
	var nowTop = t + 26 - GatetowerHoust.scrollTop;
    showDiv.style.left = nowLeft;
	showDiv.style.top = nowTop - 25;
};
/**
 * @title:sendUpdateDymc
 * @description:修改单元名称_地上
 * @author: zhang_guoliang@founder.com
 * @param MLDZID【门楼地址ID】、DYH【旧单元号】、NEWDYH【新单元号】、DYHLX【单元号类型】  
 * @date:2015-03-03 09:42:43
 */
DzBuilding.sendUpdateDymc = function(){
	if($('#xg_dsdymc').validatebox('isValid')){
		var dsdy = document.getElementsByName("dsdymcName");
		var dymc = document.getElementById("xg_dsdymc").value;
		if(dymc!=""&&dymc!=null){
			for(var i=0;i<dsdy.length;i++){
				var dsdymc = dsdy[i].value;
				if(dsdymc==dymc){
					topMessager.show({
						title: MESSAGER_TITLE,
						msg: '修改单元名称失败，名称【'+dymc+'】已存在。',
						timeout:2500
					});
					return;
				}
			}
			var params = {mldzid:mldzid,dyh:DzBuilding.dsddzddys,newdyh:dymc,dyhlx:1};
			var fajax =new FrameTools.Ajax(contextPath+"/dz/updateDymc",DzBuilding.sendUpdate_back);
			fajax.send(params);
		}else{
			topMessager.show({
				title: MESSAGER_TITLE,
				msg: '修改的单元名称不允许为空。',
				timeout:2500
			});
			return;
		}
	}
};
/**
 * @title:sendUpdate_back
 * @description:维护层户结构_回调函数
 * @author: zhang_guoliang@founder.com
 * @param result 返回提示信息  
 * @date:2015-03-03 09:49:11
 */
DzBuilding.sendUpdate_back = function(result){
	if(result){
		//关闭弹出框
		DzBuilding.hiddenCalendar();
		if(result.status == 'success'){
			//加载层户结构
			DzBuilding.onloadChjg();
		}
		topMessager.show({
			title: MESSAGER_TITLE,
			msg: result.message,
			timeout:3500
		});
	}
};
/**
 * @title:sendUpdateDxDymc
 * @description:修改单元名称_地下
 * @author: zhang_guoliang@founder.com
 * @param MLDZID【门楼地址ID】、DYH【旧单元号】、NEWDYH【新单元号】、DYHLX【单元号类型】  
 * @date:2015-03-03 16:11:32
 */
DzBuilding.sendUpdateDxDymc = function(){
	if($('#xg_dxdymc').validatebox('isValid')){
		var dxdy = document.getElementsByName("dxdymcName");
		var dymc = document.getElementById("xg_dxdymc").value;
		if(dymc!=""&&dymc!=null){
			for(var i=0;i<dxdy.length;i++){
				var dsdymc = dxdy[i].value;
				if(dsdymc==dymc){
					topMessager.show({
						title: MESSAGER_TITLE,
						msg: '修改单元名称失败，名称【'+dymc+'】已存在。',
						timeout:2500
					});
					return;
				}
			}
			var params = {mldzid:mldzid,dyh:DzBuilding.dxddzddys,newdyh:dymc,dyhlx:0};
			var fajax =new FrameTools.Ajax(contextPath+"/dz/updateDymc",DzBuilding.sendUpdate_back);
			fajax.send(params);
		}else{
			topMessager.show({
				title: MESSAGER_TITLE,
				msg: '修改的单元名称不允许为空。',
				timeout:2500
			});
			return;
		}
	}
};
/**
 * @title:sendUpdateCS
 * @description:修改地上层数
 * @author: zhang_guoliang@founder.com
 * @param MLDZID【门楼地址ID】、DYH【单元号】、LCH【旧楼层数】、NEWLCH【新楼层数】、DYHLX【单元号类型】  
 * @date:2015-03-03 16:33:42
 */
DzBuilding.sendUpdateCS = function(){
	if($('#xg_dslcs').validatebox('isValid')){
		var dslcs = document.getElementById("xg_dslcs").value;
		if(dslcs!=""&&dslcs!=null){
			if(dslcs==DzBuilding.dsddzdcs){
				topMessager.show({
					title: MESSAGER_TITLE,
					msg: '修改地上层数无任何修改。',
					timeout:2500
				});
			}else{
				var params = {mldzid:mldzid,dyh:DzBuilding.dsddzddys,zdlcs:DzBuilding.dsddzdcs,newlcs:dslcs,zdhs:DzBuilding.dsddzdhs,dyhlx:1};
				var fajax =new FrameTools.Ajax(contextPath+"/dz/updateDycs",DzBuilding.sendUpdate_back);
				fajax.send(params);
			}
		}else{
			topMessager.show({
				title: MESSAGER_TITLE,
				msg: '修改地上层数不允许为空。',
				timeout:2500
			});
			return;
		}
	}
};
/**
 * @title:sendUpdateDxCS
 * @description:修改地下层数
 * @author: zhang_guoliang@founder.com
 * @param MLDZID【门楼地址ID】、DYH【单元号】、LCH【旧楼层数】、NEWLCH【新楼层数】、DYHLX【单元号类型】  
 * @date:2015-03-04 13:47:36
 */
DzBuilding.sendUpdateDxCS = function(){
	if($('#xg_dxlcs').validatebox('isValid')){
		var dxlcs = document.getElementById("xg_dxlcs").value;
		if(dxlcs!=""&&dxlcs!=null){
			if(dxlcs==DzBuilding.dxddzdcs){
				topMessager.show({
					title: MESSAGER_TITLE,
					msg: '修改地下层数无任何修改。',
					timeout:2500
				});
			}else{
				var params = {mldzid:mldzid,dyh:DzBuilding.dxddzddys,zdlcs:DzBuilding.dxddzdcs,newlcs:dxlcs,zdhs:DzBuilding.dxddzdhs,dyhlx:0};
				var fajax =new FrameTools.Ajax(contextPath+"/dz/updateDycs",DzBuilding.sendUpdate_back);
				fajax.send(params);
			}
		}else{
			topMessager.show({
				title: MESSAGER_TITLE,
				msg: '修改地下层数不允许为空。',
				timeout:2500
			});
			return;
		}
	}
};
/**
 * @title:sendUpdateHs
 * @description:修改地上户数
 * @author: zhang_guoliang@founder.com
 * @param MLDZID【门楼地址ID】、DYH【单元号】、ZDLCS【最大层数】、NEWHS【新户数】、DYHLX【单元号类型】
 * @date:2015-03-04 16:13:48
 */
DzBuilding.sendUpdateHs = function(){
	if($('#xg_dshs').validatebox('isValid')){
		var dshs = document.getElementById("xg_dshs").value;
		if(dshs!=""&&dshs!=null){
			if(dshs==DzBuilding.dsddzdhs){
				topMessager.show({
					title: MESSAGER_TITLE,
					msg: '修改地上户数无任何修改。',
					timeout:2500
				});
			}else{
				var params = {mldzid:mldzid,dyh:DzBuilding.dsddzddys,zdlcs:DzBuilding.dsddzdcs,newhs:dshs,dyhlx:1};
				var fajax =new FrameTools.Ajax(contextPath+"/dz/updateDyhs",DzBuilding.sendUpdate_back);
				fajax.send(params);
			}
		}else{
			topMessager.show({
				title: MESSAGER_TITLE,
				msg: '修改地上户数不允许为空。',
				timeout:2500
			});
			return;
		}
	}
};
/**
 * @title:sendUpdateDxHs
 * @description:修改地下户数
 * @author: zhang_guoliang@founder.com
 * @param MLDZID【门楼地址ID】、DYH【单元号】、ZDLCS【最大层数】、NEWHS【新户数】、DYHLX【单元号类型】
 * @date:2015-03-05 09:29:21
 */
DzBuilding.sendUpdateDxHs = function(){
	if($('#xg_dxhs').validatebox('isValid')){
		var dxhs = document.getElementById("xg_dxhs").value;
		if(dxhs!=""&&dxhs!=null){
			if(dxhs==DzBuilding.dxddzdhs){
				topMessager.show({
					title: MESSAGER_TITLE,
					msg: '修改地下户数无任何修改。',
					timeout:2500
				});
			}else{
				var params = {mldzid:mldzid,dyh:DzBuilding.dxddzddys,zdlcs:DzBuilding.dxddzdcs,newhs:dxhs,dyhlx:0};
				var fajax =new FrameTools.Ajax(contextPath+"/dz/updateDyhs",DzBuilding.sendUpdate_back);
				fajax.send(params);
			}
		}else{
			topMessager.show({
				title: MESSAGER_TITLE,
				msg: '修改地下户数不允许为空。',
				timeout:2500
			});
			return;
		}
	}
};
/**
 * @title:sendUpdateClHs
 * @description:修改楼层户数_地上
 * @author: zhang_guoliang@founder.com
 * @param MLDZID【门楼地址ID】、DYH【单元号】、LCH【楼层号】、ZDHS【最大户数】、NEWHS【新户数】、DYHLX【单元号类型】
 * @date:2015-03-05 09:53:45
 */
DzBuilding.sendUpdateClHs = function(){
	if($('#xg_dslchs').validatebox('isValid')){
		var lchs = document.getElementById("xg_dslchs").value;
		if(lchs!=""&&lchs!=null){
			var params = {mldzid:mldzid,dyh:DzBuilding.dsddzddys,lch:DzBuilding.dsddzdcs,newhs:lchs,zdhs:DzBuilding.dsddzdhs,dyhlx:1};
			var fajax =new FrameTools.Ajax(contextPath+"/dz/updateDyLchs",DzBuilding.sendUpdate_back);
			fajax.send(params);
		}else{
			topMessager.show({
				title: MESSAGER_TITLE,
				msg: '修改楼层户数不允许为空。',
				timeout:2500
			});
			return;
		}
	}
};
/**
 * @title:sendUpdateDxClHs
 * @description:修改楼层户数_地下
 * @author: zhang_guoliang@founder.com
 * @param MLDZID【门楼地址ID】、DYH【单元号】、LCH【楼层号】、ZDHS【最大户数】、NEWHS【新户数】、DYHLX【单元号类型】
 * @date:2015-03-05 10:00:00
 */
DzBuilding.sendUpdateDxClHs = function(){
	if($('#xg_dxlchs').validatebox('isValid')){
		var lchs = document.getElementById("xg_dxlchs").value;
		if(lchs!=""&&lchs!=null){
			var params = {mldzid:mldzid,dyh:DzBuilding.dxddzddys,lch:DzBuilding.dxddzdcs,newhs:lchs,zdhs:DzBuilding.dxddzdhs,dyhlx:0};
			var fajax =new FrameTools.Ajax(contextPath+"/dz/updateDyLchs",DzBuilding.sendUpdate_back);
			fajax.send(params);
		}else{
			topMessager.show({
				title: MESSAGER_TITLE,
				msg: '修改楼层户数不允许为空。',
				timeout:2500
			});
			return;
		}
	}
};
/**
 * @title:sendUpdateFjmc
 * @description:修改房间名称_地上
 * @author: zhang_guoliang@founder.com
 * @param MLDZID【门楼地址ID】、DYH【单元号】、LCH【楼层号】、SH【室号】、NEWSH【新室号】、DYHLX【单元号类型】  
 * @date:2015-03-05 14:26:53
 */
DzBuilding.sendUpdateFjmc = function(){
	if($('#xg_fjmc').validatebox('isValid')){
		var fjmc = document.getElementById("xg_fjmc").value;
		var dsfjvale = document.getElementsByName("dsfjName");
		if(fjmc!=""&&fjmc!=null){
			//验证通过后重新生成单元以及关闭弹出框
			var roomName = DzBuilding.getRoomBm(DzBuilding.dsddzdcs,fjmc,"ds");
			var fjval = DzBuilding.dsddzddys+"-"+roomName;
			for(var i=0;i<dsfjvale.length;i++){
				var dsfjval = dsfjvale[i].value;
				if(dsfjval==fjval){
					topMessager.show({
						title: MESSAGER_TITLE,
						msg: '修改房间名称失败，名称【'+dsfjval+'】已存<br><br>在。',
						timeout:2500
					});
					return;
				}
			}
			var params = {mldzid:mldzid,dyh:DzBuilding.dsddzddys,lch:DzBuilding.dsddzdcs,sh:DzBuilding.dsddzdhs,newsh:fjmc,dyhlx:1};
			var fajax =new FrameTools.Ajax(contextPath+"/dz/updateDyfjmc",DzBuilding.sendUpdate_back);
			fajax.send(params);
		}else{
			topMessager.show({
				title: MESSAGER_TITLE,
				msg: '修改房间名称不允许为空。',
				timeout:2500
			});
			return;
		}
	}
};
/**
 * @title:sendUpdateDxFjmc
 * @description:修改房间名称_地下
 * @author: zhang_guoliang@founder.com
 * @param MLDZID【门楼地址ID】、DYH【单元号】、LCH【楼层号】、SH【室号】、NEWSH【新室号】、DYHLX【单元号类型】  
 * @date:2015-03-05 15:42:32
 */
DzBuilding.sendUpdateDxFjmc = function(){
	if($('#xg_dxfjmc').validatebox('isValid')){
		var fjmc = document.getElementById("xg_dxfjmc").value;
		var dxfjvale = document.getElementsByName("dxfjName");
		if(fjmc!=""&&fjmc!=null){
			//验证通过后重新生成单元以及关闭弹出框
			var roomName = DzBuilding.getRoomBm(DzBuilding.dxddzdcs,fjmc,"dx");
			var fjval = DzBuilding.dxddzddys+"-"+DzBuilding.dxddzdcs+"-"+fjmc;
			for(var i=0;i<dxfjvale.length;i++){
				var dxfjval = dxfjvale[i].value;
				if(dxfjval==fjval){
					topMessager.show({
						title: MESSAGER_TITLE,
						msg: '修改房间名称失败，名称【'+DzBuilding.dxddzddys+'-B'+DzBuilding.dxddzdcs+'-'+fjmc+'】已存<br><br>在。',
						timeout:2500
					});
					return;
				}
			}
			var params = {mldzid:mldzid,dyh:DzBuilding.dxddzddys,lch:DzBuilding.dxddzdcs,sh:DzBuilding.dxddzdhs,newsh:fjmc,dyhlx:0};
			var fajax =new FrameTools.Ajax(contextPath+"/dz/updateDyfjmc",DzBuilding.sendUpdate_back);
			fajax.send(params);
		}else{
			topMessager.show({
				title: MESSAGER_TITLE,
				msg: '修改房间名称不允许为空。',
				timeout:2500
			});
			return;
		}
	}
};
/**
 * @title:chjgZxcj
 * @description:层户结构注销重建
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-04-07 09:56:58
 */
DzBuilding.chjgZxcj = function(){
	topMessager.confirm('操作确认', '您是否确定【注销重建】此层户结构？',  function(r) {
		if(r){
			//层户结构URL
			var src = contextPath+"/dz/dzBuildingAdd?mldzid="+mldzid+"&type="+type+"&dzChb="+dzChb+"&chType="+chType+"&mainTabID="+mainTabID;
			//Iframe页面加载，解决加载页面先出输入框在加载样式问题
			var chjgHtml = "<iframe id='chjgid' style='width: 100%;height: 100%;' frameborder='no' src='"+src+"'></iframe>";
			parent.$("#chDivId").html(chjgHtml);
		}
	});
};
/**
 * @title:changeRoomHb
 * @description:合并房间
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-04-09 19:08:24
 */
DzBuilding.changeRoomHb = function(bs){
	var bz = "";
	var roomHbId ="";
	if(bs==0){
		bz = "Dx";
		roomHbId = DzBuilding.dxddzddys+"-B"+DzBuilding.dxddzdcs+"-"+DzBuilding.dxddzdhs;
		document.getElementById("dxexitid").style.display="block";
		document.getElementById("dxhbfjid").style.display="none";
		document.getElementById("dsexitid").style.display="block";
		document.getElementById("dshbfjid").style.display="none";
	}else{
		bz = "Ds";
		roomHbId = DzBuilding.dsddzddys+"-"+DzBuilding.dsddzdcs+"-"+DzBuilding.dsddzdhs;
		document.getElementById("dsexitid").style.display="block";
		document.getElementById("dshbfjid").style.display="none";
		document.getElementById("dxexitid").style.display="block";
		document.getElementById("dxhbfjid").style.display="none";
	}
	document.getElementById(bz+"Hb_"+roomHbId).checked = true;
	document.getElementById(bz+"Hb_"+roomHbId).style.display = "block";
	document.getElementById(bz+"Qd_"+roomHbId).style.display = "block";
	//循环显示复选框
	for(var i=0;i<DzBuilding.jsonHsdz.length;i++){
		var dyh = DzBuilding.jsonHsdz[i].dyh;
		var lch = DzBuilding.jsonHsdz[i].lch;
		var dyhlx = DzBuilding.jsonHsdz[i].dyhlx;
		var sh = DzBuilding.jsonHsdz[i].sh;
		if(dyhlx=="1"){
			var roomId = dyh+"-"+lch+"-"+sh;
			if(document.getElementById("DsHb_"+roomId)!=null&&document.getElementById("DsHb_"+roomId)!="null"){
				document.getElementById("DsHb_"+roomId).style.display = "block";
			}
		}else{
			var roomId = dyh+"-B"+lch+"-"+sh;
			if(document.getElementById("DxHb_"+roomId)!=null&&document.getElementById("DxHb_"+roomId)!="null"){
				document.getElementById("DxHb_"+roomId).style.display = "block";
			}
		}
	}
	//隐藏修改单元DIV
	DzBuilding.hiddenCalendar();
};
/**
 * @title:changeRoomTcHb
 * @description:退出合并
 * @author:zhang_guoliang@founder.com
 * @param   
 * @date:2015-04-09 19:09:32
 */
DzBuilding.changeRoomTcHb = function(bs){
	//循环取消复选框
	for(var i=0;i<DzBuilding.jsonHsdz.length;i++){
		var dyh = DzBuilding.jsonHsdz[i].dyh;
		var lch = DzBuilding.jsonHsdz[i].lch;
		var dyhlx = DzBuilding.jsonHsdz[i].dyhlx;
		var sh = DzBuilding.jsonHsdz[i].sh;
		if(dyhlx=="1"){
			var roomId = dyh+"-"+lch+"-"+sh;
			if(document.getElementById("DsHb_"+roomId)!=null&&document.getElementById("DsHb_"+roomId)!="null"){
				document.getElementById("DsHb_"+roomId).checked = false;
				document.getElementById("DsHb_"+roomId).style.display = "none";
				document.getElementById("DsQd_"+roomId).style.display = "none";
			}
		}else{
			var roomId = dyh+"-B"+lch+"-"+sh;
			if(document.getElementById("DxHb_"+roomId)!=null&&document.getElementById("DxHb_"+roomId)!="null"){
				document.getElementById("DxHb_"+roomId).checked = false;
				document.getElementById("DxHb_"+roomId).style.display = "none";
				document.getElementById("DxQd_"+roomId).style.display = "none";
			}
		}
	}
	//隐藏修改单元DIV
	DzBuilding.hiddenCalendar();
	if(bs==1){
		document.getElementById("dsexitid").style.display="none";
		document.getElementById("dshbfjid").style.display="block";
		document.getElementById("dxexitid").style.display="none";
		document.getElementById("dxhbfjid").style.display="block";
	}else{
		document.getElementById("dxexitid").style.display="none";
		document.getElementById("dxhbfjid").style.display="block";
		document.getElementById("dsexitid").style.display="none";
		document.getElementById("dshbfjid").style.display="block";
	}
};
/**
 * @title:HouseHbDiv
 * @description:合并保存事件
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-04-10 10:44:35
 */
DzBuilding.HouseHbDiv = function(){
	var str = "";
	$("input[name='checkName']:checked").each(function(){
		str += $(this).val()+",";
	});
	str = str.substring(0, str.length-1);
	var len = str.split(",");
	if(len.length<2){
		topMessager.show({
			title: MESSAGER_TITLE,
			msg: '至少选择一个需要合并的房间！',
			timeout:2500
		});
		return;
	}
	var params = {chdzid:str};
	var fajax =new FrameTools.Ajax(contextPath+"/dz/updateHouseHb",DzBuilding.HouseHbDiv_back);
	fajax.send(params);
};
/**
 * @title:HouseHbDiv_back
 * @description:合并保存事件_回调函数
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-04-10 15:31:43
 */
DzBuilding.HouseHbDiv_back = function(result){
	if(result){
		if(result.status == 'success'){
			//隐藏修改单元DIV
			DzBuilding.hiddenCalendar();
			//加载层户结构
			DzBuilding.onloadChjg();
			document.getElementById("dsexitid").style.display="none";
			document.getElementById("dshbfjid").style.display="block";
			document.getElementById("dxexitid").style.display="none";
			document.getElementById("dxhbfjid").style.display="block";
		}
		topMessager.show({
			title: MESSAGER_TITLE,
			msg: result.message,
			timeout:3500
		});
	}
};
/**
 * @title:changeRoomQxHb
 * @description:取消此房间合并关系
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-04-10 15:31:43
 */
DzBuilding.changeRoomQxHb = function(bs){
	var bz = "";
	var roomHbId ="";
	if(bs==0){
		bz = "DxHb_";
		roomHbId = DzBuilding.dxddzddys+"-B"+DzBuilding.dxddzdcs+"-"+DzBuilding.dxddzdhs;
	}else{
		bz = "DsHb_";
		roomHbId = DzBuilding.dsddzddys+"-"+DzBuilding.dsddzdcs+"-"+DzBuilding.dsddzdhs;
	}
	var chdzid = document.getElementById(bz+""+roomHbId).value;
	var params = {chdzid:chdzid};
	var fajax =new FrameTools.Ajax(contextPath+"/dz/updateHouseQxHb",DzBuilding.HouseHbDiv_back);
	fajax.send(params);
};