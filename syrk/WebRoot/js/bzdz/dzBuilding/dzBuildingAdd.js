if(typeof DzBuildingAdd == "undefined" || !DzBuildingAdd){
	var DzBuildingAdd = {};
};
DzBuildingAdd = function(){
	this.pk = Math.random();
};
DzBuildingAdd.divdsMaxWidth = 0;//地上最大宽度
DzBuildingAdd.divdxMaxWidth = 0;//地下最大宽度
DzBuildingAdd.dszddys = 0;//地上最大单元数
DzBuildingAdd.dszdcs = 0;//地上最大层数
DzBuildingAdd.dszdhs = 0;//地上最大户数
DzBuildingAdd.dsddzddys = 0;//地上单独一单元最大单元数【异形楼】
DzBuildingAdd.dsddzdcs = 0;//地上单独一单元最大层数【异形楼】
DzBuildingAdd.dsddzdhs = 0;//地上单独一单元最大户数【异形楼】
DzBuildingAdd.dxzddys = 0;//地下最大单元数
DzBuildingAdd.dxzdcs = 0;//地下最大层数
DzBuildingAdd.dxzdhs = 0;//地下最大户数
DzBuildingAdd.dxddzddys = 0;//地下单独一单元最大单元数【异形楼】
DzBuildingAdd.dxddzdcs = 0;//地下单独一单元最大层数【异形楼】
DzBuildingAdd.dxddzdhs = 0;//地下单独一单元最大户数【异形楼】
DzBuildingAdd.dyMaxHs = 3000;//判断单元最大户数
DzBuildingAdd.dscheckBox = true;//判断地上是否选中
DzBuildingAdd.dxcheckBox = false;//判断地下是否选中
/**
 * @title:Jquery
 * @description:初始化地址管理
 * @author: zhang_guoliang@founder.com
 * @param      
 * @date:2015-01-06 10:23:32
 */
$(function(){
	//加载层户机构按钮事件
	DzBuildingAdd.onloadChButton();
	/*窗口变化时层户结构宽度自动适应*/
	$("#chjgId").resize(function(){DzBuildingAdd.hiddenCalendar();});
});
/**
 * @title:onloadChButton
 * @description:加载层户机构按钮事件
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-01-12 18:59:42
 */	
DzBuildingAdd.onloadChButton = function(){
	//默认一单元一层一户
	DzBuildingAdd.onloadDsCh();
	//增加地上单元数
	$("#adddsdys").click(function(){
		if(!DzBuildingAdd.addDCH("dszddys", "地上单元数", 20)) {
			return;
		}
		DzBuildingAdd.onloadDsCh();
	});
	//减少地上单元数
	$("#deldsdys").click(function(){
		if(!DzBuildingAdd.delDCH("dszddys", "地上单元数", 1)) {
			return;
		}
		DzBuildingAdd.onloadDsCh();
	});
	//增加地上楼层数
	$("#adddslcs").click(function(){
		if(!DzBuildingAdd.addDCH("dslcs", "地上楼层数", 150)) {
			return;
		}
		DzBuildingAdd.onloadDsCh();
	});
	//减少地上楼层数
	$("#deldslcs").click(function(){
		if(!DzBuildingAdd.delDCH("dslcs", "地上楼层数", 1)) {
			return;
		}
		DzBuildingAdd.onloadDsCh();
	});
	//增加地上户数
	$("#adddshs").click(function(){
		if(!DzBuildingAdd.addDCH("dshs", "地上户数", 999)) {
			return;
		}
		DzBuildingAdd.onloadDsCh();
	});
	//减少地上户数
	$("#deldshs").click(function(){
		if(!DzBuildingAdd.delDCH("dshs", "地上户数", 1)) {
			return;
		}
		DzBuildingAdd.onloadDsCh();
	});
	//增加地下单元数
	$("#adddxdys").click(function(){
		if(!DzBuildingAdd.addDCH("dxzddys", "地下单元数", 20)) {
			return;
		}
		DzBuildingAdd.onloadDxCh();
	});
	//减少地下单元数
	$("#deldxdys").click(function(){
		if(!DzBuildingAdd.delDCH("dxzddys", "地下单元数", 1)) {
			return;
		}
		DzBuildingAdd.onloadDxCh();
	});
	//增加地下楼层数
	$("#adddxlcs").click(function(){
		if(!DzBuildingAdd.addDCH("dxlcs", "地下楼层数", 20)) {
			return;
		}
		DzBuildingAdd.onloadDxCh();
	});
	//减少地下楼层数
	$("#deldxlcs").click(function(){
		if(!DzBuildingAdd.delDCH("dxlcs", "地下楼层数", 1)) {
			return;
		}
		DzBuildingAdd.onloadDxCh();
	});
	//增加地下户数
	$("#adddxhs").click(function(){
		if(!DzBuildingAdd.addDCH("dxhs", "地下户数", 99)) {
			return;
		}
		DzBuildingAdd.onloadDxCh();
	});
	//减少地下户数
	$("#deldxhs").click(function(){
		if(!DzBuildingAdd.delDCH("dxhs", "地下户数", 1)) {
			return;
		}
		DzBuildingAdd.onloadDxCh();
	});
	//加载地上复选框
	var dsBoxHtml = "<input type='checkbox' id='dsBoxId' checked='true' onclick='DzBuildingAdd.dsCheckBox()'/>";
	$("#dsBoxDiv").html(dsBoxHtml);
	//加载地下复选框
	var dxBoxHtml = "<input type='checkbox' id='dxBoxId' onclick='DzBuildingAdd.dxCheckBox()'/>";
	$("#dxBoxDiv").html(dxBoxHtml);
};
/**
 * @title:addDCH
 * @description:增加单元、楼层、户室
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-01-12 19:12:24
 */	
DzBuildingAdd.addDCH = function(id, title, limit) {
	if($("#"+id).validatebox('isValid')){
		var b = true;
		var val = document.getElementById(id).value;
		if(val == ""){
			val = 0;
		}
		var v = parseInt(val);
		v++;
		if(v>limit) {
			topMessager.show({
				title: MESSAGER_TITLE,
				msg: '已达到最大'+title+'，无法再增加！',
				timeout:2500
			});
			v = limit;
			b = false;
		}
		document.getElementById(id).value = v;
		return b;
	}else{
		return false;
	}
};
/**
 * @title:delDCH
 * @description:减少单元、楼层、户室
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-01-13 14:04:32
 */	
DzBuildingAdd.delDCH = function(id, title, limit) {
	if($("#"+id).validatebox('isValid')){
		var b = true;
		var val = document.getElementById(id).value;
		if(val == ""){
			val = 2;
		}
		var v = parseInt(val);
		v--;
		if(v<limit) {
			topMessager.show({
				title: MESSAGER_TITLE,
				msg: '已达到最小'+title+'，无法再减少！',
				timeout:2500
			});
			v = limit;
			b = false;
		}
		document.getElementById(id).value = v;
		return b;
	}else{
		return false;
	}
};
/**
 * @title:onloadDsCh
 * @description:获取地上单元、楼层、户数
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-01-14 14:01:12
 */	
DzBuildingAdd.onloadDsCh = function(){
	DzBuildingAdd.dszddys = document.getElementById("dszddys").value;
	DzBuildingAdd.dszdcs = document.getElementById("dslcs").value;
	DzBuildingAdd.dszdhs = document.getElementById("dshs").value;
	if($("#dataChForm").form('validate')){
		var MaxHs = DzBuildingAdd.dszddys*DzBuildingAdd.dszdcs*DzBuildingAdd.dszdhs+DzBuildingAdd.dxzddys*DzBuildingAdd.dxzdcs*DzBuildingAdd.dxzdhs;
		if(MaxHs<DzBuildingAdd.dyMaxHs){
			//隐藏修改单元DIV
			DzBuildingAdd.hiddenCalendar();
			DzBuildingAdd.addDsDys(DzBuildingAdd.dszddys,DzBuildingAdd.dszdcs,DzBuildingAdd.dszdhs);
		}else{
			topMessager.show({
				title: MESSAGER_TITLE,
				msg: '超出最大【'+DzBuildingAdd.dyMaxHs+'】户数，无法创建层户！',
				timeout:2500
			});
		}
	}
};
/**
 * @title:onloadDxCh
 * @description:获取地下单元、楼层、户数
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-01-14 14:42:02
 */	
DzBuildingAdd.onloadDxCh = function(){
	DzBuildingAdd.dxzddys = document.getElementById("dxzddys").value;
	DzBuildingAdd.dxzdcs = document.getElementById("dxlcs").value;
	DzBuildingAdd.dxzdhs = document.getElementById("dxhs").value;
	if($("#dataChForm").form('validate')){
		var MaxHs = DzBuildingAdd.dszddys*DzBuildingAdd.dszdcs*DzBuildingAdd.dszdhs+DzBuildingAdd.dxzddys*DzBuildingAdd.dxzdcs*DzBuildingAdd.dxzdhs;
		if(MaxHs<DzBuildingAdd.dyMaxHs){
			//隐藏修改单元DIV
			DzBuildingAdd.hiddenCalendar();
			DzBuildingAdd.addDxDys(DzBuildingAdd.dxzddys,DzBuildingAdd.dxzdcs,DzBuildingAdd.dxzdhs);
		}else{
			topMessager.show({
				title: MESSAGER_TITLE,
				msg: '超出最大【'+DzBuildingAdd.dyMaxHs+'】户数，无法创建层户！',
				timeout:2500
			});
		}
	}
};
/**
 * @title:addDsDys
 * @description:创建地上单元数
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-01-20 10:26:32
 */
DzBuildingAdd.addDsDys = function(dys,cs,hs){
	DzBuildingAdd.divdsMaxWidth = 0;
	//层户结构容器
	var chjgHtml = "<table cellpadding='0' cellspacing='0' class='juzhong'>";
	//定义单元Html
	var dyHtml = "<div class='t_list'><dl>";
	//循环地上单元
	for(var i=1;i<=dys;i++){
		var topHtml = DzBuildingAdd.setTopHtml(i,cs,hs);
		var LcHtml = DzBuildingAdd.setLcHtml(i,cs,hs);
		var Maxwidth = DzBuildingAdd.dyWidth(hs);
		DzBuildingAdd.divdsMaxWidth += Maxwidth;
		dyHtml += "<dt id='dsdydt_"+i+"' style='width:"+Maxwidth+"px;'><table cellpadding='0' cellspacing='0' width='100%'>"+topHtml+""+LcHtml+"</table></dt>";
	}
	dyHtml += "</dl></div>";
	chjgHtml += "<tr><td>"+dyHtml+"</td></tr></table>";
	$("#chjgAddDsDiv").html(chjgHtml);
	//修正层户结构整体宽度
	DzBuildingAdd.divWidth();
};
/**
 * @title:dyWidth
 * @description:计算单元的宽度
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-02-08 20:18:45
 */
DzBuildingAdd.dyWidth = function(hs){
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
DzBuildingAdd.divWidth = function(){ 
	var oldMaxW = $("#chjgId").width();
	if((DzBuildingAdd.divdsMaxWidth+16)>oldMaxW||(DzBuildingAdd.divdxMaxWidth+16)>oldMaxW){
		if(DzBuildingAdd.divdsMaxWidth>DzBuildingAdd.divdxMaxWidth){
			document.getElementById("chjgAddDsDiv").style.width = DzBuildingAdd.divdsMaxWidth+16+"px";
			document.getElementById("chjgAddDxDiv").style.width = DzBuildingAdd.divdsMaxWidth+16+"px";
		}else if(DzBuildingAdd.divdsMaxWidth<DzBuildingAdd.divdxMaxWidth){
			document.getElementById("chjgAddDsDiv").style.width = DzBuildingAdd.divdxMaxWidth+16+"px";
			document.getElementById("chjgAddDxDiv").style.width = DzBuildingAdd.divdxMaxWidth+16+"px";
		}else if(DzBuildingAdd.divdsMaxWidth==DzBuildingAdd.divdxMaxWidth){
			document.getElementById("chjgAddDsDiv").style.width = DzBuildingAdd.divdsMaxWidth+16+"px";
			document.getElementById("chjgAddDxDiv").style.width = DzBuildingAdd.divdxMaxWidth+16+"px";
		}
   	}else{
   		document.getElementById("chjgAddDsDiv").style.width = "100%";
		document.getElementById("chjgAddDxDiv").style.width = "100%";
   	}
};
/**
 * @title:setTopHtml
 * @description:加载屋顶和单元数
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-01-20 10:26:54
 */
DzBuildingAdd.setTopHtml = function(dys,cs,hs){
	//begin:屋顶
	var dyTopHtml = "<tr><td>" +
			"<table cellpadding='0' cellspacing='0' align='center' width='100%' class='b_top_table'>" +
			"<tr>" +
			"<td class='b_top_l'></td>" +
			"<td class='b_top_c'></td>" +
			"<td class='b_top_r'></td>" +
			"</tr>" +
			"</table>" +
			"</td></tr><tr><td>" +
			"<div class='floot_num' id='dsdyh_"+dys+"-"+cs+"'><input type='hidden' name='dsdymcName' value='"+dys+"'/><a href='javascript:void(0);' id='dsdy_"+dys+"-"+cs+"-"+hs+"' name='dsdyName' onClick='DzBuildingAdd.showDysCalendar("+dys+","+cs+","+hs+",\"ds\");' value='"+dys+"-"+cs+"-"+hs+"'>"+dys+"</a></div>" +
			"</td></tr>";
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
DzBuildingAdd.setLcHtml = function(i,cs,hs){
	var htmlStr = "";
	for(var l=cs;l>0;l--){
		var hsHtml = DzBuildingAdd.getHsHtml(l,hs,i,"ds");
		htmlStr += "<tr><td class='gd_line'>" +
				"<div class='ceng_W'>" +
				"<ul id='dslchs_"+i+"-"+l+"'>" +
				"<li class='qiang'></li>" +
				"<li class='cengNum'><input type='hidden' name='dszdlchs_"+i+"' value='"+hs+"'/><a href='javascript:void(0);' id='dslc_"+i+"-"+l+"' name='dslcName' onClick='DzBuildingAdd.showLcHsCalendar("+i+","+l+","+hs+","+cs+",\"ds\");' value='"+i+"-"+l+"'>"+l+"层</a></li>"+hsHtml+"<li class='qiang1'></li>" +
			    "</ul></div></td></tr>";
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
DzBuildingAdd.getHsHtml = function(cs,hs,dys,type){
	var htmlStr = "";
	for(var i=1;i<=hs;i++){
		var roomName = DzBuildingAdd.getRoomBm(cs,i,type);
		if(type=="ds"){
			htmlStr += "<li><div class='cengButton' id='dsfjh_"+dys+"-"+roomName+"'><a href='javascript:void(0);' id='dsfj_"+roomName+"' name='dsfjName' title='"+dys+"-"+roomName+"' onClick='DzBuildingAdd.showFjCalendar("+dys+","+cs+","+i+",\"ds\");' value='"+dys+"-"+roomName+"'>"+roomName+"</a></div></li>";
		}else if(type=="dx"){
			htmlStr += "<li><div class='cengButton' id='dxfjh_"+dys+"-"+roomName+"'><a href='javascript:void(0);' id='dxfj_"+roomName+"' name='dxfjName' title='"+dys+"-"+roomName+"' onClick='DzBuildingAdd.showFjCalendar("+dys+","+cs+","+i+",\"dx\");' value='"+dys+"-"+cs+"-"+i+"'>"+roomName+"</a></div></li>";
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
DzBuildingAdd.getRoomBm = function(cs,hs,type){
	var roomBm = "";
	if(type == "ds"){
		roomBm = cs+"-"+hs;
	}else if(type == "dx"){
		roomBm = "B"+cs+"-"+hs;
	}
	return roomBm;
};
/**
 * @title:addDxDys
 * @description:创建地下单元数
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-01-20 15:11:56
 */
DzBuildingAdd.addDxDys = function(dys,cs,hs){
	DzBuildingAdd.divdxMaxWidth = 0;
	//层户结构容器
	var chjgHtml = "<table cellpadding='0' cellspacing='0' class='juzhong'>";
	//定义单元Html
	var dyHtml = "<div class='t_listDx'><dl>";
	//循环地下单元
	for(var i=1;i<=dys;i++){
		var downHtml = DzBuildingAdd.setDownHtml(i,cs,hs);
		var DxLcHtml = DzBuildingAdd.setDxLcHtml(i,cs,hs);
		var Maxwidth = DzBuildingAdd.dyWidth(hs);
		DzBuildingAdd.divdxMaxWidth += Maxwidth;
		dyHtml += "<dt id='dxdydt_"+i+"' style='width:"+Maxwidth+"px;'><table cellpadding='0' cellspacing='0' width='100%'>"+downHtml+""+DxLcHtml+"</table></dt>";
	}
	dyHtml += "</dl></div>";
	chjgHtml += "<tr><td>"+dyHtml+"</td></tr></table>";
	$("#chjgAddDxDiv").html(chjgHtml);
	//修正层户结构整体宽度
	DzBuildingAdd.divWidth();
};
/**
 * @title:setDownHtml
 * @description:加载地下单元数
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-01-20 15:19:43
 */
DzBuildingAdd.setDownHtml = function(dxdys,cs,hs){
	//begin:地下单元
	var dyDownHtml = "<tr><td><div class='floot_num' id='dxdyh_"+dxdys+"-"+cs+"'><input type='hidden' name='dxdymcName' value='"+dxdys+"'/><a href='javascript:void(0);' id='dxdy_"+dxdys+"-B"+cs+"-"+hs+"' name='dxdyName' onClick='DzBuildingAdd.showDysCalendar("+dxdys+","+cs+","+hs+",\"dx\");' value='"+dxdys+"-"+cs+"-"+hs+"'>地下"+dxdys+"</a></div></td></tr>";
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
DzBuildingAdd.setDxLcHtml = function(i,cs,hs){
	var htmlStr = "";
	for(var l=1;l<=cs;l++){
		var hsHtml = DzBuildingAdd.getHsHtml(l,hs,i,"dx");
		htmlStr += "<tr><td class='gd_line'>" +
				"<div class='ceng_W'>" +
				"<ul id='dxlchs_"+i+"-"+l+"'>" +
				"<li class='qiang'></li>" +
				"<li class='cengNum'><input type='hidden' name='dxzdlchs_"+i+"' value='"+hs+"'/><a href='javascript:void(0);' id='dxlc_"+i+"-"+l+"' name='dxlcName' onClick='DzBuildingAdd.showLcHsCalendar("+i+","+l+","+hs+","+cs+",\"dx\");' value='"+i+"-"+l+"'>B"+l+"层</a></li>"+hsHtml+"<li class='qiang1'></li>" +
			    "</ul></div></td></tr>";
	}
	return htmlStr;
};
/**
 * @title:czButton
 * @description:重置层户
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-01-22 18:58:21
 */
DzBuildingAdd.czButton = function(){
	DzBuildingAdd.divdxMaxWidth = 0;
	//重置操作
	document.getElementById("dsBoxId").checked = true;
	document.getElementById("dxBoxId").checked = false;
	DzBuildingAdd.dxCheckBox();
	DzBuildingAdd.dsCheckBox();
	//保存按钮重置
	document.getElementById("qdid").className = "btn1";
	//复选框取消选中状态
	document.getElementById("dsBoxId").disabled = "";
	document.getElementById("dxBoxId").disabled = "";
	//取消保存按钮只读
	document.getElementById("qdid").disabled = "";
	//折叠左侧新建地址
	$('#panelid').layout('collapse','west');
	//修正层户结构整体宽度
	DzBuildingAdd.divWidth();
};
/**
 * @title:qdButton
 * @description:保存层户
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2015-01-23 11:23:43
 */
DzBuildingAdd.qdButton = function(){
	if($("#dataChForm").form('validate')){
		if(DzBuildingAdd.dscheckBox){
			if(DzBuildingAdd.dszdcs==0||DzBuildingAdd.dszdcs==""||DzBuildingAdd.dszdhs==0||DzBuildingAdd.dszdhs==""||DzBuildingAdd.dszddys==0||DzBuildingAdd.dszddys==""){
				topMessager.show({
					title: MESSAGER_TITLE,
					msg: '地上层户信息不完整，请完善信息。',
					timeout:2500
				});
				return;
			}
		}
		if(DzBuildingAdd.dxcheckBox){
			if(DzBuildingAdd.dxzdcs==0||DzBuildingAdd.dxzdcs==""||DzBuildingAdd.dxzdhs==0||DzBuildingAdd.dxzdhs==""||DzBuildingAdd.dxzddys==0||DzBuildingAdd.dxzddys==""){
				topMessager.show({
					title: MESSAGER_TITLE,
					msg: '地下层户信息不完整，请完善信息。',
					timeout:2500
				});
				return;
			}
		}
		if(DzBuildingAdd.dscheckBox==false&&DzBuildingAdd.dxcheckBox==false){
			topMessager.show({
				title: MESSAGER_TITLE,
				msg: '层户结构信息不完整，请完善信息。',
				timeout:2500
			});
			return;
		}
		//选中的复选框只读
		document.getElementById("dsBoxId").disabled = "disabled";
		DzBuildingAdd.dsDyGray();
		document.getElementById("dxBoxId").disabled = "disabled";
		DzBuildingAdd.dxDyGray();
		//保存按钮置灰
		document.getElementById("qdid").className = "btnGray";
    	//保存按钮只读
    	document.getElementById("qdid").disabled = "disabled";
    	if(buildingBz==1){
	    	//重置按钮置灰
			document.getElementById("czid").className = "btnGray";
	    	//重置按钮只读
	    	document.getElementById("czid").disabled = "disabled";
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
			//提交层户地址注销重建信息
			$("#dataChForm").form('submit',{
				dataType : 'json',
				onSubmit: function() {
				},
				success:function(result) {
					//解析JSON格式
					result = parseReturn(result);
					topMessager.show({
						title: MESSAGER_TITLE,
						msg: result.message,
						timeout:3500
					});
					 //返回成功后执行的方法
					if(result.status == 'success'){
						if(bzdzSh=="1"){
							closeSelf();
							executeTabPageMethod(mainTabID, "DzManage.queryButton()");
						}else{
							//层户结构URL
							var src = contextPath+"/dz/dzBuilding?mldzid="+mldzid+"&type="+type+"&dzChb="+dzChb+"&chType="+chType+"&mainTabID="+mainTabID;
							//Iframe页面加载，解决加载页面先出输入框在加载样式问题
							var chjgHtml = "<iframe id='chjgid' style='width: 100%;height: 100%;' frameborder='no' src='"+src+"'></iframe>";
							parent.$("#chDivId").html(chjgHtml);
						}
					}
				}
			});
    	}else{
    		if(DzAdd.layoutWest==false){
        		//展开折叠左侧新建地址
        		$('#panelid').layout('expand','west');
        	}
    	}
	}
};
/**
 * @title:dsCheckBox
 * @description:地上复选框事件
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-01-23 15:32:34
 */
DzBuildingAdd.dsCheckBox = function(){
	DzBuildingAdd.dscheckBox = document.getElementById("dsBoxId").checked;
	if(DzBuildingAdd.dscheckBox){
		DzBuildingAdd.qxDsDyGray();
		//加载地上默认层户
		document.getElementById("dszddys").value = "1";
	    document.getElementById("dslcs").value = "1";
		document.getElementById("dshs").value = "1";
		DzBuildingAdd.onloadDsCh();
	}else{
		DzBuildingAdd.dsDyGray();
		//删除地上层户
		document.getElementById("dszddys").value = "";
	    document.getElementById("dslcs").value = "";
		document.getElementById("dshs").value = "";
		$("#chjgAddDsDiv").html("");
		DzBuildingAdd.onloadDxCh();
	}
};
/**
 * @title:dxCheckBox
 * @description:地下复选框
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-01-23 15:34:12
 */
DzBuildingAdd.dxCheckBox = function(){
	DzBuildingAdd.dxcheckBox = document.getElementById("dxBoxId").checked;
	if(DzBuildingAdd.dxcheckBox){
		DzBuildingAdd.qxDxDyGray();
		//加载地下默认层户
		document.getElementById("dxzddys").value = "1";
	    document.getElementById("dxlcs").value = "1";
		document.getElementById("dxhs").value = "1";
		DzBuildingAdd.onloadDxCh();
	}else{
		DzBuildingAdd.dxDyGray();
		//删除 层户
		document.getElementById("dxzddys").value = "";
	    document.getElementById("dxlcs").value = "";
		document.getElementById("dxhs").value = "";
		$("#chjgAddDxDiv").html("");
		DzBuildingAdd.onloadDsCh();
	}
};
/**
 * @title:dsDyGray
 * @description:地上单元只读
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-01-24 17:08:32
 */
DzBuildingAdd.dsDyGray = function(){
	document.getElementById("ds_class").className = "ds_titleGray";
	//地上加减按钮class样式
	document.getElementById("deldsdys").className = "ds_btn";
	document.getElementById("adddsdys").className = "ds_btn";
	document.getElementById("deldslcs").className = "ds_btn";
	document.getElementById("adddslcs").className = "ds_btn";
	document.getElementById("deldshs").className = "ds_btn";
	document.getElementById("adddshs").className = "ds_btn";
	//地上单元置灰
	document.getElementById("deldsdys").disabled = "disabled";
	document.getElementById("dszddys").disabled = "disabled";
	document.getElementById("adddsdys").disabled = "disabled";
	document.getElementById("deldslcs").disabled = "disabled";
	document.getElementById("dslcs").disabled = "disabled";
	document.getElementById("adddslcs").disabled = "disabled";
	document.getElementById("deldshs").disabled = "disabled";
	document.getElementById("dshs").disabled = "disabled";
	document.getElementById("adddshs").disabled = "disabled";
};
/**
 * @title:qxDsDyGray
 * @description:取消地上单元只读
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-01-26 10:59:3
 */
DzBuildingAdd.qxDsDyGray = function(){
	document.getElementById("ds_class").className = "ds_title";
	//地上加减按钮class样式
	document.getElementById("deldsdys").className = "ds_btnCur";
	document.getElementById("adddsdys").className = "ds_btnCur";
	document.getElementById("deldslcs").className = "ds_btnCur";
	document.getElementById("adddslcs").className = "ds_btnCur";
	document.getElementById("deldshs").className = "ds_btnCur";
	document.getElementById("adddshs").className = "ds_btnCur";
	//地上单元取消置灰
	document.getElementById("deldsdys").disabled = "";
	document.getElementById("dszddys").disabled = "";
	document.getElementById("adddsdys").disabled = "";
	document.getElementById("deldslcs").disabled = "";
	document.getElementById("dslcs").disabled = "";
	document.getElementById("adddslcs").disabled = "";
	document.getElementById("deldshs").disabled = "";
	document.getElementById("dshs").disabled = "";
	document.getElementById("adddshs").disabled = "";
};
/**
 * @title:dxDyGray
 * @description:地下单元只读
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-01-24 17:19:21
 */
DzBuildingAdd.dxDyGray = function(){
	document.getElementById("dx_class").className = "dx_titleGray";
	//地下加减按钮class样式
	document.getElementById("deldxdys").className = "ds_btn";
	document.getElementById("adddxdys").className = "ds_btn";
	document.getElementById("deldxlcs").className = "ds_btn";
	document.getElementById("adddxlcs").className = "ds_btn";
	document.getElementById("deldxhs").className = "ds_btn";
	document.getElementById("adddxhs").className = "ds_btn";
	//地下单元置灰
	document.getElementById("deldxdys").disabled = "disabled";
	document.getElementById("dxzddys").disabled = "disabled";
	document.getElementById("adddxdys").disabled = "disabled";
	document.getElementById("deldxlcs").disabled = "disabled";
	document.getElementById("dxlcs").disabled = "disabled";
	document.getElementById("adddxlcs").disabled = "disabled";
	document.getElementById("deldxhs").disabled = "disabled";
	document.getElementById("dxhs").disabled = "disabled";
	document.getElementById("adddxhs").disabled = "disabled";
};
/**
 * @title:qxDxDyGray
 * @description:取消地下单元只读
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-01-26 10:58:32
 */
DzBuildingAdd.qxDxDyGray = function(){
	document.getElementById("dx_class").className = "dx_title";
	//地下加减按钮class样式
	document.getElementById("deldxdys").className = "ds_btnCur";
	document.getElementById("adddxdys").className = "ds_btnCur";
	document.getElementById("deldxlcs").className = "ds_btnCur";
	document.getElementById("adddxlcs").className = "ds_btnCur";
	document.getElementById("deldxhs").className = "ds_btnCur";
	document.getElementById("adddxhs").className = "ds_btnCur";
	//地下单元取消置灰
	document.getElementById("deldxdys").disabled = "";
	document.getElementById("dxzddys").disabled = "";
	document.getElementById("adddxdys").disabled = "";
	document.getElementById("deldxlcs").disabled = "";
	document.getElementById("dxlcs").disabled = "";
	document.getElementById("adddxlcs").disabled = "";
	document.getElementById("deldxhs").disabled = "";
	document.getElementById("dxhs").disabled = "";
	document.getElementById("adddxhs").disabled = "";
};
/**
 * @title:showDysCalendar
 * @description:显示单元修改异形楼
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-01-26 13:59:35
 */
DzBuildingAdd.showDysCalendar = function(dys,cs,hs,type){
	//隐藏修改单元DIV
	DzBuildingAdd.hiddenCalendar();
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
	if(type=="ds"){
		DzBuildingAdd.dsddzddys = dys;
		DzBuildingAdd.dsddzdcs = cs;
		DzBuildingAdd.dsddzdhs = hs;
		var GatetowerHoust = document.getElementById("chjgAddDsDiv");
		var showDiv = document.getElementById("showRightDiv");
	}else if(type=="dx"){
		DzBuildingAdd.dxddzddys = dys;
		DzBuildingAdd.dxddzdcs = cs;
		DzBuildingAdd.dxddzdhs = hs;
		var GatetowerHoust = document.getElementById("chjgAddDxDiv");
		var showDiv = document.getElementById("showDxRightDiv");
	}
	showDiv.style.display = "block";
	showDiv.style.visibility="visible";
	var nowLeft = l - GatetowerHoust.scrollLeft;
	var nowTop = t + 26 - GatetowerHoust.scrollTop;
	if(buildingBz=="1"){
		showDiv.style.left = nowLeft - 255;
		showDiv.style.top = nowTop - 25;
	}else{
		if(DzAdd.layoutWest){
			showDiv.style.left = nowLeft - 634;
		}else{
			showDiv.style.left = nowLeft - 282;
		}
		showDiv.style.top = nowTop - 55;
	}
};
/**
 * @title:showDysCalendar
 * @description:显示修改单层户数
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-01-28 14:10:45
 */
DzBuildingAdd.showLcHsCalendar = function(dys,cs,hs,zdcs,type){
	//隐藏修改单元DIV
	DzBuildingAdd.hiddenCalendar();
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
	if(type=="ds"){
		DzBuildingAdd.dsddzddys = dys;
		DzBuildingAdd.dsddzdcs = cs;
		DzBuildingAdd.dsddzdhs = hs;
		DzBuildingAdd.dszdcs = zdcs;
		var GatetowerHoust = document.getElementById("chjgAddDsDiv");
		var showDiv = document.getElementById("showRightHsDiv");
	}else if(type=="dx"){
		DzBuildingAdd.dxddzddys = dys;
		DzBuildingAdd.dxddzdcs = cs;
		DzBuildingAdd.dxddzdhs = hs;
		DzBuildingAdd.dxzdcs = zdcs;
		var GatetowerHoust = document.getElementById("chjgAddDxDiv");
		var showDiv = document.getElementById("showDxRightHsDiv");
	}
	showDiv.style.display = "block";
	showDiv.style.visibility="visible";
	var nowLeft = l - GatetowerHoust.scrollLeft;
	var nowTop = t + 26 - GatetowerHoust.scrollTop;
	if(buildingBz=="1"){
		showDiv.style.left = nowLeft - 255;
		showDiv.style.top = nowTop - 25;
	}else{
		if(DzAdd.layoutWest){
			showDiv.style.left = nowLeft - 634;
		}else{
			showDiv.style.left = nowLeft - 282;
		}
		showDiv.style.top = nowTop - 55;
	}
};
/**
 * @title:showFjCalendar
 * @description:显示修改房间名称
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-01-28 14:22:32
 */
DzBuildingAdd.showFjCalendar = function(dys,cs,hs,type){
	//隐藏修改单元DIV
	DzBuildingAdd.hiddenCalendar();
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
	if(type=="ds"){
		DzBuildingAdd.dsddzddys = dys;
		DzBuildingAdd.dsddzdcs = cs;
		DzBuildingAdd.dsddzdhs = hs;
		var GatetowerHoust = document.getElementById("chjgAddDsDiv");
		var showDiv = document.getElementById("showRightHouseDiv");
	}else if(type=="dx"){
		DzBuildingAdd.dxddzddys = dys;
		DzBuildingAdd.dxddzdcs = cs;
		DzBuildingAdd.dxddzdhs = hs;
		var GatetowerHoust = document.getElementById("chjgAddDxDiv");
		var showDiv = document.getElementById("showDxRightHouseDiv");
	}
	showDiv.style.display = "block";
	showDiv.style.visibility="visible";
	var nowLeft = l - GatetowerHoust.scrollLeft;
	var nowTop = t + 26 - GatetowerHoust.scrollTop;
	if(buildingBz=="1"){
		showDiv.style.left = nowLeft - 255;
		showDiv.style.top = nowTop - 25;
	}else{
		if(DzAdd.layoutWest){
			showDiv.style.left = nowLeft - 634;
		}else{
			showDiv.style.left = nowLeft - 282;
		}
		showDiv.style.top = nowTop - 55;
	}
};
/**
 * @title:hiddenCalendar
 * @description:隐藏显示的div
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-01-26 13:59:35
 */
DzBuildingAdd.hiddenCalendar = function(){
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
 * @title:SendUpdateDymc
 * @description:修改单元名称
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-01-26 19:12:32
 */
DzBuildingAdd.SendUpdateDymc = function(){
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
			//验证通过后重新生成单元以及关闭弹出框
			var dyNewHtml = DzBuildingAdd.updateDsDys(dymc,DzBuildingAdd.dsddzdcs,DzBuildingAdd.dsddzdhs);
			document.getElementById("dsdydt_"+DzBuildingAdd.dsddzddys).outerHTML = dyNewHtml;
			DzBuildingAdd.hiddenCalendar();
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
 * @title:updateDsDys
 * @description:单独修改某一单元
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-01-27 15:25:54
 */
DzBuildingAdd.updateDsDys = function(dys,cs,hs){
	var topHtml = DzBuildingAdd.setTopHtml(dys,cs,hs);
	var LcHtml = DzBuildingAdd.setLcHtml(dys,cs,hs);
	var Maxwidth = DzBuildingAdd.dyWidth(hs);
	var dyHtml = "<dt id='dsdydt_"+dys+"' style='width:"+Maxwidth+"px;'><table cellpadding='0' cellspacing='0' width='100%'>"+topHtml+""+LcHtml+"</table></dt>";
    return dyHtml;
};
/**
 * @title:SendUpdateCS
 * @description:修改地上层数
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-01-27 15:47:34
 */
DzBuildingAdd.SendUpdateCS = function(){
	if($('#xg_dslcs').validatebox('isValid')){
		var dslcs = document.getElementById("xg_dslcs").value;
		if(dslcs!=""&&dslcs!=null){
			//验证通过后重新生成单元以及关闭弹出框
			var dyNewHtml = DzBuildingAdd.updateDsDys(DzBuildingAdd.dsddzddys,dslcs,DzBuildingAdd.dsddzdhs);
			document.getElementById("dsdydt_"+DzBuildingAdd.dsddzddys).outerHTML = dyNewHtml;
			DzBuildingAdd.hiddenCalendar();
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
 * @title:SendUpdateHs
 * @description:修改地上户数
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-01-28 10:09:36
 */
DzBuildingAdd.SendUpdateHs = function(){
	if($('#xg_dshs').validatebox('isValid')){
		var dshs = document.getElementById("xg_dshs").value;
		if(dshs!=""&&dshs!=null){
			var oldwid = DzBuildingAdd.dyWidth(DzBuildingAdd.dsddzdhs);
			var newwid = DzBuildingAdd.dyWidth(dshs);
			DzBuildingAdd.divdsMaxWidth = DzBuildingAdd.divdsMaxWidth - oldwid + newwid;
			DzBuildingAdd.divWidth();
			//验证通过后重新生成单元以及关闭弹出框
			var dyNewHtml = DzBuildingAdd.updateDsDys(DzBuildingAdd.dsddzddys,DzBuildingAdd.dsddzdcs,dshs);
			document.getElementById("dsdydt_"+DzBuildingAdd.dsddzddys).outerHTML = dyNewHtml;
			$("#chjgAddDsDiv").html($("#chjgAddDsDiv").html());
			DzBuildingAdd.hiddenCalendar();
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
 * @title:SendUpdateClHs
 * @description:修改楼层户数
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-01-31 16:51:32
 */
DzBuildingAdd.SendUpdateClHs = function(){
	if($('#xg_dslchs').validatebox('isValid')){
		var lchs = document.getElementById("xg_dslchs").value;
		if(lchs!=""&&lchs!=null){
			//计算每层最大户数
			var oldlcHs = document.getElementsByName("dszdlchs_"+DzBuildingAdd.dsddzddys);
			var oldmaxHs = 0;
			for(var i=0;i<oldlcHs.length;i++){
				var oldnum = oldlcHs[i].value;
				if(oldmaxHs<oldnum){
					oldmaxHs = oldnum;
				}
			}
			//验证通过后重新生成单元以及关闭弹出框
			var dyNewHtml = DzBuildingAdd.getHsHtml(DzBuildingAdd.dsddzdcs,lchs,DzBuildingAdd.dsddzddys,"ds");
			var newHtml = "<ul id='dslchs_"+DzBuildingAdd.dsddzddys+"-"+DzBuildingAdd.dsddzdcs+"'><li class='qiang'></li>" +
					      "<li class='cengNum'><input type='hidden' name='dszdlchs_"+DzBuildingAdd.dsddzddys+"' value='"+lchs+"'/><a href='javascript:void(0);' id='dslc_"+DzBuildingAdd.dsddzddys+"-"+DzBuildingAdd.dsddzdcs+"' " +
						  "name='dslcName' onClick='DzBuildingAdd.showLcHsCalendar("+DzBuildingAdd.dsddzddys+","+DzBuildingAdd.dsddzdcs+","+lchs+","+DzBuildingAdd.dszdcs+",\"ds\");' " +
				    	  "value='"+DzBuildingAdd.dsddzddys+"-"+DzBuildingAdd.dsddzdcs+"'>"+DzBuildingAdd.dsddzdcs+"层</a></li>"+dyNewHtml+"<li class='qiang1'></li></ul>";
			document.getElementById("dslchs_"+DzBuildingAdd.dsddzddys+"-"+DzBuildingAdd.dsddzdcs).outerHTML = newHtml;
			//计算每层最大户数
			var lcHs = document.getElementsByName("dszdlchs_"+DzBuildingAdd.dsddzddys);
			var maxHs = 0;
			for(var i=0;i<lcHs.length;i++){
				var num = lcHs[i].value;
				if(maxHs<num){
					maxHs = num;
				}
			}
			var dyNewHtml = "<div class='floot_num' id='dsdyh_"+DzBuildingAdd.dsddzddys+"-"+DzBuildingAdd.dszdcs+"'><input type='hidden' name='dsdymcName' value='"+DzBuildingAdd.dsddzddys+"'/>" +
					        "<a href='javascript:void(0);' id='dsdy_"+DzBuildingAdd.dsddzddys+"-"+DzBuildingAdd.dszdcs+"-"+maxHs+"' " +
							"name='dsdyName' onClick='DzBuildingAdd.showDysCalendar("+DzBuildingAdd.dsddzddys+","+DzBuildingAdd.dszdcs+","+maxHs+",\"ds\");' " +
							"value='"+DzBuildingAdd.dsddzddys+"-"+DzBuildingAdd.dszdcs+"-"+maxHs+"'>"+DzBuildingAdd.dsddzddys+"</a></div>";
			document.getElementById("dsdyh_"+DzBuildingAdd.dsddzddys+"-"+DzBuildingAdd.dszdcs).outerHTML = dyNewHtml;
			//修改地上单元的宽度
			var Maxwidth = DzBuildingAdd.dyWidth(maxHs);
			document.getElementById("dsdydt_"+DzBuildingAdd.dsddzddys).style.width = Maxwidth+"px";
			//设置宽度
			var oldwid = DzBuildingAdd.dyWidth(oldmaxHs);
			var newwid = DzBuildingAdd.dyWidth(maxHs);
			DzBuildingAdd.divdsMaxWidth = DzBuildingAdd.divdsMaxWidth - oldwid + newwid;
			DzBuildingAdd.divWidth();
			$("#chjgAddDsDiv").html($("#chjgAddDsDiv").html());
			DzBuildingAdd.hiddenCalendar();
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
 * @title:SendUpdateFjmc
 * @description:修改房间名称
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-02-02 13:53:43
 */
DzBuildingAdd.SendUpdateFjmc = function(){
	if($('#xg_fjmc').validatebox('isValid')){
		var fjmc = document.getElementById("xg_fjmc").value;
		var dsfjvale = document.getElementsByName("dsfjName");
		if(fjmc!=""&&fjmc!=null){
			//验证通过后重新生成单元以及关闭弹出框
			var roomName = DzBuildingAdd.getRoomBm(DzBuildingAdd.dsddzdcs,fjmc,"ds");
			var fjval = DzBuildingAdd.dsddzddys+"-"+roomName;
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
			var newHtml = "<div class='cengButton' id='dsfjh_"+DzBuildingAdd.dsddzddys+"-"+roomName+"'><a href='javascript:void(0);' id='dsfj_"+roomName+"' name='dsfjName' title='"+DzBuildingAdd.dsddzddys+"-"+roomName+"' onClick='DzBuildingAdd.showFjCalendar("+DzBuildingAdd.dsddzddys+","+DzBuildingAdd.dsddzdcs+","+fjmc+",\"ds\");' value='"+DzBuildingAdd.dsddzddys+"-"+roomName+"'>"+roomName+"</a></div>";
			document.getElementById("dsfjh_"+DzBuildingAdd.dsddzddys+"-"+DzBuildingAdd.dsddzdcs+"-"+DzBuildingAdd.dsddzdhs).outerHTML = newHtml;
			DzBuildingAdd.hiddenCalendar();
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
 * @title:SendUpdateDxDymc
 * @description:修改地下单元名称
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-02-02 19:24:36
 */
DzBuildingAdd.SendUpdateDxDymc = function(){
	if($('#xg_dxdymc').validatebox('isValid')){
		var dxdy = document.getElementsByName("dxdymcName");
		var dymc = document.getElementById("xg_dxdymc").value;
		if(dymc!=""&&dymc!=null){
			for(var i=0;i<dxdy.length;i++){
				var dxdymc = dxdy[i].value;
				if(dxdymc==dymc){
					topMessager.show({
						title: MESSAGER_TITLE,
						msg: '修改单元名称失败，名称【'+dymc+'】已存在。',
						timeout:2500
					});
					return;
				}
			}
			//验证通过后重新生成单元以及关闭弹出框
			var dyNewHtml = DzBuildingAdd.updateDxDys(dymc,DzBuildingAdd.dxddzdcs,DzBuildingAdd.dxddzdhs);
			document.getElementById("dxdydt_"+DzBuildingAdd.dxddzddys).outerHTML = dyNewHtml;
			DzBuildingAdd.hiddenCalendar();
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
 * @title:updateDxDys
 * @description:单独修改地下某一单元
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-02-02 19:38:26
 */
DzBuildingAdd.updateDxDys = function(dys,cs,hs){
    var downHtml = DzBuildingAdd.setDownHtml(dys,cs,hs);
	var DxLcHtml = DzBuildingAdd.setDxLcHtml(dys,cs,hs);
	var Maxwidth = DzBuildingAdd.dyWidth(hs);
	var dyHtml = "<dt id='dxdydt_"+dys+"' style='width:"+Maxwidth+"px;'><table cellpadding='0' cellspacing='0' width='100%'>"+downHtml+""+DxLcHtml+"</table></dt>";
	return dyHtml;
};
/**
 * @title:SendUpdateDxCS
 * @description:修改地下层数
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-02-02 20:11:53
 */
DzBuildingAdd.SendUpdateDxCS = function(){
	if($('#xg_dxlcs').validatebox('isValid')){
		var dxlcs = document.getElementById("xg_dxlcs").value;
		if(dxlcs!=""&&dxlcs!=null){
			//验证通过后重新生成单元以及关闭弹出框
			var dyNewHtml = DzBuildingAdd.updateDxDys(DzBuildingAdd.dxddzddys,dxlcs,DzBuildingAdd.dxddzdhs);
			document.getElementById("dxdydt_"+DzBuildingAdd.dxddzddys).outerHTML = dyNewHtml;
			DzBuildingAdd.hiddenCalendar();
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
 * @title:SendUpdateDxHs
 * @description:修改地下户数
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-02-03 09:37:45
 */
DzBuildingAdd.SendUpdateDxHs = function(){
	if($('#xg_dxhs').validatebox('isValid')){
		var dxhs = document.getElementById("xg_dxhs").value;
		if(dxhs!=""&&dxhs!=null){
			var oldwid = DzBuildingAdd.dyWidth(DzBuildingAdd.dxddzdhs);
			var newwid = DzBuildingAdd.dyWidth(dxhs);
			DzBuildingAdd.divdxMaxWidth = DzBuildingAdd.divdxMaxWidth - oldwid + newwid;
			DzBuildingAdd.divWidth();
			//验证通过后重新生成单元以及关闭弹出框
			var dyNewHtml = DzBuildingAdd.updateDxDys(DzBuildingAdd.dxddzddys,DzBuildingAdd.dxddzdcs,dxhs);
			document.getElementById("dxdydt_"+DzBuildingAdd.dxddzddys).outerHTML = dyNewHtml;
			$("#chjgAddDxDiv").html($("#chjgAddDxDiv").html());
			DzBuildingAdd.hiddenCalendar();
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
 * @title:SendUpdateDxClHs
 * @description:修改楼层户数
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-02-03 09:49:32
 */
DzBuildingAdd.SendUpdateDxClHs = function(){
	if($('#xg_dxlchs').validatebox('isValid')){
		var lchs = document.getElementById("xg_dxlchs").value;
		if(lchs!=""&&lchs!=null){
			//计算每层最大户数
			var oldlcHs = document.getElementsByName("dxzdlchs_"+DzBuildingAdd.dxddzddys);
			var oldmaxHs = 0;
			for(var i=0;i<oldlcHs.length;i++){
				var oldnum = oldlcHs[i].value;
				if(oldmaxHs<oldnum){
					oldmaxHs = oldnum;
				}
			}
			//验证通过后重新生成单元以及关闭弹出框
			var dyNewHtml = DzBuildingAdd.getHsHtml(DzBuildingAdd.dxddzdcs,lchs,DzBuildingAdd.dxddzddys,"dx");
			var newHtml = "<ul id='dxlchs_"+DzBuildingAdd.dxddzddys+"-"+DzBuildingAdd.dxddzdcs+"'><li class='qiang'></li>" +
					      "<li class='cengNum'><input type='hidden' name='dxzdlchs_"+DzBuildingAdd.dxddzddys+"' value='"+lchs+"'/><a href='javascript:void(0);' id='dxlc_"+DzBuildingAdd.dxddzddys+"-"+DzBuildingAdd.dxddzdcs+"' " +
						  "name='dxlcName' onClick='DzBuildingAdd.showLcHsCalendar("+DzBuildingAdd.dxddzddys+","+DzBuildingAdd.dxddzdcs+","+lchs+","+DzBuildingAdd.dxzdcs+",\"dx\");' " +
				    	  "value='"+DzBuildingAdd.dxddzddys+"-"+DzBuildingAdd.dxddzdcs+"'>B"+DzBuildingAdd.dxddzdcs+"层</a></li>"+dyNewHtml+"<li class='qiang1'></li></ul>";
			document.getElementById("dxlchs_"+DzBuildingAdd.dxddzddys+"-"+DzBuildingAdd.dxddzdcs).outerHTML = newHtml;
			//计算每层最大户数
			var lcHs = document.getElementsByName("dxzdlchs_"+DzBuildingAdd.dxddzddys);
			var maxHs = 0;
			for(var i=0;i<lcHs.length;i++){
				var num = lcHs[i].value;
				if(maxHs<num){
					maxHs = num;
				}
			}
			var dyNewHtml = "<div class='floot_num' id='dxdyh_"+DzBuildingAdd.dxddzddys+"-"+DzBuildingAdd.dxzdcs+"'><input type='hidden' name='dxdymcName' value='"+DzBuildingAdd.dxddzddys+"'/>" +
					        "<a href='javascript:void(0);' id='dxdy_"+DzBuildingAdd.dxddzddys+"-B"+DzBuildingAdd.dxzdcs+"-"+maxHs+"' " +
							"name='dxdyName' onClick='DzBuildingAdd.showDysCalendar("+DzBuildingAdd.dxddzddys+","+DzBuildingAdd.dxzdcs+","+maxHs+",\"dx\");' " +
							"value='"+DzBuildingAdd.dxddzddys+"-"+DzBuildingAdd.dxzdcs+"-"+maxHs+"'>地下"+DzBuildingAdd.dxddzddys+"</a></div>";
			document.getElementById("dxdyh_"+DzBuildingAdd.dxddzddys+"-"+DzBuildingAdd.dxzdcs).outerHTML = dyNewHtml;
			//修改地上单元的宽度
			var Maxwidth = DzBuildingAdd.dyWidth(maxHs);
			document.getElementById("dxdydt_"+DzBuildingAdd.dxddzddys).style.width = Maxwidth+"px";
			//设置宽度
			var oldwid = DzBuildingAdd.dyWidth(oldmaxHs);
			var newwid = DzBuildingAdd.dyWidth(maxHs);
			DzBuildingAdd.divdxMaxWidth = DzBuildingAdd.divdxMaxWidth - oldwid + newwid;
			DzBuildingAdd.divWidth();
			$("#chjgAddDxDiv").html($("#chjgAddDxDiv").html());
			DzBuildingAdd.hiddenCalendar();
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
 * @title:SendUpdateDxFjmc
 * @description:修改房间名称
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-02-03 10:39:53
 */
DzBuildingAdd.SendUpdateDxFjmc = function(){
	if($('#xg_dxfjmc').validatebox('isValid')){
		var fjmc = document.getElementById("xg_dxfjmc").value;
		var dxfjvale = document.getElementsByName("dxfjName");
		if(fjmc!=""&&fjmc!=null){
			//验证通过后重新生成单元以及关闭弹出框
			var roomName = DzBuildingAdd.getRoomBm(DzBuildingAdd.dxddzdcs,fjmc,"dx");
			var fjval = DzBuildingAdd.dxddzddys+"-"+DzBuildingAdd.dxddzdcs+"-"+fjmc;
			for(var i=0;i<dxfjvale.length;i++){
				var dxfjval = dxfjvale[i].value;
				if(dxfjval==fjval){
					topMessager.show({
						title: MESSAGER_TITLE,
						msg: '修改房间名称失败，名称【'+DzBuildingAdd.dxddzddys+'-B'+DzBuildingAdd.dxddzdcs+'-'+fjmc+'】已存<br><br>在。',
						timeout:2500
					});
					return;
				}
			}
			var newHtml = "<div class='cengButton' id='dxfjh_"+DzBuildingAdd.dxddzddys+"-"+roomName+"'><a href='javascript:void(0);' id='dxfj_"+roomName+"' name='dxfjName' title='"+DzBuildingAdd.dxddzddys+"-"+roomName+"' onClick='DzBuildingAdd.showFjCalendar("+DzBuildingAdd.dxddzddys+","+DzBuildingAdd.dxddzdcs+","+fjmc+",\"dx\");' value='"+DzBuildingAdd.dxddzddys+"-"+DzBuildingAdd.dxddzdcs+"-"+fjmc+"'>"+roomName+"</a></div>";
			document.getElementById("dxfjh_"+DzBuildingAdd.dxddzddys+"-B"+DzBuildingAdd.dxddzdcs+"-"+DzBuildingAdd.dxddzdhs).outerHTML = newHtml;
			DzBuildingAdd.hiddenCalendar();
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